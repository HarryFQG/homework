/**
 * 中国象棋下法
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class Chess implements Game {
	private int moves=0;
	private static final int MOVES=4;
	/* （非 Javadoc）
	 * @see FactoryPattern02.Game#move()
	 */
	@Override
	public boolean move() {
		System.out.println("中国象棋移动法则："+moves);
		return ++moves!=MOVES;	
	}

}
