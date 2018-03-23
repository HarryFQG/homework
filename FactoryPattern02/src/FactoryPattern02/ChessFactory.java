/**
 * 创建中国象棋的实现工厂
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class ChessFactory implements GameFactory {

	/* （非 Javadoc）
	 * @see FactoryPattern02.Game#move()
	 */
	@Override
	public Game getGame() {
		return new Chess();
	}

}
