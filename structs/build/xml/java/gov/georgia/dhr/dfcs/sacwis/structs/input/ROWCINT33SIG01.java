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
 * Class ROWCINT33SIG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT33SIG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _tmScrTmCntct
     */
    private java.lang.String _tmScrTmCntct;

    /**
     * Field _szCdContactLocation
     */
    private java.lang.String _szCdContactLocation;

    /**
     * Field _szCdContactMethod
     */
    private java.lang.String _szCdContactMethod;

    /**
     * Field _szCdContactOthers
     */
    private java.lang.String _szCdContactOthers;

    /**
     * Field _szCdContactPurpose
     */
    private java.lang.String _szCdContactPurpose;

    /**
     * Field _szCdContactType
     */
    private java.lang.String _szCdContactType;

    /**
     * Field _bIndContactAttempted
     */
    private java.lang.String _bIndContactAttempted;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT33SIG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'bIndContactAttempted'.
     * 
     * @return the value of field 'BIndContactAttempted'.
     */
    public java.lang.String getBIndContactAttempted()
    {
        return this._bIndContactAttempted;
    } //-- java.lang.String getBIndContactAttempted() 

    /**
     * Returns the value of field 'szCdContactLocation'.
     * 
     * @return the value of field 'SzCdContactLocation'.
     */
    public java.lang.String getSzCdContactLocation()
    {
        return this._szCdContactLocation;
    } //-- java.lang.String getSzCdContactLocation() 

    /**
     * Returns the value of field 'szCdContactMethod'.
     * 
     * @return the value of field 'SzCdContactMethod'.
     */
    public java.lang.String getSzCdContactMethod()
    {
        return this._szCdContactMethod;
    } //-- java.lang.String getSzCdContactMethod() 

    /**
     * Returns the value of field 'szCdContactOthers'.
     * 
     * @return the value of field 'SzCdContactOthers'.
     */
    public java.lang.String getSzCdContactOthers()
    {
        return this._szCdContactOthers;
    } //-- java.lang.String getSzCdContactOthers() 

    /**
     * Returns the value of field 'szCdContactPurpose'.
     * 
     * @return the value of field 'SzCdContactPurpose'.
     */
    public java.lang.String getSzCdContactPurpose()
    {
        return this._szCdContactPurpose;
    } //-- java.lang.String getSzCdContactPurpose() 

    /**
     * Returns the value of field 'szCdContactType'.
     * 
     * @return the value of field 'SzCdContactType'.
     */
    public java.lang.String getSzCdContactType()
    {
        return this._szCdContactType;
    } //-- java.lang.String getSzCdContactType() 

    /**
     * Returns the value of field 'tmScrTmCntct'.
     * 
     * @return the value of field 'TmScrTmCntct'.
     */
    public java.lang.String getTmScrTmCntct()
    {
        return this._tmScrTmCntct;
    } //-- java.lang.String getTmScrTmCntct() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

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
     * Sets the value of field 'bIndContactAttempted'.
     * 
     * @param bIndContactAttempted the value of field
     * 'bIndContactAttempted'.
     */
    public void setBIndContactAttempted(java.lang.String bIndContactAttempted)
    {
        this._bIndContactAttempted = bIndContactAttempted;
    } //-- void setBIndContactAttempted(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactLocation'.
     * 
     * @param szCdContactLocation the value of field
     * 'szCdContactLocation'.
     */
    public void setSzCdContactLocation(java.lang.String szCdContactLocation)
    {
        this._szCdContactLocation = szCdContactLocation;
    } //-- void setSzCdContactLocation(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactMethod'.
     * 
     * @param szCdContactMethod the value of field
     * 'szCdContactMethod'.
     */
    public void setSzCdContactMethod(java.lang.String szCdContactMethod)
    {
        this._szCdContactMethod = szCdContactMethod;
    } //-- void setSzCdContactMethod(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactOthers'.
     * 
     * @param szCdContactOthers the value of field
     * 'szCdContactOthers'.
     */
    public void setSzCdContactOthers(java.lang.String szCdContactOthers)
    {
        this._szCdContactOthers = szCdContactOthers;
    } //-- void setSzCdContactOthers(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactPurpose'.
     * 
     * @param szCdContactPurpose the value of field
     * 'szCdContactPurpose'.
     */
    public void setSzCdContactPurpose(java.lang.String szCdContactPurpose)
    {
        this._szCdContactPurpose = szCdContactPurpose;
    } //-- void setSzCdContactPurpose(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactType'.
     * 
     * @param szCdContactType the value of field 'szCdContactType'.
     */
    public void setSzCdContactType(java.lang.String szCdContactType)
    {
        this._szCdContactType = szCdContactType;
    } //-- void setSzCdContactType(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmCntct'.
     * 
     * @param tmScrTmCntct the value of field 'tmScrTmCntct'.
     */
    public void setTmScrTmCntct(java.lang.String tmScrTmCntct)
    {
        this._tmScrTmCntct = tmScrTmCntct;
    } //-- void setTmScrTmCntct(java.lang.String) 

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
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01 unmarshal(java.io.Reader) 

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
