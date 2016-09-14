package View;

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
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle) {
        //sets Label to Username
        userInfo.setText("Welcome " + userString + "!");
        Image image;
            image = new Image(user.getImageUrl());
            imageThing.setImage(image);
        }
    public static void SetUser(User userLogin) {
        user = userLogin;
    }
    public static void SetLbl(String username) {
        userString = username;
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
