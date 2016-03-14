package pl.silver.files;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FilesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		File file = new File("\\\\ns364990.ovh.net@5589\\DavWWWRoot");
		System.out.println("File: " + file.getName() + " exist: " + file.exists());
		for(File child : file.listFiles()){
			System.out.println("File: " + child.getName() + " exist: " + child.exists());
		}
	}

}
