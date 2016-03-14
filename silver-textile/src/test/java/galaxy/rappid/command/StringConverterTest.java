package galaxy.rappid.command;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.primitives.Bytes;

import galaxy.rapid.command.Base64Helper;
import galaxy.rapid.command.ResourceHelper;
import galaxy.rapid.command.StringConverter;

public class StringConverterTest {

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
	public void testBase64() throws IOException {
		String text = "Ala ma kota";
		String base64 = Base64Helper.encode(text);
		System.out.println("base64: " + base64);
		text = Base64Helper.decode(base64);
		System.out.println("text: " + base64);
	}
	@Test
	public void test() throws IOException {
		byte[] utf8 = new ResourceHelper().readAllBytesFromResource("utf8.txt");
		
		StringConverter converterUTF8 = new StringConverter(utf8, "utf-8");
		String orginalUtf8 = converterUTF8.convertTo("utf-8");
		String ascii = converterUTF8.convertTo("cp852");
		StringConverter converterASCII = new StringConverter(ascii, "ISO_8859_1");
		String returnUtf8 = converterASCII.convertTo("utf-8");
		
		System.out.println("read orginalUtf8 text: " + orginalUtf8 + " conver text: " + ascii);
	}

}
