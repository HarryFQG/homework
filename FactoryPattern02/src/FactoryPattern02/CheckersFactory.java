/**
 * �������������ʵ�ֹ���
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class CheckersFactory implements GameFactory {

	/* ���� Javadoc��
	 * @see FactoryPattern02.GameFactory#getGame()
	 */
	@Override
	public Game getGame() {		
		return new Checkers();
	}

}
