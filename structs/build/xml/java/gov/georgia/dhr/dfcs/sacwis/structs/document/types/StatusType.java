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
 * Class StatusType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StatusType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The NEW type
     */
    public static final int NEW_TYPE = 0;

    /**
     * The instance of the NEW type
     */
    public static final StatusType NEW = new StatusType(NEW_TYPE, "NEW");

    /**
     * The PROC type
     */
    public static final int PROC_TYPE = 1;

    /**
     * The instance of the PROC type
     */
    public static final StatusType PROC = new StatusType(PROC_TYPE, "PROC");

    /**
     * The COMP type
     */
    public static final int COMP_TYPE = 2;

    /**
     * The instance of the COMP type
     */
    public static final StatusType COMP = new StatusType(COMP_TYPE, "COMP");

    /**
     * The PEND type
     */
    public static final int PEND_TYPE = 3;

    /**
     * The instance of the PEND type
     */
    public static final StatusType PEND = new StatusType(PEND_TYPE, "PEND");

    /**
     * The APRV type
     */
    public static final int APRV_TYPE = 4;

    /**
     * The instance of the APRV type
     */
    public static final StatusType APRV = new StatusType(APRV_TYPE, "APRV");

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

    private StatusType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * StatusType
     * 
     * @return an Enumeration over all possible instances of
     * StatusType
     */
    public static java.util.Enumeration<java.lang.Object> enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration<java.lang.Object> enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this StatusType
     * 
     * @return the type of this StatusType
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
        members.put("NEW", NEW);
        members.put("PROC", PROC);
        members.put("COMP", COMP);
        members.put("PEND", PEND);
        members.put("APRV", APRV);
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
     * Returns the String representation of this StatusType
     * 
     * @return the String representation of this StatusType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new StatusType based on the given String value.
     * 
     * @param string
     * @return the StatusType value of parameter 'string'
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid StatusType";
            throw new IllegalArgumentException(err);
        }
        return (StatusType) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType valueOf(java.lang.String) 

}
