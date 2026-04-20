package LLD.designpatterns.proxypattern.virtualproxy;

public class ImageProxy implements IDisplay {
    private String imagePath;

    private RealImage realImage;

    public ImageProxy(String filePath){
        this.imagePath = filePath;
        this.realImage = null; //lazy loading (initially null)

    }
    @Override
    public void display() {
        if(this.realImage == null){
            System.out.println("RealImage not loaded yet...Loading now...");
            this.realImage = new RealImage(this.imagePath);
        }
        realImage.display();

    }
}
