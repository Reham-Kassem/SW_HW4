

public class User {
    /**
     * The user name of user
     */
    protected String UserName;
    /**
     * The email of user
     */
    protected String Email;
    /**
     * The password of user
     */
    protected String Password;
    /**
     * The mobile phone number of user
     */
    protected String PhoneNumber;
    /**
     * The address of the user
     */
    protected Address address;

    /**
     * the eWallet of user, used to make money transactions between different users
     */

    public User() {

    }

    public void registerNewUser(String username, String email, String password, String un, String phonenumber, Address add) {
        UserName = username;
        Email = email;
        Password = password;
        PhoneNumber = phonenumber;
        address = add;

    }

    public void setUserName(String username) {
        UserName = username;
    }

    public String getuserName() {
        return UserName;
    }

    public void setemail(String email) {
        Email = email;
    }

    public String getemail() {
        return Email;
    }

    public void setpassword(String password) {
        Password = password;
    }

    public String getpassword() {
        return Password;
    }

    public void setaddress(Address add) {
        address = add;
    }

    public Address getaddress() {
        return address;
    }

    public void setphonenumber(String phonenumber) {
        PhoneNumber = phonenumber;
    }

    public String getphonenumber() {
        return PhoneNumber;
    }

}
