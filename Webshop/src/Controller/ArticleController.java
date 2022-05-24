package Controller;

import Model.Article;

import java.util.*;

public class ArticleController {
    private List<Article> allArticles = new Vector<>();


    //private ArrayList<String> allArticlesAlphabeticOrder = new ArrayList<>();
    private ArrayList<Integer> sortByNum = new ArrayList<>();


    public List<Article> getAllArticles() {
        return allArticles;
    }

    public void addArticle(Article article){
        allArticles.add(article);
    }


    /**
     * returns an article from the article list by name
     * @param artName the wanted article to return
     * @return return an article
     */
    public Article getArticleByName(String artName){
        for (int i = 0; i < allArticles.size(); i++) {
            if(allArticles.get(i).getArtName().equals(artName)){
                System.out.println(allArticles.get(i).getArtName());
            return allArticles.get(i);
            }
        }
        return null;
    }


    public int generateArticleID(){
        return allArticles.size();
    }

    //TODO Error handling

    /**
     * Allowes stock amount to be changed
     * @param id the id of the Article
     * @param changeAmount the wanted change amoiunt
     */
    public void adjustStock(int id, int changeAmount){
            int currentStock = -1;
            for (int i = 0; i < this.allArticles.size(); i++) {
                if(this.allArticles.get(i).getArtID() == id){
                    currentStock = this.allArticles.get(i).getStock();
                    if(changeAmount + currentStock >= 0) {
                        this.allArticles.get(i).setStock(changeAmount + currentStock);
                    }
                    }
                }
            }



    //TODO Do an actually sorting algo LOL

    /*
    public ArrayList<String> showArticles(){
        for(int i = 0; i< allArticles.size(); i++){
            //TODO: Nach test löschen
            System.out.println(""+ allArticles.get(i).getArtName() +" "+ allArticles.get(i).getArtID() + " " + allArticles.get(i).getStock());

        }
        return this.allArticlesAlphabeticOrder;
    }*/

}
