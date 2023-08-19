package Authenticaton;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class SignUpPanel extends JPanel {

    public SignUpPanel() {

        //Selecting Layout to null
        setLayout(null);

        /*
         * SignUp Page title
         */
        JLabel title = new JLabel("SignUp");
        title.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 35));
        title.setSize(280, 50);
        title.setLocation(135, 20);
        add(title);

        /*
         * Signup page Name Label
         */
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        name.setSize(80, 15);
        name.setLocation(80, 90);
        add(name);

        /*
         * Sign Up page Name Field
         */
        JTextField tName = new JTextField();
        tName.setSize(250, 40);
        tName.setLocation(78, 110);
        tName.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0))); // Normally black without hover
        tName.setOpaque(false);
        add(tName);

        /*
         * Signup page Email Label
         */
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Arial", Font.PLAIN, 18));
        email.setSize(110, 15);
        email.setLocation(80, 180);
        add(email);

        /*
         * Sign up page Email Field
         */
        JTextField tEmail = new JTextField();
        tEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        tEmail.setSize(250, 40);
        tEmail.setLocation(78, 190);
        tEmail.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        tEmail.setOpaque(false);
        add(tEmail);

        /*
         * Sign Up page Date of Birth label
         */

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Arial", Font.PLAIN, 18));
        dob.setSize(110, 15);
        dob.setLocation(80, 260);
        add(dob);

        /*
         * Sign up page Date of Birth Field
         */
        DobPicker dobPicker = new DobPicker();
        dobPicker.setBounds(50, 290, 300, 50); // Adjust these values as needed
        add(dobPicker); // Add the DobPicker to the signUpPanel

        /*
         * Sign up page Phone Number Field
         */
        JLabel phoneNo = new JLabel("Phone No: ");
        phoneNo.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNo.setSize(110, 15);
        phoneNo.setLocation(80, 360);
        add(phoneNo);


        /*
         * Sign up panel Phone Number Field
         */

        JTextField TPhoneNo = new JTextField();
        TPhoneNo.setFont(new Font("Arial", Font.PLAIN, 15));
        TPhoneNo.setSize(250, 40);
        TPhoneNo.setLocation(78, 380);
        TPhoneNo.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        TPhoneNo.setOpaque(false);
        add(TPhoneNo);

        /*
         * Sign Up panel Sign Up Button
         */
        JButton SignUpBtn = new JButton("Sign Up");
        SignUpBtn.setSize(250, 40);
        SignUpBtn.setLocation(77, 430);
        add(SignUpBtn);

    }
}
