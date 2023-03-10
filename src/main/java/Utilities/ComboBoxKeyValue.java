package Utilities;

public class ComboBoxKeyValue {
    private String name;
    private String simbol;

    public ComboBoxKeyValue() {
    }

    public ComboBoxKeyValue(String name, String simbol) {
        this.name = name;
        this.simbol = simbol;
    }

    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public String getSimbol() {
        return simbol;
    }
}
