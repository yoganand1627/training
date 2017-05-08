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
 * Class ValidAddrOutRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ValidAddrOutRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cityCountyStruct_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY _cityCountyStruct_ARRAY;

    /**
     * Field _szCdCityTexCnty
     */
    private java.lang.String _szCdCityTexCnty;

    /**
     * Field _code1OutStruct_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY _code1OutStruct_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public ValidAddrOutRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ValidAddrOutRec()


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
     * Returns the value of field 'cityCountyStruct_ARRAY'.
     * 
     * @return the value of field 'CityCountyStruct_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY getCityCountyStruct_ARRAY()
    {
        return this._cityCountyStruct_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY getCityCountyStruct_ARRAY() 

    /**
     * Returns the value of field 'code1OutStruct_ARRAY'.
     * 
     * @return the value of field 'Code1OutStruct_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY getCode1OutStruct_ARRAY()
    {
        return this._code1OutStruct_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY getCode1OutStruct_ARRAY() 

    /**
     * Returns the value of field 'szCdCityTexCnty'.
     * 
     * @return the value of field 'SzCdCityTexCnty'.
     */
    public java.lang.String getSzCdCityTexCnty()
    {
        return this._szCdCityTexCnty;
    } //-- java.lang.String getSzCdCityTexCnty() 

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
     * Sets the value of field 'cityCountyStruct_ARRAY'.
     * 
     * @param cityCountyStruct_ARRAY the value of field
     * 'cityCountyStruct_ARRAY'.
     */
    public void setCityCountyStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY cityCountyStruct_ARRAY)
    {
        this._cityCountyStruct_ARRAY = cityCountyStruct_ARRAY;
    } //-- void setCityCountyStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY) 

    /**
     * Sets the value of field 'code1OutStruct_ARRAY'.
     * 
     * @param code1OutStruct_ARRAY the value of field
     * 'code1OutStruct_ARRAY'.
     */
    public void setCode1OutStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY code1OutStruct_ARRAY)
    {
        this._code1OutStruct_ARRAY = code1OutStruct_ARRAY;
    } //-- void setCode1OutStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY) 

    /**
     * Sets the value of field 'szCdCityTexCnty'.
     * 
     * @param szCdCityTexCnty the value of field 'szCdCityTexCnty'.
     */
    public void setSzCdCityTexCnty(java.lang.String szCdCityTexCnty)
    {
        this._szCdCityTexCnty = szCdCityTexCnty;
    } //-- void setSzCdCityTexCnty(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ValidAddrOutRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ValidAddrOutRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ValidAddrOutRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ValidAddrOutRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ValidAddrOutRec unmarshal(java.io.Reader) 

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
