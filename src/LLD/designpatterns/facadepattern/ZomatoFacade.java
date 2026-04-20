package LLD.designpatterns.facadepattern;

import LLD.designpatterns.facadepattern.subsystems.DeliveryService;
import LLD.designpatterns.facadepattern.subsystems.NotificationService;
import LLD.designpatterns.facadepattern.subsystems.PaymentService;
import LLD.designpatterns.facadepattern.subsystems.RestaurantService;

public class ZomatoFacade {
    private RestaurantService restaurantService;
    private PaymentService paymentService;
    private DeliveryService deliveryService;
    private NotificationService notificationService;

    public ZomatoFacade(){
        this.restaurantService = new RestaurantService();
        this.paymentService = new PaymentService();
        this.deliveryService = new DeliveryService();
        this.notificationService = new NotificationService();

    }

    public void placeOrder(String item, double amount){
        restaurantService.prepareFood(item);
        paymentService.makePayment(amount);
        deliveryService.assignDeliveryBoy();
        notificationService.sendNotification();

        System.out.println("Order placed successfully");
    }


}
