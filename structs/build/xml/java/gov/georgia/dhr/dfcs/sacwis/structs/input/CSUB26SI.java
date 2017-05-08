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
 * Class CSUB26SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB26SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdEventStatus_ARRAY_CSUB26SI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY_CSUB26SI _szCdEventStatus_ARRAY_CSUB26SI;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _dtDtPlcmtPermEff
     */
    private org.exolab.castor.types.Date _dtDtPlcmtPermEff;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _sysIndNewActualPlcmt
     */
    private java.lang.String _sysIndNewActualPlcmt;

    /**
     * Field _sysIndNewRemovalPlcmt
     */
    private java.lang.String _sysIndNewRemovalPlcmt;

    /**
     * Field _cSysIndPlcmtDifMedAdr
     */
    private java.lang.String _cSysIndPlcmtDifMedAdr;

    /**
     * Field _cSysIndPlcmtFacCntrct
     */
    private java.lang.String _cSysIndPlcmtFacCntrct;

    /**
     * Field _cSysIndPlcmtFacilProf
     */
    private java.lang.String _cSysIndPlcmtFacilProf;

    /**
     * Field _cSysIndPlcmtChgAdrAdm
     */
    private java.lang.String _cSysIndPlcmtChgAdrAdm;

    /**
     * Field _cSysIndPlcmtLocMatch
     */
    private java.lang.String _cSysIndPlcmtLocMatch;

    /**
     * Field _bSysIndPrfrmValidation
     */
    private java.lang.String _bSysIndPrfrmValidation;

    /**
     * Field _bIndSavePressed
     */
    private boolean _bIndSavePressed;

    /**
     * keeps track of state for field: _bIndSavePressed
     */
    private boolean _has_bIndSavePressed;

    /**
     * Field _bIndSpecialAccess
     */
    private java.lang.String _bIndSpecialAccess;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdEvent_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY _ulIdEvent_ARRAY;

    /**
     * Field _CSUB26SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00 _CSUB26SIG00;

    /**
     * Field _CSUB26SIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG01 _CSUB26SIG01;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB26SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndSavePressed()
    {
        this._has_bIndSavePressed= false;
    } //-- void deleteBIndSavePressed() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

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
     * Returns the value of field 'bIndSavePressed'.
     * 
     * @return the value of field 'BIndSavePressed'.
     */
    public boolean getBIndSavePressed()
    {
        return this._bIndSavePressed;
    } //-- boolean getBIndSavePressed() 

    /**
     * Returns the value of field 'bIndSpecialAccess'.
     * 
     * @return the value of field 'BIndSpecialAccess'.
     */
    public java.lang.String getBIndSpecialAccess()
    {
        return this._bIndSpecialAccess;
    } //-- java.lang.String getBIndSpecialAccess() 

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
     * Returns the value of field 'bSysIndPrfrmValidation'.
     * 
     * @return the value of field 'BSysIndPrfrmValidation'.
     */
    public java.lang.String getBSysIndPrfrmValidation()
    {
        return this._bSysIndPrfrmValidation;
    } //-- java.lang.String getBSysIndPrfrmValidation() 

    /**
     * Returns the value of field 'CSUB26SIG00'.
     * 
     * @return the value of field 'CSUB26SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00 getCSUB26SIG00()
    {
        return this._CSUB26SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00 getCSUB26SIG00() 

    /**
     * Returns the value of field 'CSUB26SIG01'.
     * 
     * @return the value of field 'CSUB26SIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG01 getCSUB26SIG01()
    {
        return this._CSUB26SIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG01 getCSUB26SIG01() 

    /**
     * Returns the value of field 'cSysIndPlcmtChgAdrAdm'.
     * 
     * @return the value of field 'CSysIndPlcmtChgAdrAdm'.
     */
    public java.lang.String getCSysIndPlcmtChgAdrAdm()
    {
        return this._cSysIndPlcmtChgAdrAdm;
    } //-- java.lang.String getCSysIndPlcmtChgAdrAdm() 

    /**
     * Returns the value of field 'cSysIndPlcmtDifMedAdr'.
     * 
     * @return the value of field 'CSysIndPlcmtDifMedAdr'.
     */
    public java.lang.String getCSysIndPlcmtDifMedAdr()
    {
        return this._cSysIndPlcmtDifMedAdr;
    } //-- java.lang.String getCSysIndPlcmtDifMedAdr() 

    /**
     * Returns the value of field 'cSysIndPlcmtFacCntrct'.
     * 
     * @return the value of field 'CSysIndPlcmtFacCntrct'.
     */
    public java.lang.String getCSysIndPlcmtFacCntrct()
    {
        return this._cSysIndPlcmtFacCntrct;
    } //-- java.lang.String getCSysIndPlcmtFacCntrct() 

    /**
     * Returns the value of field 'cSysIndPlcmtFacilProf'.
     * 
     * @return the value of field 'CSysIndPlcmtFacilProf'.
     */
    public java.lang.String getCSysIndPlcmtFacilProf()
    {
        return this._cSysIndPlcmtFacilProf;
    } //-- java.lang.String getCSysIndPlcmtFacilProf() 

    /**
     * Returns the value of field 'cSysIndPlcmtLocMatch'.
     * 
     * @return the value of field 'CSysIndPlcmtLocMatch'.
     */
    public java.lang.String getCSysIndPlcmtLocMatch()
    {
        return this._cSysIndPlcmtLocMatch;
    } //-- java.lang.String getCSysIndPlcmtLocMatch() 

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
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'sysIndNewActualPlcmt'.
     * 
     * @return the value of field 'SysIndNewActualPlcmt'.
     */
    public java.lang.String getSysIndNewActualPlcmt()
    {
        return this._sysIndNewActualPlcmt;
    } //-- java.lang.String getSysIndNewActualPlcmt() 

    /**
     * Returns the value of field 'sysIndNewRemovalPlcmt'.
     * 
     * @return the value of field 'SysIndNewRemovalPlcmt'.
     */
    public java.lang.String getSysIndNewRemovalPlcmt()
    {
        return this._sysIndNewRemovalPlcmt;
    } //-- java.lang.String getSysIndNewRemovalPlcmt() 

    /**
     * Returns the value of field 'szCdEventStatus_ARRAY_CSUB26SI'.
     * 
     * @return the value of field 'SzCdEventStatus_ARRAY_CSUB26SI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY_CSUB26SI getSzCdEventStatus_ARRAY_CSUB26SI()
    {
        return this._szCdEventStatus_ARRAY_CSUB26SI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY_CSUB26SI getSzCdEventStatus_ARRAY_CSUB26SI() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

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
     * Returns the value of field 'ulIdEvent_ARRAY'.
     * 
     * @return the value of field 'UlIdEvent_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY getUlIdEvent_ARRAY()
    {
        return this._ulIdEvent_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY getUlIdEvent_ARRAY() 

    /**
     * Method hasBIndSavePressed
     * 
     * 
     * 
     * @return true if at least one BIndSavePressed has been added
     */
    public boolean hasBIndSavePressed()
    {
        return this._has_bIndSavePressed;
    } //-- boolean hasBIndSavePressed() 

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
     * Returns the value of field 'bIndSavePressed'.
     * 
     * @return the value of field 'BIndSavePressed'.
     */
    public boolean isBIndSavePressed()
    {
        return this._bIndSavePressed;
    } //-- boolean isBIndSavePressed() 

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
     * Sets the value of field 'bIndSavePressed'.
     * 
     * @param bIndSavePressed the value of field 'bIndSavePressed'.
     */
    public void setBIndSavePressed(boolean bIndSavePressed)
    {
        this._bIndSavePressed = bIndSavePressed;
        this._has_bIndSavePressed = true;
    } //-- void setBIndSavePressed(boolean) 

    /**
     * Sets the value of field 'bIndSpecialAccess'.
     * 
     * @param bIndSpecialAccess the value of field
     * 'bIndSpecialAccess'.
     */
    public void setBIndSpecialAccess(java.lang.String bIndSpecialAccess)
    {
        this._bIndSpecialAccess = bIndSpecialAccess;
    } //-- void setBIndSpecialAccess(java.lang.String) 

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
     * Sets the value of field 'bSysIndPrfrmValidation'.
     * 
     * @param bSysIndPrfrmValidation the value of field
     * 'bSysIndPrfrmValidation'.
     */
    public void setBSysIndPrfrmValidation(java.lang.String bSysIndPrfrmValidation)
    {
        this._bSysIndPrfrmValidation = bSysIndPrfrmValidation;
    } //-- void setBSysIndPrfrmValidation(java.lang.String) 

    /**
     * Sets the value of field 'CSUB26SIG00'.
     * 
     * @param CSUB26SIG00 the value of field 'CSUB26SIG00'.
     */
    public void setCSUB26SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00 CSUB26SIG00)
    {
        this._CSUB26SIG00 = CSUB26SIG00;
    } //-- void setCSUB26SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00) 

    /**
     * Sets the value of field 'CSUB26SIG01'.
     * 
     * @param CSUB26SIG01 the value of field 'CSUB26SIG01'.
     */
    public void setCSUB26SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG01 CSUB26SIG01)
    {
        this._CSUB26SIG01 = CSUB26SIG01;
    } //-- void setCSUB26SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG01) 

    /**
     * Sets the value of field 'cSysIndPlcmtChgAdrAdm'.
     * 
     * @param cSysIndPlcmtChgAdrAdm the value of field
     * 'cSysIndPlcmtChgAdrAdm'.
     */
    public void setCSysIndPlcmtChgAdrAdm(java.lang.String cSysIndPlcmtChgAdrAdm)
    {
        this._cSysIndPlcmtChgAdrAdm = cSysIndPlcmtChgAdrAdm;
    } //-- void setCSysIndPlcmtChgAdrAdm(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPlcmtDifMedAdr'.
     * 
     * @param cSysIndPlcmtDifMedAdr the value of field
     * 'cSysIndPlcmtDifMedAdr'.
     */
    public void setCSysIndPlcmtDifMedAdr(java.lang.String cSysIndPlcmtDifMedAdr)
    {
        this._cSysIndPlcmtDifMedAdr = cSysIndPlcmtDifMedAdr;
    } //-- void setCSysIndPlcmtDifMedAdr(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPlcmtFacCntrct'.
     * 
     * @param cSysIndPlcmtFacCntrct the value of field
     * 'cSysIndPlcmtFacCntrct'.
     */
    public void setCSysIndPlcmtFacCntrct(java.lang.String cSysIndPlcmtFacCntrct)
    {
        this._cSysIndPlcmtFacCntrct = cSysIndPlcmtFacCntrct;
    } //-- void setCSysIndPlcmtFacCntrct(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPlcmtFacilProf'.
     * 
     * @param cSysIndPlcmtFacilProf the value of field
     * 'cSysIndPlcmtFacilProf'.
     */
    public void setCSysIndPlcmtFacilProf(java.lang.String cSysIndPlcmtFacilProf)
    {
        this._cSysIndPlcmtFacilProf = cSysIndPlcmtFacilProf;
    } //-- void setCSysIndPlcmtFacilProf(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPlcmtLocMatch'.
     * 
     * @param cSysIndPlcmtLocMatch the value of field
     * 'cSysIndPlcmtLocMatch'.
     */
    public void setCSysIndPlcmtLocMatch(java.lang.String cSysIndPlcmtLocMatch)
    {
        this._cSysIndPlcmtLocMatch = cSysIndPlcmtLocMatch;
    } //-- void setCSysIndPlcmtLocMatch(java.lang.String) 

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
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'sysIndNewActualPlcmt'.
     * 
     * @param sysIndNewActualPlcmt the value of field
     * 'sysIndNewActualPlcmt'.
     */
    public void setSysIndNewActualPlcmt(java.lang.String sysIndNewActualPlcmt)
    {
        this._sysIndNewActualPlcmt = sysIndNewActualPlcmt;
    } //-- void setSysIndNewActualPlcmt(java.lang.String) 

    /**
     * Sets the value of field 'sysIndNewRemovalPlcmt'.
     * 
     * @param sysIndNewRemovalPlcmt the value of field
     * 'sysIndNewRemovalPlcmt'.
     */
    public void setSysIndNewRemovalPlcmt(java.lang.String sysIndNewRemovalPlcmt)
    {
        this._sysIndNewRemovalPlcmt = sysIndNewRemovalPlcmt;
    } //-- void setSysIndNewRemovalPlcmt(java.lang.String) 

    /**
     * Sets the value of field 'szCdEventStatus_ARRAY_CSUB26SI'.
     * 
     * @param szCdEventStatus_ARRAY_CSUB26SI the value of field
     * 'szCdEventStatus_ARRAY_CSUB26SI'.
     */
    public void setSzCdEventStatus_ARRAY_CSUB26SI(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY_CSUB26SI szCdEventStatus_ARRAY_CSUB26SI)
    {
        this._szCdEventStatus_ARRAY_CSUB26SI = szCdEventStatus_ARRAY_CSUB26SI;
    } //-- void setSzCdEventStatus_ARRAY_CSUB26SI(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY_CSUB26SI) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

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
     * Sets the value of field 'ulIdEvent_ARRAY'.
     * 
     * @param ulIdEvent_ARRAY the value of field 'ulIdEvent_ARRAY'.
     */
    public void setUlIdEvent_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY ulIdEvent_ARRAY)
    {
        this._ulIdEvent_ARRAY = ulIdEvent_ARRAY;
    } //-- void setUlIdEvent_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI unmarshal(java.io.Reader) 

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
