
public class Server {
	final static int port = 3456;
	public static void main(String args[]){
		java.net.ServerSocket  socket       = null;
		java.net.Socket        clientSocket = null;
		java.io.PrintWriter    textWriterToClientSocket = null;
		java.io.BufferedReader textReaderFromClientSocket  = null;

		try {
			// ask and connect to system socket resource
			socket = new java.net.ServerSocket(port);
			
			System.out.println("Server: Waiting until client connects.");
			// get client socket by server socket!
			clientSocket = socket.accept();
			System.out.println(
				"Server: Client connected with socket > " 
				+ clientSocket.toString()
			);



			System.out.println(
				"Server: Server waiting/reading message from client." 
			);
			// printing to client
			boolean flushWhenLineEnd = true;
			textWriterToClientSocket = new java.io.PrintWriter(
				clientSocket.getOutputStream(), 
				flushWhenLineEnd
			);
			textReaderFromClientSocket = new java.io.BufferedReader(
				new java.io.InputStreamReader(
					clientSocket.getInputStream()
				)
			);
			// server now can read message from client:
			String clientMessage = textReaderFromClientSocket.readLine();
			System.out.println(
				"Server: Server have read message form client > "
				+ clientMessage
			);



			System.out.println(
				"Server: Server will send message to client." 
			);
			// and server may now respond:
			textWriterToClientSocket.println(
				"Server: Server have your message, thanks!"
			);
			System.out.println(
				"Server: Server send message to client."
			);


			// end of talk, return resources:
			socket.close();
			clientSocket.close();
			textReaderFromClientSocket.close();
			textWriterToClientSocket.close();

		} catch (Throwable e) {
			System.out.println("Server: Error " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Server: goodby.");
	}

}
