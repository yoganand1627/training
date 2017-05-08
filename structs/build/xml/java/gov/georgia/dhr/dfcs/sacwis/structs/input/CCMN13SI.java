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
 * Class CCMN13SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN13SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _todoCaseInfStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct _todoCaseInfStruct;

    /**
     * Field _szWhichSpclInvApprover
     */
    private java.lang.String _szWhichSpclInvApprover;

    /**
     * Field _szWhichSafetyRsrcApprover
     */
    private java.lang.String _szWhichSafetyRsrcApprover;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN13SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI()


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
     * Returns the value of field 'szWhichSafetyRsrcApprover'.
     * 
     * @return the value of field 'SzWhichSafetyRsrcApprover'.
     */
    public java.lang.String getSzWhichSafetyRsrcApprover()
    {
        return this._szWhichSafetyRsrcApprover;
    } //-- java.lang.String getSzWhichSafetyRsrcApprover() 

    /**
     * Returns the value of field 'szWhichSpclInvApprover'.
     * 
     * @return the value of field 'SzWhichSpclInvApprover'.
     */
    public java.lang.String getSzWhichSpclInvApprover()
    {
        return this._szWhichSpclInvApprover;
    } //-- java.lang.String getSzWhichSpclInvApprover() 

    /**
     * Returns the value of field 'todoCaseInfStruct'.
     * 
     * @return the value of field 'TodoCaseInfStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct getTodoCaseInfStruct()
    {
        return this._todoCaseInfStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct getTodoCaseInfStruct() 

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
     * Sets the value of field 'szWhichSafetyRsrcApprover'.
     * 
     * @param szWhichSafetyRsrcApprover the value of field
     * 'szWhichSafetyRsrcApprover'.
     */
    public void setSzWhichSafetyRsrcApprover(java.lang.String szWhichSafetyRsrcApprover)
    {
        this._szWhichSafetyRsrcApprover = szWhichSafetyRsrcApprover;
    } //-- void setSzWhichSafetyRsrcApprover(java.lang.String) 

    /**
     * Sets the value of field 'szWhichSpclInvApprover'.
     * 
     * @param szWhichSpclInvApprover the value of field
     * 'szWhichSpclInvApprover'.
     */
    public void setSzWhichSpclInvApprover(java.lang.String szWhichSpclInvApprover)
    {
        this._szWhichSpclInvApprover = szWhichSpclInvApprover;
    } //-- void setSzWhichSpclInvApprover(java.lang.String) 

    /**
     * Sets the value of field 'todoCaseInfStruct'.
     * 
     * @param todoCaseInfStruct the value of field
     * 'todoCaseInfStruct'.
     */
    public void setTodoCaseInfStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct todoCaseInfStruct)
    {
        this._todoCaseInfStruct = todoCaseInfStruct;
    } //-- void setTodoCaseInfStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI unmarshal(java.io.Reader) 

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
