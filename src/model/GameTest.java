package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void IGridGameTestIsAlign() {
		IGridGame game=new GridGame5D();
		//assertFalse(game.isAligned(-1, 0, 5));
		game.placePoint(-1, 0);
		//assertTrue(game.isAligned(-2, 0, 5));
	}
	
	@Test
	void JoinFiveTestNumberAlign() {
		GridGame5D game=new GridGame5D();
		//assertEquals(4, game.numberAlignedPoints(-1, 0, 1, 0));
		for(int i=0;i<5;++i) {
			game.placePoint(4+i,0);
		}
		//assertEquals(9,game.numberAlignedPoints(-1, 0, 1, 0));
	}

}
