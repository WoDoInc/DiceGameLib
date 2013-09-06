package lib.game.dice;

import junit.framework.TestCase;

public class Test_Dice extends TestCase
{
   public void testRandomIntInt()
   {
      Dice dice = new Dice(null);
       
      for (int i = 0; i < 10000; i++)
      {
         int value = dice.randomInt(10);
         assertTrue(1 <= value && value <= 10);
      }
   }

   public void testRandomIntIntInt()
   {
      Dice dice = new Dice(null);
       
      for (int i = 0; i < 10000; i++)
      {
         int value = dice.randomInt(10, 20);
         assertTrue(String.format("Value outside range: %s", value), 10 <= value && value <= 20);
      }
   }
}
