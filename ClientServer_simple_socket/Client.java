public class Client {
    final static String serverIPName = "localhost";
    final static int    serverPort = 3456;

    public static void main(String[] args) {
        java.net.Socket serverSocket = null;
        java.io.PrintWriter textToServerSocket = null;
        java.io.BufferedReader textFromServerSocket = null;
        
        try {

            System.out.println("Client: Connecting to server");
            //ask for system resource socket and connect to server address
            serverSocket = new java.net.Socket(serverIPName, serverPort);
            // what port have this socket? it is not neccessary to know
            // but we will try to know..
            boolean fulushOnLn = true;
            textToServerSocket = new java.io.PrintWriter(
                serverSocket.getOutputStream(),
                fulushOnLn
            );
            textFromServerSocket = new java.io.BufferedReader(
                new java.io.InputStreamReader(serverSocket.getInputStream())
            );
            System.out.println("Client: Connected to server");


            System.out.println("Client: Message will be send to server.");
            textToServerSocket.println("Client: What's up Mr. Server?");
            System.out.println("Client: Message has been send to server.");


            System.out.println("Client: Waiting/Reading message from server");
            String serverResponse = textFromServerSocket.readLine();
            System.out.println(
                "Client: Server have responded with message > " 
                + serverResponse
            );


            // return resources to system:
            serverSocket.close();
            textFromServerSocket.close();
            textToServerSocket.close();

        } catch (Throwable e) {
            System.out.println("Client: Error: " + e.getMessage());
            e.printStackTrace();
        }
		System.out.println("Client: goodby.");
    }
}