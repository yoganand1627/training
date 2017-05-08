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
 * Class CINV21SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV21SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV21SIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG01 _ROWCINV21SIG01;

    /**
     * Field _ROWCINV21SIG02
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG02 _ROWCINV21SIG02;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV21SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV21SI()


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
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'ROWCINV21SIG01'.
     * 
     * @return the value of field 'ROWCINV21SIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG01 getROWCINV21SIG01()
    {
        return this._ROWCINV21SIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG01 getROWCINV21SIG01() 

    /**
     * Returns the value of field 'ROWCINV21SIG02'.
     * 
     * @return the value of field 'ROWCINV21SIG02'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG02 getROWCINV21SIG02()
    {
        return this._ROWCINV21SIG02;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG02 getROWCINV21SIG02() 

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
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'ROWCINV21SIG01'.
     * 
     * @param ROWCINV21SIG01 the value of field 'ROWCINV21SIG01'.
     */
    public void setROWCINV21SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG01 ROWCINV21SIG01)
    {
        this._ROWCINV21SIG01 = ROWCINV21SIG01;
    } //-- void setROWCINV21SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG01) 

    /**
     * Sets the value of field 'ROWCINV21SIG02'.
     * 
     * @param ROWCINV21SIG02 the value of field 'ROWCINV21SIG02'.
     */
    public void setROWCINV21SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG02 ROWCINV21SIG02)
    {
        this._ROWCINV21SIG02 = ROWCINV21SIG02;
    } //-- void setROWCINV21SIG02(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG02) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV21SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV21SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV21SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV21SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV21SI unmarshal(java.io.Reader) 

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
