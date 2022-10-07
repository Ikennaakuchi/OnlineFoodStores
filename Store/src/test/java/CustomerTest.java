import enums.Role;
import exception.OutOfStockExceptions;
import model.Customer;
import model.Product;
import model.Staff;
import model.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class CustomerTest {
    Store store1 = new Store();
    ArrayList<Product> productArrayList = new ArrayList<>();
    String filePath = "/Users/decagon/Documents/MYTASKS AND ASSIGNMENTS/week-two-sq012-Ikennaakuchi/Store/Store Items.csv";
    Staff staff1 = new Staff("Tim Boss", "07032654321", "A12", Role.MANAGER);
    Customer customer1 = new Customer("Iyke", "07068603621", 20000000);


    @Test
    void ShouldThrowOutOfStockException(){

        staff1.addToProductList(store1,filePath);
        Assertions.assertThrows(OutOfStockExceptions.class, ()-> customer1.buy(store1,"rice", 21));
    }
}