package Authenticaton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentication extends JFrame implements ActionListener {

    //For Card Layout panels
    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    /* Login and Sign up and Logo Panel */
    SignUpPanel signUpPanel = new SignUpPanel();
    LoginPanel loginPanel = new LoginPanel(this);
    JPanel logoPanel = new JPanel(new GridBagLayout());

    /* Slide For Animation */
    private int slideX = 0; // position for sliding animation
    private Timer slideTimer; // Timer for the sliding animation

    public Authentication() {
        /*
         * Frame
         */
        setTitle("Cineplex");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        /*
         * Containers
         */
        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2));

        /*
         * Card Panel and  Layout
         */
        cardPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cardPanel.getLayout();

        /* * Theatre Photo */
        ImageIcon imageIcon = new ImageIcon("logo.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(470, 230, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);
        JLabel logoLabel = new JLabel(newImageIcon);
        logoPanel.add(logoLabel);


        /*
         * Add login and signup Panels to the Card Panel
         */
        cardPanel.add(loginPanel, "login");
        cardPanel.add(signUpPanel, "signup");

        /*
         * Adding Panels to the Container
         */
        container.add(cardPanel);
        container.add(logoPanel);

        /* Frame Visible */
        setVisible(true);
    }

    /* Animation slide */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginPanel.getSignUpButton()) {
            /*
             * Getting the signup btn of login page,
             * which is actually a button for Sliding the panel
             */
            slideX = 0;
            slideTimer = new Timer(5, e2 -> {
                slideX += 10;
                if (slideX > loginPanel.getWidth()) {
                    slideTimer.stop();
                    cardPanel.add(signUpPanel, "signup"); // Add the sign-up panel to cardPanel
                    cardLayout.show(cardPanel, "signup");
                }
                loginPanel.setLocation(-slideX, loginPanel.getY()); // Adjusted the x position only
            });
            slideTimer.start();
        }


    }
}
