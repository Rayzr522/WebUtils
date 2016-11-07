
package com.rayzr522.webutils.system;

public class SystemProperties {

    public static String home() {
        return System.getProperty("user.home");
    }

    public static String osName() {
        return System.getProperty("os.name");
    }

    public static String osVersion() {
        return System.getProperty("os.version");
    }

    public static String architecture() {
        return System.getProperty("os.arch");
    }

    public static OS osType() {
        return OS.getOS(osName());
    }

    public static String country() {
        return System.getProperty("user.country");
    }

    public static String language() {
        return System.getProperty("user.language");
    }

    public static String username() {
        return System.getProperty("user.name");
    }

    public static String pwd() {
        return System.getProperty("user.dir");
    }

}
