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
 * Class CARC01SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CARC01SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szIdEmployeeLogon
     */
    private java.lang.String _szIdEmployeeLogon;

    /**
     * Field _szTxtSecurityClassProfil
     */
    private java.lang.String _szTxtSecurityClassProfil;

    /**
     * Field _cdSecurityClassName
     */
    private java.lang.String _cdSecurityClassName;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szCdUnitRegion
     */
    private java.lang.String _szCdUnitRegion;

    /**
     * Field _ulIdOffice
     */
    private int _ulIdOffice;

    /**
     * keeps track of state for field: _ulIdOffice
     */
    private boolean _has_ulIdOffice;

    /**
     * Field _szAddrMailCodeCity
     */
    private java.lang.String _szAddrMailCodeCity;

    /**
     * Field _szNbrUnit
     */
    private java.lang.String _szNbrUnit;

    /**
     * Field _szCdUnitProgram
     */
    private java.lang.String _szCdUnitProgram;

    /**
     * Field _szCdUnitCounty
     */
    private java.lang.String _szCdUnitCounty;

    /**
     * Field _szCdEmployeeClass
     */
    private java.lang.String _szCdEmployeeClass;

    /**
     * Field _ROWCARC01SO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY _ROWCARC01SO_ARRAY;

    /**
     * Field _ROWCARC01S1_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY _ROWCARC01S1_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CARC01SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdOffice()
    {
        this._has_ulIdOffice= false;
    } //-- void deleteUlIdOffice() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'cdSecurityClassName'.
     * 
     * @return the value of field 'CdSecurityClassName'.
     */
    public java.lang.String getCdSecurityClassName()
    {
        return this._cdSecurityClassName;
    } //-- java.lang.String getCdSecurityClassName() 

    /**
     * Returns the value of field 'ROWCARC01S1_ARRAY'.
     * 
     * @return the value of field 'ROWCARC01S1_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY getROWCARC01S1_ARRAY()
    {
        return this._ROWCARC01S1_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY getROWCARC01S1_ARRAY() 

    /**
     * Returns the value of field 'ROWCARC01SO_ARRAY'.
     * 
     * @return the value of field 'ROWCARC01SO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY getROWCARC01SO_ARRAY()
    {
        return this._ROWCARC01SO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY getROWCARC01SO_ARRAY() 

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
     * Returns the value of field 'szCdEmployeeClass'.
     * 
     * @return the value of field 'SzCdEmployeeClass'.
     */
    public java.lang.String getSzCdEmployeeClass()
    {
        return this._szCdEmployeeClass;
    } //-- java.lang.String getSzCdEmployeeClass() 

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
     * Returns the value of field 'szIdEmployeeLogon'.
     * 
     * @return the value of field 'SzIdEmployeeLogon'.
     */
    public java.lang.String getSzIdEmployeeLogon()
    {
        return this._szIdEmployeeLogon;
    } //-- java.lang.String getSzIdEmployeeLogon() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szTxtSecurityClassProfil'.
     * 
     * @return the value of field 'SzTxtSecurityClassProfil'.
     */
    public java.lang.String getSzTxtSecurityClassProfil()
    {
        return this._szTxtSecurityClassProfil;
    } //-- java.lang.String getSzTxtSecurityClassProfil() 

    /**
     * Returns the value of field 'ulIdOffice'.
     * 
     * @return the value of field 'UlIdOffice'.
     */
    public int getUlIdOffice()
    {
        return this._ulIdOffice;
    } //-- int getUlIdOffice() 

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
     * Method hasUlIdOffice
     * 
     * 
     * 
     * @return true if at least one UlIdOffice has been added
     */
    public boolean hasUlIdOffice()
    {
        return this._has_ulIdOffice;
    } //-- boolean hasUlIdOffice() 

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
     * Sets the value of field 'cdSecurityClassName'.
     * 
     * @param cdSecurityClassName the value of field
     * 'cdSecurityClassName'.
     */
    public void setCdSecurityClassName(java.lang.String cdSecurityClassName)
    {
        this._cdSecurityClassName = cdSecurityClassName;
    } //-- void setCdSecurityClassName(java.lang.String) 

    /**
     * Sets the value of field 'ROWCARC01S1_ARRAY'.
     * 
     * @param ROWCARC01S1_ARRAY the value of field
     * 'ROWCARC01S1_ARRAY'.
     */
    public void setROWCARC01S1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY ROWCARC01S1_ARRAY)
    {
        this._ROWCARC01S1_ARRAY = ROWCARC01S1_ARRAY;
    } //-- void setROWCARC01S1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY) 

    /**
     * Sets the value of field 'ROWCARC01SO_ARRAY'.
     * 
     * @param ROWCARC01SO_ARRAY the value of field
     * 'ROWCARC01SO_ARRAY'.
     */
    public void setROWCARC01SO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY ROWCARC01SO_ARRAY)
    {
        this._ROWCARC01SO_ARRAY = ROWCARC01SO_ARRAY;
    } //-- void setROWCARC01SO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY) 

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
     * Sets the value of field 'szCdUnitCounty'.
     * 
     * @param szCdUnitCounty the value of field 'szCdUnitCounty'.
     */
    public void setSzCdUnitCounty(java.lang.String szCdUnitCounty)
    {
        this._szCdUnitCounty = szCdUnitCounty;
    } //-- void setSzCdUnitCounty(java.lang.String) 

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
     * Sets the value of field 'szIdEmployeeLogon'.
     * 
     * @param szIdEmployeeLogon the value of field
     * 'szIdEmployeeLogon'.
     */
    public void setSzIdEmployeeLogon(java.lang.String szIdEmployeeLogon)
    {
        this._szIdEmployeeLogon = szIdEmployeeLogon;
    } //-- void setSzIdEmployeeLogon(java.lang.String) 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSecurityClassProfil'.
     * 
     * @param szTxtSecurityClassProfil the value of field
     * 'szTxtSecurityClassProfil'.
     */
    public void setSzTxtSecurityClassProfil(java.lang.String szTxtSecurityClassProfil)
    {
        this._szTxtSecurityClassProfil = szTxtSecurityClassProfil;
    } //-- void setSzTxtSecurityClassProfil(java.lang.String) 

    /**
     * Sets the value of field 'ulIdOffice'.
     * 
     * @param ulIdOffice the value of field 'ulIdOffice'.
     */
    public void setUlIdOffice(int ulIdOffice)
    {
        this._ulIdOffice = ulIdOffice;
        this._has_ulIdOffice = true;
    } //-- void setUlIdOffice(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO unmarshal(java.io.Reader) 

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
