package day02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

/**
 * 完成网络通信
 * @author Administrator
 * 一、网络NIO的三个必须要素
 *	1.通道（channel）：负责链接
 *		java.nio.channels.Channel接口
 *				|----SelectableChannel
 *				|----ServerSocketChannel
 *				|----DatagramChannel
 *注意：没有FileChannel，非阻塞相较于网络而言的，FileChannel不能转为网络Channel
 *
 *				|----Pipe.SinkChannel
 *				|----Pipe.SourceChannel　
 *
 *
 *
 *  2.缓冲区(Buffer)：负责数据的存取
 *
 *
 *  3.选择器(Selector): 是SelectableChannel的多路复用器，用于监控SelectableChannel 的IO状况
 *
 */
public class TestNIO {

	/*******************************阻塞式传输Start*****************************************/
		/**********发送完成无反馈start***********/
	// 客户端
	@Test
	public void client1() throws IOException{
		// 1.获取客户端
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		
		FileChannel inChannel = FileChannel.open(Paths.get("E:/Tomcat/fileObject/a.txt"), StandardOpenOption.READ);
		
		// 2.分配指定大小的缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		// 3.读取本地文件，发送到服务端
		while(inChannel.read(buf) != -1){
			buf.flip();
			sChannel.write(buf);
			buf.clear();			
		}
		
		// 4.关闭通道
		inChannel.close();
		sChannel.close();		
		
	}
	
	// 服务端
	@Test
	public void server1() throws IOException{
		
			// 1.获取通道
			ServerSocketChannel ssChannel = ServerSocketChannel.open();
			
			FileChannel outChinnel = FileChannel.open(Paths.get("E:/Tomcat/fileObject/b.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			
			// 2.绑定链接
			ssChannel.bind(new InetSocketAddress(9898));
			
			// 3.获取客户端链接的通道
			SocketChannel accept = ssChannel.accept();
			
			// 4. 分配指定的缓冲区大小
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			// 5.接受客户端的数据并保存到本地
			while(accept.read(buf) != -1){
				buf.flip();
				outChinnel.write(buf);
				buf.clear();				
			}
			
			// 6.关闭通道
			accept.close();
			outChinnel.close();
			ssChannel.close();
			
			
	}
	/**********发送完成无反馈end***********/
	
	
	/**********发送完成有反馈Start
	 * @throws IOException ***********/
	// 客户端
	@Test
	public void client2() throws IOException{
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));		
		FileChannel inFile = FileChannel.open(Paths.get("E:/Tomcat/fileObject/a.txt"), StandardOpenOption.READ);
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while(inFile.read(buf) != -1){
			buf.flip();
			sChannel.write(buf);
			buf.clear();			
		}
		// 终止线程
		sChannel.shutdownOutput();
		
		// 接受服务器的反馈
		int len =0;
		while((len = sChannel.read(buf))!=-1){
			buf.flip();
			System.out.println("----:"+new String (buf.array(), 0, len));
			buf.clear();
		}
		inFile.close();
		sChannel.close();		
	}
	
	@Test
	public void server2() throws IOException{
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		ServerSocketChannel socketChannel = ssChannel.bind(new InetSocketAddress(9898));
		SocketChannel inCahnnel = socketChannel.accept();
		
		FileChannel outFile = FileChannel.open(Paths.get("E:/Tomcat/fileObject/c.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
		
		ByteBuffer buf = ByteBuffer.allocate(1024);		
		while(inCahnnel.read(buf) != -1){
			buf.flip();
			outFile.write(buf);
			buf.clear();
			
		}
		
		// 发送反馈客户端
		buf.put("服务端接受成功".getBytes());
		buf.flip();
		inCahnnel.write(buf);
		
	}
	
	
	
	/**********发送完成有反馈End***********/
	
	
	/*******************************阻塞式传输END*****************************************/
	
	/*****************************非阻塞形式Start******************************/
	// 客户端
	@Test
	public void client3() throws IOException{
		// 1.获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		
		// 2.切换非阻塞模式
		sChannel.configureBlocking(false);
		
		// 3.分配指定大小的缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		// 4.发送数据给服务器
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()){
			String 	str = scan.nextLine();
			System.out.println("---in:"+str+buf.position());
			buf.put((new Date().toString()+"\n"+str).getBytes());
			buf.flip();
			sChannel.write(buf);
			buf.clear();
			
		}
		
		/*buf.put(new Date().toString().getBytes());
		buf.flip();
		sChannel.write(buf);
		buf.clear();*/
		
		// 5.关闭流
		sChannel.close();
		
	}
	// 服务端
	@Test
	public void server3() throws IOException{
		// 1.获得通信
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		
		// *2.切换非阻塞模式
		ssChannel.configureBlocking(false);
		
		// 3.绑定链接
		ssChannel.bind(new InetSocketAddress(9898));
		
		// 4.获取选择器
		Selector selector = Selector.open();
		
		// 5.将通道注册到选择器上,并且指定“监听接受事假”
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		
		// 6.轮询式的获取选择器上已经“准备就绪”的事件		
		while(selector.select() > 0){
			// 7.获取选择器中所有注册的“选择键(已经就绪的监听事件)”,注意SelectionKey用完后要取消，不然会一直监听着
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			// 8.迭代获取"准备就绪"的事件
			while(it.hasNext()){
				SelectionKey sk = it.next();
				
				// 9.判断具体是什么事件准备就绪,SelectionKey有四种状态
				if(sk.isAcceptable()){
					// 10.若"接收就绪"，获取客户端链接
					SocketChannel sChannel = ssChannel.accept();
					// 11.切换非阻塞模式
					sChannel.configureBlocking(false);					
					// 12.将通道注册到选择器上
					sChannel.register(selector, SelectionKey.OP_READ);
				
				}else if(sk.isReadable()){
					// 13.如果是"读就绪"状态
					SocketChannel sChannel = (SocketChannel)sk.channel();
					// 14.读取数据
					ByteBuffer buf = ByteBuffer.allocate(1024);
					
					int len = 0;
					while((len = sChannel.read(buf)) >0){
						buf.flip();
						System.out.println(new String(buf.array(), 0, len));
						buf.clear();
					}
					
				}
				// 15.取消选择键SelectionKey
				it.remove();
			}
			
			
		}
		
		
	}	
	/*****************************非阻塞形式END***********************************/
	
	
	@Test
	public void testPipe() throws IOException {
		// 1.获取管道
		Pipe pipe = Pipe.open();
		// 2.将缓冲区中的数据写入管道，可以单独开一个线程写数据
		ByteBuffer buf = ByteBuffer.allocate(1024);		
		Pipe.SinkChannel sinkChannel = pipe.sink();
		buf.put("通过单向管道发送数据测试".getBytes());
		buf.flip();
		sinkChannel.write(buf);
		
		// 3.读取缓冲区的数据,可以单独做一个线程读取
		SourceChannel sourceChannel = pipe.source();
		buf.flip();
		int len = sourceChannel.read(buf);
		System.out.println(new String(buf.array(),0 , len));
		
		sourceChannel.close();
		sinkChannel.close();
	}
	
	
	
	
	
	
	
	
	
}
