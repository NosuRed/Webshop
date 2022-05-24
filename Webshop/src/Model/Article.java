package Model;

import Controller.ArticleController;

public class Article {
     private int artID = -1;
     private int stock = -1;
     private String artName = "";



    public Article(int artID,int stock, String artName){
        this.artID = artID;
        this.stock = stock;
        this.artName = artName;
    }

    public int getArtID(){
        return this.artID;
    }

    public int getStock() {
        return this.stock;
    }

    public String getArtName() {
        return this.artName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
