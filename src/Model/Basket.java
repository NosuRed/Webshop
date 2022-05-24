package Model;


import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Basket {
    private List<Article> basketList = new Vector<>();
    private Customer customerModel = null;

    private Date buyDate = null;

    public Basket(Customer customer){
        this.customerModel = customer;
    }

    public List<Article> getBasketList() {
        return basketList;
    }



}
