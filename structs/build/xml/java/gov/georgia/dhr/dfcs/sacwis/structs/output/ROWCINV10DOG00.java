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
 * Class ROWCINV10DOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV10DOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cIndPolicyViolation
     */
    private java.lang.String _cIndPolicyViolation;

    /**
     * Field _dtDtCPSInvstDtlAssigned
     */
    private org.exolab.castor.types.Date _dtDtCPSInvstDtlAssigned;

    /**
     * Field _ulIdPriorStage
     */
    private int _ulIdPriorStage;

    /**
     * keeps track of state for field: _ulIdPriorStage
     */
    private boolean _has_ulIdPriorStage;

    /**
     * Field _dtDtCPSInvstDtlBegun
     */
    private org.exolab.castor.types.Date _dtDtCPSInvstDtlBegun;

    /**
     * Field _dtDtDetermLetterSent
     */
    private org.exolab.castor.types.Date _dtDtDetermLetterSent;

    /**
     * Field _dtDtCpsInvstDtlComplt
     */
    private org.exolab.castor.types.Date _dtDtCpsInvstDtlComplt;

    /**
     * Field _dtDtCPSInvstDtlIntake
     */
    private java.util.Date _dtDtCPSInvstDtlIntake;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdCpsInvstDtlFamIncm
     */
    private java.lang.String _szCdCpsInvstDtlFamIncm;

    /**
     * Field _cdCpsOverallDisptn
     */
    private java.lang.String _cdCpsOverallDisptn;

    /**
     * Field _cIndCpsInvstDtlRaNa
     */
    private java.lang.String _cIndCpsInvstDtlRaNa;

    /**
     * Field _bIndCpsInvstSafetyPln
     */
    private java.lang.String _bIndCpsInvstSafetyPln;

    /**
     * Field _bIndCpsInvstEaConcl
     */
    private java.lang.String _bIndCpsInvstEaConcl;

    /**
     * Field _bIndCpsInvstCpsLeJointContact
     */
    private java.lang.String _bIndCpsInvstCpsLeJointContact;

    /**
     * Field _szCdCpsInvstCpsLeJointContact
     */
    private java.lang.String _szCdCpsInvstCpsLeJointContact;

    /**
     * Field _szTxtCpsInvstCpsLeJointContact
     */
    private java.lang.String _szTxtCpsInvstCpsLeJointContact;

    /**
     * Field _bIndVictimTaped
     */
    private java.lang.String _bIndVictimTaped;

    /**
     * Field _szCdVictimTaped
     */
    private java.lang.String _szCdVictimTaped;

    /**
     * Field _szTxtVictimTaped
     */
    private java.lang.String _szTxtVictimTaped;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _cIndCpsInvstAbbrv
     */
    private java.lang.String _cIndCpsInvstAbbrv;

    /**
     * Field _szCdStageRiskFinding
     */
    private java.lang.String _szCdStageRiskFinding;

    /**
     * Field _szCdStageLvlOfRisk
     */
    private java.lang.String _szCdStageLvlOfRisk;

    /**
     * Field _szTxtOvrllCaseDisptn
     */
    private java.lang.String _szTxtOvrllCaseDisptn;

    /**
     * Field _dtDtOverride
     */
    private org.exolab.castor.types.Date _dtDtOverride;

    /**
     * Field _szCdOverrideOverllFind
     */
    private java.lang.String _szCdOverrideOverllFind;

    /**
     * Field _szCdOverrideRiskLvl
     */
    private java.lang.String _szCdOverrideRiskLvl;

    /**
     * Field _szTxtOverrideComments
     */
    private java.lang.String _szTxtOverrideComments;

    /**
     * Field _cdFamviol01
     */
    private java.lang.String _cdFamviol01;

    /**
     * Field _cdFamviol02
     */
    private java.lang.String _cdFamviol02;

    /**
     * Field _cdFamviol03
     */
    private java.lang.String _cdFamviol03;

    /**
     * Field _cdFamviol04
     */
    private java.lang.String _cdFamviol04;

    /**
     * Field _cdFamviol05
     */
    private java.lang.String _cdFamviol05;

    /**
     * Field _cdAbuseStatus
     */
    private java.lang.String _cdAbuseStatus;

    /**
     * Field _cdAbuseType01
     */
    private java.lang.String _cdAbuseType01;

    /**
     * Field _cdAbuseType02
     */
    private java.lang.String _cdAbuseType02;

    /**
     * Field _cdAbuseType03
     */
    private java.lang.String _cdAbuseType03;

    /**
     * Field _cdAbuseType04
     */
    private java.lang.String _cdAbuseType04;

    /**
     * Field _cdAbuseType05
     */
    private java.lang.String _cdAbuseType05;

    /**
     * Field _cdAbuseType06
     */
    private java.lang.String _cdAbuseType06;

    /**
     * Field _cdAbuseType07
     */
    private java.lang.String _cdAbuseType07;

    /**
     * Field _cdMaltreatLoc
     */
    private java.lang.String _cdMaltreatLoc;

    /**
     * Field _cIndSpeInvstPlaceProv
     */
    private java.lang.String _cIndSpeInvstPlaceProv;

    /**
     * Field _cIndInvMaltreatInCare
     */
    private java.lang.String _cIndInvMaltreatInCare;

    /**
     * Field _cIndUnsubMIC
     */
    private java.lang.String _cIndUnsubMIC;

    /**
     * Field _cIndFostPrntNotified
     */
    private java.lang.String _cIndFostPrntNotified;

    /**
     * Field _szTxtFostPrntNotifyCmnts
     */
    private java.lang.String _szTxtFostPrntNotifyCmnts;

    /**
     * Field _dtDtFostPrntNotified
     */
    private org.exolab.castor.types.Date _dtDtFostPrntNotified;

    /**
     * Field _cIndStOffNotifyRmvChild
     */
    private java.lang.String _cIndStOffNotifyRmvChild;

    /**
     * Field _dtDtStOffNotifyRmvChild
     */
    private org.exolab.castor.types.Date _dtDtStOffNotifyRmvChild;

    /**
     * Field _dtDtStOffAdviceRmvChild
     */
    private org.exolab.castor.types.Date _dtDtStOffAdviceRmvChild;

    /**
     * Field _cIndTrialHomeVisit
     */
    private java.lang.String _cIndTrialHomeVisit;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV10DOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00()


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
     */
    public void deleteUlIdPriorStage()
    {
        this._has_ulIdPriorStage= false;
    } //-- void deleteUlIdPriorStage() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndCpsInvstCpsLeJointContact'.
     * 
     * @return the value of field 'BIndCpsInvstCpsLeJointContact'.
     */
    public java.lang.String getBIndCpsInvstCpsLeJointContact()
    {
        return this._bIndCpsInvstCpsLeJointContact;
    } //-- java.lang.String getBIndCpsInvstCpsLeJointContact() 

    /**
     * Returns the value of field 'bIndCpsInvstEaConcl'.
     * 
     * @return the value of field 'BIndCpsInvstEaConcl'.
     */
    public java.lang.String getBIndCpsInvstEaConcl()
    {
        return this._bIndCpsInvstEaConcl;
    } //-- java.lang.String getBIndCpsInvstEaConcl() 

    /**
     * Returns the value of field 'bIndCpsInvstSafetyPln'.
     * 
     * @return the value of field 'BIndCpsInvstSafetyPln'.
     */
    public java.lang.String getBIndCpsInvstSafetyPln()
    {
        return this._bIndCpsInvstSafetyPln;
    } //-- java.lang.String getBIndCpsInvstSafetyPln() 

    /**
     * Returns the value of field 'bIndVictimTaped'.
     * 
     * @return the value of field 'BIndVictimTaped'.
     */
    public java.lang.String getBIndVictimTaped()
    {
        return this._bIndVictimTaped;
    } //-- java.lang.String getBIndVictimTaped() 

    /**
     * Returns the value of field 'cIndCpsInvstAbbrv'.
     * 
     * @return the value of field 'CIndCpsInvstAbbrv'.
     */
    public java.lang.String getCIndCpsInvstAbbrv()
    {
        return this._cIndCpsInvstAbbrv;
    } //-- java.lang.String getCIndCpsInvstAbbrv() 

    /**
     * Returns the value of field 'cIndCpsInvstDtlRaNa'.
     * 
     * @return the value of field 'CIndCpsInvstDtlRaNa'.
     */
    public java.lang.String getCIndCpsInvstDtlRaNa()
    {
        return this._cIndCpsInvstDtlRaNa;
    } //-- java.lang.String getCIndCpsInvstDtlRaNa() 

    /**
     * Returns the value of field 'cIndFostPrntNotified'.
     * 
     * @return the value of field 'CIndFostPrntNotified'.
     */
    public java.lang.String getCIndFostPrntNotified()
    {
        return this._cIndFostPrntNotified;
    } //-- java.lang.String getCIndFostPrntNotified() 

    /**
     * Returns the value of field 'cIndInvMaltreatInCare'.
     * 
     * @return the value of field 'CIndInvMaltreatInCare'.
     */
    public java.lang.String getCIndInvMaltreatInCare()
    {
        return this._cIndInvMaltreatInCare;
    } //-- java.lang.String getCIndInvMaltreatInCare() 

    /**
     * Returns the value of field 'cIndPolicyViolation'.
     * 
     * @return the value of field 'CIndPolicyViolation'.
     */
    public java.lang.String getCIndPolicyViolation()
    {
        return this._cIndPolicyViolation;
    } //-- java.lang.String getCIndPolicyViolation() 

    /**
     * Returns the value of field 'cIndSpeInvstPlaceProv'.
     * 
     * @return the value of field 'CIndSpeInvstPlaceProv'.
     */
    public java.lang.String getCIndSpeInvstPlaceProv()
    {
        return this._cIndSpeInvstPlaceProv;
    } //-- java.lang.String getCIndSpeInvstPlaceProv() 

    /**
     * Returns the value of field 'cIndStOffNotifyRmvChild'.
     * 
     * @return the value of field 'CIndStOffNotifyRmvChild'.
     */
    public java.lang.String getCIndStOffNotifyRmvChild()
    {
        return this._cIndStOffNotifyRmvChild;
    } //-- java.lang.String getCIndStOffNotifyRmvChild() 

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
     * Returns the value of field 'cIndUnsubMIC'.
     * 
     * @return the value of field 'CIndUnsubMIC'.
     */
    public java.lang.String getCIndUnsubMIC()
    {
        return this._cIndUnsubMIC;
    } //-- java.lang.String getCIndUnsubMIC() 

    /**
     * Returns the value of field 'cdAbuseStatus'.
     * 
     * @return the value of field 'CdAbuseStatus'.
     */
    public java.lang.String getCdAbuseStatus()
    {
        return this._cdAbuseStatus;
    } //-- java.lang.String getCdAbuseStatus() 

    /**
     * Returns the value of field 'cdAbuseType01'.
     * 
     * @return the value of field 'CdAbuseType01'.
     */
    public java.lang.String getCdAbuseType01()
    {
        return this._cdAbuseType01;
    } //-- java.lang.String getCdAbuseType01() 

    /**
     * Returns the value of field 'cdAbuseType02'.
     * 
     * @return the value of field 'CdAbuseType02'.
     */
    public java.lang.String getCdAbuseType02()
    {
        return this._cdAbuseType02;
    } //-- java.lang.String getCdAbuseType02() 

    /**
     * Returns the value of field 'cdAbuseType03'.
     * 
     * @return the value of field 'CdAbuseType03'.
     */
    public java.lang.String getCdAbuseType03()
    {
        return this._cdAbuseType03;
    } //-- java.lang.String getCdAbuseType03() 

    /**
     * Returns the value of field 'cdAbuseType04'.
     * 
     * @return the value of field 'CdAbuseType04'.
     */
    public java.lang.String getCdAbuseType04()
    {
        return this._cdAbuseType04;
    } //-- java.lang.String getCdAbuseType04() 

    /**
     * Returns the value of field 'cdAbuseType05'.
     * 
     * @return the value of field 'CdAbuseType05'.
     */
    public java.lang.String getCdAbuseType05()
    {
        return this._cdAbuseType05;
    } //-- java.lang.String getCdAbuseType05() 

    /**
     * Returns the value of field 'cdAbuseType06'.
     * 
     * @return the value of field 'CdAbuseType06'.
     */
    public java.lang.String getCdAbuseType06()
    {
        return this._cdAbuseType06;
    } //-- java.lang.String getCdAbuseType06() 

    /**
     * Returns the value of field 'cdAbuseType07'.
     * 
     * @return the value of field 'CdAbuseType07'.
     */
    public java.lang.String getCdAbuseType07()
    {
        return this._cdAbuseType07;
    } //-- java.lang.String getCdAbuseType07() 

    /**
     * Returns the value of field 'cdCpsOverallDisptn'.
     * 
     * @return the value of field 'CdCpsOverallDisptn'.
     */
    public java.lang.String getCdCpsOverallDisptn()
    {
        return this._cdCpsOverallDisptn;
    } //-- java.lang.String getCdCpsOverallDisptn() 

    /**
     * Returns the value of field 'cdFamviol01'.
     * 
     * @return the value of field 'CdFamviol01'.
     */
    public java.lang.String getCdFamviol01()
    {
        return this._cdFamviol01;
    } //-- java.lang.String getCdFamviol01() 

    /**
     * Returns the value of field 'cdFamviol02'.
     * 
     * @return the value of field 'CdFamviol02'.
     */
    public java.lang.String getCdFamviol02()
    {
        return this._cdFamviol02;
    } //-- java.lang.String getCdFamviol02() 

    /**
     * Returns the value of field 'cdFamviol03'.
     * 
     * @return the value of field 'CdFamviol03'.
     */
    public java.lang.String getCdFamviol03()
    {
        return this._cdFamviol03;
    } //-- java.lang.String getCdFamviol03() 

    /**
     * Returns the value of field 'cdFamviol04'.
     * 
     * @return the value of field 'CdFamviol04'.
     */
    public java.lang.String getCdFamviol04()
    {
        return this._cdFamviol04;
    } //-- java.lang.String getCdFamviol04() 

    /**
     * Returns the value of field 'cdFamviol05'.
     * 
     * @return the value of field 'CdFamviol05'.
     */
    public java.lang.String getCdFamviol05()
    {
        return this._cdFamviol05;
    } //-- java.lang.String getCdFamviol05() 

    /**
     * Returns the value of field 'cdMaltreatLoc'.
     * 
     * @return the value of field 'CdMaltreatLoc'.
     */
    public java.lang.String getCdMaltreatLoc()
    {
        return this._cdMaltreatLoc;
    } //-- java.lang.String getCdMaltreatLoc() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlAssigned'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlAssigned'.
     */
    public org.exolab.castor.types.Date getDtDtCPSInvstDtlAssigned()
    {
        return this._dtDtCPSInvstDtlAssigned;
    } //-- org.exolab.castor.types.Date getDtDtCPSInvstDtlAssigned() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlBegun'.
     */
    public org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun()
    {
        return this._dtDtCPSInvstDtlBegun;
    } //-- org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlIntake'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlIntake'.
     */
    public java.util.Date getDtDtCPSInvstDtlIntake()
    {
        return this._dtDtCPSInvstDtlIntake;
    } //-- java.util.Date getDtDtCPSInvstDtlIntake() 

    /**
     * Returns the value of field 'dtDtCpsInvstDtlComplt'.
     * 
     * @return the value of field 'DtDtCpsInvstDtlComplt'.
     */
    public org.exolab.castor.types.Date getDtDtCpsInvstDtlComplt()
    {
        return this._dtDtCpsInvstDtlComplt;
    } //-- org.exolab.castor.types.Date getDtDtCpsInvstDtlComplt() 

    /**
     * Returns the value of field 'dtDtDetermLetterSent'.
     * 
     * @return the value of field 'DtDtDetermLetterSent'.
     */
    public org.exolab.castor.types.Date getDtDtDetermLetterSent()
    {
        return this._dtDtDetermLetterSent;
    } //-- org.exolab.castor.types.Date getDtDtDetermLetterSent() 

    /**
     * Returns the value of field 'dtDtFostPrntNotified'.
     * 
     * @return the value of field 'DtDtFostPrntNotified'.
     */
    public org.exolab.castor.types.Date getDtDtFostPrntNotified()
    {
        return this._dtDtFostPrntNotified;
    } //-- org.exolab.castor.types.Date getDtDtFostPrntNotified() 

    /**
     * Returns the value of field 'dtDtOverride'.
     * 
     * @return the value of field 'DtDtOverride'.
     */
    public org.exolab.castor.types.Date getDtDtOverride()
    {
        return this._dtDtOverride;
    } //-- org.exolab.castor.types.Date getDtDtOverride() 

    /**
     * Returns the value of field 'dtDtStOffAdviceRmvChild'.
     * 
     * @return the value of field 'DtDtStOffAdviceRmvChild'.
     */
    public org.exolab.castor.types.Date getDtDtStOffAdviceRmvChild()
    {
        return this._dtDtStOffAdviceRmvChild;
    } //-- org.exolab.castor.types.Date getDtDtStOffAdviceRmvChild() 

    /**
     * Returns the value of field 'dtDtStOffNotifyRmvChild'.
     * 
     * @return the value of field 'DtDtStOffNotifyRmvChild'.
     */
    public org.exolab.castor.types.Date getDtDtStOffNotifyRmvChild()
    {
        return this._dtDtStOffNotifyRmvChild;
    } //-- org.exolab.castor.types.Date getDtDtStOffNotifyRmvChild() 

    /**
     * Returns the value of field 'szCdCpsInvstCpsLeJointContact'.
     * 
     * @return the value of field 'SzCdCpsInvstCpsLeJointContact'.
     */
    public java.lang.String getSzCdCpsInvstCpsLeJointContact()
    {
        return this._szCdCpsInvstCpsLeJointContact;
    } //-- java.lang.String getSzCdCpsInvstCpsLeJointContact() 

    /**
     * Returns the value of field 'szCdCpsInvstDtlFamIncm'.
     * 
     * @return the value of field 'SzCdCpsInvstDtlFamIncm'.
     */
    public java.lang.String getSzCdCpsInvstDtlFamIncm()
    {
        return this._szCdCpsInvstDtlFamIncm;
    } //-- java.lang.String getSzCdCpsInvstDtlFamIncm() 

    /**
     * Returns the value of field 'szCdOverrideOverllFind'.
     * 
     * @return the value of field 'SzCdOverrideOverllFind'.
     */
    public java.lang.String getSzCdOverrideOverllFind()
    {
        return this._szCdOverrideOverllFind;
    } //-- java.lang.String getSzCdOverrideOverllFind() 

    /**
     * Returns the value of field 'szCdOverrideRiskLvl'.
     * 
     * @return the value of field 'SzCdOverrideRiskLvl'.
     */
    public java.lang.String getSzCdOverrideRiskLvl()
    {
        return this._szCdOverrideRiskLvl;
    } //-- java.lang.String getSzCdOverrideRiskLvl() 

    /**
     * Returns the value of field 'szCdStageLvlOfRisk'.
     * 
     * @return the value of field 'SzCdStageLvlOfRisk'.
     */
    public java.lang.String getSzCdStageLvlOfRisk()
    {
        return this._szCdStageLvlOfRisk;
    } //-- java.lang.String getSzCdStageLvlOfRisk() 

    /**
     * Returns the value of field 'szCdStageRiskFinding'.
     * 
     * @return the value of field 'SzCdStageRiskFinding'.
     */
    public java.lang.String getSzCdStageRiskFinding()
    {
        return this._szCdStageRiskFinding;
    } //-- java.lang.String getSzCdStageRiskFinding() 

    /**
     * Returns the value of field 'szCdVictimTaped'.
     * 
     * @return the value of field 'SzCdVictimTaped'.
     */
    public java.lang.String getSzCdVictimTaped()
    {
        return this._szCdVictimTaped;
    } //-- java.lang.String getSzCdVictimTaped() 

    /**
     * Returns the value of field 'szTxtCpsInvstCpsLeJointContact'.
     * 
     * @return the value of field 'SzTxtCpsInvstCpsLeJointContact'.
     */
    public java.lang.String getSzTxtCpsInvstCpsLeJointContact()
    {
        return this._szTxtCpsInvstCpsLeJointContact;
    } //-- java.lang.String getSzTxtCpsInvstCpsLeJointContact() 

    /**
     * Returns the value of field 'szTxtFostPrntNotifyCmnts'.
     * 
     * @return the value of field 'SzTxtFostPrntNotifyCmnts'.
     */
    public java.lang.String getSzTxtFostPrntNotifyCmnts()
    {
        return this._szTxtFostPrntNotifyCmnts;
    } //-- java.lang.String getSzTxtFostPrntNotifyCmnts() 

    /**
     * Returns the value of field 'szTxtOverrideComments'.
     * 
     * @return the value of field 'SzTxtOverrideComments'.
     */
    public java.lang.String getSzTxtOverrideComments()
    {
        return this._szTxtOverrideComments;
    } //-- java.lang.String getSzTxtOverrideComments() 

    /**
     * Returns the value of field 'szTxtOvrllCaseDisptn'.
     * 
     * @return the value of field 'SzTxtOvrllCaseDisptn'.
     */
    public java.lang.String getSzTxtOvrllCaseDisptn()
    {
        return this._szTxtOvrllCaseDisptn;
    } //-- java.lang.String getSzTxtOvrllCaseDisptn() 

    /**
     * Returns the value of field 'szTxtVictimTaped'.
     * 
     * @return the value of field 'SzTxtVictimTaped'.
     */
    public java.lang.String getSzTxtVictimTaped()
    {
        return this._szTxtVictimTaped;
    } //-- java.lang.String getSzTxtVictimTaped() 

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
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Returns the value of field 'ulIdPriorStage'.
     * 
     * @return the value of field 'UlIdPriorStage'.
     */
    public int getUlIdPriorStage()
    {
        return this._ulIdPriorStage;
    } //-- int getUlIdPriorStage() 

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
     * Method hasUlIdPriorStage
     * 
     * 
     * 
     * @return true if at least one UlIdPriorStage has been added
     */
    public boolean hasUlIdPriorStage()
    {
        return this._has_ulIdPriorStage;
    } //-- boolean hasUlIdPriorStage() 

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
     * Sets the value of field 'bIndCpsInvstCpsLeJointContact'.
     * 
     * @param bIndCpsInvstCpsLeJointContact the value of field
     * 'bIndCpsInvstCpsLeJointContact'.
     */
    public void setBIndCpsInvstCpsLeJointContact(java.lang.String bIndCpsInvstCpsLeJointContact)
    {
        this._bIndCpsInvstCpsLeJointContact = bIndCpsInvstCpsLeJointContact;
    } //-- void setBIndCpsInvstCpsLeJointContact(java.lang.String) 

    /**
     * Sets the value of field 'bIndCpsInvstEaConcl'.
     * 
     * @param bIndCpsInvstEaConcl the value of field
     * 'bIndCpsInvstEaConcl'.
     */
    public void setBIndCpsInvstEaConcl(java.lang.String bIndCpsInvstEaConcl)
    {
        this._bIndCpsInvstEaConcl = bIndCpsInvstEaConcl;
    } //-- void setBIndCpsInvstEaConcl(java.lang.String) 

    /**
     * Sets the value of field 'bIndCpsInvstSafetyPln'.
     * 
     * @param bIndCpsInvstSafetyPln the value of field
     * 'bIndCpsInvstSafetyPln'.
     */
    public void setBIndCpsInvstSafetyPln(java.lang.String bIndCpsInvstSafetyPln)
    {
        this._bIndCpsInvstSafetyPln = bIndCpsInvstSafetyPln;
    } //-- void setBIndCpsInvstSafetyPln(java.lang.String) 

    /**
     * Sets the value of field 'bIndVictimTaped'.
     * 
     * @param bIndVictimTaped the value of field 'bIndVictimTaped'.
     */
    public void setBIndVictimTaped(java.lang.String bIndVictimTaped)
    {
        this._bIndVictimTaped = bIndVictimTaped;
    } //-- void setBIndVictimTaped(java.lang.String) 

    /**
     * Sets the value of field 'cIndCpsInvstAbbrv'.
     * 
     * @param cIndCpsInvstAbbrv the value of field
     * 'cIndCpsInvstAbbrv'.
     */
    public void setCIndCpsInvstAbbrv(java.lang.String cIndCpsInvstAbbrv)
    {
        this._cIndCpsInvstAbbrv = cIndCpsInvstAbbrv;
    } //-- void setCIndCpsInvstAbbrv(java.lang.String) 

    /**
     * Sets the value of field 'cIndCpsInvstDtlRaNa'.
     * 
     * @param cIndCpsInvstDtlRaNa the value of field
     * 'cIndCpsInvstDtlRaNa'.
     */
    public void setCIndCpsInvstDtlRaNa(java.lang.String cIndCpsInvstDtlRaNa)
    {
        this._cIndCpsInvstDtlRaNa = cIndCpsInvstDtlRaNa;
    } //-- void setCIndCpsInvstDtlRaNa(java.lang.String) 

    /**
     * Sets the value of field 'cIndFostPrntNotified'.
     * 
     * @param cIndFostPrntNotified the value of field
     * 'cIndFostPrntNotified'.
     */
    public void setCIndFostPrntNotified(java.lang.String cIndFostPrntNotified)
    {
        this._cIndFostPrntNotified = cIndFostPrntNotified;
    } //-- void setCIndFostPrntNotified(java.lang.String) 

    /**
     * Sets the value of field 'cIndInvMaltreatInCare'.
     * 
     * @param cIndInvMaltreatInCare the value of field
     * 'cIndInvMaltreatInCare'.
     */
    public void setCIndInvMaltreatInCare(java.lang.String cIndInvMaltreatInCare)
    {
        this._cIndInvMaltreatInCare = cIndInvMaltreatInCare;
    } //-- void setCIndInvMaltreatInCare(java.lang.String) 

    /**
     * Sets the value of field 'cIndPolicyViolation'.
     * 
     * @param cIndPolicyViolation the value of field
     * 'cIndPolicyViolation'.
     */
    public void setCIndPolicyViolation(java.lang.String cIndPolicyViolation)
    {
        this._cIndPolicyViolation = cIndPolicyViolation;
    } //-- void setCIndPolicyViolation(java.lang.String) 

    /**
     * Sets the value of field 'cIndSpeInvstPlaceProv'.
     * 
     * @param cIndSpeInvstPlaceProv the value of field
     * 'cIndSpeInvstPlaceProv'.
     */
    public void setCIndSpeInvstPlaceProv(java.lang.String cIndSpeInvstPlaceProv)
    {
        this._cIndSpeInvstPlaceProv = cIndSpeInvstPlaceProv;
    } //-- void setCIndSpeInvstPlaceProv(java.lang.String) 

    /**
     * Sets the value of field 'cIndStOffNotifyRmvChild'.
     * 
     * @param cIndStOffNotifyRmvChild the value of field
     * 'cIndStOffNotifyRmvChild'.
     */
    public void setCIndStOffNotifyRmvChild(java.lang.String cIndStOffNotifyRmvChild)
    {
        this._cIndStOffNotifyRmvChild = cIndStOffNotifyRmvChild;
    } //-- void setCIndStOffNotifyRmvChild(java.lang.String) 

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
     * Sets the value of field 'cIndUnsubMIC'.
     * 
     * @param cIndUnsubMIC the value of field 'cIndUnsubMIC'.
     */
    public void setCIndUnsubMIC(java.lang.String cIndUnsubMIC)
    {
        this._cIndUnsubMIC = cIndUnsubMIC;
    } //-- void setCIndUnsubMIC(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseStatus'.
     * 
     * @param cdAbuseStatus the value of field 'cdAbuseStatus'.
     */
    public void setCdAbuseStatus(java.lang.String cdAbuseStatus)
    {
        this._cdAbuseStatus = cdAbuseStatus;
    } //-- void setCdAbuseStatus(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseType01'.
     * 
     * @param cdAbuseType01 the value of field 'cdAbuseType01'.
     */
    public void setCdAbuseType01(java.lang.String cdAbuseType01)
    {
        this._cdAbuseType01 = cdAbuseType01;
    } //-- void setCdAbuseType01(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseType02'.
     * 
     * @param cdAbuseType02 the value of field 'cdAbuseType02'.
     */
    public void setCdAbuseType02(java.lang.String cdAbuseType02)
    {
        this._cdAbuseType02 = cdAbuseType02;
    } //-- void setCdAbuseType02(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseType03'.
     * 
     * @param cdAbuseType03 the value of field 'cdAbuseType03'.
     */
    public void setCdAbuseType03(java.lang.String cdAbuseType03)
    {
        this._cdAbuseType03 = cdAbuseType03;
    } //-- void setCdAbuseType03(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseType04'.
     * 
     * @param cdAbuseType04 the value of field 'cdAbuseType04'.
     */
    public void setCdAbuseType04(java.lang.String cdAbuseType04)
    {
        this._cdAbuseType04 = cdAbuseType04;
    } //-- void setCdAbuseType04(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseType05'.
     * 
     * @param cdAbuseType05 the value of field 'cdAbuseType05'.
     */
    public void setCdAbuseType05(java.lang.String cdAbuseType05)
    {
        this._cdAbuseType05 = cdAbuseType05;
    } //-- void setCdAbuseType05(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseType06'.
     * 
     * @param cdAbuseType06 the value of field 'cdAbuseType06'.
     */
    public void setCdAbuseType06(java.lang.String cdAbuseType06)
    {
        this._cdAbuseType06 = cdAbuseType06;
    } //-- void setCdAbuseType06(java.lang.String) 

    /**
     * Sets the value of field 'cdAbuseType07'.
     * 
     * @param cdAbuseType07 the value of field 'cdAbuseType07'.
     */
    public void setCdAbuseType07(java.lang.String cdAbuseType07)
    {
        this._cdAbuseType07 = cdAbuseType07;
    } //-- void setCdAbuseType07(java.lang.String) 

    /**
     * Sets the value of field 'cdCpsOverallDisptn'.
     * 
     * @param cdCpsOverallDisptn the value of field
     * 'cdCpsOverallDisptn'.
     */
    public void setCdCpsOverallDisptn(java.lang.String cdCpsOverallDisptn)
    {
        this._cdCpsOverallDisptn = cdCpsOverallDisptn;
    } //-- void setCdCpsOverallDisptn(java.lang.String) 

    /**
     * Sets the value of field 'cdFamviol01'.
     * 
     * @param cdFamviol01 the value of field 'cdFamviol01'.
     */
    public void setCdFamviol01(java.lang.String cdFamviol01)
    {
        this._cdFamviol01 = cdFamviol01;
    } //-- void setCdFamviol01(java.lang.String) 

    /**
     * Sets the value of field 'cdFamviol02'.
     * 
     * @param cdFamviol02 the value of field 'cdFamviol02'.
     */
    public void setCdFamviol02(java.lang.String cdFamviol02)
    {
        this._cdFamviol02 = cdFamviol02;
    } //-- void setCdFamviol02(java.lang.String) 

    /**
     * Sets the value of field 'cdFamviol03'.
     * 
     * @param cdFamviol03 the value of field 'cdFamviol03'.
     */
    public void setCdFamviol03(java.lang.String cdFamviol03)
    {
        this._cdFamviol03 = cdFamviol03;
    } //-- void setCdFamviol03(java.lang.String) 

    /**
     * Sets the value of field 'cdFamviol04'.
     * 
     * @param cdFamviol04 the value of field 'cdFamviol04'.
     */
    public void setCdFamviol04(java.lang.String cdFamviol04)
    {
        this._cdFamviol04 = cdFamviol04;
    } //-- void setCdFamviol04(java.lang.String) 

    /**
     * Sets the value of field 'cdFamviol05'.
     * 
     * @param cdFamviol05 the value of field 'cdFamviol05'.
     */
    public void setCdFamviol05(java.lang.String cdFamviol05)
    {
        this._cdFamviol05 = cdFamviol05;
    } //-- void setCdFamviol05(java.lang.String) 

    /**
     * Sets the value of field 'cdMaltreatLoc'.
     * 
     * @param cdMaltreatLoc the value of field 'cdMaltreatLoc'.
     */
    public void setCdMaltreatLoc(java.lang.String cdMaltreatLoc)
    {
        this._cdMaltreatLoc = cdMaltreatLoc;
    } //-- void setCdMaltreatLoc(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlAssigned'.
     * 
     * @param dtDtCPSInvstDtlAssigned the value of field
     * 'dtDtCPSInvstDtlAssigned'.
     */
    public void setDtDtCPSInvstDtlAssigned(org.exolab.castor.types.Date dtDtCPSInvstDtlAssigned)
    {
        this._dtDtCPSInvstDtlAssigned = dtDtCPSInvstDtlAssigned;
    } //-- void setDtDtCPSInvstDtlAssigned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @param dtDtCPSInvstDtlBegun the value of field
     * 'dtDtCPSInvstDtlBegun'.
     */
    public void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date dtDtCPSInvstDtlBegun)
    {
        this._dtDtCPSInvstDtlBegun = dtDtCPSInvstDtlBegun;
    } //-- void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlIntake'.
     * 
     * @param dtDtCPSInvstDtlIntake the value of field
     * 'dtDtCPSInvstDtlIntake'.
     */
    public void setDtDtCPSInvstDtlIntake(java.util.Date dtDtCPSInvstDtlIntake)
    {
        this._dtDtCPSInvstDtlIntake = dtDtCPSInvstDtlIntake;
    } //-- void setDtDtCPSInvstDtlIntake(java.util.Date) 

    /**
     * Sets the value of field 'dtDtCpsInvstDtlComplt'.
     * 
     * @param dtDtCpsInvstDtlComplt the value of field
     * 'dtDtCpsInvstDtlComplt'.
     */
    public void setDtDtCpsInvstDtlComplt(org.exolab.castor.types.Date dtDtCpsInvstDtlComplt)
    {
        this._dtDtCpsInvstDtlComplt = dtDtCpsInvstDtlComplt;
    } //-- void setDtDtCpsInvstDtlComplt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtDetermLetterSent'.
     * 
     * @param dtDtDetermLetterSent the value of field
     * 'dtDtDetermLetterSent'.
     */
    public void setDtDtDetermLetterSent(org.exolab.castor.types.Date dtDtDetermLetterSent)
    {
        this._dtDtDetermLetterSent = dtDtDetermLetterSent;
    } //-- void setDtDtDetermLetterSent(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtFostPrntNotified'.
     * 
     * @param dtDtFostPrntNotified the value of field
     * 'dtDtFostPrntNotified'.
     */
    public void setDtDtFostPrntNotified(org.exolab.castor.types.Date dtDtFostPrntNotified)
    {
        this._dtDtFostPrntNotified = dtDtFostPrntNotified;
    } //-- void setDtDtFostPrntNotified(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtOverride'.
     * 
     * @param dtDtOverride the value of field 'dtDtOverride'.
     */
    public void setDtDtOverride(org.exolab.castor.types.Date dtDtOverride)
    {
        this._dtDtOverride = dtDtOverride;
    } //-- void setDtDtOverride(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStOffAdviceRmvChild'.
     * 
     * @param dtDtStOffAdviceRmvChild the value of field
     * 'dtDtStOffAdviceRmvChild'.
     */
    public void setDtDtStOffAdviceRmvChild(org.exolab.castor.types.Date dtDtStOffAdviceRmvChild)
    {
        this._dtDtStOffAdviceRmvChild = dtDtStOffAdviceRmvChild;
    } //-- void setDtDtStOffAdviceRmvChild(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStOffNotifyRmvChild'.
     * 
     * @param dtDtStOffNotifyRmvChild the value of field
     * 'dtDtStOffNotifyRmvChild'.
     */
    public void setDtDtStOffNotifyRmvChild(org.exolab.castor.types.Date dtDtStOffNotifyRmvChild)
    {
        this._dtDtStOffNotifyRmvChild = dtDtStOffNotifyRmvChild;
    } //-- void setDtDtStOffNotifyRmvChild(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdCpsInvstCpsLeJointContact'.
     * 
     * @param szCdCpsInvstCpsLeJointContact the value of field
     * 'szCdCpsInvstCpsLeJointContact'.
     */
    public void setSzCdCpsInvstCpsLeJointContact(java.lang.String szCdCpsInvstCpsLeJointContact)
    {
        this._szCdCpsInvstCpsLeJointContact = szCdCpsInvstCpsLeJointContact;
    } //-- void setSzCdCpsInvstCpsLeJointContact(java.lang.String) 

    /**
     * Sets the value of field 'szCdCpsInvstDtlFamIncm'.
     * 
     * @param szCdCpsInvstDtlFamIncm the value of field
     * 'szCdCpsInvstDtlFamIncm'.
     */
    public void setSzCdCpsInvstDtlFamIncm(java.lang.String szCdCpsInvstDtlFamIncm)
    {
        this._szCdCpsInvstDtlFamIncm = szCdCpsInvstDtlFamIncm;
    } //-- void setSzCdCpsInvstDtlFamIncm(java.lang.String) 

    /**
     * Sets the value of field 'szCdOverrideOverllFind'.
     * 
     * @param szCdOverrideOverllFind the value of field
     * 'szCdOverrideOverllFind'.
     */
    public void setSzCdOverrideOverllFind(java.lang.String szCdOverrideOverllFind)
    {
        this._szCdOverrideOverllFind = szCdOverrideOverllFind;
    } //-- void setSzCdOverrideOverllFind(java.lang.String) 

    /**
     * Sets the value of field 'szCdOverrideRiskLvl'.
     * 
     * @param szCdOverrideRiskLvl the value of field
     * 'szCdOverrideRiskLvl'.
     */
    public void setSzCdOverrideRiskLvl(java.lang.String szCdOverrideRiskLvl)
    {
        this._szCdOverrideRiskLvl = szCdOverrideRiskLvl;
    } //-- void setSzCdOverrideRiskLvl(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageLvlOfRisk'.
     * 
     * @param szCdStageLvlOfRisk the value of field
     * 'szCdStageLvlOfRisk'.
     */
    public void setSzCdStageLvlOfRisk(java.lang.String szCdStageLvlOfRisk)
    {
        this._szCdStageLvlOfRisk = szCdStageLvlOfRisk;
    } //-- void setSzCdStageLvlOfRisk(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageRiskFinding'.
     * 
     * @param szCdStageRiskFinding the value of field
     * 'szCdStageRiskFinding'.
     */
    public void setSzCdStageRiskFinding(java.lang.String szCdStageRiskFinding)
    {
        this._szCdStageRiskFinding = szCdStageRiskFinding;
    } //-- void setSzCdStageRiskFinding(java.lang.String) 

    /**
     * Sets the value of field 'szCdVictimTaped'.
     * 
     * @param szCdVictimTaped the value of field 'szCdVictimTaped'.
     */
    public void setSzCdVictimTaped(java.lang.String szCdVictimTaped)
    {
        this._szCdVictimTaped = szCdVictimTaped;
    } //-- void setSzCdVictimTaped(java.lang.String) 

    /**
     * Sets the value of field 'szTxtCpsInvstCpsLeJointContact'.
     * 
     * @param szTxtCpsInvstCpsLeJointContact the value of field
     * 'szTxtCpsInvstCpsLeJointContact'.
     */
    public void setSzTxtCpsInvstCpsLeJointContact(java.lang.String szTxtCpsInvstCpsLeJointContact)
    {
        this._szTxtCpsInvstCpsLeJointContact = szTxtCpsInvstCpsLeJointContact;
    } //-- void setSzTxtCpsInvstCpsLeJointContact(java.lang.String) 

    /**
     * Sets the value of field 'szTxtFostPrntNotifyCmnts'.
     * 
     * @param szTxtFostPrntNotifyCmnts the value of field
     * 'szTxtFostPrntNotifyCmnts'.
     */
    public void setSzTxtFostPrntNotifyCmnts(java.lang.String szTxtFostPrntNotifyCmnts)
    {
        this._szTxtFostPrntNotifyCmnts = szTxtFostPrntNotifyCmnts;
    } //-- void setSzTxtFostPrntNotifyCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOverrideComments'.
     * 
     * @param szTxtOverrideComments the value of field
     * 'szTxtOverrideComments'.
     */
    public void setSzTxtOverrideComments(java.lang.String szTxtOverrideComments)
    {
        this._szTxtOverrideComments = szTxtOverrideComments;
    } //-- void setSzTxtOverrideComments(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOvrllCaseDisptn'.
     * 
     * @param szTxtOvrllCaseDisptn the value of field
     * 'szTxtOvrllCaseDisptn'.
     */
    public void setSzTxtOvrllCaseDisptn(java.lang.String szTxtOvrllCaseDisptn)
    {
        this._szTxtOvrllCaseDisptn = szTxtOvrllCaseDisptn;
    } //-- void setSzTxtOvrllCaseDisptn(java.lang.String) 

    /**
     * Sets the value of field 'szTxtVictimTaped'.
     * 
     * @param szTxtVictimTaped the value of field 'szTxtVictimTaped'
     */
    public void setSzTxtVictimTaped(java.lang.String szTxtVictimTaped)
    {
        this._szTxtVictimTaped = szTxtVictimTaped;
    } //-- void setSzTxtVictimTaped(java.lang.String) 

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
     * Sets the value of field 'ulIdPriorStage'.
     * 
     * @param ulIdPriorStage the value of field 'ulIdPriorStage'.
     */
    public void setUlIdPriorStage(int ulIdPriorStage)
    {
        this._ulIdPriorStage = ulIdPriorStage;
        this._has_ulIdPriorStage = true;
    } //-- void setUlIdPriorStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 unmarshal(java.io.Reader) 

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
