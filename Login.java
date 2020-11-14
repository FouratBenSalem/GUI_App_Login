
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Creation.CreateUser;

import Creation.User;

//import java.util.Arrays; // for demonstration purposes in the password handling method ( actionPerformed )

//      File Stuff
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;

public class Login implements ActionListener {

    private static JLabel userLabel; // added these variables to increase their scope 
    private static JLabel passwordLabel;    // and to use them in the actionPerformed method
    private static JTextField userNameField;
    private static JPasswordField userPasswordField;
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

        userNameField = new JTextField(20); // 20 is the length of the textField
        userNameField.setBounds(100, 20, 165, 25); // x, y, width, height
        panel.add(userNameField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);// x, y, width, height
        panel.add(passwordLabel);

        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(100, 50, 165, 25);
        panel.add(userPasswordField);

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
            frame.dispose(); // closes login frame
        });
        panel.add(createNewUser);

        
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        

        frame.setVisible(true); // was under closeoperations

    }

    public Boolean checkUserInfo(String uName, String uPassword)
    {
        File file = new File("loggedUsers.txt");
    try{
        FileInputStream fi = new FileInputStream(file); // takes file
        ObjectInputStream input = new ObjectInputStream(fi); // takes fileInputStream
        ArrayList<User> users = new ArrayList<User>();
        try{
            while(true)
            {
                User u2 = (User)input.readObject(); // read User object and cast to the target type (User)
                users.add(u2);
            }
            
        }
        
        catch(ClassNotFoundException e){
            System.err.println("Class Not Found");        
        }
        input.close();
        for(User u2 : users){ // printing the contents of the arrayList<User> collection
            if(User.getUserName(u2)==uName && User.getUserPassword(u2)==uPassword)
            {
                return true;   
            }
            
        }
        
        
    }   
    catch(FileNotFoundException fo){
        System.err.println("File Not Found Exception");
    }
    catch(IOException e1){
            System.err.println("Class Not Found");        
    }   

        return false;
    }
    

    @Override
    public void actionPerformed(ActionEvent e){ // gets run whenever we click the button
        System.out.println("( ! ) Button clicked :");  
        String userName = userNameField.getText();
        char[] password = userPasswordField.getPassword(); //returns the password but as an array      
        String passwordString = new String(password); // turning a char array to a string
        //String stringer = Arrays.toString(password).substring(1, 3*password.length-1).replaceAll(", ", "");
        
        System.out.println("  "+userName + " : "+passwordString);
        //System.out.println("  or : "+user + " : "+stringer);

        if(checkUserInfo(userName, passwordString))
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

