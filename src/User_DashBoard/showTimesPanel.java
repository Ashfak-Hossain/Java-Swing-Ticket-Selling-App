package User_DashBoard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class showTimesPanel extends JPanel {
    public showTimesPanel() {

        /* main panel */
        setLayout(null);
        setBackground(new Color(246, 244, 235));
        setBounds(370, 75, 750, 530);
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel test = new JLabel("show time");
        test.setLocation(10, 10);
        test.setSize(300, 300);
        add(test);
    }
}
