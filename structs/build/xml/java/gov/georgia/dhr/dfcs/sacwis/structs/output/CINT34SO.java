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
 * Class CINT34SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINT34SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT51DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO _ROWCINT51DO;

    /**
     * Field _ROWCINT49DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY _ROWCINT49DO_ARRAY;

    /**
     * Field _ROWCINT50DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY _ROWCINT50DO_ARRAY;

    /**
     * Field _ROWCINT52DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY _ROWCINT52DO_ARRAY;

    /**
     * Field _ROWCINT48DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY _ROWCINT48DO_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINT34SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO()


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
     * Returns the value of field 'ROWCINT48DO_ARRAY'.
     * 
     * @return the value of field 'ROWCINT48DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY getROWCINT48DO_ARRAY()
    {
        return this._ROWCINT48DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY getROWCINT48DO_ARRAY() 

    /**
     * Returns the value of field 'ROWCINT49DO_ARRAY'.
     * 
     * @return the value of field 'ROWCINT49DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY getROWCINT49DO_ARRAY()
    {
        return this._ROWCINT49DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY getROWCINT49DO_ARRAY() 

    /**
     * Returns the value of field 'ROWCINT50DO_ARRAY'.
     * 
     * @return the value of field 'ROWCINT50DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY getROWCINT50DO_ARRAY()
    {
        return this._ROWCINT50DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY getROWCINT50DO_ARRAY() 

    /**
     * Returns the value of field 'ROWCINT51DO'.
     * 
     * @return the value of field 'ROWCINT51DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO getROWCINT51DO()
    {
        return this._ROWCINT51DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO getROWCINT51DO() 

    /**
     * Returns the value of field 'ROWCINT52DO_ARRAY'.
     * 
     * @return the value of field 'ROWCINT52DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY getROWCINT52DO_ARRAY()
    {
        return this._ROWCINT52DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY getROWCINT52DO_ARRAY() 

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
     * Sets the value of field 'ROWCINT48DO_ARRAY'.
     * 
     * @param ROWCINT48DO_ARRAY the value of field
     * 'ROWCINT48DO_ARRAY'.
     */
    public void setROWCINT48DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY ROWCINT48DO_ARRAY)
    {
        this._ROWCINT48DO_ARRAY = ROWCINT48DO_ARRAY;
    } //-- void setROWCINT48DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY) 

    /**
     * Sets the value of field 'ROWCINT49DO_ARRAY'.
     * 
     * @param ROWCINT49DO_ARRAY the value of field
     * 'ROWCINT49DO_ARRAY'.
     */
    public void setROWCINT49DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY ROWCINT49DO_ARRAY)
    {
        this._ROWCINT49DO_ARRAY = ROWCINT49DO_ARRAY;
    } //-- void setROWCINT49DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT49DO_ARRAY) 

    /**
     * Sets the value of field 'ROWCINT50DO_ARRAY'.
     * 
     * @param ROWCINT50DO_ARRAY the value of field
     * 'ROWCINT50DO_ARRAY'.
     */
    public void setROWCINT50DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY ROWCINT50DO_ARRAY)
    {
        this._ROWCINT50DO_ARRAY = ROWCINT50DO_ARRAY;
    } //-- void setROWCINT50DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY) 

    /**
     * Sets the value of field 'ROWCINT51DO'.
     * 
     * @param ROWCINT51DO the value of field 'ROWCINT51DO'.
     */
    public void setROWCINT51DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO ROWCINT51DO)
    {
        this._ROWCINT51DO = ROWCINT51DO;
    } //-- void setROWCINT51DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO) 

    /**
     * Sets the value of field 'ROWCINT52DO_ARRAY'.
     * 
     * @param ROWCINT52DO_ARRAY the value of field
     * 'ROWCINT52DO_ARRAY'.
     */
    public void setROWCINT52DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY ROWCINT52DO_ARRAY)
    {
        this._ROWCINT52DO_ARRAY = ROWCINT52DO_ARRAY;
    } //-- void setROWCINT52DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO unmarshal(java.io.Reader) 

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
