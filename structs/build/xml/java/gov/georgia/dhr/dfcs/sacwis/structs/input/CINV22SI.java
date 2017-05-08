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
 * Class CINV22SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV22SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _usSysNbrNumberOfRows
     */
    private int _usSysNbrNumberOfRows;

    /**
     * keeps track of state for field: _usSysNbrNumberOfRows
     */
    private boolean _has_usSysNbrNumberOfRows;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _ROWCINV22SIG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY _ROWCINV22SIG_ARRAY;

    /**
     * Field _ROWCINV22SIG1_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY _ROWCINV22SIG1_ARRAY;

    /**
     * Field _ROWDELETEEXTDOCPERSONCHECK
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK _ROWDELETEEXTDOCPERSONCHECK;

    /**
     * Field _ROWDELEXTDOCPERCHECK_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY _ROWDELEXTDOCPERCHECK_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV22SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'ROWCINV22SIG1_ARRAY'.
     * 
     * @return the value of field 'ROWCINV22SIG1_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY getROWCINV22SIG1_ARRAY()
    {
        return this._ROWCINV22SIG1_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY getROWCINV22SIG1_ARRAY() 

    /**
     * Returns the value of field 'ROWCINV22SIG_ARRAY'.
     * 
     * @return the value of field 'ROWCINV22SIG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY getROWCINV22SIG_ARRAY()
    {
        return this._ROWCINV22SIG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY getROWCINV22SIG_ARRAY() 

    /**
     * Returns the value of field 'ROWDELETEEXTDOCPERSONCHECK'.
     * 
     * @return the value of field 'ROWDELETEEXTDOCPERSONCHECK'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK getROWDELETEEXTDOCPERSONCHECK()
    {
        return this._ROWDELETEEXTDOCPERSONCHECK;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK getROWDELETEEXTDOCPERSONCHECK() 

    /**
     * Returns the value of field 'ROWDELEXTDOCPERCHECK_ARRAY'.
     * 
     * @return the value of field 'ROWDELEXTDOCPERCHECK_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY getROWDELEXTDOCPERCHECK_ARRAY()
    {
        return this._ROWDELEXTDOCPERCHECK_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY getROWDELEXTDOCPERCHECK_ARRAY() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

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
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

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
     * Sets the value of field 'ROWCINV22SIG1_ARRAY'.
     * 
     * @param ROWCINV22SIG1_ARRAY the value of field
     * 'ROWCINV22SIG1_ARRAY'.
     */
    public void setROWCINV22SIG1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY ROWCINV22SIG1_ARRAY)
    {
        this._ROWCINV22SIG1_ARRAY = ROWCINV22SIG1_ARRAY;
    } //-- void setROWCINV22SIG1_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG1_ARRAY) 

    /**
     * Sets the value of field 'ROWCINV22SIG_ARRAY'.
     * 
     * @param ROWCINV22SIG_ARRAY the value of field
     * 'ROWCINV22SIG_ARRAY'.
     */
    public void setROWCINV22SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY ROWCINV22SIG_ARRAY)
    {
        this._ROWCINV22SIG_ARRAY = ROWCINV22SIG_ARRAY;
    } //-- void setROWCINV22SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY) 

    /**
     * Sets the value of field 'ROWDELETEEXTDOCPERSONCHECK'.
     * 
     * @param ROWDELETEEXTDOCPERSONCHECK the value of field
     * 'ROWDELETEEXTDOCPERSONCHECK'.
     */
    public void setROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK ROWDELETEEXTDOCPERSONCHECK)
    {
        this._ROWDELETEEXTDOCPERSONCHECK = ROWDELETEEXTDOCPERSONCHECK;
    } //-- void setROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) 

    /**
     * Sets the value of field 'ROWDELEXTDOCPERCHECK_ARRAY'.
     * 
     * @param ROWDELEXTDOCPERCHECK_ARRAY the value of field
     * 'ROWDELEXTDOCPERCHECK_ARRAY'.
     */
    public void setROWDELEXTDOCPERCHECK_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY ROWDELEXTDOCPERCHECK_ARRAY)
    {
        this._ROWDELEXTDOCPERCHECK_ARRAY = ROWDELEXTDOCPERCHECK_ARRAY;
    } //-- void setROWDELEXTDOCPERCHECK_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY) 

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
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI unmarshal(java.io.Reader) 

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
