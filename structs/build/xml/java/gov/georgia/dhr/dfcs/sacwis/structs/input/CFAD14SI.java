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
 * Class CFAD14SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD14SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cSysIndFosterTypeChange
     */
    private java.lang.String _cSysIndFosterTypeChange;

    /**
     * Field _cSysIndLocChange
     */
    private java.lang.String _cSysIndLocChange;

    /**
     * Field _CFAD14SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00 _CFAD14SIG00;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD14SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'CFAD14SIG00'.
     * 
     * @return the value of field 'CFAD14SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00 getCFAD14SIG00()
    {
        return this._CFAD14SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00 getCFAD14SIG00() 

    /**
     * Returns the value of field 'cSysIndFosterTypeChange'.
     * 
     * @return the value of field 'CSysIndFosterTypeChange'.
     */
    public java.lang.String getCSysIndFosterTypeChange()
    {
        return this._cSysIndFosterTypeChange;
    } //-- java.lang.String getCSysIndFosterTypeChange() 

    /**
     * Returns the value of field 'cSysIndLocChange'.
     * 
     * @return the value of field 'CSysIndLocChange'.
     */
    public java.lang.String getCSysIndLocChange()
    {
        return this._cSysIndLocChange;
    } //-- java.lang.String getCSysIndLocChange() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

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
     * Sets the value of field 'CFAD14SIG00'.
     * 
     * @param CFAD14SIG00 the value of field 'CFAD14SIG00'.
     */
    public void setCFAD14SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00 CFAD14SIG00)
    {
        this._CFAD14SIG00 = CFAD14SIG00;
    } //-- void setCFAD14SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00) 

    /**
     * Sets the value of field 'cSysIndFosterTypeChange'.
     * 
     * @param cSysIndFosterTypeChange the value of field
     * 'cSysIndFosterTypeChange'.
     */
    public void setCSysIndFosterTypeChange(java.lang.String cSysIndFosterTypeChange)
    {
        this._cSysIndFosterTypeChange = cSysIndFosterTypeChange;
    } //-- void setCSysIndFosterTypeChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndLocChange'.
     * 
     * @param cSysIndLocChange the value of field 'cSysIndLocChange'
     */
    public void setCSysIndLocChange(java.lang.String cSysIndLocChange)
    {
        this._cSysIndLocChange = cSysIndLocChange;
    } //-- void setCSysIndLocChange(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI unmarshal(java.io.Reader) 

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
