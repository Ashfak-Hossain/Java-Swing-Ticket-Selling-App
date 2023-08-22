package authenticaton;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.time.LocalDate;
import java.io.*;


public class SignUpPanel extends JPanel {


    private final JTextField tName;
    private final JTextField tEmail;
    private final DobPicker dobPicker;
    private final JTextField tPhoneNo;
    private final JLabel successMessage;
    private final JPasswordField tpassword;

    public SignUpPanel(AuthenticationPage authenticationPage) {

        //Selecting Layout to null
        setLayout(null);

        /*
         * SignUp Page title
         */
        JLabel title = new JLabel("SignUp");
        title.setFont(new Font("Cascadia code", Font.PLAIN, 35));
        title.setSize(280, 50);
        title.setLocation(135, 20);
        add(title);

        /*
         * Signup page Name Label
         */
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        name.setSize(80, 15);
        name.setLocation(80, 90);
        add(name);

        /*
         * Sign Up page Name Field
         */
        tName = new JTextField();
        tName.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        tName.setSize(250, 40);
        tName.setLocation(78, 110);
        tName.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0))); // Normally black without hover
        tName.setOpaque(false);
        add(tName);

        /*
         * Signup page Email Label
         */
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        email.setSize(110, 15);
        email.setLocation(80, 180);
        add(email);

        /*
         * Sign up page Email Field
         */
        tEmail = new JTextField();
        tEmail.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        tEmail.setSize(250, 40);
        tEmail.setLocation(78, 190);
        tEmail.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        tEmail.setOpaque(false);
        add(tEmail);

        /*
         * Sign Up page Date of Birth label
         */

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        dob.setSize(200, 15);
        dob.setLocation(80, 260);
        add(dob);

        /*
         * Sign up page Date of Birth Field
         */
        dobPicker = new DobPicker();
        dobPicker.setBounds(50, 290, 300, 50);
        dobPicker.setFont(new Font("Cascadia code", Font.PLAIN, 15));

        add(dobPicker); // Add the DobPicker to the signUpPanel

        /*
         * Sign up page Phone Number Label
         */
        JLabel phoneNo = new JLabel("Phone No: ");
        phoneNo.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        phoneNo.setSize(110, 15);
        phoneNo.setLocation(80, 350);
        add(phoneNo);


        /*
         * Sign up panel Phone Number Field
         */

        tPhoneNo = new JTextField();
        tPhoneNo.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        tPhoneNo.setSize(250, 40);
        tPhoneNo.setLocation(78, 355);
        tPhoneNo.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        tPhoneNo.setOpaque(false);
        add(tPhoneNo);


        /*
         * Sign up page password Label
         */
        JLabel password = new JLabel("Password: ");
        password.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        password.setSize(110, 15);
        password.setLocation(80, 420);
        add(password);


        /*
         * Sign up panel Password Field
         */

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        tpassword.setSize(250, 40);
        tpassword.setLocation(78, 425);
        tpassword.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        tpassword.setOpaque(false);
        add(tpassword);



        /*
         * Sign up page Success message Label
         */
        successMessage = new JLabel("");
        successMessage.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        successMessage.setSize(250, 15);
        successMessage.setForeground(Color.RED);
        successMessage.setLocation(80, 540);
        add(successMessage);



        /*
         * Sign Up panel Reset Button
         */
        JButton reset = new JButton("Reset");
        reset.setSize(100, 20);
        reset.setLocation(81, 510);
        reset.addActionListener(e -> clearSignUpFields());
        add(reset);

        /*
         * Sign Up panel Login Btn;
         */
        JButton loginBtn = new JButton("Log In");
        loginBtn.setSize(100, 20);
        loginBtn.setLocation(190, 510);
        loginBtn.addActionListener(e -> authenticationPage.switchToLoginPanel());
        add(loginBtn);


        JButton signUpBtn = new JButton("Sign Up");
        signUpBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));

        signUpBtn.setSize(250, 40);
        signUpBtn.setLocation(77, 465);
        signUpBtn.addActionListener(e -> {
            String sName = tName.getText();
            String sEmail = tEmail.getText();
            String sPhoneNo = tPhoneNo.getText();
            LocalDate sDob = dobPicker.getSelectedDate();
            char[] userPasswordChars = tpassword.getPassword();
            String sPassword = new String(userPasswordChars);

            String data = "Name: " + sName + "\n"
                    + "Email: " + sEmail + "\n"
                    + "PhoneNo: " + sPhoneNo + "\n"
                    + "Date of Birth: " + sDob + "\n"
                    + "Pass: " + sPassword + "\n";


            if (sName.isEmpty() || sEmail.isEmpty() || sPassword.isEmpty() || sPhoneNo.isEmpty() || sDob == null) {
                successMessage.setForeground(Color.RED);
                successMessage.setText("All Fields Required");
            } else {
                successMessage.setForeground(new Color(116, 155, 194));
                successMessage.setText("Registration Successful..");

                try {
                    FileWriter fw = new FileWriter("/Users/ashfakhossainevan/AIUB/Swing project/Ticket Selling App/src/User.txt", true);
                    fw.write(data);
                    fw.write(System.getProperty("line.separator"));
                    fw.write("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
                    fw.write(System.getProperty("line.separator"));
                    fw.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                clearSignUpFields();
                authenticationPage.switchToLoginPanel();
            }

        });
        add(signUpBtn);

    }

    // Exporting Values of fields
    public String getName() {
        return tName.getText();
    }

    public void clearSignUpFields() {
        tName.setText("");
        tEmail.setText("");
        dobPicker.resetDate();
        tPhoneNo.setText("");
    }
}
