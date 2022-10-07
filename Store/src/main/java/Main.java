import enums.Qualification;
import enums.Role;
import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        Store store = new Store();
        String filePath = "/Users/decagon/Documents/MYTASKS AND ASSIGNMENTS/week-two-sq012-Ikennaakuchi/Store/Store Items.csv";
        Applicant applicant1 = new Applicant("Emeka", "07056643421", 12, Qualification.BSC);

        Staff staff1 = new Staff("Tim Boss", "07032654321","A12" ,Role.MANAGER);
        Staff staff2 = new Staff("Baba Boss", "09036231234","B12", Role.CASHIER);
        staff1.hireStaff(store, applicant1);

        System.out.println("Staff list after  hire " + store.getStaffList());

        staff1.addToProductList(store,filePath);
        System.out.println("product list  " + store.getProductList());

//        ArrayList<Product> cart1 = new ArrayList<>();

        Customer customer = new Customer("Iyke","07068603621" ,1000000);
        System.out.println(customer.buy(store,"rice",18));
//        customer.buy(store,"beans",2);


        staff2.checkOut(customer);
        staff1.checkOut(customer);


        System.out.println("product list after purchase " + store.getProductList());
        System.out.println(customer.getCart());
        System.out.println(customer.getWallet());
    }
}
