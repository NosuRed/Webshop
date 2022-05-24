package Controller;


import Model.Article;
import Model.Basket;

import java.util.List;

public class BasketController {

    private Basket basketModel = null;


    public BasketController(Basket basket){
        this.basketModel = basket;
    }

    public void addArticleToBasket(Article article){
        this.basketModel.getBasketList().add(article);
    }

    //TODO User error handeling if they try to put more articles amounts than available

    /**
     * changes the article amount in the basket
     * @param articleName the name of the article in the bassket
     * @param changeAmount the amount to change
     */
    public void changeArticleAmount(String articleName, int changeAmount) {
        int currentStock = 1;
        for (int i = 0; i < this.basketModel.getBasketList().size(); i++) {
            if (this.basketModel.getBasketList().get(i).getArtName().equals(articleName)) {
                if (changeAmount + currentStock >= 0) {
                    this.basketModel.getBasketList().get(i).setStock(changeAmount + currentStock);
                }else{
                    deleteArticleFromBasket(this.basketModel.getBasketList().get(i));
                }
            }
        }
    }

    /**
     * deletes an Article from the basket
     * @param article
     */
    public void deleteArticleFromBasket(Article article){
        this.basketModel.getBasketList().remove(article);
    }

    public void emptyBasket(){
        this.basketModel.getBasketList().clear();
    }

    public List<Article> articlesBoughtList(){
        return this.basketModel.getBasketList();
    }


}
