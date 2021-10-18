package servidor;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }
        
        while (listening) {
        	new HiloServicio(serverSocket.accept()).start();
        }
	    
        serverSocket.close();
        
    }
}
