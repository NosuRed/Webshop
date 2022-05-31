package Model;

import java.time.LocalDate;


public class Article {
    private int artID = -1;
    private int stock = -1;
    private double price = -1;
    private String artName = "";
    private LocalDate lastChanged = null;

    public Article(int artID, int stock, String artName, double price) {
        this.artID = artID;
        this.stock = stock;
        this.artName = artName;
        this.price = price;
        this.lastChanged = LocalDate.now();
    }
    public int getArtID() {
        return this.artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getArtName() {
        return this.artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(LocalDate lastChanged) {
        this.lastChanged = lastChanged;
    }
}
