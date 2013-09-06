package lib.game.dice;

import java.security.SecureRandom;
import java.util.Random;

/**
 * A dice rolling class for creating a set of dice and finding the result(s) given a set of parameters.
 * 
 * @author akaszczuk
 */
public class Dice
{
   /**
    * Constructor for the Dice class. Creates a new dice object with the supplied Result object.
    * 
    * @param result 
    */
   public Dice(Result result)
   {
      this.result = result;
   }

   /**
    * Returns a random integer between 1 and <code>maxValue</code>.
    * 
    * @return Returns Result -- a String representation of the roll.
    */
   public int randomInt(int maxValue)
   {
      return randomInt(1, maxValue);
   }

   /**
    * Returns an array of random integers between 1 and <code>maxValue</code>.
    * 
    * @return Returns an primative int array of results.
    */
   public int[] randomInts(int num, int maxValue)
   {
      int[] ret = new int[num];
      for (int i = 0; i < num; i++)
         ret[i] = randomInt(maxValue);
      return ret;
   }

   /**
    * Returns a random integer between <code>minValue</code> and <code>maxValue</code>.
    * 
    * @return Returns a result given the minimum and maximum values.
    */
   public int randomInt(int minValue, int maxValue)
   {
      int result = RANDOM.nextInt(maxValue - minValue + 1) + minValue;
      
      return result;
   }

   /**
    * Returns a list of random integers between <code>minValue</code> and <code>maxValue</code>
    * @return
    */
   public int[] randomInts(int num, int minValue, int maxValue)
   {
      int[] ret = new int[num];
      for (int i = 0; i < num; i++)
         ret[i] = randomInt(minValue, maxValue);
      return ret;
   }

   /**
    * Gets the Result object containing the current result(s).
    * 
    * @return Result object containing current result(s).
    */
   public Result getResult()
   {
      return this.result;
   }

   /**
    * Checks to see if a dice object has a current thread assigned.
    * 
    * @return Returns true if a current thread has a given dice object.
    */
   public static boolean hasCurrent()
   {
      return current.get() != null;
   }

   /**
    * Get current dice thread.
    * 
    * @return Returns the current dice object.
    */
   public static Dice getCurrent()
   {
      Dice dice = current.get();
      if (dice == null)
      {
         throw new NullPointerException("Current dice thread cannot be null");
      }

      return dice;
   }

   /**
    * Sets the current dice object to the supplied parameter.
    * 
    * @param dice The new dice object to set as the current object.
    */
   public static void setCurrent(Dice dice)
   {
      current.set(dice);
   }

   /**
    *  Set a seed given a created SecureRandom object. This method should be called prior to obtaining results, if
    *  a supplied seed is to be used in the given number generator.
    */
   public static void setSeed(long seed)
   {
      RANDOM.setSeed(seed);
   }

   /** Creates a new Random object for creating roll information. */
   public static Random RANDOM = new SecureRandom();

   /** Creates the current dice thread. */
   private static ThreadLocal<Dice> current = new ThreadLocal<>();

   /** The result object for returning a string formatted roll result. */
   private final Result result;
}
