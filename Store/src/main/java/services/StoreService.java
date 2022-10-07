package services;


import model.Product;

public interface StoreService {
    public void removeFromProductList(Product product, int quantity);

    public String canRemove(Product product, int quantity);

}
