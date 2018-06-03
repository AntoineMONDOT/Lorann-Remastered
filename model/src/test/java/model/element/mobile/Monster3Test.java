package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.Test;

public class Monster3Test {

	@Test
	public void testConstructorWithoutLevel() {
		try {
			new Monster3(0, 0, null);
			fail("Lorann should not be created without a level");
		}
		catch (Exception e) {
			
		}
	}

}
