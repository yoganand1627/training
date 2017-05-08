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
 * Class CCFC39SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC39SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cScrIndToCaseCld
     */
    private java.lang.String _cScrIndToCaseCld;

    /**
     * Field _cSysIndMergeAccess
     */
    private java.lang.String _cSysIndMergeAccess;

    /**
     * Field _szCdCaseProgram
     */
    private java.lang.String _szCdCaseProgram;

    /**
     * Field _dtDtTodaysDate
     */
    private org.exolab.castor.types.Date _dtDtTodaysDate;

    /**
     * Field _ROWCCFC39SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY _ROWCCFC39SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC39SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'cScrIndToCaseCld'.
     * 
     * @return the value of field 'CScrIndToCaseCld'.
     */
    public java.lang.String getCScrIndToCaseCld()
    {
        return this._cScrIndToCaseCld;
    } //-- java.lang.String getCScrIndToCaseCld() 

    /**
     * Returns the value of field 'cSysIndMergeAccess'.
     * 
     * @return the value of field 'CSysIndMergeAccess'.
     */
    public java.lang.String getCSysIndMergeAccess()
    {
        return this._cSysIndMergeAccess;
    } //-- java.lang.String getCSysIndMergeAccess() 

    /**
     * Returns the value of field 'dtDtTodaysDate'.
     * 
     * @return the value of field 'DtDtTodaysDate'.
     */
    public org.exolab.castor.types.Date getDtDtTodaysDate()
    {
        return this._dtDtTodaysDate;
    } //-- org.exolab.castor.types.Date getDtDtTodaysDate() 

    /**
     * Returns the value of field 'ROWCCFC39SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCFC39SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY getROWCCFC39SOG00_ARRAY()
    {
        return this._ROWCCFC39SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY getROWCCFC39SOG00_ARRAY() 

    /**
     * Returns the value of field 'szCdCaseProgram'.
     * 
     * @return the value of field 'SzCdCaseProgram'.
     */
    public java.lang.String getSzCdCaseProgram()
    {
        return this._szCdCaseProgram;
    } //-- java.lang.String getSzCdCaseProgram() 

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
     * Sets the value of field 'cScrIndToCaseCld'.
     * 
     * @param cScrIndToCaseCld the value of field 'cScrIndToCaseCld'
     */
    public void setCScrIndToCaseCld(java.lang.String cScrIndToCaseCld)
    {
        this._cScrIndToCaseCld = cScrIndToCaseCld;
    } //-- void setCScrIndToCaseCld(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndMergeAccess'.
     * 
     * @param cSysIndMergeAccess the value of field
     * 'cSysIndMergeAccess'.
     */
    public void setCSysIndMergeAccess(java.lang.String cSysIndMergeAccess)
    {
        this._cSysIndMergeAccess = cSysIndMergeAccess;
    } //-- void setCSysIndMergeAccess(java.lang.String) 

    /**
     * Sets the value of field 'dtDtTodaysDate'.
     * 
     * @param dtDtTodaysDate the value of field 'dtDtTodaysDate'.
     */
    public void setDtDtTodaysDate(org.exolab.castor.types.Date dtDtTodaysDate)
    {
        this._dtDtTodaysDate = dtDtTodaysDate;
    } //-- void setDtDtTodaysDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCCFC39SOG00_ARRAY'.
     * 
     * @param ROWCCFC39SOG00_ARRAY the value of field
     * 'ROWCCFC39SOG00_ARRAY'.
     */
    public void setROWCCFC39SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY ROWCCFC39SOG00_ARRAY)
    {
        this._ROWCCFC39SOG00_ARRAY = ROWCCFC39SOG00_ARRAY;
    } //-- void setROWCCFC39SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY) 

    /**
     * Sets the value of field 'szCdCaseProgram'.
     * 
     * @param szCdCaseProgram the value of field 'szCdCaseProgram'.
     */
    public void setSzCdCaseProgram(java.lang.String szCdCaseProgram)
    {
        this._szCdCaseProgram = szCdCaseProgram;
    } //-- void setSzCdCaseProgram(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO unmarshal(java.io.Reader) 

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
