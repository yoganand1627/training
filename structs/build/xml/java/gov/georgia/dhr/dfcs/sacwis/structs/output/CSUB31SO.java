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
 * Class CSUB31SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB31SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdRsrcAgency
     */
    private int _ulIdRsrcAgency;

    /**
     * keeps track of state for field: _ulIdRsrcAgency
     */
    private boolean _has_ulIdRsrcAgency;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _szCdPlcmtService
     */
    private java.lang.String _szCdPlcmtService;

    /**
     * Field _szNmPlcmtAgency
     */
    private java.lang.String _szNmPlcmtAgency;

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
     * Field _cCdFlocStatus5
     */
    private java.lang.String _cCdFlocStatus5;

    /**
     * Field _cCdFlocStatus6
     */
    private java.lang.String _cCdFlocStatus6;

    /**
     * Field _cCdFlocStatus7
     */
    private java.lang.String _cCdFlocStatus7;

    /**
     * Field _cCdFlocStatus8
     */
    private java.lang.String _cCdFlocStatus8;

    /**
     * Field _cCdFlocStatus9
     */
    private java.lang.String _cCdFlocStatus9;

    /**
     * Field _cCdFlocStatus10
     */
    private java.lang.String _cCdFlocStatus10;

    /**
     * Field _cCdFlocStatus11
     */
    private java.lang.String _cCdFlocStatus11;

    /**
     * Field _cCdFlocStatus12
     */
    private java.lang.String _cCdFlocStatus12;

    /**
     * Field _cCdFlocStatus13
     */
    private java.lang.String _cCdFlocStatus13;

    /**
     * Field _cCdFlocStatus14
     */
    private java.lang.String _cCdFlocStatus14;

    /**
     * Field _cCdFlocStatus15
     */
    private java.lang.String _cCdFlocStatus15;

    /**
     * Field _szCdCnperStatus
     */
    private java.lang.String _szCdCnperStatus;

    /**
     * Field _szCdCntrctFuncType
     */
    private java.lang.String _szCdCntrctFuncType;

    /**
     * Field _szCdRsrcOwnership
     */
    private java.lang.String _szCdRsrcOwnership;

    /**
     * Field _cSysIndLocChange
     */
    private java.lang.String _cSysIndLocChange;

    /**
     * Field _cSysIndALoc
     */
    private java.lang.String _cSysIndALoc;

    /**
     * Field _cSysIndFAPoc
     */
    private java.lang.String _cSysIndFAPoc;

    /**
     * Field _cSysIndCIPoc
     */
    private java.lang.String _cSysIndCIPoc;

    /**
     * Field _cSysIndRelPoc
     */
    private java.lang.String _cSysIndRelPoc;

    /**
     * Field _cSysIndNRelPoc
     */
    private java.lang.String _cSysIndNRelPoc;

    /**
     * Field _cSysIndChildUnder12
     */
    private java.lang.String _cSysIndChildUnder12;

    /**
     * Field _cSysIndRsCapacity
     */
    private java.lang.String _cSysIndRsCapacity;

    /**
     * Field _cSysIndChildUnder2or3
     */
    private java.lang.String _cSysIndChildUnder2or3;

    /**
     * Field _bIndActiveStatus
     */
    private java.lang.String _bIndActiveStatus;

    /**
     * Field _cSysIndContractCurrent
     */
    private java.lang.String _cSysIndContractCurrent;

    /**
     * Field _bSysIndNoDataFound
     */
    private java.lang.String _bSysIndNoDataFound;

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
     * Field _cCdRsrcFaHomeType7
     */
    private java.lang.String _cCdRsrcFaHomeType7;

    /**
     * Field _cCdRsrcCapacity
     */
    private int _cCdRsrcCapacity;

    /**
     * keeps track of state for field: _cCdRsrcCapacity
     */
    private boolean _has_cCdRsrcCapacity;

    /**
     * Field _bIndChkd
     */
    private java.lang.String _bIndChkd;

    /**
     * Field _szCdRsrcCategory
     */
    private java.lang.String _szCdRsrcCategory;

    /**
     * Field _cIndRsrcEmergPlace
     */
    private java.lang.String _cIndRsrcEmergPlace;

    /**
     * Field _bSysIndHomeHist
     */
    private java.lang.String _bSysIndHomeHist;

    /**
     * Field _bSysIndNoDOBFound
     */
    private java.lang.String _bSysIndNoDOBFound;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB31SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteCCdRsrcCapacity()
    {
        this._has_cCdRsrcCapacity= false;
    } //-- void deleteCCdRsrcCapacity() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdRsrcAgency()
    {
        this._has_ulIdRsrcAgency= false;
    } //-- void deleteUlIdRsrcAgency() 

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
     * Returns the value of field 'bIndActiveStatus'.
     * 
     * @return the value of field 'BIndActiveStatus'.
     */
    public java.lang.String getBIndActiveStatus()
    {
        return this._bIndActiveStatus;
    } //-- java.lang.String getBIndActiveStatus() 

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
     * Returns the value of field 'bSysIndGeneric'.
     * 
     * @return the value of field 'BSysIndGeneric'.
     */
    public java.lang.String getBSysIndGeneric()
    {
        return this._bSysIndGeneric;
    } //-- java.lang.String getBSysIndGeneric() 

    /**
     * Returns the value of field 'bSysIndHomeHist'.
     * 
     * @return the value of field 'BSysIndHomeHist'.
     */
    public java.lang.String getBSysIndHomeHist()
    {
        return this._bSysIndHomeHist;
    } //-- java.lang.String getBSysIndHomeHist() 

    /**
     * Returns the value of field 'bSysIndNoDOBFound'.
     * 
     * @return the value of field 'BSysIndNoDOBFound'.
     */
    public java.lang.String getBSysIndNoDOBFound()
    {
        return this._bSysIndNoDOBFound;
    } //-- java.lang.String getBSysIndNoDOBFound() 

    /**
     * Returns the value of field 'bSysIndNoDataFound'.
     * 
     * @return the value of field 'BSysIndNoDataFound'.
     */
    public java.lang.String getBSysIndNoDataFound()
    {
        return this._bSysIndNoDataFound;
    } //-- java.lang.String getBSysIndNoDataFound() 

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
     * Returns the value of field 'cCdFlocStatus10'.
     * 
     * @return the value of field 'CCdFlocStatus10'.
     */
    public java.lang.String getCCdFlocStatus10()
    {
        return this._cCdFlocStatus10;
    } //-- java.lang.String getCCdFlocStatus10() 

    /**
     * Returns the value of field 'cCdFlocStatus11'.
     * 
     * @return the value of field 'CCdFlocStatus11'.
     */
    public java.lang.String getCCdFlocStatus11()
    {
        return this._cCdFlocStatus11;
    } //-- java.lang.String getCCdFlocStatus11() 

    /**
     * Returns the value of field 'cCdFlocStatus12'.
     * 
     * @return the value of field 'CCdFlocStatus12'.
     */
    public java.lang.String getCCdFlocStatus12()
    {
        return this._cCdFlocStatus12;
    } //-- java.lang.String getCCdFlocStatus12() 

    /**
     * Returns the value of field 'cCdFlocStatus13'.
     * 
     * @return the value of field 'CCdFlocStatus13'.
     */
    public java.lang.String getCCdFlocStatus13()
    {
        return this._cCdFlocStatus13;
    } //-- java.lang.String getCCdFlocStatus13() 

    /**
     * Returns the value of field 'cCdFlocStatus14'.
     * 
     * @return the value of field 'CCdFlocStatus14'.
     */
    public java.lang.String getCCdFlocStatus14()
    {
        return this._cCdFlocStatus14;
    } //-- java.lang.String getCCdFlocStatus14() 

    /**
     * Returns the value of field 'cCdFlocStatus15'.
     * 
     * @return the value of field 'CCdFlocStatus15'.
     */
    public java.lang.String getCCdFlocStatus15()
    {
        return this._cCdFlocStatus15;
    } //-- java.lang.String getCCdFlocStatus15() 

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
     * Returns the value of field 'cCdFlocStatus5'.
     * 
     * @return the value of field 'CCdFlocStatus5'.
     */
    public java.lang.String getCCdFlocStatus5()
    {
        return this._cCdFlocStatus5;
    } //-- java.lang.String getCCdFlocStatus5() 

    /**
     * Returns the value of field 'cCdFlocStatus6'.
     * 
     * @return the value of field 'CCdFlocStatus6'.
     */
    public java.lang.String getCCdFlocStatus6()
    {
        return this._cCdFlocStatus6;
    } //-- java.lang.String getCCdFlocStatus6() 

    /**
     * Returns the value of field 'cCdFlocStatus7'.
     * 
     * @return the value of field 'CCdFlocStatus7'.
     */
    public java.lang.String getCCdFlocStatus7()
    {
        return this._cCdFlocStatus7;
    } //-- java.lang.String getCCdFlocStatus7() 

    /**
     * Returns the value of field 'cCdFlocStatus8'.
     * 
     * @return the value of field 'CCdFlocStatus8'.
     */
    public java.lang.String getCCdFlocStatus8()
    {
        return this._cCdFlocStatus8;
    } //-- java.lang.String getCCdFlocStatus8() 

    /**
     * Returns the value of field 'cCdFlocStatus9'.
     * 
     * @return the value of field 'CCdFlocStatus9'.
     */
    public java.lang.String getCCdFlocStatus9()
    {
        return this._cCdFlocStatus9;
    } //-- java.lang.String getCCdFlocStatus9() 

    /**
     * Returns the value of field 'cCdRsrcCapacity'.
     * 
     * @return the value of field 'CCdRsrcCapacity'.
     */
    public int getCCdRsrcCapacity()
    {
        return this._cCdRsrcCapacity;
    } //-- int getCCdRsrcCapacity() 

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
     * Returns the value of field 'cCdRsrcFaHomeType7'.
     * 
     * @return the value of field 'CCdRsrcFaHomeType7'.
     */
    public java.lang.String getCCdRsrcFaHomeType7()
    {
        return this._cCdRsrcFaHomeType7;
    } //-- java.lang.String getCCdRsrcFaHomeType7() 

    /**
     * Returns the value of field 'cIndRsrcEmergPlace'.
     * 
     * @return the value of field 'CIndRsrcEmergPlace'.
     */
    public java.lang.String getCIndRsrcEmergPlace()
    {
        return this._cIndRsrcEmergPlace;
    } //-- java.lang.String getCIndRsrcEmergPlace() 

    /**
     * Returns the value of field 'cSysIndALoc'.
     * 
     * @return the value of field 'CSysIndALoc'.
     */
    public java.lang.String getCSysIndALoc()
    {
        return this._cSysIndALoc;
    } //-- java.lang.String getCSysIndALoc() 

    /**
     * Returns the value of field 'cSysIndCIPoc'.
     * 
     * @return the value of field 'CSysIndCIPoc'.
     */
    public java.lang.String getCSysIndCIPoc()
    {
        return this._cSysIndCIPoc;
    } //-- java.lang.String getCSysIndCIPoc() 

    /**
     * Returns the value of field 'cSysIndChildUnder12'.
     * 
     * @return the value of field 'CSysIndChildUnder12'.
     */
    public java.lang.String getCSysIndChildUnder12()
    {
        return this._cSysIndChildUnder12;
    } //-- java.lang.String getCSysIndChildUnder12() 

    /**
     * Returns the value of field 'cSysIndChildUnder2or3'.
     * 
     * @return the value of field 'CSysIndChildUnder2or3'.
     */
    public java.lang.String getCSysIndChildUnder2or3()
    {
        return this._cSysIndChildUnder2or3;
    } //-- java.lang.String getCSysIndChildUnder2or3() 

    /**
     * Returns the value of field 'cSysIndContractCurrent'.
     * 
     * @return the value of field 'CSysIndContractCurrent'.
     */
    public java.lang.String getCSysIndContractCurrent()
    {
        return this._cSysIndContractCurrent;
    } //-- java.lang.String getCSysIndContractCurrent() 

    /**
     * Returns the value of field 'cSysIndFAPoc'.
     * 
     * @return the value of field 'CSysIndFAPoc'.
     */
    public java.lang.String getCSysIndFAPoc()
    {
        return this._cSysIndFAPoc;
    } //-- java.lang.String getCSysIndFAPoc() 

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
     * Returns the value of field 'cSysIndNRelPoc'.
     * 
     * @return the value of field 'CSysIndNRelPoc'.
     */
    public java.lang.String getCSysIndNRelPoc()
    {
        return this._cSysIndNRelPoc;
    } //-- java.lang.String getCSysIndNRelPoc() 

    /**
     * Returns the value of field 'cSysIndRelPoc'.
     * 
     * @return the value of field 'CSysIndRelPoc'.
     */
    public java.lang.String getCSysIndRelPoc()
    {
        return this._cSysIndRelPoc;
    } //-- java.lang.String getCSysIndRelPoc() 

    /**
     * Returns the value of field 'cSysIndRsCapacity'.
     * 
     * @return the value of field 'CSysIndRsCapacity'.
     */
    public java.lang.String getCSysIndRsCapacity()
    {
        return this._cSysIndRsCapacity;
    } //-- java.lang.String getCSysIndRsCapacity() 

    /**
     * Returns the value of field 'szCdCnperStatus'.
     * 
     * @return the value of field 'SzCdCnperStatus'.
     */
    public java.lang.String getSzCdCnperStatus()
    {
        return this._szCdCnperStatus;
    } //-- java.lang.String getSzCdCnperStatus() 

    /**
     * Returns the value of field 'szCdCntrctFuncType'.
     * 
     * @return the value of field 'SzCdCntrctFuncType'.
     */
    public java.lang.String getSzCdCntrctFuncType()
    {
        return this._szCdCntrctFuncType;
    } //-- java.lang.String getSzCdCntrctFuncType() 

    /**
     * Returns the value of field 'szCdPlcmtService'.
     * 
     * @return the value of field 'SzCdPlcmtService'.
     */
    public java.lang.String getSzCdPlcmtService()
    {
        return this._szCdPlcmtService;
    } //-- java.lang.String getSzCdPlcmtService() 

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
     * Returns the value of field 'szCdRsrcOwnership'.
     * 
     * @return the value of field 'SzCdRsrcOwnership'.
     */
    public java.lang.String getSzCdRsrcOwnership()
    {
        return this._szCdRsrcOwnership;
    } //-- java.lang.String getSzCdRsrcOwnership() 

    /**
     * Returns the value of field 'szNmPlcmtAgency'.
     * 
     * @return the value of field 'SzNmPlcmtAgency'.
     */
    public java.lang.String getSzNmPlcmtAgency()
    {
        return this._szNmPlcmtAgency;
    } //-- java.lang.String getSzNmPlcmtAgency() 

    /**
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

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
     * Returns the value of field 'ulIdRsrcAgency'.
     * 
     * @return the value of field 'UlIdRsrcAgency'.
     */
    public int getUlIdRsrcAgency()
    {
        return this._ulIdRsrcAgency;
    } //-- int getUlIdRsrcAgency() 

    /**
     * Method hasCCdRsrcCapacity
     * 
     * 
     * 
     * @return true if at least one CCdRsrcCapacity has been added
     */
    public boolean hasCCdRsrcCapacity()
    {
        return this._has_cCdRsrcCapacity;
    } //-- boolean hasCCdRsrcCapacity() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

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
     * Method hasUlIdRsrcAgency
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcAgency has been added
     */
    public boolean hasUlIdRsrcAgency()
    {
        return this._has_ulIdRsrcAgency;
    } //-- boolean hasUlIdRsrcAgency() 

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
     * Sets the value of field 'bIndActiveStatus'.
     * 
     * @param bIndActiveStatus the value of field 'bIndActiveStatus'
     */
    public void setBIndActiveStatus(java.lang.String bIndActiveStatus)
    {
        this._bIndActiveStatus = bIndActiveStatus;
    } //-- void setBIndActiveStatus(java.lang.String) 

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
     * Sets the value of field 'bSysIndGeneric'.
     * 
     * @param bSysIndGeneric the value of field 'bSysIndGeneric'.
     */
    public void setBSysIndGeneric(java.lang.String bSysIndGeneric)
    {
        this._bSysIndGeneric = bSysIndGeneric;
    } //-- void setBSysIndGeneric(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndHomeHist'.
     * 
     * @param bSysIndHomeHist the value of field 'bSysIndHomeHist'.
     */
    public void setBSysIndHomeHist(java.lang.String bSysIndHomeHist)
    {
        this._bSysIndHomeHist = bSysIndHomeHist;
    } //-- void setBSysIndHomeHist(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndNoDOBFound'.
     * 
     * @param bSysIndNoDOBFound the value of field
     * 'bSysIndNoDOBFound'.
     */
    public void setBSysIndNoDOBFound(java.lang.String bSysIndNoDOBFound)
    {
        this._bSysIndNoDOBFound = bSysIndNoDOBFound;
    } //-- void setBSysIndNoDOBFound(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndNoDataFound'.
     * 
     * @param bSysIndNoDataFound the value of field
     * 'bSysIndNoDataFound'.
     */
    public void setBSysIndNoDataFound(java.lang.String bSysIndNoDataFound)
    {
        this._bSysIndNoDataFound = bSysIndNoDataFound;
    } //-- void setBSysIndNoDataFound(java.lang.String) 

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
     * Sets the value of field 'cCdFlocStatus10'.
     * 
     * @param cCdFlocStatus10 the value of field 'cCdFlocStatus10'.
     */
    public void setCCdFlocStatus10(java.lang.String cCdFlocStatus10)
    {
        this._cCdFlocStatus10 = cCdFlocStatus10;
    } //-- void setCCdFlocStatus10(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus11'.
     * 
     * @param cCdFlocStatus11 the value of field 'cCdFlocStatus11'.
     */
    public void setCCdFlocStatus11(java.lang.String cCdFlocStatus11)
    {
        this._cCdFlocStatus11 = cCdFlocStatus11;
    } //-- void setCCdFlocStatus11(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus12'.
     * 
     * @param cCdFlocStatus12 the value of field 'cCdFlocStatus12'.
     */
    public void setCCdFlocStatus12(java.lang.String cCdFlocStatus12)
    {
        this._cCdFlocStatus12 = cCdFlocStatus12;
    } //-- void setCCdFlocStatus12(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus13'.
     * 
     * @param cCdFlocStatus13 the value of field 'cCdFlocStatus13'.
     */
    public void setCCdFlocStatus13(java.lang.String cCdFlocStatus13)
    {
        this._cCdFlocStatus13 = cCdFlocStatus13;
    } //-- void setCCdFlocStatus13(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus14'.
     * 
     * @param cCdFlocStatus14 the value of field 'cCdFlocStatus14'.
     */
    public void setCCdFlocStatus14(java.lang.String cCdFlocStatus14)
    {
        this._cCdFlocStatus14 = cCdFlocStatus14;
    } //-- void setCCdFlocStatus14(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus15'.
     * 
     * @param cCdFlocStatus15 the value of field 'cCdFlocStatus15'.
     */
    public void setCCdFlocStatus15(java.lang.String cCdFlocStatus15)
    {
        this._cCdFlocStatus15 = cCdFlocStatus15;
    } //-- void setCCdFlocStatus15(java.lang.String) 

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
     * Sets the value of field 'cCdFlocStatus5'.
     * 
     * @param cCdFlocStatus5 the value of field 'cCdFlocStatus5'.
     */
    public void setCCdFlocStatus5(java.lang.String cCdFlocStatus5)
    {
        this._cCdFlocStatus5 = cCdFlocStatus5;
    } //-- void setCCdFlocStatus5(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus6'.
     * 
     * @param cCdFlocStatus6 the value of field 'cCdFlocStatus6'.
     */
    public void setCCdFlocStatus6(java.lang.String cCdFlocStatus6)
    {
        this._cCdFlocStatus6 = cCdFlocStatus6;
    } //-- void setCCdFlocStatus6(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus7'.
     * 
     * @param cCdFlocStatus7 the value of field 'cCdFlocStatus7'.
     */
    public void setCCdFlocStatus7(java.lang.String cCdFlocStatus7)
    {
        this._cCdFlocStatus7 = cCdFlocStatus7;
    } //-- void setCCdFlocStatus7(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus8'.
     * 
     * @param cCdFlocStatus8 the value of field 'cCdFlocStatus8'.
     */
    public void setCCdFlocStatus8(java.lang.String cCdFlocStatus8)
    {
        this._cCdFlocStatus8 = cCdFlocStatus8;
    } //-- void setCCdFlocStatus8(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus9'.
     * 
     * @param cCdFlocStatus9 the value of field 'cCdFlocStatus9'.
     */
    public void setCCdFlocStatus9(java.lang.String cCdFlocStatus9)
    {
        this._cCdFlocStatus9 = cCdFlocStatus9;
    } //-- void setCCdFlocStatus9(java.lang.String) 

    /**
     * Sets the value of field 'cCdRsrcCapacity'.
     * 
     * @param cCdRsrcCapacity the value of field 'cCdRsrcCapacity'.
     */
    public void setCCdRsrcCapacity(int cCdRsrcCapacity)
    {
        this._cCdRsrcCapacity = cCdRsrcCapacity;
        this._has_cCdRsrcCapacity = true;
    } //-- void setCCdRsrcCapacity(int) 

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
     * Sets the value of field 'cCdRsrcFaHomeType7'.
     * 
     * @param cCdRsrcFaHomeType7 the value of field
     * 'cCdRsrcFaHomeType7'.
     */
    public void setCCdRsrcFaHomeType7(java.lang.String cCdRsrcFaHomeType7)
    {
        this._cCdRsrcFaHomeType7 = cCdRsrcFaHomeType7;
    } //-- void setCCdRsrcFaHomeType7(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcEmergPlace'.
     * 
     * @param cIndRsrcEmergPlace the value of field
     * 'cIndRsrcEmergPlace'.
     */
    public void setCIndRsrcEmergPlace(java.lang.String cIndRsrcEmergPlace)
    {
        this._cIndRsrcEmergPlace = cIndRsrcEmergPlace;
    } //-- void setCIndRsrcEmergPlace(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndALoc'.
     * 
     * @param cSysIndALoc the value of field 'cSysIndALoc'.
     */
    public void setCSysIndALoc(java.lang.String cSysIndALoc)
    {
        this._cSysIndALoc = cSysIndALoc;
    } //-- void setCSysIndALoc(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndCIPoc'.
     * 
     * @param cSysIndCIPoc the value of field 'cSysIndCIPoc'.
     */
    public void setCSysIndCIPoc(java.lang.String cSysIndCIPoc)
    {
        this._cSysIndCIPoc = cSysIndCIPoc;
    } //-- void setCSysIndCIPoc(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndChildUnder12'.
     * 
     * @param cSysIndChildUnder12 the value of field
     * 'cSysIndChildUnder12'.
     */
    public void setCSysIndChildUnder12(java.lang.String cSysIndChildUnder12)
    {
        this._cSysIndChildUnder12 = cSysIndChildUnder12;
    } //-- void setCSysIndChildUnder12(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndChildUnder2or3'.
     * 
     * @param cSysIndChildUnder2or3 the value of field
     * 'cSysIndChildUnder2or3'.
     */
    public void setCSysIndChildUnder2or3(java.lang.String cSysIndChildUnder2or3)
    {
        this._cSysIndChildUnder2or3 = cSysIndChildUnder2or3;
    } //-- void setCSysIndChildUnder2or3(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndContractCurrent'.
     * 
     * @param cSysIndContractCurrent the value of field
     * 'cSysIndContractCurrent'.
     */
    public void setCSysIndContractCurrent(java.lang.String cSysIndContractCurrent)
    {
        this._cSysIndContractCurrent = cSysIndContractCurrent;
    } //-- void setCSysIndContractCurrent(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndFAPoc'.
     * 
     * @param cSysIndFAPoc the value of field 'cSysIndFAPoc'.
     */
    public void setCSysIndFAPoc(java.lang.String cSysIndFAPoc)
    {
        this._cSysIndFAPoc = cSysIndFAPoc;
    } //-- void setCSysIndFAPoc(java.lang.String) 

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
     * Sets the value of field 'cSysIndNRelPoc'.
     * 
     * @param cSysIndNRelPoc the value of field 'cSysIndNRelPoc'.
     */
    public void setCSysIndNRelPoc(java.lang.String cSysIndNRelPoc)
    {
        this._cSysIndNRelPoc = cSysIndNRelPoc;
    } //-- void setCSysIndNRelPoc(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRelPoc'.
     * 
     * @param cSysIndRelPoc the value of field 'cSysIndRelPoc'.
     */
    public void setCSysIndRelPoc(java.lang.String cSysIndRelPoc)
    {
        this._cSysIndRelPoc = cSysIndRelPoc;
    } //-- void setCSysIndRelPoc(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsCapacity'.
     * 
     * @param cSysIndRsCapacity the value of field
     * 'cSysIndRsCapacity'.
     */
    public void setCSysIndRsCapacity(java.lang.String cSysIndRsCapacity)
    {
        this._cSysIndRsCapacity = cSysIndRsCapacity;
    } //-- void setCSysIndRsCapacity(java.lang.String) 

    /**
     * Sets the value of field 'szCdCnperStatus'.
     * 
     * @param szCdCnperStatus the value of field 'szCdCnperStatus'.
     */
    public void setSzCdCnperStatus(java.lang.String szCdCnperStatus)
    {
        this._szCdCnperStatus = szCdCnperStatus;
    } //-- void setSzCdCnperStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdCntrctFuncType'.
     * 
     * @param szCdCntrctFuncType the value of field
     * 'szCdCntrctFuncType'.
     */
    public void setSzCdCntrctFuncType(java.lang.String szCdCntrctFuncType)
    {
        this._szCdCntrctFuncType = szCdCntrctFuncType;
    } //-- void setSzCdCntrctFuncType(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtService'.
     * 
     * @param szCdPlcmtService the value of field 'szCdPlcmtService'
     */
    public void setSzCdPlcmtService(java.lang.String szCdPlcmtService)
    {
        this._szCdPlcmtService = szCdPlcmtService;
    } //-- void setSzCdPlcmtService(java.lang.String) 

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
     * Sets the value of field 'szCdRsrcOwnership'.
     * 
     * @param szCdRsrcOwnership the value of field
     * 'szCdRsrcOwnership'.
     */
    public void setSzCdRsrcOwnership(java.lang.String szCdRsrcOwnership)
    {
        this._szCdRsrcOwnership = szCdRsrcOwnership;
    } //-- void setSzCdRsrcOwnership(java.lang.String) 

    /**
     * Sets the value of field 'szNmPlcmtAgency'.
     * 
     * @param szNmPlcmtAgency the value of field 'szNmPlcmtAgency'.
     */
    public void setSzNmPlcmtAgency(java.lang.String szNmPlcmtAgency)
    {
        this._szNmPlcmtAgency = szNmPlcmtAgency;
    } //-- void setSzNmPlcmtAgency(java.lang.String) 

    /**
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

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
     * Sets the value of field 'ulIdRsrcAgency'.
     * 
     * @param ulIdRsrcAgency the value of field 'ulIdRsrcAgency'.
     */
    public void setUlIdRsrcAgency(int ulIdRsrcAgency)
    {
        this._ulIdRsrcAgency = ulIdRsrcAgency;
        this._has_ulIdRsrcAgency = true;
    } //-- void setUlIdRsrcAgency(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO unmarshal(java.io.Reader) 

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
