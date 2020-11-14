package Creation;

public class User {

    private  String mNname;
    private  String mPassword;
    private  String mID;
    private String mEmail;


    public User(String name, String password, String ID, String email)
    {
        this.mNname= name;
        this.mPassword = password;
        this.mID = ID;
        this.mEmail = email;
    }

    // getters and setters

    public static String getUserName(User u)
    {
        return u.mNname;
    }
    public static String getUserPassword(User u)
    {
        return u.mPassword;
    }
    public static String getUserID(User u)
    {
        return u.mID;
    }

    public static String getUsermail(User u)
    {
        return u.mEmail;
    }
    
}
