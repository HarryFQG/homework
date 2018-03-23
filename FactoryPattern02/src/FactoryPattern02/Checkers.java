/**
 * 国际象棋下法
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class Checkers implements Game {

	private int moves=0;
	private static final int MOVES=3;
	/* （非 Javadoc）
	 * @see FactoryPattern02.Game#move()
	 */
	@Override
	public boolean move() {		
			System.out.println("国际象棋移动法则："+moves);
			return ++moves!=MOVES;		
	}

}
