import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInWindow extends JFrame implements ActionListener{

    private final int windowWidth = 350;
    private final int windowHeight = 250;
    JButton logInButton;
    JPasswordField passwordField;
    JTextField loginField;
    JCheckBox echoCheckBox;
    JLabel feedback, loginLabel, passwordLabel;

    public LogInWindow(){
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sign in");
        setLayout(null);
        logInButton = new JButton("Sign In");
        logInButton.setBounds(135,130, 80, 20);
        logInButton.addActionListener(this);
        add(logInButton);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50,100,65,20);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120,100,110,20);
        passwordField.setEchoChar('*');
        add(passwordField);

        loginLabel = new JLabel("Login:");
        loginLabel.setBounds(75,70,40,20);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(120,70,110,20);
        add(loginField);

        echoCheckBox = new JCheckBox();
        echoCheckBox.setBounds(240, 100,80,20);
        echoCheckBox.setText("Show");
        echoCheckBox.addActionListener(this);
        add(echoCheckBox);

        feedback = new JLabel();
        feedback.setBounds(100,160,150,20);
        add(feedback);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == echoCheckBox){
            String tmp = new String(passwordField.getPassword());
            if(echoCheckBox.isSelected()){
                passwordField.setEchoChar((char)0);
                echoCheckBox.setText("Hide");
            }
            else {
                passwordField.setEchoChar('*');
                echoCheckBox.setText("Show");
            }
            passwordField.setText(tmp);
        }
        else{
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());
            if(new DataBaseFactory().checkPassword(login, password)){
                MainWindow mainWindow = new MainWindow();
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setVisible(true);
                this.dispose();
            }
            else{
                feedback.setText("Wrong login or password");
                feedback.setForeground(Color.RED);
            }
        }
    }
}
