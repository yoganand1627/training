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
 * Class ROWCFIN06SOG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN06SOG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dAmtSvcDtlFeePaid
     */
    private double _dAmtSvcDtlFeePaid;

    /**
     * keeps track of state for field: _dAmtSvcDtlFeePaid
     */
    private boolean _has_dAmtSvcDtlFeePaid;

    /**
     * Field _szCdSvcDtlLiType
     */
    private java.lang.String _szCdSvcDtlLiType;

    /**
     * Field _dAmtSvcDtlUnitRate
     */
    private double _dAmtSvcDtlUnitRate;

    /**
     * keeps track of state for field: _dAmtSvcDtlUnitRate
     */
    private boolean _has_dAmtSvcDtlUnitRate;

    /**
     * Field _szCdSvcDtlService
     */
    private java.lang.String _szCdSvcDtlService;

    /**
     * Field _szCdSvcDtlUnitType
     */
    private java.lang.String _szCdSvcDtlUnitType;

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
     * Field _ulIdSvcAuthDtl
     */
    private int _ulIdSvcAuthDtl;

    /**
     * keeps track of state for field: _ulIdSvcAuthDtl
     */
    private boolean _has_ulIdSvcAuthDtl;

    /**
     * Field _cIndSvcDtlRejItem
     */
    private java.lang.String _cIndSvcDtlRejItem;

    /**
     * Field _szCdSvcDtlCounty
     */
    private java.lang.String _szCdSvcDtlCounty;

    /**
     * Field _uMoSvcDtlSvcMonth
     */
    private int _uMoSvcDtlSvcMonth;

    /**
     * keeps track of state for field: _uMoSvcDtlSvcMonth
     */
    private boolean _has_uMoSvcDtlSvcMonth;

    /**
     * Field _uYrSvcDtlServiceYear
     */
    private int _uYrSvcDtlServiceYear;

    /**
     * keeps track of state for field: _uYrSvcDtlServiceYear
     */
    private boolean _has_uYrSvcDtlServiceYear;

    /**
     * Field _usNbrSvcDtlCsli
     */
    private int _usNbrSvcDtlCsli;

    /**
     * keeps track of state for field: _usNbrSvcDtlCsli
     */
    private boolean _has_usNbrSvcDtlCsli;

    /**
     * Field _sNbrSvcDtlUnitQty
     */
    private double _sNbrSvcDtlUnitQty;

    /**
     * keeps track of state for field: _sNbrSvcDtlUnitQty
     */
    private boolean _has_sNbrSvcDtlUnitQty;

    /**
     * Field _szScrNmGenericFullName
     */
    private java.lang.String _szScrNmGenericFullName;

    /**
     * Field _szCdCnsvcPaymentType
     */
    private java.lang.String _szCdCnsvcPaymentType;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN06SOG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtSvcDtlFeePaid()
    {
        this._has_dAmtSvcDtlFeePaid= false;
    } //-- void deleteDAmtSvcDtlFeePaid() 

    /**
     */
    public void deleteDAmtSvcDtlUnitRate()
    {
        this._has_dAmtSvcDtlUnitRate= false;
    } //-- void deleteDAmtSvcDtlUnitRate() 

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
    public void deleteUlIdSvcAuthDtl()
    {
        this._has_ulIdSvcAuthDtl= false;
    } //-- void deleteUlIdSvcAuthDtl() 

    /**
     */
    public void deleteUlIdSvcDtl()
    {
        this._has_ulIdSvcDtl= false;
    } //-- void deleteUlIdSvcDtl() 

    /**
     */
    public void deleteUsNbrSvcDtlCsli()
    {
        this._has_usNbrSvcDtlCsli= false;
    } //-- void deleteUsNbrSvcDtlCsli() 

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
     * Returns the value of field 'dAmtSvcDtlFeePaid'.
     * 
     * @return the value of field 'DAmtSvcDtlFeePaid'.
     */
    public double getDAmtSvcDtlFeePaid()
    {
        return this._dAmtSvcDtlFeePaid;
    } //-- double getDAmtSvcDtlFeePaid() 

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
     * Returns the value of field 'sNbrSvcDtlUnitQty'.
     * 
     * @return the value of field 'SNbrSvcDtlUnitQty'.
     */
    public double getSNbrSvcDtlUnitQty()
    {
        return this._sNbrSvcDtlUnitQty;
    } //-- double getSNbrSvcDtlUnitQty() 

    /**
     * Returns the value of field 'szCdCnsvcPaymentType'.
     * 
     * @return the value of field 'SzCdCnsvcPaymentType'.
     */
    public java.lang.String getSzCdCnsvcPaymentType()
    {
        return this._szCdCnsvcPaymentType;
    } //-- java.lang.String getSzCdCnsvcPaymentType() 

    /**
     * Returns the value of field 'szCdSvcDtlCounty'.
     * 
     * @return the value of field 'SzCdSvcDtlCounty'.
     */
    public java.lang.String getSzCdSvcDtlCounty()
    {
        return this._szCdSvcDtlCounty;
    } //-- java.lang.String getSzCdSvcDtlCounty() 

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
     * Returns the value of field 'szScrNmGenericFullName'.
     * 
     * @return the value of field 'SzScrNmGenericFullName'.
     */
    public java.lang.String getSzScrNmGenericFullName()
    {
        return this._szScrNmGenericFullName;
    } //-- java.lang.String getSzScrNmGenericFullName() 

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
     * Returns the value of field 'ulIdSvcAuthDtl'.
     * 
     * @return the value of field 'UlIdSvcAuthDtl'.
     */
    public int getUlIdSvcAuthDtl()
    {
        return this._ulIdSvcAuthDtl;
    } //-- int getUlIdSvcAuthDtl() 

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
     * Returns the value of field 'usNbrSvcDtlCsli'.
     * 
     * @return the value of field 'UsNbrSvcDtlCsli'.
     */
    public int getUsNbrSvcDtlCsli()
    {
        return this._usNbrSvcDtlCsli;
    } //-- int getUsNbrSvcDtlCsli() 

    /**
     * Method hasDAmtSvcDtlFeePaid
     * 
     * 
     * 
     * @return true if at least one DAmtSvcDtlFeePaid has been added
     */
    public boolean hasDAmtSvcDtlFeePaid()
    {
        return this._has_dAmtSvcDtlFeePaid;
    } //-- boolean hasDAmtSvcDtlFeePaid() 

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
     * Method hasUsNbrSvcDtlCsli
     * 
     * 
     * 
     * @return true if at least one UsNbrSvcDtlCsli has been added
     */
    public boolean hasUsNbrSvcDtlCsli()
    {
        return this._has_usNbrSvcDtlCsli;
    } //-- boolean hasUsNbrSvcDtlCsli() 

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
     * Sets the value of field 'dAmtSvcDtlFeePaid'.
     * 
     * @param dAmtSvcDtlFeePaid the value of field
     * 'dAmtSvcDtlFeePaid'.
     */
    public void setDAmtSvcDtlFeePaid(double dAmtSvcDtlFeePaid)
    {
        this._dAmtSvcDtlFeePaid = dAmtSvcDtlFeePaid;
        this._has_dAmtSvcDtlFeePaid = true;
    } //-- void setDAmtSvcDtlFeePaid(double) 

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
     * Sets the value of field 'szCdCnsvcPaymentType'.
     * 
     * @param szCdCnsvcPaymentType the value of field
     * 'szCdCnsvcPaymentType'.
     */
    public void setSzCdCnsvcPaymentType(java.lang.String szCdCnsvcPaymentType)
    {
        this._szCdCnsvcPaymentType = szCdCnsvcPaymentType;
    } //-- void setSzCdCnsvcPaymentType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcDtlCounty'.
     * 
     * @param szCdSvcDtlCounty the value of field 'szCdSvcDtlCounty'
     */
    public void setSzCdSvcDtlCounty(java.lang.String szCdSvcDtlCounty)
    {
        this._szCdSvcDtlCounty = szCdSvcDtlCounty;
    } //-- void setSzCdSvcDtlCounty(java.lang.String) 

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
     * Sets the value of field 'szScrNmGenericFullName'.
     * 
     * @param szScrNmGenericFullName the value of field
     * 'szScrNmGenericFullName'.
     */
    public void setSzScrNmGenericFullName(java.lang.String szScrNmGenericFullName)
    {
        this._szScrNmGenericFullName = szScrNmGenericFullName;
    } //-- void setSzScrNmGenericFullName(java.lang.String) 

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
     * Sets the value of field 'usNbrSvcDtlCsli'.
     * 
     * @param usNbrSvcDtlCsli the value of field 'usNbrSvcDtlCsli'.
     */
    public void setUsNbrSvcDtlCsli(int usNbrSvcDtlCsli)
    {
        this._usNbrSvcDtlCsli = usNbrSvcDtlCsli;
        this._has_usNbrSvcDtlCsli = true;
    } //-- void setUsNbrSvcDtlCsli(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG unmarshal(java.io.Reader) 

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
