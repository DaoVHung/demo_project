package ra.Model.Entity;

import javax.lang.model.element.NestingKind;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Table {
    private int tableID;
    private int userID;
    private String userName;
    private String email;
    private int phoneNumber;
    private int people;
    private LocalDate date;
    private LocalTime time;
    private String subject ;
    private String messege;
    private boolean status;
    public Table() {
    }

    public Table(int tableID, int userID, String userName, String email, int phoneNumber, int people, LocalDate date, LocalTime time, String subject, String messege, boolean status) {
        this.tableID = tableID;
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.people = people;
        this.date = date;
        this.time = time;
        this.subject = subject;
        this.messege = messege;
        this.status = status;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
