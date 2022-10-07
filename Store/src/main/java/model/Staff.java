package model;

import enums.Qualification;
import enums.Role;
import exception.NotAuthorizedException;
import exception.NotQualifiedException;
import services.staffService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Staff extends Person implements staffService {
    private String staffId;
    private Role role;

    public Staff() {
    }

    public Staff(String fullName, String phoneNumber, String staffId, Role role) {
        super(fullName, phoneNumber);
        this.staffId = staffId;
        this.role = role;
    }
    @Override
    public String hireStaff(Store store, Applicant applicant){
        if (!role.equals(Role.MANAGER)){
            throw new NotAuthorizedException("Not Authorized");
        }
        if (applicant.getQualification().equals(Qualification.BSC)){
            ArrayList<Staff> staffArr = store.getStaffList();
            Staff newStaff = new Staff(applicant.getFullName(),applicant.getPhoneNumber(), "B12", Role.CASHIER);
            staffArr.add(newStaff);
            store.setStaffList(staffArr);
            return "You Are Hired As the Cashier";
        }else {
            throw new NotQualifiedException("Not Qualified");
        }
    }

    @Override
    public String addToProductList(Store store, Product product){
        if(!role.equals(Role.CASHIER)){
            throw new NotAuthorizedException("Not Authorized");
        }else {
            ArrayList<Product> productArr = store.getProductList();
            productArr.add(product);
            store.setProductList(productArr);
            return "Product List Updated";
        }
    }
    @Override
    public String checkOut(Customer customer){
        if(!role.equals(Role.CASHIER)){
            throw new NotAuthorizedException("Not Authorized");
        }
        double totalPrice = 0;
        for(int i = 0; i < customer.getCart().size(); i++){
            Product product = customer.getCart().get(i);
            double itemPrice = product.getPrice() * product.getQuantity();
            totalPrice += itemPrice;
        }
        printReceipt(customer,totalPrice);
        return "Checkout Successful";
    }

    private void printReceipt(Customer customer, double totalPrice){
        System.out.println("\n\t\t ***** RECEIPT ***** \n");
        System.out.println("Name             :           " + customer.getFullName());
        System.out.println("Contact          :           " + customer.getPhoneNumber());
        System.out.println("\n          Products Purchased                         \n");
        for (int i = 0; i < customer.getCart().size(); i++) {
            System.out.println(i + 1 + "." + "  " + customer.getCart().get(i).getName() + " ".repeat(15 - customer.getCart().get(i).getName().length())
                    + "       " + customer.getCart().get(i).getQuantity() + "        "+ customer.getCart().get(i).getPrice());
        }
        System.out.println("\n---------------------------------------");
        System.out.println("Total \t\t\t\t\t\t \t # " + totalPrice);
        System.out.println("---------------------------------------");
    }

    public void addToProductList(Store store, String filePath){
        String line = "";
        BufferedReader br;
        ArrayList<Product> productList = store.getProductList();

        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                productList.add(new Product(value[0],value[1],Double.parseDouble(value[2]),Integer.parseInt(value[3])));
            }
            br.close();
            store.setProductList(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "fullName='" + this.getFullName() + '\'' +
                ", number=" + this.getPhoneNumber() +
                ", staffId='" + staffId + '\'' +
                ", role=" + role +
                '}';
    }

}
