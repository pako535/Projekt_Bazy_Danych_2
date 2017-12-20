import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInWindow extends JFrame implements ActionListener{

    private final int windowWidth = 350;
    private final int windowHeight = 250;
    JButton logInButton;
    JPasswordField passwordField;
    JTextField loginField;
    JCheckBox echoCheckBox;

    public LogInWindow(){
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setTitle("Sign in");
        setLayout(null);
        logInButton = new JButton("Sign In");
        logInButton.setBounds(135,160, 80, 20);
        logInButton.addActionListener(this);
        add(logInButton);

        passwordField = new JPasswordField();
        passwordField.setBounds(120,130,110,20);
        passwordField.setEchoChar('*');
        add(passwordField);

        loginField = new JTextField();
        loginField.setBounds(120,100,110,20);
        add(loginField);

        echoCheckBox = new JCheckBox();
        echoCheckBox.setBounds(240, 130,20,20);
        echoCheckBox.addActionListener(this);
        add(echoCheckBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == echoCheckBox){
            String tmp = new String(passwordField.getPassword());
            if(echoCheckBox.isSelected()){
                passwordField.setEchoChar((char)0);
            }
            else {
                passwordField.setEchoChar('*');
            }
            passwordField.setText(tmp);
        }
        else{

            if(true){
                MainWiondow mainWiondow = new MainWiondow();
                this.dispose();
            }
            else{

            }
        }
    }
}
