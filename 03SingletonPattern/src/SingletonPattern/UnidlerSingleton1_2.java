/**
 * ¶öººµ¥ÀýÄ£Ê½
 */

package SingletonPattern;

public class UnidlerSingleton1_2 {
	
	
		private static UnidlerSingleton1_2 instance=new UnidlerSingleton1_2();
	
		
		private UnidlerSingleton1_2(){}
		
		
		public static UnidlerSingleton1_2 getInstance(){
			return instance;
		}
		
		
		public void showMessage(){
			System.out.println("SingletonUnidler1 :Hello world!");
		}
}
