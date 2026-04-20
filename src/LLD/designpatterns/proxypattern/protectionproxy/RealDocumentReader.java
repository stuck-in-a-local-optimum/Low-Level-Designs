package LLD.designpatterns.proxypattern.protectionproxy;

public class RealDocumentReader implements IDocumentReader{
    //Real document reader (sensitive resource)

    private String filePath;
    private String password;

    public RealDocumentReader(String filePath, String password){
        this.filePath = filePath;
        this.password = password;
    }
    @Override
    public void unlockPDF() {
        System.out.println("Unlocking PDF: "+ filePath);
        System.out.println("Verying password...");
        System.out.println("PDF successfully unlocked!");

    }
}
