package LLD.designpatterns.facadepattern.subsystems;

public class PaymentService {

    public void makePayment(double amount){
        System.out.println("Payment of Rs. " + amount + " successful");
    }
}
