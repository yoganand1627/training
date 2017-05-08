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
 * Class ROWCCFC33SOG03.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC33SOG03 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPerson_ARRAY_CCFC33S
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPerson_ARRAY_CCFC33S _ulIdPerson_ARRAY_CCFC33S;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC33SOG03() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ulIdPerson_ARRAY_CCFC33S'.
     * 
     * @return the value of field 'UlIdPerson_ARRAY_CCFC33S'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPerson_ARRAY_CCFC33S getUlIdPerson_ARRAY_CCFC33S()
    {
        return this._ulIdPerson_ARRAY_CCFC33S;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPerson_ARRAY_CCFC33S getUlIdPerson_ARRAY_CCFC33S() 

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
     * Sets the value of field 'ulIdPerson_ARRAY_CCFC33S'.
     * 
     * @param ulIdPerson_ARRAY_CCFC33S the value of field
     * 'ulIdPerson_ARRAY_CCFC33S'.
     */
    public void setUlIdPerson_ARRAY_CCFC33S(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPerson_ARRAY_CCFC33S ulIdPerson_ARRAY_CCFC33S)
    {
        this._ulIdPerson_ARRAY_CCFC33S = ulIdPerson_ARRAY_CCFC33S;
    } //-- void setUlIdPerson_ARRAY_CCFC33S(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPerson_ARRAY_CCFC33S) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03 unmarshal(java.io.Reader) 

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
