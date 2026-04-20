package LLD.designpatterns.proxypattern.protectionproxy;

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
