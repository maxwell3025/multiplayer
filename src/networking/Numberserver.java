package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import javax.swing.JOptionPane;

public class Numberserver {
	public static void main(String[] args) throws IOException {
		String port = JOptionPane.showInputDialog(null);
		ServerSocket listener = new ServerSocket(Integer.parseInt(port));
		
			Socket socket = listener.accept();
			try {
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out.println(JOptionPane.showInputDialog("start the conversation"));
				while(true){
					String answer = in.readLine();
				String response = JOptionPane
						.showInputDialog("john said:" + answer + "\n" + "what do you want to respond with");
				out.println(response);
				if (response.equals("end")||answer.equals("end")) {
					socket.close();
					break;
				}
				}
				
			} finally {
				socket.close();
			}

		listener.close();
System.exit(0);
	}
}
