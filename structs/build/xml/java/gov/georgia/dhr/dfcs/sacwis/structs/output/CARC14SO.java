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
 * Class CARC14SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CARC14SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _szCdEmpSecurityClassNm
     */
    private java.lang.String _szCdEmpSecurityClassNm;

    /**
     * Field _szIdEmployeeLogon
     */
    private java.lang.String _szIdEmployeeLogon;

    /**
     * Field _ulRowQty2
     */
    private int _ulRowQty2;

    /**
     * keeps track of state for field: _ulRowQty2
     */
    private boolean _has_ulRowQty2;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _ROWCARC14SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY _ROWCARC14SOG00_ARRAY;

    /**
     * Field _ROWCARC14SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY _ROWCARC14SOG01_ARRAY;

    /**
     * Field _ROWCARC14SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY _ROWCARC14SOG02_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CARC14SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     */
    public void deleteUlRowQty2()
    {
        this._has_ulRowQty2= false;
    } //-- void deleteUlRowQty2() 

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
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'ROWCARC14SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCARC14SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY getROWCARC14SOG00_ARRAY()
    {
        return this._ROWCARC14SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY getROWCARC14SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCARC14SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCARC14SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY getROWCARC14SOG01_ARRAY()
    {
        return this._ROWCARC14SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY getROWCARC14SOG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCARC14SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCARC14SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY getROWCARC14SOG02_ARRAY()
    {
        return this._ROWCARC14SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY getROWCARC14SOG02_ARRAY() 

    /**
     * Returns the value of field 'szCdEmpSecurityClassNm'.
     * 
     * @return the value of field 'SzCdEmpSecurityClassNm'.
     */
    public java.lang.String getSzCdEmpSecurityClassNm()
    {
        return this._szCdEmpSecurityClassNm;
    } //-- java.lang.String getSzCdEmpSecurityClassNm() 

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
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Returns the value of field 'ulRowQty2'.
     * 
     * @return the value of field 'UlRowQty2'.
     */
    public int getUlRowQty2()
    {
        return this._ulRowQty2;
    } //-- int getUlRowQty2() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

    /**
     * Method hasUlRowQty2
     * 
     * 
     * 
     * @return true if at least one UlRowQty2 has been added
     */
    public boolean hasUlRowQty2()
    {
        return this._has_ulRowQty2;
    } //-- boolean hasUlRowQty2() 

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
     * Sets the value of field 'ROWCARC14SOG00_ARRAY'.
     * 
     * @param ROWCARC14SOG00_ARRAY the value of field
     * 'ROWCARC14SOG00_ARRAY'.
     */
    public void setROWCARC14SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY ROWCARC14SOG00_ARRAY)
    {
        this._ROWCARC14SOG00_ARRAY = ROWCARC14SOG00_ARRAY;
    } //-- void setROWCARC14SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCARC14SOG01_ARRAY'.
     * 
     * @param ROWCARC14SOG01_ARRAY the value of field
     * 'ROWCARC14SOG01_ARRAY'.
     */
    public void setROWCARC14SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY ROWCARC14SOG01_ARRAY)
    {
        this._ROWCARC14SOG01_ARRAY = ROWCARC14SOG01_ARRAY;
    } //-- void setROWCARC14SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCARC14SOG02_ARRAY'.
     * 
     * @param ROWCARC14SOG02_ARRAY the value of field
     * 'ROWCARC14SOG02_ARRAY'.
     */
    public void setROWCARC14SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY ROWCARC14SOG02_ARRAY)
    {
        this._ROWCARC14SOG02_ARRAY = ROWCARC14SOG02_ARRAY;
    } //-- void setROWCARC14SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY) 

    /**
     * Sets the value of field 'szCdEmpSecurityClassNm'.
     * 
     * @param szCdEmpSecurityClassNm the value of field
     * 'szCdEmpSecurityClassNm'.
     */
    public void setSzCdEmpSecurityClassNm(java.lang.String szCdEmpSecurityClassNm)
    {
        this._szCdEmpSecurityClassNm = szCdEmpSecurityClassNm;
    } //-- void setSzCdEmpSecurityClassNm(java.lang.String) 

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
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

    /**
     * Sets the value of field 'ulRowQty2'.
     * 
     * @param ulRowQty2 the value of field 'ulRowQty2'.
     */
    public void setUlRowQty2(int ulRowQty2)
    {
        this._ulRowQty2 = ulRowQty2;
        this._has_ulRowQty2 = true;
    } //-- void setUlRowQty2(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO unmarshal(java.io.Reader) 

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
