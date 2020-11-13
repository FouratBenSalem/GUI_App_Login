import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Creation.CreateUser;

//import java.util.Arrays; // for demonstration purposes in the password handling method ( actionPerformed )

public class Login implements ActionListener {

    private static JLabel userLabel; // added these variables to increase their scope 
    private static JLabel passwordLabel;    // and to use them in the actionPerformed method
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JButton closeButton;
    private static JButton createNewUser;


    private static JLabel success;

    public Login(){

        JFrame frame = new JFrame(); // whole window
        JPanel panel = new JPanel(); // layout

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null); // search for specifics of layouts

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20); // 20 is the length of the textField
        userText.setBounds(100, 20, 165, 25); // x, y, width, height
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);// x, y, width, height
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(e -> actionPerformed(e)); // we implemented the ActionListener
        panel.add(button);

        // you can delete this but it works
        closeButton = new JButton("Exit");
        closeButton.setBounds(250, 80, 80, 25);
        closeButton.addActionListener(e -> {System.out.println("User Exit from Login.."); System.exit(0); }); // a function in one line
        panel.add(closeButton);

        createNewUser = new JButton("Create new profile");
        createNewUser.setBounds(102,135,140,25);
        createNewUser.addActionListener(e -> {
            new CreateUser();
        });
        panel.add(createNewUser);

        
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        

        frame.setVisible(true); // was under closeoperations

    }
    

    @Override
    public void actionPerformed(ActionEvent e) { // gets run whenever we click the button
        System.out.println("( ! ) Button clicked :");  
        String user = userText.getText();
        char[] password = passwordText.getPassword(); //returns the password but as an array      
        String passwordString = new String(password); // turning a char array to a string
        //String stringer = Arrays.toString(password).substring(1, 3*password.length-1).replaceAll(", ", "");
        System.out.println("  "+user + " : "+passwordString);
        //System.out.println("  or : "+user + " : "+stringer);


        if(user.equals("fourat") && passwordString.equals("1230."))
        {
            success.setText("Login successful!");
            System.out.println("Login Success\n");
        }
        else{
            success.setText("Incorrect user / password");
            System.out.println("Login Failed\n");

        }

    }

    
}

