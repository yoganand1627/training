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
 * Class CCMN45SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN45SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _ROWCCMN45SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00_ARRAY _ROWCCMN45SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN45SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'ROWCCMN45SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN45SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00_ARRAY getROWCCMN45SOG00_ARRAY()
    {
        return this._ROWCCMN45SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00_ARRAY getROWCCMN45SOG00_ARRAY() 

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
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCMN45SOG00_ARRAY'.
     * 
     * @param ROWCCMN45SOG00_ARRAY the value of field
     * 'ROWCCMN45SOG00_ARRAY'.
     */
    public void setROWCCMN45SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00_ARRAY ROWCCMN45SOG00_ARRAY)
    {
        this._ROWCCMN45SOG00_ARRAY = ROWCCMN45SOG00_ARRAY;
    } //-- void setROWCCMN45SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO unmarshal(java.io.Reader) 

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
