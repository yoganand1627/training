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
 * Class CFIN06SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN06SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdSvcDtlService_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY _szCdSvcDtlService_ARRAY;

    /**
     * Field _dtSysDtGenericSysdate_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY _dtSysDtGenericSysdate_ARRAY;

    /**
     * Field _ROWCFIN06SOG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY _ROWCFIN06SOG_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN06SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO()


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
     * Returns the value of field 'dtSysDtGenericSysdate_ARRAY'.
     * 
     * @return the value of field 'DtSysDtGenericSysdate_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY getDtSysDtGenericSysdate_ARRAY()
    {
        return this._dtSysDtGenericSysdate_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY getDtSysDtGenericSysdate_ARRAY() 

    /**
     * Returns the value of field 'ROWCFIN06SOG_ARRAY'.
     * 
     * @return the value of field 'ROWCFIN06SOG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY getROWCFIN06SOG_ARRAY()
    {
        return this._ROWCFIN06SOG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY getROWCFIN06SOG_ARRAY() 

    /**
     * Returns the value of field 'szCdSvcDtlService_ARRAY'.
     * 
     * @return the value of field 'SzCdSvcDtlService_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY getSzCdSvcDtlService_ARRAY()
    {
        return this._szCdSvcDtlService_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY getSzCdSvcDtlService_ARRAY() 

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
     * Sets the value of field 'dtSysDtGenericSysdate_ARRAY'.
     * 
     * @param dtSysDtGenericSysdate_ARRAY the value of field
     * 'dtSysDtGenericSysdate_ARRAY'.
     */
    public void setDtSysDtGenericSysdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY dtSysDtGenericSysdate_ARRAY)
    {
        this._dtSysDtGenericSysdate_ARRAY = dtSysDtGenericSysdate_ARRAY;
    } //-- void setDtSysDtGenericSysdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.DtSysDtGenericSysdate_ARRAY) 

    /**
     * Sets the value of field 'ROWCFIN06SOG_ARRAY'.
     * 
     * @param ROWCFIN06SOG_ARRAY the value of field
     * 'ROWCFIN06SOG_ARRAY'.
     */
    public void setROWCFIN06SOG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY ROWCFIN06SOG_ARRAY)
    {
        this._ROWCFIN06SOG_ARRAY = ROWCFIN06SOG_ARRAY;
    } //-- void setROWCFIN06SOG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY) 

    /**
     * Sets the value of field 'szCdSvcDtlService_ARRAY'.
     * 
     * @param szCdSvcDtlService_ARRAY the value of field
     * 'szCdSvcDtlService_ARRAY'.
     */
    public void setSzCdSvcDtlService_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY szCdSvcDtlService_ARRAY)
    {
        this._szCdSvcDtlService_ARRAY = szCdSvcDtlService_ARRAY;
    } //-- void setSzCdSvcDtlService_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdSvcDtlService_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO unmarshal(java.io.Reader) 

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
