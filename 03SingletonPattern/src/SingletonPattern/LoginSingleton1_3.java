/**
 * �Ǽ�ʽ/��̬�ڲ���
 * �ж���ʽ���ŵ㣬�ֲ������Ĳ���
 */
package SingletonPattern;

/**
 * @author Feng
 *
 */
public  class LoginSingleton1_3 {
	//�ڲ���
	private static class SingletonHolder{
		private static final LoginSingleton1_3 instance=new LoginSingleton1_3();
	}
	//˽�й�����
	private LoginSingleton1_3(){};
	//��̬���ʷ���
	public static final LoginSingleton1_3 getInstance(){
		return SingletonHolder.instance;
	}
	
	public void showMessage(){
		System.out.println("SingletonLogin :Hello world!");
	}
}




