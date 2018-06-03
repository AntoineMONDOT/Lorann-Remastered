package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotionlessElementFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFactoryAlwaysReturnSomething() {
		assertNotNull(MotionlessElementFactory.getFromFileSymbol('H'));
		assertNotNull(MotionlessElementFactory.getFromFileSymbol(' '));
		assertNotNull(MotionlessElementFactory.getFromFileSymbol('@'));
		assertNotNull(MotionlessElementFactory.getFromFileSymbol('1'));
		assertNotNull(MotionlessElementFactory.getFromFileSymbol('~'));
	}
	
	@Test
	public void testFactoryReturnTileForNotKnownSprite() {
		//the sprite for a tile is space ' '
		assertEquals(MotionlessElementFactory.getFromFileSymbol('~'),MotionlessElementFactory.getFromFileSymbol(' '));
		assertEquals(MotionlessElementFactory.getFromFileSymbol('A'),MotionlessElementFactory.getFromFileSymbol(' '));
		assertEquals(MotionlessElementFactory.getFromFileSymbol('.'),MotionlessElementFactory.getFromFileSymbol(' '));
		assertEquals(MotionlessElementFactory.getFromFileSymbol('à'),MotionlessElementFactory.getFromFileSymbol(' '));
	}	

}
