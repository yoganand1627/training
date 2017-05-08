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
 * Class CINV30SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV30SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szAddrProfAssmtCity
     */
    private java.lang.String _szAddrProfAssmtCity;

    /**
     * Field _szAddrProfAssmtStLn1
     */
    private java.lang.String _szAddrProfAssmtStLn1;

    /**
     * Field _szAddrProfAssmtStLn2
     */
    private java.lang.String _szAddrProfAssmtStLn2;

    /**
     * Field _szAddrProfAssmtZip
     */
    private java.lang.String _szAddrProfAssmtZip;

    /**
     * Field _szCdProfAssmtCounty
     */
    private java.lang.String _szCdProfAssmtCounty;

    /**
     * Field _szAddrProfAssmtState
     */
    private java.lang.String _szAddrProfAssmtState;

    /**
     * Field _lNbrPhone
     */
    private java.lang.String _lNbrPhone;

    /**
     * Field _lNbrPhoneExtension
     */
    private java.lang.String _lNbrPhoneExtension;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV30SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'lNbrPhone'.
     * 
     * @return the value of field 'LNbrPhone'.
     */
    public java.lang.String getLNbrPhone()
    {
        return this._lNbrPhone;
    } //-- java.lang.String getLNbrPhone() 

    /**
     * Returns the value of field 'lNbrPhoneExtension'.
     * 
     * @return the value of field 'LNbrPhoneExtension'.
     */
    public java.lang.String getLNbrPhoneExtension()
    {
        return this._lNbrPhoneExtension;
    } //-- java.lang.String getLNbrPhoneExtension() 

    /**
     * Returns the value of field 'szAddrProfAssmtCity'.
     * 
     * @return the value of field 'SzAddrProfAssmtCity'.
     */
    public java.lang.String getSzAddrProfAssmtCity()
    {
        return this._szAddrProfAssmtCity;
    } //-- java.lang.String getSzAddrProfAssmtCity() 

    /**
     * Returns the value of field 'szAddrProfAssmtStLn1'.
     * 
     * @return the value of field 'SzAddrProfAssmtStLn1'.
     */
    public java.lang.String getSzAddrProfAssmtStLn1()
    {
        return this._szAddrProfAssmtStLn1;
    } //-- java.lang.String getSzAddrProfAssmtStLn1() 

    /**
     * Returns the value of field 'szAddrProfAssmtStLn2'.
     * 
     * @return the value of field 'SzAddrProfAssmtStLn2'.
     */
    public java.lang.String getSzAddrProfAssmtStLn2()
    {
        return this._szAddrProfAssmtStLn2;
    } //-- java.lang.String getSzAddrProfAssmtStLn2() 

    /**
     * Returns the value of field 'szAddrProfAssmtState'.
     * 
     * @return the value of field 'SzAddrProfAssmtState'.
     */
    public java.lang.String getSzAddrProfAssmtState()
    {
        return this._szAddrProfAssmtState;
    } //-- java.lang.String getSzAddrProfAssmtState() 

    /**
     * Returns the value of field 'szAddrProfAssmtZip'.
     * 
     * @return the value of field 'SzAddrProfAssmtZip'.
     */
    public java.lang.String getSzAddrProfAssmtZip()
    {
        return this._szAddrProfAssmtZip;
    } //-- java.lang.String getSzAddrProfAssmtZip() 

    /**
     * Returns the value of field 'szCdProfAssmtCounty'.
     * 
     * @return the value of field 'SzCdProfAssmtCounty'.
     */
    public java.lang.String getSzCdProfAssmtCounty()
    {
        return this._szCdProfAssmtCounty;
    } //-- java.lang.String getSzCdProfAssmtCounty() 

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
     * Sets the value of field 'lNbrPhone'.
     * 
     * @param lNbrPhone the value of field 'lNbrPhone'.
     */
    public void setLNbrPhone(java.lang.String lNbrPhone)
    {
        this._lNbrPhone = lNbrPhone;
    } //-- void setLNbrPhone(java.lang.String) 

    /**
     * Sets the value of field 'lNbrPhoneExtension'.
     * 
     * @param lNbrPhoneExtension the value of field
     * 'lNbrPhoneExtension'.
     */
    public void setLNbrPhoneExtension(java.lang.String lNbrPhoneExtension)
    {
        this._lNbrPhoneExtension = lNbrPhoneExtension;
    } //-- void setLNbrPhoneExtension(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtCity'.
     * 
     * @param szAddrProfAssmtCity the value of field
     * 'szAddrProfAssmtCity'.
     */
    public void setSzAddrProfAssmtCity(java.lang.String szAddrProfAssmtCity)
    {
        this._szAddrProfAssmtCity = szAddrProfAssmtCity;
    } //-- void setSzAddrProfAssmtCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtStLn1'.
     * 
     * @param szAddrProfAssmtStLn1 the value of field
     * 'szAddrProfAssmtStLn1'.
     */
    public void setSzAddrProfAssmtStLn1(java.lang.String szAddrProfAssmtStLn1)
    {
        this._szAddrProfAssmtStLn1 = szAddrProfAssmtStLn1;
    } //-- void setSzAddrProfAssmtStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtStLn2'.
     * 
     * @param szAddrProfAssmtStLn2 the value of field
     * 'szAddrProfAssmtStLn2'.
     */
    public void setSzAddrProfAssmtStLn2(java.lang.String szAddrProfAssmtStLn2)
    {
        this._szAddrProfAssmtStLn2 = szAddrProfAssmtStLn2;
    } //-- void setSzAddrProfAssmtStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtState'.
     * 
     * @param szAddrProfAssmtState the value of field
     * 'szAddrProfAssmtState'.
     */
    public void setSzAddrProfAssmtState(java.lang.String szAddrProfAssmtState)
    {
        this._szAddrProfAssmtState = szAddrProfAssmtState;
    } //-- void setSzAddrProfAssmtState(java.lang.String) 

    /**
     * Sets the value of field 'szAddrProfAssmtZip'.
     * 
     * @param szAddrProfAssmtZip the value of field
     * 'szAddrProfAssmtZip'.
     */
    public void setSzAddrProfAssmtZip(java.lang.String szAddrProfAssmtZip)
    {
        this._szAddrProfAssmtZip = szAddrProfAssmtZip;
    } //-- void setSzAddrProfAssmtZip(java.lang.String) 

    /**
     * Sets the value of field 'szCdProfAssmtCounty'.
     * 
     * @param szCdProfAssmtCounty the value of field
     * 'szCdProfAssmtCounty'.
     */
    public void setSzCdProfAssmtCounty(java.lang.String szCdProfAssmtCounty)
    {
        this._szCdProfAssmtCounty = szCdProfAssmtCounty;
    } //-- void setSzCdProfAssmtCounty(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO unmarshal(java.io.Reader) 

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
