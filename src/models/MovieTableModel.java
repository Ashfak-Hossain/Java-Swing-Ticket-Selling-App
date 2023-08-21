package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MovieTableModel extends AbstractTableModel {

    public ArrayList<Movie> data;
    final String[] columnNames = {"Movie", "Category", "Genre", "Show Time", "Available", "Price"};


    public MovieTableModel(ArrayList<Movie> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movie movie = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> movie.getMovieName();
            case 1 -> movie.getCategory();
            case 2 -> movie.getMovieGenre();
            case 3 -> movie.getShowTime();
            case 4 -> movie.getAvailableSeat();
            case 5 -> movie.getTicketPrice();
            default -> null;
        };

    }


}
