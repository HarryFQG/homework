/**
 * 创建Singleto类
 */
package SingletonPattern;

public class SingleObject {
	//创建SingletonObject的对象
	private static SingleObject instance=new SingleObject();
	//让构造器私有化，这样就不会被实例了
	private SingleObject (){}
	public static SingleObject getInstance(){
		return instance;		
	}
	
	public void showMessage(){
		System.out.println("Hello world!");
	}
	
	
}
