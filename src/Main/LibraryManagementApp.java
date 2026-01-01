package Main;
import Controller.AppController;
import View.WelcomeView;
import javax.swing.SwingUtilities;

public class LibraryManagementApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppController appController = new AppController();
            WelcomeView welcomeView = new WelcomeView(appController);
            welcomeView.setVisible(true);
            welcomeView.setLocationRelativeTo(null);
        });
    }
}