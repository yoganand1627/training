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
 * Class ROWCARC13SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC13SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmSecurityClass
     */
    private java.lang.String _szNmSecurityClass;

    /**
     * Field _cIndRestrict
     */
    private java.lang.String _cIndRestrict;

    /**
     * Field _szTxtSecurityClassProfil
     */
    private java.lang.String _szTxtSecurityClassProfil;

    /**
     * Field _szCdEmpSecurityClassNm
     */
    private java.lang.String _szCdEmpSecurityClassNm;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdSysDataActionOutcome
     */
    private java.lang.String _szCdSysDataActionOutcome;

    /**
     * Field _ulIdEmployee
     */
    private int _ulIdEmployee;

    /**
     * keeps track of state for field: _ulIdEmployee
     */
    private boolean _has_ulIdEmployee;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC13SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEmployee()
    {
        this._has_ulIdEmployee= false;
    } //-- void deleteUlIdEmployee() 

    /**
     * Returns the value of field 'cIndRestrict'.
     * 
     * @return the value of field 'CIndRestrict'.
     */
    public java.lang.String getCIndRestrict()
    {
        return this._cIndRestrict;
    } //-- java.lang.String getCIndRestrict() 

    /**
     * Returns the value of field 'szCdEmpSecurityClassNm'.
     * 
     * @return the value of field 'SzCdEmpSecurityClassNm'.
     */
    public java.lang.String getSzCdEmpSecurityClassNm()
    {
        return this._szCdEmpSecurityClassNm;
    } //-- java.lang.String getSzCdEmpSecurityClassNm() 

    /**
     * Returns the value of field 'szCdSysDataActionOutcome'.
     * 
     * @return the value of field 'SzCdSysDataActionOutcome'.
     */
    public java.lang.String getSzCdSysDataActionOutcome()
    {
        return this._szCdSysDataActionOutcome;
    } //-- java.lang.String getSzCdSysDataActionOutcome() 

    /**
     * Returns the value of field 'szNmSecurityClass'.
     * 
     * @return the value of field 'SzNmSecurityClass'.
     */
    public java.lang.String getSzNmSecurityClass()
    {
        return this._szNmSecurityClass;
    } //-- java.lang.String getSzNmSecurityClass() 

    /**
     * Returns the value of field 'szTxtSecurityClassProfil'.
     * 
     * @return the value of field 'SzTxtSecurityClassProfil'.
     */
    public java.lang.String getSzTxtSecurityClassProfil()
    {
        return this._szTxtSecurityClassProfil;
    } //-- java.lang.String getSzTxtSecurityClassProfil() 

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
     * Returns the value of field 'ulIdEmployee'.
     * 
     * @return the value of field 'UlIdEmployee'.
     */
    public int getUlIdEmployee()
    {
        return this._ulIdEmployee;
    } //-- int getUlIdEmployee() 

    /**
     * Method hasUlIdEmployee
     * 
     * 
     * 
     * @return true if at least one UlIdEmployee has been added
     */
    public boolean hasUlIdEmployee()
    {
        return this._has_ulIdEmployee;
    } //-- boolean hasUlIdEmployee() 

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
     * Sets the value of field 'cIndRestrict'.
     * 
     * @param cIndRestrict the value of field 'cIndRestrict'.
     */
    public void setCIndRestrict(java.lang.String cIndRestrict)
    {
        this._cIndRestrict = cIndRestrict;
    } //-- void setCIndRestrict(java.lang.String) 

    /**
     * Sets the value of field 'szCdEmpSecurityClassNm'.
     * 
     * @param szCdEmpSecurityClassNm the value of field
     * 'szCdEmpSecurityClassNm'.
     */
    public void setSzCdEmpSecurityClassNm(java.lang.String szCdEmpSecurityClassNm)
    {
        this._szCdEmpSecurityClassNm = szCdEmpSecurityClassNm;
    } //-- void setSzCdEmpSecurityClassNm(java.lang.String) 

    /**
     * Sets the value of field 'szCdSysDataActionOutcome'.
     * 
     * @param szCdSysDataActionOutcome the value of field
     * 'szCdSysDataActionOutcome'.
     */
    public void setSzCdSysDataActionOutcome(java.lang.String szCdSysDataActionOutcome)
    {
        this._szCdSysDataActionOutcome = szCdSysDataActionOutcome;
    } //-- void setSzCdSysDataActionOutcome(java.lang.String) 

    /**
     * Sets the value of field 'szNmSecurityClass'.
     * 
     * @param szNmSecurityClass the value of field
     * 'szNmSecurityClass'.
     */
    public void setSzNmSecurityClass(java.lang.String szNmSecurityClass)
    {
        this._szNmSecurityClass = szNmSecurityClass;
    } //-- void setSzNmSecurityClass(java.lang.String) 

    /**
     * Sets the value of field 'szTxtSecurityClassProfil'.
     * 
     * @param szTxtSecurityClassProfil the value of field
     * 'szTxtSecurityClassProfil'.
     */
    public void setSzTxtSecurityClassProfil(java.lang.String szTxtSecurityClassProfil)
    {
        this._szTxtSecurityClassProfil = szTxtSecurityClassProfil;
    } //-- void setSzTxtSecurityClassProfil(java.lang.String) 

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
     * Sets the value of field 'ulIdEmployee'.
     * 
     * @param ulIdEmployee the value of field 'ulIdEmployee'.
     */
    public void setUlIdEmployee(int ulIdEmployee)
    {
        this._ulIdEmployee = ulIdEmployee;
        this._has_ulIdEmployee = true;
    } //-- void setUlIdEmployee(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCARC13SIG00 unmarshal(java.io.Reader) 

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
