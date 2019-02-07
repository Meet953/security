import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Q2 {
	
	static void writeToFile(String filename, Object object) throws Exception {
		FileOutputStream fout = new FileOutputStream(filename);
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(object);
		oout.close();
		}
	

	public static void main(String[] args) {
	
	try {
		
		//generate secret key
		KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
		SecretKey sk = kg.generateKey();
		
		//encode and write secret key to the file
		String encodedKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		System.out.println("Encoded Key :" + encodedKey);
		writeToFile("C:\\Users\\a00258745\\Security\\data\\secretKey.txt", encodedKey);
		
		//write message into the file
		String message = "Hi There";
		writeToFile("C:\\Users\\a00258745\\Security\\data\\sendText.txt", message);

		//create mac for message and write into the file
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(sk);
		byte[] hmac = mac.doFinal(message.getBytes());
		String encodedHmac = Base64.getEncoder().encodeToString(hmac);
		
		System.out.println("Encoded HMAC :" + encodedHmac);
		writeToFile("C:\\Users\\a00258745\\Security\\data\\hmac.txt", encodedHmac);
		
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
