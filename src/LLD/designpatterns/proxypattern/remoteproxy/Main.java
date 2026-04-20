package LLD.designpatterns.proxypattern.remoteproxy;

public class Main {


    /*
    * CORE IDEA:
        DataService → exists on remote server
        Client should NOT deal with:
        HTTP calls
        IP/URL
        connection handling
        DataServiceProxy → acts like a local object, but internally makes network call


        DESIGN
        IDataService → common interface
        RealDataService → remote service (simulated)
        DataServiceProxy → handles network communication
        Client → calls proxy like local
    *
    *
    *
    * */
    public static void main(String[] args) {
        IDataService dataService = new DataServiceProxy("https://api.myservice.com");

        System.out.println("Client requesting data...\n");

        String data = dataService.fetchData();

        System.out.println("\n Client recieved: "+ data);

    }
}
