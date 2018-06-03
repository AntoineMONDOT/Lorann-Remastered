package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;

public class TileTest {

	private Tile Tile;

	@Before
	public void setUp() throws Exception {
		Tile = new Tile();
	}

	
	@Test
	public void testTileConstructor() {
		assertNotNull(Tile);
	}

	@Test
	public void testTileCharacter() {
		assertEquals(Tile.getSprite().getConsoleImage(),' ');
	}
	
	@Test
	public void testTileImage() {
		assertEquals(Tile.getImage(),Tile.getSprite().getImage());
	}
	
	@Test
	public void testTilePermeability() {
		assertEquals(Tile.getPermeability(),Permeability.PENETRABLE);
	}

}
