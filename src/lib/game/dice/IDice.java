package lib.game.dice;

/**
 * Dice interface for outlining the basic methods needed to be implemented by a dice class.
 * 
 * @author akaszczuk
 */
public interface IDice
{
   /** Returns a random integer between 1 and <code>maxValue</code> */
   public int randomInt(int maxValue);
   
   /** Returns a list of random integers between 1 and <code>maxValue</code> */
   public int[] randomInts(int num, int maxValue);
   
   /** Returns a random integer between <code>minValue</code> and <code>maxValue</code> */
   public int randomInt(int minValue, int maxValue);
   
   /** Returns a list of random integers between <code>minValue</code> and <code>maxValue</code> */
   public int[] randomInts(int num, int minValue, int maxValue);
   
   /** Returns the result of the roll */
   public Result getResult();
}
