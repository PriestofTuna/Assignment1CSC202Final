package Types;

import java.io.*;

/**
 * Created by lytte on 8/23/2016.
 */
public class User extends Person {

    private String user;
    private String email;
    private String firmPassword;
    private String password;
    private String phoneNumber;
    private String imageUrl;
    private static File UserBase;

    static {
        //heh, Interesting
        UserBase = new File("UserBase");
        UserBase.mkdir();
    }

    public User(String fiName, String laName, String email, String user,
                String firmPassword, String password, String phoneNumber, String imageUrl, char gender, String dateOB, String SSN) {
        super(fiName, laName, gender, SSN, dateOB);
        this.user = user;
        this.email = email;
        this.firmPassword = firmPassword;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
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
        //end of confirmed password
    }
    public void setEmail(String email2) {
        this.email = email2;

    }
    public String getEmail() {
        return email;
    }
    //end of email
    public void setUser(String user) {
        this.user=user;
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

    public void WritetoFile() throws IOException {
        File user = new File(UserBase.getName(), this.user +".dat");
        //Next Step, convert all of the elements of the User to the File, a binary File, also Encrypt password.
        //Come on, I know its extra work, but you can manage :P
        DataOutputStream outUser = new DataOutputStream(new FileOutputStream(user));
        outUser.writeBytes(this.user);
        outUser.writeBytes(this.email);
        outUser.writeUTF(this.password);
        outUser.writeUTF(this.phoneNumber);
        outUser.writeUTF(this.imageUrl);
        outUser.writeUTF(this.getfiName());
        outUser.writeUTF(this.getlaName());
        outUser.writeChar(this.getGender());
        //this is only the length of a char, others are byte length for strings
        outUser.writeUTF(this.getSSN());
        outUser.writeUTF(this.getDateOB());

//        String defaultThing =  (this.user + "\n" + this.email + "\n" + this.password + "\n" +
//                this.phoneNumber + "\n" + this.getfiName() + "\n" + this.getlaName() + "\n" + this.getGender() +
//                "\n" + this.getSSN() + "\n" + this.getDateOB() + "\n");
    }
}