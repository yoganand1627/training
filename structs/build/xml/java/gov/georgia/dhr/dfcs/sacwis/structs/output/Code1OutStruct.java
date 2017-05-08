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
 * Class Code1OutStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Code1OutStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szAddrPersAddrStLn1
     */
    private java.lang.String _szAddrPersAddrStLn1;

    /**
     * Field _szAddrPersAddrStLn2
     */
    private java.lang.String _szAddrPersAddrStLn2;

    /**
     * Field _szAddrCity
     */
    private java.lang.String _szAddrCity;

    /**
     * Field _szCdAddrState
     */
    private java.lang.String _szCdAddrState;

    /**
     * Field _lAddrZip
     */
    private java.lang.String _lAddrZip;

    /**
     * Field _szAddrCode1County
     */
    private java.lang.String _szAddrCode1County;

    /**
     * Field _szSysCode1CntyCode
     */
    private java.lang.String _szSysCode1CntyCode;

    /**
     * Field _usSysNbrCode1ReturnCode
     */
    private int _usSysNbrCode1ReturnCode;

    /**
     * keeps track of state for field: _usSysNbrCode1ReturnCode
     */
    private boolean _has_usSysNbrCode1ReturnCode;


      //----------------/
     //- Constructors -/
    //----------------/

    public Code1OutStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUsSysNbrCode1ReturnCode()
    {
        this._has_usSysNbrCode1ReturnCode= false;
    } //-- void deleteUsSysNbrCode1ReturnCode() 

    /**
     * Returns the value of field 'lAddrZip'.
     * 
     * @return the value of field 'LAddrZip'.
     */
    public java.lang.String getLAddrZip()
    {
        return this._lAddrZip;
    } //-- java.lang.String getLAddrZip() 

    /**
     * Returns the value of field 'szAddrCity'.
     * 
     * @return the value of field 'SzAddrCity'.
     */
    public java.lang.String getSzAddrCity()
    {
        return this._szAddrCity;
    } //-- java.lang.String getSzAddrCity() 

    /**
     * Returns the value of field 'szAddrCode1County'.
     * 
     * @return the value of field 'SzAddrCode1County'.
     */
    public java.lang.String getSzAddrCode1County()
    {
        return this._szAddrCode1County;
    } //-- java.lang.String getSzAddrCode1County() 

    /**
     * Returns the value of field 'szAddrPersAddrStLn1'.
     * 
     * @return the value of field 'SzAddrPersAddrStLn1'.
     */
    public java.lang.String getSzAddrPersAddrStLn1()
    {
        return this._szAddrPersAddrStLn1;
    } //-- java.lang.String getSzAddrPersAddrStLn1() 

    /**
     * Returns the value of field 'szAddrPersAddrStLn2'.
     * 
     * @return the value of field 'SzAddrPersAddrStLn2'.
     */
    public java.lang.String getSzAddrPersAddrStLn2()
    {
        return this._szAddrPersAddrStLn2;
    } //-- java.lang.String getSzAddrPersAddrStLn2() 

    /**
     * Returns the value of field 'szCdAddrState'.
     * 
     * @return the value of field 'SzCdAddrState'.
     */
    public java.lang.String getSzCdAddrState()
    {
        return this._szCdAddrState;
    } //-- java.lang.String getSzCdAddrState() 

    /**
     * Returns the value of field 'szSysCode1CntyCode'.
     * 
     * @return the value of field 'SzSysCode1CntyCode'.
     */
    public java.lang.String getSzSysCode1CntyCode()
    {
        return this._szSysCode1CntyCode;
    } //-- java.lang.String getSzSysCode1CntyCode() 

    /**
     * Returns the value of field 'usSysNbrCode1ReturnCode'.
     * 
     * @return the value of field 'UsSysNbrCode1ReturnCode'.
     */
    public int getUsSysNbrCode1ReturnCode()
    {
        return this._usSysNbrCode1ReturnCode;
    } //-- int getUsSysNbrCode1ReturnCode() 

    /**
     * Method hasUsSysNbrCode1ReturnCode
     * 
     * 
     * 
     * @return true if at least one UsSysNbrCode1ReturnCode has
     * been added
     */
    public boolean hasUsSysNbrCode1ReturnCode()
    {
        return this._has_usSysNbrCode1ReturnCode;
    } //-- boolean hasUsSysNbrCode1ReturnCode() 

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
     * Sets the value of field 'lAddrZip'.
     * 
     * @param lAddrZip the value of field 'lAddrZip'.
     */
    public void setLAddrZip(java.lang.String lAddrZip)
    {
        this._lAddrZip = lAddrZip;
    } //-- void setLAddrZip(java.lang.String) 

    /**
     * Sets the value of field 'szAddrCity'.
     * 
     * @param szAddrCity the value of field 'szAddrCity'.
     */
    public void setSzAddrCity(java.lang.String szAddrCity)
    {
        this._szAddrCity = szAddrCity;
    } //-- void setSzAddrCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrCode1County'.
     * 
     * @param szAddrCode1County the value of field
     * 'szAddrCode1County'.
     */
    public void setSzAddrCode1County(java.lang.String szAddrCode1County)
    {
        this._szAddrCode1County = szAddrCode1County;
    } //-- void setSzAddrCode1County(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPersAddrStLn1'.
     * 
     * @param szAddrPersAddrStLn1 the value of field
     * 'szAddrPersAddrStLn1'.
     */
    public void setSzAddrPersAddrStLn1(java.lang.String szAddrPersAddrStLn1)
    {
        this._szAddrPersAddrStLn1 = szAddrPersAddrStLn1;
    } //-- void setSzAddrPersAddrStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrPersAddrStLn2'.
     * 
     * @param szAddrPersAddrStLn2 the value of field
     * 'szAddrPersAddrStLn2'.
     */
    public void setSzAddrPersAddrStLn2(java.lang.String szAddrPersAddrStLn2)
    {
        this._szAddrPersAddrStLn2 = szAddrPersAddrStLn2;
    } //-- void setSzAddrPersAddrStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szCdAddrState'.
     * 
     * @param szCdAddrState the value of field 'szCdAddrState'.
     */
    public void setSzCdAddrState(java.lang.String szCdAddrState)
    {
        this._szCdAddrState = szCdAddrState;
    } //-- void setSzCdAddrState(java.lang.String) 

    /**
     * Sets the value of field 'szSysCode1CntyCode'.
     * 
     * @param szSysCode1CntyCode the value of field
     * 'szSysCode1CntyCode'.
     */
    public void setSzSysCode1CntyCode(java.lang.String szSysCode1CntyCode)
    {
        this._szSysCode1CntyCode = szSysCode1CntyCode;
    } //-- void setSzSysCode1CntyCode(java.lang.String) 

    /**
     * Sets the value of field 'usSysNbrCode1ReturnCode'.
     * 
     * @param usSysNbrCode1ReturnCode the value of field
     * 'usSysNbrCode1ReturnCode'.
     */
    public void setUsSysNbrCode1ReturnCode(int usSysNbrCode1ReturnCode)
    {
        this._usSysNbrCode1ReturnCode = usSysNbrCode1ReturnCode;
        this._has_usSysNbrCode1ReturnCode = true;
    } //-- void setUsSysNbrCode1ReturnCode(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct unmarshal(java.io.Reader) 

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
