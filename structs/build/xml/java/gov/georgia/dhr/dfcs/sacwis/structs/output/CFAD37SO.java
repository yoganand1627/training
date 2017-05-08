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
 * Class CFAD37SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD37SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdRsrcMaritalStatus
     */
    private java.lang.String _szCdRsrcMaritalStatus;

    /**
     * Field _dtDtRsrcMarriage
     */
    private org.exolab.castor.types.Date _dtDtRsrcMarriage;

    /**
     * Field _szCdRsrcCategory
     */
    private java.lang.String _szCdRsrcCategory;

    /**
     * Field _szCdRsrcFaHomeStatus
     */
    private java.lang.String _szCdRsrcFaHomeStatus;

    /**
     * Field _bIndRsrcNonPrs
     */
    private java.lang.String _bIndRsrcNonPrs;

    /**
     * Field _uNbrRsrcMlAgeMin
     */
    private int _uNbrRsrcMlAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMin
     */
    private boolean _has_uNbrRsrcMlAgeMin;

    /**
     * Field _uNbrRsrcFMAgeMax
     */
    private int _uNbrRsrcFMAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMax
     */
    private boolean _has_uNbrRsrcFMAgeMax;

    /**
     * Field _uNbrRsrcFMAgeMin
     */
    private int _uNbrRsrcFMAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMin
     */
    private boolean _has_uNbrRsrcFMAgeMin;

    /**
     * Field _uNbrRsrcFacilCapacity
     */
    private int _uNbrRsrcFacilCapacity;

    /**
     * keeps track of state for field: _uNbrRsrcFacilCapacity
     */
    private boolean _has_uNbrRsrcFacilCapacity;

    /**
     * Field _uNbrRsrcMlAgeMax
     */
    private int _uNbrRsrcMlAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMax
     */
    private boolean _has_uNbrRsrcMlAgeMax;

    /**
     * Field _sNbrRsrcOpenSlots
     */
    private int _sNbrRsrcOpenSlots;

    /**
     * keeps track of state for field: _sNbrRsrcOpenSlots
     */
    private boolean _has_sNbrRsrcOpenSlots;

    /**
     * Field _ulSysNbrGenericCntr
     */
    private int _ulSysNbrGenericCntr;

    /**
     * keeps track of state for field: _ulSysNbrGenericCntr
     */
    private boolean _has_ulSysNbrGenericCntr;

    /**
     * Field _szCdRsrcStatus
     */
    private java.lang.String _szCdRsrcStatus;

    /**
     * Field _cCdRsrcFaHomeType1_CFAD37SO
     */
    private java.lang.String _cCdRsrcFaHomeType1_CFAD37SO;

    /**
     * Field _cCdRsrcFaHomeType1
     */
    private java.lang.String _cCdRsrcFaHomeType1;

    /**
     * Field _cCdRsrcFaHomeType2
     */
    private java.lang.String _cCdRsrcFaHomeType2;

    /**
     * Field _cCdRsrcFaHomeType3
     */
    private java.lang.String _cCdRsrcFaHomeType3;

    /**
     * Field _cCdRsrcFaHomeType4
     */
    private java.lang.String _cCdRsrcFaHomeType4;

    /**
     * Field _cCdRsrcFaHomeType5
     */
    private java.lang.String _cCdRsrcFaHomeType5;

    /**
     * Field _cCdRsrcFaHomeType6
     */
    private java.lang.String _cCdRsrcFaHomeType6;

    /**
     * Field _uNbrRsrcIntMaAgeMin
     */
    private int _uNbrRsrcIntMaAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcIntMaAgeMin
     */
    private boolean _has_uNbrRsrcIntMaAgeMin;

    /**
     * Field _uNbrRsrcIntMaAgeMax
     */
    private int _uNbrRsrcIntMaAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcIntMaAgeMax
     */
    private boolean _has_uNbrRsrcIntMaAgeMax;

    /**
     * Field _uNbrRsrcIntFeAgeMin
     */
    private int _uNbrRsrcIntFeAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcIntFeAgeMin
     */
    private boolean _has_uNbrRsrcIntFeAgeMin;

    /**
     * Field _uNbrRsrcIntFeAgeMax
     */
    private int _uNbrRsrcIntFeAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcIntFeAgeMax
     */
    private boolean _has_uNbrRsrcIntFeAgeMax;

    /**
     * Field _szNbrRsrcVid
     */
    private java.lang.String _szNbrRsrcVid;

    /**
     * Field _szCdRsrcCnty
     */
    private java.lang.String _szCdRsrcCnty;

    /**
     * Field _bIndBLOBExistsInDatabase
     */
    private java.lang.String _bIndBLOBExistsInDatabase;

    /**
     * Field _bIndFosterParent
     */
    private java.lang.String _bIndFosterParent;

    /**
     * Field _bIndAdoptiveParent
     */
    private java.lang.String _bIndAdoptiveParent;

    /**
     * Field _bIndFostAdoptParent
     */
    private java.lang.String _bIndFostAdoptParent;

    /**
     * Field _bIndMarriedFP
     */
    private java.lang.String _bIndMarriedFP;

    /**
     * Field _bIndMarriedAP
     */
    private java.lang.String _bIndMarriedAP;

    /**
     * Field _bIndMarriedAorF
     */
    private java.lang.String _bIndMarriedAorF;

    /**
     * Field _szTxtNdfcsCertEntity
     */
    private java.lang.String _szTxtNdfcsCertEntity;

    /**
     * Field _szCdAdExchangeStat
     */
    private java.lang.String _szCdAdExchangeStat;

    /**
     * Field _bIndWaiver
     */
    private java.lang.String _bIndWaiver;

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
     * Field _bIndHomeIveReimbursable
     */
    private java.lang.String _bIndHomeIveReimbursable;

    /**
     * Field _bIndHoldPlacements
     */
    private java.lang.String _bIndHoldPlacements;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD37SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO()


      //-----------/
     //- Methods -/
    //-----------/

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
    public void deleteUNbrRsrcIntFeAgeMax()
    {
        this._has_uNbrRsrcIntFeAgeMax= false;
    } //-- void deleteUNbrRsrcIntFeAgeMax() 

    /**
     */
    public void deleteUNbrRsrcIntFeAgeMin()
    {
        this._has_uNbrRsrcIntFeAgeMin= false;
    } //-- void deleteUNbrRsrcIntFeAgeMin() 

    /**
     */
    public void deleteUNbrRsrcIntMaAgeMax()
    {
        this._has_uNbrRsrcIntMaAgeMax= false;
    } //-- void deleteUNbrRsrcIntMaAgeMax() 

    /**
     */
    public void deleteUNbrRsrcIntMaAgeMin()
    {
        this._has_uNbrRsrcIntMaAgeMin= false;
    } //-- void deleteUNbrRsrcIntMaAgeMin() 

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
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlSysNbrGenericCntr()
    {
        this._has_ulSysNbrGenericCntr= false;
    } //-- void deleteUlSysNbrGenericCntr() 

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
     * Returns the value of field 'bIndAdoptiveParent'.
     * 
     * @return the value of field 'BIndAdoptiveParent'.
     */
    public java.lang.String getBIndAdoptiveParent()
    {
        return this._bIndAdoptiveParent;
    } //-- java.lang.String getBIndAdoptiveParent() 

    /**
     * Returns the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @return the value of field 'BIndBLOBExistsInDatabase'.
     */
    public java.lang.String getBIndBLOBExistsInDatabase()
    {
        return this._bIndBLOBExistsInDatabase;
    } //-- java.lang.String getBIndBLOBExistsInDatabase() 

    /**
     * Returns the value of field 'bIndFostAdoptParent'.
     * 
     * @return the value of field 'BIndFostAdoptParent'.
     */
    public java.lang.String getBIndFostAdoptParent()
    {
        return this._bIndFostAdoptParent;
    } //-- java.lang.String getBIndFostAdoptParent() 

    /**
     * Returns the value of field 'bIndFosterParent'.
     * 
     * @return the value of field 'BIndFosterParent'.
     */
    public java.lang.String getBIndFosterParent()
    {
        return this._bIndFosterParent;
    } //-- java.lang.String getBIndFosterParent() 

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
     * Returns the value of field 'bIndHomeIveReimbursable'.
     * 
     * @return the value of field 'BIndHomeIveReimbursable'.
     */
    public java.lang.String getBIndHomeIveReimbursable()
    {
        return this._bIndHomeIveReimbursable;
    } //-- java.lang.String getBIndHomeIveReimbursable() 

    /**
     * Returns the value of field 'bIndMarriedAP'.
     * 
     * @return the value of field 'BIndMarriedAP'.
     */
    public java.lang.String getBIndMarriedAP()
    {
        return this._bIndMarriedAP;
    } //-- java.lang.String getBIndMarriedAP() 

    /**
     * Returns the value of field 'bIndMarriedAorF'.
     * 
     * @return the value of field 'BIndMarriedAorF'.
     */
    public java.lang.String getBIndMarriedAorF()
    {
        return this._bIndMarriedAorF;
    } //-- java.lang.String getBIndMarriedAorF() 

    /**
     * Returns the value of field 'bIndMarriedFP'.
     * 
     * @return the value of field 'BIndMarriedFP'.
     */
    public java.lang.String getBIndMarriedFP()
    {
        return this._bIndMarriedFP;
    } //-- java.lang.String getBIndMarriedFP() 

    /**
     * Returns the value of field 'bIndRsrcNonPrs'.
     * 
     * @return the value of field 'BIndRsrcNonPrs'.
     */
    public java.lang.String getBIndRsrcNonPrs()
    {
        return this._bIndRsrcNonPrs;
    } //-- java.lang.String getBIndRsrcNonPrs() 

    /**
     * Returns the value of field 'bIndWaiver'.
     * 
     * @return the value of field 'BIndWaiver'.
     */
    public java.lang.String getBIndWaiver()
    {
        return this._bIndWaiver;
    } //-- java.lang.String getBIndWaiver() 

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
     * Returns the value of field 'cCdRsrcFaHomeType1_CFAD37SO'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType1_CFAD37SO'.
     */
    public java.lang.String getCCdRsrcFaHomeType1_CFAD37SO()
    {
        return this._cCdRsrcFaHomeType1_CFAD37SO;
    } //-- java.lang.String getCCdRsrcFaHomeType1_CFAD37SO() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType2'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType2'.
     */
    public java.lang.String getCCdRsrcFaHomeType2()
    {
        return this._cCdRsrcFaHomeType2;
    } //-- java.lang.String getCCdRsrcFaHomeType2() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType3'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType3'.
     */
    public java.lang.String getCCdRsrcFaHomeType3()
    {
        return this._cCdRsrcFaHomeType3;
    } //-- java.lang.String getCCdRsrcFaHomeType3() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType4'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType4'.
     */
    public java.lang.String getCCdRsrcFaHomeType4()
    {
        return this._cCdRsrcFaHomeType4;
    } //-- java.lang.String getCCdRsrcFaHomeType4() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType5'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType5'.
     */
    public java.lang.String getCCdRsrcFaHomeType5()
    {
        return this._cCdRsrcFaHomeType5;
    } //-- java.lang.String getCCdRsrcFaHomeType5() 

    /**
     * Returns the value of field 'cCdRsrcFaHomeType6'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType6'.
     */
    public java.lang.String getCCdRsrcFaHomeType6()
    {
        return this._cCdRsrcFaHomeType6;
    } //-- java.lang.String getCCdRsrcFaHomeType6() 

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
     * Returns the value of field 'dtDtRsrcMarriage'.
     * 
     * @return the value of field 'DtDtRsrcMarriage'.
     */
    public org.exolab.castor.types.Date getDtDtRsrcMarriage()
    {
        return this._dtDtRsrcMarriage;
    } //-- org.exolab.castor.types.Date getDtDtRsrcMarriage() 

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
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00() 

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
     * Returns the value of field 'szCdAdExchangeStat'.
     * 
     * @return the value of field 'SzCdAdExchangeStat'.
     */
    public java.lang.String getSzCdAdExchangeStat()
    {
        return this._szCdAdExchangeStat;
    } //-- java.lang.String getSzCdAdExchangeStat() 

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
     * Returns the value of field 'szCdRsrcMaritalStatus'.
     * 
     * @return the value of field 'SzCdRsrcMaritalStatus'.
     */
    public java.lang.String getSzCdRsrcMaritalStatus()
    {
        return this._szCdRsrcMaritalStatus;
    } //-- java.lang.String getSzCdRsrcMaritalStatus() 

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
     * Returns the value of field 'szNbrRsrcVid'.
     * 
     * @return the value of field 'SzNbrRsrcVid'.
     */
    public java.lang.String getSzNbrRsrcVid()
    {
        return this._szNbrRsrcVid;
    } //-- java.lang.String getSzNbrRsrcVid() 

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
     * Returns the value of field 'uNbrRsrcIntFeAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcIntFeAgeMax'.
     */
    public int getUNbrRsrcIntFeAgeMax()
    {
        return this._uNbrRsrcIntFeAgeMax;
    } //-- int getUNbrRsrcIntFeAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcIntFeAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcIntFeAgeMin'.
     */
    public int getUNbrRsrcIntFeAgeMin()
    {
        return this._uNbrRsrcIntFeAgeMin;
    } //-- int getUNbrRsrcIntFeAgeMin() 

    /**
     * Returns the value of field 'uNbrRsrcIntMaAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcIntMaAgeMax'.
     */
    public int getUNbrRsrcIntMaAgeMax()
    {
        return this._uNbrRsrcIntMaAgeMax;
    } //-- int getUNbrRsrcIntMaAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcIntMaAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcIntMaAgeMin'.
     */
    public int getUNbrRsrcIntMaAgeMin()
    {
        return this._uNbrRsrcIntMaAgeMin;
    } //-- int getUNbrRsrcIntMaAgeMin() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulSysNbrGenericCntr'.
     * 
     * @return the value of field 'UlSysNbrGenericCntr'.
     */
    public int getUlSysNbrGenericCntr()
    {
        return this._ulSysNbrGenericCntr;
    } //-- int getUlSysNbrGenericCntr() 

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
     * Method hasUNbrRsrcIntFeAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntFeAgeMax has been
     * added
     */
    public boolean hasUNbrRsrcIntFeAgeMax()
    {
        return this._has_uNbrRsrcIntFeAgeMax;
    } //-- boolean hasUNbrRsrcIntFeAgeMax() 

    /**
     * Method hasUNbrRsrcIntFeAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntFeAgeMin has been
     * added
     */
    public boolean hasUNbrRsrcIntFeAgeMin()
    {
        return this._has_uNbrRsrcIntFeAgeMin;
    } //-- boolean hasUNbrRsrcIntFeAgeMin() 

    /**
     * Method hasUNbrRsrcIntMaAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntMaAgeMax has been
     * added
     */
    public boolean hasUNbrRsrcIntMaAgeMax()
    {
        return this._has_uNbrRsrcIntMaAgeMax;
    } //-- boolean hasUNbrRsrcIntMaAgeMax() 

    /**
     * Method hasUNbrRsrcIntMaAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntMaAgeMin has been
     * added
     */
    public boolean hasUNbrRsrcIntMaAgeMin()
    {
        return this._has_uNbrRsrcIntMaAgeMin;
    } //-- boolean hasUNbrRsrcIntMaAgeMin() 

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
     * Method hasUlSysNbrGenericCntr
     * 
     * 
     * 
     * @return true if at least one UlSysNbrGenericCntr has been
     * added
     */
    public boolean hasUlSysNbrGenericCntr()
    {
        return this._has_ulSysNbrGenericCntr;
    } //-- boolean hasUlSysNbrGenericCntr() 

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
     * Sets the value of field 'bIndAdoptiveParent'.
     * 
     * @param bIndAdoptiveParent the value of field
     * 'bIndAdoptiveParent'.
     */
    public void setBIndAdoptiveParent(java.lang.String bIndAdoptiveParent)
    {
        this._bIndAdoptiveParent = bIndAdoptiveParent;
    } //-- void setBIndAdoptiveParent(java.lang.String) 

    /**
     * Sets the value of field 'bIndBLOBExistsInDatabase'.
     * 
     * @param bIndBLOBExistsInDatabase the value of field
     * 'bIndBLOBExistsInDatabase'.
     */
    public void setBIndBLOBExistsInDatabase(java.lang.String bIndBLOBExistsInDatabase)
    {
        this._bIndBLOBExistsInDatabase = bIndBLOBExistsInDatabase;
    } //-- void setBIndBLOBExistsInDatabase(java.lang.String) 

    /**
     * Sets the value of field 'bIndFostAdoptParent'.
     * 
     * @param bIndFostAdoptParent the value of field
     * 'bIndFostAdoptParent'.
     */
    public void setBIndFostAdoptParent(java.lang.String bIndFostAdoptParent)
    {
        this._bIndFostAdoptParent = bIndFostAdoptParent;
    } //-- void setBIndFostAdoptParent(java.lang.String) 

    /**
     * Sets the value of field 'bIndFosterParent'.
     * 
     * @param bIndFosterParent the value of field 'bIndFosterParent'
     */
    public void setBIndFosterParent(java.lang.String bIndFosterParent)
    {
        this._bIndFosterParent = bIndFosterParent;
    } //-- void setBIndFosterParent(java.lang.String) 

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
     * Sets the value of field 'bIndHomeIveReimbursable'.
     * 
     * @param bIndHomeIveReimbursable the value of field
     * 'bIndHomeIveReimbursable'.
     */
    public void setBIndHomeIveReimbursable(java.lang.String bIndHomeIveReimbursable)
    {
        this._bIndHomeIveReimbursable = bIndHomeIveReimbursable;
    } //-- void setBIndHomeIveReimbursable(java.lang.String) 

    /**
     * Sets the value of field 'bIndMarriedAP'.
     * 
     * @param bIndMarriedAP the value of field 'bIndMarriedAP'.
     */
    public void setBIndMarriedAP(java.lang.String bIndMarriedAP)
    {
        this._bIndMarriedAP = bIndMarriedAP;
    } //-- void setBIndMarriedAP(java.lang.String) 

    /**
     * Sets the value of field 'bIndMarriedAorF'.
     * 
     * @param bIndMarriedAorF the value of field 'bIndMarriedAorF'.
     */
    public void setBIndMarriedAorF(java.lang.String bIndMarriedAorF)
    {
        this._bIndMarriedAorF = bIndMarriedAorF;
    } //-- void setBIndMarriedAorF(java.lang.String) 

    /**
     * Sets the value of field 'bIndMarriedFP'.
     * 
     * @param bIndMarriedFP the value of field 'bIndMarriedFP'.
     */
    public void setBIndMarriedFP(java.lang.String bIndMarriedFP)
    {
        this._bIndMarriedFP = bIndMarriedFP;
    } //-- void setBIndMarriedFP(java.lang.String) 

    /**
     * Sets the value of field 'bIndRsrcNonPrs'.
     * 
     * @param bIndRsrcNonPrs the value of field 'bIndRsrcNonPrs'.
     */
    public void setBIndRsrcNonPrs(java.lang.String bIndRsrcNonPrs)
    {
        this._bIndRsrcNonPrs = bIndRsrcNonPrs;
    } //-- void setBIndRsrcNonPrs(java.lang.String) 

    /**
     * Sets the value of field 'bIndWaiver'.
     * 
     * @param bIndWaiver the value of field 'bIndWaiver'.
     */
    public void setBIndWaiver(java.lang.String bIndWaiver)
    {
        this._bIndWaiver = bIndWaiver;
    } //-- void setBIndWaiver(java.lang.String) 

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
     * Sets the value of field 'cCdRsrcFaHomeType1_CFAD37SO'.
     * 
     * @param cCdRsrcFaHomeType1_CFAD37SO the value of field
     * 'cCdRsrcFaHomeType1_CFAD37SO'.
     */
    public void setCCdRsrcFaHomeType1_CFAD37SO(java.lang.String cCdRsrcFaHomeType1_CFAD37SO)
    {
        this._cCdRsrcFaHomeType1_CFAD37SO = cCdRsrcFaHomeType1_CFAD37SO;
    } //-- void setCCdRsrcFaHomeType1_CFAD37SO(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType2'.
     * 
     * @param cCdRsrcFaHomeType2 the value of field
     * 'cCdRsrcFaHomeType2'.
     */
    public void setCCdRsrcFaHomeType2(java.lang.String cCdRsrcFaHomeType2)
    {
        this._cCdRsrcFaHomeType2 = cCdRsrcFaHomeType2;
    } //-- void setCCdRsrcFaHomeType2(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType3'.
     * 
     * @param cCdRsrcFaHomeType3 the value of field
     * 'cCdRsrcFaHomeType3'.
     */
    public void setCCdRsrcFaHomeType3(java.lang.String cCdRsrcFaHomeType3)
    {
        this._cCdRsrcFaHomeType3 = cCdRsrcFaHomeType3;
    } //-- void setCCdRsrcFaHomeType3(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType4'.
     * 
     * @param cCdRsrcFaHomeType4 the value of field
     * 'cCdRsrcFaHomeType4'.
     */
    public void setCCdRsrcFaHomeType4(java.lang.String cCdRsrcFaHomeType4)
    {
        this._cCdRsrcFaHomeType4 = cCdRsrcFaHomeType4;
    } //-- void setCCdRsrcFaHomeType4(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType5'.
     * 
     * @param cCdRsrcFaHomeType5 the value of field
     * 'cCdRsrcFaHomeType5'.
     */
    public void setCCdRsrcFaHomeType5(java.lang.String cCdRsrcFaHomeType5)
    {
        this._cCdRsrcFaHomeType5 = cCdRsrcFaHomeType5;
    } //-- void setCCdRsrcFaHomeType5(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcFaHomeType6'.
     * 
     * @param cCdRsrcFaHomeType6 the value of field
     * 'cCdRsrcFaHomeType6'.
     */
    public void setCCdRsrcFaHomeType6(java.lang.String cCdRsrcFaHomeType6)
    {
        this._cCdRsrcFaHomeType6 = cCdRsrcFaHomeType6;
    } //-- void setCCdRsrcFaHomeType6(java.lang.String) 

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
     * Sets the value of field 'dtDtRsrcMarriage'.
     * 
     * @param dtDtRsrcMarriage the value of field 'dtDtRsrcMarriage'
     */
    public void setDtDtRsrcMarriage(org.exolab.castor.types.Date dtDtRsrcMarriage)
    {
        this._dtDtRsrcMarriage = dtDtRsrcMarriage;
    } //-- void setDtDtRsrcMarriage(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00) 

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
     * Sets the value of field 'szCdAdExchangeStat'.
     * 
     * @param szCdAdExchangeStat the value of field
     * 'szCdAdExchangeStat'.
     */
    public void setSzCdAdExchangeStat(java.lang.String szCdAdExchangeStat)
    {
        this._szCdAdExchangeStat = szCdAdExchangeStat;
    } //-- void setSzCdAdExchangeStat(java.lang.String) 

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
     * Sets the value of field 'szCdRsrcMaritalStatus'.
     * 
     * @param szCdRsrcMaritalStatus the value of field
     * 'szCdRsrcMaritalStatus'.
     */
    public void setSzCdRsrcMaritalStatus(java.lang.String szCdRsrcMaritalStatus)
    {
        this._szCdRsrcMaritalStatus = szCdRsrcMaritalStatus;
    } //-- void setSzCdRsrcMaritalStatus(java.lang.String) 

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
     * Sets the value of field 'szNbrRsrcVid'.
     * 
     * @param szNbrRsrcVid the value of field 'szNbrRsrcVid'.
     */
    public void setSzNbrRsrcVid(java.lang.String szNbrRsrcVid)
    {
        this._szNbrRsrcVid = szNbrRsrcVid;
    } //-- void setSzNbrRsrcVid(java.lang.String) 

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
     * Sets the value of field 'uNbrRsrcIntFeAgeMax'.
     * 
     * @param uNbrRsrcIntFeAgeMax the value of field
     * 'uNbrRsrcIntFeAgeMax'.
     */
    public void setUNbrRsrcIntFeAgeMax(int uNbrRsrcIntFeAgeMax)
    {
        this._uNbrRsrcIntFeAgeMax = uNbrRsrcIntFeAgeMax;
        this._has_uNbrRsrcIntFeAgeMax = true;
    } //-- void setUNbrRsrcIntFeAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntFeAgeMin'.
     * 
     * @param uNbrRsrcIntFeAgeMin the value of field
     * 'uNbrRsrcIntFeAgeMin'.
     */
    public void setUNbrRsrcIntFeAgeMin(int uNbrRsrcIntFeAgeMin)
    {
        this._uNbrRsrcIntFeAgeMin = uNbrRsrcIntFeAgeMin;
        this._has_uNbrRsrcIntFeAgeMin = true;
    } //-- void setUNbrRsrcIntFeAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntMaAgeMax'.
     * 
     * @param uNbrRsrcIntMaAgeMax the value of field
     * 'uNbrRsrcIntMaAgeMax'.
     */
    public void setUNbrRsrcIntMaAgeMax(int uNbrRsrcIntMaAgeMax)
    {
        this._uNbrRsrcIntMaAgeMax = uNbrRsrcIntMaAgeMax;
        this._has_uNbrRsrcIntMaAgeMax = true;
    } //-- void setUNbrRsrcIntMaAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntMaAgeMin'.
     * 
     * @param uNbrRsrcIntMaAgeMin the value of field
     * 'uNbrRsrcIntMaAgeMin'.
     */
    public void setUNbrRsrcIntMaAgeMin(int uNbrRsrcIntMaAgeMin)
    {
        this._uNbrRsrcIntMaAgeMin = uNbrRsrcIntMaAgeMin;
        this._has_uNbrRsrcIntMaAgeMin = true;
    } //-- void setUNbrRsrcIntMaAgeMin(int) 

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
     * Sets the value of field 'ulSysNbrGenericCntr'.
     * 
     * @param ulSysNbrGenericCntr the value of field
     * 'ulSysNbrGenericCntr'.
     */
    public void setUlSysNbrGenericCntr(int ulSysNbrGenericCntr)
    {
        this._ulSysNbrGenericCntr = ulSysNbrGenericCntr;
        this._has_ulSysNbrGenericCntr = true;
    } //-- void setUlSysNbrGenericCntr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO unmarshal(java.io.Reader) 

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
