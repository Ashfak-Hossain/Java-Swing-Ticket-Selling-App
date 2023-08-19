import Authenticaton.Authentication;
import javax.swing.*;

class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Authentication::new);
    }
}