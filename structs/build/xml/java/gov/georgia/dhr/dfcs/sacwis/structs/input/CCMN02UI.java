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
 * Class CCMN02UI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN02UI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CCMN02UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00 _CCMN02UIG00;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN02UI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI()


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
     * Returns the value of field 'CCMN02UIG00'.
     * 
     * @return the value of field 'CCMN02UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00 getCCMN02UIG00()
    {
        return this._CCMN02UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00 getCCMN02UIG00() 

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
     * Sets the value of field 'CCMN02UIG00'.
     * 
     * @param CCMN02UIG00 the value of field 'CCMN02UIG00'.
     */
    public void setCCMN02UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00 CCMN02UIG00)
    {
        this._CCMN02UIG00 = CCMN02UIG00;
    } //-- void setCCMN02UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI unmarshal(java.io.Reader) 

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
