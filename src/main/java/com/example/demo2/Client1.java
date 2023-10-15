package com.example.demo2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    static PrintWriter output;
    static Scanner input;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("nuraskhan", 8000);
        output = new PrintWriter(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the data packet:");
            String text = scan.nextLine();

            output.println(text);
            output.flush();
            System.out.println("Server: " + input.nextLine());
        }
    }
}