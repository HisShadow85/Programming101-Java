package week1;

import java.io.UnsupportedEncodingException;

public class DecodeURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static String decodeUrl(String input) throws UnsupportedEncodingException{
		return java.net.URLDecoder.decode(input, "UTF-8");
	}
}
