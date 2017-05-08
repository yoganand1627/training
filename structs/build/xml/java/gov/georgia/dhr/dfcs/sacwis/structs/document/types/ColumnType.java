/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.document.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Hashtable;

/**
 * Class ColumnType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ColumnType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The NUMBER type
     */
    public static final int NUMBER_TYPE = 0;

    /**
     * The instance of the NUMBER type
     */
    public static final ColumnType NUMBER = new ColumnType(NUMBER_TYPE, "NUMBER");

    /**
     * The TEXT type
     */
    public static final int TEXT_TYPE = 1;

    /**
     * The instance of the TEXT type
     */
    public static final ColumnType TEXT = new ColumnType(TEXT_TYPE, "TEXT");

    /**
     * The DATE type
     */
    public static final int DATE_TYPE = 2;

    /**
     * The instance of the DATE type
     */
    public static final ColumnType DATE = new ColumnType(DATE_TYPE, "DATE");

    /**
     * Field _memberTable
     */
    private static java.util.Hashtable<Object,Object> _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private ColumnType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * ColumnType
     * 
     * @return an Enumeration over all possible instances of
     * ColumnType
     */
    public static java.util.Enumeration<java.lang.Object> enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration<java.lang.Object> enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this ColumnType
     * 
     * @return the type of this ColumnType
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return the initialized Hashtable for the member table
     */
    private static java.util.Hashtable<Object,Object> init()
    {
        Hashtable<Object, Object> members = new Hashtable<Object, Object>();
        members.put("NUMBER", NUMBER);
        members.put("TEXT", TEXT);
        members.put("DATE", DATE);
        return members;
    } //-- java.util.Hashtable<Object,Object> init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * 
     * @return this deserialized object
     */
    private java.lang.Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this ColumnType
     * 
     * @return the String representation of this ColumnType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new ColumnType based on the given String value.
     * 
     * @param string
     * @return the ColumnType value of parameter 'string'
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ColumnType";
            throw new IllegalArgumentException(err);
        }
        return (ColumnType) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType valueOf(java.lang.String) 

}
