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
 * Class CSUB63SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB63SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CSUB63SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG00 _CSUB63SOG00;

    /**
     * Field _CSUB63SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG01 _CSUB63SOG01;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB63SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO()


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
     * Returns the value of field 'CSUB63SOG00'.
     * 
     * @return the value of field 'CSUB63SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG00 getCSUB63SOG00()
    {
        return this._CSUB63SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG00 getCSUB63SOG00() 

    /**
     * Returns the value of field 'CSUB63SOG01'.
     * 
     * @return the value of field 'CSUB63SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG01 getCSUB63SOG01()
    {
        return this._CSUB63SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG01 getCSUB63SOG01() 

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
     * Sets the value of field 'CSUB63SOG00'.
     * 
     * @param CSUB63SOG00 the value of field 'CSUB63SOG00'.
     */
    public void setCSUB63SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG00 CSUB63SOG00)
    {
        this._CSUB63SOG00 = CSUB63SOG00;
    } //-- void setCSUB63SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG00) 

    /**
     * Sets the value of field 'CSUB63SOG01'.
     * 
     * @param CSUB63SOG01 the value of field 'CSUB63SOG01'.
     */
    public void setCSUB63SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG01 CSUB63SOG01)
    {
        this._CSUB63SOG01 = CSUB63SOG01;
    } //-- void setCSUB63SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SOG01) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO unmarshal(java.io.Reader) 

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
