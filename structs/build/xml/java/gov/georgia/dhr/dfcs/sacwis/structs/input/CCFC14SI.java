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
 * Class CCFC14SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC14SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPersonRequestor
     */
    private int _ulIdPersonRequestor;

    /**
     * keeps track of state for field: _ulIdPersonRequestor
     */
    private boolean _has_ulIdPersonRequestor;

    /**
     * Field _ROWCCFC14SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00_ARRAY _ROWCCFC14SIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC14SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPersonRequestor()
    {
        this._has_ulIdPersonRequestor= false;
    } //-- void deleteUlIdPersonRequestor() 

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
     * Returns the value of field 'ROWCCFC14SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCFC14SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00_ARRAY getROWCCFC14SIG00_ARRAY()
    {
        return this._ROWCCFC14SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00_ARRAY getROWCCFC14SIG00_ARRAY() 

    /**
     * Returns the value of field 'ulIdPersonRequestor'.
     * 
     * @return the value of field 'UlIdPersonRequestor'.
     */
    public int getUlIdPersonRequestor()
    {
        return this._ulIdPersonRequestor;
    } //-- int getUlIdPersonRequestor() 

    /**
     * Method hasUlIdPersonRequestor
     * 
     * 
     * 
     * @return true if at least one UlIdPersonRequestor has been
     * added
     */
    public boolean hasUlIdPersonRequestor()
    {
        return this._has_ulIdPersonRequestor;
    } //-- boolean hasUlIdPersonRequestor() 

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
     * Sets the value of field 'ROWCCFC14SIG00_ARRAY'.
     * 
     * @param ROWCCFC14SIG00_ARRAY the value of field
     * 'ROWCCFC14SIG00_ARRAY'.
     */
    public void setROWCCFC14SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00_ARRAY ROWCCFC14SIG00_ARRAY)
    {
        this._ROWCCFC14SIG00_ARRAY = ROWCCFC14SIG00_ARRAY;
    } //-- void setROWCCFC14SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00_ARRAY) 

    /**
     * Sets the value of field 'ulIdPersonRequestor'.
     * 
     * @param ulIdPersonRequestor the value of field
     * 'ulIdPersonRequestor'.
     */
    public void setUlIdPersonRequestor(int ulIdPersonRequestor)
    {
        this._ulIdPersonRequestor = ulIdPersonRequestor;
        this._has_ulIdPersonRequestor = true;
    } //-- void setUlIdPersonRequestor(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI unmarshal(java.io.Reader) 

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
