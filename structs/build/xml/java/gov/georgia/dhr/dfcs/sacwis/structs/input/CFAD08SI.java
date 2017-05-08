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
 * Class CFAD08SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD08SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _cSysRsrcCntyChg
     */
    private java.lang.String _cSysRsrcCntyChg;

    /**
     * Field _isApprovalMode
     */
    private boolean _isApprovalMode;

    /**
     * keeps track of state for field: _isApprovalMode
     */
    private boolean _has_isApprovalMode;

    /**
     * Field _dtSysDtGenericSysdate
     */
    private org.exolab.castor.types.Date _dtSysDtGenericSysdate;

    /**
     * Field _bIndEndDateMod
     */
    private java.lang.String _bIndEndDateMod;

    /**
     * Field _cSysIndRsrcNameChg
     */
    private java.lang.String _cSysIndRsrcNameChg;

    /**
     * Field _cSysRsrcStateChg
     */
    private java.lang.String _cSysRsrcStateChg;

    /**
     * Field _cSysIndRsrcCharChgNoSvc
     */
    private java.lang.String _cSysIndRsrcCharChgNoSvc;

    /**
     * Field _cSysIndRsrcCharChg
     */
    private java.lang.String _cSysIndRsrcCharChg;

    /**
     * Field _cSysIndRsrcPrsChg
     */
    private java.lang.String _cSysIndRsrcPrsChg;

    /**
     * Field _cSysIndCategoryChange
     */
    private java.lang.String _cSysIndCategoryChange;

    /**
     * Field _cSysIndFosterTypeChange
     */
    private java.lang.String _cSysIndFosterTypeChange;

    /**
     * Field _bSysIndAgeChange
     */
    private java.lang.String _bSysIndAgeChange;

    /**
     * Field _bIndReview
     */
    private java.lang.String _bIndReview;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szCdEventStatus_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY _szCdEventStatus_ARRAY;

    /**
     * Field _szCdRsrcStatus_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY _szCdRsrcStatus_ARRAY;

    /**
     * Field _szCdRsrcState
     */
    private java.lang.String _szCdRsrcState;

    /**
     * Field _szCdRsrcCnty
     */
    private java.lang.String _szCdRsrcCnty;

    /**
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _ulIdCntrctWkr
     */
    private int _ulIdCntrctWkr;

    /**
     * keeps track of state for field: _ulIdCntrctWkr
     */
    private boolean _has_ulIdCntrctWkr;

    /**
     * Field _ROWCFAD08SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00_ARRAY _ROWCFAD08SIG00_ARRAY;

    /**
     * Field _ROWCFAD08SIG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY _ROWCFAD08SIG01_ARRAY;

    /**
     * Field _ROWCFAD08SIG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02_ARRAY _ROWCFAD08SIG02_ARRAY;

    /**
     * Field _ROWCFAD08SIG03_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03_ARRAY _ROWCFAD08SIG03_ARRAY;

    /**
     * Field _homeRaceSI_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY _homeRaceSI_ARRAY;

    /**
     * Field _ROWCFAD08SIG04
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04 _ROWCFAD08SIG04;

    /**
     * Field _ROWCFAD08SIG05
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG05 _ROWCFAD08SIG05;

    /**
     * Field _ROWCFAD08SIG06
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06 _ROWCFAD08SIG06;

    /**
     * Field _ROWCFAD08SIG07_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY _ROWCFAD08SIG07_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD08SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIsApprovalMode()
    {
        this._has_isApprovalMode= false;
    } //-- void deleteIsApprovalMode() 

    /**
     */
    public void deleteUlIdCntrctWkr()
    {
        this._has_ulIdCntrctWkr= false;
    } //-- void deleteUlIdCntrctWkr() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

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
     * Returns the value of field 'bIndEndDateMod'.
     * 
     * @return the value of field 'BIndEndDateMod'.
     */
    public java.lang.String getBIndEndDateMod()
    {
        return this._bIndEndDateMod;
    } //-- java.lang.String getBIndEndDateMod() 

    /**
     * Returns the value of field 'bIndReview'.
     * 
     * @return the value of field 'BIndReview'.
     */
    public java.lang.String getBIndReview()
    {
        return this._bIndReview;
    } //-- java.lang.String getBIndReview() 

    /**
     * Returns the value of field 'bSysIndAgeChange'.
     * 
     * @return the value of field 'BSysIndAgeChange'.
     */
    public java.lang.String getBSysIndAgeChange()
    {
        return this._bSysIndAgeChange;
    } //-- java.lang.String getBSysIndAgeChange() 

    /**
     * Returns the value of field 'cSysIndCategoryChange'.
     * 
     * @return the value of field 'CSysIndCategoryChange'.
     */
    public java.lang.String getCSysIndCategoryChange()
    {
        return this._cSysIndCategoryChange;
    } //-- java.lang.String getCSysIndCategoryChange() 

    /**
     * Returns the value of field 'cSysIndFosterTypeChange'.
     * 
     * @return the value of field 'CSysIndFosterTypeChange'.
     */
    public java.lang.String getCSysIndFosterTypeChange()
    {
        return this._cSysIndFosterTypeChange;
    } //-- java.lang.String getCSysIndFosterTypeChange() 

    /**
     * Returns the value of field 'cSysIndRsrcCharChg'.
     * 
     * @return the value of field 'CSysIndRsrcCharChg'.
     */
    public java.lang.String getCSysIndRsrcCharChg()
    {
        return this._cSysIndRsrcCharChg;
    } //-- java.lang.String getCSysIndRsrcCharChg() 

    /**
     * Returns the value of field 'cSysIndRsrcCharChgNoSvc'.
     * 
     * @return the value of field 'CSysIndRsrcCharChgNoSvc'.
     */
    public java.lang.String getCSysIndRsrcCharChgNoSvc()
    {
        return this._cSysIndRsrcCharChgNoSvc;
    } //-- java.lang.String getCSysIndRsrcCharChgNoSvc() 

    /**
     * Returns the value of field 'cSysIndRsrcNameChg'.
     * 
     * @return the value of field 'CSysIndRsrcNameChg'.
     */
    public java.lang.String getCSysIndRsrcNameChg()
    {
        return this._cSysIndRsrcNameChg;
    } //-- java.lang.String getCSysIndRsrcNameChg() 

    /**
     * Returns the value of field 'cSysIndRsrcPrsChg'.
     * 
     * @return the value of field 'CSysIndRsrcPrsChg'.
     */
    public java.lang.String getCSysIndRsrcPrsChg()
    {
        return this._cSysIndRsrcPrsChg;
    } //-- java.lang.String getCSysIndRsrcPrsChg() 

    /**
     * Returns the value of field 'cSysRsrcCntyChg'.
     * 
     * @return the value of field 'CSysRsrcCntyChg'.
     */
    public java.lang.String getCSysRsrcCntyChg()
    {
        return this._cSysRsrcCntyChg;
    } //-- java.lang.String getCSysRsrcCntyChg() 

    /**
     * Returns the value of field 'cSysRsrcStateChg'.
     * 
     * @return the value of field 'CSysRsrcStateChg'.
     */
    public java.lang.String getCSysRsrcStateChg()
    {
        return this._cSysRsrcStateChg;
    } //-- java.lang.String getCSysRsrcStateChg() 

    /**
     * Returns the value of field 'dtSysDtGenericSysdate'.
     * 
     * @return the value of field 'DtSysDtGenericSysdate'.
     */
    public org.exolab.castor.types.Date getDtSysDtGenericSysdate()
    {
        return this._dtSysDtGenericSysdate;
    } //-- org.exolab.castor.types.Date getDtSysDtGenericSysdate() 

    /**
     * Returns the value of field 'homeRaceSI_ARRAY'.
     * 
     * @return the value of field 'HomeRaceSI_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY getHomeRaceSI_ARRAY()
    {
        return this._homeRaceSI_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY getHomeRaceSI_ARRAY() 

    /**
     * Returns the value of field 'isApprovalMode'.
     * 
     * @return the value of field 'IsApprovalMode'.
     */
    public boolean getIsApprovalMode()
    {
        return this._isApprovalMode;
    } //-- boolean getIsApprovalMode() 

    /**
     * Returns the value of field 'ROWCFAD08SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD08SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00_ARRAY getROWCFAD08SIG00_ARRAY()
    {
        return this._ROWCFAD08SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00_ARRAY getROWCFAD08SIG00_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD08SIG01_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD08SIG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY getROWCFAD08SIG01_ARRAY()
    {
        return this._ROWCFAD08SIG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY getROWCFAD08SIG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD08SIG02_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD08SIG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02_ARRAY getROWCFAD08SIG02_ARRAY()
    {
        return this._ROWCFAD08SIG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02_ARRAY getROWCFAD08SIG02_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD08SIG03_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD08SIG03_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03_ARRAY getROWCFAD08SIG03_ARRAY()
    {
        return this._ROWCFAD08SIG03_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03_ARRAY getROWCFAD08SIG03_ARRAY() 

    /**
     * Returns the value of field 'ROWCFAD08SIG04'.
     * 
     * @return the value of field 'ROWCFAD08SIG04'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04 getROWCFAD08SIG04()
    {
        return this._ROWCFAD08SIG04;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04 getROWCFAD08SIG04() 

    /**
     * Returns the value of field 'ROWCFAD08SIG05'.
     * 
     * @return the value of field 'ROWCFAD08SIG05'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG05 getROWCFAD08SIG05()
    {
        return this._ROWCFAD08SIG05;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG05 getROWCFAD08SIG05() 

    /**
     * Returns the value of field 'ROWCFAD08SIG06'.
     * 
     * @return the value of field 'ROWCFAD08SIG06'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06 getROWCFAD08SIG06()
    {
        return this._ROWCFAD08SIG06;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06 getROWCFAD08SIG06() 

    /**
     * Returns the value of field 'ROWCFAD08SIG07_ARRAY'.
     * 
     * @return the value of field 'ROWCFAD08SIG07_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY getROWCFAD08SIG07_ARRAY()
    {
        return this._ROWCFAD08SIG07_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY getROWCFAD08SIG07_ARRAY() 

    /**
     * Returns the value of field 'szCdCntrctRegion'.
     * 
     * @return the value of field 'SzCdCntrctRegion'.
     */
    public java.lang.String getSzCdCntrctRegion()
    {
        return this._szCdCntrctRegion;
    } //-- java.lang.String getSzCdCntrctRegion() 

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
     * Returns the value of field 'szCdRsrcCnty'.
     * 
     * @return the value of field 'SzCdRsrcCnty'.
     */
    public java.lang.String getSzCdRsrcCnty()
    {
        return this._szCdRsrcCnty;
    } //-- java.lang.String getSzCdRsrcCnty() 

    /**
     * Returns the value of field 'szCdRsrcState'.
     * 
     * @return the value of field 'SzCdRsrcState'.
     */
    public java.lang.String getSzCdRsrcState()
    {
        return this._szCdRsrcState;
    } //-- java.lang.String getSzCdRsrcState() 

    /**
     * Returns the value of field 'szCdRsrcStatus_ARRAY'.
     * 
     * @return the value of field 'SzCdRsrcStatus_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY getSzCdRsrcStatus_ARRAY()
    {
        return this._szCdRsrcStatus_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY getSzCdRsrcStatus_ARRAY() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Method hasIsApprovalMode
     * 
     * 
     * 
     * @return true if at least one IsApprovalMode has been added
     */
    public boolean hasIsApprovalMode()
    {
        return this._has_isApprovalMode;
    } //-- boolean hasIsApprovalMode() 

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
     * Method hasUlIdResource
     * 
     * 
     * 
     * @return true if at least one UlIdResource has been added
     */
    public boolean hasUlIdResource()
    {
        return this._has_ulIdResource;
    } //-- boolean hasUlIdResource() 

    /**
     * Returns the value of field 'isApprovalMode'.
     * 
     * @return the value of field 'IsApprovalMode'.
     */
    public boolean isIsApprovalMode()
    {
        return this._isApprovalMode;
    } //-- boolean isIsApprovalMode() 

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
     * Sets the value of field 'bIndEndDateMod'.
     * 
     * @param bIndEndDateMod the value of field 'bIndEndDateMod'.
     */
    public void setBIndEndDateMod(java.lang.String bIndEndDateMod)
    {
        this._bIndEndDateMod = bIndEndDateMod;
    } //-- void setBIndEndDateMod(java.lang.String) 

    /**
     * Sets the value of field 'bIndReview'.
     * 
     * @param bIndReview the value of field 'bIndReview'.
     */
    public void setBIndReview(java.lang.String bIndReview)
    {
        this._bIndReview = bIndReview;
    } //-- void setBIndReview(java.lang.String) 

    /**
     * Sets the value of field 'bSysIndAgeChange'.
     * 
     * @param bSysIndAgeChange the value of field 'bSysIndAgeChange'
     */
    public void setBSysIndAgeChange(java.lang.String bSysIndAgeChange)
    {
        this._bSysIndAgeChange = bSysIndAgeChange;
    } //-- void setBSysIndAgeChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndCategoryChange'.
     * 
     * @param cSysIndCategoryChange the value of field
     * 'cSysIndCategoryChange'.
     */
    public void setCSysIndCategoryChange(java.lang.String cSysIndCategoryChange)
    {
        this._cSysIndCategoryChange = cSysIndCategoryChange;
    } //-- void setCSysIndCategoryChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndFosterTypeChange'.
     * 
     * @param cSysIndFosterTypeChange the value of field
     * 'cSysIndFosterTypeChange'.
     */
    public void setCSysIndFosterTypeChange(java.lang.String cSysIndFosterTypeChange)
    {
        this._cSysIndFosterTypeChange = cSysIndFosterTypeChange;
    } //-- void setCSysIndFosterTypeChange(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsrcCharChg'.
     * 
     * @param cSysIndRsrcCharChg the value of field
     * 'cSysIndRsrcCharChg'.
     */
    public void setCSysIndRsrcCharChg(java.lang.String cSysIndRsrcCharChg)
    {
        this._cSysIndRsrcCharChg = cSysIndRsrcCharChg;
    } //-- void setCSysIndRsrcCharChg(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsrcCharChgNoSvc'.
     * 
     * @param cSysIndRsrcCharChgNoSvc the value of field
     * 'cSysIndRsrcCharChgNoSvc'.
     */
    public void setCSysIndRsrcCharChgNoSvc(java.lang.String cSysIndRsrcCharChgNoSvc)
    {
        this._cSysIndRsrcCharChgNoSvc = cSysIndRsrcCharChgNoSvc;
    } //-- void setCSysIndRsrcCharChgNoSvc(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsrcNameChg'.
     * 
     * @param cSysIndRsrcNameChg the value of field
     * 'cSysIndRsrcNameChg'.
     */
    public void setCSysIndRsrcNameChg(java.lang.String cSysIndRsrcNameChg)
    {
        this._cSysIndRsrcNameChg = cSysIndRsrcNameChg;
    } //-- void setCSysIndRsrcNameChg(java.lang.String) 

    /**
     * Sets the value of field 'cSysIndRsrcPrsChg'.
     * 
     * @param cSysIndRsrcPrsChg the value of field
     * 'cSysIndRsrcPrsChg'.
     */
    public void setCSysIndRsrcPrsChg(java.lang.String cSysIndRsrcPrsChg)
    {
        this._cSysIndRsrcPrsChg = cSysIndRsrcPrsChg;
    } //-- void setCSysIndRsrcPrsChg(java.lang.String) 

    /**
     * Sets the value of field 'cSysRsrcCntyChg'.
     * 
     * @param cSysRsrcCntyChg the value of field 'cSysRsrcCntyChg'.
     */
    public void setCSysRsrcCntyChg(java.lang.String cSysRsrcCntyChg)
    {
        this._cSysRsrcCntyChg = cSysRsrcCntyChg;
    } //-- void setCSysRsrcCntyChg(java.lang.String) 

    /**
     * Sets the value of field 'cSysRsrcStateChg'.
     * 
     * @param cSysRsrcStateChg the value of field 'cSysRsrcStateChg'
     */
    public void setCSysRsrcStateChg(java.lang.String cSysRsrcStateChg)
    {
        this._cSysRsrcStateChg = cSysRsrcStateChg;
    } //-- void setCSysRsrcStateChg(java.lang.String) 

    /**
     * Sets the value of field 'dtSysDtGenericSysdate'.
     * 
     * @param dtSysDtGenericSysdate the value of field
     * 'dtSysDtGenericSysdate'.
     */
    public void setDtSysDtGenericSysdate(org.exolab.castor.types.Date dtSysDtGenericSysdate)
    {
        this._dtSysDtGenericSysdate = dtSysDtGenericSysdate;
    } //-- void setDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'homeRaceSI_ARRAY'.
     * 
     * @param homeRaceSI_ARRAY the value of field 'homeRaceSI_ARRAY'
     */
    public void setHomeRaceSI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY homeRaceSI_ARRAY)
    {
        this._homeRaceSI_ARRAY = homeRaceSI_ARRAY;
    } //-- void setHomeRaceSI_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY) 

    /**
     * Sets the value of field 'isApprovalMode'.
     * 
     * @param isApprovalMode the value of field 'isApprovalMode'.
     */
    public void setIsApprovalMode(boolean isApprovalMode)
    {
        this._isApprovalMode = isApprovalMode;
        this._has_isApprovalMode = true;
    } //-- void setIsApprovalMode(boolean) 

    /**
     * Sets the value of field 'ROWCFAD08SIG00_ARRAY'.
     * 
     * @param ROWCFAD08SIG00_ARRAY the value of field
     * 'ROWCFAD08SIG00_ARRAY'.
     */
    public void setROWCFAD08SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00_ARRAY ROWCFAD08SIG00_ARRAY)
    {
        this._ROWCFAD08SIG00_ARRAY = ROWCFAD08SIG00_ARRAY;
    } //-- void setROWCFAD08SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG00_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD08SIG01_ARRAY'.
     * 
     * @param ROWCFAD08SIG01_ARRAY the value of field
     * 'ROWCFAD08SIG01_ARRAY'.
     */
    public void setROWCFAD08SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY ROWCFAD08SIG01_ARRAY)
    {
        this._ROWCFAD08SIG01_ARRAY = ROWCFAD08SIG01_ARRAY;
    } //-- void setROWCFAD08SIG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD08SIG02_ARRAY'.
     * 
     * @param ROWCFAD08SIG02_ARRAY the value of field
     * 'ROWCFAD08SIG02_ARRAY'.
     */
    public void setROWCFAD08SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02_ARRAY ROWCFAD08SIG02_ARRAY)
    {
        this._ROWCFAD08SIG02_ARRAY = ROWCFAD08SIG02_ARRAY;
    } //-- void setROWCFAD08SIG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG02_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD08SIG03_ARRAY'.
     * 
     * @param ROWCFAD08SIG03_ARRAY the value of field
     * 'ROWCFAD08SIG03_ARRAY'.
     */
    public void setROWCFAD08SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03_ARRAY ROWCFAD08SIG03_ARRAY)
    {
        this._ROWCFAD08SIG03_ARRAY = ROWCFAD08SIG03_ARRAY;
    } //-- void setROWCFAD08SIG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG03_ARRAY) 

    /**
     * Sets the value of field 'ROWCFAD08SIG04'.
     * 
     * @param ROWCFAD08SIG04 the value of field 'ROWCFAD08SIG04'.
     */
    public void setROWCFAD08SIG04(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04 ROWCFAD08SIG04)
    {
        this._ROWCFAD08SIG04 = ROWCFAD08SIG04;
    } //-- void setROWCFAD08SIG04(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04) 

    /**
     * Sets the value of field 'ROWCFAD08SIG05'.
     * 
     * @param ROWCFAD08SIG05 the value of field 'ROWCFAD08SIG05'.
     */
    public void setROWCFAD08SIG05(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG05 ROWCFAD08SIG05)
    {
        this._ROWCFAD08SIG05 = ROWCFAD08SIG05;
    } //-- void setROWCFAD08SIG05(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG05) 

    /**
     * Sets the value of field 'ROWCFAD08SIG06'.
     * 
     * @param ROWCFAD08SIG06 the value of field 'ROWCFAD08SIG06'.
     */
    public void setROWCFAD08SIG06(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06 ROWCFAD08SIG06)
    {
        this._ROWCFAD08SIG06 = ROWCFAD08SIG06;
    } //-- void setROWCFAD08SIG06(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG06) 

    /**
     * Sets the value of field 'ROWCFAD08SIG07_ARRAY'.
     * 
     * @param ROWCFAD08SIG07_ARRAY the value of field
     * 'ROWCFAD08SIG07_ARRAY'.
     */
    public void setROWCFAD08SIG07_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY ROWCFAD08SIG07_ARRAY)
    {
        this._ROWCFAD08SIG07_ARRAY = ROWCFAD08SIG07_ARRAY;
    } //-- void setROWCFAD08SIG07_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG07_ARRAY) 

    /**
     * Sets the value of field 'szCdCntrctRegion'.
     * 
     * @param szCdCntrctRegion the value of field 'szCdCntrctRegion'
     */
    public void setSzCdCntrctRegion(java.lang.String szCdCntrctRegion)
    {
        this._szCdCntrctRegion = szCdCntrctRegion;
    } //-- void setSzCdCntrctRegion(java.lang.String) 

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
     * Sets the value of field 'szCdRsrcCnty'.
     * 
     * @param szCdRsrcCnty the value of field 'szCdRsrcCnty'.
     */
    public void setSzCdRsrcCnty(java.lang.String szCdRsrcCnty)
    {
        this._szCdRsrcCnty = szCdRsrcCnty;
    } //-- void setSzCdRsrcCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcState'.
     * 
     * @param szCdRsrcState the value of field 'szCdRsrcState'.
     */
    public void setSzCdRsrcState(java.lang.String szCdRsrcState)
    {
        this._szCdRsrcState = szCdRsrcState;
    } //-- void setSzCdRsrcState(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcStatus_ARRAY'.
     * 
     * @param szCdRsrcStatus_ARRAY the value of field
     * 'szCdRsrcStatus_ARRAY'.
     */
    public void setSzCdRsrcStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY szCdRsrcStatus_ARRAY)
    {
        this._szCdRsrcStatus_ARRAY = szCdRsrcStatus_ARRAY;
    } //-- void setSzCdRsrcStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcStatus_ARRAY) 

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
     * Sets the value of field 'ulIdResource'.
     * 
     * @param ulIdResource the value of field 'ulIdResource'.
     */
    public void setUlIdResource(int ulIdResource)
    {
        this._ulIdResource = ulIdResource;
        this._has_ulIdResource = true;
    } //-- void setUlIdResource(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI unmarshal(java.io.Reader) 

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
