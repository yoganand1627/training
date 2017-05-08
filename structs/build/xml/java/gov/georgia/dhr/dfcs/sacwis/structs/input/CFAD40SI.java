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
 * Class CFAD40SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD40SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _CFAD40SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00 _CFAD40SIG00;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdPlcmtEvent
     */
    private int _ulIdPlcmtEvent;

    /**
     * keeps track of state for field: _ulIdPlcmtEvent
     */
    private boolean _has_ulIdPlcmtEvent;

    /**
     * Field _bSysIndGeneric
     */
    private java.lang.String _bSysIndGeneric;

    /**
     * Field _bSysIndUserTodo
     */
    private java.lang.String _bSysIndUserTodo;

    /**
     * Field _szCdMedUpdTransTypE
     */
    private java.lang.String _szCdMedUpdTransTypE;

    /**
     * Field _ulSysNbrValidationMsg
     */
    private int _ulSysNbrValidationMsg;

    /**
     * keeps track of state for field: _ulSysNbrValidationMsg
     */
    private boolean _has_ulSysNbrValidationMsg;

    /**
     * Field _cSysIndAppSent
     */
    private java.lang.String _cSysIndAppSent;

    /**
     * Field _cSysIndAgreeSent
     */
    private java.lang.String _cSysIndAgreeSent;

    /**
     * Field _cSysIndAgreeRtn
     */
    private java.lang.String _cSysIndAgreeRtn;

    /**
     * Field _cSysIndSubEnd
     */
    private java.lang.String _cSysIndSubEnd;

    /**
     * Field _szCdMedUpdType
     */
    private java.lang.String _szCdMedUpdType;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD40SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI()


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
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdPlcmtEvent()
    {
        this._has_ulIdPlcmtEvent= false;
    } //-- void deleteUlIdPlcmtEvent() 

    /**
     */
    public void deleteUlSysNbrValidationMsg()
    {
        this._has_ulSysNbrValidationMsg= false;
    } //-- void deleteUlSysNbrValidationMsg() 

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
     * Returns the value of field 'bSysIndUserTodo'.
     * 
     * @return the value of field 'BSysIndUserTodo'.
     */
    public java.lang.String getBSysIndUserTodo()
    {
        return this._bSysIndUserTodo;
    } //-- java.lang.String getBSysIndUserTodo() 

    /**
     * Returns the value of field 'CFAD40SIG00'.
     * 
     * @return the value of field 'CFAD40SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00 getCFAD40SIG00()
    {
        return this._CFAD40SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00 getCFAD40SIG00() 

    /**
     * Returns the value of field 'cSysIndAgreeRtn'.
     * 
     * @return the value of field 'CSysIndAgreeRtn'.
     */
    public java.lang.String getCSysIndAgreeRtn()
    {
        return this._cSysIndAgreeRtn;
    } //-- java.lang.String getCSysIndAgreeRtn() 

    /**
     * Returns the value of field 'cSysIndAgreeSent'.
     * 
     * @return the value of field 'CSysIndAgreeSent'.
     */
    public java.lang.String getCSysIndAgreeSent()
    {
        return this._cSysIndAgreeSent;
    } //-- java.lang.String getCSysIndAgreeSent() 

    /**
     * Returns the value of field 'cSysIndAppSent'.
     * 
     * @return the value of field 'CSysIndAppSent'.
     */
    public java.lang.String getCSysIndAppSent()
    {
        return this._cSysIndAppSent;
    } //-- java.lang.String getCSysIndAppSent() 

    /**
     * Returns the value of field 'cSysIndSubEnd'.
     * 
     * @return the value of field 'CSysIndSubEnd'.
     */
    public java.lang.String getCSysIndSubEnd()
    {
        return this._cSysIndSubEnd;
    } //-- java.lang.String getCSysIndSubEnd() 

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
     * Returns the value of field 'szCdMedUpdTransTypE'.
     * 
     * @return the value of field 'SzCdMedUpdTransTypE'.
     */
    public java.lang.String getSzCdMedUpdTransTypE()
    {
        return this._szCdMedUpdTransTypE;
    } //-- java.lang.String getSzCdMedUpdTransTypE() 

    /**
     * Returns the value of field 'szCdMedUpdType'.
     * 
     * @return the value of field 'SzCdMedUpdType'.
     */
    public java.lang.String getSzCdMedUpdType()
    {
        return this._szCdMedUpdType;
    } //-- java.lang.String getSzCdMedUpdType() 

    /**
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdPlcmtEvent'.
     * 
     * @return the value of field 'UlIdPlcmtEvent'.
     */
    public int getUlIdPlcmtEvent()
    {
        return this._ulIdPlcmtEvent;
    } //-- int getUlIdPlcmtEvent() 

    /**
     * Returns the value of field 'ulSysNbrValidationMsg'.
     * 
     * @return the value of field 'UlSysNbrValidationMsg'.
     */
    public int getUlSysNbrValidationMsg()
    {
        return this._ulSysNbrValidationMsg;
    } //-- int getUlSysNbrValidationMsg() 

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
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

    /**
     * Method hasUlIdPlcmtEvent
     * 
     * 
     * 
     * @return true if at least one UlIdPlcmtEvent has been added
     */
    public boolean hasUlIdPlcmtEvent()
    {
        return this._has_ulIdPlcmtEvent;
    } //-- boolean hasUlIdPlcmtEvent() 

    /**
     * Method hasUlSysNbrValidationMsg
     * 
     * 
     * 
     * @return true if at least one UlSysNbrValidationMsg has been
     * added
     */
    public boolean hasUlSysNbrValidationMsg()
    {
        return this._has_ulSysNbrValidationMsg;
    } //-- boolean hasUlSysNbrValidationMsg() 

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
     * Sets the value of field 'bSysIndUserTodo'.
     * 
     * @param bSysIndUserTodo the value of field 'bSysIndUserTodo'.
     */
    public void setBSysIndUserTodo(java.lang.String bSysIndUserTodo)
    {
        this._bSysIndUserTodo = bSysIndUserTodo;
    } //-- void setBSysIndUserTodo(java.lang.String) 

    /**
     * Sets the value of field 'CFAD40SIG00'.
     * 
     * @param CFAD40SIG00 the value of field 'CFAD40SIG00'.
     */
    public void setCFAD40SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00 CFAD40SIG00)
    {
        this._CFAD40SIG00 = CFAD40SIG00;
    } //-- void setCFAD40SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00) 

    /**
     * Sets the value of field 'cSysIndAgreeRtn'.
     * 
     * @param cSysIndAgreeRtn the value of field 'cSysIndAgreeRtn'.
     */
    public void setCSysIndAgreeRtn(java.lang.String cSysIndAgreeRtn)
    {
        this._cSysIndAgreeRtn = cSysIndAgreeRtn;
    } //-- void setCSysIndAgreeRtn(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndAgreeSent'.
     * 
     * @param cSysIndAgreeSent the value of field 'cSysIndAgreeSent'
     */
    public void setCSysIndAgreeSent(java.lang.String cSysIndAgreeSent)
    {
        this._cSysIndAgreeSent = cSysIndAgreeSent;
    } //-- void setCSysIndAgreeSent(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndAppSent'.
     * 
     * @param cSysIndAppSent the value of field 'cSysIndAppSent'.
     */
    public void setCSysIndAppSent(java.lang.String cSysIndAppSent)
    {
        this._cSysIndAppSent = cSysIndAppSent;
    } //-- void setCSysIndAppSent(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndSubEnd'.
     * 
     * @param cSysIndSubEnd the value of field 'cSysIndSubEnd'.
     */
    public void setCSysIndSubEnd(java.lang.String cSysIndSubEnd)
    {
        this._cSysIndSubEnd = cSysIndSubEnd;
    } //-- void setCSysIndSubEnd(java.lang.String) 

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
     * Sets the value of field 'szCdMedUpdTransTypE'.
     * 
     * @param szCdMedUpdTransTypE the value of field
     * 'szCdMedUpdTransTypE'.
     */
    public void setSzCdMedUpdTransTypE(java.lang.String szCdMedUpdTransTypE)
    {
        this._szCdMedUpdTransTypE = szCdMedUpdTransTypE;
    } //-- void setSzCdMedUpdTransTypE(java.lang.String) 

    /**
     * Sets the value of field 'szCdMedUpdType'.
     * 
     * @param szCdMedUpdType the value of field 'szCdMedUpdType'.
     */
    public void setSzCdMedUpdType(java.lang.String szCdMedUpdType)
    {
        this._szCdMedUpdType = szCdMedUpdType;
    } //-- void setSzCdMedUpdType(java.lang.String) 

    /**
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

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
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

    /**
     * Sets the value of field 'ulIdPlcmtEvent'.
     * 
     * @param ulIdPlcmtEvent the value of field 'ulIdPlcmtEvent'.
     */
    public void setUlIdPlcmtEvent(int ulIdPlcmtEvent)
    {
        this._ulIdPlcmtEvent = ulIdPlcmtEvent;
        this._has_ulIdPlcmtEvent = true;
    } //-- void setUlIdPlcmtEvent(int) 

    /**
     * Sets the value of field 'ulSysNbrValidationMsg'.
     * 
     * @param ulSysNbrValidationMsg the value of field
     * 'ulSysNbrValidationMsg'.
     */
    public void setUlSysNbrValidationMsg(int ulSysNbrValidationMsg)
    {
        this._ulSysNbrValidationMsg = ulSysNbrValidationMsg;
        this._has_ulSysNbrValidationMsg = true;
    } //-- void setUlSysNbrValidationMsg(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI unmarshal(java.io.Reader) 

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
