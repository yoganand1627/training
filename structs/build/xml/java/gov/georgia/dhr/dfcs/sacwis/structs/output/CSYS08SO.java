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
 * Class CSYS08SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSYS08SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _cIndFacilSuperintNotif
     */
    private java.lang.String _cIndFacilSuperintNotif;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulNbrReviewContact
     */
    private int _ulNbrReviewContact;

    /**
     * keeps track of state for field: _ulNbrReviewContact
     */
    private boolean _has_ulNbrReviewContact;

    /**
     * Field _tsSysTsLastUpdate3
     */
    private java.util.Date _tsSysTsLastUpdate3;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdStageClassification
     */
    private java.lang.String _szCdStageClassification;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

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
     * Field _szCdContactedBy
     */
    private java.lang.String _szCdContactedBy;

    /**
     * Field _szCdContactType
     */
    private java.lang.String _szCdContactType;

    /**
     * Field _szCdRsrcCategory
     */
    private java.lang.String _szCdRsrcCategory;

    /**
     * Field _szCdContactNarr
     */
    private java.lang.String _szCdContactNarr;

    /**
     * Field _dtDTContactOccurred
     */
    private java.util.Date _dtDTContactOccurred;

    /**
     * Field _dtDTContactEntered
     */
    private org.exolab.castor.types.Date _dtDTContactEntered;

    /**
     * Field _tmScrTmCntct_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY _tmScrTmCntct_ARRAY;

    /**
     * Field _bIndContactAttempted
     */
    private java.lang.String _bIndContactAttempted;

    /**
     * Field _cIndRsrcTransport
     */
    private java.lang.String _cIndRsrcTransport;

    /**
     * Field _cSysIndContactOccurred
     */
    private java.lang.String _cSysIndContactOccurred;

    /**
     * Field _dtDtMonthlySummBegin
     */
    private org.exolab.castor.types.Date _dtDtMonthlySummBegin;

    /**
     * Field _dtDtMonthlySummEnd
     */
    private org.exolab.castor.types.Date _dtDtMonthlySummEnd;

    /**
     * Field _szScrTxtNarrStatus
     */
    private java.lang.String _szScrTxtNarrStatus;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _bScrIndStructNarrExists
     */
    private java.lang.String _bScrIndStructNarrExists;

    /**
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _dtDtIntStart
     */
    private java.util.Date _dtDtIntStart;

    /**
     * Field _ROWCCMN45DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO _ROWCCMN45DO;

    /**
     * Field _ROWCSYS08SO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY _ROWCSYS08SO_ARRAY;

    /**
     * Field _szNmAgencyName
     */
    private java.lang.String _szNmAgencyName;

    /**
     * Field _szCdJobTitle
     */
    private java.lang.String _szCdJobTitle;

    /**
     * Field _bIndCrossCountyLines
     */
    private java.lang.String _bIndCrossCountyLines;

    /**
     * Field _bIndTcmNBLStatus
     */
    private boolean _bIndTcmNBLStatus;

    /**
     * keeps track of state for field: _bIndTcmNBLStatus
     */
    private boolean _has_bIndTcmNBLStatus;

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
     * Field _indExtDocAccepted
     */
    private java.lang.String _indExtDocAccepted;

    /**
     * Field _contactCbxDisplay_Array
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array _contactCbxDisplay_Array;

    /**
     * Field _ROWPRIVCONVERSO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY _ROWPRIVCONVERSO_ARRAY;

    /**
     * Field _ROWDISCUSSEDSO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY _ROWDISCUSSEDSO_ARRAY;

    /**
     * Field _szCdPopulatedFrom
     */
    private java.lang.String _szCdPopulatedFrom;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSYS08SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndTcmNBLStatus()
    {
        this._has_bIndTcmNBLStatus= false;
    } //-- void deleteBIndTcmNBLStatus() 

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
    public void deleteUlNbrReviewContact()
    {
        this._has_ulNbrReviewContact= false;
    } //-- void deleteUlNbrReviewContact() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

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
     * Returns the value of field 'bIndTcmNBLStatus'.
     * 
     * @return the value of field 'BIndTcmNBLStatus'.
     */
    public boolean getBIndTcmNBLStatus()
    {
        return this._bIndTcmNBLStatus;
    } //-- boolean getBIndTcmNBLStatus() 

    /**
     * Returns the value of field 'bScrIndStructNarrExists'.
     * 
     * @return the value of field 'BScrIndStructNarrExists'.
     */
    public java.lang.String getBScrIndStructNarrExists()
    {
        return this._bScrIndStructNarrExists;
    } //-- java.lang.String getBScrIndStructNarrExists() 

    /**
     * Returns the value of field 'cIndFacilSuperintNotif'.
     * 
     * @return the value of field 'CIndFacilSuperintNotif'.
     */
    public java.lang.String getCIndFacilSuperintNotif()
    {
        return this._cIndFacilSuperintNotif;
    } //-- java.lang.String getCIndFacilSuperintNotif() 

    /**
     * Returns the value of field 'cIndRsrcTransport'.
     * 
     * @return the value of field 'CIndRsrcTransport'.
     */
    public java.lang.String getCIndRsrcTransport()
    {
        return this._cIndRsrcTransport;
    } //-- java.lang.String getCIndRsrcTransport() 

    /**
     * Returns the value of field 'cSysIndContactOccurred'.
     * 
     * @return the value of field 'CSysIndContactOccurred'.
     */
    public java.lang.String getCSysIndContactOccurred()
    {
        return this._cSysIndContactOccurred;
    } //-- java.lang.String getCSysIndContactOccurred() 

    /**
     * Returns the value of field 'contactCbxDisplay_Array'.
     * 
     * @return the value of field 'ContactCbxDisplay_Array'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array getContactCbxDisplay_Array()
    {
        return this._contactCbxDisplay_Array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array getContactCbxDisplay_Array() 

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
    public java.util.Date getDtDTContactOccurred()
    {
        return this._dtDTContactOccurred;
    } //-- java.util.Date getDtDTContactOccurred() 

    /**
     * Returns the value of field 'dtDtIntStart'.
     * 
     * @return the value of field 'DtDtIntStart'.
     */
    public java.util.Date getDtDtIntStart()
    {
        return this._dtDtIntStart;
    } //-- java.util.Date getDtDtIntStart() 

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
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

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
     * Returns the value of field 'ROWCCMN45DO'.
     * 
     * @return the value of field 'ROWCCMN45DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO()
    {
        return this._ROWCCMN45DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO() 

    /**
     * Returns the value of field 'ROWCSYS08SO_ARRAY'.
     * 
     * @return the value of field 'ROWCSYS08SO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY getROWCSYS08SO_ARRAY()
    {
        return this._ROWCSYS08SO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY getROWCSYS08SO_ARRAY() 

    /**
     * Returns the value of field 'ROWDISCUSSEDSO_ARRAY'.
     * 
     * @return the value of field 'ROWDISCUSSEDSO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY getROWDISCUSSEDSO_ARRAY()
    {
        return this._ROWDISCUSSEDSO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY getROWDISCUSSEDSO_ARRAY() 

    /**
     * Returns the value of field 'ROWPRIVCONVERSO_ARRAY'.
     * 
     * @return the value of field 'ROWPRIVCONVERSO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY getROWPRIVCONVERSO_ARRAY()
    {
        return this._ROWPRIVCONVERSO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY getROWPRIVCONVERSO_ARRAY() 

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
     * Returns the value of field 'szCdContactNarr'.
     * 
     * @return the value of field 'SzCdContactNarr'.
     */
    public java.lang.String getSzCdContactNarr()
    {
        return this._szCdContactNarr;
    } //-- java.lang.String getSzCdContactNarr() 

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
     * Returns the value of field 'szCdJobTitle'.
     * 
     * @return the value of field 'SzCdJobTitle'.
     */
    public java.lang.String getSzCdJobTitle()
    {
        return this._szCdJobTitle;
    } //-- java.lang.String getSzCdJobTitle() 

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
     * Returns the value of field 'szCdRsrcCategory'.
     * 
     * @return the value of field 'SzCdRsrcCategory'.
     */
    public java.lang.String getSzCdRsrcCategory()
    {
        return this._szCdRsrcCategory;
    } //-- java.lang.String getSzCdRsrcCategory() 

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
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

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
     * Returns the value of field 'szScrTxtNarrStatus'.
     * 
     * @return the value of field 'SzScrTxtNarrStatus'.
     */
    public java.lang.String getSzScrTxtNarrStatus()
    {
        return this._szScrTxtNarrStatus;
    } //-- java.lang.String getSzScrTxtNarrStatus() 

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
     * Returns the value of field 'tmScrTmCntct_ARRAY'.
     * 
     * @return the value of field 'TmScrTmCntct_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY getTmScrTmCntct_ARRAY()
    {
        return this._tmScrTmCntct_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY getTmScrTmCntct_ARRAY() 

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
     * Returns the value of field 'ulNbrReviewContact'.
     * 
     * @return the value of field 'UlNbrReviewContact'.
     */
    public int getUlNbrReviewContact()
    {
        return this._ulNbrReviewContact;
    } //-- int getUlNbrReviewContact() 

    /**
     * Method hasBIndTcmNBLStatus
     * 
     * 
     * 
     * @return true if at least one BIndTcmNBLStatus has been added
     */
    public boolean hasBIndTcmNBLStatus()
    {
        return this._has_bIndTcmNBLStatus;
    } //-- boolean hasBIndTcmNBLStatus() 

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
     * Method hasUlNbrReviewContact
     * 
     * 
     * 
     * @return true if at least one UlNbrReviewContact has been adde
     */
    public boolean hasUlNbrReviewContact()
    {
        return this._has_ulNbrReviewContact;
    } //-- boolean hasUlNbrReviewContact() 

    /**
     * Returns the value of field 'bIndTcmNBLStatus'.
     * 
     * @return the value of field 'BIndTcmNBLStatus'.
     */
    public boolean isBIndTcmNBLStatus()
    {
        return this._bIndTcmNBLStatus;
    } //-- boolean isBIndTcmNBLStatus() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

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
     * Sets the value of field 'bIndTcmNBLStatus'.
     * 
     * @param bIndTcmNBLStatus the value of field 'bIndTcmNBLStatus'
     */
    public void setBIndTcmNBLStatus(boolean bIndTcmNBLStatus)
    {
        this._bIndTcmNBLStatus = bIndTcmNBLStatus;
        this._has_bIndTcmNBLStatus = true;
    } //-- void setBIndTcmNBLStatus(boolean) 

    /**
     * Sets the value of field 'bScrIndStructNarrExists'.
     * 
     * @param bScrIndStructNarrExists the value of field
     * 'bScrIndStructNarrExists'.
     */
    public void setBScrIndStructNarrExists(java.lang.String bScrIndStructNarrExists)
    {
        this._bScrIndStructNarrExists = bScrIndStructNarrExists;
    } //-- void setBScrIndStructNarrExists(java.lang.String) 

    /**
     * Sets the value of field 'cIndFacilSuperintNotif'.
     * 
     * @param cIndFacilSuperintNotif the value of field
     * 'cIndFacilSuperintNotif'.
     */
    public void setCIndFacilSuperintNotif(java.lang.String cIndFacilSuperintNotif)
    {
        this._cIndFacilSuperintNotif = cIndFacilSuperintNotif;
    } //-- void setCIndFacilSuperintNotif(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcTransport'.
     * 
     * @param cIndRsrcTransport the value of field
     * 'cIndRsrcTransport'.
     */
    public void setCIndRsrcTransport(java.lang.String cIndRsrcTransport)
    {
        this._cIndRsrcTransport = cIndRsrcTransport;
    } //-- void setCIndRsrcTransport(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndContactOccurred'.
     * 
     * @param cSysIndContactOccurred the value of field
     * 'cSysIndContactOccurred'.
     */
    public void setCSysIndContactOccurred(java.lang.String cSysIndContactOccurred)
    {
        this._cSysIndContactOccurred = cSysIndContactOccurred;
    } //-- void setCSysIndContactOccurred(java.lang.String) 

    /**
     * Sets the value of field 'contactCbxDisplay_Array'.
     * 
     * @param contactCbxDisplay_Array the value of field
     * 'contactCbxDisplay_Array'.
     */
    public void setContactCbxDisplay_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array contactCbxDisplay_Array)
    {
        this._contactCbxDisplay_Array = contactCbxDisplay_Array;
    } //-- void setContactCbxDisplay_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array) 

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
    public void setDtDTContactOccurred(java.util.Date dtDTContactOccurred)
    {
        this._dtDTContactOccurred = dtDTContactOccurred;
    } //-- void setDtDTContactOccurred(java.util.Date) 

    /**
     * Sets the value of field 'dtDtIntStart'.
     * 
     * @param dtDtIntStart the value of field 'dtDtIntStart'.
     */
    public void setDtDtIntStart(java.util.Date dtDtIntStart)
    {
        this._dtDtIntStart = dtDtIntStart;
    } //-- void setDtDtIntStart(java.util.Date) 

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
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCCMN45DO'.
     * 
     * @param ROWCCMN45DO the value of field 'ROWCCMN45DO'.
     */
    public void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO ROWCCMN45DO)
    {
        this._ROWCCMN45DO = ROWCCMN45DO;
    } //-- void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO) 

    /**
     * Sets the value of field 'ROWCSYS08SO_ARRAY'.
     * 
     * @param ROWCSYS08SO_ARRAY the value of field
     * 'ROWCSYS08SO_ARRAY'.
     */
    public void setROWCSYS08SO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY ROWCSYS08SO_ARRAY)
    {
        this._ROWCSYS08SO_ARRAY = ROWCSYS08SO_ARRAY;
    } //-- void setROWCSYS08SO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY) 

    /**
     * Sets the value of field 'ROWDISCUSSEDSO_ARRAY'.
     * 
     * @param ROWDISCUSSEDSO_ARRAY the value of field
     * 'ROWDISCUSSEDSO_ARRAY'.
     */
    public void setROWDISCUSSEDSO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY ROWDISCUSSEDSO_ARRAY)
    {
        this._ROWDISCUSSEDSO_ARRAY = ROWDISCUSSEDSO_ARRAY;
    } //-- void setROWDISCUSSEDSO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY) 

    /**
     * Sets the value of field 'ROWPRIVCONVERSO_ARRAY'.
     * 
     * @param ROWPRIVCONVERSO_ARRAY the value of field
     * 'ROWPRIVCONVERSO_ARRAY'.
     */
    public void setROWPRIVCONVERSO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY ROWPRIVCONVERSO_ARRAY)
    {
        this._ROWPRIVCONVERSO_ARRAY = ROWPRIVCONVERSO_ARRAY;
    } //-- void setROWPRIVCONVERSO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY) 

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
     * Sets the value of field 'szCdContactNarr'.
     * 
     * @param szCdContactNarr the value of field 'szCdContactNarr'.
     */
    public void setSzCdContactNarr(java.lang.String szCdContactNarr)
    {
        this._szCdContactNarr = szCdContactNarr;
    } //-- void setSzCdContactNarr(java.lang.String) 

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
     * Sets the value of field 'szCdJobTitle'.
     * 
     * @param szCdJobTitle the value of field 'szCdJobTitle'.
     */
    public void setSzCdJobTitle(java.lang.String szCdJobTitle)
    {
        this._szCdJobTitle = szCdJobTitle;
    } //-- void setSzCdJobTitle(java.lang.String) 

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
     * Sets the value of field 'szCdRsrcCategory'.
     * 
     * @param szCdRsrcCategory the value of field 'szCdRsrcCategory'
     */
    public void setSzCdRsrcCategory(java.lang.String szCdRsrcCategory)
    {
        this._szCdRsrcCategory = szCdRsrcCategory;
    } //-- void setSzCdRsrcCategory(java.lang.String) 

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
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

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
     * Sets the value of field 'szScrTxtNarrStatus'.
     * 
     * @param szScrTxtNarrStatus the value of field
     * 'szScrTxtNarrStatus'.
     */
    public void setSzScrTxtNarrStatus(java.lang.String szScrTxtNarrStatus)
    {
        this._szScrTxtNarrStatus = szScrTxtNarrStatus;
    } //-- void setSzScrTxtNarrStatus(java.lang.String) 

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
     * Sets the value of field 'tmScrTmCntct_ARRAY'.
     * 
     * @param tmScrTmCntct_ARRAY the value of field
     * 'tmScrTmCntct_ARRAY'.
     */
    public void setTmScrTmCntct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY tmScrTmCntct_ARRAY)
    {
        this._tmScrTmCntct_ARRAY = tmScrTmCntct_ARRAY;
    } //-- void setTmScrTmCntct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY) 

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
     * Sets the value of field 'ulNbrReviewContact'.
     * 
     * @param ulNbrReviewContact the value of field
     * 'ulNbrReviewContact'.
     */
    public void setUlNbrReviewContact(int ulNbrReviewContact)
    {
        this._ulNbrReviewContact = ulNbrReviewContact;
        this._has_ulNbrReviewContact = true;
    } //-- void setUlNbrReviewContact(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO unmarshal(java.io.Reader) 

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
