package com.ricardo.hosoku;

import java.io.*;
import java.net.*;

public class TcpServer {

    public static void start() {
        int tcpPort = 8082;  // Port for TCP connections
        try (ServerSocket serverSocket = new ServerSocket(tcpPort)) {
            System.out.println("TCP Server listening on port " + tcpPort);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle TCP client requests in a new thread
    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (
                    InputStream inputStream = clientSocket.getInputStream();
                    OutputStream outputStream = clientSocket.getOutputStream()
            ) {
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    System.out.println("Received " + bytesRead + " bytes.");
                    // Send the same bytes back to the client (simple echo server)
                    outputStream.write(buffer, 0, bytesRead);
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
