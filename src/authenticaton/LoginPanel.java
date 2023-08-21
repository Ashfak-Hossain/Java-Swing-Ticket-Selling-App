package authenticaton;

import userDashBoard.DashBoard;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginPanel extends JPanel {

    /* Buttons */
    private final JButton signUpBtn;
    private final JTextField tEmail;
    private final JPasswordField pf;
    private final JLabel loginFailedMessage;

    /* initialized For panel change method */
    private int slideX = 0;
    private Timer slideTimer = new Timer(0, null);

    /* Association with Another Frame */
    private final AuthenticationPage authenticationPage;
    private DashBoard dashBoard;

    String extractedName = "";
    String extractedEmail = "";
    String extractedPassword = "";
    String extractedPhoneNumber = "";


    public LoginPanel(AuthenticationPage authenticationPage) {
        this.authenticationPage = authenticationPage;


        setLayout(null);

        /*
         * title
         */
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Cascadia code", Font.BOLD, 40));
        title.setSize(300, 60);
        title.setLocation(160, 30);
        add(title);

        /*
         * Email
         */
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Cascadia code", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(80, 130);
        add(email);

        /*
         * Email Field
         */
        tEmail = new JTextField();
        tEmail.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        tEmail.setSize(250, 40);
        tEmail.setLocation(78, 160);
        tEmail.setBorder(new MatteBorder(0, 0, 1, 0, new Color(70, 130, 169)));
        tEmail.setOpaque(false);
        add(tEmail);

        /*
         * Password
         */
        JLabel password = new JLabel("Password: ");
        password.setFont(new Font("Cascadia code", Font.PLAIN, 20));
        password.setSize(150, 20);
        password.setLocation(80, 230);
        add(password);

        /*
         * Password Field
         */
        pf = new JPasswordField();
        pf.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        pf.setSize(250, 40);
        pf.setLocation(78, 260);
        pf.setBorder(new MatteBorder(0, 0, 1, 0, new Color(70, 130, 169)));
        pf.setOpaque(false);
        add(pf);


        /*
         * SignUp Text
         */
        JLabel signUpText = new JLabel("Don't have an account ?");
        signUpText.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        signUpText.setSize(250, 40);
        signUpText.setLocation(78, 400);
        add(signUpText);

        /* Login Failed Message */

        loginFailedMessage = new JLabel("");
        loginFailedMessage.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        loginFailedMessage.setSize(250, 15);
        loginFailedMessage.setForeground(Color.RED);
        loginFailedMessage.setLocation(80, 470);
        add(loginFailedMessage);


        /*
         * SignUp Button
         */
        signUpBtn = new JButton("Sign Up");
        signUpBtn.setFont(new Font("Cascadia code", Font.PLAIN, 10));
        signUpBtn.setSize(80, 30);
        signUpBtn.setLocation(280, 405);
        signUpBtn.addActionListener(authenticationPage);
        add(signUpBtn);



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


    /* All login related task implemented here */

    public void performLogin(String email, String password) {
        boolean validCredentials = false;

        try {
            File file = new File("User.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.startsWith("Name: ")) {
                        extractedName = line.substring(6).trim();
                    } else if (line.startsWith("Email: ")) {
                        extractedEmail = line.substring(7).trim();
                    } else if (line.startsWith("PhoneNo: ")) {
                        extractedPhoneNumber = line.substring(9).trim();
                    } else if (line.startsWith("Pass: ")) {
                        extractedPassword = line.substring(6).trim();
                        break;
                    }
                }

                if (email.equals(extractedEmail) && password.equals(extractedPassword)) {
                    validCredentials = true;

                    System.out.println("User Found");


                    break;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        if (validCredentials) {
            System.out.println("Valid credentials. Logging in...");
            loginFailedMessage.setText("");

            /* Clear Fields after log in successfully */
            tEmail.setText("");
            pf.setText("");

            // After successful login, create  DashBoard

            /* Sending the loggedIn username, email and phone for showing in dashboard */

            dashBoard = new DashBoard(this, extractedName, extractedEmail, extractedPhoneNumber);
            dashBoard.setDashboardPageVisible(true);

            showDashboard();

        } else {
            loginFailedMessage.setText("Invalid Credentials !!");
        }
    }


    public void showDashboard() {
        dashBoard.setDashboardPageVisible(true); //Show the User Dashboard
        authenticationPage.setAuthVisible(false); // Hiding the Authentication page
    }

    public void showAuthenticationPage() {
        dashBoard.setDashboardPageVisible(false); //Hide the User Dashboard
        authenticationPage.setAuthVisible(true); // show the Authentication page
    }


    public JButton getSignUpButton() {
        return signUpBtn;
    }

    public void clearLoginFields() {
        tEmail.setText("");
        pf.setText("");
    }
}
