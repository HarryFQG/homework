/**
 * 登记式/静态内部类
 * 有饿汉式的优点，弥补了他的不足
 */
package SingletonPattern;

/**
 * @author Feng
 *
 */
public  class LoginSingleton1_3 {
	//内部类
	private static class SingletonHolder{
		private static final LoginSingleton1_3 instance=new LoginSingleton1_3();
	}
	//私有构造器
	private LoginSingleton1_3(){};
	//静态访问方法
	public static final LoginSingleton1_3 getInstance(){
		return SingletonHolder.instance;
	}
	
	public void showMessage(){
		System.out.println("SingletonLogin :Hello world!");
	}
}




