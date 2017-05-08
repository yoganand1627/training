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
 * Class ROWCCMNH7DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMNH7DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdOnCallCounty
     */
    private java.lang.String _szCdOnCallCounty;

    /**
     * Field _dtLastUpdate
     */
    private org.exolab.castor.types.Date _dtLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMNH7DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'dtLastUpdate'.
     * 
     * @return the value of field 'DtLastUpdate'.
     */
    public org.exolab.castor.types.Date getDtLastUpdate()
    {
        return this._dtLastUpdate;
    } //-- org.exolab.castor.types.Date getDtLastUpdate() 

    /**
     * Returns the value of field 'szCdOnCallCounty'.
     * 
     * @return the value of field 'SzCdOnCallCounty'.
     */
    public java.lang.String getSzCdOnCallCounty()
    {
        return this._szCdOnCallCounty;
    } //-- java.lang.String getSzCdOnCallCounty() 

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
     * Sets the value of field 'dtLastUpdate'.
     * 
     * @param dtLastUpdate the value of field 'dtLastUpdate'.
     */
    public void setDtLastUpdate(org.exolab.castor.types.Date dtLastUpdate)
    {
        this._dtLastUpdate = dtLastUpdate;
    } //-- void setDtLastUpdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdOnCallCounty'.
     * 
     * @param szCdOnCallCounty the value of field 'szCdOnCallCounty'
     */
    public void setSzCdOnCallCounty(java.lang.String szCdOnCallCounty)
    {
        this._szCdOnCallCounty = szCdOnCallCounty;
    } //-- void setSzCdOnCallCounty(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO unmarshal(java.io.Reader) 

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
