package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;

public class GateTest {

	private Gate gate;

	@Before
	public void setUp() throws Exception {
		gate = new Gate();
	}

	
	@Test
	public void testGateConstructor() {
		assertNotNull(gate);
	}

	@Test
	public void testGateCharacter() {
		assertEquals(gate.getSprite().getConsoleImage(),'H');
	}
	
	@Test
	public void testGateImage() {
		assertEquals(gate.getImage(),gate.getSprite().getImage());
	}
	
	@Test
	public void testGatePermeabilityWhenClose() {
		assertEquals(gate.getPermeability(),Permeability.KILLING);
	}
	
	@Test
	public void testGatePermeabilityWhenOpen() {
    	gate.setPermeability(Permeability.OPENGATE);
		assertEquals(gate.getPermeability(),Permeability.OPENGATE);
	}

}
