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
 * Class CCFC27SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC27SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdRecCheckPerson
     */
    private int _ulIdRecCheckPerson;

    /**
     * keeps track of state for field: _ulIdRecCheckPerson
     */
    private boolean _has_ulIdRecCheckPerson;

    /**
     * Field _ulIdStageRelated
     */
    private int _ulIdStageRelated;

    /**
     * keeps track of state for field: _ulIdStageRelated
     */
    private boolean _has_ulIdStageRelated;

    /**
     * Field _ROWCCFC27SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY _ROWCCFC27SIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC27SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdRecCheckPerson()
    {
        this._has_ulIdRecCheckPerson= false;
    } //-- void deleteUlIdRecCheckPerson() 

    /**
     */
    public void deleteUlIdStageRelated()
    {
        this._has_ulIdStageRelated= false;
    } //-- void deleteUlIdStageRelated() 

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
     * Returns the value of field 'ROWCCFC27SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCFC27SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY getROWCCFC27SIG00_ARRAY()
    {
        return this._ROWCCFC27SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY getROWCCFC27SIG00_ARRAY() 

    /**
     * Returns the value of field 'ulIdRecCheckPerson'.
     * 
     * @return the value of field 'UlIdRecCheckPerson'.
     */
    public int getUlIdRecCheckPerson()
    {
        return this._ulIdRecCheckPerson;
    } //-- int getUlIdRecCheckPerson() 

    /**
     * Returns the value of field 'ulIdStageRelated'.
     * 
     * @return the value of field 'UlIdStageRelated'.
     */
    public int getUlIdStageRelated()
    {
        return this._ulIdStageRelated;
    } //-- int getUlIdStageRelated() 

    /**
     * Method hasUlIdRecCheckPerson
     * 
     * 
     * 
     * @return true if at least one UlIdRecCheckPerson has been adde
     */
    public boolean hasUlIdRecCheckPerson()
    {
        return this._has_ulIdRecCheckPerson;
    } //-- boolean hasUlIdRecCheckPerson() 

    /**
     * Method hasUlIdStageRelated
     * 
     * 
     * 
     * @return true if at least one UlIdStageRelated has been added
     */
    public boolean hasUlIdStageRelated()
    {
        return this._has_ulIdStageRelated;
    } //-- boolean hasUlIdStageRelated() 

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
     * Sets the value of field 'ROWCCFC27SIG00_ARRAY'.
     * 
     * @param ROWCCFC27SIG00_ARRAY the value of field
     * 'ROWCCFC27SIG00_ARRAY'.
     */
    public void setROWCCFC27SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY ROWCCFC27SIG00_ARRAY)
    {
        this._ROWCCFC27SIG00_ARRAY = ROWCCFC27SIG00_ARRAY;
    } //-- void setROWCCFC27SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY) 

    /**
     * Sets the value of field 'ulIdRecCheckPerson'.
     * 
     * @param ulIdRecCheckPerson the value of field
     * 'ulIdRecCheckPerson'.
     */
    public void setUlIdRecCheckPerson(int ulIdRecCheckPerson)
    {
        this._ulIdRecCheckPerson = ulIdRecCheckPerson;
        this._has_ulIdRecCheckPerson = true;
    } //-- void setUlIdRecCheckPerson(int) 

    /**
     * Sets the value of field 'ulIdStageRelated'.
     * 
     * @param ulIdStageRelated the value of field 'ulIdStageRelated'
     */
    public void setUlIdStageRelated(int ulIdStageRelated)
    {
        this._ulIdStageRelated = ulIdStageRelated;
        this._has_ulIdStageRelated = true;
    } //-- void setUlIdStageRelated(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI unmarshal(java.io.Reader) 

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
