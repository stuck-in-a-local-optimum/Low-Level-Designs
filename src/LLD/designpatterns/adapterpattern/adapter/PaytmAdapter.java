package LLD.designpatterns.adapterpattern.adapter;

import LLD.designpatterns.adapterpattern.PaymentProcessor;
import LLD.designpatterns.adapterpattern.adaptee.PaytmGateway;

public class PaytmAdapter implements PaymentProcessor {
    private PaytmGateway paytmGateway;

    public PaytmAdapter(PaytmGateway paytmGateway){
        this.paytmGateway = paytmGateway;
    }
    @Override
    public void pay(double amount) {
        paytmGateway.makePaymentByPaytm(amount);

    }
}
