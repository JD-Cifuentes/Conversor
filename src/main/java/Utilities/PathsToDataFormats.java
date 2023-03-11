package Utilities;

public enum PathsToDataFormats {
    TEMP("src/main/resources/DataFormat/TempFormat.json"),
    CURRENCIES("src/main/resources/DataFormat/CurrenciesFormat.json");

    private String path;

    PathsToDataFormats(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
