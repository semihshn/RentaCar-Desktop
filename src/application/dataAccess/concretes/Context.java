package application.dataAccess.concretes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Context {
	static Connection con=null;
	
	public static Connection Connect() {
		try {
			//"jdbc:mysql://ServerIPAdresi/db_ismi", "usern_name","password"
			con=DriverManager.getConnection("jdbc:mysql://localhost/rentacar","root","");
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
	
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
