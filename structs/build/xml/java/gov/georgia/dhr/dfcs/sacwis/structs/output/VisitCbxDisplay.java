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
 * Class VisitCbxDisplay.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class VisitCbxDisplay extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdVisitCbxCodeType
     */
    private java.lang.String _szCdVisitCbxCodeType;

    /**
     * Field _szCdVisitTypeCbx
     */
    private java.lang.String _szCdVisitTypeCbx;


      //----------------/
     //- Constructors -/
    //----------------/

    public VisitCbxDisplay() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'szCdVisitCbxCodeType'.
     * 
     * @return the value of field 'SzCdVisitCbxCodeType'.
     */
    public java.lang.String getSzCdVisitCbxCodeType()
    {
        return this._szCdVisitCbxCodeType;
    } //-- java.lang.String getSzCdVisitCbxCodeType() 

    /**
     * Returns the value of field 'szCdVisitTypeCbx'.
     * 
     * @return the value of field 'SzCdVisitTypeCbx'.
     */
    public java.lang.String getSzCdVisitTypeCbx()
    {
        return this._szCdVisitTypeCbx;
    } //-- java.lang.String getSzCdVisitTypeCbx() 

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
     * Sets the value of field 'szCdVisitCbxCodeType'.
     * 
     * @param szCdVisitCbxCodeType the value of field
     * 'szCdVisitCbxCodeType'.
     */
    public void setSzCdVisitCbxCodeType(java.lang.String szCdVisitCbxCodeType)
    {
        this._szCdVisitCbxCodeType = szCdVisitCbxCodeType;
    } //-- void setSzCdVisitCbxCodeType(java.lang.String) 

    /**
     * Sets the value of field 'szCdVisitTypeCbx'.
     * 
     * @param szCdVisitTypeCbx the value of field 'szCdVisitTypeCbx'
     */
    public void setSzCdVisitTypeCbx(java.lang.String szCdVisitTypeCbx)
    {
        this._szCdVisitTypeCbx = szCdVisitTypeCbx;
    } //-- void setSzCdVisitTypeCbx(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay unmarshal(java.io.Reader) 

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
