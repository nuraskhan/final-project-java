package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
    ObjectOutputStream toServer = null;
    DataInputStream fromServer = null;
    public void start(Stage primaryStage){
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter a text: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();
        final int[] a = {0};
        tf.setOnAction(e->{
            try{
                a[0]++;
                String text = tf.getText().trim();
                if(!text.equals("")){
                    Packet packet = new Packet(a[0],text);
                    toServer.writeObject(packet);
                    toServer.flush();

                    if(fromServer.toString() != null){
                        ta.appendText("FROM SERVER: Packet SerialNo#"+a[0]+" is recieved\n");
                    }
                }else{
                    System.out.println("text should not be equal to null");
                }



            }catch (IOException ex){
                System.err.println(ex);
            }
        });
        try{
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new ObjectOutputStream(socket.getOutputStream());
        }catch (IOException ex){
            ta.appendText(ex.toString() + '\n');
        }
    }
}