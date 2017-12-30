import javax.swing.JFrame;

public class Application {

    public static void main(String[] args){

//        DataBaseFactory tmp = new DataBaseFactory();
//            System.out.print(tmp.checkEquipmentStatus("niesasdprawny"));

        LogInWindow logInWindow = new LogInWindow();
        logInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInWindow.setVisible(true);
    }
}
