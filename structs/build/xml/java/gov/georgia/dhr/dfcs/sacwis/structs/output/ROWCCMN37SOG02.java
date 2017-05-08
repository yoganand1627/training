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
 * Class ROWCCMN37SOG02.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN37SOG02 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdStageType
     */
    private java.lang.String _szCdStageType;

    /**
     * Field _szCdStageLevel
     */
    private java.lang.String _szCdStageLevel;

    /**
     * Field _bIndEcsVer
     */
    private java.lang.String _bIndEcsVer;

    /**
     * Field _bIndRedFlag
     */
    private java.lang.String _bIndRedFlag;

    /**
     * Field _bIndStageReopenDIV
     */
    private java.lang.String _bIndStageReopenDIV;

    /**
     * Field _bIndStageReopenSUB
     */
    private java.lang.String _bIndStageReopenSUB;

    /**
     * Field _bIndStageReopenADO
     */
    private java.lang.String _bIndStageReopenADO;

    /**
     * Field _cScrIndStageMerged
     */
    private java.lang.String _cScrIndStageMerged;

    /**
     * Field _cScrIndSealed
     */
    private java.lang.String _cScrIndSealed;

    /**
     * Field _dtDtStageStart
     */
    private org.exolab.castor.types.Date _dtDtStageStart;

    /**
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _szCdStageRegion
     */
    private java.lang.String _szCdStageRegion;

    /**
     * Field _szCdStageCounty
     */
    private java.lang.String _szCdStageCounty;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

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
     * Field _cdCpsOverallDisptn
     */
    private java.lang.String _cdCpsOverallDisptn;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN37SOG02() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02()


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
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndEcsVer'.
     * 
     * @return the value of field 'BIndEcsVer'.
     */
    public java.lang.String getBIndEcsVer()
    {
        return this._bIndEcsVer;
    } //-- java.lang.String getBIndEcsVer() 

    /**
     * Returns the value of field 'bIndRedFlag'.
     * 
     * @return the value of field 'BIndRedFlag'.
     */
    public java.lang.String getBIndRedFlag()
    {
        return this._bIndRedFlag;
    } //-- java.lang.String getBIndRedFlag() 

    /**
     * Returns the value of field 'bIndStageReopenADO'.
     * 
     * @return the value of field 'BIndStageReopenADO'.
     */
    public java.lang.String getBIndStageReopenADO()
    {
        return this._bIndStageReopenADO;
    } //-- java.lang.String getBIndStageReopenADO() 

    /**
     * Returns the value of field 'bIndStageReopenDIV'.
     * 
     * @return the value of field 'BIndStageReopenDIV'.
     */
    public java.lang.String getBIndStageReopenDIV()
    {
        return this._bIndStageReopenDIV;
    } //-- java.lang.String getBIndStageReopenDIV() 

    /**
     * Returns the value of field 'bIndStageReopenSUB'.
     * 
     * @return the value of field 'BIndStageReopenSUB'.
     */
    public java.lang.String getBIndStageReopenSUB()
    {
        return this._bIndStageReopenSUB;
    } //-- java.lang.String getBIndStageReopenSUB() 

    /**
     * Returns the value of field 'cScrIndSealed'.
     * 
     * @return the value of field 'CScrIndSealed'.
     */
    public java.lang.String getCScrIndSealed()
    {
        return this._cScrIndSealed;
    } //-- java.lang.String getCScrIndSealed() 

    /**
     * Returns the value of field 'cScrIndStageMerged'.
     * 
     * @return the value of field 'CScrIndStageMerged'.
     */
    public java.lang.String getCScrIndStageMerged()
    {
        return this._cScrIndStageMerged;
    } //-- java.lang.String getCScrIndStageMerged() 

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
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'dtDtStageStart'.
     * 
     * @return the value of field 'DtDtStageStart'.
     */
    public org.exolab.castor.types.Date getDtDtStageStart()
    {
        return this._dtDtStageStart;
    } //-- org.exolab.castor.types.Date getDtDtStageStart() 

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
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szCdStageCounty'.
     * 
     * @return the value of field 'SzCdStageCounty'.
     */
    public java.lang.String getSzCdStageCounty()
    {
        return this._szCdStageCounty;
    } //-- java.lang.String getSzCdStageCounty() 

    /**
     * Returns the value of field 'szCdStageLevel'.
     * 
     * @return the value of field 'SzCdStageLevel'.
     */
    public java.lang.String getSzCdStageLevel()
    {
        return this._szCdStageLevel;
    } //-- java.lang.String getSzCdStageLevel() 

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
     * Returns the value of field 'szCdStageRegion'.
     * 
     * @return the value of field 'SzCdStageRegion'.
     */
    public java.lang.String getSzCdStageRegion()
    {
        return this._szCdStageRegion;
    } //-- java.lang.String getSzCdStageRegion() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdSituation'.
     * 
     * @return the value of field 'UlIdSituation'.
     */
    public int getUlIdSituation()
    {
        return this._ulIdSituation;
    } //-- int getUlIdSituation() 

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
     * Method hasUlIdSituation
     * 
     * 
     * 
     * @return true if at least one UlIdSituation has been added
     */
    public boolean hasUlIdSituation()
    {
        return this._has_ulIdSituation;
    } //-- boolean hasUlIdSituation() 

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
     * Sets the value of field 'bIndEcsVer'.
     * 
     * @param bIndEcsVer the value of field 'bIndEcsVer'.
     */
    public void setBIndEcsVer(java.lang.String bIndEcsVer)
    {
        this._bIndEcsVer = bIndEcsVer;
    } //-- void setBIndEcsVer(java.lang.String) 

    /**
     * Sets the value of field 'bIndRedFlag'.
     * 
     * @param bIndRedFlag the value of field 'bIndRedFlag'.
     */
    public void setBIndRedFlag(java.lang.String bIndRedFlag)
    {
        this._bIndRedFlag = bIndRedFlag;
    } //-- void setBIndRedFlag(java.lang.String) 

    /**
     * Sets the value of field 'bIndStageReopenADO'.
     * 
     * @param bIndStageReopenADO the value of field
     * 'bIndStageReopenADO'.
     */
    public void setBIndStageReopenADO(java.lang.String bIndStageReopenADO)
    {
        this._bIndStageReopenADO = bIndStageReopenADO;
    } //-- void setBIndStageReopenADO(java.lang.String) 

    /**
     * Sets the value of field 'bIndStageReopenDIV'.
     * 
     * @param bIndStageReopenDIV the value of field
     * 'bIndStageReopenDIV'.
     */
    public void setBIndStageReopenDIV(java.lang.String bIndStageReopenDIV)
    {
        this._bIndStageReopenDIV = bIndStageReopenDIV;
    } //-- void setBIndStageReopenDIV(java.lang.String) 

    /**
     * Sets the value of field 'bIndStageReopenSUB'.
     * 
     * @param bIndStageReopenSUB the value of field
     * 'bIndStageReopenSUB'.
     */
    public void setBIndStageReopenSUB(java.lang.String bIndStageReopenSUB)
    {
        this._bIndStageReopenSUB = bIndStageReopenSUB;
    } //-- void setBIndStageReopenSUB(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndSealed'.
     * 
     * @param cScrIndSealed the value of field 'cScrIndSealed'.
     */
    public void setCScrIndSealed(java.lang.String cScrIndSealed)
    {
        this._cScrIndSealed = cScrIndSealed;
    } //-- void setCScrIndSealed(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndStageMerged'.
     * 
     * @param cScrIndStageMerged the value of field
     * 'cScrIndStageMerged'.
     */
    public void setCScrIndStageMerged(java.lang.String cScrIndStageMerged)
    {
        this._cScrIndStageMerged = cScrIndStageMerged;
    } //-- void setCScrIndStageMerged(java.lang.String) 

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
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStageStart'.
     * 
     * @param dtDtStageStart the value of field 'dtDtStageStart'.
     */
    public void setDtDtStageStart(org.exolab.castor.types.Date dtDtStageStart)
    {
        this._dtDtStageStart = dtDtStageStart;
    } //-- void setDtDtStageStart(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCounty'.
     * 
     * @param szCdStageCounty the value of field 'szCdStageCounty'.
     */
    public void setSzCdStageCounty(java.lang.String szCdStageCounty)
    {
        this._szCdStageCounty = szCdStageCounty;
    } //-- void setSzCdStageCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageLevel'.
     * 
     * @param szCdStageLevel the value of field 'szCdStageLevel'.
     */
    public void setSzCdStageLevel(java.lang.String szCdStageLevel)
    {
        this._szCdStageLevel = szCdStageLevel;
    } //-- void setSzCdStageLevel(java.lang.String) 

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
     * Sets the value of field 'szCdStageRegion'.
     * 
     * @param szCdStageRegion the value of field 'szCdStageRegion'.
     */
    public void setSzCdStageRegion(java.lang.String szCdStageRegion)
    {
        this._szCdStageRegion = szCdStageRegion;
    } //-- void setSzCdStageRegion(java.lang.String) 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

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
     * Sets the value of field 'ulIdSituation'.
     * 
     * @param ulIdSituation the value of field 'ulIdSituation'.
     */
    public void setUlIdSituation(int ulIdSituation)
    {
        this._ulIdSituation = ulIdSituation;
        this._has_ulIdSituation = true;
    } //-- void setUlIdSituation(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02 unmarshal(java.io.Reader) 

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
