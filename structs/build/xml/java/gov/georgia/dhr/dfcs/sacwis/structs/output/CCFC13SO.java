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
 * Class CCFC13SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC13SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _bIndActiveStatus
     */
    private java.lang.String _bIndActiveStatus;

    /**
     * Field _cSysIndPrimaryWorker
     */
    private java.lang.String _cSysIndPrimaryWorker;

    /**
     * Field _ROWCCFC13SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY _ROWCCFC13SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC13SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO()


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
     * Returns the value of field 'bIndActiveStatus'.
     * 
     * @return the value of field 'BIndActiveStatus'.
     */
    public java.lang.String getBIndActiveStatus()
    {
        return this._bIndActiveStatus;
    } //-- java.lang.String getBIndActiveStatus() 

    /**
     * Returns the value of field 'cSysIndPrimaryWorker'.
     * 
     * @return the value of field 'CSysIndPrimaryWorker'.
     */
    public java.lang.String getCSysIndPrimaryWorker()
    {
        return this._cSysIndPrimaryWorker;
    } //-- java.lang.String getCSysIndPrimaryWorker() 

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
     * Returns the value of field 'ROWCCFC13SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCFC13SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY getROWCCFC13SOG00_ARRAY()
    {
        return this._ROWCCFC13SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY getROWCCFC13SOG00_ARRAY() 

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
     * Sets the value of field 'bIndActiveStatus'.
     * 
     * @param bIndActiveStatus the value of field 'bIndActiveStatus'
     */
    public void setBIndActiveStatus(java.lang.String bIndActiveStatus)
    {
        this._bIndActiveStatus = bIndActiveStatus;
    } //-- void setBIndActiveStatus(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndPrimaryWorker'.
     * 
     * @param cSysIndPrimaryWorker the value of field
     * 'cSysIndPrimaryWorker'.
     */
    public void setCSysIndPrimaryWorker(java.lang.String cSysIndPrimaryWorker)
    {
        this._cSysIndPrimaryWorker = cSysIndPrimaryWorker;
    } //-- void setCSysIndPrimaryWorker(java.lang.String) 

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
     * Sets the value of field 'ROWCCFC13SOG00_ARRAY'.
     * 
     * @param ROWCCFC13SOG00_ARRAY the value of field
     * 'ROWCCFC13SOG00_ARRAY'.
     */
    public void setROWCCFC13SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY ROWCCFC13SOG00_ARRAY)
    {
        this._ROWCCFC13SOG00_ARRAY = ROWCCFC13SOG00_ARRAY;
    } //-- void setROWCCFC13SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO unmarshal(java.io.Reader) 

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
