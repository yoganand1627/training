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
 * Class ROWCCON15SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON15SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdRsrcSvcService
     */
    private java.lang.String _szCdRsrcSvcService;

    /**
     * Field _szCdRsrcSvcServiceType
     */
    private java.lang.String _szCdRsrcSvcServiceType;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON15SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'szCdRsrcSvcService'.
     * 
     * @return the value of field 'SzCdRsrcSvcService'.
     */
    public java.lang.String getSzCdRsrcSvcService()
    {
        return this._szCdRsrcSvcService;
    } //-- java.lang.String getSzCdRsrcSvcService() 

    /**
     * Returns the value of field 'szCdRsrcSvcServiceType'.
     * 
     * @return the value of field 'SzCdRsrcSvcServiceType'.
     */
    public java.lang.String getSzCdRsrcSvcServiceType()
    {
        return this._szCdRsrcSvcServiceType;
    } //-- java.lang.String getSzCdRsrcSvcServiceType() 

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
     * Sets the value of field 'szCdRsrcSvcService'.
     * 
     * @param szCdRsrcSvcService the value of field
     * 'szCdRsrcSvcService'.
     */
    public void setSzCdRsrcSvcService(java.lang.String szCdRsrcSvcService)
    {
        this._szCdRsrcSvcService = szCdRsrcSvcService;
    } //-- void setSzCdRsrcSvcService(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSvcServiceType'.
     * 
     * @param szCdRsrcSvcServiceType the value of field
     * 'szCdRsrcSvcServiceType'.
     */
    public void setSzCdRsrcSvcServiceType(java.lang.String szCdRsrcSvcServiceType)
    {
        this._szCdRsrcSvcServiceType = szCdRsrcSvcServiceType;
    } //-- void setSzCdRsrcSvcServiceType(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01 unmarshal(java.io.Reader) 

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
