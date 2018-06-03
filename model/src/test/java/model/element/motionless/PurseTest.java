package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;

public class PurseTest {

	private Purse Purse;

	@Before
	public void setUp() throws Exception {
		Purse = new Purse();
	}

	
	@Test
	public void testPurseConstructor() {
		assertNotNull(Purse);
	}

	@Test
	public void testPurseCharacter() {
		assertEquals(Purse.getSprite().getConsoleImage(),'$');
	}
	
	@Test
	public void testPurseImage() {
		assertEquals(Purse.getImage(),Purse.getSprite().getImage());
	}
	
	@Test
	public void testPursePermeability() {
		assertEquals(Purse.getPermeability(),Permeability.PENETRABLE);
	}

}
