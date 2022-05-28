package Controller;

import Model.Article;

import java.util.*;

public class ArticleController {
    private List<Article> allArticles = new Vector<>();
    private int articleId = -1;

    public List<Article> getAllArticles() {
        return allArticles;
    }

    public void addArticle(Article article) {
        this.allArticles.add(article);
    }


    /**
     * returns an article from the article list by name
     *
     * @param artName the wanted article to return
     * @return return an article
     */
    public Article getArticleByName(String artName) {
        for (int i = 0; i < allArticles.size(); i++) {
            if (allArticles.get(i).getArtName().equals(artName)) {
                return allArticles.get(i);
            }
        }
        return null;
    }


    public int generateArticleID() {
        if(allArticles.size() == 0) {
            this.articleId++;
        }else{
            this.articleId = allArticles.size() + 1;
        }
        return this.articleId;
    }

    //TODO Error handling

    /**
     * Allowes stock amount to be changed
     *
     * @param id           the id of the Article
     * @param changeAmount the wanted change amoiunt
     */
    public void adjustStock(int id, int changeAmount) {
        int currentStock = -1;
        for (int i = 0; i < this.allArticles.size(); i++) {
            if (this.allArticles.get(i).getArtID() == id) {
                currentStock = this.allArticles.get(i).getStock();
                if (changeAmount + currentStock >= 0) {
                    this.allArticles.get(i).setStock(changeAmount + currentStock);
                }
            }
        }
    }


    public List<Article> sortArticlesInOrder(String userInput){
        if (userInput.equals("A")) {
            this.allArticles.sort(Comparator.comparing(Article::getArtName));
        }else{
            this.allArticles.sort(Comparator.comparing(Article::getArtID));
        }
        return this.allArticles;
    }


}
