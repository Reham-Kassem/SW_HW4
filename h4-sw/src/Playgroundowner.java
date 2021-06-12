

public class Playgroundowner extends User {
    public Playground playground;
    protected eWallet ewallet;

    public Playgroundowner() {
        playground = new Playground();
    }

    public Playgroundowner(String username, String email, String password, String un, String phonenumber, Address add) {
        UserName = username;
        Email = email;
        Password = password;
        PhoneNumber = phonenumber;
        address = add;

    }

    public void showbookings(int id) {
        playground.printsbookedslot(id);
    }
    public void getplaygroundlist() {
        playground.getListOFPlaygrounds();
    }

    public void updateplayground(String New_Discription) {
        playground.setPlaygroundDescription(New_Discription);
    }

    public eWallet getewallet() {
        return ewallet;
    }

}
