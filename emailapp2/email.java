package emailapp2;

import java.util.Scanner;
import java.text.Normalizer;

public class email {
    
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String email;
    private String company = "devcompany.com";
      
        
    public email() {        
        this.lastName = lastName();
        this.firstName = firstName();
        this.department = department();
        this.password = password(defaultPasswordLength);
        this.email = email();
    }
        
    // Determine the department (sales, development, accounting), if none leave blank    
    private String department() {
        System.out.println("\nAz új dolgozó: " + lastName + " " + firstName + "\nKérem válasszon osztályt: \n 1. Értékesítés \n 2. Fejlesztés \n 3. Könyvelés \n 4. Nem tartozom egy osztályhoz sem");
        Scanner be = new Scanner(System.in);
        int choose = be.nextInt();
        if (choose == 1) {
            return "Sales";
        } else if (choose == 2) {
            return "Development";
        } else if (choose == 3) {
            return "Accounting";
        } else {
            return "none";
        }
    }
    
    private String lastName() {
        System.out.println("Kérem adja meg a vezetéknevét:");
        Scanner be = new Scanner(System.in);
        String lastName = be.next();
        return lastName;
    }
        
    private String firstName() {
        System.out.println("Kérem adja meg a keresztnevét:");
        Scanner be = new Scanner(System.in);
        String firstName = be.next();
        return firstName;
    }
    
    private String email() {  
        return email = lastName.toLowerCase() + "." + firstName.toLowerCase() + "@" + department.toLowerCase() + "." + company;        
    }
    
    // Generate a random String for a password    
    private String password(int length) {
        String passwordSet = "AÁBCDEÉFGHJIÍKLMNOÓÖŐUÚÜŰPQRSTVWXYZ0123456789^@&$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);        
    }
    
    //setters
    public void setMailBoxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }
    
    public void setchangePassword(String password) {
        this.password = password;
    }
    
    
    //getters
    public int getMailBoxCapacity() {
        return mailboxCapacity;
    }
    
    public String getAlternateEmail() {
        return alternateEmail;
    }
    
    public String getPassword() {
        return password;
    }
    //name, email, and mailbox capacity
    public String showInfo() {
        email = Normalizer.normalize(email, Normalizer.Form.NFD);
        email = email.replaceAll("\\p{M}", "");
        return "Név: " + lastName + " " + firstName +
               "\nJelszó: " + password +
               "\nOsztály: " + department +
               "\nCéges e-mail: " + email +
               "\nE-mail tárhely: " + mailboxCapacity + " MB\n";
    }
    
}
