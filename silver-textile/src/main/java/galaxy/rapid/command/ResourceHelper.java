package galaxy.rapid.command;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class ResourceHelper {
	public ResourceHelper() {
	}

	public byte[] readAllBytesFromResource(String resource) throws IOException {
		InputStream is = getClass().getResourceAsStream("/" + resource);
//		String theString = IOUtils.toString(is, Charsets.UTF_8); 
//		System.out.println("theString: " + theString);
		byte[] bytes = IOUtils.toByteArray(is);
		return bytes;
	}
}
