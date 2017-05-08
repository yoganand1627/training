/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.input;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class CCMN05UI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN05UI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _ROWCCMN45DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO _ROWCCMN45DO;

    /**
     * Field _ROWCCMN57DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY _ROWCCMN57DO_ARRAY;

    /**
     * Field _ulIdApproval
     */
    private int _ulIdApproval;

    /**
     * keeps track of state for field: _ulIdApproval
     */
    private boolean _has_ulIdApproval;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN05UI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdApproval()
    {
        this._has_ulIdApproval= false;
    } //-- void deleteUlIdApproval() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'ROWCCMN45DO'.
     * 
     * @return the value of field 'ROWCCMN45DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO getROWCCMN45DO()
    {
        return this._ROWCCMN45DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO getROWCCMN45DO() 

    /**
     * Returns the value of field 'ROWCCMN57DO_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN57DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY getROWCCMN57DO_ARRAY()
    {
        return this._ROWCCMN57DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY getROWCCMN57DO_ARRAY() 

    /**
     * Returns the value of field 'ulIdApproval'.
     * 
     * @return the value of field 'UlIdApproval'.
     */
    public int getUlIdApproval()
    {
        return this._ulIdApproval;
    } //-- int getUlIdApproval() 

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
     * Method hasUlIdApproval
     * 
     * 
     * 
     * @return true if at least one UlIdApproval has been added
     */
    public boolean hasUlIdApproval()
    {
        return this._has_ulIdApproval;
    } //-- boolean hasUlIdApproval() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'ROWCCMN45DO'.
     * 
     * @param ROWCCMN45DO the value of field 'ROWCCMN45DO'.
     */
    public void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO ROWCCMN45DO)
    {
        this._ROWCCMN45DO = ROWCCMN45DO;
    } //-- void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO) 

    /**
     * Sets the value of field 'ROWCCMN57DO_ARRAY'.
     * 
     * @param ROWCCMN57DO_ARRAY the value of field
     * 'ROWCCMN57DO_ARRAY'.
     */
    public void setROWCCMN57DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY ROWCCMN57DO_ARRAY)
    {
        this._ROWCCMN57DO_ARRAY = ROWCCMN57DO_ARRAY;
    } //-- void setROWCCMN57DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY) 

    /**
     * Sets the value of field 'ulIdApproval'.
     * 
     * @param ulIdApproval the value of field 'ulIdApproval'.
     */
    public void setUlIdApproval(int ulIdApproval)
    {
        this._ulIdApproval = ulIdApproval;
        this._has_ulIdApproval = true;
    } //-- void setUlIdApproval(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI unmarshal(java.io.Reader) 

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
