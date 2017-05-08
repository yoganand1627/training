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
 * Class RenderType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class RenderType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The PDF type
     */
    public static final int PDF_TYPE = 0;

    /**
     * The instance of the PDF type
     */
    public static final RenderType PDF = new RenderType(PDF_TYPE, "PDF");

    /**
     * The HTML_WITH_SHELL type
     */
    public static final int HTML_WITH_SHELL_TYPE = 1;

    /**
     * The instance of the HTML_WITH_SHELL type
     */
    public static final RenderType HTML_WITH_SHELL = new RenderType(HTML_WITH_SHELL_TYPE, "HTML_WITH_SHELL");

    /**
     * The HTML_WITHOUT_SHELL type
     */
    public static final int HTML_WITHOUT_SHELL_TYPE = 2;

    /**
     * The instance of the HTML_WITHOUT_SHELL type
     */
    public static final RenderType HTML_WITHOUT_SHELL = new RenderType(HTML_WITHOUT_SHELL_TYPE, "HTML_WITHOUT_SHELL");

    /**
     * The HTML_COMMENT_SHELL type
     */
    public static final int HTML_COMMENT_SHELL_TYPE = 3;

    /**
     * The instance of the HTML_COMMENT_SHELL type
     */
    public static final RenderType HTML_COMMENT_SHELL = new RenderType(HTML_COMMENT_SHELL_TYPE, "HTML_COMMENT_SHELL");

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

    private RenderType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * RenderType
     * 
     * @return an Enumeration over all possible instances of
     * RenderType
     */
    public static java.util.Enumeration<java.lang.Object> enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration<java.lang.Object> enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this RenderType
     * 
     * @return the type of this RenderType
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
        members.put("PDF", PDF);
        members.put("HTML_WITH_SHELL", HTML_WITH_SHELL);
        members.put("HTML_WITHOUT_SHELL", HTML_WITHOUT_SHELL);
        members.put("HTML_COMMENT_SHELL", HTML_COMMENT_SHELL);
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
     * Returns the String representation of this RenderType
     * 
     * @return the String representation of this RenderType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new RenderType based on the given String value.
     * 
     * @param string
     * @return the RenderType value of parameter 'string'
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid RenderType";
            throw new IllegalArgumentException(err);
        }
        return (RenderType) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType valueOf(java.lang.String) 

}
