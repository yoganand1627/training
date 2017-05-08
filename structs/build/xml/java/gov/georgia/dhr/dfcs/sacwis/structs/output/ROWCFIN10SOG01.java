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
 * Class ROWCFIN10SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN10SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdCnsvcService
     */
    private java.lang.String _szCdCnsvcService;

    /**
     * Field _szCdCnsvcUnitType
     */
    private java.lang.String _szCdCnsvcUnitType;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN10SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'szCdCnsvcUnitType'.
     * 
     * @return the value of field 'SzCdCnsvcUnitType'.
     */
    public java.lang.String getSzCdCnsvcUnitType()
    {
        return this._szCdCnsvcUnitType;
    } //-- java.lang.String getSzCdCnsvcUnitType() 

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
     * Sets the value of field 'szCdCnsvcService'.
     * 
     * @param szCdCnsvcService the value of field 'szCdCnsvcService'
     */
    public void setSzCdCnsvcService(java.lang.String szCdCnsvcService)
    {
        this._szCdCnsvcService = szCdCnsvcService;
    } //-- void setSzCdCnsvcService(java.lang.String) 

    /**
     * Sets the value of field 'szCdCnsvcUnitType'.
     * 
     * @param szCdCnsvcUnitType the value of field
     * 'szCdCnsvcUnitType'.
     */
    public void setSzCdCnsvcUnitType(java.lang.String szCdCnsvcUnitType)
    {
        this._szCdCnsvcUnitType = szCdCnsvcUnitType;
    } //-- void setSzCdCnsvcUnitType(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01 unmarshal(java.io.Reader) 

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
