/**
 * 六种单例模式中：
 * 			一般不建议使用懒汉式，建议使用饿汉式；明确要求动态加载（Lazy loading）时使用登记
 * 			登记式内部静态类；如果涉及反序列化，就是用枚举单例模式；如果其他特许要求可使用双检锁单例模式
 */

package SingletonPattern;

public class DemoSingleton {

	public static void main(String[] args) {
		//不能使用SingleObject的构造函数
		SingleObject object=SingleObject.getInstance();
		object.showMessage();
		//线程安全的懒汉式单例模式
		SingletonIdler1 idler=SingletonIdler1.getInstance();
		idler.showMessage();
		//饿汉安全单例模式
		UnidlerSingleton1_2 unidler=UnidlerSingleton1_2.getInstance();
		unidler.showMessage();
		//登记式/静态内部类
		LoginSingleton1_3 login=LoginSingleton1_3.getInstance();
		login.showMessage();
		//枚举实例化单例模式
		EnumSingleton1_1 sEnum=EnumSingleton1_1.INSTANCE;
		sEnum.showMessage();
		//双检锁/双重校检锁
		DCLSinglecton1_4 instance=DCLSinglecton1_4.getInstance();
		instance.showMessage();
	}

}
