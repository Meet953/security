import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;

import javax.crypto.spec.DHParameterSpec;

public class Q1GenerateParams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		try {
				 AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DH");
				 paramGen.init(1024);
				 // Generate the parameters
				 AlgorithmParameters params = paramGen.generateParameters();
				 DHParameterSpec dhSpec = params.getParameterSpec(DHParameterSpec.class);

				 //Constructs a parameter set for Diffie-Hellman, using
				 //getP:prime modules
				 //getG:base generator
				 //getL:size in bits
				 String s = dhSpec.getP() + "," + dhSpec.getG() + "," + dhSpec.getL();
				 System.out.println(s);
				 writeToFile("data/dhParams", s) ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				 
	}
	
	
	private static void writeToFile(String filename, Object object)
		      throws Exception {
		    FileOutputStream fout = new FileOutputStream(new File(filename));
		    ObjectOutputStream oout = new ObjectOutputStream(fout);
		    oout.writeObject(object);
		    oout.close();
		}

}
