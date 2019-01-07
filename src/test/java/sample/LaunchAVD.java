package sample;

import java.io.IOException;

public class LaunchAVD {

    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("/Users/sandeep/Library/Android/sdk/tools/emulator -avd Pixel_A9_86_64");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
