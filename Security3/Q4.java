import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

 
public class Q4 {

	private static void writeToFile(String filename, Object object)
		      throws Exception {
		    FileOutputStream fout = new FileOutputStream(new File(filename));
		    ObjectOutputStream oout = new ObjectOutputStream(fout);
		    oout.writeObject(object);
		    oout.close();
		}

	
	
	public static void main(String[] args) {
		
		Employee e1= new Employee("Meet","Croi Oige", "9988807643");
				
		 
		 String ALGORITHM = "AES" ;
		 
			try {
				 KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
				 
				  SecretKey key = keygen.generateKey();
				  System.out.println("Key: " + key);
				  
				  Cipher eCipher = Cipher.getInstance(ALGORITHM);
				  
				  // Initialize the cipher for encryption
				  eCipher.init(Cipher.ENCRYPT_MODE, key);
				  System.out.println("Employee: " + e1.toString());
				  
				  //creating sealed object 
				  SealedObject sealedEmp = new SealedObject(e1, eCipher);
				  System.out.println("Sealed Employee: " + sealedEmp);
				 
				 //saving sealed object to file
				  writeToFile("data/sealedObject.dat", sealedEmp);
				  
				//saving Cipher key to file
				  writeToFile("data/secretKey.txt", key);
				  

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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			  
				
	}
}
