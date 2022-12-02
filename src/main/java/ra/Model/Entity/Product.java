package ra.Model.Entity;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    private int drinksID;
    private String catalogID;
    private String drinksName ;
    private int price ;
    private String title;
    private boolean drinksStatus;
    private String drinksImg;
    private List<String> listImgLinks = new ArrayList<>();

    public Drinks() {
    }

    public Drinks(int drinksID, String catalogID, String drinksName, int price, String title, boolean drinksStatus, String drinksImg, List<String> listImgLinks) {

        this.drinksID = drinksID;
        this.catalogID = catalogID;
        this.drinksName = drinksName;
        this.price = price;
        this.title = title;
        this.drinksStatus = drinksStatus;
        this.drinksImg = drinksImg;
        this.listImgLinks = listImgLinks;
    }

    public int getDrinksID() {
        return drinksID;
    }

    public void setDrinksID(int drinksID) {
        this.drinksID = drinksID;
    }

    public String getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    public String getDrinksName() {
        return drinksName;
    }

    public void setDrinksName(String drinksName) {
        this.drinksName = drinksName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDrinksStatus() {
        return drinksStatus;
    }

    public void setDrinksStatus(boolean drinksStatus) {
        this.drinksStatus = drinksStatus;
    }

    public String getDrinksImg() {
        return drinksImg;
    }

    public void setDrinksImg(String drinksImg) {
        this.drinksImg = drinksImg;
    }

    public List<String> getListImgLinks() {
        return listImgLinks;
    }

    public void setListImgLinks(List<String> listImgLinks) {
        this.listImgLinks = listImgLinks;
    }
}
