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
 * Class CCON22SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON22SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtStageStart
     */
    private org.exolab.castor.types.Date _dtDtStageStart;

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _dtDtSituationOpened
     */
    private org.exolab.castor.types.Date _dtDtSituationOpened;

    /**
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _ROWCCON22SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY _ROWCCON22SOG00_ARRAY;

    /**
     * Field _ROWCCON22SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01 _ROWCCON22SOG01;

    /**
     * Field _ROWCCON22SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY _ROWCCON22SOG02_ARRAY;

    /**
     * Field _szSpcSvcAprvAmt
     */
    private double _szSpcSvcAprvAmt;

    /**
     * keeps track of state for field: _szSpcSvcAprvAmt
     */
    private boolean _has_szSpcSvcAprvAmt;

    /**
     * Field _szCdSplServType
     */
    private java.lang.String _szCdSplServType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON22SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSzSpcSvcAprvAmt()
    {
        this._has_szSpcSvcAprvAmt= false;
    } //-- void deleteSzSpcSvcAprvAmt() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

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
     * Returns the value of field 'dtDtSituationOpened'.
     * 
     * @return the value of field 'DtDtSituationOpened'.
     */
    public org.exolab.castor.types.Date getDtDtSituationOpened()
    {
        return this._dtDtSituationOpened;
    } //-- org.exolab.castor.types.Date getDtDtSituationOpened() 

    /**
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'dtDtStageStart'.
     * 
     * @return the value of field 'DtDtStageStart'.
     */
    public org.exolab.castor.types.Date getDtDtStageStart()
    {
        return this._dtDtStageStart;
    } //-- org.exolab.castor.types.Date getDtDtStageStart() 

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
     * Returns the value of field 'ROWCCON22SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCON22SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY getROWCCON22SOG00_ARRAY()
    {
        return this._ROWCCON22SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY getROWCCON22SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCCON22SOG01'.
     * 
     * @return the value of field 'ROWCCON22SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01 getROWCCON22SOG01()
    {
        return this._ROWCCON22SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01 getROWCCON22SOG01() 

    /**
     * Returns the value of field 'ROWCCON22SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCCON22SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY getROWCCON22SOG02_ARRAY()
    {
        return this._ROWCCON22SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY getROWCCON22SOG02_ARRAY() 

    /**
     * Returns the value of field 'szCdSplServType'.
     * 
     * @return the value of field 'SzCdSplServType'.
     */
    public java.lang.String getSzCdSplServType()
    {
        return this._szCdSplServType;
    } //-- java.lang.String getSzCdSplServType() 

    /**
     * Returns the value of field 'szSpcSvcAprvAmt'.
     * 
     * @return the value of field 'SzSpcSvcAprvAmt'.
     */
    public double getSzSpcSvcAprvAmt()
    {
        return this._szSpcSvcAprvAmt;
    } //-- double getSzSpcSvcAprvAmt() 

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
     * Method hasSzSpcSvcAprvAmt
     * 
     * 
     * 
     * @return true if at least one SzSpcSvcAprvAmt has been added
     */
    public boolean hasSzSpcSvcAprvAmt()
    {
        return this._has_szSpcSvcAprvAmt;
    } //-- boolean hasSzSpcSvcAprvAmt() 

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
     * Sets the value of field 'dtDtSituationOpened'.
     * 
     * @param dtDtSituationOpened the value of field
     * 'dtDtSituationOpened'.
     */
    public void setDtDtSituationOpened(org.exolab.castor.types.Date dtDtSituationOpened)
    {
        this._dtDtSituationOpened = dtDtSituationOpened;
    } //-- void setDtDtSituationOpened(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStageStart'.
     * 
     * @param dtDtStageStart the value of field 'dtDtStageStart'.
     */
    public void setDtDtStageStart(org.exolab.castor.types.Date dtDtStageStart)
    {
        this._dtDtStageStart = dtDtStageStart;
    } //-- void setDtDtStageStart(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCCON22SOG00_ARRAY'.
     * 
     * @param ROWCCON22SOG00_ARRAY the value of field
     * 'ROWCCON22SOG00_ARRAY'.
     */
    public void setROWCCON22SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY ROWCCON22SOG00_ARRAY)
    {
        this._ROWCCON22SOG00_ARRAY = ROWCCON22SOG00_ARRAY;
    } //-- void setROWCCON22SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCCON22SOG01'.
     * 
     * @param ROWCCON22SOG01 the value of field 'ROWCCON22SOG01'.
     */
    public void setROWCCON22SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01 ROWCCON22SOG01)
    {
        this._ROWCCON22SOG01 = ROWCCON22SOG01;
    } //-- void setROWCCON22SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01) 

    /**
     * Sets the value of field 'ROWCCON22SOG02_ARRAY'.
     * 
     * @param ROWCCON22SOG02_ARRAY the value of field
     * 'ROWCCON22SOG02_ARRAY'.
     */
    public void setROWCCON22SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY ROWCCON22SOG02_ARRAY)
    {
        this._ROWCCON22SOG02_ARRAY = ROWCCON22SOG02_ARRAY;
    } //-- void setROWCCON22SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY) 

    /**
     * Sets the value of field 'szCdSplServType'.
     * 
     * @param szCdSplServType the value of field 'szCdSplServType'.
     */
    public void setSzCdSplServType(java.lang.String szCdSplServType)
    {
        this._szCdSplServType = szCdSplServType;
    } //-- void setSzCdSplServType(java.lang.String) 

    /**
     * Sets the value of field 'szSpcSvcAprvAmt'.
     * 
     * @param szSpcSvcAprvAmt the value of field 'szSpcSvcAprvAmt'.
     */
    public void setSzSpcSvcAprvAmt(double szSpcSvcAprvAmt)
    {
        this._szSpcSvcAprvAmt = szSpcSvcAprvAmt;
        this._has_szSpcSvcAprvAmt = true;
    } //-- void setSzSpcSvcAprvAmt(double) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO unmarshal(java.io.Reader) 

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
