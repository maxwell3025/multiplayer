package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Numberclient {
	public static void main(String[] args) throws IOException {
		String port = JOptionPane.showInputDialog("Enter port of a machine that is running the number service");
		String serverAddress = JOptionPane.showInputDialog(
				"Enter IP Address of a machine that is\n" + "running the number service on port " + port + ":");
		Socket s = new Socket(serverAddress, Integer.parseInt(port));
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream());
		while(true){
			String answer = input.readLine();
		String response = JOptionPane
				.showInputDialog("john said:" + answer + "\n" + "what do you want to respond with");
		out.println(response);
		if (response.equals("end")||answer.equals("end")) {
			s.close();
			break;
		}
			System.exit(0);
		}
		

	}
}