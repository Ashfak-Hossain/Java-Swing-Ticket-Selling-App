import Authenticaton.AuthenticationPage;

import javax.swing.*;

class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AuthenticationPage::new);
    }
}