package User_DashBoard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ticketPricePanel extends JPanel {
    public ticketPricePanel() {

        /* main panel */
        setLayout(null);
        setBackground(new Color(246, 244, 235));
        setBounds(370, 75, 750, 530);
        setBorder(new BevelBorder(BevelBorder.LOWERED));


        /* Main Heading */
        JLabel heading1 = new JLabel("Ticket price");
        heading1.setBounds(30, 30, 300, 40);
        heading1.setFont(new Font("Cascadia code", Font.BOLD, 22));
        add(heading1);

        /* ===================== 2D Movies ===================== */
        JLabel movies2D = new JLabel("2D Movies: ");
        movies2D.setBounds(30, 80, 300, 40);
        movies2D.setFont(new Font("Cascadia code", Font.PLAIN, 20));
        add(movies2D);

        JLabel movies2DDetails1 = new JLabel("Matinee price (Shows starting before 3:00 pm except holidays)");
        movies2DDetails1.setBounds(30, 120, 600, 40);
        movies2DDetails1.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        add(movies2DDetails1);

        JLabel movies2DDetails2 = new JLabel("Regular - 300.00 Taka & Premium - 350.00 Taka");
        movies2DDetails2.setBounds(30, 145, 500, 40);
        movies2DDetails2.setFont(new Font("Cascadia code", Font.PLAIN, 14));
        add(movies2DDetails2);

        JLabel movies2DDetails3 = new JLabel("Regular price (Shows starting at or after 3:00 pm except holidays)");
        movies2DDetails3.setBounds(30, 200, 600, 40);
        movies2DDetails3.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        add(movies2DDetails3);

        JLabel movies2DDetails4 = new JLabel("Regular - 350.00 Taka & Premium - 400.00 Taka");
        movies2DDetails4.setBounds(30, 225, 500, 40);
        movies2DDetails4.setFont(new Font("Cascadia code", Font.PLAIN, 14));
        add(movies2DDetails4);

        /* ===================== 3D Movies ===================== */
        JLabel movies3D = new JLabel("3D Movies: ");
        movies3D.setBounds(30, 275, 600, 40);
        movies3D.setFont(new Font("Cascadia code", Font.PLAIN, 20));
        add(movies3D);

        JLabel movies3DDetails1 = new JLabel("Matinee price (Shows starting before 3:00 pm except holidays)");
        movies3DDetails1.setBounds(30, 315, 600, 40);
        movies3DDetails1.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        add(movies3DDetails1);

        JLabel movies3DDetails2 = new JLabel("Regular - 500.00 Taka & Premium - 700.00 Taka");
        movies3DDetails2.setBounds(30, 340, 500, 40);
        movies3DDetails2.setFont(new Font("Cascadia code", Font.PLAIN, 14));
        add(movies3DDetails2);

        JLabel movies3DDetails3 = new JLabel("Regular price (Shows starting at or after 3:00 pm except holidays)");
        movies3DDetails3.setBounds(30, 395, 600, 40);
        movies3DDetails3.setFont(new Font("Cascadia code", Font.PLAIN, 15));
        add(movies3DDetails3);

        JLabel movies3DDetails4 = new JLabel("Regular - 600.00 Taka & Premium - 800.00 Taka");
        movies3DDetails4.setBounds(30, 420, 500, 40);
        movies3DDetails4.setFont(new Font("Cascadia code", Font.PLAIN, 14));
        add(movies3DDetails4);


    }
}
