package Model;


import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Basket {
    private final List<Article> basketList = new Vector<>();
    private final Date buyDate = null;
    private Customer customerModel = null;

    public Basket(Customer customer) {
        this.customerModel = customer;
    }

    public List<Article> getBasketList() {
        return basketList;
    }


}
