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
 * Class CSUB68SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB68SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB68SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG00 _ROWCSUB68SIG00;

    /**
     * Field _ROWCSUB68SIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01 _ROWCSUB68SIG01;

    /**
     * Field _bSysIndCase
     */
    private java.lang.String _bSysIndCase;

    /**
     * Field _bIndStageClose
     */
    private java.lang.String _bIndStageClose;

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


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB68SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'bIndReopenStageEvent'.
     * 
     * @return the value of field 'BIndReopenStageEvent'.
     */
    public java.lang.String getBIndReopenStageEvent()
    {
        return this._bIndReopenStageEvent;
    } //-- java.lang.String getBIndReopenStageEvent() 

    /**
     * Returns the value of field 'bIndStageClose'.
     * 
     * @return the value of field 'BIndStageClose'.
     */
    public java.lang.String getBIndStageClose()
    {
        return this._bIndStageClose;
    } //-- java.lang.String getBIndStageClose() 

    /**
     * Returns the value of field 'bSysIndCase'.
     * 
     * @return the value of field 'BSysIndCase'.
     */
    public java.lang.String getBSysIndCase()
    {
        return this._bSysIndCase;
    } //-- java.lang.String getBSysIndCase() 

    /**
     * Returns the value of field 'ROWCSUB68SIG00'.
     * 
     * @return the value of field 'ROWCSUB68SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG00 getROWCSUB68SIG00()
    {
        return this._ROWCSUB68SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG00 getROWCSUB68SIG00() 

    /**
     * Returns the value of field 'ROWCSUB68SIG01'.
     * 
     * @return the value of field 'ROWCSUB68SIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01 getROWCSUB68SIG01()
    {
        return this._ROWCSUB68SIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01 getROWCSUB68SIG01() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

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
     * Sets the value of field 'bIndStageClose'.
     * 
     * @param bIndStageClose the value of field 'bIndStageClose'.
     */
    public void setBIndStageClose(java.lang.String bIndStageClose)
    {
        this._bIndStageClose = bIndStageClose;
    } //-- void setBIndStageClose(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndCase'.
     * 
     * @param bSysIndCase the value of field 'bSysIndCase'.
     */
    public void setBSysIndCase(java.lang.String bSysIndCase)
    {
        this._bSysIndCase = bSysIndCase;
    } //-- void setBSysIndCase(java.lang.String) 

    /**
     * Sets the value of field 'ROWCSUB68SIG00'.
     * 
     * @param ROWCSUB68SIG00 the value of field 'ROWCSUB68SIG00'.
     */
    public void setROWCSUB68SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG00 ROWCSUB68SIG00)
    {
        this._ROWCSUB68SIG00 = ROWCSUB68SIG00;
    } //-- void setROWCSUB68SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG00) 

    /**
     * Sets the value of field 'ROWCSUB68SIG01'.
     * 
     * @param ROWCSUB68SIG01 the value of field 'ROWCSUB68SIG01'.
     */
    public void setROWCSUB68SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01 ROWCSUB68SIG01)
    {
        this._ROWCSUB68SIG01 = ROWCSUB68SIG01;
    } //-- void setROWCSUB68SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB68SIG01) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI unmarshal(java.io.Reader) 

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
