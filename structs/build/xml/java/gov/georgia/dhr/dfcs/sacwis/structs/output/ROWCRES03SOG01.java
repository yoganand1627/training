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
 * Class ROWCRES03SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES03SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdRsrcPhone
     */
    private int _ulIdRsrcPhone;

    /**
     * keeps track of state for field: _ulIdRsrcPhone
     */
    private boolean _has_ulIdRsrcPhone;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szCdFacilPhoneType
     */
    private java.lang.String _szCdFacilPhoneType;

    /**
     * Field _lNbrFacilPhoneNumber
     */
    private java.lang.String _lNbrFacilPhoneNumber;

    /**
     * Field _lNbrFacilPhoneExtension
     */
    private java.lang.String _lNbrFacilPhoneExtension;

    /**
     * Field _szTxtRsrcPhoneComments
     */
    private java.lang.String _szTxtRsrcPhoneComments;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES03SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdRsrcPhone()
    {
        this._has_ulIdRsrcPhone= false;
    } //-- void deleteUlIdRsrcPhone() 

    /**
     * Returns the value of field 'lNbrFacilPhoneExtension'.
     * 
     * @return the value of field 'LNbrFacilPhoneExtension'.
     */
    public java.lang.String getLNbrFacilPhoneExtension()
    {
        return this._lNbrFacilPhoneExtension;
    } //-- java.lang.String getLNbrFacilPhoneExtension() 

    /**
     * Returns the value of field 'lNbrFacilPhoneNumber'.
     * 
     * @return the value of field 'LNbrFacilPhoneNumber'.
     */
    public java.lang.String getLNbrFacilPhoneNumber()
    {
        return this._lNbrFacilPhoneNumber;
    } //-- java.lang.String getLNbrFacilPhoneNumber() 

    /**
     * Returns the value of field 'szCdFacilPhoneType'.
     * 
     * @return the value of field 'SzCdFacilPhoneType'.
     */
    public java.lang.String getSzCdFacilPhoneType()
    {
        return this._szCdFacilPhoneType;
    } //-- java.lang.String getSzCdFacilPhoneType() 

    /**
     * Returns the value of field 'szTxtRsrcPhoneComments'.
     * 
     * @return the value of field 'SzTxtRsrcPhoneComments'.
     */
    public java.lang.String getSzTxtRsrcPhoneComments()
    {
        return this._szTxtRsrcPhoneComments;
    } //-- java.lang.String getSzTxtRsrcPhoneComments() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdRsrcPhone'.
     * 
     * @return the value of field 'UlIdRsrcPhone'.
     */
    public int getUlIdRsrcPhone()
    {
        return this._ulIdRsrcPhone;
    } //-- int getUlIdRsrcPhone() 

    /**
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

    /**
     * Method hasUlIdRsrcPhone
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcPhone has been added
     */
    public boolean hasUlIdRsrcPhone()
    {
        return this._has_ulIdRsrcPhone;
    } //-- boolean hasUlIdRsrcPhone() 

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
     * Sets the value of field 'lNbrFacilPhoneExtension'.
     * 
     * @param lNbrFacilPhoneExtension the value of field
     * 'lNbrFacilPhoneExtension'.
     */
    public void setLNbrFacilPhoneExtension(java.lang.String lNbrFacilPhoneExtension)
    {
        this._lNbrFacilPhoneExtension = lNbrFacilPhoneExtension;
    } //-- void setLNbrFacilPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'lNbrFacilPhoneNumber'.
     * 
     * @param lNbrFacilPhoneNumber the value of field
     * 'lNbrFacilPhoneNumber'.
     */
    public void setLNbrFacilPhoneNumber(java.lang.String lNbrFacilPhoneNumber)
    {
        this._lNbrFacilPhoneNumber = lNbrFacilPhoneNumber;
    } //-- void setLNbrFacilPhoneNumber(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilPhoneType'.
     * 
     * @param szCdFacilPhoneType the value of field
     * 'szCdFacilPhoneType'.
     */
    public void setSzCdFacilPhoneType(java.lang.String szCdFacilPhoneType)
    {
        this._szCdFacilPhoneType = szCdFacilPhoneType;
    } //-- void setSzCdFacilPhoneType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRsrcPhoneComments'.
     * 
     * @param szTxtRsrcPhoneComments the value of field
     * 'szTxtRsrcPhoneComments'.
     */
    public void setSzTxtRsrcPhoneComments(java.lang.String szTxtRsrcPhoneComments)
    {
        this._szTxtRsrcPhoneComments = szTxtRsrcPhoneComments;
    } //-- void setSzTxtRsrcPhoneComments(java.lang.String) 

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
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

    /**
     * Sets the value of field 'ulIdRsrcPhone'.
     * 
     * @param ulIdRsrcPhone the value of field 'ulIdRsrcPhone'.
     */
    public void setUlIdRsrcPhone(int ulIdRsrcPhone)
    {
        this._ulIdRsrcPhone = ulIdRsrcPhone;
        this._has_ulIdRsrcPhone = true;
    } //-- void setUlIdRsrcPhone(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01 unmarshal(java.io.Reader) 

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
