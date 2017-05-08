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
 * Class PrsnSearchOutRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PrsnSearchOutRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szScrCdPersonSearchHit
     */
    private java.lang.String _szScrCdPersonSearchHit;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szNmIncmgPersFull
     */
    private java.lang.String _szNmIncmgPersFull;

    /**
     * Field _szScrNmGenericFullName
     */
    private java.lang.String _szScrNmGenericFullName;

    /**
     * Field _usScrIndScore
     */
    private int _usScrIndScore;

    /**
     * keeps track of state for field: _usScrIndScore
     */
    private boolean _has_usScrIndScore;

    /**
     * Field _bIndActiveStatus
     */
    private java.lang.String _bIndActiveStatus;

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

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
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szAddrCity
     */
    private java.lang.String _szAddrCity;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _szAddrPersAddrStLn1
     */
    private java.lang.String _szAddrPersAddrStLn1;

    /**
     * Field _szNbrPersonIdSsn
     */
    private java.lang.String _szNbrPersonIdSsn;

    /**
     * Field _bSysIndViewPersonInfo
     */
    private java.lang.String _bSysIndViewPersonInfo;

    /**
     * Field _cWcdIndMerge
     */
    private java.lang.String _cWcdIndMerge;

    /**
     * Field _bIndPersonDobApprox
     */
    private java.lang.String _bIndPersonDobApprox;

    /**
     * Field _dtDtPersonDeath
     */
    private org.exolab.castor.types.Date _dtDtPersonDeath;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _dtDtNameEndDate
     */
    private org.exolab.castor.types.Date _dtDtNameEndDate;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _lNbrMedcaidNo
     */
    private int _lNbrMedcaidNo;

    /**
     * keeps track of state for field: _lNbrMedcaidNo
     */
    private boolean _has_lNbrMedcaidNo;

    /**
     * Field _indPsa
     */
    private java.lang.String _indPsa;

    /**
     * Field _indAdopted
     */
    private java.lang.String _indAdopted;


      //----------------/
     //- Constructors -/
    //----------------/

    public PrsnSearchOutRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrMedcaidNo()
    {
        this._has_lNbrMedcaidNo= false;
    } //-- void deleteLNbrMedcaidNo() 

    /**
     */
    public void deleteLNbrPersonAge()
    {
        this._has_lNbrPersonAge= false;
    } //-- void deleteLNbrPersonAge() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUsScrIndScore()
    {
        this._has_usScrIndScore= false;
    } //-- void deleteUsScrIndScore() 

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
     * Returns the value of field 'bIndPersonDobApprox'.
     * 
     * @return the value of field 'BIndPersonDobApprox'.
     */
    public java.lang.String getBIndPersonDobApprox()
    {
        return this._bIndPersonDobApprox;
    } //-- java.lang.String getBIndPersonDobApprox() 

    /**
     * Returns the value of field 'bSysIndViewPersonInfo'.
     * 
     * @return the value of field 'BSysIndViewPersonInfo'.
     */
    public java.lang.String getBSysIndViewPersonInfo()
    {
        return this._bSysIndViewPersonInfo;
    } //-- java.lang.String getBSysIndViewPersonInfo() 

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
     * Returns the value of field 'cWcdIndMerge'.
     * 
     * @return the value of field 'CWcdIndMerge'.
     */
    public java.lang.String getCWcdIndMerge()
    {
        return this._cWcdIndMerge;
    } //-- java.lang.String getCWcdIndMerge() 

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
     * Returns the value of field 'indAdopted'.
     * 
     * @return the value of field 'IndAdopted'.
     */
    public java.lang.String getIndAdopted()
    {
        return this._indAdopted;
    } //-- java.lang.String getIndAdopted() 

    /**
     * Returns the value of field 'indPsa'.
     * 
     * @return the value of field 'IndPsa'.
     */
    public java.lang.String getIndPsa()
    {
        return this._indPsa;
    } //-- java.lang.String getIndPsa() 

    /**
     * Returns the value of field 'lNbrMedcaidNo'.
     * 
     * @return the value of field 'LNbrMedcaidNo'.
     */
    public int getLNbrMedcaidNo()
    {
        return this._lNbrMedcaidNo;
    } //-- int getLNbrMedcaidNo() 

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
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

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
     * Returns the value of field 'szNbrPersonIdSsn'.
     * 
     * @return the value of field 'SzNbrPersonIdSsn'.
     */
    public java.lang.String getSzNbrPersonIdSsn()
    {
        return this._szNbrPersonIdSsn;
    } //-- java.lang.String getSzNbrPersonIdSsn() 

    /**
     * Returns the value of field 'szNmIncmgPersFull'.
     * 
     * @return the value of field 'SzNmIncmgPersFull'.
     */
    public java.lang.String getSzNmIncmgPersFull()
    {
        return this._szNmIncmgPersFull;
    } //-- java.lang.String getSzNmIncmgPersFull() 

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
     * Returns the value of field 'szScrCdPersonSearchHit'.
     * 
     * @return the value of field 'SzScrCdPersonSearchHit'.
     */
    public java.lang.String getSzScrCdPersonSearchHit()
    {
        return this._szScrCdPersonSearchHit;
    } //-- java.lang.String getSzScrCdPersonSearchHit() 

    /**
     * Returns the value of field 'szScrNmGenericFullName'.
     * 
     * @return the value of field 'SzScrNmGenericFullName'.
     */
    public java.lang.String getSzScrNmGenericFullName()
    {
        return this._szScrNmGenericFullName;
    } //-- java.lang.String getSzScrNmGenericFullName() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Returns the value of field 'usScrIndScore'.
     * 
     * @return the value of field 'UsScrIndScore'.
     */
    public int getUsScrIndScore()
    {
        return this._usScrIndScore;
    } //-- int getUsScrIndScore() 

    /**
     * Method hasLNbrMedcaidNo
     * 
     * 
     * 
     * @return true if at least one LNbrMedcaidNo has been added
     */
    public boolean hasLNbrMedcaidNo()
    {
        return this._has_lNbrMedcaidNo;
    } //-- boolean hasLNbrMedcaidNo() 

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
     * Method hasUsScrIndScore
     * 
     * 
     * 
     * @return true if at least one UsScrIndScore has been added
     */
    public boolean hasUsScrIndScore()
    {
        return this._has_usScrIndScore;
    } //-- boolean hasUsScrIndScore() 

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
     * Sets the value of field 'bIndActiveStatus'.
     * 
     * @param bIndActiveStatus the value of field 'bIndActiveStatus'
     */
    public void setBIndActiveStatus(java.lang.String bIndActiveStatus)
    {
        this._bIndActiveStatus = bIndActiveStatus;
    } //-- void setBIndActiveStatus(java.lang.String) 

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
     * Sets the value of field 'bSysIndViewPersonInfo'.
     * 
     * @param bSysIndViewPersonInfo the value of field
     * 'bSysIndViewPersonInfo'.
     */
    public void setBSysIndViewPersonInfo(java.lang.String bSysIndViewPersonInfo)
    {
        this._bSysIndViewPersonInfo = bSysIndViewPersonInfo;
    } //-- void setBSysIndViewPersonInfo(java.lang.String) 

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
     * Sets the value of field 'cWcdIndMerge'.
     * 
     * @param cWcdIndMerge the value of field 'cWcdIndMerge'.
     */
    public void setCWcdIndMerge(java.lang.String cWcdIndMerge)
    {
        this._cWcdIndMerge = cWcdIndMerge;
    } //-- void setCWcdIndMerge(java.lang.String) 

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
     * Sets the value of field 'indAdopted'.
     * 
     * @param indAdopted the value of field 'indAdopted'.
     */
    public void setIndAdopted(java.lang.String indAdopted)
    {
        this._indAdopted = indAdopted;
    } //-- void setIndAdopted(java.lang.String) 

    /**
     * Sets the value of field 'indPsa'.
     * 
     * @param indPsa the value of field 'indPsa'.
     */
    public void setIndPsa(java.lang.String indPsa)
    {
        this._indPsa = indPsa;
    } //-- void setIndPsa(java.lang.String) 

    /**
     * Sets the value of field 'lNbrMedcaidNo'.
     * 
     * @param lNbrMedcaidNo the value of field 'lNbrMedcaidNo'.
     */
    public void setLNbrMedcaidNo(int lNbrMedcaidNo)
    {
        this._lNbrMedcaidNo = lNbrMedcaidNo;
        this._has_lNbrMedcaidNo = true;
    } //-- void setLNbrMedcaidNo(int) 

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
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

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
     * Sets the value of field 'szNbrPersonIdSsn'.
     * 
     * @param szNbrPersonIdSsn the value of field 'szNbrPersonIdSsn'
     */
    public void setSzNbrPersonIdSsn(java.lang.String szNbrPersonIdSsn)
    {
        this._szNbrPersonIdSsn = szNbrPersonIdSsn;
    } //-- void setSzNbrPersonIdSsn(java.lang.String) 

    /**
     * Sets the value of field 'szNmIncmgPersFull'.
     * 
     * @param szNmIncmgPersFull the value of field
     * 'szNmIncmgPersFull'.
     */
    public void setSzNmIncmgPersFull(java.lang.String szNmIncmgPersFull)
    {
        this._szNmIncmgPersFull = szNmIncmgPersFull;
    } //-- void setSzNmIncmgPersFull(java.lang.String) 

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
     * Sets the value of field 'szScrCdPersonSearchHit'.
     * 
     * @param szScrCdPersonSearchHit the value of field
     * 'szScrCdPersonSearchHit'.
     */
    public void setSzScrCdPersonSearchHit(java.lang.String szScrCdPersonSearchHit)
    {
        this._szScrCdPersonSearchHit = szScrCdPersonSearchHit;
    } //-- void setSzScrCdPersonSearchHit(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmGenericFullName'.
     * 
     * @param szScrNmGenericFullName the value of field
     * 'szScrNmGenericFullName'.
     */
    public void setSzScrNmGenericFullName(java.lang.String szScrNmGenericFullName)
    {
        this._szScrNmGenericFullName = szScrNmGenericFullName;
    } //-- void setSzScrNmGenericFullName(java.lang.String) 

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
     * Sets the value of field 'usScrIndScore'.
     * 
     * @param usScrIndScore the value of field 'usScrIndScore'.
     */
    public void setUsScrIndScore(int usScrIndScore)
    {
        this._usScrIndScore = usScrIndScore;
        this._has_usScrIndScore = true;
    } //-- void setUsScrIndScore(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec unmarshal(java.io.Reader) 

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
