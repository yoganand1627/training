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
 * Class CFIN19SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN19SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN19SOG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY _ROWCFIN19SOG_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN19SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO()


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
     * Returns the value of field 'ROWCFIN19SOG_ARRAY'.
     * 
     * @return the value of field 'ROWCFIN19SOG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY getROWCFIN19SOG_ARRAY()
    {
        return this._ROWCFIN19SOG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY getROWCFIN19SOG_ARRAY() 

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
     * Sets the value of field 'ROWCFIN19SOG_ARRAY'.
     * 
     * @param ROWCFIN19SOG_ARRAY the value of field
     * 'ROWCFIN19SOG_ARRAY'.
     */
    public void setROWCFIN19SOG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY ROWCFIN19SOG_ARRAY)
    {
        this._ROWCFIN19SOG_ARRAY = ROWCFIN19SOG_ARRAY;
    } //-- void setROWCFIN19SOG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO unmarshal(java.io.Reader) 

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