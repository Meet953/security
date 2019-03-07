import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.spec.DHParameterSpec;

public class Q2SaveDHKeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		String PARTY = args[0];
		//String PARTY = "abc";
		 
		// get DH parameters
		 String valuesInStr = (String) readFromFile("data/dhParams");
		 String[] values = valuesInStr.split(",");
		 BigInteger p = new BigInteger(values[0]);
		 BigInteger g = new BigInteger(values[1]);
		 int l = Integer.parseInt(values[2]);
		 DHParameterSpec dhSpec = new DHParameterSpec(p, g, l);
		 
		 // Use the values to generate a key pair
		 KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH");
		 keyGen.initialize(dhSpec);
		 KeyPair keypair = keyGen.generateKeyPair();
		 
		 
		// Save the private key
		 PrivateKey privateKey = keypair.getPrivate();
		 writeToFile("data/" + PARTY + "Private", privateKey) ;
		 
		 // Save the public key
		 PublicKey publicKey = keypair.getPublic();
		 byte[] publicKeyBytes = publicKey.getEncoded();
		 System.out.println(publicKeyBytes.length);
		 FileOutputStream fout2 = new FileOutputStream
		("data/" + PARTY + "Public");
		 fout2.write(publicKeyBytes);
		 fout2.close();
		 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	 static void writeToFile(String filename, Object object)
		      throws Exception {
		    FileOutputStream fout = new FileOutputStream(new File(filename));
		    ObjectOutputStream oout = new ObjectOutputStream(fout);
		    oout.writeObject(object);
		    oout.close();
		}
	
	static Object readFromFile(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(filename);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object object = oin.readObject();
		oin.close();
		return object;
		}
	

}
