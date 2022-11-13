
package Servlet;

import java.util.*;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "catalog")
@SessionScoped
public class CatalogBrowserBean implements Serializable {

    private static final long serialVersionUID = 2729758432756108274L;

    private int index = 0;
    private static Catalogue catalogue = new Catalogue();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        if (index < 0) {
            this.index = 0;
        } else if (index >= catalogue.getSize()) {
            this.index = catalogue.getSize() - 1;
        } else {
            this.index = index;
        }
    }

    public int getID() {
        if (index < catalogue.getSize()) {
            return catalogue.get(index).getIdArticle();
        } else {
            return 0;
        }
    }

    public String getDescription() {
        if (index < catalogue.getSize()) {
            return catalogue.get(index).getDescription();
        } else {
            return "";
        }
    }

    public String getMarque() {
        if (index < catalogue.getSize()) {
            return catalogue.get(index).getMarque();
        } else {
            return "";
        }
    }

    public double getPrix() {
        if (index < catalogue.getSize()) {
            return catalogue.get(index).getPrix();
        } else {
            return 0;
        }
    }
    
    public int getCount(){
        return catalogue.getSize();
    }


    public String next() {
        this.setIndex(index + 1);
        return "success";
    }

    public String previous() {
        this.setIndex(index - 1);
        return "success";
    }

    public String addArticle() {
        catalogue.add(new Article(catalogue.getMaxId() + 1,
                "desc" + catalogue.getMaxId(),
                "mar" + catalogue.getMaxId(),
                100));
        return "success";
    }

    public String removeArticle() {
        catalogue.remove(index);
        return "success";
    }

}

class Article {

    private int idArticle;
    private String description;
    private String marque;
    private double prix;

    public Article(int idArticle, String description, String marque, double prix) {
        this.idArticle = idArticle;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public String getDescription() {
        return description;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}

class Catalogue {

    private static List<Article> articles = new ArrayList<>();

    public Catalogue() {
        articles.add(new Article(1, "Drone", "Perroquet", 400));
        articles.add(new Article(2, "Télévision", "SuperBrand", 350));
        articles.add(new Article(3, "Souris", "Mulot", 35));
        articles.add(new Article(4, "Smartphone", "MegaMark", 750));
        articles.add(new Article(5, "Vacances", "AuSoleil", 15_000));

    }

    public Article get(int index) {
        return articles.get(index);
    }

    public int getSize() {
        return articles.size();
    }

    public void add(Article article) {
        articles.add(article);
    }

    public int getMaxId() {
        int max = 0;
        for (Article article : articles) {
            if (article.getIdArticle() > max) {
                max = article.getIdArticle();
            }
        }
        return max;
    }

    public void remove(int index) {
        articles.remove(index);
    }
}
