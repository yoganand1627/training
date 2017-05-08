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
 * Class CFAD07SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD07SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szTxtSchDistName
     */
    private java.lang.String _szTxtSchDistName;

    /**
     * Field _bIndEndDateMod
     */
    private java.lang.String _bIndEndDateMod;

    /**
     * Field _dtSysDtGenericSysdate
     */
    private org.exolab.castor.types.Date _dtSysDtGenericSysdate;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szApprovalStatus
     */
    private java.lang.String _szApprovalStatus;

    /**
     * Field _ROWCFAD07SOG04
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04 _ROWCFAD07SOG04;

    /**
     * Field _ROWCFAD07SOG05
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05 _ROWCFAD07SOG05;

    /**
     * Field _ROWCFAD07SOG06
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG06 _ROWCFAD07SOG06;

    /**
     * Field _ROWCFAD07SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY _ROWCFAD07SOG01_ARRAY;

    /**
     * Field _ROWCFAD07SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY _ROWCFAD07SOG02_ARRAY;

    /**
     * Field _ROWCFAD07SOG03_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY _ROWCFAD07SOG03_ARRAY;

    /**
     * Field _homeRaceSO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY _homeRaceSO_ARRAY;

    /**
     * Field _ROWCFAD07SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY _ROWCFAD07SOG00_ARRAY;

    /**
     * Field _ROWCFAD07SOG07_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY _ROWCFAD07SOG07_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD07SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

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
     * Returns the value of field 'bIndEndDateMod'.
     * 
     * @return the value of field 'BIndEndDateMod'.
     */
    public java.lang.String getBIndEndDateMod()
    {
        return this._bIndEndDateMod;
    } //-- java.lang.String getBIndEndDateMod() 

    /**
     * Returns the value of field 'dtSysDtGenericSysdate'.
     * 
     * @return the value of field 'DtSysDtGenericSysdate'.
     */
    public org.exolab.castor.types.Date getDtSysDtGenericSysdate()
    {
        return this._dtSysDtGenericSysdate;
    } //-- org.exolab.castor.types.Date getDtSysDtGenericSysdate() 

    /**
     * Returns the value of field 'homeRaceSO_ARRAY'.
     * 
     * @return the value of field 'HomeRaceSO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY getHomeRaceSO_ARRAY()
    {
        return this._homeRaceSO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY getHomeRaceSO_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD07SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD07SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY getROWCFAD07SOG00_ARRAY()
    {
        return this._ROWCFAD07SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY getROWCFAD07SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD07SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD07SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY getROWCFAD07SOG01_ARRAY()
    {
        return this._ROWCFAD07SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY getROWCFAD07SOG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD07SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD07SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY getROWCFAD07SOG02_ARRAY()
    {
        return this._ROWCFAD07SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY getROWCFAD07SOG02_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD07SOG03_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD07SOG03_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY getROWCFAD07SOG03_ARRAY()
    {
        return this._ROWCFAD07SOG03_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY getROWCFAD07SOG03_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD07SOG04'.
     * 
     * @return the value of field 'ROWCFAD07SOG04'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04 getROWCFAD07SOG04()
    {
        return this._ROWCFAD07SOG04;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04 getROWCFAD07SOG04() 

    /**
     * Returns the value of field 'ROWCFAD07SOG05'.
     * 
     * @return the value of field 'ROWCFAD07SOG05'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05 getROWCFAD07SOG05()
    {
        return this._ROWCFAD07SOG05;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05 getROWCFAD07SOG05() 

    /**
     * Returns the value of field 'ROWCFAD07SOG06'.
     * 
     * @return the value of field 'ROWCFAD07SOG06'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG06 getROWCFAD07SOG06()
    {
        return this._ROWCFAD07SOG06;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG06 getROWCFAD07SOG06() 

    /**
     * Returns the value of field 'ROWCFAD07SOG07_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD07SOG07_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY getROWCFAD07SOG07_ARRAY()
    {
        return this._ROWCFAD07SOG07_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY getROWCFAD07SOG07_ARRAY() 

    /**
     * Returns the value of field 'szApprovalStatus'.
     * 
     * @return the value of field 'SzApprovalStatus'.
     */
    public java.lang.String getSzApprovalStatus()
    {
        return this._szApprovalStatus;
    } //-- java.lang.String getSzApprovalStatus() 

    /**
     * Returns the value of field 'szTxtSchDistName'.
     * 
     * @return the value of field 'SzTxtSchDistName'.
     */
    public java.lang.String getSzTxtSchDistName()
    {
        return this._szTxtSchDistName;
    } //-- java.lang.String getSzTxtSchDistName() 

    /**
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

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
     * Sets the value of field 'bIndEndDateMod'.
     * 
     * @param bIndEndDateMod the value of field 'bIndEndDateMod'.
     */
    public void setBIndEndDateMod(java.lang.String bIndEndDateMod)
    {
        this._bIndEndDateMod = bIndEndDateMod;
    } //-- void setBIndEndDateMod(java.lang.String) 

    /**
     * Sets the value of field 'dtSysDtGenericSysdate'.
     * 
     * @param dtSysDtGenericSysdate the value of field
     * 'dtSysDtGenericSysdate'.
     */
    public void setDtSysDtGenericSysdate(org.exolab.castor.types.Date dtSysDtGenericSysdate)
    {
        this._dtSysDtGenericSysdate = dtSysDtGenericSysdate;
    } //-- void setDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'homeRaceSO_ARRAY'.
     * 
     * @param homeRaceSO_ARRAY the value of field 'homeRaceSO_ARRAY'
     */
    public void setHomeRaceSO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY homeRaceSO_ARRAY)
    {
        this._homeRaceSO_ARRAY = homeRaceSO_ARRAY;
    } //-- void setHomeRaceSO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD07SOG00_ARRAY'.
     * 
     * @param ROWCFAD07SOG00_ARRAY the value of field
     * 'ROWCFAD07SOG00_ARRAY'.
     */
    public void setROWCFAD07SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY ROWCFAD07SOG00_ARRAY)
    {
        this._ROWCFAD07SOG00_ARRAY = ROWCFAD07SOG00_ARRAY;
    } //-- void setROWCFAD07SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD07SOG01_ARRAY'.
     * 
     * @param ROWCFAD07SOG01_ARRAY the value of field
     * 'ROWCFAD07SOG01_ARRAY'.
     */
    public void setROWCFAD07SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY ROWCFAD07SOG01_ARRAY)
    {
        this._ROWCFAD07SOG01_ARRAY = ROWCFAD07SOG01_ARRAY;
    } //-- void setROWCFAD07SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD07SOG02_ARRAY'.
     * 
     * @param ROWCFAD07SOG02_ARRAY the value of field
     * 'ROWCFAD07SOG02_ARRAY'.
     */
    public void setROWCFAD07SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY ROWCFAD07SOG02_ARRAY)
    {
        this._ROWCFAD07SOG02_ARRAY = ROWCFAD07SOG02_ARRAY;
    } //-- void setROWCFAD07SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG02_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD07SOG03_ARRAY'.
     * 
     * @param ROWCFAD07SOG03_ARRAY the value of field
     * 'ROWCFAD07SOG03_ARRAY'.
     */
    public void setROWCFAD07SOG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY ROWCFAD07SOG03_ARRAY)
    {
        this._ROWCFAD07SOG03_ARRAY = ROWCFAD07SOG03_ARRAY;
    } //-- void setROWCFAD07SOG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG03_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD07SOG04'.
     * 
     * @param ROWCFAD07SOG04 the value of field 'ROWCFAD07SOG04'.
     */
    public void setROWCFAD07SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04 ROWCFAD07SOG04)
    {
        this._ROWCFAD07SOG04 = ROWCFAD07SOG04;
    } //-- void setROWCFAD07SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG04) 

    /**
     * Sets the value of field 'ROWCFAD07SOG05'.
     * 
     * @param ROWCFAD07SOG05 the value of field 'ROWCFAD07SOG05'.
     */
    public void setROWCFAD07SOG05(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05 ROWCFAD07SOG05)
    {
        this._ROWCFAD07SOG05 = ROWCFAD07SOG05;
    } //-- void setROWCFAD07SOG05(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05) 

    /**
     * Sets the value of field 'ROWCFAD07SOG06'.
     * 
     * @param ROWCFAD07SOG06 the value of field 'ROWCFAD07SOG06'.
     */
    public void setROWCFAD07SOG06(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG06 ROWCFAD07SOG06)
    {
        this._ROWCFAD07SOG06 = ROWCFAD07SOG06;
    } //-- void setROWCFAD07SOG06(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG06) 

    /**
     * Sets the value of field 'ROWCFAD07SOG07_ARRAY'.
     * 
     * @param ROWCFAD07SOG07_ARRAY the value of field
     * 'ROWCFAD07SOG07_ARRAY'.
     */
    public void setROWCFAD07SOG07_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY ROWCFAD07SOG07_ARRAY)
    {
        this._ROWCFAD07SOG07_ARRAY = ROWCFAD07SOG07_ARRAY;
    } //-- void setROWCFAD07SOG07_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG07_ARRAY) 

    /**
     * Sets the value of field 'szApprovalStatus'.
     * 
     * @param szApprovalStatus the value of field 'szApprovalStatus'
     */
    public void setSzApprovalStatus(java.lang.String szApprovalStatus)
    {
        this._szApprovalStatus = szApprovalStatus;
    } //-- void setSzApprovalStatus(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSchDistName'.
     * 
     * @param szTxtSchDistName the value of field 'szTxtSchDistName'
     */
    public void setSzTxtSchDistName(java.lang.String szTxtSchDistName)
    {
        this._szTxtSchDistName = szTxtSchDistName;
    } //-- void setSzTxtSchDistName(java.lang.String) 

    /**
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO unmarshal(java.io.Reader) 

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
