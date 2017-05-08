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
 * Class ROWCFIN21SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN21SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dAmtSvcDtlIncome
     */
    private double _dAmtSvcDtlIncome;

    /**
     * keeps track of state for field: _dAmtSvcDtlIncome
     */
    private boolean _has_dAmtSvcDtlIncome;

    /**
     * Field _dAmtInvoValidAmount
     */
    private double _dAmtInvoValidAmount;

    /**
     * keeps track of state for field: _dAmtInvoValidAmount
     */
    private boolean _has_dAmtInvoValidAmount;

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
     * Field _dtDtInvoWarrantDate
     */
    private org.exolab.castor.types.Date _dtDtInvoWarrantDate;

    /**
     * Field _ulIdInvoInvoice
     */
    private int _ulIdInvoInvoice;

    /**
     * keeps track of state for field: _ulIdInvoInvoice
     */
    private boolean _has_ulIdInvoInvoice;

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
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _dScrAmtFinPayhstLntot
     */
    private double _dScrAmtFinPayhstLntot;

    /**
     * keeps track of state for field: _dScrAmtFinPayhstLntot
     */
    private boolean _has_dScrAmtFinPayhstLntot;

    /**
     * Field _szNbrInvoWarrant
     */
    private java.lang.String _szNbrInvoWarrant;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _szCdPaymentDelivery
     */
    private java.lang.String _szCdPaymentDelivery;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN21SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtInvoValidAmount()
    {
        this._has_dAmtInvoValidAmount= false;
    } //-- void deleteDAmtInvoValidAmount() 

    /**
     */
    public void deleteDAmtSvcDtlFeePaid()
    {
        this._has_dAmtSvcDtlFeePaid= false;
    } //-- void deleteDAmtSvcDtlFeePaid() 

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
    public void deleteDScrAmtFinPayhstLntot()
    {
        this._has_dScrAmtFinPayhstLntot= false;
    } //-- void deleteDScrAmtFinPayhstLntot() 

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
    public void deleteUlIdInvoInvoice()
    {
        this._has_ulIdInvoInvoice= false;
    } //-- void deleteUlIdInvoInvoice() 

    /**
     * Returns the value of field 'dAmtInvoValidAmount'.
     * 
     * @return the value of field 'DAmtInvoValidAmount'.
     */
    public double getDAmtInvoValidAmount()
    {
        return this._dAmtInvoValidAmount;
    } //-- double getDAmtInvoValidAmount() 

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
     * Returns the value of field 'dScrAmtFinPayhstLntot'.
     * 
     * @return the value of field 'DScrAmtFinPayhstLntot'.
     */
    public double getDScrAmtFinPayhstLntot()
    {
        return this._dScrAmtFinPayhstLntot;
    } //-- double getDScrAmtFinPayhstLntot() 

    /**
     * Returns the value of field 'dtDtInvoWarrantDate'.
     * 
     * @return the value of field 'DtDtInvoWarrantDate'.
     */
    public org.exolab.castor.types.Date getDtDtInvoWarrantDate()
    {
        return this._dtDtInvoWarrantDate;
    } //-- org.exolab.castor.types.Date getDtDtInvoWarrantDate() 

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
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

    /**
     * Returns the value of field 'szCdPaymentDelivery'.
     * 
     * @return the value of field 'SzCdPaymentDelivery'.
     */
    public java.lang.String getSzCdPaymentDelivery()
    {
        return this._szCdPaymentDelivery;
    } //-- java.lang.String getSzCdPaymentDelivery() 

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
     * Returns the value of field 'szNbrInvoWarrant'.
     * 
     * @return the value of field 'SzNbrInvoWarrant'.
     */
    public java.lang.String getSzNbrInvoWarrant()
    {
        return this._szNbrInvoWarrant;
    } //-- java.lang.String getSzNbrInvoWarrant() 

    /**
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

    /**
     * Returns the value of field 'ulIdInvoInvoice'.
     * 
     * @return the value of field 'UlIdInvoInvoice'.
     */
    public int getUlIdInvoInvoice()
    {
        return this._ulIdInvoInvoice;
    } //-- int getUlIdInvoInvoice() 

    /**
     * Method hasDAmtInvoValidAmount
     * 
     * 
     * 
     * @return true if at least one DAmtInvoValidAmount has been
     * added
     */
    public boolean hasDAmtInvoValidAmount()
    {
        return this._has_dAmtInvoValidAmount;
    } //-- boolean hasDAmtInvoValidAmount() 

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
     * Method hasDScrAmtFinPayhstLntot
     * 
     * 
     * 
     * @return true if at least one DScrAmtFinPayhstLntot has been
     * added
     */
    public boolean hasDScrAmtFinPayhstLntot()
    {
        return this._has_dScrAmtFinPayhstLntot;
    } //-- boolean hasDScrAmtFinPayhstLntot() 

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
     * Method hasUlIdInvoInvoice
     * 
     * 
     * 
     * @return true if at least one UlIdInvoInvoice has been added
     */
    public boolean hasUlIdInvoInvoice()
    {
        return this._has_ulIdInvoInvoice;
    } //-- boolean hasUlIdInvoInvoice() 

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
     * Sets the value of field 'dAmtInvoValidAmount'.
     * 
     * @param dAmtInvoValidAmount the value of field
     * 'dAmtInvoValidAmount'.
     */
    public void setDAmtInvoValidAmount(double dAmtInvoValidAmount)
    {
        this._dAmtInvoValidAmount = dAmtInvoValidAmount;
        this._has_dAmtInvoValidAmount = true;
    } //-- void setDAmtInvoValidAmount(double) 

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
     * Sets the value of field 'dScrAmtFinPayhstLntot'.
     * 
     * @param dScrAmtFinPayhstLntot the value of field
     * 'dScrAmtFinPayhstLntot'.
     */
    public void setDScrAmtFinPayhstLntot(double dScrAmtFinPayhstLntot)
    {
        this._dScrAmtFinPayhstLntot = dScrAmtFinPayhstLntot;
        this._has_dScrAmtFinPayhstLntot = true;
    } //-- void setDScrAmtFinPayhstLntot(double) 

    /**
     * Sets the value of field 'dtDtInvoWarrantDate'.
     * 
     * @param dtDtInvoWarrantDate the value of field
     * 'dtDtInvoWarrantDate'.
     */
    public void setDtDtInvoWarrantDate(org.exolab.castor.types.Date dtDtInvoWarrantDate)
    {
        this._dtDtInvoWarrantDate = dtDtInvoWarrantDate;
    } //-- void setDtDtInvoWarrantDate(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPaymentDelivery'.
     * 
     * @param szCdPaymentDelivery the value of field
     * 'szCdPaymentDelivery'.
     */
    public void setSzCdPaymentDelivery(java.lang.String szCdPaymentDelivery)
    {
        this._szCdPaymentDelivery = szCdPaymentDelivery;
    } //-- void setSzCdPaymentDelivery(java.lang.String) 

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
     * Sets the value of field 'szNbrInvoWarrant'.
     * 
     * @param szNbrInvoWarrant the value of field 'szNbrInvoWarrant'
     */
    public void setSzNbrInvoWarrant(java.lang.String szNbrInvoWarrant)
    {
        this._szNbrInvoWarrant = szNbrInvoWarrant;
    } //-- void setSzNbrInvoWarrant(java.lang.String) 

    /**
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

    /**
     * Sets the value of field 'ulIdInvoInvoice'.
     * 
     * @param ulIdInvoInvoice the value of field 'ulIdInvoInvoice'.
     */
    public void setUlIdInvoInvoice(int ulIdInvoInvoice)
    {
        this._ulIdInvoInvoice = ulIdInvoInvoice;
        this._has_ulIdInvoInvoice = true;
    } //-- void setUlIdInvoInvoice(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN21SOG00 unmarshal(java.io.Reader) 

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
