package User_DashBoard;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class aboutUsPanel extends JPanel {
    public aboutUsPanel() {

        /* main panel */
        setLayout(null);
        setBackground(new Color(246, 244, 235));
        setBounds(370, 75, 750, 530);
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel heading1 = new JLabel("About Paradise Theatre");
        heading1.setBounds(30, 30, 300, 40);
        heading1.setFont(new Font("Cascadia code", Font.PLAIN, 22));
        add(heading1);

        /* text copied From the cineplex website */
        TextArea textArea = new TextArea("The First Multiplex Cinema Theatre in Bangladesh STAR CINEPLEX : Show Motion Limited, incorporated \n in 19th December 2002, pioneered the modern Multiplex Movie Theater industry with STAR Cineplex brand \n in Bangladesh. With lucid vision for the entertainment development in the country, the local and \n foreign promoters of Show Motion Ltd. started the first international quality state-of-the-art multiplex\n cinema theatre on 8th October 2004 in Bangladesh at Bashundhara City Mall at Panthapath, Dhaka \n\n\n. In January 2019, STAR Cineplex opened another branch in Shimanto Shambhar. The new branch has \n 3 fully digital cinema screens with state-of-the-art 3D Projection Technology, Silver Screens,\n Dolby-Digital Sound and stadium seating. One of the 3 halls will have ATMOS sound system which will \n make the movie watching even more brilliant. Hall 1 has a seating capacity of 263, Hall 2 has \n that of 253 and 3 has the capacity of 221, totaling to more than 730 seats.\n\n\n STAR Cineplex, Bashundhara City shooping mall branch has six fully digital cinema screens with \n state-of-the-art 3D Projection Technology, Silver Screens, Dolby-Digital Sound and stadium seating. With a total \n capacity of 1,600 seats the theater has large lobby with full concession stands serving pop-corns, \n soft drinks, ice-creams and many other items. In addition to scheduled shows, STAR Cineplex also \n caters to special corporate bookings, red-carpet premieres and private events. Visit www.cineplexbd.com \n for updated movie schedules and online ticket purchase\n ");
        textArea.setBounds(30, 70, 695, 400);
        textArea.setBackground(new Color(246, 244, 235));
        add(textArea);
    }

}
