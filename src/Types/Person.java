package Types;

/**
 * Created by lytte on 8/23/2016.
 */
public class Person {
    private char gender;
    private String fiName;
    private String laName;
    private String SSN;
    private String dateOB;

    public Person() {
        this.gender = 'n';
        this.fiName = "DefaultFirst";
        this.laName = "DefaultLast";
        this.SSN = "AAA-GG-SSSS";
        this.dateOB = "00/00/0000";
    }
    public Person(String fiName, String laName, char gender, String SSN, String dateOB) {
        this.fiName = fiName;
        this.laName = laName;
        this.gender = gender;
        this.SSN = SSN;
        this.dateOB = dateOB;
    }

    public void setLaName(String laName2) {
        this.laName=laName2;

    }
    public String getlaName() {
        return laName;
    }
    public void setFiName(String fiName2) {
        this.fiName=fiName2;
    }
    public String getfiName() {
        return fiName;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public char getGender() {
        return this.gender;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getDateOB() {
        return dateOB;
    }

    public void setDateOB(String dateOB) {
        this.dateOB = dateOB;
    }
    // cut

}
