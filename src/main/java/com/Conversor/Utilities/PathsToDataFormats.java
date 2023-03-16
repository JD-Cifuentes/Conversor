package com.Conversor.Utilities;

public enum PathsToDataFormats {
    TEMP("DataFormat/TempFormat.json"),
    CURRENCIES("DataFormat/CurrenciesFormat.json");

    private String path;

    PathsToDataFormats(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
