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
 * Class CCFC07SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC07SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _szCdPalFollupEducStat
     */
    private java.lang.String _szCdPalFollupEducStat;

    /**
     * Field _szCdPalFollupEmployed
     */
    private java.lang.String _szCdPalFollupEmployed;

    /**
     * Field _szCdPalFollupLivArr
     */
    private java.lang.String _szCdPalFollupLivArr;

    /**
     * Field _szCdPalFollupMarital
     */
    private java.lang.String _szCdPalFollupMarital;

    /**
     * Field _szCdPalFollupHighestEdu
     */
    private java.lang.String _szCdPalFollupHighestEdu;

    /**
     * Field _uCdPalFollupReunified
     */
    private java.lang.String _uCdPalFollupReunified;

    /**
     * Field _dtDtPalFollupDate
     */
    private org.exolab.castor.types.Date _dtDtPalFollupDate;

    /**
     * Field _cIndPalFollupNoPubAst
     */
    private java.lang.String _cIndPalFollupNoPubAst;

    /**
     * Field _cIndPalFollupNotLocate
     */
    private java.lang.String _cIndPalFollupNotLocate;

    /**
     * Field _lNbrPalFollupNumChldrn
     */
    private int _lNbrPalFollupNumChldrn;

    /**
     * keeps track of state for field: _lNbrPalFollupNumChldrn
     */
    private boolean _has_lNbrPalFollupNumChldrn;

    /**
     * Field _ROWCCFC07SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC07SOG00_ARRAY _ROWCCFC07SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC07SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrPalFollupNumChldrn()
    {
        this._has_lNbrPalFollupNumChldrn= false;
    } //-- void deleteLNbrPalFollupNumChldrn() 

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
     * Returns the value of field 'cIndPalFollupNoPubAst'.
     * 
     * @return the value of field 'CIndPalFollupNoPubAst'.
     */
    public java.lang.String getCIndPalFollupNoPubAst()
    {
        return this._cIndPalFollupNoPubAst;
    } //-- java.lang.String getCIndPalFollupNoPubAst() 

    /**
     * Returns the value of field 'cIndPalFollupNotLocate'.
     * 
     * @return the value of field 'CIndPalFollupNotLocate'.
     */
    public java.lang.String getCIndPalFollupNotLocate()
    {
        return this._cIndPalFollupNotLocate;
    } //-- java.lang.String getCIndPalFollupNotLocate() 

    /**
     * Returns the value of field 'dtDtPalFollupDate'.
     * 
     * @return the value of field 'DtDtPalFollupDate'.
     */
    public org.exolab.castor.types.Date getDtDtPalFollupDate()
    {
        return this._dtDtPalFollupDate;
    } //-- org.exolab.castor.types.Date getDtDtPalFollupDate() 

    /**
     * Returns the value of field 'lNbrPalFollupNumChldrn'.
     * 
     * @return the value of field 'LNbrPalFollupNumChldrn'.
     */
    public int getLNbrPalFollupNumChldrn()
    {
        return this._lNbrPalFollupNumChldrn;
    } //-- int getLNbrPalFollupNumChldrn() 

    /**
     * Returns the value of field 'ROWCCFC07SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCFC07SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC07SOG00_ARRAY getROWCCFC07SOG00_ARRAY()
    {
        return this._ROWCCFC07SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC07SOG00_ARRAY getROWCCFC07SOG00_ARRAY() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

    /**
     * Returns the value of field 'szCdPalFollupEducStat'.
     * 
     * @return the value of field 'SzCdPalFollupEducStat'.
     */
    public java.lang.String getSzCdPalFollupEducStat()
    {
        return this._szCdPalFollupEducStat;
    } //-- java.lang.String getSzCdPalFollupEducStat() 

    /**
     * Returns the value of field 'szCdPalFollupEmployed'.
     * 
     * @return the value of field 'SzCdPalFollupEmployed'.
     */
    public java.lang.String getSzCdPalFollupEmployed()
    {
        return this._szCdPalFollupEmployed;
    } //-- java.lang.String getSzCdPalFollupEmployed() 

    /**
     * Returns the value of field 'szCdPalFollupHighestEdu'.
     * 
     * @return the value of field 'SzCdPalFollupHighestEdu'.
     */
    public java.lang.String getSzCdPalFollupHighestEdu()
    {
        return this._szCdPalFollupHighestEdu;
    } //-- java.lang.String getSzCdPalFollupHighestEdu() 

    /**
     * Returns the value of field 'szCdPalFollupLivArr'.
     * 
     * @return the value of field 'SzCdPalFollupLivArr'.
     */
    public java.lang.String getSzCdPalFollupLivArr()
    {
        return this._szCdPalFollupLivArr;
    } //-- java.lang.String getSzCdPalFollupLivArr() 

    /**
     * Returns the value of field 'szCdPalFollupMarital'.
     * 
     * @return the value of field 'SzCdPalFollupMarital'.
     */
    public java.lang.String getSzCdPalFollupMarital()
    {
        return this._szCdPalFollupMarital;
    } //-- java.lang.String getSzCdPalFollupMarital() 

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
     * Returns the value of field 'tsSysTsLastUpdate2'.
     * 
     * @return the value of field 'TsSysTsLastUpdate2'.
     */
    public java.util.Date getTsSysTsLastUpdate2()
    {
        return this._tsSysTsLastUpdate2;
    } //-- java.util.Date getTsSysTsLastUpdate2() 

    /**
     * Returns the value of field 'uCdPalFollupReunified'.
     * 
     * @return the value of field 'UCdPalFollupReunified'.
     */
    public java.lang.String getUCdPalFollupReunified()
    {
        return this._uCdPalFollupReunified;
    } //-- java.lang.String getUCdPalFollupReunified() 

    /**
     * Method hasLNbrPalFollupNumChldrn
     * 
     * 
     * 
     * @return true if at least one LNbrPalFollupNumChldrn has been
     * added
     */
    public boolean hasLNbrPalFollupNumChldrn()
    {
        return this._has_lNbrPalFollupNumChldrn;
    } //-- boolean hasLNbrPalFollupNumChldrn() 

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
     * Sets the value of field 'cIndPalFollupNoPubAst'.
     * 
     * @param cIndPalFollupNoPubAst the value of field
     * 'cIndPalFollupNoPubAst'.
     */
    public void setCIndPalFollupNoPubAst(java.lang.String cIndPalFollupNoPubAst)
    {
        this._cIndPalFollupNoPubAst = cIndPalFollupNoPubAst;
    } //-- void setCIndPalFollupNoPubAst(java.lang.String) 

    /**
     * Sets the value of field 'cIndPalFollupNotLocate'.
     * 
     * @param cIndPalFollupNotLocate the value of field
     * 'cIndPalFollupNotLocate'.
     */
    public void setCIndPalFollupNotLocate(java.lang.String cIndPalFollupNotLocate)
    {
        this._cIndPalFollupNotLocate = cIndPalFollupNotLocate;
    } //-- void setCIndPalFollupNotLocate(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPalFollupDate'.
     * 
     * @param dtDtPalFollupDate the value of field
     * 'dtDtPalFollupDate'.
     */
    public void setDtDtPalFollupDate(org.exolab.castor.types.Date dtDtPalFollupDate)
    {
        this._dtDtPalFollupDate = dtDtPalFollupDate;
    } //-- void setDtDtPalFollupDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrPalFollupNumChldrn'.
     * 
     * @param lNbrPalFollupNumChldrn the value of field
     * 'lNbrPalFollupNumChldrn'.
     */
    public void setLNbrPalFollupNumChldrn(int lNbrPalFollupNumChldrn)
    {
        this._lNbrPalFollupNumChldrn = lNbrPalFollupNumChldrn;
        this._has_lNbrPalFollupNumChldrn = true;
    } //-- void setLNbrPalFollupNumChldrn(int) 

    /**
     * Sets the value of field 'ROWCCFC07SOG00_ARRAY'.
     * 
     * @param ROWCCFC07SOG00_ARRAY the value of field
     * 'ROWCCFC07SOG00_ARRAY'.
     */
    public void setROWCCFC07SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC07SOG00_ARRAY ROWCCFC07SOG00_ARRAY)
    {
        this._ROWCCFC07SOG00_ARRAY = ROWCCFC07SOG00_ARRAY;
    } //-- void setROWCCFC07SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC07SOG00_ARRAY) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdPalFollupEducStat'.
     * 
     * @param szCdPalFollupEducStat the value of field
     * 'szCdPalFollupEducStat'.
     */
    public void setSzCdPalFollupEducStat(java.lang.String szCdPalFollupEducStat)
    {
        this._szCdPalFollupEducStat = szCdPalFollupEducStat;
    } //-- void setSzCdPalFollupEducStat(java.lang.String) 

    /**
     * Sets the value of field 'szCdPalFollupEmployed'.
     * 
     * @param szCdPalFollupEmployed the value of field
     * 'szCdPalFollupEmployed'.
     */
    public void setSzCdPalFollupEmployed(java.lang.String szCdPalFollupEmployed)
    {
        this._szCdPalFollupEmployed = szCdPalFollupEmployed;
    } //-- void setSzCdPalFollupEmployed(java.lang.String) 

    /**
     * Sets the value of field 'szCdPalFollupHighestEdu'.
     * 
     * @param szCdPalFollupHighestEdu the value of field
     * 'szCdPalFollupHighestEdu'.
     */
    public void setSzCdPalFollupHighestEdu(java.lang.String szCdPalFollupHighestEdu)
    {
        this._szCdPalFollupHighestEdu = szCdPalFollupHighestEdu;
    } //-- void setSzCdPalFollupHighestEdu(java.lang.String) 

    /**
     * Sets the value of field 'szCdPalFollupLivArr'.
     * 
     * @param szCdPalFollupLivArr the value of field
     * 'szCdPalFollupLivArr'.
     */
    public void setSzCdPalFollupLivArr(java.lang.String szCdPalFollupLivArr)
    {
        this._szCdPalFollupLivArr = szCdPalFollupLivArr;
    } //-- void setSzCdPalFollupLivArr(java.lang.String) 

    /**
     * Sets the value of field 'szCdPalFollupMarital'.
     * 
     * @param szCdPalFollupMarital the value of field
     * 'szCdPalFollupMarital'.
     */
    public void setSzCdPalFollupMarital(java.lang.String szCdPalFollupMarital)
    {
        this._szCdPalFollupMarital = szCdPalFollupMarital;
    } //-- void setSzCdPalFollupMarital(java.lang.String) 

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
     * Sets the value of field 'tsSysTsLastUpdate2'.
     * 
     * @param tsSysTsLastUpdate2 the value of field
     * 'tsSysTsLastUpdate2'.
     */
    public void setTsSysTsLastUpdate2(java.util.Date tsSysTsLastUpdate2)
    {
        this._tsSysTsLastUpdate2 = tsSysTsLastUpdate2;
    } //-- void setTsSysTsLastUpdate2(java.util.Date) 

    /**
     * Sets the value of field 'uCdPalFollupReunified'.
     * 
     * @param uCdPalFollupReunified the value of field
     * 'uCdPalFollupReunified'.
     */
    public void setUCdPalFollupReunified(java.lang.String uCdPalFollupReunified)
    {
        this._uCdPalFollupReunified = uCdPalFollupReunified;
    } //-- void setUCdPalFollupReunified(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO unmarshal(java.io.Reader) 

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
