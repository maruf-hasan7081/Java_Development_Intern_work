//Task 2: Multithreaded Chat Application
//Description: Create a console-based chat application that allows multiple users to chat with each other via multithreading.
// Objectives:
//Implement server and client classes using Java Sockets for networking.
//Use threads to manage multiple clients simultaneously.
//Broadcast messages from one client to all connected clients.


import java.io.*;
import java.net.*;
import java.util.*;

public class L3task2 {
    private static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start as server or client? (s/c)");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("s")) {
            startServer();
        } else if (choice.equalsIgnoreCase("c")) {
            startClient();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    
    private static void startServer() {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
    private static void startClient() {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

           
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

           
            while (true) {
                String text = sc.nextLine();
                out.println(text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static List<ClientHandler> clients = L3task2.clients;

    ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { socket.close(); } catch (IOException e) { e.printStackTrace(); }
            clients.remove(this);
        }
    }

    private void broadcast(String message) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != this) {
                    client.out.println(message);
                }
            }
        }
    }
}
