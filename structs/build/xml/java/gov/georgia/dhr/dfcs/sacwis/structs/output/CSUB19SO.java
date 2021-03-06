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
 * Class CSUB19SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB19SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdPersonSecondary_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY _ulIdPersonSecondary_ARRAY;

    /**
     * Field _tsLastUpdate_ARRAY_CSUB19SO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO _tsLastUpdate_ARRAY_CSUB19SO;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB19SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

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
     * Returns the value of field 'tsLastUpdate_ARRAY_CSUB19SO'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY_CSUB19SO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO getTsLastUpdate_ARRAY_CSUB19SO()
    {
        return this._tsLastUpdate_ARRAY_CSUB19SO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO getTsLastUpdate_ARRAY_CSUB19SO() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Returns the value of field 'ulIdPersonSecondary_ARRAY'.
     * 
     * @return the value of field 'UlIdPersonSecondary_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY getUlIdPersonSecondary_ARRAY()
    {
        return this._ulIdPersonSecondary_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY getUlIdPersonSecondary_ARRAY() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Sets the value of field 'tsLastUpdate_ARRAY_CSUB19SO'.
     * 
     * @param tsLastUpdate_ARRAY_CSUB19SO the value of field
     * 'tsLastUpdate_ARRAY_CSUB19SO'.
     */
    public void setTsLastUpdate_ARRAY_CSUB19SO(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO tsLastUpdate_ARRAY_CSUB19SO)
    {
        this._tsLastUpdate_ARRAY_CSUB19SO = tsLastUpdate_ARRAY_CSUB19SO;
    } //-- void setTsLastUpdate_ARRAY_CSUB19SO(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

    /**
     * Sets the value of field 'ulIdPersonSecondary_ARRAY'.
     * 
     * @param ulIdPersonSecondary_ARRAY the value of field
     * 'ulIdPersonSecondary_ARRAY'.
     */
    public void setUlIdPersonSecondary_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY ulIdPersonSecondary_ARRAY)
    {
        this._ulIdPersonSecondary_ARRAY = ulIdPersonSecondary_ARRAY;
    } //-- void setUlIdPersonSecondary_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO unmarshal(java.io.Reader) 

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
