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
 * Class ROWCINT52DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT52DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdIncomingPhone
     */
    private int _ulIdIncomingPhone;

    /**
     * keeps track of state for field: _ulIdIncomingPhone
     */
    private boolean _has_ulIdIncomingPhone;

    /**
     * Field _ulIdIncmgPerson
     */
    private int _ulIdIncmgPerson;

    /**
     * keeps track of state for field: _ulIdIncmgPerson
     */
    private boolean _has_ulIdIncmgPerson;

    /**
     * Field _szTxtIncmgPhoneComments
     */
    private java.lang.String _szTxtIncmgPhoneComments;

    /**
     * Field _szNbrIncmgPhoneExtension
     */
    private java.lang.String _szNbrIncmgPhoneExtension;

    /**
     * Field _szNbrIncmgPhone
     */
    private java.lang.String _szNbrIncmgPhone;

    /**
     * Field _dtDtIncmgPhoneStart
     */
    private org.exolab.castor.types.Date _dtDtIncmgPhoneStart;

    /**
     * Field _dtDtIncmgPhoneEnd
     */
    private org.exolab.castor.types.Date _dtDtIncmgPhoneEnd;

    /**
     * Field _cIndIncmgPhoneInvalid
     */
    private java.lang.String _cIndIncmgPhoneInvalid;

    /**
     * Field _cIndIncmgPhonePrimary
     */
    private java.lang.String _cIndIncmgPhonePrimary;

    /**
     * Field _szCdIncmgPhoneType
     */
    private java.lang.String _szCdIncmgPhoneType;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT52DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO()


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
    public void deleteUlIdIncomingPhone()
    {
        this._has_ulIdIncomingPhone= false;
    } //-- void deleteUlIdIncomingPhone() 

    /**
     * Returns the value of field 'cIndIncmgPhoneInvalid'.
     * 
     * @return the value of field 'CIndIncmgPhoneInvalid'.
     */
    public java.lang.String getCIndIncmgPhoneInvalid()
    {
        return this._cIndIncmgPhoneInvalid;
    } //-- java.lang.String getCIndIncmgPhoneInvalid() 

    /**
     * Returns the value of field 'cIndIncmgPhonePrimary'.
     * 
     * @return the value of field 'CIndIncmgPhonePrimary'.
     */
    public java.lang.String getCIndIncmgPhonePrimary()
    {
        return this._cIndIncmgPhonePrimary;
    } //-- java.lang.String getCIndIncmgPhonePrimary() 

    /**
     * Returns the value of field 'dtDtIncmgPhoneEnd'.
     * 
     * @return the value of field 'DtDtIncmgPhoneEnd'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgPhoneEnd()
    {
        return this._dtDtIncmgPhoneEnd;
    } //-- org.exolab.castor.types.Date getDtDtIncmgPhoneEnd() 

    /**
     * Returns the value of field 'dtDtIncmgPhoneStart'.
     * 
     * @return the value of field 'DtDtIncmgPhoneStart'.
     */
    public org.exolab.castor.types.Date getDtDtIncmgPhoneStart()
    {
        return this._dtDtIncmgPhoneStart;
    } //-- org.exolab.castor.types.Date getDtDtIncmgPhoneStart() 

    /**
     * Returns the value of field 'szCdIncmgPhoneType'.
     * 
     * @return the value of field 'SzCdIncmgPhoneType'.
     */
    public java.lang.String getSzCdIncmgPhoneType()
    {
        return this._szCdIncmgPhoneType;
    } //-- java.lang.String getSzCdIncmgPhoneType() 

    /**
     * Returns the value of field 'szNbrIncmgPhone'.
     * 
     * @return the value of field 'SzNbrIncmgPhone'.
     */
    public java.lang.String getSzNbrIncmgPhone()
    {
        return this._szNbrIncmgPhone;
    } //-- java.lang.String getSzNbrIncmgPhone() 

    /**
     * Returns the value of field 'szNbrIncmgPhoneExtension'.
     * 
     * @return the value of field 'SzNbrIncmgPhoneExtension'.
     */
    public java.lang.String getSzNbrIncmgPhoneExtension()
    {
        return this._szNbrIncmgPhoneExtension;
    } //-- java.lang.String getSzNbrIncmgPhoneExtension() 

    /**
     * Returns the value of field 'szTxtIncmgPhoneComments'.
     * 
     * @return the value of field 'SzTxtIncmgPhoneComments'.
     */
    public java.lang.String getSzTxtIncmgPhoneComments()
    {
        return this._szTxtIncmgPhoneComments;
    } //-- java.lang.String getSzTxtIncmgPhoneComments() 

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
     * Returns the value of field 'ulIdIncomingPhone'.
     * 
     * @return the value of field 'UlIdIncomingPhone'.
     */
    public int getUlIdIncomingPhone()
    {
        return this._ulIdIncomingPhone;
    } //-- int getUlIdIncomingPhone() 

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
     * Method hasUlIdIncomingPhone
     * 
     * 
     * 
     * @return true if at least one UlIdIncomingPhone has been added
     */
    public boolean hasUlIdIncomingPhone()
    {
        return this._has_ulIdIncomingPhone;
    } //-- boolean hasUlIdIncomingPhone() 

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
     * Sets the value of field 'cIndIncmgPhoneInvalid'.
     * 
     * @param cIndIncmgPhoneInvalid the value of field
     * 'cIndIncmgPhoneInvalid'.
     */
    public void setCIndIncmgPhoneInvalid(java.lang.String cIndIncmgPhoneInvalid)
    {
        this._cIndIncmgPhoneInvalid = cIndIncmgPhoneInvalid;
    } //-- void setCIndIncmgPhoneInvalid(java.lang.String) 

    /**
     * Sets the value of field 'cIndIncmgPhonePrimary'.
     * 
     * @param cIndIncmgPhonePrimary the value of field
     * 'cIndIncmgPhonePrimary'.
     */
    public void setCIndIncmgPhonePrimary(java.lang.String cIndIncmgPhonePrimary)
    {
        this._cIndIncmgPhonePrimary = cIndIncmgPhonePrimary;
    } //-- void setCIndIncmgPhonePrimary(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIncmgPhoneEnd'.
     * 
     * @param dtDtIncmgPhoneEnd the value of field
     * 'dtDtIncmgPhoneEnd'.
     */
    public void setDtDtIncmgPhoneEnd(org.exolab.castor.types.Date dtDtIncmgPhoneEnd)
    {
        this._dtDtIncmgPhoneEnd = dtDtIncmgPhoneEnd;
    } //-- void setDtDtIncmgPhoneEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtIncmgPhoneStart'.
     * 
     * @param dtDtIncmgPhoneStart the value of field
     * 'dtDtIncmgPhoneStart'.
     */
    public void setDtDtIncmgPhoneStart(org.exolab.castor.types.Date dtDtIncmgPhoneStart)
    {
        this._dtDtIncmgPhoneStart = dtDtIncmgPhoneStart;
    } //-- void setDtDtIncmgPhoneStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdIncmgPhoneType'.
     * 
     * @param szCdIncmgPhoneType the value of field
     * 'szCdIncmgPhoneType'.
     */
    public void setSzCdIncmgPhoneType(java.lang.String szCdIncmgPhoneType)
    {
        this._szCdIncmgPhoneType = szCdIncmgPhoneType;
    } //-- void setSzCdIncmgPhoneType(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgPhone'.
     * 
     * @param szNbrIncmgPhone the value of field 'szNbrIncmgPhone'.
     */
    public void setSzNbrIncmgPhone(java.lang.String szNbrIncmgPhone)
    {
        this._szNbrIncmgPhone = szNbrIncmgPhone;
    } //-- void setSzNbrIncmgPhone(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgPhoneExtension'.
     * 
     * @param szNbrIncmgPhoneExtension the value of field
     * 'szNbrIncmgPhoneExtension'.
     */
    public void setSzNbrIncmgPhoneExtension(java.lang.String szNbrIncmgPhoneExtension)
    {
        this._szNbrIncmgPhoneExtension = szNbrIncmgPhoneExtension;
    } //-- void setSzNbrIncmgPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncmgPhoneComments'.
     * 
     * @param szTxtIncmgPhoneComments the value of field
     * 'szTxtIncmgPhoneComments'.
     */
    public void setSzTxtIncmgPhoneComments(java.lang.String szTxtIncmgPhoneComments)
    {
        this._szTxtIncmgPhoneComments = szTxtIncmgPhoneComments;
    } //-- void setSzTxtIncmgPhoneComments(java.lang.String) 

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
     * Sets the value of field 'ulIdIncomingPhone'.
     * 
     * @param ulIdIncomingPhone the value of field
     * 'ulIdIncomingPhone'.
     */
    public void setUlIdIncomingPhone(int ulIdIncomingPhone)
    {
        this._ulIdIncomingPhone = ulIdIncomingPhone;
        this._has_ulIdIncomingPhone = true;
    } //-- void setUlIdIncomingPhone(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO unmarshal(java.io.Reader) 

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
