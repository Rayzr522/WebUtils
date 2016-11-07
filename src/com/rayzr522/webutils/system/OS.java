
package com.rayzr522.webutils.system;

public enum OS {

    MAC("mac"),
    WINDOWS("win"),
    LINUX("linux", "unix"),
    OTHER(new String[0]);

    private String[] keywords;

    OS(String... keywords) {
        this.keywords = keywords;
    }

    public static OS getOS(String osString) {

        for (OS os : values()) {

            for (String str : os.keywords) {

                if (osString.contains(str)) {

                    return os;

                }

            }

        }

        return OTHER;

    }

}
