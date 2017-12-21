import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener{

    private final int windowWidth = 800;
    private final int windowHeight = 600;

    public MainWindow(){
        setSize(windowWidth, windowHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
