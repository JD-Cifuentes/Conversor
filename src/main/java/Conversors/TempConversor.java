package Conversors;
public class TempConversor {
    public double CtoF(double C){
        double F = (C * 9/5) + 32;
        return F;
    }
    public double CtoK(double C){
        double K = C + 273.15;
        return K;
    }
    public double FtoC(double F){
        double C = (F - 32) * 5/9;
        return C;
    }
    public double FtoK(double F){
        double K = (F - 32) * 5/9 + 273.15;
        return K;
    }
    public double KtoC(double K){
        double C = K - 273.15;
        return C;
    }
    public double KtoF(double K){
        double F = (K - 273.15) * 9/5 + 32;
        return F;
    }
}
