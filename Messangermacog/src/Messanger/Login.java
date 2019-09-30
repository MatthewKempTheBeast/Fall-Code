package Messanger;

import java.io.*;
import java.net.*;
public class Login {
	private String iP;
	private int porT;
	private Socket connection;
	public Login(String ip, int port) throws UnknownHostException, IOException{
		connection = new Socket(ip,port);
		this.iP = ip;
		this.porT = port;
	}
	public Login() {
		connection = new Socket();
		this.iP = "";
		this.porT = 12902;
	}
	public boolean verifyCred(String user,String pass) throws IOException {
		PrintWriter pr = new PrintWriter(connection.getOutputStream());
		//we dont need to encode with special values because we are only checking login credentials
		//nothing else will be sent or recieved from the server as its all on the public network
		System.out.println("Login"+user + ":" + pass);
		pr.println("Login"+user + ":" + pass);
		pr.flush();
		InputStreamReader in = new InputStreamReader(connection.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		String str = bf.readLine();
		System.out.println(str);
		if(str.equals("true")) {
			close();
			return true;
		}
		else {
			close();
			return false;
		}

	}
	public void create(String user,String pass) throws IOException{
		PrintWriter pr = new PrintWriter(connection.getOutputStream());
		//we dont need to encode with special values because we are only checking login credentials
		//nothing else will be sent or recieved from the server as its all on the public network
		System.out.println("Create"+user + ":" + pass);
		pr.println("Create"+user + ":" + pass);
		pr.flush();
	}
	public void close() throws IOException {
		connection.close();
	}
	public static boolean testConnection(String ip, int port) {
		Socket temp;
		try {
			temp = new Socket(ip,port);
			System.out.println("1");
		} catch (UnknownHostException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		System.out.println("2");
		try {
			temp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}