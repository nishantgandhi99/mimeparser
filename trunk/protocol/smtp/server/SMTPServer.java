package smtp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import smtp.server.SMTPConnection;

public class SMTPServer implements Runnable {
	
	private final static int PORT = 5678;
	private int port;
	
	public SMTPServer() {
		this.port = PORT;
	}
	
	public SMTPServer(int port) {
		this.port = port;
	}
	
	@Override
	public void run() {
		
		System.out.println("Starting SMTP server ...");
		
		ServerSocket mailSocket = null;
		try {
			mailSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Problem z bindowaniem do portu: " + e.toString());
			return;
		}
        
        System.out.println("Listetning connections on port: " + port);
        
		while (true) {
			
			Socket SMTPSocket = null;
			SMTPConnection connection = null;
			try {
				SMTPSocket = mailSocket.accept();
				connection = new SMTPConnection(SMTPSocket);
			} catch (Exception e) {
				System.err.println("Problem z akceptowaniem polaczen");
				return;
			}
			Thread thread = new Thread(connection);
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		
		SMTPServer smtpServer = new SMTPServer(5679);
		Thread thread = new Thread(smtpServer);
		thread.start();
		
	}
}
