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
 * Class CCFC19SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC19SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtCaseClosed
     */
    private org.exolab.castor.types.Date _dtDtCaseClosed;

    /**
     * Field _szCdRecRtnRetenType
     */
    private java.lang.String _szCdRecRtnRetenType;

    /**
     * Field _dtDtRecRtnDstryActual
     */
    private org.exolab.castor.types.Date _dtDtRecRtnDstryActual;

    /**
     * Field _dtDtRecRtnDstryElig
     */
    private org.exolab.castor.types.Date _dtDtRecRtnDstryElig;

    /**
     * Field _szTxtRecRtnDstryDtRsn
     */
    private java.lang.String _szTxtRecRtnDstryDtRsn;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC19SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO()


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
     * Returns the value of field 'dtDtCaseClosed'.
     * 
     * @return the value of field 'DtDtCaseClosed'.
     */
    public org.exolab.castor.types.Date getDtDtCaseClosed()
    {
        return this._dtDtCaseClosed;
    } //-- org.exolab.castor.types.Date getDtDtCaseClosed() 

    /**
     * Returns the value of field 'dtDtRecRtnDstryActual'.
     * 
     * @return the value of field 'DtDtRecRtnDstryActual'.
     */
    public org.exolab.castor.types.Date getDtDtRecRtnDstryActual()
    {
        return this._dtDtRecRtnDstryActual;
    } //-- org.exolab.castor.types.Date getDtDtRecRtnDstryActual() 

    /**
     * Returns the value of field 'dtDtRecRtnDstryElig'.
     * 
     * @return the value of field 'DtDtRecRtnDstryElig'.
     */
    public org.exolab.castor.types.Date getDtDtRecRtnDstryElig()
    {
        return this._dtDtRecRtnDstryElig;
    } //-- org.exolab.castor.types.Date getDtDtRecRtnDstryElig() 

    /**
     * Returns the value of field 'szCdRecRtnRetenType'.
     * 
     * @return the value of field 'SzCdRecRtnRetenType'.
     */
    public java.lang.String getSzCdRecRtnRetenType()
    {
        return this._szCdRecRtnRetenType;
    } //-- java.lang.String getSzCdRecRtnRetenType() 

    /**
     * Returns the value of field 'szTxtRecRtnDstryDtRsn'.
     * 
     * @return the value of field 'SzTxtRecRtnDstryDtRsn'.
     */
    public java.lang.String getSzTxtRecRtnDstryDtRsn()
    {
        return this._szTxtRecRtnDstryDtRsn;
    } //-- java.lang.String getSzTxtRecRtnDstryDtRsn() 

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
     * Sets the value of field 'dtDtCaseClosed'.
     * 
     * @param dtDtCaseClosed the value of field 'dtDtCaseClosed'.
     */
    public void setDtDtCaseClosed(org.exolab.castor.types.Date dtDtCaseClosed)
    {
        this._dtDtCaseClosed = dtDtCaseClosed;
    } //-- void setDtDtCaseClosed(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRecRtnDstryActual'.
     * 
     * @param dtDtRecRtnDstryActual the value of field
     * 'dtDtRecRtnDstryActual'.
     */
    public void setDtDtRecRtnDstryActual(org.exolab.castor.types.Date dtDtRecRtnDstryActual)
    {
        this._dtDtRecRtnDstryActual = dtDtRecRtnDstryActual;
    } //-- void setDtDtRecRtnDstryActual(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRecRtnDstryElig'.
     * 
     * @param dtDtRecRtnDstryElig the value of field
     * 'dtDtRecRtnDstryElig'.
     */
    public void setDtDtRecRtnDstryElig(org.exolab.castor.types.Date dtDtRecRtnDstryElig)
    {
        this._dtDtRecRtnDstryElig = dtDtRecRtnDstryElig;
    } //-- void setDtDtRecRtnDstryElig(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdRecRtnRetenType'.
     * 
     * @param szCdRecRtnRetenType the value of field
     * 'szCdRecRtnRetenType'.
     */
    public void setSzCdRecRtnRetenType(java.lang.String szCdRecRtnRetenType)
    {
        this._szCdRecRtnRetenType = szCdRecRtnRetenType;
    } //-- void setSzCdRecRtnRetenType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRecRtnDstryDtRsn'.
     * 
     * @param szTxtRecRtnDstryDtRsn the value of field
     * 'szTxtRecRtnDstryDtRsn'.
     */
    public void setSzTxtRecRtnDstryDtRsn(java.lang.String szTxtRecRtnDstryDtRsn)
    {
        this._szTxtRecRtnDstryDtRsn = szTxtRecRtnDstryDtRsn;
    } //-- void setSzTxtRecRtnDstryDtRsn(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO unmarshal(java.io.Reader) 

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
