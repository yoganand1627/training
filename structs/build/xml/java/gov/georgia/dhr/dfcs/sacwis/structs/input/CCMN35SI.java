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
 * Class CCMN35SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN35SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _aprvlStageProg
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg _aprvlStageProg;

    /**
     * Field _ROWCCMN61DI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN61DI _ROWCCMN61DI;

    /**
     * Field _ROWCCMNI2DI
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI _ROWCCMNI2DI;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _ldIdTodo
     */
    private int _ldIdTodo;

    /**
     * keeps track of state for field: _ldIdTodo
     */
    private boolean _has_ldIdTodo;

    /**
     * Field _ulIdApproval
     */
    private int _ulIdApproval;

    /**
     * keeps track of state for field: _ulIdApproval
     */
    private boolean _has_ulIdApproval;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _bIndDesigneeAprvl
     */
    private java.lang.String _bIndDesigneeAprvl;

    /**
     * Field _szWcdCdAprvlWinaction
     */
    private java.lang.String _szWcdCdAprvlWinaction;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _ulIdCntrctWkr
     */
    private int _ulIdCntrctWkr;

    /**
     * keeps track of state for field: _ulIdCntrctWkr
     */
    private boolean _has_ulIdCntrctWkr;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _szCdAttrRegSsStf
     */
    private java.lang.String _szCdAttrRegSsStf;

    /**
     * Field _bIndAdoptionFinalized
     */
    private java.lang.String _bIndAdoptionFinalized;

    /**
     * Field _szWhichSpclInvApprover
     */
    private java.lang.String _szWhichSpclInvApprover;

    /**
     * Field _szWhichSafetyRsrcApprover
     */
    private java.lang.String _szWhichSafetyRsrcApprover;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCMN35SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLdIdTodo()
    {
        this._has_ldIdTodo= false;
    } //-- void deleteLdIdTodo() 

    /**
     */
    public void deleteUlIdApproval()
    {
        this._has_ulIdApproval= false;
    } //-- void deleteUlIdApproval() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdCntrctWkr()
    {
        this._has_ulIdCntrctWkr= false;
    } //-- void deleteUlIdCntrctWkr() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

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
     * Returns the value of field 'aprvlStageProg'.
     * 
     * @return the value of field 'AprvlStageProg'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg getAprvlStageProg()
    {
        return this._aprvlStageProg;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg getAprvlStageProg() 

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
     * Returns the value of field 'bIndAdoptionFinalized'.
     * 
     * @return the value of field 'BIndAdoptionFinalized'.
     */
    public java.lang.String getBIndAdoptionFinalized()
    {
        return this._bIndAdoptionFinalized;
    } //-- java.lang.String getBIndAdoptionFinalized() 

    /**
     * Returns the value of field 'bIndDesigneeAprvl'.
     * 
     * @return the value of field 'BIndDesigneeAprvl'.
     */
    public java.lang.String getBIndDesigneeAprvl()
    {
        return this._bIndDesigneeAprvl;
    } //-- java.lang.String getBIndDesigneeAprvl() 

    /**
     * Returns the value of field 'ldIdTodo'.
     * 
     * @return the value of field 'LdIdTodo'.
     */
    public int getLdIdTodo()
    {
        return this._ldIdTodo;
    } //-- int getLdIdTodo() 

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
     * Returns the value of field 'ROWCCMN61DI'.
     * 
     * @return the value of field 'ROWCCMN61DI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN61DI getROWCCMN61DI()
    {
        return this._ROWCCMN61DI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN61DI getROWCCMN61DI() 

    /**
     * Returns the value of field 'ROWCCMNI2DI'.
     * 
     * @return the value of field 'ROWCCMNI2DI'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI getROWCCMNI2DI()
    {
        return this._ROWCCMNI2DI;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI getROWCCMNI2DI() 

    /**
     * Returns the value of field 'szCdAttrRegSsStf'.
     * 
     * @return the value of field 'SzCdAttrRegSsStf'.
     */
    public java.lang.String getSzCdAttrRegSsStf()
    {
        return this._szCdAttrRegSsStf;
    } //-- java.lang.String getSzCdAttrRegSsStf() 

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
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'szWcdCdAprvlWinaction'.
     * 
     * @return the value of field 'SzWcdCdAprvlWinaction'.
     */
    public java.lang.String getSzWcdCdAprvlWinaction()
    {
        return this._szWcdCdAprvlWinaction;
    } //-- java.lang.String getSzWcdCdAprvlWinaction() 

    /**
     * Returns the value of field 'szWhichSafetyRsrcApprover'.
     * 
     * @return the value of field 'SzWhichSafetyRsrcApprover'.
     */
    public java.lang.String getSzWhichSafetyRsrcApprover()
    {
        return this._szWhichSafetyRsrcApprover;
    } //-- java.lang.String getSzWhichSafetyRsrcApprover() 

    /**
     * Returns the value of field 'szWhichSpclInvApprover'.
     * 
     * @return the value of field 'SzWhichSpclInvApprover'.
     */
    public java.lang.String getSzWhichSpclInvApprover()
    {
        return this._szWhichSpclInvApprover;
    } //-- java.lang.String getSzWhichSpclInvApprover() 

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
     * Returns the value of field 'ulIdApproval'.
     * 
     * @return the value of field 'UlIdApproval'.
     */
    public int getUlIdApproval()
    {
        return this._ulIdApproval;
    } //-- int getUlIdApproval() 

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
     * Returns the value of field 'ulIdCntrctWkr'.
     * 
     * @return the value of field 'UlIdCntrctWkr'.
     */
    public int getUlIdCntrctWkr()
    {
        return this._ulIdCntrctWkr;
    } //-- int getUlIdCntrctWkr() 

    /**
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

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
     * Method hasLdIdTodo
     * 
     * 
     * 
     * @return true if at least one LdIdTodo has been added
     */
    public boolean hasLdIdTodo()
    {
        return this._has_ldIdTodo;
    } //-- boolean hasLdIdTodo() 

    /**
     * Method hasUlIdApproval
     * 
     * 
     * 
     * @return true if at least one UlIdApproval has been added
     */
    public boolean hasUlIdApproval()
    {
        return this._has_ulIdApproval;
    } //-- boolean hasUlIdApproval() 

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
     * Method hasUlIdCntrctWkr
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctWkr has been added
     */
    public boolean hasUlIdCntrctWkr()
    {
        return this._has_ulIdCntrctWkr;
    } //-- boolean hasUlIdCntrctWkr() 

    /**
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

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
     * Sets the value of field 'aprvlStageProg'.
     * 
     * @param aprvlStageProg the value of field 'aprvlStageProg'.
     */
    public void setAprvlStageProg(gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg aprvlStageProg)
    {
        this._aprvlStageProg = aprvlStageProg;
    } //-- void setAprvlStageProg(gov.georgia.dhr.dfcs.sacwis.structs.input.AprvlStageProg) 

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
     * Sets the value of field 'bIndAdoptionFinalized'.
     * 
     * @param bIndAdoptionFinalized the value of field
     * 'bIndAdoptionFinalized'.
     */
    public void setBIndAdoptionFinalized(java.lang.String bIndAdoptionFinalized)
    {
        this._bIndAdoptionFinalized = bIndAdoptionFinalized;
    } //-- void setBIndAdoptionFinalized(java.lang.String) 

    /**
     * Sets the value of field 'bIndDesigneeAprvl'.
     * 
     * @param bIndDesigneeAprvl the value of field
     * 'bIndDesigneeAprvl'.
     */
    public void setBIndDesigneeAprvl(java.lang.String bIndDesigneeAprvl)
    {
        this._bIndDesigneeAprvl = bIndDesigneeAprvl;
    } //-- void setBIndDesigneeAprvl(java.lang.String) 

    /**
     * Sets the value of field 'ldIdTodo'.
     * 
     * @param ldIdTodo the value of field 'ldIdTodo'.
     */
    public void setLdIdTodo(int ldIdTodo)
    {
        this._ldIdTodo = ldIdTodo;
        this._has_ldIdTodo = true;
    } //-- void setLdIdTodo(int) 

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
     * Sets the value of field 'ROWCCMN61DI'.
     * 
     * @param ROWCCMN61DI the value of field 'ROWCCMN61DI'.
     */
    public void setROWCCMN61DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN61DI ROWCCMN61DI)
    {
        this._ROWCCMN61DI = ROWCCMN61DI;
    } //-- void setROWCCMN61DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN61DI) 

    /**
     * Sets the value of field 'ROWCCMNI2DI'.
     * 
     * @param ROWCCMNI2DI the value of field 'ROWCCMNI2DI'.
     */
    public void setROWCCMNI2DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI ROWCCMNI2DI)
    {
        this._ROWCCMNI2DI = ROWCCMNI2DI;
    } //-- void setROWCCMNI2DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI) 

    /**
     * Sets the value of field 'szCdAttrRegSsStf'.
     * 
     * @param szCdAttrRegSsStf the value of field 'szCdAttrRegSsStf'
     */
    public void setSzCdAttrRegSsStf(java.lang.String szCdAttrRegSsStf)
    {
        this._szCdAttrRegSsStf = szCdAttrRegSsStf;
    } //-- void setSzCdAttrRegSsStf(java.lang.String) 

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
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'szWcdCdAprvlWinaction'.
     * 
     * @param szWcdCdAprvlWinaction the value of field
     * 'szWcdCdAprvlWinaction'.
     */
    public void setSzWcdCdAprvlWinaction(java.lang.String szWcdCdAprvlWinaction)
    {
        this._szWcdCdAprvlWinaction = szWcdCdAprvlWinaction;
    } //-- void setSzWcdCdAprvlWinaction(java.lang.String) 

    /**
     * Sets the value of field 'szWhichSafetyRsrcApprover'.
     * 
     * @param szWhichSafetyRsrcApprover the value of field
     * 'szWhichSafetyRsrcApprover'.
     */
    public void setSzWhichSafetyRsrcApprover(java.lang.String szWhichSafetyRsrcApprover)
    {
        this._szWhichSafetyRsrcApprover = szWhichSafetyRsrcApprover;
    } //-- void setSzWhichSafetyRsrcApprover(java.lang.String) 

    /**
     * Sets the value of field 'szWhichSpclInvApprover'.
     * 
     * @param szWhichSpclInvApprover the value of field
     * 'szWhichSpclInvApprover'.
     */
    public void setSzWhichSpclInvApprover(java.lang.String szWhichSpclInvApprover)
    {
        this._szWhichSpclInvApprover = szWhichSpclInvApprover;
    } //-- void setSzWhichSpclInvApprover(java.lang.String) 

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
     * Sets the value of field 'ulIdApproval'.
     * 
     * @param ulIdApproval the value of field 'ulIdApproval'.
     */
    public void setUlIdApproval(int ulIdApproval)
    {
        this._ulIdApproval = ulIdApproval;
        this._has_ulIdApproval = true;
    } //-- void setUlIdApproval(int) 

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
     * Sets the value of field 'ulIdCntrctWkr'.
     * 
     * @param ulIdCntrctWkr the value of field 'ulIdCntrctWkr'.
     */
    public void setUlIdCntrctWkr(int ulIdCntrctWkr)
    {
        this._ulIdCntrctWkr = ulIdCntrctWkr;
        this._has_ulIdCntrctWkr = true;
    } //-- void setUlIdCntrctWkr(int) 

    /**
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI unmarshal(java.io.Reader) 

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
