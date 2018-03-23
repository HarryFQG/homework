/**
 * ���������·�
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class Checkers implements Game {

	private int moves=0;
	private static final int MOVES=3;
	/* ���� Javadoc��
	 * @see FactoryPattern02.Game#move()
	 */
	@Override
	public boolean move() {		
			System.out.println("���������ƶ�����"+moves);
			return ++moves!=MOVES;		
	}

}
