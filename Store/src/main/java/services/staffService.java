package services;

import model.Applicant;
import model.Customer;
import model.Product;
import model.Store;

public interface staffService {
    public String addToProductList(Store store, Product product);
    public String checkOut( Customer customer);
    public String hireStaff(Store store, Applicant applicant);
}
