/**
 * 懒汉式，线程安全。
 */
package SingletonPattern;

public class SingletonIdler1 {
	
	private static SingletonIdler1 instance;
	
	private SingletonIdler1(){}
	//获取唯一可用对象
	
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
