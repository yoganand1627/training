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
 * Class ROWCCFC33SOG01.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC33SOG01 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdStage_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY _ulIdStage_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC33SOG01() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ulIdStage_ARRAY'.
     * 
     * @return the value of field 'UlIdStage_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY getUlIdStage_ARRAY()
    {
        return this._ulIdStage_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY getUlIdStage_ARRAY() 

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
     * Sets the value of field 'ulIdStage_ARRAY'.
     * 
     * @param ulIdStage_ARRAY the value of field 'ulIdStage_ARRAY'.
     */
    public void setUlIdStage_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY ulIdStage_ARRAY)
    {
        this._ulIdStage_ARRAY = ulIdStage_ARRAY;
    } //-- void setUlIdStage_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01 unmarshal(java.io.Reader) 

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
