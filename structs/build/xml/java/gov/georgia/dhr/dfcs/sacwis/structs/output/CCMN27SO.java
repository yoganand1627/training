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
 * Class CCMN27SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN27SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _tsSysTsLastUpdate3
     */
    private java.util.Date _tsSysTsLastUpdate3;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN27SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO()


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
     * Returns the value of field 'tsSysTsLastUpdate2'.
     * 
     * @return the value of field 'TsSysTsLastUpdate2'.
     */
    public java.util.Date getTsSysTsLastUpdate2()
    {
        return this._tsSysTsLastUpdate2;
    } //-- java.util.Date getTsSysTsLastUpdate2() 

    /**
     * Returns the value of field 'tsSysTsLastUpdate3'.
     * 
     * @return the value of field 'TsSysTsLastUpdate3'.
     */
    public java.util.Date getTsSysTsLastUpdate3()
    {
        return this._tsSysTsLastUpdate3;
    } //-- java.util.Date getTsSysTsLastUpdate3() 

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
     * Sets the value of field 'tsSysTsLastUpdate2'.
     * 
     * @param tsSysTsLastUpdate2 the value of field
     * 'tsSysTsLastUpdate2'.
     */
    public void setTsSysTsLastUpdate2(java.util.Date tsSysTsLastUpdate2)
    {
        this._tsSysTsLastUpdate2 = tsSysTsLastUpdate2;
    } //-- void setTsSysTsLastUpdate2(java.util.Date) 

    /**
     * Sets the value of field 'tsSysTsLastUpdate3'.
     * 
     * @param tsSysTsLastUpdate3 the value of field
     * 'tsSysTsLastUpdate3'.
     */
    public void setTsSysTsLastUpdate3(java.util.Date tsSysTsLastUpdate3)
    {
        this._tsSysTsLastUpdate3 = tsSysTsLastUpdate3;
    } //-- void setTsSysTsLastUpdate3(java.util.Date) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO unmarshal(java.io.Reader) 

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
