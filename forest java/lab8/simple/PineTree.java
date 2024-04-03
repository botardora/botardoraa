package lab8.simple;
import lab8.Plant;
public class PineTree implements Plant{
    public double oxigenAmount = 20;
    public int lifetime = 22;
    public String repres = "P";

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
