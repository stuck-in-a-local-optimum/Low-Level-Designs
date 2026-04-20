package LLD.designpatterns.proxypattern;

import LLD.designpatterns.proxypattern.virtualproxy.IDisplay;
import LLD.designpatterns.proxypattern.virtualproxy.ImageProxy;

public class Main {
    public static void main(String[] args) {
        IDisplay image  = new ImageProxy("photo.jpg");

        System.out.println("Image object created, but not loaded yet");

        System.out.println("\n Now calling display...\n");

        image.display(); //triggers loaing

        System.out.println("\nCalling display again...\n");

        image.display(); //no reloading

    }
}
