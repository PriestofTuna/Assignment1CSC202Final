package View;

import Exceptions.EmptyListException;
import Types.QueueListLinked;
import Types.User;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * Created by lytte on 9/1/2016.
 *
 */
public class ResultController implements Initializable {
    @FXML Label userInfo;
    @FXML Circle pictureCircle;
    @FXML ImageView imageThing;
    @FXML BorderPane scene;
    static String userString;
    static User user;
    static QueueListLinked<User> ActiveUsers = new QueueListLinked<>();
    static QueueListLinked<String> ActiveUsersNames = new QueueListLinked<>();
    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle) {
        //sets Label to Username
//        Rectangle cir = new Rectangle(10,10);
        try {
            userInfo.setText("Welcome " + userString + "!");

            Image image;

            image = new Image(user.getImageUrl());
//        imageThing.setLayoutX(1100);
//        imageThing.setLayoutY(100);
//        imageThing.setClip(cir);
            imageThing.setImage(image);
            if (ActiveUsers.size() > 5) {
                ActiveUsers.deQueue();
            }
            if(ActiveUsersNames.size()>5) {
                ActiveUsersNames.deQueue();
            }
            ActiveUsers.enQueue(user);
            ActiveUsersNames.enQueue(user.getUser());
        }catch (EmptyListException e){

        }
        }
    public static void SetUser(User userLogin) {
        user = userLogin;
    }
    public static void SetLbl(String username) {
        userString = username;
    }
    public void exit(ActionEvent actionEvent) {
        try {
            Main.changeScene("Login.fxml", actionEvent);
        }catch(IOException io) {

        }

    }

    public void showInfo(ActionEvent actionEvent) {
            userInfo.setText(ActiveUsers.toString());

        }
}
