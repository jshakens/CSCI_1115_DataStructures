import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Exercise31_09Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    taClient.setDisable(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taClient));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taServer));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 400, 400);
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    new Thread(() -> {
      try {
        connectToClient();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }).start();
  }
  public void connectToClient() throws IOException {
    ServerSocket serverSocket = new ServerSocket(8000);
    Platform.runLater(()->
            taClient.appendText("Exercise31_09 Server Started at "+ new Date()+ '\n'));
    Socket socket = serverSocket.accept();
    DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
    DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

    taServer.setOnKeyPressed(event -> {
      System.out.println(event.getCode());
      if (event.getCode()== KeyCode.ENTER){
          try {
            outputToClient.writeUTF(taServer.getText().trim());
            taClient.appendText("\nS:"+taServer.getText());
            outputToClient.flush();
            taServer.clear();
          } catch (IOException e) {
            e.printStackTrace();
          }
      }
    });

    while (true){
      String history = inputFromClient.readUTF();
      Platform.runLater(()->{
      taClient.appendText("\nC:"+history.trim());});
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
