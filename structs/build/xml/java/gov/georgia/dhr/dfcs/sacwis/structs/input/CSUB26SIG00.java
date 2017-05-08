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
 * Class CSUB26SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB26SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szAddrPlcmtCity
     */
    private java.lang.String _szAddrPlcmtCity;

    /**
     * Field _szAddrPlcmtCnty
     */
    private java.lang.String _szAddrPlcmtCnty;

    /**
     * Field _szAddrPlcmtLn1
     */
    private java.lang.String _szAddrPlcmtLn1;

    /**
     * Field _szAddrPlcmtLn2
     */
    private java.lang.String _szAddrPlcmtLn2;

    /**
     * Field _szAddrPlcmtSt
     */
    private java.lang.String _szAddrPlcmtSt;

    /**
     * Field _szAddrPlcmtZip
     */
    private java.lang.String _szAddrPlcmtZip;

    /**
     * Field _szCdPlcmtLivArr
     */
    private java.lang.String _szCdPlcmtLivArr;

    /**
     * Field _szCdPlcmtRemovalRsn
     */
    private java.lang.String _szCdPlcmtRemovalRsn;

    /**
     * Field _szCdPlcmtService
     */
    private java.lang.String _szCdPlcmtService;

    /**
     * Field _szCdPlcmtType
     */
    private java.lang.String _szCdPlcmtType;

    /**
     * Field _dtDtPlcmtCaregvrDiscuss
     */
    private org.exolab.castor.types.Date _dtDtPlcmtCaregvrDiscuss;

    /**
     * Field _dtDtPlcmtChildDiscuss
     */
    private org.exolab.castor.types.Date _dtDtPlcmtChildDiscuss;

    /**
     * Field _dtDtPlcmtChildPlan
     */
    private org.exolab.castor.types.Date _dtDtPlcmtChildPlan;

    /**
     * Field _dtDtPlcmtEducLog
     */
    private org.exolab.castor.types.Date _dtDtPlcmtEducLog;

    /**
     * Field _ulIdCaseMngrRsrc
     */
    private int _ulIdCaseMngrRsrc;

    /**
     * keeps track of state for field: _ulIdCaseMngrRsrc
     */
    private boolean _has_ulIdCaseMngrRsrc;

    /**
     * Field _ulIdSupRsrc
     */
    private int _ulIdSupRsrc;

    /**
     * keeps track of state for field: _ulIdSupRsrc
     */
    private boolean _has_ulIdSupRsrc;

    /**
     * Field _nmCaseMngrRsrc
     */
    private java.lang.String _nmCaseMngrRsrc;

    /**
     * Field _nmSupRsrc
     */
    private java.lang.String _nmSupRsrc;

    /**
     * Field _ulIdCaseMngrCert
     */
    private int _ulIdCaseMngrCert;

    /**
     * keeps track of state for field: _ulIdCaseMngrCert
     */
    private boolean _has_ulIdCaseMngrCert;

    /**
     * Field _ulIdSupCert
     */
    private int _ulIdSupCert;

    /**
     * keeps track of state for field: _ulIdSupCert
     */
    private boolean _has_ulIdSupCert;

    /**
     * Field _indCaseMngrCert
     */
    private java.lang.String _indCaseMngrCert;

    /**
     * Field _indSupCert
     */
    private java.lang.String _indSupCert;

    /**
     * Field _dtSupCert
     */
    private org.exolab.castor.types.Date _dtSupCert;

    /**
     * Field _dtCaseMngrCert
     */
    private org.exolab.castor.types.Date _dtCaseMngrCert;

    /**
     * Field _dtLastViewPlcmtLog
     */
    private org.exolab.castor.types.Date _dtLastViewPlcmtLog;

    /**
     * Field _dtDtPlcmtEnd
     */
    private java.util.Date _dtDtPlcmtEnd;

    /**
     * Field _dtDtPlcmtMeddevHistory
     */
    private org.exolab.castor.types.Date _dtDtPlcmtMeddevHistory;

    /**
     * Field _dtDtPlcmtParentsNotif
     */
    private org.exolab.castor.types.Date _dtDtPlcmtParentsNotif;

    /**
     * Field _dtDtPlcmtPreplaceVisit
     */
    private org.exolab.castor.types.Date _dtDtPlcmtPreplaceVisit;

    /**
     * Field _dtDtPlcmtSchoolRecords
     */
    private org.exolab.castor.types.Date _dtDtPlcmtSchoolRecords;

    /**
     * Field _dtDtPlcmtStart
     */
    private java.util.Date _dtDtPlcmtStart;

    /**
     * Field _ulIdPlcmtAdult
     */
    private int _ulIdPlcmtAdult;

    /**
     * keeps track of state for field: _ulIdPlcmtAdult
     */
    private boolean _has_ulIdPlcmtAdult;

    /**
     * Field _ulIdPlcmtChild
     */
    private int _ulIdPlcmtChild;

    /**
     * keeps track of state for field: _ulIdPlcmtChild
     */
    private boolean _has_ulIdPlcmtChild;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdRsrcAgency
     */
    private int _ulIdRsrcAgency;

    /**
     * keeps track of state for field: _ulIdRsrcAgency
     */
    private boolean _has_ulIdRsrcAgency;

    /**
     * Field _ulIdRsrcFacil
     */
    private int _ulIdRsrcFacil;

    /**
     * keeps track of state for field: _ulIdRsrcFacil
     */
    private boolean _has_ulIdRsrcFacil;

    /**
     * Field _ulIdRsrcFacilOriginal
     */
    private int _ulIdRsrcFacilOriginal;

    /**
     * keeps track of state for field: _ulIdRsrcFacilOriginal
     */
    private boolean _has_ulIdRsrcFacilOriginal;

    /**
     * Field _szCdPlcmtActPlanned
     */
    private java.lang.String _szCdPlcmtActPlanned;

    /**
     * Field _cIndPlcmtContCntct
     */
    private java.lang.String _cIndPlcmtContCntct;

    /**
     * Field _cIndPlcmtEducLog
     */
    private java.lang.String _cIndPlcmtEducLog;

    /**
     * Field _cIndPlcmetEmerg
     */
    private java.lang.String _cIndPlcmetEmerg;

    /**
     * Field _cIndPlcmtNoneApply
     */
    private java.lang.String _cIndPlcmtNoneApply;

    /**
     * Field _cIndPlcmtSchoolDoc
     */
    private java.lang.String _cIndPlcmtSchoolDoc;

    /**
     * Field _cIndPlcmtWriteHistory
     */
    private java.lang.String _cIndPlcmtWriteHistory;

    /**
     * Field _szNbrPlcmtPhoneExt
     */
    private java.lang.String _szNbrPlcmtPhoneExt;

    /**
     * Field _szNbrPlcmtTelephone
     */
    private java.lang.String _szNbrPlcmtTelephone;

    /**
     * Field _szNmPlcmtAgency
     */
    private java.lang.String _szNmPlcmtAgency;

    /**
     * Field _szNmPlcmtContact
     */
    private java.lang.String _szNmPlcmtContact;

    /**
     * Field _szNmPlcmtFacil
     */
    private java.lang.String _szNmPlcmtFacil;

    /**
     * Field _szNmPlcmtPersonFull
     */
    private java.lang.String _szNmPlcmtPersonFull;

    /**
     * Field _szTxtPlcmtAddrComment
     */
    private java.lang.String _szTxtPlcmtAddrComment;

    /**
     * Field _szTxtPlcmtDiscussion
     */
    private java.lang.String _szTxtPlcmtDiscussion;

    /**
     * Field _szTxtPlcmtDocuments
     */
    private java.lang.String _szTxtPlcmtDocuments;

    /**
     * Field _szTxtPlcmtRemovalRsn
     */
    private java.lang.String _szTxtPlcmtRemovalRsn;

    /**
     * Field _szCdPlcmtActAtt
     */
    private java.lang.String _szCdPlcmtActAtt;

    /**
     * Field _szCdPlcmtContactedBy
     */
    private java.lang.String _szCdPlcmtContactedBy;

    /**
     * Field _ulIdContactedBy
     */
    private int _ulIdContactedBy;

    /**
     * keeps track of state for field: _ulIdContactedBy
     */
    private boolean _has_ulIdContactedBy;

    /**
     * Field _szCdPlcmtContMethod
     */
    private java.lang.String _szCdPlcmtContMethod;

    /**
     * Field _cIndPlcmtTempType
     */
    private java.lang.String _cIndPlcmtTempType;

    /**
     * Field _szCdPlcmtTempType
     */
    private java.lang.String _szCdPlcmtTempType;

    /**
     * Field _szTxtPlcmtTempCmmnts
     */
    private java.lang.String _szTxtPlcmtTempCmmnts;

    /**
     * Field _cIndWaiverReqd
     */
    private java.lang.String _cIndWaiverReqd;

    /**
     * Field _szCdWaivertype
     */
    private java.lang.String _szCdWaivertype;

    /**
     * Field _ulIdWaiver
     */
    private int _ulIdWaiver;

    /**
     * keeps track of state for field: _ulIdWaiver
     */
    private boolean _has_ulIdWaiver;

    /**
     * Field _dtDtLastDischarged
     */
    private org.exolab.castor.types.Date _dtDtLastDischarged;

    /**
     * Field _dtDtPlcmtPermDue
     */
    private org.exolab.castor.types.Date _dtDtPlcmtPermDue;

    /**
     * Field _szCdMatch
     */
    private java.lang.String _szCdMatch;

    /**
     * Field _szCdBrdngCnty
     */
    private java.lang.String _szCdBrdngCnty;

    /**
     * Field _cIndTrialHomeVisit
     */
    private java.lang.String _cIndTrialHomeVisit;

    /**
     * Field _dtDtCrtBegin
     */
    private org.exolab.castor.types.Date _dtDtCrtBegin;

    /**
     * Field _dtDtCrtEnd
     */
    private org.exolab.castor.types.Date _dtDtCrtEnd;

    /**
     * Field _cIndPlcmtSafe
     */
    private java.lang.String _cIndPlcmtSafe;

    /**
     * Field _cIndPlcmtRestr
     */
    private java.lang.String _cIndPlcmtRestr;

    /**
     * Field _cIndPlcmtFamLike
     */
    private java.lang.String _cIndPlcmtFamLike;

    /**
     * Field _cIndPlcmtAppr
     */
    private java.lang.String _cIndPlcmtAppr;

    /**
     * Field _cIndPlcmtProx
     */
    private java.lang.String _cIndPlcmtProx;

    /**
     * Field _cIndPlcmtSchDist
     */
    private java.lang.String _cIndPlcmtSchDist;

    /**
     * Field _cIndPlcmtCasePlan
     */
    private java.lang.String _cIndPlcmtCasePlan;

    /**
     * Field _szTxtPlcmtChkList
     */
    private java.lang.String _szTxtPlcmtChkList;

    /**
     * Field _cIndPlcmtTrauma
     */
    private java.lang.String _cIndPlcmtTrauma;

    /**
     * Field _szTxtPlcmtTrauma
     */
    private java.lang.String _szTxtPlcmtTrauma;

    /**
     * Field _cIndPlcmtSibling
     */
    private java.lang.String _cIndPlcmtSibling;

    /**
     * Field _szCdSibRsn
     */
    private java.lang.String _szCdSibRsn;

    /**
     * Field _nbrSibinCare
     */
    private int _nbrSibinCare;

    /**
     * keeps track of state for field: _nbrSibinCare
     */
    private boolean _has_nbrSibinCare;

    /**
     * Field _nbrSibPlaced
     */
    private int _nbrSibPlaced;

    /**
     * keeps track of state for field: _nbrSibPlaced
     */
    private boolean _has_nbrSibPlaced;

    /**
     * Field _szTxtPlcmtSibling
     */
    private java.lang.String _szTxtPlcmtSibling;

    /**
     * Field _cIndPlcmtCCFA
     */
    private java.lang.String _cIndPlcmtCCFA;

    /**
     * Field _szCdPlcmtCCFA
     */
    private java.lang.String _szCdPlcmtCCFA;

    /**
     * Field _szTxtPlcmtCCFA
     */
    private java.lang.String _szTxtPlcmtCCFA;

    /**
     * Field _cIndPlcmtSpvsn
     */
    private java.lang.String _cIndPlcmtSpvsn;

    /**
     * Field _szTxtPlcmtSpvsn
     */
    private java.lang.String _szTxtPlcmtSpvsn;

    /**
     * Field _dtDtPsychInfo
     */
    private org.exolab.castor.types.Date _dtDtPsychInfo;

    /**
     * Field _szTxtPsychInfoCont
     */
    private java.lang.String _szTxtPsychInfoCont;

    /**
     * Field _dtDtPsychCPInfo
     */
    private org.exolab.castor.types.Date _dtDtPsychCPInfo;

    /**
     * Field _szTxtPsychCPInfoCont
     */
    private java.lang.String _szTxtPsychCPInfoCont;

    /**
     * Field _dtDtMedInfo
     */
    private org.exolab.castor.types.Date _dtDtMedInfo;

    /**
     * Field _szTxtMedInfoCont
     */
    private java.lang.String _szTxtMedInfoCont;

    /**
     * Field _dtDtMedCPInfo
     */
    private org.exolab.castor.types.Date _dtDtMedCPInfo;

    /**
     * Field _szTxtMedCPInfoCont
     */
    private java.lang.String _szTxtMedCPInfoCont;

    /**
     * Field _dtDtEduInfo
     */
    private org.exolab.castor.types.Date _dtDtEduInfo;

    /**
     * Field _cIndEduInfoNA
     */
    private java.lang.String _cIndEduInfoNA;

    /**
     * Field _szTxtEduInfoCont
     */
    private java.lang.String _szTxtEduInfoCont;

    /**
     * Field _dtDtEduCPInfo
     */
    private org.exolab.castor.types.Date _dtDtEduCPInfo;

    /**
     * Field _cIndEduCPInfoNA
     */
    private java.lang.String _cIndEduCPInfoNA;

    /**
     * Field _szTxtEduCPInfoCont
     */
    private java.lang.String _szTxtEduCPInfoCont;

    /**
     * Field _szTxtCareGvDoc
     */
    private java.lang.String _szTxtCareGvDoc;

    /**
     * Field _szTxtAddtnlDoc
     */
    private java.lang.String _szTxtAddtnlDoc;

    /**
     * Field _cIndPlcmtChPlacedFr
     */
    private java.lang.String _cIndPlcmtChPlacedFr;

    /**
     * Field _cIndPlcmtChPlacedBy
     */
    private java.lang.String _cIndPlcmtChPlacedBy;

    /**
     * Field _szCdAdoPlaceInfo1
     */
    private java.lang.String _szCdAdoPlaceInfo1;

    /**
     * Field _szCdAdoPlaceInfo2
     */
    private java.lang.String _szCdAdoPlaceInfo2;

    /**
     * Field _szCdAdoPlaceInfo3
     */
    private java.lang.String _szCdAdoPlaceInfo3;

    /**
     * Field _szCdAdoPlaceInfo4
     */
    private java.lang.String _szCdAdoPlaceInfo4;

    /**
     * Field _szCdChildTransitionCmnts
     */
    private java.lang.String _szCdChildTransitionCmnts;

    /**
     * Field _cIndLTFCPlacement
     */
    private java.lang.String _cIndLTFCPlacement;

    /**
     * Field _dtDtAgreementSigned
     */
    private org.exolab.castor.types.Date _dtDtAgreementSigned;

    /**
     * Field _cIndConnectedAdult
     */
    private java.lang.String _cIndConnectedAdult;

    /**
     * Field _ulIdPersonConnected
     */
    private int _ulIdPersonConnected;

    /**
     * keeps track of state for field: _ulIdPersonConnected
     */
    private boolean _has_ulIdPersonConnected;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB26SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNbrSibPlaced()
    {
        this._has_nbrSibPlaced= false;
    } //-- void deleteNbrSibPlaced() 

    /**
     */
    public void deleteNbrSibinCare()
    {
        this._has_nbrSibinCare= false;
    } //-- void deleteNbrSibinCare() 

    /**
     */
    public void deleteUlIdCaseMngrCert()
    {
        this._has_ulIdCaseMngrCert= false;
    } //-- void deleteUlIdCaseMngrCert() 

    /**
     */
    public void deleteUlIdCaseMngrRsrc()
    {
        this._has_ulIdCaseMngrRsrc= false;
    } //-- void deleteUlIdCaseMngrRsrc() 

    /**
     */
    public void deleteUlIdContactedBy()
    {
        this._has_ulIdContactedBy= false;
    } //-- void deleteUlIdContactedBy() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdPersonConnected()
    {
        this._has_ulIdPersonConnected= false;
    } //-- void deleteUlIdPersonConnected() 

    /**
     */
    public void deleteUlIdPlcmtAdult()
    {
        this._has_ulIdPlcmtAdult= false;
    } //-- void deleteUlIdPlcmtAdult() 

    /**
     */
    public void deleteUlIdPlcmtChild()
    {
        this._has_ulIdPlcmtChild= false;
    } //-- void deleteUlIdPlcmtChild() 

    /**
     */
    public void deleteUlIdRsrcAgency()
    {
        this._has_ulIdRsrcAgency= false;
    } //-- void deleteUlIdRsrcAgency() 

    /**
     */
    public void deleteUlIdRsrcFacil()
    {
        this._has_ulIdRsrcFacil= false;
    } //-- void deleteUlIdRsrcFacil() 

    /**
     */
    public void deleteUlIdRsrcFacilOriginal()
    {
        this._has_ulIdRsrcFacilOriginal= false;
    } //-- void deleteUlIdRsrcFacilOriginal() 

    /**
     */
    public void deleteUlIdSupCert()
    {
        this._has_ulIdSupCert= false;
    } //-- void deleteUlIdSupCert() 

    /**
     */
    public void deleteUlIdSupRsrc()
    {
        this._has_ulIdSupRsrc= false;
    } //-- void deleteUlIdSupRsrc() 

    /**
     */
    public void deleteUlIdWaiver()
    {
        this._has_ulIdWaiver= false;
    } //-- void deleteUlIdWaiver() 

    /**
     * Returns the value of field 'cIndConnectedAdult'.
     * 
     * @return the value of field 'CIndConnectedAdult'.
     */
    public java.lang.String getCIndConnectedAdult()
    {
        return this._cIndConnectedAdult;
    } //-- java.lang.String getCIndConnectedAdult() 

    /**
     * Returns the value of field 'cIndEduCPInfoNA'.
     * 
     * @return the value of field 'CIndEduCPInfoNA'.
     */
    public java.lang.String getCIndEduCPInfoNA()
    {
        return this._cIndEduCPInfoNA;
    } //-- java.lang.String getCIndEduCPInfoNA() 

    /**
     * Returns the value of field 'cIndEduInfoNA'.
     * 
     * @return the value of field 'CIndEduInfoNA'.
     */
    public java.lang.String getCIndEduInfoNA()
    {
        return this._cIndEduInfoNA;
    } //-- java.lang.String getCIndEduInfoNA() 

    /**
     * Returns the value of field 'cIndLTFCPlacement'.
     * 
     * @return the value of field 'CIndLTFCPlacement'.
     */
    public java.lang.String getCIndLTFCPlacement()
    {
        return this._cIndLTFCPlacement;
    } //-- java.lang.String getCIndLTFCPlacement() 

    /**
     * Returns the value of field 'cIndPlcmetEmerg'.
     * 
     * @return the value of field 'CIndPlcmetEmerg'.
     */
    public java.lang.String getCIndPlcmetEmerg()
    {
        return this._cIndPlcmetEmerg;
    } //-- java.lang.String getCIndPlcmetEmerg() 

    /**
     * Returns the value of field 'cIndPlcmtAppr'.
     * 
     * @return the value of field 'CIndPlcmtAppr'.
     */
    public java.lang.String getCIndPlcmtAppr()
    {
        return this._cIndPlcmtAppr;
    } //-- java.lang.String getCIndPlcmtAppr() 

    /**
     * Returns the value of field 'cIndPlcmtCCFA'.
     * 
     * @return the value of field 'CIndPlcmtCCFA'.
     */
    public java.lang.String getCIndPlcmtCCFA()
    {
        return this._cIndPlcmtCCFA;
    } //-- java.lang.String getCIndPlcmtCCFA() 

    /**
     * Returns the value of field 'cIndPlcmtCasePlan'.
     * 
     * @return the value of field 'CIndPlcmtCasePlan'.
     */
    public java.lang.String getCIndPlcmtCasePlan()
    {
        return this._cIndPlcmtCasePlan;
    } //-- java.lang.String getCIndPlcmtCasePlan() 

    /**
     * Returns the value of field 'cIndPlcmtChPlacedBy'.
     * 
     * @return the value of field 'CIndPlcmtChPlacedBy'.
     */
    public java.lang.String getCIndPlcmtChPlacedBy()
    {
        return this._cIndPlcmtChPlacedBy;
    } //-- java.lang.String getCIndPlcmtChPlacedBy() 

    /**
     * Returns the value of field 'cIndPlcmtChPlacedFr'.
     * 
     * @return the value of field 'CIndPlcmtChPlacedFr'.
     */
    public java.lang.String getCIndPlcmtChPlacedFr()
    {
        return this._cIndPlcmtChPlacedFr;
    } //-- java.lang.String getCIndPlcmtChPlacedFr() 

    /**
     * Returns the value of field 'cIndPlcmtContCntct'.
     * 
     * @return the value of field 'CIndPlcmtContCntct'.
     */
    public java.lang.String getCIndPlcmtContCntct()
    {
        return this._cIndPlcmtContCntct;
    } //-- java.lang.String getCIndPlcmtContCntct() 

    /**
     * Returns the value of field 'cIndPlcmtEducLog'.
     * 
     * @return the value of field 'CIndPlcmtEducLog'.
     */
    public java.lang.String getCIndPlcmtEducLog()
    {
        return this._cIndPlcmtEducLog;
    } //-- java.lang.String getCIndPlcmtEducLog() 

    /**
     * Returns the value of field 'cIndPlcmtFamLike'.
     * 
     * @return the value of field 'CIndPlcmtFamLike'.
     */
    public java.lang.String getCIndPlcmtFamLike()
    {
        return this._cIndPlcmtFamLike;
    } //-- java.lang.String getCIndPlcmtFamLike() 

    /**
     * Returns the value of field 'cIndPlcmtNoneApply'.
     * 
     * @return the value of field 'CIndPlcmtNoneApply'.
     */
    public java.lang.String getCIndPlcmtNoneApply()
    {
        return this._cIndPlcmtNoneApply;
    } //-- java.lang.String getCIndPlcmtNoneApply() 

    /**
     * Returns the value of field 'cIndPlcmtProx'.
     * 
     * @return the value of field 'CIndPlcmtProx'.
     */
    public java.lang.String getCIndPlcmtProx()
    {
        return this._cIndPlcmtProx;
    } //-- java.lang.String getCIndPlcmtProx() 

    /**
     * Returns the value of field 'cIndPlcmtRestr'.
     * 
     * @return the value of field 'CIndPlcmtRestr'.
     */
    public java.lang.String getCIndPlcmtRestr()
    {
        return this._cIndPlcmtRestr;
    } //-- java.lang.String getCIndPlcmtRestr() 

    /**
     * Returns the value of field 'cIndPlcmtSafe'.
     * 
     * @return the value of field 'CIndPlcmtSafe'.
     */
    public java.lang.String getCIndPlcmtSafe()
    {
        return this._cIndPlcmtSafe;
    } //-- java.lang.String getCIndPlcmtSafe() 

    /**
     * Returns the value of field 'cIndPlcmtSchDist'.
     * 
     * @return the value of field 'CIndPlcmtSchDist'.
     */
    public java.lang.String getCIndPlcmtSchDist()
    {
        return this._cIndPlcmtSchDist;
    } //-- java.lang.String getCIndPlcmtSchDist() 

    /**
     * Returns the value of field 'cIndPlcmtSchoolDoc'.
     * 
     * @return the value of field 'CIndPlcmtSchoolDoc'.
     */
    public java.lang.String getCIndPlcmtSchoolDoc()
    {
        return this._cIndPlcmtSchoolDoc;
    } //-- java.lang.String getCIndPlcmtSchoolDoc() 

    /**
     * Returns the value of field 'cIndPlcmtSibling'.
     * 
     * @return the value of field 'CIndPlcmtSibling'.
     */
    public java.lang.String getCIndPlcmtSibling()
    {
        return this._cIndPlcmtSibling;
    } //-- java.lang.String getCIndPlcmtSibling() 

    /**
     * Returns the value of field 'cIndPlcmtSpvsn'.
     * 
     * @return the value of field 'CIndPlcmtSpvsn'.
     */
    public java.lang.String getCIndPlcmtSpvsn()
    {
        return this._cIndPlcmtSpvsn;
    } //-- java.lang.String getCIndPlcmtSpvsn() 

    /**
     * Returns the value of field 'cIndPlcmtTempType'.
     * 
     * @return the value of field 'CIndPlcmtTempType'.
     */
    public java.lang.String getCIndPlcmtTempType()
    {
        return this._cIndPlcmtTempType;
    } //-- java.lang.String getCIndPlcmtTempType() 

    /**
     * Returns the value of field 'cIndPlcmtTrauma'.
     * 
     * @return the value of field 'CIndPlcmtTrauma'.
     */
    public java.lang.String getCIndPlcmtTrauma()
    {
        return this._cIndPlcmtTrauma;
    } //-- java.lang.String getCIndPlcmtTrauma() 

    /**
     * Returns the value of field 'cIndPlcmtWriteHistory'.
     * 
     * @return the value of field 'CIndPlcmtWriteHistory'.
     */
    public java.lang.String getCIndPlcmtWriteHistory()
    {
        return this._cIndPlcmtWriteHistory;
    } //-- java.lang.String getCIndPlcmtWriteHistory() 

    /**
     * Returns the value of field 'cIndTrialHomeVisit'.
     * 
     * @return the value of field 'CIndTrialHomeVisit'.
     */
    public java.lang.String getCIndTrialHomeVisit()
    {
        return this._cIndTrialHomeVisit;
    } //-- java.lang.String getCIndTrialHomeVisit() 

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
     * Returns the value of field 'dtCaseMngrCert'.
     * 
     * @return the value of field 'DtCaseMngrCert'.
     */
    public org.exolab.castor.types.Date getDtCaseMngrCert()
    {
        return this._dtCaseMngrCert;
    } //-- org.exolab.castor.types.Date getDtCaseMngrCert() 

    /**
     * Returns the value of field 'dtDtAgreementSigned'.
     * 
     * @return the value of field 'DtDtAgreementSigned'.
     */
    public org.exolab.castor.types.Date getDtDtAgreementSigned()
    {
        return this._dtDtAgreementSigned;
    } //-- org.exolab.castor.types.Date getDtDtAgreementSigned() 

    /**
     * Returns the value of field 'dtDtCrtBegin'.
     * 
     * @return the value of field 'DtDtCrtBegin'.
     */
    public org.exolab.castor.types.Date getDtDtCrtBegin()
    {
        return this._dtDtCrtBegin;
    } //-- org.exolab.castor.types.Date getDtDtCrtBegin() 

    /**
     * Returns the value of field 'dtDtCrtEnd'.
     * 
     * @return the value of field 'DtDtCrtEnd'.
     */
    public org.exolab.castor.types.Date getDtDtCrtEnd()
    {
        return this._dtDtCrtEnd;
    } //-- org.exolab.castor.types.Date getDtDtCrtEnd() 

    /**
     * Returns the value of field 'dtDtEduCPInfo'.
     * 
     * @return the value of field 'DtDtEduCPInfo'.
     */
    public org.exolab.castor.types.Date getDtDtEduCPInfo()
    {
        return this._dtDtEduCPInfo;
    } //-- org.exolab.castor.types.Date getDtDtEduCPInfo() 

    /**
     * Returns the value of field 'dtDtEduInfo'.
     * 
     * @return the value of field 'DtDtEduInfo'.
     */
    public org.exolab.castor.types.Date getDtDtEduInfo()
    {
        return this._dtDtEduInfo;
    } //-- org.exolab.castor.types.Date getDtDtEduInfo() 

    /**
     * Returns the value of field 'dtDtLastDischarged'.
     * 
     * @return the value of field 'DtDtLastDischarged'.
     */
    public org.exolab.castor.types.Date getDtDtLastDischarged()
    {
        return this._dtDtLastDischarged;
    } //-- org.exolab.castor.types.Date getDtDtLastDischarged() 

    /**
     * Returns the value of field 'dtDtMedCPInfo'.
     * 
     * @return the value of field 'DtDtMedCPInfo'.
     */
    public org.exolab.castor.types.Date getDtDtMedCPInfo()
    {
        return this._dtDtMedCPInfo;
    } //-- org.exolab.castor.types.Date getDtDtMedCPInfo() 

    /**
     * Returns the value of field 'dtDtMedInfo'.
     * 
     * @return the value of field 'DtDtMedInfo'.
     */
    public org.exolab.castor.types.Date getDtDtMedInfo()
    {
        return this._dtDtMedInfo;
    } //-- org.exolab.castor.types.Date getDtDtMedInfo() 

    /**
     * Returns the value of field 'dtDtPlcmtCaregvrDiscuss'.
     * 
     * @return the value of field 'DtDtPlcmtCaregvrDiscuss'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtCaregvrDiscuss()
    {
        return this._dtDtPlcmtCaregvrDiscuss;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtCaregvrDiscuss() 

    /**
     * Returns the value of field 'dtDtPlcmtChildDiscuss'.
     * 
     * @return the value of field 'DtDtPlcmtChildDiscuss'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtChildDiscuss()
    {
        return this._dtDtPlcmtChildDiscuss;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtChildDiscuss() 

    /**
     * Returns the value of field 'dtDtPlcmtChildPlan'.
     * 
     * @return the value of field 'DtDtPlcmtChildPlan'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtChildPlan()
    {
        return this._dtDtPlcmtChildPlan;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtChildPlan() 

    /**
     * Returns the value of field 'dtDtPlcmtEducLog'.
     * 
     * @return the value of field 'DtDtPlcmtEducLog'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtEducLog()
    {
        return this._dtDtPlcmtEducLog;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtEducLog() 

    /**
     * Returns the value of field 'dtDtPlcmtEnd'.
     * 
     * @return the value of field 'DtDtPlcmtEnd'.
     */
    public java.util.Date getDtDtPlcmtEnd()
    {
        return this._dtDtPlcmtEnd;
    } //-- java.util.Date getDtDtPlcmtEnd() 

    /**
     * Returns the value of field 'dtDtPlcmtMeddevHistory'.
     * 
     * @return the value of field 'DtDtPlcmtMeddevHistory'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtMeddevHistory()
    {
        return this._dtDtPlcmtMeddevHistory;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtMeddevHistory() 

    /**
     * Returns the value of field 'dtDtPlcmtParentsNotif'.
     * 
     * @return the value of field 'DtDtPlcmtParentsNotif'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtParentsNotif()
    {
        return this._dtDtPlcmtParentsNotif;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtParentsNotif() 

    /**
     * Returns the value of field 'dtDtPlcmtPermDue'.
     * 
     * @return the value of field 'DtDtPlcmtPermDue'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtPermDue()
    {
        return this._dtDtPlcmtPermDue;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtPermDue() 

    /**
     * Returns the value of field 'dtDtPlcmtPreplaceVisit'.
     * 
     * @return the value of field 'DtDtPlcmtPreplaceVisit'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtPreplaceVisit()
    {
        return this._dtDtPlcmtPreplaceVisit;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtPreplaceVisit() 

    /**
     * Returns the value of field 'dtDtPlcmtSchoolRecords'.
     * 
     * @return the value of field 'DtDtPlcmtSchoolRecords'.
     */
    public org.exolab.castor.types.Date getDtDtPlcmtSchoolRecords()
    {
        return this._dtDtPlcmtSchoolRecords;
    } //-- org.exolab.castor.types.Date getDtDtPlcmtSchoolRecords() 

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
     * Returns the value of field 'dtDtPsychCPInfo'.
     * 
     * @return the value of field 'DtDtPsychCPInfo'.
     */
    public org.exolab.castor.types.Date getDtDtPsychCPInfo()
    {
        return this._dtDtPsychCPInfo;
    } //-- org.exolab.castor.types.Date getDtDtPsychCPInfo() 

    /**
     * Returns the value of field 'dtDtPsychInfo'.
     * 
     * @return the value of field 'DtDtPsychInfo'.
     */
    public org.exolab.castor.types.Date getDtDtPsychInfo()
    {
        return this._dtDtPsychInfo;
    } //-- org.exolab.castor.types.Date getDtDtPsychInfo() 

    /**
     * Returns the value of field 'dtLastViewPlcmtLog'.
     * 
     * @return the value of field 'DtLastViewPlcmtLog'.
     */
    public org.exolab.castor.types.Date getDtLastViewPlcmtLog()
    {
        return this._dtLastViewPlcmtLog;
    } //-- org.exolab.castor.types.Date getDtLastViewPlcmtLog() 

    /**
     * Returns the value of field 'dtSupCert'.
     * 
     * @return the value of field 'DtSupCert'.
     */
    public org.exolab.castor.types.Date getDtSupCert()
    {
        return this._dtSupCert;
    } //-- org.exolab.castor.types.Date getDtSupCert() 

    /**
     * Returns the value of field 'indCaseMngrCert'.
     * 
     * @return the value of field 'IndCaseMngrCert'.
     */
    public java.lang.String getIndCaseMngrCert()
    {
        return this._indCaseMngrCert;
    } //-- java.lang.String getIndCaseMngrCert() 

    /**
     * Returns the value of field 'indSupCert'.
     * 
     * @return the value of field 'IndSupCert'.
     */
    public java.lang.String getIndSupCert()
    {
        return this._indSupCert;
    } //-- java.lang.String getIndSupCert() 

    /**
     * Returns the value of field 'nbrSibPlaced'.
     * 
     * @return the value of field 'NbrSibPlaced'.
     */
    public int getNbrSibPlaced()
    {
        return this._nbrSibPlaced;
    } //-- int getNbrSibPlaced() 

    /**
     * Returns the value of field 'nbrSibinCare'.
     * 
     * @return the value of field 'NbrSibinCare'.
     */
    public int getNbrSibinCare()
    {
        return this._nbrSibinCare;
    } //-- int getNbrSibinCare() 

    /**
     * Returns the value of field 'nmCaseMngrRsrc'.
     * 
     * @return the value of field 'NmCaseMngrRsrc'.
     */
    public java.lang.String getNmCaseMngrRsrc()
    {
        return this._nmCaseMngrRsrc;
    } //-- java.lang.String getNmCaseMngrRsrc() 

    /**
     * Returns the value of field 'nmSupRsrc'.
     * 
     * @return the value of field 'NmSupRsrc'.
     */
    public java.lang.String getNmSupRsrc()
    {
        return this._nmSupRsrc;
    } //-- java.lang.String getNmSupRsrc() 

    /**
     * Returns the value of field 'szAddrPlcmtCity'.
     * 
     * @return the value of field 'SzAddrPlcmtCity'.
     */
    public java.lang.String getSzAddrPlcmtCity()
    {
        return this._szAddrPlcmtCity;
    } //-- java.lang.String getSzAddrPlcmtCity() 

    /**
     * Returns the value of field 'szAddrPlcmtCnty'.
     * 
     * @return the value of field 'SzAddrPlcmtCnty'.
     */
    public java.lang.String getSzAddrPlcmtCnty()
    {
        return this._szAddrPlcmtCnty;
    } //-- java.lang.String getSzAddrPlcmtCnty() 

    /**
     * Returns the value of field 'szAddrPlcmtLn1'.
     * 
     * @return the value of field 'SzAddrPlcmtLn1'.
     */
    public java.lang.String getSzAddrPlcmtLn1()
    {
        return this._szAddrPlcmtLn1;
    } //-- java.lang.String getSzAddrPlcmtLn1() 

    /**
     * Returns the value of field 'szAddrPlcmtLn2'.
     * 
     * @return the value of field 'SzAddrPlcmtLn2'.
     */
    public java.lang.String getSzAddrPlcmtLn2()
    {
        return this._szAddrPlcmtLn2;
    } //-- java.lang.String getSzAddrPlcmtLn2() 

    /**
     * Returns the value of field 'szAddrPlcmtSt'.
     * 
     * @return the value of field 'SzAddrPlcmtSt'.
     */
    public java.lang.String getSzAddrPlcmtSt()
    {
        return this._szAddrPlcmtSt;
    } //-- java.lang.String getSzAddrPlcmtSt() 

    /**
     * Returns the value of field 'szAddrPlcmtZip'.
     * 
     * @return the value of field 'SzAddrPlcmtZip'.
     */
    public java.lang.String getSzAddrPlcmtZip()
    {
        return this._szAddrPlcmtZip;
    } //-- java.lang.String getSzAddrPlcmtZip() 

    /**
     * Returns the value of field 'szCdAdoPlaceInfo1'.
     * 
     * @return the value of field 'SzCdAdoPlaceInfo1'.
     */
    public java.lang.String getSzCdAdoPlaceInfo1()
    {
        return this._szCdAdoPlaceInfo1;
    } //-- java.lang.String getSzCdAdoPlaceInfo1() 

    /**
     * Returns the value of field 'szCdAdoPlaceInfo2'.
     * 
     * @return the value of field 'SzCdAdoPlaceInfo2'.
     */
    public java.lang.String getSzCdAdoPlaceInfo2()
    {
        return this._szCdAdoPlaceInfo2;
    } //-- java.lang.String getSzCdAdoPlaceInfo2() 

    /**
     * Returns the value of field 'szCdAdoPlaceInfo3'.
     * 
     * @return the value of field 'SzCdAdoPlaceInfo3'.
     */
    public java.lang.String getSzCdAdoPlaceInfo3()
    {
        return this._szCdAdoPlaceInfo3;
    } //-- java.lang.String getSzCdAdoPlaceInfo3() 

    /**
     * Returns the value of field 'szCdAdoPlaceInfo4'.
     * 
     * @return the value of field 'SzCdAdoPlaceInfo4'.
     */
    public java.lang.String getSzCdAdoPlaceInfo4()
    {
        return this._szCdAdoPlaceInfo4;
    } //-- java.lang.String getSzCdAdoPlaceInfo4() 

    /**
     * Returns the value of field 'szCdBrdngCnty'.
     * 
     * @return the value of field 'SzCdBrdngCnty'.
     */
    public java.lang.String getSzCdBrdngCnty()
    {
        return this._szCdBrdngCnty;
    } //-- java.lang.String getSzCdBrdngCnty() 

    /**
     * Returns the value of field 'szCdChildTransitionCmnts'.
     * 
     * @return the value of field 'SzCdChildTransitionCmnts'.
     */
    public java.lang.String getSzCdChildTransitionCmnts()
    {
        return this._szCdChildTransitionCmnts;
    } //-- java.lang.String getSzCdChildTransitionCmnts() 

    /**
     * Returns the value of field 'szCdMatch'.
     * 
     * @return the value of field 'SzCdMatch'.
     */
    public java.lang.String getSzCdMatch()
    {
        return this._szCdMatch;
    } //-- java.lang.String getSzCdMatch() 

    /**
     * Returns the value of field 'szCdPlcmtActAtt'.
     * 
     * @return the value of field 'SzCdPlcmtActAtt'.
     */
    public java.lang.String getSzCdPlcmtActAtt()
    {
        return this._szCdPlcmtActAtt;
    } //-- java.lang.String getSzCdPlcmtActAtt() 

    /**
     * Returns the value of field 'szCdPlcmtActPlanned'.
     * 
     * @return the value of field 'SzCdPlcmtActPlanned'.
     */
    public java.lang.String getSzCdPlcmtActPlanned()
    {
        return this._szCdPlcmtActPlanned;
    } //-- java.lang.String getSzCdPlcmtActPlanned() 

    /**
     * Returns the value of field 'szCdPlcmtCCFA'.
     * 
     * @return the value of field 'SzCdPlcmtCCFA'.
     */
    public java.lang.String getSzCdPlcmtCCFA()
    {
        return this._szCdPlcmtCCFA;
    } //-- java.lang.String getSzCdPlcmtCCFA() 

    /**
     * Returns the value of field 'szCdPlcmtContMethod'.
     * 
     * @return the value of field 'SzCdPlcmtContMethod'.
     */
    public java.lang.String getSzCdPlcmtContMethod()
    {
        return this._szCdPlcmtContMethod;
    } //-- java.lang.String getSzCdPlcmtContMethod() 

    /**
     * Returns the value of field 'szCdPlcmtContactedBy'.
     * 
     * @return the value of field 'SzCdPlcmtContactedBy'.
     */
    public java.lang.String getSzCdPlcmtContactedBy()
    {
        return this._szCdPlcmtContactedBy;
    } //-- java.lang.String getSzCdPlcmtContactedBy() 

    /**
     * Returns the value of field 'szCdPlcmtLivArr'.
     * 
     * @return the value of field 'SzCdPlcmtLivArr'.
     */
    public java.lang.String getSzCdPlcmtLivArr()
    {
        return this._szCdPlcmtLivArr;
    } //-- java.lang.String getSzCdPlcmtLivArr() 

    /**
     * Returns the value of field 'szCdPlcmtRemovalRsn'.
     * 
     * @return the value of field 'SzCdPlcmtRemovalRsn'.
     */
    public java.lang.String getSzCdPlcmtRemovalRsn()
    {
        return this._szCdPlcmtRemovalRsn;
    } //-- java.lang.String getSzCdPlcmtRemovalRsn() 

    /**
     * Returns the value of field 'szCdPlcmtService'.
     * 
     * @return the value of field 'SzCdPlcmtService'.
     */
    public java.lang.String getSzCdPlcmtService()
    {
        return this._szCdPlcmtService;
    } //-- java.lang.String getSzCdPlcmtService() 

    /**
     * Returns the value of field 'szCdPlcmtTempType'.
     * 
     * @return the value of field 'SzCdPlcmtTempType'.
     */
    public java.lang.String getSzCdPlcmtTempType()
    {
        return this._szCdPlcmtTempType;
    } //-- java.lang.String getSzCdPlcmtTempType() 

    /**
     * Returns the value of field 'szCdPlcmtType'.
     * 
     * @return the value of field 'SzCdPlcmtType'.
     */
    public java.lang.String getSzCdPlcmtType()
    {
        return this._szCdPlcmtType;
    } //-- java.lang.String getSzCdPlcmtType() 

    /**
     * Returns the value of field 'szCdSibRsn'.
     * 
     * @return the value of field 'SzCdSibRsn'.
     */
    public java.lang.String getSzCdSibRsn()
    {
        return this._szCdSibRsn;
    } //-- java.lang.String getSzCdSibRsn() 

    /**
     * Returns the value of field 'szCdWaivertype'.
     * 
     * @return the value of field 'SzCdWaivertype'.
     */
    public java.lang.String getSzCdWaivertype()
    {
        return this._szCdWaivertype;
    } //-- java.lang.String getSzCdWaivertype() 

    /**
     * Returns the value of field 'szNbrPlcmtPhoneExt'.
     * 
     * @return the value of field 'SzNbrPlcmtPhoneExt'.
     */
    public java.lang.String getSzNbrPlcmtPhoneExt()
    {
        return this._szNbrPlcmtPhoneExt;
    } //-- java.lang.String getSzNbrPlcmtPhoneExt() 

    /**
     * Returns the value of field 'szNbrPlcmtTelephone'.
     * 
     * @return the value of field 'SzNbrPlcmtTelephone'.
     */
    public java.lang.String getSzNbrPlcmtTelephone()
    {
        return this._szNbrPlcmtTelephone;
    } //-- java.lang.String getSzNbrPlcmtTelephone() 

    /**
     * Returns the value of field 'szNmPlcmtAgency'.
     * 
     * @return the value of field 'SzNmPlcmtAgency'.
     */
    public java.lang.String getSzNmPlcmtAgency()
    {
        return this._szNmPlcmtAgency;
    } //-- java.lang.String getSzNmPlcmtAgency() 

    /**
     * Returns the value of field 'szNmPlcmtContact'.
     * 
     * @return the value of field 'SzNmPlcmtContact'.
     */
    public java.lang.String getSzNmPlcmtContact()
    {
        return this._szNmPlcmtContact;
    } //-- java.lang.String getSzNmPlcmtContact() 

    /**
     * Returns the value of field 'szNmPlcmtFacil'.
     * 
     * @return the value of field 'SzNmPlcmtFacil'.
     */
    public java.lang.String getSzNmPlcmtFacil()
    {
        return this._szNmPlcmtFacil;
    } //-- java.lang.String getSzNmPlcmtFacil() 

    /**
     * Returns the value of field 'szNmPlcmtPersonFull'.
     * 
     * @return the value of field 'SzNmPlcmtPersonFull'.
     */
    public java.lang.String getSzNmPlcmtPersonFull()
    {
        return this._szNmPlcmtPersonFull;
    } //-- java.lang.String getSzNmPlcmtPersonFull() 

    /**
     * Returns the value of field 'szTxtAddtnlDoc'.
     * 
     * @return the value of field 'SzTxtAddtnlDoc'.
     */
    public java.lang.String getSzTxtAddtnlDoc()
    {
        return this._szTxtAddtnlDoc;
    } //-- java.lang.String getSzTxtAddtnlDoc() 

    /**
     * Returns the value of field 'szTxtCareGvDoc'.
     * 
     * @return the value of field 'SzTxtCareGvDoc'.
     */
    public java.lang.String getSzTxtCareGvDoc()
    {
        return this._szTxtCareGvDoc;
    } //-- java.lang.String getSzTxtCareGvDoc() 

    /**
     * Returns the value of field 'szTxtEduCPInfoCont'.
     * 
     * @return the value of field 'SzTxtEduCPInfoCont'.
     */
    public java.lang.String getSzTxtEduCPInfoCont()
    {
        return this._szTxtEduCPInfoCont;
    } //-- java.lang.String getSzTxtEduCPInfoCont() 

    /**
     * Returns the value of field 'szTxtEduInfoCont'.
     * 
     * @return the value of field 'SzTxtEduInfoCont'.
     */
    public java.lang.String getSzTxtEduInfoCont()
    {
        return this._szTxtEduInfoCont;
    } //-- java.lang.String getSzTxtEduInfoCont() 

    /**
     * Returns the value of field 'szTxtMedCPInfoCont'.
     * 
     * @return the value of field 'SzTxtMedCPInfoCont'.
     */
    public java.lang.String getSzTxtMedCPInfoCont()
    {
        return this._szTxtMedCPInfoCont;
    } //-- java.lang.String getSzTxtMedCPInfoCont() 

    /**
     * Returns the value of field 'szTxtMedInfoCont'.
     * 
     * @return the value of field 'SzTxtMedInfoCont'.
     */
    public java.lang.String getSzTxtMedInfoCont()
    {
        return this._szTxtMedInfoCont;
    } //-- java.lang.String getSzTxtMedInfoCont() 

    /**
     * Returns the value of field 'szTxtPlcmtAddrComment'.
     * 
     * @return the value of field 'SzTxtPlcmtAddrComment'.
     */
    public java.lang.String getSzTxtPlcmtAddrComment()
    {
        return this._szTxtPlcmtAddrComment;
    } //-- java.lang.String getSzTxtPlcmtAddrComment() 

    /**
     * Returns the value of field 'szTxtPlcmtCCFA'.
     * 
     * @return the value of field 'SzTxtPlcmtCCFA'.
     */
    public java.lang.String getSzTxtPlcmtCCFA()
    {
        return this._szTxtPlcmtCCFA;
    } //-- java.lang.String getSzTxtPlcmtCCFA() 

    /**
     * Returns the value of field 'szTxtPlcmtChkList'.
     * 
     * @return the value of field 'SzTxtPlcmtChkList'.
     */
    public java.lang.String getSzTxtPlcmtChkList()
    {
        return this._szTxtPlcmtChkList;
    } //-- java.lang.String getSzTxtPlcmtChkList() 

    /**
     * Returns the value of field 'szTxtPlcmtDiscussion'.
     * 
     * @return the value of field 'SzTxtPlcmtDiscussion'.
     */
    public java.lang.String getSzTxtPlcmtDiscussion()
    {
        return this._szTxtPlcmtDiscussion;
    } //-- java.lang.String getSzTxtPlcmtDiscussion() 

    /**
     * Returns the value of field 'szTxtPlcmtDocuments'.
     * 
     * @return the value of field 'SzTxtPlcmtDocuments'.
     */
    public java.lang.String getSzTxtPlcmtDocuments()
    {
        return this._szTxtPlcmtDocuments;
    } //-- java.lang.String getSzTxtPlcmtDocuments() 

    /**
     * Returns the value of field 'szTxtPlcmtRemovalRsn'.
     * 
     * @return the value of field 'SzTxtPlcmtRemovalRsn'.
     */
    public java.lang.String getSzTxtPlcmtRemovalRsn()
    {
        return this._szTxtPlcmtRemovalRsn;
    } //-- java.lang.String getSzTxtPlcmtRemovalRsn() 

    /**
     * Returns the value of field 'szTxtPlcmtSibling'.
     * 
     * @return the value of field 'SzTxtPlcmtSibling'.
     */
    public java.lang.String getSzTxtPlcmtSibling()
    {
        return this._szTxtPlcmtSibling;
    } //-- java.lang.String getSzTxtPlcmtSibling() 

    /**
     * Returns the value of field 'szTxtPlcmtSpvsn'.
     * 
     * @return the value of field 'SzTxtPlcmtSpvsn'.
     */
    public java.lang.String getSzTxtPlcmtSpvsn()
    {
        return this._szTxtPlcmtSpvsn;
    } //-- java.lang.String getSzTxtPlcmtSpvsn() 

    /**
     * Returns the value of field 'szTxtPlcmtTempCmmnts'.
     * 
     * @return the value of field 'SzTxtPlcmtTempCmmnts'.
     */
    public java.lang.String getSzTxtPlcmtTempCmmnts()
    {
        return this._szTxtPlcmtTempCmmnts;
    } //-- java.lang.String getSzTxtPlcmtTempCmmnts() 

    /**
     * Returns the value of field 'szTxtPlcmtTrauma'.
     * 
     * @return the value of field 'SzTxtPlcmtTrauma'.
     */
    public java.lang.String getSzTxtPlcmtTrauma()
    {
        return this._szTxtPlcmtTrauma;
    } //-- java.lang.String getSzTxtPlcmtTrauma() 

    /**
     * Returns the value of field 'szTxtPsychCPInfoCont'.
     * 
     * @return the value of field 'SzTxtPsychCPInfoCont'.
     */
    public java.lang.String getSzTxtPsychCPInfoCont()
    {
        return this._szTxtPsychCPInfoCont;
    } //-- java.lang.String getSzTxtPsychCPInfoCont() 

    /**
     * Returns the value of field 'szTxtPsychInfoCont'.
     * 
     * @return the value of field 'SzTxtPsychInfoCont'.
     */
    public java.lang.String getSzTxtPsychInfoCont()
    {
        return this._szTxtPsychInfoCont;
    } //-- java.lang.String getSzTxtPsychInfoCont() 

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
     * Returns the value of field 'ulIdCaseMngrCert'.
     * 
     * @return the value of field 'UlIdCaseMngrCert'.
     */
    public int getUlIdCaseMngrCert()
    {
        return this._ulIdCaseMngrCert;
    } //-- int getUlIdCaseMngrCert() 

    /**
     * Returns the value of field 'ulIdCaseMngrRsrc'.
     * 
     * @return the value of field 'UlIdCaseMngrRsrc'.
     */
    public int getUlIdCaseMngrRsrc()
    {
        return this._ulIdCaseMngrRsrc;
    } //-- int getUlIdCaseMngrRsrc() 

    /**
     * Returns the value of field 'ulIdContactedBy'.
     * 
     * @return the value of field 'UlIdContactedBy'.
     */
    public int getUlIdContactedBy()
    {
        return this._ulIdContactedBy;
    } //-- int getUlIdContactedBy() 

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
     * Returns the value of field 'ulIdPersonConnected'.
     * 
     * @return the value of field 'UlIdPersonConnected'.
     */
    public int getUlIdPersonConnected()
    {
        return this._ulIdPersonConnected;
    } //-- int getUlIdPersonConnected() 

    /**
     * Returns the value of field 'ulIdPlcmtAdult'.
     * 
     * @return the value of field 'UlIdPlcmtAdult'.
     */
    public int getUlIdPlcmtAdult()
    {
        return this._ulIdPlcmtAdult;
    } //-- int getUlIdPlcmtAdult() 

    /**
     * Returns the value of field 'ulIdPlcmtChild'.
     * 
     * @return the value of field 'UlIdPlcmtChild'.
     */
    public int getUlIdPlcmtChild()
    {
        return this._ulIdPlcmtChild;
    } //-- int getUlIdPlcmtChild() 

    /**
     * Returns the value of field 'ulIdRsrcAgency'.
     * 
     * @return the value of field 'UlIdRsrcAgency'.
     */
    public int getUlIdRsrcAgency()
    {
        return this._ulIdRsrcAgency;
    } //-- int getUlIdRsrcAgency() 

    /**
     * Returns the value of field 'ulIdRsrcFacil'.
     * 
     * @return the value of field 'UlIdRsrcFacil'.
     */
    public int getUlIdRsrcFacil()
    {
        return this._ulIdRsrcFacil;
    } //-- int getUlIdRsrcFacil() 

    /**
     * Returns the value of field 'ulIdRsrcFacilOriginal'.
     * 
     * @return the value of field 'UlIdRsrcFacilOriginal'.
     */
    public int getUlIdRsrcFacilOriginal()
    {
        return this._ulIdRsrcFacilOriginal;
    } //-- int getUlIdRsrcFacilOriginal() 

    /**
     * Returns the value of field 'ulIdSupCert'.
     * 
     * @return the value of field 'UlIdSupCert'.
     */
    public int getUlIdSupCert()
    {
        return this._ulIdSupCert;
    } //-- int getUlIdSupCert() 

    /**
     * Returns the value of field 'ulIdSupRsrc'.
     * 
     * @return the value of field 'UlIdSupRsrc'.
     */
    public int getUlIdSupRsrc()
    {
        return this._ulIdSupRsrc;
    } //-- int getUlIdSupRsrc() 

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
     * Method hasNbrSibPlaced
     * 
     * 
     * 
     * @return true if at least one NbrSibPlaced has been added
     */
    public boolean hasNbrSibPlaced()
    {
        return this._has_nbrSibPlaced;
    } //-- boolean hasNbrSibPlaced() 

    /**
     * Method hasNbrSibinCare
     * 
     * 
     * 
     * @return true if at least one NbrSibinCare has been added
     */
    public boolean hasNbrSibinCare()
    {
        return this._has_nbrSibinCare;
    } //-- boolean hasNbrSibinCare() 

    /**
     * Method hasUlIdCaseMngrCert
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMngrCert has been added
     */
    public boolean hasUlIdCaseMngrCert()
    {
        return this._has_ulIdCaseMngrCert;
    } //-- boolean hasUlIdCaseMngrCert() 

    /**
     * Method hasUlIdCaseMngrRsrc
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMngrRsrc has been added
     */
    public boolean hasUlIdCaseMngrRsrc()
    {
        return this._has_ulIdCaseMngrRsrc;
    } //-- boolean hasUlIdCaseMngrRsrc() 

    /**
     * Method hasUlIdContactedBy
     * 
     * 
     * 
     * @return true if at least one UlIdContactedBy has been added
     */
    public boolean hasUlIdContactedBy()
    {
        return this._has_ulIdContactedBy;
    } //-- boolean hasUlIdContactedBy() 

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
     * Method hasUlIdPersonConnected
     * 
     * 
     * 
     * @return true if at least one UlIdPersonConnected has been
     * added
     */
    public boolean hasUlIdPersonConnected()
    {
        return this._has_ulIdPersonConnected;
    } //-- boolean hasUlIdPersonConnected() 

    /**
     * Method hasUlIdPlcmtAdult
     * 
     * 
     * 
     * @return true if at least one UlIdPlcmtAdult has been added
     */
    public boolean hasUlIdPlcmtAdult()
    {
        return this._has_ulIdPlcmtAdult;
    } //-- boolean hasUlIdPlcmtAdult() 

    /**
     * Method hasUlIdPlcmtChild
     * 
     * 
     * 
     * @return true if at least one UlIdPlcmtChild has been added
     */
    public boolean hasUlIdPlcmtChild()
    {
        return this._has_ulIdPlcmtChild;
    } //-- boolean hasUlIdPlcmtChild() 

    /**
     * Method hasUlIdRsrcAgency
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcAgency has been added
     */
    public boolean hasUlIdRsrcAgency()
    {
        return this._has_ulIdRsrcAgency;
    } //-- boolean hasUlIdRsrcAgency() 

    /**
     * Method hasUlIdRsrcFacil
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcFacil has been added
     */
    public boolean hasUlIdRsrcFacil()
    {
        return this._has_ulIdRsrcFacil;
    } //-- boolean hasUlIdRsrcFacil() 

    /**
     * Method hasUlIdRsrcFacilOriginal
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcFacilOriginal has been
     * added
     */
    public boolean hasUlIdRsrcFacilOriginal()
    {
        return this._has_ulIdRsrcFacilOriginal;
    } //-- boolean hasUlIdRsrcFacilOriginal() 

    /**
     * Method hasUlIdSupCert
     * 
     * 
     * 
     * @return true if at least one UlIdSupCert has been added
     */
    public boolean hasUlIdSupCert()
    {
        return this._has_ulIdSupCert;
    } //-- boolean hasUlIdSupCert() 

    /**
     * Method hasUlIdSupRsrc
     * 
     * 
     * 
     * @return true if at least one UlIdSupRsrc has been added
     */
    public boolean hasUlIdSupRsrc()
    {
        return this._has_ulIdSupRsrc;
    } //-- boolean hasUlIdSupRsrc() 

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
     * Sets the value of field 'cIndConnectedAdult'.
     * 
     * @param cIndConnectedAdult the value of field
     * 'cIndConnectedAdult'.
     */
    public void setCIndConnectedAdult(java.lang.String cIndConnectedAdult)
    {
        this._cIndConnectedAdult = cIndConnectedAdult;
    } //-- void setCIndConnectedAdult(java.lang.String) 

    /**
     * Sets the value of field 'cIndEduCPInfoNA'.
     * 
     * @param cIndEduCPInfoNA the value of field 'cIndEduCPInfoNA'.
     */
    public void setCIndEduCPInfoNA(java.lang.String cIndEduCPInfoNA)
    {
        this._cIndEduCPInfoNA = cIndEduCPInfoNA;
    } //-- void setCIndEduCPInfoNA(java.lang.String) 

    /**
     * Sets the value of field 'cIndEduInfoNA'.
     * 
     * @param cIndEduInfoNA the value of field 'cIndEduInfoNA'.
     */
    public void setCIndEduInfoNA(java.lang.String cIndEduInfoNA)
    {
        this._cIndEduInfoNA = cIndEduInfoNA;
    } //-- void setCIndEduInfoNA(java.lang.String) 

    /**
     * Sets the value of field 'cIndLTFCPlacement'.
     * 
     * @param cIndLTFCPlacement the value of field
     * 'cIndLTFCPlacement'.
     */
    public void setCIndLTFCPlacement(java.lang.String cIndLTFCPlacement)
    {
        this._cIndLTFCPlacement = cIndLTFCPlacement;
    } //-- void setCIndLTFCPlacement(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmetEmerg'.
     * 
     * @param cIndPlcmetEmerg the value of field 'cIndPlcmetEmerg'.
     */
    public void setCIndPlcmetEmerg(java.lang.String cIndPlcmetEmerg)
    {
        this._cIndPlcmetEmerg = cIndPlcmetEmerg;
    } //-- void setCIndPlcmetEmerg(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtAppr'.
     * 
     * @param cIndPlcmtAppr the value of field 'cIndPlcmtAppr'.
     */
    public void setCIndPlcmtAppr(java.lang.String cIndPlcmtAppr)
    {
        this._cIndPlcmtAppr = cIndPlcmtAppr;
    } //-- void setCIndPlcmtAppr(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtCCFA'.
     * 
     * @param cIndPlcmtCCFA the value of field 'cIndPlcmtCCFA'.
     */
    public void setCIndPlcmtCCFA(java.lang.String cIndPlcmtCCFA)
    {
        this._cIndPlcmtCCFA = cIndPlcmtCCFA;
    } //-- void setCIndPlcmtCCFA(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtCasePlan'.
     * 
     * @param cIndPlcmtCasePlan the value of field
     * 'cIndPlcmtCasePlan'.
     */
    public void setCIndPlcmtCasePlan(java.lang.String cIndPlcmtCasePlan)
    {
        this._cIndPlcmtCasePlan = cIndPlcmtCasePlan;
    } //-- void setCIndPlcmtCasePlan(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtChPlacedBy'.
     * 
     * @param cIndPlcmtChPlacedBy the value of field
     * 'cIndPlcmtChPlacedBy'.
     */
    public void setCIndPlcmtChPlacedBy(java.lang.String cIndPlcmtChPlacedBy)
    {
        this._cIndPlcmtChPlacedBy = cIndPlcmtChPlacedBy;
    } //-- void setCIndPlcmtChPlacedBy(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtChPlacedFr'.
     * 
     * @param cIndPlcmtChPlacedFr the value of field
     * 'cIndPlcmtChPlacedFr'.
     */
    public void setCIndPlcmtChPlacedFr(java.lang.String cIndPlcmtChPlacedFr)
    {
        this._cIndPlcmtChPlacedFr = cIndPlcmtChPlacedFr;
    } //-- void setCIndPlcmtChPlacedFr(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtContCntct'.
     * 
     * @param cIndPlcmtContCntct the value of field
     * 'cIndPlcmtContCntct'.
     */
    public void setCIndPlcmtContCntct(java.lang.String cIndPlcmtContCntct)
    {
        this._cIndPlcmtContCntct = cIndPlcmtContCntct;
    } //-- void setCIndPlcmtContCntct(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtEducLog'.
     * 
     * @param cIndPlcmtEducLog the value of field 'cIndPlcmtEducLog'
     */
    public void setCIndPlcmtEducLog(java.lang.String cIndPlcmtEducLog)
    {
        this._cIndPlcmtEducLog = cIndPlcmtEducLog;
    } //-- void setCIndPlcmtEducLog(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtFamLike'.
     * 
     * @param cIndPlcmtFamLike the value of field 'cIndPlcmtFamLike'
     */
    public void setCIndPlcmtFamLike(java.lang.String cIndPlcmtFamLike)
    {
        this._cIndPlcmtFamLike = cIndPlcmtFamLike;
    } //-- void setCIndPlcmtFamLike(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtNoneApply'.
     * 
     * @param cIndPlcmtNoneApply the value of field
     * 'cIndPlcmtNoneApply'.
     */
    public void setCIndPlcmtNoneApply(java.lang.String cIndPlcmtNoneApply)
    {
        this._cIndPlcmtNoneApply = cIndPlcmtNoneApply;
    } //-- void setCIndPlcmtNoneApply(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtProx'.
     * 
     * @param cIndPlcmtProx the value of field 'cIndPlcmtProx'.
     */
    public void setCIndPlcmtProx(java.lang.String cIndPlcmtProx)
    {
        this._cIndPlcmtProx = cIndPlcmtProx;
    } //-- void setCIndPlcmtProx(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtRestr'.
     * 
     * @param cIndPlcmtRestr the value of field 'cIndPlcmtRestr'.
     */
    public void setCIndPlcmtRestr(java.lang.String cIndPlcmtRestr)
    {
        this._cIndPlcmtRestr = cIndPlcmtRestr;
    } //-- void setCIndPlcmtRestr(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtSafe'.
     * 
     * @param cIndPlcmtSafe the value of field 'cIndPlcmtSafe'.
     */
    public void setCIndPlcmtSafe(java.lang.String cIndPlcmtSafe)
    {
        this._cIndPlcmtSafe = cIndPlcmtSafe;
    } //-- void setCIndPlcmtSafe(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtSchDist'.
     * 
     * @param cIndPlcmtSchDist the value of field 'cIndPlcmtSchDist'
     */
    public void setCIndPlcmtSchDist(java.lang.String cIndPlcmtSchDist)
    {
        this._cIndPlcmtSchDist = cIndPlcmtSchDist;
    } //-- void setCIndPlcmtSchDist(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtSchoolDoc'.
     * 
     * @param cIndPlcmtSchoolDoc the value of field
     * 'cIndPlcmtSchoolDoc'.
     */
    public void setCIndPlcmtSchoolDoc(java.lang.String cIndPlcmtSchoolDoc)
    {
        this._cIndPlcmtSchoolDoc = cIndPlcmtSchoolDoc;
    } //-- void setCIndPlcmtSchoolDoc(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtSibling'.
     * 
     * @param cIndPlcmtSibling the value of field 'cIndPlcmtSibling'
     */
    public void setCIndPlcmtSibling(java.lang.String cIndPlcmtSibling)
    {
        this._cIndPlcmtSibling = cIndPlcmtSibling;
    } //-- void setCIndPlcmtSibling(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtSpvsn'.
     * 
     * @param cIndPlcmtSpvsn the value of field 'cIndPlcmtSpvsn'.
     */
    public void setCIndPlcmtSpvsn(java.lang.String cIndPlcmtSpvsn)
    {
        this._cIndPlcmtSpvsn = cIndPlcmtSpvsn;
    } //-- void setCIndPlcmtSpvsn(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtTempType'.
     * 
     * @param cIndPlcmtTempType the value of field
     * 'cIndPlcmtTempType'.
     */
    public void setCIndPlcmtTempType(java.lang.String cIndPlcmtTempType)
    {
        this._cIndPlcmtTempType = cIndPlcmtTempType;
    } //-- void setCIndPlcmtTempType(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtTrauma'.
     * 
     * @param cIndPlcmtTrauma the value of field 'cIndPlcmtTrauma'.
     */
    public void setCIndPlcmtTrauma(java.lang.String cIndPlcmtTrauma)
    {
        this._cIndPlcmtTrauma = cIndPlcmtTrauma;
    } //-- void setCIndPlcmtTrauma(java.lang.String) 

    /**
     * Sets the value of field 'cIndPlcmtWriteHistory'.
     * 
     * @param cIndPlcmtWriteHistory the value of field
     * 'cIndPlcmtWriteHistory'.
     */
    public void setCIndPlcmtWriteHistory(java.lang.String cIndPlcmtWriteHistory)
    {
        this._cIndPlcmtWriteHistory = cIndPlcmtWriteHistory;
    } //-- void setCIndPlcmtWriteHistory(java.lang.String) 

    /**
     * Sets the value of field 'cIndTrialHomeVisit'.
     * 
     * @param cIndTrialHomeVisit the value of field
     * 'cIndTrialHomeVisit'.
     */
    public void setCIndTrialHomeVisit(java.lang.String cIndTrialHomeVisit)
    {
        this._cIndTrialHomeVisit = cIndTrialHomeVisit;
    } //-- void setCIndTrialHomeVisit(java.lang.String) 

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
     * Sets the value of field 'dtCaseMngrCert'.
     * 
     * @param dtCaseMngrCert the value of field 'dtCaseMngrCert'.
     */
    public void setDtCaseMngrCert(org.exolab.castor.types.Date dtCaseMngrCert)
    {
        this._dtCaseMngrCert = dtCaseMngrCert;
    } //-- void setDtCaseMngrCert(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAgreementSigned'.
     * 
     * @param dtDtAgreementSigned the value of field
     * 'dtDtAgreementSigned'.
     */
    public void setDtDtAgreementSigned(org.exolab.castor.types.Date dtDtAgreementSigned)
    {
        this._dtDtAgreementSigned = dtDtAgreementSigned;
    } //-- void setDtDtAgreementSigned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCrtBegin'.
     * 
     * @param dtDtCrtBegin the value of field 'dtDtCrtBegin'.
     */
    public void setDtDtCrtBegin(org.exolab.castor.types.Date dtDtCrtBegin)
    {
        this._dtDtCrtBegin = dtDtCrtBegin;
    } //-- void setDtDtCrtBegin(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCrtEnd'.
     * 
     * @param dtDtCrtEnd the value of field 'dtDtCrtEnd'.
     */
    public void setDtDtCrtEnd(org.exolab.castor.types.Date dtDtCrtEnd)
    {
        this._dtDtCrtEnd = dtDtCrtEnd;
    } //-- void setDtDtCrtEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEduCPInfo'.
     * 
     * @param dtDtEduCPInfo the value of field 'dtDtEduCPInfo'.
     */
    public void setDtDtEduCPInfo(org.exolab.castor.types.Date dtDtEduCPInfo)
    {
        this._dtDtEduCPInfo = dtDtEduCPInfo;
    } //-- void setDtDtEduCPInfo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtEduInfo'.
     * 
     * @param dtDtEduInfo the value of field 'dtDtEduInfo'.
     */
    public void setDtDtEduInfo(org.exolab.castor.types.Date dtDtEduInfo)
    {
        this._dtDtEduInfo = dtDtEduInfo;
    } //-- void setDtDtEduInfo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLastDischarged'.
     * 
     * @param dtDtLastDischarged the value of field
     * 'dtDtLastDischarged'.
     */
    public void setDtDtLastDischarged(org.exolab.castor.types.Date dtDtLastDischarged)
    {
        this._dtDtLastDischarged = dtDtLastDischarged;
    } //-- void setDtDtLastDischarged(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtMedCPInfo'.
     * 
     * @param dtDtMedCPInfo the value of field 'dtDtMedCPInfo'.
     */
    public void setDtDtMedCPInfo(org.exolab.castor.types.Date dtDtMedCPInfo)
    {
        this._dtDtMedCPInfo = dtDtMedCPInfo;
    } //-- void setDtDtMedCPInfo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtMedInfo'.
     * 
     * @param dtDtMedInfo the value of field 'dtDtMedInfo'.
     */
    public void setDtDtMedInfo(org.exolab.castor.types.Date dtDtMedInfo)
    {
        this._dtDtMedInfo = dtDtMedInfo;
    } //-- void setDtDtMedInfo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtCaregvrDiscuss'.
     * 
     * @param dtDtPlcmtCaregvrDiscuss the value of field
     * 'dtDtPlcmtCaregvrDiscuss'.
     */
    public void setDtDtPlcmtCaregvrDiscuss(org.exolab.castor.types.Date dtDtPlcmtCaregvrDiscuss)
    {
        this._dtDtPlcmtCaregvrDiscuss = dtDtPlcmtCaregvrDiscuss;
    } //-- void setDtDtPlcmtCaregvrDiscuss(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtChildDiscuss'.
     * 
     * @param dtDtPlcmtChildDiscuss the value of field
     * 'dtDtPlcmtChildDiscuss'.
     */
    public void setDtDtPlcmtChildDiscuss(org.exolab.castor.types.Date dtDtPlcmtChildDiscuss)
    {
        this._dtDtPlcmtChildDiscuss = dtDtPlcmtChildDiscuss;
    } //-- void setDtDtPlcmtChildDiscuss(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtChildPlan'.
     * 
     * @param dtDtPlcmtChildPlan the value of field
     * 'dtDtPlcmtChildPlan'.
     */
    public void setDtDtPlcmtChildPlan(org.exolab.castor.types.Date dtDtPlcmtChildPlan)
    {
        this._dtDtPlcmtChildPlan = dtDtPlcmtChildPlan;
    } //-- void setDtDtPlcmtChildPlan(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtEducLog'.
     * 
     * @param dtDtPlcmtEducLog the value of field 'dtDtPlcmtEducLog'
     */
    public void setDtDtPlcmtEducLog(org.exolab.castor.types.Date dtDtPlcmtEducLog)
    {
        this._dtDtPlcmtEducLog = dtDtPlcmtEducLog;
    } //-- void setDtDtPlcmtEducLog(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtEnd'.
     * 
     * @param dtDtPlcmtEnd the value of field 'dtDtPlcmtEnd'.
     */
    public void setDtDtPlcmtEnd(java.util.Date dtDtPlcmtEnd)
    {
        this._dtDtPlcmtEnd = dtDtPlcmtEnd;
    } //-- void setDtDtPlcmtEnd(java.util.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtMeddevHistory'.
     * 
     * @param dtDtPlcmtMeddevHistory the value of field
     * 'dtDtPlcmtMeddevHistory'.
     */
    public void setDtDtPlcmtMeddevHistory(org.exolab.castor.types.Date dtDtPlcmtMeddevHistory)
    {
        this._dtDtPlcmtMeddevHistory = dtDtPlcmtMeddevHistory;
    } //-- void setDtDtPlcmtMeddevHistory(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtParentsNotif'.
     * 
     * @param dtDtPlcmtParentsNotif the value of field
     * 'dtDtPlcmtParentsNotif'.
     */
    public void setDtDtPlcmtParentsNotif(org.exolab.castor.types.Date dtDtPlcmtParentsNotif)
    {
        this._dtDtPlcmtParentsNotif = dtDtPlcmtParentsNotif;
    } //-- void setDtDtPlcmtParentsNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtPermDue'.
     * 
     * @param dtDtPlcmtPermDue the value of field 'dtDtPlcmtPermDue'
     */
    public void setDtDtPlcmtPermDue(org.exolab.castor.types.Date dtDtPlcmtPermDue)
    {
        this._dtDtPlcmtPermDue = dtDtPlcmtPermDue;
    } //-- void setDtDtPlcmtPermDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtPreplaceVisit'.
     * 
     * @param dtDtPlcmtPreplaceVisit the value of field
     * 'dtDtPlcmtPreplaceVisit'.
     */
    public void setDtDtPlcmtPreplaceVisit(org.exolab.castor.types.Date dtDtPlcmtPreplaceVisit)
    {
        this._dtDtPlcmtPreplaceVisit = dtDtPlcmtPreplaceVisit;
    } //-- void setDtDtPlcmtPreplaceVisit(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtSchoolRecords'.
     * 
     * @param dtDtPlcmtSchoolRecords the value of field
     * 'dtDtPlcmtSchoolRecords'.
     */
    public void setDtDtPlcmtSchoolRecords(org.exolab.castor.types.Date dtDtPlcmtSchoolRecords)
    {
        this._dtDtPlcmtSchoolRecords = dtDtPlcmtSchoolRecords;
    } //-- void setDtDtPlcmtSchoolRecords(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'dtDtPsychCPInfo'.
     * 
     * @param dtDtPsychCPInfo the value of field 'dtDtPsychCPInfo'.
     */
    public void setDtDtPsychCPInfo(org.exolab.castor.types.Date dtDtPsychCPInfo)
    {
        this._dtDtPsychCPInfo = dtDtPsychCPInfo;
    } //-- void setDtDtPsychCPInfo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPsychInfo'.
     * 
     * @param dtDtPsychInfo the value of field 'dtDtPsychInfo'.
     */
    public void setDtDtPsychInfo(org.exolab.castor.types.Date dtDtPsychInfo)
    {
        this._dtDtPsychInfo = dtDtPsychInfo;
    } //-- void setDtDtPsychInfo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtLastViewPlcmtLog'.
     * 
     * @param dtLastViewPlcmtLog the value of field
     * 'dtLastViewPlcmtLog'.
     */
    public void setDtLastViewPlcmtLog(org.exolab.castor.types.Date dtLastViewPlcmtLog)
    {
        this._dtLastViewPlcmtLog = dtLastViewPlcmtLog;
    } //-- void setDtLastViewPlcmtLog(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtSupCert'.
     * 
     * @param dtSupCert the value of field 'dtSupCert'.
     */
    public void setDtSupCert(org.exolab.castor.types.Date dtSupCert)
    {
        this._dtSupCert = dtSupCert;
    } //-- void setDtSupCert(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indCaseMngrCert'.
     * 
     * @param indCaseMngrCert the value of field 'indCaseMngrCert'.
     */
    public void setIndCaseMngrCert(java.lang.String indCaseMngrCert)
    {
        this._indCaseMngrCert = indCaseMngrCert;
    } //-- void setIndCaseMngrCert(java.lang.String) 

    /**
     * Sets the value of field 'indSupCert'.
     * 
     * @param indSupCert the value of field 'indSupCert'.
     */
    public void setIndSupCert(java.lang.String indSupCert)
    {
        this._indSupCert = indSupCert;
    } //-- void setIndSupCert(java.lang.String) 

    /**
     * Sets the value of field 'nbrSibPlaced'.
     * 
     * @param nbrSibPlaced the value of field 'nbrSibPlaced'.
     */
    public void setNbrSibPlaced(int nbrSibPlaced)
    {
        this._nbrSibPlaced = nbrSibPlaced;
        this._has_nbrSibPlaced = true;
    } //-- void setNbrSibPlaced(int) 

    /**
     * Sets the value of field 'nbrSibinCare'.
     * 
     * @param nbrSibinCare the value of field 'nbrSibinCare'.
     */
    public void setNbrSibinCare(int nbrSibinCare)
    {
        this._nbrSibinCare = nbrSibinCare;
        this._has_nbrSibinCare = true;
    } //-- void setNbrSibinCare(int) 

    /**
     * Sets the value of field 'nmCaseMngrRsrc'.
     * 
     * @param nmCaseMngrRsrc the value of field 'nmCaseMngrRsrc'.
     */
    public void setNmCaseMngrRsrc(java.lang.String nmCaseMngrRsrc)
    {
        this._nmCaseMngrRsrc = nmCaseMngrRsrc;
    } //-- void setNmCaseMngrRsrc(java.lang.String) 

    /**
     * Sets the value of field 'nmSupRsrc'.
     * 
     * @param nmSupRsrc the value of field 'nmSupRsrc'.
     */
    public void setNmSupRsrc(java.lang.String nmSupRsrc)
    {
        this._nmSupRsrc = nmSupRsrc;
    } //-- void setNmSupRsrc(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPlcmtCity'.
     * 
     * @param szAddrPlcmtCity the value of field 'szAddrPlcmtCity'.
     */
    public void setSzAddrPlcmtCity(java.lang.String szAddrPlcmtCity)
    {
        this._szAddrPlcmtCity = szAddrPlcmtCity;
    } //-- void setSzAddrPlcmtCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPlcmtCnty'.
     * 
     * @param szAddrPlcmtCnty the value of field 'szAddrPlcmtCnty'.
     */
    public void setSzAddrPlcmtCnty(java.lang.String szAddrPlcmtCnty)
    {
        this._szAddrPlcmtCnty = szAddrPlcmtCnty;
    } //-- void setSzAddrPlcmtCnty(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPlcmtLn1'.
     * 
     * @param szAddrPlcmtLn1 the value of field 'szAddrPlcmtLn1'.
     */
    public void setSzAddrPlcmtLn1(java.lang.String szAddrPlcmtLn1)
    {
        this._szAddrPlcmtLn1 = szAddrPlcmtLn1;
    } //-- void setSzAddrPlcmtLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPlcmtLn2'.
     * 
     * @param szAddrPlcmtLn2 the value of field 'szAddrPlcmtLn2'.
     */
    public void setSzAddrPlcmtLn2(java.lang.String szAddrPlcmtLn2)
    {
        this._szAddrPlcmtLn2 = szAddrPlcmtLn2;
    } //-- void setSzAddrPlcmtLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPlcmtSt'.
     * 
     * @param szAddrPlcmtSt the value of field 'szAddrPlcmtSt'.
     */
    public void setSzAddrPlcmtSt(java.lang.String szAddrPlcmtSt)
    {
        this._szAddrPlcmtSt = szAddrPlcmtSt;
    } //-- void setSzAddrPlcmtSt(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPlcmtZip'.
     * 
     * @param szAddrPlcmtZip the value of field 'szAddrPlcmtZip'.
     */
    public void setSzAddrPlcmtZip(java.lang.String szAddrPlcmtZip)
    {
        this._szAddrPlcmtZip = szAddrPlcmtZip;
    } //-- void setSzAddrPlcmtZip(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdoPlaceInfo1'.
     * 
     * @param szCdAdoPlaceInfo1 the value of field
     * 'szCdAdoPlaceInfo1'.
     */
    public void setSzCdAdoPlaceInfo1(java.lang.String szCdAdoPlaceInfo1)
    {
        this._szCdAdoPlaceInfo1 = szCdAdoPlaceInfo1;
    } //-- void setSzCdAdoPlaceInfo1(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdoPlaceInfo2'.
     * 
     * @param szCdAdoPlaceInfo2 the value of field
     * 'szCdAdoPlaceInfo2'.
     */
    public void setSzCdAdoPlaceInfo2(java.lang.String szCdAdoPlaceInfo2)
    {
        this._szCdAdoPlaceInfo2 = szCdAdoPlaceInfo2;
    } //-- void setSzCdAdoPlaceInfo2(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdoPlaceInfo3'.
     * 
     * @param szCdAdoPlaceInfo3 the value of field
     * 'szCdAdoPlaceInfo3'.
     */
    public void setSzCdAdoPlaceInfo3(java.lang.String szCdAdoPlaceInfo3)
    {
        this._szCdAdoPlaceInfo3 = szCdAdoPlaceInfo3;
    } //-- void setSzCdAdoPlaceInfo3(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdoPlaceInfo4'.
     * 
     * @param szCdAdoPlaceInfo4 the value of field
     * 'szCdAdoPlaceInfo4'.
     */
    public void setSzCdAdoPlaceInfo4(java.lang.String szCdAdoPlaceInfo4)
    {
        this._szCdAdoPlaceInfo4 = szCdAdoPlaceInfo4;
    } //-- void setSzCdAdoPlaceInfo4(java.lang.String) 

    /**
     * Sets the value of field 'szCdBrdngCnty'.
     * 
     * @param szCdBrdngCnty the value of field 'szCdBrdngCnty'.
     */
    public void setSzCdBrdngCnty(java.lang.String szCdBrdngCnty)
    {
        this._szCdBrdngCnty = szCdBrdngCnty;
    } //-- void setSzCdBrdngCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdChildTransitionCmnts'.
     * 
     * @param szCdChildTransitionCmnts the value of field
     * 'szCdChildTransitionCmnts'.
     */
    public void setSzCdChildTransitionCmnts(java.lang.String szCdChildTransitionCmnts)
    {
        this._szCdChildTransitionCmnts = szCdChildTransitionCmnts;
    } //-- void setSzCdChildTransitionCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szCdMatch'.
     * 
     * @param szCdMatch the value of field 'szCdMatch'.
     */
    public void setSzCdMatch(java.lang.String szCdMatch)
    {
        this._szCdMatch = szCdMatch;
    } //-- void setSzCdMatch(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtActAtt'.
     * 
     * @param szCdPlcmtActAtt the value of field 'szCdPlcmtActAtt'.
     */
    public void setSzCdPlcmtActAtt(java.lang.String szCdPlcmtActAtt)
    {
        this._szCdPlcmtActAtt = szCdPlcmtActAtt;
    } //-- void setSzCdPlcmtActAtt(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtActPlanned'.
     * 
     * @param szCdPlcmtActPlanned the value of field
     * 'szCdPlcmtActPlanned'.
     */
    public void setSzCdPlcmtActPlanned(java.lang.String szCdPlcmtActPlanned)
    {
        this._szCdPlcmtActPlanned = szCdPlcmtActPlanned;
    } //-- void setSzCdPlcmtActPlanned(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtCCFA'.
     * 
     * @param szCdPlcmtCCFA the value of field 'szCdPlcmtCCFA'.
     */
    public void setSzCdPlcmtCCFA(java.lang.String szCdPlcmtCCFA)
    {
        this._szCdPlcmtCCFA = szCdPlcmtCCFA;
    } //-- void setSzCdPlcmtCCFA(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtContMethod'.
     * 
     * @param szCdPlcmtContMethod the value of field
     * 'szCdPlcmtContMethod'.
     */
    public void setSzCdPlcmtContMethod(java.lang.String szCdPlcmtContMethod)
    {
        this._szCdPlcmtContMethod = szCdPlcmtContMethod;
    } //-- void setSzCdPlcmtContMethod(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtContactedBy'.
     * 
     * @param szCdPlcmtContactedBy the value of field
     * 'szCdPlcmtContactedBy'.
     */
    public void setSzCdPlcmtContactedBy(java.lang.String szCdPlcmtContactedBy)
    {
        this._szCdPlcmtContactedBy = szCdPlcmtContactedBy;
    } //-- void setSzCdPlcmtContactedBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtLivArr'.
     * 
     * @param szCdPlcmtLivArr the value of field 'szCdPlcmtLivArr'.
     */
    public void setSzCdPlcmtLivArr(java.lang.String szCdPlcmtLivArr)
    {
        this._szCdPlcmtLivArr = szCdPlcmtLivArr;
    } //-- void setSzCdPlcmtLivArr(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtRemovalRsn'.
     * 
     * @param szCdPlcmtRemovalRsn the value of field
     * 'szCdPlcmtRemovalRsn'.
     */
    public void setSzCdPlcmtRemovalRsn(java.lang.String szCdPlcmtRemovalRsn)
    {
        this._szCdPlcmtRemovalRsn = szCdPlcmtRemovalRsn;
    } //-- void setSzCdPlcmtRemovalRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtService'.
     * 
     * @param szCdPlcmtService the value of field 'szCdPlcmtService'
     */
    public void setSzCdPlcmtService(java.lang.String szCdPlcmtService)
    {
        this._szCdPlcmtService = szCdPlcmtService;
    } //-- void setSzCdPlcmtService(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtTempType'.
     * 
     * @param szCdPlcmtTempType the value of field
     * 'szCdPlcmtTempType'.
     */
    public void setSzCdPlcmtTempType(java.lang.String szCdPlcmtTempType)
    {
        this._szCdPlcmtTempType = szCdPlcmtTempType;
    } //-- void setSzCdPlcmtTempType(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtType'.
     * 
     * @param szCdPlcmtType the value of field 'szCdPlcmtType'.
     */
    public void setSzCdPlcmtType(java.lang.String szCdPlcmtType)
    {
        this._szCdPlcmtType = szCdPlcmtType;
    } //-- void setSzCdPlcmtType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSibRsn'.
     * 
     * @param szCdSibRsn the value of field 'szCdSibRsn'.
     */
    public void setSzCdSibRsn(java.lang.String szCdSibRsn)
    {
        this._szCdSibRsn = szCdSibRsn;
    } //-- void setSzCdSibRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdWaivertype'.
     * 
     * @param szCdWaivertype the value of field 'szCdWaivertype'.
     */
    public void setSzCdWaivertype(java.lang.String szCdWaivertype)
    {
        this._szCdWaivertype = szCdWaivertype;
    } //-- void setSzCdWaivertype(java.lang.String) 

    /**
     * Sets the value of field 'szNbrPlcmtPhoneExt'.
     * 
     * @param szNbrPlcmtPhoneExt the value of field
     * 'szNbrPlcmtPhoneExt'.
     */
    public void setSzNbrPlcmtPhoneExt(java.lang.String szNbrPlcmtPhoneExt)
    {
        this._szNbrPlcmtPhoneExt = szNbrPlcmtPhoneExt;
    } //-- void setSzNbrPlcmtPhoneExt(java.lang.String) 

    /**
     * Sets the value of field 'szNbrPlcmtTelephone'.
     * 
     * @param szNbrPlcmtTelephone the value of field
     * 'szNbrPlcmtTelephone'.
     */
    public void setSzNbrPlcmtTelephone(java.lang.String szNbrPlcmtTelephone)
    {
        this._szNbrPlcmtTelephone = szNbrPlcmtTelephone;
    } //-- void setSzNbrPlcmtTelephone(java.lang.String) 

    /**
     * Sets the value of field 'szNmPlcmtAgency'.
     * 
     * @param szNmPlcmtAgency the value of field 'szNmPlcmtAgency'.
     */
    public void setSzNmPlcmtAgency(java.lang.String szNmPlcmtAgency)
    {
        this._szNmPlcmtAgency = szNmPlcmtAgency;
    } //-- void setSzNmPlcmtAgency(java.lang.String) 

    /**
     * Sets the value of field 'szNmPlcmtContact'.
     * 
     * @param szNmPlcmtContact the value of field 'szNmPlcmtContact'
     */
    public void setSzNmPlcmtContact(java.lang.String szNmPlcmtContact)
    {
        this._szNmPlcmtContact = szNmPlcmtContact;
    } //-- void setSzNmPlcmtContact(java.lang.String) 

    /**
     * Sets the value of field 'szNmPlcmtFacil'.
     * 
     * @param szNmPlcmtFacil the value of field 'szNmPlcmtFacil'.
     */
    public void setSzNmPlcmtFacil(java.lang.String szNmPlcmtFacil)
    {
        this._szNmPlcmtFacil = szNmPlcmtFacil;
    } //-- void setSzNmPlcmtFacil(java.lang.String) 

    /**
     * Sets the value of field 'szNmPlcmtPersonFull'.
     * 
     * @param szNmPlcmtPersonFull the value of field
     * 'szNmPlcmtPersonFull'.
     */
    public void setSzNmPlcmtPersonFull(java.lang.String szNmPlcmtPersonFull)
    {
        this._szNmPlcmtPersonFull = szNmPlcmtPersonFull;
    } //-- void setSzNmPlcmtPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szTxtAddtnlDoc'.
     * 
     * @param szTxtAddtnlDoc the value of field 'szTxtAddtnlDoc'.
     */
    public void setSzTxtAddtnlDoc(java.lang.String szTxtAddtnlDoc)
    {
        this._szTxtAddtnlDoc = szTxtAddtnlDoc;
    } //-- void setSzTxtAddtnlDoc(java.lang.String) 

    /**
     * Sets the value of field 'szTxtCareGvDoc'.
     * 
     * @param szTxtCareGvDoc the value of field 'szTxtCareGvDoc'.
     */
    public void setSzTxtCareGvDoc(java.lang.String szTxtCareGvDoc)
    {
        this._szTxtCareGvDoc = szTxtCareGvDoc;
    } //-- void setSzTxtCareGvDoc(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEduCPInfoCont'.
     * 
     * @param szTxtEduCPInfoCont the value of field
     * 'szTxtEduCPInfoCont'.
     */
    public void setSzTxtEduCPInfoCont(java.lang.String szTxtEduCPInfoCont)
    {
        this._szTxtEduCPInfoCont = szTxtEduCPInfoCont;
    } //-- void setSzTxtEduCPInfoCont(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEduInfoCont'.
     * 
     * @param szTxtEduInfoCont the value of field 'szTxtEduInfoCont'
     */
    public void setSzTxtEduInfoCont(java.lang.String szTxtEduInfoCont)
    {
        this._szTxtEduInfoCont = szTxtEduInfoCont;
    } //-- void setSzTxtEduInfoCont(java.lang.String) 

    /**
     * Sets the value of field 'szTxtMedCPInfoCont'.
     * 
     * @param szTxtMedCPInfoCont the value of field
     * 'szTxtMedCPInfoCont'.
     */
    public void setSzTxtMedCPInfoCont(java.lang.String szTxtMedCPInfoCont)
    {
        this._szTxtMedCPInfoCont = szTxtMedCPInfoCont;
    } //-- void setSzTxtMedCPInfoCont(java.lang.String) 

    /**
     * Sets the value of field 'szTxtMedInfoCont'.
     * 
     * @param szTxtMedInfoCont the value of field 'szTxtMedInfoCont'
     */
    public void setSzTxtMedInfoCont(java.lang.String szTxtMedInfoCont)
    {
        this._szTxtMedInfoCont = szTxtMedInfoCont;
    } //-- void setSzTxtMedInfoCont(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtAddrComment'.
     * 
     * @param szTxtPlcmtAddrComment the value of field
     * 'szTxtPlcmtAddrComment'.
     */
    public void setSzTxtPlcmtAddrComment(java.lang.String szTxtPlcmtAddrComment)
    {
        this._szTxtPlcmtAddrComment = szTxtPlcmtAddrComment;
    } //-- void setSzTxtPlcmtAddrComment(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtCCFA'.
     * 
     * @param szTxtPlcmtCCFA the value of field 'szTxtPlcmtCCFA'.
     */
    public void setSzTxtPlcmtCCFA(java.lang.String szTxtPlcmtCCFA)
    {
        this._szTxtPlcmtCCFA = szTxtPlcmtCCFA;
    } //-- void setSzTxtPlcmtCCFA(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtChkList'.
     * 
     * @param szTxtPlcmtChkList the value of field
     * 'szTxtPlcmtChkList'.
     */
    public void setSzTxtPlcmtChkList(java.lang.String szTxtPlcmtChkList)
    {
        this._szTxtPlcmtChkList = szTxtPlcmtChkList;
    } //-- void setSzTxtPlcmtChkList(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtDiscussion'.
     * 
     * @param szTxtPlcmtDiscussion the value of field
     * 'szTxtPlcmtDiscussion'.
     */
    public void setSzTxtPlcmtDiscussion(java.lang.String szTxtPlcmtDiscussion)
    {
        this._szTxtPlcmtDiscussion = szTxtPlcmtDiscussion;
    } //-- void setSzTxtPlcmtDiscussion(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtDocuments'.
     * 
     * @param szTxtPlcmtDocuments the value of field
     * 'szTxtPlcmtDocuments'.
     */
    public void setSzTxtPlcmtDocuments(java.lang.String szTxtPlcmtDocuments)
    {
        this._szTxtPlcmtDocuments = szTxtPlcmtDocuments;
    } //-- void setSzTxtPlcmtDocuments(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtRemovalRsn'.
     * 
     * @param szTxtPlcmtRemovalRsn the value of field
     * 'szTxtPlcmtRemovalRsn'.
     */
    public void setSzTxtPlcmtRemovalRsn(java.lang.String szTxtPlcmtRemovalRsn)
    {
        this._szTxtPlcmtRemovalRsn = szTxtPlcmtRemovalRsn;
    } //-- void setSzTxtPlcmtRemovalRsn(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtSibling'.
     * 
     * @param szTxtPlcmtSibling the value of field
     * 'szTxtPlcmtSibling'.
     */
    public void setSzTxtPlcmtSibling(java.lang.String szTxtPlcmtSibling)
    {
        this._szTxtPlcmtSibling = szTxtPlcmtSibling;
    } //-- void setSzTxtPlcmtSibling(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtSpvsn'.
     * 
     * @param szTxtPlcmtSpvsn the value of field 'szTxtPlcmtSpvsn'.
     */
    public void setSzTxtPlcmtSpvsn(java.lang.String szTxtPlcmtSpvsn)
    {
        this._szTxtPlcmtSpvsn = szTxtPlcmtSpvsn;
    } //-- void setSzTxtPlcmtSpvsn(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtTempCmmnts'.
     * 
     * @param szTxtPlcmtTempCmmnts the value of field
     * 'szTxtPlcmtTempCmmnts'.
     */
    public void setSzTxtPlcmtTempCmmnts(java.lang.String szTxtPlcmtTempCmmnts)
    {
        this._szTxtPlcmtTempCmmnts = szTxtPlcmtTempCmmnts;
    } //-- void setSzTxtPlcmtTempCmmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPlcmtTrauma'.
     * 
     * @param szTxtPlcmtTrauma the value of field 'szTxtPlcmtTrauma'
     */
    public void setSzTxtPlcmtTrauma(java.lang.String szTxtPlcmtTrauma)
    {
        this._szTxtPlcmtTrauma = szTxtPlcmtTrauma;
    } //-- void setSzTxtPlcmtTrauma(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPsychCPInfoCont'.
     * 
     * @param szTxtPsychCPInfoCont the value of field
     * 'szTxtPsychCPInfoCont'.
     */
    public void setSzTxtPsychCPInfoCont(java.lang.String szTxtPsychCPInfoCont)
    {
        this._szTxtPsychCPInfoCont = szTxtPsychCPInfoCont;
    } //-- void setSzTxtPsychCPInfoCont(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPsychInfoCont'.
     * 
     * @param szTxtPsychInfoCont the value of field
     * 'szTxtPsychInfoCont'.
     */
    public void setSzTxtPsychInfoCont(java.lang.String szTxtPsychInfoCont)
    {
        this._szTxtPsychInfoCont = szTxtPsychInfoCont;
    } //-- void setSzTxtPsychInfoCont(java.lang.String) 

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
     * Sets the value of field 'ulIdCaseMngrCert'.
     * 
     * @param ulIdCaseMngrCert the value of field 'ulIdCaseMngrCert'
     */
    public void setUlIdCaseMngrCert(int ulIdCaseMngrCert)
    {
        this._ulIdCaseMngrCert = ulIdCaseMngrCert;
        this._has_ulIdCaseMngrCert = true;
    } //-- void setUlIdCaseMngrCert(int) 

    /**
     * Sets the value of field 'ulIdCaseMngrRsrc'.
     * 
     * @param ulIdCaseMngrRsrc the value of field 'ulIdCaseMngrRsrc'
     */
    public void setUlIdCaseMngrRsrc(int ulIdCaseMngrRsrc)
    {
        this._ulIdCaseMngrRsrc = ulIdCaseMngrRsrc;
        this._has_ulIdCaseMngrRsrc = true;
    } //-- void setUlIdCaseMngrRsrc(int) 

    /**
     * Sets the value of field 'ulIdContactedBy'.
     * 
     * @param ulIdContactedBy the value of field 'ulIdContactedBy'.
     */
    public void setUlIdContactedBy(int ulIdContactedBy)
    {
        this._ulIdContactedBy = ulIdContactedBy;
        this._has_ulIdContactedBy = true;
    } //-- void setUlIdContactedBy(int) 

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
     * Sets the value of field 'ulIdPersonConnected'.
     * 
     * @param ulIdPersonConnected the value of field
     * 'ulIdPersonConnected'.
     */
    public void setUlIdPersonConnected(int ulIdPersonConnected)
    {
        this._ulIdPersonConnected = ulIdPersonConnected;
        this._has_ulIdPersonConnected = true;
    } //-- void setUlIdPersonConnected(int) 

    /**
     * Sets the value of field 'ulIdPlcmtAdult'.
     * 
     * @param ulIdPlcmtAdult the value of field 'ulIdPlcmtAdult'.
     */
    public void setUlIdPlcmtAdult(int ulIdPlcmtAdult)
    {
        this._ulIdPlcmtAdult = ulIdPlcmtAdult;
        this._has_ulIdPlcmtAdult = true;
    } //-- void setUlIdPlcmtAdult(int) 

    /**
     * Sets the value of field 'ulIdPlcmtChild'.
     * 
     * @param ulIdPlcmtChild the value of field 'ulIdPlcmtChild'.
     */
    public void setUlIdPlcmtChild(int ulIdPlcmtChild)
    {
        this._ulIdPlcmtChild = ulIdPlcmtChild;
        this._has_ulIdPlcmtChild = true;
    } //-- void setUlIdPlcmtChild(int) 

    /**
     * Sets the value of field 'ulIdRsrcAgency'.
     * 
     * @param ulIdRsrcAgency the value of field 'ulIdRsrcAgency'.
     */
    public void setUlIdRsrcAgency(int ulIdRsrcAgency)
    {
        this._ulIdRsrcAgency = ulIdRsrcAgency;
        this._has_ulIdRsrcAgency = true;
    } //-- void setUlIdRsrcAgency(int) 

    /**
     * Sets the value of field 'ulIdRsrcFacil'.
     * 
     * @param ulIdRsrcFacil the value of field 'ulIdRsrcFacil'.
     */
    public void setUlIdRsrcFacil(int ulIdRsrcFacil)
    {
        this._ulIdRsrcFacil = ulIdRsrcFacil;
        this._has_ulIdRsrcFacil = true;
    } //-- void setUlIdRsrcFacil(int) 

    /**
     * Sets the value of field 'ulIdRsrcFacilOriginal'.
     * 
     * @param ulIdRsrcFacilOriginal the value of field
     * 'ulIdRsrcFacilOriginal'.
     */
    public void setUlIdRsrcFacilOriginal(int ulIdRsrcFacilOriginal)
    {
        this._ulIdRsrcFacilOriginal = ulIdRsrcFacilOriginal;
        this._has_ulIdRsrcFacilOriginal = true;
    } //-- void setUlIdRsrcFacilOriginal(int) 

    /**
     * Sets the value of field 'ulIdSupCert'.
     * 
     * @param ulIdSupCert the value of field 'ulIdSupCert'.
     */
    public void setUlIdSupCert(int ulIdSupCert)
    {
        this._ulIdSupCert = ulIdSupCert;
        this._has_ulIdSupCert = true;
    } //-- void setUlIdSupCert(int) 

    /**
     * Sets the value of field 'ulIdSupRsrc'.
     * 
     * @param ulIdSupRsrc the value of field 'ulIdSupRsrc'.
     */
    public void setUlIdSupRsrc(int ulIdSupRsrc)
    {
        this._ulIdSupRsrc = ulIdSupRsrc;
        this._has_ulIdSupRsrc = true;
    } //-- void setUlIdSupRsrc(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00 unmarshal(java.io.Reader) 

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
