package Creation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CreateUser {

    private static JLabel userNameLabel; // added these variables to increase their scope 
    private static JLabel userPasswordLabel;    // and to use them in the actionPerformed method
    private static JTextField userName;
    private static JPasswordField userPassword;
    private static JButton confirm;
    private static JButton closeButton;

    public CreateUser(){

        JFrame frame = new JFrame(); // whole window
        JPanel panel = new JPanel(); // layout

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null); 

        userNameLabel = new JLabel("User-Name : ");
        userNameLabel.setBounds(10, 20, 80, 25);
        panel.add(userNameLabel);




        frame.setVisible(true); // was under closeoperations

    }

}