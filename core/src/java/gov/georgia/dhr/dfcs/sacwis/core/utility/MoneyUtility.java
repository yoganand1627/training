package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.utility.Money;

import java.util.List;
import java.util.ListIterator;


/**
 * The MoneyUtility Class allows a user to compute the average, sum, and find maximum on a List of Money object
 *
 * @author Ja'Nien Montank, 3 April 2002
 */
public class MoneyUtility {

  /**
   * Takes a List of Money objects and adds them together
   *
   * @param moneyObjects - values to sum
   */
  public static Money sum(List moneyObjects) {
    ListIterator moneyIterator = moneyObjects.listIterator();
    double moneyValue = 0;
    double sumValue = 0;

    while (moneyIterator.hasNext()) {
      Money moneySum = (Money) moneyIterator.next();
      moneyValue = moneySum.getDouble();
      sumValue = sumValue + moneyValue;
    }

    Money sum = new Money(sumValue);
    return sum;
  }


  /**
   * Takes a List of Money objects and finds the average
   *
   * @param moneyObjects - values to average
   */
  public static Money average(List moneyObjects) {
    Money sum = sum(moneyObjects);
    double sumValue = sum.getDouble();

    int size = moneyObjects.size();
    double average = sumValue / size;

    Money averageMoney = new Money(average);
    return averageMoney;
  }


  /**
   * Takes a List of Money objects and finds the maximum
   *
   * @param moneyObjects - values to evaluate
   */
  public static Money max(List moneyObjects) {
    ListIterator moneyIterator = moneyObjects.listIterator();
    Money currentMax = new Money();

    while (moneyIterator.hasNext()) {
      Money currentValue = (Money) moneyIterator.next();
      boolean greaterThan = currentValue.isGreaterThan(currentMax);

      if (greaterThan) {
        currentMax = currentValue;
      }
    }

    return currentMax;
  }


  /** Default constructor - private to prevent instantiation */
  private MoneyUtility() {
  }


}










