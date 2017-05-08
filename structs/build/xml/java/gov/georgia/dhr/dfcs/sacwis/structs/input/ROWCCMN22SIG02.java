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
 * Class ROWCCMN22SIG02.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN22SIG02 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdUnitEmpLink
     */
    private int _ulIdUnitEmpLink;

    /**
     * keeps track of state for field: _ulIdUnitEmpLink
     */
    private boolean _has_ulIdUnitEmpLink;

    /**
     * Field _szCdUnitMemberRole
     */
    private java.lang.String _szCdUnitMemberRole;

    /**
     * Field _szCdUnitMemberInOut
     */
    private java.lang.String _szCdUnitMemberInOut;

    /**
     * Field _szScrCdUnitMemberInOut
     */
    private java.lang.String _szScrCdUnitMemberInOut;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN22SIG02() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdUnitEmpLink()
    {
        this._has_ulIdUnitEmpLink= false;
    } //-- void deleteUlIdUnitEmpLink() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'szCdUnitMemberInOut'.
     * 
     * @return the value of field 'SzCdUnitMemberInOut'.
     */
    public java.lang.String getSzCdUnitMemberInOut()
    {
        return this._szCdUnitMemberInOut;
    } //-- java.lang.String getSzCdUnitMemberInOut() 

    /**
     * Returns the value of field 'szCdUnitMemberRole'.
     * 
     * @return the value of field 'SzCdUnitMemberRole'.
     */
    public java.lang.String getSzCdUnitMemberRole()
    {
        return this._szCdUnitMemberRole;
    } //-- java.lang.String getSzCdUnitMemberRole() 

    /**
     * Returns the value of field 'szScrCdUnitMemberInOut'.
     * 
     * @return the value of field 'SzScrCdUnitMemberInOut'.
     */
    public java.lang.String getSzScrCdUnitMemberInOut()
    {
        return this._szScrCdUnitMemberInOut;
    } //-- java.lang.String getSzScrCdUnitMemberInOut() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdUnitEmpLink'.
     * 
     * @return the value of field 'UlIdUnitEmpLink'.
     */
    public int getUlIdUnitEmpLink()
    {
        return this._ulIdUnitEmpLink;
    } //-- int getUlIdUnitEmpLink() 

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
     * Method hasUlIdUnitEmpLink
     * 
     * 
     * 
     * @return true if at least one UlIdUnitEmpLink has been added
     */
    public boolean hasUlIdUnitEmpLink()
    {
        return this._has_ulIdUnitEmpLink;
    } //-- boolean hasUlIdUnitEmpLink() 

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
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitMemberInOut'.
     * 
     * @param szCdUnitMemberInOut the value of field
     * 'szCdUnitMemberInOut'.
     */
    public void setSzCdUnitMemberInOut(java.lang.String szCdUnitMemberInOut)
    {
        this._szCdUnitMemberInOut = szCdUnitMemberInOut;
    } //-- void setSzCdUnitMemberInOut(java.lang.String) 

    /**
     * Sets the value of field 'szCdUnitMemberRole'.
     * 
     * @param szCdUnitMemberRole the value of field
     * 'szCdUnitMemberRole'.
     */
    public void setSzCdUnitMemberRole(java.lang.String szCdUnitMemberRole)
    {
        this._szCdUnitMemberRole = szCdUnitMemberRole;
    } //-- void setSzCdUnitMemberRole(java.lang.String) 

    /**
     * Sets the value of field 'szScrCdUnitMemberInOut'.
     * 
     * @param szScrCdUnitMemberInOut the value of field
     * 'szScrCdUnitMemberInOut'.
     */
    public void setSzScrCdUnitMemberInOut(java.lang.String szScrCdUnitMemberInOut)
    {
        this._szScrCdUnitMemberInOut = szScrCdUnitMemberInOut;
    } //-- void setSzScrCdUnitMemberInOut(java.lang.String) 

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
     * Sets the value of field 'ulIdUnitEmpLink'.
     * 
     * @param ulIdUnitEmpLink the value of field 'ulIdUnitEmpLink'.
     */
    public void setUlIdUnitEmpLink(int ulIdUnitEmpLink)
    {
        this._ulIdUnitEmpLink = ulIdUnitEmpLink;
        this._has_ulIdUnitEmpLink = true;
    } //-- void setUlIdUnitEmpLink(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02 unmarshal(java.io.Reader) 

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
