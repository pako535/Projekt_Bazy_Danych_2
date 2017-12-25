import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener{

    private final int WindowWidth = 800;
    private final int WindowHeight = 600;
    JPanel cards;
    private final static String peopleTableCard = "People";
    private final static String locationsTableCard = "Locations";
    private final static String equipmentTableCard = "Equipment";
    JRadioButton peopleTableRadio, locationsTableRadio, equipmentTableRadio;
    JLabel peopleTableLabel, locationsTableLabel, equipmentTableLabel;
    JTable table;

    public MainWindow(){
        setSize(WindowWidth, WindowHeight);
        setResizable(false);
        setTitle("Database explorer");
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        JPanel cards = new JPanel(new CardLayout());
        cards.add(card1, peopleTableCard);
        cards.add(card2, locationsTableCard);
        cards.add(card3, equipmentTableCard);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
