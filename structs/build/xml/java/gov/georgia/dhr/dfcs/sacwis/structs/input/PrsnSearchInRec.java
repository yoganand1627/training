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
 * Class PrsnSearchInRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PrsnSearchInRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _bUNKNOWNDOBSEARCH
     */
    private java.lang.String _bUNKNOWNDOBSEARCH;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szCdNameSuffix
     */
    private java.lang.String _szCdNameSuffix;

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
     * Field _szCdAddrState
     */
    private java.lang.String _szCdAddrState;

    /**
     * Field _lAddrZip
     */
    private java.lang.String _lAddrZip;

    /**
     * Field _szCdAddrCounty
     */
    private java.lang.String _szCdAddrCounty;

    /**
     * Field _szNbrPersonIdSsn
     */
    private java.lang.String _szNbrPersonIdSsn;

    /**
     * Field _cCdPersonSex
     */
    private java.lang.String _cCdPersonSex;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _lNbrPersonAge
     */
    private int _lNbrPersonAge;

    /**
     * keeps track of state for field: _lNbrPersonAge
     */
    private boolean _has_lNbrPersonAge;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _bScrAdditParametersChk
     */
    private java.lang.String _bScrAdditParametersChk;

    /**
     * Field _bScrAddressChk
     */
    private java.lang.String _bScrAddressChk;

    /**
     * Field _bScrPhoneticChk
     */
    private java.lang.String _bScrPhoneticChk;

    /**
     * Field _bScrFullNameChk
     */
    private java.lang.String _bScrFullNameChk;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _scrPartlNameChk
     */
    private java.lang.String _scrPartlNameChk;

    /**
     * Field _bASearchFlag
     */
    private java.lang.String _bASearchFlag;

    /**
     * Field _bIndNamePrimary
     */
    private java.lang.String _bIndNamePrimary;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _nbrMedicaidNo
     */
    private java.lang.String _nbrMedicaidNo;

    /**
     * Field _bIndSealed
     */
    private java.lang.String _bIndSealed;


      //----------------/
     //- Constructors -/
    //----------------/

    public PrsnSearchInRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec()


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
     * Returns the value of field 'bASearchFlag'.
     * 
     * @return the value of field 'BASearchFlag'.
     */
    public java.lang.String getBASearchFlag()
    {
        return this._bASearchFlag;
    } //-- java.lang.String getBASearchFlag() 

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
     * Returns the value of field 'bIndSealed'.
     * 
     * @return the value of field 'BIndSealed'.
     */
    public java.lang.String getBIndSealed()
    {
        return this._bIndSealed;
    } //-- java.lang.String getBIndSealed() 

    /**
     * Returns the value of field 'bScrAdditParametersChk'.
     * 
     * @return the value of field 'BScrAdditParametersChk'.
     */
    public java.lang.String getBScrAdditParametersChk()
    {
        return this._bScrAdditParametersChk;
    } //-- java.lang.String getBScrAdditParametersChk() 

    /**
     * Returns the value of field 'bScrAddressChk'.
     * 
     * @return the value of field 'BScrAddressChk'.
     */
    public java.lang.String getBScrAddressChk()
    {
        return this._bScrAddressChk;
    } //-- java.lang.String getBScrAddressChk() 

    /**
     * Returns the value of field 'bScrFullNameChk'.
     * 
     * @return the value of field 'BScrFullNameChk'.
     */
    public java.lang.String getBScrFullNameChk()
    {
        return this._bScrFullNameChk;
    } //-- java.lang.String getBScrFullNameChk() 

    /**
     * Returns the value of field 'bScrPhoneticChk'.
     * 
     * @return the value of field 'BScrPhoneticChk'.
     */
    public java.lang.String getBScrPhoneticChk()
    {
        return this._bScrPhoneticChk;
    } //-- java.lang.String getBScrPhoneticChk() 

    /**
     * Returns the value of field 'bUNKNOWNDOBSEARCH'.
     * 
     * @return the value of field 'BUNKNOWNDOBSEARCH'.
     */
    public java.lang.String getBUNKNOWNDOBSEARCH()
    {
        return this._bUNKNOWNDOBSEARCH;
    } //-- java.lang.String getBUNKNOWNDOBSEARCH() 

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
     * Returns the value of field 'dtDtPersonBirth'.
     * 
     * @return the value of field 'DtDtPersonBirth'.
     */
    public org.exolab.castor.types.Date getDtDtPersonBirth()
    {
        return this._dtDtPersonBirth;
    } //-- org.exolab.castor.types.Date getDtDtPersonBirth() 

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
     * Returns the value of field 'nbrMedicaidNo'.
     * 
     * @return the value of field 'NbrMedicaidNo'.
     */
    public java.lang.String getNbrMedicaidNo()
    {
        return this._nbrMedicaidNo;
    } //-- java.lang.String getNbrMedicaidNo() 

    /**
     * Returns the value of field 'scrPartlNameChk'.
     * 
     * @return the value of field 'ScrPartlNameChk'.
     */
    public java.lang.String getScrPartlNameChk()
    {
        return this._scrPartlNameChk;
    } //-- java.lang.String getScrPartlNameChk() 

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
     * Returns the value of field 'szCdNameSuffix'.
     * 
     * @return the value of field 'SzCdNameSuffix'.
     */
    public java.lang.String getSzCdNameSuffix()
    {
        return this._szCdNameSuffix;
    } //-- java.lang.String getSzCdNameSuffix() 

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
     * Sets the value of field 'bASearchFlag'.
     * 
     * @param bASearchFlag the value of field 'bASearchFlag'.
     */
    public void setBASearchFlag(java.lang.String bASearchFlag)
    {
        this._bASearchFlag = bASearchFlag;
    } //-- void setBASearchFlag(java.lang.String) 

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
     * Sets the value of field 'bIndSealed'.
     * 
     * @param bIndSealed the value of field 'bIndSealed'.
     */
    public void setBIndSealed(java.lang.String bIndSealed)
    {
        this._bIndSealed = bIndSealed;
    } //-- void setBIndSealed(java.lang.String) 

    /**
     * Sets the value of field 'bScrAdditParametersChk'.
     * 
     * @param bScrAdditParametersChk the value of field
     * 'bScrAdditParametersChk'.
     */
    public void setBScrAdditParametersChk(java.lang.String bScrAdditParametersChk)
    {
        this._bScrAdditParametersChk = bScrAdditParametersChk;
    } //-- void setBScrAdditParametersChk(java.lang.String) 

    /**
     * Sets the value of field 'bScrAddressChk'.
     * 
     * @param bScrAddressChk the value of field 'bScrAddressChk'.
     */
    public void setBScrAddressChk(java.lang.String bScrAddressChk)
    {
        this._bScrAddressChk = bScrAddressChk;
    } //-- void setBScrAddressChk(java.lang.String) 

    /**
     * Sets the value of field 'bScrFullNameChk'.
     * 
     * @param bScrFullNameChk the value of field 'bScrFullNameChk'.
     */
    public void setBScrFullNameChk(java.lang.String bScrFullNameChk)
    {
        this._bScrFullNameChk = bScrFullNameChk;
    } //-- void setBScrFullNameChk(java.lang.String) 

    /**
     * Sets the value of field 'bScrPhoneticChk'.
     * 
     * @param bScrPhoneticChk the value of field 'bScrPhoneticChk'.
     */
    public void setBScrPhoneticChk(java.lang.String bScrPhoneticChk)
    {
        this._bScrPhoneticChk = bScrPhoneticChk;
    } //-- void setBScrPhoneticChk(java.lang.String) 

    /**
     * Sets the value of field 'bUNKNOWNDOBSEARCH'.
     * 
     * @param bUNKNOWNDOBSEARCH the value of field
     * 'bUNKNOWNDOBSEARCH'.
     */
    public void setBUNKNOWNDOBSEARCH(java.lang.String bUNKNOWNDOBSEARCH)
    {
        this._bUNKNOWNDOBSEARCH = bUNKNOWNDOBSEARCH;
    } //-- void setBUNKNOWNDOBSEARCH(java.lang.String) 

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
     * Sets the value of field 'dtDtPersonBirth'.
     * 
     * @param dtDtPersonBirth the value of field 'dtDtPersonBirth'.
     */
    public void setDtDtPersonBirth(org.exolab.castor.types.Date dtDtPersonBirth)
    {
        this._dtDtPersonBirth = dtDtPersonBirth;
    } //-- void setDtDtPersonBirth(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'nbrMedicaidNo'.
     * 
     * @param nbrMedicaidNo the value of field 'nbrMedicaidNo'.
     */
    public void setNbrMedicaidNo(java.lang.String nbrMedicaidNo)
    {
        this._nbrMedicaidNo = nbrMedicaidNo;
    } //-- void setNbrMedicaidNo(java.lang.String) 

    /**
     * Sets the value of field 'scrPartlNameChk'.
     * 
     * @param scrPartlNameChk the value of field 'scrPartlNameChk'.
     */
    public void setScrPartlNameChk(java.lang.String scrPartlNameChk)
    {
        this._scrPartlNameChk = scrPartlNameChk;
    } //-- void setScrPartlNameChk(java.lang.String) 

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
     * Sets the value of field 'szCdNameSuffix'.
     * 
     * @param szCdNameSuffix the value of field 'szCdNameSuffix'.
     */
    public void setSzCdNameSuffix(java.lang.String szCdNameSuffix)
    {
        this._szCdNameSuffix = szCdNameSuffix;
    } //-- void setSzCdNameSuffix(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec unmarshal(java.io.Reader) 

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
