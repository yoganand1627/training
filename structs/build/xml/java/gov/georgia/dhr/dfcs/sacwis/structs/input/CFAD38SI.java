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
 * Class CFAD38SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD38SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _cSysIndAppStatusChange
     */
    private java.lang.String _cSysIndAppStatusChange;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _isApprovalMode
     */
    private boolean _isApprovalMode;

    /**
     * keeps track of state for field: _isApprovalMode
     */
    private boolean _has_isApprovalMode;

    /**
     * Field _szCdRsrcCategory
     */
    private java.lang.String _szCdRsrcCategory;

    /**
     * Field _szCdRsrcFaHomeStatus
     */
    private java.lang.String _szCdRsrcFaHomeStatus;

    /**
     * Field _uNbrRsrcMlAgeMin
     */
    private int _uNbrRsrcMlAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMin
     */
    private boolean _has_uNbrRsrcMlAgeMin;

    /**
     * Field _uNbrRsrcMlAgeMax
     */
    private int _uNbrRsrcMlAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMax
     */
    private boolean _has_uNbrRsrcMlAgeMax;

    /**
     * Field _uNbrRsrcFMAgeMin
     */
    private int _uNbrRsrcFMAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMin
     */
    private boolean _has_uNbrRsrcFMAgeMin;

    /**
     * Field _uNbrRsrcFMAgeMax
     */
    private int _uNbrRsrcFMAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMax
     */
    private boolean _has_uNbrRsrcFMAgeMax;

    /**
     * Field _uNbrRsrcFacilCapacity
     */
    private int _uNbrRsrcFacilCapacity;

    /**
     * keeps track of state for field: _uNbrRsrcFacilCapacity
     */
    private boolean _has_uNbrRsrcFacilCapacity;

    /**
     * Field _cCdRsrcFaHomeType1
     */
    private java.lang.String _cCdRsrcFaHomeType1;

    /**
     * Field _sNbrRsrcOpenSlots
     */
    private int _sNbrRsrcOpenSlots;

    /**
     * keeps track of state for field: _sNbrRsrcOpenSlots
     */
    private boolean _has_sNbrRsrcOpenSlots;

    /**
     * Field _szCdRsrcStatus
     */
    private java.lang.String _szCdRsrcStatus;

    /**
     * Field _cCdFlocStatus1
     */
    private java.lang.String _cCdFlocStatus1;

    /**
     * Field _cCdFlocStatus2
     */
    private java.lang.String _cCdFlocStatus2;

    /**
     * Field _cCdFlocStatus3
     */
    private java.lang.String _cCdFlocStatus3;

    /**
     * Field _cCdFlocStatus4
     */
    private java.lang.String _cCdFlocStatus4;

    /**
     * Field _cSysIndFosterTypeChange
     */
    private java.lang.String _cSysIndFosterTypeChange;

    /**
     * Field _cSysIndLocChange
     */
    private java.lang.String _cSysIndLocChange;

    /**
     * Field _cSysIndCategoryChange
     */
    private java.lang.String _cSysIndCategoryChange;

    /**
     * Field _cSysIndFeAgeChange
     */
    private java.lang.String _cSysIndFeAgeChange;

    /**
     * Field _cSysIndMaAgeChange
     */
    private java.lang.String _cSysIndMaAgeChange;

    /**
     * Field _cIndRshsNonDFCSHome
     */
    private java.lang.String _cIndRshsNonDFCSHome;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _szNmRsrcLastUpdate
     */
    private java.lang.String _szNmRsrcLastUpdate;

    /**
     * Field _szCdRshsRegion
     */
    private java.lang.String _szCdRshsRegion;

    /**
     * Field _szCdRsrcCnty
     */
    private java.lang.String _szCdRsrcCnty;

    /**
     * Field _ulIdCntrctWkr
     */
    private int _ulIdCntrctWkr;

    /**
     * keeps track of state for field: _ulIdCntrctWkr
     */
    private boolean _has_ulIdCntrctWkr;

    /**
     * Field _szCdRsrcClosureRsn
     */
    private java.lang.String _szCdRsrcClosureRsn;

    /**
     * Field _szCdRsrcInvolClosure
     */
    private java.lang.String _szCdRsrcInvolClosure;

    /**
     * Field _szCdRsrcRecmndReopen
     */
    private java.lang.String _szCdRsrcRecmndReopen;

    /**
     * Field _ROWCCMN01UIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY _ROWCCMN01UIG00_ARRAY;

    /**
     * Field _cIndRshsWriteHist
     */
    private java.lang.String _cIndRshsWriteHist;

    /**
     * Field _szTxtNdfcsCertEntity
     */
    private java.lang.String _szTxtNdfcsCertEntity;

    /**
     * Field _dtDtApprvlBegin
     */
    private java.util.Date _dtDtApprvlBegin;

    /**
     * Field _dtDtApprvlEnd
     */
    private java.util.Date _dtDtApprvlEnd;

    /**
     * Field _szTxtStatusRsnComments
     */
    private java.lang.String _szTxtStatusRsnComments;

    /**
     * Field _dtFosterParentManual
     */
    private java.util.Date _dtFosterParentManual;

    /**
     * Field _dtFosterParentBill
     */
    private java.util.Date _dtFosterParentBill;

    /**
     * Field _bIndHoldPlacements
     */
    private java.lang.String _bIndHoldPlacements;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD38SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIsApprovalMode()
    {
        this._has_isApprovalMode= false;
    } //-- void deleteIsApprovalMode() 

    /**
     */
    public void deleteSNbrRsrcOpenSlots()
    {
        this._has_sNbrRsrcOpenSlots= false;
    } //-- void deleteSNbrRsrcOpenSlots() 

    /**
     */
    public void deleteUNbrRsrcFMAgeMax()
    {
        this._has_uNbrRsrcFMAgeMax= false;
    } //-- void deleteUNbrRsrcFMAgeMax() 

    /**
     */
    public void deleteUNbrRsrcFMAgeMin()
    {
        this._has_uNbrRsrcFMAgeMin= false;
    } //-- void deleteUNbrRsrcFMAgeMin() 

    /**
     */
    public void deleteUNbrRsrcFacilCapacity()
    {
        this._has_uNbrRsrcFacilCapacity= false;
    } //-- void deleteUNbrRsrcFacilCapacity() 

    /**
     */
    public void deleteUNbrRsrcMlAgeMax()
    {
        this._has_uNbrRsrcMlAgeMax= false;
    } //-- void deleteUNbrRsrcMlAgeMax() 

    /**
     */
    public void deleteUNbrRsrcMlAgeMin()
    {
        this._has_uNbrRsrcMlAgeMin= false;
    } //-- void deleteUNbrRsrcMlAgeMin() 

    /**
     */
    public void deleteUlIdCntrctWkr()
    {
        this._has_ulIdCntrctWkr= false;
    } //-- void deleteUlIdCntrctWkr() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

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
     * Returns the value of field 'bIndHoldPlacements'.
     * 
     * @return the value of field 'BIndHoldPlacements'.
     */
    public java.lang.String getBIndHoldPlacements()
    {
        return this._bIndHoldPlacements;
    } //-- java.lang.String getBIndHoldPlacements() 

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
     * Returns the value of field 'cCdFlocStatus1'.
     * 
     * @return the value of field 'CCdFlocStatus1'.
     */
    public java.lang.String getCCdFlocStatus1()
    {
        return this._cCdFlocStatus1;
    } //-- java.lang.String getCCdFlocStatus1() 

    /**
     * Returns the value of field 'cCdFlocStatus2'.
     * 
     * @return the value of field 'CCdFlocStatus2'.
     */
    public java.lang.String getCCdFlocStatus2()
    {
        return this._cCdFlocStatus2;
    } //-- java.lang.String getCCdFlocStatus2() 

    /**
     * Returns the value of field 'cCdFlocStatus3'.
     * 
     * @return the value of field 'CCdFlocStatus3'.
     */
    public java.lang.String getCCdFlocStatus3()
    {
        return this._cCdFlocStatus3;
    } //-- java.lang.String getCCdFlocStatus3() 

    /**
     * Returns the value of field 'cCdFlocStatus4'.
     * 
     * @return the value of field 'CCdFlocStatus4'.
     */
    public java.lang.String getCCdFlocStatus4()
    {
        return this._cCdFlocStatus4;
    } //-- java.lang.String getCCdFlocStatus4() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType1'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType1'.
     */
    public java.lang.String getCCdRsrcFaHomeType1()
    {
        return this._cCdRsrcFaHomeType1;
    } //-- java.lang.String getCCdRsrcFaHomeType1() 

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
     * Returns the value of field 'cIndRshsWriteHist'.
     * 
     * @return the value of field 'CIndRshsWriteHist'.
     */
    public java.lang.String getCIndRshsWriteHist()
    {
        return this._cIndRshsWriteHist;
    } //-- java.lang.String getCIndRshsWriteHist() 

    /**
     * Returns the value of field 'cSysIndAppStatusChange'.
     * 
     * @return the value of field 'CSysIndAppStatusChange'.
     */
    public java.lang.String getCSysIndAppStatusChange()
    {
        return this._cSysIndAppStatusChange;
    } //-- java.lang.String getCSysIndAppStatusChange() 

    /**
     * Returns the value of field 'cSysIndCategoryChange'.
     * 
     * @return the value of field 'CSysIndCategoryChange'.
     */
    public java.lang.String getCSysIndCategoryChange()
    {
        return this._cSysIndCategoryChange;
    } //-- java.lang.String getCSysIndCategoryChange() 

    /**
     * Returns the value of field 'cSysIndFeAgeChange'.
     * 
     * @return the value of field 'CSysIndFeAgeChange'.
     */
    public java.lang.String getCSysIndFeAgeChange()
    {
        return this._cSysIndFeAgeChange;
    } //-- java.lang.String getCSysIndFeAgeChange() 

    /**
     * Returns the value of field 'cSysIndFosterTypeChange'.
     * 
     * @return the value of field 'CSysIndFosterTypeChange'.
     */
    public java.lang.String getCSysIndFosterTypeChange()
    {
        return this._cSysIndFosterTypeChange;
    } //-- java.lang.String getCSysIndFosterTypeChange() 

    /**
     * Returns the value of field 'cSysIndLocChange'.
     * 
     * @return the value of field 'CSysIndLocChange'.
     */
    public java.lang.String getCSysIndLocChange()
    {
        return this._cSysIndLocChange;
    } //-- java.lang.String getCSysIndLocChange() 

    /**
     * Returns the value of field 'cSysIndMaAgeChange'.
     * 
     * @return the value of field 'CSysIndMaAgeChange'.
     */
    public java.lang.String getCSysIndMaAgeChange()
    {
        return this._cSysIndMaAgeChange;
    } //-- java.lang.String getCSysIndMaAgeChange() 

    /**
     * Returns the value of field 'dtDtApprvlBegin'.
     * 
     * @return the value of field 'DtDtApprvlBegin'.
     */
    public java.util.Date getDtDtApprvlBegin()
    {
        return this._dtDtApprvlBegin;
    } //-- java.util.Date getDtDtApprvlBegin() 

    /**
     * Returns the value of field 'dtDtApprvlEnd'.
     * 
     * @return the value of field 'DtDtApprvlEnd'.
     */
    public java.util.Date getDtDtApprvlEnd()
    {
        return this._dtDtApprvlEnd;
    } //-- java.util.Date getDtDtApprvlEnd() 

    /**
     * Returns the value of field 'dtFosterParentBill'.
     * 
     * @return the value of field 'DtFosterParentBill'.
     */
    public java.util.Date getDtFosterParentBill()
    {
        return this._dtFosterParentBill;
    } //-- java.util.Date getDtFosterParentBill() 

    /**
     * Returns the value of field 'dtFosterParentManual'.
     * 
     * @return the value of field 'DtFosterParentManual'.
     */
    public java.util.Date getDtFosterParentManual()
    {
        return this._dtFosterParentManual;
    } //-- java.util.Date getDtFosterParentManual() 

    /**
     * Returns the value of field 'isApprovalMode'.
     * 
     * @return the value of field 'IsApprovalMode'.
     */
    public boolean getIsApprovalMode()
    {
        return this._isApprovalMode;
    } //-- boolean getIsApprovalMode() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN01UIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY getROWCCMN01UIG00_ARRAY()
    {
        return this._ROWCCMN01UIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY getROWCCMN01UIG00_ARRAY() 

    /**
     * Returns the value of field 'sNbrRsrcOpenSlots'.
     * 
     * @return the value of field 'SNbrRsrcOpenSlots'.
     */
    public int getSNbrRsrcOpenSlots()
    {
        return this._sNbrRsrcOpenSlots;
    } //-- int getSNbrRsrcOpenSlots() 

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
     * Returns the value of field 'szCdRsrcCategory'.
     * 
     * @return the value of field 'SzCdRsrcCategory'.
     */
    public java.lang.String getSzCdRsrcCategory()
    {
        return this._szCdRsrcCategory;
    } //-- java.lang.String getSzCdRsrcCategory() 

    /**
     * Returns the value of field 'szCdRsrcClosureRsn'.
     * 
     * @return the value of field 'SzCdRsrcClosureRsn'.
     */
    public java.lang.String getSzCdRsrcClosureRsn()
    {
        return this._szCdRsrcClosureRsn;
    } //-- java.lang.String getSzCdRsrcClosureRsn() 

    /**
     * Returns the value of field 'szCdRsrcCnty'.
     * 
     * @return the value of field 'SzCdRsrcCnty'.
     */
    public java.lang.String getSzCdRsrcCnty()
    {
        return this._szCdRsrcCnty;
    } //-- java.lang.String getSzCdRsrcCnty() 

    /**
     * Returns the value of field 'szCdRsrcFaHomeStatus'.
     * 
     * @return the value of field 'SzCdRsrcFaHomeStatus'.
     */
    public java.lang.String getSzCdRsrcFaHomeStatus()
    {
        return this._szCdRsrcFaHomeStatus;
    } //-- java.lang.String getSzCdRsrcFaHomeStatus() 

    /**
     * Returns the value of field 'szCdRsrcInvolClosure'.
     * 
     * @return the value of field 'SzCdRsrcInvolClosure'.
     */
    public java.lang.String getSzCdRsrcInvolClosure()
    {
        return this._szCdRsrcInvolClosure;
    } //-- java.lang.String getSzCdRsrcInvolClosure() 

    /**
     * Returns the value of field 'szCdRsrcRecmndReopen'.
     * 
     * @return the value of field 'SzCdRsrcRecmndReopen'.
     */
    public java.lang.String getSzCdRsrcRecmndReopen()
    {
        return this._szCdRsrcRecmndReopen;
    } //-- java.lang.String getSzCdRsrcRecmndReopen() 

    /**
     * Returns the value of field 'szCdRsrcStatus'.
     * 
     * @return the value of field 'SzCdRsrcStatus'.
     */
    public java.lang.String getSzCdRsrcStatus()
    {
        return this._szCdRsrcStatus;
    } //-- java.lang.String getSzCdRsrcStatus() 

    /**
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

    /**
     * Returns the value of field 'szNmRsrcLastUpdate'.
     * 
     * @return the value of field 'SzNmRsrcLastUpdate'.
     */
    public java.lang.String getSzNmRsrcLastUpdate()
    {
        return this._szNmRsrcLastUpdate;
    } //-- java.lang.String getSzNmRsrcLastUpdate() 

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
     * Returns the value of field 'szTxtStatusRsnComments'.
     * 
     * @return the value of field 'SzTxtStatusRsnComments'.
     */
    public java.lang.String getSzTxtStatusRsnComments()
    {
        return this._szTxtStatusRsnComments;
    } //-- java.lang.String getSzTxtStatusRsnComments() 

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
     * Returns the value of field 'uNbrRsrcFMAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcFMAgeMax'.
     */
    public int getUNbrRsrcFMAgeMax()
    {
        return this._uNbrRsrcFMAgeMax;
    } //-- int getUNbrRsrcFMAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcFMAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcFMAgeMin'.
     */
    public int getUNbrRsrcFMAgeMin()
    {
        return this._uNbrRsrcFMAgeMin;
    } //-- int getUNbrRsrcFMAgeMin() 

    /**
     * Returns the value of field 'uNbrRsrcFacilCapacity'.
     * 
     * @return the value of field 'UNbrRsrcFacilCapacity'.
     */
    public int getUNbrRsrcFacilCapacity()
    {
        return this._uNbrRsrcFacilCapacity;
    } //-- int getUNbrRsrcFacilCapacity() 

    /**
     * Returns the value of field 'uNbrRsrcMlAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcMlAgeMax'.
     */
    public int getUNbrRsrcMlAgeMax()
    {
        return this._uNbrRsrcMlAgeMax;
    } //-- int getUNbrRsrcMlAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcMlAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcMlAgeMin'.
     */
    public int getUNbrRsrcMlAgeMin()
    {
        return this._uNbrRsrcMlAgeMin;
    } //-- int getUNbrRsrcMlAgeMin() 

    /**
     * Returns the value of field 'ulIdCntrctWkr'.
     * 
     * @return the value of field 'UlIdCntrctWkr'.
     */
    public int getUlIdCntrctWkr()
    {
        return this._ulIdCntrctWkr;
    } //-- int getUlIdCntrctWkr() 

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
     * Method hasIsApprovalMode
     * 
     * 
     * 
     * @return true if at least one IsApprovalMode has been added
     */
    public boolean hasIsApprovalMode()
    {
        return this._has_isApprovalMode;
    } //-- boolean hasIsApprovalMode() 

    /**
     * Method hasSNbrRsrcOpenSlots
     * 
     * 
     * 
     * @return true if at least one SNbrRsrcOpenSlots has been added
     */
    public boolean hasSNbrRsrcOpenSlots()
    {
        return this._has_sNbrRsrcOpenSlots;
    } //-- boolean hasSNbrRsrcOpenSlots() 

    /**
     * Method hasUNbrRsrcFMAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFMAgeMax has been added
     */
    public boolean hasUNbrRsrcFMAgeMax()
    {
        return this._has_uNbrRsrcFMAgeMax;
    } //-- boolean hasUNbrRsrcFMAgeMax() 

    /**
     * Method hasUNbrRsrcFMAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFMAgeMin has been added
     */
    public boolean hasUNbrRsrcFMAgeMin()
    {
        return this._has_uNbrRsrcFMAgeMin;
    } //-- boolean hasUNbrRsrcFMAgeMin() 

    /**
     * Method hasUNbrRsrcFacilCapacity
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFacilCapacity has been
     * added
     */
    public boolean hasUNbrRsrcFacilCapacity()
    {
        return this._has_uNbrRsrcFacilCapacity;
    } //-- boolean hasUNbrRsrcFacilCapacity() 

    /**
     * Method hasUNbrRsrcMlAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcMlAgeMax has been added
     */
    public boolean hasUNbrRsrcMlAgeMax()
    {
        return this._has_uNbrRsrcMlAgeMax;
    } //-- boolean hasUNbrRsrcMlAgeMax() 

    /**
     * Method hasUNbrRsrcMlAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcMlAgeMin has been added
     */
    public boolean hasUNbrRsrcMlAgeMin()
    {
        return this._has_uNbrRsrcMlAgeMin;
    } //-- boolean hasUNbrRsrcMlAgeMin() 

    /**
     * Method hasUlIdCntrctWkr
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctWkr has been added
     */
    public boolean hasUlIdCntrctWkr()
    {
        return this._has_ulIdCntrctWkr;
    } //-- boolean hasUlIdCntrctWkr() 

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
     * Returns the value of field 'isApprovalMode'.
     * 
     * @return the value of field 'IsApprovalMode'.
     */
    public boolean isIsApprovalMode()
    {
        return this._isApprovalMode;
    } //-- boolean isIsApprovalMode() 

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
     * Sets the value of field 'bIndHoldPlacements'.
     * 
     * @param bIndHoldPlacements the value of field
     * 'bIndHoldPlacements'.
     */
    public void setBIndHoldPlacements(java.lang.String bIndHoldPlacements)
    {
        this._bIndHoldPlacements = bIndHoldPlacements;
    } //-- void setBIndHoldPlacements(java.lang.String) 

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
     * Sets the value of field 'cCdFlocStatus1'.
     * 
     * @param cCdFlocStatus1 the value of field 'cCdFlocStatus1'.
     */
    public void setCCdFlocStatus1(java.lang.String cCdFlocStatus1)
    {
        this._cCdFlocStatus1 = cCdFlocStatus1;
    } //-- void setCCdFlocStatus1(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus2'.
     * 
     * @param cCdFlocStatus2 the value of field 'cCdFlocStatus2'.
     */
    public void setCCdFlocStatus2(java.lang.String cCdFlocStatus2)
    {
        this._cCdFlocStatus2 = cCdFlocStatus2;
    } //-- void setCCdFlocStatus2(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus3'.
     * 
     * @param cCdFlocStatus3 the value of field 'cCdFlocStatus3'.
     */
    public void setCCdFlocStatus3(java.lang.String cCdFlocStatus3)
    {
        this._cCdFlocStatus3 = cCdFlocStatus3;
    } //-- void setCCdFlocStatus3(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus4'.
     * 
     * @param cCdFlocStatus4 the value of field 'cCdFlocStatus4'.
     */
    public void setCCdFlocStatus4(java.lang.String cCdFlocStatus4)
    {
        this._cCdFlocStatus4 = cCdFlocStatus4;
    } //-- void setCCdFlocStatus4(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType1'.
     * 
     * @param cCdRsrcFaHomeType1 the value of field
     * 'cCdRsrcFaHomeType1'.
     */
    public void setCCdRsrcFaHomeType1(java.lang.String cCdRsrcFaHomeType1)
    {
        this._cCdRsrcFaHomeType1 = cCdRsrcFaHomeType1;
    } //-- void setCCdRsrcFaHomeType1(java.lang.String) 

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
     * Sets the value of field 'cSysIndAppStatusChange'.
     * 
     * @param cSysIndAppStatusChange the value of field
     * 'cSysIndAppStatusChange'.
     */
    public void setCSysIndAppStatusChange(java.lang.String cSysIndAppStatusChange)
    {
        this._cSysIndAppStatusChange = cSysIndAppStatusChange;
    } //-- void setCSysIndAppStatusChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndCategoryChange'.
     * 
     * @param cSysIndCategoryChange the value of field
     * 'cSysIndCategoryChange'.
     */
    public void setCSysIndCategoryChange(java.lang.String cSysIndCategoryChange)
    {
        this._cSysIndCategoryChange = cSysIndCategoryChange;
    } //-- void setCSysIndCategoryChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndFeAgeChange'.
     * 
     * @param cSysIndFeAgeChange the value of field
     * 'cSysIndFeAgeChange'.
     */
    public void setCSysIndFeAgeChange(java.lang.String cSysIndFeAgeChange)
    {
        this._cSysIndFeAgeChange = cSysIndFeAgeChange;
    } //-- void setCSysIndFeAgeChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndFosterTypeChange'.
     * 
     * @param cSysIndFosterTypeChange the value of field
     * 'cSysIndFosterTypeChange'.
     */
    public void setCSysIndFosterTypeChange(java.lang.String cSysIndFosterTypeChange)
    {
        this._cSysIndFosterTypeChange = cSysIndFosterTypeChange;
    } //-- void setCSysIndFosterTypeChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndLocChange'.
     * 
     * @param cSysIndLocChange the value of field 'cSysIndLocChange'
     */
    public void setCSysIndLocChange(java.lang.String cSysIndLocChange)
    {
        this._cSysIndLocChange = cSysIndLocChange;
    } //-- void setCSysIndLocChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndMaAgeChange'.
     * 
     * @param cSysIndMaAgeChange the value of field
     * 'cSysIndMaAgeChange'.
     */
    public void setCSysIndMaAgeChange(java.lang.String cSysIndMaAgeChange)
    {
        this._cSysIndMaAgeChange = cSysIndMaAgeChange;
    } //-- void setCSysIndMaAgeChange(java.lang.String) 

    /**
     * Sets the value of field 'dtDtApprvlBegin'.
     * 
     * @param dtDtApprvlBegin the value of field 'dtDtApprvlBegin'.
     */
    public void setDtDtApprvlBegin(java.util.Date dtDtApprvlBegin)
    {
        this._dtDtApprvlBegin = dtDtApprvlBegin;
    } //-- void setDtDtApprvlBegin(java.util.Date) 

    /**
     * Sets the value of field 'dtDtApprvlEnd'.
     * 
     * @param dtDtApprvlEnd the value of field 'dtDtApprvlEnd'.
     */
    public void setDtDtApprvlEnd(java.util.Date dtDtApprvlEnd)
    {
        this._dtDtApprvlEnd = dtDtApprvlEnd;
    } //-- void setDtDtApprvlEnd(java.util.Date) 

    /**
     * Sets the value of field 'dtFosterParentBill'.
     * 
     * @param dtFosterParentBill the value of field
     * 'dtFosterParentBill'.
     */
    public void setDtFosterParentBill(java.util.Date dtFosterParentBill)
    {
        this._dtFosterParentBill = dtFosterParentBill;
    } //-- void setDtFosterParentBill(java.util.Date) 

    /**
     * Sets the value of field 'dtFosterParentManual'.
     * 
     * @param dtFosterParentManual the value of field
     * 'dtFosterParentManual'.
     */
    public void setDtFosterParentManual(java.util.Date dtFosterParentManual)
    {
        this._dtFosterParentManual = dtFosterParentManual;
    } //-- void setDtFosterParentManual(java.util.Date) 

    /**
     * Sets the value of field 'isApprovalMode'.
     * 
     * @param isApprovalMode the value of field 'isApprovalMode'.
     */
    public void setIsApprovalMode(boolean isApprovalMode)
    {
        this._isApprovalMode = isApprovalMode;
        this._has_isApprovalMode = true;
    } //-- void setIsApprovalMode(boolean) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00_ARRAY'.
     * 
     * @param ROWCCMN01UIG00_ARRAY the value of field
     * 'ROWCCMN01UIG00_ARRAY'.
     */
    public void setROWCCMN01UIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY ROWCCMN01UIG00_ARRAY)
    {
        this._ROWCCMN01UIG00_ARRAY = ROWCCMN01UIG00_ARRAY;
    } //-- void setROWCCMN01UIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY) 

    /**
     * Sets the value of field 'sNbrRsrcOpenSlots'.
     * 
     * @param sNbrRsrcOpenSlots the value of field
     * 'sNbrRsrcOpenSlots'.
     */
    public void setSNbrRsrcOpenSlots(int sNbrRsrcOpenSlots)
    {
        this._sNbrRsrcOpenSlots = sNbrRsrcOpenSlots;
        this._has_sNbrRsrcOpenSlots = true;
    } //-- void setSNbrRsrcOpenSlots(int) 

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
     * Sets the value of field 'szCdRsrcCategory'.
     * 
     * @param szCdRsrcCategory the value of field 'szCdRsrcCategory'
     */
    public void setSzCdRsrcCategory(java.lang.String szCdRsrcCategory)
    {
        this._szCdRsrcCategory = szCdRsrcCategory;
    } //-- void setSzCdRsrcCategory(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcClosureRsn'.
     * 
     * @param szCdRsrcClosureRsn the value of field
     * 'szCdRsrcClosureRsn'.
     */
    public void setSzCdRsrcClosureRsn(java.lang.String szCdRsrcClosureRsn)
    {
        this._szCdRsrcClosureRsn = szCdRsrcClosureRsn;
    } //-- void setSzCdRsrcClosureRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcCnty'.
     * 
     * @param szCdRsrcCnty the value of field 'szCdRsrcCnty'.
     */
    public void setSzCdRsrcCnty(java.lang.String szCdRsrcCnty)
    {
        this._szCdRsrcCnty = szCdRsrcCnty;
    } //-- void setSzCdRsrcCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcFaHomeStatus'.
     * 
     * @param szCdRsrcFaHomeStatus the value of field
     * 'szCdRsrcFaHomeStatus'.
     */
    public void setSzCdRsrcFaHomeStatus(java.lang.String szCdRsrcFaHomeStatus)
    {
        this._szCdRsrcFaHomeStatus = szCdRsrcFaHomeStatus;
    } //-- void setSzCdRsrcFaHomeStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcInvolClosure'.
     * 
     * @param szCdRsrcInvolClosure the value of field
     * 'szCdRsrcInvolClosure'.
     */
    public void setSzCdRsrcInvolClosure(java.lang.String szCdRsrcInvolClosure)
    {
        this._szCdRsrcInvolClosure = szCdRsrcInvolClosure;
    } //-- void setSzCdRsrcInvolClosure(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcRecmndReopen'.
     * 
     * @param szCdRsrcRecmndReopen the value of field
     * 'szCdRsrcRecmndReopen'.
     */
    public void setSzCdRsrcRecmndReopen(java.lang.String szCdRsrcRecmndReopen)
    {
        this._szCdRsrcRecmndReopen = szCdRsrcRecmndReopen;
    } //-- void setSzCdRsrcRecmndReopen(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcStatus'.
     * 
     * @param szCdRsrcStatus the value of field 'szCdRsrcStatus'.
     */
    public void setSzCdRsrcStatus(java.lang.String szCdRsrcStatus)
    {
        this._szCdRsrcStatus = szCdRsrcStatus;
    } //-- void setSzCdRsrcStatus(java.lang.String) 

    /**
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

    /**
     * Sets the value of field 'szNmRsrcLastUpdate'.
     * 
     * @param szNmRsrcLastUpdate the value of field
     * 'szNmRsrcLastUpdate'.
     */
    public void setSzNmRsrcLastUpdate(java.lang.String szNmRsrcLastUpdate)
    {
        this._szNmRsrcLastUpdate = szNmRsrcLastUpdate;
    } //-- void setSzNmRsrcLastUpdate(java.lang.String) 

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
     * Sets the value of field 'szTxtStatusRsnComments'.
     * 
     * @param szTxtStatusRsnComments the value of field
     * 'szTxtStatusRsnComments'.
     */
    public void setSzTxtStatusRsnComments(java.lang.String szTxtStatusRsnComments)
    {
        this._szTxtStatusRsnComments = szTxtStatusRsnComments;
    } //-- void setSzTxtStatusRsnComments(java.lang.String) 

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
     * Sets the value of field 'uNbrRsrcFMAgeMax'.
     * 
     * @param uNbrRsrcFMAgeMax the value of field 'uNbrRsrcFMAgeMax'
     */
    public void setUNbrRsrcFMAgeMax(int uNbrRsrcFMAgeMax)
    {
        this._uNbrRsrcFMAgeMax = uNbrRsrcFMAgeMax;
        this._has_uNbrRsrcFMAgeMax = true;
    } //-- void setUNbrRsrcFMAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcFMAgeMin'.
     * 
     * @param uNbrRsrcFMAgeMin the value of field 'uNbrRsrcFMAgeMin'
     */
    public void setUNbrRsrcFMAgeMin(int uNbrRsrcFMAgeMin)
    {
        this._uNbrRsrcFMAgeMin = uNbrRsrcFMAgeMin;
        this._has_uNbrRsrcFMAgeMin = true;
    } //-- void setUNbrRsrcFMAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRsrcFacilCapacity'.
     * 
     * @param uNbrRsrcFacilCapacity the value of field
     * 'uNbrRsrcFacilCapacity'.
     */
    public void setUNbrRsrcFacilCapacity(int uNbrRsrcFacilCapacity)
    {
        this._uNbrRsrcFacilCapacity = uNbrRsrcFacilCapacity;
        this._has_uNbrRsrcFacilCapacity = true;
    } //-- void setUNbrRsrcFacilCapacity(int) 

    /**
     * Sets the value of field 'uNbrRsrcMlAgeMax'.
     * 
     * @param uNbrRsrcMlAgeMax the value of field 'uNbrRsrcMlAgeMax'
     */
    public void setUNbrRsrcMlAgeMax(int uNbrRsrcMlAgeMax)
    {
        this._uNbrRsrcMlAgeMax = uNbrRsrcMlAgeMax;
        this._has_uNbrRsrcMlAgeMax = true;
    } //-- void setUNbrRsrcMlAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcMlAgeMin'.
     * 
     * @param uNbrRsrcMlAgeMin the value of field 'uNbrRsrcMlAgeMin'
     */
    public void setUNbrRsrcMlAgeMin(int uNbrRsrcMlAgeMin)
    {
        this._uNbrRsrcMlAgeMin = uNbrRsrcMlAgeMin;
        this._has_uNbrRsrcMlAgeMin = true;
    } //-- void setUNbrRsrcMlAgeMin(int) 

    /**
     * Sets the value of field 'ulIdCntrctWkr'.
     * 
     * @param ulIdCntrctWkr the value of field 'ulIdCntrctWkr'.
     */
    public void setUlIdCntrctWkr(int ulIdCntrctWkr)
    {
        this._ulIdCntrctWkr = ulIdCntrctWkr;
        this._has_ulIdCntrctWkr = true;
    } //-- void setUlIdCntrctWkr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI unmarshal(java.io.Reader) 

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
