import Authenticaton.AuthenticationPage;
import User_DashBoard.DashBoard;

import javax.swing.*;

class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AuthenticationPage::new);
//        new DashBoard();
    }
}