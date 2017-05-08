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
 * Class StfSrchCrtInStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StfSrchCrtInStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmNameLast
     */
    private java.lang.String _szNmNameLast;

    /**
     * Field _szNmNameFirst
     */
    private java.lang.String _szNmNameFirst;

    /**
     * Field _szNmNameMiddle
     */
    private java.lang.String _szNmNameMiddle;

    /**
     * Field _szCdUnitRegion
     */
    private java.lang.String _szCdUnitRegion;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _cScrIndActive
     */
    private java.lang.String _cScrIndActive;

    /**
     * Field _szCdEmpSkill
     */
    private java.lang.String _szCdEmpSkill;

    /**
     * Field _szCdUnitSpecialization
     */
    private java.lang.String _szCdUnitSpecialization;

    /**
     * Field _szCdUnitProgram
     */
    private java.lang.String _szCdUnitProgram;

    /**
     * Field _bIndJobAssignable
     */
    private java.lang.String _bIndJobAssignable;

    /**
     * Field _bIndCaseAssignable
     */
    private java.lang.String _bIndCaseAssignable;

    /**
     * Field _szAddrMailCodeCity
     */
    private java.lang.String _szAddrMailCodeCity;

    /**
     * Field _szCdOfficeCounty
     */
    private java.lang.String _szCdOfficeCounty;

    /**
     * Field _szNbrPersonIdNumber
     */
    private java.lang.String _szNbrPersonIdNumber;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

    /**
     * Field _szAddrMailCode
     */
    private java.lang.String _szAddrMailCode;

    /**
     * Field _szNmOfficeName
     */
    private java.lang.String _szNmOfficeName;


      //----------------/
     //- Constructors -/
    //----------------/

    public StfSrchCrtInStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct()


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
     * Returns the value of field 'bIndCaseAssignable'.
     * 
     * @return the value of field 'BIndCaseAssignable'.
     */
    public java.lang.String getBIndCaseAssignable()
    {
        return this._bIndCaseAssignable;
    } //-- java.lang.String getBIndCaseAssignable() 

    /**
     * Returns the value of field 'bIndJobAssignable'.
     * 
     * @return the value of field 'BIndJobAssignable'.
     */
    public java.lang.String getBIndJobAssignable()
    {
        return this._bIndJobAssignable;
    } //-- java.lang.String getBIndJobAssignable() 

    /**
     * Returns the value of field 'cScrIndActive'.
     * 
     * @return the value of field 'CScrIndActive'.
     */
    public java.lang.String getCScrIndActive()
    {
        return this._cScrIndActive;
    } //-- java.lang.String getCScrIndActive() 

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
     * Returns the value of field 'szAddrMailCodeCity'.
     * 
     * @return the value of field 'SzAddrMailCodeCity'.
     */
    public java.lang.String getSzAddrMailCodeCity()
    {
        return this._szAddrMailCodeCity;
    } //-- java.lang.String getSzAddrMailCodeCity() 

    /**
     * Returns the value of field 'szCdEmpSkill'.
     * 
     * @return the value of field 'SzCdEmpSkill'.
     */
    public java.lang.String getSzCdEmpSkill()
    {
        return this._szCdEmpSkill;
    } //-- java.lang.String getSzCdEmpSkill() 

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
     * Returns the value of field 'szCdUnitProgram'.
     * 
     * @return the value of field 'SzCdUnitProgram'.
     */
    public java.lang.String getSzCdUnitProgram()
    {
        return this._szCdUnitProgram;
    } //-- java.lang.String getSzCdUnitProgram() 

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
     * Returns the value of field 'szCdUnitSpecialization'.
     * 
     * @return the value of field 'SzCdUnitSpecialization'.
     */
    public java.lang.String getSzCdUnitSpecialization()
    {
        return this._szCdUnitSpecialization;
    } //-- java.lang.String getSzCdUnitSpecialization() 

    /**
     * Returns the value of field 'szNbrPersonIdNumber'.
     * 
     * @return the value of field 'SzNbrPersonIdNumber'.
     */
    public java.lang.String getSzNbrPersonIdNumber()
    {
        return this._szNbrPersonIdNumber;
    } //-- java.lang.String getSzNbrPersonIdNumber() 

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
     * Returns the value of field 'szNmOfficeName'.
     * 
     * @return the value of field 'SzNmOfficeName'.
     */
    public java.lang.String getSzNmOfficeName()
    {
        return this._szNmOfficeName;
    } //-- java.lang.String getSzNmOfficeName() 

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
     * Sets the value of field 'bIndCaseAssignable'.
     * 
     * @param bIndCaseAssignable the value of field
     * 'bIndCaseAssignable'.
     */
    public void setBIndCaseAssignable(java.lang.String bIndCaseAssignable)
    {
        this._bIndCaseAssignable = bIndCaseAssignable;
    } //-- void setBIndCaseAssignable(java.lang.String) 

    /**
     * Sets the value of field 'bIndJobAssignable'.
     * 
     * @param bIndJobAssignable the value of field
     * 'bIndJobAssignable'.
     */
    public void setBIndJobAssignable(java.lang.String bIndJobAssignable)
    {
        this._bIndJobAssignable = bIndJobAssignable;
    } //-- void setBIndJobAssignable(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndActive'.
     * 
     * @param cScrIndActive the value of field 'cScrIndActive'.
     */
    public void setCScrIndActive(java.lang.String cScrIndActive)
    {
        this._cScrIndActive = cScrIndActive;
    } //-- void setCScrIndActive(java.lang.String) 

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
     * Sets the value of field 'szAddrMailCodeCity'.
     * 
     * @param szAddrMailCodeCity the value of field
     * 'szAddrMailCodeCity'.
     */
    public void setSzAddrMailCodeCity(java.lang.String szAddrMailCodeCity)
    {
        this._szAddrMailCodeCity = szAddrMailCodeCity;
    } //-- void setSzAddrMailCodeCity(java.lang.String) 

    /**
     * Sets the value of field 'szCdEmpSkill'.
     * 
     * @param szCdEmpSkill the value of field 'szCdEmpSkill'.
     */
    public void setSzCdEmpSkill(java.lang.String szCdEmpSkill)
    {
        this._szCdEmpSkill = szCdEmpSkill;
    } //-- void setSzCdEmpSkill(java.lang.String) 

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
     * Sets the value of field 'szCdUnitProgram'.
     * 
     * @param szCdUnitProgram the value of field 'szCdUnitProgram'.
     */
    public void setSzCdUnitProgram(java.lang.String szCdUnitProgram)
    {
        this._szCdUnitProgram = szCdUnitProgram;
    } //-- void setSzCdUnitProgram(java.lang.String) 

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
     * Sets the value of field 'szCdUnitSpecialization'.
     * 
     * @param szCdUnitSpecialization the value of field
     * 'szCdUnitSpecialization'.
     */
    public void setSzCdUnitSpecialization(java.lang.String szCdUnitSpecialization)
    {
        this._szCdUnitSpecialization = szCdUnitSpecialization;
    } //-- void setSzCdUnitSpecialization(java.lang.String) 

    /**
     * Sets the value of field 'szNbrPersonIdNumber'.
     * 
     * @param szNbrPersonIdNumber the value of field
     * 'szNbrPersonIdNumber'.
     */
    public void setSzNbrPersonIdNumber(java.lang.String szNbrPersonIdNumber)
    {
        this._szNbrPersonIdNumber = szNbrPersonIdNumber;
    } //-- void setSzNbrPersonIdNumber(java.lang.String) 

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
     * Sets the value of field 'szNmOfficeName'.
     * 
     * @param szNmOfficeName the value of field 'szNmOfficeName'.
     */
    public void setSzNmOfficeName(java.lang.String szNmOfficeName)
    {
        this._szNmOfficeName = szNmOfficeName;
    } //-- void setSzNmOfficeName(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct unmarshal(java.io.Reader) 

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
