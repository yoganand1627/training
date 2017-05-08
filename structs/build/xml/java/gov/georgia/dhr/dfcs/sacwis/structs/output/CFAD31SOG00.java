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
 * Class CFAD31SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD31SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _cdPersonSex
     */
    private java.lang.String _cdPersonSex;

    /**
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _nbrPersonAge
     */
    private int _nbrPersonAge;

    /**
     * keeps track of state for field: _nbrPersonAge
     */
    private boolean _has_nbrPersonAge;

    /**
     * Field _dtDtPlcmtStart
     */
    private java.util.Date _dtDtPlcmtStart;

    /**
     * Field _dtDtPlcmtEnd
     */
    private java.util.Date _dtDtPlcmtEnd;

    /**
     * Field _szCdPlcmtRemovalRsn
     */
    private java.lang.String _szCdPlcmtRemovalRsn;

    /**
     * Field _cdPlcmtType
     */
    private java.lang.String _cdPlcmtType;

    /**
     * Field _szCdPlocChild
     */
    private java.lang.String _szCdPlocChild;

    /**
     * Field _szCdPlcmtLivArr
     */
    private java.lang.String _szCdPlcmtLivArr;

    /**
     * Field _cScrIndAdptnCnsmmtd
     */
    private java.lang.String _cScrIndAdptnCnsmmtd;

    /**
     * Field _szSblngPlcmt
     */
    private java.lang.String _szSblngPlcmt;

    /**
     * Field _cdLegalStatCnty
     */
    private java.lang.String _cdLegalStatCnty;

    /**
     * Field _cScrIndSealed
     */
    private java.lang.String _cScrIndSealed;

    /**
     * Field _ulIdRsrcFacil
     */
    private int _ulIdRsrcFacil;

    /**
     * keeps track of state for field: _ulIdRsrcFacil
     */
    private boolean _has_ulIdRsrcFacil;

    /**
     * Field _nmPlcmtFacil
     */
    private java.lang.String _nmPlcmtFacil;

    /**
     * Field _ulIdRsrcAgency
     */
    private int _ulIdRsrcAgency;

    /**
     * keeps track of state for field: _ulIdRsrcAgency
     */
    private boolean _has_ulIdRsrcAgency;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdRbwoProg
     */
    private java.lang.String _szCdRbwoProg;

    /**
     * Field _szIndCci
     */
    private java.lang.String _szIndCci;

    /**
     * Field _szCdPlcmtTempType
     */
    private java.lang.String _szCdPlcmtTempType;

    /**
     * Field _dPerDiem
     */
    private double _dPerDiem;

    /**
     * keeps track of state for field: _dPerDiem
     */
    private boolean _has_dPerDiem;

    /**
     * Field _dWaiverRate
     */
    private double _dWaiverRate;

    /**
     * keeps track of state for field: _dWaiverRate
     */
    private boolean _has_dWaiverRate;

    /**
     * Field _ulIdPlcmtEvent
     */
    private int _ulIdPlcmtEvent;

    /**
     * keeps track of state for field: _ulIdPlcmtEvent
     */
    private boolean _has_ulIdPlcmtEvent;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD31SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDPerDiem()
    {
        this._has_dPerDiem= false;
    } //-- void deleteDPerDiem() 

    /**
     */
    public void deleteDWaiverRate()
    {
        this._has_dWaiverRate= false;
    } //-- void deleteDWaiverRate() 

    /**
     */
    public void deleteNbrPersonAge()
    {
        this._has_nbrPersonAge= false;
    } //-- void deleteNbrPersonAge() 

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
    public void deleteUlIdRsrcAgency()
    {
        this._has_ulIdRsrcAgency= false;
    } //-- void deleteUlIdRsrcAgency() 

    /**
     */
    public void deleteUlIdRsrcFacil()
    {
        this._has_ulIdRsrcFacil= false;
    } //-- void deleteUlIdRsrcFacil() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'cScrIndAdptnCnsmmtd'.
     * 
     * @return the value of field 'CScrIndAdptnCnsmmtd'.
     */
    public java.lang.String getCScrIndAdptnCnsmmtd()
    {
        return this._cScrIndAdptnCnsmmtd;
    } //-- java.lang.String getCScrIndAdptnCnsmmtd() 

    /**
     * Returns the value of field 'cScrIndSealed'.
     * 
     * @return the value of field 'CScrIndSealed'.
     */
    public java.lang.String getCScrIndSealed()
    {
        return this._cScrIndSealed;
    } //-- java.lang.String getCScrIndSealed() 

    /**
     * Returns the value of field 'cdLegalStatCnty'.
     * 
     * @return the value of field 'CdLegalStatCnty'.
     */
    public java.lang.String getCdLegalStatCnty()
    {
        return this._cdLegalStatCnty;
    } //-- java.lang.String getCdLegalStatCnty() 

    /**
     * Returns the value of field 'cdPersonSex'.
     * 
     * @return the value of field 'CdPersonSex'.
     */
    public java.lang.String getCdPersonSex()
    {
        return this._cdPersonSex;
    } //-- java.lang.String getCdPersonSex() 

    /**
     * Returns the value of field 'cdPlcmtType'.
     * 
     * @return the value of field 'CdPlcmtType'.
     */
    public java.lang.String getCdPlcmtType()
    {
        return this._cdPlcmtType;
    } //-- java.lang.String getCdPlcmtType() 

    /**
     * Returns the value of field 'dPerDiem'.
     * 
     * @return the value of field 'DPerDiem'.
     */
    public double getDPerDiem()
    {
        return this._dPerDiem;
    } //-- double getDPerDiem() 

    /**
     * Returns the value of field 'dWaiverRate'.
     * 
     * @return the value of field 'DWaiverRate'.
     */
    public double getDWaiverRate()
    {
        return this._dWaiverRate;
    } //-- double getDWaiverRate() 

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
     * Returns the value of field 'dtDtPlcmtEnd'.
     * 
     * @return the value of field 'DtDtPlcmtEnd'.
     */
    public java.util.Date getDtDtPlcmtEnd()
    {
        return this._dtDtPlcmtEnd;
    } //-- java.util.Date getDtDtPlcmtEnd() 

    /**
     * Returns the value of field 'dtDtPlcmtStart'.
     * 
     * @return the value of field 'DtDtPlcmtStart'.
     */
    public java.util.Date getDtDtPlcmtStart()
    {
        return this._dtDtPlcmtStart;
    } //-- java.util.Date getDtDtPlcmtStart() 

    /**
     * Returns the value of field 'nbrPersonAge'.
     * 
     * @return the value of field 'NbrPersonAge'.
     */
    public int getNbrPersonAge()
    {
        return this._nbrPersonAge;
    } //-- int getNbrPersonAge() 

    /**
     * Returns the value of field 'nmPlcmtFacil'.
     * 
     * @return the value of field 'NmPlcmtFacil'.
     */
    public java.lang.String getNmPlcmtFacil()
    {
        return this._nmPlcmtFacil;
    } //-- java.lang.String getNmPlcmtFacil() 

    /**
     * Returns the value of field 'szCdPlcmtLivArr'.
     * 
     * @return the value of field 'SzCdPlcmtLivArr'.
     */
    public java.lang.String getSzCdPlcmtLivArr()
    {
        return this._szCdPlcmtLivArr;
    } //-- java.lang.String getSzCdPlcmtLivArr() 

    /**
     * Returns the value of field 'szCdPlcmtRemovalRsn'.
     * 
     * @return the value of field 'SzCdPlcmtRemovalRsn'.
     */
    public java.lang.String getSzCdPlcmtRemovalRsn()
    {
        return this._szCdPlcmtRemovalRsn;
    } //-- java.lang.String getSzCdPlcmtRemovalRsn() 

    /**
     * Returns the value of field 'szCdPlcmtTempType'.
     * 
     * @return the value of field 'SzCdPlcmtTempType'.
     */
    public java.lang.String getSzCdPlcmtTempType()
    {
        return this._szCdPlcmtTempType;
    } //-- java.lang.String getSzCdPlcmtTempType() 

    /**
     * Returns the value of field 'szCdPlocChild'.
     * 
     * @return the value of field 'SzCdPlocChild'.
     */
    public java.lang.String getSzCdPlocChild()
    {
        return this._szCdPlocChild;
    } //-- java.lang.String getSzCdPlocChild() 

    /**
     * Returns the value of field 'szCdRbwoProg'.
     * 
     * @return the value of field 'SzCdRbwoProg'.
     */
    public java.lang.String getSzCdRbwoProg()
    {
        return this._szCdRbwoProg;
    } //-- java.lang.String getSzCdRbwoProg() 

    /**
     * Returns the value of field 'szIndCci'.
     * 
     * @return the value of field 'SzIndCci'.
     */
    public java.lang.String getSzIndCci()
    {
        return this._szIndCci;
    } //-- java.lang.String getSzIndCci() 

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
     * Returns the value of field 'szSblngPlcmt'.
     * 
     * @return the value of field 'SzSblngPlcmt'.
     */
    public java.lang.String getSzSblngPlcmt()
    {
        return this._szSblngPlcmt;
    } //-- java.lang.String getSzSblngPlcmt() 

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
     * Returns the value of field 'ulIdRsrcAgency'.
     * 
     * @return the value of field 'UlIdRsrcAgency'.
     */
    public int getUlIdRsrcAgency()
    {
        return this._ulIdRsrcAgency;
    } //-- int getUlIdRsrcAgency() 

    /**
     * Returns the value of field 'ulIdRsrcFacil'.
     * 
     * @return the value of field 'UlIdRsrcFacil'.
     */
    public int getUlIdRsrcFacil()
    {
        return this._ulIdRsrcFacil;
    } //-- int getUlIdRsrcFacil() 

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
     * Method hasDPerDiem
     * 
     * 
     * 
     * @return true if at least one DPerDiem has been added
     */
    public boolean hasDPerDiem()
    {
        return this._has_dPerDiem;
    } //-- boolean hasDPerDiem() 

    /**
     * Method hasDWaiverRate
     * 
     * 
     * 
     * @return true if at least one DWaiverRate has been added
     */
    public boolean hasDWaiverRate()
    {
        return this._has_dWaiverRate;
    } //-- boolean hasDWaiverRate() 

    /**
     * Method hasNbrPersonAge
     * 
     * 
     * 
     * @return true if at least one NbrPersonAge has been added
     */
    public boolean hasNbrPersonAge()
    {
        return this._has_nbrPersonAge;
    } //-- boolean hasNbrPersonAge() 

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
     * Method hasUlIdRsrcAgency
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcAgency has been added
     */
    public boolean hasUlIdRsrcAgency()
    {
        return this._has_ulIdRsrcAgency;
    } //-- boolean hasUlIdRsrcAgency() 

    /**
     * Method hasUlIdRsrcFacil
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcFacil has been added
     */
    public boolean hasUlIdRsrcFacil()
    {
        return this._has_ulIdRsrcFacil;
    } //-- boolean hasUlIdRsrcFacil() 

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
     * Sets the value of field 'cScrIndAdptnCnsmmtd'.
     * 
     * @param cScrIndAdptnCnsmmtd the value of field
     * 'cScrIndAdptnCnsmmtd'.
     */
    public void setCScrIndAdptnCnsmmtd(java.lang.String cScrIndAdptnCnsmmtd)
    {
        this._cScrIndAdptnCnsmmtd = cScrIndAdptnCnsmmtd;
    } //-- void setCScrIndAdptnCnsmmtd(java.lang.String) 

    /**
     * Sets the value of field 'cScrIndSealed'.
     * 
     * @param cScrIndSealed the value of field 'cScrIndSealed'.
     */
    public void setCScrIndSealed(java.lang.String cScrIndSealed)
    {
        this._cScrIndSealed = cScrIndSealed;
    } //-- void setCScrIndSealed(java.lang.String) 

    /**
     * Sets the value of field 'cdLegalStatCnty'.
     * 
     * @param cdLegalStatCnty the value of field 'cdLegalStatCnty'.
     */
    public void setCdLegalStatCnty(java.lang.String cdLegalStatCnty)
    {
        this._cdLegalStatCnty = cdLegalStatCnty;
    } //-- void setCdLegalStatCnty(java.lang.String) 

    /**
     * Sets the value of field 'cdPersonSex'.
     * 
     * @param cdPersonSex the value of field 'cdPersonSex'.
     */
    public void setCdPersonSex(java.lang.String cdPersonSex)
    {
        this._cdPersonSex = cdPersonSex;
    } //-- void setCdPersonSex(java.lang.String) 

    /**
     * Sets the value of field 'cdPlcmtType'.
     * 
     * @param cdPlcmtType the value of field 'cdPlcmtType'.
     */
    public void setCdPlcmtType(java.lang.String cdPlcmtType)
    {
        this._cdPlcmtType = cdPlcmtType;
    } //-- void setCdPlcmtType(java.lang.String) 

    /**
     * Sets the value of field 'dPerDiem'.
     * 
     * @param dPerDiem the value of field 'dPerDiem'.
     */
    public void setDPerDiem(double dPerDiem)
    {
        this._dPerDiem = dPerDiem;
        this._has_dPerDiem = true;
    } //-- void setDPerDiem(double) 

    /**
     * Sets the value of field 'dWaiverRate'.
     * 
     * @param dWaiverRate the value of field 'dWaiverRate'.
     */
    public void setDWaiverRate(double dWaiverRate)
    {
        this._dWaiverRate = dWaiverRate;
        this._has_dWaiverRate = true;
    } //-- void setDWaiverRate(double) 

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
     * Sets the value of field 'dtDtPlcmtEnd'.
     * 
     * @param dtDtPlcmtEnd the value of field 'dtDtPlcmtEnd'.
     */
    public void setDtDtPlcmtEnd(java.util.Date dtDtPlcmtEnd)
    {
        this._dtDtPlcmtEnd = dtDtPlcmtEnd;
    } //-- void setDtDtPlcmtEnd(java.util.Date) 

    /**
     * Sets the value of field 'dtDtPlcmtStart'.
     * 
     * @param dtDtPlcmtStart the value of field 'dtDtPlcmtStart'.
     */
    public void setDtDtPlcmtStart(java.util.Date dtDtPlcmtStart)
    {
        this._dtDtPlcmtStart = dtDtPlcmtStart;
    } //-- void setDtDtPlcmtStart(java.util.Date) 

    /**
     * Sets the value of field 'nbrPersonAge'.
     * 
     * @param nbrPersonAge the value of field 'nbrPersonAge'.
     */
    public void setNbrPersonAge(int nbrPersonAge)
    {
        this._nbrPersonAge = nbrPersonAge;
        this._has_nbrPersonAge = true;
    } //-- void setNbrPersonAge(int) 

    /**
     * Sets the value of field 'nmPlcmtFacil'.
     * 
     * @param nmPlcmtFacil the value of field 'nmPlcmtFacil'.
     */
    public void setNmPlcmtFacil(java.lang.String nmPlcmtFacil)
    {
        this._nmPlcmtFacil = nmPlcmtFacil;
    } //-- void setNmPlcmtFacil(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtLivArr'.
     * 
     * @param szCdPlcmtLivArr the value of field 'szCdPlcmtLivArr'.
     */
    public void setSzCdPlcmtLivArr(java.lang.String szCdPlcmtLivArr)
    {
        this._szCdPlcmtLivArr = szCdPlcmtLivArr;
    } //-- void setSzCdPlcmtLivArr(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtRemovalRsn'.
     * 
     * @param szCdPlcmtRemovalRsn the value of field
     * 'szCdPlcmtRemovalRsn'.
     */
    public void setSzCdPlcmtRemovalRsn(java.lang.String szCdPlcmtRemovalRsn)
    {
        this._szCdPlcmtRemovalRsn = szCdPlcmtRemovalRsn;
    } //-- void setSzCdPlcmtRemovalRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtTempType'.
     * 
     * @param szCdPlcmtTempType the value of field
     * 'szCdPlcmtTempType'.
     */
    public void setSzCdPlcmtTempType(java.lang.String szCdPlcmtTempType)
    {
        this._szCdPlcmtTempType = szCdPlcmtTempType;
    } //-- void setSzCdPlcmtTempType(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlocChild'.
     * 
     * @param szCdPlocChild the value of field 'szCdPlocChild'.
     */
    public void setSzCdPlocChild(java.lang.String szCdPlocChild)
    {
        this._szCdPlocChild = szCdPlocChild;
    } //-- void setSzCdPlocChild(java.lang.String) 

    /**
     * Sets the value of field 'szCdRbwoProg'.
     * 
     * @param szCdRbwoProg the value of field 'szCdRbwoProg'.
     */
    public void setSzCdRbwoProg(java.lang.String szCdRbwoProg)
    {
        this._szCdRbwoProg = szCdRbwoProg;
    } //-- void setSzCdRbwoProg(java.lang.String) 

    /**
     * Sets the value of field 'szIndCci'.
     * 
     * @param szIndCci the value of field 'szIndCci'.
     */
    public void setSzIndCci(java.lang.String szIndCci)
    {
        this._szIndCci = szIndCci;
    } //-- void setSzIndCci(java.lang.String) 

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
     * Sets the value of field 'szSblngPlcmt'.
     * 
     * @param szSblngPlcmt the value of field 'szSblngPlcmt'.
     */
    public void setSzSblngPlcmt(java.lang.String szSblngPlcmt)
    {
        this._szSblngPlcmt = szSblngPlcmt;
    } //-- void setSzSblngPlcmt(java.lang.String) 

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
     * Sets the value of field 'ulIdRsrcAgency'.
     * 
     * @param ulIdRsrcAgency the value of field 'ulIdRsrcAgency'.
     */
    public void setUlIdRsrcAgency(int ulIdRsrcAgency)
    {
        this._ulIdRsrcAgency = ulIdRsrcAgency;
        this._has_ulIdRsrcAgency = true;
    } //-- void setUlIdRsrcAgency(int) 

    /**
     * Sets the value of field 'ulIdRsrcFacil'.
     * 
     * @param ulIdRsrcFacil the value of field 'ulIdRsrcFacil'.
     */
    public void setUlIdRsrcFacil(int ulIdRsrcFacil)
    {
        this._ulIdRsrcFacil = ulIdRsrcFacil;
        this._has_ulIdRsrcFacil = true;
    } //-- void setUlIdRsrcFacil(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SOG00 unmarshal(java.io.Reader) 

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
