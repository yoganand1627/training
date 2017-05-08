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
 * Class CFAD39SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD39SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cIndIncidentChildInPad
     */
    private java.lang.String _cIndIncidentChildInPad;

    /**
     * Field _cIndSauConf
     */
    private java.lang.String _cIndSauConf;

    /**
     * Field _cIndSpclAsstApprvl
     */
    private java.lang.String _cIndSpclAsstApprvl;

    /**
     * Field _dtDtSndAprv
     */
    private org.exolab.castor.types.Date _dtDtSndAprv;

    /**
     * Field _szSndFndType
     */
    private java.lang.String _szSndFndType;

    /**
     * Field _szSndAprvType
     */
    private java.lang.String _szSndAprvType;

    /**
     * Field _szSpcSvcType
     */
    private java.lang.String _szSpcSvcType;

    /**
     * Field _szSpcSvcAprvAmt
     */
    private double _szSpcSvcAprvAmt;

    /**
     * keeps track of state for field: _szSpcSvcAprvAmt
     */
    private boolean _has_szSpcSvcAprvAmt;

    /**
     * Field _szNonRecAprvAmt
     */
    private double _szNonRecAprvAmt;

    /**
     * keeps track of state for field: _szNonRecAprvAmt
     */
    private boolean _has_szNonRecAprvAmt;

    /**
     * Field _szSpcRtAprvAmt
     */
    private double _szSpcRtAprvAmt;

    /**
     * keeps track of state for field: _szSpcRtAprvAmt
     */
    private boolean _has_szSpcRtAprvAmt;

    /**
     * Field _sAmtSpclAsstReq
     */
    private double _sAmtSpclAsstReq;

    /**
     * keeps track of state for field: _sAmtSpclAsstReq
     */
    private boolean _has_sAmtSpclAsstReq;

    /**
     * Field _szCdSpclAsstType
     */
    private java.lang.String _szCdSpclAsstType;

    /**
     * Field _szTxtSpclAsstSpecify
     */
    private java.lang.String _szTxtSpclAsstSpecify;

    /**
     * Field _szTxtSpclAsstCmnts
     */
    private java.lang.String _szTxtSpclAsstCmnts;

    /**
     * Field _dtDtRenwlEffBegin
     */
    private org.exolab.castor.types.Date _dtDtRenwlEffBegin;

    /**
     * Field _dtDtRenwlEffEnd
     */
    private org.exolab.castor.types.Date _dtDtRenwlEffEnd;

    /**
     * Field _dtDtAdptSubAgreeRetn
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAgreeRetn;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _ulIdAdptSub
     */
    private int _ulIdAdptSub;

    /**
     * keeps track of state for field: _ulIdAdptSub
     */
    private boolean _has_ulIdAdptSub;

    /**
     * Field _dtDtAdptSubLastInvc
     */
    private org.exolab.castor.types.Date _dtDtAdptSubLastInvc;

    /**
     * Field _ulIdAdptSubPayee
     */
    private int _ulIdAdptSubPayee;

    /**
     * keeps track of state for field: _ulIdAdptSubPayee
     */
    private boolean _has_ulIdAdptSubPayee;

    /**
     * Field _dtDtAdptSubAgreeSent
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAgreeSent;

    /**
     * Field _dtDtAdptSubAppReturned
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAppReturned;

    /**
     * Field _dtDtAdptSubAppSent
     */
    private org.exolab.castor.types.Date _dtDtAdptSubAppSent;

    /**
     * Field _dtDtAdptSubApprvd
     */
    private org.exolab.castor.types.Date _dtDtAdptSubApprvd;

    /**
     * Field _dtDtAdptSubEffective
     */
    private org.exolab.castor.types.Date _dtDtAdptSubEffective;

    /**
     * Field _dtDtAdptSubEnd
     */
    private org.exolab.castor.types.Date _dtDtAdptSubEnd;

    /**
     * Field _dtDtAdptSubTerm
     */
    private org.exolab.castor.types.Date _dtDtAdptSubTerm;

    /**
     * Field _sAmtAdptSub
     */
    private double _sAmtAdptSub;

    /**
     * keeps track of state for field: _sAmtAdptSub
     */
    private boolean _has_sAmtAdptSub;

    /**
     * Field _sAmtAdptBaseRate
     */
    private double _sAmtAdptBaseRate;

    /**
     * keeps track of state for field: _sAmtAdptBaseRate
     */
    private boolean _has_sAmtAdptBaseRate;

    /**
     * Field _szTxtAdptSubRsn
     */
    private java.lang.String _szTxtAdptSubRsn;

    /**
     * Field _szCdAdptSubCloseRsn
     */
    private java.lang.String _szCdAdptSubCloseRsn;

    /**
     * Field _cIndAdptSubThirdParty
     */
    private java.lang.String _cIndAdptSubThirdParty;

    /**
     * Field _cIndSchoolVerified
     */
    private java.lang.String _cIndSchoolVerified;

    /**
     * Field _cIndAdptSubProcess
     */
    private java.lang.String _cIndAdptSubProcess;

    /**
     * Field _szCdAdptSubDeterm
     */
    private java.lang.String _szCdAdptSubDeterm;

    /**
     * Field _szCdPlaymentMthd
     */
    private java.lang.String _szCdPlaymentMthd;

    /**
     * Field _ulIdSpecialNeedsEvent
     */
    private int _ulIdSpecialNeedsEvent;

    /**
     * keeps track of state for field: _ulIdSpecialNeedsEvent
     */
    private boolean _has_ulIdSpecialNeedsEvent;

    /**
     * Field _szCdAllNonIncidentSSA
     */
    private java.lang.String _szCdAllNonIncidentSSA;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _indPriorEndedArgreement
     */
    private java.lang.String _indPriorEndedArgreement;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _bIndBasicRateReq
     */
    private java.lang.String _bIndBasicRateReq;

    /**
     * Field _bIndSpcNeedsApproved
     */
    private java.lang.String _bIndSpcNeedsApproved;

    /**
     * Field _bIndNonRecRequested
     */
    private java.lang.String _bIndNonRecRequested;

    /**
     * Field _bIndNonRecApproved
     */
    private java.lang.String _bIndNonRecApproved;

    /**
     * Field _BIndSpclServiceReq
     */
    private java.lang.String _BIndSpclServiceReq;

    /**
     * Field _BIndSpclReqApproved
     */
    private java.lang.String _BIndSpclReqApproved;

    /**
     * Field _BIndSpecializedRateReq
     */
    private java.lang.String _BIndSpecializedRateReq;

    /**
     * Field _BIndSpclRateAdoAppr
     */
    private java.lang.String _BIndSpclRateAdoAppr;

    /**
     * Field _BIndReasonSpecialRequest
     */
    private java.lang.String _BIndReasonSpecialRequest;

    /**
     * Field _dtDtApprvDate
     */
    private org.exolab.castor.types.Date _dtDtApprvDate;

    /**
     * Field _dtDtExpirationDate
     */
    private org.exolab.castor.types.Date _dtDtExpirationDate;

    /**
     * Field _dtDtPlcmtStart
     */
    private java.util.Date _dtDtPlcmtStart;

    /**
     * Field _dtDtLatestSndAprv
     */
    private org.exolab.castor.types.Date _dtDtLatestSndAprv;

    /**
     * Field _ulAmtBasicRate
     */
    private double _ulAmtBasicRate;

    /**
     * keeps track of state for field: _ulAmtBasicRate
     */
    private boolean _has_ulAmtBasicRate;

    /**
     * Field _szCdPaymentMethodApp
     */
    private java.lang.String _szCdPaymentMethodApp;

    /**
     * Field _szTxtOtherSpcServ
     */
    private java.lang.String _szTxtOtherSpcServ;

    /**
     * Field _szTxtComments
     */
    private java.lang.String _szTxtComments;

    /**
     * Field _cdBasicRateType
     */
    private java.lang.String _cdBasicRateType;

    /**
     * Field _sNbrBasicAmt
     */
    private double _sNbrBasicAmt;

    /**
     * keeps track of state for field: _sNbrBasicAmt
     */
    private boolean _has_sNbrBasicAmt;

    /**
     * Field _sNbrCountyAddonAmt
     */
    private double _sNbrCountyAddonAmt;

    /**
     * keeps track of state for field: _sNbrCountyAddonAmt
     */
    private boolean _has_sNbrCountyAddonAmt;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD39SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSAmtAdptBaseRate()
    {
        this._has_sAmtAdptBaseRate= false;
    } //-- void deleteSAmtAdptBaseRate() 

    /**
     */
    public void deleteSAmtAdptSub()
    {
        this._has_sAmtAdptSub= false;
    } //-- void deleteSAmtAdptSub() 

    /**
     */
    public void deleteSAmtSpclAsstReq()
    {
        this._has_sAmtSpclAsstReq= false;
    } //-- void deleteSAmtSpclAsstReq() 

    /**
     */
    public void deleteSNbrBasicAmt()
    {
        this._has_sNbrBasicAmt= false;
    } //-- void deleteSNbrBasicAmt() 

    /**
     */
    public void deleteSNbrCountyAddonAmt()
    {
        this._has_sNbrCountyAddonAmt= false;
    } //-- void deleteSNbrCountyAddonAmt() 

    /**
     */
    public void deleteSzNonRecAprvAmt()
    {
        this._has_szNonRecAprvAmt= false;
    } //-- void deleteSzNonRecAprvAmt() 

    /**
     */
    public void deleteSzSpcRtAprvAmt()
    {
        this._has_szSpcRtAprvAmt= false;
    } //-- void deleteSzSpcRtAprvAmt() 

    /**
     */
    public void deleteSzSpcSvcAprvAmt()
    {
        this._has_szSpcSvcAprvAmt= false;
    } //-- void deleteSzSpcSvcAprvAmt() 

    /**
     */
    public void deleteUlAmtBasicRate()
    {
        this._has_ulAmtBasicRate= false;
    } //-- void deleteUlAmtBasicRate() 

    /**
     */
    public void deleteUlIdAdptSub()
    {
        this._has_ulIdAdptSub= false;
    } //-- void deleteUlIdAdptSub() 

    /**
     */
    public void deleteUlIdAdptSubPayee()
    {
        this._has_ulIdAdptSubPayee= false;
    } //-- void deleteUlIdAdptSubPayee() 

    /**
     */
    public void deleteUlIdSpecialNeedsEvent()
    {
        this._has_ulIdSpecialNeedsEvent= false;
    } //-- void deleteUlIdSpecialNeedsEvent() 

    /**
     * Returns the value of field 'bIndBasicRateReq'.
     * 
     * @return the value of field 'BIndBasicRateReq'.
     */
    public java.lang.String getBIndBasicRateReq()
    {
        return this._bIndBasicRateReq;
    } //-- java.lang.String getBIndBasicRateReq() 

    /**
     * Returns the value of field 'bIndNonRecApproved'.
     * 
     * @return the value of field 'BIndNonRecApproved'.
     */
    public java.lang.String getBIndNonRecApproved()
    {
        return this._bIndNonRecApproved;
    } //-- java.lang.String getBIndNonRecApproved() 

    /**
     * Returns the value of field 'bIndNonRecRequested'.
     * 
     * @return the value of field 'BIndNonRecRequested'.
     */
    public java.lang.String getBIndNonRecRequested()
    {
        return this._bIndNonRecRequested;
    } //-- java.lang.String getBIndNonRecRequested() 

    /**
     * Returns the value of field 'BIndReasonSpecialRequest'.
     * 
     * @return the value of field 'BIndReasonSpecialRequest'.
     */
    public java.lang.String getBIndReasonSpecialRequest()
    {
        return this._BIndReasonSpecialRequest;
    } //-- java.lang.String getBIndReasonSpecialRequest() 

    /**
     * Returns the value of field 'bIndSpcNeedsApproved'.
     * 
     * @return the value of field 'BIndSpcNeedsApproved'.
     */
    public java.lang.String getBIndSpcNeedsApproved()
    {
        return this._bIndSpcNeedsApproved;
    } //-- java.lang.String getBIndSpcNeedsApproved() 

    /**
     * Returns the value of field 'BIndSpclRateAdoAppr'.
     * 
     * @return the value of field 'BIndSpclRateAdoAppr'.
     */
    public java.lang.String getBIndSpclRateAdoAppr()
    {
        return this._BIndSpclRateAdoAppr;
    } //-- java.lang.String getBIndSpclRateAdoAppr() 

    /**
     * Returns the value of field 'BIndSpclReqApproved'.
     * 
     * @return the value of field 'BIndSpclReqApproved'.
     */
    public java.lang.String getBIndSpclReqApproved()
    {
        return this._BIndSpclReqApproved;
    } //-- java.lang.String getBIndSpclReqApproved() 

    /**
     * Returns the value of field 'BIndSpclServiceReq'.
     * 
     * @return the value of field 'BIndSpclServiceReq'.
     */
    public java.lang.String getBIndSpclServiceReq()
    {
        return this._BIndSpclServiceReq;
    } //-- java.lang.String getBIndSpclServiceReq() 

    /**
     * Returns the value of field 'BIndSpecializedRateReq'.
     * 
     * @return the value of field 'BIndSpecializedRateReq'.
     */
    public java.lang.String getBIndSpecializedRateReq()
    {
        return this._BIndSpecializedRateReq;
    } //-- java.lang.String getBIndSpecializedRateReq() 

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
     * Returns the value of field 'cIndAdptSubProcess'.
     * 
     * @return the value of field 'CIndAdptSubProcess'.
     */
    public java.lang.String getCIndAdptSubProcess()
    {
        return this._cIndAdptSubProcess;
    } //-- java.lang.String getCIndAdptSubProcess() 

    /**
     * Returns the value of field 'cIndAdptSubThirdParty'.
     * 
     * @return the value of field 'CIndAdptSubThirdParty'.
     */
    public java.lang.String getCIndAdptSubThirdParty()
    {
        return this._cIndAdptSubThirdParty;
    } //-- java.lang.String getCIndAdptSubThirdParty() 

    /**
     * Returns the value of field 'cIndIncidentChildInPad'.
     * 
     * @return the value of field 'CIndIncidentChildInPad'.
     */
    public java.lang.String getCIndIncidentChildInPad()
    {
        return this._cIndIncidentChildInPad;
    } //-- java.lang.String getCIndIncidentChildInPad() 

    /**
     * Returns the value of field 'cIndSauConf'.
     * 
     * @return the value of field 'CIndSauConf'.
     */
    public java.lang.String getCIndSauConf()
    {
        return this._cIndSauConf;
    } //-- java.lang.String getCIndSauConf() 

    /**
     * Returns the value of field 'cIndSchoolVerified'.
     * 
     * @return the value of field 'CIndSchoolVerified'.
     */
    public java.lang.String getCIndSchoolVerified()
    {
        return this._cIndSchoolVerified;
    } //-- java.lang.String getCIndSchoolVerified() 

    /**
     * Returns the value of field 'cIndSpclAsstApprvl'.
     * 
     * @return the value of field 'CIndSpclAsstApprvl'.
     */
    public java.lang.String getCIndSpclAsstApprvl()
    {
        return this._cIndSpclAsstApprvl;
    } //-- java.lang.String getCIndSpclAsstApprvl() 

    /**
     * Returns the value of field 'cdBasicRateType'.
     * 
     * @return the value of field 'CdBasicRateType'.
     */
    public java.lang.String getCdBasicRateType()
    {
        return this._cdBasicRateType;
    } //-- java.lang.String getCdBasicRateType() 

    /**
     * Returns the value of field 'dtDtAdptSubAgreeRetn'.
     * 
     * @return the value of field 'DtDtAdptSubAgreeRetn'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAgreeRetn()
    {
        return this._dtDtAdptSubAgreeRetn;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAgreeRetn() 

    /**
     * Returns the value of field 'dtDtAdptSubAgreeSent'.
     * 
     * @return the value of field 'DtDtAdptSubAgreeSent'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAgreeSent()
    {
        return this._dtDtAdptSubAgreeSent;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAgreeSent() 

    /**
     * Returns the value of field 'dtDtAdptSubAppReturned'.
     * 
     * @return the value of field 'DtDtAdptSubAppReturned'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAppReturned()
    {
        return this._dtDtAdptSubAppReturned;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAppReturned() 

    /**
     * Returns the value of field 'dtDtAdptSubAppSent'.
     * 
     * @return the value of field 'DtDtAdptSubAppSent'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubAppSent()
    {
        return this._dtDtAdptSubAppSent;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubAppSent() 

    /**
     * Returns the value of field 'dtDtAdptSubApprvd'.
     * 
     * @return the value of field 'DtDtAdptSubApprvd'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubApprvd()
    {
        return this._dtDtAdptSubApprvd;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubApprvd() 

    /**
     * Returns the value of field 'dtDtAdptSubEffective'.
     * 
     * @return the value of field 'DtDtAdptSubEffective'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubEffective()
    {
        return this._dtDtAdptSubEffective;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubEffective() 

    /**
     * Returns the value of field 'dtDtAdptSubEnd'.
     * 
     * @return the value of field 'DtDtAdptSubEnd'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubEnd()
    {
        return this._dtDtAdptSubEnd;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubEnd() 

    /**
     * Returns the value of field 'dtDtAdptSubLastInvc'.
     * 
     * @return the value of field 'DtDtAdptSubLastInvc'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubLastInvc()
    {
        return this._dtDtAdptSubLastInvc;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubLastInvc() 

    /**
     * Returns the value of field 'dtDtAdptSubTerm'.
     * 
     * @return the value of field 'DtDtAdptSubTerm'.
     */
    public org.exolab.castor.types.Date getDtDtAdptSubTerm()
    {
        return this._dtDtAdptSubTerm;
    } //-- org.exolab.castor.types.Date getDtDtAdptSubTerm() 

    /**
     * Returns the value of field 'dtDtApprvDate'.
     * 
     * @return the value of field 'DtDtApprvDate'.
     */
    public org.exolab.castor.types.Date getDtDtApprvDate()
    {
        return this._dtDtApprvDate;
    } //-- org.exolab.castor.types.Date getDtDtApprvDate() 

    /**
     * Returns the value of field 'dtDtExpirationDate'.
     * 
     * @return the value of field 'DtDtExpirationDate'.
     */
    public org.exolab.castor.types.Date getDtDtExpirationDate()
    {
        return this._dtDtExpirationDate;
    } //-- org.exolab.castor.types.Date getDtDtExpirationDate() 

    /**
     * Returns the value of field 'dtDtLatestSndAprv'.
     * 
     * @return the value of field 'DtDtLatestSndAprv'.
     */
    public org.exolab.castor.types.Date getDtDtLatestSndAprv()
    {
        return this._dtDtLatestSndAprv;
    } //-- org.exolab.castor.types.Date getDtDtLatestSndAprv() 

    /**
     * Returns the value of field 'dtDtPlcmtStart'.
     * 
     * @return the value of field 'DtDtPlcmtStart'.
     */
    public java.util.Date getDtDtPlcmtStart()
    {
        return this._dtDtPlcmtStart;
    } //-- java.util.Date getDtDtPlcmtStart() 

    /**
     * Returns the value of field 'dtDtRenwlEffBegin'.
     * 
     * @return the value of field 'DtDtRenwlEffBegin'.
     */
    public org.exolab.castor.types.Date getDtDtRenwlEffBegin()
    {
        return this._dtDtRenwlEffBegin;
    } //-- org.exolab.castor.types.Date getDtDtRenwlEffBegin() 

    /**
     * Returns the value of field 'dtDtRenwlEffEnd'.
     * 
     * @return the value of field 'DtDtRenwlEffEnd'.
     */
    public org.exolab.castor.types.Date getDtDtRenwlEffEnd()
    {
        return this._dtDtRenwlEffEnd;
    } //-- org.exolab.castor.types.Date getDtDtRenwlEffEnd() 

    /**
     * Returns the value of field 'dtDtSndAprv'.
     * 
     * @return the value of field 'DtDtSndAprv'.
     */
    public org.exolab.castor.types.Date getDtDtSndAprv()
    {
        return this._dtDtSndAprv;
    } //-- org.exolab.castor.types.Date getDtDtSndAprv() 

    /**
     * Returns the value of field 'indPriorEndedArgreement'.
     * 
     * @return the value of field 'IndPriorEndedArgreement'.
     */
    public java.lang.String getIndPriorEndedArgreement()
    {
        return this._indPriorEndedArgreement;
    } //-- java.lang.String getIndPriorEndedArgreement() 

    /**
     * Returns the value of field 'sAmtAdptBaseRate'.
     * 
     * @return the value of field 'SAmtAdptBaseRate'.
     */
    public double getSAmtAdptBaseRate()
    {
        return this._sAmtAdptBaseRate;
    } //-- double getSAmtAdptBaseRate() 

    /**
     * Returns the value of field 'sAmtAdptSub'.
     * 
     * @return the value of field 'SAmtAdptSub'.
     */
    public double getSAmtAdptSub()
    {
        return this._sAmtAdptSub;
    } //-- double getSAmtAdptSub() 

    /**
     * Returns the value of field 'sAmtSpclAsstReq'.
     * 
     * @return the value of field 'SAmtSpclAsstReq'.
     */
    public double getSAmtSpclAsstReq()
    {
        return this._sAmtSpclAsstReq;
    } //-- double getSAmtSpclAsstReq() 

    /**
     * Returns the value of field 'sNbrBasicAmt'.
     * 
     * @return the value of field 'SNbrBasicAmt'.
     */
    public double getSNbrBasicAmt()
    {
        return this._sNbrBasicAmt;
    } //-- double getSNbrBasicAmt() 

    /**
     * Returns the value of field 'sNbrCountyAddonAmt'.
     * 
     * @return the value of field 'SNbrCountyAddonAmt'.
     */
    public double getSNbrCountyAddonAmt()
    {
        return this._sNbrCountyAddonAmt;
    } //-- double getSNbrCountyAddonAmt() 

    /**
     * Returns the value of field 'szCdAdptSubCloseRsn'.
     * 
     * @return the value of field 'SzCdAdptSubCloseRsn'.
     */
    public java.lang.String getSzCdAdptSubCloseRsn()
    {
        return this._szCdAdptSubCloseRsn;
    } //-- java.lang.String getSzCdAdptSubCloseRsn() 

    /**
     * Returns the value of field 'szCdAdptSubDeterm'.
     * 
     * @return the value of field 'SzCdAdptSubDeterm'.
     */
    public java.lang.String getSzCdAdptSubDeterm()
    {
        return this._szCdAdptSubDeterm;
    } //-- java.lang.String getSzCdAdptSubDeterm() 

    /**
     * Returns the value of field 'szCdAllNonIncidentSSA'.
     * 
     * @return the value of field 'SzCdAllNonIncidentSSA'.
     */
    public java.lang.String getSzCdAllNonIncidentSSA()
    {
        return this._szCdAllNonIncidentSSA;
    } //-- java.lang.String getSzCdAllNonIncidentSSA() 

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
     * Returns the value of field 'szCdPaymentMethodApp'.
     * 
     * @return the value of field 'SzCdPaymentMethodApp'.
     */
    public java.lang.String getSzCdPaymentMethodApp()
    {
        return this._szCdPaymentMethodApp;
    } //-- java.lang.String getSzCdPaymentMethodApp() 

    /**
     * Returns the value of field 'szCdPlaymentMthd'.
     * 
     * @return the value of field 'SzCdPlaymentMthd'.
     */
    public java.lang.String getSzCdPlaymentMthd()
    {
        return this._szCdPlaymentMthd;
    } //-- java.lang.String getSzCdPlaymentMthd() 

    /**
     * Returns the value of field 'szCdSpclAsstType'.
     * 
     * @return the value of field 'SzCdSpclAsstType'.
     */
    public java.lang.String getSzCdSpclAsstType()
    {
        return this._szCdSpclAsstType;
    } //-- java.lang.String getSzCdSpclAsstType() 

    /**
     * Returns the value of field 'szNonRecAprvAmt'.
     * 
     * @return the value of field 'SzNonRecAprvAmt'.
     */
    public double getSzNonRecAprvAmt()
    {
        return this._szNonRecAprvAmt;
    } //-- double getSzNonRecAprvAmt() 

    /**
     * Returns the value of field 'szSndAprvType'.
     * 
     * @return the value of field 'SzSndAprvType'.
     */
    public java.lang.String getSzSndAprvType()
    {
        return this._szSndAprvType;
    } //-- java.lang.String getSzSndAprvType() 

    /**
     * Returns the value of field 'szSndFndType'.
     * 
     * @return the value of field 'SzSndFndType'.
     */
    public java.lang.String getSzSndFndType()
    {
        return this._szSndFndType;
    } //-- java.lang.String getSzSndFndType() 

    /**
     * Returns the value of field 'szSpcRtAprvAmt'.
     * 
     * @return the value of field 'SzSpcRtAprvAmt'.
     */
    public double getSzSpcRtAprvAmt()
    {
        return this._szSpcRtAprvAmt;
    } //-- double getSzSpcRtAprvAmt() 

    /**
     * Returns the value of field 'szSpcSvcAprvAmt'.
     * 
     * @return the value of field 'SzSpcSvcAprvAmt'.
     */
    public double getSzSpcSvcAprvAmt()
    {
        return this._szSpcSvcAprvAmt;
    } //-- double getSzSpcSvcAprvAmt() 

    /**
     * Returns the value of field 'szSpcSvcType'.
     * 
     * @return the value of field 'SzSpcSvcType'.
     */
    public java.lang.String getSzSpcSvcType()
    {
        return this._szSpcSvcType;
    } //-- java.lang.String getSzSpcSvcType() 

    /**
     * Returns the value of field 'szTxtAdptSubRsn'.
     * 
     * @return the value of field 'SzTxtAdptSubRsn'.
     */
    public java.lang.String getSzTxtAdptSubRsn()
    {
        return this._szTxtAdptSubRsn;
    } //-- java.lang.String getSzTxtAdptSubRsn() 

    /**
     * Returns the value of field 'szTxtComments'.
     * 
     * @return the value of field 'SzTxtComments'.
     */
    public java.lang.String getSzTxtComments()
    {
        return this._szTxtComments;
    } //-- java.lang.String getSzTxtComments() 

    /**
     * Returns the value of field 'szTxtOtherSpcServ'.
     * 
     * @return the value of field 'SzTxtOtherSpcServ'.
     */
    public java.lang.String getSzTxtOtherSpcServ()
    {
        return this._szTxtOtherSpcServ;
    } //-- java.lang.String getSzTxtOtherSpcServ() 

    /**
     * Returns the value of field 'szTxtSpclAsstCmnts'.
     * 
     * @return the value of field 'SzTxtSpclAsstCmnts'.
     */
    public java.lang.String getSzTxtSpclAsstCmnts()
    {
        return this._szTxtSpclAsstCmnts;
    } //-- java.lang.String getSzTxtSpclAsstCmnts() 

    /**
     * Returns the value of field 'szTxtSpclAsstSpecify'.
     * 
     * @return the value of field 'SzTxtSpclAsstSpecify'.
     */
    public java.lang.String getSzTxtSpclAsstSpecify()
    {
        return this._szTxtSpclAsstSpecify;
    } //-- java.lang.String getSzTxtSpclAsstSpecify() 

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
     * Returns the value of field 'ulAmtBasicRate'.
     * 
     * @return the value of field 'UlAmtBasicRate'.
     */
    public double getUlAmtBasicRate()
    {
        return this._ulAmtBasicRate;
    } //-- double getUlAmtBasicRate() 

    /**
     * Returns the value of field 'ulIdAdptSub'.
     * 
     * @return the value of field 'UlIdAdptSub'.
     */
    public int getUlIdAdptSub()
    {
        return this._ulIdAdptSub;
    } //-- int getUlIdAdptSub() 

    /**
     * Returns the value of field 'ulIdAdptSubPayee'.
     * 
     * @return the value of field 'UlIdAdptSubPayee'.
     */
    public int getUlIdAdptSubPayee()
    {
        return this._ulIdAdptSubPayee;
    } //-- int getUlIdAdptSubPayee() 

    /**
     * Returns the value of field 'ulIdSpecialNeedsEvent'.
     * 
     * @return the value of field 'UlIdSpecialNeedsEvent'.
     */
    public int getUlIdSpecialNeedsEvent()
    {
        return this._ulIdSpecialNeedsEvent;
    } //-- int getUlIdSpecialNeedsEvent() 

    /**
     * Method hasSAmtAdptBaseRate
     * 
     * 
     * 
     * @return true if at least one SAmtAdptBaseRate has been added
     */
    public boolean hasSAmtAdptBaseRate()
    {
        return this._has_sAmtAdptBaseRate;
    } //-- boolean hasSAmtAdptBaseRate() 

    /**
     * Method hasSAmtAdptSub
     * 
     * 
     * 
     * @return true if at least one SAmtAdptSub has been added
     */
    public boolean hasSAmtAdptSub()
    {
        return this._has_sAmtAdptSub;
    } //-- boolean hasSAmtAdptSub() 

    /**
     * Method hasSAmtSpclAsstReq
     * 
     * 
     * 
     * @return true if at least one SAmtSpclAsstReq has been added
     */
    public boolean hasSAmtSpclAsstReq()
    {
        return this._has_sAmtSpclAsstReq;
    } //-- boolean hasSAmtSpclAsstReq() 

    /**
     * Method hasSNbrBasicAmt
     * 
     * 
     * 
     * @return true if at least one SNbrBasicAmt has been added
     */
    public boolean hasSNbrBasicAmt()
    {
        return this._has_sNbrBasicAmt;
    } //-- boolean hasSNbrBasicAmt() 

    /**
     * Method hasSNbrCountyAddonAmt
     * 
     * 
     * 
     * @return true if at least one SNbrCountyAddonAmt has been adde
     */
    public boolean hasSNbrCountyAddonAmt()
    {
        return this._has_sNbrCountyAddonAmt;
    } //-- boolean hasSNbrCountyAddonAmt() 

    /**
     * Method hasSzNonRecAprvAmt
     * 
     * 
     * 
     * @return true if at least one SzNonRecAprvAmt has been added
     */
    public boolean hasSzNonRecAprvAmt()
    {
        return this._has_szNonRecAprvAmt;
    } //-- boolean hasSzNonRecAprvAmt() 

    /**
     * Method hasSzSpcRtAprvAmt
     * 
     * 
     * 
     * @return true if at least one SzSpcRtAprvAmt has been added
     */
    public boolean hasSzSpcRtAprvAmt()
    {
        return this._has_szSpcRtAprvAmt;
    } //-- boolean hasSzSpcRtAprvAmt() 

    /**
     * Method hasSzSpcSvcAprvAmt
     * 
     * 
     * 
     * @return true if at least one SzSpcSvcAprvAmt has been added
     */
    public boolean hasSzSpcSvcAprvAmt()
    {
        return this._has_szSpcSvcAprvAmt;
    } //-- boolean hasSzSpcSvcAprvAmt() 

    /**
     * Method hasUlAmtBasicRate
     * 
     * 
     * 
     * @return true if at least one UlAmtBasicRate has been added
     */
    public boolean hasUlAmtBasicRate()
    {
        return this._has_ulAmtBasicRate;
    } //-- boolean hasUlAmtBasicRate() 

    /**
     * Method hasUlIdAdptSub
     * 
     * 
     * 
     * @return true if at least one UlIdAdptSub has been added
     */
    public boolean hasUlIdAdptSub()
    {
        return this._has_ulIdAdptSub;
    } //-- boolean hasUlIdAdptSub() 

    /**
     * Method hasUlIdAdptSubPayee
     * 
     * 
     * 
     * @return true if at least one UlIdAdptSubPayee has been added
     */
    public boolean hasUlIdAdptSubPayee()
    {
        return this._has_ulIdAdptSubPayee;
    } //-- boolean hasUlIdAdptSubPayee() 

    /**
     * Method hasUlIdSpecialNeedsEvent
     * 
     * 
     * 
     * @return true if at least one UlIdSpecialNeedsEvent has been
     * added
     */
    public boolean hasUlIdSpecialNeedsEvent()
    {
        return this._has_ulIdSpecialNeedsEvent;
    } //-- boolean hasUlIdSpecialNeedsEvent() 

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
     * Sets the value of field 'bIndBasicRateReq'.
     * 
     * @param bIndBasicRateReq the value of field 'bIndBasicRateReq'
     */
    public void setBIndBasicRateReq(java.lang.String bIndBasicRateReq)
    {
        this._bIndBasicRateReq = bIndBasicRateReq;
    } //-- void setBIndBasicRateReq(java.lang.String) 

    /**
     * Sets the value of field 'bIndNonRecApproved'.
     * 
     * @param bIndNonRecApproved the value of field
     * 'bIndNonRecApproved'.
     */
    public void setBIndNonRecApproved(java.lang.String bIndNonRecApproved)
    {
        this._bIndNonRecApproved = bIndNonRecApproved;
    } //-- void setBIndNonRecApproved(java.lang.String) 

    /**
     * Sets the value of field 'bIndNonRecRequested'.
     * 
     * @param bIndNonRecRequested the value of field
     * 'bIndNonRecRequested'.
     */
    public void setBIndNonRecRequested(java.lang.String bIndNonRecRequested)
    {
        this._bIndNonRecRequested = bIndNonRecRequested;
    } //-- void setBIndNonRecRequested(java.lang.String) 

    /**
     * Sets the value of field 'BIndReasonSpecialRequest'.
     * 
     * @param BIndReasonSpecialRequest the value of field
     * 'BIndReasonSpecialRequest'.
     */
    public void setBIndReasonSpecialRequest(java.lang.String BIndReasonSpecialRequest)
    {
        this._BIndReasonSpecialRequest = BIndReasonSpecialRequest;
    } //-- void setBIndReasonSpecialRequest(java.lang.String) 

    /**
     * Sets the value of field 'bIndSpcNeedsApproved'.
     * 
     * @param bIndSpcNeedsApproved the value of field
     * 'bIndSpcNeedsApproved'.
     */
    public void setBIndSpcNeedsApproved(java.lang.String bIndSpcNeedsApproved)
    {
        this._bIndSpcNeedsApproved = bIndSpcNeedsApproved;
    } //-- void setBIndSpcNeedsApproved(java.lang.String) 

    /**
     * Sets the value of field 'BIndSpclRateAdoAppr'.
     * 
     * @param BIndSpclRateAdoAppr the value of field
     * 'BIndSpclRateAdoAppr'.
     */
    public void setBIndSpclRateAdoAppr(java.lang.String BIndSpclRateAdoAppr)
    {
        this._BIndSpclRateAdoAppr = BIndSpclRateAdoAppr;
    } //-- void setBIndSpclRateAdoAppr(java.lang.String) 

    /**
     * Sets the value of field 'BIndSpclReqApproved'.
     * 
     * @param BIndSpclReqApproved the value of field
     * 'BIndSpclReqApproved'.
     */
    public void setBIndSpclReqApproved(java.lang.String BIndSpclReqApproved)
    {
        this._BIndSpclReqApproved = BIndSpclReqApproved;
    } //-- void setBIndSpclReqApproved(java.lang.String) 

    /**
     * Sets the value of field 'BIndSpclServiceReq'.
     * 
     * @param BIndSpclServiceReq the value of field
     * 'BIndSpclServiceReq'.
     */
    public void setBIndSpclServiceReq(java.lang.String BIndSpclServiceReq)
    {
        this._BIndSpclServiceReq = BIndSpclServiceReq;
    } //-- void setBIndSpclServiceReq(java.lang.String) 

    /**
     * Sets the value of field 'BIndSpecializedRateReq'.
     * 
     * @param BIndSpecializedRateReq the value of field
     * 'BIndSpecializedRateReq'.
     */
    public void setBIndSpecializedRateReq(java.lang.String BIndSpecializedRateReq)
    {
        this._BIndSpecializedRateReq = BIndSpecializedRateReq;
    } //-- void setBIndSpecializedRateReq(java.lang.String) 

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
     * Sets the value of field 'cIndAdptSubProcess'.
     * 
     * @param cIndAdptSubProcess the value of field
     * 'cIndAdptSubProcess'.
     */
    public void setCIndAdptSubProcess(java.lang.String cIndAdptSubProcess)
    {
        this._cIndAdptSubProcess = cIndAdptSubProcess;
    } //-- void setCIndAdptSubProcess(java.lang.String) 

    /**
     * Sets the value of field 'cIndAdptSubThirdParty'.
     * 
     * @param cIndAdptSubThirdParty the value of field
     * 'cIndAdptSubThirdParty'.
     */
    public void setCIndAdptSubThirdParty(java.lang.String cIndAdptSubThirdParty)
    {
        this._cIndAdptSubThirdParty = cIndAdptSubThirdParty;
    } //-- void setCIndAdptSubThirdParty(java.lang.String) 

    /**
     * Sets the value of field 'cIndIncidentChildInPad'.
     * 
     * @param cIndIncidentChildInPad the value of field
     * 'cIndIncidentChildInPad'.
     */
    public void setCIndIncidentChildInPad(java.lang.String cIndIncidentChildInPad)
    {
        this._cIndIncidentChildInPad = cIndIncidentChildInPad;
    } //-- void setCIndIncidentChildInPad(java.lang.String) 

    /**
     * Sets the value of field 'cIndSauConf'.
     * 
     * @param cIndSauConf the value of field 'cIndSauConf'.
     */
    public void setCIndSauConf(java.lang.String cIndSauConf)
    {
        this._cIndSauConf = cIndSauConf;
    } //-- void setCIndSauConf(java.lang.String) 

    /**
     * Sets the value of field 'cIndSchoolVerified'.
     * 
     * @param cIndSchoolVerified the value of field
     * 'cIndSchoolVerified'.
     */
    public void setCIndSchoolVerified(java.lang.String cIndSchoolVerified)
    {
        this._cIndSchoolVerified = cIndSchoolVerified;
    } //-- void setCIndSchoolVerified(java.lang.String) 

    /**
     * Sets the value of field 'cIndSpclAsstApprvl'.
     * 
     * @param cIndSpclAsstApprvl the value of field
     * 'cIndSpclAsstApprvl'.
     */
    public void setCIndSpclAsstApprvl(java.lang.String cIndSpclAsstApprvl)
    {
        this._cIndSpclAsstApprvl = cIndSpclAsstApprvl;
    } //-- void setCIndSpclAsstApprvl(java.lang.String) 

    /**
     * Sets the value of field 'cdBasicRateType'.
     * 
     * @param cdBasicRateType the value of field 'cdBasicRateType'.
     */
    public void setCdBasicRateType(java.lang.String cdBasicRateType)
    {
        this._cdBasicRateType = cdBasicRateType;
    } //-- void setCdBasicRateType(java.lang.String) 

    /**
     * Sets the value of field 'dtDtAdptSubAgreeRetn'.
     * 
     * @param dtDtAdptSubAgreeRetn the value of field
     * 'dtDtAdptSubAgreeRetn'.
     */
    public void setDtDtAdptSubAgreeRetn(org.exolab.castor.types.Date dtDtAdptSubAgreeRetn)
    {
        this._dtDtAdptSubAgreeRetn = dtDtAdptSubAgreeRetn;
    } //-- void setDtDtAdptSubAgreeRetn(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubAgreeSent'.
     * 
     * @param dtDtAdptSubAgreeSent the value of field
     * 'dtDtAdptSubAgreeSent'.
     */
    public void setDtDtAdptSubAgreeSent(org.exolab.castor.types.Date dtDtAdptSubAgreeSent)
    {
        this._dtDtAdptSubAgreeSent = dtDtAdptSubAgreeSent;
    } //-- void setDtDtAdptSubAgreeSent(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubAppReturned'.
     * 
     * @param dtDtAdptSubAppReturned the value of field
     * 'dtDtAdptSubAppReturned'.
     */
    public void setDtDtAdptSubAppReturned(org.exolab.castor.types.Date dtDtAdptSubAppReturned)
    {
        this._dtDtAdptSubAppReturned = dtDtAdptSubAppReturned;
    } //-- void setDtDtAdptSubAppReturned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubAppSent'.
     * 
     * @param dtDtAdptSubAppSent the value of field
     * 'dtDtAdptSubAppSent'.
     */
    public void setDtDtAdptSubAppSent(org.exolab.castor.types.Date dtDtAdptSubAppSent)
    {
        this._dtDtAdptSubAppSent = dtDtAdptSubAppSent;
    } //-- void setDtDtAdptSubAppSent(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubApprvd'.
     * 
     * @param dtDtAdptSubApprvd the value of field
     * 'dtDtAdptSubApprvd'.
     */
    public void setDtDtAdptSubApprvd(org.exolab.castor.types.Date dtDtAdptSubApprvd)
    {
        this._dtDtAdptSubApprvd = dtDtAdptSubApprvd;
    } //-- void setDtDtAdptSubApprvd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubEffective'.
     * 
     * @param dtDtAdptSubEffective the value of field
     * 'dtDtAdptSubEffective'.
     */
    public void setDtDtAdptSubEffective(org.exolab.castor.types.Date dtDtAdptSubEffective)
    {
        this._dtDtAdptSubEffective = dtDtAdptSubEffective;
    } //-- void setDtDtAdptSubEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubEnd'.
     * 
     * @param dtDtAdptSubEnd the value of field 'dtDtAdptSubEnd'.
     */
    public void setDtDtAdptSubEnd(org.exolab.castor.types.Date dtDtAdptSubEnd)
    {
        this._dtDtAdptSubEnd = dtDtAdptSubEnd;
    } //-- void setDtDtAdptSubEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubLastInvc'.
     * 
     * @param dtDtAdptSubLastInvc the value of field
     * 'dtDtAdptSubLastInvc'.
     */
    public void setDtDtAdptSubLastInvc(org.exolab.castor.types.Date dtDtAdptSubLastInvc)
    {
        this._dtDtAdptSubLastInvc = dtDtAdptSubLastInvc;
    } //-- void setDtDtAdptSubLastInvc(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdptSubTerm'.
     * 
     * @param dtDtAdptSubTerm the value of field 'dtDtAdptSubTerm'.
     */
    public void setDtDtAdptSubTerm(org.exolab.castor.types.Date dtDtAdptSubTerm)
    {
        this._dtDtAdptSubTerm = dtDtAdptSubTerm;
    } //-- void setDtDtAdptSubTerm(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtApprvDate'.
     * 
     * @param dtDtApprvDate the value of field 'dtDtApprvDate'.
     */
    public void setDtDtApprvDate(org.exolab.castor.types.Date dtDtApprvDate)
    {
        this._dtDtApprvDate = dtDtApprvDate;
    } //-- void setDtDtApprvDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtExpirationDate'.
     * 
     * @param dtDtExpirationDate the value of field
     * 'dtDtExpirationDate'.
     */
    public void setDtDtExpirationDate(org.exolab.castor.types.Date dtDtExpirationDate)
    {
        this._dtDtExpirationDate = dtDtExpirationDate;
    } //-- void setDtDtExpirationDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLatestSndAprv'.
     * 
     * @param dtDtLatestSndAprv the value of field
     * 'dtDtLatestSndAprv'.
     */
    public void setDtDtLatestSndAprv(org.exolab.castor.types.Date dtDtLatestSndAprv)
    {
        this._dtDtLatestSndAprv = dtDtLatestSndAprv;
    } //-- void setDtDtLatestSndAprv(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtStart'.
     * 
     * @param dtDtPlcmtStart the value of field 'dtDtPlcmtStart'.
     */
    public void setDtDtPlcmtStart(java.util.Date dtDtPlcmtStart)
    {
        this._dtDtPlcmtStart = dtDtPlcmtStart;
    } //-- void setDtDtPlcmtStart(java.util.Date) 

    /**
     * Sets the value of field 'dtDtRenwlEffBegin'.
     * 
     * @param dtDtRenwlEffBegin the value of field
     * 'dtDtRenwlEffBegin'.
     */
    public void setDtDtRenwlEffBegin(org.exolab.castor.types.Date dtDtRenwlEffBegin)
    {
        this._dtDtRenwlEffBegin = dtDtRenwlEffBegin;
    } //-- void setDtDtRenwlEffBegin(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRenwlEffEnd'.
     * 
     * @param dtDtRenwlEffEnd the value of field 'dtDtRenwlEffEnd'.
     */
    public void setDtDtRenwlEffEnd(org.exolab.castor.types.Date dtDtRenwlEffEnd)
    {
        this._dtDtRenwlEffEnd = dtDtRenwlEffEnd;
    } //-- void setDtDtRenwlEffEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSndAprv'.
     * 
     * @param dtDtSndAprv the value of field 'dtDtSndAprv'.
     */
    public void setDtDtSndAprv(org.exolab.castor.types.Date dtDtSndAprv)
    {
        this._dtDtSndAprv = dtDtSndAprv;
    } //-- void setDtDtSndAprv(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indPriorEndedArgreement'.
     * 
     * @param indPriorEndedArgreement the value of field
     * 'indPriorEndedArgreement'.
     */
    public void setIndPriorEndedArgreement(java.lang.String indPriorEndedArgreement)
    {
        this._indPriorEndedArgreement = indPriorEndedArgreement;
    } //-- void setIndPriorEndedArgreement(java.lang.String) 

    /**
     * Sets the value of field 'sAmtAdptBaseRate'.
     * 
     * @param sAmtAdptBaseRate the value of field 'sAmtAdptBaseRate'
     */
    public void setSAmtAdptBaseRate(double sAmtAdptBaseRate)
    {
        this._sAmtAdptBaseRate = sAmtAdptBaseRate;
        this._has_sAmtAdptBaseRate = true;
    } //-- void setSAmtAdptBaseRate(double) 

    /**
     * Sets the value of field 'sAmtAdptSub'.
     * 
     * @param sAmtAdptSub the value of field 'sAmtAdptSub'.
     */
    public void setSAmtAdptSub(double sAmtAdptSub)
    {
        this._sAmtAdptSub = sAmtAdptSub;
        this._has_sAmtAdptSub = true;
    } //-- void setSAmtAdptSub(double) 

    /**
     * Sets the value of field 'sAmtSpclAsstReq'.
     * 
     * @param sAmtSpclAsstReq the value of field 'sAmtSpclAsstReq'.
     */
    public void setSAmtSpclAsstReq(double sAmtSpclAsstReq)
    {
        this._sAmtSpclAsstReq = sAmtSpclAsstReq;
        this._has_sAmtSpclAsstReq = true;
    } //-- void setSAmtSpclAsstReq(double) 

    /**
     * Sets the value of field 'sNbrBasicAmt'.
     * 
     * @param sNbrBasicAmt the value of field 'sNbrBasicAmt'.
     */
    public void setSNbrBasicAmt(double sNbrBasicAmt)
    {
        this._sNbrBasicAmt = sNbrBasicAmt;
        this._has_sNbrBasicAmt = true;
    } //-- void setSNbrBasicAmt(double) 

    /**
     * Sets the value of field 'sNbrCountyAddonAmt'.
     * 
     * @param sNbrCountyAddonAmt the value of field
     * 'sNbrCountyAddonAmt'.
     */
    public void setSNbrCountyAddonAmt(double sNbrCountyAddonAmt)
    {
        this._sNbrCountyAddonAmt = sNbrCountyAddonAmt;
        this._has_sNbrCountyAddonAmt = true;
    } //-- void setSNbrCountyAddonAmt(double) 

    /**
     * Sets the value of field 'szCdAdptSubCloseRsn'.
     * 
     * @param szCdAdptSubCloseRsn the value of field
     * 'szCdAdptSubCloseRsn'.
     */
    public void setSzCdAdptSubCloseRsn(java.lang.String szCdAdptSubCloseRsn)
    {
        this._szCdAdptSubCloseRsn = szCdAdptSubCloseRsn;
    } //-- void setSzCdAdptSubCloseRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdptSubDeterm'.
     * 
     * @param szCdAdptSubDeterm the value of field
     * 'szCdAdptSubDeterm'.
     */
    public void setSzCdAdptSubDeterm(java.lang.String szCdAdptSubDeterm)
    {
        this._szCdAdptSubDeterm = szCdAdptSubDeterm;
    } //-- void setSzCdAdptSubDeterm(java.lang.String) 

    /**
     * Sets the value of field 'szCdAllNonIncidentSSA'.
     * 
     * @param szCdAllNonIncidentSSA the value of field
     * 'szCdAllNonIncidentSSA'.
     */
    public void setSzCdAllNonIncidentSSA(java.lang.String szCdAllNonIncidentSSA)
    {
        this._szCdAllNonIncidentSSA = szCdAllNonIncidentSSA;
    } //-- void setSzCdAllNonIncidentSSA(java.lang.String) 

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
     * Sets the value of field 'szCdPaymentMethodApp'.
     * 
     * @param szCdPaymentMethodApp the value of field
     * 'szCdPaymentMethodApp'.
     */
    public void setSzCdPaymentMethodApp(java.lang.String szCdPaymentMethodApp)
    {
        this._szCdPaymentMethodApp = szCdPaymentMethodApp;
    } //-- void setSzCdPaymentMethodApp(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlaymentMthd'.
     * 
     * @param szCdPlaymentMthd the value of field 'szCdPlaymentMthd'
     */
    public void setSzCdPlaymentMthd(java.lang.String szCdPlaymentMthd)
    {
        this._szCdPlaymentMthd = szCdPlaymentMthd;
    } //-- void setSzCdPlaymentMthd(java.lang.String) 

    /**
     * Sets the value of field 'szCdSpclAsstType'.
     * 
     * @param szCdSpclAsstType the value of field 'szCdSpclAsstType'
     */
    public void setSzCdSpclAsstType(java.lang.String szCdSpclAsstType)
    {
        this._szCdSpclAsstType = szCdSpclAsstType;
    } //-- void setSzCdSpclAsstType(java.lang.String) 

    /**
     * Sets the value of field 'szNonRecAprvAmt'.
     * 
     * @param szNonRecAprvAmt the value of field 'szNonRecAprvAmt'.
     */
    public void setSzNonRecAprvAmt(double szNonRecAprvAmt)
    {
        this._szNonRecAprvAmt = szNonRecAprvAmt;
        this._has_szNonRecAprvAmt = true;
    } //-- void setSzNonRecAprvAmt(double) 

    /**
     * Sets the value of field 'szSndAprvType'.
     * 
     * @param szSndAprvType the value of field 'szSndAprvType'.
     */
    public void setSzSndAprvType(java.lang.String szSndAprvType)
    {
        this._szSndAprvType = szSndAprvType;
    } //-- void setSzSndAprvType(java.lang.String) 

    /**
     * Sets the value of field 'szSndFndType'.
     * 
     * @param szSndFndType the value of field 'szSndFndType'.
     */
    public void setSzSndFndType(java.lang.String szSndFndType)
    {
        this._szSndFndType = szSndFndType;
    } //-- void setSzSndFndType(java.lang.String) 

    /**
     * Sets the value of field 'szSpcRtAprvAmt'.
     * 
     * @param szSpcRtAprvAmt the value of field 'szSpcRtAprvAmt'.
     */
    public void setSzSpcRtAprvAmt(double szSpcRtAprvAmt)
    {
        this._szSpcRtAprvAmt = szSpcRtAprvAmt;
        this._has_szSpcRtAprvAmt = true;
    } //-- void setSzSpcRtAprvAmt(double) 

    /**
     * Sets the value of field 'szSpcSvcAprvAmt'.
     * 
     * @param szSpcSvcAprvAmt the value of field 'szSpcSvcAprvAmt'.
     */
    public void setSzSpcSvcAprvAmt(double szSpcSvcAprvAmt)
    {
        this._szSpcSvcAprvAmt = szSpcSvcAprvAmt;
        this._has_szSpcSvcAprvAmt = true;
    } //-- void setSzSpcSvcAprvAmt(double) 

    /**
     * Sets the value of field 'szSpcSvcType'.
     * 
     * @param szSpcSvcType the value of field 'szSpcSvcType'.
     */
    public void setSzSpcSvcType(java.lang.String szSpcSvcType)
    {
        this._szSpcSvcType = szSpcSvcType;
    } //-- void setSzSpcSvcType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtAdptSubRsn'.
     * 
     * @param szTxtAdptSubRsn the value of field 'szTxtAdptSubRsn'.
     */
    public void setSzTxtAdptSubRsn(java.lang.String szTxtAdptSubRsn)
    {
        this._szTxtAdptSubRsn = szTxtAdptSubRsn;
    } //-- void setSzTxtAdptSubRsn(java.lang.String) 

    /**
     * Sets the value of field 'szTxtComments'.
     * 
     * @param szTxtComments the value of field 'szTxtComments'.
     */
    public void setSzTxtComments(java.lang.String szTxtComments)
    {
        this._szTxtComments = szTxtComments;
    } //-- void setSzTxtComments(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOtherSpcServ'.
     * 
     * @param szTxtOtherSpcServ the value of field
     * 'szTxtOtherSpcServ'.
     */
    public void setSzTxtOtherSpcServ(java.lang.String szTxtOtherSpcServ)
    {
        this._szTxtOtherSpcServ = szTxtOtherSpcServ;
    } //-- void setSzTxtOtherSpcServ(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSpclAsstCmnts'.
     * 
     * @param szTxtSpclAsstCmnts the value of field
     * 'szTxtSpclAsstCmnts'.
     */
    public void setSzTxtSpclAsstCmnts(java.lang.String szTxtSpclAsstCmnts)
    {
        this._szTxtSpclAsstCmnts = szTxtSpclAsstCmnts;
    } //-- void setSzTxtSpclAsstCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSpclAsstSpecify'.
     * 
     * @param szTxtSpclAsstSpecify the value of field
     * 'szTxtSpclAsstSpecify'.
     */
    public void setSzTxtSpclAsstSpecify(java.lang.String szTxtSpclAsstSpecify)
    {
        this._szTxtSpclAsstSpecify = szTxtSpclAsstSpecify;
    } //-- void setSzTxtSpclAsstSpecify(java.lang.String) 

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
     * Sets the value of field 'ulAmtBasicRate'.
     * 
     * @param ulAmtBasicRate the value of field 'ulAmtBasicRate'.
     */
    public void setUlAmtBasicRate(double ulAmtBasicRate)
    {
        this._ulAmtBasicRate = ulAmtBasicRate;
        this._has_ulAmtBasicRate = true;
    } //-- void setUlAmtBasicRate(double) 

    /**
     * Sets the value of field 'ulIdAdptSub'.
     * 
     * @param ulIdAdptSub the value of field 'ulIdAdptSub'.
     */
    public void setUlIdAdptSub(int ulIdAdptSub)
    {
        this._ulIdAdptSub = ulIdAdptSub;
        this._has_ulIdAdptSub = true;
    } //-- void setUlIdAdptSub(int) 

    /**
     * Sets the value of field 'ulIdAdptSubPayee'.
     * 
     * @param ulIdAdptSubPayee the value of field 'ulIdAdptSubPayee'
     */
    public void setUlIdAdptSubPayee(int ulIdAdptSubPayee)
    {
        this._ulIdAdptSubPayee = ulIdAdptSubPayee;
        this._has_ulIdAdptSubPayee = true;
    } //-- void setUlIdAdptSubPayee(int) 

    /**
     * Sets the value of field 'ulIdSpecialNeedsEvent'.
     * 
     * @param ulIdSpecialNeedsEvent the value of field
     * 'ulIdSpecialNeedsEvent'.
     */
    public void setUlIdSpecialNeedsEvent(int ulIdSpecialNeedsEvent)
    {
        this._ulIdSpecialNeedsEvent = ulIdSpecialNeedsEvent;
        this._has_ulIdSpecialNeedsEvent = true;
    } //-- void setUlIdSpecialNeedsEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SOG00 unmarshal(java.io.Reader) 

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
