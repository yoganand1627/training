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
 * Class CCON19SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON19SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdSvcAuth
     */
    private int _ulIdSvcAuth;

    /**
     * keeps track of state for field: _ulIdSvcAuth
     */
    private boolean _has_ulIdSvcAuth;

    /**
     * Field _bIndOverSpendingLimitPad
     */
    private java.lang.String _bIndOverSpendingLimitPad;

    /**
     * Field _dAmtNonRecLimit
     */
    private double _dAmtNonRecLimit;

    /**
     * keeps track of state for field: _dAmtNonRecLimit
     */
    private boolean _has_dAmtNonRecLimit;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON19SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtNonRecLimit()
    {
        this._has_dAmtNonRecLimit= false;
    } //-- void deleteDAmtNonRecLimit() 

    /**
     */
    public void deleteUlIdSvcAuth()
    {
        this._has_ulIdSvcAuth= false;
    } //-- void deleteUlIdSvcAuth() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'bIndOverSpendingLimitPad'.
     * 
     * @return the value of field 'BIndOverSpendingLimitPad'.
     */
    public java.lang.String getBIndOverSpendingLimitPad()
    {
        return this._bIndOverSpendingLimitPad;
    } //-- java.lang.String getBIndOverSpendingLimitPad() 

    /**
     * Returns the value of field 'dAmtNonRecLimit'.
     * 
     * @return the value of field 'DAmtNonRecLimit'.
     */
    public double getDAmtNonRecLimit()
    {
        return this._dAmtNonRecLimit;
    } //-- double getDAmtNonRecLimit() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 getROWCCMN01UIG00() 

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
     * Returns the value of field 'ulIdSvcAuth'.
     * 
     * @return the value of field 'UlIdSvcAuth'.
     */
    public int getUlIdSvcAuth()
    {
        return this._ulIdSvcAuth;
    } //-- int getUlIdSvcAuth() 

    /**
     * Method hasDAmtNonRecLimit
     * 
     * 
     * 
     * @return true if at least one DAmtNonRecLimit has been added
     */
    public boolean hasDAmtNonRecLimit()
    {
        return this._has_dAmtNonRecLimit;
    } //-- boolean hasDAmtNonRecLimit() 

    /**
     * Method hasUlIdSvcAuth
     * 
     * 
     * 
     * @return true if at least one UlIdSvcAuth has been added
     */
    public boolean hasUlIdSvcAuth()
    {
        return this._has_ulIdSvcAuth;
    } //-- boolean hasUlIdSvcAuth() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'bIndOverSpendingLimitPad'.
     * 
     * @param bIndOverSpendingLimitPad the value of field
     * 'bIndOverSpendingLimitPad'.
     */
    public void setBIndOverSpendingLimitPad(java.lang.String bIndOverSpendingLimitPad)
    {
        this._bIndOverSpendingLimitPad = bIndOverSpendingLimitPad;
    } //-- void setBIndOverSpendingLimitPad(java.lang.String) 

    /**
     * Sets the value of field 'dAmtNonRecLimit'.
     * 
     * @param dAmtNonRecLimit the value of field 'dAmtNonRecLimit'.
     */
    public void setDAmtNonRecLimit(double dAmtNonRecLimit)
    {
        this._dAmtNonRecLimit = dAmtNonRecLimit;
        this._has_dAmtNonRecLimit = true;
    } //-- void setDAmtNonRecLimit(double) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00) 

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
     * Sets the value of field 'ulIdSvcAuth'.
     * 
     * @param ulIdSvcAuth the value of field 'ulIdSvcAuth'.
     */
    public void setUlIdSvcAuth(int ulIdSvcAuth)
    {
        this._ulIdSvcAuth = ulIdSvcAuth;
        this._has_ulIdSvcAuth = true;
    } //-- void setUlIdSvcAuth(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO unmarshal(java.io.Reader) 

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
