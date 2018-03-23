/**
 * 双检锁/双重校检锁
 * 	优点：双锁机制，安全且在多线程情况下能保持高效能
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
