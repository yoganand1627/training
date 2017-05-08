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
 * Class CSUB15SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB15SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdSUBStage
     */
    private int _ulIdSUBStage;

    /**
     * keeps track of state for field: _ulIdSUBStage
     */
    private boolean _has_ulIdSUBStage;

    /**
     * Field _tsLastUpdate_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY _tsLastUpdate_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB15SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO()


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
     */
    public void deleteUlIdSUBStage()
    {
        this._has_ulIdSUBStage= false;
    } //-- void deleteUlIdSUBStage() 

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
     * Returns the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY()
    {
        return this._tsLastUpdate_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY() 

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
     * Returns the value of field 'ulIdSUBStage'.
     * 
     * @return the value of field 'UlIdSUBStage'.
     */
    public int getUlIdSUBStage()
    {
        return this._ulIdSUBStage;
    } //-- int getUlIdSUBStage() 

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
     * Method hasUlIdSUBStage
     * 
     * 
     * 
     * @return true if at least one UlIdSUBStage has been added
     */
    public boolean hasUlIdSUBStage()
    {
        return this._has_ulIdSUBStage;
    } //-- boolean hasUlIdSUBStage() 

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
     * Sets the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @param tsLastUpdate_ARRAY the value of field
     * 'tsLastUpdate_ARRAY'.
     */
    public void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY tsLastUpdate_ARRAY)
    {
        this._tsLastUpdate_ARRAY = tsLastUpdate_ARRAY;
    } //-- void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY) 

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
     * Sets the value of field 'ulIdSUBStage'.
     * 
     * @param ulIdSUBStage the value of field 'ulIdSUBStage'.
     */
    public void setUlIdSUBStage(int ulIdSUBStage)
    {
        this._ulIdSUBStage = ulIdSUBStage;
        this._has_ulIdSUBStage = true;
    } //-- void setUlIdSUBStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO unmarshal(java.io.Reader) 

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
