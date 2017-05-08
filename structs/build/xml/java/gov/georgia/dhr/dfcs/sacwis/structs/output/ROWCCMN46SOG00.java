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
 * Class ROWCCMN46SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN46SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdPhoneType
     */
    private java.lang.String _szCdPhoneType;

    /**
     * Field _bIndPersonPhonePrimary
     */
    private java.lang.String _bIndPersonPhonePrimary;

    /**
     * Field _bIndPersonPhoneInvalid
     */
    private java.lang.String _bIndPersonPhoneInvalid;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _lNbrPhoneExtension
     */
    private java.lang.String _lNbrPhoneExtension;

    /**
     * Field _dtDtPersonPhoneEnd
     */
    private org.exolab.castor.types.Date _dtDtPersonPhoneEnd;

    /**
     * Field _dtDtPersonPhoneStart
     */
    private org.exolab.castor.types.Date _dtDtPersonPhoneStart;

    /**
     * Field _szTxtPhoneComments
     */
    private java.lang.String _szTxtPhoneComments;

    /**
     * Field _ulIdPhone
     */
    private int _ulIdPhone;

    /**
     * keeps track of state for field: _ulIdPhone
     */
    private boolean _has_ulIdPhone;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN46SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPhone()
    {
        this._has_ulIdPhone= false;
    } //-- void deleteUlIdPhone() 

    /**
     * Returns the value of field 'bIndPersonPhoneInvalid'.
     * 
     * @return the value of field 'BIndPersonPhoneInvalid'.
     */
    public java.lang.String getBIndPersonPhoneInvalid()
    {
        return this._bIndPersonPhoneInvalid;
    } //-- java.lang.String getBIndPersonPhoneInvalid() 

    /**
     * Returns the value of field 'bIndPersonPhonePrimary'.
     * 
     * @return the value of field 'BIndPersonPhonePrimary'.
     */
    public java.lang.String getBIndPersonPhonePrimary()
    {
        return this._bIndPersonPhonePrimary;
    } //-- java.lang.String getBIndPersonPhonePrimary() 

    /**
     * Returns the value of field 'dtDtPersonPhoneEnd'.
     * 
     * @return the value of field 'DtDtPersonPhoneEnd'.
     */
    public org.exolab.castor.types.Date getDtDtPersonPhoneEnd()
    {
        return this._dtDtPersonPhoneEnd;
    } //-- org.exolab.castor.types.Date getDtDtPersonPhoneEnd() 

    /**
     * Returns the value of field 'dtDtPersonPhoneStart'.
     * 
     * @return the value of field 'DtDtPersonPhoneStart'.
     */
    public org.exolab.castor.types.Date getDtDtPersonPhoneStart()
    {
        return this._dtDtPersonPhoneStart;
    } //-- org.exolab.castor.types.Date getDtDtPersonPhoneStart() 

    /**
     * Returns the value of field 'lNbrPhone'.
     * 
     * @return the value of field 'LNbrPhone'.
     */
    public java.lang.String getLNbrPhone()
    {
        return this._lNbrPhone;
    } //-- java.lang.String getLNbrPhone() 

    /**
     * Returns the value of field 'lNbrPhoneExtension'.
     * 
     * @return the value of field 'LNbrPhoneExtension'.
     */
    public java.lang.String getLNbrPhoneExtension()
    {
        return this._lNbrPhoneExtension;
    } //-- java.lang.String getLNbrPhoneExtension() 

    /**
     * Returns the value of field 'szCdPhoneType'.
     * 
     * @return the value of field 'SzCdPhoneType'.
     */
    public java.lang.String getSzCdPhoneType()
    {
        return this._szCdPhoneType;
    } //-- java.lang.String getSzCdPhoneType() 

    /**
     * Returns the value of field 'szTxtPhoneComments'.
     * 
     * @return the value of field 'SzTxtPhoneComments'.
     */
    public java.lang.String getSzTxtPhoneComments()
    {
        return this._szTxtPhoneComments;
    } //-- java.lang.String getSzTxtPhoneComments() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdPhone'.
     * 
     * @return the value of field 'UlIdPhone'.
     */
    public int getUlIdPhone()
    {
        return this._ulIdPhone;
    } //-- int getUlIdPhone() 

    /**
     * Method hasUlIdPhone
     * 
     * 
     * 
     * @return true if at least one UlIdPhone has been added
     */
    public boolean hasUlIdPhone()
    {
        return this._has_ulIdPhone;
    } //-- boolean hasUlIdPhone() 

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
     * Sets the value of field 'bIndPersonPhoneInvalid'.
     * 
     * @param bIndPersonPhoneInvalid the value of field
     * 'bIndPersonPhoneInvalid'.
     */
    public void setBIndPersonPhoneInvalid(java.lang.String bIndPersonPhoneInvalid)
    {
        this._bIndPersonPhoneInvalid = bIndPersonPhoneInvalid;
    } //-- void setBIndPersonPhoneInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndPersonPhonePrimary'.
     * 
     * @param bIndPersonPhonePrimary the value of field
     * 'bIndPersonPhonePrimary'.
     */
    public void setBIndPersonPhonePrimary(java.lang.String bIndPersonPhonePrimary)
    {
        this._bIndPersonPhonePrimary = bIndPersonPhonePrimary;
    } //-- void setBIndPersonPhonePrimary(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPersonPhoneEnd'.
     * 
     * @param dtDtPersonPhoneEnd the value of field
     * 'dtDtPersonPhoneEnd'.
     */
    public void setDtDtPersonPhoneEnd(org.exolab.castor.types.Date dtDtPersonPhoneEnd)
    {
        this._dtDtPersonPhoneEnd = dtDtPersonPhoneEnd;
    } //-- void setDtDtPersonPhoneEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersonPhoneStart'.
     * 
     * @param dtDtPersonPhoneStart the value of field
     * 'dtDtPersonPhoneStart'.
     */
    public void setDtDtPersonPhoneStart(org.exolab.castor.types.Date dtDtPersonPhoneStart)
    {
        this._dtDtPersonPhoneStart = dtDtPersonPhoneStart;
    } //-- void setDtDtPersonPhoneStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrPhone'.
     * 
     * @param lNbrPhone the value of field 'lNbrPhone'.
     */
    public void setLNbrPhone(java.lang.String lNbrPhone)
    {
        this._lNbrPhone = lNbrPhone;
    } //-- void setLNbrPhone(java.lang.String) 

    /**
     * Sets the value of field 'lNbrPhoneExtension'.
     * 
     * @param lNbrPhoneExtension the value of field
     * 'lNbrPhoneExtension'.
     */
    public void setLNbrPhoneExtension(java.lang.String lNbrPhoneExtension)
    {
        this._lNbrPhoneExtension = lNbrPhoneExtension;
    } //-- void setLNbrPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'szCdPhoneType'.
     * 
     * @param szCdPhoneType the value of field 'szCdPhoneType'.
     */
    public void setSzCdPhoneType(java.lang.String szCdPhoneType)
    {
        this._szCdPhoneType = szCdPhoneType;
    } //-- void setSzCdPhoneType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPhoneComments'.
     * 
     * @param szTxtPhoneComments the value of field
     * 'szTxtPhoneComments'.
     */
    public void setSzTxtPhoneComments(java.lang.String szTxtPhoneComments)
    {
        this._szTxtPhoneComments = szTxtPhoneComments;
    } //-- void setSzTxtPhoneComments(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdPhone'.
     * 
     * @param ulIdPhone the value of field 'ulIdPhone'.
     */
    public void setUlIdPhone(int ulIdPhone)
    {
        this._ulIdPhone = ulIdPhone;
        this._has_ulIdPhone = true;
    } //-- void setUlIdPhone(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN46SOG00 unmarshal(java.io.Reader) 

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
