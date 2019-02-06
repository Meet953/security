import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

public class Q3Apache {
	 
public static void main(String[] args) {
	
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the message");
	  String message = sc.nextLine();
      String digest = DigestUtils.sha256Hex(message);
      sc.close();
   
      System.out.println("Password        = " + message);
      System.out.println("Password Digest = " + digest);
      System.out.println("Length          = " + digest.length());
}
}