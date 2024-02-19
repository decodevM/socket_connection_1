package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSide {
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                File socketFile = new File("src/main/resources/logs.txt");
                try(
                        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter socketOut = new PrintWriter(socket.getOutputStream(),true);
                        FileWriter fileWriter = new FileWriter(socketFile,true);
                ){
                    String message = null;
                    while((message = socketIn.readLine()) != null){
                        PrintWriter socketFileWriter = new PrintWriter(fileWriter);
                        System.out.println("Client -> " + message);
                        if(message.equalsIgnoreCase("turn off server")){
                            break;
                        }

                        socketFileWriter.println(message);
                        socketFileWriter.close();
                        socketOut.println("Next?");
                    }

                    if(message != null && message.equalsIgnoreCase("turn off server")){
                        socketOut.println("Goodbye");
                        break;
                    }

                    socketOut.close();
                    socketIn.close();
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}