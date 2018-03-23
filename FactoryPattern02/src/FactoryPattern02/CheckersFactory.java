/**
 * 创建国际象棋的实现工厂
 */
package FactoryPattern02;

/**
 * @author Feng
 *
 */
public class CheckersFactory implements GameFactory {

	/* （非 Javadoc）
	 * @see FactoryPattern02.GameFactory#getGame()
	 */
	@Override
	public Game getGame() {		
		return new Checkers();
	}

}
