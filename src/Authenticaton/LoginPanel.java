package Authenticaton;

import User_DashBoard.DashBoard;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginPanel extends JPanel {
    private final JButton signUpBtn;
    private final JTextField tEmail;
    private final JPasswordField pf;
    private final JLabel loginFailedMessage;

    /* initialized For panel change method */
    private int slideX = 0;
    private Timer slideTimer = new Timer(0, null);

    /* Association with Another Frame */
    private final AuthenticationPage authenticationPage;


    public LoginPanel(AuthenticationPage authenticationPage) {
        this.authenticationPage = authenticationPage;


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
        tEmail = new JTextField();
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
        pf = new JPasswordField();
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
        loginBtn.addActionListener(e -> {
            String userEmail = tEmail.getText();
            char[] userPasswordChars = pf.getPassword();
            performLogin(userEmail, new String(userPasswordChars));
        });
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

        /* Login Failed Message */
        loginFailedMessage = new JLabel("");
        loginFailedMessage.setFont(new Font("Arial", Font.PLAIN, 15));
        loginFailedMessage.setSize(250, 15);
        loginFailedMessage.setForeground(Color.RED);
        loginFailedMessage.setLocation(80, 470);
        add(loginFailedMessage);

    }

    /* Login Panel Change */
    public void changeLoginPanel(CardLayout cardLayout, JPanel cardPanel, SignUpPanel signUpPanel) {
        slideX = 0;
        slideTimer.stop();
        slideTimer = new Timer(5, e -> {
            slideX += 10;
            if (slideX > getWidth()) {
                slideTimer.stop();
                cardPanel.add(signUpPanel, "signup");
                cardLayout.show(cardPanel, "signup");
            }
            setLocation(-slideX, getY());
        });
        slideTimer.start();
    }


    public void performLogin(String email, String password) {
        boolean validCredentials = false;

        try {
            File file = new File("User.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Email: ")) {
                    String extractedEmail = line.substring(7).trim(); // find the exact email
                    line = scanner.nextLine();
                    if (line.startsWith("Pass: ")) {
                        String extractedPassword = line.substring(6).trim(); // find the exact password
                        if (extractedEmail.equals(email) && extractedPassword.equals(password)) {
                            validCredentials = true;
                            System.out.println("Found");
                            break;
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        if (validCredentials) {
            System.out.println("Valid credentials. Logging in...");
            loginFailedMessage.setText("");
            authenticationPage.showDashboard();
        } else {
            loginFailedMessage.setText("Invalid Credentials !!");
        }
    }


    public JButton getSignUpButton() {
        return signUpBtn;
    }

    public void clearLoginFields() {
        tEmail.setText("");
        pf.setText("");
    }
}
