package galaxy.rapid.command;

import org.apache.commons.codec.binary.Base64;

import com.google.common.base.Charsets;

public class Base64Helper {
	private static Base64 decoder = new Base64();

	public static String decode(String base64) {
		byte[] decodedBytes = decoder.decode(base64);
		String result = new String(decodedBytes);
		System.out.println("base64 decode:" + result);
		return result;
	}

	public static String encode(String text) {
		return decoder.encodeAsString(text.getBytes(Charsets.UTF_8));
	}

}
