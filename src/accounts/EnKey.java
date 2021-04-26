package accounts;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;   
import javax.crypto.SecretKey; 

public class EnKey {
		public static SecretKey keygen() throws NoSuchAlgorithmException {
				
				KeyGenerator keyGen;
				keyGen = KeyGenerator.getInstance("AES");
				keyGen.init(128);
				
				SecretKey secret = keyGen.generateKey();
				return secret;
			
		}
		
		static Cipher cipher;
		
		public static void main(String[] args) throws Exception {

			cipher = Cipher.getInstance("AES");  
	    }
		
	    public static String encrypt(String plainT, SecretKey secret) throws Exception {
	    	
	        byte[] plainTB = plainT.getBytes();
	        cipher.init(Cipher.ENCRYPT_MODE, secret);
	        byte[] encTB = cipher.doFinal(plainTB);
	        Base64.Encoder enc = Base64.getEncoder();
	        String encT = enc.encodeToString(encTB);
	        
	        return encT;
	    }

	    public static String decrypt(String encT, SecretKey secret) throws Exception {
	    	
	        Base64.Decoder decoder = Base64.getDecoder();
	        byte[] encTB = decoder.decode(encT);
	        cipher.init(Cipher.DECRYPT_MODE, secret);
	        byte[] decTB = cipher.doFinal(encTB);
	        String decT = new String(decTB);
	        
	        return decT;
	    }
	    
}
