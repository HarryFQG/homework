package day01;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * һ��������(Buffer)����Java NIO�и������ݵĴ�ȡ���������ײ�������飬���ڴ洢��ͬ���������͵�����
 * �����������͵Ĳ�ͬ��boolean���⣬����7�ж��У����ṩ����Ӧ���͵Ļ�������
 * ByteBuffer:
 * 
 * 
 * CharBuffer:
 * ShortBuffer:
 * IntBuffer:
 * LongBuffer:
 * FloatBuffer:
 * DoubleBuffer:
 * �����������Ĺ���ʽ����һ�£�ͨ��allocate������ȡ������
 * @author Administrator
 *������������ȡ���ݵ��������ķ�����
 *	put()���������ݵ�������
 *	get() :��ȡ������������
 *
 *�����������е��ĸ��������ԣ�
 *	capacity����������ʾ�����������洢���ݵ�������һ���������ܸı䡣
 *	limit:		 ���ޣ���ʾ�������п��Բ������ݵĴ�С����limit ��������ݲ��ܶ�д��
 *	position�� λ�ã���ʾ�����������ڲ������ݵ�λ��
 * mark:��ǣ���ʾ��¼��ǰposition��λ�ã�����ͨ��reset()�ظ���mark��λ��
 *
 * ���ݴ�С��0<=mark<=position <= limit <= capacity
 *
 *�ģ�ֱ�ӻ��������ֱ�ӻ�����
 *	��ֱ�ӻ�������ͨ��allocate()�������仺��������������������JVM���ڴ��С���ͳIO�������֡�
 *	ֱ�ӻ�������ͨ��allocateDirect()��������ֱ�ӻ��������������������ڲ���ϵͳ�������ڴ��У��������Ч�ʡ���Ч��
 *						�ŵ㣺��Ч
 *						ȱ�㣺����ȫ��������
 *
 */
public class Demo1 {
	
	@Test
		public void testBuffer(){
			// 1.����һ��ָ����С�Ļ�����
			ByteBuffer buf = ByteBuffer.allocate(1024);
			System.out.println("-----position-----limit-----capacity--");			
			System.out.println("----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			// 2.д����ģʽ����put�����������ݵ�������
			buf.put("abcde".getBytes());
			System.out.println("put֮��-----position-----limit-----capacity--");			
			System.out.println("put֮��-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 3.�л�Ϊ��ȡ���ݵ�ģʽ
			buf.flip();
			System.out.println("flip֮��-----position-----limit-----capacity--");			
			System.out.println("flip֮��-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 4.����get()��ȡ�������е�����
			byte[] dst = new byte[buf.limit()];
			buf.get(dst);
			System.out.println(new String(dst));
			System.out.println("get֮��-----position-----limit-----capacity--");			
			System.out.println("get֮��-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 5.rewind() ���ظ�������
			buf.rewind();
			System.out.println("rewind֮��-----position-----limit-----capacity--");			
			System.out.println("rewind֮��-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			
			// 6.clear()��ջ�����,���ǻ������е�������Ȼ�����ڣ����ǳ��ڡ�������״̬��
			buf.clear();
			System.out.println("clean֮��-----position-----limit-----capacity--");			
			System.out.println("clean֮��-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
			System.out.println("clear֮��---:"+(char)buf.get());
			
		}
	
	
	@Test
	public void test2(){
		String str ="abcde";
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.put(str.getBytes());
		buf.flip();
		byte[] dst = new byte[buf.limit()];
		buf.get(dst,0,2);
		System.out.println(new String(dst,0,2));//��ʱposition�ڵڶ���λ����
		System.out.println("-----position-----limit-----capacity--");			
		System.out.println("-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
		// mark()���
		buf.mark();
		buf.get(dst,2,2);
		System.out.println(new String(dst,2,2));
		System.out.println("-----position-----limit-----capacity--");			
		System.out.println("-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
		// reset():�ָ���mark��λ��
		buf.reset();
		System.out.println("reset-----position-----limit-----capacity--");			
		System.out.println("reset-----"+buf.position()+"----"+buf.limit()+"----"+buf.capacity());
		
		// �жϻ�������ʱ�������� 
		if(buf.hasRemaining()){
			// ��ȡ�������п��Բ���������
			System.out.println("ʣ�ࣺ"+buf.remaining()+"��");
		}		
	}
	/**
	 * ����ֱ�ӻ�����
	 */
	@Test
	public void test3(){
		ByteBuffer buf = ByteBuffer.allocateDirect(1024);
		// �ж��Ƿ���ֱ�ӻ�������
		System.out.println("��ֱ�ӻ�������" + buf.isDirect());
	}
	
	
	
}
