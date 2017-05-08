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
 * Class CCON12SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON12SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _szCdCntrctFuncType
     */
    private java.lang.String _szCdCntrctFuncType;

    /**
     * Field _dtDtCncntyEffective
     */
    private org.exolab.castor.types.Date _dtDtCncntyEffective;

    /**
     * Field _dtDtCncntyEnd
     */
    private org.exolab.castor.types.Date _dtDtCncntyEnd;

    /**
     * Field _ulIdCntrctWkr
     */
    private int _ulIdCntrctWkr;

    /**
     * keeps track of state for field: _ulIdCntrctWkr
     */
    private boolean _has_ulIdCntrctWkr;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulNbrCnsvcPeriod
     */
    private int _ulNbrCnsvcPeriod;

    /**
     * keeps track of state for field: _ulNbrCnsvcPeriod
     */
    private boolean _has_ulNbrCnsvcPeriod;

    /**
     * Field _ulNbrCnsvcVersion
     */
    private int _ulNbrCnsvcVersion;

    /**
     * keeps track of state for field: _ulNbrCnsvcVersion
     */
    private boolean _has_ulNbrCnsvcVersion;

    /**
     * Field _ROWCCON12SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00_ARRAY _ROWCCON12SIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON12SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCntrctWkr()
    {
        this._has_ulIdCntrctWkr= false;
    } //-- void deleteUlIdCntrctWkr() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlNbrCnsvcPeriod()
    {
        this._has_ulNbrCnsvcPeriod= false;
    } //-- void deleteUlNbrCnsvcPeriod() 

    /**
     */
    public void deleteUlNbrCnsvcVersion()
    {
        this._has_ulNbrCnsvcVersion= false;
    } //-- void deleteUlNbrCnsvcVersion() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'dtDtCncntyEffective'.
     * 
     * @return the value of field 'DtDtCncntyEffective'.
     */
    public org.exolab.castor.types.Date getDtDtCncntyEffective()
    {
        return this._dtDtCncntyEffective;
    } //-- org.exolab.castor.types.Date getDtDtCncntyEffective() 

    /**
     * Returns the value of field 'dtDtCncntyEnd'.
     * 
     * @return the value of field 'DtDtCncntyEnd'.
     */
    public org.exolab.castor.types.Date getDtDtCncntyEnd()
    {
        return this._dtDtCncntyEnd;
    } //-- org.exolab.castor.types.Date getDtDtCncntyEnd() 

    /**
     * Returns the value of field 'ROWCCON12SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCON12SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00_ARRAY getROWCCON12SIG00_ARRAY()
    {
        return this._ROWCCON12SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00_ARRAY getROWCCON12SIG00_ARRAY() 

    /**
     * Returns the value of field 'szCdCntrctFuncType'.
     * 
     * @return the value of field 'SzCdCntrctFuncType'.
     */
    public java.lang.String getSzCdCntrctFuncType()
    {
        return this._szCdCntrctFuncType;
    } //-- java.lang.String getSzCdCntrctFuncType() 

    /**
     * Returns the value of field 'ulIdCntrctWkr'.
     * 
     * @return the value of field 'UlIdCntrctWkr'.
     */
    public int getUlIdCntrctWkr()
    {
        return this._ulIdCntrctWkr;
    } //-- int getUlIdCntrctWkr() 

    /**
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

    /**
     * Returns the value of field 'ulNbrCnsvcPeriod'.
     * 
     * @return the value of field 'UlNbrCnsvcPeriod'.
     */
    public int getUlNbrCnsvcPeriod()
    {
        return this._ulNbrCnsvcPeriod;
    } //-- int getUlNbrCnsvcPeriod() 

    /**
     * Returns the value of field 'ulNbrCnsvcVersion'.
     * 
     * @return the value of field 'UlNbrCnsvcVersion'.
     */
    public int getUlNbrCnsvcVersion()
    {
        return this._ulNbrCnsvcVersion;
    } //-- int getUlNbrCnsvcVersion() 

    /**
     * Method hasUlIdCntrctWkr
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctWkr has been added
     */
    public boolean hasUlIdCntrctWkr()
    {
        return this._has_ulIdCntrctWkr;
    } //-- boolean hasUlIdCntrctWkr() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

    /**
     * Method hasUlNbrCnsvcPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcPeriod has been added
     */
    public boolean hasUlNbrCnsvcPeriod()
    {
        return this._has_ulNbrCnsvcPeriod;
    } //-- boolean hasUlNbrCnsvcPeriod() 

    /**
     * Method hasUlNbrCnsvcVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcVersion has been added
     */
    public boolean hasUlNbrCnsvcVersion()
    {
        return this._has_ulNbrCnsvcVersion;
    } //-- boolean hasUlNbrCnsvcVersion() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'dtDtCncntyEffective'.
     * 
     * @param dtDtCncntyEffective the value of field
     * 'dtDtCncntyEffective'.
     */
    public void setDtDtCncntyEffective(org.exolab.castor.types.Date dtDtCncntyEffective)
    {
        this._dtDtCncntyEffective = dtDtCncntyEffective;
    } //-- void setDtDtCncntyEffective(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCncntyEnd'.
     * 
     * @param dtDtCncntyEnd the value of field 'dtDtCncntyEnd'.
     */
    public void setDtDtCncntyEnd(org.exolab.castor.types.Date dtDtCncntyEnd)
    {
        this._dtDtCncntyEnd = dtDtCncntyEnd;
    } //-- void setDtDtCncntyEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCON12SIG00_ARRAY'.
     * 
     * @param ROWCCON12SIG00_ARRAY the value of field
     * 'ROWCCON12SIG00_ARRAY'.
     */
    public void setROWCCON12SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00_ARRAY ROWCCON12SIG00_ARRAY)
    {
        this._ROWCCON12SIG00_ARRAY = ROWCCON12SIG00_ARRAY;
    } //-- void setROWCCON12SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00_ARRAY) 

    /**
     * Sets the value of field 'szCdCntrctFuncType'.
     * 
     * @param szCdCntrctFuncType the value of field
     * 'szCdCntrctFuncType'.
     */
    public void setSzCdCntrctFuncType(java.lang.String szCdCntrctFuncType)
    {
        this._szCdCntrctFuncType = szCdCntrctFuncType;
    } //-- void setSzCdCntrctFuncType(java.lang.String) 

    /**
     * Sets the value of field 'ulIdCntrctWkr'.
     * 
     * @param ulIdCntrctWkr the value of field 'ulIdCntrctWkr'.
     */
    public void setUlIdCntrctWkr(int ulIdCntrctWkr)
    {
        this._ulIdCntrctWkr = ulIdCntrctWkr;
        this._has_ulIdCntrctWkr = true;
    } //-- void setUlIdCntrctWkr(int) 

    /**
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

    /**
     * Sets the value of field 'ulNbrCnsvcPeriod'.
     * 
     * @param ulNbrCnsvcPeriod the value of field 'ulNbrCnsvcPeriod'
     */
    public void setUlNbrCnsvcPeriod(int ulNbrCnsvcPeriod)
    {
        this._ulNbrCnsvcPeriod = ulNbrCnsvcPeriod;
        this._has_ulNbrCnsvcPeriod = true;
    } //-- void setUlNbrCnsvcPeriod(int) 

    /**
     * Sets the value of field 'ulNbrCnsvcVersion'.
     * 
     * @param ulNbrCnsvcVersion the value of field
     * 'ulNbrCnsvcVersion'.
     */
    public void setUlNbrCnsvcVersion(int ulNbrCnsvcVersion)
    {
        this._ulNbrCnsvcVersion = ulNbrCnsvcVersion;
        this._has_ulNbrCnsvcVersion = true;
    } //-- void setUlNbrCnsvcVersion(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI unmarshal(java.io.Reader) 

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
