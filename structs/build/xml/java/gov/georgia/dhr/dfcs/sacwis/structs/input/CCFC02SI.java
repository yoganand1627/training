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
 * Class CCFC02SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC02SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szSysCdWinMode
     */
    private java.lang.String _szSysCdWinMode;

    /**
     * Field _ROWCCMN01UIG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 _ROWCCMN01UIG00;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdPalCloseLivArr
     */
    private java.lang.String _szCdPalCloseLivArr;

    /**
     * Field _dtDtPalPostasmtDate
     */
    private org.exolab.castor.types.Date _dtDtPalPostasmtDate;

    /**
     * Field _dtDtPalPreasmtDate
     */
    private org.exolab.castor.types.Date _dtDtPalPreasmtDate;

    /**
     * Field _cIndPalIlNoIlsAssmt
     */
    private java.lang.String _cIndPalIlNoIlsAssmt;

    /**
     * Field _cIndPalIlNoPoasmt_Scre
     */
    private java.lang.String _cIndPalIlNoPoasmt_Scre;

    /**
     * Field _cIndPalIlNoPrasmtScre
     */
    private java.lang.String _cIndPalIlNoPrasmtScre;

    /**
     * Field _lNbrPalPostasmtScore
     */
    private int _lNbrPalPostasmtScore;

    /**
     * keeps track of state for field: _lNbrPalPostasmtScore
     */
    private boolean _has_lNbrPalPostasmtScore;

    /**
     * Field _lNbrPalPreasmtScore
     */
    private int _lNbrPalPreasmtScore;

    /**
     * keeps track of state for field: _lNbrPalPreasmtScore
     */
    private boolean _has_lNbrPalPreasmtScore;

    /**
     * Field _szTxtPalIlNoIlsRsn
     */
    private java.lang.String _szTxtPalIlNoIlsRsn;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC02SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrPalPostasmtScore()
    {
        this._has_lNbrPalPostasmtScore= false;
    } //-- void deleteLNbrPalPostasmtScore() 

    /**
     */
    public void deleteLNbrPalPreasmtScore()
    {
        this._has_lNbrPalPreasmtScore= false;
    } //-- void deleteLNbrPalPreasmtScore() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

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
     * Returns the value of field 'cIndPalIlNoIlsAssmt'.
     * 
     * @return the value of field 'CIndPalIlNoIlsAssmt'.
     */
    public java.lang.String getCIndPalIlNoIlsAssmt()
    {
        return this._cIndPalIlNoIlsAssmt;
    } //-- java.lang.String getCIndPalIlNoIlsAssmt() 

    /**
     * Returns the value of field 'cIndPalIlNoPoasmt_Scre'.
     * 
     * @return the value of field 'CIndPalIlNoPoasmt_Scre'.
     */
    public java.lang.String getCIndPalIlNoPoasmt_Scre()
    {
        return this._cIndPalIlNoPoasmt_Scre;
    } //-- java.lang.String getCIndPalIlNoPoasmt_Scre() 

    /**
     * Returns the value of field 'cIndPalIlNoPrasmtScre'.
     * 
     * @return the value of field 'CIndPalIlNoPrasmtScre'.
     */
    public java.lang.String getCIndPalIlNoPrasmtScre()
    {
        return this._cIndPalIlNoPrasmtScre;
    } //-- java.lang.String getCIndPalIlNoPrasmtScre() 

    /**
     * Returns the value of field 'dtDtPalPostasmtDate'.
     * 
     * @return the value of field 'DtDtPalPostasmtDate'.
     */
    public org.exolab.castor.types.Date getDtDtPalPostasmtDate()
    {
        return this._dtDtPalPostasmtDate;
    } //-- org.exolab.castor.types.Date getDtDtPalPostasmtDate() 

    /**
     * Returns the value of field 'dtDtPalPreasmtDate'.
     * 
     * @return the value of field 'DtDtPalPreasmtDate'.
     */
    public org.exolab.castor.types.Date getDtDtPalPreasmtDate()
    {
        return this._dtDtPalPreasmtDate;
    } //-- org.exolab.castor.types.Date getDtDtPalPreasmtDate() 

    /**
     * Returns the value of field 'lNbrPalPostasmtScore'.
     * 
     * @return the value of field 'LNbrPalPostasmtScore'.
     */
    public int getLNbrPalPostasmtScore()
    {
        return this._lNbrPalPostasmtScore;
    } //-- int getLNbrPalPostasmtScore() 

    /**
     * Returns the value of field 'lNbrPalPreasmtScore'.
     * 
     * @return the value of field 'LNbrPalPreasmtScore'.
     */
    public int getLNbrPalPreasmtScore()
    {
        return this._lNbrPalPreasmtScore;
    } //-- int getLNbrPalPreasmtScore() 

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
     * Returns the value of field 'szCdPalCloseLivArr'.
     * 
     * @return the value of field 'SzCdPalCloseLivArr'.
     */
    public java.lang.String getSzCdPalCloseLivArr()
    {
        return this._szCdPalCloseLivArr;
    } //-- java.lang.String getSzCdPalCloseLivArr() 

    /**
     * Returns the value of field 'szSysCdWinMode'.
     * 
     * @return the value of field 'SzSysCdWinMode'.
     */
    public java.lang.String getSzSysCdWinMode()
    {
        return this._szSysCdWinMode;
    } //-- java.lang.String getSzSysCdWinMode() 

    /**
     * Returns the value of field 'szTxtPalIlNoIlsRsn'.
     * 
     * @return the value of field 'SzTxtPalIlNoIlsRsn'.
     */
    public java.lang.String getSzTxtPalIlNoIlsRsn()
    {
        return this._szTxtPalIlNoIlsRsn;
    } //-- java.lang.String getSzTxtPalIlNoIlsRsn() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Method hasLNbrPalPostasmtScore
     * 
     * 
     * 
     * @return true if at least one LNbrPalPostasmtScore has been
     * added
     */
    public boolean hasLNbrPalPostasmtScore()
    {
        return this._has_lNbrPalPostasmtScore;
    } //-- boolean hasLNbrPalPostasmtScore() 

    /**
     * Method hasLNbrPalPreasmtScore
     * 
     * 
     * 
     * @return true if at least one LNbrPalPreasmtScore has been
     * added
     */
    public boolean hasLNbrPalPreasmtScore()
    {
        return this._has_lNbrPalPreasmtScore;
    } //-- boolean hasLNbrPalPreasmtScore() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'cIndPalIlNoIlsAssmt'.
     * 
     * @param cIndPalIlNoIlsAssmt the value of field
     * 'cIndPalIlNoIlsAssmt'.
     */
    public void setCIndPalIlNoIlsAssmt(java.lang.String cIndPalIlNoIlsAssmt)
    {
        this._cIndPalIlNoIlsAssmt = cIndPalIlNoIlsAssmt;
    } //-- void setCIndPalIlNoIlsAssmt(java.lang.String) 

    /**
     * Sets the value of field 'cIndPalIlNoPoasmt_Scre'.
     * 
     * @param cIndPalIlNoPoasmt_Scre the value of field
     * 'cIndPalIlNoPoasmt_Scre'.
     */
    public void setCIndPalIlNoPoasmt_Scre(java.lang.String cIndPalIlNoPoasmt_Scre)
    {
        this._cIndPalIlNoPoasmt_Scre = cIndPalIlNoPoasmt_Scre;
    } //-- void setCIndPalIlNoPoasmt_Scre(java.lang.String) 

    /**
     * Sets the value of field 'cIndPalIlNoPrasmtScre'.
     * 
     * @param cIndPalIlNoPrasmtScre the value of field
     * 'cIndPalIlNoPrasmtScre'.
     */
    public void setCIndPalIlNoPrasmtScre(java.lang.String cIndPalIlNoPrasmtScre)
    {
        this._cIndPalIlNoPrasmtScre = cIndPalIlNoPrasmtScre;
    } //-- void setCIndPalIlNoPrasmtScre(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPalPostasmtDate'.
     * 
     * @param dtDtPalPostasmtDate the value of field
     * 'dtDtPalPostasmtDate'.
     */
    public void setDtDtPalPostasmtDate(org.exolab.castor.types.Date dtDtPalPostasmtDate)
    {
        this._dtDtPalPostasmtDate = dtDtPalPostasmtDate;
    } //-- void setDtDtPalPostasmtDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPalPreasmtDate'.
     * 
     * @param dtDtPalPreasmtDate the value of field
     * 'dtDtPalPreasmtDate'.
     */
    public void setDtDtPalPreasmtDate(org.exolab.castor.types.Date dtDtPalPreasmtDate)
    {
        this._dtDtPalPreasmtDate = dtDtPalPreasmtDate;
    } //-- void setDtDtPalPreasmtDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrPalPostasmtScore'.
     * 
     * @param lNbrPalPostasmtScore the value of field
     * 'lNbrPalPostasmtScore'.
     */
    public void setLNbrPalPostasmtScore(int lNbrPalPostasmtScore)
    {
        this._lNbrPalPostasmtScore = lNbrPalPostasmtScore;
        this._has_lNbrPalPostasmtScore = true;
    } //-- void setLNbrPalPostasmtScore(int) 

    /**
     * Sets the value of field 'lNbrPalPreasmtScore'.
     * 
     * @param lNbrPalPreasmtScore the value of field
     * 'lNbrPalPreasmtScore'.
     */
    public void setLNbrPalPreasmtScore(int lNbrPalPreasmtScore)
    {
        this._lNbrPalPreasmtScore = lNbrPalPreasmtScore;
        this._has_lNbrPalPreasmtScore = true;
    } //-- void setLNbrPalPreasmtScore(int) 

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
     * Sets the value of field 'szCdPalCloseLivArr'.
     * 
     * @param szCdPalCloseLivArr the value of field
     * 'szCdPalCloseLivArr'.
     */
    public void setSzCdPalCloseLivArr(java.lang.String szCdPalCloseLivArr)
    {
        this._szCdPalCloseLivArr = szCdPalCloseLivArr;
    } //-- void setSzCdPalCloseLivArr(java.lang.String) 

    /**
     * Sets the value of field 'szSysCdWinMode'.
     * 
     * @param szSysCdWinMode the value of field 'szSysCdWinMode'.
     */
    public void setSzSysCdWinMode(java.lang.String szSysCdWinMode)
    {
        this._szSysCdWinMode = szSysCdWinMode;
    } //-- void setSzSysCdWinMode(java.lang.String) 

    /**
     * Sets the value of field 'szTxtPalIlNoIlsRsn'.
     * 
     * @param szTxtPalIlNoIlsRsn the value of field
     * 'szTxtPalIlNoIlsRsn'.
     */
    public void setSzTxtPalIlNoIlsRsn(java.lang.String szTxtPalIlNoIlsRsn)
    {
        this._szTxtPalIlNoIlsRsn = szTxtPalIlNoIlsRsn;
    } //-- void setSzTxtPalIlNoIlsRsn(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI unmarshal(java.io.Reader) 

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
