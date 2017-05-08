package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * The Money class consists of methods that standardize the precision of all currency as well as the display. This
 * includes methods that perform the necessary mathimatical computations.
 *
 * @author Ja'Nien Montank, 2 April 2002
 */
public class Money implements Serializable, Cloneable {
  /** Default constructor - results in a Money object equal to zero */
  public Money() {
  }


  /**
   * Constructor that takes a String value representing a monetary value
   *
   * @param moneyString - String representing the money value
   */
  public Money(String moneyString) {
    int firstBracket = moneyString.indexOf("(");
    if (firstBracket > -1) {
      StringBuffer buffer = new StringBuffer(moneyString);
      buffer.deleteCharAt(firstBracket);
      moneyString = buffer.toString();
      int secondBracket = moneyString.indexOf(")");
      buffer = new StringBuffer(moneyString);
      buffer.deleteCharAt(secondBracket);
      moneyString = "-" + buffer.toString();
    }
    this.money = this.toDouble(moneyString);
  }


  /**
   * Constructor that takes a double value representing a monetary value
   *
   * @param doubleMoney - double representing the money value
   */
  public Money(double doubleMoney) {
    this.money = this.setDecimalPlace(doubleMoney);
  }

  /**
   * Subtracts input from existing Money object
   *
   * @param moneyValue - value to subtract
   */
  public Money subtract(Money moneyValue) {
    double doubleMoney = moneyValue.getDouble();
    return new Money(this.money - doubleMoney);
  }

  /**
   * Subtracts input from existing Money object
   *
   * @param moneyValue - value to subtract
   */
  public void subtractSelf(Money moneyValue) {
    double doubleMoney = moneyValue.getDouble();
    this.money = this.money - doubleMoney;
  }


  /**
   * Subtracts input from existing Money object and does not allow results less than zero
   *
   * @param moneyValue - value to subtract
   */
  public void subtractNoNegative(Money moneyValue) {
    this.subtractSelf(moneyValue);

    if (this.money < 0) {
      this.money = 0;
    }
  }

  /**
   * Adds input moneyValue to  the existing Money object and returns a new Money object. The operation performed is new
   * Money = this + moneyValue.
   *
   * @param moneyValue - value to add
   */
  public Money add(Money moneyValue) {
    double doubleMoney = moneyValue.getDouble();
    return new Money(this.money + doubleMoney);
  }

  /**
   * Adds input moneyValue to an existing Money object The operation performed is this = this + moneyValue.
   *
   * @param moneyValue - value to add
   */
  public void addSelf(Money moneyValue) {
    double doubleMoney = moneyValue.getDouble();
    this.money = this.money + doubleMoney;
  }

  /**
   * Divides existing Money object by input value The operation performed is new Money = this / moneyValue.
   *
   * @param moneyDouble - value to divide by
   */
  public Money divide(float moneyDouble) {
    double doubleMoney = this.money / moneyDouble;
    return new Money(this.setDecimalPlace(doubleMoney));
  }

  /**
   * Divides existing Money object by input value The operation performed is this = this / moneyValue.
   *
   * @param moneyDouble - value to divide by
   */
  public void divideSelf(float moneyDouble) {
    double doubleMoney = this.money / moneyDouble;
    this.money = this.setDecimalPlace(doubleMoney);
  }

  /**
   * Divides existing Money object by input value, moneyInt and returns a new Money object. The operation performed is
   * new Money = this / moneyInt.
   *
   * @param moneyInt - value to divide by
   */
  public Money divide(int moneyInt) {
    double doubleMoney = this.money / moneyInt;
    return new Money(this.setDecimalPlace(doubleMoney));
  }


  /**
   * Divides existing Money object by input value The operation performed is this = this / moneyInt.
   *
   * @param moneyInt - value to divide by
   */
  public void divideSelf(int moneyInt) {
    double doubleMoney = this.money / moneyInt;
    this.money = this.setDecimalPlace(doubleMoney);
  }

  /**
   * Multiplies existing Money object by input value, moneyInt and returns a new Money object. The operation performed
   * is new Money = this * moneyInt.
   *
   * @param moneyInt - value to multiply by
   */
  public Money multiply(int moneyInt) {
    double doubleMoney = this.money * moneyInt;
    return new Money(this.setDecimalPlace(doubleMoney));
  }

  /**
   * Multiplies existing Money object by input value, moneyInt and returns a new Money object. The operation performed
   * is this = this * moneyInt.
   *
   * @param moneyInt - value to multiply by
   */
  public void multiplySelf(int moneyInt) {
    double doubleMoney = this.money * moneyInt;
    this.money = this.setDecimalPlace(doubleMoney);
  }

  /**
   * Multiplies existing Money object by input value The operation performed is new Money = this * moneyDouble .
   *
   * @param moneyDouble - value to multiply by
   */
  public Money multiply(float moneyDouble) {
    double doubleMoney = this.money * moneyDouble;
    return new Money(this.setDecimalPlace(doubleMoney));
  }

  /**
   * Multiplies existing Money object by input value The operation performed is this = this * moneyDouble
   *
   * @param moneyDouble - value to multiply by
   */
  public void multiplySelf(float moneyDouble) {
    double doubleMoney = this.money * moneyDouble;
    this.money = this.setDecimalPlace(doubleMoney);
  }


  /**
   * Determines if this money object is greater than the object passed in
   *
   * @param moneyValue - value to be compared
   * @return boolean - whether this money object is greater than the passed in money object
   */
  public boolean isGreaterThan(Money moneyValue) {
    boolean valueIsGreater = false;
    double doubleMoney = moneyValue.getDouble();
    if (this.money > doubleMoney) {
      valueIsGreater = true;
    }
    return valueIsGreater;
  }


  /**
   * Takes a two Money Objects and compares their values
   *
   * @param compareTo - value to be compared
   */
  public boolean equals(Object compareTo) {
    boolean result = false;

    if (compareTo != null) {
      Money compareValue = (Money) compareTo;
      double compareToValue = compareValue.getDouble();
      double roundedCompareValue = setDecimalPlace(compareToValue);
      Double valueCompare = roundedCompareValue;

      double moneyValue = this.money;
      double roundedMoneyValue = setDecimalPlace(moneyValue);
      Double valueMoney = roundedMoneyValue;

      if (valueCompare.equals(valueMoney)) {
        result = true;
      }

    }

    return result;
  }


  /**
   * Determines if this money object is less than the object passed in
   *
   * @param moneyValue - value to be compared
   * @return boolean - whether this money object is greater than the passed in money object
   */
  public boolean isLessThan(Money moneyValue) {
    boolean valueIsLess = false;
    double doubleMoney = moneyValue.getDouble();
    if (this.money < doubleMoney) {
      valueIsLess = true;
    }
    return valueIsLess;
  }

  /** Rounds the money object to the nearest whole dollar and returns a new money object. */
  public Money round() {
    return new Money(Math.round(this.money));
  }

  /** Rounds the money object to the nearest whole dollar */
  public void roundSelf() {
    this.money = Math.round(this.money);
  }

  /** Rounds money object down to the nearest whole dollar and returns a new money object. */
  public Money roundDown() {
    return new Money(Math.floor(this.money));
  }

  /** Rounds money object down to the nearest whole dollar */
  public void roundDownSelf() {
    this.money = Math.floor(this.money);
  }

  /** Rounds money object up to the nearest whole dollar and returns a new money object. */
  public Money roundUp() {
    return new Money(Math.ceil(this.money));
  }

  /** Rounds money object up to the nearest whole dollar */
  public void roundUpSelf() {
    this.money = Math.ceil(this.money);
  }


  /**
   * Returns the positive value of this Money object
   *
   * @return Money - the positive value
   */
  public Money absolute() {
    double doubleMoney = Math.abs(this.money);
    Money moneyValue = new Money(doubleMoney);
    return moneyValue;
  }


  /**
   * Translates the Money object to a String
   *
   * @return String - value equivalent to the Money object
   */
  public String toString() {
    BigDecimal myDecimal = new BigDecimal(this.money);
    NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    double doubleMoney = myDecimal.doubleValue();
    String moneyString = moneyFormatter.format(doubleMoney);

    StringBuffer moneyBuffer = new StringBuffer(moneyString);
    int dollarLocation = moneyString.indexOf(Money.DOLLAR_SIGN);
    moneyBuffer.deleteCharAt(dollarLocation);
    return moneyBuffer.toString();
  }


  /**
   * Translates the Money object to a String with no formating - no comma, decimal, or dollar sign
   *
   * @return String - value equivalent to the Money object with no format
   */
  public String toStringNoFormat() {

    Money money = new Money(this.money);
    String moneyString = money.toString();
    StringBuffer moneyBuffer = new StringBuffer(moneyString);

    int decimalLocation = moneyString.indexOf(Money.DECIMAL);
    moneyBuffer.deleteCharAt(decimalLocation);
    int commaLocation = moneyString.indexOf(Money.COMMA);

    while (commaLocation > 0) {
      moneyBuffer.deleteCharAt(commaLocation);
      commaLocation = (moneyBuffer.toString().indexOf(Money.COMMA));

    }


    return moneyBuffer.toString();
  }

  /** Clears value of Money Object */
  public void clear() {
    this.money = 0.0;
  }

  /**
   * Returns double value of the Money object
   *
   * @return double - value equivalent to the Money object
   */
  public double getDouble() {
    return this.money;
  }


  /**
   * Constructor that takes a String value representing a monetary value
   *
   * @param moneyString - String representing the money value
   */
  public static Money formatMoney(String moneyStringNoFormat) {
    StringBuffer value = new StringBuffer(moneyStringNoFormat);
    int length = value.length();
    value.insert((length - 2), ".");
    Double noFormat = new Double(value.toString());

    double doubleMoney = noFormat;
    Money money = new Money(doubleMoney);

    return money;

  }


  /**
   * Sets the decimal places for a double value to limit precision to the hundreths
   *
   * @param moneyValue - the double to set
   * @return double - double with two decimal places
   */
  double setDecimalPlace(double moneyValue) {
    double decimalNumber = moneyValue * 100;
    double number = Math.round(decimalNumber);
    return (number / 100);
  }


  /**
   * Translates a String to double
   *
   * @param moneyString - value to translate
   * @return double - value equivalent to the String passed in
   */
  double toDouble(String moneyString) {
    StringBuffer moneyBuffer = new StringBuffer(moneyString);
    int dollarLocation = moneyString.indexOf(DOLLAR_SIGN);
    int indexLocation = 0;

    if (dollarLocation >= 0) {
      moneyBuffer.deleteCharAt(dollarLocation);
      indexLocation++;
    }

    String multipleCommas = null;
    int commaLocation = moneyString.indexOf(COMMA) - indexLocation;
    if (commaLocation > 0) {
      moneyBuffer.deleteCharAt(commaLocation);
      multipleCommas = moneyBuffer.toString();
      indexLocation++;
    }

    int secondComma = 0;
    if (multipleCommas != null) {
      secondComma = multipleCommas.lastIndexOf(COMMA);

      if (secondComma > 0) {
        moneyBuffer.deleteCharAt(secondComma);
      }
    }

    Double moneyDouble = StringHelper.toDouble(moneyBuffer.toString());
    double doubleMoney = this.setDecimalPlace(moneyDouble);
    this.money = doubleMoney;
    return doubleMoney;

  }

  public Object clone() {
    Object clonedMoney = null;

    try {
      clonedMoney = super.clone();
    }
    catch (CloneNotSupportedException e) {
      // This will never be thrown because we know that the
      // super class is java.lang.Object
    }
    return clonedMoney;
  }

  //-- Instance Variable--
  private double money;

  //--Static Constants--
  public static final String COMMA = ",";
  public static final String DOLLAR_SIGN = "$";
  public static final String DECIMAL = ".";
  public static final Money ZERO_MONEY = new Money();

}
