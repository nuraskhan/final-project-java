package com.example.demo2;

import javafx.application.Platform;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server1 {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        Scanner scan = new Scanner(socket.getInputStream());
        PrintWriter output = new PrintWriter(socket.getOutputStream());
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            System.out.println("Clients:"+scan.nextLine());
            System.out.print("Server:");
            String a = input.nextLine();
            output.println(a);
            output.flush();
        }
        output.close();
        scan.close();
        socket.close();
        serverSocket.close();

    }
}