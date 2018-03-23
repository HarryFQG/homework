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
 * �������ͨ��
 * @author Administrator
 * һ������NIO����������Ҫ��
 *	1.ͨ����channel������������
 *		java.nio.channels.Channel�ӿ�
 *				|----SelectableChannel
 *				|----ServerSocketChannel
 *				|----DatagramChannel
 *ע�⣺û��FileChannel�������������������Եģ�FileChannel����תΪ����Channel
 *
 *				|----Pipe.SinkChannel
 *				|----Pipe.SourceChannel��
 *
 *
 *
 *  2.������(Buffer)���������ݵĴ�ȡ
 *
 *
 *  3.ѡ����(Selector): ��SelectableChannel�Ķ�·�����������ڼ��SelectableChannel ��IO״��
 *
 */
public class TestNIO {

	/*******************************����ʽ����Start*****************************************/
		/**********��������޷���start***********/
	// �ͻ���
	@Test
	public void client1() throws IOException{
		// 1.��ȡ�ͻ���
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		
		FileChannel inChannel = FileChannel.open(Paths.get("E:/Tomcat/fileObject/a.txt"), StandardOpenOption.READ);
		
		// 2.����ָ����С�Ļ�����
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		// 3.��ȡ�����ļ������͵������
		while(inChannel.read(buf) != -1){
			buf.flip();
			sChannel.write(buf);
			buf.clear();			
		}
		
		// 4.�ر�ͨ��
		inChannel.close();
		sChannel.close();		
		
	}
	
	// �����
	@Test
	public void server1() throws IOException{
		
			// 1.��ȡͨ��
			ServerSocketChannel ssChannel = ServerSocketChannel.open();
			
			FileChannel outChinnel = FileChannel.open(Paths.get("E:/Tomcat/fileObject/b.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			
			// 2.������
			ssChannel.bind(new InetSocketAddress(9898));
			
			// 3.��ȡ�ͻ������ӵ�ͨ��
			SocketChannel accept = ssChannel.accept();
			
			// 4. ����ָ���Ļ�������С
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			// 5.���ܿͻ��˵����ݲ����浽����
			while(accept.read(buf) != -1){
				buf.flip();
				outChinnel.write(buf);
				buf.clear();				
			}
			
			// 6.�ر�ͨ��
			accept.close();
			outChinnel.close();
			ssChannel.close();
			
			
	}
	/**********��������޷���end***********/
	
	
	/**********��������з���Start
	 * @throws IOException ***********/
	// �ͻ���
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
		// ��ֹ�߳�
		sChannel.shutdownOutput();
		
		// ���ܷ������ķ���
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
		
		// ���ͷ����ͻ���
		buf.put("����˽��ܳɹ�".getBytes());
		buf.flip();
		inCahnnel.write(buf);
		
	}
	
	
	
	/**********��������з���End***********/
	
	
	/*******************************����ʽ����END*****************************************/
	
	/*****************************��������ʽStart******************************/
	// �ͻ���
	@Test
	public void client3() throws IOException{
		// 1.��ȡͨ��
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
		
		// 2.�л�������ģʽ
		sChannel.configureBlocking(false);
		
		// 3.����ָ����С�Ļ�����
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		// 4.�������ݸ�������
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
		
		// 5.�ر���
		sChannel.close();
		
	}
	// �����
	@Test
	public void server3() throws IOException{
		// 1.���ͨ��
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		
		// *2.�л�������ģʽ
		ssChannel.configureBlocking(false);
		
		// 3.������
		ssChannel.bind(new InetSocketAddress(9898));
		
		// 4.��ȡѡ����
		Selector selector = Selector.open();
		
		// 5.��ͨ��ע�ᵽѡ������,����ָ�������������¼١�
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		
		// 6.��ѯʽ�Ļ�ȡѡ�������Ѿ���׼�����������¼�		
		while(selector.select() > 0){
			// 7.��ȡѡ����������ע��ġ�ѡ���(�Ѿ������ļ����¼�)��,ע��SelectionKey�����Ҫȡ������Ȼ��һֱ������
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			// 8.������ȡ"׼������"���¼�
			while(it.hasNext()){
				SelectionKey sk = it.next();
				
				// 9.�жϾ�����ʲô�¼�׼������,SelectionKey������״̬
				if(sk.isAcceptable()){
					// 10.��"���վ���"����ȡ�ͻ�������
					SocketChannel sChannel = ssChannel.accept();
					// 11.�л�������ģʽ
					sChannel.configureBlocking(false);					
					// 12.��ͨ��ע�ᵽѡ������
					sChannel.register(selector, SelectionKey.OP_READ);
				
				}else if(sk.isReadable()){
					// 13.�����"������"״̬
					SocketChannel sChannel = (SocketChannel)sk.channel();
					// 14.��ȡ����
					ByteBuffer buf = ByteBuffer.allocate(1024);
					
					int len = 0;
					while((len = sChannel.read(buf)) >0){
						buf.flip();
						System.out.println(new String(buf.array(), 0, len));
						buf.clear();
					}
					
				}
				// 15.ȡ��ѡ���SelectionKey
				it.remove();
			}
			
			
		}
		
		
	}	
	/*****************************��������ʽEND***********************************/
	
	
	@Test
	public void testPipe() throws IOException {
		// 1.��ȡ�ܵ�
		Pipe pipe = Pipe.open();
		// 2.���������е�����д��ܵ������Ե�����һ���߳�д����
		ByteBuffer buf = ByteBuffer.allocate(1024);		
		Pipe.SinkChannel sinkChannel = pipe.sink();
		buf.put("ͨ������ܵ��������ݲ���".getBytes());
		buf.flip();
		sinkChannel.write(buf);
		
		// 3.��ȡ������������,���Ե�����һ���̶߳�ȡ
		SourceChannel sourceChannel = pipe.source();
		buf.flip();
		int len = sourceChannel.read(buf);
		System.out.println(new String(buf.array(),0 , len));
		
		sourceChannel.close();
		sinkChannel.close();
	}
	
	
	
	
	
	
	
	
	
}
