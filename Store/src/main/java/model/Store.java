package model;

import services.StoreService;

import java.util.ArrayList;

public class Store implements StoreService {

    private ArrayList<Product> productList = new ArrayList<>();
    private ArrayList<Staff> staffList = new ArrayList<>();


    @Override
    public void removeFromProductList(Product product, int quantity){
        product.setQuantity(product.getQuantity()-quantity);
    }
    @Override
    public String canRemove(Product product, int quantity){
        if (!productList.contains(product)){
            return "product not available";
        }
        if (!(product.getQuantity() >= quantity)){
            return "OUT OF STOCK";
        }else {
            return "product available";
        }
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }
}
