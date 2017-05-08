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
 * Class ROWCCON22SOG02.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON22SOG02 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdCnsvcPaymentType
     */
    private java.lang.String _szCdCnsvcPaymentType;

    /**
     * Field _szCdCnsvcService
     */
    private java.lang.String _szCdCnsvcService;

    /**
     * Field _szNbrCnsvcUnitType
     */
    private java.lang.String _szNbrCnsvcUnitType;

    /**
     * Field _ulNbrCnsvcLineItem
     */
    private int _ulNbrCnsvcLineItem;

    /**
     * keeps track of state for field: _ulNbrCnsvcLineItem
     */
    private boolean _has_ulNbrCnsvcLineItem;

    /**
     * Field _ulNbrCnsvcUnitRate
     */
    private double _ulNbrCnsvcUnitRate;

    /**
     * keeps track of state for field: _ulNbrCnsvcUnitRate
     */
    private boolean _has_ulNbrCnsvcUnitRate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON22SOG02() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlNbrCnsvcLineItem()
    {
        this._has_ulNbrCnsvcLineItem= false;
    } //-- void deleteUlNbrCnsvcLineItem() 

    /**
     */
    public void deleteUlNbrCnsvcUnitRate()
    {
        this._has_ulNbrCnsvcUnitRate= false;
    } //-- void deleteUlNbrCnsvcUnitRate() 

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
     * Returns the value of field 'szCdCnsvcService'.
     * 
     * @return the value of field 'SzCdCnsvcService'.
     */
    public java.lang.String getSzCdCnsvcService()
    {
        return this._szCdCnsvcService;
    } //-- java.lang.String getSzCdCnsvcService() 

    /**
     * Returns the value of field 'szNbrCnsvcUnitType'.
     * 
     * @return the value of field 'SzNbrCnsvcUnitType'.
     */
    public java.lang.String getSzNbrCnsvcUnitType()
    {
        return this._szNbrCnsvcUnitType;
    } //-- java.lang.String getSzNbrCnsvcUnitType() 

    /**
     * Returns the value of field 'ulNbrCnsvcLineItem'.
     * 
     * @return the value of field 'UlNbrCnsvcLineItem'.
     */
    public int getUlNbrCnsvcLineItem()
    {
        return this._ulNbrCnsvcLineItem;
    } //-- int getUlNbrCnsvcLineItem() 

    /**
     * Returns the value of field 'ulNbrCnsvcUnitRate'.
     * 
     * @return the value of field 'UlNbrCnsvcUnitRate'.
     */
    public double getUlNbrCnsvcUnitRate()
    {
        return this._ulNbrCnsvcUnitRate;
    } //-- double getUlNbrCnsvcUnitRate() 

    /**
     * Method hasUlNbrCnsvcLineItem
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcLineItem has been adde
     */
    public boolean hasUlNbrCnsvcLineItem()
    {
        return this._has_ulNbrCnsvcLineItem;
    } //-- boolean hasUlNbrCnsvcLineItem() 

    /**
     * Method hasUlNbrCnsvcUnitRate
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcUnitRate has been adde
     */
    public boolean hasUlNbrCnsvcUnitRate()
    {
        return this._has_ulNbrCnsvcUnitRate;
    } //-- boolean hasUlNbrCnsvcUnitRate() 

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
     * Sets the value of field 'szCdCnsvcService'.
     * 
     * @param szCdCnsvcService the value of field 'szCdCnsvcService'
     */
    public void setSzCdCnsvcService(java.lang.String szCdCnsvcService)
    {
        this._szCdCnsvcService = szCdCnsvcService;
    } //-- void setSzCdCnsvcService(java.lang.String) 

    /**
     * Sets the value of field 'szNbrCnsvcUnitType'.
     * 
     * @param szNbrCnsvcUnitType the value of field
     * 'szNbrCnsvcUnitType'.
     */
    public void setSzNbrCnsvcUnitType(java.lang.String szNbrCnsvcUnitType)
    {
        this._szNbrCnsvcUnitType = szNbrCnsvcUnitType;
    } //-- void setSzNbrCnsvcUnitType(java.lang.String) 

    /**
     * Sets the value of field 'ulNbrCnsvcLineItem'.
     * 
     * @param ulNbrCnsvcLineItem the value of field
     * 'ulNbrCnsvcLineItem'.
     */
    public void setUlNbrCnsvcLineItem(int ulNbrCnsvcLineItem)
    {
        this._ulNbrCnsvcLineItem = ulNbrCnsvcLineItem;
        this._has_ulNbrCnsvcLineItem = true;
    } //-- void setUlNbrCnsvcLineItem(int) 

    /**
     * Sets the value of field 'ulNbrCnsvcUnitRate'.
     * 
     * @param ulNbrCnsvcUnitRate the value of field
     * 'ulNbrCnsvcUnitRate'.
     */
    public void setUlNbrCnsvcUnitRate(double ulNbrCnsvcUnitRate)
    {
        this._ulNbrCnsvcUnitRate = ulNbrCnsvcUnitRate;
        this._has_ulNbrCnsvcUnitRate = true;
    } //-- void setUlNbrCnsvcUnitRate(double) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02 unmarshal(java.io.Reader) 

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
