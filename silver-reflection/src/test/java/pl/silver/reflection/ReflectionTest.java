package pl.silver.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReflectionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Testing orginal = new Testing("orginal", false);
		Testing newData = new Testing("new data", true);
		SilverReflectionUtills.copyProperties(orginal, newData);
		assertTrue(orginal.getString().equals(newData.getString()));
		assertTrue(orginal.isB());
	}

}
