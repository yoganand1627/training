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
 * Class CallEntrySvcStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallEntrySvcStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szCdIncmgCallerInt
     */
    private java.lang.String _szCdIncmgCallerInt;

    /**
     * Field _szCdIncmgAllegType
     */
    private java.lang.String _szCdIncmgAllegType;

    /**
     * Field _dtDtIncomingCall
     */
    private org.exolab.castor.types.Date _dtDtIncomingCall;

    /**
     * Field _szSysCdWinMode
     */
    private java.lang.String _szSysCdWinMode;

    /**
     * Field _cdIncmgStatus
     */
    private java.lang.String _cdIncmgStatus;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _szCdStageCnty
     */
    private java.lang.String _szCdStageCnty;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _szCdStageRegion
     */
    private java.lang.String _szCdStageRegion;

    /**
     * Field _szCdStageType
     */
    private java.lang.String _szCdStageType;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szAddrIncmgStreetLn1
     */
    private java.lang.String _szAddrIncmgStreetLn1;

    /**
     * Field _szAddrIncmgStreetLn2
     */
    private java.lang.String _szAddrIncmgStreetLn2;

    /**
     * Field _szCdIncomingDisposition
     */
    private java.lang.String _szCdIncomingDisposition;

    /**
     * Field _cdIncomingProgramType
     */
    private java.lang.String _cdIncomingProgramType;

    /**
     * Field _dtIncomingCallDisposed
     */
    private org.exolab.castor.types.Date _dtIncomingCallDisposed;

    /**
     * Field _tsIncmgCallDisp
     */
    private java.util.Date _tsIncmgCallDisp;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdIncomingCallType
     */
    private java.lang.String _szCdIncomingCallType;

    /**
     * Field _nmIncomingCallerFirst
     */
    private java.lang.String _nmIncomingCallerFirst;

    /**
     * Field _szCdIncmgAddrType
     */
    private java.lang.String _szCdIncmgAddrType;

    /**
     * Field _nmIncomingCallerMiddle
     */
    private java.lang.String _nmIncomingCallerMiddle;

    /**
     * Field _nmIncomingCallerLast
     */
    private java.lang.String _nmIncomingCallerLast;

    /**
     * Field _cdIncomingCallerSuffix
     */
    private java.lang.String _cdIncomingCallerSuffix;

    /**
     * Field _szNbrIncomingCallerPhone
     */
    private java.lang.String _szNbrIncomingCallerPhone;

    /**
     * Field _szCdIncmgPhoneType
     */
    private java.lang.String _szCdIncmgPhoneType;

    /**
     * Field _szNbrIncmgCallerExt
     */
    private java.lang.String _szNbrIncmgCallerExt;

    /**
     * Field _szCdIncmgSex
     */
    private java.lang.String _szCdIncmgSex;

    /**
     * Field _szAddrIncomingCallerCity
     */
    private java.lang.String _szAddrIncomingCallerCity;

    /**
     * Field _szCdIncomingCallerCounty
     */
    private java.lang.String _szCdIncomingCallerCounty;

    /**
     * Field _szCdIncomingCallerState
     */
    private java.lang.String _szCdIncomingCallerState;

    /**
     * Field _szAddrIncmgZip
     */
    private java.lang.String _szAddrIncmgZip;

    /**
     * Field _szNmIncmgRegardingFirst
     */
    private java.lang.String _szNmIncmgRegardingFirst;

    /**
     * Field _szNmIncmgRegardingLast
     */
    private java.lang.String _szNmIncmgRegardingLast;

    /**
     * Field _szCdInfoAndRefrl
     */
    private java.lang.String _szCdInfoAndRefrl;

    /**
     * Field _szCdSpclReq
     */
    private java.lang.String _szCdSpclReq;

    /**
     * Field _ulIdAllegation
     */
    private int _ulIdAllegation;

    /**
     * keeps track of state for field: _ulIdAllegation
     */
    private boolean _has_ulIdAllegation;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szNmJurisdiction
     */
    private java.lang.String _szNmJurisdiction;

    /**
     * Field _tmSysTmCallDisp
     */
    private java.lang.String _tmSysTmCallDisp;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _tmTmIncmgCall
     */
    private java.lang.String _tmTmIncmgCall;

    /**
     * Field _szAddrIncWkrCity
     */
    private java.lang.String _szAddrIncWkrCity;

    /**
     * Field _lNbrIncWkrPhone
     */
    private java.lang.String _lNbrIncWkrPhone;

    /**
     * Field _lNbrIncWkrExt
     */
    private java.lang.String _lNbrIncWkrExt;

    /**
     * Field _szNmIncWkrName
     */
    private java.lang.String _szNmIncWkrName;

    /**
     * Field _szNbrIncmgUnit
     */
    private java.lang.String _szNbrIncmgUnit;

    /**
     * Field _szCdIncmgRegion
     */
    private java.lang.String _szCdIncmgRegion;

    /**
     * Field _szCdNonRsdntReqType
     */
    private java.lang.String _szCdNonRsdntReqType;

    /**
     * Field _szCdSpclInvstgtn
     */
    private java.lang.String _szCdSpclInvstgtn;

    /**
     * Field _cIndCnfidntltyExplnd
     */
    private java.lang.String _cIndCnfidntltyExplnd;

    /**
     * Field _cIndIncmgMaltreatInCare
     */
    private java.lang.String _cIndIncmgMaltreatInCare;

    /**
     * Field _dtCnfidntltyExplntn
     */
    private org.exolab.castor.types.Date _dtCnfidntltyExplntn;

    /**
     * Field _ulIdIncomingWkr
     */
    private int _ulIdIncomingWkr;

    /**
     * keeps track of state for field: _ulIdIncomingWkr
     */
    private boolean _has_ulIdIncomingWkr;

    /**
     * Field _szNmIncmgSupName
     */
    private java.lang.String _szNmIncmgSupName;

    /**
     * Field _szNbrIncmgSupPhone
     */
    private java.lang.String _szNbrIncmgSupPhone;

    /**
     * Field _szNbrIncmgSupExt
     */
    private java.lang.String _szNbrIncmgSupExt;

    /**
     * Field _ulIdIncomingSup
     */
    private int _ulIdIncomingSup;

    /**
     * keeps track of state for field: _ulIdIncomingSup
     */
    private boolean _has_ulIdIncomingSup;

    /**
     * Field _szCdIncomingWorkerCounty
     */
    private java.lang.String _szCdIncomingWorkerCounty;

    /**
     * Field _szCdIncmgWorkerRegion
     */
    private java.lang.String _szCdIncmgWorkerRegion;

    /**
     * Field _szCdSpclCircumstances
     */
    private java.lang.String _szCdSpclCircumstances;

    /**
     * Field _szCdStageClassification
     */
    private java.lang.String _szCdStageClassification;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallEntrySvcStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAllegation()
    {
        this._has_ulIdAllegation= false;
    } //-- void deleteUlIdAllegation() 

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
     */
    public void deleteUlIdIncomingSup()
    {
        this._has_ulIdIncomingSup= false;
    } //-- void deleteUlIdIncomingSup() 

    /**
     */
    public void deleteUlIdIncomingWkr()
    {
        this._has_ulIdIncomingWkr= false;
    } //-- void deleteUlIdIncomingWkr() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     * Returns the value of field 'cIndCnfidntltyExplnd'.
     * 
     * @return the value of field 'CIndCnfidntltyExplnd'.
     */
    public java.lang.String getCIndCnfidntltyExplnd()
    {
        return this._cIndCnfidntltyExplnd;
    } //-- java.lang.String getCIndCnfidntltyExplnd() 

    /**
     * Returns the value of field 'cIndIncmgMaltreatInCare'.
     * 
     * @return the value of field 'CIndIncmgMaltreatInCare'.
     */
    public java.lang.String getCIndIncmgMaltreatInCare()
    {
        return this._cIndIncmgMaltreatInCare;
    } //-- java.lang.String getCIndIncmgMaltreatInCare() 

    /**
     * Returns the value of field 'cdIncmgStatus'.
     * 
     * @return the value of field 'CdIncmgStatus'.
     */
    public java.lang.String getCdIncmgStatus()
    {
        return this._cdIncmgStatus;
    } //-- java.lang.String getCdIncmgStatus() 

    /**
     * Returns the value of field 'cdIncomingCallerSuffix'.
     * 
     * @return the value of field 'CdIncomingCallerSuffix'.
     */
    public java.lang.String getCdIncomingCallerSuffix()
    {
        return this._cdIncomingCallerSuffix;
    } //-- java.lang.String getCdIncomingCallerSuffix() 

    /**
     * Returns the value of field 'cdIncomingProgramType'.
     * 
     * @return the value of field 'CdIncomingProgramType'.
     */
    public java.lang.String getCdIncomingProgramType()
    {
        return this._cdIncomingProgramType;
    } //-- java.lang.String getCdIncomingProgramType() 

    /**
     * Returns the value of field 'dtCnfidntltyExplntn'.
     * 
     * @return the value of field 'DtCnfidntltyExplntn'.
     */
    public org.exolab.castor.types.Date getDtCnfidntltyExplntn()
    {
        return this._dtCnfidntltyExplntn;
    } //-- org.exolab.castor.types.Date getDtCnfidntltyExplntn() 

    /**
     * Returns the value of field 'dtDtIncomingCall'.
     * 
     * @return the value of field 'DtDtIncomingCall'.
     */
    public org.exolab.castor.types.Date getDtDtIncomingCall()
    {
        return this._dtDtIncomingCall;
    } //-- org.exolab.castor.types.Date getDtDtIncomingCall() 

    /**
     * Returns the value of field 'dtIncomingCallDisposed'.
     * 
     * @return the value of field 'DtIncomingCallDisposed'.
     */
    public org.exolab.castor.types.Date getDtIncomingCallDisposed()
    {
        return this._dtIncomingCallDisposed;
    } //-- org.exolab.castor.types.Date getDtIncomingCallDisposed() 

    /**
     * Returns the value of field 'lNbrIncWkrExt'.
     * 
     * @return the value of field 'LNbrIncWkrExt'.
     */
    public java.lang.String getLNbrIncWkrExt()
    {
        return this._lNbrIncWkrExt;
    } //-- java.lang.String getLNbrIncWkrExt() 

    /**
     * Returns the value of field 'lNbrIncWkrPhone'.
     * 
     * @return the value of field 'LNbrIncWkrPhone'.
     */
    public java.lang.String getLNbrIncWkrPhone()
    {
        return this._lNbrIncWkrPhone;
    } //-- java.lang.String getLNbrIncWkrPhone() 

    /**
     * Returns the value of field 'nmIncomingCallerFirst'.
     * 
     * @return the value of field 'NmIncomingCallerFirst'.
     */
    public java.lang.String getNmIncomingCallerFirst()
    {
        return this._nmIncomingCallerFirst;
    } //-- java.lang.String getNmIncomingCallerFirst() 

    /**
     * Returns the value of field 'nmIncomingCallerLast'.
     * 
     * @return the value of field 'NmIncomingCallerLast'.
     */
    public java.lang.String getNmIncomingCallerLast()
    {
        return this._nmIncomingCallerLast;
    } //-- java.lang.String getNmIncomingCallerLast() 

    /**
     * Returns the value of field 'nmIncomingCallerMiddle'.
     * 
     * @return the value of field 'NmIncomingCallerMiddle'.
     */
    public java.lang.String getNmIncomingCallerMiddle()
    {
        return this._nmIncomingCallerMiddle;
    } //-- java.lang.String getNmIncomingCallerMiddle() 

    /**
     * Returns the value of field 'szAddrIncWkrCity'.
     * 
     * @return the value of field 'SzAddrIncWkrCity'.
     */
    public java.lang.String getSzAddrIncWkrCity()
    {
        return this._szAddrIncWkrCity;
    } //-- java.lang.String getSzAddrIncWkrCity() 

    /**
     * Returns the value of field 'szAddrIncmgStreetLn1'.
     * 
     * @return the value of field 'SzAddrIncmgStreetLn1'.
     */
    public java.lang.String getSzAddrIncmgStreetLn1()
    {
        return this._szAddrIncmgStreetLn1;
    } //-- java.lang.String getSzAddrIncmgStreetLn1() 

    /**
     * Returns the value of field 'szAddrIncmgStreetLn2'.
     * 
     * @return the value of field 'SzAddrIncmgStreetLn2'.
     */
    public java.lang.String getSzAddrIncmgStreetLn2()
    {
        return this._szAddrIncmgStreetLn2;
    } //-- java.lang.String getSzAddrIncmgStreetLn2() 

    /**
     * Returns the value of field 'szAddrIncmgZip'.
     * 
     * @return the value of field 'SzAddrIncmgZip'.
     */
    public java.lang.String getSzAddrIncmgZip()
    {
        return this._szAddrIncmgZip;
    } //-- java.lang.String getSzAddrIncmgZip() 

    /**
     * Returns the value of field 'szAddrIncomingCallerCity'.
     * 
     * @return the value of field 'SzAddrIncomingCallerCity'.
     */
    public java.lang.String getSzAddrIncomingCallerCity()
    {
        return this._szAddrIncomingCallerCity;
    } //-- java.lang.String getSzAddrIncomingCallerCity() 

    /**
     * Returns the value of field 'szCdIncmgAddrType'.
     * 
     * @return the value of field 'SzCdIncmgAddrType'.
     */
    public java.lang.String getSzCdIncmgAddrType()
    {
        return this._szCdIncmgAddrType;
    } //-- java.lang.String getSzCdIncmgAddrType() 

    /**
     * Returns the value of field 'szCdIncmgAllegType'.
     * 
     * @return the value of field 'SzCdIncmgAllegType'.
     */
    public java.lang.String getSzCdIncmgAllegType()
    {
        return this._szCdIncmgAllegType;
    } //-- java.lang.String getSzCdIncmgAllegType() 

    /**
     * Returns the value of field 'szCdIncmgCallerInt'.
     * 
     * @return the value of field 'SzCdIncmgCallerInt'.
     */
    public java.lang.String getSzCdIncmgCallerInt()
    {
        return this._szCdIncmgCallerInt;
    } //-- java.lang.String getSzCdIncmgCallerInt() 

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
     * Returns the value of field 'szCdIncmgRegion'.
     * 
     * @return the value of field 'SzCdIncmgRegion'.
     */
    public java.lang.String getSzCdIncmgRegion()
    {
        return this._szCdIncmgRegion;
    } //-- java.lang.String getSzCdIncmgRegion() 

    /**
     * Returns the value of field 'szCdIncmgSex'.
     * 
     * @return the value of field 'SzCdIncmgSex'.
     */
    public java.lang.String getSzCdIncmgSex()
    {
        return this._szCdIncmgSex;
    } //-- java.lang.String getSzCdIncmgSex() 

    /**
     * Returns the value of field 'szCdIncmgWorkerRegion'.
     * 
     * @return the value of field 'SzCdIncmgWorkerRegion'.
     */
    public java.lang.String getSzCdIncmgWorkerRegion()
    {
        return this._szCdIncmgWorkerRegion;
    } //-- java.lang.String getSzCdIncmgWorkerRegion() 

    /**
     * Returns the value of field 'szCdIncomingCallType'.
     * 
     * @return the value of field 'SzCdIncomingCallType'.
     */
    public java.lang.String getSzCdIncomingCallType()
    {
        return this._szCdIncomingCallType;
    } //-- java.lang.String getSzCdIncomingCallType() 

    /**
     * Returns the value of field 'szCdIncomingCallerCounty'.
     * 
     * @return the value of field 'SzCdIncomingCallerCounty'.
     */
    public java.lang.String getSzCdIncomingCallerCounty()
    {
        return this._szCdIncomingCallerCounty;
    } //-- java.lang.String getSzCdIncomingCallerCounty() 

    /**
     * Returns the value of field 'szCdIncomingCallerState'.
     * 
     * @return the value of field 'SzCdIncomingCallerState'.
     */
    public java.lang.String getSzCdIncomingCallerState()
    {
        return this._szCdIncomingCallerState;
    } //-- java.lang.String getSzCdIncomingCallerState() 

    /**
     * Returns the value of field 'szCdIncomingDisposition'.
     * 
     * @return the value of field 'SzCdIncomingDisposition'.
     */
    public java.lang.String getSzCdIncomingDisposition()
    {
        return this._szCdIncomingDisposition;
    } //-- java.lang.String getSzCdIncomingDisposition() 

    /**
     * Returns the value of field 'szCdIncomingWorkerCounty'.
     * 
     * @return the value of field 'SzCdIncomingWorkerCounty'.
     */
    public java.lang.String getSzCdIncomingWorkerCounty()
    {
        return this._szCdIncomingWorkerCounty;
    } //-- java.lang.String getSzCdIncomingWorkerCounty() 

    /**
     * Returns the value of field 'szCdInfoAndRefrl'.
     * 
     * @return the value of field 'SzCdInfoAndRefrl'.
     */
    public java.lang.String getSzCdInfoAndRefrl()
    {
        return this._szCdInfoAndRefrl;
    } //-- java.lang.String getSzCdInfoAndRefrl() 

    /**
     * Returns the value of field 'szCdNonRsdntReqType'.
     * 
     * @return the value of field 'SzCdNonRsdntReqType'.
     */
    public java.lang.String getSzCdNonRsdntReqType()
    {
        return this._szCdNonRsdntReqType;
    } //-- java.lang.String getSzCdNonRsdntReqType() 

    /**
     * Returns the value of field 'szCdSpclCircumstances'.
     * 
     * @return the value of field 'SzCdSpclCircumstances'.
     */
    public java.lang.String getSzCdSpclCircumstances()
    {
        return this._szCdSpclCircumstances;
    } //-- java.lang.String getSzCdSpclCircumstances() 

    /**
     * Returns the value of field 'szCdSpclInvstgtn'.
     * 
     * @return the value of field 'SzCdSpclInvstgtn'.
     */
    public java.lang.String getSzCdSpclInvstgtn()
    {
        return this._szCdSpclInvstgtn;
    } //-- java.lang.String getSzCdSpclInvstgtn() 

    /**
     * Returns the value of field 'szCdSpclReq'.
     * 
     * @return the value of field 'SzCdSpclReq'.
     */
    public java.lang.String getSzCdSpclReq()
    {
        return this._szCdSpclReq;
    } //-- java.lang.String getSzCdSpclReq() 

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
     * Returns the value of field 'szCdStageClassification'.
     * 
     * @return the value of field 'SzCdStageClassification'.
     */
    public java.lang.String getSzCdStageClassification()
    {
        return this._szCdStageClassification;
    } //-- java.lang.String getSzCdStageClassification() 

    /**
     * Returns the value of field 'szCdStageCnty'.
     * 
     * @return the value of field 'SzCdStageCnty'.
     */
    public java.lang.String getSzCdStageCnty()
    {
        return this._szCdStageCnty;
    } //-- java.lang.String getSzCdStageCnty() 

    /**
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

    /**
     * Returns the value of field 'szCdStageReasonClosed'.
     * 
     * @return the value of field 'SzCdStageReasonClosed'.
     */
    public java.lang.String getSzCdStageReasonClosed()
    {
        return this._szCdStageReasonClosed;
    } //-- java.lang.String getSzCdStageReasonClosed() 

    /**
     * Returns the value of field 'szCdStageRegion'.
     * 
     * @return the value of field 'SzCdStageRegion'.
     */
    public java.lang.String getSzCdStageRegion()
    {
        return this._szCdStageRegion;
    } //-- java.lang.String getSzCdStageRegion() 

    /**
     * Returns the value of field 'szCdStageType'.
     * 
     * @return the value of field 'SzCdStageType'.
     */
    public java.lang.String getSzCdStageType()
    {
        return this._szCdStageType;
    } //-- java.lang.String getSzCdStageType() 

    /**
     * Returns the value of field 'szNbrIncmgCallerExt'.
     * 
     * @return the value of field 'SzNbrIncmgCallerExt'.
     */
    public java.lang.String getSzNbrIncmgCallerExt()
    {
        return this._szNbrIncmgCallerExt;
    } //-- java.lang.String getSzNbrIncmgCallerExt() 

    /**
     * Returns the value of field 'szNbrIncmgSupExt'.
     * 
     * @return the value of field 'SzNbrIncmgSupExt'.
     */
    public java.lang.String getSzNbrIncmgSupExt()
    {
        return this._szNbrIncmgSupExt;
    } //-- java.lang.String getSzNbrIncmgSupExt() 

    /**
     * Returns the value of field 'szNbrIncmgSupPhone'.
     * 
     * @return the value of field 'SzNbrIncmgSupPhone'.
     */
    public java.lang.String getSzNbrIncmgSupPhone()
    {
        return this._szNbrIncmgSupPhone;
    } //-- java.lang.String getSzNbrIncmgSupPhone() 

    /**
     * Returns the value of field 'szNbrIncmgUnit'.
     * 
     * @return the value of field 'SzNbrIncmgUnit'.
     */
    public java.lang.String getSzNbrIncmgUnit()
    {
        return this._szNbrIncmgUnit;
    } //-- java.lang.String getSzNbrIncmgUnit() 

    /**
     * Returns the value of field 'szNbrIncomingCallerPhone'.
     * 
     * @return the value of field 'SzNbrIncomingCallerPhone'.
     */
    public java.lang.String getSzNbrIncomingCallerPhone()
    {
        return this._szNbrIncomingCallerPhone;
    } //-- java.lang.String getSzNbrIncomingCallerPhone() 

    /**
     * Returns the value of field 'szNmIncWkrName'.
     * 
     * @return the value of field 'SzNmIncWkrName'.
     */
    public java.lang.String getSzNmIncWkrName()
    {
        return this._szNmIncWkrName;
    } //-- java.lang.String getSzNmIncWkrName() 

    /**
     * Returns the value of field 'szNmIncmgRegardingFirst'.
     * 
     * @return the value of field 'SzNmIncmgRegardingFirst'.
     */
    public java.lang.String getSzNmIncmgRegardingFirst()
    {
        return this._szNmIncmgRegardingFirst;
    } //-- java.lang.String getSzNmIncmgRegardingFirst() 

    /**
     * Returns the value of field 'szNmIncmgRegardingLast'.
     * 
     * @return the value of field 'SzNmIncmgRegardingLast'.
     */
    public java.lang.String getSzNmIncmgRegardingLast()
    {
        return this._szNmIncmgRegardingLast;
    } //-- java.lang.String getSzNmIncmgRegardingLast() 

    /**
     * Returns the value of field 'szNmIncmgSupName'.
     * 
     * @return the value of field 'SzNmIncmgSupName'.
     */
    public java.lang.String getSzNmIncmgSupName()
    {
        return this._szNmIncmgSupName;
    } //-- java.lang.String getSzNmIncmgSupName() 

    /**
     * Returns the value of field 'szNmJurisdiction'.
     * 
     * @return the value of field 'SzNmJurisdiction'.
     */
    public java.lang.String getSzNmJurisdiction()
    {
        return this._szNmJurisdiction;
    } //-- java.lang.String getSzNmJurisdiction() 

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
     * Returns the value of field 'szSysCdWinMode'.
     * 
     * @return the value of field 'SzSysCdWinMode'.
     */
    public java.lang.String getSzSysCdWinMode()
    {
        return this._szSysCdWinMode;
    } //-- java.lang.String getSzSysCdWinMode() 

    /**
     * Returns the value of field 'tmSysTmCallDisp'.
     * 
     * @return the value of field 'TmSysTmCallDisp'.
     */
    public java.lang.String getTmSysTmCallDisp()
    {
        return this._tmSysTmCallDisp;
    } //-- java.lang.String getTmSysTmCallDisp() 

    /**
     * Returns the value of field 'tmTmIncmgCall'.
     * 
     * @return the value of field 'TmTmIncmgCall'.
     */
    public java.lang.String getTmTmIncmgCall()
    {
        return this._tmTmIncmgCall;
    } //-- java.lang.String getTmTmIncmgCall() 

    /**
     * Returns the value of field 'tsIncmgCallDisp'.
     * 
     * @return the value of field 'TsIncmgCallDisp'.
     */
    public java.util.Date getTsIncmgCallDisp()
    {
        return this._tsIncmgCallDisp;
    } //-- java.util.Date getTsIncmgCallDisp() 

    /**
     * Returns the value of field 'ulIdAllegation'.
     * 
     * @return the value of field 'UlIdAllegation'.
     */
    public int getUlIdAllegation()
    {
        return this._ulIdAllegation;
    } //-- int getUlIdAllegation() 

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
     * Returns the value of field 'ulIdIncomingSup'.
     * 
     * @return the value of field 'UlIdIncomingSup'.
     */
    public int getUlIdIncomingSup()
    {
        return this._ulIdIncomingSup;
    } //-- int getUlIdIncomingSup() 

    /**
     * Returns the value of field 'ulIdIncomingWkr'.
     * 
     * @return the value of field 'UlIdIncomingWkr'.
     */
    public int getUlIdIncomingWkr()
    {
        return this._ulIdIncomingWkr;
    } //-- int getUlIdIncomingWkr() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdSituation'.
     * 
     * @return the value of field 'UlIdSituation'.
     */
    public int getUlIdSituation()
    {
        return this._ulIdSituation;
    } //-- int getUlIdSituation() 

    /**
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

    /**
     * Method hasUlIdAllegation
     * 
     * 
     * 
     * @return true if at least one UlIdAllegation has been added
     */
    public boolean hasUlIdAllegation()
    {
        return this._has_ulIdAllegation;
    } //-- boolean hasUlIdAllegation() 

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
     * Method hasUlIdIncomingSup
     * 
     * 
     * 
     * @return true if at least one UlIdIncomingSup has been added
     */
    public boolean hasUlIdIncomingSup()
    {
        return this._has_ulIdIncomingSup;
    } //-- boolean hasUlIdIncomingSup() 

    /**
     * Method hasUlIdIncomingWkr
     * 
     * 
     * 
     * @return true if at least one UlIdIncomingWkr has been added
     */
    public boolean hasUlIdIncomingWkr()
    {
        return this._has_ulIdIncomingWkr;
    } //-- boolean hasUlIdIncomingWkr() 

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
     * Method hasUlIdSituation
     * 
     * 
     * 
     * @return true if at least one UlIdSituation has been added
     */
    public boolean hasUlIdSituation()
    {
        return this._has_ulIdSituation;
    } //-- boolean hasUlIdSituation() 

    /**
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

    /**
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

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
     * Sets the value of field 'cIndCnfidntltyExplnd'.
     * 
     * @param cIndCnfidntltyExplnd the value of field
     * 'cIndCnfidntltyExplnd'.
     */
    public void setCIndCnfidntltyExplnd(java.lang.String cIndCnfidntltyExplnd)
    {
        this._cIndCnfidntltyExplnd = cIndCnfidntltyExplnd;
    } //-- void setCIndCnfidntltyExplnd(java.lang.String) 

    /**
     * Sets the value of field 'cIndIncmgMaltreatInCare'.
     * 
     * @param cIndIncmgMaltreatInCare the value of field
     * 'cIndIncmgMaltreatInCare'.
     */
    public void setCIndIncmgMaltreatInCare(java.lang.String cIndIncmgMaltreatInCare)
    {
        this._cIndIncmgMaltreatInCare = cIndIncmgMaltreatInCare;
    } //-- void setCIndIncmgMaltreatInCare(java.lang.String) 

    /**
     * Sets the value of field 'cdIncmgStatus'.
     * 
     * @param cdIncmgStatus the value of field 'cdIncmgStatus'.
     */
    public void setCdIncmgStatus(java.lang.String cdIncmgStatus)
    {
        this._cdIncmgStatus = cdIncmgStatus;
    } //-- void setCdIncmgStatus(java.lang.String) 

    /**
     * Sets the value of field 'cdIncomingCallerSuffix'.
     * 
     * @param cdIncomingCallerSuffix the value of field
     * 'cdIncomingCallerSuffix'.
     */
    public void setCdIncomingCallerSuffix(java.lang.String cdIncomingCallerSuffix)
    {
        this._cdIncomingCallerSuffix = cdIncomingCallerSuffix;
    } //-- void setCdIncomingCallerSuffix(java.lang.String) 

    /**
     * Sets the value of field 'cdIncomingProgramType'.
     * 
     * @param cdIncomingProgramType the value of field
     * 'cdIncomingProgramType'.
     */
    public void setCdIncomingProgramType(java.lang.String cdIncomingProgramType)
    {
        this._cdIncomingProgramType = cdIncomingProgramType;
    } //-- void setCdIncomingProgramType(java.lang.String) 

    /**
     * Sets the value of field 'dtCnfidntltyExplntn'.
     * 
     * @param dtCnfidntltyExplntn the value of field
     * 'dtCnfidntltyExplntn'.
     */
    public void setDtCnfidntltyExplntn(org.exolab.castor.types.Date dtCnfidntltyExplntn)
    {
        this._dtCnfidntltyExplntn = dtCnfidntltyExplntn;
    } //-- void setDtCnfidntltyExplntn(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtIncomingCall'.
     * 
     * @param dtDtIncomingCall the value of field 'dtDtIncomingCall'
     */
    public void setDtDtIncomingCall(org.exolab.castor.types.Date dtDtIncomingCall)
    {
        this._dtDtIncomingCall = dtDtIncomingCall;
    } //-- void setDtDtIncomingCall(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtIncomingCallDisposed'.
     * 
     * @param dtIncomingCallDisposed the value of field
     * 'dtIncomingCallDisposed'.
     */
    public void setDtIncomingCallDisposed(org.exolab.castor.types.Date dtIncomingCallDisposed)
    {
        this._dtIncomingCallDisposed = dtIncomingCallDisposed;
    } //-- void setDtIncomingCallDisposed(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrIncWkrExt'.
     * 
     * @param lNbrIncWkrExt the value of field 'lNbrIncWkrExt'.
     */
    public void setLNbrIncWkrExt(java.lang.String lNbrIncWkrExt)
    {
        this._lNbrIncWkrExt = lNbrIncWkrExt;
    } //-- void setLNbrIncWkrExt(java.lang.String) 

    /**
     * Sets the value of field 'lNbrIncWkrPhone'.
     * 
     * @param lNbrIncWkrPhone the value of field 'lNbrIncWkrPhone'.
     */
    public void setLNbrIncWkrPhone(java.lang.String lNbrIncWkrPhone)
    {
        this._lNbrIncWkrPhone = lNbrIncWkrPhone;
    } //-- void setLNbrIncWkrPhone(java.lang.String) 

    /**
     * Sets the value of field 'nmIncomingCallerFirst'.
     * 
     * @param nmIncomingCallerFirst the value of field
     * 'nmIncomingCallerFirst'.
     */
    public void setNmIncomingCallerFirst(java.lang.String nmIncomingCallerFirst)
    {
        this._nmIncomingCallerFirst = nmIncomingCallerFirst;
    } //-- void setNmIncomingCallerFirst(java.lang.String) 

    /**
     * Sets the value of field 'nmIncomingCallerLast'.
     * 
     * @param nmIncomingCallerLast the value of field
     * 'nmIncomingCallerLast'.
     */
    public void setNmIncomingCallerLast(java.lang.String nmIncomingCallerLast)
    {
        this._nmIncomingCallerLast = nmIncomingCallerLast;
    } //-- void setNmIncomingCallerLast(java.lang.String) 

    /**
     * Sets the value of field 'nmIncomingCallerMiddle'.
     * 
     * @param nmIncomingCallerMiddle the value of field
     * 'nmIncomingCallerMiddle'.
     */
    public void setNmIncomingCallerMiddle(java.lang.String nmIncomingCallerMiddle)
    {
        this._nmIncomingCallerMiddle = nmIncomingCallerMiddle;
    } //-- void setNmIncomingCallerMiddle(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncWkrCity'.
     * 
     * @param szAddrIncWkrCity the value of field 'szAddrIncWkrCity'
     */
    public void setSzAddrIncWkrCity(java.lang.String szAddrIncWkrCity)
    {
        this._szAddrIncWkrCity = szAddrIncWkrCity;
    } //-- void setSzAddrIncWkrCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgStreetLn1'.
     * 
     * @param szAddrIncmgStreetLn1 the value of field
     * 'szAddrIncmgStreetLn1'.
     */
    public void setSzAddrIncmgStreetLn1(java.lang.String szAddrIncmgStreetLn1)
    {
        this._szAddrIncmgStreetLn1 = szAddrIncmgStreetLn1;
    } //-- void setSzAddrIncmgStreetLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgStreetLn2'.
     * 
     * @param szAddrIncmgStreetLn2 the value of field
     * 'szAddrIncmgStreetLn2'.
     */
    public void setSzAddrIncmgStreetLn2(java.lang.String szAddrIncmgStreetLn2)
    {
        this._szAddrIncmgStreetLn2 = szAddrIncmgStreetLn2;
    } //-- void setSzAddrIncmgStreetLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncmgZip'.
     * 
     * @param szAddrIncmgZip the value of field 'szAddrIncmgZip'.
     */
    public void setSzAddrIncmgZip(java.lang.String szAddrIncmgZip)
    {
        this._szAddrIncmgZip = szAddrIncmgZip;
    } //-- void setSzAddrIncmgZip(java.lang.String) 

    /**
     * Sets the value of field 'szAddrIncomingCallerCity'.
     * 
     * @param szAddrIncomingCallerCity the value of field
     * 'szAddrIncomingCallerCity'.
     */
    public void setSzAddrIncomingCallerCity(java.lang.String szAddrIncomingCallerCity)
    {
        this._szAddrIncomingCallerCity = szAddrIncomingCallerCity;
    } //-- void setSzAddrIncomingCallerCity(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgAddrType'.
     * 
     * @param szCdIncmgAddrType the value of field
     * 'szCdIncmgAddrType'.
     */
    public void setSzCdIncmgAddrType(java.lang.String szCdIncmgAddrType)
    {
        this._szCdIncmgAddrType = szCdIncmgAddrType;
    } //-- void setSzCdIncmgAddrType(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgAllegType'.
     * 
     * @param szCdIncmgAllegType the value of field
     * 'szCdIncmgAllegType'.
     */
    public void setSzCdIncmgAllegType(java.lang.String szCdIncmgAllegType)
    {
        this._szCdIncmgAllegType = szCdIncmgAllegType;
    } //-- void setSzCdIncmgAllegType(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgCallerInt'.
     * 
     * @param szCdIncmgCallerInt the value of field
     * 'szCdIncmgCallerInt'.
     */
    public void setSzCdIncmgCallerInt(java.lang.String szCdIncmgCallerInt)
    {
        this._szCdIncmgCallerInt = szCdIncmgCallerInt;
    } //-- void setSzCdIncmgCallerInt(java.lang.String) 

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
     * Sets the value of field 'szCdIncmgRegion'.
     * 
     * @param szCdIncmgRegion the value of field 'szCdIncmgRegion'.
     */
    public void setSzCdIncmgRegion(java.lang.String szCdIncmgRegion)
    {
        this._szCdIncmgRegion = szCdIncmgRegion;
    } //-- void setSzCdIncmgRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgSex'.
     * 
     * @param szCdIncmgSex the value of field 'szCdIncmgSex'.
     */
    public void setSzCdIncmgSex(java.lang.String szCdIncmgSex)
    {
        this._szCdIncmgSex = szCdIncmgSex;
    } //-- void setSzCdIncmgSex(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgWorkerRegion'.
     * 
     * @param szCdIncmgWorkerRegion the value of field
     * 'szCdIncmgWorkerRegion'.
     */
    public void setSzCdIncmgWorkerRegion(java.lang.String szCdIncmgWorkerRegion)
    {
        this._szCdIncmgWorkerRegion = szCdIncmgWorkerRegion;
    } //-- void setSzCdIncmgWorkerRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingCallType'.
     * 
     * @param szCdIncomingCallType the value of field
     * 'szCdIncomingCallType'.
     */
    public void setSzCdIncomingCallType(java.lang.String szCdIncomingCallType)
    {
        this._szCdIncomingCallType = szCdIncomingCallType;
    } //-- void setSzCdIncomingCallType(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingCallerCounty'.
     * 
     * @param szCdIncomingCallerCounty the value of field
     * 'szCdIncomingCallerCounty'.
     */
    public void setSzCdIncomingCallerCounty(java.lang.String szCdIncomingCallerCounty)
    {
        this._szCdIncomingCallerCounty = szCdIncomingCallerCounty;
    } //-- void setSzCdIncomingCallerCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingCallerState'.
     * 
     * @param szCdIncomingCallerState the value of field
     * 'szCdIncomingCallerState'.
     */
    public void setSzCdIncomingCallerState(java.lang.String szCdIncomingCallerState)
    {
        this._szCdIncomingCallerState = szCdIncomingCallerState;
    } //-- void setSzCdIncomingCallerState(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingDisposition'.
     * 
     * @param szCdIncomingDisposition the value of field
     * 'szCdIncomingDisposition'.
     */
    public void setSzCdIncomingDisposition(java.lang.String szCdIncomingDisposition)
    {
        this._szCdIncomingDisposition = szCdIncomingDisposition;
    } //-- void setSzCdIncomingDisposition(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncomingWorkerCounty'.
     * 
     * @param szCdIncomingWorkerCounty the value of field
     * 'szCdIncomingWorkerCounty'.
     */
    public void setSzCdIncomingWorkerCounty(java.lang.String szCdIncomingWorkerCounty)
    {
        this._szCdIncomingWorkerCounty = szCdIncomingWorkerCounty;
    } //-- void setSzCdIncomingWorkerCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdInfoAndRefrl'.
     * 
     * @param szCdInfoAndRefrl the value of field 'szCdInfoAndRefrl'
     */
    public void setSzCdInfoAndRefrl(java.lang.String szCdInfoAndRefrl)
    {
        this._szCdInfoAndRefrl = szCdInfoAndRefrl;
    } //-- void setSzCdInfoAndRefrl(java.lang.String) 

    /**
     * Sets the value of field 'szCdNonRsdntReqType'.
     * 
     * @param szCdNonRsdntReqType the value of field
     * 'szCdNonRsdntReqType'.
     */
    public void setSzCdNonRsdntReqType(java.lang.String szCdNonRsdntReqType)
    {
        this._szCdNonRsdntReqType = szCdNonRsdntReqType;
    } //-- void setSzCdNonRsdntReqType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSpclCircumstances'.
     * 
     * @param szCdSpclCircumstances the value of field
     * 'szCdSpclCircumstances'.
     */
    public void setSzCdSpclCircumstances(java.lang.String szCdSpclCircumstances)
    {
        this._szCdSpclCircumstances = szCdSpclCircumstances;
    } //-- void setSzCdSpclCircumstances(java.lang.String) 

    /**
     * Sets the value of field 'szCdSpclInvstgtn'.
     * 
     * @param szCdSpclInvstgtn the value of field 'szCdSpclInvstgtn'
     */
    public void setSzCdSpclInvstgtn(java.lang.String szCdSpclInvstgtn)
    {
        this._szCdSpclInvstgtn = szCdSpclInvstgtn;
    } //-- void setSzCdSpclInvstgtn(java.lang.String) 

    /**
     * Sets the value of field 'szCdSpclReq'.
     * 
     * @param szCdSpclReq the value of field 'szCdSpclReq'.
     */
    public void setSzCdSpclReq(java.lang.String szCdSpclReq)
    {
        this._szCdSpclReq = szCdSpclReq;
    } //-- void setSzCdSpclReq(java.lang.String) 

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
     * Sets the value of field 'szCdStageClassification'.
     * 
     * @param szCdStageClassification the value of field
     * 'szCdStageClassification'.
     */
    public void setSzCdStageClassification(java.lang.String szCdStageClassification)
    {
        this._szCdStageClassification = szCdStageClassification;
    } //-- void setSzCdStageClassification(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCnty'.
     * 
     * @param szCdStageCnty the value of field 'szCdStageCnty'.
     */
    public void setSzCdStageCnty(java.lang.String szCdStageCnty)
    {
        this._szCdStageCnty = szCdStageCnty;
    } //-- void setSzCdStageCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageReasonClosed'.
     * 
     * @param szCdStageReasonClosed the value of field
     * 'szCdStageReasonClosed'.
     */
    public void setSzCdStageReasonClosed(java.lang.String szCdStageReasonClosed)
    {
        this._szCdStageReasonClosed = szCdStageReasonClosed;
    } //-- void setSzCdStageReasonClosed(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageRegion'.
     * 
     * @param szCdStageRegion the value of field 'szCdStageRegion'.
     */
    public void setSzCdStageRegion(java.lang.String szCdStageRegion)
    {
        this._szCdStageRegion = szCdStageRegion;
    } //-- void setSzCdStageRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageType'.
     * 
     * @param szCdStageType the value of field 'szCdStageType'.
     */
    public void setSzCdStageType(java.lang.String szCdStageType)
    {
        this._szCdStageType = szCdStageType;
    } //-- void setSzCdStageType(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgCallerExt'.
     * 
     * @param szNbrIncmgCallerExt the value of field
     * 'szNbrIncmgCallerExt'.
     */
    public void setSzNbrIncmgCallerExt(java.lang.String szNbrIncmgCallerExt)
    {
        this._szNbrIncmgCallerExt = szNbrIncmgCallerExt;
    } //-- void setSzNbrIncmgCallerExt(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgSupExt'.
     * 
     * @param szNbrIncmgSupExt the value of field 'szNbrIncmgSupExt'
     */
    public void setSzNbrIncmgSupExt(java.lang.String szNbrIncmgSupExt)
    {
        this._szNbrIncmgSupExt = szNbrIncmgSupExt;
    } //-- void setSzNbrIncmgSupExt(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgSupPhone'.
     * 
     * @param szNbrIncmgSupPhone the value of field
     * 'szNbrIncmgSupPhone'.
     */
    public void setSzNbrIncmgSupPhone(java.lang.String szNbrIncmgSupPhone)
    {
        this._szNbrIncmgSupPhone = szNbrIncmgSupPhone;
    } //-- void setSzNbrIncmgSupPhone(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncmgUnit'.
     * 
     * @param szNbrIncmgUnit the value of field 'szNbrIncmgUnit'.
     */
    public void setSzNbrIncmgUnit(java.lang.String szNbrIncmgUnit)
    {
        this._szNbrIncmgUnit = szNbrIncmgUnit;
    } //-- void setSzNbrIncmgUnit(java.lang.String) 

    /**
     * Sets the value of field 'szNbrIncomingCallerPhone'.
     * 
     * @param szNbrIncomingCallerPhone the value of field
     * 'szNbrIncomingCallerPhone'.
     */
    public void setSzNbrIncomingCallerPhone(java.lang.String szNbrIncomingCallerPhone)
    {
        this._szNbrIncomingCallerPhone = szNbrIncomingCallerPhone;
    } //-- void setSzNbrIncomingCallerPhone(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncWkrName'.
     * 
     * @param szNmIncWkrName the value of field 'szNmIncWkrName'.
     */
    public void setSzNmIncWkrName(java.lang.String szNmIncWkrName)
    {
        this._szNmIncWkrName = szNmIncWkrName;
    } //-- void setSzNmIncWkrName(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgRegardingFirst'.
     * 
     * @param szNmIncmgRegardingFirst the value of field
     * 'szNmIncmgRegardingFirst'.
     */
    public void setSzNmIncmgRegardingFirst(java.lang.String szNmIncmgRegardingFirst)
    {
        this._szNmIncmgRegardingFirst = szNmIncmgRegardingFirst;
    } //-- void setSzNmIncmgRegardingFirst(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgRegardingLast'.
     * 
     * @param szNmIncmgRegardingLast the value of field
     * 'szNmIncmgRegardingLast'.
     */
    public void setSzNmIncmgRegardingLast(java.lang.String szNmIncmgRegardingLast)
    {
        this._szNmIncmgRegardingLast = szNmIncmgRegardingLast;
    } //-- void setSzNmIncmgRegardingLast(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgSupName'.
     * 
     * @param szNmIncmgSupName the value of field 'szNmIncmgSupName'
     */
    public void setSzNmIncmgSupName(java.lang.String szNmIncmgSupName)
    {
        this._szNmIncmgSupName = szNmIncmgSupName;
    } //-- void setSzNmIncmgSupName(java.lang.String) 

    /**
     * Sets the value of field 'szNmJurisdiction'.
     * 
     * @param szNmJurisdiction the value of field 'szNmJurisdiction'
     */
    public void setSzNmJurisdiction(java.lang.String szNmJurisdiction)
    {
        this._szNmJurisdiction = szNmJurisdiction;
    } //-- void setSzNmJurisdiction(java.lang.String) 

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
     * Sets the value of field 'szSysCdWinMode'.
     * 
     * @param szSysCdWinMode the value of field 'szSysCdWinMode'.
     */
    public void setSzSysCdWinMode(java.lang.String szSysCdWinMode)
    {
        this._szSysCdWinMode = szSysCdWinMode;
    } //-- void setSzSysCdWinMode(java.lang.String) 

    /**
     * Sets the value of field 'tmSysTmCallDisp'.
     * 
     * @param tmSysTmCallDisp the value of field 'tmSysTmCallDisp'.
     */
    public void setTmSysTmCallDisp(java.lang.String tmSysTmCallDisp)
    {
        this._tmSysTmCallDisp = tmSysTmCallDisp;
    } //-- void setTmSysTmCallDisp(java.lang.String) 

    /**
     * Sets the value of field 'tmTmIncmgCall'.
     * 
     * @param tmTmIncmgCall the value of field 'tmTmIncmgCall'.
     */
    public void setTmTmIncmgCall(java.lang.String tmTmIncmgCall)
    {
        this._tmTmIncmgCall = tmTmIncmgCall;
    } //-- void setTmTmIncmgCall(java.lang.String) 

    /**
     * Sets the value of field 'tsIncmgCallDisp'.
     * 
     * @param tsIncmgCallDisp the value of field 'tsIncmgCallDisp'.
     */
    public void setTsIncmgCallDisp(java.util.Date tsIncmgCallDisp)
    {
        this._tsIncmgCallDisp = tsIncmgCallDisp;
    } //-- void setTsIncmgCallDisp(java.util.Date) 

    /**
     * Sets the value of field 'ulIdAllegation'.
     * 
     * @param ulIdAllegation the value of field 'ulIdAllegation'.
     */
    public void setUlIdAllegation(int ulIdAllegation)
    {
        this._ulIdAllegation = ulIdAllegation;
        this._has_ulIdAllegation = true;
    } //-- void setUlIdAllegation(int) 

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
     * Sets the value of field 'ulIdIncomingSup'.
     * 
     * @param ulIdIncomingSup the value of field 'ulIdIncomingSup'.
     */
    public void setUlIdIncomingSup(int ulIdIncomingSup)
    {
        this._ulIdIncomingSup = ulIdIncomingSup;
        this._has_ulIdIncomingSup = true;
    } //-- void setUlIdIncomingSup(int) 

    /**
     * Sets the value of field 'ulIdIncomingWkr'.
     * 
     * @param ulIdIncomingWkr the value of field 'ulIdIncomingWkr'.
     */
    public void setUlIdIncomingWkr(int ulIdIncomingWkr)
    {
        this._ulIdIncomingWkr = ulIdIncomingWkr;
        this._has_ulIdIncomingWkr = true;
    } //-- void setUlIdIncomingWkr(int) 

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
     * Sets the value of field 'ulIdSituation'.
     * 
     * @param ulIdSituation the value of field 'ulIdSituation'.
     */
    public void setUlIdSituation(int ulIdSituation)
    {
        this._ulIdSituation = ulIdSituation;
        this._has_ulIdSituation = true;
    } //-- void setUlIdSituation(int) 

    /**
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

    /**
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct unmarshal(java.io.Reader) 

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
