/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.input;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ROWCINV23SI01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV23SI01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _szCdExtDocType
     */
    private java.lang.String _szCdExtDocType;

    /**
     * Field _szCdDocClass
     */
    private java.lang.String _szCdDocClass;

    /**
     * Field _dtExtDocAdded
     */
    private org.exolab.castor.types.Date _dtExtDocAdded;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV23SI01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Returns the value of field 'dtExtDocAdded'.
     * 
     * @return the value of field 'DtExtDocAdded'.
     */
    public org.exolab.castor.types.Date getDtExtDocAdded()
    {
        return this._dtExtDocAdded;
    } //-- org.exolab.castor.types.Date getDtExtDocAdded() 

    /**
     * Returns the value of field 'szCdDocClass'.
     * 
     * @return the value of field 'SzCdDocClass'.
     */
    public java.lang.String getSzCdDocClass()
    {
        return this._szCdDocClass;
    } //-- java.lang.String getSzCdDocClass() 

    /**
     * Returns the value of field 'szCdExtDocType'.
     * 
     * @return the value of field 'SzCdExtDocType'.
     */
    public java.lang.String getSzCdExtDocType()
    {
        return this._szCdExtDocType;
    } //-- java.lang.String getSzCdExtDocType() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

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
     * Sets the value of field 'dtExtDocAdded'.
     * 
     * @param dtExtDocAdded the value of field 'dtExtDocAdded'.
     */
    public void setDtExtDocAdded(org.exolab.castor.types.Date dtExtDocAdded)
    {
        this._dtExtDocAdded = dtExtDocAdded;
    } //-- void setDtExtDocAdded(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdDocClass'.
     * 
     * @param szCdDocClass the value of field 'szCdDocClass'.
     */
    public void setSzCdDocClass(java.lang.String szCdDocClass)
    {
        this._szCdDocClass = szCdDocClass;
    } //-- void setSzCdDocClass(java.lang.String) 

    /**
     * Sets the value of field 'szCdExtDocType'.
     * 
     * @param szCdExtDocType the value of field 'szCdExtDocType'.
     */
    public void setSzCdExtDocType(java.lang.String szCdExtDocType)
    {
        this._szCdExtDocType = szCdExtDocType;
    } //-- void setSzCdExtDocType(java.lang.String) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01 unmarshal(java.io.Reader) 

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
