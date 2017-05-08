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
 * Class ROWCINT50DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT50DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdIncmgPersonId
     */
    private int _ulIdIncmgPersonId;

    /**
     * keeps track of state for field: _ulIdIncmgPersonId
     */
    private boolean _has_ulIdIncmgPersonId;

    /**
     * Field _szDescIncmgPersonID
     */
    private java.lang.String _szDescIncmgPersonID;

    /**
     * Field _cIndIncmgPersonIDInv
     */
    private java.lang.String _cIndIncmgPersonIDInv;

    /**
     * Field _ulIdIncmgPerson
     */
    private int _ulIdIncmgPerson;

    /**
     * keeps track of state for field: _ulIdIncmgPerson
     */
    private boolean _has_ulIdIncmgPerson;

    /**
     * Field _szNbrIncmgPersIdNumber
     */
    private java.lang.String _szNbrIncmgPersIdNumber;

    /**
     * Field _szCdIncmgPersIdType
     */
    private java.lang.String _szCdIncmgPersIdType;

    /**
     * Field _dtDtIncmgPersIdStart
     */
    private org.exolab.castor.types.Date _dtDtIncmgPersIdStart;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT50DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdIncmgPerson()
    {
        this._has_ulIdIncmgPerson= false;
    } //-- void deleteUlIdIncmgPerson() 

    /**
     */
    public void deleteUlIdIncmgPersonId()
    {
        this._has_ulIdIncmgPersonId= false;
    } //-- void deleteUlIdIncmgPersonId() 

    /**
     * Returns the value of field 'cIndIncmgPersonIDInv'.
     * 
     * @return the value of field 'CIndIncmgPersonIDInv'.
     */
    public java.lang.String getCIndIncmgPersonIDInv()
    {
        return this._cIndIncmgPersonIDInv;
    } //-- java.lang.String getCIndIncmgPersonIDInv() 

    /**
     * Returns the value of field 'dtDtIncmgPersIdStart'.
     * 
     * @return the value of field 'DtDtIncmgPersIdStart'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgPersIdStart()
    {
        return this._dtDtIncmgPersIdStart;
    } //-- org.exolab.castor.types.Date getDtDtIncmgPersIdStart() 

    /**
     * Returns the value of field 'szCdIncmgPersIdType'.
     * 
     * @return the value of field 'SzCdIncmgPersIdType'.
     */
    public java.lang.String getSzCdIncmgPersIdType()
    {
        return this._szCdIncmgPersIdType;
    } //-- java.lang.String getSzCdIncmgPersIdType() 

    /**
     * Returns the value of field 'szDescIncmgPersonID'.
     * 
     * @return the value of field 'SzDescIncmgPersonID'.
     */
    public java.lang.String getSzDescIncmgPersonID()
    {
        return this._szDescIncmgPersonID;
    } //-- java.lang.String getSzDescIncmgPersonID() 

    /**
     * Returns the value of field 'szNbrIncmgPersIdNumber'.
     * 
     * @return the value of field 'SzNbrIncmgPersIdNumber'.
     */
    public java.lang.String getSzNbrIncmgPersIdNumber()
    {
        return this._szNbrIncmgPersIdNumber;
    } //-- java.lang.String getSzNbrIncmgPersIdNumber() 

    /**
     * Returns the value of field 'ulIdIncmgPerson'.
     * 
     * @return the value of field 'UlIdIncmgPerson'.
     */
    public int getUlIdIncmgPerson()
    {
        return this._ulIdIncmgPerson;
    } //-- int getUlIdIncmgPerson() 

    /**
     * Returns the value of field 'ulIdIncmgPersonId'.
     * 
     * @return the value of field 'UlIdIncmgPersonId'.
     */
    public int getUlIdIncmgPersonId()
    {
        return this._ulIdIncmgPersonId;
    } //-- int getUlIdIncmgPersonId() 

    /**
     * Method hasUlIdIncmgPerson
     * 
     * 
     * 
     * @return true if at least one UlIdIncmgPerson has been added
     */
    public boolean hasUlIdIncmgPerson()
    {
        return this._has_ulIdIncmgPerson;
    } //-- boolean hasUlIdIncmgPerson() 

    /**
     * Method hasUlIdIncmgPersonId
     * 
     * 
     * 
     * @return true if at least one UlIdIncmgPersonId has been added
     */
    public boolean hasUlIdIncmgPersonId()
    {
        return this._has_ulIdIncmgPersonId;
    } //-- boolean hasUlIdIncmgPersonId() 

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
     * Sets the value of field 'cIndIncmgPersonIDInv'.
     * 
     * @param cIndIncmgPersonIDInv the value of field
     * 'cIndIncmgPersonIDInv'.
     */
    public void setCIndIncmgPersonIDInv(java.lang.String cIndIncmgPersonIDInv)
    {
        this._cIndIncmgPersonIDInv = cIndIncmgPersonIDInv;
    } //-- void setCIndIncmgPersonIDInv(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIncmgPersIdStart'.
     * 
     * @param dtDtIncmgPersIdStart the value of field
     * 'dtDtIncmgPersIdStart'.
     */
    public void setDtDtIncmgPersIdStart(org.exolab.castor.types.Date dtDtIncmgPersIdStart)
    {
        this._dtDtIncmgPersIdStart = dtDtIncmgPersIdStart;
    } //-- void setDtDtIncmgPersIdStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdIncmgPersIdType'.
     * 
     * @param szCdIncmgPersIdType the value of field
     * 'szCdIncmgPersIdType'.
     */
    public void setSzCdIncmgPersIdType(java.lang.String szCdIncmgPersIdType)
    {
        this._szCdIncmgPersIdType = szCdIncmgPersIdType;
    } //-- void setSzCdIncmgPersIdType(java.lang.String) 

    /**
     * Sets the value of field 'szDescIncmgPersonID'.
     * 
     * @param szDescIncmgPersonID the value of field
     * 'szDescIncmgPersonID'.
     */
    public void setSzDescIncmgPersonID(java.lang.String szDescIncmgPersonID)
    {
        this._szDescIncmgPersonID = szDescIncmgPersonID;
    } //-- void setSzDescIncmgPersonID(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgPersIdNumber'.
     * 
     * @param szNbrIncmgPersIdNumber the value of field
     * 'szNbrIncmgPersIdNumber'.
     */
    public void setSzNbrIncmgPersIdNumber(java.lang.String szNbrIncmgPersIdNumber)
    {
        this._szNbrIncmgPersIdNumber = szNbrIncmgPersIdNumber;
    } //-- void setSzNbrIncmgPersIdNumber(java.lang.String) 

    /**
     * Sets the value of field 'ulIdIncmgPerson'.
     * 
     * @param ulIdIncmgPerson the value of field 'ulIdIncmgPerson'.
     */
    public void setUlIdIncmgPerson(int ulIdIncmgPerson)
    {
        this._ulIdIncmgPerson = ulIdIncmgPerson;
        this._has_ulIdIncmgPerson = true;
    } //-- void setUlIdIncmgPerson(int) 

    /**
     * Sets the value of field 'ulIdIncmgPersonId'.
     * 
     * @param ulIdIncmgPersonId the value of field
     * 'ulIdIncmgPersonId'.
     */
    public void setUlIdIncmgPersonId(int ulIdIncmgPersonId)
    {
        this._ulIdIncmgPersonId = ulIdIncmgPersonId;
        this._has_ulIdIncmgPersonId = true;
    } //-- void setUlIdIncmgPersonId(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO unmarshal(java.io.Reader) 

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
