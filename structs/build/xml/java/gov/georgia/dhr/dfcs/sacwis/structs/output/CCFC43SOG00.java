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
 * Class CCFC43SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC43SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdAdminRvAppealResult
     */
    private java.lang.String _szCdAdminRvAppealResult;

    /**
     * Field _szCdAdminRvReqBy
     */
    private java.lang.String _szCdAdminRvReqBy;

    /**
     * Field _szScrNmReviewReqBy
     */
    private java.lang.String _szScrNmReviewReqBy;

    /**
     * Field _szCdAdminRvAppealType
     */
    private java.lang.String _szCdAdminRvAppealType;

    /**
     * Field _szCdAdminRvAuth
     */
    private java.lang.String _szCdAdminRvAuth;

    /**
     * Field _szCdAdminRvStatus
     */
    private java.lang.String _szCdAdminRvStatus;

    /**
     * Field _dtDtAdminRvAppealNotif
     */
    private org.exolab.castor.types.Date _dtDtAdminRvAppealNotif;

    /**
     * Field _dtDtAdminRvAppealReview
     */
    private org.exolab.castor.types.Date _dtDtAdminRvAppealReview;

    /**
     * Field _dtDtAdminRvDue
     */
    private org.exolab.castor.types.Date _dtDtAdminRvDue;

    /**
     * Field _dtDtAdminRvEmgcyRel
     */
    private org.exolab.castor.types.Date _dtDtAdminRvEmgcyRel;

    /**
     * Field _dtDtAdminRvHearing
     */
    private org.exolab.castor.types.Date _dtDtAdminRvHearing;

    /**
     * Field _dtDtAdminRvReqAppeal
     */
    private org.exolab.castor.types.Date _dtDtAdminRvReqAppeal;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdPersonRequestor
     */
    private int _ulIdPersonRequestor;

    /**
     * keeps track of state for field: _ulIdPersonRequestor
     */
    private boolean _has_ulIdPersonRequestor;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdStageRelated
     */
    private int _ulIdStageRelated;

    /**
     * keeps track of state for field: _ulIdStageRelated
     */
    private boolean _has_ulIdStageRelated;

    /**
     * Field _cIndAdminRvEmgcyRel
     */
    private java.lang.String _cIndAdminRvEmgcyRel;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _bIndSaagNotification
     */
    private java.lang.String _bIndSaagNotification;

    /**
     * Field _bIndLglRepresentation
     */
    private java.lang.String _bIndLglRepresentation;

    /**
     * Field _dtDtDeterminationLtr
     */
    private org.exolab.castor.types.Date _dtDtDeterminationLtr;

    /**
     * Field _sztxtAppealResult
     */
    private java.lang.String _sztxtAppealResult;

    /**
     * Field _sztxtRsnApprvDeny
     */
    private java.lang.String _sztxtRsnApprvDeny;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szCdAdminRvIndLevel
     */
    private java.lang.String _szCdAdminRvIndLevel;

    /**
     * Field _dtDt1lvlAdminRvReqAppeal
     */
    private org.exolab.castor.types.Date _dtDt1lvlAdminRvReqAppeal;

    /**
     * Field _dtDt1lvlAdminRvAppealNotif
     */
    private org.exolab.castor.types.Date _dtDt1lvlAdminRvAppealNotif;

    /**
     * Field _dtDt1lvlAdminRvAppealReview
     */
    private org.exolab.castor.types.Date _dtDt1lvlAdminRvAppealReview;

    /**
     * Field _dtDt1lvlAdminRvDue
     */
    private org.exolab.castor.types.Date _dtDt1lvlAdminRvDue;

    /**
     * Field _dtDt1lvlDeterminationLtr
     */
    private org.exolab.castor.types.Date _dtDt1lvlDeterminationLtr;

    /**
     * Field _bInd1lvlSaagNotification
     */
    private java.lang.String _bInd1lvlSaagNotification;

    /**
     * Field _bInd1lvlLglRepresentation
     */
    private java.lang.String _bInd1lvlLglRepresentation;

    /**
     * Field _szCd1lvlAdminRvDisp
     */
    private java.lang.String _szCd1lvlAdminRvDisp;

    /**
     * Field _szCd1lvlAdminRsDisg
     */
    private java.lang.String _szCd1lvlAdminRsDisg;

    /**
     * Field _szTxt1lvlAdminRevResults
     */
    private java.lang.String _szTxt1lvlAdminRevResults;

    /**
     * Field _dtDt1lvlAdminRvPersonNotif
     */
    private org.exolab.castor.types.Date _dtDt1lvlAdminRvPersonNotif;

    /**
     * Field _szTxt1lvlAdminRevResAppDen
     */
    private java.lang.String _szTxt1lvlAdminRevResAppDen;

    /**
     * Field _szNmPersonFullAmdRev1lSME
     */
    private java.lang.String _szNmPersonFullAmdRev1lSME;

    /**
     * Field _ulAdmRev2lvlPriorStage
     */
    private int _ulAdmRev2lvlPriorStage;

    /**
     * keeps track of state for field: _ulAdmRev2lvlPriorStage
     */
    private boolean _has_ulAdmRev2lvlPriorStage;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _ROWCCMN01UIG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY _ROWCCMN01UIG02_ARRAY;

    /**
     * Field _szNmAdmRvPersonFullAmdComp
     */
    private java.lang.String _szNmAdmRvPersonFullAmdComp;

    /**
     * Field _bInd1lvlAdmRv21lvlStag
     */
    private java.lang.String _bInd1lvlAdmRv21lvlStag;

    /**
     * Field _bInd2lvlAdmRvComp
     */
    private java.lang.String _bInd2lvlAdmRvComp;

    /**
     * Field _szTxt2lvlAdminRevOff
     */
    private java.lang.String _szTxt2lvlAdminRevOff;

    /**
     * Field _dtDt2lvlAdminRvReqAppeal
     */
    private org.exolab.castor.types.Date _dtDt2lvlAdminRvReqAppeal;

    /**
     * Field _dtDt2lvlAdminRvAppealNotif
     */
    private org.exolab.castor.types.Date _dtDt2lvlAdminRvAppealNotif;

    /**
     * Field _dtDt2lvlAdminRvAppealReview
     */
    private org.exolab.castor.types.Date _dtDt2lvlAdminRvAppealReview;

    /**
     * Field _dtDt2lvlAdminRvDue
     */
    private org.exolab.castor.types.Date _dtDt2lvlAdminRvDue;

    /**
     * Field _bInd2lvlSaagNotification
     */
    private java.lang.String _bInd2lvlSaagNotification;

    /**
     * Field _bInd2lvlLglRepresentation
     */
    private java.lang.String _bInd2lvlLglRepresentation;

    /**
     * Field _szCd2lvlAdminRvDisp
     */
    private java.lang.String _szCd2lvlAdminRvDisp;

    /**
     * Field _szCd2lvlAdminRsDisg
     */
    private java.lang.String _szCd2lvlAdminRsDisg;

    /**
     * Field _szTxt2lvlAdminRevResults
     */
    private java.lang.String _szTxt2lvlAdminRevResults;

    /**
     * Field _dtDt2lvlAdminRvPersonNotif
     */
    private org.exolab.castor.types.Date _dtDt2lvlAdminRvPersonNotif;

    /**
     * Field _szTxt2lvlAdminRevResAppDen
     */
    private java.lang.String _szTxt2lvlAdminRevResAppDen;

    /**
     * Field _dtDt2lvlAdminRvReqIntrv
     */
    private org.exolab.castor.types.Date _dtDt2lvlAdminRvReqIntrv;

    /**
     * Field _dtDt2lvlAdmRvDecLtr
     */
    private org.exolab.castor.types.Date _dtDt2lvlAdmRvDecLtr;

    /**
     * Field _szCd2lvlAdminRvType
     */
    private java.lang.String _szCd2lvlAdminRvType;

    /**
     * Field _dtDt3lvlAdmRvDecLtr
     */
    private org.exolab.castor.types.Date _dtDt3lvlAdmRvDecLtr;

    /**
     * Field _dtDt3lvlAdminRvAppealReview
     */
    private org.exolab.castor.types.Date _dtDt3lvlAdminRvAppealReview;

    /**
     * Field _dtDt3lvlAdminRvDue
     */
    private org.exolab.castor.types.Date _dtDt3lvlAdminRvDue;

    /**
     * Field _szCd3lvlAdminRvDisp
     */
    private java.lang.String _szCd3lvlAdminRvDisp;

    /**
     * Field _szCd3lvlAdminRsDisg
     */
    private java.lang.String _szCd3lvlAdminRsDisg;

    /**
     * Field _szTxt3lvlAdminRevResults
     */
    private java.lang.String _szTxt3lvlAdminRevResults;

    /**
     * Field _dtDt3lvlAdminRvPersonNotif
     */
    private org.exolab.castor.types.Date _dtDt3lvlAdminRvPersonNotif;

    /**
     * Field _szTxt3lvlAdminRevResAppDen
     */
    private java.lang.String _szTxt3lvlAdminRevResAppDen;

    /**
     * Field _szCd3lvlAdminRvFnDec
     */
    private java.lang.String _szCd3lvlAdminRvFnDec;

    /**
     * Field _szTxt3lvlAdminRevCommDes
     */
    private java.lang.String _szTxt3lvlAdminRevCommDes;

    /**
     * Field _szTxt3lvlAdminRevCompDoc
     */
    private java.lang.String _szTxt3lvlAdminRevCompDoc;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC43SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlAdmRev2lvlPriorStage()
    {
        this._has_ulAdmRev2lvlPriorStage= false;
    } //-- void deleteUlAdmRev2lvlPriorStage() 

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
    public void deleteUlIdPersonRequestor()
    {
        this._has_ulIdPersonRequestor= false;
    } //-- void deleteUlIdPersonRequestor() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdStageRelated()
    {
        this._has_ulIdStageRelated= false;
    } //-- void deleteUlIdStageRelated() 

    /**
     * Returns the value of field 'bInd1lvlAdmRv21lvlStag'.
     * 
     * @return the value of field 'BInd1lvlAdmRv21lvlStag'.
     */
    public java.lang.String getBInd1lvlAdmRv21lvlStag()
    {
        return this._bInd1lvlAdmRv21lvlStag;
    } //-- java.lang.String getBInd1lvlAdmRv21lvlStag() 

    /**
     * Returns the value of field 'bInd1lvlLglRepresentation'.
     * 
     * @return the value of field 'BInd1lvlLglRepresentation'.
     */
    public java.lang.String getBInd1lvlLglRepresentation()
    {
        return this._bInd1lvlLglRepresentation;
    } //-- java.lang.String getBInd1lvlLglRepresentation() 

    /**
     * Returns the value of field 'bInd1lvlSaagNotification'.
     * 
     * @return the value of field 'BInd1lvlSaagNotification'.
     */
    public java.lang.String getBInd1lvlSaagNotification()
    {
        return this._bInd1lvlSaagNotification;
    } //-- java.lang.String getBInd1lvlSaagNotification() 

    /**
     * Returns the value of field 'bInd2lvlAdmRvComp'.
     * 
     * @return the value of field 'BInd2lvlAdmRvComp'.
     */
    public java.lang.String getBInd2lvlAdmRvComp()
    {
        return this._bInd2lvlAdmRvComp;
    } //-- java.lang.String getBInd2lvlAdmRvComp() 

    /**
     * Returns the value of field 'bInd2lvlLglRepresentation'.
     * 
     * @return the value of field 'BInd2lvlLglRepresentation'.
     */
    public java.lang.String getBInd2lvlLglRepresentation()
    {
        return this._bInd2lvlLglRepresentation;
    } //-- java.lang.String getBInd2lvlLglRepresentation() 

    /**
     * Returns the value of field 'bInd2lvlSaagNotification'.
     * 
     * @return the value of field 'BInd2lvlSaagNotification'.
     */
    public java.lang.String getBInd2lvlSaagNotification()
    {
        return this._bInd2lvlSaagNotification;
    } //-- java.lang.String getBInd2lvlSaagNotification() 

    /**
     * Returns the value of field 'bIndLglRepresentation'.
     * 
     * @return the value of field 'BIndLglRepresentation'.
     */
    public java.lang.String getBIndLglRepresentation()
    {
        return this._bIndLglRepresentation;
    } //-- java.lang.String getBIndLglRepresentation() 

    /**
     * Returns the value of field 'bIndSaagNotification'.
     * 
     * @return the value of field 'BIndSaagNotification'.
     */
    public java.lang.String getBIndSaagNotification()
    {
        return this._bIndSaagNotification;
    } //-- java.lang.String getBIndSaagNotification() 

    /**
     * Returns the value of field 'cIndAdminRvEmgcyRel'.
     * 
     * @return the value of field 'CIndAdminRvEmgcyRel'.
     */
    public java.lang.String getCIndAdminRvEmgcyRel()
    {
        return this._cIndAdminRvEmgcyRel;
    } //-- java.lang.String getCIndAdminRvEmgcyRel() 

    /**
     * Returns the value of field 'dtDt1lvlAdminRvAppealNotif'.
     * 
     * @return the value of field 'DtDt1lvlAdminRvAppealNotif'.
     */
    public org.exolab.castor.types.Date getDtDt1lvlAdminRvAppealNotif()
    {
        return this._dtDt1lvlAdminRvAppealNotif;
    } //-- org.exolab.castor.types.Date getDtDt1lvlAdminRvAppealNotif() 

    /**
     * Returns the value of field 'dtDt1lvlAdminRvAppealReview'.
     * 
     * @return the value of field 'DtDt1lvlAdminRvAppealReview'.
     */
    public org.exolab.castor.types.Date getDtDt1lvlAdminRvAppealReview()
    {
        return this._dtDt1lvlAdminRvAppealReview;
    } //-- org.exolab.castor.types.Date getDtDt1lvlAdminRvAppealReview() 

    /**
     * Returns the value of field 'dtDt1lvlAdminRvDue'.
     * 
     * @return the value of field 'DtDt1lvlAdminRvDue'.
     */
    public org.exolab.castor.types.Date getDtDt1lvlAdminRvDue()
    {
        return this._dtDt1lvlAdminRvDue;
    } //-- org.exolab.castor.types.Date getDtDt1lvlAdminRvDue() 

    /**
     * Returns the value of field 'dtDt1lvlAdminRvPersonNotif'.
     * 
     * @return the value of field 'DtDt1lvlAdminRvPersonNotif'.
     */
    public org.exolab.castor.types.Date getDtDt1lvlAdminRvPersonNotif()
    {
        return this._dtDt1lvlAdminRvPersonNotif;
    } //-- org.exolab.castor.types.Date getDtDt1lvlAdminRvPersonNotif() 

    /**
     * Returns the value of field 'dtDt1lvlAdminRvReqAppeal'.
     * 
     * @return the value of field 'DtDt1lvlAdminRvReqAppeal'.
     */
    public org.exolab.castor.types.Date getDtDt1lvlAdminRvReqAppeal()
    {
        return this._dtDt1lvlAdminRvReqAppeal;
    } //-- org.exolab.castor.types.Date getDtDt1lvlAdminRvReqAppeal() 

    /**
     * Returns the value of field 'dtDt1lvlDeterminationLtr'.
     * 
     * @return the value of field 'DtDt1lvlDeterminationLtr'.
     */
    public org.exolab.castor.types.Date getDtDt1lvlDeterminationLtr()
    {
        return this._dtDt1lvlDeterminationLtr;
    } //-- org.exolab.castor.types.Date getDtDt1lvlDeterminationLtr() 

    /**
     * Returns the value of field 'dtDt2lvlAdmRvDecLtr'.
     * 
     * @return the value of field 'DtDt2lvlAdmRvDecLtr'.
     */
    public org.exolab.castor.types.Date getDtDt2lvlAdmRvDecLtr()
    {
        return this._dtDt2lvlAdmRvDecLtr;
    } //-- org.exolab.castor.types.Date getDtDt2lvlAdmRvDecLtr() 

    /**
     * Returns the value of field 'dtDt2lvlAdminRvAppealNotif'.
     * 
     * @return the value of field 'DtDt2lvlAdminRvAppealNotif'.
     */
    public org.exolab.castor.types.Date getDtDt2lvlAdminRvAppealNotif()
    {
        return this._dtDt2lvlAdminRvAppealNotif;
    } //-- org.exolab.castor.types.Date getDtDt2lvlAdminRvAppealNotif() 

    /**
     * Returns the value of field 'dtDt2lvlAdminRvAppealReview'.
     * 
     * @return the value of field 'DtDt2lvlAdminRvAppealReview'.
     */
    public org.exolab.castor.types.Date getDtDt2lvlAdminRvAppealReview()
    {
        return this._dtDt2lvlAdminRvAppealReview;
    } //-- org.exolab.castor.types.Date getDtDt2lvlAdminRvAppealReview() 

    /**
     * Returns the value of field 'dtDt2lvlAdminRvDue'.
     * 
     * @return the value of field 'DtDt2lvlAdminRvDue'.
     */
    public org.exolab.castor.types.Date getDtDt2lvlAdminRvDue()
    {
        return this._dtDt2lvlAdminRvDue;
    } //-- org.exolab.castor.types.Date getDtDt2lvlAdminRvDue() 

    /**
     * Returns the value of field 'dtDt2lvlAdminRvPersonNotif'.
     * 
     * @return the value of field 'DtDt2lvlAdminRvPersonNotif'.
     */
    public org.exolab.castor.types.Date getDtDt2lvlAdminRvPersonNotif()
    {
        return this._dtDt2lvlAdminRvPersonNotif;
    } //-- org.exolab.castor.types.Date getDtDt2lvlAdminRvPersonNotif() 

    /**
     * Returns the value of field 'dtDt2lvlAdminRvReqAppeal'.
     * 
     * @return the value of field 'DtDt2lvlAdminRvReqAppeal'.
     */
    public org.exolab.castor.types.Date getDtDt2lvlAdminRvReqAppeal()
    {
        return this._dtDt2lvlAdminRvReqAppeal;
    } //-- org.exolab.castor.types.Date getDtDt2lvlAdminRvReqAppeal() 

    /**
     * Returns the value of field 'dtDt2lvlAdminRvReqIntrv'.
     * 
     * @return the value of field 'DtDt2lvlAdminRvReqIntrv'.
     */
    public org.exolab.castor.types.Date getDtDt2lvlAdminRvReqIntrv()
    {
        return this._dtDt2lvlAdminRvReqIntrv;
    } //-- org.exolab.castor.types.Date getDtDt2lvlAdminRvReqIntrv() 

    /**
     * Returns the value of field 'dtDt3lvlAdmRvDecLtr'.
     * 
     * @return the value of field 'DtDt3lvlAdmRvDecLtr'.
     */
    public org.exolab.castor.types.Date getDtDt3lvlAdmRvDecLtr()
    {
        return this._dtDt3lvlAdmRvDecLtr;
    } //-- org.exolab.castor.types.Date getDtDt3lvlAdmRvDecLtr() 

    /**
     * Returns the value of field 'dtDt3lvlAdminRvAppealReview'.
     * 
     * @return the value of field 'DtDt3lvlAdminRvAppealReview'.
     */
    public org.exolab.castor.types.Date getDtDt3lvlAdminRvAppealReview()
    {
        return this._dtDt3lvlAdminRvAppealReview;
    } //-- org.exolab.castor.types.Date getDtDt3lvlAdminRvAppealReview() 

    /**
     * Returns the value of field 'dtDt3lvlAdminRvDue'.
     * 
     * @return the value of field 'DtDt3lvlAdminRvDue'.
     */
    public org.exolab.castor.types.Date getDtDt3lvlAdminRvDue()
    {
        return this._dtDt3lvlAdminRvDue;
    } //-- org.exolab.castor.types.Date getDtDt3lvlAdminRvDue() 

    /**
     * Returns the value of field 'dtDt3lvlAdminRvPersonNotif'.
     * 
     * @return the value of field 'DtDt3lvlAdminRvPersonNotif'.
     */
    public org.exolab.castor.types.Date getDtDt3lvlAdminRvPersonNotif()
    {
        return this._dtDt3lvlAdminRvPersonNotif;
    } //-- org.exolab.castor.types.Date getDtDt3lvlAdminRvPersonNotif() 

    /**
     * Returns the value of field 'dtDtAdminRvAppealNotif'.
     * 
     * @return the value of field 'DtDtAdminRvAppealNotif'.
     */
    public org.exolab.castor.types.Date getDtDtAdminRvAppealNotif()
    {
        return this._dtDtAdminRvAppealNotif;
    } //-- org.exolab.castor.types.Date getDtDtAdminRvAppealNotif() 

    /**
     * Returns the value of field 'dtDtAdminRvAppealReview'.
     * 
     * @return the value of field 'DtDtAdminRvAppealReview'.
     */
    public org.exolab.castor.types.Date getDtDtAdminRvAppealReview()
    {
        return this._dtDtAdminRvAppealReview;
    } //-- org.exolab.castor.types.Date getDtDtAdminRvAppealReview() 

    /**
     * Returns the value of field 'dtDtAdminRvDue'.
     * 
     * @return the value of field 'DtDtAdminRvDue'.
     */
    public org.exolab.castor.types.Date getDtDtAdminRvDue()
    {
        return this._dtDtAdminRvDue;
    } //-- org.exolab.castor.types.Date getDtDtAdminRvDue() 

    /**
     * Returns the value of field 'dtDtAdminRvEmgcyRel'.
     * 
     * @return the value of field 'DtDtAdminRvEmgcyRel'.
     */
    public org.exolab.castor.types.Date getDtDtAdminRvEmgcyRel()
    {
        return this._dtDtAdminRvEmgcyRel;
    } //-- org.exolab.castor.types.Date getDtDtAdminRvEmgcyRel() 

    /**
     * Returns the value of field 'dtDtAdminRvHearing'.
     * 
     * @return the value of field 'DtDtAdminRvHearing'.
     */
    public org.exolab.castor.types.Date getDtDtAdminRvHearing()
    {
        return this._dtDtAdminRvHearing;
    } //-- org.exolab.castor.types.Date getDtDtAdminRvHearing() 

    /**
     * Returns the value of field 'dtDtAdminRvReqAppeal'.
     * 
     * @return the value of field 'DtDtAdminRvReqAppeal'.
     */
    public org.exolab.castor.types.Date getDtDtAdminRvReqAppeal()
    {
        return this._dtDtAdminRvReqAppeal;
    } //-- org.exolab.castor.types.Date getDtDtAdminRvReqAppeal() 

    /**
     * Returns the value of field 'dtDtDeterminationLtr'.
     * 
     * @return the value of field 'DtDtDeterminationLtr'.
     */
    public org.exolab.castor.types.Date getDtDtDeterminationLtr()
    {
        return this._dtDtDeterminationLtr;
    } //-- org.exolab.castor.types.Date getDtDtDeterminationLtr() 

    /**
     * Returns the value of field 'ROWCCMN01UIG02_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN01UIG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY getROWCCMN01UIG02_ARRAY()
    {
        return this._ROWCCMN01UIG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY getROWCCMN01UIG02_ARRAY() 

    /**
     * Returns the value of field 'szCd1lvlAdminRsDisg'.
     * 
     * @return the value of field 'SzCd1lvlAdminRsDisg'.
     */
    public java.lang.String getSzCd1lvlAdminRsDisg()
    {
        return this._szCd1lvlAdminRsDisg;
    } //-- java.lang.String getSzCd1lvlAdminRsDisg() 

    /**
     * Returns the value of field 'szCd1lvlAdminRvDisp'.
     * 
     * @return the value of field 'SzCd1lvlAdminRvDisp'.
     */
    public java.lang.String getSzCd1lvlAdminRvDisp()
    {
        return this._szCd1lvlAdminRvDisp;
    } //-- java.lang.String getSzCd1lvlAdminRvDisp() 

    /**
     * Returns the value of field 'szCd2lvlAdminRsDisg'.
     * 
     * @return the value of field 'SzCd2lvlAdminRsDisg'.
     */
    public java.lang.String getSzCd2lvlAdminRsDisg()
    {
        return this._szCd2lvlAdminRsDisg;
    } //-- java.lang.String getSzCd2lvlAdminRsDisg() 

    /**
     * Returns the value of field 'szCd2lvlAdminRvDisp'.
     * 
     * @return the value of field 'SzCd2lvlAdminRvDisp'.
     */
    public java.lang.String getSzCd2lvlAdminRvDisp()
    {
        return this._szCd2lvlAdminRvDisp;
    } //-- java.lang.String getSzCd2lvlAdminRvDisp() 

    /**
     * Returns the value of field 'szCd2lvlAdminRvType'.
     * 
     * @return the value of field 'SzCd2lvlAdminRvType'.
     */
    public java.lang.String getSzCd2lvlAdminRvType()
    {
        return this._szCd2lvlAdminRvType;
    } //-- java.lang.String getSzCd2lvlAdminRvType() 

    /**
     * Returns the value of field 'szCd3lvlAdminRsDisg'.
     * 
     * @return the value of field 'SzCd3lvlAdminRsDisg'.
     */
    public java.lang.String getSzCd3lvlAdminRsDisg()
    {
        return this._szCd3lvlAdminRsDisg;
    } //-- java.lang.String getSzCd3lvlAdminRsDisg() 

    /**
     * Returns the value of field 'szCd3lvlAdminRvDisp'.
     * 
     * @return the value of field 'SzCd3lvlAdminRvDisp'.
     */
    public java.lang.String getSzCd3lvlAdminRvDisp()
    {
        return this._szCd3lvlAdminRvDisp;
    } //-- java.lang.String getSzCd3lvlAdminRvDisp() 

    /**
     * Returns the value of field 'szCd3lvlAdminRvFnDec'.
     * 
     * @return the value of field 'SzCd3lvlAdminRvFnDec'.
     */
    public java.lang.String getSzCd3lvlAdminRvFnDec()
    {
        return this._szCd3lvlAdminRvFnDec;
    } //-- java.lang.String getSzCd3lvlAdminRvFnDec() 

    /**
     * Returns the value of field 'szCdAdminRvAppealResult'.
     * 
     * @return the value of field 'SzCdAdminRvAppealResult'.
     */
    public java.lang.String getSzCdAdminRvAppealResult()
    {
        return this._szCdAdminRvAppealResult;
    } //-- java.lang.String getSzCdAdminRvAppealResult() 

    /**
     * Returns the value of field 'szCdAdminRvAppealType'.
     * 
     * @return the value of field 'SzCdAdminRvAppealType'.
     */
    public java.lang.String getSzCdAdminRvAppealType()
    {
        return this._szCdAdminRvAppealType;
    } //-- java.lang.String getSzCdAdminRvAppealType() 

    /**
     * Returns the value of field 'szCdAdminRvAuth'.
     * 
     * @return the value of field 'SzCdAdminRvAuth'.
     */
    public java.lang.String getSzCdAdminRvAuth()
    {
        return this._szCdAdminRvAuth;
    } //-- java.lang.String getSzCdAdminRvAuth() 

    /**
     * Returns the value of field 'szCdAdminRvIndLevel'.
     * 
     * @return the value of field 'SzCdAdminRvIndLevel'.
     */
    public java.lang.String getSzCdAdminRvIndLevel()
    {
        return this._szCdAdminRvIndLevel;
    } //-- java.lang.String getSzCdAdminRvIndLevel() 

    /**
     * Returns the value of field 'szCdAdminRvReqBy'.
     * 
     * @return the value of field 'SzCdAdminRvReqBy'.
     */
    public java.lang.String getSzCdAdminRvReqBy()
    {
        return this._szCdAdminRvReqBy;
    } //-- java.lang.String getSzCdAdminRvReqBy() 

    /**
     * Returns the value of field 'szCdAdminRvStatus'.
     * 
     * @return the value of field 'SzCdAdminRvStatus'.
     */
    public java.lang.String getSzCdAdminRvStatus()
    {
        return this._szCdAdminRvStatus;
    } //-- java.lang.String getSzCdAdminRvStatus() 

    /**
     * Returns the value of field 'szNmAdmRvPersonFullAmdComp'.
     * 
     * @return the value of field 'SzNmAdmRvPersonFullAmdComp'.
     */
    public java.lang.String getSzNmAdmRvPersonFullAmdComp()
    {
        return this._szNmAdmRvPersonFullAmdComp;
    } //-- java.lang.String getSzNmAdmRvPersonFullAmdComp() 

    /**
     * Returns the value of field 'szNmPersonFullAmdRev1lSME'.
     * 
     * @return the value of field 'SzNmPersonFullAmdRev1lSME'.
     */
    public java.lang.String getSzNmPersonFullAmdRev1lSME()
    {
        return this._szNmPersonFullAmdRev1lSME;
    } //-- java.lang.String getSzNmPersonFullAmdRev1lSME() 

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
     * Returns the value of field 'szScrNmReviewReqBy'.
     * 
     * @return the value of field 'SzScrNmReviewReqBy'.
     */
    public java.lang.String getSzScrNmReviewReqBy()
    {
        return this._szScrNmReviewReqBy;
    } //-- java.lang.String getSzScrNmReviewReqBy() 

    /**
     * Returns the value of field 'szTxt1lvlAdminRevResAppDen'.
     * 
     * @return the value of field 'SzTxt1lvlAdminRevResAppDen'.
     */
    public java.lang.String getSzTxt1lvlAdminRevResAppDen()
    {
        return this._szTxt1lvlAdminRevResAppDen;
    } //-- java.lang.String getSzTxt1lvlAdminRevResAppDen() 

    /**
     * Returns the value of field 'szTxt1lvlAdminRevResults'.
     * 
     * @return the value of field 'SzTxt1lvlAdminRevResults'.
     */
    public java.lang.String getSzTxt1lvlAdminRevResults()
    {
        return this._szTxt1lvlAdminRevResults;
    } //-- java.lang.String getSzTxt1lvlAdminRevResults() 

    /**
     * Returns the value of field 'szTxt2lvlAdminRevOff'.
     * 
     * @return the value of field 'SzTxt2lvlAdminRevOff'.
     */
    public java.lang.String getSzTxt2lvlAdminRevOff()
    {
        return this._szTxt2lvlAdminRevOff;
    } //-- java.lang.String getSzTxt2lvlAdminRevOff() 

    /**
     * Returns the value of field 'szTxt2lvlAdminRevResAppDen'.
     * 
     * @return the value of field 'SzTxt2lvlAdminRevResAppDen'.
     */
    public java.lang.String getSzTxt2lvlAdminRevResAppDen()
    {
        return this._szTxt2lvlAdminRevResAppDen;
    } //-- java.lang.String getSzTxt2lvlAdminRevResAppDen() 

    /**
     * Returns the value of field 'szTxt2lvlAdminRevResults'.
     * 
     * @return the value of field 'SzTxt2lvlAdminRevResults'.
     */
    public java.lang.String getSzTxt2lvlAdminRevResults()
    {
        return this._szTxt2lvlAdminRevResults;
    } //-- java.lang.String getSzTxt2lvlAdminRevResults() 

    /**
     * Returns the value of field 'szTxt3lvlAdminRevCommDes'.
     * 
     * @return the value of field 'SzTxt3lvlAdminRevCommDes'.
     */
    public java.lang.String getSzTxt3lvlAdminRevCommDes()
    {
        return this._szTxt3lvlAdminRevCommDes;
    } //-- java.lang.String getSzTxt3lvlAdminRevCommDes() 

    /**
     * Returns the value of field 'szTxt3lvlAdminRevCompDoc'.
     * 
     * @return the value of field 'SzTxt3lvlAdminRevCompDoc'.
     */
    public java.lang.String getSzTxt3lvlAdminRevCompDoc()
    {
        return this._szTxt3lvlAdminRevCompDoc;
    } //-- java.lang.String getSzTxt3lvlAdminRevCompDoc() 

    /**
     * Returns the value of field 'szTxt3lvlAdminRevResAppDen'.
     * 
     * @return the value of field 'SzTxt3lvlAdminRevResAppDen'.
     */
    public java.lang.String getSzTxt3lvlAdminRevResAppDen()
    {
        return this._szTxt3lvlAdminRevResAppDen;
    } //-- java.lang.String getSzTxt3lvlAdminRevResAppDen() 

    /**
     * Returns the value of field 'szTxt3lvlAdminRevResults'.
     * 
     * @return the value of field 'SzTxt3lvlAdminRevResults'.
     */
    public java.lang.String getSzTxt3lvlAdminRevResults()
    {
        return this._szTxt3lvlAdminRevResults;
    } //-- java.lang.String getSzTxt3lvlAdminRevResults() 

    /**
     * Returns the value of field 'sztxtAppealResult'.
     * 
     * @return the value of field 'SztxtAppealResult'.
     */
    public java.lang.String getSztxtAppealResult()
    {
        return this._sztxtAppealResult;
    } //-- java.lang.String getSztxtAppealResult() 

    /**
     * Returns the value of field 'sztxtRsnApprvDeny'.
     * 
     * @return the value of field 'SztxtRsnApprvDeny'.
     */
    public java.lang.String getSztxtRsnApprvDeny()
    {
        return this._sztxtRsnApprvDeny;
    } //-- java.lang.String getSztxtRsnApprvDeny() 

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
     * Returns the value of field 'ulAdmRev2lvlPriorStage'.
     * 
     * @return the value of field 'UlAdmRev2lvlPriorStage'.
     */
    public int getUlAdmRev2lvlPriorStage()
    {
        return this._ulAdmRev2lvlPriorStage;
    } //-- int getUlAdmRev2lvlPriorStage() 

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
     * Returns the value of field 'ulIdPersonRequestor'.
     * 
     * @return the value of field 'UlIdPersonRequestor'.
     */
    public int getUlIdPersonRequestor()
    {
        return this._ulIdPersonRequestor;
    } //-- int getUlIdPersonRequestor() 

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
     * Returns the value of field 'ulIdStageRelated'.
     * 
     * @return the value of field 'UlIdStageRelated'.
     */
    public int getUlIdStageRelated()
    {
        return this._ulIdStageRelated;
    } //-- int getUlIdStageRelated() 

    /**
     * Method hasUlAdmRev2lvlPriorStage
     * 
     * 
     * 
     * @return true if at least one UlAdmRev2lvlPriorStage has been
     * added
     */
    public boolean hasUlAdmRev2lvlPriorStage()
    {
        return this._has_ulAdmRev2lvlPriorStage;
    } //-- boolean hasUlAdmRev2lvlPriorStage() 

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
     * Method hasUlIdPersonRequestor
     * 
     * 
     * 
     * @return true if at least one UlIdPersonRequestor has been
     * added
     */
    public boolean hasUlIdPersonRequestor()
    {
        return this._has_ulIdPersonRequestor;
    } //-- boolean hasUlIdPersonRequestor() 

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
     * Method hasUlIdStageRelated
     * 
     * 
     * 
     * @return true if at least one UlIdStageRelated has been added
     */
    public boolean hasUlIdStageRelated()
    {
        return this._has_ulIdStageRelated;
    } //-- boolean hasUlIdStageRelated() 

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
     * Sets the value of field 'bInd1lvlAdmRv21lvlStag'.
     * 
     * @param bInd1lvlAdmRv21lvlStag the value of field
     * 'bInd1lvlAdmRv21lvlStag'.
     */
    public void setBInd1lvlAdmRv21lvlStag(java.lang.String bInd1lvlAdmRv21lvlStag)
    {
        this._bInd1lvlAdmRv21lvlStag = bInd1lvlAdmRv21lvlStag;
    } //-- void setBInd1lvlAdmRv21lvlStag(java.lang.String) 

    /**
     * Sets the value of field 'bInd1lvlLglRepresentation'.
     * 
     * @param bInd1lvlLglRepresentation the value of field
     * 'bInd1lvlLglRepresentation'.
     */
    public void setBInd1lvlLglRepresentation(java.lang.String bInd1lvlLglRepresentation)
    {
        this._bInd1lvlLglRepresentation = bInd1lvlLglRepresentation;
    } //-- void setBInd1lvlLglRepresentation(java.lang.String) 

    /**
     * Sets the value of field 'bInd1lvlSaagNotification'.
     * 
     * @param bInd1lvlSaagNotification the value of field
     * 'bInd1lvlSaagNotification'.
     */
    public void setBInd1lvlSaagNotification(java.lang.String bInd1lvlSaagNotification)
    {
        this._bInd1lvlSaagNotification = bInd1lvlSaagNotification;
    } //-- void setBInd1lvlSaagNotification(java.lang.String) 

    /**
     * Sets the value of field 'bInd2lvlAdmRvComp'.
     * 
     * @param bInd2lvlAdmRvComp the value of field
     * 'bInd2lvlAdmRvComp'.
     */
    public void setBInd2lvlAdmRvComp(java.lang.String bInd2lvlAdmRvComp)
    {
        this._bInd2lvlAdmRvComp = bInd2lvlAdmRvComp;
    } //-- void setBInd2lvlAdmRvComp(java.lang.String) 

    /**
     * Sets the value of field 'bInd2lvlLglRepresentation'.
     * 
     * @param bInd2lvlLglRepresentation the value of field
     * 'bInd2lvlLglRepresentation'.
     */
    public void setBInd2lvlLglRepresentation(java.lang.String bInd2lvlLglRepresentation)
    {
        this._bInd2lvlLglRepresentation = bInd2lvlLglRepresentation;
    } //-- void setBInd2lvlLglRepresentation(java.lang.String) 

    /**
     * Sets the value of field 'bInd2lvlSaagNotification'.
     * 
     * @param bInd2lvlSaagNotification the value of field
     * 'bInd2lvlSaagNotification'.
     */
    public void setBInd2lvlSaagNotification(java.lang.String bInd2lvlSaagNotification)
    {
        this._bInd2lvlSaagNotification = bInd2lvlSaagNotification;
    } //-- void setBInd2lvlSaagNotification(java.lang.String) 

    /**
     * Sets the value of field 'bIndLglRepresentation'.
     * 
     * @param bIndLglRepresentation the value of field
     * 'bIndLglRepresentation'.
     */
    public void setBIndLglRepresentation(java.lang.String bIndLglRepresentation)
    {
        this._bIndLglRepresentation = bIndLglRepresentation;
    } //-- void setBIndLglRepresentation(java.lang.String) 

    /**
     * Sets the value of field 'bIndSaagNotification'.
     * 
     * @param bIndSaagNotification the value of field
     * 'bIndSaagNotification'.
     */
    public void setBIndSaagNotification(java.lang.String bIndSaagNotification)
    {
        this._bIndSaagNotification = bIndSaagNotification;
    } //-- void setBIndSaagNotification(java.lang.String) 

    /**
     * Sets the value of field 'cIndAdminRvEmgcyRel'.
     * 
     * @param cIndAdminRvEmgcyRel the value of field
     * 'cIndAdminRvEmgcyRel'.
     */
    public void setCIndAdminRvEmgcyRel(java.lang.String cIndAdminRvEmgcyRel)
    {
        this._cIndAdminRvEmgcyRel = cIndAdminRvEmgcyRel;
    } //-- void setCIndAdminRvEmgcyRel(java.lang.String) 

    /**
     * Sets the value of field 'dtDt1lvlAdminRvAppealNotif'.
     * 
     * @param dtDt1lvlAdminRvAppealNotif the value of field
     * 'dtDt1lvlAdminRvAppealNotif'.
     */
    public void setDtDt1lvlAdminRvAppealNotif(org.exolab.castor.types.Date dtDt1lvlAdminRvAppealNotif)
    {
        this._dtDt1lvlAdminRvAppealNotif = dtDt1lvlAdminRvAppealNotif;
    } //-- void setDtDt1lvlAdminRvAppealNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt1lvlAdminRvAppealReview'.
     * 
     * @param dtDt1lvlAdminRvAppealReview the value of field
     * 'dtDt1lvlAdminRvAppealReview'.
     */
    public void setDtDt1lvlAdminRvAppealReview(org.exolab.castor.types.Date dtDt1lvlAdminRvAppealReview)
    {
        this._dtDt1lvlAdminRvAppealReview = dtDt1lvlAdminRvAppealReview;
    } //-- void setDtDt1lvlAdminRvAppealReview(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt1lvlAdminRvDue'.
     * 
     * @param dtDt1lvlAdminRvDue the value of field
     * 'dtDt1lvlAdminRvDue'.
     */
    public void setDtDt1lvlAdminRvDue(org.exolab.castor.types.Date dtDt1lvlAdminRvDue)
    {
        this._dtDt1lvlAdminRvDue = dtDt1lvlAdminRvDue;
    } //-- void setDtDt1lvlAdminRvDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt1lvlAdminRvPersonNotif'.
     * 
     * @param dtDt1lvlAdminRvPersonNotif the value of field
     * 'dtDt1lvlAdminRvPersonNotif'.
     */
    public void setDtDt1lvlAdminRvPersonNotif(org.exolab.castor.types.Date dtDt1lvlAdminRvPersonNotif)
    {
        this._dtDt1lvlAdminRvPersonNotif = dtDt1lvlAdminRvPersonNotif;
    } //-- void setDtDt1lvlAdminRvPersonNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt1lvlAdminRvReqAppeal'.
     * 
     * @param dtDt1lvlAdminRvReqAppeal the value of field
     * 'dtDt1lvlAdminRvReqAppeal'.
     */
    public void setDtDt1lvlAdminRvReqAppeal(org.exolab.castor.types.Date dtDt1lvlAdminRvReqAppeal)
    {
        this._dtDt1lvlAdminRvReqAppeal = dtDt1lvlAdminRvReqAppeal;
    } //-- void setDtDt1lvlAdminRvReqAppeal(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt1lvlDeterminationLtr'.
     * 
     * @param dtDt1lvlDeterminationLtr the value of field
     * 'dtDt1lvlDeterminationLtr'.
     */
    public void setDtDt1lvlDeterminationLtr(org.exolab.castor.types.Date dtDt1lvlDeterminationLtr)
    {
        this._dtDt1lvlDeterminationLtr = dtDt1lvlDeterminationLtr;
    } //-- void setDtDt1lvlDeterminationLtr(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt2lvlAdmRvDecLtr'.
     * 
     * @param dtDt2lvlAdmRvDecLtr the value of field
     * 'dtDt2lvlAdmRvDecLtr'.
     */
    public void setDtDt2lvlAdmRvDecLtr(org.exolab.castor.types.Date dtDt2lvlAdmRvDecLtr)
    {
        this._dtDt2lvlAdmRvDecLtr = dtDt2lvlAdmRvDecLtr;
    } //-- void setDtDt2lvlAdmRvDecLtr(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt2lvlAdminRvAppealNotif'.
     * 
     * @param dtDt2lvlAdminRvAppealNotif the value of field
     * 'dtDt2lvlAdminRvAppealNotif'.
     */
    public void setDtDt2lvlAdminRvAppealNotif(org.exolab.castor.types.Date dtDt2lvlAdminRvAppealNotif)
    {
        this._dtDt2lvlAdminRvAppealNotif = dtDt2lvlAdminRvAppealNotif;
    } //-- void setDtDt2lvlAdminRvAppealNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt2lvlAdminRvAppealReview'.
     * 
     * @param dtDt2lvlAdminRvAppealReview the value of field
     * 'dtDt2lvlAdminRvAppealReview'.
     */
    public void setDtDt2lvlAdminRvAppealReview(org.exolab.castor.types.Date dtDt2lvlAdminRvAppealReview)
    {
        this._dtDt2lvlAdminRvAppealReview = dtDt2lvlAdminRvAppealReview;
    } //-- void setDtDt2lvlAdminRvAppealReview(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt2lvlAdminRvDue'.
     * 
     * @param dtDt2lvlAdminRvDue the value of field
     * 'dtDt2lvlAdminRvDue'.
     */
    public void setDtDt2lvlAdminRvDue(org.exolab.castor.types.Date dtDt2lvlAdminRvDue)
    {
        this._dtDt2lvlAdminRvDue = dtDt2lvlAdminRvDue;
    } //-- void setDtDt2lvlAdminRvDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt2lvlAdminRvPersonNotif'.
     * 
     * @param dtDt2lvlAdminRvPersonNotif the value of field
     * 'dtDt2lvlAdminRvPersonNotif'.
     */
    public void setDtDt2lvlAdminRvPersonNotif(org.exolab.castor.types.Date dtDt2lvlAdminRvPersonNotif)
    {
        this._dtDt2lvlAdminRvPersonNotif = dtDt2lvlAdminRvPersonNotif;
    } //-- void setDtDt2lvlAdminRvPersonNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt2lvlAdminRvReqAppeal'.
     * 
     * @param dtDt2lvlAdminRvReqAppeal the value of field
     * 'dtDt2lvlAdminRvReqAppeal'.
     */
    public void setDtDt2lvlAdminRvReqAppeal(org.exolab.castor.types.Date dtDt2lvlAdminRvReqAppeal)
    {
        this._dtDt2lvlAdminRvReqAppeal = dtDt2lvlAdminRvReqAppeal;
    } //-- void setDtDt2lvlAdminRvReqAppeal(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt2lvlAdminRvReqIntrv'.
     * 
     * @param dtDt2lvlAdminRvReqIntrv the value of field
     * 'dtDt2lvlAdminRvReqIntrv'.
     */
    public void setDtDt2lvlAdminRvReqIntrv(org.exolab.castor.types.Date dtDt2lvlAdminRvReqIntrv)
    {
        this._dtDt2lvlAdminRvReqIntrv = dtDt2lvlAdminRvReqIntrv;
    } //-- void setDtDt2lvlAdminRvReqIntrv(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt3lvlAdmRvDecLtr'.
     * 
     * @param dtDt3lvlAdmRvDecLtr the value of field
     * 'dtDt3lvlAdmRvDecLtr'.
     */
    public void setDtDt3lvlAdmRvDecLtr(org.exolab.castor.types.Date dtDt3lvlAdmRvDecLtr)
    {
        this._dtDt3lvlAdmRvDecLtr = dtDt3lvlAdmRvDecLtr;
    } //-- void setDtDt3lvlAdmRvDecLtr(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt3lvlAdminRvAppealReview'.
     * 
     * @param dtDt3lvlAdminRvAppealReview the value of field
     * 'dtDt3lvlAdminRvAppealReview'.
     */
    public void setDtDt3lvlAdminRvAppealReview(org.exolab.castor.types.Date dtDt3lvlAdminRvAppealReview)
    {
        this._dtDt3lvlAdminRvAppealReview = dtDt3lvlAdminRvAppealReview;
    } //-- void setDtDt3lvlAdminRvAppealReview(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt3lvlAdminRvDue'.
     * 
     * @param dtDt3lvlAdminRvDue the value of field
     * 'dtDt3lvlAdminRvDue'.
     */
    public void setDtDt3lvlAdminRvDue(org.exolab.castor.types.Date dtDt3lvlAdminRvDue)
    {
        this._dtDt3lvlAdminRvDue = dtDt3lvlAdminRvDue;
    } //-- void setDtDt3lvlAdminRvDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDt3lvlAdminRvPersonNotif'.
     * 
     * @param dtDt3lvlAdminRvPersonNotif the value of field
     * 'dtDt3lvlAdminRvPersonNotif'.
     */
    public void setDtDt3lvlAdminRvPersonNotif(org.exolab.castor.types.Date dtDt3lvlAdminRvPersonNotif)
    {
        this._dtDt3lvlAdminRvPersonNotif = dtDt3lvlAdminRvPersonNotif;
    } //-- void setDtDt3lvlAdminRvPersonNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdminRvAppealNotif'.
     * 
     * @param dtDtAdminRvAppealNotif the value of field
     * 'dtDtAdminRvAppealNotif'.
     */
    public void setDtDtAdminRvAppealNotif(org.exolab.castor.types.Date dtDtAdminRvAppealNotif)
    {
        this._dtDtAdminRvAppealNotif = dtDtAdminRvAppealNotif;
    } //-- void setDtDtAdminRvAppealNotif(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdminRvAppealReview'.
     * 
     * @param dtDtAdminRvAppealReview the value of field
     * 'dtDtAdminRvAppealReview'.
     */
    public void setDtDtAdminRvAppealReview(org.exolab.castor.types.Date dtDtAdminRvAppealReview)
    {
        this._dtDtAdminRvAppealReview = dtDtAdminRvAppealReview;
    } //-- void setDtDtAdminRvAppealReview(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdminRvDue'.
     * 
     * @param dtDtAdminRvDue the value of field 'dtDtAdminRvDue'.
     */
    public void setDtDtAdminRvDue(org.exolab.castor.types.Date dtDtAdminRvDue)
    {
        this._dtDtAdminRvDue = dtDtAdminRvDue;
    } //-- void setDtDtAdminRvDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdminRvEmgcyRel'.
     * 
     * @param dtDtAdminRvEmgcyRel the value of field
     * 'dtDtAdminRvEmgcyRel'.
     */
    public void setDtDtAdminRvEmgcyRel(org.exolab.castor.types.Date dtDtAdminRvEmgcyRel)
    {
        this._dtDtAdminRvEmgcyRel = dtDtAdminRvEmgcyRel;
    } //-- void setDtDtAdminRvEmgcyRel(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdminRvHearing'.
     * 
     * @param dtDtAdminRvHearing the value of field
     * 'dtDtAdminRvHearing'.
     */
    public void setDtDtAdminRvHearing(org.exolab.castor.types.Date dtDtAdminRvHearing)
    {
        this._dtDtAdminRvHearing = dtDtAdminRvHearing;
    } //-- void setDtDtAdminRvHearing(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtAdminRvReqAppeal'.
     * 
     * @param dtDtAdminRvReqAppeal the value of field
     * 'dtDtAdminRvReqAppeal'.
     */
    public void setDtDtAdminRvReqAppeal(org.exolab.castor.types.Date dtDtAdminRvReqAppeal)
    {
        this._dtDtAdminRvReqAppeal = dtDtAdminRvReqAppeal;
    } //-- void setDtDtAdminRvReqAppeal(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtDeterminationLtr'.
     * 
     * @param dtDtDeterminationLtr the value of field
     * 'dtDtDeterminationLtr'.
     */
    public void setDtDtDeterminationLtr(org.exolab.castor.types.Date dtDtDeterminationLtr)
    {
        this._dtDtDeterminationLtr = dtDtDeterminationLtr;
    } //-- void setDtDtDeterminationLtr(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN01UIG02_ARRAY'.
     * 
     * @param ROWCCMN01UIG02_ARRAY the value of field
     * 'ROWCCMN01UIG02_ARRAY'.
     */
    public void setROWCCMN01UIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY ROWCCMN01UIG02_ARRAY)
    {
        this._ROWCCMN01UIG02_ARRAY = ROWCCMN01UIG02_ARRAY;
    } //-- void setROWCCMN01UIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY) 

    /**
     * Sets the value of field 'szCd1lvlAdminRsDisg'.
     * 
     * @param szCd1lvlAdminRsDisg the value of field
     * 'szCd1lvlAdminRsDisg'.
     */
    public void setSzCd1lvlAdminRsDisg(java.lang.String szCd1lvlAdminRsDisg)
    {
        this._szCd1lvlAdminRsDisg = szCd1lvlAdminRsDisg;
    } //-- void setSzCd1lvlAdminRsDisg(java.lang.String) 

    /**
     * Sets the value of field 'szCd1lvlAdminRvDisp'.
     * 
     * @param szCd1lvlAdminRvDisp the value of field
     * 'szCd1lvlAdminRvDisp'.
     */
    public void setSzCd1lvlAdminRvDisp(java.lang.String szCd1lvlAdminRvDisp)
    {
        this._szCd1lvlAdminRvDisp = szCd1lvlAdminRvDisp;
    } //-- void setSzCd1lvlAdminRvDisp(java.lang.String) 

    /**
     * Sets the value of field 'szCd2lvlAdminRsDisg'.
     * 
     * @param szCd2lvlAdminRsDisg the value of field
     * 'szCd2lvlAdminRsDisg'.
     */
    public void setSzCd2lvlAdminRsDisg(java.lang.String szCd2lvlAdminRsDisg)
    {
        this._szCd2lvlAdminRsDisg = szCd2lvlAdminRsDisg;
    } //-- void setSzCd2lvlAdminRsDisg(java.lang.String) 

    /**
     * Sets the value of field 'szCd2lvlAdminRvDisp'.
     * 
     * @param szCd2lvlAdminRvDisp the value of field
     * 'szCd2lvlAdminRvDisp'.
     */
    public void setSzCd2lvlAdminRvDisp(java.lang.String szCd2lvlAdminRvDisp)
    {
        this._szCd2lvlAdminRvDisp = szCd2lvlAdminRvDisp;
    } //-- void setSzCd2lvlAdminRvDisp(java.lang.String) 

    /**
     * Sets the value of field 'szCd2lvlAdminRvType'.
     * 
     * @param szCd2lvlAdminRvType the value of field
     * 'szCd2lvlAdminRvType'.
     */
    public void setSzCd2lvlAdminRvType(java.lang.String szCd2lvlAdminRvType)
    {
        this._szCd2lvlAdminRvType = szCd2lvlAdminRvType;
    } //-- void setSzCd2lvlAdminRvType(java.lang.String) 

    /**
     * Sets the value of field 'szCd3lvlAdminRsDisg'.
     * 
     * @param szCd3lvlAdminRsDisg the value of field
     * 'szCd3lvlAdminRsDisg'.
     */
    public void setSzCd3lvlAdminRsDisg(java.lang.String szCd3lvlAdminRsDisg)
    {
        this._szCd3lvlAdminRsDisg = szCd3lvlAdminRsDisg;
    } //-- void setSzCd3lvlAdminRsDisg(java.lang.String) 

    /**
     * Sets the value of field 'szCd3lvlAdminRvDisp'.
     * 
     * @param szCd3lvlAdminRvDisp the value of field
     * 'szCd3lvlAdminRvDisp'.
     */
    public void setSzCd3lvlAdminRvDisp(java.lang.String szCd3lvlAdminRvDisp)
    {
        this._szCd3lvlAdminRvDisp = szCd3lvlAdminRvDisp;
    } //-- void setSzCd3lvlAdminRvDisp(java.lang.String) 

    /**
     * Sets the value of field 'szCd3lvlAdminRvFnDec'.
     * 
     * @param szCd3lvlAdminRvFnDec the value of field
     * 'szCd3lvlAdminRvFnDec'.
     */
    public void setSzCd3lvlAdminRvFnDec(java.lang.String szCd3lvlAdminRvFnDec)
    {
        this._szCd3lvlAdminRvFnDec = szCd3lvlAdminRvFnDec;
    } //-- void setSzCd3lvlAdminRvFnDec(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdminRvAppealResult'.
     * 
     * @param szCdAdminRvAppealResult the value of field
     * 'szCdAdminRvAppealResult'.
     */
    public void setSzCdAdminRvAppealResult(java.lang.String szCdAdminRvAppealResult)
    {
        this._szCdAdminRvAppealResult = szCdAdminRvAppealResult;
    } //-- void setSzCdAdminRvAppealResult(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdminRvAppealType'.
     * 
     * @param szCdAdminRvAppealType the value of field
     * 'szCdAdminRvAppealType'.
     */
    public void setSzCdAdminRvAppealType(java.lang.String szCdAdminRvAppealType)
    {
        this._szCdAdminRvAppealType = szCdAdminRvAppealType;
    } //-- void setSzCdAdminRvAppealType(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdminRvAuth'.
     * 
     * @param szCdAdminRvAuth the value of field 'szCdAdminRvAuth'.
     */
    public void setSzCdAdminRvAuth(java.lang.String szCdAdminRvAuth)
    {
        this._szCdAdminRvAuth = szCdAdminRvAuth;
    } //-- void setSzCdAdminRvAuth(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdminRvIndLevel'.
     * 
     * @param szCdAdminRvIndLevel the value of field
     * 'szCdAdminRvIndLevel'.
     */
    public void setSzCdAdminRvIndLevel(java.lang.String szCdAdminRvIndLevel)
    {
        this._szCdAdminRvIndLevel = szCdAdminRvIndLevel;
    } //-- void setSzCdAdminRvIndLevel(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdminRvReqBy'.
     * 
     * @param szCdAdminRvReqBy the value of field 'szCdAdminRvReqBy'
     */
    public void setSzCdAdminRvReqBy(java.lang.String szCdAdminRvReqBy)
    {
        this._szCdAdminRvReqBy = szCdAdminRvReqBy;
    } //-- void setSzCdAdminRvReqBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdAdminRvStatus'.
     * 
     * @param szCdAdminRvStatus the value of field
     * 'szCdAdminRvStatus'.
     */
    public void setSzCdAdminRvStatus(java.lang.String szCdAdminRvStatus)
    {
        this._szCdAdminRvStatus = szCdAdminRvStatus;
    } //-- void setSzCdAdminRvStatus(java.lang.String) 

    /**
     * Sets the value of field 'szNmAdmRvPersonFullAmdComp'.
     * 
     * @param szNmAdmRvPersonFullAmdComp the value of field
     * 'szNmAdmRvPersonFullAmdComp'.
     */
    public void setSzNmAdmRvPersonFullAmdComp(java.lang.String szNmAdmRvPersonFullAmdComp)
    {
        this._szNmAdmRvPersonFullAmdComp = szNmAdmRvPersonFullAmdComp;
    } //-- void setSzNmAdmRvPersonFullAmdComp(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFullAmdRev1lSME'.
     * 
     * @param szNmPersonFullAmdRev1lSME the value of field
     * 'szNmPersonFullAmdRev1lSME'.
     */
    public void setSzNmPersonFullAmdRev1lSME(java.lang.String szNmPersonFullAmdRev1lSME)
    {
        this._szNmPersonFullAmdRev1lSME = szNmPersonFullAmdRev1lSME;
    } //-- void setSzNmPersonFullAmdRev1lSME(java.lang.String) 

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
     * Sets the value of field 'szScrNmReviewReqBy'.
     * 
     * @param szScrNmReviewReqBy the value of field
     * 'szScrNmReviewReqBy'.
     */
    public void setSzScrNmReviewReqBy(java.lang.String szScrNmReviewReqBy)
    {
        this._szScrNmReviewReqBy = szScrNmReviewReqBy;
    } //-- void setSzScrNmReviewReqBy(java.lang.String) 

    /**
     * Sets the value of field 'szTxt1lvlAdminRevResAppDen'.
     * 
     * @param szTxt1lvlAdminRevResAppDen the value of field
     * 'szTxt1lvlAdminRevResAppDen'.
     */
    public void setSzTxt1lvlAdminRevResAppDen(java.lang.String szTxt1lvlAdminRevResAppDen)
    {
        this._szTxt1lvlAdminRevResAppDen = szTxt1lvlAdminRevResAppDen;
    } //-- void setSzTxt1lvlAdminRevResAppDen(java.lang.String) 

    /**
     * Sets the value of field 'szTxt1lvlAdminRevResults'.
     * 
     * @param szTxt1lvlAdminRevResults the value of field
     * 'szTxt1lvlAdminRevResults'.
     */
    public void setSzTxt1lvlAdminRevResults(java.lang.String szTxt1lvlAdminRevResults)
    {
        this._szTxt1lvlAdminRevResults = szTxt1lvlAdminRevResults;
    } //-- void setSzTxt1lvlAdminRevResults(java.lang.String) 

    /**
     * Sets the value of field 'szTxt2lvlAdminRevOff'.
     * 
     * @param szTxt2lvlAdminRevOff the value of field
     * 'szTxt2lvlAdminRevOff'.
     */
    public void setSzTxt2lvlAdminRevOff(java.lang.String szTxt2lvlAdminRevOff)
    {
        this._szTxt2lvlAdminRevOff = szTxt2lvlAdminRevOff;
    } //-- void setSzTxt2lvlAdminRevOff(java.lang.String) 

    /**
     * Sets the value of field 'szTxt2lvlAdminRevResAppDen'.
     * 
     * @param szTxt2lvlAdminRevResAppDen the value of field
     * 'szTxt2lvlAdminRevResAppDen'.
     */
    public void setSzTxt2lvlAdminRevResAppDen(java.lang.String szTxt2lvlAdminRevResAppDen)
    {
        this._szTxt2lvlAdminRevResAppDen = szTxt2lvlAdminRevResAppDen;
    } //-- void setSzTxt2lvlAdminRevResAppDen(java.lang.String) 

    /**
     * Sets the value of field 'szTxt2lvlAdminRevResults'.
     * 
     * @param szTxt2lvlAdminRevResults the value of field
     * 'szTxt2lvlAdminRevResults'.
     */
    public void setSzTxt2lvlAdminRevResults(java.lang.String szTxt2lvlAdminRevResults)
    {
        this._szTxt2lvlAdminRevResults = szTxt2lvlAdminRevResults;
    } //-- void setSzTxt2lvlAdminRevResults(java.lang.String) 

    /**
     * Sets the value of field 'szTxt3lvlAdminRevCommDes'.
     * 
     * @param szTxt3lvlAdminRevCommDes the value of field
     * 'szTxt3lvlAdminRevCommDes'.
     */
    public void setSzTxt3lvlAdminRevCommDes(java.lang.String szTxt3lvlAdminRevCommDes)
    {
        this._szTxt3lvlAdminRevCommDes = szTxt3lvlAdminRevCommDes;
    } //-- void setSzTxt3lvlAdminRevCommDes(java.lang.String) 

    /**
     * Sets the value of field 'szTxt3lvlAdminRevCompDoc'.
     * 
     * @param szTxt3lvlAdminRevCompDoc the value of field
     * 'szTxt3lvlAdminRevCompDoc'.
     */
    public void setSzTxt3lvlAdminRevCompDoc(java.lang.String szTxt3lvlAdminRevCompDoc)
    {
        this._szTxt3lvlAdminRevCompDoc = szTxt3lvlAdminRevCompDoc;
    } //-- void setSzTxt3lvlAdminRevCompDoc(java.lang.String) 

    /**
     * Sets the value of field 'szTxt3lvlAdminRevResAppDen'.
     * 
     * @param szTxt3lvlAdminRevResAppDen the value of field
     * 'szTxt3lvlAdminRevResAppDen'.
     */
    public void setSzTxt3lvlAdminRevResAppDen(java.lang.String szTxt3lvlAdminRevResAppDen)
    {
        this._szTxt3lvlAdminRevResAppDen = szTxt3lvlAdminRevResAppDen;
    } //-- void setSzTxt3lvlAdminRevResAppDen(java.lang.String) 

    /**
     * Sets the value of field 'szTxt3lvlAdminRevResults'.
     * 
     * @param szTxt3lvlAdminRevResults the value of field
     * 'szTxt3lvlAdminRevResults'.
     */
    public void setSzTxt3lvlAdminRevResults(java.lang.String szTxt3lvlAdminRevResults)
    {
        this._szTxt3lvlAdminRevResults = szTxt3lvlAdminRevResults;
    } //-- void setSzTxt3lvlAdminRevResults(java.lang.String) 

    /**
     * Sets the value of field 'sztxtAppealResult'.
     * 
     * @param sztxtAppealResult the value of field
     * 'sztxtAppealResult'.
     */
    public void setSztxtAppealResult(java.lang.String sztxtAppealResult)
    {
        this._sztxtAppealResult = sztxtAppealResult;
    } //-- void setSztxtAppealResult(java.lang.String) 

    /**
     * Sets the value of field 'sztxtRsnApprvDeny'.
     * 
     * @param sztxtRsnApprvDeny the value of field
     * 'sztxtRsnApprvDeny'.
     */
    public void setSztxtRsnApprvDeny(java.lang.String sztxtRsnApprvDeny)
    {
        this._sztxtRsnApprvDeny = sztxtRsnApprvDeny;
    } //-- void setSztxtRsnApprvDeny(java.lang.String) 

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
     * Sets the value of field 'ulAdmRev2lvlPriorStage'.
     * 
     * @param ulAdmRev2lvlPriorStage the value of field
     * 'ulAdmRev2lvlPriorStage'.
     */
    public void setUlAdmRev2lvlPriorStage(int ulAdmRev2lvlPriorStage)
    {
        this._ulAdmRev2lvlPriorStage = ulAdmRev2lvlPriorStage;
        this._has_ulAdmRev2lvlPriorStage = true;
    } //-- void setUlAdmRev2lvlPriorStage(int) 

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
     * Sets the value of field 'ulIdPersonRequestor'.
     * 
     * @param ulIdPersonRequestor the value of field
     * 'ulIdPersonRequestor'.
     */
    public void setUlIdPersonRequestor(int ulIdPersonRequestor)
    {
        this._ulIdPersonRequestor = ulIdPersonRequestor;
        this._has_ulIdPersonRequestor = true;
    } //-- void setUlIdPersonRequestor(int) 

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
     * Sets the value of field 'ulIdStageRelated'.
     * 
     * @param ulIdStageRelated the value of field 'ulIdStageRelated'
     */
    public void setUlIdStageRelated(int ulIdStageRelated)
    {
        this._ulIdStageRelated = ulIdStageRelated;
        this._has_ulIdStageRelated = true;
    } //-- void setUlIdStageRelated(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00 unmarshal(java.io.Reader) 

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
