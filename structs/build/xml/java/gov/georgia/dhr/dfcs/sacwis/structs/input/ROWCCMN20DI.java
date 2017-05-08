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
 * Class ROWCCMN20DI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN20DI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdOnCallCounty_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY _szCdOnCallCounty_ARRAY;

    /**
     * Field _cdCountyCounter
     */
    private int _cdCountyCounter;

    /**
     * keeps track of state for field: _cdCountyCounter
     */
    private boolean _has_cdCountyCounter;

    /**
     * Field _szCdRegion
     */
    private java.lang.String _szCdRegion;

    /**
     * Field _szCdOnCallCounty
     */
    private java.lang.String _szCdOnCallCounty;

    /**
     * Field _szCdOnCallProgram
     */
    private java.lang.String _szCdOnCallProgram;

    /**
     * Field _szCdOnCallType
     */
    private java.lang.String _szCdOnCallType;

    /**
     * Field _dtDtOnCallStart
     */
    private org.exolab.castor.types.Date _dtDtOnCallStart;

    /**
     * Field _tmOnCallStart
     */
    private java.lang.String _tmOnCallStart;

    /**
     * Field _dtDtOnCallEnd
     */
    private org.exolab.castor.types.Date _dtDtOnCallEnd;

    /**
     * Field _tmOnCallEnd
     */
    private java.lang.String _tmOnCallEnd;

    /**
     * Field _ulIdOnCall
     */
    private int _ulIdOnCall;

    /**
     * keeps track of state for field: _ulIdOnCall
     */
    private boolean _has_ulIdOnCall;

    /**
     * Field _bIndOnCallFilled
     */
    private java.lang.String _bIndOnCallFilled;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdOnCallMultOrAll
     */
    private java.lang.String _szCdOnCallMultOrAll;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN20DI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteCdCountyCounter()
    {
        this._has_cdCountyCounter= false;
    } //-- void deleteCdCountyCounter() 

    /**
     */
    public void deleteUlIdOnCall()
    {
        this._has_ulIdOnCall= false;
    } //-- void deleteUlIdOnCall() 

    /**
     * Returns the value of field 'bIndOnCallFilled'.
     * 
     * @return the value of field 'BIndOnCallFilled'.
     */
    public java.lang.String getBIndOnCallFilled()
    {
        return this._bIndOnCallFilled;
    } //-- java.lang.String getBIndOnCallFilled() 

    /**
     * Returns the value of field 'cdCountyCounter'.
     * 
     * @return the value of field 'CdCountyCounter'.
     */
    public int getCdCountyCounter()
    {
        return this._cdCountyCounter;
    } //-- int getCdCountyCounter() 

    /**
     * Returns the value of field 'dtDtOnCallEnd'.
     * 
     * @return the value of field 'DtDtOnCallEnd'.
     */
    public org.exolab.castor.types.Date getDtDtOnCallEnd()
    {
        return this._dtDtOnCallEnd;
    } //-- org.exolab.castor.types.Date getDtDtOnCallEnd() 

    /**
     * Returns the value of field 'dtDtOnCallStart'.
     * 
     * @return the value of field 'DtDtOnCallStart'.
     */
    public org.exolab.castor.types.Date getDtDtOnCallStart()
    {
        return this._dtDtOnCallStart;
    } //-- org.exolab.castor.types.Date getDtDtOnCallStart() 

    /**
     * Returns the value of field 'szCdOnCallCounty'.
     * 
     * @return the value of field 'SzCdOnCallCounty'.
     */
    public java.lang.String getSzCdOnCallCounty()
    {
        return this._szCdOnCallCounty;
    } //-- java.lang.String getSzCdOnCallCounty() 

    /**
     * Returns the value of field 'szCdOnCallCounty_ARRAY'.
     * 
     * @return the value of field 'SzCdOnCallCounty_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY getSzCdOnCallCounty_ARRAY()
    {
        return this._szCdOnCallCounty_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY getSzCdOnCallCounty_ARRAY() 

    /**
     * Returns the value of field 'szCdOnCallMultOrAll'.
     * 
     * @return the value of field 'SzCdOnCallMultOrAll'.
     */
    public java.lang.String getSzCdOnCallMultOrAll()
    {
        return this._szCdOnCallMultOrAll;
    } //-- java.lang.String getSzCdOnCallMultOrAll() 

    /**
     * Returns the value of field 'szCdOnCallProgram'.
     * 
     * @return the value of field 'SzCdOnCallProgram'.
     */
    public java.lang.String getSzCdOnCallProgram()
    {
        return this._szCdOnCallProgram;
    } //-- java.lang.String getSzCdOnCallProgram() 

    /**
     * Returns the value of field 'szCdOnCallType'.
     * 
     * @return the value of field 'SzCdOnCallType'.
     */
    public java.lang.String getSzCdOnCallType()
    {
        return this._szCdOnCallType;
    } //-- java.lang.String getSzCdOnCallType() 

    /**
     * Returns the value of field 'szCdRegion'.
     * 
     * @return the value of field 'SzCdRegion'.
     */
    public java.lang.String getSzCdRegion()
    {
        return this._szCdRegion;
    } //-- java.lang.String getSzCdRegion() 

    /**
     * Returns the value of field 'tmOnCallEnd'.
     * 
     * @return the value of field 'TmOnCallEnd'.
     */
    public java.lang.String getTmOnCallEnd()
    {
        return this._tmOnCallEnd;
    } //-- java.lang.String getTmOnCallEnd() 

    /**
     * Returns the value of field 'tmOnCallStart'.
     * 
     * @return the value of field 'TmOnCallStart'.
     */
    public java.lang.String getTmOnCallStart()
    {
        return this._tmOnCallStart;
    } //-- java.lang.String getTmOnCallStart() 

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
     * Returns the value of field 'ulIdOnCall'.
     * 
     * @return the value of field 'UlIdOnCall'.
     */
    public int getUlIdOnCall()
    {
        return this._ulIdOnCall;
    } //-- int getUlIdOnCall() 

    /**
     * Method hasCdCountyCounter
     * 
     * 
     * 
     * @return true if at least one CdCountyCounter has been added
     */
    public boolean hasCdCountyCounter()
    {
        return this._has_cdCountyCounter;
    } //-- boolean hasCdCountyCounter() 

    /**
     * Method hasUlIdOnCall
     * 
     * 
     * 
     * @return true if at least one UlIdOnCall has been added
     */
    public boolean hasUlIdOnCall()
    {
        return this._has_ulIdOnCall;
    } //-- boolean hasUlIdOnCall() 

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
     * Sets the value of field 'bIndOnCallFilled'.
     * 
     * @param bIndOnCallFilled the value of field 'bIndOnCallFilled'
     */
    public void setBIndOnCallFilled(java.lang.String bIndOnCallFilled)
    {
        this._bIndOnCallFilled = bIndOnCallFilled;
    } //-- void setBIndOnCallFilled(java.lang.String) 

    /**
     * Sets the value of field 'cdCountyCounter'.
     * 
     * @param cdCountyCounter the value of field 'cdCountyCounter'.
     */
    public void setCdCountyCounter(int cdCountyCounter)
    {
        this._cdCountyCounter = cdCountyCounter;
        this._has_cdCountyCounter = true;
    } //-- void setCdCountyCounter(int) 

    /**
     * Sets the value of field 'dtDtOnCallEnd'.
     * 
     * @param dtDtOnCallEnd the value of field 'dtDtOnCallEnd'.
     */
    public void setDtDtOnCallEnd(org.exolab.castor.types.Date dtDtOnCallEnd)
    {
        this._dtDtOnCallEnd = dtDtOnCallEnd;
    } //-- void setDtDtOnCallEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtOnCallStart'.
     * 
     * @param dtDtOnCallStart the value of field 'dtDtOnCallStart'.
     */
    public void setDtDtOnCallStart(org.exolab.castor.types.Date dtDtOnCallStart)
    {
        this._dtDtOnCallStart = dtDtOnCallStart;
    } //-- void setDtDtOnCallStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdOnCallCounty'.
     * 
     * @param szCdOnCallCounty the value of field 'szCdOnCallCounty'
     */
    public void setSzCdOnCallCounty(java.lang.String szCdOnCallCounty)
    {
        this._szCdOnCallCounty = szCdOnCallCounty;
    } //-- void setSzCdOnCallCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdOnCallCounty_ARRAY'.
     * 
     * @param szCdOnCallCounty_ARRAY the value of field
     * 'szCdOnCallCounty_ARRAY'.
     */
    public void setSzCdOnCallCounty_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY szCdOnCallCounty_ARRAY)
    {
        this._szCdOnCallCounty_ARRAY = szCdOnCallCounty_ARRAY;
    } //-- void setSzCdOnCallCounty_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY) 

    /**
     * Sets the value of field 'szCdOnCallMultOrAll'.
     * 
     * @param szCdOnCallMultOrAll the value of field
     * 'szCdOnCallMultOrAll'.
     */
    public void setSzCdOnCallMultOrAll(java.lang.String szCdOnCallMultOrAll)
    {
        this._szCdOnCallMultOrAll = szCdOnCallMultOrAll;
    } //-- void setSzCdOnCallMultOrAll(java.lang.String) 

    /**
     * Sets the value of field 'szCdOnCallProgram'.
     * 
     * @param szCdOnCallProgram the value of field
     * 'szCdOnCallProgram'.
     */
    public void setSzCdOnCallProgram(java.lang.String szCdOnCallProgram)
    {
        this._szCdOnCallProgram = szCdOnCallProgram;
    } //-- void setSzCdOnCallProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdOnCallType'.
     * 
     * @param szCdOnCallType the value of field 'szCdOnCallType'.
     */
    public void setSzCdOnCallType(java.lang.String szCdOnCallType)
    {
        this._szCdOnCallType = szCdOnCallType;
    } //-- void setSzCdOnCallType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRegion'.
     * 
     * @param szCdRegion the value of field 'szCdRegion'.
     */
    public void setSzCdRegion(java.lang.String szCdRegion)
    {
        this._szCdRegion = szCdRegion;
    } //-- void setSzCdRegion(java.lang.String) 

    /**
     * Sets the value of field 'tmOnCallEnd'.
     * 
     * @param tmOnCallEnd the value of field 'tmOnCallEnd'.
     */
    public void setTmOnCallEnd(java.lang.String tmOnCallEnd)
    {
        this._tmOnCallEnd = tmOnCallEnd;
    } //-- void setTmOnCallEnd(java.lang.String) 

    /**
     * Sets the value of field 'tmOnCallStart'.
     * 
     * @param tmOnCallStart the value of field 'tmOnCallStart'.
     */
    public void setTmOnCallStart(java.lang.String tmOnCallStart)
    {
        this._tmOnCallStart = tmOnCallStart;
    } //-- void setTmOnCallStart(java.lang.String) 

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
     * Sets the value of field 'ulIdOnCall'.
     * 
     * @param ulIdOnCall the value of field 'ulIdOnCall'.
     */
    public void setUlIdOnCall(int ulIdOnCall)
    {
        this._ulIdOnCall = ulIdOnCall;
        this._has_ulIdOnCall = true;
    } //-- void setUlIdOnCall(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI unmarshal(java.io.Reader) 

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