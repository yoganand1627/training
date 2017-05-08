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
 * Class PersListAudStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PersListAudStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _lSysNbrUniqueLBKey
     */
    private int _lSysNbrUniqueLBKey;

    /**
     * keeps track of state for field: _lSysNbrUniqueLBKey
     */
    private boolean _has_lSysNbrUniqueLBKey;

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
     * Field _szCdNameSuffix
     */
    private java.lang.String _szCdNameSuffix;

    /**
     * Field _bIndNamePrimary
     */
    private java.lang.String _bIndNamePrimary;

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
     * Field _cdPersonStatus
     */
    private java.lang.String _cdPersonStatus;

    /**
     * Field _szCdCategoryCategory
     */
    private java.lang.String _szCdCategoryCategory;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _bScrIndAddrDataChange
     */
    private java.lang.String _bScrIndAddrDataChange;

    /**
     * Field _bScrIndPhoneDataChange
     */
    private java.lang.String _bScrIndPhoneDataChange;

    /**
     * Field _bScrIndRaceDataChange
     */
    private java.lang.String _bScrIndRaceDataChange;

    /**
     * Field _bScrIndNameDataChange
     */
    private java.lang.String _bScrIndNameDataChange;

    /**
     * Field _bScrIndIDDataChange
     */
    private java.lang.String _bScrIndIDDataChange;

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

    /**
     * Field _bIndSsnConfirm
     */
    private boolean _bIndSsnConfirm;

    /**
     * keeps track of state for field: _bIndSsnConfirm
     */
    private boolean _has_bIndSsnConfirm;

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _bScrIndDOBDataChange
     */
    private java.lang.String _bScrIndDOBDataChange;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersListAudStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndSsnConfirm()
    {
        this._has_bIndSsnConfirm= false;
    } //-- void deleteBIndSsnConfirm() 

    /**
     */
    public void deleteLNbrPersonAge()
    {
        this._has_lNbrPersonAge= false;
    } //-- void deleteLNbrPersonAge() 

    /**
     */
    public void deleteLSysNbrUniqueLBKey()
    {
        this._has_lSysNbrUniqueLBKey= false;
    } //-- void deleteLSysNbrUniqueLBKey() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'bIndNamePrimary'.
     * 
     * @return the value of field 'BIndNamePrimary'.
     */
    public java.lang.String getBIndNamePrimary()
    {
        return this._bIndNamePrimary;
    } //-- java.lang.String getBIndNamePrimary() 

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
     * Returns the value of field 'bIndSsnConfirm'.
     * 
     * @return the value of field 'BIndSsnConfirm'.
     */
    public boolean getBIndSsnConfirm()
    {
        return this._bIndSsnConfirm;
    } //-- boolean getBIndSsnConfirm() 

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
     * Returns the value of field 'bScrIndAddrDataChange'.
     * 
     * @return the value of field 'BScrIndAddrDataChange'.
     */
    public java.lang.String getBScrIndAddrDataChange()
    {
        return this._bScrIndAddrDataChange;
    } //-- java.lang.String getBScrIndAddrDataChange() 

    /**
     * Returns the value of field 'bScrIndDOBDataChange'.
     * 
     * @return the value of field 'BScrIndDOBDataChange'.
     */
    public java.lang.String getBScrIndDOBDataChange()
    {
        return this._bScrIndDOBDataChange;
    } //-- java.lang.String getBScrIndDOBDataChange() 

    /**
     * Returns the value of field 'bScrIndIDDataChange'.
     * 
     * @return the value of field 'BScrIndIDDataChange'.
     */
    public java.lang.String getBScrIndIDDataChange()
    {
        return this._bScrIndIDDataChange;
    } //-- java.lang.String getBScrIndIDDataChange() 

    /**
     * Returns the value of field 'bScrIndNameDataChange'.
     * 
     * @return the value of field 'BScrIndNameDataChange'.
     */
    public java.lang.String getBScrIndNameDataChange()
    {
        return this._bScrIndNameDataChange;
    } //-- java.lang.String getBScrIndNameDataChange() 

    /**
     * Returns the value of field 'bScrIndPhoneDataChange'.
     * 
     * @return the value of field 'BScrIndPhoneDataChange'.
     */
    public java.lang.String getBScrIndPhoneDataChange()
    {
        return this._bScrIndPhoneDataChange;
    } //-- java.lang.String getBScrIndPhoneDataChange() 

    /**
     * Returns the value of field 'bScrIndRaceDataChange'.
     * 
     * @return the value of field 'BScrIndRaceDataChange'.
     */
    public java.lang.String getBScrIndRaceDataChange()
    {
        return this._bScrIndRaceDataChange;
    } //-- java.lang.String getBScrIndRaceDataChange() 

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
     * Returns the value of field 'cdPersonStatus'.
     * 
     * @return the value of field 'CdPersonStatus'.
     */
    public java.lang.String getCdPersonStatus()
    {
        return this._cdPersonStatus;
    } //-- java.lang.String getCdPersonStatus() 

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
     * Returns the value of field 'lSysNbrUniqueLBKey'.
     * 
     * @return the value of field 'LSysNbrUniqueLBKey'.
     */
    public int getLSysNbrUniqueLBKey()
    {
        return this._lSysNbrUniqueLBKey;
    } //-- int getLSysNbrUniqueLBKey() 

    /**
     * Returns the value of field 'szCdCategoryCategory'.
     * 
     * @return the value of field 'SzCdCategoryCategory'.
     */
    public java.lang.String getSzCdCategoryCategory()
    {
        return this._szCdCategoryCategory;
    } //-- java.lang.String getSzCdCategoryCategory() 

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
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

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
     * Method hasBIndSsnConfirm
     * 
     * 
     * 
     * @return true if at least one BIndSsnConfirm has been added
     */
    public boolean hasBIndSsnConfirm()
    {
        return this._has_bIndSsnConfirm;
    } //-- boolean hasBIndSsnConfirm() 

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
     * Method hasLSysNbrUniqueLBKey
     * 
     * 
     * 
     * @return true if at least one LSysNbrUniqueLBKey has been adde
     */
    public boolean hasLSysNbrUniqueLBKey()
    {
        return this._has_lSysNbrUniqueLBKey;
    } //-- boolean hasLSysNbrUniqueLBKey() 

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
     * Returns the value of field 'bIndSsnConfirm'.
     * 
     * @return the value of field 'BIndSsnConfirm'.
     */
    public boolean isBIndSsnConfirm()
    {
        return this._bIndSsnConfirm;
    } //-- boolean isBIndSsnConfirm() 

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
     * Sets the value of field 'bIndNamePrimary'.
     * 
     * @param bIndNamePrimary the value of field 'bIndNamePrimary'.
     */
    public void setBIndNamePrimary(java.lang.String bIndNamePrimary)
    {
        this._bIndNamePrimary = bIndNamePrimary;
    } //-- void setBIndNamePrimary(java.lang.String) 

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
     * Sets the value of field 'bIndSsnConfirm'.
     * 
     * @param bIndSsnConfirm the value of field 'bIndSsnConfirm'.
     */
    public void setBIndSsnConfirm(boolean bIndSsnConfirm)
    {
        this._bIndSsnConfirm = bIndSsnConfirm;
        this._has_bIndSsnConfirm = true;
    } //-- void setBIndSsnConfirm(boolean) 

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
     * Sets the value of field 'bScrIndAddrDataChange'.
     * 
     * @param bScrIndAddrDataChange the value of field
     * 'bScrIndAddrDataChange'.
     */
    public void setBScrIndAddrDataChange(java.lang.String bScrIndAddrDataChange)
    {
        this._bScrIndAddrDataChange = bScrIndAddrDataChange;
    } //-- void setBScrIndAddrDataChange(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndDOBDataChange'.
     * 
     * @param bScrIndDOBDataChange the value of field
     * 'bScrIndDOBDataChange'.
     */
    public void setBScrIndDOBDataChange(java.lang.String bScrIndDOBDataChange)
    {
        this._bScrIndDOBDataChange = bScrIndDOBDataChange;
    } //-- void setBScrIndDOBDataChange(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndIDDataChange'.
     * 
     * @param bScrIndIDDataChange the value of field
     * 'bScrIndIDDataChange'.
     */
    public void setBScrIndIDDataChange(java.lang.String bScrIndIDDataChange)
    {
        this._bScrIndIDDataChange = bScrIndIDDataChange;
    } //-- void setBScrIndIDDataChange(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndNameDataChange'.
     * 
     * @param bScrIndNameDataChange the value of field
     * 'bScrIndNameDataChange'.
     */
    public void setBScrIndNameDataChange(java.lang.String bScrIndNameDataChange)
    {
        this._bScrIndNameDataChange = bScrIndNameDataChange;
    } //-- void setBScrIndNameDataChange(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndPhoneDataChange'.
     * 
     * @param bScrIndPhoneDataChange the value of field
     * 'bScrIndPhoneDataChange'.
     */
    public void setBScrIndPhoneDataChange(java.lang.String bScrIndPhoneDataChange)
    {
        this._bScrIndPhoneDataChange = bScrIndPhoneDataChange;
    } //-- void setBScrIndPhoneDataChange(java.lang.String) 

    /**
     * Sets the value of field 'bScrIndRaceDataChange'.
     * 
     * @param bScrIndRaceDataChange the value of field
     * 'bScrIndRaceDataChange'.
     */
    public void setBScrIndRaceDataChange(java.lang.String bScrIndRaceDataChange)
    {
        this._bScrIndRaceDataChange = bScrIndRaceDataChange;
    } //-- void setBScrIndRaceDataChange(java.lang.String) 

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
     * Sets the value of field 'cdPersonStatus'.
     * 
     * @param cdPersonStatus the value of field 'cdPersonStatus'.
     */
    public void setCdPersonStatus(java.lang.String cdPersonStatus)
    {
        this._cdPersonStatus = cdPersonStatus;
    } //-- void setCdPersonStatus(java.lang.String) 

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
     * Sets the value of field 'lSysNbrUniqueLBKey'.
     * 
     * @param lSysNbrUniqueLBKey the value of field
     * 'lSysNbrUniqueLBKey'.
     */
    public void setLSysNbrUniqueLBKey(int lSysNbrUniqueLBKey)
    {
        this._lSysNbrUniqueLBKey = lSysNbrUniqueLBKey;
        this._has_lSysNbrUniqueLBKey = true;
    } //-- void setLSysNbrUniqueLBKey(int) 

    /**
     * Sets the value of field 'szCdCategoryCategory'.
     * 
     * @param szCdCategoryCategory the value of field
     * 'szCdCategoryCategory'.
     */
    public void setSzCdCategoryCategory(java.lang.String szCdCategoryCategory)
    {
        this._szCdCategoryCategory = szCdCategoryCategory;
    } //-- void setSzCdCategoryCategory(java.lang.String) 

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
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct unmarshal(java.io.Reader) 

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
