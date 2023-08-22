package userDashBoard;

import models.Movie;
import models.MovieTableModel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ShowTimesPanel extends JPanel {
    JTable table;
    MovieTableModel tableModel;
    JScrollPane scrollPane;

    UserProfilePanel userProfilePanel;

    public ShowTimesPanel(UserProfilePanel userProfilePanel) {

        this.userProfilePanel = userProfilePanel;

        /* main panel */
        setLayout(new BorderLayout());
        setBackground(new Color(246, 244, 235));
        setBounds(370, 75, 750, 530);
        setBorder(new BevelBorder(BevelBorder.LOWERED));

        ArrayList<Movie> data = new ArrayList<>();

        Movie movie1 = new Movie("The Avengers", "3D", "Action", "Friday 3:30 PM", 27, "650");
        Movie movie2 = new Movie("Thor: The Dark World", "2D", "Adventure", "Sunday 3:30 PM", 40, "500");
        Movie movie3 = new Movie("Captain America: The First Avenger", "3D", "Action", "Thursday 3:30 PM", 30, "800");
        Movie movie4 = new Movie("Black Widow", "2D", "Action", "Friday 8:00 PM", 10, "500");
        Movie movie5 = new Movie("Eternals", "3D", "Fantasy", "Thursday 8:00 PM", 27, "800");
        Movie movie6 = new Movie("Black Panther\n", "2D", "Action", "Sunday 3:30 PM", 5, "800");

        data.add(movie1);
        data.add(movie2);
        data.add(movie3);
        data.add(movie4);
        data.add(movie5);
        data.add(movie6);

        /* Table Model for Movies */
        tableModel = new MovieTableModel(data);

        /* Table */
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("Cascadia code", Font.PLAIN, 16));

        /* Resizing the column width */
        table.getColumnModel().getColumn(0).setPreferredWidth(350);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(170);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);

        /* Resizing the Row width */
        table.setRowHeight(35);

        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(false);
    }

    public int getSelectedRowIndex() {
        return table.getSelectedRow();
    }

    public Movie getSelectedMovie(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
            return tableModel.data.get(rowIndex);
        }
        return null;
    }

    /* To store the purchased Data in purchase_history file */
    public void saveMovieData(Movie selectedMovie) {
        String userInfo = getUserInfo();
        String purchaseInfo = userInfo
                + "MovieName: " + selectedMovie.getMovieName() + "\n"
                + "Movie ShowTime: " + selectedMovie.getShowTime();
        try (FileWriter fw = new FileWriter(
                "/Users/ashfakhossainevan/AIUB/Swing project/Ticket Selling App/src/purchase_history.txt", true)) {
            fw.write(purchaseInfo);
            fw.write(System.getProperty("line.separator"));
            fw.write("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
            fw.write(System.getProperty("line.separator"));
            JOptionPane.showMessageDialog(this, "Ticket Purchased!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private String getUserInfo() {

        return "Name: " + userProfilePanel.getName() + "\n"
                + "Email: " + userProfilePanel.getEmail() + "\n"
                + "PhoneNo: " + userProfilePanel.getPhoneNo() + "\n";

    }
}
