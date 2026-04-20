package LLD.designpatterns.proxypattern.protectionproxy;

public class Main {

    public static void main(String[] args) {
        User normalUser = new User("Ajeet", false);
        User premiumUser = new User("Piku", true);

        DocumentReaderProxy reader1 = new DocumentReaderProxy(normalUser, "file.pdf", "1234");
        DocumentReaderProxy reader2 = new DocumentReaderProxy(premiumUser, "file.pdf", "1234");

        reader1.unlockPDF(); //should be denied
        System.out.println("-------------------------");
        reader2.unlockPDF(); // should be allowed
    }
}
