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
 * Class CategoryType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CategoryType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The NARRATIVE_DOCUMENT type
     */
    public static final int NARRATIVE_DOCUMENT_TYPE = 0;

    /**
     * The instance of the NARRATIVE_DOCUMENT type
     */
    public static final CategoryType NARRATIVE_DOCUMENT = new CategoryType(NARRATIVE_DOCUMENT_TYPE, "NARRATIVE_DOCUMENT");

    /**
     * The COMPOSITE_DOCUMENT type
     */
    public static final int COMPOSITE_DOCUMENT_TYPE = 1;

    /**
     * The instance of the COMPOSITE_DOCUMENT type
     */
    public static final CategoryType COMPOSITE_DOCUMENT = new CategoryType(COMPOSITE_DOCUMENT_TYPE, "COMPOSITE_DOCUMENT");

    /**
     * The SIMPLE_DOCUMENT type
     */
    public static final int SIMPLE_DOCUMENT_TYPE = 2;

    /**
     * The instance of the SIMPLE_DOCUMENT type
     */
    public static final CategoryType SIMPLE_DOCUMENT = new CategoryType(SIMPLE_DOCUMENT_TYPE, "SIMPLE_DOCUMENT");

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

    private CategoryType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * CategoryType
     * 
     * @return an Enumeration over all possible instances of
     * CategoryType
     */
    public static java.util.Enumeration<java.lang.Object> enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration<java.lang.Object> enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this CategoryType
     * 
     * @return the type of this CategoryType
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
        members.put("NARRATIVE_DOCUMENT", NARRATIVE_DOCUMENT);
        members.put("COMPOSITE_DOCUMENT", COMPOSITE_DOCUMENT);
        members.put("SIMPLE_DOCUMENT", SIMPLE_DOCUMENT);
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
     * Returns the String representation of this CategoryType
     * 
     * @return the String representation of this CategoryType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new CategoryType based on the given String value.
     * 
     * @param string
     * @return the CategoryType value of parameter 'string'
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid CategoryType";
            throw new IllegalArgumentException(err);
        }
        return (CategoryType) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType valueOf(java.lang.String) 

}
