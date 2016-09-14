package Types;

import javafx.scene.image.Image;
import java.io.*;

/**
 * Created by lytte on 8/23/2016.
 */
public class User extends Person {
    private String[] loginInfo;
    private String user;
    private String email;
    private String firmPassword;
    private String password;
    private String phoneNumber;
    private String imageUrl;
    private Image defaultImage = new Image("file:/C:/Users/lytte/OneDrive/Pictures/Saved%20Pictures/RandomTestPicture.jpg");
    private static File UserBase;

    static {
        //heh, Interesting
        UserBase = new File("UserBase");
        UserBase.mkdir();
    }
    public User(String username) throws  IOException{
        try {
            if (exists(username)) {
                File usernameFile = new File("UserBase", (username + ".dat"));
                String accountInfo[] = new String[10];
                DataInputStream inUser = new DataInputStream(new FileInputStream(usernameFile));
                for (int i = 0; i < 9; i++) {
                    if (accountInfo[i] == null) {
                        accountInfo[i] = " ";
                        //if its null, set it to empty
                    }
                    accountInfo[i] = inUser.readUTF();
                }
                accountInfo[9] = "" + inUser.readChar();
                loginInfo = accountInfo;
                setAll(loginInfo);
            }
        }catch(EOFException e) {
            System.out.println("Please no");
        }
    }

    public User(String fiName, String laName, String email, String user,
                String firmPassword, String password, String phoneNumber,
                String imageUrl, char gender, String dateOB, String SSN) {
        super(fiName, laName, gender, SSN, dateOB);
        this.user = user;
        this.email = email;
        this.firmPassword = firmPassword;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        //sets all values
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getpassword() {
        return password;
    }

    public void setFirmPassword(String firmPassword2) {
        this.firmPassword = firmPassword2;

    }

    public String getFirmPassword() {
        return firmPassword;
    }

    public void setEmail(String email2) {
        this.email = email2;

    }

    public String getEmail() {
        return email;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Image userImage() {
        if(getImageUrl().isEmpty()) {
            setImageUrl("file:/C:/Users/lytte/OneDrive/Pictures/Saved%20Pictures/RandomTestPicture.jpg");
            return new Image("file:/C:/Users/lytte/OneDrive/Pictures/Saved%20Pictures/RandomTestPicture.jpg");
        }
        return new Image(getImageUrl());
    }

    public void setAll(String[] all) {
        //sets all values to ones inside the file
        char gender = all[9].toCharArray()[0];
        setUser(all[0]);
        setEmail(all[1]);
        setPassword(all[2]);
        setPhoneNumber(all[3]);
        setImageUrl(all[4]);
        setFiName(all[5]);
        setLaName(all[6]);
        setSSN(all[7]);
        setDateOB(all[8]);
        setGender(gender);

    }
    public void writeToFile() throws IOException {
        File user = new File(UserBase.getName(), this.user + ".dat");
        //Creates a file ending with .dat for binary/UTF
        DataOutputStream outUser = new DataOutputStream(new FileOutputStream(user));
        outUser.writeUTF(this.user);
        outUser.writeUTF(this.email);
        outUser.writeUTF(this.password);
        outUser.writeUTF(this.phoneNumber);
        outUser.writeUTF(this.imageUrl.toString());
        outUser.writeUTF(this.getfiName());
        outUser.writeUTF(this.getlaName());
        outUser.writeUTF(this.getSSN());
        outUser.writeUTF(this.getDateOB());
        outUser.writeChar(this.getGender());
        //this is only the length of a char, others are byte length for strings
    }
    public static String[] readFilePartial(String username) throws IOException {
        //used to check account
        String usernameF = username + ".dat";
        File usernameFile = new File("UserBase", usernameF);
        String accountInfo[] = {"null", "null", "null"};
        if(exists(username)){
            DataInputStream inUser = new DataInputStream(new FileInputStream(usernameFile));
            accountInfo[0] = inUser.readUTF();
            //username
            accountInfo[2] = inUser.readUTF();
            //email
            accountInfo[1] = inUser.readUTF();
            //password, arranged in array Username, password, email.
        }
        return accountInfo;
    }

    public static boolean checkPasswords(String password, String firmPassword) {
        String patternPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,64}";
        if (!password.isEmpty()) {
            if (password.equals(firmPassword)) {
                if (password.matches(patternPass) && firmPassword.matches(patternPass)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean checkEmail(String email) {
        String pattern = "\\w+@\\w+\\.\\w+";
        if (!email.isEmpty()) {
            if (email.matches(pattern)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean exists(String user) {
        String userFile = user + ".dat";
        File userF = new File("UserBase", userFile);
        return userF.exists();
    }
    public String userInfo() {
        return(this.user + "\n" + this.email + "\n" +
                this.phoneNumber +  "\n" + this.imageUrl + "\n" + this.getfiName() + "\n" + this.getlaName() + "\n" + this.getGender() +
                "\n" + this.getSSN() + "\n" + this.getDateOB() + "\n");
    }
    public String[] getLoginInfo() {
        return loginInfo;
    }
}