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
 * Class CallDcsnAUDIn.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallDcsnAUDIn extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _callDcsnAUD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD _callDcsnAUD;

    /**
     * Field _determListAUD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD _determListAUD;

    /**
     * Field _specHD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD _specHD;

    /**
     * Field _determCmntsAUD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.DetermCmntsAUD _determCmntsAUD;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallDcsnAUDIn() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn()


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
     * Returns the value of field 'callDcsnAUD'.
     * 
     * @return the value of field 'CallDcsnAUD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD getCallDcsnAUD()
    {
        return this._callDcsnAUD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD getCallDcsnAUD() 

    /**
     * Returns the value of field 'determCmntsAUD'.
     * 
     * @return the value of field 'DetermCmntsAUD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.DetermCmntsAUD getDetermCmntsAUD()
    {
        return this._determCmntsAUD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DetermCmntsAUD getDetermCmntsAUD() 

    /**
     * Returns the value of field 'determListAUD'.
     * 
     * @return the value of field 'DetermListAUD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD getDetermListAUD()
    {
        return this._determListAUD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD getDetermListAUD() 

    /**
     * Returns the value of field 'specHD'.
     * 
     * @return the value of field 'SpecHD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD getSpecHD()
    {
        return this._specHD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD getSpecHD() 

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
     * Sets the value of field 'callDcsnAUD'.
     * 
     * @param callDcsnAUD the value of field 'callDcsnAUD'.
     */
    public void setCallDcsnAUD(gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD callDcsnAUD)
    {
        this._callDcsnAUD = callDcsnAUD;
    } //-- void setCallDcsnAUD(gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD) 

    /**
     * Sets the value of field 'determCmntsAUD'.
     * 
     * @param determCmntsAUD the value of field 'determCmntsAUD'.
     */
    public void setDetermCmntsAUD(gov.georgia.dhr.dfcs.sacwis.structs.input.DetermCmntsAUD determCmntsAUD)
    {
        this._determCmntsAUD = determCmntsAUD;
    } //-- void setDetermCmntsAUD(gov.georgia.dhr.dfcs.sacwis.structs.input.DetermCmntsAUD) 

    /**
     * Sets the value of field 'determListAUD'.
     * 
     * @param determListAUD the value of field 'determListAUD'.
     */
    public void setDetermListAUD(gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD determListAUD)
    {
        this._determListAUD = determListAUD;
    } //-- void setDetermListAUD(gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD) 

    /**
     * Sets the value of field 'specHD'.
     * 
     * @param specHD the value of field 'specHD'.
     */
    public void setSpecHD(gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD specHD)
    {
        this._specHD = specHD;
    } //-- void setSpecHD(gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn unmarshal(java.io.Reader) 

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
