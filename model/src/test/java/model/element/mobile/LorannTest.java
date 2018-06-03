package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LorannTest {

	@Test
	public void testConstructorWithoutLevel() throws IOException {
		assertNotNull(new Lorann(0, 0, null));
	}

}
