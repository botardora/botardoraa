package lab8.simple;
import lab8.Plant;
public class Grass implements Plant{
    public double oxigenAmount = 8;
    public int lifetime = 3;
    public String repres = "G";

    @Override
    public double getOxigenAmountPerYear() {
        return oxigenAmount;
    }

    @Override
    public int getLifeTime() {
        return lifetime;
    }

    @Override
    public String getRepresentation() {
        return repres;
    }


}
