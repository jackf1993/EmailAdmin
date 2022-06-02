import java.util.Objects;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int passwordLength =10;
    private String department;
    private String email;
    private int emailCapacity = 500;
    private String companySuffix = "anycompany.com";
    private int mailboxCapacity;
    private String alternateEmail;

    //constructor to receive first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // call method asking for department, return the department
        this.department = setDepartment();

        // call a method to return a random password
        this.password = randomPassword(passwordLength);
        System.out.println("Your Password is: " +this.password);

        // combine elements to generate email
        if(!Objects.equals(department, "")) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        }
        else{
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"  + companySuffix;
        }
    }

    // Ask for the department
    private String setDepartment(){
        System.out.print("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if(departmentChoice ==1) return "sales";
        else if(departmentChoice ==2) return "dev";
        else if(departmentChoice == 3) return "acct";
        else return "";
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        char [] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }

    // set the mailbox capacity
    public void setEmailCapacity(int emailCapacity) {
        this.emailCapacity = emailCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void setChangePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity(){
       return emailCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getNewPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: "+ firstName + " " + lastName+
                "\nComapny Email: " + email +
                "\nMailbox Capacity: " + emailCapacity +" mb";
    }
}
