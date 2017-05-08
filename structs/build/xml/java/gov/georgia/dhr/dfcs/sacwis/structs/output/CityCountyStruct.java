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
 * Class CityCountyStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CityCountyStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdCityTexCnty
     */
    private java.lang.String _szCdCityTexCnty;

    /**
     * Field _szNmCityCnty
     */
    private java.lang.String _szNmCityCnty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CityCountyStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'szNmCityCnty'.
     * 
     * @return the value of field 'SzNmCityCnty'.
     */
    public java.lang.String getSzNmCityCnty()
    {
        return this._szNmCityCnty;
    } //-- java.lang.String getSzNmCityCnty() 

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
     * Sets the value of field 'szCdCityTexCnty'.
     * 
     * @param szCdCityTexCnty the value of field 'szCdCityTexCnty'.
     */
    public void setSzCdCityTexCnty(java.lang.String szCdCityTexCnty)
    {
        this._szCdCityTexCnty = szCdCityTexCnty;
    } //-- void setSzCdCityTexCnty(java.lang.String) 

    /**
     * Sets the value of field 'szNmCityCnty'.
     * 
     * @param szNmCityCnty the value of field 'szNmCityCnty'.
     */
    public void setSzNmCityCnty(java.lang.String szNmCityCnty)
    {
        this._szNmCityCnty = szNmCityCnty;
    } //-- void setSzNmCityCnty(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct unmarshal(java.io.Reader) 

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
