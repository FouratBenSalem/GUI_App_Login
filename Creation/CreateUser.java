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
    private static JLabel userPasswordLabel1;
    private static JLabel userEmailLabel;
    private static JLabel userIDLabel;
    
    private static JTextField userNameField;
    private static JTextField userEmailField;
    private static JTextField userIDField;

    private static JPasswordField userPasswordField;
    private static JPasswordField userPasswordField1;

    private static JButton confirm;
    private static JButton closeButton;

    public CreateUser(){

        JFrame frame = new JFrame(); // whole window
        JPanel panel = new JPanel(); // layout

        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null); 

        userNameLabel = new JLabel("User-Name : ");
        userNameLabel.setBounds(10, 20, 100, 25);
        panel.add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(90, 20, 100, 25);
        panel.add(userNameField);

        userEmailLabel = new JLabel("Email : ");
        userEmailLabel.setBounds(10,50,100,25);
        panel.add(userEmailLabel);


        userEmailField = new JTextField();
        userEmailField.setBounds(90,50,100,25);
        panel.add(userEmailField);

        userIDLabel = new JLabel("User ID : ");
        userIDLabel.setBounds(10,80,100,25);
        panel.add(userIDLabel);

        userIDField = new JTextField();
        userIDField.setBounds(90,80,100,25);
        panel.add(userIDField);

        userPasswordLabel = new JLabel("Password");
        userPasswordLabel.setBounds(10,110,100,25);
        panel.add(userPasswordLabel);


        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(90,110,100,25);
        panel.add(userPasswordField);

        userPasswordLabel1 = new JLabel("Confirm");
        userPasswordLabel1.setBounds(10,140,100,25);
        panel.add(userPasswordLabel1);


        userPasswordField1 = new JPasswordField();
        userPasswordField1.setBounds(90,140,100,25);
        panel.add(userPasswordField1);


        confirm = new JButton("Confirm");
        confirm.setBounds(40,180,80,25);
        confirm.addActionListener(e -> {

        });
        panel.add(confirm);

        closeButton = new JButton("Exit");
        closeButton.setBounds(140,180,80,25);
        closeButton.addActionListener(e -> {
            System.out.println("User Exit From CreateUser.."); System.exit(0);
            
        });
        panel.add(closeButton);


        frame.setVisible(true); // was under closeoperations

    }

}