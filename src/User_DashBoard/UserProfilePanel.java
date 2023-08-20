package User_DashBoard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfilePanel extends JPanel implements ActionListener {

    /* fields */
    JTextField nameField;
    JTextField phoneNumberField;
    JPasswordField passwordField;

    /* buttons */
    JButton updateBtn;

    public UserProfilePanel() {

        /* main panel */
        setLayout(null);
        setBackground(new Color(246, 244, 235));
        setBounds(370, 75, 750, 530);
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        /* ============== Labels And Text Fields ============== */

        /* Name Label */
        JLabel name = new JLabel("Ashfak Hossain Evan");
        name.setFont(new Font("Cascadia Code", Font.PLAIN, 23));
        name.setBounds(400, 90, 250, 40);
        add(name);

        /* Email Label */
        JLabel email = new JLabel("evan1234.ek@gmail.com");
        email.setFont(new Font("Cascadia Code", Font.PLAIN, 23));
        email.setBounds(400, 140, 350, 40);
        add(email);

        /* Phone No Label */
        JLabel phoneNo = new JLabel("01912124569");
        phoneNo.setFont(new Font("Cascadia Code", Font.PLAIN, 23));
        phoneNo.setBounds(400, 190, 350, 40);
        add(phoneNo);



        /* Name Label for update area */

        JLabel name2 = new JLabel("Name :");
        name2.setFont(new Font("Cascadia Code", Font.BOLD, 18));
        name2.setBounds(70, 300, 100, 20);
        add(name2);

        /* nameField for Update Name */

        nameField = new JTextField();
        nameField.setBounds(140, 295, 200, 30);
        nameField.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        nameField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0))); // Normally black without hover
        nameField.setOpaque(false);
        add(nameField);

        /* Password Label for update area */

        JLabel password = new JLabel("Password :");
        password.setFont(new Font("Cascadia Code", Font.BOLD, 18));
        password.setBounds(70, 400, 150, 20);
        add(password);

        /* Password Field for update area */

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 395, 160, 30);
        passwordField.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        passwordField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0))); // Normally black without hover
        passwordField.setOpaque(false);
        add(passwordField);

        /* Phone Number Label for update area */

        JLabel phoneNo2 = new JLabel("Phone No :");
        phoneNo2.setFont(new Font("Cascadia Code", Font.BOLD, 18));
        phoneNo2.setBounds(400, 300, 130, 20);
        add(phoneNo2);

        /* Phone Number for update area */

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(515, 295, 200, 30);
        phoneNumberField.setFont(new Font("Cascadia code", Font.PLAIN, 18));
        phoneNumberField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0))); // Normally black without hover
        phoneNumberField.setOpaque(false);
        add(phoneNumberField);

        /* Update Button */

        updateBtn = new JButton("Update");
        updateBtn.setBounds(450, 380, 200, 40);
        updateBtn.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        updateBtn.setFocusPainted(false);
        updateBtn.addActionListener(this);
        add(updateBtn);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateBtn) {
            String newName = nameField.getText();
            String newPhoneNumber = phoneNumberField.getText();
            String newPassword = new String(passwordField.getPassword());

        }
    }
}
