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
 * Class PersListRtrvStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PersListRtrvStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdStagePersType
     */
    private java.lang.String _szCdStagePersType;

    /**
     * Field _bIndStagePersCaller
     */
    private java.lang.String _bIndStagePersCaller;

    /**
     * Field _szCdStagePersLstSort
     */
    private java.lang.String _szCdStagePersLstSort;

    /**
     * Field _bScrIndPersIdentifiers
     */
    private java.lang.String _bScrIndPersIdentifiers;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _bIndPersonDobApprox
     */
    private java.lang.String _bIndPersonDobApprox;

    /**
     * Field _lNbrPersonAge
     */
    private int _lNbrPersonAge;

    /**
     * keeps track of state for field: _lNbrPersonAge
     */
    private boolean _has_lNbrPersonAge;

    /**
     * Field _cCdPersonSex
     */
    private java.lang.String _cCdPersonSex;

    /**
     * Field _szCdStagePersRelInt
     */
    private java.lang.String _szCdStagePersRelInt;

    /**
     * Field _bIndStagePersReporter
     */
    private java.lang.String _bIndStagePersReporter;

    /**
     * Field _szCdStagePersSearchInd
     */
    private java.lang.String _szCdStagePersSearchInd;

    /**
     * Field _bIndStagePersInLaw
     */
    private java.lang.String _bIndStagePersInLaw;

    /**
     * Field _dtDtPersonDeath
     */
    private org.exolab.castor.types.Date _dtDtPersonDeath;

    /**
     * Field _szCdPersonDeath
     */
    private java.lang.String _szCdPersonDeath;

    /**
     * Field _szCdPersonMaritalStatus
     */
    private java.lang.String _szCdPersonMaritalStatus;

    /**
     * Field _szCdPersonLanguage
     */
    private java.lang.String _szCdPersonLanguage;

    /**
     * Field _szCdDisasterRlf
     */
    private java.lang.String _szCdDisasterRlf;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _szTxtStagePersNotes
     */
    private java.lang.String _szTxtStagePersNotes;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _bScrIndAlias
     */
    private java.lang.String _bScrIndAlias;

    /**
     * Field _lScrNbrOfAddrs
     */
    private java.lang.String _lScrNbrOfAddrs;

    /**
     * Field _lScrNbrPhoneNbrs
     */
    private java.lang.String _lScrNbrPhoneNbrs;

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _dtDtNameEndDate
     */
    private org.exolab.castor.types.Date _dtDtNameEndDate;

    /**
     * Field _dtDtNameStartDate
     */
    private org.exolab.castor.types.Date _dtDtNameStartDate;

    /**
     * Field _bIndNameInvalid
     */
    private java.lang.String _bIndNameInvalid;

    /**
     * Field _szCdNameSuffix
     */
    private java.lang.String _szCdNameSuffix;

    /**
     * Field _szNbrPersonIdNumber
     */
    private java.lang.String _szNbrPersonIdNumber;

    /**
     * Field _bIndPersonIDInvalid
     */
    private java.lang.String _bIndPersonIDInvalid;

    /**
     * Field _dtPersonIDEnd
     */
    private org.exolab.castor.types.Date _dtPersonIDEnd;

    /**
     * Field _dtPersonIDStart
     */
    private org.exolab.castor.types.Date _dtPersonIDStart;

    /**
     * Field _szDescPersonID
     */
    private java.lang.String _szDescPersonID;

    /**
     * Field _szAddrPersAddrStLn1
     */
    private java.lang.String _szAddrPersAddrStLn1;

    /**
     * Field _szAddrPersAddrStLn2
     */
    private java.lang.String _szAddrPersAddrStLn2;

    /**
     * Field _szAddrCity
     */
    private java.lang.String _szAddrCity;

    /**
     * Field _lAddrZip
     */
    private java.lang.String _lAddrZip;

    /**
     * Field _szCdAddrCounty
     */
    private java.lang.String _szCdAddrCounty;

    /**
     * Field _szCdPersAddrLinkType
     */
    private java.lang.String _szCdPersAddrLinkType;

    /**
     * Field _bIndPersAddrLinkInvalid
     */
    private java.lang.String _bIndPersAddrLinkInvalid;

    /**
     * Field _dtDtPersAddrLinkEnd
     */
    private org.exolab.castor.types.Date _dtDtPersAddrLinkEnd;

    /**
     * Field _dtDtPersAddrLinkStart
     */
    private org.exolab.castor.types.Date _dtDtPersAddrLinkStart;

    /**
     * Field _szTxtPersAddrCmnts
     */
    private java.lang.String _szTxtPersAddrCmnts;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _lNbrPhoneExtension
     */
    private java.lang.String _lNbrPhoneExtension;

    /**
     * Field _szCdPhoneType
     */
    private java.lang.String _szCdPhoneType;

    /**
     * Field _dtDtPersonPhoneEnd
     */
    private org.exolab.castor.types.Date _dtDtPersonPhoneEnd;

    /**
     * Field _dtDtPersonPhoneStart
     */
    private org.exolab.castor.types.Date _dtDtPersonPhoneStart;

    /**
     * Field _bIndPersonPhoneInvalid
     */
    private java.lang.String _bIndPersonPhoneInvalid;

    /**
     * Field _szTxtPhoneComments
     */
    private java.lang.String _szTxtPhoneComments;

    /**
     * Field _szCdAddrState
     */
    private java.lang.String _szCdAddrState;

    /**
     * Field _ulIdName
     */
    private int _ulIdName;

    /**
     * keeps track of state for field: _ulIdName
     */
    private boolean _has_ulIdName;

    /**
     * Field _ldIdAddress
     */
    private int _ldIdAddress;

    /**
     * keeps track of state for field: _ldIdAddress
     */
    private boolean _has_ldIdAddress;

    /**
     * Field _ulIdPersonId
     */
    private int _ulIdPersonId;

    /**
     * keeps track of state for field: _ulIdPersonId
     */
    private boolean _has_ulIdPersonId;

    /**
     * Field _ulIdPhone
     */
    private int _ulIdPhone;

    /**
     * keeps track of state for field: _ulIdPhone
     */
    private boolean _has_ulIdPhone;

    /**
     * Field _ulIdAddrPersonLink
     */
    private int _ulIdAddrPersonLink;

    /**
     * keeps track of state for field: _ulIdAddrPersonLink
     */
    private boolean _has_ulIdAddrPersonLink;

    /**
     * Field _szCdIncmgPersTitle
     */
    private java.lang.String _szCdIncmgPersTitle;

    /**
     * Field _szCdIncmgPersMatchType
     */
    private java.lang.String _szCdIncmgPersMatchType;

    /**
     * Field _szCdIncmgPersPrfCitizenship
     */
    private java.lang.String _szCdIncmgPersPrfCitizenship;

    /**
     * Field _cIndIncmgPersUsCitizen
     */
    private java.lang.String _cIndIncmgPersUsCitizen;

    /**
     * Field _szCdIncmgPersImmgrtnStatus
     */
    private java.lang.String _szCdIncmgPersImmgrtnStatus;

    /**
     * Field _szCdIncmgPersCntryOrigin
     */
    private java.lang.String _szCdIncmgPersCntryOrigin;

    /**
     * Field _ulIdSecondaryCareGiver
     */
    private int _ulIdSecondaryCareGiver;

    /**
     * keeps track of state for field: _ulIdSecondaryCareGiver
     */
    private boolean _has_ulIdSecondaryCareGiver;

    /**
     * Field _szTxtStagePersOthRelations
     */
    private java.lang.String _szTxtStagePersOthRelations;

    /**
     * Field _cdPKHouseholdMember
     */
    private java.lang.String _cdPKHouseholdMember;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersListRtrvStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrPersonAge()
    {
        this._has_lNbrPersonAge= false;
    } //-- void deleteLNbrPersonAge() 

    /**
     */
    public void deleteLdIdAddress()
    {
        this._has_ldIdAddress= false;
    } //-- void deleteLdIdAddress() 

    /**
     */
    public void deleteUlIdAddrPersonLink()
    {
        this._has_ulIdAddrPersonLink= false;
    } //-- void deleteUlIdAddrPersonLink() 

    /**
     */
    public void deleteUlIdName()
    {
        this._has_ulIdName= false;
    } //-- void deleteUlIdName() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPersonId()
    {
        this._has_ulIdPersonId= false;
    } //-- void deleteUlIdPersonId() 

    /**
     */
    public void deleteUlIdPhone()
    {
        this._has_ulIdPhone= false;
    } //-- void deleteUlIdPhone() 

    /**
     */
    public void deleteUlIdSecondaryCareGiver()
    {
        this._has_ulIdSecondaryCareGiver= false;
    } //-- void deleteUlIdSecondaryCareGiver() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndNameInvalid'.
     * 
     * @return the value of field 'BIndNameInvalid'.
     */
    public java.lang.String getBIndNameInvalid()
    {
        return this._bIndNameInvalid;
    } //-- java.lang.String getBIndNameInvalid() 

    /**
     * Returns the value of field 'bIndPersAddrLinkInvalid'.
     * 
     * @return the value of field 'BIndPersAddrLinkInvalid'.
     */
    public java.lang.String getBIndPersAddrLinkInvalid()
    {
        return this._bIndPersAddrLinkInvalid;
    } //-- java.lang.String getBIndPersAddrLinkInvalid() 

    /**
     * Returns the value of field 'bIndPersonDobApprox'.
     * 
     * @return the value of field 'BIndPersonDobApprox'.
     */
    public java.lang.String getBIndPersonDobApprox()
    {
        return this._bIndPersonDobApprox;
    } //-- java.lang.String getBIndPersonDobApprox() 

    /**
     * Returns the value of field 'bIndPersonIDInvalid'.
     * 
     * @return the value of field 'BIndPersonIDInvalid'.
     */
    public java.lang.String getBIndPersonIDInvalid()
    {
        return this._bIndPersonIDInvalid;
    } //-- java.lang.String getBIndPersonIDInvalid() 

    /**
     * Returns the value of field 'bIndPersonPhoneInvalid'.
     * 
     * @return the value of field 'BIndPersonPhoneInvalid'.
     */
    public java.lang.String getBIndPersonPhoneInvalid()
    {
        return this._bIndPersonPhoneInvalid;
    } //-- java.lang.String getBIndPersonPhoneInvalid() 

    /**
     * Returns the value of field 'bIndStagePersCaller'.
     * 
     * @return the value of field 'BIndStagePersCaller'.
     */
    public java.lang.String getBIndStagePersCaller()
    {
        return this._bIndStagePersCaller;
    } //-- java.lang.String getBIndStagePersCaller() 

    /**
     * Returns the value of field 'bIndStagePersInLaw'.
     * 
     * @return the value of field 'BIndStagePersInLaw'.
     */
    public java.lang.String getBIndStagePersInLaw()
    {
        return this._bIndStagePersInLaw;
    } //-- java.lang.String getBIndStagePersInLaw() 

    /**
     * Returns the value of field 'bIndStagePersReporter'.
     * 
     * @return the value of field 'BIndStagePersReporter'.
     */
    public java.lang.String getBIndStagePersReporter()
    {
        return this._bIndStagePersReporter;
    } //-- java.lang.String getBIndStagePersReporter() 

    /**
     * Returns the value of field 'bScrIndAlias'.
     * 
     * @return the value of field 'BScrIndAlias'.
     */
    public java.lang.String getBScrIndAlias()
    {
        return this._bScrIndAlias;
    } //-- java.lang.String getBScrIndAlias() 

    /**
     * Returns the value of field 'bScrIndPersIdentifiers'.
     * 
     * @return the value of field 'BScrIndPersIdentifiers'.
     */
    public java.lang.String getBScrIndPersIdentifiers()
    {
        return this._bScrIndPersIdentifiers;
    } //-- java.lang.String getBScrIndPersIdentifiers() 

    /**
     * Returns the value of field 'cCdPersonSex'.
     * 
     * @return the value of field 'CCdPersonSex'.
     */
    public java.lang.String getCCdPersonSex()
    {
        return this._cCdPersonSex;
    } //-- java.lang.String getCCdPersonSex() 

    /**
     * Returns the value of field 'cIndIncmgPersUsCitizen'.
     * 
     * @return the value of field 'CIndIncmgPersUsCitizen'.
     */
    public java.lang.String getCIndIncmgPersUsCitizen()
    {
        return this._cIndIncmgPersUsCitizen;
    } //-- java.lang.String getCIndIncmgPersUsCitizen() 

    /**
     * Returns the value of field 'cdPKHouseholdMember'.
     * 
     * @return the value of field 'CdPKHouseholdMember'.
     */
    public java.lang.String getCdPKHouseholdMember()
    {
        return this._cdPKHouseholdMember;
    } //-- java.lang.String getCdPKHouseholdMember() 

    /**
     * Returns the value of field 'dtDtNameEndDate'.
     * 
     * @return the value of field 'DtDtNameEndDate'.
     */
    public org.exolab.castor.types.Date getDtDtNameEndDate()
    {
        return this._dtDtNameEndDate;
    } //-- org.exolab.castor.types.Date getDtDtNameEndDate() 

    /**
     * Returns the value of field 'dtDtNameStartDate'.
     * 
     * @return the value of field 'DtDtNameStartDate'.
     */
    public org.exolab.castor.types.Date getDtDtNameStartDate()
    {
        return this._dtDtNameStartDate;
    } //-- org.exolab.castor.types.Date getDtDtNameStartDate() 

    /**
     * Returns the value of field 'dtDtPersAddrLinkEnd'.
     * 
     * @return the value of field 'DtDtPersAddrLinkEnd'.
     */
    public org.exolab.castor.types.Date getDtDtPersAddrLinkEnd()
    {
        return this._dtDtPersAddrLinkEnd;
    } //-- org.exolab.castor.types.Date getDtDtPersAddrLinkEnd() 

    /**
     * Returns the value of field 'dtDtPersAddrLinkStart'.
     * 
     * @return the value of field 'DtDtPersAddrLinkStart'.
     */
    public org.exolab.castor.types.Date getDtDtPersAddrLinkStart()
    {
        return this._dtDtPersAddrLinkStart;
    } //-- org.exolab.castor.types.Date getDtDtPersAddrLinkStart() 

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
     * Returns the value of field 'dtDtPersonDeath'.
     * 
     * @return the value of field 'DtDtPersonDeath'.
     */
    public org.exolab.castor.types.Date getDtDtPersonDeath()
    {
        return this._dtDtPersonDeath;
    } //-- org.exolab.castor.types.Date getDtDtPersonDeath() 

    /**
     * Returns the value of field 'dtDtPersonPhoneEnd'.
     * 
     * @return the value of field 'DtDtPersonPhoneEnd'.
     */
    public org.exolab.castor.types.Date getDtDtPersonPhoneEnd()
    {
        return this._dtDtPersonPhoneEnd;
    } //-- org.exolab.castor.types.Date getDtDtPersonPhoneEnd() 

    /**
     * Returns the value of field 'dtDtPersonPhoneStart'.
     * 
     * @return the value of field 'DtDtPersonPhoneStart'.
     */
    public org.exolab.castor.types.Date getDtDtPersonPhoneStart()
    {
        return this._dtDtPersonPhoneStart;
    } //-- org.exolab.castor.types.Date getDtDtPersonPhoneStart() 

    /**
     * Returns the value of field 'dtPersonIDEnd'.
     * 
     * @return the value of field 'DtPersonIDEnd'.
     */
    public org.exolab.castor.types.Date getDtPersonIDEnd()
    {
        return this._dtPersonIDEnd;
    } //-- org.exolab.castor.types.Date getDtPersonIDEnd() 

    /**
     * Returns the value of field 'dtPersonIDStart'.
     * 
     * @return the value of field 'DtPersonIDStart'.
     */
    public org.exolab.castor.types.Date getDtPersonIDStart()
    {
        return this._dtPersonIDStart;
    } //-- org.exolab.castor.types.Date getDtPersonIDStart() 

    /**
     * Returns the value of field 'lAddrZip'.
     * 
     * @return the value of field 'LAddrZip'.
     */
    public java.lang.String getLAddrZip()
    {
        return this._lAddrZip;
    } //-- java.lang.String getLAddrZip() 

    /**
     * Returns the value of field 'lNbrPersonAge'.
     * 
     * @return the value of field 'LNbrPersonAge'.
     */
    public int getLNbrPersonAge()
    {
        return this._lNbrPersonAge;
    } //-- int getLNbrPersonAge() 

    /**
     * Returns the value of field 'lNbrPhone'.
     * 
     * @return the value of field 'LNbrPhone'.
     */
    public java.lang.String getLNbrPhone()
    {
        return this._lNbrPhone;
    } //-- java.lang.String getLNbrPhone() 

    /**
     * Returns the value of field 'lNbrPhoneExtension'.
     * 
     * @return the value of field 'LNbrPhoneExtension'.
     */
    public java.lang.String getLNbrPhoneExtension()
    {
        return this._lNbrPhoneExtension;
    } //-- java.lang.String getLNbrPhoneExtension() 

    /**
     * Returns the value of field 'lScrNbrOfAddrs'.
     * 
     * @return the value of field 'LScrNbrOfAddrs'.
     */
    public java.lang.String getLScrNbrOfAddrs()
    {
        return this._lScrNbrOfAddrs;
    } //-- java.lang.String getLScrNbrOfAddrs() 

    /**
     * Returns the value of field 'lScrNbrPhoneNbrs'.
     * 
     * @return the value of field 'LScrNbrPhoneNbrs'.
     */
    public java.lang.String getLScrNbrPhoneNbrs()
    {
        return this._lScrNbrPhoneNbrs;
    } //-- java.lang.String getLScrNbrPhoneNbrs() 

    /**
     * Returns the value of field 'ldIdAddress'.
     * 
     * @return the value of field 'LdIdAddress'.
     */
    public int getLdIdAddress()
    {
        return this._ldIdAddress;
    } //-- int getLdIdAddress() 

    /**
     * Returns the value of field 'szAddrCity'.
     * 
     * @return the value of field 'SzAddrCity'.
     */
    public java.lang.String getSzAddrCity()
    {
        return this._szAddrCity;
    } //-- java.lang.String getSzAddrCity() 

    /**
     * Returns the value of field 'szAddrPersAddrStLn1'.
     * 
     * @return the value of field 'SzAddrPersAddrStLn1'.
     */
    public java.lang.String getSzAddrPersAddrStLn1()
    {
        return this._szAddrPersAddrStLn1;
    } //-- java.lang.String getSzAddrPersAddrStLn1() 

    /**
     * Returns the value of field 'szAddrPersAddrStLn2'.
     * 
     * @return the value of field 'SzAddrPersAddrStLn2'.
     */
    public java.lang.String getSzAddrPersAddrStLn2()
    {
        return this._szAddrPersAddrStLn2;
    } //-- java.lang.String getSzAddrPersAddrStLn2() 

    /**
     * Returns the value of field 'szCdAddrCounty'.
     * 
     * @return the value of field 'SzCdAddrCounty'.
     */
    public java.lang.String getSzCdAddrCounty()
    {
        return this._szCdAddrCounty;
    } //-- java.lang.String getSzCdAddrCounty() 

    /**
     * Returns the value of field 'szCdAddrState'.
     * 
     * @return the value of field 'SzCdAddrState'.
     */
    public java.lang.String getSzCdAddrState()
    {
        return this._szCdAddrState;
    } //-- java.lang.String getSzCdAddrState() 

    /**
     * Returns the value of field 'szCdDisasterRlf'.
     * 
     * @return the value of field 'SzCdDisasterRlf'.
     */
    public java.lang.String getSzCdDisasterRlf()
    {
        return this._szCdDisasterRlf;
    } //-- java.lang.String getSzCdDisasterRlf() 

    /**
     * Returns the value of field 'szCdIncmgPersCntryOrigin'.
     * 
     * @return the value of field 'SzCdIncmgPersCntryOrigin'.
     */
    public java.lang.String getSzCdIncmgPersCntryOrigin()
    {
        return this._szCdIncmgPersCntryOrigin;
    } //-- java.lang.String getSzCdIncmgPersCntryOrigin() 

    /**
     * Returns the value of field 'szCdIncmgPersImmgrtnStatus'.
     * 
     * @return the value of field 'SzCdIncmgPersImmgrtnStatus'.
     */
    public java.lang.String getSzCdIncmgPersImmgrtnStatus()
    {
        return this._szCdIncmgPersImmgrtnStatus;
    } //-- java.lang.String getSzCdIncmgPersImmgrtnStatus() 

    /**
     * Returns the value of field 'szCdIncmgPersMatchType'.
     * 
     * @return the value of field 'SzCdIncmgPersMatchType'.
     */
    public java.lang.String getSzCdIncmgPersMatchType()
    {
        return this._szCdIncmgPersMatchType;
    } //-- java.lang.String getSzCdIncmgPersMatchType() 

    /**
     * Returns the value of field 'szCdIncmgPersPrfCitizenship'.
     * 
     * @return the value of field 'SzCdIncmgPersPrfCitizenship'.
     */
    public java.lang.String getSzCdIncmgPersPrfCitizenship()
    {
        return this._szCdIncmgPersPrfCitizenship;
    } //-- java.lang.String getSzCdIncmgPersPrfCitizenship() 

    /**
     * Returns the value of field 'szCdIncmgPersTitle'.
     * 
     * @return the value of field 'SzCdIncmgPersTitle'.
     */
    public java.lang.String getSzCdIncmgPersTitle()
    {
        return this._szCdIncmgPersTitle;
    } //-- java.lang.String getSzCdIncmgPersTitle() 

    /**
     * Returns the value of field 'szCdNameSuffix'.
     * 
     * @return the value of field 'SzCdNameSuffix'.
     */
    public java.lang.String getSzCdNameSuffix()
    {
        return this._szCdNameSuffix;
    } //-- java.lang.String getSzCdNameSuffix() 

    /**
     * Returns the value of field 'szCdPersAddrLinkType'.
     * 
     * @return the value of field 'SzCdPersAddrLinkType'.
     */
    public java.lang.String getSzCdPersAddrLinkType()
    {
        return this._szCdPersAddrLinkType;
    } //-- java.lang.String getSzCdPersAddrLinkType() 

    /**
     * Returns the value of field 'szCdPersonDeath'.
     * 
     * @return the value of field 'SzCdPersonDeath'.
     */
    public java.lang.String getSzCdPersonDeath()
    {
        return this._szCdPersonDeath;
    } //-- java.lang.String getSzCdPersonDeath() 

    /**
     * Returns the value of field 'szCdPersonEthnicGroup'.
     * 
     * @return the value of field 'SzCdPersonEthnicGroup'.
     */
    public java.lang.String getSzCdPersonEthnicGroup()
    {
        return this._szCdPersonEthnicGroup;
    } //-- java.lang.String getSzCdPersonEthnicGroup() 

    /**
     * Returns the value of field 'szCdPersonLanguage'.
     * 
     * @return the value of field 'SzCdPersonLanguage'.
     */
    public java.lang.String getSzCdPersonLanguage()
    {
        return this._szCdPersonLanguage;
    } //-- java.lang.String getSzCdPersonLanguage() 

    /**
     * Returns the value of field 'szCdPersonMaritalStatus'.
     * 
     * @return the value of field 'SzCdPersonMaritalStatus'.
     */
    public java.lang.String getSzCdPersonMaritalStatus()
    {
        return this._szCdPersonMaritalStatus;
    } //-- java.lang.String getSzCdPersonMaritalStatus() 

    /**
     * Returns the value of field 'szCdPhoneType'.
     * 
     * @return the value of field 'SzCdPhoneType'.
     */
    public java.lang.String getSzCdPhoneType()
    {
        return this._szCdPhoneType;
    } //-- java.lang.String getSzCdPhoneType() 

    /**
     * Returns the value of field 'szCdStagePersLstSort'.
     * 
     * @return the value of field 'SzCdStagePersLstSort'.
     */
    public java.lang.String getSzCdStagePersLstSort()
    {
        return this._szCdStagePersLstSort;
    } //-- java.lang.String getSzCdStagePersLstSort() 

    /**
     * Returns the value of field 'szCdStagePersRelInt'.
     * 
     * @return the value of field 'SzCdStagePersRelInt'.
     */
    public java.lang.String getSzCdStagePersRelInt()
    {
        return this._szCdStagePersRelInt;
    } //-- java.lang.String getSzCdStagePersRelInt() 

    /**
     * Returns the value of field 'szCdStagePersRole'.
     * 
     * @return the value of field 'SzCdStagePersRole'.
     */
    public java.lang.String getSzCdStagePersRole()
    {
        return this._szCdStagePersRole;
    } //-- java.lang.String getSzCdStagePersRole() 

    /**
     * Returns the value of field 'szCdStagePersSearchInd'.
     * 
     * @return the value of field 'SzCdStagePersSearchInd'.
     */
    public java.lang.String getSzCdStagePersSearchInd()
    {
        return this._szCdStagePersSearchInd;
    } //-- java.lang.String getSzCdStagePersSearchInd() 

    /**
     * Returns the value of field 'szCdStagePersType'.
     * 
     * @return the value of field 'SzCdStagePersType'.
     */
    public java.lang.String getSzCdStagePersType()
    {
        return this._szCdStagePersType;
    } //-- java.lang.String getSzCdStagePersType() 

    /**
     * Returns the value of field 'szDescPersonID'.
     * 
     * @return the value of field 'SzDescPersonID'.
     */
    public java.lang.String getSzDescPersonID()
    {
        return this._szDescPersonID;
    } //-- java.lang.String getSzDescPersonID() 

    /**
     * Returns the value of field 'szNbrPersonIdNumber'.
     * 
     * @return the value of field 'SzNbrPersonIdNumber'.
     */
    public java.lang.String getSzNbrPersonIdNumber()
    {
        return this._szNbrPersonIdNumber;
    } //-- java.lang.String getSzNbrPersonIdNumber() 

    /**
     * Returns the value of field 'szNmNameFirst'.
     * 
     * @return the value of field 'SzNmNameFirst'.
     */
    public java.lang.String getSzNmNameFirst()
    {
        return this._szNmNameFirst;
    } //-- java.lang.String getSzNmNameFirst() 

    /**
     * Returns the value of field 'szNmNameLast'.
     * 
     * @return the value of field 'SzNmNameLast'.
     */
    public java.lang.String getSzNmNameLast()
    {
        return this._szNmNameLast;
    } //-- java.lang.String getSzNmNameLast() 

    /**
     * Returns the value of field 'szNmNameMiddle'.
     * 
     * @return the value of field 'SzNmNameMiddle'.
     */
    public java.lang.String getSzNmNameMiddle()
    {
        return this._szNmNameMiddle;
    } //-- java.lang.String getSzNmNameMiddle() 

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
     * Returns the value of field 'szTxtPersAddrCmnts'.
     * 
     * @return the value of field 'SzTxtPersAddrCmnts'.
     */
    public java.lang.String getSzTxtPersAddrCmnts()
    {
        return this._szTxtPersAddrCmnts;
    } //-- java.lang.String getSzTxtPersAddrCmnts() 

    /**
     * Returns the value of field 'szTxtPhoneComments'.
     * 
     * @return the value of field 'SzTxtPhoneComments'.
     */
    public java.lang.String getSzTxtPhoneComments()
    {
        return this._szTxtPhoneComments;
    } //-- java.lang.String getSzTxtPhoneComments() 

    /**
     * Returns the value of field 'szTxtStagePersNotes'.
     * 
     * @return the value of field 'SzTxtStagePersNotes'.
     */
    public java.lang.String getSzTxtStagePersNotes()
    {
        return this._szTxtStagePersNotes;
    } //-- java.lang.String getSzTxtStagePersNotes() 

    /**
     * Returns the value of field 'szTxtStagePersOthRelations'.
     * 
     * @return the value of field 'SzTxtStagePersOthRelations'.
     */
    public java.lang.String getSzTxtStagePersOthRelations()
    {
        return this._szTxtStagePersOthRelations;
    } //-- java.lang.String getSzTxtStagePersOthRelations() 

    /**
     * Returns the value of field 'ulIdAddrPersonLink'.
     * 
     * @return the value of field 'UlIdAddrPersonLink'.
     */
    public int getUlIdAddrPersonLink()
    {
        return this._ulIdAddrPersonLink;
    } //-- int getUlIdAddrPersonLink() 

    /**
     * Returns the value of field 'ulIdName'.
     * 
     * @return the value of field 'UlIdName'.
     */
    public int getUlIdName()
    {
        return this._ulIdName;
    } //-- int getUlIdName() 

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
     * Returns the value of field 'ulIdPersonId'.
     * 
     * @return the value of field 'UlIdPersonId'.
     */
    public int getUlIdPersonId()
    {
        return this._ulIdPersonId;
    } //-- int getUlIdPersonId() 

    /**
     * Returns the value of field 'ulIdPhone'.
     * 
     * @return the value of field 'UlIdPhone'.
     */
    public int getUlIdPhone()
    {
        return this._ulIdPhone;
    } //-- int getUlIdPhone() 

    /**
     * Returns the value of field 'ulIdSecondaryCareGiver'.
     * 
     * @return the value of field 'UlIdSecondaryCareGiver'.
     */
    public int getUlIdSecondaryCareGiver()
    {
        return this._ulIdSecondaryCareGiver;
    } //-- int getUlIdSecondaryCareGiver() 

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
     * Method hasLNbrPersonAge
     * 
     * 
     * 
     * @return true if at least one LNbrPersonAge has been added
     */
    public boolean hasLNbrPersonAge()
    {
        return this._has_lNbrPersonAge;
    } //-- boolean hasLNbrPersonAge() 

    /**
     * Method hasLdIdAddress
     * 
     * 
     * 
     * @return true if at least one LdIdAddress has been added
     */
    public boolean hasLdIdAddress()
    {
        return this._has_ldIdAddress;
    } //-- boolean hasLdIdAddress() 

    /**
     * Method hasUlIdAddrPersonLink
     * 
     * 
     * 
     * @return true if at least one UlIdAddrPersonLink has been adde
     */
    public boolean hasUlIdAddrPersonLink()
    {
        return this._has_ulIdAddrPersonLink;
    } //-- boolean hasUlIdAddrPersonLink() 

    /**
     * Method hasUlIdName
     * 
     * 
     * 
     * @return true if at least one UlIdName has been added
     */
    public boolean hasUlIdName()
    {
        return this._has_ulIdName;
    } //-- boolean hasUlIdName() 

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
     * Method hasUlIdPersonId
     * 
     * 
     * 
     * @return true if at least one UlIdPersonId has been added
     */
    public boolean hasUlIdPersonId()
    {
        return this._has_ulIdPersonId;
    } //-- boolean hasUlIdPersonId() 

    /**
     * Method hasUlIdPhone
     * 
     * 
     * 
     * @return true if at least one UlIdPhone has been added
     */
    public boolean hasUlIdPhone()
    {
        return this._has_ulIdPhone;
    } //-- boolean hasUlIdPhone() 

    /**
     * Method hasUlIdSecondaryCareGiver
     * 
     * 
     * 
     * @return true if at least one UlIdSecondaryCareGiver has been
     * added
     */
    public boolean hasUlIdSecondaryCareGiver()
    {
        return this._has_ulIdSecondaryCareGiver;
    } //-- boolean hasUlIdSecondaryCareGiver() 

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
     * Sets the value of field 'bIndNameInvalid'.
     * 
     * @param bIndNameInvalid the value of field 'bIndNameInvalid'.
     */
    public void setBIndNameInvalid(java.lang.String bIndNameInvalid)
    {
        this._bIndNameInvalid = bIndNameInvalid;
    } //-- void setBIndNameInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndPersAddrLinkInvalid'.
     * 
     * @param bIndPersAddrLinkInvalid the value of field
     * 'bIndPersAddrLinkInvalid'.
     */
    public void setBIndPersAddrLinkInvalid(java.lang.String bIndPersAddrLinkInvalid)
    {
        this._bIndPersAddrLinkInvalid = bIndPersAddrLinkInvalid;
    } //-- void setBIndPersAddrLinkInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndPersonDobApprox'.
     * 
     * @param bIndPersonDobApprox the value of field
     * 'bIndPersonDobApprox'.
     */
    public void setBIndPersonDobApprox(java.lang.String bIndPersonDobApprox)
    {
        this._bIndPersonDobApprox = bIndPersonDobApprox;
    } //-- void setBIndPersonDobApprox(java.lang.String) 

    /**
     * Sets the value of field 'bIndPersonIDInvalid'.
     * 
     * @param bIndPersonIDInvalid the value of field
     * 'bIndPersonIDInvalid'.
     */
    public void setBIndPersonIDInvalid(java.lang.String bIndPersonIDInvalid)
    {
        this._bIndPersonIDInvalid = bIndPersonIDInvalid;
    } //-- void setBIndPersonIDInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndPersonPhoneInvalid'.
     * 
     * @param bIndPersonPhoneInvalid the value of field
     * 'bIndPersonPhoneInvalid'.
     */
    public void setBIndPersonPhoneInvalid(java.lang.String bIndPersonPhoneInvalid)
    {
        this._bIndPersonPhoneInvalid = bIndPersonPhoneInvalid;
    } //-- void setBIndPersonPhoneInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersCaller'.
     * 
     * @param bIndStagePersCaller the value of field
     * 'bIndStagePersCaller'.
     */
    public void setBIndStagePersCaller(java.lang.String bIndStagePersCaller)
    {
        this._bIndStagePersCaller = bIndStagePersCaller;
    } //-- void setBIndStagePersCaller(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersInLaw'.
     * 
     * @param bIndStagePersInLaw the value of field
     * 'bIndStagePersInLaw'.
     */
    public void setBIndStagePersInLaw(java.lang.String bIndStagePersInLaw)
    {
        this._bIndStagePersInLaw = bIndStagePersInLaw;
    } //-- void setBIndStagePersInLaw(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersReporter'.
     * 
     * @param bIndStagePersReporter the value of field
     * 'bIndStagePersReporter'.
     */
    public void setBIndStagePersReporter(java.lang.String bIndStagePersReporter)
    {
        this._bIndStagePersReporter = bIndStagePersReporter;
    } //-- void setBIndStagePersReporter(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndAlias'.
     * 
     * @param bScrIndAlias the value of field 'bScrIndAlias'.
     */
    public void setBScrIndAlias(java.lang.String bScrIndAlias)
    {
        this._bScrIndAlias = bScrIndAlias;
    } //-- void setBScrIndAlias(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndPersIdentifiers'.
     * 
     * @param bScrIndPersIdentifiers the value of field
     * 'bScrIndPersIdentifiers'.
     */
    public void setBScrIndPersIdentifiers(java.lang.String bScrIndPersIdentifiers)
    {
        this._bScrIndPersIdentifiers = bScrIndPersIdentifiers;
    } //-- void setBScrIndPersIdentifiers(java.lang.String) 

    /**
     * Sets the value of field 'cCdPersonSex'.
     * 
     * @param cCdPersonSex the value of field 'cCdPersonSex'.
     */
    public void setCCdPersonSex(java.lang.String cCdPersonSex)
    {
        this._cCdPersonSex = cCdPersonSex;
    } //-- void setCCdPersonSex(java.lang.String) 

    /**
     * Sets the value of field 'cIndIncmgPersUsCitizen'.
     * 
     * @param cIndIncmgPersUsCitizen the value of field
     * 'cIndIncmgPersUsCitizen'.
     */
    public void setCIndIncmgPersUsCitizen(java.lang.String cIndIncmgPersUsCitizen)
    {
        this._cIndIncmgPersUsCitizen = cIndIncmgPersUsCitizen;
    } //-- void setCIndIncmgPersUsCitizen(java.lang.String) 

    /**
     * Sets the value of field 'cdPKHouseholdMember'.
     * 
     * @param cdPKHouseholdMember the value of field
     * 'cdPKHouseholdMember'.
     */
    public void setCdPKHouseholdMember(java.lang.String cdPKHouseholdMember)
    {
        this._cdPKHouseholdMember = cdPKHouseholdMember;
    } //-- void setCdPKHouseholdMember(java.lang.String) 

    /**
     * Sets the value of field 'dtDtNameEndDate'.
     * 
     * @param dtDtNameEndDate the value of field 'dtDtNameEndDate'.
     */
    public void setDtDtNameEndDate(org.exolab.castor.types.Date dtDtNameEndDate)
    {
        this._dtDtNameEndDate = dtDtNameEndDate;
    } //-- void setDtDtNameEndDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtNameStartDate'.
     * 
     * @param dtDtNameStartDate the value of field
     * 'dtDtNameStartDate'.
     */
    public void setDtDtNameStartDate(org.exolab.castor.types.Date dtDtNameStartDate)
    {
        this._dtDtNameStartDate = dtDtNameStartDate;
    } //-- void setDtDtNameStartDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersAddrLinkEnd'.
     * 
     * @param dtDtPersAddrLinkEnd the value of field
     * 'dtDtPersAddrLinkEnd'.
     */
    public void setDtDtPersAddrLinkEnd(org.exolab.castor.types.Date dtDtPersAddrLinkEnd)
    {
        this._dtDtPersAddrLinkEnd = dtDtPersAddrLinkEnd;
    } //-- void setDtDtPersAddrLinkEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersAddrLinkStart'.
     * 
     * @param dtDtPersAddrLinkStart the value of field
     * 'dtDtPersAddrLinkStart'.
     */
    public void setDtDtPersAddrLinkStart(org.exolab.castor.types.Date dtDtPersAddrLinkStart)
    {
        this._dtDtPersAddrLinkStart = dtDtPersAddrLinkStart;
    } //-- void setDtDtPersAddrLinkStart(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'dtDtPersonDeath'.
     * 
     * @param dtDtPersonDeath the value of field 'dtDtPersonDeath'.
     */
    public void setDtDtPersonDeath(org.exolab.castor.types.Date dtDtPersonDeath)
    {
        this._dtDtPersonDeath = dtDtPersonDeath;
    } //-- void setDtDtPersonDeath(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersonPhoneEnd'.
     * 
     * @param dtDtPersonPhoneEnd the value of field
     * 'dtDtPersonPhoneEnd'.
     */
    public void setDtDtPersonPhoneEnd(org.exolab.castor.types.Date dtDtPersonPhoneEnd)
    {
        this._dtDtPersonPhoneEnd = dtDtPersonPhoneEnd;
    } //-- void setDtDtPersonPhoneEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersonPhoneStart'.
     * 
     * @param dtDtPersonPhoneStart the value of field
     * 'dtDtPersonPhoneStart'.
     */
    public void setDtDtPersonPhoneStart(org.exolab.castor.types.Date dtDtPersonPhoneStart)
    {
        this._dtDtPersonPhoneStart = dtDtPersonPhoneStart;
    } //-- void setDtDtPersonPhoneStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtPersonIDEnd'.
     * 
     * @param dtPersonIDEnd the value of field 'dtPersonIDEnd'.
     */
    public void setDtPersonIDEnd(org.exolab.castor.types.Date dtPersonIDEnd)
    {
        this._dtPersonIDEnd = dtPersonIDEnd;
    } //-- void setDtPersonIDEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtPersonIDStart'.
     * 
     * @param dtPersonIDStart the value of field 'dtPersonIDStart'.
     */
    public void setDtPersonIDStart(org.exolab.castor.types.Date dtPersonIDStart)
    {
        this._dtPersonIDStart = dtPersonIDStart;
    } //-- void setDtPersonIDStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lAddrZip'.
     * 
     * @param lAddrZip the value of field 'lAddrZip'.
     */
    public void setLAddrZip(java.lang.String lAddrZip)
    {
        this._lAddrZip = lAddrZip;
    } //-- void setLAddrZip(java.lang.String) 

    /**
     * Sets the value of field 'lNbrPersonAge'.
     * 
     * @param lNbrPersonAge the value of field 'lNbrPersonAge'.
     */
    public void setLNbrPersonAge(int lNbrPersonAge)
    {
        this._lNbrPersonAge = lNbrPersonAge;
        this._has_lNbrPersonAge = true;
    } //-- void setLNbrPersonAge(int) 

    /**
     * Sets the value of field 'lNbrPhone'.
     * 
     * @param lNbrPhone the value of field 'lNbrPhone'.
     */
    public void setLNbrPhone(java.lang.String lNbrPhone)
    {
        this._lNbrPhone = lNbrPhone;
    } //-- void setLNbrPhone(java.lang.String) 

    /**
     * Sets the value of field 'lNbrPhoneExtension'.
     * 
     * @param lNbrPhoneExtension the value of field
     * 'lNbrPhoneExtension'.
     */
    public void setLNbrPhoneExtension(java.lang.String lNbrPhoneExtension)
    {
        this._lNbrPhoneExtension = lNbrPhoneExtension;
    } //-- void setLNbrPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'lScrNbrOfAddrs'.
     * 
     * @param lScrNbrOfAddrs the value of field 'lScrNbrOfAddrs'.
     */
    public void setLScrNbrOfAddrs(java.lang.String lScrNbrOfAddrs)
    {
        this._lScrNbrOfAddrs = lScrNbrOfAddrs;
    } //-- void setLScrNbrOfAddrs(java.lang.String) 

    /**
     * Sets the value of field 'lScrNbrPhoneNbrs'.
     * 
     * @param lScrNbrPhoneNbrs the value of field 'lScrNbrPhoneNbrs'
     */
    public void setLScrNbrPhoneNbrs(java.lang.String lScrNbrPhoneNbrs)
    {
        this._lScrNbrPhoneNbrs = lScrNbrPhoneNbrs;
    } //-- void setLScrNbrPhoneNbrs(java.lang.String) 

    /**
     * Sets the value of field 'ldIdAddress'.
     * 
     * @param ldIdAddress the value of field 'ldIdAddress'.
     */
    public void setLdIdAddress(int ldIdAddress)
    {
        this._ldIdAddress = ldIdAddress;
        this._has_ldIdAddress = true;
    } //-- void setLdIdAddress(int) 

    /**
     * Sets the value of field 'szAddrCity'.
     * 
     * @param szAddrCity the value of field 'szAddrCity'.
     */
    public void setSzAddrCity(java.lang.String szAddrCity)
    {
        this._szAddrCity = szAddrCity;
    } //-- void setSzAddrCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPersAddrStLn1'.
     * 
     * @param szAddrPersAddrStLn1 the value of field
     * 'szAddrPersAddrStLn1'.
     */
    public void setSzAddrPersAddrStLn1(java.lang.String szAddrPersAddrStLn1)
    {
        this._szAddrPersAddrStLn1 = szAddrPersAddrStLn1;
    } //-- void setSzAddrPersAddrStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPersAddrStLn2'.
     * 
     * @param szAddrPersAddrStLn2 the value of field
     * 'szAddrPersAddrStLn2'.
     */
    public void setSzAddrPersAddrStLn2(java.lang.String szAddrPersAddrStLn2)
    {
        this._szAddrPersAddrStLn2 = szAddrPersAddrStLn2;
    } //-- void setSzAddrPersAddrStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szCdAddrCounty'.
     * 
     * @param szCdAddrCounty the value of field 'szCdAddrCounty'.
     */
    public void setSzCdAddrCounty(java.lang.String szCdAddrCounty)
    {
        this._szCdAddrCounty = szCdAddrCounty;
    } //-- void setSzCdAddrCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdAddrState'.
     * 
     * @param szCdAddrState the value of field 'szCdAddrState'.
     */
    public void setSzCdAddrState(java.lang.String szCdAddrState)
    {
        this._szCdAddrState = szCdAddrState;
    } //-- void setSzCdAddrState(java.lang.String) 

    /**
     * Sets the value of field 'szCdDisasterRlf'.
     * 
     * @param szCdDisasterRlf the value of field 'szCdDisasterRlf'.
     */
    public void setSzCdDisasterRlf(java.lang.String szCdDisasterRlf)
    {
        this._szCdDisasterRlf = szCdDisasterRlf;
    } //-- void setSzCdDisasterRlf(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersCntryOrigin'.
     * 
     * @param szCdIncmgPersCntryOrigin the value of field
     * 'szCdIncmgPersCntryOrigin'.
     */
    public void setSzCdIncmgPersCntryOrigin(java.lang.String szCdIncmgPersCntryOrigin)
    {
        this._szCdIncmgPersCntryOrigin = szCdIncmgPersCntryOrigin;
    } //-- void setSzCdIncmgPersCntryOrigin(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersImmgrtnStatus'.
     * 
     * @param szCdIncmgPersImmgrtnStatus the value of field
     * 'szCdIncmgPersImmgrtnStatus'.
     */
    public void setSzCdIncmgPersImmgrtnStatus(java.lang.String szCdIncmgPersImmgrtnStatus)
    {
        this._szCdIncmgPersImmgrtnStatus = szCdIncmgPersImmgrtnStatus;
    } //-- void setSzCdIncmgPersImmgrtnStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersMatchType'.
     * 
     * @param szCdIncmgPersMatchType the value of field
     * 'szCdIncmgPersMatchType'.
     */
    public void setSzCdIncmgPersMatchType(java.lang.String szCdIncmgPersMatchType)
    {
        this._szCdIncmgPersMatchType = szCdIncmgPersMatchType;
    } //-- void setSzCdIncmgPersMatchType(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersPrfCitizenship'.
     * 
     * @param szCdIncmgPersPrfCitizenship the value of field
     * 'szCdIncmgPersPrfCitizenship'.
     */
    public void setSzCdIncmgPersPrfCitizenship(java.lang.String szCdIncmgPersPrfCitizenship)
    {
        this._szCdIncmgPersPrfCitizenship = szCdIncmgPersPrfCitizenship;
    } //-- void setSzCdIncmgPersPrfCitizenship(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncmgPersTitle'.
     * 
     * @param szCdIncmgPersTitle the value of field
     * 'szCdIncmgPersTitle'.
     */
    public void setSzCdIncmgPersTitle(java.lang.String szCdIncmgPersTitle)
    {
        this._szCdIncmgPersTitle = szCdIncmgPersTitle;
    } //-- void setSzCdIncmgPersTitle(java.lang.String) 

    /**
     * Sets the value of field 'szCdNameSuffix'.
     * 
     * @param szCdNameSuffix the value of field 'szCdNameSuffix'.
     */
    public void setSzCdNameSuffix(java.lang.String szCdNameSuffix)
    {
        this._szCdNameSuffix = szCdNameSuffix;
    } //-- void setSzCdNameSuffix(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersAddrLinkType'.
     * 
     * @param szCdPersAddrLinkType the value of field
     * 'szCdPersAddrLinkType'.
     */
    public void setSzCdPersAddrLinkType(java.lang.String szCdPersAddrLinkType)
    {
        this._szCdPersAddrLinkType = szCdPersAddrLinkType;
    } //-- void setSzCdPersAddrLinkType(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonDeath'.
     * 
     * @param szCdPersonDeath the value of field 'szCdPersonDeath'.
     */
    public void setSzCdPersonDeath(java.lang.String szCdPersonDeath)
    {
        this._szCdPersonDeath = szCdPersonDeath;
    } //-- void setSzCdPersonDeath(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonEthnicGroup'.
     * 
     * @param szCdPersonEthnicGroup the value of field
     * 'szCdPersonEthnicGroup'.
     */
    public void setSzCdPersonEthnicGroup(java.lang.String szCdPersonEthnicGroup)
    {
        this._szCdPersonEthnicGroup = szCdPersonEthnicGroup;
    } //-- void setSzCdPersonEthnicGroup(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonLanguage'.
     * 
     * @param szCdPersonLanguage the value of field
     * 'szCdPersonLanguage'.
     */
    public void setSzCdPersonLanguage(java.lang.String szCdPersonLanguage)
    {
        this._szCdPersonLanguage = szCdPersonLanguage;
    } //-- void setSzCdPersonLanguage(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonMaritalStatus'.
     * 
     * @param szCdPersonMaritalStatus the value of field
     * 'szCdPersonMaritalStatus'.
     */
    public void setSzCdPersonMaritalStatus(java.lang.String szCdPersonMaritalStatus)
    {
        this._szCdPersonMaritalStatus = szCdPersonMaritalStatus;
    } //-- void setSzCdPersonMaritalStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdPhoneType'.
     * 
     * @param szCdPhoneType the value of field 'szCdPhoneType'.
     */
    public void setSzCdPhoneType(java.lang.String szCdPhoneType)
    {
        this._szCdPhoneType = szCdPhoneType;
    } //-- void setSzCdPhoneType(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersLstSort'.
     * 
     * @param szCdStagePersLstSort the value of field
     * 'szCdStagePersLstSort'.
     */
    public void setSzCdStagePersLstSort(java.lang.String szCdStagePersLstSort)
    {
        this._szCdStagePersLstSort = szCdStagePersLstSort;
    } //-- void setSzCdStagePersLstSort(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRelInt'.
     * 
     * @param szCdStagePersRelInt the value of field
     * 'szCdStagePersRelInt'.
     */
    public void setSzCdStagePersRelInt(java.lang.String szCdStagePersRelInt)
    {
        this._szCdStagePersRelInt = szCdStagePersRelInt;
    } //-- void setSzCdStagePersRelInt(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRole'.
     * 
     * @param szCdStagePersRole the value of field
     * 'szCdStagePersRole'.
     */
    public void setSzCdStagePersRole(java.lang.String szCdStagePersRole)
    {
        this._szCdStagePersRole = szCdStagePersRole;
    } //-- void setSzCdStagePersRole(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersSearchInd'.
     * 
     * @param szCdStagePersSearchInd the value of field
     * 'szCdStagePersSearchInd'.
     */
    public void setSzCdStagePersSearchInd(java.lang.String szCdStagePersSearchInd)
    {
        this._szCdStagePersSearchInd = szCdStagePersSearchInd;
    } //-- void setSzCdStagePersSearchInd(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersType'.
     * 
     * @param szCdStagePersType the value of field
     * 'szCdStagePersType'.
     */
    public void setSzCdStagePersType(java.lang.String szCdStagePersType)
    {
        this._szCdStagePersType = szCdStagePersType;
    } //-- void setSzCdStagePersType(java.lang.String) 

    /**
     * Sets the value of field 'szDescPersonID'.
     * 
     * @param szDescPersonID the value of field 'szDescPersonID'.
     */
    public void setSzDescPersonID(java.lang.String szDescPersonID)
    {
        this._szDescPersonID = szDescPersonID;
    } //-- void setSzDescPersonID(java.lang.String) 

    /**
     * Sets the value of field 'szNbrPersonIdNumber'.
     * 
     * @param szNbrPersonIdNumber the value of field
     * 'szNbrPersonIdNumber'.
     */
    public void setSzNbrPersonIdNumber(java.lang.String szNbrPersonIdNumber)
    {
        this._szNbrPersonIdNumber = szNbrPersonIdNumber;
    } //-- void setSzNbrPersonIdNumber(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameFirst'.
     * 
     * @param szNmNameFirst the value of field 'szNmNameFirst'.
     */
    public void setSzNmNameFirst(java.lang.String szNmNameFirst)
    {
        this._szNmNameFirst = szNmNameFirst;
    } //-- void setSzNmNameFirst(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameLast'.
     * 
     * @param szNmNameLast the value of field 'szNmNameLast'.
     */
    public void setSzNmNameLast(java.lang.String szNmNameLast)
    {
        this._szNmNameLast = szNmNameLast;
    } //-- void setSzNmNameLast(java.lang.String) 

    /**
     * Sets the value of field 'szNmNameMiddle'.
     * 
     * @param szNmNameMiddle the value of field 'szNmNameMiddle'.
     */
    public void setSzNmNameMiddle(java.lang.String szNmNameMiddle)
    {
        this._szNmNameMiddle = szNmNameMiddle;
    } //-- void setSzNmNameMiddle(java.lang.String) 

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
     * Sets the value of field 'szTxtPersAddrCmnts'.
     * 
     * @param szTxtPersAddrCmnts the value of field
     * 'szTxtPersAddrCmnts'.
     */
    public void setSzTxtPersAddrCmnts(java.lang.String szTxtPersAddrCmnts)
    {
        this._szTxtPersAddrCmnts = szTxtPersAddrCmnts;
    } //-- void setSzTxtPersAddrCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPhoneComments'.
     * 
     * @param szTxtPhoneComments the value of field
     * 'szTxtPhoneComments'.
     */
    public void setSzTxtPhoneComments(java.lang.String szTxtPhoneComments)
    {
        this._szTxtPhoneComments = szTxtPhoneComments;
    } //-- void setSzTxtPhoneComments(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStagePersNotes'.
     * 
     * @param szTxtStagePersNotes the value of field
     * 'szTxtStagePersNotes'.
     */
    public void setSzTxtStagePersNotes(java.lang.String szTxtStagePersNotes)
    {
        this._szTxtStagePersNotes = szTxtStagePersNotes;
    } //-- void setSzTxtStagePersNotes(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStagePersOthRelations'.
     * 
     * @param szTxtStagePersOthRelations the value of field
     * 'szTxtStagePersOthRelations'.
     */
    public void setSzTxtStagePersOthRelations(java.lang.String szTxtStagePersOthRelations)
    {
        this._szTxtStagePersOthRelations = szTxtStagePersOthRelations;
    } //-- void setSzTxtStagePersOthRelations(java.lang.String) 

    /**
     * Sets the value of field 'ulIdAddrPersonLink'.
     * 
     * @param ulIdAddrPersonLink the value of field
     * 'ulIdAddrPersonLink'.
     */
    public void setUlIdAddrPersonLink(int ulIdAddrPersonLink)
    {
        this._ulIdAddrPersonLink = ulIdAddrPersonLink;
        this._has_ulIdAddrPersonLink = true;
    } //-- void setUlIdAddrPersonLink(int) 

    /**
     * Sets the value of field 'ulIdName'.
     * 
     * @param ulIdName the value of field 'ulIdName'.
     */
    public void setUlIdName(int ulIdName)
    {
        this._ulIdName = ulIdName;
        this._has_ulIdName = true;
    } //-- void setUlIdName(int) 

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
     * Sets the value of field 'ulIdPersonId'.
     * 
     * @param ulIdPersonId the value of field 'ulIdPersonId'.
     */
    public void setUlIdPersonId(int ulIdPersonId)
    {
        this._ulIdPersonId = ulIdPersonId;
        this._has_ulIdPersonId = true;
    } //-- void setUlIdPersonId(int) 

    /**
     * Sets the value of field 'ulIdPhone'.
     * 
     * @param ulIdPhone the value of field 'ulIdPhone'.
     */
    public void setUlIdPhone(int ulIdPhone)
    {
        this._ulIdPhone = ulIdPhone;
        this._has_ulIdPhone = true;
    } //-- void setUlIdPhone(int) 

    /**
     * Sets the value of field 'ulIdSecondaryCareGiver'.
     * 
     * @param ulIdSecondaryCareGiver the value of field
     * 'ulIdSecondaryCareGiver'.
     */
    public void setUlIdSecondaryCareGiver(int ulIdSecondaryCareGiver)
    {
        this._ulIdSecondaryCareGiver = ulIdSecondaryCareGiver;
        this._has_ulIdSecondaryCareGiver = true;
    } //-- void setUlIdSecondaryCareGiver(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct unmarshal(java.io.Reader) 

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
