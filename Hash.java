import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hash {

	
	public static void main(String[] args) {
		
		/*MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			
			String originalString = "Hi My Name is Meet";
			byte[] encodedhash = digest.digest(
			  originalString .getBytes(StandardCharsets.UTF_8));
			
			System.out.println(encodedhash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		String text = "12345";
		MessageDigest sha = null;
		try {
		sha = MessageDigest.getInstance("SHA-256");


		} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		sha.reset();
		sha.update(text.getBytes());
		byte[] digest = sha.digest();
		System.out.println(digest.length);

		String encodedDigest = Base64.getEncoder().encodeToString(digest);

		System.out.println(encodedDigest);
		
	}  
}
