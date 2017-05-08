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
 * Class CSUB15SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB15SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulPageSizeNbr_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY _ulPageSizeNbr_ARRAY;

    /**
     * Field _szSysCdWinMode
     */
    private java.lang.String _szSysCdWinMode;

    /**
     * Field _bWCDIndSearchChange
     */
    private java.lang.String _bWCDIndSearchChange;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _ROWCSUB15SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00 _ROWCSUB15SIG00;

    /**
     * Field _ROWCSUB15SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01_ARRAY _ROWCSUB15SIG01_ARRAY;

    /**
     * Field _ROWCSUB15SIG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02_ARRAY _ROWCSUB15SIG02_ARRAY;

    /**
     * Field _ROWCSUB15SIG03_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY _ROWCSUB15SIG03_ARRAY;

    /**
     * Field _szCdAttrStateOfficeMgmt
     */
    private java.lang.String _szCdAttrStateOfficeMgmt;

    /**
     * Field _szCdAttrRegSsStf
     */
    private java.lang.String _szCdAttrRegSsStf;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB15SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

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
     * Returns the value of field 'bWCDIndSearchChange'.
     * 
     * @return the value of field 'BWCDIndSearchChange'.
     */
    public java.lang.String getBWCDIndSearchChange()
    {
        return this._bWCDIndSearchChange;
    } //-- java.lang.String getBWCDIndSearchChange() 

    /**
     * Returns the value of field 'dtDtPersonBirth'.
     * 
     * @return the value of field 'DtDtPersonBirth'.
     */
    public org.exolab.castor.types.Date getDtDtPersonBirth()
    {
        return this._dtDtPersonBirth;
    } //-- org.exolab.castor.types.Date getDtDtPersonBirth() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'ROWCSUB15SIG00'.
     * 
     * @return the value of field 'ROWCSUB15SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00 getROWCSUB15SIG00()
    {
        return this._ROWCSUB15SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00 getROWCSUB15SIG00() 

    /**
     * Returns the value of field 'ROWCSUB15SIG01_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB15SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01_ARRAY getROWCSUB15SIG01_ARRAY()
    {
        return this._ROWCSUB15SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01_ARRAY getROWCSUB15SIG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCSUB15SIG02_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB15SIG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02_ARRAY getROWCSUB15SIG02_ARRAY()
    {
        return this._ROWCSUB15SIG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02_ARRAY getROWCSUB15SIG02_ARRAY() 

    /**
     * Returns the value of field 'ROWCSUB15SIG03_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB15SIG03_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY getROWCSUB15SIG03_ARRAY()
    {
        return this._ROWCSUB15SIG03_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY getROWCSUB15SIG03_ARRAY() 

    /**
     * Returns the value of field 'szCdAttrRegSsStf'.
     * 
     * @return the value of field 'SzCdAttrRegSsStf'.
     */
    public java.lang.String getSzCdAttrRegSsStf()
    {
        return this._szCdAttrRegSsStf;
    } //-- java.lang.String getSzCdAttrRegSsStf() 

    /**
     * Returns the value of field 'szCdAttrStateOfficeMgmt'.
     * 
     * @return the value of field 'SzCdAttrStateOfficeMgmt'.
     */
    public java.lang.String getSzCdAttrStateOfficeMgmt()
    {
        return this._szCdAttrStateOfficeMgmt;
    } //-- java.lang.String getSzCdAttrStateOfficeMgmt() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szSysCdWinMode'.
     * 
     * @return the value of field 'SzSysCdWinMode'.
     */
    public java.lang.String getSzSysCdWinMode()
    {
        return this._szSysCdWinMode;
    } //-- java.lang.String getSzSysCdWinMode() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Returns the value of field 'ulPageSizeNbr_ARRAY'.
     * 
     * @return the value of field 'UlPageSizeNbr_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY getUlPageSizeNbr_ARRAY()
    {
        return this._ulPageSizeNbr_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY getUlPageSizeNbr_ARRAY() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Sets the value of field 'bWCDIndSearchChange'.
     * 
     * @param bWCDIndSearchChange the value of field
     * 'bWCDIndSearchChange'.
     */
    public void setBWCDIndSearchChange(java.lang.String bWCDIndSearchChange)
    {
        this._bWCDIndSearchChange = bWCDIndSearchChange;
    } //-- void setBWCDIndSearchChange(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPersonBirth'.
     * 
     * @param dtDtPersonBirth the value of field 'dtDtPersonBirth'.
     */
    public void setDtDtPersonBirth(org.exolab.castor.types.Date dtDtPersonBirth)
    {
        this._dtDtPersonBirth = dtDtPersonBirth;
    } //-- void setDtDtPersonBirth(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'ROWCSUB15SIG00'.
     * 
     * @param ROWCSUB15SIG00 the value of field 'ROWCSUB15SIG00'.
     */
    public void setROWCSUB15SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00 ROWCSUB15SIG00)
    {
        this._ROWCSUB15SIG00 = ROWCSUB15SIG00;
    } //-- void setROWCSUB15SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00) 

    /**
     * Sets the value of field 'ROWCSUB15SIG01_ARRAY'.
     * 
     * @param ROWCSUB15SIG01_ARRAY the value of field
     * 'ROWCSUB15SIG01_ARRAY'.
     */
    public void setROWCSUB15SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01_ARRAY ROWCSUB15SIG01_ARRAY)
    {
        this._ROWCSUB15SIG01_ARRAY = ROWCSUB15SIG01_ARRAY;
    } //-- void setROWCSUB15SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCSUB15SIG02_ARRAY'.
     * 
     * @param ROWCSUB15SIG02_ARRAY the value of field
     * 'ROWCSUB15SIG02_ARRAY'.
     */
    public void setROWCSUB15SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02_ARRAY ROWCSUB15SIG02_ARRAY)
    {
        this._ROWCSUB15SIG02_ARRAY = ROWCSUB15SIG02_ARRAY;
    } //-- void setROWCSUB15SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02_ARRAY) 

    /**
     * Sets the value of field 'ROWCSUB15SIG03_ARRAY'.
     * 
     * @param ROWCSUB15SIG03_ARRAY the value of field
     * 'ROWCSUB15SIG03_ARRAY'.
     */
    public void setROWCSUB15SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY ROWCSUB15SIG03_ARRAY)
    {
        this._ROWCSUB15SIG03_ARRAY = ROWCSUB15SIG03_ARRAY;
    } //-- void setROWCSUB15SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY) 

    /**
     * Sets the value of field 'szCdAttrRegSsStf'.
     * 
     * @param szCdAttrRegSsStf the value of field 'szCdAttrRegSsStf'
     */
    public void setSzCdAttrRegSsStf(java.lang.String szCdAttrRegSsStf)
    {
        this._szCdAttrRegSsStf = szCdAttrRegSsStf;
    } //-- void setSzCdAttrRegSsStf(java.lang.String) 

    /**
     * Sets the value of field 'szCdAttrStateOfficeMgmt'.
     * 
     * @param szCdAttrStateOfficeMgmt the value of field
     * 'szCdAttrStateOfficeMgmt'.
     */
    public void setSzCdAttrStateOfficeMgmt(java.lang.String szCdAttrStateOfficeMgmt)
    {
        this._szCdAttrStateOfficeMgmt = szCdAttrStateOfficeMgmt;
    } //-- void setSzCdAttrStateOfficeMgmt(java.lang.String) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szSysCdWinMode'.
     * 
     * @param szSysCdWinMode the value of field 'szSysCdWinMode'.
     */
    public void setSzSysCdWinMode(java.lang.String szSysCdWinMode)
    {
        this._szSysCdWinMode = szSysCdWinMode;
    } //-- void setSzSysCdWinMode(java.lang.String) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

    /**
     * Sets the value of field 'ulPageSizeNbr_ARRAY'.
     * 
     * @param ulPageSizeNbr_ARRAY the value of field
     * 'ulPageSizeNbr_ARRAY'.
     */
    public void setUlPageSizeNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY)
    {
        this._ulPageSizeNbr_ARRAY = ulPageSizeNbr_ARRAY;
    } //-- void setUlPageSizeNbr_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI unmarshal(java.io.Reader) 

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
