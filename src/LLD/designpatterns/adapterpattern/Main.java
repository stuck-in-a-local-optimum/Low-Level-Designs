package LLD.designpatterns.adapterpattern;

import LLD.designpatterns.adapterpattern.adaptee.PaytmGateway;
import LLD.designpatterns.adapterpattern.adapter.PaytmAdapter;

public class Main {

    public static void main(String[] args) {
        // client uses PaymentProcessor; PaytmAdapter wraps PaytmGateway (adaptee)
        PaytmGateway paytm = new PaytmGateway();
        PaymentProcessor processor = new PaytmAdapter(paytm);
        processor.pay(1000);
    }
}
