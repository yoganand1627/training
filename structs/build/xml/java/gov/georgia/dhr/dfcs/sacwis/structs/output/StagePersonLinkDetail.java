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
 * Class StagePersonLinkDetail.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StagePersonLinkDetail extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bIndStagePersEmpNew
     */
    private java.lang.String _bIndStagePersEmpNew;

    /**
     * Field _bIndSafetyRsrc
     */
    private java.lang.String _bIndSafetyRsrc;

    /**
     * Field _bIndStagePersInLaw
     */
    private java.lang.String _bIndStagePersInLaw;

    /**
     * Field _bIndStagePersPrSecAsgn
     */
    private java.lang.String _bIndStagePersPrSecAsgn;

    /**
     * Field _bIndStagePersReporter
     */
    private java.lang.String _bIndStagePersReporter;

    /**
     * Field _cdPKHouseholdMember
     */
    private java.lang.String _cdPKHouseholdMember;

    /**
     * Field _dtDtPersonAddedOrRelated
     */
    private org.exolab.castor.types.Date _dtDtPersonAddedOrRelated;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _dtDtStagePersLink
     */
    private org.exolab.castor.types.Date _dtDtStagePersLink;

    /**
     * Field _szCdStagePersLstSort
     */
    private java.lang.String _szCdStagePersLstSort;

    /**
     * Field _szCdStagePersRelInt
     */
    private java.lang.String _szCdStagePersRelInt;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _szCdStagePersSearchInd
     */
    private java.lang.String _szCdStagePersSearchInd;

    /**
     * Field _szCdStagePersType
     */
    private java.lang.String _szCdStagePersType;

    /**
     * Field _szCdSideOfFamily
     */
    private java.lang.String _szCdSideOfFamily;

    /**
     * Field _szTxtStagePersNotes
     */
    private java.lang.String _szTxtStagePersNotes;

    /**
     * Field _szTxtStagePersOthRelations
     */
    private java.lang.String _szTxtStagePersOthRelations;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

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
     * Field _ulIdStagePersonLink
     */
    private int _ulIdStagePersonLink;

    /**
     * keeps track of state for field: _ulIdStagePersonLink
     */
    private boolean _has_ulIdStagePersonLink;

    /**
     * Field _ulIdPersScndryCaretaker
     */
    private int _ulIdPersScndryCaretaker;

    /**
     * keeps track of state for field: _ulIdPersScndryCaretaker
     */
    private boolean _has_ulIdPersScndryCaretaker;


      //----------------/
     //- Constructors -/
    //----------------/

    public StagePersonLinkDetail() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail()


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
    public void deleteUlIdPersScndryCaretaker()
    {
        this._has_ulIdPersScndryCaretaker= false;
    } //-- void deleteUlIdPersScndryCaretaker() 

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
    public void deleteUlIdStagePersonLink()
    {
        this._has_ulIdStagePersonLink= false;
    } //-- void deleteUlIdStagePersonLink() 

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
     * Returns the value of field 'bIndSafetyRsrc'.
     * 
     * @return the value of field 'BIndSafetyRsrc'.
     */
    public java.lang.String getBIndSafetyRsrc()
    {
        return this._bIndSafetyRsrc;
    } //-- java.lang.String getBIndSafetyRsrc() 

    /**
     * Returns the value of field 'bIndStagePersEmpNew'.
     * 
     * @return the value of field 'BIndStagePersEmpNew'.
     */
    public java.lang.String getBIndStagePersEmpNew()
    {
        return this._bIndStagePersEmpNew;
    } //-- java.lang.String getBIndStagePersEmpNew() 

    /**
     * Returns the value of field 'bIndStagePersInLaw'.
     * 
     * @return the value of field 'BIndStagePersInLaw'.
     */
    public java.lang.String getBIndStagePersInLaw()
    {
        return this._bIndStagePersInLaw;
    } //-- java.lang.String getBIndStagePersInLaw() 

    /**
     * Returns the value of field 'bIndStagePersPrSecAsgn'.
     * 
     * @return the value of field 'BIndStagePersPrSecAsgn'.
     */
    public java.lang.String getBIndStagePersPrSecAsgn()
    {
        return this._bIndStagePersPrSecAsgn;
    } //-- java.lang.String getBIndStagePersPrSecAsgn() 

    /**
     * Returns the value of field 'bIndStagePersReporter'.
     * 
     * @return the value of field 'BIndStagePersReporter'.
     */
    public java.lang.String getBIndStagePersReporter()
    {
        return this._bIndStagePersReporter;
    } //-- java.lang.String getBIndStagePersReporter() 

    /**
     * Returns the value of field 'cdPKHouseholdMember'.
     * 
     * @return the value of field 'CdPKHouseholdMember'.
     */
    public java.lang.String getCdPKHouseholdMember()
    {
        return this._cdPKHouseholdMember;
    } //-- java.lang.String getCdPKHouseholdMember() 

    /**
     * Returns the value of field 'dtDtPersonAddedOrRelated'.
     * 
     * @return the value of field 'DtDtPersonAddedOrRelated'.
     */
    public org.exolab.castor.types.Date getDtDtPersonAddedOrRelated()
    {
        return this._dtDtPersonAddedOrRelated;
    } //-- org.exolab.castor.types.Date getDtDtPersonAddedOrRelated() 

    /**
     * Returns the value of field 'dtDtPersonBirth'.
     * 
     * @return the value of field 'DtDtPersonBirth'.
     */
    public org.exolab.castor.types.Date getDtDtPersonBirth()
    {
        return this._dtDtPersonBirth;
    } //-- org.exolab.castor.types.Date getDtDtPersonBirth() 

    /**
     * Returns the value of field 'dtDtStagePersLink'.
     * 
     * @return the value of field 'DtDtStagePersLink'.
     */
    public org.exolab.castor.types.Date getDtDtStagePersLink()
    {
        return this._dtDtStagePersLink;
    } //-- org.exolab.castor.types.Date getDtDtStagePersLink() 

    /**
     * Returns the value of field 'szCdSideOfFamily'.
     * 
     * @return the value of field 'SzCdSideOfFamily'.
     */
    public java.lang.String getSzCdSideOfFamily()
    {
        return this._szCdSideOfFamily;
    } //-- java.lang.String getSzCdSideOfFamily() 

    /**
     * Returns the value of field 'szCdStagePersLstSort'.
     * 
     * @return the value of field 'SzCdStagePersLstSort'.
     */
    public java.lang.String getSzCdStagePersLstSort()
    {
        return this._szCdStagePersLstSort;
    } //-- java.lang.String getSzCdStagePersLstSort() 

    /**
     * Returns the value of field 'szCdStagePersRelInt'.
     * 
     * @return the value of field 'SzCdStagePersRelInt'.
     */
    public java.lang.String getSzCdStagePersRelInt()
    {
        return this._szCdStagePersRelInt;
    } //-- java.lang.String getSzCdStagePersRelInt() 

    /**
     * Returns the value of field 'szCdStagePersRole'.
     * 
     * @return the value of field 'SzCdStagePersRole'.
     */
    public java.lang.String getSzCdStagePersRole()
    {
        return this._szCdStagePersRole;
    } //-- java.lang.String getSzCdStagePersRole() 

    /**
     * Returns the value of field 'szCdStagePersSearchInd'.
     * 
     * @return the value of field 'SzCdStagePersSearchInd'.
     */
    public java.lang.String getSzCdStagePersSearchInd()
    {
        return this._szCdStagePersSearchInd;
    } //-- java.lang.String getSzCdStagePersSearchInd() 

    /**
     * Returns the value of field 'szCdStagePersType'.
     * 
     * @return the value of field 'SzCdStagePersType'.
     */
    public java.lang.String getSzCdStagePersType()
    {
        return this._szCdStagePersType;
    } //-- java.lang.String getSzCdStagePersType() 

    /**
     * Returns the value of field 'szTxtStagePersNotes'.
     * 
     * @return the value of field 'SzTxtStagePersNotes'.
     */
    public java.lang.String getSzTxtStagePersNotes()
    {
        return this._szTxtStagePersNotes;
    } //-- java.lang.String getSzTxtStagePersNotes() 

    /**
     * Returns the value of field 'szTxtStagePersOthRelations'.
     * 
     * @return the value of field 'SzTxtStagePersOthRelations'.
     */
    public java.lang.String getSzTxtStagePersOthRelations()
    {
        return this._szTxtStagePersOthRelations;
    } //-- java.lang.String getSzTxtStagePersOthRelations() 

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
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdPersScndryCaretaker'.
     * 
     * @return the value of field 'UlIdPersScndryCaretaker'.
     */
    public int getUlIdPersScndryCaretaker()
    {
        return this._ulIdPersScndryCaretaker;
    } //-- int getUlIdPersScndryCaretaker() 

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
     * Returns the value of field 'ulIdStagePersonLink'.
     * 
     * @return the value of field 'UlIdStagePersonLink'.
     */
    public int getUlIdStagePersonLink()
    {
        return this._ulIdStagePersonLink;
    } //-- int getUlIdStagePersonLink() 

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
     * Method hasUlIdPersScndryCaretaker
     * 
     * 
     * 
     * @return true if at least one UlIdPersScndryCaretaker has
     * been added
     */
    public boolean hasUlIdPersScndryCaretaker()
    {
        return this._has_ulIdPersScndryCaretaker;
    } //-- boolean hasUlIdPersScndryCaretaker() 

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
     * Method hasUlIdStagePersonLink
     * 
     * 
     * 
     * @return true if at least one UlIdStagePersonLink has been
     * added
     */
    public boolean hasUlIdStagePersonLink()
    {
        return this._has_ulIdStagePersonLink;
    } //-- boolean hasUlIdStagePersonLink() 

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
     * Sets the value of field 'bIndSafetyRsrc'.
     * 
     * @param bIndSafetyRsrc the value of field 'bIndSafetyRsrc'.
     */
    public void setBIndSafetyRsrc(java.lang.String bIndSafetyRsrc)
    {
        this._bIndSafetyRsrc = bIndSafetyRsrc;
    } //-- void setBIndSafetyRsrc(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersEmpNew'.
     * 
     * @param bIndStagePersEmpNew the value of field
     * 'bIndStagePersEmpNew'.
     */
    public void setBIndStagePersEmpNew(java.lang.String bIndStagePersEmpNew)
    {
        this._bIndStagePersEmpNew = bIndStagePersEmpNew;
    } //-- void setBIndStagePersEmpNew(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersInLaw'.
     * 
     * @param bIndStagePersInLaw the value of field
     * 'bIndStagePersInLaw'.
     */
    public void setBIndStagePersInLaw(java.lang.String bIndStagePersInLaw)
    {
        this._bIndStagePersInLaw = bIndStagePersInLaw;
    } //-- void setBIndStagePersInLaw(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersPrSecAsgn'.
     * 
     * @param bIndStagePersPrSecAsgn the value of field
     * 'bIndStagePersPrSecAsgn'.
     */
    public void setBIndStagePersPrSecAsgn(java.lang.String bIndStagePersPrSecAsgn)
    {
        this._bIndStagePersPrSecAsgn = bIndStagePersPrSecAsgn;
    } //-- void setBIndStagePersPrSecAsgn(java.lang.String) 

    /**
     * Sets the value of field 'bIndStagePersReporter'.
     * 
     * @param bIndStagePersReporter the value of field
     * 'bIndStagePersReporter'.
     */
    public void setBIndStagePersReporter(java.lang.String bIndStagePersReporter)
    {
        this._bIndStagePersReporter = bIndStagePersReporter;
    } //-- void setBIndStagePersReporter(java.lang.String) 

    /**
     * Sets the value of field 'cdPKHouseholdMember'.
     * 
     * @param cdPKHouseholdMember the value of field
     * 'cdPKHouseholdMember'.
     */
    public void setCdPKHouseholdMember(java.lang.String cdPKHouseholdMember)
    {
        this._cdPKHouseholdMember = cdPKHouseholdMember;
    } //-- void setCdPKHouseholdMember(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPersonAddedOrRelated'.
     * 
     * @param dtDtPersonAddedOrRelated the value of field
     * 'dtDtPersonAddedOrRelated'.
     */
    public void setDtDtPersonAddedOrRelated(org.exolab.castor.types.Date dtDtPersonAddedOrRelated)
    {
        this._dtDtPersonAddedOrRelated = dtDtPersonAddedOrRelated;
    } //-- void setDtDtPersonAddedOrRelated(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersonBirth'.
     * 
     * @param dtDtPersonBirth the value of field 'dtDtPersonBirth'.
     */
    public void setDtDtPersonBirth(org.exolab.castor.types.Date dtDtPersonBirth)
    {
        this._dtDtPersonBirth = dtDtPersonBirth;
    } //-- void setDtDtPersonBirth(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStagePersLink'.
     * 
     * @param dtDtStagePersLink the value of field
     * 'dtDtStagePersLink'.
     */
    public void setDtDtStagePersLink(org.exolab.castor.types.Date dtDtStagePersLink)
    {
        this._dtDtStagePersLink = dtDtStagePersLink;
    } //-- void setDtDtStagePersLink(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdSideOfFamily'.
     * 
     * @param szCdSideOfFamily the value of field 'szCdSideOfFamily'
     */
    public void setSzCdSideOfFamily(java.lang.String szCdSideOfFamily)
    {
        this._szCdSideOfFamily = szCdSideOfFamily;
    } //-- void setSzCdSideOfFamily(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersLstSort'.
     * 
     * @param szCdStagePersLstSort the value of field
     * 'szCdStagePersLstSort'.
     */
    public void setSzCdStagePersLstSort(java.lang.String szCdStagePersLstSort)
    {
        this._szCdStagePersLstSort = szCdStagePersLstSort;
    } //-- void setSzCdStagePersLstSort(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRelInt'.
     * 
     * @param szCdStagePersRelInt the value of field
     * 'szCdStagePersRelInt'.
     */
    public void setSzCdStagePersRelInt(java.lang.String szCdStagePersRelInt)
    {
        this._szCdStagePersRelInt = szCdStagePersRelInt;
    } //-- void setSzCdStagePersRelInt(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRole'.
     * 
     * @param szCdStagePersRole the value of field
     * 'szCdStagePersRole'.
     */
    public void setSzCdStagePersRole(java.lang.String szCdStagePersRole)
    {
        this._szCdStagePersRole = szCdStagePersRole;
    } //-- void setSzCdStagePersRole(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersSearchInd'.
     * 
     * @param szCdStagePersSearchInd the value of field
     * 'szCdStagePersSearchInd'.
     */
    public void setSzCdStagePersSearchInd(java.lang.String szCdStagePersSearchInd)
    {
        this._szCdStagePersSearchInd = szCdStagePersSearchInd;
    } //-- void setSzCdStagePersSearchInd(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersType'.
     * 
     * @param szCdStagePersType the value of field
     * 'szCdStagePersType'.
     */
    public void setSzCdStagePersType(java.lang.String szCdStagePersType)
    {
        this._szCdStagePersType = szCdStagePersType;
    } //-- void setSzCdStagePersType(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStagePersNotes'.
     * 
     * @param szTxtStagePersNotes the value of field
     * 'szTxtStagePersNotes'.
     */
    public void setSzTxtStagePersNotes(java.lang.String szTxtStagePersNotes)
    {
        this._szTxtStagePersNotes = szTxtStagePersNotes;
    } //-- void setSzTxtStagePersNotes(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStagePersOthRelations'.
     * 
     * @param szTxtStagePersOthRelations the value of field
     * 'szTxtStagePersOthRelations'.
     */
    public void setSzTxtStagePersOthRelations(java.lang.String szTxtStagePersOthRelations)
    {
        this._szTxtStagePersOthRelations = szTxtStagePersOthRelations;
    } //-- void setSzTxtStagePersOthRelations(java.lang.String) 

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
     * Sets the value of field 'ulIdPersScndryCaretaker'.
     * 
     * @param ulIdPersScndryCaretaker the value of field
     * 'ulIdPersScndryCaretaker'.
     */
    public void setUlIdPersScndryCaretaker(int ulIdPersScndryCaretaker)
    {
        this._ulIdPersScndryCaretaker = ulIdPersScndryCaretaker;
        this._has_ulIdPersScndryCaretaker = true;
    } //-- void setUlIdPersScndryCaretaker(int) 

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
     * Sets the value of field 'ulIdStagePersonLink'.
     * 
     * @param ulIdStagePersonLink the value of field
     * 'ulIdStagePersonLink'.
     */
    public void setUlIdStagePersonLink(int ulIdStagePersonLink)
    {
        this._ulIdStagePersonLink = ulIdStagePersonLink;
        this._has_ulIdStagePersonLink = true;
    } //-- void setUlIdStagePersonLink(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail unmarshal(java.io.Reader) 

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
