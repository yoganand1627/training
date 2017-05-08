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
 * Class StagePersonLinkSO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StagePersonLinkSO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _stagePersonLinkDetail_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY _stagePersonLinkDetail_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public StagePersonLinkSO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'stagePersonLinkDetail_ARRAY'.
     * 
     * @return the value of field 'StagePersonLinkDetail_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY getStagePersonLinkDetail_ARRAY()
    {
        return this._stagePersonLinkDetail_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY getStagePersonLinkDetail_ARRAY() 

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
     * Sets the value of field 'stagePersonLinkDetail_ARRAY'.
     * 
     * @param stagePersonLinkDetail_ARRAY the value of field
     * 'stagePersonLinkDetail_ARRAY'.
     */
    public void setStagePersonLinkDetail_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY stagePersonLinkDetail_ARRAY)
    {
        this._stagePersonLinkDetail_ARRAY = stagePersonLinkDetail_ARRAY;
    } //-- void setStagePersonLinkDetail_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkSO unmarshal(java.io.Reader) 

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
