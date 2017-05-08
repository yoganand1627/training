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
 * Class CSUB36SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB36SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bWCDIndMoreData
     */
    private java.lang.String _bWCDIndMoreData;

    /**
     * Field _ROWCSUB36SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY _ROWCSUB36SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB36SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB36SO()


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
     * Returns the value of field 'bWCDIndMoreData'.
     * 
     * @return the value of field 'BWCDIndMoreData'.
     */
    public java.lang.String getBWCDIndMoreData()
    {
        return this._bWCDIndMoreData;
    } //-- java.lang.String getBWCDIndMoreData() 

    /**
     * Returns the value of field 'ROWCSUB36SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB36SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY getROWCSUB36SOG00_ARRAY()
    {
        return this._ROWCSUB36SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY getROWCSUB36SOG00_ARRAY() 

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
     * Sets the value of field 'bWCDIndMoreData'.
     * 
     * @param bWCDIndMoreData the value of field 'bWCDIndMoreData'.
     */
    public void setBWCDIndMoreData(java.lang.String bWCDIndMoreData)
    {
        this._bWCDIndMoreData = bWCDIndMoreData;
    } //-- void setBWCDIndMoreData(java.lang.String) 

    /**
     * Sets the value of field 'ROWCSUB36SOG00_ARRAY'.
     * 
     * @param ROWCSUB36SOG00_ARRAY the value of field
     * 'ROWCSUB36SOG00_ARRAY'.
     */
    public void setROWCSUB36SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY ROWCSUB36SOG00_ARRAY)
    {
        this._ROWCSUB36SOG00_ARRAY = ROWCSUB36SOG00_ARRAY;
    } //-- void setROWCSUB36SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB36SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB36SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB36SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB36SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB36SO unmarshal(java.io.Reader) 

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