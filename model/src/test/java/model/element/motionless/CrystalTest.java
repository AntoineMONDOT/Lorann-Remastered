package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;

public class CrystalTest {

	private Crystal crystal;

	@Before
	public void setUp() throws Exception {
		crystal = new Crystal();
	}

	
	@Test
	public void testCrsytalConstructor() {
		assertNotNull(crystal);
	}

	@Test
	public void testCrystalCharacter() {
		assertEquals(crystal.getSprite().getConsoleImage(),'X');
	}
	
	@Test
	public void testCrystalImage() {
		assertEquals(crystal.getImage(),crystal.getSprite().getImage());
	}
	
	@Test
	public void testCrystalPermeabilityWhenNotTaken() {
		assertEquals(crystal.getPermeability(),Permeability.OPENNING);
	}
	
	@Test
	public void testCrystalPermeabilityWhenAlreadyTake() {
    	crystal.setPermeability(Permeability.PENETRABLE);
		assertEquals(crystal.getPermeability(),Permeability.PENETRABLE);
	}

}
