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
 * Class CSUB50SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB50SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CSUB50SIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SIG00 _CSUB50SIG00;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _cReqFuncCd
     */
    private java.lang.String _cReqFuncCd;

    /**
     * Field _cSysIndDtPptCompFlld
     */
    private java.lang.String _cSysIndDtPptCompFlld;

    /**
     * Field _szCdEventStatus_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY _szCdEventStatus_ARRAY;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulSysIdTodoCfPersCrea
     */
    private int _ulSysIdTodoCfPersCrea;

    /**
     * keeps track of state for field: _ulSysIdTodoCfPersCrea
     */
    private boolean _has_ulSysIdTodoCfPersCrea;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB50SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI()


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
     * Returns the value of field 'cReqFuncCd'.
     * 
     * @return the value of field 'CReqFuncCd'.
     */
    public java.lang.String getCReqFuncCd()
    {
        return this._cReqFuncCd;
    } //-- java.lang.String getCReqFuncCd() 

    /**
     * Returns the value of field 'CSUB50SIG00'.
     * 
     * @return the value of field 'CSUB50SIG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SIG00 getCSUB50SIG00()
    {
        return this._CSUB50SIG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SIG00 getCSUB50SIG00() 

    /**
     * Returns the value of field 'cSysIndDtPptCompFlld'.
     * 
     * @return the value of field 'CSysIndDtPptCompFlld'.
     */
    public java.lang.String getCSysIndDtPptCompFlld()
    {
        return this._cSysIndDtPptCompFlld;
    } //-- java.lang.String getCSysIndDtPptCompFlld() 

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
     * Returns the value of field 'szCdEventStatus_ARRAY'.
     * 
     * @return the value of field 'SzCdEventStatus_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY getSzCdEventStatus_ARRAY()
    {
        return this._szCdEventStatus_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY getSzCdEventStatus_ARRAY() 

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
     * Sets the value of field 'cReqFuncCd'.
     * 
     * @param cReqFuncCd the value of field 'cReqFuncCd'.
     */
    public void setCReqFuncCd(java.lang.String cReqFuncCd)
    {
        this._cReqFuncCd = cReqFuncCd;
    } //-- void setCReqFuncCd(java.lang.String) 

    /**
     * Sets the value of field 'CSUB50SIG00'.
     * 
     * @param CSUB50SIG00 the value of field 'CSUB50SIG00'.
     */
    public void setCSUB50SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SIG00 CSUB50SIG00)
    {
        this._CSUB50SIG00 = CSUB50SIG00;
    } //-- void setCSUB50SIG00(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SIG00) 

    /**
     * Sets the value of field 'cSysIndDtPptCompFlld'.
     * 
     * @param cSysIndDtPptCompFlld the value of field
     * 'cSysIndDtPptCompFlld'.
     */
    public void setCSysIndDtPptCompFlld(java.lang.String cSysIndDtPptCompFlld)
    {
        this._cSysIndDtPptCompFlld = cSysIndDtPptCompFlld;
    } //-- void setCSysIndDtPptCompFlld(java.lang.String) 

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
     * Sets the value of field 'szCdEventStatus_ARRAY'.
     * 
     * @param szCdEventStatus_ARRAY the value of field
     * 'szCdEventStatus_ARRAY'.
     */
    public void setSzCdEventStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY szCdEventStatus_ARRAY)
    {
        this._szCdEventStatus_ARRAY = szCdEventStatus_ARRAY;
    } //-- void setSzCdEventStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI unmarshal(java.io.Reader) 

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
