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
 * Class CSUB39SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB39SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB39SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB39SIG00 _ROWCSUB39SIG00;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _cSysIndDtOutcomeFlld
     */
    private java.lang.String _cSysIndDtOutcomeFlld;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _ulSysIdTodoCfPersCrea
     */
    private int _ulSysIdTodoCfPersCrea;

    /**
     * keeps track of state for field: _ulSysIdTodoCfPersCrea
     */
    private boolean _has_ulSysIdTodoCfPersCrea;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _cSysIndDamCalled
     */
    private java.lang.String _cSysIndDamCalled;

    /**
     * Field _bIndSavePressed
     */
    private boolean _bIndSavePressed;

    /**
     * keeps track of state for field: _bIndSavePressed
     */
    private boolean _has_bIndSavePressed;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB39SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndSavePressed()
    {
        this._has_bIndSavePressed= false;
    } //-- void deleteBIndSavePressed() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlSysIdTodoCfPersCrea()
    {
        this._has_ulSysIdTodoCfPersCrea= false;
    } //-- void deleteUlSysIdTodoCfPersCrea() 

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
     * Returns the value of field 'bIndSavePressed'.
     * 
     * @return the value of field 'BIndSavePressed'.
     */
    public boolean getBIndSavePressed()
    {
        return this._bIndSavePressed;
    } //-- boolean getBIndSavePressed() 

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
     * Returns the value of field 'cSysIndDamCalled'.
     * 
     * @return the value of field 'CSysIndDamCalled'.
     */
    public java.lang.String getCSysIndDamCalled()
    {
        return this._cSysIndDamCalled;
    } //-- java.lang.String getCSysIndDamCalled() 

    /**
     * Returns the value of field 'cSysIndDtOutcomeFlld'.
     * 
     * @return the value of field 'CSysIndDtOutcomeFlld'.
     */
    public java.lang.String getCSysIndDtOutcomeFlld()
    {
        return this._cSysIndDtOutcomeFlld;
    } //-- java.lang.String getCSysIndDtOutcomeFlld() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00'.
     * 
     * @return the value of field 'ROWCCMN01UIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00()
    {
        return this._ROWCCMN01UIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 getROWCCMN01UIG00() 

    /**
     * Returns the value of field 'ROWCSUB39SIG00'.
     * 
     * @return the value of field 'ROWCSUB39SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB39SIG00 getROWCSUB39SIG00()
    {
        return this._ROWCSUB39SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB39SIG00 getROWCSUB39SIG00() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

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
     * Returns the value of field 'ulSysIdTodoCfPersCrea'.
     * 
     * @return the value of field 'UlSysIdTodoCfPersCrea'.
     */
    public int getUlSysIdTodoCfPersCrea()
    {
        return this._ulSysIdTodoCfPersCrea;
    } //-- int getUlSysIdTodoCfPersCrea() 

    /**
     * Method hasBIndSavePressed
     * 
     * 
     * 
     * @return true if at least one BIndSavePressed has been added
     */
    public boolean hasBIndSavePressed()
    {
        return this._has_bIndSavePressed;
    } //-- boolean hasBIndSavePressed() 

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
     * Method hasUlSysIdTodoCfPersCrea
     * 
     * 
     * 
     * @return true if at least one UlSysIdTodoCfPersCrea has been
     * added
     */
    public boolean hasUlSysIdTodoCfPersCrea()
    {
        return this._has_ulSysIdTodoCfPersCrea;
    } //-- boolean hasUlSysIdTodoCfPersCrea() 

    /**
     * Returns the value of field 'bIndSavePressed'.
     * 
     * @return the value of field 'BIndSavePressed'.
     */
    public boolean isBIndSavePressed()
    {
        return this._bIndSavePressed;
    } //-- boolean isBIndSavePressed() 

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
     * Sets the value of field 'bIndSavePressed'.
     * 
     * @param bIndSavePressed the value of field 'bIndSavePressed'.
     */
    public void setBIndSavePressed(boolean bIndSavePressed)
    {
        this._bIndSavePressed = bIndSavePressed;
        this._has_bIndSavePressed = true;
    } //-- void setBIndSavePressed(boolean) 

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
     * Sets the value of field 'cSysIndDamCalled'.
     * 
     * @param cSysIndDamCalled the value of field 'cSysIndDamCalled'
     */
    public void setCSysIndDamCalled(java.lang.String cSysIndDamCalled)
    {
        this._cSysIndDamCalled = cSysIndDamCalled;
    } //-- void setCSysIndDamCalled(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndDtOutcomeFlld'.
     * 
     * @param cSysIndDtOutcomeFlld the value of field
     * 'cSysIndDtOutcomeFlld'.
     */
    public void setCSysIndDtOutcomeFlld(java.lang.String cSysIndDtOutcomeFlld)
    {
        this._cSysIndDtOutcomeFlld = cSysIndDtOutcomeFlld;
    } //-- void setCSysIndDtOutcomeFlld(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00'.
     * 
     * @param ROWCCMN01UIG00 the value of field 'ROWCCMN01UIG00'.
     */
    public void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 ROWCCMN01UIG00)
    {
        this._ROWCCMN01UIG00 = ROWCCMN01UIG00;
    } //-- void setROWCCMN01UIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00) 

    /**
     * Sets the value of field 'ROWCSUB39SIG00'.
     * 
     * @param ROWCSUB39SIG00 the value of field 'ROWCSUB39SIG00'.
     */
    public void setROWCSUB39SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB39SIG00 ROWCSUB39SIG00)
    {
        this._ROWCSUB39SIG00 = ROWCSUB39SIG00;
    } //-- void setROWCSUB39SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB39SIG00) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

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
     * Sets the value of field 'ulSysIdTodoCfPersCrea'.
     * 
     * @param ulSysIdTodoCfPersCrea the value of field
     * 'ulSysIdTodoCfPersCrea'.
     */
    public void setUlSysIdTodoCfPersCrea(int ulSysIdTodoCfPersCrea)
    {
        this._ulSysIdTodoCfPersCrea = ulSysIdTodoCfPersCrea;
        this._has_ulSysIdTodoCfPersCrea = true;
    } //-- void setUlSysIdTodoCfPersCrea(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI unmarshal(java.io.Reader) 

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
