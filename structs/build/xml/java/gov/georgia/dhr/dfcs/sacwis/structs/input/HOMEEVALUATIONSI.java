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
 * Class HOMEEVALUATIONSI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HOMEEVALUATIONSI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _cdStatusNew
     */
    private java.lang.String _cdStatusNew;

    /**
     * Field _dtDtSampleFrom
     */
    private org.exolab.castor.types.Date _dtDtSampleFrom;

    /**
     * Field _dtDtSampleTo
     */
    private org.exolab.castor.types.Date _dtDtSampleTo;


      //----------------/
     //- Constructors -/
    //----------------/

    public HOMEEVALUATIONSI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'cdStatusNew'.
     * 
     * @return the value of field 'CdStatusNew'.
     */
    public java.lang.String getCdStatusNew()
    {
        return this._cdStatusNew;
    } //-- java.lang.String getCdStatusNew() 

    /**
     * Returns the value of field 'dtDtSampleFrom'.
     * 
     * @return the value of field 'DtDtSampleFrom'.
     */
    public org.exolab.castor.types.Date getDtDtSampleFrom()
    {
        return this._dtDtSampleFrom;
    } //-- org.exolab.castor.types.Date getDtDtSampleFrom() 

    /**
     * Returns the value of field 'dtDtSampleTo'.
     * 
     * @return the value of field 'DtDtSampleTo'.
     */
    public org.exolab.castor.types.Date getDtDtSampleTo()
    {
        return this._dtDtSampleTo;
    } //-- org.exolab.castor.types.Date getDtDtSampleTo() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

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
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

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
     * Sets the value of field 'cdStatusNew'.
     * 
     * @param cdStatusNew the value of field 'cdStatusNew'.
     */
    public void setCdStatusNew(java.lang.String cdStatusNew)
    {
        this._cdStatusNew = cdStatusNew;
    } //-- void setCdStatusNew(java.lang.String) 

    /**
     * Sets the value of field 'dtDtSampleFrom'.
     * 
     * @param dtDtSampleFrom the value of field 'dtDtSampleFrom'.
     */
    public void setDtDtSampleFrom(org.exolab.castor.types.Date dtDtSampleFrom)
    {
        this._dtDtSampleFrom = dtDtSampleFrom;
    } //-- void setDtDtSampleFrom(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSampleTo'.
     * 
     * @param dtDtSampleTo the value of field 'dtDtSampleTo'.
     */
    public void setDtDtSampleTo(org.exolab.castor.types.Date dtDtSampleTo)
    {
        this._dtDtSampleTo = dtDtSampleTo;
    } //-- void setDtDtSampleTo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI unmarshal(java.io.Reader) 

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