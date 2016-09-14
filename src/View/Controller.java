package View;

import Types.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static javafx.scene.paint.Color.rgb;

public class Controller {

    @FXML TextField fNameI;

    @FXML TextField lNameI;

    @FXML TextField SSNI;

    @FXML TextField dateofBirthI;

    @FXML TextField usernameI;

    @FXML PasswordField passwordI;

    @FXML PasswordField firmPasswordI;

    @FXML TextField emailI;

    @FXML TextField phoneNumberI;

    @FXML ComboBox<String> genderI;

    @FXML Label passwordInfoLabel;

    @FXML Label emailInfoLabel;

    @FXML Label urlLbl;

    @FXML Label usernameTaken;

    @FXML Button imageURLI;
    char gender = 'n';
    String fNameIText = "";
    boolean isfNameFilled = false;
    String lNameIText = "";
    boolean islNameFilled = false;
    String SSNIText = "";
    boolean isSSNFilled = false;
    String dateofBirthIText = "";
    boolean isDateOfBirthFilled = false;
    String usernameIText = "";
    boolean isUsernameFilled = false;
    String passwordIText = "";
    boolean isPasswordCorrect = false;
    String firmPasswordIText = "";
    boolean isfirmPasswordICorrect = false;
    String emailIText = "";
    boolean isEmailCorrect = false;
    String phoneNumberIText = "";
    boolean isPhoneNumberITextFilled = false;
    String imageURL = "";
    boolean genderSelected = true;
    public void UnFilled(TextField unFilled) {
        unFilled.setStyle("-fx-border-color: crimson");
        unFilled.setPromptText("Hey! Don't leave me hanging!");
    }
    public void Filled(TextField filled) {
        filled.setPromptText("");
        filled.setStyle("-fx-border-color: null");
    }

    public void letterRegFN(KeyEvent keyEvent) {
        fNameIText = fNameI.getText()+ keyEvent.getCharacter();
        if(!fNameIText.isEmpty()) {
            isfNameFilled = true;
            Filled(fNameI);
        }else {
            UnFilled(fNameI);
            isfNameFilled = false;
        }
    }

    public void letterRegLN(KeyEvent keyEvent) {
        lNameIText = lNameI.getText()+ keyEvent.getCharacter();
        if(!lNameIText.isEmpty()) {
            islNameFilled = true;
        }else {
            islNameFilled = false;
        }

    }

    public void letterRegSSN(KeyEvent keyEvent) {
        SSNIText = SSNI.getText()+ keyEvent.getCharacter();
        if(!SSNIText.isEmpty()) {
            isSSNFilled = true;
        }else{
            isSSNFilled = false;
        }
    }

    public void letterRegDoB(KeyEvent keyEvent) {
        dateofBirthIText = dateofBirthI.getText()+ keyEvent.getCharacter();
        if(!dateofBirthIText.isEmpty()) {
            isDateOfBirthFilled = true;
        }else{
            isDateOfBirthFilled = false;
        }
    }

    public void letterRegUser(KeyEvent keyEvent) {
        usernameIText = usernameI.getText()+ keyEvent.getCharacter();
        if(!usernameIText.isEmpty()) {
            isUsernameFilled = true;
        }else{
            isUsernameFilled = false;
        }
    }

    public void letterRegPass(KeyEvent keyEvent) {
        passwordIText = passwordI.getText() + keyEvent.getCharacter();
        isPasswordCorrect = User.checkPasswords(passwordIText, firmPasswordIText);
        isfirmPasswordICorrect = User.checkPasswords(passwordIText, firmPasswordIText);
        if(isPasswordCorrect && isfirmPasswordICorrect) {
            passwordInfoLabel.setText("Good Password!");
            passwordInfoLabel.setTextFill(rgb(255,255,254));
        }else{
            passwordInfoLabel.setText("Password must match and be 8-64 char and contain one of each: a-z, A-Z, 0-9, special char");
            passwordInfoLabel.setTextFill(rgb(255,0,0));
        }
    }

    public void letterRegFPass(KeyEvent keyEvent) {
        firmPasswordIText = firmPasswordI.getText() + keyEvent.getCharacter();
        isfirmPasswordICorrect = User.checkPasswords(passwordIText, firmPasswordIText);
        isPasswordCorrect = User.checkPasswords(passwordIText, firmPasswordIText);
        if(isPasswordCorrect && isfirmPasswordICorrect) {
            passwordInfoLabel.setText("Good Password!");
            passwordInfoLabel.setTextFill(rgb(255,255,255));
        }else{
            passwordInfoLabel.setText("Password must match and be 8-64 char and contain one of each: a-z, A-Z, 0-9, special char");
            passwordInfoLabel.setTextFill(rgb(255,0,0));
        }
    }


    public void letterRegEmail(KeyEvent keyEvent) {
        emailIText = emailI.getText()+ keyEvent.getCharacter();
        isEmailCorrect = User.checkEmail(emailIText);
        if(isEmailCorrect) {
            emailInfoLabel.setText("Good Email");
            emailInfoLabel.setTextFill(rgb(255,255,255));
        }else{
            emailInfoLabel.setText("Must contain @/. I.E you@name.com");
            emailInfoLabel.setTextFill(rgb(255,0,0));
        }
    }

    public void letterRegPhone(KeyEvent keyEvent) {
        phoneNumberIText = phoneNumberI.getText()+ keyEvent.getCharacter();
        if(!phoneNumberIText.isEmpty()) {
            isPhoneNumberITextFilled = true;
        }else{
            isPhoneNumberITextFilled = false;
        }
    }


    public void imageFocus(ActionEvent actionEvent) {

        try{
            Stage primaryStage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
            FileChooser filer = new FileChooser();
            filer.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            filer.setTitle("Nyhaha");
            File file;
            file = filer.showOpenDialog(primaryStage);
            //file becomes the File in the FileChooser, and then gives imageURL the path
            imageURL = file.toURI().toString();
            if (imageURL.endsWith(".jpg") | imageURL.endsWith(".png") | imageURL.endsWith(".gif")) {
                //Instead this should be filed into User, and put into a round ImageView
                imageURLI.setGraphicTextGap(10);

                ImageView profile = new ImageView(new Image(file.toURI().toString()));
                profile.setFitWidth(30);
                profile.setFitHeight(38);
                urlLbl.setText(imageURL);
                urlLbl.setOpacity(1);
                imageURLI.setGraphic(profile);
            } else {
                urlLbl.setText("That's not a valid image, make sure it ends with .jpg, .png, or .gif");
            }
        }catch(NullPointerException nullImage) {
            urlLbl.setText("Not a valid image!! :(");
            urlLbl.setOpacity(1);
        }

    }

    public void accountCreate(ActionEvent actionEvent) {
            String selected = genderI.getValue();
            emailIText = emailI.getText();
        //depending on genderI's value, it will set gender to a char, or halt the account's creation.
        if(selected == null) {
            genderI.setValue("Blank");
            gender = 'n';
            genderI.setStyle("-fx-background-color: red");
            genderSelected = false;
        } else if (selected.equals("Male")) {
                gender = 'm';
                genderI.setStyle("-fx-background-color: white");
                genderSelected = true;
            } else if (selected.equals("Female")) {
                genderI.setStyle("-fx-background-color: white");
                gender = 'f';
                genderSelected = true;
            } else if (selected.equals("Blank")) {
                genderI.setStyle("-fx-background-color: white");
                gender = 'n';
                genderSelected = true;
            }
            if (!User.exists(usernameIText)) {
                //if it doesn't exist, check to see if it can be created, and set defaults for optional values if empty.
                usernameTaken.setTextFill(rgb(255,255,255));
                usernameTaken.setOpacity(0);
                if (genderSelected && isPasswordCorrect && ((isEmailCorrect | emailIText.isEmpty() | emailIText.equals("\u0002"))) && isfirmPasswordICorrect && isUsernameFilled && isDateOfBirthFilled && isfNameFilled && islNameFilled && isPhoneNumberITextFilled) {
                    if(emailIText.isEmpty()) {
                        emailIText = "DefaultEmail@Account.com";
                    }
                    if(SSNIText.isEmpty()) {
                        SSNIText = "DefaultSSN";
                    }
                    if(imageURL.isEmpty()) {
                        imageURL = "file:/C:/Users/lytte/OneDrive/Pictures/Saved%20Pictures/RandomTestPicture.jpg";
                    }

                    User user = new User(fNameIText, lNameIText,
                            emailIText, usernameIText, firmPasswordIText, passwordIText,
                            phoneNumberIText, imageURL, gender, dateofBirthIText, SSNIText);
                    //if all the information is correct for its fields, create a new user and then write it to file
                    try {
                        user.writeToFile();
                        Main.currentUser = user;
                        Main.username = user.getUser();
                        ResultController.SetLbl(Main.username);
                        ResultController.SetUser(Main.currentUser);
                        //sets the ResultController values
                        usernameTaken.setTextFill(rgb(255,255,255));
                        usernameTaken.setOpacity(0);
                        Main.changeScene("Result.fxml", actionEvent);
                    } catch (IOException io) {
                    System.out.println(io.getCause() + "\n" + io.getStackTrace());
                    }
                } else {
                    //checks each field and styles it according to whether or not its correct
                    if(isUsernameFilled){
                        Filled(usernameI);
                    } else {
                        UnFilled(usernameI);
                    }
                    if(isfNameFilled){
                        Filled(fNameI);
                    } else {
                        UnFilled(fNameI);
                    }
                    if(islNameFilled){
                        Filled(lNameI);
                    } else {
                        UnFilled(lNameI);
                    }
                    if(isDateOfBirthFilled){
                        Filled(dateofBirthI);
                    } else {
                        UnFilled(dateofBirthI);
                    }
                    if(isPasswordCorrect) {
                        Filled(passwordI);
                        Filled(firmPasswordI);
                    } else {
                        UnFilled(passwordI);
                        UnFilled(firmPasswordI);
                    }
                    if(isEmailCorrect | emailIText.isEmpty() | emailIText.equals("") | emailIText.equals("")){
                        Filled(emailI);
                    } else {
                        System.out.println(emailIText);
                        UnFilled(emailI);
                    }
                }
            } else {
                //tells the user that the Username is taken
                usernameTaken.setTextFill(rgb(255,0,0));
                usernameTaken.setOpacity(1);
            }
    }
    public void loginUser(ActionEvent actionEvent) {
        try {
            Main.changeScene("Login.fxml", actionEvent);
        }catch(IOException nyah) {
            System.out.println("Failure");
        }
        }

    public void genderFocus(MouseEvent mouseEvent) {
        genderI.requestFocus();
    }
}
