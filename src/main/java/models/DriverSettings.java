package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DriverSettings {
    private String browserType;

    @JsonProperty(value = "isIncognito")
    private boolean isIncognito;
    @JsonProperty(value = "isEngLanguage")
    private boolean isEngLanguage;
    @JsonProperty(value = "isStartMaximized")
    private boolean isStartMaximized;

    public DriverSettings(String browserType, boolean isIncognito, boolean isEngLanguage, boolean isStartMaximized) {
        this.browserType = browserType;
        this.isIncognito = isIncognito;
        this.isEngLanguage = isEngLanguage;
        this.isStartMaximized = isStartMaximized;
    }


    public DriverSettings() {
    }

    @Override
    public String toString() {
        return "DriverSettings{" +
                "browserType='" + browserType + '\'' +
                ", incognito=" + isIncognito +
                ", engLanguage=" + isEngLanguage +
                ", startMaximized=" + isStartMaximized +
                '}';
    }

    public String getBrowserType() {
        return browserType;
    }

    public boolean getIncognito() {
        return isIncognito;
    }

    public boolean getEngLanguage() {
        return isEngLanguage;
    }

    public boolean getStartMaximized() {
        return isStartMaximized;
    }
}
