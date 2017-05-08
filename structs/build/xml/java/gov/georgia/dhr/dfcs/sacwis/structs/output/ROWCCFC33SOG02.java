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
 * Class ROWCCFC33SOG02.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC33SOG02 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdEvent_ARRAY_CCFC33S
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CCFC33S _ulIdEvent_ARRAY_CCFC33S;

    /**
     * Field _ulSysNbrUlongKey_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY _ulSysNbrUlongKey_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC33SOG02() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ulIdEvent_ARRAY_CCFC33S'.
     * 
     * @return the value of field 'UlIdEvent_ARRAY_CCFC33S'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CCFC33S getUlIdEvent_ARRAY_CCFC33S()
    {
        return this._ulIdEvent_ARRAY_CCFC33S;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CCFC33S getUlIdEvent_ARRAY_CCFC33S() 

    /**
     * Returns the value of field 'ulSysNbrUlongKey_ARRAY'.
     * 
     * @return the value of field 'UlSysNbrUlongKey_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY getUlSysNbrUlongKey_ARRAY()
    {
        return this._ulSysNbrUlongKey_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY getUlSysNbrUlongKey_ARRAY() 

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
     * Sets the value of field 'ulIdEvent_ARRAY_CCFC33S'.
     * 
     * @param ulIdEvent_ARRAY_CCFC33S the value of field
     * 'ulIdEvent_ARRAY_CCFC33S'.
     */
    public void setUlIdEvent_ARRAY_CCFC33S(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CCFC33S ulIdEvent_ARRAY_CCFC33S)
    {
        this._ulIdEvent_ARRAY_CCFC33S = ulIdEvent_ARRAY_CCFC33S;
    } //-- void setUlIdEvent_ARRAY_CCFC33S(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdEvent_ARRAY_CCFC33S) 

    /**
     * Sets the value of field 'ulSysNbrUlongKey_ARRAY'.
     * 
     * @param ulSysNbrUlongKey_ARRAY the value of field
     * 'ulSysNbrUlongKey_ARRAY'.
     */
    public void setUlSysNbrUlongKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY ulSysNbrUlongKey_ARRAY)
    {
        this._ulSysNbrUlongKey_ARRAY = ulSysNbrUlongKey_ARRAY;
    } //-- void setUlSysNbrUlongKey_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlSysNbrUlongKey_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02 unmarshal(java.io.Reader) 

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
