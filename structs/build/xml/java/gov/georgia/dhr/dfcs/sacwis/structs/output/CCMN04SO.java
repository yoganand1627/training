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
 * Class CCMN04SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN04SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CCMN04SOG08_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY _CCMN04SOG08_ARRAY;

    /**
     * Field _CCMN04SOG07_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY _CCMN04SOG07_ARRAY;

    /**
     * Field _ROWCCMN04SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00 _ROWCCMN04SOG00;

    /**
     * Field _ROWCCMN04SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01 _ROWCCMN04SOG01;

    /**
     * Field _ROWCCMN04SOG04
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04 _ROWCCMN04SOG04;

    /**
     * Field _ROWCCMN04SOG05
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05 _ROWCCMN04SOG05;

    /**
     * Field _ROWCCMN04SOG06
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06 _ROWCCMN04SOG06;

    /**
     * Field _ROWCCMN04SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY _ROWCCMN04SOG02_ARRAY;

    /**
     * Field _ROWCCMN04SOG03_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG03_ARRAY _ROWCCMN04SOG03_ARRAY;

    /**
     * Field _szAddrMailCode
     */
    private java.lang.String _szAddrMailCode;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _ulIdOffice
     */
    private int _ulIdOffice;

    /**
     * keeps track of state for field: _ulIdOffice
     */
    private boolean _has_ulIdOffice;

    /**
     * Field _szNmOfficeName
     */
    private java.lang.String _szNmOfficeName;

    /**
     * Field _szCdOfficeLocation
     */
    private java.lang.String _szCdOfficeLocation;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _ROWCCMN04SOG02
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 _ROWCCMN04SOG02;

    /**
     * Field _szAddrMailCodeCity
     */
    private java.lang.String _szAddrMailCodeCity;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN04SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO()


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
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'CCMN04SOG07_ARRAY'.
     * 
     * @return the value of field 'CCMN04SOG07_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY getCCMN04SOG07_ARRAY()
    {
        return this._CCMN04SOG07_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY getCCMN04SOG07_ARRAY() 

    /**
     * Returns the value of field 'CCMN04SOG08_ARRAY'.
     * 
     * @return the value of field 'CCMN04SOG08_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY getCCMN04SOG08_ARRAY()
    {
        return this._CCMN04SOG08_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY getCCMN04SOG08_ARRAY() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'ROWCCMN04SOG00'.
     * 
     * @return the value of field 'ROWCCMN04SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00 getROWCCMN04SOG00()
    {
        return this._ROWCCMN04SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00 getROWCCMN04SOG00() 

    /**
     * Returns the value of field 'ROWCCMN04SOG01'.
     * 
     * @return the value of field 'ROWCCMN04SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01 getROWCCMN04SOG01()
    {
        return this._ROWCCMN04SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01 getROWCCMN04SOG01() 

    /**
     * Returns the value of field 'ROWCCMN04SOG02'.
     * 
     * @return the value of field 'ROWCCMN04SOG02'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 getROWCCMN04SOG02()
    {
        return this._ROWCCMN04SOG02;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 getROWCCMN04SOG02() 

    /**
     * Returns the value of field 'ROWCCMN04SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN04SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY getROWCCMN04SOG02_ARRAY()
    {
        return this._ROWCCMN04SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY getROWCCMN04SOG02_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN04SOG03_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN04SOG03_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG03_ARRAY getROWCCMN04SOG03_ARRAY()
    {
        return this._ROWCCMN04SOG03_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG03_ARRAY getROWCCMN04SOG03_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN04SOG04'.
     * 
     * @return the value of field 'ROWCCMN04SOG04'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04 getROWCCMN04SOG04()
    {
        return this._ROWCCMN04SOG04;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04 getROWCCMN04SOG04() 

    /**
     * Returns the value of field 'ROWCCMN04SOG05'.
     * 
     * @return the value of field 'ROWCCMN04SOG05'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05 getROWCCMN04SOG05()
    {
        return this._ROWCCMN04SOG05;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05 getROWCCMN04SOG05() 

    /**
     * Returns the value of field 'ROWCCMN04SOG06'.
     * 
     * @return the value of field 'ROWCCMN04SOG06'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06 getROWCCMN04SOG06()
    {
        return this._ROWCCMN04SOG06;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06 getROWCCMN04SOG06() 

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
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

    /**
     * Returns the value of field 'szCdOfficeLocation'.
     * 
     * @return the value of field 'SzCdOfficeLocation'.
     */
    public java.lang.String getSzCdOfficeLocation()
    {
        return this._szCdOfficeLocation;
    } //-- java.lang.String getSzCdOfficeLocation() 

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
     * Returns the value of field 'ulIdOffice'.
     * 
     * @return the value of field 'UlIdOffice'.
     */
    public int getUlIdOffice()
    {
        return this._ulIdOffice;
    } //-- int getUlIdOffice() 

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
     * Sets the value of field 'CCMN04SOG07_ARRAY'.
     * 
     * @param CCMN04SOG07_ARRAY the value of field
     * 'CCMN04SOG07_ARRAY'.
     */
    public void setCCMN04SOG07_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY CCMN04SOG07_ARRAY)
    {
        this._CCMN04SOG07_ARRAY = CCMN04SOG07_ARRAY;
    } //-- void setCCMN04SOG07_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY) 

    /**
     * Sets the value of field 'CCMN04SOG08_ARRAY'.
     * 
     * @param CCMN04SOG08_ARRAY the value of field
     * 'CCMN04SOG08_ARRAY'.
     */
    public void setCCMN04SOG08_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY CCMN04SOG08_ARRAY)
    {
        this._CCMN04SOG08_ARRAY = CCMN04SOG08_ARRAY;
    } //-- void setCCMN04SOG08_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN04SOG00'.
     * 
     * @param ROWCCMN04SOG00 the value of field 'ROWCCMN04SOG00'.
     */
    public void setROWCCMN04SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00 ROWCCMN04SOG00)
    {
        this._ROWCCMN04SOG00 = ROWCCMN04SOG00;
    } //-- void setROWCCMN04SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00) 

    /**
     * Sets the value of field 'ROWCCMN04SOG01'.
     * 
     * @param ROWCCMN04SOG01 the value of field 'ROWCCMN04SOG01'.
     */
    public void setROWCCMN04SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01 ROWCCMN04SOG01)
    {
        this._ROWCCMN04SOG01 = ROWCCMN04SOG01;
    } //-- void setROWCCMN04SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01) 

    /**
     * Sets the value of field 'ROWCCMN04SOG02'.
     * 
     * @param ROWCCMN04SOG02 the value of field 'ROWCCMN04SOG02'.
     */
    public void setROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 ROWCCMN04SOG02)
    {
        this._ROWCCMN04SOG02 = ROWCCMN04SOG02;
    } //-- void setROWCCMN04SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) 

    /**
     * Sets the value of field 'ROWCCMN04SOG02_ARRAY'.
     * 
     * @param ROWCCMN04SOG02_ARRAY the value of field
     * 'ROWCCMN04SOG02_ARRAY'.
     */
    public void setROWCCMN04SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY ROWCCMN04SOG02_ARRAY)
    {
        this._ROWCCMN04SOG02_ARRAY = ROWCCMN04SOG02_ARRAY;
    } //-- void setROWCCMN04SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN04SOG03_ARRAY'.
     * 
     * @param ROWCCMN04SOG03_ARRAY the value of field
     * 'ROWCCMN04SOG03_ARRAY'.
     */
    public void setROWCCMN04SOG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG03_ARRAY ROWCCMN04SOG03_ARRAY)
    {
        this._ROWCCMN04SOG03_ARRAY = ROWCCMN04SOG03_ARRAY;
    } //-- void setROWCCMN04SOG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG03_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN04SOG04'.
     * 
     * @param ROWCCMN04SOG04 the value of field 'ROWCCMN04SOG04'.
     */
    public void setROWCCMN04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04 ROWCCMN04SOG04)
    {
        this._ROWCCMN04SOG04 = ROWCCMN04SOG04;
    } //-- void setROWCCMN04SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04) 

    /**
     * Sets the value of field 'ROWCCMN04SOG05'.
     * 
     * @param ROWCCMN04SOG05 the value of field 'ROWCCMN04SOG05'.
     */
    public void setROWCCMN04SOG05(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05 ROWCCMN04SOG05)
    {
        this._ROWCCMN04SOG05 = ROWCCMN04SOG05;
    } //-- void setROWCCMN04SOG05(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05) 

    /**
     * Sets the value of field 'ROWCCMN04SOG06'.
     * 
     * @param ROWCCMN04SOG06 the value of field 'ROWCCMN04SOG06'.
     */
    public void setROWCCMN04SOG06(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06 ROWCCMN04SOG06)
    {
        this._ROWCCMN04SOG06 = ROWCCMN04SOG06;
    } //-- void setROWCCMN04SOG06(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06) 

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
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdOfficeLocation'.
     * 
     * @param szCdOfficeLocation the value of field
     * 'szCdOfficeLocation'.
     */
    public void setSzCdOfficeLocation(java.lang.String szCdOfficeLocation)
    {
        this._szCdOfficeLocation = szCdOfficeLocation;
    } //-- void setSzCdOfficeLocation(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO unmarshal(java.io.Reader) 

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
