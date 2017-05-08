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
 * Class ROWCCMN50DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN50DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szBjnJob
     */
    private java.lang.String _szBjnJob;

    /**
     * Field _szTextErsNumber
     */
    private java.lang.String _szTextErsNumber;

    /**
     * Field _szCdEmployeeClass
     */
    private java.lang.String _szCdEmployeeClass;

    /**
     * Field _szCdUnitRegion
     */
    private java.lang.String _szCdUnitRegion;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _szNmOfficeName
     */
    private java.lang.String _szNmOfficeName;

    /**
     * Field _lSysNbrPersPhnHome
     */
    private java.lang.String _lSysNbrPersPhnHome;

    /**
     * Field _lSysNbrPersPhoneWork
     */
    private java.lang.String _lSysNbrPersPhoneWork;

    /**
     * Field _szCdPhoneType
     */
    private java.lang.String _szCdPhoneType;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _lNbrPhoneExtension
     */
    private java.lang.String _lNbrPhoneExtension;

    /**
     * Field _bIndPersonPhonePrimary
     */
    private java.lang.String _bIndPersonPhonePrimary;

    /**
     * Field _dtDtEmpLastAssigned
     */
    private org.exolab.castor.types.Date _dtDtEmpLastAssigned;

    /**
     * Field _tmScrTmEmpLastAssigned
     */
    private java.lang.String _tmScrTmEmpLastAssigned;

    /**
     * Field _szAddrMailCode
     */
    private java.lang.String _szAddrMailCode;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _szCdUnitCounty
     */
    private java.lang.String _szCdUnitCounty;

    /**
     * Field _szCdOfficeCounty
     */
    private java.lang.String _szCdOfficeCounty;

    /**
     * Field _szCdJobTitle
     */
    private java.lang.String _szCdJobTitle;

    /**
     * Field _szCdEmpProgram
     */
    private java.lang.String _szCdEmpProgram;

    /**
     * Field _bIndOverPolicyLimit
     */
    private boolean _bIndOverPolicyLimit;

    /**
     * keeps track of state for field: _bIndOverPolicyLimit
     */
    private boolean _has_bIndOverPolicyLimit;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN50DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndOverPolicyLimit()
    {
        this._has_bIndOverPolicyLimit= false;
    } //-- void deleteBIndOverPolicyLimit() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean getBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean getBIndOverPolicyLimit() 

    /**
     * Returns the value of field 'bIndPersonPhonePrimary'.
     * 
     * @return the value of field 'BIndPersonPhonePrimary'.
     */
    public java.lang.String getBIndPersonPhonePrimary()
    {
        return this._bIndPersonPhonePrimary;
    } //-- java.lang.String getBIndPersonPhonePrimary() 

    /**
     * Returns the value of field 'dtDtEmpLastAssigned'.
     * 
     * @return the value of field 'DtDtEmpLastAssigned'.
     */
    public org.exolab.castor.types.Date getDtDtEmpLastAssigned()
    {
        return this._dtDtEmpLastAssigned;
    } //-- org.exolab.castor.types.Date getDtDtEmpLastAssigned() 

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
     * Returns the value of field 'lNbrPhoneExtension'.
     * 
     * @return the value of field 'LNbrPhoneExtension'.
     */
    public java.lang.String getLNbrPhoneExtension()
    {
        return this._lNbrPhoneExtension;
    } //-- java.lang.String getLNbrPhoneExtension() 

    /**
     * Returns the value of field 'lSysNbrPersPhnHome'.
     * 
     * @return the value of field 'LSysNbrPersPhnHome'.
     */
    public java.lang.String getLSysNbrPersPhnHome()
    {
        return this._lSysNbrPersPhnHome;
    } //-- java.lang.String getLSysNbrPersPhnHome() 

    /**
     * Returns the value of field 'lSysNbrPersPhoneWork'.
     * 
     * @return the value of field 'LSysNbrPersPhoneWork'.
     */
    public java.lang.String getLSysNbrPersPhoneWork()
    {
        return this._lSysNbrPersPhoneWork;
    } //-- java.lang.String getLSysNbrPersPhoneWork() 

    /**
     * Returns the value of field 'szAddrMailCode'.
     * 
     * @return the value of field 'SzAddrMailCode'.
     */
    public java.lang.String getSzAddrMailCode()
    {
        return this._szAddrMailCode;
    } //-- java.lang.String getSzAddrMailCode() 

    /**
     * Returns the value of field 'szBjnJob'.
     * 
     * @return the value of field 'SzBjnJob'.
     */
    public java.lang.String getSzBjnJob()
    {
        return this._szBjnJob;
    } //-- java.lang.String getSzBjnJob() 

    /**
     * Returns the value of field 'szCdEmpProgram'.
     * 
     * @return the value of field 'SzCdEmpProgram'.
     */
    public java.lang.String getSzCdEmpProgram()
    {
        return this._szCdEmpProgram;
    } //-- java.lang.String getSzCdEmpProgram() 

    /**
     * Returns the value of field 'szCdEmployeeClass'.
     * 
     * @return the value of field 'SzCdEmployeeClass'.
     */
    public java.lang.String getSzCdEmployeeClass()
    {
        return this._szCdEmployeeClass;
    } //-- java.lang.String getSzCdEmployeeClass() 

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
     * Returns the value of field 'szCdOfficeCounty'.
     * 
     * @return the value of field 'SzCdOfficeCounty'.
     */
    public java.lang.String getSzCdOfficeCounty()
    {
        return this._szCdOfficeCounty;
    } //-- java.lang.String getSzCdOfficeCounty() 

    /**
     * Returns the value of field 'szCdPhoneType'.
     * 
     * @return the value of field 'SzCdPhoneType'.
     */
    public java.lang.String getSzCdPhoneType()
    {
        return this._szCdPhoneType;
    } //-- java.lang.String getSzCdPhoneType() 

    /**
     * Returns the value of field 'szCdUnitCounty'.
     * 
     * @return the value of field 'SzCdUnitCounty'.
     */
    public java.lang.String getSzCdUnitCounty()
    {
        return this._szCdUnitCounty;
    } //-- java.lang.String getSzCdUnitCounty() 

    /**
     * Returns the value of field 'szCdUnitRegion'.
     * 
     * @return the value of field 'SzCdUnitRegion'.
     */
    public java.lang.String getSzCdUnitRegion()
    {
        return this._szCdUnitRegion;
    } //-- java.lang.String getSzCdUnitRegion() 

    /**
     * Returns the value of field 'szNbrUnit'.
     * 
     * @return the value of field 'SzNbrUnit'.
     */
    public java.lang.String getSzNbrUnit()
    {
        return this._szNbrUnit;
    } //-- java.lang.String getSzNbrUnit() 

    /**
     * Returns the value of field 'szNmOfficeName'.
     * 
     * @return the value of field 'SzNmOfficeName'.
     */
    public java.lang.String getSzNmOfficeName()
    {
        return this._szNmOfficeName;
    } //-- java.lang.String getSzNmOfficeName() 

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
     * Returns the value of field 'szTextErsNumber'.
     * 
     * @return the value of field 'SzTextErsNumber'.
     */
    public java.lang.String getSzTextErsNumber()
    {
        return this._szTextErsNumber;
    } //-- java.lang.String getSzTextErsNumber() 

    /**
     * Returns the value of field 'tmScrTmEmpLastAssigned'.
     * 
     * @return the value of field 'TmScrTmEmpLastAssigned'.
     */
    public java.lang.String getTmScrTmEmpLastAssigned()
    {
        return this._tmScrTmEmpLastAssigned;
    } //-- java.lang.String getTmScrTmEmpLastAssigned() 

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
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

    /**
     * Method hasBIndOverPolicyLimit
     * 
     * 
     * 
     * @return true if at least one BIndOverPolicyLimit has been
     * added
     */
    public boolean hasBIndOverPolicyLimit()
    {
        return this._has_bIndOverPolicyLimit;
    } //-- boolean hasBIndOverPolicyLimit() 

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
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

    /**
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean isBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean isBIndOverPolicyLimit() 

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
     * Sets the value of field 'bIndOverPolicyLimit'.
     * 
     * @param bIndOverPolicyLimit the value of field
     * 'bIndOverPolicyLimit'.
     */
    public void setBIndOverPolicyLimit(boolean bIndOverPolicyLimit)
    {
        this._bIndOverPolicyLimit = bIndOverPolicyLimit;
        this._has_bIndOverPolicyLimit = true;
    } //-- void setBIndOverPolicyLimit(boolean) 

    /**
     * Sets the value of field 'bIndPersonPhonePrimary'.
     * 
     * @param bIndPersonPhonePrimary the value of field
     * 'bIndPersonPhonePrimary'.
     */
    public void setBIndPersonPhonePrimary(java.lang.String bIndPersonPhonePrimary)
    {
        this._bIndPersonPhonePrimary = bIndPersonPhonePrimary;
    } //-- void setBIndPersonPhonePrimary(java.lang.String) 

    /**
     * Sets the value of field 'dtDtEmpLastAssigned'.
     * 
     * @param dtDtEmpLastAssigned the value of field
     * 'dtDtEmpLastAssigned'.
     */
    public void setDtDtEmpLastAssigned(org.exolab.castor.types.Date dtDtEmpLastAssigned)
    {
        this._dtDtEmpLastAssigned = dtDtEmpLastAssigned;
    } //-- void setDtDtEmpLastAssigned(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'lNbrPhoneExtension'.
     * 
     * @param lNbrPhoneExtension the value of field
     * 'lNbrPhoneExtension'.
     */
    public void setLNbrPhoneExtension(java.lang.String lNbrPhoneExtension)
    {
        this._lNbrPhoneExtension = lNbrPhoneExtension;
    } //-- void setLNbrPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'lSysNbrPersPhnHome'.
     * 
     * @param lSysNbrPersPhnHome the value of field
     * 'lSysNbrPersPhnHome'.
     */
    public void setLSysNbrPersPhnHome(java.lang.String lSysNbrPersPhnHome)
    {
        this._lSysNbrPersPhnHome = lSysNbrPersPhnHome;
    } //-- void setLSysNbrPersPhnHome(java.lang.String) 

    /**
     * Sets the value of field 'lSysNbrPersPhoneWork'.
     * 
     * @param lSysNbrPersPhoneWork the value of field
     * 'lSysNbrPersPhoneWork'.
     */
    public void setLSysNbrPersPhoneWork(java.lang.String lSysNbrPersPhoneWork)
    {
        this._lSysNbrPersPhoneWork = lSysNbrPersPhoneWork;
    } //-- void setLSysNbrPersPhoneWork(java.lang.String) 

    /**
     * Sets the value of field 'szAddrMailCode'.
     * 
     * @param szAddrMailCode the value of field 'szAddrMailCode'.
     */
    public void setSzAddrMailCode(java.lang.String szAddrMailCode)
    {
        this._szAddrMailCode = szAddrMailCode;
    } //-- void setSzAddrMailCode(java.lang.String) 

    /**
     * Sets the value of field 'szBjnJob'.
     * 
     * @param szBjnJob the value of field 'szBjnJob'.
     */
    public void setSzBjnJob(java.lang.String szBjnJob)
    {
        this._szBjnJob = szBjnJob;
    } //-- void setSzBjnJob(java.lang.String) 

    /**
     * Sets the value of field 'szCdEmpProgram'.
     * 
     * @param szCdEmpProgram the value of field 'szCdEmpProgram'.
     */
    public void setSzCdEmpProgram(java.lang.String szCdEmpProgram)
    {
        this._szCdEmpProgram = szCdEmpProgram;
    } //-- void setSzCdEmpProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdEmployeeClass'.
     * 
     * @param szCdEmployeeClass the value of field
     * 'szCdEmployeeClass'.
     */
    public void setSzCdEmployeeClass(java.lang.String szCdEmployeeClass)
    {
        this._szCdEmployeeClass = szCdEmployeeClass;
    } //-- void setSzCdEmployeeClass(java.lang.String) 

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
     * Sets the value of field 'szCdOfficeCounty'.
     * 
     * @param szCdOfficeCounty the value of field 'szCdOfficeCounty'
     */
    public void setSzCdOfficeCounty(java.lang.String szCdOfficeCounty)
    {
        this._szCdOfficeCounty = szCdOfficeCounty;
    } //-- void setSzCdOfficeCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPhoneType'.
     * 
     * @param szCdPhoneType the value of field 'szCdPhoneType'.
     */
    public void setSzCdPhoneType(java.lang.String szCdPhoneType)
    {
        this._szCdPhoneType = szCdPhoneType;
    } //-- void setSzCdPhoneType(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitCounty'.
     * 
     * @param szCdUnitCounty the value of field 'szCdUnitCounty'.
     */
    public void setSzCdUnitCounty(java.lang.String szCdUnitCounty)
    {
        this._szCdUnitCounty = szCdUnitCounty;
    } //-- void setSzCdUnitCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitRegion'.
     * 
     * @param szCdUnitRegion the value of field 'szCdUnitRegion'.
     */
    public void setSzCdUnitRegion(java.lang.String szCdUnitRegion)
    {
        this._szCdUnitRegion = szCdUnitRegion;
    } //-- void setSzCdUnitRegion(java.lang.String) 

    /**
     * Sets the value of field 'szNbrUnit'.
     * 
     * @param szNbrUnit the value of field 'szNbrUnit'.
     */
    public void setSzNbrUnit(java.lang.String szNbrUnit)
    {
        this._szNbrUnit = szNbrUnit;
    } //-- void setSzNbrUnit(java.lang.String) 

    /**
     * Sets the value of field 'szNmOfficeName'.
     * 
     * @param szNmOfficeName the value of field 'szNmOfficeName'.
     */
    public void setSzNmOfficeName(java.lang.String szNmOfficeName)
    {
        this._szNmOfficeName = szNmOfficeName;
    } //-- void setSzNmOfficeName(java.lang.String) 

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
     * Sets the value of field 'szTextErsNumber'.
     * 
     * @param szTextErsNumber the value of field 'szTextErsNumber'.
     */
    public void setSzTextErsNumber(java.lang.String szTextErsNumber)
    {
        this._szTextErsNumber = szTextErsNumber;
    } //-- void setSzTextErsNumber(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmEmpLastAssigned'.
     * 
     * @param tmScrTmEmpLastAssigned the value of field
     * 'tmScrTmEmpLastAssigned'.
     */
    public void setTmScrTmEmpLastAssigned(java.lang.String tmScrTmEmpLastAssigned)
    {
        this._tmScrTmEmpLastAssigned = tmScrTmEmpLastAssigned;
    } //-- void setTmScrTmEmpLastAssigned(java.lang.String) 

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
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO unmarshal(java.io.Reader) 

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
