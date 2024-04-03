package lab8.simple;
import lab8.Plant;
public class Mushroom implements Plant{
    public double oxigenAmount = 2;
    public int lifetime = 1;
    public String repres = "M";

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
