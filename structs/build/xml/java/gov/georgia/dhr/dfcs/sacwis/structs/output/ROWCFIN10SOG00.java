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
 * Class ROWCFIN10SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN10SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dAmtSvcDtlIncome
     */
    private double _dAmtSvcDtlIncome;

    /**
     * keeps track of state for field: _dAmtSvcDtlIncome
     */
    private boolean _has_dAmtSvcDtlIncome;

    /**
     * Field _dAmtSvcDtlUnitRate
     */
    private double _dAmtSvcDtlUnitRate;

    /**
     * keeps track of state for field: _dAmtSvcDtlUnitRate
     */
    private boolean _has_dAmtSvcDtlUnitRate;

    /**
     * Field _szCdSvcDtlLiType
     */
    private java.lang.String _szCdSvcDtlLiType;

    /**
     * Field _szCdSvcDtlService
     */
    private java.lang.String _szCdSvcDtlService;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdSvcDtl
     */
    private int _ulIdSvcDtl;

    /**
     * keeps track of state for field: _ulIdSvcDtl
     */
    private boolean _has_ulIdSvcDtl;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _cIndSvcDtlRejItem
     */
    private java.lang.String _cIndSvcDtlRejItem;

    /**
     * Field _uMoSvcDtlSvcMonth
     */
    private int _uMoSvcDtlSvcMonth;

    /**
     * keeps track of state for field: _uMoSvcDtlSvcMonth
     */
    private boolean _has_uMoSvcDtlSvcMonth;

    /**
     * Field _lNbrRsrcFacilAcclaim
     */
    private int _lNbrRsrcFacilAcclaim;

    /**
     * keeps track of state for field: _lNbrRsrcFacilAcclaim
     */
    private boolean _has_lNbrRsrcFacilAcclaim;

    /**
     * Field _sNbrSvcDtlFromDay
     */
    private int _sNbrSvcDtlFromDay;

    /**
     * keeps track of state for field: _sNbrSvcDtlFromDay
     */
    private boolean _has_sNbrSvcDtlFromDay;

    /**
     * Field _sNbrSvcDtlToDay
     */
    private int _sNbrSvcDtlToDay;

    /**
     * keeps track of state for field: _sNbrSvcDtlToDay
     */
    private boolean _has_sNbrSvcDtlToDay;

    /**
     * Field _sNbrSvcDtlUnitQty
     */
    private double _sNbrSvcDtlUnitQty;

    /**
     * keeps track of state for field: _sNbrSvcDtlUnitQty
     */
    private boolean _has_sNbrSvcDtlUnitQty;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _uYrSvcDtlServiceYear
     */
    private int _uYrSvcDtlServiceYear;

    /**
     * keeps track of state for field: _uYrSvcDtlServiceYear
     */
    private boolean _has_uYrSvcDtlServiceYear;

    /**
     * Field _szCdSvcDtlUnitType
     */
    private java.lang.String _szCdSvcDtlUnitType;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN10SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtSvcDtlIncome()
    {
        this._has_dAmtSvcDtlIncome= false;
    } //-- void deleteDAmtSvcDtlIncome() 

    /**
     */
    public void deleteDAmtSvcDtlUnitRate()
    {
        this._has_dAmtSvcDtlUnitRate= false;
    } //-- void deleteDAmtSvcDtlUnitRate() 

    /**
     */
    public void deleteLNbrRsrcFacilAcclaim()
    {
        this._has_lNbrRsrcFacilAcclaim= false;
    } //-- void deleteLNbrRsrcFacilAcclaim() 

    /**
     */
    public void deleteSNbrSvcDtlFromDay()
    {
        this._has_sNbrSvcDtlFromDay= false;
    } //-- void deleteSNbrSvcDtlFromDay() 

    /**
     */
    public void deleteSNbrSvcDtlToDay()
    {
        this._has_sNbrSvcDtlToDay= false;
    } //-- void deleteSNbrSvcDtlToDay() 

    /**
     */
    public void deleteSNbrSvcDtlUnitQty()
    {
        this._has_sNbrSvcDtlUnitQty= false;
    } //-- void deleteSNbrSvcDtlUnitQty() 

    /**
     */
    public void deleteUMoSvcDtlSvcMonth()
    {
        this._has_uMoSvcDtlSvcMonth= false;
    } //-- void deleteUMoSvcDtlSvcMonth() 

    /**
     */
    public void deleteUYrSvcDtlServiceYear()
    {
        this._has_uYrSvcDtlServiceYear= false;
    } //-- void deleteUYrSvcDtlServiceYear() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdSvcDtl()
    {
        this._has_ulIdSvcDtl= false;
    } //-- void deleteUlIdSvcDtl() 

    /**
     * Returns the value of field 'cIndSvcDtlRejItem'.
     * 
     * @return the value of field 'CIndSvcDtlRejItem'.
     */
    public java.lang.String getCIndSvcDtlRejItem()
    {
        return this._cIndSvcDtlRejItem;
    } //-- java.lang.String getCIndSvcDtlRejItem() 

    /**
     * Returns the value of field 'dAmtSvcDtlIncome'.
     * 
     * @return the value of field 'DAmtSvcDtlIncome'.
     */
    public double getDAmtSvcDtlIncome()
    {
        return this._dAmtSvcDtlIncome;
    } //-- double getDAmtSvcDtlIncome() 

    /**
     * Returns the value of field 'dAmtSvcDtlUnitRate'.
     * 
     * @return the value of field 'DAmtSvcDtlUnitRate'.
     */
    public double getDAmtSvcDtlUnitRate()
    {
        return this._dAmtSvcDtlUnitRate;
    } //-- double getDAmtSvcDtlUnitRate() 

    /**
     * Returns the value of field 'lNbrRsrcFacilAcclaim'.
     * 
     * @return the value of field 'LNbrRsrcFacilAcclaim'.
     */
    public int getLNbrRsrcFacilAcclaim()
    {
        return this._lNbrRsrcFacilAcclaim;
    } //-- int getLNbrRsrcFacilAcclaim() 

    /**
     * Returns the value of field 'sNbrSvcDtlFromDay'.
     * 
     * @return the value of field 'SNbrSvcDtlFromDay'.
     */
    public int getSNbrSvcDtlFromDay()
    {
        return this._sNbrSvcDtlFromDay;
    } //-- int getSNbrSvcDtlFromDay() 

    /**
     * Returns the value of field 'sNbrSvcDtlToDay'.
     * 
     * @return the value of field 'SNbrSvcDtlToDay'.
     */
    public int getSNbrSvcDtlToDay()
    {
        return this._sNbrSvcDtlToDay;
    } //-- int getSNbrSvcDtlToDay() 

    /**
     * Returns the value of field 'sNbrSvcDtlUnitQty'.
     * 
     * @return the value of field 'SNbrSvcDtlUnitQty'.
     */
    public double getSNbrSvcDtlUnitQty()
    {
        return this._sNbrSvcDtlUnitQty;
    } //-- double getSNbrSvcDtlUnitQty() 

    /**
     * Returns the value of field 'szCdSvcDtlLiType'.
     * 
     * @return the value of field 'SzCdSvcDtlLiType'.
     */
    public java.lang.String getSzCdSvcDtlLiType()
    {
        return this._szCdSvcDtlLiType;
    } //-- java.lang.String getSzCdSvcDtlLiType() 

    /**
     * Returns the value of field 'szCdSvcDtlService'.
     * 
     * @return the value of field 'SzCdSvcDtlService'.
     */
    public java.lang.String getSzCdSvcDtlService()
    {
        return this._szCdSvcDtlService;
    } //-- java.lang.String getSzCdSvcDtlService() 

    /**
     * Returns the value of field 'szCdSvcDtlUnitType'.
     * 
     * @return the value of field 'SzCdSvcDtlUnitType'.
     */
    public java.lang.String getSzCdSvcDtlUnitType()
    {
        return this._szCdSvcDtlUnitType;
    } //-- java.lang.String getSzCdSvcDtlUnitType() 

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
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'uMoSvcDtlSvcMonth'.
     * 
     * @return the value of field 'UMoSvcDtlSvcMonth'.
     */
    public int getUMoSvcDtlSvcMonth()
    {
        return this._uMoSvcDtlSvcMonth;
    } //-- int getUMoSvcDtlSvcMonth() 

    /**
     * Returns the value of field 'uYrSvcDtlServiceYear'.
     * 
     * @return the value of field 'UYrSvcDtlServiceYear'.
     */
    public int getUYrSvcDtlServiceYear()
    {
        return this._uYrSvcDtlServiceYear;
    } //-- int getUYrSvcDtlServiceYear() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdSvcDtl'.
     * 
     * @return the value of field 'UlIdSvcDtl'.
     */
    public int getUlIdSvcDtl()
    {
        return this._ulIdSvcDtl;
    } //-- int getUlIdSvcDtl() 

    /**
     * Method hasDAmtSvcDtlIncome
     * 
     * 
     * 
     * @return true if at least one DAmtSvcDtlIncome has been added
     */
    public boolean hasDAmtSvcDtlIncome()
    {
        return this._has_dAmtSvcDtlIncome;
    } //-- boolean hasDAmtSvcDtlIncome() 

    /**
     * Method hasDAmtSvcDtlUnitRate
     * 
     * 
     * 
     * @return true if at least one DAmtSvcDtlUnitRate has been adde
     */
    public boolean hasDAmtSvcDtlUnitRate()
    {
        return this._has_dAmtSvcDtlUnitRate;
    } //-- boolean hasDAmtSvcDtlUnitRate() 

    /**
     * Method hasLNbrRsrcFacilAcclaim
     * 
     * 
     * 
     * @return true if at least one LNbrRsrcFacilAcclaim has been
     * added
     */
    public boolean hasLNbrRsrcFacilAcclaim()
    {
        return this._has_lNbrRsrcFacilAcclaim;
    } //-- boolean hasLNbrRsrcFacilAcclaim() 

    /**
     * Method hasSNbrSvcDtlFromDay
     * 
     * 
     * 
     * @return true if at least one SNbrSvcDtlFromDay has been added
     */
    public boolean hasSNbrSvcDtlFromDay()
    {
        return this._has_sNbrSvcDtlFromDay;
    } //-- boolean hasSNbrSvcDtlFromDay() 

    /**
     * Method hasSNbrSvcDtlToDay
     * 
     * 
     * 
     * @return true if at least one SNbrSvcDtlToDay has been added
     */
    public boolean hasSNbrSvcDtlToDay()
    {
        return this._has_sNbrSvcDtlToDay;
    } //-- boolean hasSNbrSvcDtlToDay() 

    /**
     * Method hasSNbrSvcDtlUnitQty
     * 
     * 
     * 
     * @return true if at least one SNbrSvcDtlUnitQty has been added
     */
    public boolean hasSNbrSvcDtlUnitQty()
    {
        return this._has_sNbrSvcDtlUnitQty;
    } //-- boolean hasSNbrSvcDtlUnitQty() 

    /**
     * Method hasUMoSvcDtlSvcMonth
     * 
     * 
     * 
     * @return true if at least one UMoSvcDtlSvcMonth has been added
     */
    public boolean hasUMoSvcDtlSvcMonth()
    {
        return this._has_uMoSvcDtlSvcMonth;
    } //-- boolean hasUMoSvcDtlSvcMonth() 

    /**
     * Method hasUYrSvcDtlServiceYear
     * 
     * 
     * 
     * @return true if at least one UYrSvcDtlServiceYear has been
     * added
     */
    public boolean hasUYrSvcDtlServiceYear()
    {
        return this._has_uYrSvcDtlServiceYear;
    } //-- boolean hasUYrSvcDtlServiceYear() 

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
     * Method hasUlIdSvcDtl
     * 
     * 
     * 
     * @return true if at least one UlIdSvcDtl has been added
     */
    public boolean hasUlIdSvcDtl()
    {
        return this._has_ulIdSvcDtl;
    } //-- boolean hasUlIdSvcDtl() 

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
     * Sets the value of field 'cIndSvcDtlRejItem'.
     * 
     * @param cIndSvcDtlRejItem the value of field
     * 'cIndSvcDtlRejItem'.
     */
    public void setCIndSvcDtlRejItem(java.lang.String cIndSvcDtlRejItem)
    {
        this._cIndSvcDtlRejItem = cIndSvcDtlRejItem;
    } //-- void setCIndSvcDtlRejItem(java.lang.String) 

    /**
     * Sets the value of field 'dAmtSvcDtlIncome'.
     * 
     * @param dAmtSvcDtlIncome the value of field 'dAmtSvcDtlIncome'
     */
    public void setDAmtSvcDtlIncome(double dAmtSvcDtlIncome)
    {
        this._dAmtSvcDtlIncome = dAmtSvcDtlIncome;
        this._has_dAmtSvcDtlIncome = true;
    } //-- void setDAmtSvcDtlIncome(double) 

    /**
     * Sets the value of field 'dAmtSvcDtlUnitRate'.
     * 
     * @param dAmtSvcDtlUnitRate the value of field
     * 'dAmtSvcDtlUnitRate'.
     */
    public void setDAmtSvcDtlUnitRate(double dAmtSvcDtlUnitRate)
    {
        this._dAmtSvcDtlUnitRate = dAmtSvcDtlUnitRate;
        this._has_dAmtSvcDtlUnitRate = true;
    } //-- void setDAmtSvcDtlUnitRate(double) 

    /**
     * Sets the value of field 'lNbrRsrcFacilAcclaim'.
     * 
     * @param lNbrRsrcFacilAcclaim the value of field
     * 'lNbrRsrcFacilAcclaim'.
     */
    public void setLNbrRsrcFacilAcclaim(int lNbrRsrcFacilAcclaim)
    {
        this._lNbrRsrcFacilAcclaim = lNbrRsrcFacilAcclaim;
        this._has_lNbrRsrcFacilAcclaim = true;
    } //-- void setLNbrRsrcFacilAcclaim(int) 

    /**
     * Sets the value of field 'sNbrSvcDtlFromDay'.
     * 
     * @param sNbrSvcDtlFromDay the value of field
     * 'sNbrSvcDtlFromDay'.
     */
    public void setSNbrSvcDtlFromDay(int sNbrSvcDtlFromDay)
    {
        this._sNbrSvcDtlFromDay = sNbrSvcDtlFromDay;
        this._has_sNbrSvcDtlFromDay = true;
    } //-- void setSNbrSvcDtlFromDay(int) 

    /**
     * Sets the value of field 'sNbrSvcDtlToDay'.
     * 
     * @param sNbrSvcDtlToDay the value of field 'sNbrSvcDtlToDay'.
     */
    public void setSNbrSvcDtlToDay(int sNbrSvcDtlToDay)
    {
        this._sNbrSvcDtlToDay = sNbrSvcDtlToDay;
        this._has_sNbrSvcDtlToDay = true;
    } //-- void setSNbrSvcDtlToDay(int) 

    /**
     * Sets the value of field 'sNbrSvcDtlUnitQty'.
     * 
     * @param sNbrSvcDtlUnitQty the value of field
     * 'sNbrSvcDtlUnitQty'.
     */
    public void setSNbrSvcDtlUnitQty(double sNbrSvcDtlUnitQty)
    {
        this._sNbrSvcDtlUnitQty = sNbrSvcDtlUnitQty;
        this._has_sNbrSvcDtlUnitQty = true;
    } //-- void setSNbrSvcDtlUnitQty(double) 

    /**
     * Sets the value of field 'szCdSvcDtlLiType'.
     * 
     * @param szCdSvcDtlLiType the value of field 'szCdSvcDtlLiType'
     */
    public void setSzCdSvcDtlLiType(java.lang.String szCdSvcDtlLiType)
    {
        this._szCdSvcDtlLiType = szCdSvcDtlLiType;
    } //-- void setSzCdSvcDtlLiType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcDtlService'.
     * 
     * @param szCdSvcDtlService the value of field
     * 'szCdSvcDtlService'.
     */
    public void setSzCdSvcDtlService(java.lang.String szCdSvcDtlService)
    {
        this._szCdSvcDtlService = szCdSvcDtlService;
    } //-- void setSzCdSvcDtlService(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcDtlUnitType'.
     * 
     * @param szCdSvcDtlUnitType the value of field
     * 'szCdSvcDtlUnitType'.
     */
    public void setSzCdSvcDtlUnitType(java.lang.String szCdSvcDtlUnitType)
    {
        this._szCdSvcDtlUnitType = szCdSvcDtlUnitType;
    } //-- void setSzCdSvcDtlUnitType(java.lang.String) 

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
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'uMoSvcDtlSvcMonth'.
     * 
     * @param uMoSvcDtlSvcMonth the value of field
     * 'uMoSvcDtlSvcMonth'.
     */
    public void setUMoSvcDtlSvcMonth(int uMoSvcDtlSvcMonth)
    {
        this._uMoSvcDtlSvcMonth = uMoSvcDtlSvcMonth;
        this._has_uMoSvcDtlSvcMonth = true;
    } //-- void setUMoSvcDtlSvcMonth(int) 

    /**
     * Sets the value of field 'uYrSvcDtlServiceYear'.
     * 
     * @param uYrSvcDtlServiceYear the value of field
     * 'uYrSvcDtlServiceYear'.
     */
    public void setUYrSvcDtlServiceYear(int uYrSvcDtlServiceYear)
    {
        this._uYrSvcDtlServiceYear = uYrSvcDtlServiceYear;
        this._has_uYrSvcDtlServiceYear = true;
    } //-- void setUYrSvcDtlServiceYear(int) 

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
     * Sets the value of field 'ulIdSvcDtl'.
     * 
     * @param ulIdSvcDtl the value of field 'ulIdSvcDtl'.
     */
    public void setUlIdSvcDtl(int ulIdSvcDtl)
    {
        this._ulIdSvcDtl = ulIdSvcDtl;
        this._has_ulIdSvcDtl = true;
    } //-- void setUlIdSvcDtl(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00 unmarshal(java.io.Reader) 

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
