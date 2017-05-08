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
 * Class CINV24SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV24SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _bCdPersonChar
     */
    private java.lang.String _bCdPersonChar;

    /**
     * Field _bCdPersNotYetDiag
     */
    private java.lang.String _bCdPersNotYetDiag;

    /**
     * Field _szTxtCharCmnts
     */
    private java.lang.String _szTxtCharCmnts;

    /**
     * Field _szCdPersonDeath
     */
    private java.lang.String _szCdPersonDeath;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _szCdPersonLanguage
     */
    private java.lang.String _szCdPersonLanguage;

    /**
     * Field _szCdPersonLivArr
     */
    private java.lang.String _szCdPersonLivArr;

    /**
     * Field _szCdPersonMaritalStatus
     */
    private java.lang.String _szCdPersonMaritalStatus;

    /**
     * Field _szCdPersonRelationship
     */
    private java.lang.String _szCdPersonRelationship;

    /**
     * Field _szCdPersonReligion
     */
    private java.lang.String _szCdPersonReligion;

    /**
     * Field _cCdPersonSex
     */
    private java.lang.String _cCdPersonSex;

    /**
     * Field _cdPersonStatus
     */
    private java.lang.String _cdPersonStatus;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _dtDtPersonDeath
     */
    private org.exolab.castor.types.Date _dtDtPersonDeath;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _bIndPersonDobApprox
     */
    private java.lang.String _bIndPersonDobApprox;

    /**
     * Field _szTxtOccupation
     */
    private java.lang.String _szTxtOccupation;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ROWCINV24SOG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY _ROWCINV24SOG_ARRAY;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _indPrevAdopt
     */
    private java.lang.String _indPrevAdopt;

    /**
     * Field _indAdoptnDislutn
     */
    private java.lang.String _indAdoptnDislutn;

    /**
     * Field _indPrivateAdoptn
     */
    private java.lang.String _indPrivateAdoptn;

    /**
     * Field _indPublicAdoptn
     */
    private java.lang.String _indPublicAdoptn;

    /**
     * Field _indIntlAdoptn
     */
    private java.lang.String _indIntlAdoptn;

    /**
     * Field _indSingleParAdpt
     */
    private java.lang.String _indSingleParAdpt;

    /**
     * Field _szCdCounty
     */
    private java.lang.String _szCdCounty;

    /**
     * Field _szCdState
     */
    private java.lang.String _szCdState;

    /**
     * Field _szCdCntry
     */
    private java.lang.String _szCdCntry;

    /**
     * Field _szCdSngleMomOrFar
     */
    private java.lang.String _szCdSngleMomOrFar;

    /**
     * Field _szAgency
     */
    private java.lang.String _szAgency;

    /**
     * Field _txtDissolutionDate
     */
    private org.exolab.castor.types.Date _txtDissolutionDate;

    /**
     * Field _txtPrevAdopt
     */
    private org.exolab.castor.types.Date _txtPrevAdopt;

    /**
     * Field _bIndIVEPriorAdoption
     */
    private java.lang.String _bIndIVEPriorAdoption;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV24SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

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
     * Returns the value of field 'bCdPersNotYetDiag'.
     * 
     * @return the value of field 'BCdPersNotYetDiag'.
     */
    public java.lang.String getBCdPersNotYetDiag()
    {
        return this._bCdPersNotYetDiag;
    } //-- java.lang.String getBCdPersNotYetDiag() 

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
     * Returns the value of field 'bIndIVEPriorAdoption'.
     * 
     * @return the value of field 'BIndIVEPriorAdoption'.
     */
    public java.lang.String getBIndIVEPriorAdoption()
    {
        return this._bIndIVEPriorAdoption;
    } //-- java.lang.String getBIndIVEPriorAdoption() 

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
     * Returns the value of field 'cCdPersonSex'.
     * 
     * @return the value of field 'CCdPersonSex'.
     */
    public java.lang.String getCCdPersonSex()
    {
        return this._cCdPersonSex;
    } //-- java.lang.String getCCdPersonSex() 

    /**
     * Returns the value of field 'cdPersonStatus'.
     * 
     * @return the value of field 'CdPersonStatus'.
     */
    public java.lang.String getCdPersonStatus()
    {
        return this._cdPersonStatus;
    } //-- java.lang.String getCdPersonStatus() 

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
     * Returns the value of field 'dtDtPersonDeath'.
     * 
     * @return the value of field 'DtDtPersonDeath'.
     */
    public org.exolab.castor.types.Date getDtDtPersonDeath()
    {
        return this._dtDtPersonDeath;
    } //-- org.exolab.castor.types.Date getDtDtPersonDeath() 

    /**
     * Returns the value of field 'indAdoptnDislutn'.
     * 
     * @return the value of field 'IndAdoptnDislutn'.
     */
    public java.lang.String getIndAdoptnDislutn()
    {
        return this._indAdoptnDislutn;
    } //-- java.lang.String getIndAdoptnDislutn() 

    /**
     * Returns the value of field 'indIntlAdoptn'.
     * 
     * @return the value of field 'IndIntlAdoptn'.
     */
    public java.lang.String getIndIntlAdoptn()
    {
        return this._indIntlAdoptn;
    } //-- java.lang.String getIndIntlAdoptn() 

    /**
     * Returns the value of field 'indPrevAdopt'.
     * 
     * @return the value of field 'IndPrevAdopt'.
     */
    public java.lang.String getIndPrevAdopt()
    {
        return this._indPrevAdopt;
    } //-- java.lang.String getIndPrevAdopt() 

    /**
     * Returns the value of field 'indPrivateAdoptn'.
     * 
     * @return the value of field 'IndPrivateAdoptn'.
     */
    public java.lang.String getIndPrivateAdoptn()
    {
        return this._indPrivateAdoptn;
    } //-- java.lang.String getIndPrivateAdoptn() 

    /**
     * Returns the value of field 'indPublicAdoptn'.
     * 
     * @return the value of field 'IndPublicAdoptn'.
     */
    public java.lang.String getIndPublicAdoptn()
    {
        return this._indPublicAdoptn;
    } //-- java.lang.String getIndPublicAdoptn() 

    /**
     * Returns the value of field 'indSingleParAdpt'.
     * 
     * @return the value of field 'IndSingleParAdpt'.
     */
    public java.lang.String getIndSingleParAdpt()
    {
        return this._indSingleParAdpt;
    } //-- java.lang.String getIndSingleParAdpt() 

    /**
     * Returns the value of field 'ROWCINV24SOG_ARRAY'.
     * 
     * @return the value of field 'ROWCINV24SOG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY getROWCINV24SOG_ARRAY()
    {
        return this._ROWCINV24SOG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY getROWCINV24SOG_ARRAY() 

    /**
     * Returns the value of field 'szAgency'.
     * 
     * @return the value of field 'SzAgency'.
     */
    public java.lang.String getSzAgency()
    {
        return this._szAgency;
    } //-- java.lang.String getSzAgency() 

    /**
     * Returns the value of field 'szCdCntry'.
     * 
     * @return the value of field 'SzCdCntry'.
     */
    public java.lang.String getSzCdCntry()
    {
        return this._szCdCntry;
    } //-- java.lang.String getSzCdCntry() 

    /**
     * Returns the value of field 'szCdCounty'.
     * 
     * @return the value of field 'SzCdCounty'.
     */
    public java.lang.String getSzCdCounty()
    {
        return this._szCdCounty;
    } //-- java.lang.String getSzCdCounty() 

    /**
     * Returns the value of field 'szCdPersonDeath'.
     * 
     * @return the value of field 'SzCdPersonDeath'.
     */
    public java.lang.String getSzCdPersonDeath()
    {
        return this._szCdPersonDeath;
    } //-- java.lang.String getSzCdPersonDeath() 

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
     * Returns the value of field 'szCdPersonLanguage'.
     * 
     * @return the value of field 'SzCdPersonLanguage'.
     */
    public java.lang.String getSzCdPersonLanguage()
    {
        return this._szCdPersonLanguage;
    } //-- java.lang.String getSzCdPersonLanguage() 

    /**
     * Returns the value of field 'szCdPersonLivArr'.
     * 
     * @return the value of field 'SzCdPersonLivArr'.
     */
    public java.lang.String getSzCdPersonLivArr()
    {
        return this._szCdPersonLivArr;
    } //-- java.lang.String getSzCdPersonLivArr() 

    /**
     * Returns the value of field 'szCdPersonMaritalStatus'.
     * 
     * @return the value of field 'SzCdPersonMaritalStatus'.
     */
    public java.lang.String getSzCdPersonMaritalStatus()
    {
        return this._szCdPersonMaritalStatus;
    } //-- java.lang.String getSzCdPersonMaritalStatus() 

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
     * Returns the value of field 'szCdPersonReligion'.
     * 
     * @return the value of field 'SzCdPersonReligion'.
     */
    public java.lang.String getSzCdPersonReligion()
    {
        return this._szCdPersonReligion;
    } //-- java.lang.String getSzCdPersonReligion() 

    /**
     * Returns the value of field 'szCdSngleMomOrFar'.
     * 
     * @return the value of field 'SzCdSngleMomOrFar'.
     */
    public java.lang.String getSzCdSngleMomOrFar()
    {
        return this._szCdSngleMomOrFar;
    } //-- java.lang.String getSzCdSngleMomOrFar() 

    /**
     * Returns the value of field 'szCdState'.
     * 
     * @return the value of field 'SzCdState'.
     */
    public java.lang.String getSzCdState()
    {
        return this._szCdState;
    } //-- java.lang.String getSzCdState() 

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
     * Returns the value of field 'szTxtCharCmnts'.
     * 
     * @return the value of field 'SzTxtCharCmnts'.
     */
    public java.lang.String getSzTxtCharCmnts()
    {
        return this._szTxtCharCmnts;
    } //-- java.lang.String getSzTxtCharCmnts() 

    /**
     * Returns the value of field 'szTxtOccupation'.
     * 
     * @return the value of field 'SzTxtOccupation'.
     */
    public java.lang.String getSzTxtOccupation()
    {
        return this._szTxtOccupation;
    } //-- java.lang.String getSzTxtOccupation() 

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
     * Returns the value of field 'txtDissolutionDate'.
     * 
     * @return the value of field 'TxtDissolutionDate'.
     */
    public org.exolab.castor.types.Date getTxtDissolutionDate()
    {
        return this._txtDissolutionDate;
    } //-- org.exolab.castor.types.Date getTxtDissolutionDate() 

    /**
     * Returns the value of field 'txtPrevAdopt'.
     * 
     * @return the value of field 'TxtPrevAdopt'.
     */
    public org.exolab.castor.types.Date getTxtPrevAdopt()
    {
        return this._txtPrevAdopt;
    } //-- org.exolab.castor.types.Date getTxtPrevAdopt() 

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
     * Sets the value of field 'bCdPersNotYetDiag'.
     * 
     * @param bCdPersNotYetDiag the value of field
     * 'bCdPersNotYetDiag'.
     */
    public void setBCdPersNotYetDiag(java.lang.String bCdPersNotYetDiag)
    {
        this._bCdPersNotYetDiag = bCdPersNotYetDiag;
    } //-- void setBCdPersNotYetDiag(java.lang.String) 

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
     * Sets the value of field 'bIndIVEPriorAdoption'.
     * 
     * @param bIndIVEPriorAdoption the value of field
     * 'bIndIVEPriorAdoption'.
     */
    public void setBIndIVEPriorAdoption(java.lang.String bIndIVEPriorAdoption)
    {
        this._bIndIVEPriorAdoption = bIndIVEPriorAdoption;
    } //-- void setBIndIVEPriorAdoption(java.lang.String) 

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
     * Sets the value of field 'cCdPersonSex'.
     * 
     * @param cCdPersonSex the value of field 'cCdPersonSex'.
     */
    public void setCCdPersonSex(java.lang.String cCdPersonSex)
    {
        this._cCdPersonSex = cCdPersonSex;
    } //-- void setCCdPersonSex(java.lang.String) 

    /**
     * Sets the value of field 'cdPersonStatus'.
     * 
     * @param cdPersonStatus the value of field 'cdPersonStatus'.
     */
    public void setCdPersonStatus(java.lang.String cdPersonStatus)
    {
        this._cdPersonStatus = cdPersonStatus;
    } //-- void setCdPersonStatus(java.lang.String) 

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
     * Sets the value of field 'dtDtPersonDeath'.
     * 
     * @param dtDtPersonDeath the value of field 'dtDtPersonDeath'.
     */
    public void setDtDtPersonDeath(org.exolab.castor.types.Date dtDtPersonDeath)
    {
        this._dtDtPersonDeath = dtDtPersonDeath;
    } //-- void setDtDtPersonDeath(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'indAdoptnDislutn'.
     * 
     * @param indAdoptnDislutn the value of field 'indAdoptnDislutn'
     */
    public void setIndAdoptnDislutn(java.lang.String indAdoptnDislutn)
    {
        this._indAdoptnDislutn = indAdoptnDislutn;
    } //-- void setIndAdoptnDislutn(java.lang.String) 

    /**
     * Sets the value of field 'indIntlAdoptn'.
     * 
     * @param indIntlAdoptn the value of field 'indIntlAdoptn'.
     */
    public void setIndIntlAdoptn(java.lang.String indIntlAdoptn)
    {
        this._indIntlAdoptn = indIntlAdoptn;
    } //-- void setIndIntlAdoptn(java.lang.String) 

    /**
     * Sets the value of field 'indPrevAdopt'.
     * 
     * @param indPrevAdopt the value of field 'indPrevAdopt'.
     */
    public void setIndPrevAdopt(java.lang.String indPrevAdopt)
    {
        this._indPrevAdopt = indPrevAdopt;
    } //-- void setIndPrevAdopt(java.lang.String) 

    /**
     * Sets the value of field 'indPrivateAdoptn'.
     * 
     * @param indPrivateAdoptn the value of field 'indPrivateAdoptn'
     */
    public void setIndPrivateAdoptn(java.lang.String indPrivateAdoptn)
    {
        this._indPrivateAdoptn = indPrivateAdoptn;
    } //-- void setIndPrivateAdoptn(java.lang.String) 

    /**
     * Sets the value of field 'indPublicAdoptn'.
     * 
     * @param indPublicAdoptn the value of field 'indPublicAdoptn'.
     */
    public void setIndPublicAdoptn(java.lang.String indPublicAdoptn)
    {
        this._indPublicAdoptn = indPublicAdoptn;
    } //-- void setIndPublicAdoptn(java.lang.String) 

    /**
     * Sets the value of field 'indSingleParAdpt'.
     * 
     * @param indSingleParAdpt the value of field 'indSingleParAdpt'
     */
    public void setIndSingleParAdpt(java.lang.String indSingleParAdpt)
    {
        this._indSingleParAdpt = indSingleParAdpt;
    } //-- void setIndSingleParAdpt(java.lang.String) 

    /**
     * Sets the value of field 'ROWCINV24SOG_ARRAY'.
     * 
     * @param ROWCINV24SOG_ARRAY the value of field
     * 'ROWCINV24SOG_ARRAY'.
     */
    public void setROWCINV24SOG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY ROWCINV24SOG_ARRAY)
    {
        this._ROWCINV24SOG_ARRAY = ROWCINV24SOG_ARRAY;
    } //-- void setROWCINV24SOG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY) 

    /**
     * Sets the value of field 'szAgency'.
     * 
     * @param szAgency the value of field 'szAgency'.
     */
    public void setSzAgency(java.lang.String szAgency)
    {
        this._szAgency = szAgency;
    } //-- void setSzAgency(java.lang.String) 

    /**
     * Sets the value of field 'szCdCntry'.
     * 
     * @param szCdCntry the value of field 'szCdCntry'.
     */
    public void setSzCdCntry(java.lang.String szCdCntry)
    {
        this._szCdCntry = szCdCntry;
    } //-- void setSzCdCntry(java.lang.String) 

    /**
     * Sets the value of field 'szCdCounty'.
     * 
     * @param szCdCounty the value of field 'szCdCounty'.
     */
    public void setSzCdCounty(java.lang.String szCdCounty)
    {
        this._szCdCounty = szCdCounty;
    } //-- void setSzCdCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonDeath'.
     * 
     * @param szCdPersonDeath the value of field 'szCdPersonDeath'.
     */
    public void setSzCdPersonDeath(java.lang.String szCdPersonDeath)
    {
        this._szCdPersonDeath = szCdPersonDeath;
    } //-- void setSzCdPersonDeath(java.lang.String) 

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
     * Sets the value of field 'szCdPersonLanguage'.
     * 
     * @param szCdPersonLanguage the value of field
     * 'szCdPersonLanguage'.
     */
    public void setSzCdPersonLanguage(java.lang.String szCdPersonLanguage)
    {
        this._szCdPersonLanguage = szCdPersonLanguage;
    } //-- void setSzCdPersonLanguage(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonLivArr'.
     * 
     * @param szCdPersonLivArr the value of field 'szCdPersonLivArr'
     */
    public void setSzCdPersonLivArr(java.lang.String szCdPersonLivArr)
    {
        this._szCdPersonLivArr = szCdPersonLivArr;
    } //-- void setSzCdPersonLivArr(java.lang.String) 

    /**
     * Sets the value of field 'szCdPersonMaritalStatus'.
     * 
     * @param szCdPersonMaritalStatus the value of field
     * 'szCdPersonMaritalStatus'.
     */
    public void setSzCdPersonMaritalStatus(java.lang.String szCdPersonMaritalStatus)
    {
        this._szCdPersonMaritalStatus = szCdPersonMaritalStatus;
    } //-- void setSzCdPersonMaritalStatus(java.lang.String) 

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
     * Sets the value of field 'szCdPersonReligion'.
     * 
     * @param szCdPersonReligion the value of field
     * 'szCdPersonReligion'.
     */
    public void setSzCdPersonReligion(java.lang.String szCdPersonReligion)
    {
        this._szCdPersonReligion = szCdPersonReligion;
    } //-- void setSzCdPersonReligion(java.lang.String) 

    /**
     * Sets the value of field 'szCdSngleMomOrFar'.
     * 
     * @param szCdSngleMomOrFar the value of field
     * 'szCdSngleMomOrFar'.
     */
    public void setSzCdSngleMomOrFar(java.lang.String szCdSngleMomOrFar)
    {
        this._szCdSngleMomOrFar = szCdSngleMomOrFar;
    } //-- void setSzCdSngleMomOrFar(java.lang.String) 

    /**
     * Sets the value of field 'szCdState'.
     * 
     * @param szCdState the value of field 'szCdState'.
     */
    public void setSzCdState(java.lang.String szCdState)
    {
        this._szCdState = szCdState;
    } //-- void setSzCdState(java.lang.String) 

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
     * Sets the value of field 'szTxtCharCmnts'.
     * 
     * @param szTxtCharCmnts the value of field 'szTxtCharCmnts'.
     */
    public void setSzTxtCharCmnts(java.lang.String szTxtCharCmnts)
    {
        this._szTxtCharCmnts = szTxtCharCmnts;
    } //-- void setSzTxtCharCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtOccupation'.
     * 
     * @param szTxtOccupation the value of field 'szTxtOccupation'.
     */
    public void setSzTxtOccupation(java.lang.String szTxtOccupation)
    {
        this._szTxtOccupation = szTxtOccupation;
    } //-- void setSzTxtOccupation(java.lang.String) 

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
     * Sets the value of field 'txtDissolutionDate'.
     * 
     * @param txtDissolutionDate the value of field
     * 'txtDissolutionDate'.
     */
    public void setTxtDissolutionDate(org.exolab.castor.types.Date txtDissolutionDate)
    {
        this._txtDissolutionDate = txtDissolutionDate;
    } //-- void setTxtDissolutionDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'txtPrevAdopt'.
     * 
     * @param txtPrevAdopt the value of field 'txtPrevAdopt'.
     */
    public void setTxtPrevAdopt(org.exolab.castor.types.Date txtPrevAdopt)
    {
        this._txtPrevAdopt = txtPrevAdopt;
    } //-- void setTxtPrevAdopt(org.exolab.castor.types.Date) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO unmarshal(java.io.Reader) 

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
