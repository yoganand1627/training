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
 * Class ROWCCMN05SIG04.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN05SIG04 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdUnitEmpLink
     */
    private int _ulIdUnitEmpLink;

    /**
     * keeps track of state for field: _ulIdUnitEmpLink
     */
    private boolean _has_ulIdUnitEmpLink;

    /**
     * Field _szCdUnitMemberInOut
     */
    private java.lang.String _szCdUnitMemberInOut;

    /**
     * Field _szCdUnitMemberRole
     */
    private java.lang.String _szCdUnitMemberRole;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN05SIG04() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     */
    public void deleteUlIdUnitEmpLink()
    {
        this._has_ulIdUnitEmpLink= false;
    } //-- void deleteUlIdUnitEmpLink() 

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
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

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
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

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
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04 unmarshal(java.io.Reader) 

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
