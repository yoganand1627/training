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
 * Class CSUB19SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB19SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB19SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00 _ROWCSUB19SIG00;

    /**
     * Field _ROWCSUB19SIG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG01 _ROWCSUB19SIG01;

    /**
     * Field _bSysIndPrfrmValidation
     */
    private java.lang.String _bSysIndPrfrmValidation;

    /**
     * Field _szSysCdWinMode
     */
    private java.lang.String _szSysCdWinMode;

    /**
     * Field _szCdMedUpdTransTypE_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY _szCdMedUpdTransTypE_ARRAY;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB19SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI()


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
     * Returns the value of field 'bSysIndGeneric'.
     * 
     * @return the value of field 'BSysIndGeneric'.
     */
    public java.lang.String getBSysIndGeneric()
    {
        return this._bSysIndGeneric;
    } //-- java.lang.String getBSysIndGeneric() 

    /**
     * Returns the value of field 'bSysIndPrfrmValidation'.
     * 
     * @return the value of field 'BSysIndPrfrmValidation'.
     */
    public java.lang.String getBSysIndPrfrmValidation()
    {
        return this._bSysIndPrfrmValidation;
    } //-- java.lang.String getBSysIndPrfrmValidation() 

    /**
     * Returns the value of field 'ROWCSUB19SIG00'.
     * 
     * @return the value of field 'ROWCSUB19SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00 getROWCSUB19SIG00()
    {
        return this._ROWCSUB19SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00 getROWCSUB19SIG00() 

    /**
     * Returns the value of field 'ROWCSUB19SIG01'.
     * 
     * @return the value of field 'ROWCSUB19SIG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG01 getROWCSUB19SIG01()
    {
        return this._ROWCSUB19SIG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG01 getROWCSUB19SIG01() 

    /**
     * Returns the value of field 'szCdMedUpdTransTypE_ARRAY'.
     * 
     * @return the value of field 'SzCdMedUpdTransTypE_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY getSzCdMedUpdTransTypE_ARRAY()
    {
        return this._szCdMedUpdTransTypE_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY getSzCdMedUpdTransTypE_ARRAY() 

    /**
     * Returns the value of field 'szSysCdWinMode'.
     * 
     * @return the value of field 'SzSysCdWinMode'.
     */
    public java.lang.String getSzSysCdWinMode()
    {
        return this._szSysCdWinMode;
    } //-- java.lang.String getSzSysCdWinMode() 

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
     * Sets the value of field 'bSysIndGeneric'.
     * 
     * @param bSysIndGeneric the value of field 'bSysIndGeneric'.
     */
    public void setBSysIndGeneric(java.lang.String bSysIndGeneric)
    {
        this._bSysIndGeneric = bSysIndGeneric;
    } //-- void setBSysIndGeneric(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndPrfrmValidation'.
     * 
     * @param bSysIndPrfrmValidation the value of field
     * 'bSysIndPrfrmValidation'.
     */
    public void setBSysIndPrfrmValidation(java.lang.String bSysIndPrfrmValidation)
    {
        this._bSysIndPrfrmValidation = bSysIndPrfrmValidation;
    } //-- void setBSysIndPrfrmValidation(java.lang.String) 

    /**
     * Sets the value of field 'ROWCSUB19SIG00'.
     * 
     * @param ROWCSUB19SIG00 the value of field 'ROWCSUB19SIG00'.
     */
    public void setROWCSUB19SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00 ROWCSUB19SIG00)
    {
        this._ROWCSUB19SIG00 = ROWCSUB19SIG00;
    } //-- void setROWCSUB19SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00) 

    /**
     * Sets the value of field 'ROWCSUB19SIG01'.
     * 
     * @param ROWCSUB19SIG01 the value of field 'ROWCSUB19SIG01'.
     */
    public void setROWCSUB19SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG01 ROWCSUB19SIG01)
    {
        this._ROWCSUB19SIG01 = ROWCSUB19SIG01;
    } //-- void setROWCSUB19SIG01(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG01) 

    /**
     * Sets the value of field 'szCdMedUpdTransTypE_ARRAY'.
     * 
     * @param szCdMedUpdTransTypE_ARRAY the value of field
     * 'szCdMedUpdTransTypE_ARRAY'.
     */
    public void setSzCdMedUpdTransTypE_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY szCdMedUpdTransTypE_ARRAY)
    {
        this._szCdMedUpdTransTypE_ARRAY = szCdMedUpdTransTypE_ARRAY;
    } //-- void setSzCdMedUpdTransTypE_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdMedUpdTransTypE_ARRAY) 

    /**
     * Sets the value of field 'szSysCdWinMode'.
     * 
     * @param szSysCdWinMode the value of field 'szSysCdWinMode'.
     */
    public void setSzSysCdWinMode(java.lang.String szSysCdWinMode)
    {
        this._szSysCdWinMode = szSysCdWinMode;
    } //-- void setSzSysCdWinMode(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI unmarshal(java.io.Reader) 

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
