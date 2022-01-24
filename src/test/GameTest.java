package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.model.GridGame5D;

public class GameTest {

	@Test
	void IGridGameTestIsAlign() {
		GridGame5D game = new GridGame5D();
		assertTrue(game.isAligned(9, 3, 5));
		game.placePoint(9, 3);
		assertFalse(game.isAligned(8, 3, 5));
	}

}
