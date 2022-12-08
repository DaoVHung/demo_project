package ra.Model.Entity;
//UserID int primary key auto_increment,
//        UserName VARCHAR(30) not null ,
//        Passwords VARCHAR(30) not null ,
//        ConfirmPass VARCHAR(30) not null,
//        FullName nvarchar(50) not null ,
//        Email varchar(50) not null ,
//        PhoneNumber int not null ,
//        UserStatus bit  default (true),
//        Permission bit  default (false)

public class User {
    private int userID;
    private String userName;
    private String passwords;
    private String confirmPass;
    private String fullName;
    private String email;
    private String phoneNumber;
    private boolean userStatus;
    private boolean permission;
    private String address;


    public User() {
    }

    public User(int userID, String userName, String passwords, String confirmPass, String fullName, String email, String phoneNumber, boolean userStatus, boolean permission, String address) {
        this.userID = userID;
        this.userName = userName;
        this.passwords = passwords;
        this.confirmPass = confirmPass;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userStatus = userStatus;
        this.permission = permission;
        this.address = address;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
