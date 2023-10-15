package com.example.demo2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application {
    public void start(Stage primaryStage){
        TextArea ta = new TextArea();
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
        new Thread(()-> {
            try{
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(()->
                        ta.appendText("Server started at " + new Date() + '\n'));
                Socket socket = serverSocket.accept();
                ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());

                DataOutputStream outputToClient = new DataOutputStream (socket.getOutputStream());
                int x =0;
                while(true){
                    x++;
                    Object o = inputFromClient.readObject();
                    Packet p = (Packet)o;
                    String text = p.getData();
                    String TEXT = text.toUpperCase();
                    outputToClient.writeUTF(TEXT);
                    Platform.runLater(() ->{
                        ta.appendText("Recieving From Clients Packet's serialNo#"+ p.getSerialNo() +"and Packet's Date is "
                                + TEXT + '\n');
                        System.out.println(TEXT);
                    });

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }).start();
    }
}