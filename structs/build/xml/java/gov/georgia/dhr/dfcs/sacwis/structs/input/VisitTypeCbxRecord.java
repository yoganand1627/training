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
 * Class VisitTypeCbxRecord.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class VisitTypeCbxRecord extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdVisitTypeCbx
     */
    private java.lang.String _szCdVisitTypeCbx;

    /**
     * Field _idVisitType
     */
    private int _idVisitType;

    /**
     * keeps track of state for field: _idVisitType
     */
    private boolean _has_idVisitType;


      //----------------/
     //- Constructors -/
    //----------------/

    public VisitTypeCbxRecord() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIdVisitType()
    {
        this._has_idVisitType= false;
    } //-- void deleteIdVisitType() 

    /**
     * Returns the value of field 'idVisitType'.
     * 
     * @return the value of field 'IdVisitType'.
     */
    public int getIdVisitType()
    {
        return this._idVisitType;
    } //-- int getIdVisitType() 

    /**
     * Returns the value of field 'szCdVisitTypeCbx'.
     * 
     * @return the value of field 'SzCdVisitTypeCbx'.
     */
    public java.lang.String getSzCdVisitTypeCbx()
    {
        return this._szCdVisitTypeCbx;
    } //-- java.lang.String getSzCdVisitTypeCbx() 

    /**
     * Method hasIdVisitType
     * 
     * 
     * 
     * @return true if at least one IdVisitType has been added
     */
    public boolean hasIdVisitType()
    {
        return this._has_idVisitType;
    } //-- boolean hasIdVisitType() 

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
     * Sets the value of field 'idVisitType'.
     * 
     * @param idVisitType the value of field 'idVisitType'.
     */
    public void setIdVisitType(int idVisitType)
    {
        this._idVisitType = idVisitType;
        this._has_idVisitType = true;
    } //-- void setIdVisitType(int) 

    /**
     * Sets the value of field 'szCdVisitTypeCbx'.
     * 
     * @param szCdVisitTypeCbx the value of field 'szCdVisitTypeCbx'
     */
    public void setSzCdVisitTypeCbx(java.lang.String szCdVisitTypeCbx)
    {
        this._szCdVisitTypeCbx = szCdVisitTypeCbx;
    } //-- void setSzCdVisitTypeCbx(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord unmarshal(java.io.Reader) 

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
