package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.Test;

public class SupraPowerTest {

	@Test
	public void testConstructorWithoutLevel() {
		try {
			new SupraPower(0, 0, null);
			fail("Lorann should not be created without a level");
		}
		catch (Exception e) {
			
		}
	}

}
