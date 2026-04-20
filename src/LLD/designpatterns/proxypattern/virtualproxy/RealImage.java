package LLD.designpatterns.proxypattern.virtualproxy;

public class RealImage implements IDisplay {
    private String imagePath;

    public RealImage(String filePath){
        this.imagePath = filePath;
        loadImageFromDisk(); //expensive operation
    }

    private void loadImageFromDisk(){
        System.out.println("Loading image from disk: "+ imagePath);
        System.out.println("Applying compression...");
        System.out.println("Applying filters...");

    }
    @Override
    public void display() {
        System.out.println("Displaying image: "+ imagePath);

    }
}
