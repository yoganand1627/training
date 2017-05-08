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
 * Class CINV05SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV05SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _pageModeStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.PageModeStruct _pageModeStruct;

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _ROWCINV26SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY _ROWCINV26SIG00_ARRAY;

    /**
     * Field _CINV05SIG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY _CINV05SIG_ARRAY;

    /**
     * Field _CINV05SI_ADD_PERSON_TO_STAGES_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY _CINV05SI_ADD_PERSON_TO_STAGES_ARRAY;

    /**
     * Field _szCdStagePersSearchInd
     */
    private java.lang.String _szCdStagePersSearchInd;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _bCdPersonChar
     */
    private java.lang.String _bCdPersonChar;

    /**
     * Field _bCdPersNotYetDiag
     */
    private java.lang.String _bCdPersNotYetDiag;

    /**
     * Field _bSysIndCreateToDo
     */
    private java.lang.String _bSysIndCreateToDo;

    /**
     * Field _szCdPersGuardCnsrv
     */
    private java.lang.String _szCdPersGuardCnsrv;

    /**
     * Field _szCdPersonDeath
     */
    private java.lang.String _szCdPersonDeath;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _szCdPersonLanguage
     */
    private java.lang.String _szCdPersonLanguage;

    /**
     * Field _szCdPersonMaritalStatus
     */
    private java.lang.String _szCdPersonMaritalStatus;

    /**
     * Field _szTxtMaidenName
     */
    private java.lang.String _szTxtMaidenName;

    /**
     * Field _szCdPersonRelationship
     */
    private java.lang.String _szCdPersonRelationship;

    /**
     * Field _szCdPersonReligion
     */
    private java.lang.String _szCdPersonReligion;

    /**
     * Field _cCdPersonSex
     */
    private java.lang.String _cCdPersonSex;

    /**
     * Field _szCdDisasterRlf
     */
    private java.lang.String _szCdDisasterRlf;

    /**
     * Field _cdPersonStatus
     */
    private java.lang.String _cdPersonStatus;

    /**
     * Field _szCdPersonLivArr
     */
    private java.lang.String _szCdPersonLivArr;

    /**
     * Field _szCdStagePersType
     */
    private java.lang.String _szCdStagePersType;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _szCdStagePersRelInt
     */
    private java.lang.String _szCdStagePersRelInt;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _dtDtLegRepAssigned
     */
    private org.exolab.castor.types.Date _dtDtLegRepAssigned;

    /**
     * Field _dtDtLegRepUnassigned
     */
    private org.exolab.castor.types.Date _dtDtLegRepUnassigned;

    /**
     * Field _szCdPersonBirthCity
     */
    private java.lang.String _szCdPersonBirthCity;

    /**
     * Field _szCdPersonBirthState
     */
    private java.lang.String _szCdPersonBirthState;

    /**
     * Field _szCdPersonBirthCounty
     */
    private java.lang.String _szCdPersonBirthCounty;

    /**
     * Field _szCdPersonBirthCountry
     */
    private java.lang.String _szCdPersonBirthCountry;

    /**
     * Field _szCdMotherMarried
     */
    private java.lang.String _szCdMotherMarried;

    /**
     * Field _cdPKHouseholdMember
     */
    private java.lang.String _cdPKHouseholdMember;

    /**
     * Field _dtDtEntryUS
     */
    private org.exolab.castor.types.Date _dtDtEntryUS;

    /**
     * Field _bIndPaternityEst
     */
    private java.lang.String _bIndPaternityEst;

    /**
     * Field _bIndLegalCust
     */
    private java.lang.String _bIndLegalCust;

    /**
     * Field _bIndSsnCheck
     */
    private boolean _bIndSsnCheck;

    /**
     * keeps track of state for field: _bIndSsnCheck
     */
    private boolean _has_bIndSsnCheck;

    /**
     * Field _bIndSafetyRsrc
     */
    private java.lang.String _bIndSafetyRsrc;

    /**
     * Field _bIndRsrcHouseholdMember
     */
    private java.lang.String _bIndRsrcHouseholdMember;

    /**
     * Field _bIndVerified
     */
    private java.lang.String _bIndVerified;

    /**
     * Field _dtDtPersonDeath
     */
    private org.exolab.castor.types.Date _dtDtPersonDeath;

    /**
     * Field _szNbrPersonSSN
     */
    private java.lang.String _szNbrPersonSSN;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdStagePerson
     */
    private int _ulIdStagePerson;

    /**
     * keeps track of state for field: _ulIdStagePerson
     */
    private boolean _has_ulIdStagePerson;

    /**
     * Field _bIndStagePersInLaw
     */
    private java.lang.String _bIndStagePersInLaw;

    /**
     * Field _bIndPersonDobApprox
     */
    private java.lang.String _bIndPersonDobApprox;

    /**
     * Field _bIndStagePersReporter
     */
    private java.lang.String _bIndStagePersReporter;

    /**
     * Field _lNbrPersonAge
     */
    private int _lNbrPersonAge;

    /**
     * keeps track of state for field: _lNbrPersonAge
     */
    private boolean _has_lNbrPersonAge;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _szCdTitle
     */
    private java.lang.String _szCdTitle;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szCdProofCitizen
     */
    private java.lang.String _szCdProofCitizen;

    /**
     * Field _bIndUSCitizen
     */
    private java.lang.String _bIndUSCitizen;

    /**
     * Field _szCdImmigrationStatus
     */
    private java.lang.String _szCdImmigrationStatus;

    /**
     * Field _szCdCntryOfOrigin
     */
    private java.lang.String _szCdCntryOfOrigin;

    /**
     * Field _ulIdPrimaryCareGiver
     */
    private int _ulIdPrimaryCareGiver;

    /**
     * keeps track of state for field: _ulIdPrimaryCareGiver
     */
    private boolean _has_ulIdPrimaryCareGiver;

    /**
     * Field _ulIdSecondaryCareGiver
     */
    private int _ulIdSecondaryCareGiver;

    /**
     * keeps track of state for field: _ulIdSecondaryCareGiver
     */
    private boolean _has_ulIdSecondaryCareGiver;

    /**
     * Field _ulIdPutativeFather
     */
    private int _ulIdPutativeFather;

    /**
     * keeps track of state for field: _ulIdPutativeFather
     */
    private boolean _has_ulIdPutativeFather;

    /**
     * Field _ulIdLegalFather
     */
    private int _ulIdLegalFather;

    /**
     * keeps track of state for field: _ulIdLegalFather
     */
    private boolean _has_ulIdLegalFather;

    /**
     * Field _ulIdBioFather
     */
    private int _ulIdBioFather;

    /**
     * keeps track of state for field: _ulIdBioFather
     */
    private boolean _has_ulIdBioFather;

    /**
     * Field _ulIdLegalMother
     */
    private int _ulIdLegalMother;

    /**
     * keeps track of state for field: _ulIdLegalMother
     */
    private boolean _has_ulIdLegalMother;

    /**
     * Field _ulIdBioMother
     */
    private int _ulIdBioMother;

    /**
     * keeps track of state for field: _ulIdBioMother
     */
    private boolean _has_ulIdBioMother;

    /**
     * Field _szCdSideOfFamily
     */
    private java.lang.String _szCdSideOfFamily;

    /**
     * Field _szCdPersonEyeColor
     */
    private java.lang.String _szCdPersonEyeColor;

    /**
     * Field _lQtyPersonWeight
     */
    private int _lQtyPersonWeight;

    /**
     * keeps track of state for field: _lQtyPersonWeight
     */
    private boolean _has_lQtyPersonWeight;

    /**
     * Field _sQtyPersonHeightFeet
     */
    private int _sQtyPersonHeightFeet;

    /**
     * keeps track of state for field: _sQtyPersonHeightFeet
     */
    private boolean _has_sQtyPersonHeightFeet;

    /**
     * Field _sQtyPersonHeightInches
     */
    private int _sQtyPersonHeightInches;

    /**
     * keeps track of state for field: _sQtyPersonHeightInches
     */
    private boolean _has_sQtyPersonHeightInches;

    /**
     * Field _szCdPersonHairColor
     */
    private java.lang.String _szCdPersonHairColor;

    /**
     * Field _szCdPersonHighestEduc
     */
    private java.lang.String _szCdPersonHighestEduc;

    /**
     * Field _szTxtOtherRelationshipsCmnts
     */
    private java.lang.String _szTxtOtherRelationshipsCmnts;

    /**
     * Field _szTxtPercentHeritage
     */
    private java.lang.String _szTxtPercentHeritage;

    /**
     * Field _szTxtTribalName
     */
    private java.lang.String _szTxtTribalName;

    /**
     * Field _szTxtTribalRegistryNumber
     */
    private java.lang.String _szTxtTribalRegistryNumber;

    /**
     * Field _bScrIndTribalMember
     */
    private java.lang.String _bScrIndTribalMember;

    /**
     * Field _bScrIndRegisteredWithTribe
     */
    private java.lang.String _bScrIndRegisteredWithTribe;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szSysCdWinMode
     */
    private java.lang.String _szSysCdWinMode;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _tsSysTsLastUpdate3
     */
    private java.util.Date _tsSysTsLastUpdate3;

    /**
     * Field _szTxtOccupation
     */
    private java.lang.String _szTxtOccupation;

    /**
     * Field _szTxtStagePersNotes
     */
    private java.lang.String _szTxtStagePersNotes;

    /**
     * Field _szCdCategoryCategory_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY _szCdCategoryCategory_ARRAY;

    /**
     * Field _ulIdTodoPersAssigned
     */
    private int _ulIdTodoPersAssigned;

    /**
     * keeps track of state for field: _ulIdTodoPersAssigned
     */
    private boolean _has_ulIdTodoPersAssigned;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _ulIdPersonId
     */
    private int _ulIdPersonId;

    /**
     * keeps track of state for field: _ulIdPersonId
     */
    private boolean _has_ulIdPersonId;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _bIndChkd
     */
    private java.lang.String _bIndChkd;

    /**
     * Field _szTxtAddlCmnts
     */
    private java.lang.String _szTxtAddlCmnts;

    /**
     * Field _szTxtEmail
     */
    private java.lang.String _szTxtEmail;

    /**
     * Field _ROWCINV05SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01_ARRAY _ROWCINV05SIG01_ARRAY;

    /**
     * Field _ROWCINV05SIG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02_ARRAY _ROWCINV05SIG02_ARRAY;

    /**
     * Field _bIndRecordsCheckNav
     */
    private java.lang.String _bIndRecordsCheckNav;

    /**
     * Field _cIndSsiAppSubmitted
     */
    private java.lang.String _cIndSsiAppSubmitted;

    /**
     * Field _cIndSsiMedDsbltyReqMet
     */
    private java.lang.String _cIndSsiMedDsbltyReqMet;

    /**
     * Field _cIndSsiRecipient
     */
    private java.lang.String _cIndSsiRecipient;

    /**
     * Field _cIndSsiDfcsPayee
     */
    private java.lang.String _cIndSsiDfcsPayee;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV05SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndSsnCheck()
    {
        this._has_bIndSsnCheck= false;
    } //-- void deleteBIndSsnCheck() 

    /**
     */
    public void deleteLNbrPersonAge()
    {
        this._has_lNbrPersonAge= false;
    } //-- void deleteLNbrPersonAge() 

    /**
     */
    public void deleteLQtyPersonWeight()
    {
        this._has_lQtyPersonWeight= false;
    } //-- void deleteLQtyPersonWeight() 

    /**
     */
    public void deleteSQtyPersonHeightFeet()
    {
        this._has_sQtyPersonHeightFeet= false;
    } //-- void deleteSQtyPersonHeightFeet() 

    /**
     */
    public void deleteSQtyPersonHeightInches()
    {
        this._has_sQtyPersonHeightInches= false;
    } //-- void deleteSQtyPersonHeightInches() 

    /**
     */
    public void deleteUlIdBioFather()
    {
        this._has_ulIdBioFather= false;
    } //-- void deleteUlIdBioFather() 

    /**
     */
    public void deleteUlIdBioMother()
    {
        this._has_ulIdBioMother= false;
    } //-- void deleteUlIdBioMother() 

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
    public void deleteUlIdLegalFather()
    {
        this._has_ulIdLegalFather= false;
    } //-- void deleteUlIdLegalFather() 

    /**
     */
    public void deleteUlIdLegalMother()
    {
        this._has_ulIdLegalMother= false;
    } //-- void deleteUlIdLegalMother() 

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
    public void deleteUlIdPrimaryCareGiver()
    {
        this._has_ulIdPrimaryCareGiver= false;
    } //-- void deleteUlIdPrimaryCareGiver() 

    /**
     */
    public void deleteUlIdPutativeFather()
    {
        this._has_ulIdPutativeFather= false;
    } //-- void deleteUlIdPutativeFather() 

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
     */
    public void deleteUlIdStagePerson()
    {
        this._has_ulIdStagePerson= false;
    } //-- void deleteUlIdStagePerson() 

    /**
     */
    public void deleteUlIdTodoPersAssigned()
    {
        this._has_ulIdTodoPersAssigned= false;
    } //-- void deleteUlIdTodoPersAssigned() 

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
     * Returns the value of field 'bCdPersNotYetDiag'.
     * 
     * @return the value of field 'BCdPersNotYetDiag'.
     */
    public java.lang.String getBCdPersNotYetDiag()
    {
        return this._bCdPersNotYetDiag;
    } //-- java.lang.String getBCdPersNotYetDiag() 

    /**
     * Returns the value of field 'bCdPersonChar'.
     * 
     * @return the value of field 'BCdPersonChar'.
     */
    public java.lang.String getBCdPersonChar()
    {
        return this._bCdPersonChar;
    } //-- java.lang.String getBCdPersonChar() 

    /**
     * Returns the value of field 'bIndChkd'.
     * 
     * @return the value of field 'BIndChkd'.
     */
    public java.lang.String getBIndChkd()
    {
        return this._bIndChkd;
    } //-- java.lang.String getBIndChkd() 

    /**
     * Returns the value of field 'bIndLegalCust'.
     * 
     * @return the value of field 'BIndLegalCust'.
     */
    public java.lang.String getBIndLegalCust()
    {
        return this._bIndLegalCust;
    } //-- java.lang.String getBIndLegalCust() 

    /**
     * Returns the value of field 'bIndPaternityEst'.
     * 
     * @return the value of field 'BIndPaternityEst'.
     */
    public java.lang.String getBIndPaternityEst()
    {
        return this._bIndPaternityEst;
    } //-- java.lang.String getBIndPaternityEst() 

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
     * Returns the value of field 'bIndRecordsCheckNav'.
     * 
     * @return the value of field 'BIndRecordsCheckNav'.
     */
    public java.lang.String getBIndRecordsCheckNav()
    {
        return this._bIndRecordsCheckNav;
    } //-- java.lang.String getBIndRecordsCheckNav() 

    /**
     * Returns the value of field 'bIndRsrcHouseholdMember'.
     * 
     * @return the value of field 'BIndRsrcHouseholdMember'.
     */
    public java.lang.String getBIndRsrcHouseholdMember()
    {
        return this._bIndRsrcHouseholdMember;
    } //-- java.lang.String getBIndRsrcHouseholdMember() 

    /**
     * Returns the value of field 'bIndSafetyRsrc'.
     * 
     * @return the value of field 'BIndSafetyRsrc'.
     */
    public java.lang.String getBIndSafetyRsrc()
    {
        return this._bIndSafetyRsrc;
    } //-- java.lang.String getBIndSafetyRsrc() 

    /**
     * Returns the value of field 'bIndSsnCheck'.
     * 
     * @return the value of field 'BIndSsnCheck'.
     */
    public boolean getBIndSsnCheck()
    {
        return this._bIndSsnCheck;
    } //-- boolean getBIndSsnCheck() 

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
     * Returns the value of field 'bIndUSCitizen'.
     * 
     * @return the value of field 'BIndUSCitizen'.
     */
    public java.lang.String getBIndUSCitizen()
    {
        return this._bIndUSCitizen;
    } //-- java.lang.String getBIndUSCitizen() 

    /**
     * Returns the value of field 'bIndVerified'.
     * 
     * @return the value of field 'BIndVerified'.
     */
    public java.lang.String getBIndVerified()
    {
        return this._bIndVerified;
    } //-- java.lang.String getBIndVerified() 

    /**
     * Returns the value of field 'bScrIndRegisteredWithTribe'.
     * 
     * @return the value of field 'BScrIndRegisteredWithTribe'.
     */
    public java.lang.String getBScrIndRegisteredWithTribe()
    {
        return this._bScrIndRegisteredWithTribe;
    } //-- java.lang.String getBScrIndRegisteredWithTribe() 

    /**
     * Returns the value of field 'bScrIndTribalMember'.
     * 
     * @return the value of field 'BScrIndTribalMember'.
     */
    public java.lang.String getBScrIndTribalMember()
    {
        return this._bScrIndTribalMember;
    } //-- java.lang.String getBScrIndTribalMember() 

    /**
     * Returns the value of field 'bSysIndCreateToDo'.
     * 
     * @return the value of field 'BSysIndCreateToDo'.
     */
    public java.lang.String getBSysIndCreateToDo()
    {
        return this._bSysIndCreateToDo;
    } //-- java.lang.String getBSysIndCreateToDo() 

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
     * Returns the value of field 'cCdPersonSex'.
     * 
     * @return the value of field 'CCdPersonSex'.
     */
    public java.lang.String getCCdPersonSex()
    {
        return this._cCdPersonSex;
    } //-- java.lang.String getCCdPersonSex() 

    /**
     * Returns the value of field 'CINV05SIG_ARRAY'.
     * 
     * @return the value of field 'CINV05SIG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY getCINV05SIG_ARRAY()
    {
        return this._CINV05SIG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY getCINV05SIG_ARRAY() 

    /**
     * Returns the value of field
     * 'CINV05SI_ADD_PERSON_TO_STAGES_ARRAY'.
     * 
     * @return the value of field
     * 'CINV05SI_ADD_PERSON_TO_STAGES_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY()
    {
        return this._CINV05SI_ADD_PERSON_TO_STAGES_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY getCINV05SI_ADD_PERSON_TO_STAGES_ARRAY() 

    /**
     * Returns the value of field 'cIndSsiAppSubmitted'.
     * 
     * @return the value of field 'CIndSsiAppSubmitted'.
     */
    public java.lang.String getCIndSsiAppSubmitted()
    {
        return this._cIndSsiAppSubmitted;
    } //-- java.lang.String getCIndSsiAppSubmitted() 

    /**
     * Returns the value of field 'cIndSsiDfcsPayee'.
     * 
     * @return the value of field 'CIndSsiDfcsPayee'.
     */
    public java.lang.String getCIndSsiDfcsPayee()
    {
        return this._cIndSsiDfcsPayee;
    } //-- java.lang.String getCIndSsiDfcsPayee() 

    /**
     * Returns the value of field 'cIndSsiMedDsbltyReqMet'.
     * 
     * @return the value of field 'CIndSsiMedDsbltyReqMet'.
     */
    public java.lang.String getCIndSsiMedDsbltyReqMet()
    {
        return this._cIndSsiMedDsbltyReqMet;
    } //-- java.lang.String getCIndSsiMedDsbltyReqMet() 

    /**
     * Returns the value of field 'cIndSsiRecipient'.
     * 
     * @return the value of field 'CIndSsiRecipient'.
     */
    public java.lang.String getCIndSsiRecipient()
    {
        return this._cIndSsiRecipient;
    } //-- java.lang.String getCIndSsiRecipient() 

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
     * Returns the value of field 'cdPersonStatus'.
     * 
     * @return the value of field 'CdPersonStatus'.
     */
    public java.lang.String getCdPersonStatus()
    {
        return this._cdPersonStatus;
    } //-- java.lang.String getCdPersonStatus() 

    /**
     * Returns the value of field 'dtDtEntryUS'.
     * 
     * @return the value of field 'DtDtEntryUS'.
     */
    public org.exolab.castor.types.Date getDtDtEntryUS()
    {
        return this._dtDtEntryUS;
    } //-- org.exolab.castor.types.Date getDtDtEntryUS() 

    /**
     * Returns the value of field 'dtDtLegRepAssigned'.
     * 
     * @return the value of field 'DtDtLegRepAssigned'.
     */
    public org.exolab.castor.types.Date getDtDtLegRepAssigned()
    {
        return this._dtDtLegRepAssigned;
    } //-- org.exolab.castor.types.Date getDtDtLegRepAssigned() 

    /**
     * Returns the value of field 'dtDtLegRepUnassigned'.
     * 
     * @return the value of field 'DtDtLegRepUnassigned'.
     */
    public org.exolab.castor.types.Date getDtDtLegRepUnassigned()
    {
        return this._dtDtLegRepUnassigned;
    } //-- org.exolab.castor.types.Date getDtDtLegRepUnassigned() 

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
     * Returns the value of field 'lNbrPersonAge'.
     * 
     * @return the value of field 'LNbrPersonAge'.
     */
    public int getLNbrPersonAge()
    {
        return this._lNbrPersonAge;
    } //-- int getLNbrPersonAge() 

    /**
     * Returns the value of field 'lQtyPersonWeight'.
     * 
     * @return the value of field 'LQtyPersonWeight'.
     */
    public int getLQtyPersonWeight()
    {
        return this._lQtyPersonWeight;
    } //-- int getLQtyPersonWeight() 

    /**
     * Returns the value of field 'pageModeStruct'.
     * 
     * @return the value of field 'PageModeStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.PageModeStruct getPageModeStruct()
    {
        return this._pageModeStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PageModeStruct getPageModeStruct() 

    /**
     * Returns the value of field 'ROWCINV05SIG01_ARRAY'.
     * 
     * @return the value of field 'ROWCINV05SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01_ARRAY getROWCINV05SIG01_ARRAY()
    {
        return this._ROWCINV05SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01_ARRAY getROWCINV05SIG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV05SIG02_ARRAY'.
     * 
     * @return the value of field 'ROWCINV05SIG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02_ARRAY getROWCINV05SIG02_ARRAY()
    {
        return this._ROWCINV05SIG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02_ARRAY getROWCINV05SIG02_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV26SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV26SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY getROWCINV26SIG00_ARRAY()
    {
        return this._ROWCINV26SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY getROWCINV26SIG00_ARRAY() 

    /**
     * Returns the value of field 'sQtyPersonHeightFeet'.
     * 
     * @return the value of field 'SQtyPersonHeightFeet'.
     */
    public int getSQtyPersonHeightFeet()
    {
        return this._sQtyPersonHeightFeet;
    } //-- int getSQtyPersonHeightFeet() 

    /**
     * Returns the value of field 'sQtyPersonHeightInches'.
     * 
     * @return the value of field 'SQtyPersonHeightInches'.
     */
    public int getSQtyPersonHeightInches()
    {
        return this._sQtyPersonHeightInches;
    } //-- int getSQtyPersonHeightInches() 

    /**
     * Returns the value of field 'szCdCategoryCategory_ARRAY'.
     * 
     * @return the value of field 'SzCdCategoryCategory_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY getSzCdCategoryCategory_ARRAY()
    {
        return this._szCdCategoryCategory_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY getSzCdCategoryCategory_ARRAY() 

    /**
     * Returns the value of field 'szCdCntryOfOrigin'.
     * 
     * @return the value of field 'SzCdCntryOfOrigin'.
     */
    public java.lang.String getSzCdCntryOfOrigin()
    {
        return this._szCdCntryOfOrigin;
    } //-- java.lang.String getSzCdCntryOfOrigin() 

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
     * Returns the value of field 'szCdImmigrationStatus'.
     * 
     * @return the value of field 'SzCdImmigrationStatus'.
     */
    public java.lang.String getSzCdImmigrationStatus()
    {
        return this._szCdImmigrationStatus;
    } //-- java.lang.String getSzCdImmigrationStatus() 

    /**
     * Returns the value of field 'szCdMotherMarried'.
     * 
     * @return the value of field 'SzCdMotherMarried'.
     */
    public java.lang.String getSzCdMotherMarried()
    {
        return this._szCdMotherMarried;
    } //-- java.lang.String getSzCdMotherMarried() 

    /**
     * Returns the value of field 'szCdPersGuardCnsrv'.
     * 
     * @return the value of field 'SzCdPersGuardCnsrv'.
     */
    public java.lang.String getSzCdPersGuardCnsrv()
    {
        return this._szCdPersGuardCnsrv;
    } //-- java.lang.String getSzCdPersGuardCnsrv() 

    /**
     * Returns the value of field 'szCdPersonBirthCity'.
     * 
     * @return the value of field 'SzCdPersonBirthCity'.
     */
    public java.lang.String getSzCdPersonBirthCity()
    {
        return this._szCdPersonBirthCity;
    } //-- java.lang.String getSzCdPersonBirthCity() 

    /**
     * Returns the value of field 'szCdPersonBirthCountry'.
     * 
     * @return the value of field 'SzCdPersonBirthCountry'.
     */
    public java.lang.String getSzCdPersonBirthCountry()
    {
        return this._szCdPersonBirthCountry;
    } //-- java.lang.String getSzCdPersonBirthCountry() 

    /**
     * Returns the value of field 'szCdPersonBirthCounty'.
     * 
     * @return the value of field 'SzCdPersonBirthCounty'.
     */
    public java.lang.String getSzCdPersonBirthCounty()
    {
        return this._szCdPersonBirthCounty;
    } //-- java.lang.String getSzCdPersonBirthCounty() 

    /**
     * Returns the value of field 'szCdPersonBirthState'.
     * 
     * @return the value of field 'SzCdPersonBirthState'.
     */
    public java.lang.String getSzCdPersonBirthState()
    {
        return this._szCdPersonBirthState;
    } //-- java.lang.String getSzCdPersonBirthState() 

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
     * Returns the value of field 'szCdPersonEyeColor'.
     * 
     * @return the value of field 'SzCdPersonEyeColor'.
     */
    public java.lang.String getSzCdPersonEyeColor()
    {
        return this._szCdPersonEyeColor;
    } //-- java.lang.String getSzCdPersonEyeColor() 

    /**
     * Returns the value of field 'szCdPersonHairColor'.
     * 
     * @return the value of field 'SzCdPersonHairColor'.
     */
    public java.lang.String getSzCdPersonHairColor()
    {
        return this._szCdPersonHairColor;
    } //-- java.lang.String getSzCdPersonHairColor() 

    /**
     * Returns the value of field 'szCdPersonHighestEduc'.
     * 
     * @return the value of field 'SzCdPersonHighestEduc'.
     */
    public java.lang.String getSzCdPersonHighestEduc()
    {
        return this._szCdPersonHighestEduc;
    } //-- java.lang.String getSzCdPersonHighestEduc() 

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
     * Returns the value of field 'szCdPersonLivArr'.
     * 
     * @return the value of field 'SzCdPersonLivArr'.
     */
    public java.lang.String getSzCdPersonLivArr()
    {
        return this._szCdPersonLivArr;
    } //-- java.lang.String getSzCdPersonLivArr() 

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
     * Returns the value of field 'szCdPersonRelationship'.
     * 
     * @return the value of field 'SzCdPersonRelationship'.
     */
    public java.lang.String getSzCdPersonRelationship()
    {
        return this._szCdPersonRelationship;
    } //-- java.lang.String getSzCdPersonRelationship() 

    /**
     * Returns the value of field 'szCdPersonReligion'.
     * 
     * @return the value of field 'SzCdPersonReligion'.
     */
    public java.lang.String getSzCdPersonReligion()
    {
        return this._szCdPersonReligion;
    } //-- java.lang.String getSzCdPersonReligion() 

    /**
     * Returns the value of field 'szCdProofCitizen'.
     * 
     * @return the value of field 'SzCdProofCitizen'.
     */
    public java.lang.String getSzCdProofCitizen()
    {
        return this._szCdProofCitizen;
    } //-- java.lang.String getSzCdProofCitizen() 

    /**
     * Returns the value of field 'szCdSideOfFamily'.
     * 
     * @return the value of field 'SzCdSideOfFamily'.
     */
    public java.lang.String getSzCdSideOfFamily()
    {
        return this._szCdSideOfFamily;
    } //-- java.lang.String getSzCdSideOfFamily() 

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
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szCdTitle'.
     * 
     * @return the value of field 'SzCdTitle'.
     */
    public java.lang.String getSzCdTitle()
    {
        return this._szCdTitle;
    } //-- java.lang.String getSzCdTitle() 

    /**
     * Returns the value of field 'szNbrPersonSSN'.
     * 
     * @return the value of field 'SzNbrPersonSSN'.
     */
    public java.lang.String getSzNbrPersonSSN()
    {
        return this._szNbrPersonSSN;
    } //-- java.lang.String getSzNbrPersonSSN() 

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
     * Returns the value of field 'szSysCdWinMode'.
     * 
     * @return the value of field 'SzSysCdWinMode'.
     */
    public java.lang.String getSzSysCdWinMode()
    {
        return this._szSysCdWinMode;
    } //-- java.lang.String getSzSysCdWinMode() 

    /**
     * Returns the value of field 'szTxtAddlCmnts'.
     * 
     * @return the value of field 'SzTxtAddlCmnts'.
     */
    public java.lang.String getSzTxtAddlCmnts()
    {
        return this._szTxtAddlCmnts;
    } //-- java.lang.String getSzTxtAddlCmnts() 

    /**
     * Returns the value of field 'szTxtEmail'.
     * 
     * @return the value of field 'SzTxtEmail'.
     */
    public java.lang.String getSzTxtEmail()
    {
        return this._szTxtEmail;
    } //-- java.lang.String getSzTxtEmail() 

    /**
     * Returns the value of field 'szTxtMaidenName'.
     * 
     * @return the value of field 'SzTxtMaidenName'.
     */
    public java.lang.String getSzTxtMaidenName()
    {
        return this._szTxtMaidenName;
    } //-- java.lang.String getSzTxtMaidenName() 

    /**
     * Returns the value of field 'szTxtOccupation'.
     * 
     * @return the value of field 'SzTxtOccupation'.
     */
    public java.lang.String getSzTxtOccupation()
    {
        return this._szTxtOccupation;
    } //-- java.lang.String getSzTxtOccupation() 

    /**
     * Returns the value of field 'szTxtOtherRelationshipsCmnts'.
     * 
     * @return the value of field 'SzTxtOtherRelationshipsCmnts'.
     */
    public java.lang.String getSzTxtOtherRelationshipsCmnts()
    {
        return this._szTxtOtherRelationshipsCmnts;
    } //-- java.lang.String getSzTxtOtherRelationshipsCmnts() 

    /**
     * Returns the value of field 'szTxtPercentHeritage'.
     * 
     * @return the value of field 'SzTxtPercentHeritage'.
     */
    public java.lang.String getSzTxtPercentHeritage()
    {
        return this._szTxtPercentHeritage;
    } //-- java.lang.String getSzTxtPercentHeritage() 

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
     * Returns the value of field 'szTxtTribalName'.
     * 
     * @return the value of field 'SzTxtTribalName'.
     */
    public java.lang.String getSzTxtTribalName()
    {
        return this._szTxtTribalName;
    } //-- java.lang.String getSzTxtTribalName() 

    /**
     * Returns the value of field 'szTxtTribalRegistryNumber'.
     * 
     * @return the value of field 'SzTxtTribalRegistryNumber'.
     */
    public java.lang.String getSzTxtTribalRegistryNumber()
    {
        return this._szTxtTribalRegistryNumber;
    } //-- java.lang.String getSzTxtTribalRegistryNumber() 

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
     * Returns the value of field 'tsSysTsLastUpdate2'.
     * 
     * @return the value of field 'TsSysTsLastUpdate2'.
     */
    public java.util.Date getTsSysTsLastUpdate2()
    {
        return this._tsSysTsLastUpdate2;
    } //-- java.util.Date getTsSysTsLastUpdate2() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate3'.
     * 
     * @return the value of field 'TsSysTsLastUpdate3'.
     */
    public java.util.Date getTsSysTsLastUpdate3()
    {
        return this._tsSysTsLastUpdate3;
    } //-- java.util.Date getTsSysTsLastUpdate3() 

    /**
     * Returns the value of field 'ulIdBioFather'.
     * 
     * @return the value of field 'UlIdBioFather'.
     */
    public int getUlIdBioFather()
    {
        return this._ulIdBioFather;
    } //-- int getUlIdBioFather() 

    /**
     * Returns the value of field 'ulIdBioMother'.
     * 
     * @return the value of field 'UlIdBioMother'.
     */
    public int getUlIdBioMother()
    {
        return this._ulIdBioMother;
    } //-- int getUlIdBioMother() 

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
     * Returns the value of field 'ulIdLegalFather'.
     * 
     * @return the value of field 'UlIdLegalFather'.
     */
    public int getUlIdLegalFather()
    {
        return this._ulIdLegalFather;
    } //-- int getUlIdLegalFather() 

    /**
     * Returns the value of field 'ulIdLegalMother'.
     * 
     * @return the value of field 'UlIdLegalMother'.
     */
    public int getUlIdLegalMother()
    {
        return this._ulIdLegalMother;
    } //-- int getUlIdLegalMother() 

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
     * Returns the value of field 'ulIdPrimaryCareGiver'.
     * 
     * @return the value of field 'UlIdPrimaryCareGiver'.
     */
    public int getUlIdPrimaryCareGiver()
    {
        return this._ulIdPrimaryCareGiver;
    } //-- int getUlIdPrimaryCareGiver() 

    /**
     * Returns the value of field 'ulIdPutativeFather'.
     * 
     * @return the value of field 'UlIdPutativeFather'.
     */
    public int getUlIdPutativeFather()
    {
        return this._ulIdPutativeFather;
    } //-- int getUlIdPutativeFather() 

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
     * Returns the value of field 'ulIdStagePerson'.
     * 
     * @return the value of field 'UlIdStagePerson'.
     */
    public int getUlIdStagePerson()
    {
        return this._ulIdStagePerson;
    } //-- int getUlIdStagePerson() 

    /**
     * Returns the value of field 'ulIdTodoPersAssigned'.
     * 
     * @return the value of field 'UlIdTodoPersAssigned'.
     */
    public int getUlIdTodoPersAssigned()
    {
        return this._ulIdTodoPersAssigned;
    } //-- int getUlIdTodoPersAssigned() 

    /**
     * Method hasBIndSsnCheck
     * 
     * 
     * 
     * @return true if at least one BIndSsnCheck has been added
     */
    public boolean hasBIndSsnCheck()
    {
        return this._has_bIndSsnCheck;
    } //-- boolean hasBIndSsnCheck() 

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
     * Method hasLQtyPersonWeight
     * 
     * 
     * 
     * @return true if at least one LQtyPersonWeight has been added
     */
    public boolean hasLQtyPersonWeight()
    {
        return this._has_lQtyPersonWeight;
    } //-- boolean hasLQtyPersonWeight() 

    /**
     * Method hasSQtyPersonHeightFeet
     * 
     * 
     * 
     * @return true if at least one SQtyPersonHeightFeet has been
     * added
     */
    public boolean hasSQtyPersonHeightFeet()
    {
        return this._has_sQtyPersonHeightFeet;
    } //-- boolean hasSQtyPersonHeightFeet() 

    /**
     * Method hasSQtyPersonHeightInches
     * 
     * 
     * 
     * @return true if at least one SQtyPersonHeightInches has been
     * added
     */
    public boolean hasSQtyPersonHeightInches()
    {
        return this._has_sQtyPersonHeightInches;
    } //-- boolean hasSQtyPersonHeightInches() 

    /**
     * Method hasUlIdBioFather
     * 
     * 
     * 
     * @return true if at least one UlIdBioFather has been added
     */
    public boolean hasUlIdBioFather()
    {
        return this._has_ulIdBioFather;
    } //-- boolean hasUlIdBioFather() 

    /**
     * Method hasUlIdBioMother
     * 
     * 
     * 
     * @return true if at least one UlIdBioMother has been added
     */
    public boolean hasUlIdBioMother()
    {
        return this._has_ulIdBioMother;
    } //-- boolean hasUlIdBioMother() 

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
     * Method hasUlIdLegalFather
     * 
     * 
     * 
     * @return true if at least one UlIdLegalFather has been added
     */
    public boolean hasUlIdLegalFather()
    {
        return this._has_ulIdLegalFather;
    } //-- boolean hasUlIdLegalFather() 

    /**
     * Method hasUlIdLegalMother
     * 
     * 
     * 
     * @return true if at least one UlIdLegalMother has been added
     */
    public boolean hasUlIdLegalMother()
    {
        return this._has_ulIdLegalMother;
    } //-- boolean hasUlIdLegalMother() 

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
     * Method hasUlIdPrimaryCareGiver
     * 
     * 
     * 
     * @return true if at least one UlIdPrimaryCareGiver has been
     * added
     */
    public boolean hasUlIdPrimaryCareGiver()
    {
        return this._has_ulIdPrimaryCareGiver;
    } //-- boolean hasUlIdPrimaryCareGiver() 

    /**
     * Method hasUlIdPutativeFather
     * 
     * 
     * 
     * @return true if at least one UlIdPutativeFather has been adde
     */
    public boolean hasUlIdPutativeFather()
    {
        return this._has_ulIdPutativeFather;
    } //-- boolean hasUlIdPutativeFather() 

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
     * Method hasUlIdStagePerson
     * 
     * 
     * 
     * @return true if at least one UlIdStagePerson has been added
     */
    public boolean hasUlIdStagePerson()
    {
        return this._has_ulIdStagePerson;
    } //-- boolean hasUlIdStagePerson() 

    /**
     * Method hasUlIdTodoPersAssigned
     * 
     * 
     * 
     * @return true if at least one UlIdTodoPersAssigned has been
     * added
     */
    public boolean hasUlIdTodoPersAssigned()
    {
        return this._has_ulIdTodoPersAssigned;
    } //-- boolean hasUlIdTodoPersAssigned() 

    /**
     * Returns the value of field 'bIndSsnCheck'.
     * 
     * @return the value of field 'BIndSsnCheck'.
     */
    public boolean isBIndSsnCheck()
    {
        return this._bIndSsnCheck;
    } //-- boolean isBIndSsnCheck() 

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
     * Sets the value of field 'bCdPersNotYetDiag'.
     * 
     * @param bCdPersNotYetDiag the value of field
     * 'bCdPersNotYetDiag'.
     */
    public void setBCdPersNotYetDiag(java.lang.String bCdPersNotYetDiag)
    {
        this._bCdPersNotYetDiag = bCdPersNotYetDiag;
    } //-- void setBCdPersNotYetDiag(java.lang.String) 

    /**
     * Sets the value of field 'bCdPersonChar'.
     * 
     * @param bCdPersonChar the value of field 'bCdPersonChar'.
     */
    public void setBCdPersonChar(java.lang.String bCdPersonChar)
    {
        this._bCdPersonChar = bCdPersonChar;
    } //-- void setBCdPersonChar(java.lang.String) 

    /**
     * Sets the value of field 'bIndChkd'.
     * 
     * @param bIndChkd the value of field 'bIndChkd'.
     */
    public void setBIndChkd(java.lang.String bIndChkd)
    {
        this._bIndChkd = bIndChkd;
    } //-- void setBIndChkd(java.lang.String) 

    /**
     * Sets the value of field 'bIndLegalCust'.
     * 
     * @param bIndLegalCust the value of field 'bIndLegalCust'.
     */
    public void setBIndLegalCust(java.lang.String bIndLegalCust)
    {
        this._bIndLegalCust = bIndLegalCust;
    } //-- void setBIndLegalCust(java.lang.String) 

    /**
     * Sets the value of field 'bIndPaternityEst'.
     * 
     * @param bIndPaternityEst the value of field 'bIndPaternityEst'
     */
    public void setBIndPaternityEst(java.lang.String bIndPaternityEst)
    {
        this._bIndPaternityEst = bIndPaternityEst;
    } //-- void setBIndPaternityEst(java.lang.String) 

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
     * Sets the value of field 'bIndRecordsCheckNav'.
     * 
     * @param bIndRecordsCheckNav the value of field
     * 'bIndRecordsCheckNav'.
     */
    public void setBIndRecordsCheckNav(java.lang.String bIndRecordsCheckNav)
    {
        this._bIndRecordsCheckNav = bIndRecordsCheckNav;
    } //-- void setBIndRecordsCheckNav(java.lang.String) 

    /**
     * Sets the value of field 'bIndRsrcHouseholdMember'.
     * 
     * @param bIndRsrcHouseholdMember the value of field
     * 'bIndRsrcHouseholdMember'.
     */
    public void setBIndRsrcHouseholdMember(java.lang.String bIndRsrcHouseholdMember)
    {
        this._bIndRsrcHouseholdMember = bIndRsrcHouseholdMember;
    } //-- void setBIndRsrcHouseholdMember(java.lang.String) 

    /**
     * Sets the value of field 'bIndSafetyRsrc'.
     * 
     * @param bIndSafetyRsrc the value of field 'bIndSafetyRsrc'.
     */
    public void setBIndSafetyRsrc(java.lang.String bIndSafetyRsrc)
    {
        this._bIndSafetyRsrc = bIndSafetyRsrc;
    } //-- void setBIndSafetyRsrc(java.lang.String) 

    /**
     * Sets the value of field 'bIndSsnCheck'.
     * 
     * @param bIndSsnCheck the value of field 'bIndSsnCheck'.
     */
    public void setBIndSsnCheck(boolean bIndSsnCheck)
    {
        this._bIndSsnCheck = bIndSsnCheck;
        this._has_bIndSsnCheck = true;
    } //-- void setBIndSsnCheck(boolean) 

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
     * Sets the value of field 'bIndUSCitizen'.
     * 
     * @param bIndUSCitizen the value of field 'bIndUSCitizen'.
     */
    public void setBIndUSCitizen(java.lang.String bIndUSCitizen)
    {
        this._bIndUSCitizen = bIndUSCitizen;
    } //-- void setBIndUSCitizen(java.lang.String) 

    /**
     * Sets the value of field 'bIndVerified'.
     * 
     * @param bIndVerified the value of field 'bIndVerified'.
     */
    public void setBIndVerified(java.lang.String bIndVerified)
    {
        this._bIndVerified = bIndVerified;
    } //-- void setBIndVerified(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndRegisteredWithTribe'.
     * 
     * @param bScrIndRegisteredWithTribe the value of field
     * 'bScrIndRegisteredWithTribe'.
     */
    public void setBScrIndRegisteredWithTribe(java.lang.String bScrIndRegisteredWithTribe)
    {
        this._bScrIndRegisteredWithTribe = bScrIndRegisteredWithTribe;
    } //-- void setBScrIndRegisteredWithTribe(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndTribalMember'.
     * 
     * @param bScrIndTribalMember the value of field
     * 'bScrIndTribalMember'.
     */
    public void setBScrIndTribalMember(java.lang.String bScrIndTribalMember)
    {
        this._bScrIndTribalMember = bScrIndTribalMember;
    } //-- void setBScrIndTribalMember(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndCreateToDo'.
     * 
     * @param bSysIndCreateToDo the value of field
     * 'bSysIndCreateToDo'.
     */
    public void setBSysIndCreateToDo(java.lang.String bSysIndCreateToDo)
    {
        this._bSysIndCreateToDo = bSysIndCreateToDo;
    } //-- void setBSysIndCreateToDo(java.lang.String) 

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
     * Sets the value of field 'cCdPersonSex'.
     * 
     * @param cCdPersonSex the value of field 'cCdPersonSex'.
     */
    public void setCCdPersonSex(java.lang.String cCdPersonSex)
    {
        this._cCdPersonSex = cCdPersonSex;
    } //-- void setCCdPersonSex(java.lang.String) 

    /**
     * Sets the value of field 'CINV05SIG_ARRAY'.
     * 
     * @param CINV05SIG_ARRAY the value of field 'CINV05SIG_ARRAY'.
     */
    public void setCINV05SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY CINV05SIG_ARRAY)
    {
        this._CINV05SIG_ARRAY = CINV05SIG_ARRAY;
    } //-- void setCINV05SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SIG_ARRAY) 

    /**
     * Sets the value of field
     * 'CINV05SI_ADD_PERSON_TO_STAGES_ARRAY'.
     * 
     * @param CINV05SI_ADD_PERSON_TO_STAGES_ARRAY the value of
     * field 'CINV05SI_ADD_PERSON_TO_STAGES_ARRAY'.
     */
    public void setCINV05SI_ADD_PERSON_TO_STAGES_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY CINV05SI_ADD_PERSON_TO_STAGES_ARRAY)
    {
        this._CINV05SI_ADD_PERSON_TO_STAGES_ARRAY = CINV05SI_ADD_PERSON_TO_STAGES_ARRAY;
    } //-- void setCINV05SI_ADD_PERSON_TO_STAGES_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY) 

    /**
     * Sets the value of field 'cIndSsiAppSubmitted'.
     * 
     * @param cIndSsiAppSubmitted the value of field
     * 'cIndSsiAppSubmitted'.
     */
    public void setCIndSsiAppSubmitted(java.lang.String cIndSsiAppSubmitted)
    {
        this._cIndSsiAppSubmitted = cIndSsiAppSubmitted;
    } //-- void setCIndSsiAppSubmitted(java.lang.String) 

    /**
     * Sets the value of field 'cIndSsiDfcsPayee'.
     * 
     * @param cIndSsiDfcsPayee the value of field 'cIndSsiDfcsPayee'
     */
    public void setCIndSsiDfcsPayee(java.lang.String cIndSsiDfcsPayee)
    {
        this._cIndSsiDfcsPayee = cIndSsiDfcsPayee;
    } //-- void setCIndSsiDfcsPayee(java.lang.String) 

    /**
     * Sets the value of field 'cIndSsiMedDsbltyReqMet'.
     * 
     * @param cIndSsiMedDsbltyReqMet the value of field
     * 'cIndSsiMedDsbltyReqMet'.
     */
    public void setCIndSsiMedDsbltyReqMet(java.lang.String cIndSsiMedDsbltyReqMet)
    {
        this._cIndSsiMedDsbltyReqMet = cIndSsiMedDsbltyReqMet;
    } //-- void setCIndSsiMedDsbltyReqMet(java.lang.String) 

    /**
     * Sets the value of field 'cIndSsiRecipient'.
     * 
     * @param cIndSsiRecipient the value of field 'cIndSsiRecipient'
     */
    public void setCIndSsiRecipient(java.lang.String cIndSsiRecipient)
    {
        this._cIndSsiRecipient = cIndSsiRecipient;
    } //-- void setCIndSsiRecipient(java.lang.String) 

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
     * Sets the value of field 'cdPersonStatus'.
     * 
     * @param cdPersonStatus the value of field 'cdPersonStatus'.
     */
    public void setCdPersonStatus(java.lang.String cdPersonStatus)
    {
        this._cdPersonStatus = cdPersonStatus;
    } //-- void setCdPersonStatus(java.lang.String) 

    /**
     * Sets the value of field 'dtDtEntryUS'.
     * 
     * @param dtDtEntryUS the value of field 'dtDtEntryUS'.
     */
    public void setDtDtEntryUS(org.exolab.castor.types.Date dtDtEntryUS)
    {
        this._dtDtEntryUS = dtDtEntryUS;
    } //-- void setDtDtEntryUS(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLegRepAssigned'.
     * 
     * @param dtDtLegRepAssigned the value of field
     * 'dtDtLegRepAssigned'.
     */
    public void setDtDtLegRepAssigned(org.exolab.castor.types.Date dtDtLegRepAssigned)
    {
        this._dtDtLegRepAssigned = dtDtLegRepAssigned;
    } //-- void setDtDtLegRepAssigned(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtLegRepUnassigned'.
     * 
     * @param dtDtLegRepUnassigned the value of field
     * 'dtDtLegRepUnassigned'.
     */
    public void setDtDtLegRepUnassigned(org.exolab.castor.types.Date dtDtLegRepUnassigned)
    {
        this._dtDtLegRepUnassigned = dtDtLegRepUnassigned;
    } //-- void setDtDtLegRepUnassigned(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'lQtyPersonWeight'.
     * 
     * @param lQtyPersonWeight the value of field 'lQtyPersonWeight'
     */
    public void setLQtyPersonWeight(int lQtyPersonWeight)
    {
        this._lQtyPersonWeight = lQtyPersonWeight;
        this._has_lQtyPersonWeight = true;
    } //-- void setLQtyPersonWeight(int) 

    /**
     * Sets the value of field 'pageModeStruct'.
     * 
     * @param pageModeStruct the value of field 'pageModeStruct'.
     */
    public void setPageModeStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.PageModeStruct pageModeStruct)
    {
        this._pageModeStruct = pageModeStruct;
    } //-- void setPageModeStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.PageModeStruct) 

    /**
     * Sets the value of field 'ROWCINV05SIG01_ARRAY'.
     * 
     * @param ROWCINV05SIG01_ARRAY the value of field
     * 'ROWCINV05SIG01_ARRAY'.
     */
    public void setROWCINV05SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01_ARRAY ROWCINV05SIG01_ARRAY)
    {
        this._ROWCINV05SIG01_ARRAY = ROWCINV05SIG01_ARRAY;
    } //-- void setROWCINV05SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV05SIG02_ARRAY'.
     * 
     * @param ROWCINV05SIG02_ARRAY the value of field
     * 'ROWCINV05SIG02_ARRAY'.
     */
    public void setROWCINV05SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02_ARRAY ROWCINV05SIG02_ARRAY)
    {
        this._ROWCINV05SIG02_ARRAY = ROWCINV05SIG02_ARRAY;
    } //-- void setROWCINV05SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV05SIG02_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV26SIG00_ARRAY'.
     * 
     * @param ROWCINV26SIG00_ARRAY the value of field
     * 'ROWCINV26SIG00_ARRAY'.
     */
    public void setROWCINV26SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY ROWCINV26SIG00_ARRAY)
    {
        this._ROWCINV26SIG00_ARRAY = ROWCINV26SIG00_ARRAY;
    } //-- void setROWCINV26SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY) 

    /**
     * Sets the value of field 'sQtyPersonHeightFeet'.
     * 
     * @param sQtyPersonHeightFeet the value of field
     * 'sQtyPersonHeightFeet'.
     */
    public void setSQtyPersonHeightFeet(int sQtyPersonHeightFeet)
    {
        this._sQtyPersonHeightFeet = sQtyPersonHeightFeet;
        this._has_sQtyPersonHeightFeet = true;
    } //-- void setSQtyPersonHeightFeet(int) 

    /**
     * Sets the value of field 'sQtyPersonHeightInches'.
     * 
     * @param sQtyPersonHeightInches the value of field
     * 'sQtyPersonHeightInches'.
     */
    public void setSQtyPersonHeightInches(int sQtyPersonHeightInches)
    {
        this._sQtyPersonHeightInches = sQtyPersonHeightInches;
        this._has_sQtyPersonHeightInches = true;
    } //-- void setSQtyPersonHeightInches(int) 

    /**
     * Sets the value of field 'szCdCategoryCategory_ARRAY'.
     * 
     * @param szCdCategoryCategory_ARRAY the value of field
     * 'szCdCategoryCategory_ARRAY'.
     */
    public void setSzCdCategoryCategory_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY szCdCategoryCategory_ARRAY)
    {
        this._szCdCategoryCategory_ARRAY = szCdCategoryCategory_ARRAY;
    } //-- void setSzCdCategoryCategory_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY) 

    /**
     * Sets the value of field 'szCdCntryOfOrigin'.
     * 
     * @param szCdCntryOfOrigin the value of field
     * 'szCdCntryOfOrigin'.
     */
    public void setSzCdCntryOfOrigin(java.lang.String szCdCntryOfOrigin)
    {
        this._szCdCntryOfOrigin = szCdCntryOfOrigin;
    } //-- void setSzCdCntryOfOrigin(java.lang.String) 

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
     * Sets the value of field 'szCdImmigrationStatus'.
     * 
     * @param szCdImmigrationStatus the value of field
     * 'szCdImmigrationStatus'.
     */
    public void setSzCdImmigrationStatus(java.lang.String szCdImmigrationStatus)
    {
        this._szCdImmigrationStatus = szCdImmigrationStatus;
    } //-- void setSzCdImmigrationStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdMotherMarried'.
     * 
     * @param szCdMotherMarried the value of field
     * 'szCdMotherMarried'.
     */
    public void setSzCdMotherMarried(java.lang.String szCdMotherMarried)
    {
        this._szCdMotherMarried = szCdMotherMarried;
    } //-- void setSzCdMotherMarried(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersGuardCnsrv'.
     * 
     * @param szCdPersGuardCnsrv the value of field
     * 'szCdPersGuardCnsrv'.
     */
    public void setSzCdPersGuardCnsrv(java.lang.String szCdPersGuardCnsrv)
    {
        this._szCdPersGuardCnsrv = szCdPersGuardCnsrv;
    } //-- void setSzCdPersGuardCnsrv(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonBirthCity'.
     * 
     * @param szCdPersonBirthCity the value of field
     * 'szCdPersonBirthCity'.
     */
    public void setSzCdPersonBirthCity(java.lang.String szCdPersonBirthCity)
    {
        this._szCdPersonBirthCity = szCdPersonBirthCity;
    } //-- void setSzCdPersonBirthCity(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonBirthCountry'.
     * 
     * @param szCdPersonBirthCountry the value of field
     * 'szCdPersonBirthCountry'.
     */
    public void setSzCdPersonBirthCountry(java.lang.String szCdPersonBirthCountry)
    {
        this._szCdPersonBirthCountry = szCdPersonBirthCountry;
    } //-- void setSzCdPersonBirthCountry(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonBirthCounty'.
     * 
     * @param szCdPersonBirthCounty the value of field
     * 'szCdPersonBirthCounty'.
     */
    public void setSzCdPersonBirthCounty(java.lang.String szCdPersonBirthCounty)
    {
        this._szCdPersonBirthCounty = szCdPersonBirthCounty;
    } //-- void setSzCdPersonBirthCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonBirthState'.
     * 
     * @param szCdPersonBirthState the value of field
     * 'szCdPersonBirthState'.
     */
    public void setSzCdPersonBirthState(java.lang.String szCdPersonBirthState)
    {
        this._szCdPersonBirthState = szCdPersonBirthState;
    } //-- void setSzCdPersonBirthState(java.lang.String) 

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
     * Sets the value of field 'szCdPersonEyeColor'.
     * 
     * @param szCdPersonEyeColor the value of field
     * 'szCdPersonEyeColor'.
     */
    public void setSzCdPersonEyeColor(java.lang.String szCdPersonEyeColor)
    {
        this._szCdPersonEyeColor = szCdPersonEyeColor;
    } //-- void setSzCdPersonEyeColor(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonHairColor'.
     * 
     * @param szCdPersonHairColor the value of field
     * 'szCdPersonHairColor'.
     */
    public void setSzCdPersonHairColor(java.lang.String szCdPersonHairColor)
    {
        this._szCdPersonHairColor = szCdPersonHairColor;
    } //-- void setSzCdPersonHairColor(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonHighestEduc'.
     * 
     * @param szCdPersonHighestEduc the value of field
     * 'szCdPersonHighestEduc'.
     */
    public void setSzCdPersonHighestEduc(java.lang.String szCdPersonHighestEduc)
    {
        this._szCdPersonHighestEduc = szCdPersonHighestEduc;
    } //-- void setSzCdPersonHighestEduc(java.lang.String) 

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
     * Sets the value of field 'szCdPersonLivArr'.
     * 
     * @param szCdPersonLivArr the value of field 'szCdPersonLivArr'
     */
    public void setSzCdPersonLivArr(java.lang.String szCdPersonLivArr)
    {
        this._szCdPersonLivArr = szCdPersonLivArr;
    } //-- void setSzCdPersonLivArr(java.lang.String) 

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
     * Sets the value of field 'szCdPersonRelationship'.
     * 
     * @param szCdPersonRelationship the value of field
     * 'szCdPersonRelationship'.
     */
    public void setSzCdPersonRelationship(java.lang.String szCdPersonRelationship)
    {
        this._szCdPersonRelationship = szCdPersonRelationship;
    } //-- void setSzCdPersonRelationship(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonReligion'.
     * 
     * @param szCdPersonReligion the value of field
     * 'szCdPersonReligion'.
     */
    public void setSzCdPersonReligion(java.lang.String szCdPersonReligion)
    {
        this._szCdPersonReligion = szCdPersonReligion;
    } //-- void setSzCdPersonReligion(java.lang.String) 

    /**
     * Sets the value of field 'szCdProofCitizen'.
     * 
     * @param szCdProofCitizen the value of field 'szCdProofCitizen'
     */
    public void setSzCdProofCitizen(java.lang.String szCdProofCitizen)
    {
        this._szCdProofCitizen = szCdProofCitizen;
    } //-- void setSzCdProofCitizen(java.lang.String) 

    /**
     * Sets the value of field 'szCdSideOfFamily'.
     * 
     * @param szCdSideOfFamily the value of field 'szCdSideOfFamily'
     */
    public void setSzCdSideOfFamily(java.lang.String szCdSideOfFamily)
    {
        this._szCdSideOfFamily = szCdSideOfFamily;
    } //-- void setSzCdSideOfFamily(java.lang.String) 

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
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szCdTitle'.
     * 
     * @param szCdTitle the value of field 'szCdTitle'.
     */
    public void setSzCdTitle(java.lang.String szCdTitle)
    {
        this._szCdTitle = szCdTitle;
    } //-- void setSzCdTitle(java.lang.String) 

    /**
     * Sets the value of field 'szNbrPersonSSN'.
     * 
     * @param szNbrPersonSSN the value of field 'szNbrPersonSSN'.
     */
    public void setSzNbrPersonSSN(java.lang.String szNbrPersonSSN)
    {
        this._szNbrPersonSSN = szNbrPersonSSN;
    } //-- void setSzNbrPersonSSN(java.lang.String) 

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
     * Sets the value of field 'szSysCdWinMode'.
     * 
     * @param szSysCdWinMode the value of field 'szSysCdWinMode'.
     */
    public void setSzSysCdWinMode(java.lang.String szSysCdWinMode)
    {
        this._szSysCdWinMode = szSysCdWinMode;
    } //-- void setSzSysCdWinMode(java.lang.String) 

    /**
     * Sets the value of field 'szTxtAddlCmnts'.
     * 
     * @param szTxtAddlCmnts the value of field 'szTxtAddlCmnts'.
     */
    public void setSzTxtAddlCmnts(java.lang.String szTxtAddlCmnts)
    {
        this._szTxtAddlCmnts = szTxtAddlCmnts;
    } //-- void setSzTxtAddlCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEmail'.
     * 
     * @param szTxtEmail the value of field 'szTxtEmail'.
     */
    public void setSzTxtEmail(java.lang.String szTxtEmail)
    {
        this._szTxtEmail = szTxtEmail;
    } //-- void setSzTxtEmail(java.lang.String) 

    /**
     * Sets the value of field 'szTxtMaidenName'.
     * 
     * @param szTxtMaidenName the value of field 'szTxtMaidenName'.
     */
    public void setSzTxtMaidenName(java.lang.String szTxtMaidenName)
    {
        this._szTxtMaidenName = szTxtMaidenName;
    } //-- void setSzTxtMaidenName(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOccupation'.
     * 
     * @param szTxtOccupation the value of field 'szTxtOccupation'.
     */
    public void setSzTxtOccupation(java.lang.String szTxtOccupation)
    {
        this._szTxtOccupation = szTxtOccupation;
    } //-- void setSzTxtOccupation(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOtherRelationshipsCmnts'.
     * 
     * @param szTxtOtherRelationshipsCmnts the value of field
     * 'szTxtOtherRelationshipsCmnts'.
     */
    public void setSzTxtOtherRelationshipsCmnts(java.lang.String szTxtOtherRelationshipsCmnts)
    {
        this._szTxtOtherRelationshipsCmnts = szTxtOtherRelationshipsCmnts;
    } //-- void setSzTxtOtherRelationshipsCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPercentHeritage'.
     * 
     * @param szTxtPercentHeritage the value of field
     * 'szTxtPercentHeritage'.
     */
    public void setSzTxtPercentHeritage(java.lang.String szTxtPercentHeritage)
    {
        this._szTxtPercentHeritage = szTxtPercentHeritage;
    } //-- void setSzTxtPercentHeritage(java.lang.String) 

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
     * Sets the value of field 'szTxtTribalName'.
     * 
     * @param szTxtTribalName the value of field 'szTxtTribalName'.
     */
    public void setSzTxtTribalName(java.lang.String szTxtTribalName)
    {
        this._szTxtTribalName = szTxtTribalName;
    } //-- void setSzTxtTribalName(java.lang.String) 

    /**
     * Sets the value of field 'szTxtTribalRegistryNumber'.
     * 
     * @param szTxtTribalRegistryNumber the value of field
     * 'szTxtTribalRegistryNumber'.
     */
    public void setSzTxtTribalRegistryNumber(java.lang.String szTxtTribalRegistryNumber)
    {
        this._szTxtTribalRegistryNumber = szTxtTribalRegistryNumber;
    } //-- void setSzTxtTribalRegistryNumber(java.lang.String) 

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
     * Sets the value of field 'tsSysTsLastUpdate2'.
     * 
     * @param tsSysTsLastUpdate2 the value of field
     * 'tsSysTsLastUpdate2'.
     */
    public void setTsSysTsLastUpdate2(java.util.Date tsSysTsLastUpdate2)
    {
        this._tsSysTsLastUpdate2 = tsSysTsLastUpdate2;
    } //-- void setTsSysTsLastUpdate2(java.util.Date) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate3'.
     * 
     * @param tsSysTsLastUpdate3 the value of field
     * 'tsSysTsLastUpdate3'.
     */
    public void setTsSysTsLastUpdate3(java.util.Date tsSysTsLastUpdate3)
    {
        this._tsSysTsLastUpdate3 = tsSysTsLastUpdate3;
    } //-- void setTsSysTsLastUpdate3(java.util.Date) 

    /**
     * Sets the value of field 'ulIdBioFather'.
     * 
     * @param ulIdBioFather the value of field 'ulIdBioFather'.
     */
    public void setUlIdBioFather(int ulIdBioFather)
    {
        this._ulIdBioFather = ulIdBioFather;
        this._has_ulIdBioFather = true;
    } //-- void setUlIdBioFather(int) 

    /**
     * Sets the value of field 'ulIdBioMother'.
     * 
     * @param ulIdBioMother the value of field 'ulIdBioMother'.
     */
    public void setUlIdBioMother(int ulIdBioMother)
    {
        this._ulIdBioMother = ulIdBioMother;
        this._has_ulIdBioMother = true;
    } //-- void setUlIdBioMother(int) 

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
     * Sets the value of field 'ulIdLegalFather'.
     * 
     * @param ulIdLegalFather the value of field 'ulIdLegalFather'.
     */
    public void setUlIdLegalFather(int ulIdLegalFather)
    {
        this._ulIdLegalFather = ulIdLegalFather;
        this._has_ulIdLegalFather = true;
    } //-- void setUlIdLegalFather(int) 

    /**
     * Sets the value of field 'ulIdLegalMother'.
     * 
     * @param ulIdLegalMother the value of field 'ulIdLegalMother'.
     */
    public void setUlIdLegalMother(int ulIdLegalMother)
    {
        this._ulIdLegalMother = ulIdLegalMother;
        this._has_ulIdLegalMother = true;
    } //-- void setUlIdLegalMother(int) 

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
     * Sets the value of field 'ulIdPrimaryCareGiver'.
     * 
     * @param ulIdPrimaryCareGiver the value of field
     * 'ulIdPrimaryCareGiver'.
     */
    public void setUlIdPrimaryCareGiver(int ulIdPrimaryCareGiver)
    {
        this._ulIdPrimaryCareGiver = ulIdPrimaryCareGiver;
        this._has_ulIdPrimaryCareGiver = true;
    } //-- void setUlIdPrimaryCareGiver(int) 

    /**
     * Sets the value of field 'ulIdPutativeFather'.
     * 
     * @param ulIdPutativeFather the value of field
     * 'ulIdPutativeFather'.
     */
    public void setUlIdPutativeFather(int ulIdPutativeFather)
    {
        this._ulIdPutativeFather = ulIdPutativeFather;
        this._has_ulIdPutativeFather = true;
    } //-- void setUlIdPutativeFather(int) 

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
     * Sets the value of field 'ulIdStagePerson'.
     * 
     * @param ulIdStagePerson the value of field 'ulIdStagePerson'.
     */
    public void setUlIdStagePerson(int ulIdStagePerson)
    {
        this._ulIdStagePerson = ulIdStagePerson;
        this._has_ulIdStagePerson = true;
    } //-- void setUlIdStagePerson(int) 

    /**
     * Sets the value of field 'ulIdTodoPersAssigned'.
     * 
     * @param ulIdTodoPersAssigned the value of field
     * 'ulIdTodoPersAssigned'.
     */
    public void setUlIdTodoPersAssigned(int ulIdTodoPersAssigned)
    {
        this._ulIdTodoPersAssigned = ulIdTodoPersAssigned;
        this._has_ulIdTodoPersAssigned = true;
    } //-- void setUlIdTodoPersAssigned(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI unmarshal(java.io.Reader) 

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
