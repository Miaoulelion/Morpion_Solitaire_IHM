package gridTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gridGames.IGridGame;
import gridGames.JoinFive;

class GridGameTest {

	@Test
	void IGridGameTestIsAlign() {
		IGridGame game=new JoinFive();
		assertFalse(game.isAligned(-1, 0, 5));
		game.placePawn(-1, 0);
		assertTrue(game.isAligned(-2, 0, 5));
	}
	
	@Test
	void JoinFiveTestNumberAlign() {
		JoinFive game=new JoinFive();
		assertEquals(4, game.numberAlignedPoints(-1, 0, 1, 0));
		for(int i=0;i<5;++i) {
			game.placePawn(4+i,0);
		}
		assertEquals(9,game.numberAlignedPoints(-1, 0, 1, 0));
	}
	
	

}
