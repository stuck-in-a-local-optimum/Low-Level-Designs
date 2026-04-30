package LLD.designpatterns.proxypattern.remoteproxy;

interface IDataService {
    String fetchData();
}

public class DataServiceProxy implements IDataService {
    private String serverUrl;

    public DataServiceProxy(String serverUrl){
        this.serverUrl = serverUrl;
    }

    @Override
    public String fetchData() {
        System.out.println("Connecting to remoter server: " + this.serverUrl);

        //Simulating newtwork call
        simulateNetworkLatency();

        //In real case --? HTTP/gRPC call
        RealDataService remoteService = new RealDataService();

        String data = remoteService.fetchData();

        System.out.println("Data recieved from remote server");
        return data;


    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(1000); //simulate delay

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
