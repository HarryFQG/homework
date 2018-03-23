/**
 * ˫����/˫��У����
 * 	�ŵ㣺˫�����ƣ���ȫ���ڶ��߳�������ܱ��ָ�Ч��
 */
package SingletonPattern;

/**
 * @author Feng
 *
 */
public class DCLSinglecton1_4 {
	
	private volatile static DCLSinglecton1_4 instance;
	
	private DCLSinglecton1_4(){}
	
	public static DCLSinglecton1_4 getInstance(){
		if(instance==null){
			synchronized (DCLSinglecton1_4.class) {
				if(instance==null){
					instance=new DCLSinglecton1_4();
				}
			}
		}
		
		return instance;				
	}
	public void showMessage(){
		System.out.println("DCLSinglecton1_4 :Hello world!");
	}
}
