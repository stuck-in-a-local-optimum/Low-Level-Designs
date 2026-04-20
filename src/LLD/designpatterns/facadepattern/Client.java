package LLD.designpatterns.facadepattern;

public class Client {

    public static void main(String[] args) {
        ZomatoFacade zomatoApp = new ZomatoFacade();

        zomatoApp.placeOrder("Pizza", 500);

    }
}
