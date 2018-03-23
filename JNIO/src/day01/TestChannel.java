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
 * һ��ͨ��(Channel)������Դ�ڵ���Ŀ��ڵ�����ӡ���java NIO�и��𻺳������ݵĴ��䡣Channel �����洢���ݣ������Ҫ��ϻ��������д��䡣
 * 
 * ����ͨ������Ҫʵ����
 * 	java.nio.channel.Channel��ڣ�
 * 			|--FileChannel
 * 			|--SocketChannel
 * 			|--ServerSocketChannel
 * 			|--DatagramChannel
 * 
 * ������ȡͨ�������ַ�ʽ
 *  1.Java���֧��ͨ�������ṩ��getChannel()����
 *  	����IO:
 *  	FileInputStream/FileOutputStream
 *  	RandomAccessFile
 *  	���磺
 *  	Socket
 *  	ServerSocket
 *  	DatagramSocket
 *  
 *  2.��JDK1.7�е�NIO2��Ը���ͨ���ṩ�˾�̬����open();
 *  3.��JDK1.7�е�NIO2��File �������newByteChannel()
 *  
 *  
 *  �ġ�ͨ��֮������ݴ���
 *  	transferForm():
 *  	transferTo():
 * 
 * �塢��ɢ(Scatter)��ۼ�(Gather)
 *  ��ɢ��ȡ(Scattering Reads):��ͨ���е����ݷ�ɢ�������������
 *  �ۼ�д��(Gathering Writes):������������е����ݾۼ���ͨ��
 * 
 * �����ַ�����Charset
 * 	 ���룺�ַ���--->�ֽ���
 *  ����	:  �ֽ�����-->�ַ���
 * 
 * 
 * @author Administrator
 *
 */
public class TestChannel {
	
	// 1.����ͨ������ļ��ĸ���(��ֱ�ӻ�����)
	@Test
	public void test1(){
		long start = System.currentTimeMillis();
		try {
			
			FileInputStream fis = new FileInputStream("E:\\Tomcat\\fileObject\\nio.zip");
			FileOutputStream fos = new FileOutputStream("E:\\Tomcat\\fileObject\\nio2.zip") ;
			
			// 1.��ȡͨ��
			FileChannel inchannel = fis.getChannel();
			FileChannel outchannel = fos.getChannel();
			
			// 2.����ָ����С�Ļ�����
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			// 3.��ͨ���е����ݴ��뻺������
			while(inchannel.read(buf)!=-1){
				buf.flip();//�л��ɶ�ȡ���ݵ�ģʽ
				
				// 4.��������������д��ͨ��
				outchannel.write(buf);
				buf.clear();			
			}
			outchannel.close();
			inchannel.close();
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("��ֱ�ӻ�������ʱ��"+(end-start));
		
		
	}
	
	
	
	// 2.ʹ��ֱ�ӻ���������ļ��ĸ���(�ڴ�ӳ���ļ�)
	@Test
	public void test2() throws IOException{
		long start = System.currentTimeMillis();
		
		// ��������ͨ��		
		FileChannel inChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio.zip"), StandardOpenOption.READ );// ����Ĳ�������ǰ���ļ��Ĳ���
		FileChannel outChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio3.zip"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);// ����Ĳ�������ǰ���ļ��Ĳ���
		
		// �ڴ�ӳ���ļ�����test1��ԭ��һ����ֻ������ȡ�ķ�ʽ��һ����ע�⣺ֻ��byteBuffer֧��
		MappedByteBuffer inMapBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMapBuffer = outChannel.map(MapMode.READ_WRITE, 0,inChannel.size());
		
		// ���ֲ���Ҫͨ���������ֱ�ӶԻ������Ķ�д����
		byte[] dst = new byte[10240];
		inMapBuffer.get(dst);
		outMapBuffer.put(dst);
		
		outChannel.close();
		inChannel.close();
		long end = System.currentTimeMillis();
		System.out.println("ֱ�ӻ�������ʱ��"+(end-start));
		
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		
	}
	
	
	// ͨ��֮������ݴ���(ֱ�ӻ������ķ�ʽ)
	@Test
	public void test3() throws IOException{
		long start = System.currentTimeMillis();
		
		FileChannel inChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio.zip"), StandardOpenOption.READ );// ����Ĳ�������ǰ���ļ��Ĳ���
		FileChannel outChannel = FileChannel.open(Paths.get("E:\\Tomcat\\fileObject\\nio4.zip"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);// ����Ĳ�������ǰ���ļ��Ĳ���
		
		 inChannel.transferTo(0, inChannel.size(), outChannel );
		// outChannel.transferFrom(inChannel, 0, inChannel.size());
		inChannel.close();
		outChannel.close();
		
		long end = System.currentTimeMillis();
		System.out.println("ֱ�ӻ�������ʱ��"+(end-start));
	}
	
	/*
	 * ��ɢ�;ۼ�
	 * */
	@Test
	public void test4() throws IOException{
		
		RandomAccessFile raf1 = new RandomAccessFile("E:\\Tomcat\\fileObject\\a.txt","rw");
		
		// 1.��ȡͨ��
		FileChannel inChannel = raf1.getChannel();
		
		// 2.����ָ����С�Ļ�����
		ByteBuffer buf1 = ByteBuffer.allocate(100);
		ByteBuffer buf2 = ByteBuffer.allocate(1024);
		
		// 3.��ɢ��ȡ
		ByteBuffer[] bufs = {buf1, buf2};
		inChannel.read(bufs);
		
		for(ByteBuffer byteBuffer : bufs){
			byteBuffer.flip();
		}
		System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
		System.out.println("--------------");
		System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));
		
		// 4.�ۼ�д��
		RandomAccessFile raf2 = new RandomAccessFile("E:\\Tomcat\\fileObject\\b.txt", "rw");
		FileChannel outChannel = raf2.getChannel();
		outChannel.write(bufs);
		
	}
	
	/**
	 * �ַ���
	 * @throws CharacterCodingException 
	 * */
	@Test
	public void test5() throws CharacterCodingException{
		// ֧�ֵ��ַ���
		/*SortedMap<String, Charset> map = Charset.availableCharsets();
		for (Entry<String, Charset> entry : map.entrySet()) {
			System.out.println("key:"+entry.getKey()+"---value:"+entry.getValue());
		}*/
		
		Charset cs1 = Charset.forName("GBK");
		// 1.��ȡ�������������
		//   ��ȡ������
		CharsetEncoder encoder = cs1.newEncoder();
		//  ��ȡ������
		CharsetDecoder decoder = cs1.newDecoder();
		
		CharBuffer cBuf = CharBuffer.allocate(1024);
		cBuf.put("�人����ɽ��������ѧԺ");
		cBuf.flip();
		
		// ����
		ByteBuffer bBuf = encoder.encode(cBuf);
		
		for(int i = 0; i<12; i++){
			System.out.println("---"+bBuf.get());
		}
		
		// ����
		bBuf.flip();
		CharBuffer cBuf2 = decoder.decode(bBuf);
		System.out.println("GBK������----"+cBuf2.toString());
		
		Charset cs2 = Charset.forName("UTF-8");
		bBuf.flip();
		CharBuffer decode = cs2.decode(bBuf);
		System.out.println("UTF-8������----"+decode.toString());
		
		
	}
	
	
	
	
	

}
