/**
 * �й������·�
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class Chess implements Game {
	private int moves=0;
	private static final int MOVES=4;
	/* ���� Javadoc��
	 * @see FactoryPattern02.Game#move()
	 */
	@Override
	public boolean move() {
		System.out.println("�й������ƶ�����"+moves);
		return ++moves!=MOVES;	
	}

}
