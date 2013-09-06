package lib.game.dice;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is designed to take in expressions to determine the type of die or dice to roll. A typical dice game
 * may use one to two six-sided dice, this class can support additional die types for the purpose of being used
 * with multiple types of games.
 * 
 * Typical expressions expected:
 * <li> d6
 * <li> 1d6
 * <li> 2d6
 * <li> 4d10
 * 
 * A typical expression uses the format of <code>#(number of dice)d#(number of die sides)</code>.
 * A complex expression may require the object to support multiple die types and aggregate the result.
 * Such as the following <code>(1d4 + 2d6)</code>.
 * 
 * @author akaszczuk
 */
public class Result
{

   /**
    * 
    * @param expression
    */
   public Result(String expression)
   {
      this.expression = expression;
   }

   /**
    * 
    * @return
    */
   public String getExpression()
   {
      return expression;
   }

   /**
    * 
    * @return
    */
   public String getDetailExpression()
   {
      return detailExpression;
   }

   /**
    * 
    * @param detailExpression
    */
   public void setDetailExpression(String detailExpression)
   {
      this.detailExpression = detailExpression;
   }

   /**
    * 
    * @return
    */
   public String getDescription()
   {
      return description;
   }

   /**
    * 
    * @param description
    */
   public void setDescription(String description)
   {
      this.description = description;
   }

   /**
    * 
    * @return
    */
   public Object getValue()
   {
      return value;
   }

   /**
    * 
    * @param value
    */
   public void setValue(Object value)
   {
      this.value = value;
   }

   /**
    * 
    * @return
    */
   public Map<String, String> getProperties()
   {
      return this.properties;
   }

   /**
    * Returns a formatted result String object.
    * 
    * @return Returns a formatted result string.
    */
   public String format()
   {
      StringBuilder sb = new StringBuilder(64);
      sb.append(expression).append(" = ");

      if (detailExpression != null && !detailExpression.equals(value.toString()))
      {
         sb.append("(").append(detailExpression).append(") = ");
      }

      sb.append(value);
      if (description != null)
      {
         sb.append(" // ").append(description);
      }

      return sb.toString();
   }

   /** The expression used the generate the dice. */
   private final String expression;

   /** The detailed expression used to generate the dice. */
   private String detailExpression;

   /** The value. */
   private Object value;

   /** The description. */
   private String description;

   /** The properties map. */
   private final Map<String, String> properties = new HashMap<String, String>();
}