package userDashBoard;

import authenticaton.LoginPanel;
import models.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener {

    /* Buttons */
    private final JButton profileBtn;
    private final JButton showTimesBtn;
    private final JButton ticketPriceBtn;
    private final JButton aboutUsBtn;
    private final JButton logOutBtn;
    private final JButton buyBtn;

    /* Panels */
    UserProfilePanel userProfilePanel;
    ShowTimesPanel showTimesPanel;
    TicketPricePanel ticketPricePanel;
    AboutUsPanel aboutUsPanel;
    LoginPanel loginPanel;

    public DashBoard(LoginPanel loginPanel, String name, String email, String phone) {

        this.loginPanel = loginPanel;

        userProfilePanel = new UserProfilePanel(name, email, phone);

        /* Frame */
        setTitle("User DashBoard");

        setBounds(120, 90, 1200, 720);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);

        /* Container */
        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(116, 155, 194));

        /* Logo */
        ImageIcon imageIcon = new ImageIcon("/Users/ashfakhossainevan/AIUB/Swing project/untitled/logo.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(320, 150, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);
        JLabel logoLabel = new JLabel(newImageIcon);
        logoLabel.setBounds(5, 5, 340, 150);
        container.add(logoLabel);

        /* ========================= Buttons ========================= */

        /* Profile Button */
        profileBtn = new JButton("Profile");
        profileBtn.setBounds(70, 200, 200, 40);
        profileBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        profileBtn.setFocusPainted(false);
        profileBtn.addActionListener(this);
        container.add(profileBtn);

        /* ShowTime Button */
        showTimesBtn = new JButton("Movie Show");
        showTimesBtn.setBounds(70, 270, 200, 40);
        showTimesBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        showTimesBtn.setFocusPainted(false);
        showTimesBtn.addActionListener(this);
        container.add(showTimesBtn);

        /* Ticket Price Button */
        ticketPriceBtn = new JButton("Ticket Price");
        ticketPriceBtn.setBounds(70, 340, 200, 40);
        ticketPriceBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        ticketPriceBtn.setFocusPainted(false);
        ticketPriceBtn.addActionListener(this);
        container.add(ticketPriceBtn);

        /* About Us Button */
        aboutUsBtn = new JButton("About Us");
        aboutUsBtn.setBounds(70, 410, 200, 40);
        aboutUsBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        aboutUsBtn.setFocusPainted(false);
        aboutUsBtn.addActionListener(this);
        container.add(aboutUsBtn);

        /* Log Out Button */
        logOutBtn = new JButton("Log Out");
        logOutBtn.setBounds(70, 480, 200, 40);
        logOutBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        logOutBtn.setFocusPainted(false);
        logOutBtn.addActionListener(this);
        container.add(logOutBtn);

        /* Buy Ticket Button */
        buyBtn = new JButton("Buy Ticket");
        buyBtn.setBounds(900, 20, 200, 40);
        buyBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        buyBtn.setFocusPainted(false);
        buyBtn.setVisible(false);
        buyBtn.addActionListener(this);
        container.add(buyBtn);

        /* ========================= Panels ========================= */

        /* User Profile Panel */
        container.add(userProfilePanel);

        /* Show Time Panel */
        showTimesPanel = new ShowTimesPanel(userProfilePanel); // constructor for access getter from userProfilePanel to
                                                               // the showTimesPanel
        container.add(showTimesPanel);

        /* Ticket Price Panel */
        ticketPricePanel = new TicketPricePanel();
        container.add(ticketPricePanel);

        /* About Us Panel */
        aboutUsPanel = new AboutUsPanel();
        container.add(aboutUsPanel);

        setVisible(false);

    }

    public void setDashboardPageVisible(boolean b) {
        setVisible(b);
    }

    private void hidePanels() {
        userProfilePanel.setVisible(false);
        showTimesPanel.setVisible(false);
        ticketPricePanel.setVisible(false);
        aboutUsPanel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileBtn) {
            hidePanels();
            buyBtn.setVisible(false);
            userProfilePanel.setVisible(true);
        } else if (e.getSource() == showTimesBtn) {
            hidePanels();
            buyBtn.setVisible(true); // visible buy-button only when user will go show time Section
            showTimesPanel.setVisible(true);
        } else if (e.getSource() == ticketPriceBtn) {
            hidePanels();
            buyBtn.setVisible(false);
            ticketPricePanel.setVisible(true);
        } else if (e.getSource() == aboutUsBtn) {
            hidePanels();
            buyBtn.setVisible(false);
            aboutUsPanel.setVisible(true);
        } else if (e.getSource() == logOutBtn) {
            hidePanels();
            buyBtn.setVisible(false);
            loginPanel.showAuthenticationPage();
        } else if (e.getSource() == buyBtn) {
            int selectedRowIndex = showTimesPanel.getSelectedRowIndex();
            if (selectedRowIndex != -1) {
                Movie selectedMovie = showTimesPanel.getSelectedMovie(selectedRowIndex);
                showTimesPanel.saveMovieData(selectedMovie);
            }
        }
    }
}
