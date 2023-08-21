
/*
 ? Author: Ashfak Hossain Evan
 ? American International University Bangladesh
 * Java Swing Graphics User Interface Project *: Simple Movie Theatre Ticket selling App
 */

import authenticaton.AuthenticationPage;

import static javax.swing.SwingUtilities.invokeLater;

class App {
    public static void main(String[] args) {
        invokeLater(AuthenticationPage::new);
    }
}
