package authenticaton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticationPage extends JFrame implements ActionListener {

    /* Login and Sign up and Logo Panel */

    SignUpPanel signUpPanel;
    LoginPanel loginPanel;

    // For Card Layout panels
    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    public AuthenticationPage() {

        /* Login and Sign up and Logo Panel */
        signUpPanel = new SignUpPanel(this);
        loginPanel = new LoginPanel(this);
        JPanel logoPanel = new JPanel(new GridBagLayout());

        /*
         * Frame
         */
        setTitle("Paradise Theatre");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        /*
         * Containers
         */
        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2));

        /*
         * Card Panel and Layout
         */
        cardPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cardPanel.getLayout();

        /* * Theatre Photo */
        ImageIcon imageIcon = new ImageIcon("/Users/ashfakhossainevan/AIUB/Swing project/Ticket Selling App/logo.png");
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

    /* To change The Panel */
    public void switchToLoginPanel() {
        cardLayout.show(cardPanel, "login");
        loginPanel.clearLoginFields();
    }

    public void setAuthVisible(boolean b) {
        setVisible(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* Animation slide */
        if (e.getSource() == loginPanel.getSignUpButton()) {
            loginPanel.changeLoginPanel(cardLayout, cardPanel, signUpPanel);
        }
    }
}
