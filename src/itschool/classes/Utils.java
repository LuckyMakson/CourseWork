package itschool.classes;

public class Utils {
    public static int getRandomInteger(int border)
    {
        return (int)(Math.random()*border);
    }

    public static int getRandomInteger(int leftBorder, int rightBorder)
    {
        return leftBorder + (int)(Math.random()*(rightBorder-leftBorder));
    }
}
