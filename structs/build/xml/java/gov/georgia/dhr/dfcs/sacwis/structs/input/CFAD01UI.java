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
 * Class CFAD01UI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD01UI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _cSysIndCategoryChange
     */
    private java.lang.String _cSysIndCategoryChange;

    /**
     * Field _cSysIndRsrcCharChgNoSvc
     */
    private java.lang.String _cSysIndRsrcCharChgNoSvc;

    /**
     * Field _cSysIndRsrcCharChg
     */
    private java.lang.String _cSysIndRsrcCharChg;

    /**
     * Field _cSysIndRsrcPrsChg
     */
    private java.lang.String _cSysIndRsrcPrsChg;

    /**
     * Field _bSysIndAddressChange
     */
    private java.lang.String _bSysIndAddressChange;

    /**
     * Field _cSysIndFosterTypeChange
     */
    private java.lang.String _cSysIndFosterTypeChange;

    /**
     * Field _bSysIndAgeChange
     */
    private java.lang.String _bSysIndAgeChange;

    /**
     * Field _uNbrRsrcMlAgeMin
     */
    private int _uNbrRsrcMlAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMin
     */
    private boolean _has_uNbrRsrcMlAgeMin;

    /**
     * Field _uNbrRsrcMlAgeMax
     */
    private int _uNbrRsrcMlAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMax
     */
    private boolean _has_uNbrRsrcMlAgeMax;

    /**
     * Field _uNbrRsrcFMAgeMin
     */
    private int _uNbrRsrcFMAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMin
     */
    private boolean _has_uNbrRsrcFMAgeMin;

    /**
     * Field _uNbrRsrcFMAgeMax
     */
    private int _uNbrRsrcFMAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMax
     */
    private boolean _has_uNbrRsrcFMAgeMax;

    /**
     * Field _szCdRshsFaHomeStatus
     */
    private java.lang.String _szCdRshsFaHomeStatus;

    /**
     * Field _CFAD01UIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY _CFAD01UIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD01UI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUNbrRsrcFMAgeMax()
    {
        this._has_uNbrRsrcFMAgeMax= false;
    } //-- void deleteUNbrRsrcFMAgeMax() 

    /**
     */
    public void deleteUNbrRsrcFMAgeMin()
    {
        this._has_uNbrRsrcFMAgeMin= false;
    } //-- void deleteUNbrRsrcFMAgeMin() 

    /**
     */
    public void deleteUNbrRsrcMlAgeMax()
    {
        this._has_uNbrRsrcMlAgeMax= false;
    } //-- void deleteUNbrRsrcMlAgeMax() 

    /**
     */
    public void deleteUNbrRsrcMlAgeMin()
    {
        this._has_uNbrRsrcMlAgeMin= false;
    } //-- void deleteUNbrRsrcMlAgeMin() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'bSysIndAddressChange'.
     * 
     * @return the value of field 'BSysIndAddressChange'.
     */
    public java.lang.String getBSysIndAddressChange()
    {
        return this._bSysIndAddressChange;
    } //-- java.lang.String getBSysIndAddressChange() 

    /**
     * Returns the value of field 'bSysIndAgeChange'.
     * 
     * @return the value of field 'BSysIndAgeChange'.
     */
    public java.lang.String getBSysIndAgeChange()
    {
        return this._bSysIndAgeChange;
    } //-- java.lang.String getBSysIndAgeChange() 

    /**
     * Returns the value of field 'CFAD01UIG00_ARRAY'.
     * 
     * @return the value of field 'CFAD01UIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY getCFAD01UIG00_ARRAY()
    {
        return this._CFAD01UIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY getCFAD01UIG00_ARRAY() 

    /**
     * Returns the value of field 'cSysIndCategoryChange'.
     * 
     * @return the value of field 'CSysIndCategoryChange'.
     */
    public java.lang.String getCSysIndCategoryChange()
    {
        return this._cSysIndCategoryChange;
    } //-- java.lang.String getCSysIndCategoryChange() 

    /**
     * Returns the value of field 'cSysIndFosterTypeChange'.
     * 
     * @return the value of field 'CSysIndFosterTypeChange'.
     */
    public java.lang.String getCSysIndFosterTypeChange()
    {
        return this._cSysIndFosterTypeChange;
    } //-- java.lang.String getCSysIndFosterTypeChange() 

    /**
     * Returns the value of field 'cSysIndRsrcCharChg'.
     * 
     * @return the value of field 'CSysIndRsrcCharChg'.
     */
    public java.lang.String getCSysIndRsrcCharChg()
    {
        return this._cSysIndRsrcCharChg;
    } //-- java.lang.String getCSysIndRsrcCharChg() 

    /**
     * Returns the value of field 'cSysIndRsrcCharChgNoSvc'.
     * 
     * @return the value of field 'CSysIndRsrcCharChgNoSvc'.
     */
    public java.lang.String getCSysIndRsrcCharChgNoSvc()
    {
        return this._cSysIndRsrcCharChgNoSvc;
    } //-- java.lang.String getCSysIndRsrcCharChgNoSvc() 

    /**
     * Returns the value of field 'cSysIndRsrcPrsChg'.
     * 
     * @return the value of field 'CSysIndRsrcPrsChg'.
     */
    public java.lang.String getCSysIndRsrcPrsChg()
    {
        return this._cSysIndRsrcPrsChg;
    } //-- java.lang.String getCSysIndRsrcPrsChg() 

    /**
     * Returns the value of field 'szCdRshsFaHomeStatus'.
     * 
     * @return the value of field 'SzCdRshsFaHomeStatus'.
     */
    public java.lang.String getSzCdRshsFaHomeStatus()
    {
        return this._szCdRshsFaHomeStatus;
    } //-- java.lang.String getSzCdRshsFaHomeStatus() 

    /**
     * Returns the value of field 'uNbrRsrcFMAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcFMAgeMax'.
     */
    public int getUNbrRsrcFMAgeMax()
    {
        return this._uNbrRsrcFMAgeMax;
    } //-- int getUNbrRsrcFMAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcFMAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcFMAgeMin'.
     */
    public int getUNbrRsrcFMAgeMin()
    {
        return this._uNbrRsrcFMAgeMin;
    } //-- int getUNbrRsrcFMAgeMin() 

    /**
     * Returns the value of field 'uNbrRsrcMlAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcMlAgeMax'.
     */
    public int getUNbrRsrcMlAgeMax()
    {
        return this._uNbrRsrcMlAgeMax;
    } //-- int getUNbrRsrcMlAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcMlAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcMlAgeMin'.
     */
    public int getUNbrRsrcMlAgeMin()
    {
        return this._uNbrRsrcMlAgeMin;
    } //-- int getUNbrRsrcMlAgeMin() 

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
     * Method hasUNbrRsrcFMAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFMAgeMax has been added
     */
    public boolean hasUNbrRsrcFMAgeMax()
    {
        return this._has_uNbrRsrcFMAgeMax;
    } //-- boolean hasUNbrRsrcFMAgeMax() 

    /**
     * Method hasUNbrRsrcFMAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFMAgeMin has been added
     */
    public boolean hasUNbrRsrcFMAgeMin()
    {
        return this._has_uNbrRsrcFMAgeMin;
    } //-- boolean hasUNbrRsrcFMAgeMin() 

    /**
     * Method hasUNbrRsrcMlAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcMlAgeMax has been added
     */
    public boolean hasUNbrRsrcMlAgeMax()
    {
        return this._has_uNbrRsrcMlAgeMax;
    } //-- boolean hasUNbrRsrcMlAgeMax() 

    /**
     * Method hasUNbrRsrcMlAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcMlAgeMin has been added
     */
    public boolean hasUNbrRsrcMlAgeMin()
    {
        return this._has_uNbrRsrcMlAgeMin;
    } //-- boolean hasUNbrRsrcMlAgeMin() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'bSysIndAddressChange'.
     * 
     * @param bSysIndAddressChange the value of field
     * 'bSysIndAddressChange'.
     */
    public void setBSysIndAddressChange(java.lang.String bSysIndAddressChange)
    {
        this._bSysIndAddressChange = bSysIndAddressChange;
    } //-- void setBSysIndAddressChange(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndAgeChange'.
     * 
     * @param bSysIndAgeChange the value of field 'bSysIndAgeChange'
     */
    public void setBSysIndAgeChange(java.lang.String bSysIndAgeChange)
    {
        this._bSysIndAgeChange = bSysIndAgeChange;
    } //-- void setBSysIndAgeChange(java.lang.String) 

    /**
     * Sets the value of field 'CFAD01UIG00_ARRAY'.
     * 
     * @param CFAD01UIG00_ARRAY the value of field
     * 'CFAD01UIG00_ARRAY'.
     */
    public void setCFAD01UIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY CFAD01UIG00_ARRAY)
    {
        this._CFAD01UIG00_ARRAY = CFAD01UIG00_ARRAY;
    } //-- void setCFAD01UIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY) 

    /**
     * Sets the value of field 'cSysIndCategoryChange'.
     * 
     * @param cSysIndCategoryChange the value of field
     * 'cSysIndCategoryChange'.
     */
    public void setCSysIndCategoryChange(java.lang.String cSysIndCategoryChange)
    {
        this._cSysIndCategoryChange = cSysIndCategoryChange;
    } //-- void setCSysIndCategoryChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndFosterTypeChange'.
     * 
     * @param cSysIndFosterTypeChange the value of field
     * 'cSysIndFosterTypeChange'.
     */
    public void setCSysIndFosterTypeChange(java.lang.String cSysIndFosterTypeChange)
    {
        this._cSysIndFosterTypeChange = cSysIndFosterTypeChange;
    } //-- void setCSysIndFosterTypeChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsrcCharChg'.
     * 
     * @param cSysIndRsrcCharChg the value of field
     * 'cSysIndRsrcCharChg'.
     */
    public void setCSysIndRsrcCharChg(java.lang.String cSysIndRsrcCharChg)
    {
        this._cSysIndRsrcCharChg = cSysIndRsrcCharChg;
    } //-- void setCSysIndRsrcCharChg(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsrcCharChgNoSvc'.
     * 
     * @param cSysIndRsrcCharChgNoSvc the value of field
     * 'cSysIndRsrcCharChgNoSvc'.
     */
    public void setCSysIndRsrcCharChgNoSvc(java.lang.String cSysIndRsrcCharChgNoSvc)
    {
        this._cSysIndRsrcCharChgNoSvc = cSysIndRsrcCharChgNoSvc;
    } //-- void setCSysIndRsrcCharChgNoSvc(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsrcPrsChg'.
     * 
     * @param cSysIndRsrcPrsChg the value of field
     * 'cSysIndRsrcPrsChg'.
     */
    public void setCSysIndRsrcPrsChg(java.lang.String cSysIndRsrcPrsChg)
    {
        this._cSysIndRsrcPrsChg = cSysIndRsrcPrsChg;
    } //-- void setCSysIndRsrcPrsChg(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsFaHomeStatus'.
     * 
     * @param szCdRshsFaHomeStatus the value of field
     * 'szCdRshsFaHomeStatus'.
     */
    public void setSzCdRshsFaHomeStatus(java.lang.String szCdRshsFaHomeStatus)
    {
        this._szCdRshsFaHomeStatus = szCdRshsFaHomeStatus;
    } //-- void setSzCdRshsFaHomeStatus(java.lang.String) 

    /**
     * Sets the value of field 'uNbrRsrcFMAgeMax'.
     * 
     * @param uNbrRsrcFMAgeMax the value of field 'uNbrRsrcFMAgeMax'
     */
    public void setUNbrRsrcFMAgeMax(int uNbrRsrcFMAgeMax)
    {
        this._uNbrRsrcFMAgeMax = uNbrRsrcFMAgeMax;
        this._has_uNbrRsrcFMAgeMax = true;
    } //-- void setUNbrRsrcFMAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcFMAgeMin'.
     * 
     * @param uNbrRsrcFMAgeMin the value of field 'uNbrRsrcFMAgeMin'
     */
    public void setUNbrRsrcFMAgeMin(int uNbrRsrcFMAgeMin)
    {
        this._uNbrRsrcFMAgeMin = uNbrRsrcFMAgeMin;
        this._has_uNbrRsrcFMAgeMin = true;
    } //-- void setUNbrRsrcFMAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRsrcMlAgeMax'.
     * 
     * @param uNbrRsrcMlAgeMax the value of field 'uNbrRsrcMlAgeMax'
     */
    public void setUNbrRsrcMlAgeMax(int uNbrRsrcMlAgeMax)
    {
        this._uNbrRsrcMlAgeMax = uNbrRsrcMlAgeMax;
        this._has_uNbrRsrcMlAgeMax = true;
    } //-- void setUNbrRsrcMlAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcMlAgeMin'.
     * 
     * @param uNbrRsrcMlAgeMin the value of field 'uNbrRsrcMlAgeMin'
     */
    public void setUNbrRsrcMlAgeMin(int uNbrRsrcMlAgeMin)
    {
        this._uNbrRsrcMlAgeMin = uNbrRsrcMlAgeMin;
        this._has_uNbrRsrcMlAgeMin = true;
    } //-- void setUNbrRsrcMlAgeMin(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI unmarshal(java.io.Reader) 

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
