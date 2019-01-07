package utils;

import java.io.File;

public class CommonUtils {

    public void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getYOUnivereseAPKPath() {
        File file = new File(new ConfigReader().getApkPath());
        return file.getAbsolutePath();
    }
}
