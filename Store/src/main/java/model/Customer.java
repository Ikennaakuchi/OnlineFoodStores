package model;

import exception.InsufficientFundsException;
import exception.OutOfStockExceptions;
import services.CustomerService;

import java.util.ArrayList;

public class Customer extends Person implements CustomerService {

    private double wallet;
    private ArrayList<Product> cart = new ArrayList<>();

    public Customer(double wallet) {
        this.wallet = wallet;
    }

    public Customer(String fullName, String phoneNumber, double wallet) {
        super(fullName, phoneNumber);
        this.wallet = wallet;
    }

    @Override
    public String buy(Store store, String productName, int quantity){
        Product product = new Product();
        for (Product p: store.getProductList()) {
            if(p.getName().equalsIgnoreCase(productName)){
                product = p;
            }
        }
        if((product.getPrice() * quantity) > wallet){
            throw new InsufficientFundsException("Insufficient Funds");
        }else{
            wallet -= (product.getPrice() * quantity);
        }
        if (store.canRemove(product,quantity).equals("product available")){
            store.removeFromProductList(product,quantity);
            Product newProduct = new Product(product.getName(), product.getCategory(), product.getPrice(), quantity);
            this.cart.add(newProduct);
            return "product added successfully";
        }
        throw new OutOfStockExceptions("OUT OF STOCK");
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
}
