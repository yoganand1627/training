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
 * Class CSUB39SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB39SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdLegalActEvent
     */
    private int _ulIdLegalActEvent;

    /**
     * keeps track of state for field: _ulIdLegalActEvent
     */
    private boolean _has_ulIdLegalActEvent;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB39SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdLegalActEvent()
    {
        this._has_ulIdLegalActEvent= false;
    } //-- void deleteUlIdLegalActEvent() 

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
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

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
     * Returns the value of field 'ulIdLegalActEvent'.
     * 
     * @return the value of field 'UlIdLegalActEvent'.
     */
    public int getUlIdLegalActEvent()
    {
        return this._ulIdLegalActEvent;
    } //-- int getUlIdLegalActEvent() 

    /**
     * Method hasUlIdLegalActEvent
     * 
     * 
     * 
     * @return true if at least one UlIdLegalActEvent has been added
     */
    public boolean hasUlIdLegalActEvent()
    {
        return this._has_ulIdLegalActEvent;
    } //-- boolean hasUlIdLegalActEvent() 

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
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

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
     * Sets the value of field 'ulIdLegalActEvent'.
     * 
     * @param ulIdLegalActEvent the value of field
     * 'ulIdLegalActEvent'.
     */
    public void setUlIdLegalActEvent(int ulIdLegalActEvent)
    {
        this._ulIdLegalActEvent = ulIdLegalActEvent;
        this._has_ulIdLegalActEvent = true;
    } //-- void setUlIdLegalActEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO unmarshal(java.io.Reader) 

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
