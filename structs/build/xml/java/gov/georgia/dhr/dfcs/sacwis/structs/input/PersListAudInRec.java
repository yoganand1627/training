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
 * Class PersListAudInRec.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PersListAudInRec extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT02SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY _ROWCINT02SIG00_ARRAY;

    /**
     * Field _ROWCINT02SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY _ROWCINT02SIG01_ARRAY;

    /**
     * Field _persListAudStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct _persListAudStruct;

    /**
     * Field _ROWCCMN44SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY _ROWCCMN44SIG00_ARRAY;

    /**
     * Field _ROWCCMN31SI_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY _ROWCCMN31SI_ARRAY;

    /**
     * Field _ROWCINV26SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY _ROWCINV26SIG00_ARRAY;

    /**
     * Field _CINT14WLB_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY _CINT14WLB_ARRAY;

    /**
     * Field _sysLastUpdate
     */
    private java.util.Date _sysLastUpdate;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _usSysNbrNumberOfRows
     */
    private int _usSysNbrNumberOfRows;

    /**
     * keeps track of state for field: _usSysNbrNumberOfRows
     */
    private boolean _has_usSysNbrNumberOfRows;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _bSysIndUpdateFullName
     */
    private java.lang.String _bSysIndUpdateFullName;

    /**
     * Field _bIndPersCancelHist
     */
    private java.lang.String _bIndPersCancelHist;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersListAudInRec() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUsSysNbrNumberOfRows()
    {
        this._has_usSysNbrNumberOfRows= false;
    } //-- void deleteUsSysNbrNumberOfRows() 

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
     * Returns the value of field 'bIndPersCancelHist'.
     * 
     * @return the value of field 'BIndPersCancelHist'.
     */
    public java.lang.String getBIndPersCancelHist()
    {
        return this._bIndPersCancelHist;
    } //-- java.lang.String getBIndPersCancelHist() 

    /**
     * Returns the value of field 'bSysIndUpdateFullName'.
     * 
     * @return the value of field 'BSysIndUpdateFullName'.
     */
    public java.lang.String getBSysIndUpdateFullName()
    {
        return this._bSysIndUpdateFullName;
    } //-- java.lang.String getBSysIndUpdateFullName() 

    /**
     * Returns the value of field 'CINT14WLB_ARRAY'.
     * 
     * @return the value of field 'CINT14WLB_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY getCINT14WLB_ARRAY()
    {
        return this._CINT14WLB_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY getCINT14WLB_ARRAY() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'persListAudStruct'.
     * 
     * @return the value of field 'PersListAudStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct getPersListAudStruct()
    {
        return this._persListAudStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct getPersListAudStruct() 

    /**
     * Returns the value of field 'ROWCCMN31SI_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN31SI_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY getROWCCMN31SI_ARRAY()
    {
        return this._ROWCCMN31SI_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY getROWCCMN31SI_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN44SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN44SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY getROWCCMN44SIG00_ARRAY()
    {
        return this._ROWCCMN44SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY getROWCCMN44SIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCINT02SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINT02SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY getROWCINT02SIG00_ARRAY()
    {
        return this._ROWCINT02SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY getROWCINT02SIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCINT02SIG01_ARRAY'.
     * 
     * @return the value of field 'ROWCINT02SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY getROWCINT02SIG01_ARRAY()
    {
        return this._ROWCINT02SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY getROWCINT02SIG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV26SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCINV26SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY getROWCINV26SIG00_ARRAY()
    {
        return this._ROWCINV26SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY getROWCINV26SIG00_ARRAY() 

    /**
     * Returns the value of field 'sysLastUpdate'.
     * 
     * @return the value of field 'SysLastUpdate'.
     */
    public java.util.Date getSysLastUpdate()
    {
        return this._sysLastUpdate;
    } //-- java.util.Date getSysLastUpdate() 

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
     * Returns the value of field 'usSysNbrNumberOfRows'.
     * 
     * @return the value of field 'UsSysNbrNumberOfRows'.
     */
    public int getUsSysNbrNumberOfRows()
    {
        return this._usSysNbrNumberOfRows;
    } //-- int getUsSysNbrNumberOfRows() 

    /**
     * Method hasUsSysNbrNumberOfRows
     * 
     * 
     * 
     * @return true if at least one UsSysNbrNumberOfRows has been
     * added
     */
    public boolean hasUsSysNbrNumberOfRows()
    {
        return this._has_usSysNbrNumberOfRows;
    } //-- boolean hasUsSysNbrNumberOfRows() 

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
     * Sets the value of field 'bIndPersCancelHist'.
     * 
     * @param bIndPersCancelHist the value of field
     * 'bIndPersCancelHist'.
     */
    public void setBIndPersCancelHist(java.lang.String bIndPersCancelHist)
    {
        this._bIndPersCancelHist = bIndPersCancelHist;
    } //-- void setBIndPersCancelHist(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndUpdateFullName'.
     * 
     * @param bSysIndUpdateFullName the value of field
     * 'bSysIndUpdateFullName'.
     */
    public void setBSysIndUpdateFullName(java.lang.String bSysIndUpdateFullName)
    {
        this._bSysIndUpdateFullName = bSysIndUpdateFullName;
    } //-- void setBSysIndUpdateFullName(java.lang.String) 

    /**
     * Sets the value of field 'CINT14WLB_ARRAY'.
     * 
     * @param CINT14WLB_ARRAY the value of field 'CINT14WLB_ARRAY'.
     */
    public void setCINT14WLB_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY CINT14WLB_ARRAY)
    {
        this._CINT14WLB_ARRAY = CINT14WLB_ARRAY;
    } //-- void setCINT14WLB_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'persListAudStruct'.
     * 
     * @param persListAudStruct the value of field
     * 'persListAudStruct'.
     */
    public void setPersListAudStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct persListAudStruct)
    {
        this._persListAudStruct = persListAudStruct;
    } //-- void setPersListAudStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct) 

    /**
     * Sets the value of field 'ROWCCMN31SI_ARRAY'.
     * 
     * @param ROWCCMN31SI_ARRAY the value of field
     * 'ROWCCMN31SI_ARRAY'.
     */
    public void setROWCCMN31SI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY ROWCCMN31SI_ARRAY)
    {
        this._ROWCCMN31SI_ARRAY = ROWCCMN31SI_ARRAY;
    } //-- void setROWCCMN31SI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN44SIG00_ARRAY'.
     * 
     * @param ROWCCMN44SIG00_ARRAY the value of field
     * 'ROWCCMN44SIG00_ARRAY'.
     */
    public void setROWCCMN44SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY ROWCCMN44SIG00_ARRAY)
    {
        this._ROWCCMN44SIG00_ARRAY = ROWCCMN44SIG00_ARRAY;
    } //-- void setROWCCMN44SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCINT02SIG00_ARRAY'.
     * 
     * @param ROWCINT02SIG00_ARRAY the value of field
     * 'ROWCINT02SIG00_ARRAY'.
     */
    public void setROWCINT02SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY ROWCINT02SIG00_ARRAY)
    {
        this._ROWCINT02SIG00_ARRAY = ROWCINT02SIG00_ARRAY;
    } //-- void setROWCINT02SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCINT02SIG01_ARRAY'.
     * 
     * @param ROWCINT02SIG01_ARRAY the value of field
     * 'ROWCINT02SIG01_ARRAY'.
     */
    public void setROWCINT02SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY ROWCINT02SIG01_ARRAY)
    {
        this._ROWCINT02SIG01_ARRAY = ROWCINT02SIG01_ARRAY;
    } //-- void setROWCINT02SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV26SIG00_ARRAY'.
     * 
     * @param ROWCINV26SIG00_ARRAY the value of field
     * 'ROWCINV26SIG00_ARRAY'.
     */
    public void setROWCINV26SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY ROWCINV26SIG00_ARRAY)
    {
        this._ROWCINV26SIG00_ARRAY = ROWCINV26SIG00_ARRAY;
    } //-- void setROWCINV26SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY) 

    /**
     * Sets the value of field 'sysLastUpdate'.
     * 
     * @param sysLastUpdate the value of field 'sysLastUpdate'.
     */
    public void setSysLastUpdate(java.util.Date sysLastUpdate)
    {
        this._sysLastUpdate = sysLastUpdate;
    } //-- void setSysLastUpdate(java.util.Date) 

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
     * Sets the value of field 'usSysNbrNumberOfRows'.
     * 
     * @param usSysNbrNumberOfRows the value of field
     * 'usSysNbrNumberOfRows'.
     */
    public void setUsSysNbrNumberOfRows(int usSysNbrNumberOfRows)
    {
        this._usSysNbrNumberOfRows = usSysNbrNumberOfRows;
        this._has_usSysNbrNumberOfRows = true;
    } //-- void setUsSysNbrNumberOfRows(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec unmarshal(java.io.Reader) 

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
