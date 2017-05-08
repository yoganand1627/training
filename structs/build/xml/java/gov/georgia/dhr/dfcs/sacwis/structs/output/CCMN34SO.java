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
 * Class CCMN34SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCMN34SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulRowQty2
     */
    private int _ulRowQty2;

    /**
     * keeps track of state for field: _ulRowQty2
     */
    private boolean _has_ulRowQty2;

    /**
     * Field _ulRowQty3
     */
    private int _ulRowQty3;

    /**
     * keeps track of state for field: _ulRowQty3
     */
    private boolean _has_ulRowQty3;

    /**
     * Field _bMoreDataInd2
     */
    private java.lang.String _bMoreDataInd2;

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
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _szCdTaskTopWindow
     */
    private java.lang.String _szCdTaskTopWindow;

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
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _tmWCDTmSystemTime
     */
    private java.lang.String _tmWCDTmSystemTime;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szTxtApprovalTopic
     */
    private java.lang.String _szTxtApprovalTopic;

    /**
     * Field _ROWCCMN45DO
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO _ROWCCMN45DO;

    /**
     * Field _aprvlStageProg
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg _aprvlStageProg;

    /**
     * Field _ROWCCMN56DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY _ROWCCMN56DO_ARRAY;

    /**
     * Field _ROWCCMN57DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY _ROWCCMN57DO_ARRAY;

    /**
     * Field _ROWCCMNI3DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY _ROWCCMNI3DO_ARRAY;

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

    public CCMN34SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO()


      //-----------/
     //- Methods -/
    //-----------/

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
    public void deleteUlRowQty2()
    {
        this._has_ulRowQty2= false;
    } //-- void deleteUlRowQty2() 

    /**
     */
    public void deleteUlRowQty3()
    {
        this._has_ulRowQty3= false;
    } //-- void deleteUlRowQty3() 

    /**
     * Returns the value of field 'aprvlStageProg'.
     * 
     * @return the value of field 'AprvlStageProg'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg getAprvlStageProg()
    {
        return this._aprvlStageProg;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg getAprvlStageProg() 

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
     * Returns the value of field 'bIndAdoptionFinalized'.
     * 
     * @return the value of field 'BIndAdoptionFinalized'.
     */
    public java.lang.String getBIndAdoptionFinalized()
    {
        return this._bIndAdoptionFinalized;
    } //-- java.lang.String getBIndAdoptionFinalized() 

    /**
     * Returns the value of field 'bMoreDataInd2'.
     * 
     * @return the value of field 'BMoreDataInd2'.
     */
    public java.lang.String getBMoreDataInd2()
    {
        return this._bMoreDataInd2;
    } //-- java.lang.String getBMoreDataInd2() 

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
     * Returns the value of field 'ROWCCMN45DO'.
     * 
     * @return the value of field 'ROWCCMN45DO'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO()
    {
        return this._ROWCCMN45DO;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO getROWCCMN45DO() 

    /**
     * Returns the value of field 'ROWCCMN56DO_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN56DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY getROWCCMN56DO_ARRAY()
    {
        return this._ROWCCMN56DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY getROWCCMN56DO_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMN57DO_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN57DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY getROWCCMN57DO_ARRAY()
    {
        return this._ROWCCMN57DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY getROWCCMN57DO_ARRAY() 

    /**
     * Returns the value of field 'ROWCCMNI3DO_ARRAY'.
     * 
     * @return the value of field 'ROWCCMNI3DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY getROWCCMNI3DO_ARRAY()
    {
        return this._ROWCCMNI3DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY getROWCCMNI3DO_ARRAY() 

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
     * Returns the value of field 'szCdTaskTopWindow'.
     * 
     * @return the value of field 'SzCdTaskTopWindow'.
     */
    public java.lang.String getSzCdTaskTopWindow()
    {
        return this._szCdTaskTopWindow;
    } //-- java.lang.String getSzCdTaskTopWindow() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

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
     * Returns the value of field 'szTxtApprovalTopic'.
     * 
     * @return the value of field 'SzTxtApprovalTopic'.
     */
    public java.lang.String getSzTxtApprovalTopic()
    {
        return this._szTxtApprovalTopic;
    } //-- java.lang.String getSzTxtApprovalTopic() 

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
     * Returns the value of field 'tmWCDTmSystemTime'.
     * 
     * @return the value of field 'TmWCDTmSystemTime'.
     */
    public java.lang.String getTmWCDTmSystemTime()
    {
        return this._tmWCDTmSystemTime;
    } //-- java.lang.String getTmWCDTmSystemTime() 

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
     * Returns the value of field 'ulRowQty2'.
     * 
     * @return the value of field 'UlRowQty2'.
     */
    public int getUlRowQty2()
    {
        return this._ulRowQty2;
    } //-- int getUlRowQty2() 

    /**
     * Returns the value of field 'ulRowQty3'.
     * 
     * @return the value of field 'UlRowQty3'.
     */
    public int getUlRowQty3()
    {
        return this._ulRowQty3;
    } //-- int getUlRowQty3() 

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
     * Method hasUlRowQty2
     * 
     * 
     * 
     * @return true if at least one UlRowQty2 has been added
     */
    public boolean hasUlRowQty2()
    {
        return this._has_ulRowQty2;
    } //-- boolean hasUlRowQty2() 

    /**
     * Method hasUlRowQty3
     * 
     * 
     * 
     * @return true if at least one UlRowQty3 has been added
     */
    public boolean hasUlRowQty3()
    {
        return this._has_ulRowQty3;
    } //-- boolean hasUlRowQty3() 

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
    public void setAprvlStageProg(gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg aprvlStageProg)
    {
        this._aprvlStageProg = aprvlStageProg;
    } //-- void setAprvlStageProg(gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg) 

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
     * Sets the value of field 'bMoreDataInd2'.
     * 
     * @param bMoreDataInd2 the value of field 'bMoreDataInd2'.
     */
    public void setBMoreDataInd2(java.lang.String bMoreDataInd2)
    {
        this._bMoreDataInd2 = bMoreDataInd2;
    } //-- void setBMoreDataInd2(java.lang.String) 

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
     * Sets the value of field 'ROWCCMN45DO'.
     * 
     * @param ROWCCMN45DO the value of field 'ROWCCMN45DO'.
     */
    public void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO ROWCCMN45DO)
    {
        this._ROWCCMN45DO = ROWCCMN45DO;
    } //-- void setROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO) 

    /**
     * Sets the value of field 'ROWCCMN56DO_ARRAY'.
     * 
     * @param ROWCCMN56DO_ARRAY the value of field
     * 'ROWCCMN56DO_ARRAY'.
     */
    public void setROWCCMN56DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY ROWCCMN56DO_ARRAY)
    {
        this._ROWCCMN56DO_ARRAY = ROWCCMN56DO_ARRAY;
    } //-- void setROWCCMN56DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMN57DO_ARRAY'.
     * 
     * @param ROWCCMN57DO_ARRAY the value of field
     * 'ROWCCMN57DO_ARRAY'.
     */
    public void setROWCCMN57DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY ROWCCMN57DO_ARRAY)
    {
        this._ROWCCMN57DO_ARRAY = ROWCCMN57DO_ARRAY;
    } //-- void setROWCCMN57DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY) 

    /**
     * Sets the value of field 'ROWCCMNI3DO_ARRAY'.
     * 
     * @param ROWCCMNI3DO_ARRAY the value of field
     * 'ROWCCMNI3DO_ARRAY'.
     */
    public void setROWCCMNI3DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY ROWCCMNI3DO_ARRAY)
    {
        this._ROWCCMNI3DO_ARRAY = ROWCCMNI3DO_ARRAY;
    } //-- void setROWCCMNI3DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY) 

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
     * Sets the value of field 'szCdTaskTopWindow'.
     * 
     * @param szCdTaskTopWindow the value of field
     * 'szCdTaskTopWindow'.
     */
    public void setSzCdTaskTopWindow(java.lang.String szCdTaskTopWindow)
    {
        this._szCdTaskTopWindow = szCdTaskTopWindow;
    } //-- void setSzCdTaskTopWindow(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

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
     * Sets the value of field 'szTxtApprovalTopic'.
     * 
     * @param szTxtApprovalTopic the value of field
     * 'szTxtApprovalTopic'.
     */
    public void setSzTxtApprovalTopic(java.lang.String szTxtApprovalTopic)
    {
        this._szTxtApprovalTopic = szTxtApprovalTopic;
    } //-- void setSzTxtApprovalTopic(java.lang.String) 

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
     * Sets the value of field 'tmWCDTmSystemTime'.
     * 
     * @param tmWCDTmSystemTime the value of field
     * 'tmWCDTmSystemTime'.
     */
    public void setTmWCDTmSystemTime(java.lang.String tmWCDTmSystemTime)
    {
        this._tmWCDTmSystemTime = tmWCDTmSystemTime;
    } //-- void setTmWCDTmSystemTime(java.lang.String) 

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
     * Sets the value of field 'ulRowQty2'.
     * 
     * @param ulRowQty2 the value of field 'ulRowQty2'.
     */
    public void setUlRowQty2(int ulRowQty2)
    {
        this._ulRowQty2 = ulRowQty2;
        this._has_ulRowQty2 = true;
    } //-- void setUlRowQty2(int) 

    /**
     * Sets the value of field 'ulRowQty3'.
     * 
     * @param ulRowQty3 the value of field 'ulRowQty3'.
     */
    public void setUlRowQty3(int ulRowQty3)
    {
        this._ulRowQty3 = ulRowQty3;
        this._has_ulRowQty3 = true;
    } //-- void setUlRowQty3(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO unmarshal(java.io.Reader) 

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
