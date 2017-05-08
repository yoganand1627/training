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
 * Class ROWCCMN44SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN44SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bIndPersAddrLinkPrimary
     */
    private java.lang.String _bIndPersAddrLinkPrimary;

    /**
     * Field _bIndPersAddrLinkInvalid
     */
    private java.lang.String _bIndPersAddrLinkInvalid;

    /**
     * Field _szCdPersAddrLinkType
     */
    private java.lang.String _szCdPersAddrLinkType;

    /**
     * Field _szAddrPersAddrStLn1
     */
    private java.lang.String _szAddrPersAddrStLn1;

    /**
     * Field _szAddrPersAddrStLn2
     */
    private java.lang.String _szAddrPersAddrStLn2;

    /**
     * Field _szAddrPersAddrAttn
     */
    private java.lang.String _szAddrPersAddrAttn;

    /**
     * Field _szTxtPersonEmail
     */
    private java.lang.String _szTxtPersonEmail;

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
     * Field _ldIdAddress
     */
    private int _ldIdAddress;

    /**
     * keeps track of state for field: _ldIdAddress
     */
    private boolean _has_ldIdAddress;

    /**
     * Field _ulIdAddrPersonLink
     */
    private int _ulIdAddrPersonLink;

    /**
     * keeps track of state for field: _ulIdAddrPersonLink
     */
    private boolean _has_ulIdAddrPersonLink;

    /**
     * Field _dtDtPersAddrLinkStart
     */
    private org.exolab.castor.types.Date _dtDtPersAddrLinkStart;

    /**
     * Field _dtDtPersAddrLinkEnd
     */
    private org.exolab.castor.types.Date _dtDtPersAddrLinkEnd;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _szTxtPersAddrCmnts
     */
    private java.lang.String _szTxtPersAddrCmnts;

    /**
     * Field _lNbrPersonAddrHash
     */
    private int _lNbrPersonAddrHash;

    /**
     * keeps track of state for field: _lNbrPersonAddrHash
     */
    private boolean _has_lNbrPersonAddrHash;

    /**
     * Field _bSysIndAddrMedUpdate
     */
    private java.lang.String _bSysIndAddrMedUpdate;

    /**
     * Field _bIndRemovalHome
     */
    private java.lang.String _bIndRemovalHome;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN44SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrPersonAddrHash()
    {
        this._has_lNbrPersonAddrHash= false;
    } //-- void deleteLNbrPersonAddrHash() 

    /**
     */
    public void deleteLdIdAddress()
    {
        this._has_ldIdAddress= false;
    } //-- void deleteLdIdAddress() 

    /**
     */
    public void deleteUlIdAddrPersonLink()
    {
        this._has_ulIdAddrPersonLink= false;
    } //-- void deleteUlIdAddrPersonLink() 

    /**
     * Returns the value of field 'bIndPersAddrLinkInvalid'.
     * 
     * @return the value of field 'BIndPersAddrLinkInvalid'.
     */
    public java.lang.String getBIndPersAddrLinkInvalid()
    {
        return this._bIndPersAddrLinkInvalid;
    } //-- java.lang.String getBIndPersAddrLinkInvalid() 

    /**
     * Returns the value of field 'bIndPersAddrLinkPrimary'.
     * 
     * @return the value of field 'BIndPersAddrLinkPrimary'.
     */
    public java.lang.String getBIndPersAddrLinkPrimary()
    {
        return this._bIndPersAddrLinkPrimary;
    } //-- java.lang.String getBIndPersAddrLinkPrimary() 

    /**
     * Returns the value of field 'bIndRemovalHome'.
     * 
     * @return the value of field 'BIndRemovalHome'.
     */
    public java.lang.String getBIndRemovalHome()
    {
        return this._bIndRemovalHome;
    } //-- java.lang.String getBIndRemovalHome() 

    /**
     * Returns the value of field 'bSysIndAddrMedUpdate'.
     * 
     * @return the value of field 'BSysIndAddrMedUpdate'.
     */
    public java.lang.String getBSysIndAddrMedUpdate()
    {
        return this._bSysIndAddrMedUpdate;
    } //-- java.lang.String getBSysIndAddrMedUpdate() 

    /**
     * Returns the value of field 'dtDtPersAddrLinkEnd'.
     * 
     * @return the value of field 'DtDtPersAddrLinkEnd'.
     */
    public org.exolab.castor.types.Date getDtDtPersAddrLinkEnd()
    {
        return this._dtDtPersAddrLinkEnd;
    } //-- org.exolab.castor.types.Date getDtDtPersAddrLinkEnd() 

    /**
     * Returns the value of field 'dtDtPersAddrLinkStart'.
     * 
     * @return the value of field 'DtDtPersAddrLinkStart'.
     */
    public org.exolab.castor.types.Date getDtDtPersAddrLinkStart()
    {
        return this._dtDtPersAddrLinkStart;
    } //-- org.exolab.castor.types.Date getDtDtPersAddrLinkStart() 

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
     * Returns the value of field 'lNbrPersonAddrHash'.
     * 
     * @return the value of field 'LNbrPersonAddrHash'.
     */
    public int getLNbrPersonAddrHash()
    {
        return this._lNbrPersonAddrHash;
    } //-- int getLNbrPersonAddrHash() 

    /**
     * Returns the value of field 'ldIdAddress'.
     * 
     * @return the value of field 'LdIdAddress'.
     */
    public int getLdIdAddress()
    {
        return this._ldIdAddress;
    } //-- int getLdIdAddress() 

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
     * Returns the value of field 'szAddrPersAddrAttn'.
     * 
     * @return the value of field 'SzAddrPersAddrAttn'.
     */
    public java.lang.String getSzAddrPersAddrAttn()
    {
        return this._szAddrPersAddrAttn;
    } //-- java.lang.String getSzAddrPersAddrAttn() 

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
     * Returns the value of field 'szCdPersAddrLinkType'.
     * 
     * @return the value of field 'SzCdPersAddrLinkType'.
     */
    public java.lang.String getSzCdPersAddrLinkType()
    {
        return this._szCdPersAddrLinkType;
    } //-- java.lang.String getSzCdPersAddrLinkType() 

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
     * Returns the value of field 'szTxtPersAddrCmnts'.
     * 
     * @return the value of field 'SzTxtPersAddrCmnts'.
     */
    public java.lang.String getSzTxtPersAddrCmnts()
    {
        return this._szTxtPersAddrCmnts;
    } //-- java.lang.String getSzTxtPersAddrCmnts() 

    /**
     * Returns the value of field 'szTxtPersonEmail'.
     * 
     * @return the value of field 'SzTxtPersonEmail'.
     */
    public java.lang.String getSzTxtPersonEmail()
    {
        return this._szTxtPersonEmail;
    } //-- java.lang.String getSzTxtPersonEmail() 

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
     * Returns the value of field 'ulIdAddrPersonLink'.
     * 
     * @return the value of field 'UlIdAddrPersonLink'.
     */
    public int getUlIdAddrPersonLink()
    {
        return this._ulIdAddrPersonLink;
    } //-- int getUlIdAddrPersonLink() 

    /**
     * Method hasLNbrPersonAddrHash
     * 
     * 
     * 
     * @return true if at least one LNbrPersonAddrHash has been adde
     */
    public boolean hasLNbrPersonAddrHash()
    {
        return this._has_lNbrPersonAddrHash;
    } //-- boolean hasLNbrPersonAddrHash() 

    /**
     * Method hasLdIdAddress
     * 
     * 
     * 
     * @return true if at least one LdIdAddress has been added
     */
    public boolean hasLdIdAddress()
    {
        return this._has_ldIdAddress;
    } //-- boolean hasLdIdAddress() 

    /**
     * Method hasUlIdAddrPersonLink
     * 
     * 
     * 
     * @return true if at least one UlIdAddrPersonLink has been adde
     */
    public boolean hasUlIdAddrPersonLink()
    {
        return this._has_ulIdAddrPersonLink;
    } //-- boolean hasUlIdAddrPersonLink() 

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
     * Sets the value of field 'bIndPersAddrLinkInvalid'.
     * 
     * @param bIndPersAddrLinkInvalid the value of field
     * 'bIndPersAddrLinkInvalid'.
     */
    public void setBIndPersAddrLinkInvalid(java.lang.String bIndPersAddrLinkInvalid)
    {
        this._bIndPersAddrLinkInvalid = bIndPersAddrLinkInvalid;
    } //-- void setBIndPersAddrLinkInvalid(java.lang.String) 

    /**
     * Sets the value of field 'bIndPersAddrLinkPrimary'.
     * 
     * @param bIndPersAddrLinkPrimary the value of field
     * 'bIndPersAddrLinkPrimary'.
     */
    public void setBIndPersAddrLinkPrimary(java.lang.String bIndPersAddrLinkPrimary)
    {
        this._bIndPersAddrLinkPrimary = bIndPersAddrLinkPrimary;
    } //-- void setBIndPersAddrLinkPrimary(java.lang.String) 

    /**
     * Sets the value of field 'bIndRemovalHome'.
     * 
     * @param bIndRemovalHome the value of field 'bIndRemovalHome'.
     */
    public void setBIndRemovalHome(java.lang.String bIndRemovalHome)
    {
        this._bIndRemovalHome = bIndRemovalHome;
    } //-- void setBIndRemovalHome(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndAddrMedUpdate'.
     * 
     * @param bSysIndAddrMedUpdate the value of field
     * 'bSysIndAddrMedUpdate'.
     */
    public void setBSysIndAddrMedUpdate(java.lang.String bSysIndAddrMedUpdate)
    {
        this._bSysIndAddrMedUpdate = bSysIndAddrMedUpdate;
    } //-- void setBSysIndAddrMedUpdate(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPersAddrLinkEnd'.
     * 
     * @param dtDtPersAddrLinkEnd the value of field
     * 'dtDtPersAddrLinkEnd'.
     */
    public void setDtDtPersAddrLinkEnd(org.exolab.castor.types.Date dtDtPersAddrLinkEnd)
    {
        this._dtDtPersAddrLinkEnd = dtDtPersAddrLinkEnd;
    } //-- void setDtDtPersAddrLinkEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersAddrLinkStart'.
     * 
     * @param dtDtPersAddrLinkStart the value of field
     * 'dtDtPersAddrLinkStart'.
     */
    public void setDtDtPersAddrLinkStart(org.exolab.castor.types.Date dtDtPersAddrLinkStart)
    {
        this._dtDtPersAddrLinkStart = dtDtPersAddrLinkStart;
    } //-- void setDtDtPersAddrLinkStart(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'lNbrPersonAddrHash'.
     * 
     * @param lNbrPersonAddrHash the value of field
     * 'lNbrPersonAddrHash'.
     */
    public void setLNbrPersonAddrHash(int lNbrPersonAddrHash)
    {
        this._lNbrPersonAddrHash = lNbrPersonAddrHash;
        this._has_lNbrPersonAddrHash = true;
    } //-- void setLNbrPersonAddrHash(int) 

    /**
     * Sets the value of field 'ldIdAddress'.
     * 
     * @param ldIdAddress the value of field 'ldIdAddress'.
     */
    public void setLdIdAddress(int ldIdAddress)
    {
        this._ldIdAddress = ldIdAddress;
        this._has_ldIdAddress = true;
    } //-- void setLdIdAddress(int) 

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
     * Sets the value of field 'szAddrPersAddrAttn'.
     * 
     * @param szAddrPersAddrAttn the value of field
     * 'szAddrPersAddrAttn'.
     */
    public void setSzAddrPersAddrAttn(java.lang.String szAddrPersAddrAttn)
    {
        this._szAddrPersAddrAttn = szAddrPersAddrAttn;
    } //-- void setSzAddrPersAddrAttn(java.lang.String) 

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
     * Sets the value of field 'szCdPersAddrLinkType'.
     * 
     * @param szCdPersAddrLinkType the value of field
     * 'szCdPersAddrLinkType'.
     */
    public void setSzCdPersAddrLinkType(java.lang.String szCdPersAddrLinkType)
    {
        this._szCdPersAddrLinkType = szCdPersAddrLinkType;
    } //-- void setSzCdPersAddrLinkType(java.lang.String) 

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
     * Sets the value of field 'szTxtPersAddrCmnts'.
     * 
     * @param szTxtPersAddrCmnts the value of field
     * 'szTxtPersAddrCmnts'.
     */
    public void setSzTxtPersAddrCmnts(java.lang.String szTxtPersAddrCmnts)
    {
        this._szTxtPersAddrCmnts = szTxtPersAddrCmnts;
    } //-- void setSzTxtPersAddrCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPersonEmail'.
     * 
     * @param szTxtPersonEmail the value of field 'szTxtPersonEmail'
     */
    public void setSzTxtPersonEmail(java.lang.String szTxtPersonEmail)
    {
        this._szTxtPersonEmail = szTxtPersonEmail;
    } //-- void setSzTxtPersonEmail(java.lang.String) 

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
     * Sets the value of field 'ulIdAddrPersonLink'.
     * 
     * @param ulIdAddrPersonLink the value of field
     * 'ulIdAddrPersonLink'.
     */
    public void setUlIdAddrPersonLink(int ulIdAddrPersonLink)
    {
        this._ulIdAddrPersonLink = ulIdAddrPersonLink;
        this._has_ulIdAddrPersonLink = true;
    } //-- void setUlIdAddrPersonLink(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00 unmarshal(java.io.Reader) 

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
