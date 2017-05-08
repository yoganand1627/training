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
 * Class CSYS07SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSYS07SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _bIndReview
     */
    private java.lang.String _bIndReview;

    /**
     * Field _bIndVictimSelected
     */
    private java.lang.String _bIndVictimSelected;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _ROWCSVC02SIG03_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY _ROWCSVC02SIG03_ARRAY;

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
     * Field _szCdStageClassification
     */
    private java.lang.String _szCdStageClassification;

    /**
     * Field _tsSysTsLastUpdate3
     */
    private java.util.Date _tsSysTsLastUpdate3;

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szNmContactedBy
     */
    private java.lang.String _szNmContactedBy;

    /**
     * Field _szCdContactLocation
     */
    private java.lang.String _szCdContactLocation;

    /**
     * Field _szCdContactMethod
     */
    private java.lang.String _szCdContactMethod;

    /**
     * Field _szCdContactOthers
     */
    private java.lang.String _szCdContactOthers;

    /**
     * Field _szCdContactPurpose
     */
    private java.lang.String _szCdContactPurpose;

    /**
     * Field _szCdContactNarrative
     */
    private java.lang.String _szCdContactNarrative;

    /**
     * Field _szCdContactType
     */
    private java.lang.String _szCdContactType;

    /**
     * Field _bIndContactAttempted
     */
    private java.lang.String _bIndContactAttempted;

    /**
     * Field _bIndDeleteDoc
     */
    private java.lang.String _bIndDeleteDoc;

    /**
     * Field _dtDTContactOccurred
     */
    private org.exolab.castor.types.Date _dtDTContactOccurred;

    /**
     * Field _dtDTContactEntered
     */
    private org.exolab.castor.types.Date _dtDTContactEntered;

    /**
     * Field _tmScrTmCntct
     */
    private java.lang.String _tmScrTmCntct;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdStageType
     */
    private java.lang.String _szCdStageType;

    /**
     * Field _dtDtMonthlySummBegin
     */
    private org.exolab.castor.types.Date _dtDtMonthlySummBegin;

    /**
     * Field _dtDtMonthlySummEnd
     */
    private org.exolab.castor.types.Date _dtDtMonthlySummEnd;

    /**
     * Field _ROWCSYS07SI_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY _ROWCSYS07SI_ARRAY;

    /**
     * Field _ROWCLSC97DIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY _ROWCLSC97DIG00_ARRAY;

    /**
     * Field _ulRowSelected
     */
    private int _ulRowSelected;

    /**
     * keeps track of state for field: _ulRowSelected
     */
    private boolean _has_ulRowSelected;

    /**
     * Field _szNmAgencyName
     */
    private java.lang.String _szNmAgencyName;

    /**
     * Field _bIndCrossCountyLines
     */
    private java.lang.String _bIndCrossCountyLines;

    /**
     * Field _ulIdTCMClient
     */
    private int _ulIdTCMClient;

    /**
     * keeps track of state for field: _ulIdTCMClient
     */
    private boolean _has_ulIdTCMClient;

    /**
     * Field _szCdTCMEligible
     */
    private java.lang.String _szCdTCMEligible;

    /**
     * Field _szCdTCMMedSvcs
     */
    private java.lang.String _szCdTCMMedSvcs;

    /**
     * Field _contactCbxRecord_Array
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array _contactCbxRecord_Array;

    /**
     * Field _szCdContactedBy
     */
    private java.lang.String _szCdContactedBy;

    /**
     * Field _indExtDocAccepted
     */
    private java.lang.String _indExtDocAccepted;

    /**
     * Field _ROWPRIVCONVER_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY _ROWPRIVCONVER_ARRAY;

    /**
     * Field _ROWDELETEPRIVCONVER_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY _ROWDELETEPRIVCONVER_ARRAY;

    /**
     * Field _szNmPortalUserFull
     */
    private java.lang.String _szNmPortalUserFull;

    /**
     * Field _ulIdPortalUser
     */
    private int _ulIdPortalUser;

    /**
     * keeps track of state for field: _ulIdPortalUser
     */
    private boolean _has_ulIdPortalUser;

    /**
     * Field _szTitlePortalUser
     */
    private java.lang.String _szTitlePortalUser;

    /**
     * Field _szCdPopulatedFrom
     */
    private java.lang.String _szCdPopulatedFrom;

    /**
     * Field _ROWDISCUSSED_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY _ROWDISCUSSED_ARRAY;

    /**
     * Field _ROWDELETEDISCUSSED_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY _ROWDELETEDISCUSSED_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSYS07SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI()


      //-----------/
     //- Methods -/
    //-----------/

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
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPortalUser()
    {
        this._has_ulIdPortalUser= false;
    } //-- void deleteUlIdPortalUser() 

    /**
     */
    public void deleteUlIdTCMClient()
    {
        this._has_ulIdTCMClient= false;
    } //-- void deleteUlIdTCMClient() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     */
    public void deleteUlRowSelected()
    {
        this._has_ulRowSelected= false;
    } //-- void deleteUlRowSelected() 

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
     * Returns the value of field 'bIndContactAttempted'.
     * 
     * @return the value of field 'BIndContactAttempted'.
     */
    public java.lang.String getBIndContactAttempted()
    {
        return this._bIndContactAttempted;
    } //-- java.lang.String getBIndContactAttempted() 

    /**
     * Returns the value of field 'bIndCrossCountyLines'.
     * 
     * @return the value of field 'BIndCrossCountyLines'.
     */
    public java.lang.String getBIndCrossCountyLines()
    {
        return this._bIndCrossCountyLines;
    } //-- java.lang.String getBIndCrossCountyLines() 

    /**
     * Returns the value of field 'bIndDeleteDoc'.
     * 
     * @return the value of field 'BIndDeleteDoc'.
     */
    public java.lang.String getBIndDeleteDoc()
    {
        return this._bIndDeleteDoc;
    } //-- java.lang.String getBIndDeleteDoc() 

    /**
     * Returns the value of field 'bIndReview'.
     * 
     * @return the value of field 'BIndReview'.
     */
    public java.lang.String getBIndReview()
    {
        return this._bIndReview;
    } //-- java.lang.String getBIndReview() 

    /**
     * Returns the value of field 'bIndVictimSelected'.
     * 
     * @return the value of field 'BIndVictimSelected'.
     */
    public java.lang.String getBIndVictimSelected()
    {
        return this._bIndVictimSelected;
    } //-- java.lang.String getBIndVictimSelected() 

    /**
     * Returns the value of field 'contactCbxRecord_Array'.
     * 
     * @return the value of field 'ContactCbxRecord_Array'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array getContactCbxRecord_Array()
    {
        return this._contactCbxRecord_Array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array getContactCbxRecord_Array() 

    /**
     * Returns the value of field 'dtDTContactEntered'.
     * 
     * @return the value of field 'DtDTContactEntered'.
     */
    public org.exolab.castor.types.Date getDtDTContactEntered()
    {
        return this._dtDTContactEntered;
    } //-- org.exolab.castor.types.Date getDtDTContactEntered() 

    /**
     * Returns the value of field 'dtDTContactOccurred'.
     * 
     * @return the value of field 'DtDTContactOccurred'.
     */
    public org.exolab.castor.types.Date getDtDTContactOccurred()
    {
        return this._dtDTContactOccurred;
    } //-- org.exolab.castor.types.Date getDtDTContactOccurred() 

    /**
     * Returns the value of field 'dtDtMonthlySummBegin'.
     * 
     * @return the value of field 'DtDtMonthlySummBegin'.
     */
    public org.exolab.castor.types.Date getDtDtMonthlySummBegin()
    {
        return this._dtDtMonthlySummBegin;
    } //-- org.exolab.castor.types.Date getDtDtMonthlySummBegin() 

    /**
     * Returns the value of field 'dtDtMonthlySummEnd'.
     * 
     * @return the value of field 'DtDtMonthlySummEnd'.
     */
    public org.exolab.castor.types.Date getDtDtMonthlySummEnd()
    {
        return this._dtDtMonthlySummEnd;
    } //-- org.exolab.castor.types.Date getDtDtMonthlySummEnd() 

    /**
     * Returns the value of field 'indExtDocAccepted'.
     * 
     * @return the value of field 'IndExtDocAccepted'.
     */
    public java.lang.String getIndExtDocAccepted()
    {
        return this._indExtDocAccepted;
    } //-- java.lang.String getIndExtDocAccepted() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'ROWCLSC97DIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCLSC97DIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY getROWCLSC97DIG00_ARRAY()
    {
        return this._ROWCLSC97DIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY getROWCLSC97DIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCSVC02SIG03_ARRAY'.
     * 
     * @return the value of field 'ROWCSVC02SIG03_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY getROWCSVC02SIG03_ARRAY()
    {
        return this._ROWCSVC02SIG03_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY getROWCSVC02SIG03_ARRAY() 

    /**
     * Returns the value of field 'ROWCSYS07SI_ARRAY'.
     * 
     * @return the value of field 'ROWCSYS07SI_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY getROWCSYS07SI_ARRAY()
    {
        return this._ROWCSYS07SI_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY getROWCSYS07SI_ARRAY() 

    /**
     * Returns the value of field 'ROWDELETEDISCUSSED_ARRAY'.
     * 
     * @return the value of field 'ROWDELETEDISCUSSED_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY getROWDELETEDISCUSSED_ARRAY()
    {
        return this._ROWDELETEDISCUSSED_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY getROWDELETEDISCUSSED_ARRAY() 

    /**
     * Returns the value of field 'ROWDELETEPRIVCONVER_ARRAY'.
     * 
     * @return the value of field 'ROWDELETEPRIVCONVER_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY getROWDELETEPRIVCONVER_ARRAY()
    {
        return this._ROWDELETEPRIVCONVER_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY getROWDELETEPRIVCONVER_ARRAY() 

    /**
     * Returns the value of field 'ROWDISCUSSED_ARRAY'.
     * 
     * @return the value of field 'ROWDISCUSSED_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY getROWDISCUSSED_ARRAY()
    {
        return this._ROWDISCUSSED_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY getROWDISCUSSED_ARRAY() 

    /**
     * Returns the value of field 'ROWPRIVCONVER_ARRAY'.
     * 
     * @return the value of field 'ROWPRIVCONVER_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY getROWPRIVCONVER_ARRAY()
    {
        return this._ROWPRIVCONVER_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY getROWPRIVCONVER_ARRAY() 

    /**
     * Returns the value of field 'szCdContactLocation'.
     * 
     * @return the value of field 'SzCdContactLocation'.
     */
    public java.lang.String getSzCdContactLocation()
    {
        return this._szCdContactLocation;
    } //-- java.lang.String getSzCdContactLocation() 

    /**
     * Returns the value of field 'szCdContactMethod'.
     * 
     * @return the value of field 'SzCdContactMethod'.
     */
    public java.lang.String getSzCdContactMethod()
    {
        return this._szCdContactMethod;
    } //-- java.lang.String getSzCdContactMethod() 

    /**
     * Returns the value of field 'szCdContactNarrative'.
     * 
     * @return the value of field 'SzCdContactNarrative'.
     */
    public java.lang.String getSzCdContactNarrative()
    {
        return this._szCdContactNarrative;
    } //-- java.lang.String getSzCdContactNarrative() 

    /**
     * Returns the value of field 'szCdContactOthers'.
     * 
     * @return the value of field 'SzCdContactOthers'.
     */
    public java.lang.String getSzCdContactOthers()
    {
        return this._szCdContactOthers;
    } //-- java.lang.String getSzCdContactOthers() 

    /**
     * Returns the value of field 'szCdContactPurpose'.
     * 
     * @return the value of field 'SzCdContactPurpose'.
     */
    public java.lang.String getSzCdContactPurpose()
    {
        return this._szCdContactPurpose;
    } //-- java.lang.String getSzCdContactPurpose() 

    /**
     * Returns the value of field 'szCdContactType'.
     * 
     * @return the value of field 'SzCdContactType'.
     */
    public java.lang.String getSzCdContactType()
    {
        return this._szCdContactType;
    } //-- java.lang.String getSzCdContactType() 

    /**
     * Returns the value of field 'szCdContactedBy'.
     * 
     * @return the value of field 'SzCdContactedBy'.
     */
    public java.lang.String getSzCdContactedBy()
    {
        return this._szCdContactedBy;
    } //-- java.lang.String getSzCdContactedBy() 

    /**
     * Returns the value of field 'szCdPopulatedFrom'.
     * 
     * @return the value of field 'SzCdPopulatedFrom'.
     */
    public java.lang.String getSzCdPopulatedFrom()
    {
        return this._szCdPopulatedFrom;
    } //-- java.lang.String getSzCdPopulatedFrom() 

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
     * Returns the value of field 'szCdStageType'.
     * 
     * @return the value of field 'SzCdStageType'.
     */
    public java.lang.String getSzCdStageType()
    {
        return this._szCdStageType;
    } //-- java.lang.String getSzCdStageType() 

    /**
     * Returns the value of field 'szCdTCMEligible'.
     * 
     * @return the value of field 'SzCdTCMEligible'.
     */
    public java.lang.String getSzCdTCMEligible()
    {
        return this._szCdTCMEligible;
    } //-- java.lang.String getSzCdTCMEligible() 

    /**
     * Returns the value of field 'szCdTCMMedSvcs'.
     * 
     * @return the value of field 'SzCdTCMMedSvcs'.
     */
    public java.lang.String getSzCdTCMMedSvcs()
    {
        return this._szCdTCMMedSvcs;
    } //-- java.lang.String getSzCdTCMMedSvcs() 

    /**
     * Returns the value of field 'szNmAgencyName'.
     * 
     * @return the value of field 'SzNmAgencyName'.
     */
    public java.lang.String getSzNmAgencyName()
    {
        return this._szNmAgencyName;
    } //-- java.lang.String getSzNmAgencyName() 

    /**
     * Returns the value of field 'szNmContactedBy'.
     * 
     * @return the value of field 'SzNmContactedBy'.
     */
    public java.lang.String getSzNmContactedBy()
    {
        return this._szNmContactedBy;
    } //-- java.lang.String getSzNmContactedBy() 

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
     * Returns the value of field 'szNmPortalUserFull'.
     * 
     * @return the value of field 'SzNmPortalUserFull'.
     */
    public java.lang.String getSzNmPortalUserFull()
    {
        return this._szNmPortalUserFull;
    } //-- java.lang.String getSzNmPortalUserFull() 

    /**
     * Returns the value of field 'szTitlePortalUser'.
     * 
     * @return the value of field 'SzTitlePortalUser'.
     */
    public java.lang.String getSzTitlePortalUser()
    {
        return this._szTitlePortalUser;
    } //-- java.lang.String getSzTitlePortalUser() 

    /**
     * Returns the value of field 'tmScrTmCntct'.
     * 
     * @return the value of field 'TmScrTmCntct'.
     */
    public java.lang.String getTmScrTmCntct()
    {
        return this._tmScrTmCntct;
    } //-- java.lang.String getTmScrTmCntct() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdPortalUser'.
     * 
     * @return the value of field 'UlIdPortalUser'.
     */
    public int getUlIdPortalUser()
    {
        return this._ulIdPortalUser;
    } //-- int getUlIdPortalUser() 

    /**
     * Returns the value of field 'ulIdTCMClient'.
     * 
     * @return the value of field 'UlIdTCMClient'.
     */
    public int getUlIdTCMClient()
    {
        return this._ulIdTCMClient;
    } //-- int getUlIdTCMClient() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Returns the value of field 'ulRowSelected'.
     * 
     * @return the value of field 'UlRowSelected'.
     */
    public int getUlRowSelected()
    {
        return this._ulRowSelected;
    } //-- int getUlRowSelected() 

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
     * Method hasUlIdPortalUser
     * 
     * 
     * 
     * @return true if at least one UlIdPortalUser has been added
     */
    public boolean hasUlIdPortalUser()
    {
        return this._has_ulIdPortalUser;
    } //-- boolean hasUlIdPortalUser() 

    /**
     * Method hasUlIdTCMClient
     * 
     * 
     * 
     * @return true if at least one UlIdTCMClient has been added
     */
    public boolean hasUlIdTCMClient()
    {
        return this._has_ulIdTCMClient;
    } //-- boolean hasUlIdTCMClient() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

    /**
     * Method hasUlRowSelected
     * 
     * 
     * 
     * @return true if at least one UlRowSelected has been added
     */
    public boolean hasUlRowSelected()
    {
        return this._has_ulRowSelected;
    } //-- boolean hasUlRowSelected() 

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
     * Sets the value of field 'bIndContactAttempted'.
     * 
     * @param bIndContactAttempted the value of field
     * 'bIndContactAttempted'.
     */
    public void setBIndContactAttempted(java.lang.String bIndContactAttempted)
    {
        this._bIndContactAttempted = bIndContactAttempted;
    } //-- void setBIndContactAttempted(java.lang.String) 

    /**
     * Sets the value of field 'bIndCrossCountyLines'.
     * 
     * @param bIndCrossCountyLines the value of field
     * 'bIndCrossCountyLines'.
     */
    public void setBIndCrossCountyLines(java.lang.String bIndCrossCountyLines)
    {
        this._bIndCrossCountyLines = bIndCrossCountyLines;
    } //-- void setBIndCrossCountyLines(java.lang.String) 

    /**
     * Sets the value of field 'bIndDeleteDoc'.
     * 
     * @param bIndDeleteDoc the value of field 'bIndDeleteDoc'.
     */
    public void setBIndDeleteDoc(java.lang.String bIndDeleteDoc)
    {
        this._bIndDeleteDoc = bIndDeleteDoc;
    } //-- void setBIndDeleteDoc(java.lang.String) 

    /**
     * Sets the value of field 'bIndReview'.
     * 
     * @param bIndReview the value of field 'bIndReview'.
     */
    public void setBIndReview(java.lang.String bIndReview)
    {
        this._bIndReview = bIndReview;
    } //-- void setBIndReview(java.lang.String) 

    /**
     * Sets the value of field 'bIndVictimSelected'.
     * 
     * @param bIndVictimSelected the value of field
     * 'bIndVictimSelected'.
     */
    public void setBIndVictimSelected(java.lang.String bIndVictimSelected)
    {
        this._bIndVictimSelected = bIndVictimSelected;
    } //-- void setBIndVictimSelected(java.lang.String) 

    /**
     * Sets the value of field 'contactCbxRecord_Array'.
     * 
     * @param contactCbxRecord_Array the value of field
     * 'contactCbxRecord_Array'.
     */
    public void setContactCbxRecord_Array(gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array contactCbxRecord_Array)
    {
        this._contactCbxRecord_Array = contactCbxRecord_Array;
    } //-- void setContactCbxRecord_Array(gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array) 

    /**
     * Sets the value of field 'dtDTContactEntered'.
     * 
     * @param dtDTContactEntered the value of field
     * 'dtDTContactEntered'.
     */
    public void setDtDTContactEntered(org.exolab.castor.types.Date dtDTContactEntered)
    {
        this._dtDTContactEntered = dtDTContactEntered;
    } //-- void setDtDTContactEntered(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDTContactOccurred'.
     * 
     * @param dtDTContactOccurred the value of field
     * 'dtDTContactOccurred'.
     */
    public void setDtDTContactOccurred(org.exolab.castor.types.Date dtDTContactOccurred)
    {
        this._dtDTContactOccurred = dtDTContactOccurred;
    } //-- void setDtDTContactOccurred(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtMonthlySummBegin'.
     * 
     * @param dtDtMonthlySummBegin the value of field
     * 'dtDtMonthlySummBegin'.
     */
    public void setDtDtMonthlySummBegin(org.exolab.castor.types.Date dtDtMonthlySummBegin)
    {
        this._dtDtMonthlySummBegin = dtDtMonthlySummBegin;
    } //-- void setDtDtMonthlySummBegin(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtMonthlySummEnd'.
     * 
     * @param dtDtMonthlySummEnd the value of field
     * 'dtDtMonthlySummEnd'.
     */
    public void setDtDtMonthlySummEnd(org.exolab.castor.types.Date dtDtMonthlySummEnd)
    {
        this._dtDtMonthlySummEnd = dtDtMonthlySummEnd;
    } //-- void setDtDtMonthlySummEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indExtDocAccepted'.
     * 
     * @param indExtDocAccepted the value of field
     * 'indExtDocAccepted'.
     */
    public void setIndExtDocAccepted(java.lang.String indExtDocAccepted)
    {
        this._indExtDocAccepted = indExtDocAccepted;
    } //-- void setIndExtDocAccepted(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'ROWCLSC97DIG00_ARRAY'.
     * 
     * @param ROWCLSC97DIG00_ARRAY the value of field
     * 'ROWCLSC97DIG00_ARRAY'.
     */
    public void setROWCLSC97DIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY ROWCLSC97DIG00_ARRAY)
    {
        this._ROWCLSC97DIG00_ARRAY = ROWCLSC97DIG00_ARRAY;
    } //-- void setROWCLSC97DIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCLSC97DIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCSVC02SIG03_ARRAY'.
     * 
     * @param ROWCSVC02SIG03_ARRAY the value of field
     * 'ROWCSVC02SIG03_ARRAY'.
     */
    public void setROWCSVC02SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY ROWCSVC02SIG03_ARRAY)
    {
        this._ROWCSVC02SIG03_ARRAY = ROWCSVC02SIG03_ARRAY;
    } //-- void setROWCSVC02SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY) 

    /**
     * Sets the value of field 'ROWCSYS07SI_ARRAY'.
     * 
     * @param ROWCSYS07SI_ARRAY the value of field
     * 'ROWCSYS07SI_ARRAY'.
     */
    public void setROWCSYS07SI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY ROWCSYS07SI_ARRAY)
    {
        this._ROWCSYS07SI_ARRAY = ROWCSYS07SI_ARRAY;
    } //-- void setROWCSYS07SI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY) 

    /**
     * Sets the value of field 'ROWDELETEDISCUSSED_ARRAY'.
     * 
     * @param ROWDELETEDISCUSSED_ARRAY the value of field
     * 'ROWDELETEDISCUSSED_ARRAY'.
     */
    public void setROWDELETEDISCUSSED_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY ROWDELETEDISCUSSED_ARRAY)
    {
        this._ROWDELETEDISCUSSED_ARRAY = ROWDELETEDISCUSSED_ARRAY;
    } //-- void setROWDELETEDISCUSSED_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY) 

    /**
     * Sets the value of field 'ROWDELETEPRIVCONVER_ARRAY'.
     * 
     * @param ROWDELETEPRIVCONVER_ARRAY the value of field
     * 'ROWDELETEPRIVCONVER_ARRAY'.
     */
    public void setROWDELETEPRIVCONVER_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY ROWDELETEPRIVCONVER_ARRAY)
    {
        this._ROWDELETEPRIVCONVER_ARRAY = ROWDELETEPRIVCONVER_ARRAY;
    } //-- void setROWDELETEPRIVCONVER_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY) 

    /**
     * Sets the value of field 'ROWDISCUSSED_ARRAY'.
     * 
     * @param ROWDISCUSSED_ARRAY the value of field
     * 'ROWDISCUSSED_ARRAY'.
     */
    public void setROWDISCUSSED_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY ROWDISCUSSED_ARRAY)
    {
        this._ROWDISCUSSED_ARRAY = ROWDISCUSSED_ARRAY;
    } //-- void setROWDISCUSSED_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY) 

    /**
     * Sets the value of field 'ROWPRIVCONVER_ARRAY'.
     * 
     * @param ROWPRIVCONVER_ARRAY the value of field
     * 'ROWPRIVCONVER_ARRAY'.
     */
    public void setROWPRIVCONVER_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY ROWPRIVCONVER_ARRAY)
    {
        this._ROWPRIVCONVER_ARRAY = ROWPRIVCONVER_ARRAY;
    } //-- void setROWPRIVCONVER_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY) 

    /**
     * Sets the value of field 'szCdContactLocation'.
     * 
     * @param szCdContactLocation the value of field
     * 'szCdContactLocation'.
     */
    public void setSzCdContactLocation(java.lang.String szCdContactLocation)
    {
        this._szCdContactLocation = szCdContactLocation;
    } //-- void setSzCdContactLocation(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactMethod'.
     * 
     * @param szCdContactMethod the value of field
     * 'szCdContactMethod'.
     */
    public void setSzCdContactMethod(java.lang.String szCdContactMethod)
    {
        this._szCdContactMethod = szCdContactMethod;
    } //-- void setSzCdContactMethod(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactNarrative'.
     * 
     * @param szCdContactNarrative the value of field
     * 'szCdContactNarrative'.
     */
    public void setSzCdContactNarrative(java.lang.String szCdContactNarrative)
    {
        this._szCdContactNarrative = szCdContactNarrative;
    } //-- void setSzCdContactNarrative(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactOthers'.
     * 
     * @param szCdContactOthers the value of field
     * 'szCdContactOthers'.
     */
    public void setSzCdContactOthers(java.lang.String szCdContactOthers)
    {
        this._szCdContactOthers = szCdContactOthers;
    } //-- void setSzCdContactOthers(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactPurpose'.
     * 
     * @param szCdContactPurpose the value of field
     * 'szCdContactPurpose'.
     */
    public void setSzCdContactPurpose(java.lang.String szCdContactPurpose)
    {
        this._szCdContactPurpose = szCdContactPurpose;
    } //-- void setSzCdContactPurpose(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactType'.
     * 
     * @param szCdContactType the value of field 'szCdContactType'.
     */
    public void setSzCdContactType(java.lang.String szCdContactType)
    {
        this._szCdContactType = szCdContactType;
    } //-- void setSzCdContactType(java.lang.String) 

    /**
     * Sets the value of field 'szCdContactedBy'.
     * 
     * @param szCdContactedBy the value of field 'szCdContactedBy'.
     */
    public void setSzCdContactedBy(java.lang.String szCdContactedBy)
    {
        this._szCdContactedBy = szCdContactedBy;
    } //-- void setSzCdContactedBy(java.lang.String) 

    /**
     * Sets the value of field 'szCdPopulatedFrom'.
     * 
     * @param szCdPopulatedFrom the value of field
     * 'szCdPopulatedFrom'.
     */
    public void setSzCdPopulatedFrom(java.lang.String szCdPopulatedFrom)
    {
        this._szCdPopulatedFrom = szCdPopulatedFrom;
    } //-- void setSzCdPopulatedFrom(java.lang.String) 

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
     * Sets the value of field 'szCdStageType'.
     * 
     * @param szCdStageType the value of field 'szCdStageType'.
     */
    public void setSzCdStageType(java.lang.String szCdStageType)
    {
        this._szCdStageType = szCdStageType;
    } //-- void setSzCdStageType(java.lang.String) 

    /**
     * Sets the value of field 'szCdTCMEligible'.
     * 
     * @param szCdTCMEligible the value of field 'szCdTCMEligible'.
     */
    public void setSzCdTCMEligible(java.lang.String szCdTCMEligible)
    {
        this._szCdTCMEligible = szCdTCMEligible;
    } //-- void setSzCdTCMEligible(java.lang.String) 

    /**
     * Sets the value of field 'szCdTCMMedSvcs'.
     * 
     * @param szCdTCMMedSvcs the value of field 'szCdTCMMedSvcs'.
     */
    public void setSzCdTCMMedSvcs(java.lang.String szCdTCMMedSvcs)
    {
        this._szCdTCMMedSvcs = szCdTCMMedSvcs;
    } //-- void setSzCdTCMMedSvcs(java.lang.String) 

    /**
     * Sets the value of field 'szNmAgencyName'.
     * 
     * @param szNmAgencyName the value of field 'szNmAgencyName'.
     */
    public void setSzNmAgencyName(java.lang.String szNmAgencyName)
    {
        this._szNmAgencyName = szNmAgencyName;
    } //-- void setSzNmAgencyName(java.lang.String) 

    /**
     * Sets the value of field 'szNmContactedBy'.
     * 
     * @param szNmContactedBy the value of field 'szNmContactedBy'.
     */
    public void setSzNmContactedBy(java.lang.String szNmContactedBy)
    {
        this._szNmContactedBy = szNmContactedBy;
    } //-- void setSzNmContactedBy(java.lang.String) 

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
     * Sets the value of field 'szNmPortalUserFull'.
     * 
     * @param szNmPortalUserFull the value of field
     * 'szNmPortalUserFull'.
     */
    public void setSzNmPortalUserFull(java.lang.String szNmPortalUserFull)
    {
        this._szNmPortalUserFull = szNmPortalUserFull;
    } //-- void setSzNmPortalUserFull(java.lang.String) 

    /**
     * Sets the value of field 'szTitlePortalUser'.
     * 
     * @param szTitlePortalUser the value of field
     * 'szTitlePortalUser'.
     */
    public void setSzTitlePortalUser(java.lang.String szTitlePortalUser)
    {
        this._szTitlePortalUser = szTitlePortalUser;
    } //-- void setSzTitlePortalUser(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmCntct'.
     * 
     * @param tmScrTmCntct the value of field 'tmScrTmCntct'.
     */
    public void setTmScrTmCntct(java.lang.String tmScrTmCntct)
    {
        this._tmScrTmCntct = tmScrTmCntct;
    } //-- void setTmScrTmCntct(java.lang.String) 

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
     * Sets the value of field 'ulIdPortalUser'.
     * 
     * @param ulIdPortalUser the value of field 'ulIdPortalUser'.
     */
    public void setUlIdPortalUser(int ulIdPortalUser)
    {
        this._ulIdPortalUser = ulIdPortalUser;
        this._has_ulIdPortalUser = true;
    } //-- void setUlIdPortalUser(int) 

    /**
     * Sets the value of field 'ulIdTCMClient'.
     * 
     * @param ulIdTCMClient the value of field 'ulIdTCMClient'.
     */
    public void setUlIdTCMClient(int ulIdTCMClient)
    {
        this._ulIdTCMClient = ulIdTCMClient;
        this._has_ulIdTCMClient = true;
    } //-- void setUlIdTCMClient(int) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

    /**
     * Sets the value of field 'ulRowSelected'.
     * 
     * @param ulRowSelected the value of field 'ulRowSelected'.
     */
    public void setUlRowSelected(int ulRowSelected)
    {
        this._ulRowSelected = ulRowSelected;
        this._has_ulRowSelected = true;
    } //-- void setUlRowSelected(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI unmarshal(java.io.Reader) 

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
