package mobile;

import utils.CommonUtils;

import java.io.IOException;

public class LaunchAVDs {

    private String sdkToolsPath = System.getenv("ANDROID_HOME") + "/tools/";

    public void startAndroidEmulators() {

        String nexusEmulatorAndroid8 = "Nexus6_A8";
        String nexusEmulatorAndroid9 = "Nexus6_A9";
        startEmulator(nexusEmulatorAndroid8);
        startEmulator(nexusEmulatorAndroid9);

        new CommonUtils().sleep(30);
    }

    public void startEmulator(String deviceName) {

        String commandToStartEmulator = sdkToolsPath + "emulator -avd " + deviceName;
        executeCommand(commandToStartEmulator);

    }

    public void executeCommand(String command) {

        System.out.println(command);
        try {

            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void stopAndroidEmulators() {

        executeCommand("adb -s emulator-5554 emu kill");
        executeCommand("adb -s emulator-5556 emu kill");

    }
}
