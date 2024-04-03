package lab8.simple;
import lab8.Plant;
public class OakTree implements Plant{
    public double oxigenAmount = 15;
    public int lifetime = 18;
    public String repres = "O";

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
