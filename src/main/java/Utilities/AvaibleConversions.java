package Utilities;

public enum AvaibleConversions {
    TEMPCONV("TempConversion"),
    CURRENCYCONV("CurrConversion");

    private String kindOfConv;

    AvaibleConversions(String kindOfConv){this.kindOfConv = kindOfConv;}

    @Override
    public String toString() {
        return kindOfConv;
    }
}
