package day01;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 一、缓冲区(Buffer)：在Java NIO中负责数据的存取，缓冲区底层就是数组，用于存储不同的数据类型的数据
 * 根据数据类型的不同（boolean除外，另外7中都有），提供了相应类型的缓冲区。
 * ByteBuffer:
 * 
 * 
 * CharBuffer:
 * ShortBuffer:
 * IntBuffer:
 * LongBuffer:
 * FloatBuffer:
 * DoubleBuffer:
 * 上述缓冲区的管理方式几乎一致，通过allocate（）获取缓冲区
 * @author Administrator
 *二、缓冲区存取数据的两个核心方法：
 *	put()：存入数据到缓冲区
 *	get() :获取缓冲区的数据
 *
 *三、缓冲区中的四个核心属性：
 *	capacity：容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变。
 *	limit:		 界限，表示缓冲区中可以操作数据的大小。（limit 后面的数据不能读写）
 *	position： 位置，表示缓冲区中正在操作数据的位置
 * mark:标记，表示记录当前position的位置，可以通过reset()回复到mark的位置
 *
 * 数据大小：0<=mark<=position <= limit <= capacity
 *
 *四：直接缓冲区与非直接缓冲区
 *	非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中。传统IO都是这种。
 *	直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在操作系统的物理内存中，可以提高效率。高效，
 *						优点：高效
 *						缺点：不安全，开销大。
 *
 */
public class Demo1 {
	
	@Test
		public void testBuffer(){
			// 1.分配一个指定大小的缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);
			System.out.println("-----position-----limit-----capacity--");			
			System.out.println("----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			// 2.写数据模式利用put方法存入数据到缓冲区
			buf.put("abcde".getBytes());
			System.out.println("put之后-----position-----limit-----capacity--");			
			System.out.println("put之后-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 3.切换为读取数据的模式
			buf.flip();
			System.out.println("flip之后-----position-----limit-----capacity--");			
			System.out.println("flip之后-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 4.利用get()读取缓冲区中的数据
			byte[] dst = new byte[buf.limit()];
			buf.get(dst);
			System.out.println(new String(dst));
			System.out.println("get之后-----position-----limit-----capacity--");			
			System.out.println("get之后-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 5.rewind() 可重复读数据
			buf.rewind();
			System.out.println("rewind之后-----position-----limit-----capacity--");			
			System.out.println("rewind之后-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 6.clear()清空缓冲区,但是缓冲区中的数据依然还存在，但是出于“被遗忘状态”
			buf.clear();
			System.out.println("clean之后-----position-----limit-----capacity--");			
			System.out.println("clean之后-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			System.out.println("clear之后---:"+(char)buf.get());
			
		}
	
	
	@Test
	public void test2(){
		String str ="abcde";
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.put(str.getBytes());
		buf.flip();
		byte[] dst = new byte[buf.limit()];
		buf.get(dst,0,2);
		System.out.println(new String(dst,0,2));//此时position在第二个位置上
		System.out.println("-----position-----limit-----capacity--");			
		System.out.println("-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
		// mark()标记
		buf.mark();
		buf.get(dst,2,2);
		System.out.println(new String(dst,2,2));
		System.out.println("-----position-----limit-----capacity--");			
		System.out.println("-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
		// reset():恢复到mark的位置
		buf.reset();
		System.out.println("reset-----position-----limit-----capacity--");			
		System.out.println("reset-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
		
		// 判断缓冲区中时候还有数据 
		if(buf.hasRemaining()){
			// 获取缓冲区中可以操作的数据
			System.out.println("剩余："+buf.remaining()+"个");
		}		
	}
	/**
	 * 创建直接缓冲区
	 */
	@Test
	public void test3(){
		ByteBuffer buf = ByteBuffer.allocateDirect(1024);
		// 判断是否是直接缓冲区：
		System.out.println("是直接缓冲区吗？" + buf.isDirect());
	}
	
	
	
}
