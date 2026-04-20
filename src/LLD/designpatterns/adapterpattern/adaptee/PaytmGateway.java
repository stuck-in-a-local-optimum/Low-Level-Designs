package LLD.designpatterns.adapterpattern.adaptee;

import LLD.designpatterns.adapterpattern.PaymentProcessor;

public class PaytmGateway {

    public void makePaymentByPaytm(double amount){
        System.out.println("Payment done via Paytm: "+ amount);
    }
}
