package galaxy.rapid.command;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringConverter {
	Charset charset;
	String orginalText;
	
	
	public StringConverter(String stringToConvert) {
		orginalText = stringToConvert;
	}
	public StringConverter(String stringToConvert, String string) throws UnsupportedEncodingException {
		orginalText = stringToConvert;
	}
	
	public StringConverter(byte[] textbytes, String charset) throws UnsupportedEncodingException {
		orginalText = new String(textbytes, charset);
	}

	public String convertTo(String charset){
		
		try {
			byte[] convertText = orginalText.getBytes(charset);
//			String s = new String(b, "US-ASCII");
			String s = new String(convertText, charset);
			return s;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
		
	}
}
