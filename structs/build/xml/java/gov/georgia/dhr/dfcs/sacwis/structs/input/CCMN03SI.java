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
 * Class CCMN03SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN03SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _stdWinIDStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct _stdWinIDStruct;

    /**
     * Field _stfSrchCrtInStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct _stfSrchCrtInStruct;

    /**
     * Field _stageIdInStruct_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY _stageIdInStruct_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN03SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI()


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
     * Returns the value of field 'stageIdInStruct_ARRAY'.
     * 
     * @return the value of field 'StageIdInStruct_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY getStageIdInStruct_ARRAY()
    {
        return this._stageIdInStruct_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY getStageIdInStruct_ARRAY() 

    /**
     * Returns the value of field 'stdWinIDStruct'.
     * 
     * @return the value of field 'StdWinIDStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct getStdWinIDStruct()
    {
        return this._stdWinIDStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct getStdWinIDStruct() 

    /**
     * Returns the value of field 'stfSrchCrtInStruct'.
     * 
     * @return the value of field 'StfSrchCrtInStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct getStfSrchCrtInStruct()
    {
        return this._stfSrchCrtInStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct getStfSrchCrtInStruct() 

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
     * Sets the value of field 'stageIdInStruct_ARRAY'.
     * 
     * @param stageIdInStruct_ARRAY the value of field
     * 'stageIdInStruct_ARRAY'.
     */
    public void setStageIdInStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY stageIdInStruct_ARRAY)
    {
        this._stageIdInStruct_ARRAY = stageIdInStruct_ARRAY;
    } //-- void setStageIdInStruct_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY) 

    /**
     * Sets the value of field 'stdWinIDStruct'.
     * 
     * @param stdWinIDStruct the value of field 'stdWinIDStruct'.
     */
    public void setStdWinIDStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct stdWinIDStruct)
    {
        this._stdWinIDStruct = stdWinIDStruct;
    } //-- void setStdWinIDStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StdWinIDStruct) 

    /**
     * Sets the value of field 'stfSrchCrtInStruct'.
     * 
     * @param stfSrchCrtInStruct the value of field
     * 'stfSrchCrtInStruct'.
     */
    public void setStfSrchCrtInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct stfSrchCrtInStruct)
    {
        this._stfSrchCrtInStruct = stfSrchCrtInStruct;
    } //-- void setStfSrchCrtInStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI unmarshal(java.io.Reader) 

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
