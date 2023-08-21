package models;

public class Movie {
    private String movieName;
    private String category;
    private String movieGenre;
    private String showTime;
    private int availableSeat;
    private String ticketPrice;


    public Movie(String movieName, String category, String movieGenre, String showTime, int availableSeat, String ticketPrice) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.ticketPrice = ticketPrice;
        this.category = category;
        this.showTime = showTime;
        this.availableSeat = availableSeat;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
