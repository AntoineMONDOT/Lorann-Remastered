package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;

public class HorizontalBoneTest {

	private HorizontalBone HBone;

	@Before
	public void setUp() throws Exception {
		HBone = new HorizontalBone();
	}

	
	@Test
	public void testGateConstructor() {
		assertNotNull(HBone);
	}

	@Test
	public void testGateCharacter() {
		assertEquals(HBone.getSprite().getConsoleImage(),'-');
	}
	
	@Test
	public void testGateImage() {
		assertEquals(HBone.getImage(),HBone.getSprite().getImage());
	}
	
	@Test
	public void testHorizontalBonePermeability() {
		assertEquals(HBone.getPermeability(),Permeability.BLOCKING);
	}

}
