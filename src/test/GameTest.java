package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.model.GridGame5D;
import main.model.GridGame5T;
import main.model.Point;

public class GameTest {

	@Test
	void IGridGameTestIsPresent() {
		GridGame5D game = new GridGame5D();
		// We verify if the "x=9,y=3" is aligned if we search a 5 points alignment.
		assertTrue(game.isAligned(9, 3, 5));
		// A Point is placed, so the alignment is "confirmed".
		game.placePoint(9, 3);
		// The new point need to exist in the grid to be displayed.
		assertTrue(game.getGridPoints().contains(new Point(9, 3)));
		// This point doesn't exist already.
		assertFalse(game.getGridPoints().contains(new Point(20, 2)));
	}

	@Test
	void IGridGameTestIsAlign() {
		GridGame5D game = new GridGame5D();
		// We verify if the "x=9,y=3" is aligned if we search a 5 points alignment.
		assertTrue(game.isAligned(9, 3, 5));
		// A Point is placed, so the alignment is "confirmed".
		game.placePoint(9, 3);
		// The new point can't be aligned, all the point around are already aligned.
		assertFalse(game.isAligned(8, 3, 5));
	}

	@Test
	void IGridGameReturnAlignment() {
		// It is the alignment that we are looking for.
		ArrayList<Point> align = new ArrayList<Point>();
		align.add(new Point(9, 3));
		align.add(new Point(10, 3));
		align.add(new Point(11, 3));
		align.add(new Point(12, 3));
		align.add(new Point(13, 3));
		GridGame5D game = new GridGame5D();
		// We verify if the "x=9,y=3" is aligned if we search a 5 points alignment.
		assertTrue(game.isAligned(9, 3, 5));
		// A Point is placed, so the alignment is "confirmed".
		game.placePoint(9, 3);
		// We verify if we find the same alignment
		assertEquals(game.getListOfAlignment().get(0).getLinePoint(), align);
	}

	@Test
	void IGridGameTestPossiblePoint() {
		GridGame5D game = new GridGame5D();
		// Verify if all the possible points are OK to be aligned.
		ArrayList<Point> possibilites = new ArrayList<Point>(game.getPossiblePoint());
		for (Point p : possibilites) {
			assertTrue(game.isAligned(p.getX(), p.getY(), 5));
		}
	}

	@Test
	void IGridGameTestIsAlign5T() {
		GridGame5T game = new GridGame5T();
		// We verify if the "x=9,y=3" is aligned if we search a 5 points alignment.
		assertTrue(game.isAligned(9, 3, 5));
		// A Point is placed, so the alignment is "confirmed".
		game.placePoint(9, 3);
		// The new point can't be aligned, all the point around are already aligned.
		assertFalse(game.isAligned(8, 3, 5));
	}

	@Test
	void IGridGameReturnAlignment5T() {
		// It is the alignment that we are looking for.
		ArrayList<Point> align = new ArrayList<Point>();
		align.add(new Point(9, 3));
		align.add(new Point(10, 3));
		align.add(new Point(11, 3));
		align.add(new Point(12, 3));
		align.add(new Point(13, 3));
		GridGame5T game = new GridGame5T();
		// We verify if the "x=9,y=3" is aligned if we search a 5 points alignment.
		assertTrue(game.isAligned(9, 3, 5));
		// A Point is placed, so the alignment is "confirmed".
		game.placePoint(9, 3);
		// We verify if we find the same alignment
		assertEquals(game.getListOfAlignment().get(0).getLinePoint(), align);
	}

	@Test
	void IGridGameTestIsPresent5T() {
		GridGame5T game = new GridGame5T();
		// We verify if the "x=9,y=3" is aligned if we search a 5 points alignment.
		assertTrue(game.isAligned(9, 3, 5));
		// A Point is placed, so the alignment is "confirmed".
		game.placePoint(9, 3);
		// The new point need to exist in the grid to be displayed.
		assertTrue(game.getGridPoints().contains(new Point(9, 3)));
		// This point doesn't exist already.
		assertFalse(game.getGridPoints().contains(new Point(20, 2)));
	}

	@Test
	void IGridGameTestPossiblePoint5T() {
		GridGame5T game = new GridGame5T();
		// Verify if all the possible points are OK to be aligned.
		ArrayList<Point> possibilites = new ArrayList<Point>(game.getPossiblePoint());
		for (Point p : possibilites) {
			assertTrue(game.isAligned(p.getX(), p.getY(), 5));
		}

	}

	void searchBestRandomSolution() {
		GridGame5D game = new GridGame5D();
		int bestScore = 0;
		int actualScore;
		int i;
		for (i = 0; i < 500; i++) {
			game.randomSolve();
			actualScore = game.getPointPlayed().size();
			if (actualScore > bestScore) {
				bestScore = actualScore;
			}
			game.restartGame();
		}

		System.out.println(
				"La meilleure solution trouvée après " + i + " occurances  de Random Search est : " + bestScore);

	}

}
