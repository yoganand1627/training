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
 * Class ROWCCMN56DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN56DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dtDtApproversDetermination
     */
    private org.exolab.castor.types.Date _dtDtApproversDetermination;

    /**
     * Field _tmScrTmApprovalTime
     */
    private java.lang.String _tmScrTmApprovalTime;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szCdApproversStatus
     */
    private java.lang.String _szCdApproversStatus;

    /**
     * Field _szTxtApproversComments
     */
    private java.lang.String _szTxtApproversComments;

    /**
     * Field _ldIdTodo
     */
    private int _ldIdTodo;

    /**
     * keeps track of state for field: _ldIdTodo
     */
    private boolean _has_ldIdTodo;

    /**
     * Field _ulIdApprovers
     */
    private int _ulIdApprovers;

    /**
     * keeps track of state for field: _ulIdApprovers
     */
    private boolean _has_ulIdApprovers;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN56DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO()


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
    public void deleteUlIdApprovers()
    {
        this._has_ulIdApprovers= false;
    } //-- void deleteUlIdApprovers() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

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
     * Returns the value of field 'tmScrTmApprovalTime'.
     * 
     * @return the value of field 'TmScrTmApprovalTime'.
     */
    public java.lang.String getTmScrTmApprovalTime()
    {
        return this._tmScrTmApprovalTime;
    } //-- java.lang.String getTmScrTmApprovalTime() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdApprovers'.
     * 
     * @return the value of field 'UlIdApprovers'.
     */
    public int getUlIdApprovers()
    {
        return this._ulIdApprovers;
    } //-- int getUlIdApprovers() 

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
     * Method hasUlIdApprovers
     * 
     * 
     * 
     * @return true if at least one UlIdApprovers has been added
     */
    public boolean hasUlIdApprovers()
    {
        return this._has_ulIdApprovers;
    } //-- boolean hasUlIdApprovers() 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

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
     * Sets the value of field 'tmScrTmApprovalTime'.
     * 
     * @param tmScrTmApprovalTime the value of field
     * 'tmScrTmApprovalTime'.
     */
    public void setTmScrTmApprovalTime(java.lang.String tmScrTmApprovalTime)
    {
        this._tmScrTmApprovalTime = tmScrTmApprovalTime;
    } //-- void setTmScrTmApprovalTime(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdApprovers'.
     * 
     * @param ulIdApprovers the value of field 'ulIdApprovers'.
     */
    public void setUlIdApprovers(int ulIdApprovers)
    {
        this._ulIdApprovers = ulIdApprovers;
        this._has_ulIdApprovers = true;
    } //-- void setUlIdApprovers(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO unmarshal(java.io.Reader) 

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
