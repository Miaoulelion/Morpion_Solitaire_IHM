package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void IGridGameTestIsAlign() {
		GridGame5D game=new GridGame5D();
		assertTrue(game.isAligned(9, 3, 5));
		game.placePoint(9, 3);
		assertFalse(game.isAligned(8, 3, 5));
	}
	


}
