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
 * Class CSUB67SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB67SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB67SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00 _ROWCSUB67SOG00;

    /**
     * Field _ROWCSUB67SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01 _ROWCSUB67SOG01;

    /**
     * Field _txtNmFirst
     */
    private java.lang.String _txtNmFirst;

    /**
     * Field _txtNmMiddle
     */
    private java.lang.String _txtNmMiddle;

    /**
     * Field _txtNmLast
     */
    private java.lang.String _txtNmLast;

    /**
     * Field _bIndReopenStageEvent
     */
    private java.lang.String _bIndReopenStageEvent;

    /**
     * Field _szCdStageReasonClosedFromReopen
     */
    private java.lang.String _szCdStageReasonClosedFromReopen;

    /**
     * Field _szTxtStageClosureCmntsFromReopen
     */
    private java.lang.String _szTxtStageClosureCmntsFromReopen;

    /**
     * Field _dtDtStageCloseFromReopen
     */
    private org.exolab.castor.types.Date _dtDtStageCloseFromReopen;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB67SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO()


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
     * Returns the value of field 'bIndReopenStageEvent'.
     * 
     * @return the value of field 'BIndReopenStageEvent'.
     */
    public java.lang.String getBIndReopenStageEvent()
    {
        return this._bIndReopenStageEvent;
    } //-- java.lang.String getBIndReopenStageEvent() 

    /**
     * Returns the value of field 'dtDtStageCloseFromReopen'.
     * 
     * @return the value of field 'DtDtStageCloseFromReopen'.
     */
    public org.exolab.castor.types.Date getDtDtStageCloseFromReopen()
    {
        return this._dtDtStageCloseFromReopen;
    } //-- org.exolab.castor.types.Date getDtDtStageCloseFromReopen() 

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
     * Returns the value of field 'ROWCSUB67SOG00'.
     * 
     * @return the value of field 'ROWCSUB67SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00 getROWCSUB67SOG00()
    {
        return this._ROWCSUB67SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00 getROWCSUB67SOG00() 

    /**
     * Returns the value of field 'ROWCSUB67SOG01'.
     * 
     * @return the value of field 'ROWCSUB67SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01 getROWCSUB67SOG01()
    {
        return this._ROWCSUB67SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01 getROWCSUB67SOG01() 

    /**
     * Returns the value of field
     * 'szCdStageReasonClosedFromReopen'.
     * 
     * @return the value of field 'SzCdStageReasonClosedFromReopen'.
     */
    public java.lang.String getSzCdStageReasonClosedFromReopen()
    {
        return this._szCdStageReasonClosedFromReopen;
    } //-- java.lang.String getSzCdStageReasonClosedFromReopen() 

    /**
     * Returns the value of field
     * 'szTxtStageClosureCmntsFromReopen'.
     * 
     * @return the value of field 'SzTxtStageClosureCmntsFromReopen'
     */
    public java.lang.String getSzTxtStageClosureCmntsFromReopen()
    {
        return this._szTxtStageClosureCmntsFromReopen;
    } //-- java.lang.String getSzTxtStageClosureCmntsFromReopen() 

    /**
     * Returns the value of field 'txtNmFirst'.
     * 
     * @return the value of field 'TxtNmFirst'.
     */
    public java.lang.String getTxtNmFirst()
    {
        return this._txtNmFirst;
    } //-- java.lang.String getTxtNmFirst() 

    /**
     * Returns the value of field 'txtNmLast'.
     * 
     * @return the value of field 'TxtNmLast'.
     */
    public java.lang.String getTxtNmLast()
    {
        return this._txtNmLast;
    } //-- java.lang.String getTxtNmLast() 

    /**
     * Returns the value of field 'txtNmMiddle'.
     * 
     * @return the value of field 'TxtNmMiddle'.
     */
    public java.lang.String getTxtNmMiddle()
    {
        return this._txtNmMiddle;
    } //-- java.lang.String getTxtNmMiddle() 

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
     * Sets the value of field 'bIndReopenStageEvent'.
     * 
     * @param bIndReopenStageEvent the value of field
     * 'bIndReopenStageEvent'.
     */
    public void setBIndReopenStageEvent(java.lang.String bIndReopenStageEvent)
    {
        this._bIndReopenStageEvent = bIndReopenStageEvent;
    } //-- void setBIndReopenStageEvent(java.lang.String) 

    /**
     * Sets the value of field 'dtDtStageCloseFromReopen'.
     * 
     * @param dtDtStageCloseFromReopen the value of field
     * 'dtDtStageCloseFromReopen'.
     */
    public void setDtDtStageCloseFromReopen(org.exolab.castor.types.Date dtDtStageCloseFromReopen)
    {
        this._dtDtStageCloseFromReopen = dtDtStageCloseFromReopen;
    } //-- void setDtDtStageCloseFromReopen(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCSUB67SOG00'.
     * 
     * @param ROWCSUB67SOG00 the value of field 'ROWCSUB67SOG00'.
     */
    public void setROWCSUB67SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00 ROWCSUB67SOG00)
    {
        this._ROWCSUB67SOG00 = ROWCSUB67SOG00;
    } //-- void setROWCSUB67SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00) 

    /**
     * Sets the value of field 'ROWCSUB67SOG01'.
     * 
     * @param ROWCSUB67SOG01 the value of field 'ROWCSUB67SOG01'.
     */
    public void setROWCSUB67SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01 ROWCSUB67SOG01)
    {
        this._ROWCSUB67SOG01 = ROWCSUB67SOG01;
    } //-- void setROWCSUB67SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01) 

    /**
     * Sets the value of field 'szCdStageReasonClosedFromReopen'.
     * 
     * @param szCdStageReasonClosedFromReopen the value of field
     * 'szCdStageReasonClosedFromReopen'.
     */
    public void setSzCdStageReasonClosedFromReopen(java.lang.String szCdStageReasonClosedFromReopen)
    {
        this._szCdStageReasonClosedFromReopen = szCdStageReasonClosedFromReopen;
    } //-- void setSzCdStageReasonClosedFromReopen(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStageClosureCmntsFromReopen'.
     * 
     * @param szTxtStageClosureCmntsFromReopen the value of field
     * 'szTxtStageClosureCmntsFromReopen'.
     */
    public void setSzTxtStageClosureCmntsFromReopen(java.lang.String szTxtStageClosureCmntsFromReopen)
    {
        this._szTxtStageClosureCmntsFromReopen = szTxtStageClosureCmntsFromReopen;
    } //-- void setSzTxtStageClosureCmntsFromReopen(java.lang.String) 

    /**
     * Sets the value of field 'txtNmFirst'.
     * 
     * @param txtNmFirst the value of field 'txtNmFirst'.
     */
    public void setTxtNmFirst(java.lang.String txtNmFirst)
    {
        this._txtNmFirst = txtNmFirst;
    } //-- void setTxtNmFirst(java.lang.String) 

    /**
     * Sets the value of field 'txtNmLast'.
     * 
     * @param txtNmLast the value of field 'txtNmLast'.
     */
    public void setTxtNmLast(java.lang.String txtNmLast)
    {
        this._txtNmLast = txtNmLast;
    } //-- void setTxtNmLast(java.lang.String) 

    /**
     * Sets the value of field 'txtNmMiddle'.
     * 
     * @param txtNmMiddle the value of field 'txtNmMiddle'.
     */
    public void setTxtNmMiddle(java.lang.String txtNmMiddle)
    {
        this._txtNmMiddle = txtNmMiddle;
    } //-- void setTxtNmMiddle(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO unmarshal(java.io.Reader) 

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
