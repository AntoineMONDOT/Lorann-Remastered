package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Monster2Test {

	@Test
	public void testConstructorWithoutLevel() throws IOException {
		assertNotNull(new Monster2(0, 0, null));
	}
}
