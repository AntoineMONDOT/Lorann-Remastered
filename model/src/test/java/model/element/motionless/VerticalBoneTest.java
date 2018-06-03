package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;

public class VerticalBoneTest {

	private VerticalBone VBone;

	@Before
	public void setUp() throws Exception {
		VBone = new VerticalBone();
	}

	
	@Test
	public void testVerticalBoneConstructor() {
		assertNotNull(VBone);
	}

	@Test
	public void testVerticalBoneCharacter() {
		assertEquals(VBone.getSprite().getConsoleImage(),'|');
	}
	
	@Test
	public void testVerticalBoneImage() {
		assertEquals(VBone.getImage(),VBone.getSprite().getImage());
	}
	
	@Test
	public void testVertiacalBonePermeability() {
		assertEquals(VBone.getPermeability(),Permeability.BLOCKING);
	}

}
