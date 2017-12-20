import javax.swing.JFrame;

public class Application {

    public static void main(String[] args){
        LogInWindow logInWindow = new LogInWindow();
        logInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInWindow.setVisible(true);
    }
}
