package sample;

import java.io.IOException;

public class StartAVD {

    public static void main(String[] args) {

        String homeDirectory = System.getProperty("user.home");

//                Start Emulator
        String command = "sh -c emulator -avd Nexus5XA9_86_64";
//        String command = "sh -c ls";
        try {

            Runtime.getRuntime()
                    .exec(String.format(command));
//            System.out.println( Runtime.getRuntime().exec(command).exitValue());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
