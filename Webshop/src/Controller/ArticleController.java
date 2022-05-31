package Controller;

import Model.Article;
import persistence.FileReadManager;

import java.io.IOException;
import java.util.*;

public class ArticleController {
    private final List<Article> allArticles = new Vector<>();
    FileReadManager readManager = new FileReadManager();
    private int articleId = -1;
    private Set<Article> articleSet = null;
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
            if (allArticles.get(i).getArtName().equalsIgnoreCase(artName)) {
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
     * @param articleName  Name of the Article
     * @param changeAmount the wanted change amoiunt
     */
    public void adjustStock(String articleName, int changeAmount) {
        this.articleSet = new HashSet<>(this.allArticles);
        for (Article article : this.articleSet) {
            if (article.getStock() >=0) {
                if (article.getArtName().equalsIgnoreCase(articleName)) {
                    article.setStock(article.getStock() + changeAmount);
                }
            }

        }
    }


    public List<Article> sortArticlesInOrder(String userInput) {
        if (userInput.equalsIgnoreCase("A")) {
            this.allArticles.sort(Comparator.comparing(Article::getArtName));
        } else if (userInput.equalsIgnoreCase("O")) {
            this.allArticles.sort(Comparator.comparing(Article::getArtID));
        }
        return this.allArticles;
    }


    public void setArticleModel(Article articleModel) {
        this.articleModel = articleModel;
    }


}
