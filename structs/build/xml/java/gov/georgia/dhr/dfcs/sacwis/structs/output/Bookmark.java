/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.output;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Bookmark.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Bookmark extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bookmarkName
     */
    private java.lang.String _bookmarkName;

    /**
     * Field _bookmarkData
     */
    private java.lang.String _bookmarkData;


      //----------------/
     //- Constructors -/
    //----------------/

    public Bookmark() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bookmarkData'.
     * 
     * @return the value of field 'BookmarkData'.
     */
    public java.lang.String getBookmarkData()
    {
        return this._bookmarkData;
    } //-- java.lang.String getBookmarkData() 

    /**
     * Returns the value of field 'bookmarkName'.
     * 
     * @return the value of field 'BookmarkName'.
     */
    public java.lang.String getBookmarkName()
    {
        return this._bookmarkName;
    } //-- java.lang.String getBookmarkName() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'bookmarkData'.
     * 
     * @param bookmarkData the value of field 'bookmarkData'.
     */
    public void setBookmarkData(java.lang.String bookmarkData)
    {
        this._bookmarkData = bookmarkData;
    } //-- void setBookmarkData(java.lang.String) 

    /**
     * Sets the value of field 'bookmarkName'.
     * 
     * @param bookmarkName the value of field 'bookmarkName'.
     */
    public void setBookmarkName(java.lang.String bookmarkName)
    {
        this._bookmarkName = bookmarkName;
    } //-- void setBookmarkName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Bookmark unmarshal(java.io.Reader) 

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
