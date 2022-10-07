import enums.Qualification;
import enums.Role;
import exception.NotQualifiedException;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StaffTest {
    Store store1 = new Store();
    String filePath = "/Users/decagon/Documents/MYTASKS AND ASSIGNMENTS/week-two-sq012-Ikennaakuchi/Store/Store Items.csv";

    Applicant applicant1 = new Applicant("Emeka", "07056643421", 12, Qualification.BSC);
    Applicant applicant2 = new Applicant("Emeka", "07056643421", 12, Qualification.HND);


    Staff staff1 = new Staff("Tim Boss", "07032654321","A12" , Role.MANAGER);
    Staff staff2 = new Staff("Baba Boss", "09036231234","B12", Role.CASHIER);
    Customer customer1 = new Customer("Iyke","07068603621" ,500000);



    @Test
    void ShouldSuccessfullyHireACashierStaffIfQualificationsAreMet(){

        Assertions.assertEquals("You Are Hired As the Cashier", staff1.hireStaff(store1, applicant1));
    }

    @Test
    void ShouldReturnNotAuthorizedIfStaffIsNotAuthorizedToHire(){
        Assertions.assertEquals("Not Authorized", staff2.hireStaff(store1, applicant1));
    }

    @Test
    void ShouldThrowNotQualifiedException(){
        Assertions.assertThrows(NotQualifiedException.class, ()-> staff1.hireStaff(store1, applicant2));
    }

    @Test
    void ShouldReturnNotAuthorizedIfNotAuthorizedToIssueReceipt() {
        Assertions.assertEquals("Not Authorized", staff1.checkOut(customer1));
    }
    @Test
    void ShouldReturnCheckoutSuccessful(){
        staff1.addToProductList(store1,filePath);
        customer1.buy(store1,"rice", 3);
        Assertions.assertEquals("Checkout Successful", staff2.checkOut(customer1));
    }
}