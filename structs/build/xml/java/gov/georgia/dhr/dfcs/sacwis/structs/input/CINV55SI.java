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
 * Class CINV55SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV55SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV55SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY _ROWCINV55SIG00_ARRAY;

    /**
     * Field _ROWCINV55SIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01 _ROWCINV55SIG01;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV55SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

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
     * Returns the value of field 'ROWCINV55SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV55SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY getROWCINV55SIG00_ARRAY()
    {
        return this._ROWCINV55SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY getROWCINV55SIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV55SIG01'.
     * 
     * @return the value of field 'ROWCINV55SIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01 getROWCINV55SIG01()
    {
        return this._ROWCINV55SIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01 getROWCINV55SIG01() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

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
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'ROWCINV55SIG00_ARRAY'.
     * 
     * @param ROWCINV55SIG00_ARRAY the value of field
     * 'ROWCINV55SIG00_ARRAY'.
     */
    public void setROWCINV55SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY ROWCINV55SIG00_ARRAY)
    {
        this._ROWCINV55SIG00_ARRAY = ROWCINV55SIG00_ARRAY;
    } //-- void setROWCINV55SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV55SIG01'.
     * 
     * @param ROWCINV55SIG01 the value of field 'ROWCINV55SIG01'.
     */
    public void setROWCINV55SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01 ROWCINV55SIG01)
    {
        this._ROWCINV55SIG01 = ROWCINV55SIG01;
    } //-- void setROWCINV55SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI unmarshal(java.io.Reader) 

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
