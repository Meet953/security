import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
 

public class Q2BLOWFISH {
  public static void main(String[] args) {
	  
	  String ALGORITHM = "BLOWFISH" ;
	 
	try {
		 KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		 
		 SecretKey key = keygen.generateKey();
		  
		  Cipher eCipher = Cipher.getInstance(ALGORITHM);
		  // Initialize the cipher for encryption
		  eCipher.init(Cipher.ENCRYPT_MODE, key);
		  
		  String s = "This is just an example";
		  System.out.println("Clear text: " + s);
		  byte[] cleartext = s.getBytes();
		  // Encrypt the cleartext
		  byte[] ciphertext = eCipher.doFinal(cleartext);
		  System.out.println("Cipher text: " +   new String(ciphertext));
		 
		/////////////////////////////////////////////////
		// Decrypt
			
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);
		// Decrypt the ciphertext
		byte[] clearText1 = dCipher.doFinal(ciphertext);
		String text = new String(clearText1);
		System.out.println("Decrypted text: " + text);

	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalBlockSizeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (BadPaddingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchPaddingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidKeyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	  
	  
	  
   }
}