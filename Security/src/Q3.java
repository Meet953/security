import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Q3 {

	
	static Object readFromFile(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(filename);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object object = oin.readObject();
		oin.close();
		return object;
		}
	
	public static void main(String[] args) {
		
		
		try {
			
			//reading and decoding secret key from file
			String encodedKey = (String) readFromFile("C:\\Users\\a00258745\\Security\\data\\secretKey.txt");
			System.out.println("Encoded Key : " + encodedKey );
			byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
			SecretKey sk = new SecretKeySpec(decodedKey, 0, decodedKey.length,"HmacSHA256");
			
			//reading message from file
			String message = (String) readFromFile("C:\\Users\\a00258745\\Security\\data\\sendText.txt");
			System.out.println("Message : " + message );
			
			//reading and decoding hmac from file
			String encodedHmac = (String) readFromFile("C:\\Users\\a00258745\\Security\\data\\hmac.txt");
			System.out.println("Encoded HMAC : " + encodedHmac );
			byte[] decodedHmac = Base64.getDecoder().decode(encodedHmac);
			
			//create hmac for message with secret key
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(sk);  
			byte[] result = mac.doFinal(message.getBytes());
			
			//comparing messages
			System.out.println("Check: " + Arrays.equals(decodedHmac, result));
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}
}
