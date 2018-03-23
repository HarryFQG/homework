/**
 * ����Singleto��
 */
package SingletonPattern;

public class SingleObject {
	//����SingletonObject�Ķ���
	private static SingleObject instance=new SingleObject();
	//�ù�����˽�л��������Ͳ��ᱻʵ����
	private SingleObject (){}
	public static SingleObject getInstance(){
		return instance;		
	}
	
	public void showMessage(){
		System.out.println("Hello world!");
	}
	
	
}
