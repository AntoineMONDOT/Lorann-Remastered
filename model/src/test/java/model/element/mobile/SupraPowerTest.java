package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SupraPowerTest {

	@Test
	public void testConstructorWithoutLevel() throws IOException {
		assertNotNull(new SupraPower(0, 0, null));
	}

}
