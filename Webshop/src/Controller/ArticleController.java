package Controller;

import Model.Article;
import persistence.FileReadManager;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class ArticleController {
    private final List<Article> allArticles = new Vector<>();
    FileReadManager readManager = new FileReadManager();
    private int articleId = -1;
    private Article articleModel = null;

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

    public void readData(String file) throws IOException {

        readManager.openForReading(file);
        Article article;

        do {
            article = readManager.loadArticle();
            if (article != null) {
                addArticle(article);
            }
        } while (article != null);

        readManager.closeReadManager();
    }


    public int generateArticleID() {
        if (allArticles.size() == 0) {
            this.articleId++;
        } else {
            this.articleId = allArticles.size() + 1;
        }
        return this.articleId;
    }


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


    public List<Article> sortArticlesInOrder(String userInput) {
        if (userInput.equalsIgnoreCase("A")) {
            this.allArticles.sort(Comparator.comparing(Article::getArtName));
        } else if(userInput.equalsIgnoreCase("O")) {
            this.allArticles.sort(Comparator.comparing(Article::getArtID));
        }
        return this.allArticles;
    }


    public void setArticleModel(Article articleModel) {
        this.articleModel = articleModel;
    }


}
