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
 * Class CSUB25SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB25SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _bIndBLOBExistsInDatabase_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY _bIndBLOBExistsInDatabase_ARRAY;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _szCdPlocChild
     */
    private java.lang.String _szCdPlocChild;

    /**
     * Field _CSUB25SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00 _CSUB25SOG00;

    /**
     * Field _CSUB25SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01 _CSUB25SOG01;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _cCdRsrcFaHomeType1
     */
    private java.lang.String _cCdRsrcFaHomeType1;

    /**
     * Field _cCdRsrcFaHomeType2
     */
    private java.lang.String _cCdRsrcFaHomeType2;

    /**
     * Field _cCdRsrcFaHomeType3
     */
    private java.lang.String _cCdRsrcFaHomeType3;

    /**
     * Field _cCdRsrcFaHomeType4
     */
    private java.lang.String _cCdRsrcFaHomeType4;

    /**
     * Field _cCdRsrcFaHomeType5
     */
    private java.lang.String _cCdRsrcFaHomeType5;

    /**
     * Field _cCdRsrcFaHomeType6
     */
    private java.lang.String _cCdRsrcFaHomeType6;

    /**
     * Field _cCdRsrcFaHomeType7
     */
    private java.lang.String _cCdRsrcFaHomeType7;

    /**
     * Field _szCdRsrcCategory
     */
    private java.lang.String _szCdRsrcCategory;

    /**
     * Field _cIndRsrcEmergPlace
     */
    private java.lang.String _cIndRsrcEmergPlace;

    /**
     * Field _dtDtPlcmtPermEff
     */
    private org.exolab.castor.types.Date _dtDtPlcmtPermEff;

    /**
     * Field _cIndRsrcStatus
     */
    private java.lang.String _cIndRsrcStatus;

    /**
     * Field _CSUB25SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY _CSUB25SOG02_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB25SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'bIndBLOBExistsInDatabase_ARRAY'.
     * 
     * @return the value of field 'BIndBLOBExistsInDatabase_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY getBIndBLOBExistsInDatabase_ARRAY()
    {
        return this._bIndBLOBExistsInDatabase_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY getBIndBLOBExistsInDatabase_ARRAY() 

    /**
     * Returns the value of field 'bSysIndGeneric'.
     * 
     * @return the value of field 'BSysIndGeneric'.
     */
    public java.lang.String getBSysIndGeneric()
    {
        return this._bSysIndGeneric;
    } //-- java.lang.String getBSysIndGeneric() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType1'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType1'.
     */
    public java.lang.String getCCdRsrcFaHomeType1()
    {
        return this._cCdRsrcFaHomeType1;
    } //-- java.lang.String getCCdRsrcFaHomeType1() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType2'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType2'.
     */
    public java.lang.String getCCdRsrcFaHomeType2()
    {
        return this._cCdRsrcFaHomeType2;
    } //-- java.lang.String getCCdRsrcFaHomeType2() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType3'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType3'.
     */
    public java.lang.String getCCdRsrcFaHomeType3()
    {
        return this._cCdRsrcFaHomeType3;
    } //-- java.lang.String getCCdRsrcFaHomeType3() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType4'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType4'.
     */
    public java.lang.String getCCdRsrcFaHomeType4()
    {
        return this._cCdRsrcFaHomeType4;
    } //-- java.lang.String getCCdRsrcFaHomeType4() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType5'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType5'.
     */
    public java.lang.String getCCdRsrcFaHomeType5()
    {
        return this._cCdRsrcFaHomeType5;
    } //-- java.lang.String getCCdRsrcFaHomeType5() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType6'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType6'.
     */
    public java.lang.String getCCdRsrcFaHomeType6()
    {
        return this._cCdRsrcFaHomeType6;
    } //-- java.lang.String getCCdRsrcFaHomeType6() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType7'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType7'.
     */
    public java.lang.String getCCdRsrcFaHomeType7()
    {
        return this._cCdRsrcFaHomeType7;
    } //-- java.lang.String getCCdRsrcFaHomeType7() 

    /**
     * Returns the value of field 'cIndRsrcEmergPlace'.
     * 
     * @return the value of field 'CIndRsrcEmergPlace'.
     */
    public java.lang.String getCIndRsrcEmergPlace()
    {
        return this._cIndRsrcEmergPlace;
    } //-- java.lang.String getCIndRsrcEmergPlace() 

    /**
     * Returns the value of field 'cIndRsrcStatus'.
     * 
     * @return the value of field 'CIndRsrcStatus'.
     */
    public java.lang.String getCIndRsrcStatus()
    {
        return this._cIndRsrcStatus;
    } //-- java.lang.String getCIndRsrcStatus() 

    /**
     * Returns the value of field 'CSUB25SOG00'.
     * 
     * @return the value of field 'CSUB25SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00 getCSUB25SOG00()
    {
        return this._CSUB25SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00 getCSUB25SOG00() 

    /**
     * Returns the value of field 'CSUB25SOG01'.
     * 
     * @return the value of field 'CSUB25SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01 getCSUB25SOG01()
    {
        return this._CSUB25SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01 getCSUB25SOG01() 

    /**
     * Returns the value of field 'CSUB25SOG02_ARRAY'.
     * 
     * @return the value of field 'CSUB25SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY getCSUB25SOG02_ARRAY()
    {
        return this._CSUB25SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY getCSUB25SOG02_ARRAY() 

    /**
     * Returns the value of field 'dtDtPlcmtPermEff'.
     * 
     * @return the value of field 'DtDtPlcmtPermEff'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtPermEff()
    {
        return this._dtDtPlcmtPermEff;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtPermEff() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00() 

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
     * Returns the value of field 'szCdPlocChild'.
     * 
     * @return the value of field 'SzCdPlocChild'.
     */
    public java.lang.String getSzCdPlocChild()
    {
        return this._szCdPlocChild;
    } //-- java.lang.String getSzCdPlocChild() 

    /**
     * Returns the value of field 'szCdRsrcCategory'.
     * 
     * @return the value of field 'SzCdRsrcCategory'.
     */
    public java.lang.String getSzCdRsrcCategory()
    {
        return this._szCdRsrcCategory;
    } //-- java.lang.String getSzCdRsrcCategory() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

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
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'bIndBLOBExistsInDatabase_ARRAY'.
     * 
     * @param bIndBLOBExistsInDatabase_ARRAY the value of field
     * 'bIndBLOBExistsInDatabase_ARRAY'.
     */
    public void setBIndBLOBExistsInDatabase_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY bIndBLOBExistsInDatabase_ARRAY)
    {
        this._bIndBLOBExistsInDatabase_ARRAY = bIndBLOBExistsInDatabase_ARRAY;
    } //-- void setBIndBLOBExistsInDatabase_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.BIndBLOBExistsInDatabase_ARRAY) 

    /**
     * Sets the value of field 'bSysIndGeneric'.
     * 
     * @param bSysIndGeneric the value of field 'bSysIndGeneric'.
     */
    public void setBSysIndGeneric(java.lang.String bSysIndGeneric)
    {
        this._bSysIndGeneric = bSysIndGeneric;
    } //-- void setBSysIndGeneric(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType1'.
     * 
     * @param cCdRsrcFaHomeType1 the value of field
     * 'cCdRsrcFaHomeType1'.
     */
    public void setCCdRsrcFaHomeType1(java.lang.String cCdRsrcFaHomeType1)
    {
        this._cCdRsrcFaHomeType1 = cCdRsrcFaHomeType1;
    } //-- void setCCdRsrcFaHomeType1(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType2'.
     * 
     * @param cCdRsrcFaHomeType2 the value of field
     * 'cCdRsrcFaHomeType2'.
     */
    public void setCCdRsrcFaHomeType2(java.lang.String cCdRsrcFaHomeType2)
    {
        this._cCdRsrcFaHomeType2 = cCdRsrcFaHomeType2;
    } //-- void setCCdRsrcFaHomeType2(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType3'.
     * 
     * @param cCdRsrcFaHomeType3 the value of field
     * 'cCdRsrcFaHomeType3'.
     */
    public void setCCdRsrcFaHomeType3(java.lang.String cCdRsrcFaHomeType3)
    {
        this._cCdRsrcFaHomeType3 = cCdRsrcFaHomeType3;
    } //-- void setCCdRsrcFaHomeType3(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType4'.
     * 
     * @param cCdRsrcFaHomeType4 the value of field
     * 'cCdRsrcFaHomeType4'.
     */
    public void setCCdRsrcFaHomeType4(java.lang.String cCdRsrcFaHomeType4)
    {
        this._cCdRsrcFaHomeType4 = cCdRsrcFaHomeType4;
    } //-- void setCCdRsrcFaHomeType4(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType5'.
     * 
     * @param cCdRsrcFaHomeType5 the value of field
     * 'cCdRsrcFaHomeType5'.
     */
    public void setCCdRsrcFaHomeType5(java.lang.String cCdRsrcFaHomeType5)
    {
        this._cCdRsrcFaHomeType5 = cCdRsrcFaHomeType5;
    } //-- void setCCdRsrcFaHomeType5(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType6'.
     * 
     * @param cCdRsrcFaHomeType6 the value of field
     * 'cCdRsrcFaHomeType6'.
     */
    public void setCCdRsrcFaHomeType6(java.lang.String cCdRsrcFaHomeType6)
    {
        this._cCdRsrcFaHomeType6 = cCdRsrcFaHomeType6;
    } //-- void setCCdRsrcFaHomeType6(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType7'.
     * 
     * @param cCdRsrcFaHomeType7 the value of field
     * 'cCdRsrcFaHomeType7'.
     */
    public void setCCdRsrcFaHomeType7(java.lang.String cCdRsrcFaHomeType7)
    {
        this._cCdRsrcFaHomeType7 = cCdRsrcFaHomeType7;
    } //-- void setCCdRsrcFaHomeType7(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcEmergPlace'.
     * 
     * @param cIndRsrcEmergPlace the value of field
     * 'cIndRsrcEmergPlace'.
     */
    public void setCIndRsrcEmergPlace(java.lang.String cIndRsrcEmergPlace)
    {
        this._cIndRsrcEmergPlace = cIndRsrcEmergPlace;
    } //-- void setCIndRsrcEmergPlace(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcStatus'.
     * 
     * @param cIndRsrcStatus the value of field 'cIndRsrcStatus'.
     */
    public void setCIndRsrcStatus(java.lang.String cIndRsrcStatus)
    {
        this._cIndRsrcStatus = cIndRsrcStatus;
    } //-- void setCIndRsrcStatus(java.lang.String) 

    /**
     * Sets the value of field 'CSUB25SOG00'.
     * 
     * @param CSUB25SOG00 the value of field 'CSUB25SOG00'.
     */
    public void setCSUB25SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00 CSUB25SOG00)
    {
        this._CSUB25SOG00 = CSUB25SOG00;
    } //-- void setCSUB25SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00) 

    /**
     * Sets the value of field 'CSUB25SOG01'.
     * 
     * @param CSUB25SOG01 the value of field 'CSUB25SOG01'.
     */
    public void setCSUB25SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01 CSUB25SOG01)
    {
        this._CSUB25SOG01 = CSUB25SOG01;
    } //-- void setCSUB25SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01) 

    /**
     * Sets the value of field 'CSUB25SOG02_ARRAY'.
     * 
     * @param CSUB25SOG02_ARRAY the value of field
     * 'CSUB25SOG02_ARRAY'.
     */
    public void setCSUB25SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY CSUB25SOG02_ARRAY)
    {
        this._CSUB25SOG02_ARRAY = CSUB25SOG02_ARRAY;
    } //-- void setCSUB25SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY) 

    /**
     * Sets the value of field 'dtDtPlcmtPermEff'.
     * 
     * @param dtDtPlcmtPermEff the value of field 'dtDtPlcmtPermEff'
     */
    public void setDtDtPlcmtPermEff(org.exolab.castor.types.Date dtDtPlcmtPermEff)
    {
        this._dtDtPlcmtPermEff = dtDtPlcmtPermEff;
    } //-- void setDtDtPlcmtPermEff(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00) 

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
     * Sets the value of field 'szCdPlocChild'.
     * 
     * @param szCdPlocChild the value of field 'szCdPlocChild'.
     */
    public void setSzCdPlocChild(java.lang.String szCdPlocChild)
    {
        this._szCdPlocChild = szCdPlocChild;
    } //-- void setSzCdPlocChild(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcCategory'.
     * 
     * @param szCdRsrcCategory the value of field 'szCdRsrcCategory'
     */
    public void setSzCdRsrcCategory(java.lang.String szCdRsrcCategory)
    {
        this._szCdRsrcCategory = szCdRsrcCategory;
    } //-- void setSzCdRsrcCategory(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO unmarshal(java.io.Reader) 

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
