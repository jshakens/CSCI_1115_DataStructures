// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise31_01Server extends Application {
  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);

    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    new Thread(() -> connectToClient()).start();
  }

  public void connectToClient() {
    try {
      ServerSocket serverSocket = new ServerSocket(8000);
      Platform.runLater(()->
              ta.appendText("Exercise31_01Server Started at "+ new Date()+ '\n'));
      Socket socket = serverSocket.accept();
      DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

      while (true) {
        int numOfYears = (int) inputFromClient.readDouble();
        double loanAmount = inputFromClient.readDouble();
        double annualInterest = inputFromClient.readDouble();
        Loan loan = new Loan(annualInterest, numOfYears,loanAmount);
        double monthlyPayment = loan.getMonthlyPayment();
        outputToClient.writeDouble(monthlyPayment);
        double totalPayments = loan.getTotalPayment();
        outputToClient.writeDouble(totalPayments);
        Platform.runLater(() ->{
          ta.appendText("Annual Interest Rate: "+ annualInterest + "\nNumber of Years: "+numOfYears +
                  "\nLoan Amount: "+loanAmount);
          ta.appendText("\nmonthly payments: "+ monthlyPayment+ ""+ "\ntotal Payement: "+
                  totalPayments + "\n");
                }
                );
      }
    } catch (IOException e) {
      e.printStackTrace();
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
