package NavalNetworking;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class Networking {
    private String IP ;
    private int PORT ;
    private boolean isHoster ;
    public Networking() throws IOException {
        ServerSocket serverSocket = new ServerSocket(0);
        InetAddress serverAddress = InetAddress.getLocalHost();
        System.out.println("Listening on port: " + serverSocket.getLocalPort() + " IP: " + serverAddress);
        Socket clientSocket = serverSocket.accept();
        OutputStream out = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        InputStream in = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    }
    public String[] info() {
        if (isHoster) {
        return new String[] {IP,Integer.toString(PORT)} ;
        }
        return new String[] {null} ;
    }
    public Networking(String IP, int PORT) throws IOException {
        Socket clientSocket = new Socket(IP, PORT);
        OutputStream out = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        InputStream in = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    }
}