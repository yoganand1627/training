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
 * Class HierPersSrchRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HierPersSrchRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szAddrCity
     */
    private java.lang.String _szAddrCity;

    /**
     * Field _cCdPersonSex
     */
    private java.lang.String _cCdPersonSex;

    /**
     * Field _bASearchFlag
     */
    private java.lang.String _bASearchFlag;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _szAddrPersAddrStLn1
     */
    private java.lang.String _szAddrPersAddrStLn1;

    /**
     * Field _szAddrPersAddrStLn2
     */
    private java.lang.String _szAddrPersAddrStLn2;

    /**
     * Field _lAddrZip
     */
    private java.lang.String _lAddrZip;

    /**
     * Field _szCdAddrCounty
     */
    private java.lang.String _szCdAddrCounty;

    /**
     * Field _szCdAddrState
     */
    private java.lang.String _szCdAddrState;

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
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _lSysNbrUniqueLBKey
     */
    private int _lSysNbrUniqueLBKey;

    /**
     * keeps track of state for field: _lSysNbrUniqueLBKey
     */
    private boolean _has_lSysNbrUniqueLBKey;

    /**
     * Field _szNbrPersonIdSsn
     */
    private java.lang.String _szNbrPersonIdSsn;


      //----------------/
     //- Constructors -/
    //----------------/

    public HierPersSrchRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec()


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
    public void deleteLSysNbrUniqueLBKey()
    {
        this._has_lSysNbrUniqueLBKey= false;
    } //-- void deleteLSysNbrUniqueLBKey() 

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
     * Returns the value of field 'lSysNbrUniqueLBKey'.
     * 
     * @return the value of field 'LSysNbrUniqueLBKey'.
     */
    public int getLSysNbrUniqueLBKey()
    {
        return this._lSysNbrUniqueLBKey;
    } //-- int getLSysNbrUniqueLBKey() 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec unmarshal(java.io.Reader) 

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
