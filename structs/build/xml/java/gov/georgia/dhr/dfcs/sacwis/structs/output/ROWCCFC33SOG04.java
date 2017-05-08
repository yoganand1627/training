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
 * Class ROWCCFC33SOG04.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC33SOG04 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdCrimHist_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY _ulIdCrimHist_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC33SOG04() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ulIdCrimHist_ARRAY'.
     * 
     * @return the value of field 'UlIdCrimHist_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY getUlIdCrimHist_ARRAY()
    {
        return this._ulIdCrimHist_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY getUlIdCrimHist_ARRAY() 

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
     * Sets the value of field 'ulIdCrimHist_ARRAY'.
     * 
     * @param ulIdCrimHist_ARRAY the value of field
     * 'ulIdCrimHist_ARRAY'.
     */
    public void setUlIdCrimHist_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY ulIdCrimHist_ARRAY)
    {
        this._ulIdCrimHist_ARRAY = ulIdCrimHist_ARRAY;
    } //-- void setUlIdCrimHist_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04 unmarshal(java.io.Reader) 

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
