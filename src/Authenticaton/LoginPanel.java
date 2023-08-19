package Authenticaton;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class LoginPanel extends JPanel {
    private final JButton signUpBtn;


    public LoginPanel(Authentication authenticationPage) {

        setLayout(null);

        /*
         * title
         */
        JLabel title = new JLabel("Login");
        title.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 40));
        title.setSize(300, 60);
        title.setLocation(160, 30);
        add(title);

        /*
         * Email
         */
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(80, 130);
        add(email);

        /*
         * Email Field
         */
        JTextField tEmail = new JTextField();
        tEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        tEmail.setSize(250, 40);
        tEmail.setLocation(78, 160);
        tEmail.setBorder(new MatteBorder(0, 0, 1, 0, new Color(70, 130, 169)));
        tEmail.setOpaque(false);
        add(tEmail);

        /*
         * Password
         */
        JLabel password = new JLabel("Password: ");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(80, 230);
        add(password);

        /*
         * Password Field
         */
        JPasswordField pf = new JPasswordField();
        pf.setFont(new Font("Arial", Font.PLAIN, 15));
        pf.setSize(250, 40);
        pf.setLocation(78, 260);
        pf.setBorder(new MatteBorder(0, 0, 1, 0, new Color(70, 130, 169)));
        pf.setOpaque(false);
        add(pf);


        /*
         * Login Button
         */
        JButton loginBtn = new JButton("Log In");
        loginBtn.setSize(250, 40);
        loginBtn.setLocation(77, 330);
        add(loginBtn);

        /*
         * SignUp Text
         */
        JLabel signUpText = new JLabel("Don't have an account ?");
        signUpText.setFont(new Font("Arial", Font.PLAIN, 15));
        signUpText.setSize(250, 40);
        signUpText.setLocation(78, 400);
        add(signUpText);

        /*
         * SignUp Button
         */


        signUpBtn = new JButton("Sign Up");
        signUpBtn.setSize(80, 30);
        signUpBtn.setLocation(250, 405);
        signUpBtn.addActionListener(authenticationPage);
        add(signUpBtn);

    }

    public JButton getSignUpButton() {
        return signUpBtn;
    }
}
