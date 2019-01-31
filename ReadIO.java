	import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64; 
public class ReadIO {
	

	
	  
	  public static void main(String[] args)throws Exception 
	  { 
		  String text = null;
		  BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\a00258745\\\\Digest\\\\src\\\\test.txt"));
		  try {
		      StringBuilder sb = new StringBuilder();
		      String line = br.readLine();
System.out.println(line);
		      while (line != null) {
		          sb.append(line);
		          sb.append(System.lineSeparator());
		          line = br.readLine();
		      }
		   text  = sb.toString();
		  } finally {
		      br.close();
		  }
		  
	  
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
