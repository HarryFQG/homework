/**
 * 枚举单例模式：单例模式最优方法
 * 		优点：更简洁。自动支持序列化机制，绝对防止多次实例化，避免多线程问题。
 */
package SingletonPattern;

/**
 * @author Feng
 *
 */
public enum EnumSingleton1_1 {
	INSTANCE;
	public void whatMethod(){};
	public void showMessage(){
		System.out.println("enum :Hello world!");
	}
	
	
}




