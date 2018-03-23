package day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.junit.Test;

/**
 * 一、通道(Channel)：用于源节点与目标节点的链接。在java NIO中负责缓冲区数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 * 
 * 二、通道的主要实现类
 * 	java.nio.channel.Channel借口：
 * 			|--FileChannel
 * 			|--SocketChannel
 * 			|--ServerSocketChannel
 * 			|--DatagramChannel
 * 
 * 三、获取通道的三种方式
 *  1.Java针对支持通道的类提供了getChannel()方法
 *  	本地IO:
 *  	FileInputStream/FileOutputStream
 *  	RandomAccessFile
 *  	网络：
 *  	Socket
 *  	ServerSocket
 *  	DatagramSocket
 *  
 *  2.在JDK1.7中的NIO2针对各个通道提供了静态方法open();
 *  3.在JDK1.7中的NIO2的File 工具类的newByteChannel()
 *  
 *  
 *  四、通道之间的数据传输
 *  	transferForm():
 *  	transferTo():
 * 
 * 五、分散(Scatter)与聚集(Gather)
 *  分散读取(Scattering Reads):将通道中的数据分散到多个缓冲区中
 *  聚集写入(Gathering Writes):将多个缓冲区中的数据聚集到通道
 * 
 * 六、字符集：Charset
 * 	 编码：字符串--->字节码
 *  解码	:  字节数组-->字符串
 * 
 * 
 * @author Administrator
 *
 */
public class TestChannel {
	
	// 1.利用通道完成文件的复制(非直接缓冲区)
	@Test
	public void test1(){
		long start = System.currentTimeMillis();
		try {
			
			FileInputStream fis = new FileInputStream("E:\\Tomcat\\fileObject\\nio.zip");
			FileOutputStream fos = new FileOutputStream("E:\\Tomcat\\fileObject\\nio2.zip") ;
			
			// 1.获取通道
			FileChannel inchannel = fis.getChannel();
			FileChannel outchannel = fos.getChannel();
			
			// 2.分配指定大小的缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			// 3.将通道中的数据存入缓冲区中
			while(inchannel.read(buf)!=-1){
				buf.flip();//切换成读取数据的模式
				
				// 4.将缓冲区的数据写入通道
				outchannel.write(buf);
				buf.clear();			
			}
			outchannel.close();
			inchannel.close();
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("非直接缓冲区耗时："+(end-start));
		
		
	}
	
	
	
	// 2.使用直接缓冲区完成文件的复制(内存映射文件)
	@Test
	public void test2() throws IOException{
		long start = System.currentTimeMillis();
		
		// 获得输入的通道		
		FileChannel inChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio.zip"), StandardOpenOption.READ );// 后面的参数，对前面文件的操作
		FileChannel outChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio3.zip"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);// 后面的参数，对前面文件的操作
		
		// 内存映射文件，和test1的原理一样，只不过获取的方式不一样。注意：只用byteBuffer支持
		MappedByteBuffer inMapBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMapBuffer = outChannel.map(MapMode.READ_WRITE, 0,inChannel.size());
		
		// 这种不需要通道，这个是直接对缓冲区的读写操作
		byte[] dst = new byte[10240];
		inMapBuffer.get(dst);
		outMapBuffer.put(dst);
		
		outChannel.close();
		inChannel.close();
		long end = System.currentTimeMillis();
		System.out.println("直接缓冲区耗时："+(end-start));
		
	}
	
	public void test8(){
		
		try {
			
			FileChannel inChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
			FileChannel outChannel = FileChannel.open(Paths.get(""), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
			MappedByteBuffer inMap = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
			MappedByteBuffer outMap = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
			byte[] b = new byte[1024];
			inMap.get(b);
			outMap.put(b);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		
	}
	
	
	// 通道之间的数据传输(直接缓冲区的方式)
	@Test
	public void test3() throws IOException{
		long start = System.currentTimeMillis();
		
		FileChannel inChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio.zip"), StandardOpenOption.READ );// 后面的参数，对前面文件的操作
		FileChannel outChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio4.zip"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);// 后面的参数，对前面文件的操作
		
		 inChannel.transferTo(0, inChannel.size(), outChannel );
		// outChannel.transferFrom(inChannel, 0, inChannel.size());
		inChannel.close();
		outChannel.close();
		
		long end = System.currentTimeMillis();
		System.out.println("直接缓冲区耗时："+(end-start));
	}
	
	/*
	 * 分散和聚集
	 * */
	@Test
	public void test4() throws IOException{
		
		RandomAccessFile raf1 = new RandomAccessFile("E:\\Tomcat\\fileObject\\a.txt","rw");
		
		// 1.获取通道
		FileChannel inChannel = raf1.getChannel();
		
		// 2.分配指定大小的缓冲区
		ByteBuffer buf1 = ByteBuffer.allocate(100);
		ByteBuffer buf2 = ByteBuffer.allocate(1024);
		
		// 3.分散读取
		ByteBuffer[] bufs = {buf1, buf2};
		inChannel.read(bufs);
		
		for(ByteBuffer byteBuffer : bufs){
			byteBuffer.flip();
		}
		System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
		System.out.println("--------------");
		System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));
		
		// 4.聚集写入
		RandomAccessFile raf2 = new RandomAccessFile("E:\\Tomcat\\fileObject\\b.txt", "rw");
		FileChannel outChannel = raf2.getChannel();
		outChannel.write(bufs);
		
	}
	
	/**
	 * 字符集
	 * @throws CharacterCodingException 
	 * */
	@Test
	public void test5() throws CharacterCodingException{
		// 支持的字符集
		/*SortedMap<String, Charset> map = Charset.availableCharsets();
		for (Entry<String, Charset> entry : map.entrySet()) {
			System.out.println("key:"+entry.getKey()+"---value:"+entry.getValue());
		}*/
		
		Charset cs1 = Charset.forName("GBK");
		// 1.获取编码器与解码器
		//   获取编码器
		CharsetEncoder encoder = cs1.newEncoder();
		//  获取解码器
		CharsetDecoder decoder = cs1.newDecoder();
		
		CharBuffer cBuf = CharBuffer.allocate(1024);
		cBuf.put("武汉，洪山区，华夏学院");
		cBuf.flip();
		
		// 编码
		ByteBuffer bBuf = encoder.encode(cBuf);
		
		for(int i = 0; i<12; i++){
			System.out.println("---"+bBuf.get());
		}
		
		// 解码
		bBuf.flip();
		CharBuffer cBuf2 = decoder.decode(bBuf);
		System.out.println("GBK解码结果----"+cBuf2.toString());
		
		Charset cs2 = Charset.forName("UTF-8");
		bBuf.flip();
		CharBuffer decode = cs2.decode(bBuf);
		System.out.println("UTF-8解码结果----"+decode.toString());
		
		
	}
	
	
	
	
	

}
