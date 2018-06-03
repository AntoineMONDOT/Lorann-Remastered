package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;

public class BoneTest {
	
	private Bone bone;

	@Before
	public void setUp() throws Exception {
		bone = new Bone();
	}

	
	@Test
	public void testBoneConstructor() {
		assertNotNull(bone);
	}

	@Test
	public void testBoneCharacter() {
		assertEquals(bone.getSprite().getConsoleImage(),'O');
	}
	
	@Test
	public void testBoneImage() {
		assertEquals(bone.getImage(),bone.getSprite().getImage());
	}
	
	@Test
	public void testBonePermeability() {
		assertEquals(bone.getPermeability(),Permeability.BLOCKING);
	}

}
