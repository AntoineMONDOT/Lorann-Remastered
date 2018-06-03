package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.Test;

public class LorannTest {

	@Test
	public void testConstructorWithoutLevel() {
		try {
			new Lorann(0, 0, null);
			fail("Lorann should not be created without a level");
		}
		catch (Exception e) {
			
		}
	}

}
