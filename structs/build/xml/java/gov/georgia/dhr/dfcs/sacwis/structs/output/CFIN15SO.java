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
 * Class CFIN15SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN15SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _ROWCFIN15SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG01_ARRAY _ROWCFIN15SOG01_ARRAY;

    /**
     * Field _ROWCFIN15SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY _ROWCFIN15SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN15SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

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
     * Returns the value of field 'ROWCFIN15SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCFIN15SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY getROWCFIN15SOG00_ARRAY()
    {
        return this._ROWCFIN15SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY getROWCFIN15SOG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCFIN15SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCFIN15SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG01_ARRAY getROWCFIN15SOG01_ARRAY()
    {
        return this._ROWCFIN15SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG01_ARRAY getROWCFIN15SOG01_ARRAY() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

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
     * Sets the value of field 'ROWCFIN15SOG00_ARRAY'.
     * 
     * @param ROWCFIN15SOG00_ARRAY the value of field
     * 'ROWCFIN15SOG00_ARRAY'.
     */
    public void setROWCFIN15SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY ROWCFIN15SOG00_ARRAY)
    {
        this._ROWCFIN15SOG00_ARRAY = ROWCFIN15SOG00_ARRAY;
    } //-- void setROWCFIN15SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCFIN15SOG01_ARRAY'.
     * 
     * @param ROWCFIN15SOG01_ARRAY the value of field
     * 'ROWCFIN15SOG01_ARRAY'.
     */
    public void setROWCFIN15SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG01_ARRAY ROWCFIN15SOG01_ARRAY)
    {
        this._ROWCFIN15SOG01_ARRAY = ROWCFIN15SOG01_ARRAY;
    } //-- void setROWCFIN15SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG01_ARRAY) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO unmarshal(java.io.Reader) 

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
