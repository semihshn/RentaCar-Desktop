package application.core.utilities.security.encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptHelper {
	
    public static String encryptMD5(String content) {
    	try {
    		MessageDigest md=MessageDigest.getInstance("MD5");
    		//Byte olarak oku
    		byte[] encrypted=md.digest(content.getBytes());
    		
    		BigInteger no=new BigInteger(1,encrypted);
    		//Hex Hesapla
    		String hashContent=no.toString(16);
    		while (hashContent.length()<32) {
				hashContent="0"+hashContent;
			}
    		
    		return hashContent;
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
    	
    	
    }

}
