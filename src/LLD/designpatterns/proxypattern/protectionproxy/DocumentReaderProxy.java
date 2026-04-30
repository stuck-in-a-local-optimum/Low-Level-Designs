package LLD.designpatterns.proxypattern.protectionproxy;

interface IDocumentReader {
    void unlockPDF();
}

class User {
    private String name;
    private boolean isPremium;

    User(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    boolean isPremium() {
        return isPremium;
    }

    void setPremium(boolean premium) {
        isPremium = premium;
    }
}

public class DocumentReaderProxy implements IDocumentReader{

    private User user;
    private RealDocumentReader realDocumentReader;

    public DocumentReaderProxy(User user, String filePath, String password){
        this.user = user;
        this.realDocumentReader = new RealDocumentReader(filePath, password);
    }

    @Override
    public void unlockPDF() {
        if(!this.user.isPremium()){
            System.out.println("Access Denied: "+ user.getName() +" is not a premimum user");
            return;
        }
        System.out.println("Access Granted: Welcome: "+  user.getName());
        this.realDocumentReader.unlockPDF();

    }
}
