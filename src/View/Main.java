package View;

import Types.User;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static User currentUser;
    static String username = "Karl";
    static Stage window;
    static Parent root;
    static String fxScene = "CreateAccount.fxml";
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        root = FXMLLoader.load(getClass().getResource(fxScene));
        window.setTitle("Sign up :D");
        window.setScene(new Scene(root, 600, 575));
        window.show();
    }


    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public static <T extends Event>  void changeScene(String fxmlFile, T e ) throws IOException{
        //uses T for different Action Events
        String title = fxmlFile;
        Parent root = FXMLLoader.load(Main.class.getResource(fxmlFile));
        //nope, here
        Stage primaryStage = (Stage)(((Node)e.getSource()).getScene().getWindow());
        //here?
        if(title.endsWith(".fxml")) {
            title.substring(0, title.length() -5);
            //changes title to fit for the window
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root, 600, 575));
        primaryStage.show();
    }
    public static void setFxScene(String fxScene1) {
        fxScene = fxScene1;
    }
    public static Stage getWindow() {
        return window;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
