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
 * Class CCON18SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON18SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCON18SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00_ARRAY _ROWCCON18SOG00_ARRAY;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _ulIdSvcAuth
     */
    private int _ulIdSvcAuth;

    /**
     * keeps track of state for field: _ulIdSvcAuth
     */
    private boolean _has_ulIdSvcAuth;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdSvcAuthCounty
     */
    private java.lang.String _szCdSvcAuthCounty;

    /**
     * Field _szTxtSvcAuthComments
     */
    private java.lang.String _szTxtSvcAuthComments;

    /**
     * Field _szTxtSvcAuthSecProvdr
     */
    private java.lang.String _szTxtSvcAuthSecProvdr;

    /**
     * Field _cIndSvcAuthComplete
     */
    private java.lang.String _cIndSvcAuthComplete;

    /**
     * Field _szCdSvcAuthRegion
     */
    private java.lang.String _szCdSvcAuthRegion;

    /**
     * Field _szCdSvcAuthService
     */
    private java.lang.String _szCdSvcAuthService;

    /**
     * Field _szCdSvcAuthCategory
     */
    private java.lang.String _szCdSvcAuthCategory;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _ulIdCntrctManager
     */
    private int _ulIdCntrctManager;

    /**
     * keeps track of state for field: _ulIdCntrctManager
     */
    private boolean _has_ulIdCntrctManager;

    /**
     * Field _ulNbrCncntyPeriod
     */
    private int _ulNbrCncntyPeriod;

    /**
     * keeps track of state for field: _ulNbrCncntyPeriod
     */
    private boolean _has_ulNbrCncntyPeriod;

    /**
     * Field _ulNbrCncntyVersion
     */
    private int _ulNbrCncntyVersion;

    /**
     * keeps track of state for field: _ulNbrCncntyVersion
     */
    private boolean _has_ulNbrCncntyVersion;

    /**
     * Field _dtDtCnperClosure
     */
    private org.exolab.castor.types.Date _dtDtCnperClosure;

    /**
     * Field _dtDtCnperStart
     */
    private org.exolab.castor.types.Date _dtDtCnperStart;

    /**
     * Field _cIndCnperRenewal
     */
    private java.lang.String _cIndCnperRenewal;

    /**
     * Field _szCdCnperStatus
     */
    private java.lang.String _szCdCnperStatus;

    /**
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _cIndCntrctBudgLimit
     */
    private java.lang.String _cIndCntrctBudgLimit;

    /**
     * Field _bScrIndDtlRecExist
     */
    private java.lang.String _bScrIndDtlRecExist;

    /**
     * Field _dtDtSvcAuthEff
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthEff;

    /**
     * Field _dtDtSituationOpened
     */
    private org.exolab.castor.types.Date _dtDtSituationOpened;

    /**
     * Field _bIndStageClose
     */
    private java.lang.String _bIndStageClose;

    /**
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _error_message
     */
    private int _error_message;

    /**
     * keeps track of state for field: _error_message
     */
    private boolean _has_error_message;

    /**
     * Field _cIndDntdCmmtySvc
     */
    private java.lang.String _cIndDntdCmmtySvc;

    /**
     * Field _szCdPayCnty
     */
    private java.lang.String _szCdPayCnty;

    /**
     * Field _cIndWaiverReqd
     */
    private java.lang.String _cIndWaiverReqd;

    /**
     * Field _dtDtRefSent
     */
    private org.exolab.castor.types.Date _dtDtRefSent;

    /**
     * Field _szCdErlyCaseTyp
     */
    private java.lang.String _szCdErlyCaseTyp;

    /**
     * Field _szCdPupTyp
     */
    private java.lang.String _szCdPupTyp;

    /**
     * Field _szCdPupOtcme
     */
    private java.lang.String _szCdPupOtcme;

    /**
     * Field _ulIdWaiver
     */
    private int _ulIdWaiver;

    /**
     * keeps track of state for field: _ulIdWaiver
     */
    private boolean _has_ulIdWaiver;

    /**
     * Field _bIndBLOBExistsInDatabase
     */
    private java.lang.String _bIndBLOBExistsInDatabase;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON18SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteError_message()
    {
        this._has_error_message= false;
    } //-- void deleteError_message() 

    /**
     */
    public void deleteUlIdCntrctManager()
    {
        this._has_ulIdCntrctManager= false;
    } //-- void deleteUlIdCntrctManager() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdSvcAuth()
    {
        this._has_ulIdSvcAuth= false;
    } //-- void deleteUlIdSvcAuth() 

    /**
     */
    public void deleteUlIdWaiver()
    {
        this._has_ulIdWaiver= false;
    } //-- void deleteUlIdWaiver() 

    /**
     */
    public void deleteUlNbrCncntyPeriod()
    {
        this._has_ulNbrCncntyPeriod= false;
    } //-- void deleteUlNbrCncntyPeriod() 

    /**
     */
    public void deleteUlNbrCncntyVersion()
    {
        this._has_ulNbrCncntyVersion= false;
    } //-- void deleteUlNbrCncntyVersion() 

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
     * Returns the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @return the value of field 'BIndBLOBExistsInDatabase'.
     */
    public java.lang.String getBIndBLOBExistsInDatabase()
    {
        return this._bIndBLOBExistsInDatabase;
    } //-- java.lang.String getBIndBLOBExistsInDatabase() 

    /**
     * Returns the value of field 'bIndStageClose'.
     * 
     * @return the value of field 'BIndStageClose'.
     */
    public java.lang.String getBIndStageClose()
    {
        return this._bIndStageClose;
    } //-- java.lang.String getBIndStageClose() 

    /**
     * Returns the value of field 'bScrIndDtlRecExist'.
     * 
     * @return the value of field 'BScrIndDtlRecExist'.
     */
    public java.lang.String getBScrIndDtlRecExist()
    {
        return this._bScrIndDtlRecExist;
    } //-- java.lang.String getBScrIndDtlRecExist() 

    /**
     * Returns the value of field 'cIndCnperRenewal'.
     * 
     * @return the value of field 'CIndCnperRenewal'.
     */
    public java.lang.String getCIndCnperRenewal()
    {
        return this._cIndCnperRenewal;
    } //-- java.lang.String getCIndCnperRenewal() 

    /**
     * Returns the value of field 'cIndCntrctBudgLimit'.
     * 
     * @return the value of field 'CIndCntrctBudgLimit'.
     */
    public java.lang.String getCIndCntrctBudgLimit()
    {
        return this._cIndCntrctBudgLimit;
    } //-- java.lang.String getCIndCntrctBudgLimit() 

    /**
     * Returns the value of field 'cIndDntdCmmtySvc'.
     * 
     * @return the value of field 'CIndDntdCmmtySvc'.
     */
    public java.lang.String getCIndDntdCmmtySvc()
    {
        return this._cIndDntdCmmtySvc;
    } //-- java.lang.String getCIndDntdCmmtySvc() 

    /**
     * Returns the value of field 'cIndSvcAuthComplete'.
     * 
     * @return the value of field 'CIndSvcAuthComplete'.
     */
    public java.lang.String getCIndSvcAuthComplete()
    {
        return this._cIndSvcAuthComplete;
    } //-- java.lang.String getCIndSvcAuthComplete() 

    /**
     * Returns the value of field 'cIndWaiverReqd'.
     * 
     * @return the value of field 'CIndWaiverReqd'.
     */
    public java.lang.String getCIndWaiverReqd()
    {
        return this._cIndWaiverReqd;
    } //-- java.lang.String getCIndWaiverReqd() 

    /**
     * Returns the value of field 'dtDtCnperClosure'.
     * 
     * @return the value of field 'DtDtCnperClosure'.
     */
    public org.exolab.castor.types.Date getDtDtCnperClosure()
    {
        return this._dtDtCnperClosure;
    } //-- org.exolab.castor.types.Date getDtDtCnperClosure() 

    /**
     * Returns the value of field 'dtDtCnperStart'.
     * 
     * @return the value of field 'DtDtCnperStart'.
     */
    public org.exolab.castor.types.Date getDtDtCnperStart()
    {
        return this._dtDtCnperStart;
    } //-- org.exolab.castor.types.Date getDtDtCnperStart() 

    /**
     * Returns the value of field 'dtDtRefSent'.
     * 
     * @return the value of field 'DtDtRefSent'.
     */
    public org.exolab.castor.types.Date getDtDtRefSent()
    {
        return this._dtDtRefSent;
    } //-- org.exolab.castor.types.Date getDtDtRefSent() 

    /**
     * Returns the value of field 'dtDtSituationOpened'.
     * 
     * @return the value of field 'DtDtSituationOpened'.
     */
    public org.exolab.castor.types.Date getDtDtSituationOpened()
    {
        return this._dtDtSituationOpened;
    } //-- org.exolab.castor.types.Date getDtDtSituationOpened() 

    /**
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'dtDtSvcAuthEff'.
     * 
     * @return the value of field 'DtDtSvcAuthEff'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthEff()
    {
        return this._dtDtSvcAuthEff;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthEff() 

    /**
     * Returns the value of field 'error_message'.
     * 
     * @return the value of field 'Error_message'.
     */
    public int getError_message()
    {
        return this._error_message;
    } //-- int getError_message() 

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
     * Returns the value of field 'ROWCCON18SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCON18SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00_ARRAY getROWCCON18SOG00_ARRAY()
    {
        return this._ROWCCON18SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00_ARRAY getROWCCON18SOG00_ARRAY() 

    /**
     * Returns the value of field 'szCdCnperStatus'.
     * 
     * @return the value of field 'SzCdCnperStatus'.
     */
    public java.lang.String getSzCdCnperStatus()
    {
        return this._szCdCnperStatus;
    } //-- java.lang.String getSzCdCnperStatus() 

    /**
     * Returns the value of field 'szCdCntrctRegion'.
     * 
     * @return the value of field 'SzCdCntrctRegion'.
     */
    public java.lang.String getSzCdCntrctRegion()
    {
        return this._szCdCntrctRegion;
    } //-- java.lang.String getSzCdCntrctRegion() 

    /**
     * Returns the value of field 'szCdErlyCaseTyp'.
     * 
     * @return the value of field 'SzCdErlyCaseTyp'.
     */
    public java.lang.String getSzCdErlyCaseTyp()
    {
        return this._szCdErlyCaseTyp;
    } //-- java.lang.String getSzCdErlyCaseTyp() 

    /**
     * Returns the value of field 'szCdPayCnty'.
     * 
     * @return the value of field 'SzCdPayCnty'.
     */
    public java.lang.String getSzCdPayCnty()
    {
        return this._szCdPayCnty;
    } //-- java.lang.String getSzCdPayCnty() 

    /**
     * Returns the value of field 'szCdPupOtcme'.
     * 
     * @return the value of field 'SzCdPupOtcme'.
     */
    public java.lang.String getSzCdPupOtcme()
    {
        return this._szCdPupOtcme;
    } //-- java.lang.String getSzCdPupOtcme() 

    /**
     * Returns the value of field 'szCdPupTyp'.
     * 
     * @return the value of field 'SzCdPupTyp'.
     */
    public java.lang.String getSzCdPupTyp()
    {
        return this._szCdPupTyp;
    } //-- java.lang.String getSzCdPupTyp() 

    /**
     * Returns the value of field 'szCdSvcAuthCategory'.
     * 
     * @return the value of field 'SzCdSvcAuthCategory'.
     */
    public java.lang.String getSzCdSvcAuthCategory()
    {
        return this._szCdSvcAuthCategory;
    } //-- java.lang.String getSzCdSvcAuthCategory() 

    /**
     * Returns the value of field 'szCdSvcAuthCounty'.
     * 
     * @return the value of field 'SzCdSvcAuthCounty'.
     */
    public java.lang.String getSzCdSvcAuthCounty()
    {
        return this._szCdSvcAuthCounty;
    } //-- java.lang.String getSzCdSvcAuthCounty() 

    /**
     * Returns the value of field 'szCdSvcAuthRegion'.
     * 
     * @return the value of field 'SzCdSvcAuthRegion'.
     */
    public java.lang.String getSzCdSvcAuthRegion()
    {
        return this._szCdSvcAuthRegion;
    } //-- java.lang.String getSzCdSvcAuthRegion() 

    /**
     * Returns the value of field 'szCdSvcAuthService'.
     * 
     * @return the value of field 'SzCdSvcAuthService'.
     */
    public java.lang.String getSzCdSvcAuthService()
    {
        return this._szCdSvcAuthService;
    } //-- java.lang.String getSzCdSvcAuthService() 

    /**
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

    /**
     * Returns the value of field 'szTxtSvcAuthComments'.
     * 
     * @return the value of field 'SzTxtSvcAuthComments'.
     */
    public java.lang.String getSzTxtSvcAuthComments()
    {
        return this._szTxtSvcAuthComments;
    } //-- java.lang.String getSzTxtSvcAuthComments() 

    /**
     * Returns the value of field 'szTxtSvcAuthSecProvdr'.
     * 
     * @return the value of field 'SzTxtSvcAuthSecProvdr'.
     */
    public java.lang.String getSzTxtSvcAuthSecProvdr()
    {
        return this._szTxtSvcAuthSecProvdr;
    } //-- java.lang.String getSzTxtSvcAuthSecProvdr() 

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
     * Returns the value of field 'ulIdCntrctManager'.
     * 
     * @return the value of field 'UlIdCntrctManager'.
     */
    public int getUlIdCntrctManager()
    {
        return this._ulIdCntrctManager;
    } //-- int getUlIdCntrctManager() 

    /**
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdSvcAuth'.
     * 
     * @return the value of field 'UlIdSvcAuth'.
     */
    public int getUlIdSvcAuth()
    {
        return this._ulIdSvcAuth;
    } //-- int getUlIdSvcAuth() 

    /**
     * Returns the value of field 'ulIdWaiver'.
     * 
     * @return the value of field 'UlIdWaiver'.
     */
    public int getUlIdWaiver()
    {
        return this._ulIdWaiver;
    } //-- int getUlIdWaiver() 

    /**
     * Returns the value of field 'ulNbrCncntyPeriod'.
     * 
     * @return the value of field 'UlNbrCncntyPeriod'.
     */
    public int getUlNbrCncntyPeriod()
    {
        return this._ulNbrCncntyPeriod;
    } //-- int getUlNbrCncntyPeriod() 

    /**
     * Returns the value of field 'ulNbrCncntyVersion'.
     * 
     * @return the value of field 'UlNbrCncntyVersion'.
     */
    public int getUlNbrCncntyVersion()
    {
        return this._ulNbrCncntyVersion;
    } //-- int getUlNbrCncntyVersion() 

    /**
     * Method hasError_message
     * 
     * 
     * 
     * @return true if at least one Error_message has been added
     */
    public boolean hasError_message()
    {
        return this._has_error_message;
    } //-- boolean hasError_message() 

    /**
     * Method hasUlIdCntrctManager
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctManager has been added
     */
    public boolean hasUlIdCntrctManager()
    {
        return this._has_ulIdCntrctManager;
    } //-- boolean hasUlIdCntrctManager() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

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
     * Method hasUlIdSvcAuth
     * 
     * 
     * 
     * @return true if at least one UlIdSvcAuth has been added
     */
    public boolean hasUlIdSvcAuth()
    {
        return this._has_ulIdSvcAuth;
    } //-- boolean hasUlIdSvcAuth() 

    /**
     * Method hasUlIdWaiver
     * 
     * 
     * 
     * @return true if at least one UlIdWaiver has been added
     */
    public boolean hasUlIdWaiver()
    {
        return this._has_ulIdWaiver;
    } //-- boolean hasUlIdWaiver() 

    /**
     * Method hasUlNbrCncntyPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCncntyPeriod has been added
     */
    public boolean hasUlNbrCncntyPeriod()
    {
        return this._has_ulNbrCncntyPeriod;
    } //-- boolean hasUlNbrCncntyPeriod() 

    /**
     * Method hasUlNbrCncntyVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCncntyVersion has been adde
     */
    public boolean hasUlNbrCncntyVersion()
    {
        return this._has_ulNbrCncntyVersion;
    } //-- boolean hasUlNbrCncntyVersion() 

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
     * Sets the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @param bIndBLOBExistsInDatabase the value of field
     * 'bIndBLOBExistsInDatabase'.
     */
    public void setBIndBLOBExistsInDatabase(java.lang.String bIndBLOBExistsInDatabase)
    {
        this._bIndBLOBExistsInDatabase = bIndBLOBExistsInDatabase;
    } //-- void setBIndBLOBExistsInDatabase(java.lang.String) 

    /**
     * Sets the value of field 'bIndStageClose'.
     * 
     * @param bIndStageClose the value of field 'bIndStageClose'.
     */
    public void setBIndStageClose(java.lang.String bIndStageClose)
    {
        this._bIndStageClose = bIndStageClose;
    } //-- void setBIndStageClose(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndDtlRecExist'.
     * 
     * @param bScrIndDtlRecExist the value of field
     * 'bScrIndDtlRecExist'.
     */
    public void setBScrIndDtlRecExist(java.lang.String bScrIndDtlRecExist)
    {
        this._bScrIndDtlRecExist = bScrIndDtlRecExist;
    } //-- void setBScrIndDtlRecExist(java.lang.String) 

    /**
     * Sets the value of field 'cIndCnperRenewal'.
     * 
     * @param cIndCnperRenewal the value of field 'cIndCnperRenewal'
     */
    public void setCIndCnperRenewal(java.lang.String cIndCnperRenewal)
    {
        this._cIndCnperRenewal = cIndCnperRenewal;
    } //-- void setCIndCnperRenewal(java.lang.String) 

    /**
     * Sets the value of field 'cIndCntrctBudgLimit'.
     * 
     * @param cIndCntrctBudgLimit the value of field
     * 'cIndCntrctBudgLimit'.
     */
    public void setCIndCntrctBudgLimit(java.lang.String cIndCntrctBudgLimit)
    {
        this._cIndCntrctBudgLimit = cIndCntrctBudgLimit;
    } //-- void setCIndCntrctBudgLimit(java.lang.String) 

    /**
     * Sets the value of field 'cIndDntdCmmtySvc'.
     * 
     * @param cIndDntdCmmtySvc the value of field 'cIndDntdCmmtySvc'
     */
    public void setCIndDntdCmmtySvc(java.lang.String cIndDntdCmmtySvc)
    {
        this._cIndDntdCmmtySvc = cIndDntdCmmtySvc;
    } //-- void setCIndDntdCmmtySvc(java.lang.String) 

    /**
     * Sets the value of field 'cIndSvcAuthComplete'.
     * 
     * @param cIndSvcAuthComplete the value of field
     * 'cIndSvcAuthComplete'.
     */
    public void setCIndSvcAuthComplete(java.lang.String cIndSvcAuthComplete)
    {
        this._cIndSvcAuthComplete = cIndSvcAuthComplete;
    } //-- void setCIndSvcAuthComplete(java.lang.String) 

    /**
     * Sets the value of field 'cIndWaiverReqd'.
     * 
     * @param cIndWaiverReqd the value of field 'cIndWaiverReqd'.
     */
    public void setCIndWaiverReqd(java.lang.String cIndWaiverReqd)
    {
        this._cIndWaiverReqd = cIndWaiverReqd;
    } //-- void setCIndWaiverReqd(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCnperClosure'.
     * 
     * @param dtDtCnperClosure the value of field 'dtDtCnperClosure'
     */
    public void setDtDtCnperClosure(org.exolab.castor.types.Date dtDtCnperClosure)
    {
        this._dtDtCnperClosure = dtDtCnperClosure;
    } //-- void setDtDtCnperClosure(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCnperStart'.
     * 
     * @param dtDtCnperStart the value of field 'dtDtCnperStart'.
     */
    public void setDtDtCnperStart(org.exolab.castor.types.Date dtDtCnperStart)
    {
        this._dtDtCnperStart = dtDtCnperStart;
    } //-- void setDtDtCnperStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRefSent'.
     * 
     * @param dtDtRefSent the value of field 'dtDtRefSent'.
     */
    public void setDtDtRefSent(org.exolab.castor.types.Date dtDtRefSent)
    {
        this._dtDtRefSent = dtDtRefSent;
    } //-- void setDtDtRefSent(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSituationOpened'.
     * 
     * @param dtDtSituationOpened the value of field
     * 'dtDtSituationOpened'.
     */
    public void setDtDtSituationOpened(org.exolab.castor.types.Date dtDtSituationOpened)
    {
        this._dtDtSituationOpened = dtDtSituationOpened;
    } //-- void setDtDtSituationOpened(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcAuthEff'.
     * 
     * @param dtDtSvcAuthEff the value of field 'dtDtSvcAuthEff'.
     */
    public void setDtDtSvcAuthEff(org.exolab.castor.types.Date dtDtSvcAuthEff)
    {
        this._dtDtSvcAuthEff = dtDtSvcAuthEff;
    } //-- void setDtDtSvcAuthEff(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'error_message'.
     * 
     * @param error_message the value of field 'error_message'.
     */
    public void setError_message(int error_message)
    {
        this._error_message = error_message;
        this._has_error_message = true;
    } //-- void setError_message(int) 

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
     * Sets the value of field 'ROWCCON18SOG00_ARRAY'.
     * 
     * @param ROWCCON18SOG00_ARRAY the value of field
     * 'ROWCCON18SOG00_ARRAY'.
     */
    public void setROWCCON18SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00_ARRAY ROWCCON18SOG00_ARRAY)
    {
        this._ROWCCON18SOG00_ARRAY = ROWCCON18SOG00_ARRAY;
    } //-- void setROWCCON18SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00_ARRAY) 

    /**
     * Sets the value of field 'szCdCnperStatus'.
     * 
     * @param szCdCnperStatus the value of field 'szCdCnperStatus'.
     */
    public void setSzCdCnperStatus(java.lang.String szCdCnperStatus)
    {
        this._szCdCnperStatus = szCdCnperStatus;
    } //-- void setSzCdCnperStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdCntrctRegion'.
     * 
     * @param szCdCntrctRegion the value of field 'szCdCntrctRegion'
     */
    public void setSzCdCntrctRegion(java.lang.String szCdCntrctRegion)
    {
        this._szCdCntrctRegion = szCdCntrctRegion;
    } //-- void setSzCdCntrctRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdErlyCaseTyp'.
     * 
     * @param szCdErlyCaseTyp the value of field 'szCdErlyCaseTyp'.
     */
    public void setSzCdErlyCaseTyp(java.lang.String szCdErlyCaseTyp)
    {
        this._szCdErlyCaseTyp = szCdErlyCaseTyp;
    } //-- void setSzCdErlyCaseTyp(java.lang.String) 

    /**
     * Sets the value of field 'szCdPayCnty'.
     * 
     * @param szCdPayCnty the value of field 'szCdPayCnty'.
     */
    public void setSzCdPayCnty(java.lang.String szCdPayCnty)
    {
        this._szCdPayCnty = szCdPayCnty;
    } //-- void setSzCdPayCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPupOtcme'.
     * 
     * @param szCdPupOtcme the value of field 'szCdPupOtcme'.
     */
    public void setSzCdPupOtcme(java.lang.String szCdPupOtcme)
    {
        this._szCdPupOtcme = szCdPupOtcme;
    } //-- void setSzCdPupOtcme(java.lang.String) 

    /**
     * Sets the value of field 'szCdPupTyp'.
     * 
     * @param szCdPupTyp the value of field 'szCdPupTyp'.
     */
    public void setSzCdPupTyp(java.lang.String szCdPupTyp)
    {
        this._szCdPupTyp = szCdPupTyp;
    } //-- void setSzCdPupTyp(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthCategory'.
     * 
     * @param szCdSvcAuthCategory the value of field
     * 'szCdSvcAuthCategory'.
     */
    public void setSzCdSvcAuthCategory(java.lang.String szCdSvcAuthCategory)
    {
        this._szCdSvcAuthCategory = szCdSvcAuthCategory;
    } //-- void setSzCdSvcAuthCategory(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthCounty'.
     * 
     * @param szCdSvcAuthCounty the value of field
     * 'szCdSvcAuthCounty'.
     */
    public void setSzCdSvcAuthCounty(java.lang.String szCdSvcAuthCounty)
    {
        this._szCdSvcAuthCounty = szCdSvcAuthCounty;
    } //-- void setSzCdSvcAuthCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthRegion'.
     * 
     * @param szCdSvcAuthRegion the value of field
     * 'szCdSvcAuthRegion'.
     */
    public void setSzCdSvcAuthRegion(java.lang.String szCdSvcAuthRegion)
    {
        this._szCdSvcAuthRegion = szCdSvcAuthRegion;
    } //-- void setSzCdSvcAuthRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthService'.
     * 
     * @param szCdSvcAuthService the value of field
     * 'szCdSvcAuthService'.
     */
    public void setSzCdSvcAuthService(java.lang.String szCdSvcAuthService)
    {
        this._szCdSvcAuthService = szCdSvcAuthService;
    } //-- void setSzCdSvcAuthService(java.lang.String) 

    /**
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSvcAuthComments'.
     * 
     * @param szTxtSvcAuthComments the value of field
     * 'szTxtSvcAuthComments'.
     */
    public void setSzTxtSvcAuthComments(java.lang.String szTxtSvcAuthComments)
    {
        this._szTxtSvcAuthComments = szTxtSvcAuthComments;
    } //-- void setSzTxtSvcAuthComments(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSvcAuthSecProvdr'.
     * 
     * @param szTxtSvcAuthSecProvdr the value of field
     * 'szTxtSvcAuthSecProvdr'.
     */
    public void setSzTxtSvcAuthSecProvdr(java.lang.String szTxtSvcAuthSecProvdr)
    {
        this._szTxtSvcAuthSecProvdr = szTxtSvcAuthSecProvdr;
    } //-- void setSzTxtSvcAuthSecProvdr(java.lang.String) 

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
     * Sets the value of field 'ulIdCntrctManager'.
     * 
     * @param ulIdCntrctManager the value of field
     * 'ulIdCntrctManager'.
     */
    public void setUlIdCntrctManager(int ulIdCntrctManager)
    {
        this._ulIdCntrctManager = ulIdCntrctManager;
        this._has_ulIdCntrctManager = true;
    } //-- void setUlIdCntrctManager(int) 

    /**
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

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
     * Sets the value of field 'ulIdSvcAuth'.
     * 
     * @param ulIdSvcAuth the value of field 'ulIdSvcAuth'.
     */
    public void setUlIdSvcAuth(int ulIdSvcAuth)
    {
        this._ulIdSvcAuth = ulIdSvcAuth;
        this._has_ulIdSvcAuth = true;
    } //-- void setUlIdSvcAuth(int) 

    /**
     * Sets the value of field 'ulIdWaiver'.
     * 
     * @param ulIdWaiver the value of field 'ulIdWaiver'.
     */
    public void setUlIdWaiver(int ulIdWaiver)
    {
        this._ulIdWaiver = ulIdWaiver;
        this._has_ulIdWaiver = true;
    } //-- void setUlIdWaiver(int) 

    /**
     * Sets the value of field 'ulNbrCncntyPeriod'.
     * 
     * @param ulNbrCncntyPeriod the value of field
     * 'ulNbrCncntyPeriod'.
     */
    public void setUlNbrCncntyPeriod(int ulNbrCncntyPeriod)
    {
        this._ulNbrCncntyPeriod = ulNbrCncntyPeriod;
        this._has_ulNbrCncntyPeriod = true;
    } //-- void setUlNbrCncntyPeriod(int) 

    /**
     * Sets the value of field 'ulNbrCncntyVersion'.
     * 
     * @param ulNbrCncntyVersion the value of field
     * 'ulNbrCncntyVersion'.
     */
    public void setUlNbrCncntyVersion(int ulNbrCncntyVersion)
    {
        this._ulNbrCncntyVersion = ulNbrCncntyVersion;
        this._has_ulNbrCncntyVersion = true;
    } //-- void setUlNbrCncntyVersion(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO unmarshal(java.io.Reader) 

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
