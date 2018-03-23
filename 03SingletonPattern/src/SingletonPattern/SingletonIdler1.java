/**
 * ����ʽ���̰߳�ȫ��
 */
package SingletonPattern;

public class SingletonIdler1 {
	
	private static SingletonIdler1 instance;
	
	private SingletonIdler1(){}
	//��ȡΨһ���ö���
	
	public static synchronized SingletonIdler1 getInstance(){
		if(instance==null){
			instance=new SingletonIdler1();
		}
		
		return instance;
	}
	
	public void showMessage(){
		System.out.println("SingletonIdler1 :Hello world!");
	}
}
