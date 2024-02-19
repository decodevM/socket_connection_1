package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientSide {
    public static void main(String[] args) {
        // Initialize a socket with the server's IP address and port number
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Write something:");
            String message;
            // Continuously read user input until it equals "exit" or is null
            while ((message = userInput.readLine()) != null) {
                if(message.equalsIgnoreCase("turn off server")){
                    // Send "turn off server" to the server to indicate termination
                    socketOut.println("turn off server");
                    System.out.println("Server -> " + socketIn.readLine());
                    break;
                }
                // Terminate only client side
                if(message.equalsIgnoreCase("exit")){
                    break;
                }

                if (!message.trim().isEmpty()) {
                    socketOut.println(message);
                    System.out.println("Server -> " + socketIn.readLine());
                }
                System.out.print("Write something: ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
