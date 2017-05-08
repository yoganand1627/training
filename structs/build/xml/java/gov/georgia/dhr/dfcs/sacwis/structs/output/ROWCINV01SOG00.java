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
 * Class ROWCINV01SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV01SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _bIndActiveStatus
     */
    private java.lang.String _bIndActiveStatus;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdStagePerson
     */
    private int _ulIdStagePerson;

    /**
     * keeps track of state for field: _ulIdStagePerson
     */
    private boolean _has_ulIdStagePerson;

    /**
     * Field _szCdPersonRelationship
     */
    private java.lang.String _szCdPersonRelationship;

    /**
     * Field _bIndPersonDobApprox
     */
    private java.lang.String _bIndPersonDobApprox;

    /**
     * Field _lNbrPersonAge
     */
    private int _lNbrPersonAge;

    /**
     * keeps track of state for field: _lNbrPersonAge
     */
    private boolean _has_lNbrPersonAge;

    /**
     * Field _bIndStagePersReporter
     */
    private java.lang.String _bIndStagePersReporter;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _szCdStagePersRelInt
     */
    private java.lang.String _szCdStagePersRelInt;

    /**
     * Field _cCdPersonSex
     */
    private java.lang.String _cCdPersonSex;

    /**
     * Field _szCdStagePersType
     */
    private java.lang.String _szCdStagePersType;

    /**
     * Field _szCdStagePersSearchInd
     */
    private java.lang.String _szCdStagePersSearchInd;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _bCdPersonChar
     */
    private java.lang.String _bCdPersonChar;

    /**
     * Field _cWcdIndMerge
     */
    private java.lang.String _cWcdIndMerge;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _szCdIncmgPersTitle
     */
    private java.lang.String _szCdIncmgPersTitle;

    /**
     * Field _szTxtOtherRelationshipsCmnts
     */
    private java.lang.String _szTxtOtherRelationshipsCmnts;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV01SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrPersonAge()
    {
        this._has_lNbrPersonAge= false;
    } //-- void deleteLNbrPersonAge() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdStagePerson()
    {
        this._has_ulIdStagePerson= false;
    } //-- void deleteUlIdStagePerson() 

    /**
     * Returns the value of field 'bCdPersonChar'.
     * 
     * @return the value of field 'BCdPersonChar'.
     */
    public java.lang.String getBCdPersonChar()
    {
        return this._bCdPersonChar;
    } //-- java.lang.String getBCdPersonChar() 

    /**
     * Returns the value of field 'bIndActiveStatus'.
     * 
     * @return the value of field 'BIndActiveStatus'.
     */
    public java.lang.String getBIndActiveStatus()
    {
        return this._bIndActiveStatus;
    } //-- java.lang.String getBIndActiveStatus() 

    /**
     * Returns the value of field 'bIndPersonDobApprox'.
     * 
     * @return the value of field 'BIndPersonDobApprox'.
     */
    public java.lang.String getBIndPersonDobApprox()
    {
        return this._bIndPersonDobApprox;
    } //-- java.lang.String getBIndPersonDobApprox() 

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
     * Returns the value of field 'cCdPersonSex'.
     * 
     * @return the value of field 'CCdPersonSex'.
     */
    public java.lang.String getCCdPersonSex()
    {
        return this._cCdPersonSex;
    } //-- java.lang.String getCCdPersonSex() 

    /**
     * Returns the value of field 'cWcdIndMerge'.
     * 
     * @return the value of field 'CWcdIndMerge'.
     */
    public java.lang.String getCWcdIndMerge()
    {
        return this._cWcdIndMerge;
    } //-- java.lang.String getCWcdIndMerge() 

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
     * Returns the value of field 'lNbrPersonAge'.
     * 
     * @return the value of field 'LNbrPersonAge'.
     */
    public int getLNbrPersonAge()
    {
        return this._lNbrPersonAge;
    } //-- int getLNbrPersonAge() 

    /**
     * Returns the value of field 'szCdIncmgPersTitle'.
     * 
     * @return the value of field 'SzCdIncmgPersTitle'.
     */
    public java.lang.String getSzCdIncmgPersTitle()
    {
        return this._szCdIncmgPersTitle;
    } //-- java.lang.String getSzCdIncmgPersTitle() 

    /**
     * Returns the value of field 'szCdPersonEthnicGroup'.
     * 
     * @return the value of field 'SzCdPersonEthnicGroup'.
     */
    public java.lang.String getSzCdPersonEthnicGroup()
    {
        return this._szCdPersonEthnicGroup;
    } //-- java.lang.String getSzCdPersonEthnicGroup() 

    /**
     * Returns the value of field 'szCdPersonRelationship'.
     * 
     * @return the value of field 'SzCdPersonRelationship'.
     */
    public java.lang.String getSzCdPersonRelationship()
    {
        return this._szCdPersonRelationship;
    } //-- java.lang.String getSzCdPersonRelationship() 

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
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szTxtOtherRelationshipsCmnts'.
     * 
     * @return the value of field 'SzTxtOtherRelationshipsCmnts'.
     */
    public java.lang.String getSzTxtOtherRelationshipsCmnts()
    {
        return this._szTxtOtherRelationshipsCmnts;
    } //-- java.lang.String getSzTxtOtherRelationshipsCmnts() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdStagePerson'.
     * 
     * @return the value of field 'UlIdStagePerson'.
     */
    public int getUlIdStagePerson()
    {
        return this._ulIdStagePerson;
    } //-- int getUlIdStagePerson() 

    /**
     * Method hasLNbrPersonAge
     * 
     * 
     * 
     * @return true if at least one LNbrPersonAge has been added
     */
    public boolean hasLNbrPersonAge()
    {
        return this._has_lNbrPersonAge;
    } //-- boolean hasLNbrPersonAge() 

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
     * Method hasUlIdStagePerson
     * 
     * 
     * 
     * @return true if at least one UlIdStagePerson has been added
     */
    public boolean hasUlIdStagePerson()
    {
        return this._has_ulIdStagePerson;
    } //-- boolean hasUlIdStagePerson() 

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
     * Sets the value of field 'bCdPersonChar'.
     * 
     * @param bCdPersonChar the value of field 'bCdPersonChar'.
     */
    public void setBCdPersonChar(java.lang.String bCdPersonChar)
    {
        this._bCdPersonChar = bCdPersonChar;
    } //-- void setBCdPersonChar(java.lang.String) 

    /**
     * Sets the value of field 'bIndActiveStatus'.
     * 
     * @param bIndActiveStatus the value of field 'bIndActiveStatus'
     */
    public void setBIndActiveStatus(java.lang.String bIndActiveStatus)
    {
        this._bIndActiveStatus = bIndActiveStatus;
    } //-- void setBIndActiveStatus(java.lang.String) 

    /**
     * Sets the value of field 'bIndPersonDobApprox'.
     * 
     * @param bIndPersonDobApprox the value of field
     * 'bIndPersonDobApprox'.
     */
    public void setBIndPersonDobApprox(java.lang.String bIndPersonDobApprox)
    {
        this._bIndPersonDobApprox = bIndPersonDobApprox;
    } //-- void setBIndPersonDobApprox(java.lang.String) 

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
     * Sets the value of field 'cCdPersonSex'.
     * 
     * @param cCdPersonSex the value of field 'cCdPersonSex'.
     */
    public void setCCdPersonSex(java.lang.String cCdPersonSex)
    {
        this._cCdPersonSex = cCdPersonSex;
    } //-- void setCCdPersonSex(java.lang.String) 

    /**
     * Sets the value of field 'cWcdIndMerge'.
     * 
     * @param cWcdIndMerge the value of field 'cWcdIndMerge'.
     */
    public void setCWcdIndMerge(java.lang.String cWcdIndMerge)
    {
        this._cWcdIndMerge = cWcdIndMerge;
    } //-- void setCWcdIndMerge(java.lang.String) 

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
     * Sets the value of field 'lNbrPersonAge'.
     * 
     * @param lNbrPersonAge the value of field 'lNbrPersonAge'.
     */
    public void setLNbrPersonAge(int lNbrPersonAge)
    {
        this._lNbrPersonAge = lNbrPersonAge;
        this._has_lNbrPersonAge = true;
    } //-- void setLNbrPersonAge(int) 

    /**
     * Sets the value of field 'szCdIncmgPersTitle'.
     * 
     * @param szCdIncmgPersTitle the value of field
     * 'szCdIncmgPersTitle'.
     */
    public void setSzCdIncmgPersTitle(java.lang.String szCdIncmgPersTitle)
    {
        this._szCdIncmgPersTitle = szCdIncmgPersTitle;
    } //-- void setSzCdIncmgPersTitle(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonEthnicGroup'.
     * 
     * @param szCdPersonEthnicGroup the value of field
     * 'szCdPersonEthnicGroup'.
     */
    public void setSzCdPersonEthnicGroup(java.lang.String szCdPersonEthnicGroup)
    {
        this._szCdPersonEthnicGroup = szCdPersonEthnicGroup;
    } //-- void setSzCdPersonEthnicGroup(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonRelationship'.
     * 
     * @param szCdPersonRelationship the value of field
     * 'szCdPersonRelationship'.
     */
    public void setSzCdPersonRelationship(java.lang.String szCdPersonRelationship)
    {
        this._szCdPersonRelationship = szCdPersonRelationship;
    } //-- void setSzCdPersonRelationship(java.lang.String) 

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
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOtherRelationshipsCmnts'.
     * 
     * @param szTxtOtherRelationshipsCmnts the value of field
     * 'szTxtOtherRelationshipsCmnts'.
     */
    public void setSzTxtOtherRelationshipsCmnts(java.lang.String szTxtOtherRelationshipsCmnts)
    {
        this._szTxtOtherRelationshipsCmnts = szTxtOtherRelationshipsCmnts;
    } //-- void setSzTxtOtherRelationshipsCmnts(java.lang.String) 

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
     * Sets the value of field 'ulIdStagePerson'.
     * 
     * @param ulIdStagePerson the value of field 'ulIdStagePerson'.
     */
    public void setUlIdStagePerson(int ulIdStagePerson)
    {
        this._ulIdStagePerson = ulIdStagePerson;
        this._has_ulIdStagePerson = true;
    } //-- void setUlIdStagePerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00 unmarshal(java.io.Reader) 

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
