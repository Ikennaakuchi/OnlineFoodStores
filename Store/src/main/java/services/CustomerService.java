package services;

import model.Product;
import model.Store;

public interface CustomerService {
    public String buy(Store store, String productName, int quantity) throws Exception;
}
