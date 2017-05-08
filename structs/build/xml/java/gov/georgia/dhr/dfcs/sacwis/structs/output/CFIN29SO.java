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
 * Class CFIN29SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN29SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dAmtSvcDtlUnitRate
     */
    private double _dAmtSvcDtlUnitRate;

    /**
     * keeps track of state for field: _dAmtSvcDtlUnitRate
     */
    private boolean _has_dAmtSvcDtlUnitRate;

    /**
     * Field _usNbrSvcDtlCsli
     */
    private int _usNbrSvcDtlCsli;

    /**
     * keeps track of state for field: _usNbrSvcDtlCsli
     */
    private boolean _has_usNbrSvcDtlCsli;

    /**
     * Field _ulIdSvcAuthDtl
     */
    private int _ulIdSvcAuthDtl;

    /**
     * keeps track of state for field: _ulIdSvcAuthDtl
     */
    private boolean _has_ulIdSvcAuthDtl;

    /**
     * Field _szCdSvcDtlUnitType
     */
    private java.lang.String _szCdSvcDtlUnitType;

    /**
     * Field _szCdCnsvcPaymentType
     */
    private java.lang.String _szCdCnsvcPaymentType;

    /**
     * Field _ulNbrCnverNoShowPct
     */
    private int _ulNbrCnverNoShowPct;

    /**
     * keeps track of state for field: _ulNbrCnverNoShowPct
     */
    private boolean _has_ulNbrCnverNoShowPct;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN29SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtSvcDtlUnitRate()
    {
        this._has_dAmtSvcDtlUnitRate= false;
    } //-- void deleteDAmtSvcDtlUnitRate() 

    /**
     */
    public void deleteUlIdSvcAuthDtl()
    {
        this._has_ulIdSvcAuthDtl= false;
    } //-- void deleteUlIdSvcAuthDtl() 

    /**
     */
    public void deleteUlNbrCnverNoShowPct()
    {
        this._has_ulNbrCnverNoShowPct= false;
    } //-- void deleteUlNbrCnverNoShowPct() 

    /**
     */
    public void deleteUsNbrSvcDtlCsli()
    {
        this._has_usNbrSvcDtlCsli= false;
    } //-- void deleteUsNbrSvcDtlCsli() 

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
     * Returns the value of field 'dAmtSvcDtlUnitRate'.
     * 
     * @return the value of field 'DAmtSvcDtlUnitRate'.
     */
    public double getDAmtSvcDtlUnitRate()
    {
        return this._dAmtSvcDtlUnitRate;
    } //-- double getDAmtSvcDtlUnitRate() 

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
     * Returns the value of field 'ulIdSvcAuthDtl'.
     * 
     * @return the value of field 'UlIdSvcAuthDtl'.
     */
    public int getUlIdSvcAuthDtl()
    {
        return this._ulIdSvcAuthDtl;
    } //-- int getUlIdSvcAuthDtl() 

    /**
     * Returns the value of field 'ulNbrCnverNoShowPct'.
     * 
     * @return the value of field 'UlNbrCnverNoShowPct'.
     */
    public int getUlNbrCnverNoShowPct()
    {
        return this._ulNbrCnverNoShowPct;
    } //-- int getUlNbrCnverNoShowPct() 

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
     * Method hasUlNbrCnverNoShowPct
     * 
     * 
     * 
     * @return true if at least one UlNbrCnverNoShowPct has been
     * added
     */
    public boolean hasUlNbrCnverNoShowPct()
    {
        return this._has_ulNbrCnverNoShowPct;
    } //-- boolean hasUlNbrCnverNoShowPct() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

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
     * Sets the value of field 'ulNbrCnverNoShowPct'.
     * 
     * @param ulNbrCnverNoShowPct the value of field
     * 'ulNbrCnverNoShowPct'.
     */
    public void setUlNbrCnverNoShowPct(int ulNbrCnverNoShowPct)
    {
        this._ulNbrCnverNoShowPct = ulNbrCnverNoShowPct;
        this._has_ulNbrCnverNoShowPct = true;
    } //-- void setUlNbrCnverNoShowPct(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO unmarshal(java.io.Reader) 

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
