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
 * Class ROWCCON21SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON21SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdSvcAuthDtlAuthType
     */
    private java.lang.String _szCdSvcAuthDtlAuthType;

    /**
     * Field _szCdSvcAuthDtlSvc
     */
    private java.lang.String _szCdSvcAuthDtlSvc;

    /**
     * Field _dtDtSvcAuthDtlBegin
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthDtlBegin;

    /**
     * Field _dtDtSvcAuthDtlEnd
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthDtlEnd;

    /**
     * Field _dtDtSvcAuthDtlTerm
     */
    private org.exolab.castor.types.Date _dtDtSvcAuthDtlTerm;

    /**
     * Field _lAmtSvcAuthDtlAmtReq
     */
    private double _lAmtSvcAuthDtlAmtReq;

    /**
     * keeps track of state for field: _lAmtSvcAuthDtlAmtReq
     */
    private boolean _has_lAmtSvcAuthDtlAmtReq;

    /**
     * Field _lNbrSvcAuthDtlUnitReq
     */
    private double _lNbrSvcAuthDtlUnitReq;

    /**
     * keeps track of state for field: _lNbrSvcAuthDtlUnitReq
     */
    private boolean _has_lNbrSvcAuthDtlUnitReq;

    /**
     * Field _ulIdSvcAuthDtl
     */
    private int _ulIdSvcAuthDtl;

    /**
     * keeps track of state for field: _ulIdSvcAuthDtl
     */
    private boolean _has_ulIdSvcAuthDtl;

    /**
     * Field _szCdSvcAuthDtlUnitType
     */
    private java.lang.String _szCdSvcAuthDtlUnitType;

    /**
     * Field _szCdSvcAuthDtlPeriod
     */
    private java.lang.String _szCdSvcAuthDtlPeriod;

    /**
     * Field _uNbrSvcAuthDtlFreq
     */
    private int _uNbrSvcAuthDtlFreq;

    /**
     * keeps track of state for field: _uNbrSvcAuthDtlFreq
     */
    private boolean _has_uNbrSvcAuthDtlFreq;

    /**
     * Field _lNbrSvcAuthDtlSugUnit
     */
    private int _lNbrSvcAuthDtlSugUnit;

    /**
     * keeps track of state for field: _lNbrSvcAuthDtlSugUnit
     */
    private boolean _has_lNbrSvcAuthDtlSugUnit;

    /**
     * Field _lNbrSvcAuthDtlUnitUsed
     */
    private double _lNbrSvcAuthDtlUnitUsed;

    /**
     * keeps track of state for field: _lNbrSvcAuthDtlUnitUsed
     */
    private boolean _has_lNbrSvcAuthDtlUnitUsed;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON21SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLAmtSvcAuthDtlAmtReq()
    {
        this._has_lAmtSvcAuthDtlAmtReq= false;
    } //-- void deleteLAmtSvcAuthDtlAmtReq() 

    /**
     */
    public void deleteLNbrSvcAuthDtlSugUnit()
    {
        this._has_lNbrSvcAuthDtlSugUnit= false;
    } //-- void deleteLNbrSvcAuthDtlSugUnit() 

    /**
     */
    public void deleteLNbrSvcAuthDtlUnitReq()
    {
        this._has_lNbrSvcAuthDtlUnitReq= false;
    } //-- void deleteLNbrSvcAuthDtlUnitReq() 

    /**
     */
    public void deleteLNbrSvcAuthDtlUnitUsed()
    {
        this._has_lNbrSvcAuthDtlUnitUsed= false;
    } //-- void deleteLNbrSvcAuthDtlUnitUsed() 

    /**
     */
    public void deleteUNbrSvcAuthDtlFreq()
    {
        this._has_uNbrSvcAuthDtlFreq= false;
    } //-- void deleteUNbrSvcAuthDtlFreq() 

    /**
     */
    public void deleteUlIdSvcAuthDtl()
    {
        this._has_ulIdSvcAuthDtl= false;
    } //-- void deleteUlIdSvcAuthDtl() 

    /**
     * Returns the value of field 'dtDtSvcAuthDtlBegin'.
     * 
     * @return the value of field 'DtDtSvcAuthDtlBegin'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthDtlBegin()
    {
        return this._dtDtSvcAuthDtlBegin;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthDtlBegin() 

    /**
     * Returns the value of field 'dtDtSvcAuthDtlEnd'.
     * 
     * @return the value of field 'DtDtSvcAuthDtlEnd'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthDtlEnd()
    {
        return this._dtDtSvcAuthDtlEnd;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthDtlEnd() 

    /**
     * Returns the value of field 'dtDtSvcAuthDtlTerm'.
     * 
     * @return the value of field 'DtDtSvcAuthDtlTerm'.
     */
    public org.exolab.castor.types.Date getDtDtSvcAuthDtlTerm()
    {
        return this._dtDtSvcAuthDtlTerm;
    } //-- org.exolab.castor.types.Date getDtDtSvcAuthDtlTerm() 

    /**
     * Returns the value of field 'lAmtSvcAuthDtlAmtReq'.
     * 
     * @return the value of field 'LAmtSvcAuthDtlAmtReq'.
     */
    public double getLAmtSvcAuthDtlAmtReq()
    {
        return this._lAmtSvcAuthDtlAmtReq;
    } //-- double getLAmtSvcAuthDtlAmtReq() 

    /**
     * Returns the value of field 'lNbrSvcAuthDtlSugUnit'.
     * 
     * @return the value of field 'LNbrSvcAuthDtlSugUnit'.
     */
    public int getLNbrSvcAuthDtlSugUnit()
    {
        return this._lNbrSvcAuthDtlSugUnit;
    } //-- int getLNbrSvcAuthDtlSugUnit() 

    /**
     * Returns the value of field 'lNbrSvcAuthDtlUnitReq'.
     * 
     * @return the value of field 'LNbrSvcAuthDtlUnitReq'.
     */
    public double getLNbrSvcAuthDtlUnitReq()
    {
        return this._lNbrSvcAuthDtlUnitReq;
    } //-- double getLNbrSvcAuthDtlUnitReq() 

    /**
     * Returns the value of field 'lNbrSvcAuthDtlUnitUsed'.
     * 
     * @return the value of field 'LNbrSvcAuthDtlUnitUsed'.
     */
    public double getLNbrSvcAuthDtlUnitUsed()
    {
        return this._lNbrSvcAuthDtlUnitUsed;
    } //-- double getLNbrSvcAuthDtlUnitUsed() 

    /**
     * Returns the value of field 'szCdSvcAuthDtlAuthType'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlAuthType'.
     */
    public java.lang.String getSzCdSvcAuthDtlAuthType()
    {
        return this._szCdSvcAuthDtlAuthType;
    } //-- java.lang.String getSzCdSvcAuthDtlAuthType() 

    /**
     * Returns the value of field 'szCdSvcAuthDtlPeriod'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlPeriod'.
     */
    public java.lang.String getSzCdSvcAuthDtlPeriod()
    {
        return this._szCdSvcAuthDtlPeriod;
    } //-- java.lang.String getSzCdSvcAuthDtlPeriod() 

    /**
     * Returns the value of field 'szCdSvcAuthDtlSvc'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlSvc'.
     */
    public java.lang.String getSzCdSvcAuthDtlSvc()
    {
        return this._szCdSvcAuthDtlSvc;
    } //-- java.lang.String getSzCdSvcAuthDtlSvc() 

    /**
     * Returns the value of field 'szCdSvcAuthDtlUnitType'.
     * 
     * @return the value of field 'SzCdSvcAuthDtlUnitType'.
     */
    public java.lang.String getSzCdSvcAuthDtlUnitType()
    {
        return this._szCdSvcAuthDtlUnitType;
    } //-- java.lang.String getSzCdSvcAuthDtlUnitType() 

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
     * Returns the value of field 'uNbrSvcAuthDtlFreq'.
     * 
     * @return the value of field 'UNbrSvcAuthDtlFreq'.
     */
    public int getUNbrSvcAuthDtlFreq()
    {
        return this._uNbrSvcAuthDtlFreq;
    } //-- int getUNbrSvcAuthDtlFreq() 

    /**
     * Returns the value of field 'ulIdSvcAuthDtl'.
     * 
     * @return the value of field 'UlIdSvcAuthDtl'.
     */
    public int getUlIdSvcAuthDtl()
    {
        return this._ulIdSvcAuthDtl;
    } //-- int getUlIdSvcAuthDtl() 

    /**
     * Method hasLAmtSvcAuthDtlAmtReq
     * 
     * 
     * 
     * @return true if at least one LAmtSvcAuthDtlAmtReq has been
     * added
     */
    public boolean hasLAmtSvcAuthDtlAmtReq()
    {
        return this._has_lAmtSvcAuthDtlAmtReq;
    } //-- boolean hasLAmtSvcAuthDtlAmtReq() 

    /**
     * Method hasLNbrSvcAuthDtlSugUnit
     * 
     * 
     * 
     * @return true if at least one LNbrSvcAuthDtlSugUnit has been
     * added
     */
    public boolean hasLNbrSvcAuthDtlSugUnit()
    {
        return this._has_lNbrSvcAuthDtlSugUnit;
    } //-- boolean hasLNbrSvcAuthDtlSugUnit() 

    /**
     * Method hasLNbrSvcAuthDtlUnitReq
     * 
     * 
     * 
     * @return true if at least one LNbrSvcAuthDtlUnitReq has been
     * added
     */
    public boolean hasLNbrSvcAuthDtlUnitReq()
    {
        return this._has_lNbrSvcAuthDtlUnitReq;
    } //-- boolean hasLNbrSvcAuthDtlUnitReq() 

    /**
     * Method hasLNbrSvcAuthDtlUnitUsed
     * 
     * 
     * 
     * @return true if at least one LNbrSvcAuthDtlUnitUsed has been
     * added
     */
    public boolean hasLNbrSvcAuthDtlUnitUsed()
    {
        return this._has_lNbrSvcAuthDtlUnitUsed;
    } //-- boolean hasLNbrSvcAuthDtlUnitUsed() 

    /**
     * Method hasUNbrSvcAuthDtlFreq
     * 
     * 
     * 
     * @return true if at least one UNbrSvcAuthDtlFreq has been adde
     */
    public boolean hasUNbrSvcAuthDtlFreq()
    {
        return this._has_uNbrSvcAuthDtlFreq;
    } //-- boolean hasUNbrSvcAuthDtlFreq() 

    /**
     * Method hasUlIdSvcAuthDtl
     * 
     * 
     * 
     * @return true if at least one UlIdSvcAuthDtl has been added
     */
    public boolean hasUlIdSvcAuthDtl()
    {
        return this._has_ulIdSvcAuthDtl;
    } //-- boolean hasUlIdSvcAuthDtl() 

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
     * Sets the value of field 'dtDtSvcAuthDtlBegin'.
     * 
     * @param dtDtSvcAuthDtlBegin the value of field
     * 'dtDtSvcAuthDtlBegin'.
     */
    public void setDtDtSvcAuthDtlBegin(org.exolab.castor.types.Date dtDtSvcAuthDtlBegin)
    {
        this._dtDtSvcAuthDtlBegin = dtDtSvcAuthDtlBegin;
    } //-- void setDtDtSvcAuthDtlBegin(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcAuthDtlEnd'.
     * 
     * @param dtDtSvcAuthDtlEnd the value of field
     * 'dtDtSvcAuthDtlEnd'.
     */
    public void setDtDtSvcAuthDtlEnd(org.exolab.castor.types.Date dtDtSvcAuthDtlEnd)
    {
        this._dtDtSvcAuthDtlEnd = dtDtSvcAuthDtlEnd;
    } //-- void setDtDtSvcAuthDtlEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSvcAuthDtlTerm'.
     * 
     * @param dtDtSvcAuthDtlTerm the value of field
     * 'dtDtSvcAuthDtlTerm'.
     */
    public void setDtDtSvcAuthDtlTerm(org.exolab.castor.types.Date dtDtSvcAuthDtlTerm)
    {
        this._dtDtSvcAuthDtlTerm = dtDtSvcAuthDtlTerm;
    } //-- void setDtDtSvcAuthDtlTerm(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lAmtSvcAuthDtlAmtReq'.
     * 
     * @param lAmtSvcAuthDtlAmtReq the value of field
     * 'lAmtSvcAuthDtlAmtReq'.
     */
    public void setLAmtSvcAuthDtlAmtReq(double lAmtSvcAuthDtlAmtReq)
    {
        this._lAmtSvcAuthDtlAmtReq = lAmtSvcAuthDtlAmtReq;
        this._has_lAmtSvcAuthDtlAmtReq = true;
    } //-- void setLAmtSvcAuthDtlAmtReq(double) 

    /**
     * Sets the value of field 'lNbrSvcAuthDtlSugUnit'.
     * 
     * @param lNbrSvcAuthDtlSugUnit the value of field
     * 'lNbrSvcAuthDtlSugUnit'.
     */
    public void setLNbrSvcAuthDtlSugUnit(int lNbrSvcAuthDtlSugUnit)
    {
        this._lNbrSvcAuthDtlSugUnit = lNbrSvcAuthDtlSugUnit;
        this._has_lNbrSvcAuthDtlSugUnit = true;
    } //-- void setLNbrSvcAuthDtlSugUnit(int) 

    /**
     * Sets the value of field 'lNbrSvcAuthDtlUnitReq'.
     * 
     * @param lNbrSvcAuthDtlUnitReq the value of field
     * 'lNbrSvcAuthDtlUnitReq'.
     */
    public void setLNbrSvcAuthDtlUnitReq(double lNbrSvcAuthDtlUnitReq)
    {
        this._lNbrSvcAuthDtlUnitReq = lNbrSvcAuthDtlUnitReq;
        this._has_lNbrSvcAuthDtlUnitReq = true;
    } //-- void setLNbrSvcAuthDtlUnitReq(double) 

    /**
     * Sets the value of field 'lNbrSvcAuthDtlUnitUsed'.
     * 
     * @param lNbrSvcAuthDtlUnitUsed the value of field
     * 'lNbrSvcAuthDtlUnitUsed'.
     */
    public void setLNbrSvcAuthDtlUnitUsed(double lNbrSvcAuthDtlUnitUsed)
    {
        this._lNbrSvcAuthDtlUnitUsed = lNbrSvcAuthDtlUnitUsed;
        this._has_lNbrSvcAuthDtlUnitUsed = true;
    } //-- void setLNbrSvcAuthDtlUnitUsed(double) 

    /**
     * Sets the value of field 'szCdSvcAuthDtlAuthType'.
     * 
     * @param szCdSvcAuthDtlAuthType the value of field
     * 'szCdSvcAuthDtlAuthType'.
     */
    public void setSzCdSvcAuthDtlAuthType(java.lang.String szCdSvcAuthDtlAuthType)
    {
        this._szCdSvcAuthDtlAuthType = szCdSvcAuthDtlAuthType;
    } //-- void setSzCdSvcAuthDtlAuthType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthDtlPeriod'.
     * 
     * @param szCdSvcAuthDtlPeriod the value of field
     * 'szCdSvcAuthDtlPeriod'.
     */
    public void setSzCdSvcAuthDtlPeriod(java.lang.String szCdSvcAuthDtlPeriod)
    {
        this._szCdSvcAuthDtlPeriod = szCdSvcAuthDtlPeriod;
    } //-- void setSzCdSvcAuthDtlPeriod(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthDtlSvc'.
     * 
     * @param szCdSvcAuthDtlSvc the value of field
     * 'szCdSvcAuthDtlSvc'.
     */
    public void setSzCdSvcAuthDtlSvc(java.lang.String szCdSvcAuthDtlSvc)
    {
        this._szCdSvcAuthDtlSvc = szCdSvcAuthDtlSvc;
    } //-- void setSzCdSvcAuthDtlSvc(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthDtlUnitType'.
     * 
     * @param szCdSvcAuthDtlUnitType the value of field
     * 'szCdSvcAuthDtlUnitType'.
     */
    public void setSzCdSvcAuthDtlUnitType(java.lang.String szCdSvcAuthDtlUnitType)
    {
        this._szCdSvcAuthDtlUnitType = szCdSvcAuthDtlUnitType;
    } //-- void setSzCdSvcAuthDtlUnitType(java.lang.String) 

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
     * Sets the value of field 'uNbrSvcAuthDtlFreq'.
     * 
     * @param uNbrSvcAuthDtlFreq the value of field
     * 'uNbrSvcAuthDtlFreq'.
     */
    public void setUNbrSvcAuthDtlFreq(int uNbrSvcAuthDtlFreq)
    {
        this._uNbrSvcAuthDtlFreq = uNbrSvcAuthDtlFreq;
        this._has_uNbrSvcAuthDtlFreq = true;
    } //-- void setUNbrSvcAuthDtlFreq(int) 

    /**
     * Sets the value of field 'ulIdSvcAuthDtl'.
     * 
     * @param ulIdSvcAuthDtl the value of field 'ulIdSvcAuthDtl'.
     */
    public void setUlIdSvcAuthDtl(int ulIdSvcAuthDtl)
    {
        this._ulIdSvcAuthDtl = ulIdSvcAuthDtl;
        this._has_ulIdSvcAuthDtl = true;
    } //-- void setUlIdSvcAuthDtl(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00 unmarshal(java.io.Reader) 

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
