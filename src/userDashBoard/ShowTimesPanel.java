package userDashBoard;

import models.Movie;
import models.MovieTableModel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

public class ShowTimesPanel extends JPanel {
    JTable table;
    MovieTableModel tableModel;
    JScrollPane scrollPane;

    public ShowTimesPanel() {

        /* main panel */
        setLayout(new BorderLayout());
        setBackground(new Color(246, 244, 235));
        setBounds(370, 75, 750, 530);
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        ArrayList<Movie> data = new ArrayList<>();

        Movie movie1 = new Movie("The Avengers", "3D", "Action", "Friday 3:30 PM", 30, "800");
        Movie movie2 = new Movie("Thor: The Dark World", "3D", "Adventure", "Sunday 3:30 PM", 30, "800");
        Movie movie3 = new Movie("Captain America: The First Avenger", "3D", "Action", "Thursday 3:30 PM", 30, "800");

        data.add(movie1);
        data.add(movie2);
        data.add(movie3);

        /* Table Model for Movies */
        tableModel = new MovieTableModel(data);

        /* Table */
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("Cascadia code", Font.PLAIN, 13));

        /* Resizing the column width */
        table.getColumnModel().getColumn(0).setPreferredWidth(300);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(170);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);

        /* Resizing the Row width */
        table.setRowHeight(25);

        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(false);
    }
}
