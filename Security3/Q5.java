import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class Q5 {

	static Object readFromFile(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(filename);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object object = oin.readObject();
		oin.close();
		return object;
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String ALGORITHM = "AES" ;
		 try {
		 // Decrypt
		
		SecretKey key = (SecretKey) readFromFile("data/secretKey.txt");
		System.out.println("Key: " + key);
		 
		SealedObject sealedEmp =  (SealedObject) readFromFile("data/sealedObject.dat");
		System.out.println("Sealed Employee: " + sealedEmp);
		
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);
		
		// extracting the sealed object 
		Employee e2 = (Employee) sealedEmp.getObject(dCipher);
		System.out.println("Employee: " +e2.toString());
		
	}
		 catch (Exception e) {
			// TODO: handle exception
		}
	}

}
