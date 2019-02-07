import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Q5Client {

public static void main(String[] args) throws Exception{

InetAddress inet = InetAddress.getByName("localhost");
//InetAddress inet = InetAddress.getByAddress(http://192.168.56.1/);

Socket s = new Socket(inet, 2000);

OutputStream out = s.getOutputStream();
PrintWriter p = new PrintWriter(out);
InputStream in = s.getInputStream();
Scanner sc = new Scanner(in);

p.println("tv");
p.flush();

String input = sc.nextLine();
System.out.println("Client : " + input);
}

}