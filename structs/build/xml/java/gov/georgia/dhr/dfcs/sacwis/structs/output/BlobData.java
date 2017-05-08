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
 * Class BlobData.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BlobData extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _blobId
     */
    private java.lang.String _blobId;

    /**
     * Field _blobTableName
     */
    private java.lang.String _blobTableName;


      //----------------/
     //- Constructors -/
    //----------------/

    public BlobData() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'blobId'.
     * 
     * @return the value of field 'BlobId'.
     */
    public java.lang.String getBlobId()
    {
        return this._blobId;
    } //-- java.lang.String getBlobId() 

    /**
     * Returns the value of field 'blobTableName'.
     * 
     * @return the value of field 'BlobTableName'.
     */
    public java.lang.String getBlobTableName()
    {
        return this._blobTableName;
    } //-- java.lang.String getBlobTableName() 

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
     * Sets the value of field 'blobId'.
     * 
     * @param blobId the value of field 'blobId'.
     */
    public void setBlobId(java.lang.String blobId)
    {
        this._blobId = blobId;
    } //-- void setBlobId(java.lang.String) 

    /**
     * Sets the value of field 'blobTableName'.
     * 
     * @param blobTableName the value of field 'blobTableName'.
     */
    public void setBlobTableName(java.lang.String blobTableName)
    {
        this._blobTableName = blobTableName;
    } //-- void setBlobTableName(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BlobData unmarshal(java.io.Reader) 

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
