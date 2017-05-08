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
 * Class ApproversStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ApproversStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szCdApproversStatus
     */
    private java.lang.String _szCdApproversStatus;

    /**
     * Field _dtDtApproversDetermination
     */
    private org.exolab.castor.types.Date _dtDtApproversDetermination;

    /**
     * Field _dtDtApproversRequested
     */
    private org.exolab.castor.types.Date _dtDtApproversRequested;

    /**
     * Field _ulIdApproval
     */
    private int _ulIdApproval;

    /**
     * keeps track of state for field: _ulIdApproval
     */
    private boolean _has_ulIdApproval;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ldIdTodo
     */
    private int _ldIdTodo;

    /**
     * keeps track of state for field: _ldIdTodo
     */
    private boolean _has_ldIdTodo;

    /**
     * Field _bIndApproversHistorical
     */
    private java.lang.String _bIndApproversHistorical;

    /**
     * Field _szTxtApproversComments
     */
    private java.lang.String _szTxtApproversComments;


      //----------------/
     //- Constructors -/
    //----------------/

    public ApproversStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLdIdTodo()
    {
        this._has_ldIdTodo= false;
    } //-- void deleteLdIdTodo() 

    /**
     */
    public void deleteUlIdApproval()
    {
        this._has_ulIdApproval= false;
    } //-- void deleteUlIdApproval() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'bIndApproversHistorical'.
     * 
     * @return the value of field 'BIndApproversHistorical'.
     */
    public java.lang.String getBIndApproversHistorical()
    {
        return this._bIndApproversHistorical;
    } //-- java.lang.String getBIndApproversHistorical() 

    /**
     * Returns the value of field 'dtDtApproversDetermination'.
     * 
     * @return the value of field 'DtDtApproversDetermination'.
     */
    public org.exolab.castor.types.Date getDtDtApproversDetermination()
    {
        return this._dtDtApproversDetermination;
    } //-- org.exolab.castor.types.Date getDtDtApproversDetermination() 

    /**
     * Returns the value of field 'dtDtApproversRequested'.
     * 
     * @return the value of field 'DtDtApproversRequested'.
     */
    public org.exolab.castor.types.Date getDtDtApproversRequested()
    {
        return this._dtDtApproversRequested;
    } //-- org.exolab.castor.types.Date getDtDtApproversRequested() 

    /**
     * Returns the value of field 'ldIdTodo'.
     * 
     * @return the value of field 'LdIdTodo'.
     */
    public int getLdIdTodo()
    {
        return this._ldIdTodo;
    } //-- int getLdIdTodo() 

    /**
     * Returns the value of field 'szCdApproversStatus'.
     * 
     * @return the value of field 'SzCdApproversStatus'.
     */
    public java.lang.String getSzCdApproversStatus()
    {
        return this._szCdApproversStatus;
    } //-- java.lang.String getSzCdApproversStatus() 

    /**
     * Returns the value of field 'szTxtApproversComments'.
     * 
     * @return the value of field 'SzTxtApproversComments'.
     */
    public java.lang.String getSzTxtApproversComments()
    {
        return this._szTxtApproversComments;
    } //-- java.lang.String getSzTxtApproversComments() 

    /**
     * Returns the value of field 'ulIdApproval'.
     * 
     * @return the value of field 'UlIdApproval'.
     */
    public int getUlIdApproval()
    {
        return this._ulIdApproval;
    } //-- int getUlIdApproval() 

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
     * Method hasLdIdTodo
     * 
     * 
     * 
     * @return true if at least one LdIdTodo has been added
     */
    public boolean hasLdIdTodo()
    {
        return this._has_ldIdTodo;
    } //-- boolean hasLdIdTodo() 

    /**
     * Method hasUlIdApproval
     * 
     * 
     * 
     * @return true if at least one UlIdApproval has been added
     */
    public boolean hasUlIdApproval()
    {
        return this._has_ulIdApproval;
    } //-- boolean hasUlIdApproval() 

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
     * Sets the value of field 'bIndApproversHistorical'.
     * 
     * @param bIndApproversHistorical the value of field
     * 'bIndApproversHistorical'.
     */
    public void setBIndApproversHistorical(java.lang.String bIndApproversHistorical)
    {
        this._bIndApproversHistorical = bIndApproversHistorical;
    } //-- void setBIndApproversHistorical(java.lang.String) 

    /**
     * Sets the value of field 'dtDtApproversDetermination'.
     * 
     * @param dtDtApproversDetermination the value of field
     * 'dtDtApproversDetermination'.
     */
    public void setDtDtApproversDetermination(org.exolab.castor.types.Date dtDtApproversDetermination)
    {
        this._dtDtApproversDetermination = dtDtApproversDetermination;
    } //-- void setDtDtApproversDetermination(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtApproversRequested'.
     * 
     * @param dtDtApproversRequested the value of field
     * 'dtDtApproversRequested'.
     */
    public void setDtDtApproversRequested(org.exolab.castor.types.Date dtDtApproversRequested)
    {
        this._dtDtApproversRequested = dtDtApproversRequested;
    } //-- void setDtDtApproversRequested(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ldIdTodo'.
     * 
     * @param ldIdTodo the value of field 'ldIdTodo'.
     */
    public void setLdIdTodo(int ldIdTodo)
    {
        this._ldIdTodo = ldIdTodo;
        this._has_ldIdTodo = true;
    } //-- void setLdIdTodo(int) 

    /**
     * Sets the value of field 'szCdApproversStatus'.
     * 
     * @param szCdApproversStatus the value of field
     * 'szCdApproversStatus'.
     */
    public void setSzCdApproversStatus(java.lang.String szCdApproversStatus)
    {
        this._szCdApproversStatus = szCdApproversStatus;
    } //-- void setSzCdApproversStatus(java.lang.String) 

    /**
     * Sets the value of field 'szTxtApproversComments'.
     * 
     * @param szTxtApproversComments the value of field
     * 'szTxtApproversComments'.
     */
    public void setSzTxtApproversComments(java.lang.String szTxtApproversComments)
    {
        this._szTxtApproversComments = szTxtApproversComments;
    } //-- void setSzTxtApproversComments(java.lang.String) 

    /**
     * Sets the value of field 'ulIdApproval'.
     * 
     * @param ulIdApproval the value of field 'ulIdApproval'.
     */
    public void setUlIdApproval(int ulIdApproval)
    {
        this._ulIdApproval = ulIdApproval;
        this._has_ulIdApproval = true;
    } //-- void setUlIdApproval(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct unmarshal(java.io.Reader) 

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
