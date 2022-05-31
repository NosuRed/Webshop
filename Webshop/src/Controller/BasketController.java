package Controller;


import Model.Article;
import Model.Basket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasketController {

    private final ArrayList<String> basketBoughtListDisplay = new ArrayList<>();
    Set<Article> articleSet = null;
    private Basket basketModel = null;
    private int stockAmount = 0;
    private int stockToChange = -1;

    public BasketController(Basket basket) {
        this.basketModel = basket;
    }

    public void addArticleToBasket(Article article) {
        this.basketModel.getBasketList().add(article);
    }

    public void getStockAmountToAdd() {

        System.out.println(basketBoughtListDisplay);
    }


    public void addArticle(String articleName, int stockAmount) {
        this.stockAmount = stockAmount;
        this.basketBoughtListDisplay.add(articleName + " " + this.stockAmount);
    }

    public int getStockAmount() {
        return this.stockToChange;
    }

    public void setStockAmount(int stockAmount) {
        this.stockToChange = stockAmount;
    }

    public void decreaseArticleStock(String articleName, int amount) {
        this.articleSet = new HashSet<>(basketModel.getBasketList());
        for (Article article : this.articleSet) {
            if (article.getStock() > 0) {
                if (article.getArtName().equalsIgnoreCase(articleName)) {
                    article.setStock(article.getStock() - amount);
                }
            } else {
                System.out.println("error");
            }

        }
    }


    /**
     * deletes an Article from the basket
     *
     * @param
     */
    public void deleteArticleFromBasket(String articleName) {
        this.articleSet = new HashSet<>(this.basketModel.getBasketList());
        for (Article article : this.articleSet) {
            if (article.getArtName().equals(articleName)) {
                this.basketModel.getBasketList().remove(article);
            }
        }

    }

    public void emptyBasket() {
        this.basketBoughtListDisplay.clear();
        this.basketModel.getBasketList().clear();
    }

    public List<Article> articlesBoughtList() {
        return this.basketModel.getBasketList();
    }

    public void articlesBought() {
        if (this.basketModel.getBasketList() != null) {
            for (int i = 0; i < this.basketModel.getBasketList().size(); i++) {
                System.out.println(this.basketModel.getBasketList().get(i).getArtName() + " | " + this.basketModel.getBasketList().get(i).getStock());
            }
        }
    }

    public ArrayList<String> getBasketBoughtListDisplay() {
        return basketBoughtListDisplay;
    }

    public double articlePriceSum(){
        double priceSum = 0;
        for (Article article: this.basketModel.getBasketList()) {
            priceSum = article.getPrice() * article.getStock();
        }
        return priceSum;
    }

}
