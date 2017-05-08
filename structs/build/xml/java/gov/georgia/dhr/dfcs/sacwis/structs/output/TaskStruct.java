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
 * Class TaskStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TaskStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _szTxtTaskDecode
     */
    private java.lang.String _szTxtTaskDecode;

    /**
     * Field _dtDtTaskDue
     */
    private org.exolab.castor.types.Date _dtDtTaskDue;


      //----------------/
     //- Constructors -/
    //----------------/

    public TaskStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'dtDtTaskDue'.
     * 
     * @return the value of field 'DtDtTaskDue'.
     */
    public org.exolab.castor.types.Date getDtDtTaskDue()
    {
        return this._dtDtTaskDue;
    } //-- org.exolab.castor.types.Date getDtDtTaskDue() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szTxtTaskDecode'.
     * 
     * @return the value of field 'SzTxtTaskDecode'.
     */
    public java.lang.String getSzTxtTaskDecode()
    {
        return this._szTxtTaskDecode;
    } //-- java.lang.String getSzTxtTaskDecode() 

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
     * Sets the value of field 'dtDtTaskDue'.
     * 
     * @param dtDtTaskDue the value of field 'dtDtTaskDue'.
     */
    public void setDtDtTaskDue(org.exolab.castor.types.Date dtDtTaskDue)
    {
        this._dtDtTaskDue = dtDtTaskDue;
    } //-- void setDtDtTaskDue(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szTxtTaskDecode'.
     * 
     * @param szTxtTaskDecode the value of field 'szTxtTaskDecode'.
     */
    public void setSzTxtTaskDecode(java.lang.String szTxtTaskDecode)
    {
        this._szTxtTaskDecode = szTxtTaskDecode;
    } //-- void setSzTxtTaskDecode(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct unmarshal(java.io.Reader) 

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
