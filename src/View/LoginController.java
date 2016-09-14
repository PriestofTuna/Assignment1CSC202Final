package View;

import Types.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Created by lytte on 9/5/2016.
 */
public class LoginController {
    @FXML
    TextField usernameI;
    @FXML
    TextField passwordI;
    @FXML
    Label incorrect;
    public void login(ActionEvent actionEvent) {
        String usernameIT = usernameI.getText();
        String passwordIT = passwordI.getText();
            if(!usernameI.getText().isEmpty() & !passwordI.getText().isEmpty()) {
                if(User.exists(usernameIT)) {
                    try {
                        String details[] = User.readFilePartial(usernameIT);
                        if(usernameIT.equals(details[0]) & passwordIT.equals(details[1])) {
                            incorrect.setText("Username or password is incorrect");
                            incorrect.setOpacity(0.00);
                            //if its correct, sets the label back to default, makes it invisible and
                            User user = new User(usernameIT);
                            Main.currentUser =  user;
                            Main.username = user.getUser();
                            ResultController.SetUser(Main.currentUser);
                            ResultController.SetLbl(Main.username);
                            Main.changeScene("Result.fxml", actionEvent);
                            //set scene to result
                        } else {
                            incorrect.setText("Username or password is incorrect");
                            incorrect.setOpacity(1.00);
                        }

                    } catch (IOException io) {
                        System.out.println(io.getCause() + " Hm" + "\n" + io.getCause() + "\n" + io.getMessage());
                    }
                }else {
                    incorrect.setText("Username doesn't exist! Try creating an account");
                    incorrect.setOpacity(1.00);
                }
            }else {
                incorrect.setText("Fields cannot be empty");
                incorrect.setOpacity(1.00);
            }
    }

    public void signUp(MouseEvent mouseEvent) {
        //back to sign up page
        try {
            Main.changeScene("CreateAccount.fxml", mouseEvent);
        }catch(IOException io) {

        }
        }
}
