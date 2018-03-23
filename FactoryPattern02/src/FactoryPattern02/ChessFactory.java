/**
 * �����й������ʵ�ֹ���
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class ChessFactory implements GameFactory {

	/* ���� Javadoc��
	 * @see FactoryPattern02.Game#move()
	 */
	@Override
	public Game getGame() {
		return new Chess();
	}

}
