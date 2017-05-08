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
 * Class CFAD14SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD14SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdResourceHistory
     */
    private int _ulIdResourceHistory;

    /**
     * keeps track of state for field: _ulIdResourceHistory
     */
    private boolean _has_ulIdResourceHistory;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szAddrRshsAttn
     */
    private java.lang.String _szAddrRshsAttn;

    /**
     * Field _szAddrRshsCity
     */
    private java.lang.String _szAddrRshsCity;

    /**
     * Field _szAddrRshsStLn1
     */
    private java.lang.String _szAddrRshsStLn1;

    /**
     * Field _szAddrRshsStLn2
     */
    private java.lang.String _szAddrRshsStLn2;

    /**
     * Field _lAddrRshsZip
     */
    private java.lang.String _lAddrRshsZip;

    /**
     * Field _szCdRshsCampusType
     */
    private java.lang.String _szCdRshsCampusType;

    /**
     * Field _szCdRshsCategory
     */
    private java.lang.String _szCdRshsCategory;

    /**
     * Field _szCdRshsCertBy
     */
    private java.lang.String _szCdRshsCertBy;

    /**
     * Field _szCdRshsClosureRsn
     */
    private java.lang.String _szCdRshsClosureRsn;

    /**
     * Field _szCdRshsCnty
     */
    private java.lang.String _szCdRshsCnty;

    /**
     * Field _szCdRshsEthnicity
     */
    private java.lang.String _szCdRshsEthnicity;

    /**
     * Field _szCdRshsFaHomeStatus
     */
    private java.lang.String _szCdRshsFaHomeStatus;

    /**
     * Field _cCdRshsFaHomeType1
     */
    private java.lang.String _cCdRshsFaHomeType1;

    /**
     * Field _szCdRshsFacilType
     */
    private java.lang.String _szCdRshsFacilType;

    /**
     * Field _szCdRshsHub
     */
    private java.lang.String _szCdRshsHub;

    /**
     * Field _szCdRshsInvolClosure
     */
    private java.lang.String _szCdRshsInvolClosure;

    /**
     * Field _szCdRshsLanguage
     */
    private java.lang.String _szCdRshsLanguage;

    /**
     * Field _szCdRshsMaintainer
     */
    private java.lang.String _szCdRshsMaintainer;

    /**
     * Field _szCdRshsMaritalStatus
     */
    private java.lang.String _szCdRshsMaritalStatus;

    /**
     * Field _szCdRshsOperBy
     */
    private java.lang.String _szCdRshsOperBy;

    /**
     * Field _szCdRshsOwnership
     */
    private java.lang.String _szCdRshsOwnership;

    /**
     * Field _szCdRshsPayment
     */
    private java.lang.String _szCdRshsPayment;

    /**
     * Field _szCdRshsRecmndReopen
     */
    private java.lang.String _szCdRshsRecmndReopen;

    /**
     * Field _szCdRshsRegion
     */
    private java.lang.String _szCdRshsRegion;

    /**
     * Field _szCdRshsReligion
     */
    private java.lang.String _szCdRshsReligion;

    /**
     * Field _szCdRshsRespite
     */
    private java.lang.String _szCdRshsRespite;

    /**
     * Field _szCdRshsSchDist
     */
    private java.lang.String _szCdRshsSchDist;

    /**
     * Field _szCdRshsSetting
     */
    private java.lang.String _szCdRshsSetting;

    /**
     * Field _szCdRshsSourceInquiry
     */
    private java.lang.String _szCdRshsSourceInquiry;

    /**
     * Field _szCdRshsState
     */
    private java.lang.String _szCdRshsState;

    /**
     * Field _szCdRshsStatus
     */
    private java.lang.String _szCdRshsStatus;

    /**
     * Field _szCdRshsType
     */
    private java.lang.String _szCdRshsType;

    /**
     * Field _dtDtRshsCert
     */
    private org.exolab.castor.types.Date _dtDtRshsCert;

    /**
     * Field _dtDtRshsClose
     */
    private org.exolab.castor.types.Date _dtDtRshsClose;

    /**
     * Field _dtDtRshsEffective
     */
    private org.exolab.castor.types.Date _dtDtRshsEffective;

    /**
     * Field _dtDtRshsEnd
     */
    private org.exolab.castor.types.Date _dtDtRshsEnd;

    /**
     * Field _dtDtRshsMarriage
     */
    private org.exolab.castor.types.Date _dtDtRshsMarriage;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _cIndRshsCareProv
     */
    private java.lang.String _cIndRshsCareProv;

    /**
     * Field _cIndRshsEmergPlace
     */
    private java.lang.String _cIndRshsEmergPlace;

    /**
     * Field _cIndRshsInactive
     */
    private java.lang.String _cIndRshsInactive;

    /**
     * Field _cIndCurrHomeStudyExists
     */
    private java.lang.String _cIndCurrHomeStudyExists;

    /**
     * Field _cIndRshsNonDFCSHome
     */
    private java.lang.String _cIndRshsNonDFCSHome;

    /**
     * Field _cIndRshsTransport
     */
    private java.lang.String _cIndRshsTransport;

    /**
     * Field _cIndRshsWriteHist
     */
    private java.lang.String _cIndRshsWriteHist;

    /**
     * Field _dNbrRshsAnnualIncome
     */
    private double _dNbrRshsAnnualIncome;

    /**
     * keeps track of state for field: _dNbrRshsAnnualIncome
     */
    private boolean _has_dNbrRshsAnnualIncome;

    /**
     * Field _lNbrRshsCampusNbr
     */
    private int _lNbrRshsCampusNbr;

    /**
     * keeps track of state for field: _lNbrRshsCampusNbr
     */
    private boolean _has_lNbrRshsCampusNbr;

    /**
     * Field _lNbrRshsFacilAcclaim
     */
    private int _lNbrRshsFacilAcclaim;

    /**
     * keeps track of state for field: _lNbrRshsFacilAcclaim
     */
    private boolean _has_lNbrRshsFacilAcclaim;

    /**
     * Field _uNbrRshsFacilCapacity
     */
    private int _uNbrRshsFacilCapacity;

    /**
     * keeps track of state for field: _uNbrRshsFacilCapacity
     */
    private boolean _has_uNbrRshsFacilCapacity;

    /**
     * Field _uNbrRshsFMAgeMax
     */
    private int _uNbrRshsFMAgeMax;

    /**
     * keeps track of state for field: _uNbrRshsFMAgeMax
     */
    private boolean _has_uNbrRshsFMAgeMax;

    /**
     * Field _uNbrRshsFMAgeMin
     */
    private int _uNbrRshsFMAgeMin;

    /**
     * keeps track of state for field: _uNbrRshsFMAgeMin
     */
    private boolean _has_uNbrRshsFMAgeMin;

    /**
     * Field _uNbrRshsIntChildren
     */
    private int _uNbrRshsIntChildren;

    /**
     * keeps track of state for field: _uNbrRshsIntChildren
     */
    private boolean _has_uNbrRshsIntChildren;

    /**
     * Field _uNbrRshsIntFeAgeMax
     */
    private int _uNbrRshsIntFeAgeMax;

    /**
     * keeps track of state for field: _uNbrRshsIntFeAgeMax
     */
    private boolean _has_uNbrRshsIntFeAgeMax;

    /**
     * Field _uNbrRshsIntFeAgeMin
     */
    private int _uNbrRshsIntFeAgeMin;

    /**
     * keeps track of state for field: _uNbrRshsIntFeAgeMin
     */
    private boolean _has_uNbrRshsIntFeAgeMin;

    /**
     * Field _uNbrRshsIntMaAgeMax
     */
    private int _uNbrRshsIntMaAgeMax;

    /**
     * keeps track of state for field: _uNbrRshsIntMaAgeMax
     */
    private boolean _has_uNbrRshsIntMaAgeMax;

    /**
     * Field _uNbrRshsIntMaAgeMin
     */
    private int _uNbrRshsIntMaAgeMin;

    /**
     * keeps track of state for field: _uNbrRshsIntMaAgeMin
     */
    private boolean _has_uNbrRshsIntMaAgeMin;

    /**
     * Field _uNbrRshsMaAgeMax
     */
    private int _uNbrRshsMaAgeMax;

    /**
     * keeps track of state for field: _uNbrRshsMaAgeMax
     */
    private boolean _has_uNbrRshsMaAgeMax;

    /**
     * Field _uNbrRshsMaAgeMin
     */
    private int _uNbrRshsMaAgeMin;

    /**
     * keeps track of state for field: _uNbrRshsMaAgeMin
     */
    private boolean _has_uNbrRshsMaAgeMin;

    /**
     * Field _sNbrRshsOpenSlots
     */
    private int _sNbrRshsOpenSlots;

    /**
     * keeps track of state for field: _sNbrRshsOpenSlots
     */
    private boolean _has_sNbrRshsOpenSlots;

    /**
     * Field _szNbrRshsPhn
     */
    private java.lang.String _szNbrRshsPhn;

    /**
     * Field _lNbrRshsPhoneExtension
     */
    private java.lang.String _lNbrRshsPhoneExtension;

    /**
     * Field _szNbrRshsVid
     */
    private java.lang.String _szNbrRshsVid;

    /**
     * Field _szNmRshsContact
     */
    private java.lang.String _szNmRshsContact;

    /**
     * Field _szNmRshsLastUpdate
     */
    private java.lang.String _szNmRshsLastUpdate;

    /**
     * Field _szNmRshsResource
     */
    private java.lang.String _szNmRshsResource;

    /**
     * Field _szTxtRshsAddrCmnts
     */
    private java.lang.String _szTxtRshsAddrCmnts;

    /**
     * Field _szTxtRshsComments
     */
    private java.lang.String _szTxtRshsComments;

    /**
     * Field _tmScrTmGeneric1
     */
    private java.lang.String _tmScrTmGeneric1;

    /**
     * Field _tmScrTmGeneric5
     */
    private java.lang.String _tmScrTmGeneric5;

    /**
     * Field _szTxtNdfcsCertEntity
     */
    private java.lang.String _szTxtNdfcsCertEntity;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD14SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDNbrRshsAnnualIncome()
    {
        this._has_dNbrRshsAnnualIncome= false;
    } //-- void deleteDNbrRshsAnnualIncome() 

    /**
     */
    public void deleteLNbrRshsCampusNbr()
    {
        this._has_lNbrRshsCampusNbr= false;
    } //-- void deleteLNbrRshsCampusNbr() 

    /**
     */
    public void deleteLNbrRshsFacilAcclaim()
    {
        this._has_lNbrRshsFacilAcclaim= false;
    } //-- void deleteLNbrRshsFacilAcclaim() 

    /**
     */
    public void deleteSNbrRshsOpenSlots()
    {
        this._has_sNbrRshsOpenSlots= false;
    } //-- void deleteSNbrRshsOpenSlots() 

    /**
     */
    public void deleteUNbrRshsFMAgeMax()
    {
        this._has_uNbrRshsFMAgeMax= false;
    } //-- void deleteUNbrRshsFMAgeMax() 

    /**
     */
    public void deleteUNbrRshsFMAgeMin()
    {
        this._has_uNbrRshsFMAgeMin= false;
    } //-- void deleteUNbrRshsFMAgeMin() 

    /**
     */
    public void deleteUNbrRshsFacilCapacity()
    {
        this._has_uNbrRshsFacilCapacity= false;
    } //-- void deleteUNbrRshsFacilCapacity() 

    /**
     */
    public void deleteUNbrRshsIntChildren()
    {
        this._has_uNbrRshsIntChildren= false;
    } //-- void deleteUNbrRshsIntChildren() 

    /**
     */
    public void deleteUNbrRshsIntFeAgeMax()
    {
        this._has_uNbrRshsIntFeAgeMax= false;
    } //-- void deleteUNbrRshsIntFeAgeMax() 

    /**
     */
    public void deleteUNbrRshsIntFeAgeMin()
    {
        this._has_uNbrRshsIntFeAgeMin= false;
    } //-- void deleteUNbrRshsIntFeAgeMin() 

    /**
     */
    public void deleteUNbrRshsIntMaAgeMax()
    {
        this._has_uNbrRshsIntMaAgeMax= false;
    } //-- void deleteUNbrRshsIntMaAgeMax() 

    /**
     */
    public void deleteUNbrRshsIntMaAgeMin()
    {
        this._has_uNbrRshsIntMaAgeMin= false;
    } //-- void deleteUNbrRshsIntMaAgeMin() 

    /**
     */
    public void deleteUNbrRshsMaAgeMax()
    {
        this._has_uNbrRshsMaAgeMax= false;
    } //-- void deleteUNbrRshsMaAgeMax() 

    /**
     */
    public void deleteUNbrRshsMaAgeMin()
    {
        this._has_uNbrRshsMaAgeMin= false;
    } //-- void deleteUNbrRshsMaAgeMin() 

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
    public void deleteUlIdResourceHistory()
    {
        this._has_ulIdResourceHistory= false;
    } //-- void deleteUlIdResourceHistory() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'cCdRshsFaHomeType1'.
     * 
     * @return the value of field 'CCdRshsFaHomeType1'.
     */
    public java.lang.String getCCdRshsFaHomeType1()
    {
        return this._cCdRshsFaHomeType1;
    } //-- java.lang.String getCCdRshsFaHomeType1() 

    /**
     * Returns the value of field 'cIndCurrHomeStudyExists'.
     * 
     * @return the value of field 'CIndCurrHomeStudyExists'.
     */
    public java.lang.String getCIndCurrHomeStudyExists()
    {
        return this._cIndCurrHomeStudyExists;
    } //-- java.lang.String getCIndCurrHomeStudyExists() 

    /**
     * Returns the value of field 'cIndRshsCareProv'.
     * 
     * @return the value of field 'CIndRshsCareProv'.
     */
    public java.lang.String getCIndRshsCareProv()
    {
        return this._cIndRshsCareProv;
    } //-- java.lang.String getCIndRshsCareProv() 

    /**
     * Returns the value of field 'cIndRshsEmergPlace'.
     * 
     * @return the value of field 'CIndRshsEmergPlace'.
     */
    public java.lang.String getCIndRshsEmergPlace()
    {
        return this._cIndRshsEmergPlace;
    } //-- java.lang.String getCIndRshsEmergPlace() 

    /**
     * Returns the value of field 'cIndRshsInactive'.
     * 
     * @return the value of field 'CIndRshsInactive'.
     */
    public java.lang.String getCIndRshsInactive()
    {
        return this._cIndRshsInactive;
    } //-- java.lang.String getCIndRshsInactive() 

    /**
     * Returns the value of field 'cIndRshsNonDFCSHome'.
     * 
     * @return the value of field 'CIndRshsNonDFCSHome'.
     */
    public java.lang.String getCIndRshsNonDFCSHome()
    {
        return this._cIndRshsNonDFCSHome;
    } //-- java.lang.String getCIndRshsNonDFCSHome() 

    /**
     * Returns the value of field 'cIndRshsTransport'.
     * 
     * @return the value of field 'CIndRshsTransport'.
     */
    public java.lang.String getCIndRshsTransport()
    {
        return this._cIndRshsTransport;
    } //-- java.lang.String getCIndRshsTransport() 

    /**
     * Returns the value of field 'cIndRshsWriteHist'.
     * 
     * @return the value of field 'CIndRshsWriteHist'.
     */
    public java.lang.String getCIndRshsWriteHist()
    {
        return this._cIndRshsWriteHist;
    } //-- java.lang.String getCIndRshsWriteHist() 

    /**
     * Returns the value of field 'dNbrRshsAnnualIncome'.
     * 
     * @return the value of field 'DNbrRshsAnnualIncome'.
     */
    public double getDNbrRshsAnnualIncome()
    {
        return this._dNbrRshsAnnualIncome;
    } //-- double getDNbrRshsAnnualIncome() 

    /**
     * Returns the value of field 'dtDtRshsCert'.
     * 
     * @return the value of field 'DtDtRshsCert'.
     */
    public org.exolab.castor.types.Date getDtDtRshsCert()
    {
        return this._dtDtRshsCert;
    } //-- org.exolab.castor.types.Date getDtDtRshsCert() 

    /**
     * Returns the value of field 'dtDtRshsClose'.
     * 
     * @return the value of field 'DtDtRshsClose'.
     */
    public org.exolab.castor.types.Date getDtDtRshsClose()
    {
        return this._dtDtRshsClose;
    } //-- org.exolab.castor.types.Date getDtDtRshsClose() 

    /**
     * Returns the value of field 'dtDtRshsEffective'.
     * 
     * @return the value of field 'DtDtRshsEffective'.
     */
    public org.exolab.castor.types.Date getDtDtRshsEffective()
    {
        return this._dtDtRshsEffective;
    } //-- org.exolab.castor.types.Date getDtDtRshsEffective() 

    /**
     * Returns the value of field 'dtDtRshsEnd'.
     * 
     * @return the value of field 'DtDtRshsEnd'.
     */
    public org.exolab.castor.types.Date getDtDtRshsEnd()
    {
        return this._dtDtRshsEnd;
    } //-- org.exolab.castor.types.Date getDtDtRshsEnd() 

    /**
     * Returns the value of field 'dtDtRshsMarriage'.
     * 
     * @return the value of field 'DtDtRshsMarriage'.
     */
    public org.exolab.castor.types.Date getDtDtRshsMarriage()
    {
        return this._dtDtRshsMarriage;
    } //-- org.exolab.castor.types.Date getDtDtRshsMarriage() 

    /**
     * Returns the value of field 'lAddrRshsZip'.
     * 
     * @return the value of field 'LAddrRshsZip'.
     */
    public java.lang.String getLAddrRshsZip()
    {
        return this._lAddrRshsZip;
    } //-- java.lang.String getLAddrRshsZip() 

    /**
     * Returns the value of field 'lNbrRshsCampusNbr'.
     * 
     * @return the value of field 'LNbrRshsCampusNbr'.
     */
    public int getLNbrRshsCampusNbr()
    {
        return this._lNbrRshsCampusNbr;
    } //-- int getLNbrRshsCampusNbr() 

    /**
     * Returns the value of field 'lNbrRshsFacilAcclaim'.
     * 
     * @return the value of field 'LNbrRshsFacilAcclaim'.
     */
    public int getLNbrRshsFacilAcclaim()
    {
        return this._lNbrRshsFacilAcclaim;
    } //-- int getLNbrRshsFacilAcclaim() 

    /**
     * Returns the value of field 'lNbrRshsPhoneExtension'.
     * 
     * @return the value of field 'LNbrRshsPhoneExtension'.
     */
    public java.lang.String getLNbrRshsPhoneExtension()
    {
        return this._lNbrRshsPhoneExtension;
    } //-- java.lang.String getLNbrRshsPhoneExtension() 

    /**
     * Returns the value of field 'sNbrRshsOpenSlots'.
     * 
     * @return the value of field 'SNbrRshsOpenSlots'.
     */
    public int getSNbrRshsOpenSlots()
    {
        return this._sNbrRshsOpenSlots;
    } //-- int getSNbrRshsOpenSlots() 

    /**
     * Returns the value of field 'szAddrRshsAttn'.
     * 
     * @return the value of field 'SzAddrRshsAttn'.
     */
    public java.lang.String getSzAddrRshsAttn()
    {
        return this._szAddrRshsAttn;
    } //-- java.lang.String getSzAddrRshsAttn() 

    /**
     * Returns the value of field 'szAddrRshsCity'.
     * 
     * @return the value of field 'SzAddrRshsCity'.
     */
    public java.lang.String getSzAddrRshsCity()
    {
        return this._szAddrRshsCity;
    } //-- java.lang.String getSzAddrRshsCity() 

    /**
     * Returns the value of field 'szAddrRshsStLn1'.
     * 
     * @return the value of field 'SzAddrRshsStLn1'.
     */
    public java.lang.String getSzAddrRshsStLn1()
    {
        return this._szAddrRshsStLn1;
    } //-- java.lang.String getSzAddrRshsStLn1() 

    /**
     * Returns the value of field 'szAddrRshsStLn2'.
     * 
     * @return the value of field 'SzAddrRshsStLn2'.
     */
    public java.lang.String getSzAddrRshsStLn2()
    {
        return this._szAddrRshsStLn2;
    } //-- java.lang.String getSzAddrRshsStLn2() 

    /**
     * Returns the value of field 'szCdRshsCampusType'.
     * 
     * @return the value of field 'SzCdRshsCampusType'.
     */
    public java.lang.String getSzCdRshsCampusType()
    {
        return this._szCdRshsCampusType;
    } //-- java.lang.String getSzCdRshsCampusType() 

    /**
     * Returns the value of field 'szCdRshsCategory'.
     * 
     * @return the value of field 'SzCdRshsCategory'.
     */
    public java.lang.String getSzCdRshsCategory()
    {
        return this._szCdRshsCategory;
    } //-- java.lang.String getSzCdRshsCategory() 

    /**
     * Returns the value of field 'szCdRshsCertBy'.
     * 
     * @return the value of field 'SzCdRshsCertBy'.
     */
    public java.lang.String getSzCdRshsCertBy()
    {
        return this._szCdRshsCertBy;
    } //-- java.lang.String getSzCdRshsCertBy() 

    /**
     * Returns the value of field 'szCdRshsClosureRsn'.
     * 
     * @return the value of field 'SzCdRshsClosureRsn'.
     */
    public java.lang.String getSzCdRshsClosureRsn()
    {
        return this._szCdRshsClosureRsn;
    } //-- java.lang.String getSzCdRshsClosureRsn() 

    /**
     * Returns the value of field 'szCdRshsCnty'.
     * 
     * @return the value of field 'SzCdRshsCnty'.
     */
    public java.lang.String getSzCdRshsCnty()
    {
        return this._szCdRshsCnty;
    } //-- java.lang.String getSzCdRshsCnty() 

    /**
     * Returns the value of field 'szCdRshsEthnicity'.
     * 
     * @return the value of field 'SzCdRshsEthnicity'.
     */
    public java.lang.String getSzCdRshsEthnicity()
    {
        return this._szCdRshsEthnicity;
    } //-- java.lang.String getSzCdRshsEthnicity() 

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
     * Returns the value of field 'szCdRshsFacilType'.
     * 
     * @return the value of field 'SzCdRshsFacilType'.
     */
    public java.lang.String getSzCdRshsFacilType()
    {
        return this._szCdRshsFacilType;
    } //-- java.lang.String getSzCdRshsFacilType() 

    /**
     * Returns the value of field 'szCdRshsHub'.
     * 
     * @return the value of field 'SzCdRshsHub'.
     */
    public java.lang.String getSzCdRshsHub()
    {
        return this._szCdRshsHub;
    } //-- java.lang.String getSzCdRshsHub() 

    /**
     * Returns the value of field 'szCdRshsInvolClosure'.
     * 
     * @return the value of field 'SzCdRshsInvolClosure'.
     */
    public java.lang.String getSzCdRshsInvolClosure()
    {
        return this._szCdRshsInvolClosure;
    } //-- java.lang.String getSzCdRshsInvolClosure() 

    /**
     * Returns the value of field 'szCdRshsLanguage'.
     * 
     * @return the value of field 'SzCdRshsLanguage'.
     */
    public java.lang.String getSzCdRshsLanguage()
    {
        return this._szCdRshsLanguage;
    } //-- java.lang.String getSzCdRshsLanguage() 

    /**
     * Returns the value of field 'szCdRshsMaintainer'.
     * 
     * @return the value of field 'SzCdRshsMaintainer'.
     */
    public java.lang.String getSzCdRshsMaintainer()
    {
        return this._szCdRshsMaintainer;
    } //-- java.lang.String getSzCdRshsMaintainer() 

    /**
     * Returns the value of field 'szCdRshsMaritalStatus'.
     * 
     * @return the value of field 'SzCdRshsMaritalStatus'.
     */
    public java.lang.String getSzCdRshsMaritalStatus()
    {
        return this._szCdRshsMaritalStatus;
    } //-- java.lang.String getSzCdRshsMaritalStatus() 

    /**
     * Returns the value of field 'szCdRshsOperBy'.
     * 
     * @return the value of field 'SzCdRshsOperBy'.
     */
    public java.lang.String getSzCdRshsOperBy()
    {
        return this._szCdRshsOperBy;
    } //-- java.lang.String getSzCdRshsOperBy() 

    /**
     * Returns the value of field 'szCdRshsOwnership'.
     * 
     * @return the value of field 'SzCdRshsOwnership'.
     */
    public java.lang.String getSzCdRshsOwnership()
    {
        return this._szCdRshsOwnership;
    } //-- java.lang.String getSzCdRshsOwnership() 

    /**
     * Returns the value of field 'szCdRshsPayment'.
     * 
     * @return the value of field 'SzCdRshsPayment'.
     */
    public java.lang.String getSzCdRshsPayment()
    {
        return this._szCdRshsPayment;
    } //-- java.lang.String getSzCdRshsPayment() 

    /**
     * Returns the value of field 'szCdRshsRecmndReopen'.
     * 
     * @return the value of field 'SzCdRshsRecmndReopen'.
     */
    public java.lang.String getSzCdRshsRecmndReopen()
    {
        return this._szCdRshsRecmndReopen;
    } //-- java.lang.String getSzCdRshsRecmndReopen() 

    /**
     * Returns the value of field 'szCdRshsRegion'.
     * 
     * @return the value of field 'SzCdRshsRegion'.
     */
    public java.lang.String getSzCdRshsRegion()
    {
        return this._szCdRshsRegion;
    } //-- java.lang.String getSzCdRshsRegion() 

    /**
     * Returns the value of field 'szCdRshsReligion'.
     * 
     * @return the value of field 'SzCdRshsReligion'.
     */
    public java.lang.String getSzCdRshsReligion()
    {
        return this._szCdRshsReligion;
    } //-- java.lang.String getSzCdRshsReligion() 

    /**
     * Returns the value of field 'szCdRshsRespite'.
     * 
     * @return the value of field 'SzCdRshsRespite'.
     */
    public java.lang.String getSzCdRshsRespite()
    {
        return this._szCdRshsRespite;
    } //-- java.lang.String getSzCdRshsRespite() 

    /**
     * Returns the value of field 'szCdRshsSchDist'.
     * 
     * @return the value of field 'SzCdRshsSchDist'.
     */
    public java.lang.String getSzCdRshsSchDist()
    {
        return this._szCdRshsSchDist;
    } //-- java.lang.String getSzCdRshsSchDist() 

    /**
     * Returns the value of field 'szCdRshsSetting'.
     * 
     * @return the value of field 'SzCdRshsSetting'.
     */
    public java.lang.String getSzCdRshsSetting()
    {
        return this._szCdRshsSetting;
    } //-- java.lang.String getSzCdRshsSetting() 

    /**
     * Returns the value of field 'szCdRshsSourceInquiry'.
     * 
     * @return the value of field 'SzCdRshsSourceInquiry'.
     */
    public java.lang.String getSzCdRshsSourceInquiry()
    {
        return this._szCdRshsSourceInquiry;
    } //-- java.lang.String getSzCdRshsSourceInquiry() 

    /**
     * Returns the value of field 'szCdRshsState'.
     * 
     * @return the value of field 'SzCdRshsState'.
     */
    public java.lang.String getSzCdRshsState()
    {
        return this._szCdRshsState;
    } //-- java.lang.String getSzCdRshsState() 

    /**
     * Returns the value of field 'szCdRshsStatus'.
     * 
     * @return the value of field 'SzCdRshsStatus'.
     */
    public java.lang.String getSzCdRshsStatus()
    {
        return this._szCdRshsStatus;
    } //-- java.lang.String getSzCdRshsStatus() 

    /**
     * Returns the value of field 'szCdRshsType'.
     * 
     * @return the value of field 'SzCdRshsType'.
     */
    public java.lang.String getSzCdRshsType()
    {
        return this._szCdRshsType;
    } //-- java.lang.String getSzCdRshsType() 

    /**
     * Returns the value of field 'szNbrRshsPhn'.
     * 
     * @return the value of field 'SzNbrRshsPhn'.
     */
    public java.lang.String getSzNbrRshsPhn()
    {
        return this._szNbrRshsPhn;
    } //-- java.lang.String getSzNbrRshsPhn() 

    /**
     * Returns the value of field 'szNbrRshsVid'.
     * 
     * @return the value of field 'SzNbrRshsVid'.
     */
    public java.lang.String getSzNbrRshsVid()
    {
        return this._szNbrRshsVid;
    } //-- java.lang.String getSzNbrRshsVid() 

    /**
     * Returns the value of field 'szNmRshsContact'.
     * 
     * @return the value of field 'SzNmRshsContact'.
     */
    public java.lang.String getSzNmRshsContact()
    {
        return this._szNmRshsContact;
    } //-- java.lang.String getSzNmRshsContact() 

    /**
     * Returns the value of field 'szNmRshsLastUpdate'.
     * 
     * @return the value of field 'SzNmRshsLastUpdate'.
     */
    public java.lang.String getSzNmRshsLastUpdate()
    {
        return this._szNmRshsLastUpdate;
    } //-- java.lang.String getSzNmRshsLastUpdate() 

    /**
     * Returns the value of field 'szNmRshsResource'.
     * 
     * @return the value of field 'SzNmRshsResource'.
     */
    public java.lang.String getSzNmRshsResource()
    {
        return this._szNmRshsResource;
    } //-- java.lang.String getSzNmRshsResource() 

    /**
     * Returns the value of field 'szTxtNdfcsCertEntity'.
     * 
     * @return the value of field 'SzTxtNdfcsCertEntity'.
     */
    public java.lang.String getSzTxtNdfcsCertEntity()
    {
        return this._szTxtNdfcsCertEntity;
    } //-- java.lang.String getSzTxtNdfcsCertEntity() 

    /**
     * Returns the value of field 'szTxtRshsAddrCmnts'.
     * 
     * @return the value of field 'SzTxtRshsAddrCmnts'.
     */
    public java.lang.String getSzTxtRshsAddrCmnts()
    {
        return this._szTxtRshsAddrCmnts;
    } //-- java.lang.String getSzTxtRshsAddrCmnts() 

    /**
     * Returns the value of field 'szTxtRshsComments'.
     * 
     * @return the value of field 'SzTxtRshsComments'.
     */
    public java.lang.String getSzTxtRshsComments()
    {
        return this._szTxtRshsComments;
    } //-- java.lang.String getSzTxtRshsComments() 

    /**
     * Returns the value of field 'tmScrTmGeneric1'.
     * 
     * @return the value of field 'TmScrTmGeneric1'.
     */
    public java.lang.String getTmScrTmGeneric1()
    {
        return this._tmScrTmGeneric1;
    } //-- java.lang.String getTmScrTmGeneric1() 

    /**
     * Returns the value of field 'tmScrTmGeneric5'.
     * 
     * @return the value of field 'TmScrTmGeneric5'.
     */
    public java.lang.String getTmScrTmGeneric5()
    {
        return this._tmScrTmGeneric5;
    } //-- java.lang.String getTmScrTmGeneric5() 

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
     * Returns the value of field 'uNbrRshsFMAgeMax'.
     * 
     * @return the value of field 'UNbrRshsFMAgeMax'.
     */
    public int getUNbrRshsFMAgeMax()
    {
        return this._uNbrRshsFMAgeMax;
    } //-- int getUNbrRshsFMAgeMax() 

    /**
     * Returns the value of field 'uNbrRshsFMAgeMin'.
     * 
     * @return the value of field 'UNbrRshsFMAgeMin'.
     */
    public int getUNbrRshsFMAgeMin()
    {
        return this._uNbrRshsFMAgeMin;
    } //-- int getUNbrRshsFMAgeMin() 

    /**
     * Returns the value of field 'uNbrRshsFacilCapacity'.
     * 
     * @return the value of field 'UNbrRshsFacilCapacity'.
     */
    public int getUNbrRshsFacilCapacity()
    {
        return this._uNbrRshsFacilCapacity;
    } //-- int getUNbrRshsFacilCapacity() 

    /**
     * Returns the value of field 'uNbrRshsIntChildren'.
     * 
     * @return the value of field 'UNbrRshsIntChildren'.
     */
    public int getUNbrRshsIntChildren()
    {
        return this._uNbrRshsIntChildren;
    } //-- int getUNbrRshsIntChildren() 

    /**
     * Returns the value of field 'uNbrRshsIntFeAgeMax'.
     * 
     * @return the value of field 'UNbrRshsIntFeAgeMax'.
     */
    public int getUNbrRshsIntFeAgeMax()
    {
        return this._uNbrRshsIntFeAgeMax;
    } //-- int getUNbrRshsIntFeAgeMax() 

    /**
     * Returns the value of field 'uNbrRshsIntFeAgeMin'.
     * 
     * @return the value of field 'UNbrRshsIntFeAgeMin'.
     */
    public int getUNbrRshsIntFeAgeMin()
    {
        return this._uNbrRshsIntFeAgeMin;
    } //-- int getUNbrRshsIntFeAgeMin() 

    /**
     * Returns the value of field 'uNbrRshsIntMaAgeMax'.
     * 
     * @return the value of field 'UNbrRshsIntMaAgeMax'.
     */
    public int getUNbrRshsIntMaAgeMax()
    {
        return this._uNbrRshsIntMaAgeMax;
    } //-- int getUNbrRshsIntMaAgeMax() 

    /**
     * Returns the value of field 'uNbrRshsIntMaAgeMin'.
     * 
     * @return the value of field 'UNbrRshsIntMaAgeMin'.
     */
    public int getUNbrRshsIntMaAgeMin()
    {
        return this._uNbrRshsIntMaAgeMin;
    } //-- int getUNbrRshsIntMaAgeMin() 

    /**
     * Returns the value of field 'uNbrRshsMaAgeMax'.
     * 
     * @return the value of field 'UNbrRshsMaAgeMax'.
     */
    public int getUNbrRshsMaAgeMax()
    {
        return this._uNbrRshsMaAgeMax;
    } //-- int getUNbrRshsMaAgeMax() 

    /**
     * Returns the value of field 'uNbrRshsMaAgeMin'.
     * 
     * @return the value of field 'UNbrRshsMaAgeMin'.
     */
    public int getUNbrRshsMaAgeMin()
    {
        return this._uNbrRshsMaAgeMin;
    } //-- int getUNbrRshsMaAgeMin() 

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
     * Returns the value of field 'ulIdResourceHistory'.
     * 
     * @return the value of field 'UlIdResourceHistory'.
     */
    public int getUlIdResourceHistory()
    {
        return this._ulIdResourceHistory;
    } //-- int getUlIdResourceHistory() 

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
     * Method hasDNbrRshsAnnualIncome
     * 
     * 
     * 
     * @return true if at least one DNbrRshsAnnualIncome has been
     * added
     */
    public boolean hasDNbrRshsAnnualIncome()
    {
        return this._has_dNbrRshsAnnualIncome;
    } //-- boolean hasDNbrRshsAnnualIncome() 

    /**
     * Method hasLNbrRshsCampusNbr
     * 
     * 
     * 
     * @return true if at least one LNbrRshsCampusNbr has been added
     */
    public boolean hasLNbrRshsCampusNbr()
    {
        return this._has_lNbrRshsCampusNbr;
    } //-- boolean hasLNbrRshsCampusNbr() 

    /**
     * Method hasLNbrRshsFacilAcclaim
     * 
     * 
     * 
     * @return true if at least one LNbrRshsFacilAcclaim has been
     * added
     */
    public boolean hasLNbrRshsFacilAcclaim()
    {
        return this._has_lNbrRshsFacilAcclaim;
    } //-- boolean hasLNbrRshsFacilAcclaim() 

    /**
     * Method hasSNbrRshsOpenSlots
     * 
     * 
     * 
     * @return true if at least one SNbrRshsOpenSlots has been added
     */
    public boolean hasSNbrRshsOpenSlots()
    {
        return this._has_sNbrRshsOpenSlots;
    } //-- boolean hasSNbrRshsOpenSlots() 

    /**
     * Method hasUNbrRshsFMAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRshsFMAgeMax has been added
     */
    public boolean hasUNbrRshsFMAgeMax()
    {
        return this._has_uNbrRshsFMAgeMax;
    } //-- boolean hasUNbrRshsFMAgeMax() 

    /**
     * Method hasUNbrRshsFMAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRshsFMAgeMin has been added
     */
    public boolean hasUNbrRshsFMAgeMin()
    {
        return this._has_uNbrRshsFMAgeMin;
    } //-- boolean hasUNbrRshsFMAgeMin() 

    /**
     * Method hasUNbrRshsFacilCapacity
     * 
     * 
     * 
     * @return true if at least one UNbrRshsFacilCapacity has been
     * added
     */
    public boolean hasUNbrRshsFacilCapacity()
    {
        return this._has_uNbrRshsFacilCapacity;
    } //-- boolean hasUNbrRshsFacilCapacity() 

    /**
     * Method hasUNbrRshsIntChildren
     * 
     * 
     * 
     * @return true if at least one UNbrRshsIntChildren has been
     * added
     */
    public boolean hasUNbrRshsIntChildren()
    {
        return this._has_uNbrRshsIntChildren;
    } //-- boolean hasUNbrRshsIntChildren() 

    /**
     * Method hasUNbrRshsIntFeAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRshsIntFeAgeMax has been
     * added
     */
    public boolean hasUNbrRshsIntFeAgeMax()
    {
        return this._has_uNbrRshsIntFeAgeMax;
    } //-- boolean hasUNbrRshsIntFeAgeMax() 

    /**
     * Method hasUNbrRshsIntFeAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRshsIntFeAgeMin has been
     * added
     */
    public boolean hasUNbrRshsIntFeAgeMin()
    {
        return this._has_uNbrRshsIntFeAgeMin;
    } //-- boolean hasUNbrRshsIntFeAgeMin() 

    /**
     * Method hasUNbrRshsIntMaAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRshsIntMaAgeMax has been
     * added
     */
    public boolean hasUNbrRshsIntMaAgeMax()
    {
        return this._has_uNbrRshsIntMaAgeMax;
    } //-- boolean hasUNbrRshsIntMaAgeMax() 

    /**
     * Method hasUNbrRshsIntMaAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRshsIntMaAgeMin has been
     * added
     */
    public boolean hasUNbrRshsIntMaAgeMin()
    {
        return this._has_uNbrRshsIntMaAgeMin;
    } //-- boolean hasUNbrRshsIntMaAgeMin() 

    /**
     * Method hasUNbrRshsMaAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRshsMaAgeMax has been added
     */
    public boolean hasUNbrRshsMaAgeMax()
    {
        return this._has_uNbrRshsMaAgeMax;
    } //-- boolean hasUNbrRshsMaAgeMax() 

    /**
     * Method hasUNbrRshsMaAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRshsMaAgeMin has been added
     */
    public boolean hasUNbrRshsMaAgeMin()
    {
        return this._has_uNbrRshsMaAgeMin;
    } //-- boolean hasUNbrRshsMaAgeMin() 

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
     * Method hasUlIdResourceHistory
     * 
     * 
     * 
     * @return true if at least one UlIdResourceHistory has been
     * added
     */
    public boolean hasUlIdResourceHistory()
    {
        return this._has_ulIdResourceHistory;
    } //-- boolean hasUlIdResourceHistory() 

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
     * Sets the value of field 'cCdRshsFaHomeType1'.
     * 
     * @param cCdRshsFaHomeType1 the value of field
     * 'cCdRshsFaHomeType1'.
     */
    public void setCCdRshsFaHomeType1(java.lang.String cCdRshsFaHomeType1)
    {
        this._cCdRshsFaHomeType1 = cCdRshsFaHomeType1;
    } //-- void setCCdRshsFaHomeType1(java.lang.String) 

    /**
     * Sets the value of field 'cIndCurrHomeStudyExists'.
     * 
     * @param cIndCurrHomeStudyExists the value of field
     * 'cIndCurrHomeStudyExists'.
     */
    public void setCIndCurrHomeStudyExists(java.lang.String cIndCurrHomeStudyExists)
    {
        this._cIndCurrHomeStudyExists = cIndCurrHomeStudyExists;
    } //-- void setCIndCurrHomeStudyExists(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsCareProv'.
     * 
     * @param cIndRshsCareProv the value of field 'cIndRshsCareProv'
     */
    public void setCIndRshsCareProv(java.lang.String cIndRshsCareProv)
    {
        this._cIndRshsCareProv = cIndRshsCareProv;
    } //-- void setCIndRshsCareProv(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsEmergPlace'.
     * 
     * @param cIndRshsEmergPlace the value of field
     * 'cIndRshsEmergPlace'.
     */
    public void setCIndRshsEmergPlace(java.lang.String cIndRshsEmergPlace)
    {
        this._cIndRshsEmergPlace = cIndRshsEmergPlace;
    } //-- void setCIndRshsEmergPlace(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsInactive'.
     * 
     * @param cIndRshsInactive the value of field 'cIndRshsInactive'
     */
    public void setCIndRshsInactive(java.lang.String cIndRshsInactive)
    {
        this._cIndRshsInactive = cIndRshsInactive;
    } //-- void setCIndRshsInactive(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsNonDFCSHome'.
     * 
     * @param cIndRshsNonDFCSHome the value of field
     * 'cIndRshsNonDFCSHome'.
     */
    public void setCIndRshsNonDFCSHome(java.lang.String cIndRshsNonDFCSHome)
    {
        this._cIndRshsNonDFCSHome = cIndRshsNonDFCSHome;
    } //-- void setCIndRshsNonDFCSHome(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsTransport'.
     * 
     * @param cIndRshsTransport the value of field
     * 'cIndRshsTransport'.
     */
    public void setCIndRshsTransport(java.lang.String cIndRshsTransport)
    {
        this._cIndRshsTransport = cIndRshsTransport;
    } //-- void setCIndRshsTransport(java.lang.String) 

    /**
     * Sets the value of field 'cIndRshsWriteHist'.
     * 
     * @param cIndRshsWriteHist the value of field
     * 'cIndRshsWriteHist'.
     */
    public void setCIndRshsWriteHist(java.lang.String cIndRshsWriteHist)
    {
        this._cIndRshsWriteHist = cIndRshsWriteHist;
    } //-- void setCIndRshsWriteHist(java.lang.String) 

    /**
     * Sets the value of field 'dNbrRshsAnnualIncome'.
     * 
     * @param dNbrRshsAnnualIncome the value of field
     * 'dNbrRshsAnnualIncome'.
     */
    public void setDNbrRshsAnnualIncome(double dNbrRshsAnnualIncome)
    {
        this._dNbrRshsAnnualIncome = dNbrRshsAnnualIncome;
        this._has_dNbrRshsAnnualIncome = true;
    } //-- void setDNbrRshsAnnualIncome(double) 

    /**
     * Sets the value of field 'dtDtRshsCert'.
     * 
     * @param dtDtRshsCert the value of field 'dtDtRshsCert'.
     */
    public void setDtDtRshsCert(org.exolab.castor.types.Date dtDtRshsCert)
    {
        this._dtDtRshsCert = dtDtRshsCert;
    } //-- void setDtDtRshsCert(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsClose'.
     * 
     * @param dtDtRshsClose the value of field 'dtDtRshsClose'.
     */
    public void setDtDtRshsClose(org.exolab.castor.types.Date dtDtRshsClose)
    {
        this._dtDtRshsClose = dtDtRshsClose;
    } //-- void setDtDtRshsClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsEffective'.
     * 
     * @param dtDtRshsEffective the value of field
     * 'dtDtRshsEffective'.
     */
    public void setDtDtRshsEffective(org.exolab.castor.types.Date dtDtRshsEffective)
    {
        this._dtDtRshsEffective = dtDtRshsEffective;
    } //-- void setDtDtRshsEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsEnd'.
     * 
     * @param dtDtRshsEnd the value of field 'dtDtRshsEnd'.
     */
    public void setDtDtRshsEnd(org.exolab.castor.types.Date dtDtRshsEnd)
    {
        this._dtDtRshsEnd = dtDtRshsEnd;
    } //-- void setDtDtRshsEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRshsMarriage'.
     * 
     * @param dtDtRshsMarriage the value of field 'dtDtRshsMarriage'
     */
    public void setDtDtRshsMarriage(org.exolab.castor.types.Date dtDtRshsMarriage)
    {
        this._dtDtRshsMarriage = dtDtRshsMarriage;
    } //-- void setDtDtRshsMarriage(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lAddrRshsZip'.
     * 
     * @param lAddrRshsZip the value of field 'lAddrRshsZip'.
     */
    public void setLAddrRshsZip(java.lang.String lAddrRshsZip)
    {
        this._lAddrRshsZip = lAddrRshsZip;
    } //-- void setLAddrRshsZip(java.lang.String) 

    /**
     * Sets the value of field 'lNbrRshsCampusNbr'.
     * 
     * @param lNbrRshsCampusNbr the value of field
     * 'lNbrRshsCampusNbr'.
     */
    public void setLNbrRshsCampusNbr(int lNbrRshsCampusNbr)
    {
        this._lNbrRshsCampusNbr = lNbrRshsCampusNbr;
        this._has_lNbrRshsCampusNbr = true;
    } //-- void setLNbrRshsCampusNbr(int) 

    /**
     * Sets the value of field 'lNbrRshsFacilAcclaim'.
     * 
     * @param lNbrRshsFacilAcclaim the value of field
     * 'lNbrRshsFacilAcclaim'.
     */
    public void setLNbrRshsFacilAcclaim(int lNbrRshsFacilAcclaim)
    {
        this._lNbrRshsFacilAcclaim = lNbrRshsFacilAcclaim;
        this._has_lNbrRshsFacilAcclaim = true;
    } //-- void setLNbrRshsFacilAcclaim(int) 

    /**
     * Sets the value of field 'lNbrRshsPhoneExtension'.
     * 
     * @param lNbrRshsPhoneExtension the value of field
     * 'lNbrRshsPhoneExtension'.
     */
    public void setLNbrRshsPhoneExtension(java.lang.String lNbrRshsPhoneExtension)
    {
        this._lNbrRshsPhoneExtension = lNbrRshsPhoneExtension;
    } //-- void setLNbrRshsPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'sNbrRshsOpenSlots'.
     * 
     * @param sNbrRshsOpenSlots the value of field
     * 'sNbrRshsOpenSlots'.
     */
    public void setSNbrRshsOpenSlots(int sNbrRshsOpenSlots)
    {
        this._sNbrRshsOpenSlots = sNbrRshsOpenSlots;
        this._has_sNbrRshsOpenSlots = true;
    } //-- void setSNbrRshsOpenSlots(int) 

    /**
     * Sets the value of field 'szAddrRshsAttn'.
     * 
     * @param szAddrRshsAttn the value of field 'szAddrRshsAttn'.
     */
    public void setSzAddrRshsAttn(java.lang.String szAddrRshsAttn)
    {
        this._szAddrRshsAttn = szAddrRshsAttn;
    } //-- void setSzAddrRshsAttn(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRshsCity'.
     * 
     * @param szAddrRshsCity the value of field 'szAddrRshsCity'.
     */
    public void setSzAddrRshsCity(java.lang.String szAddrRshsCity)
    {
        this._szAddrRshsCity = szAddrRshsCity;
    } //-- void setSzAddrRshsCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRshsStLn1'.
     * 
     * @param szAddrRshsStLn1 the value of field 'szAddrRshsStLn1'.
     */
    public void setSzAddrRshsStLn1(java.lang.String szAddrRshsStLn1)
    {
        this._szAddrRshsStLn1 = szAddrRshsStLn1;
    } //-- void setSzAddrRshsStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRshsStLn2'.
     * 
     * @param szAddrRshsStLn2 the value of field 'szAddrRshsStLn2'.
     */
    public void setSzAddrRshsStLn2(java.lang.String szAddrRshsStLn2)
    {
        this._szAddrRshsStLn2 = szAddrRshsStLn2;
    } //-- void setSzAddrRshsStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsCampusType'.
     * 
     * @param szCdRshsCampusType the value of field
     * 'szCdRshsCampusType'.
     */
    public void setSzCdRshsCampusType(java.lang.String szCdRshsCampusType)
    {
        this._szCdRshsCampusType = szCdRshsCampusType;
    } //-- void setSzCdRshsCampusType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsCategory'.
     * 
     * @param szCdRshsCategory the value of field 'szCdRshsCategory'
     */
    public void setSzCdRshsCategory(java.lang.String szCdRshsCategory)
    {
        this._szCdRshsCategory = szCdRshsCategory;
    } //-- void setSzCdRshsCategory(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsCertBy'.
     * 
     * @param szCdRshsCertBy the value of field 'szCdRshsCertBy'.
     */
    public void setSzCdRshsCertBy(java.lang.String szCdRshsCertBy)
    {
        this._szCdRshsCertBy = szCdRshsCertBy;
    } //-- void setSzCdRshsCertBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsClosureRsn'.
     * 
     * @param szCdRshsClosureRsn the value of field
     * 'szCdRshsClosureRsn'.
     */
    public void setSzCdRshsClosureRsn(java.lang.String szCdRshsClosureRsn)
    {
        this._szCdRshsClosureRsn = szCdRshsClosureRsn;
    } //-- void setSzCdRshsClosureRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsCnty'.
     * 
     * @param szCdRshsCnty the value of field 'szCdRshsCnty'.
     */
    public void setSzCdRshsCnty(java.lang.String szCdRshsCnty)
    {
        this._szCdRshsCnty = szCdRshsCnty;
    } //-- void setSzCdRshsCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsEthnicity'.
     * 
     * @param szCdRshsEthnicity the value of field
     * 'szCdRshsEthnicity'.
     */
    public void setSzCdRshsEthnicity(java.lang.String szCdRshsEthnicity)
    {
        this._szCdRshsEthnicity = szCdRshsEthnicity;
    } //-- void setSzCdRshsEthnicity(java.lang.String) 

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
     * Sets the value of field 'szCdRshsFacilType'.
     * 
     * @param szCdRshsFacilType the value of field
     * 'szCdRshsFacilType'.
     */
    public void setSzCdRshsFacilType(java.lang.String szCdRshsFacilType)
    {
        this._szCdRshsFacilType = szCdRshsFacilType;
    } //-- void setSzCdRshsFacilType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsHub'.
     * 
     * @param szCdRshsHub the value of field 'szCdRshsHub'.
     */
    public void setSzCdRshsHub(java.lang.String szCdRshsHub)
    {
        this._szCdRshsHub = szCdRshsHub;
    } //-- void setSzCdRshsHub(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsInvolClosure'.
     * 
     * @param szCdRshsInvolClosure the value of field
     * 'szCdRshsInvolClosure'.
     */
    public void setSzCdRshsInvolClosure(java.lang.String szCdRshsInvolClosure)
    {
        this._szCdRshsInvolClosure = szCdRshsInvolClosure;
    } //-- void setSzCdRshsInvolClosure(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsLanguage'.
     * 
     * @param szCdRshsLanguage the value of field 'szCdRshsLanguage'
     */
    public void setSzCdRshsLanguage(java.lang.String szCdRshsLanguage)
    {
        this._szCdRshsLanguage = szCdRshsLanguage;
    } //-- void setSzCdRshsLanguage(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsMaintainer'.
     * 
     * @param szCdRshsMaintainer the value of field
     * 'szCdRshsMaintainer'.
     */
    public void setSzCdRshsMaintainer(java.lang.String szCdRshsMaintainer)
    {
        this._szCdRshsMaintainer = szCdRshsMaintainer;
    } //-- void setSzCdRshsMaintainer(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsMaritalStatus'.
     * 
     * @param szCdRshsMaritalStatus the value of field
     * 'szCdRshsMaritalStatus'.
     */
    public void setSzCdRshsMaritalStatus(java.lang.String szCdRshsMaritalStatus)
    {
        this._szCdRshsMaritalStatus = szCdRshsMaritalStatus;
    } //-- void setSzCdRshsMaritalStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsOperBy'.
     * 
     * @param szCdRshsOperBy the value of field 'szCdRshsOperBy'.
     */
    public void setSzCdRshsOperBy(java.lang.String szCdRshsOperBy)
    {
        this._szCdRshsOperBy = szCdRshsOperBy;
    } //-- void setSzCdRshsOperBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsOwnership'.
     * 
     * @param szCdRshsOwnership the value of field
     * 'szCdRshsOwnership'.
     */
    public void setSzCdRshsOwnership(java.lang.String szCdRshsOwnership)
    {
        this._szCdRshsOwnership = szCdRshsOwnership;
    } //-- void setSzCdRshsOwnership(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsPayment'.
     * 
     * @param szCdRshsPayment the value of field 'szCdRshsPayment'.
     */
    public void setSzCdRshsPayment(java.lang.String szCdRshsPayment)
    {
        this._szCdRshsPayment = szCdRshsPayment;
    } //-- void setSzCdRshsPayment(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsRecmndReopen'.
     * 
     * @param szCdRshsRecmndReopen the value of field
     * 'szCdRshsRecmndReopen'.
     */
    public void setSzCdRshsRecmndReopen(java.lang.String szCdRshsRecmndReopen)
    {
        this._szCdRshsRecmndReopen = szCdRshsRecmndReopen;
    } //-- void setSzCdRshsRecmndReopen(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsRegion'.
     * 
     * @param szCdRshsRegion the value of field 'szCdRshsRegion'.
     */
    public void setSzCdRshsRegion(java.lang.String szCdRshsRegion)
    {
        this._szCdRshsRegion = szCdRshsRegion;
    } //-- void setSzCdRshsRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsReligion'.
     * 
     * @param szCdRshsReligion the value of field 'szCdRshsReligion'
     */
    public void setSzCdRshsReligion(java.lang.String szCdRshsReligion)
    {
        this._szCdRshsReligion = szCdRshsReligion;
    } //-- void setSzCdRshsReligion(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsRespite'.
     * 
     * @param szCdRshsRespite the value of field 'szCdRshsRespite'.
     */
    public void setSzCdRshsRespite(java.lang.String szCdRshsRespite)
    {
        this._szCdRshsRespite = szCdRshsRespite;
    } //-- void setSzCdRshsRespite(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsSchDist'.
     * 
     * @param szCdRshsSchDist the value of field 'szCdRshsSchDist'.
     */
    public void setSzCdRshsSchDist(java.lang.String szCdRshsSchDist)
    {
        this._szCdRshsSchDist = szCdRshsSchDist;
    } //-- void setSzCdRshsSchDist(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsSetting'.
     * 
     * @param szCdRshsSetting the value of field 'szCdRshsSetting'.
     */
    public void setSzCdRshsSetting(java.lang.String szCdRshsSetting)
    {
        this._szCdRshsSetting = szCdRshsSetting;
    } //-- void setSzCdRshsSetting(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsSourceInquiry'.
     * 
     * @param szCdRshsSourceInquiry the value of field
     * 'szCdRshsSourceInquiry'.
     */
    public void setSzCdRshsSourceInquiry(java.lang.String szCdRshsSourceInquiry)
    {
        this._szCdRshsSourceInquiry = szCdRshsSourceInquiry;
    } //-- void setSzCdRshsSourceInquiry(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsState'.
     * 
     * @param szCdRshsState the value of field 'szCdRshsState'.
     */
    public void setSzCdRshsState(java.lang.String szCdRshsState)
    {
        this._szCdRshsState = szCdRshsState;
    } //-- void setSzCdRshsState(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsStatus'.
     * 
     * @param szCdRshsStatus the value of field 'szCdRshsStatus'.
     */
    public void setSzCdRshsStatus(java.lang.String szCdRshsStatus)
    {
        this._szCdRshsStatus = szCdRshsStatus;
    } //-- void setSzCdRshsStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRshsType'.
     * 
     * @param szCdRshsType the value of field 'szCdRshsType'.
     */
    public void setSzCdRshsType(java.lang.String szCdRshsType)
    {
        this._szCdRshsType = szCdRshsType;
    } //-- void setSzCdRshsType(java.lang.String) 

    /**
     * Sets the value of field 'szNbrRshsPhn'.
     * 
     * @param szNbrRshsPhn the value of field 'szNbrRshsPhn'.
     */
    public void setSzNbrRshsPhn(java.lang.String szNbrRshsPhn)
    {
        this._szNbrRshsPhn = szNbrRshsPhn;
    } //-- void setSzNbrRshsPhn(java.lang.String) 

    /**
     * Sets the value of field 'szNbrRshsVid'.
     * 
     * @param szNbrRshsVid the value of field 'szNbrRshsVid'.
     */
    public void setSzNbrRshsVid(java.lang.String szNbrRshsVid)
    {
        this._szNbrRshsVid = szNbrRshsVid;
    } //-- void setSzNbrRshsVid(java.lang.String) 

    /**
     * Sets the value of field 'szNmRshsContact'.
     * 
     * @param szNmRshsContact the value of field 'szNmRshsContact'.
     */
    public void setSzNmRshsContact(java.lang.String szNmRshsContact)
    {
        this._szNmRshsContact = szNmRshsContact;
    } //-- void setSzNmRshsContact(java.lang.String) 

    /**
     * Sets the value of field 'szNmRshsLastUpdate'.
     * 
     * @param szNmRshsLastUpdate the value of field
     * 'szNmRshsLastUpdate'.
     */
    public void setSzNmRshsLastUpdate(java.lang.String szNmRshsLastUpdate)
    {
        this._szNmRshsLastUpdate = szNmRshsLastUpdate;
    } //-- void setSzNmRshsLastUpdate(java.lang.String) 

    /**
     * Sets the value of field 'szNmRshsResource'.
     * 
     * @param szNmRshsResource the value of field 'szNmRshsResource'
     */
    public void setSzNmRshsResource(java.lang.String szNmRshsResource)
    {
        this._szNmRshsResource = szNmRshsResource;
    } //-- void setSzNmRshsResource(java.lang.String) 

    /**
     * Sets the value of field 'szTxtNdfcsCertEntity'.
     * 
     * @param szTxtNdfcsCertEntity the value of field
     * 'szTxtNdfcsCertEntity'.
     */
    public void setSzTxtNdfcsCertEntity(java.lang.String szTxtNdfcsCertEntity)
    {
        this._szTxtNdfcsCertEntity = szTxtNdfcsCertEntity;
    } //-- void setSzTxtNdfcsCertEntity(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRshsAddrCmnts'.
     * 
     * @param szTxtRshsAddrCmnts the value of field
     * 'szTxtRshsAddrCmnts'.
     */
    public void setSzTxtRshsAddrCmnts(java.lang.String szTxtRshsAddrCmnts)
    {
        this._szTxtRshsAddrCmnts = szTxtRshsAddrCmnts;
    } //-- void setSzTxtRshsAddrCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRshsComments'.
     * 
     * @param szTxtRshsComments the value of field
     * 'szTxtRshsComments'.
     */
    public void setSzTxtRshsComments(java.lang.String szTxtRshsComments)
    {
        this._szTxtRshsComments = szTxtRshsComments;
    } //-- void setSzTxtRshsComments(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmGeneric1'.
     * 
     * @param tmScrTmGeneric1 the value of field 'tmScrTmGeneric1'.
     */
    public void setTmScrTmGeneric1(java.lang.String tmScrTmGeneric1)
    {
        this._tmScrTmGeneric1 = tmScrTmGeneric1;
    } //-- void setTmScrTmGeneric1(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmGeneric5'.
     * 
     * @param tmScrTmGeneric5 the value of field 'tmScrTmGeneric5'.
     */
    public void setTmScrTmGeneric5(java.lang.String tmScrTmGeneric5)
    {
        this._tmScrTmGeneric5 = tmScrTmGeneric5;
    } //-- void setTmScrTmGeneric5(java.lang.String) 

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
     * Sets the value of field 'uNbrRshsFMAgeMax'.
     * 
     * @param uNbrRshsFMAgeMax the value of field 'uNbrRshsFMAgeMax'
     */
    public void setUNbrRshsFMAgeMax(int uNbrRshsFMAgeMax)
    {
        this._uNbrRshsFMAgeMax = uNbrRshsFMAgeMax;
        this._has_uNbrRshsFMAgeMax = true;
    } //-- void setUNbrRshsFMAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRshsFMAgeMin'.
     * 
     * @param uNbrRshsFMAgeMin the value of field 'uNbrRshsFMAgeMin'
     */
    public void setUNbrRshsFMAgeMin(int uNbrRshsFMAgeMin)
    {
        this._uNbrRshsFMAgeMin = uNbrRshsFMAgeMin;
        this._has_uNbrRshsFMAgeMin = true;
    } //-- void setUNbrRshsFMAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRshsFacilCapacity'.
     * 
     * @param uNbrRshsFacilCapacity the value of field
     * 'uNbrRshsFacilCapacity'.
     */
    public void setUNbrRshsFacilCapacity(int uNbrRshsFacilCapacity)
    {
        this._uNbrRshsFacilCapacity = uNbrRshsFacilCapacity;
        this._has_uNbrRshsFacilCapacity = true;
    } //-- void setUNbrRshsFacilCapacity(int) 

    /**
     * Sets the value of field 'uNbrRshsIntChildren'.
     * 
     * @param uNbrRshsIntChildren the value of field
     * 'uNbrRshsIntChildren'.
     */
    public void setUNbrRshsIntChildren(int uNbrRshsIntChildren)
    {
        this._uNbrRshsIntChildren = uNbrRshsIntChildren;
        this._has_uNbrRshsIntChildren = true;
    } //-- void setUNbrRshsIntChildren(int) 

    /**
     * Sets the value of field 'uNbrRshsIntFeAgeMax'.
     * 
     * @param uNbrRshsIntFeAgeMax the value of field
     * 'uNbrRshsIntFeAgeMax'.
     */
    public void setUNbrRshsIntFeAgeMax(int uNbrRshsIntFeAgeMax)
    {
        this._uNbrRshsIntFeAgeMax = uNbrRshsIntFeAgeMax;
        this._has_uNbrRshsIntFeAgeMax = true;
    } //-- void setUNbrRshsIntFeAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRshsIntFeAgeMin'.
     * 
     * @param uNbrRshsIntFeAgeMin the value of field
     * 'uNbrRshsIntFeAgeMin'.
     */
    public void setUNbrRshsIntFeAgeMin(int uNbrRshsIntFeAgeMin)
    {
        this._uNbrRshsIntFeAgeMin = uNbrRshsIntFeAgeMin;
        this._has_uNbrRshsIntFeAgeMin = true;
    } //-- void setUNbrRshsIntFeAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRshsIntMaAgeMax'.
     * 
     * @param uNbrRshsIntMaAgeMax the value of field
     * 'uNbrRshsIntMaAgeMax'.
     */
    public void setUNbrRshsIntMaAgeMax(int uNbrRshsIntMaAgeMax)
    {
        this._uNbrRshsIntMaAgeMax = uNbrRshsIntMaAgeMax;
        this._has_uNbrRshsIntMaAgeMax = true;
    } //-- void setUNbrRshsIntMaAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRshsIntMaAgeMin'.
     * 
     * @param uNbrRshsIntMaAgeMin the value of field
     * 'uNbrRshsIntMaAgeMin'.
     */
    public void setUNbrRshsIntMaAgeMin(int uNbrRshsIntMaAgeMin)
    {
        this._uNbrRshsIntMaAgeMin = uNbrRshsIntMaAgeMin;
        this._has_uNbrRshsIntMaAgeMin = true;
    } //-- void setUNbrRshsIntMaAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRshsMaAgeMax'.
     * 
     * @param uNbrRshsMaAgeMax the value of field 'uNbrRshsMaAgeMax'
     */
    public void setUNbrRshsMaAgeMax(int uNbrRshsMaAgeMax)
    {
        this._uNbrRshsMaAgeMax = uNbrRshsMaAgeMax;
        this._has_uNbrRshsMaAgeMax = true;
    } //-- void setUNbrRshsMaAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRshsMaAgeMin'.
     * 
     * @param uNbrRshsMaAgeMin the value of field 'uNbrRshsMaAgeMin'
     */
    public void setUNbrRshsMaAgeMin(int uNbrRshsMaAgeMin)
    {
        this._uNbrRshsMaAgeMin = uNbrRshsMaAgeMin;
        this._has_uNbrRshsMaAgeMin = true;
    } //-- void setUNbrRshsMaAgeMin(int) 

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
     * Sets the value of field 'ulIdResourceHistory'.
     * 
     * @param ulIdResourceHistory the value of field
     * 'ulIdResourceHistory'.
     */
    public void setUlIdResourceHistory(int ulIdResourceHistory)
    {
        this._ulIdResourceHistory = ulIdResourceHistory;
        this._has_ulIdResourceHistory = true;
    } //-- void setUlIdResourceHistory(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00 unmarshal(java.io.Reader) 

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
