import authenticaton.AuthenticationPage;

import javax.swing.*;


class App {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(AuthenticationPage::new);
        } catch (Exception e) {
            throw e;
        }
    }
}

