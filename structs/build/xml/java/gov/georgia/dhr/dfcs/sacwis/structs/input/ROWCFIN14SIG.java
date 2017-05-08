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
 * Class ROWCFIN14SIG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN14SIG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _usNbrCostReimCsli
     */
    private int _usNbrCostReimCsli;

    /**
     * keeps track of state for field: _usNbrCostReimCsli
     */
    private boolean _has_usNbrCostReimCsli;

    /**
     * Field _cIndCostReimRejItm
     */
    private java.lang.String _cIndCostReimRejItm;

    /**
     * Field _uNbrCostReimUnitQty
     */
    private double _uNbrCostReimUnitQty;

    /**
     * keeps track of state for field: _uNbrCostReimUnitQty
     */
    private boolean _has_uNbrCostReimUnitQty;

    /**
     * Field _szCdCostReimLiType
     */
    private java.lang.String _szCdCostReimLiType;

    /**
     * Field _dScrAmtCostReimCmpUrt
     */
    private double _dScrAmtCostReimCmpUrt;

    /**
     * keeps track of state for field: _dScrAmtCostReimCmpUrt
     */
    private boolean _has_dScrAmtCostReimCmpUrt;

    /**
     * Field _szCdCostReimService
     */
    private java.lang.String _szCdCostReimService;

    /**
     * Field _dAmtCostReimAdminAll
     */
    private double _dAmtCostReimAdminAll;

    /**
     * keeps track of state for field: _dAmtCostReimAdminAll
     */
    private boolean _has_dAmtCostReimAdminAll;

    /**
     * Field _dAmtCostReimEquip
     */
    private double _dAmtCostReimEquip;

    /**
     * keeps track of state for field: _dAmtCostReimEquip
     */
    private boolean _has_dAmtCostReimEquip;

    /**
     * Field _dAmtCostReimFrgBenft
     */
    private double _dAmtCostReimFrgBenft;

    /**
     * keeps track of state for field: _dAmtCostReimFrgBenft
     */
    private boolean _has_dAmtCostReimFrgBenft;

    /**
     * Field _dAmtCostReimOffItem
     */
    private double _dAmtCostReimOffItem;

    /**
     * keeps track of state for field: _dAmtCostReimOffItem
     */
    private boolean _has_dAmtCostReimOffItem;

    /**
     * Field _dAmtCostReimDtlOther
     */
    private double _dAmtCostReimDtlOther;

    /**
     * keeps track of state for field: _dAmtCostReimDtlOther
     */
    private boolean _has_dAmtCostReimDtlOther;

    /**
     * Field _dAmtCostReimSalary
     */
    private double _dAmtCostReimSalary;

    /**
     * keeps track of state for field: _dAmtCostReimSalary
     */
    private boolean _has_dAmtCostReimSalary;

    /**
     * Field _dAmtCostReimSupply
     */
    private double _dAmtCostReimSupply;

    /**
     * keeps track of state for field: _dAmtCostReimSupply
     */
    private boolean _has_dAmtCostReimSupply;

    /**
     * Field _dAmtCostReimTravel
     */
    private double _dAmtCostReimTravel;

    /**
     * keeps track of state for field: _dAmtCostReimTravel
     */
    private boolean _has_dAmtCostReimTravel;

    /**
     * Field _szCdCostReimInvoDisptn
     */
    private java.lang.String _szCdCostReimInvoDisptn;

    /**
     * Field _ulIdCostReim
     */
    private int _ulIdCostReim;

    /**
     * keeps track of state for field: _ulIdCostReim
     */
    private boolean _has_ulIdCostReim;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN14SIG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteDAmtCostReimAdminAll()
    {
        this._has_dAmtCostReimAdminAll= false;
    } //-- void deleteDAmtCostReimAdminAll() 

    /**
     */
    public void deleteDAmtCostReimDtlOther()
    {
        this._has_dAmtCostReimDtlOther= false;
    } //-- void deleteDAmtCostReimDtlOther() 

    /**
     */
    public void deleteDAmtCostReimEquip()
    {
        this._has_dAmtCostReimEquip= false;
    } //-- void deleteDAmtCostReimEquip() 

    /**
     */
    public void deleteDAmtCostReimFrgBenft()
    {
        this._has_dAmtCostReimFrgBenft= false;
    } //-- void deleteDAmtCostReimFrgBenft() 

    /**
     */
    public void deleteDAmtCostReimOffItem()
    {
        this._has_dAmtCostReimOffItem= false;
    } //-- void deleteDAmtCostReimOffItem() 

    /**
     */
    public void deleteDAmtCostReimSalary()
    {
        this._has_dAmtCostReimSalary= false;
    } //-- void deleteDAmtCostReimSalary() 

    /**
     */
    public void deleteDAmtCostReimSupply()
    {
        this._has_dAmtCostReimSupply= false;
    } //-- void deleteDAmtCostReimSupply() 

    /**
     */
    public void deleteDAmtCostReimTravel()
    {
        this._has_dAmtCostReimTravel= false;
    } //-- void deleteDAmtCostReimTravel() 

    /**
     */
    public void deleteDScrAmtCostReimCmpUrt()
    {
        this._has_dScrAmtCostReimCmpUrt= false;
    } //-- void deleteDScrAmtCostReimCmpUrt() 

    /**
     */
    public void deleteUNbrCostReimUnitQty()
    {
        this._has_uNbrCostReimUnitQty= false;
    } //-- void deleteUNbrCostReimUnitQty() 

    /**
     */
    public void deleteUlIdCostReim()
    {
        this._has_ulIdCostReim= false;
    } //-- void deleteUlIdCostReim() 

    /**
     */
    public void deleteUsNbrCostReimCsli()
    {
        this._has_usNbrCostReimCsli= false;
    } //-- void deleteUsNbrCostReimCsli() 

    /**
     * Returns the value of field 'cIndCostReimRejItm'.
     * 
     * @return the value of field 'CIndCostReimRejItm'.
     */
    public java.lang.String getCIndCostReimRejItm()
    {
        return this._cIndCostReimRejItm;
    } //-- java.lang.String getCIndCostReimRejItm() 

    /**
     * Returns the value of field 'dAmtCostReimAdminAll'.
     * 
     * @return the value of field 'DAmtCostReimAdminAll'.
     */
    public double getDAmtCostReimAdminAll()
    {
        return this._dAmtCostReimAdminAll;
    } //-- double getDAmtCostReimAdminAll() 

    /**
     * Returns the value of field 'dAmtCostReimDtlOther'.
     * 
     * @return the value of field 'DAmtCostReimDtlOther'.
     */
    public double getDAmtCostReimDtlOther()
    {
        return this._dAmtCostReimDtlOther;
    } //-- double getDAmtCostReimDtlOther() 

    /**
     * Returns the value of field 'dAmtCostReimEquip'.
     * 
     * @return the value of field 'DAmtCostReimEquip'.
     */
    public double getDAmtCostReimEquip()
    {
        return this._dAmtCostReimEquip;
    } //-- double getDAmtCostReimEquip() 

    /**
     * Returns the value of field 'dAmtCostReimFrgBenft'.
     * 
     * @return the value of field 'DAmtCostReimFrgBenft'.
     */
    public double getDAmtCostReimFrgBenft()
    {
        return this._dAmtCostReimFrgBenft;
    } //-- double getDAmtCostReimFrgBenft() 

    /**
     * Returns the value of field 'dAmtCostReimOffItem'.
     * 
     * @return the value of field 'DAmtCostReimOffItem'.
     */
    public double getDAmtCostReimOffItem()
    {
        return this._dAmtCostReimOffItem;
    } //-- double getDAmtCostReimOffItem() 

    /**
     * Returns the value of field 'dAmtCostReimSalary'.
     * 
     * @return the value of field 'DAmtCostReimSalary'.
     */
    public double getDAmtCostReimSalary()
    {
        return this._dAmtCostReimSalary;
    } //-- double getDAmtCostReimSalary() 

    /**
     * Returns the value of field 'dAmtCostReimSupply'.
     * 
     * @return the value of field 'DAmtCostReimSupply'.
     */
    public double getDAmtCostReimSupply()
    {
        return this._dAmtCostReimSupply;
    } //-- double getDAmtCostReimSupply() 

    /**
     * Returns the value of field 'dAmtCostReimTravel'.
     * 
     * @return the value of field 'DAmtCostReimTravel'.
     */
    public double getDAmtCostReimTravel()
    {
        return this._dAmtCostReimTravel;
    } //-- double getDAmtCostReimTravel() 

    /**
     * Returns the value of field 'dScrAmtCostReimCmpUrt'.
     * 
     * @return the value of field 'DScrAmtCostReimCmpUrt'.
     */
    public double getDScrAmtCostReimCmpUrt()
    {
        return this._dScrAmtCostReimCmpUrt;
    } //-- double getDScrAmtCostReimCmpUrt() 

    /**
     * Returns the value of field 'szCdCostReimInvoDisptn'.
     * 
     * @return the value of field 'SzCdCostReimInvoDisptn'.
     */
    public java.lang.String getSzCdCostReimInvoDisptn()
    {
        return this._szCdCostReimInvoDisptn;
    } //-- java.lang.String getSzCdCostReimInvoDisptn() 

    /**
     * Returns the value of field 'szCdCostReimLiType'.
     * 
     * @return the value of field 'SzCdCostReimLiType'.
     */
    public java.lang.String getSzCdCostReimLiType()
    {
        return this._szCdCostReimLiType;
    } //-- java.lang.String getSzCdCostReimLiType() 

    /**
     * Returns the value of field 'szCdCostReimService'.
     * 
     * @return the value of field 'SzCdCostReimService'.
     */
    public java.lang.String getSzCdCostReimService()
    {
        return this._szCdCostReimService;
    } //-- java.lang.String getSzCdCostReimService() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

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
     * Returns the value of field 'uNbrCostReimUnitQty'.
     * 
     * @return the value of field 'UNbrCostReimUnitQty'.
     */
    public double getUNbrCostReimUnitQty()
    {
        return this._uNbrCostReimUnitQty;
    } //-- double getUNbrCostReimUnitQty() 

    /**
     * Returns the value of field 'ulIdCostReim'.
     * 
     * @return the value of field 'UlIdCostReim'.
     */
    public int getUlIdCostReim()
    {
        return this._ulIdCostReim;
    } //-- int getUlIdCostReim() 

    /**
     * Returns the value of field 'usNbrCostReimCsli'.
     * 
     * @return the value of field 'UsNbrCostReimCsli'.
     */
    public int getUsNbrCostReimCsli()
    {
        return this._usNbrCostReimCsli;
    } //-- int getUsNbrCostReimCsli() 

    /**
     * Method hasDAmtCostReimAdminAll
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimAdminAll has been
     * added
     */
    public boolean hasDAmtCostReimAdminAll()
    {
        return this._has_dAmtCostReimAdminAll;
    } //-- boolean hasDAmtCostReimAdminAll() 

    /**
     * Method hasDAmtCostReimDtlOther
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimDtlOther has been
     * added
     */
    public boolean hasDAmtCostReimDtlOther()
    {
        return this._has_dAmtCostReimDtlOther;
    } //-- boolean hasDAmtCostReimDtlOther() 

    /**
     * Method hasDAmtCostReimEquip
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimEquip has been added
     */
    public boolean hasDAmtCostReimEquip()
    {
        return this._has_dAmtCostReimEquip;
    } //-- boolean hasDAmtCostReimEquip() 

    /**
     * Method hasDAmtCostReimFrgBenft
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimFrgBenft has been
     * added
     */
    public boolean hasDAmtCostReimFrgBenft()
    {
        return this._has_dAmtCostReimFrgBenft;
    } //-- boolean hasDAmtCostReimFrgBenft() 

    /**
     * Method hasDAmtCostReimOffItem
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimOffItem has been
     * added
     */
    public boolean hasDAmtCostReimOffItem()
    {
        return this._has_dAmtCostReimOffItem;
    } //-- boolean hasDAmtCostReimOffItem() 

    /**
     * Method hasDAmtCostReimSalary
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimSalary has been adde
     */
    public boolean hasDAmtCostReimSalary()
    {
        return this._has_dAmtCostReimSalary;
    } //-- boolean hasDAmtCostReimSalary() 

    /**
     * Method hasDAmtCostReimSupply
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimSupply has been adde
     */
    public boolean hasDAmtCostReimSupply()
    {
        return this._has_dAmtCostReimSupply;
    } //-- boolean hasDAmtCostReimSupply() 

    /**
     * Method hasDAmtCostReimTravel
     * 
     * 
     * 
     * @return true if at least one DAmtCostReimTravel has been adde
     */
    public boolean hasDAmtCostReimTravel()
    {
        return this._has_dAmtCostReimTravel;
    } //-- boolean hasDAmtCostReimTravel() 

    /**
     * Method hasDScrAmtCostReimCmpUrt
     * 
     * 
     * 
     * @return true if at least one DScrAmtCostReimCmpUrt has been
     * added
     */
    public boolean hasDScrAmtCostReimCmpUrt()
    {
        return this._has_dScrAmtCostReimCmpUrt;
    } //-- boolean hasDScrAmtCostReimCmpUrt() 

    /**
     * Method hasUNbrCostReimUnitQty
     * 
     * 
     * 
     * @return true if at least one UNbrCostReimUnitQty has been
     * added
     */
    public boolean hasUNbrCostReimUnitQty()
    {
        return this._has_uNbrCostReimUnitQty;
    } //-- boolean hasUNbrCostReimUnitQty() 

    /**
     * Method hasUlIdCostReim
     * 
     * 
     * 
     * @return true if at least one UlIdCostReim has been added
     */
    public boolean hasUlIdCostReim()
    {
        return this._has_ulIdCostReim;
    } //-- boolean hasUlIdCostReim() 

    /**
     * Method hasUsNbrCostReimCsli
     * 
     * 
     * 
     * @return true if at least one UsNbrCostReimCsli has been added
     */
    public boolean hasUsNbrCostReimCsli()
    {
        return this._has_usNbrCostReimCsli;
    } //-- boolean hasUsNbrCostReimCsli() 

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
     * Sets the value of field 'cIndCostReimRejItm'.
     * 
     * @param cIndCostReimRejItm the value of field
     * 'cIndCostReimRejItm'.
     */
    public void setCIndCostReimRejItm(java.lang.String cIndCostReimRejItm)
    {
        this._cIndCostReimRejItm = cIndCostReimRejItm;
    } //-- void setCIndCostReimRejItm(java.lang.String) 

    /**
     * Sets the value of field 'dAmtCostReimAdminAll'.
     * 
     * @param dAmtCostReimAdminAll the value of field
     * 'dAmtCostReimAdminAll'.
     */
    public void setDAmtCostReimAdminAll(double dAmtCostReimAdminAll)
    {
        this._dAmtCostReimAdminAll = dAmtCostReimAdminAll;
        this._has_dAmtCostReimAdminAll = true;
    } //-- void setDAmtCostReimAdminAll(double) 

    /**
     * Sets the value of field 'dAmtCostReimDtlOther'.
     * 
     * @param dAmtCostReimDtlOther the value of field
     * 'dAmtCostReimDtlOther'.
     */
    public void setDAmtCostReimDtlOther(double dAmtCostReimDtlOther)
    {
        this._dAmtCostReimDtlOther = dAmtCostReimDtlOther;
        this._has_dAmtCostReimDtlOther = true;
    } //-- void setDAmtCostReimDtlOther(double) 

    /**
     * Sets the value of field 'dAmtCostReimEquip'.
     * 
     * @param dAmtCostReimEquip the value of field
     * 'dAmtCostReimEquip'.
     */
    public void setDAmtCostReimEquip(double dAmtCostReimEquip)
    {
        this._dAmtCostReimEquip = dAmtCostReimEquip;
        this._has_dAmtCostReimEquip = true;
    } //-- void setDAmtCostReimEquip(double) 

    /**
     * Sets the value of field 'dAmtCostReimFrgBenft'.
     * 
     * @param dAmtCostReimFrgBenft the value of field
     * 'dAmtCostReimFrgBenft'.
     */
    public void setDAmtCostReimFrgBenft(double dAmtCostReimFrgBenft)
    {
        this._dAmtCostReimFrgBenft = dAmtCostReimFrgBenft;
        this._has_dAmtCostReimFrgBenft = true;
    } //-- void setDAmtCostReimFrgBenft(double) 

    /**
     * Sets the value of field 'dAmtCostReimOffItem'.
     * 
     * @param dAmtCostReimOffItem the value of field
     * 'dAmtCostReimOffItem'.
     */
    public void setDAmtCostReimOffItem(double dAmtCostReimOffItem)
    {
        this._dAmtCostReimOffItem = dAmtCostReimOffItem;
        this._has_dAmtCostReimOffItem = true;
    } //-- void setDAmtCostReimOffItem(double) 

    /**
     * Sets the value of field 'dAmtCostReimSalary'.
     * 
     * @param dAmtCostReimSalary the value of field
     * 'dAmtCostReimSalary'.
     */
    public void setDAmtCostReimSalary(double dAmtCostReimSalary)
    {
        this._dAmtCostReimSalary = dAmtCostReimSalary;
        this._has_dAmtCostReimSalary = true;
    } //-- void setDAmtCostReimSalary(double) 

    /**
     * Sets the value of field 'dAmtCostReimSupply'.
     * 
     * @param dAmtCostReimSupply the value of field
     * 'dAmtCostReimSupply'.
     */
    public void setDAmtCostReimSupply(double dAmtCostReimSupply)
    {
        this._dAmtCostReimSupply = dAmtCostReimSupply;
        this._has_dAmtCostReimSupply = true;
    } //-- void setDAmtCostReimSupply(double) 

    /**
     * Sets the value of field 'dAmtCostReimTravel'.
     * 
     * @param dAmtCostReimTravel the value of field
     * 'dAmtCostReimTravel'.
     */
    public void setDAmtCostReimTravel(double dAmtCostReimTravel)
    {
        this._dAmtCostReimTravel = dAmtCostReimTravel;
        this._has_dAmtCostReimTravel = true;
    } //-- void setDAmtCostReimTravel(double) 

    /**
     * Sets the value of field 'dScrAmtCostReimCmpUrt'.
     * 
     * @param dScrAmtCostReimCmpUrt the value of field
     * 'dScrAmtCostReimCmpUrt'.
     */
    public void setDScrAmtCostReimCmpUrt(double dScrAmtCostReimCmpUrt)
    {
        this._dScrAmtCostReimCmpUrt = dScrAmtCostReimCmpUrt;
        this._has_dScrAmtCostReimCmpUrt = true;
    } //-- void setDScrAmtCostReimCmpUrt(double) 

    /**
     * Sets the value of field 'szCdCostReimInvoDisptn'.
     * 
     * @param szCdCostReimInvoDisptn the value of field
     * 'szCdCostReimInvoDisptn'.
     */
    public void setSzCdCostReimInvoDisptn(java.lang.String szCdCostReimInvoDisptn)
    {
        this._szCdCostReimInvoDisptn = szCdCostReimInvoDisptn;
    } //-- void setSzCdCostReimInvoDisptn(java.lang.String) 

    /**
     * Sets the value of field 'szCdCostReimLiType'.
     * 
     * @param szCdCostReimLiType the value of field
     * 'szCdCostReimLiType'.
     */
    public void setSzCdCostReimLiType(java.lang.String szCdCostReimLiType)
    {
        this._szCdCostReimLiType = szCdCostReimLiType;
    } //-- void setSzCdCostReimLiType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCostReimService'.
     * 
     * @param szCdCostReimService the value of field
     * 'szCdCostReimService'.
     */
    public void setSzCdCostReimService(java.lang.String szCdCostReimService)
    {
        this._szCdCostReimService = szCdCostReimService;
    } //-- void setSzCdCostReimService(java.lang.String) 

    /**
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

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
     * Sets the value of field 'uNbrCostReimUnitQty'.
     * 
     * @param uNbrCostReimUnitQty the value of field
     * 'uNbrCostReimUnitQty'.
     */
    public void setUNbrCostReimUnitQty(double uNbrCostReimUnitQty)
    {
        this._uNbrCostReimUnitQty = uNbrCostReimUnitQty;
        this._has_uNbrCostReimUnitQty = true;
    } //-- void setUNbrCostReimUnitQty(double) 

    /**
     * Sets the value of field 'ulIdCostReim'.
     * 
     * @param ulIdCostReim the value of field 'ulIdCostReim'.
     */
    public void setUlIdCostReim(int ulIdCostReim)
    {
        this._ulIdCostReim = ulIdCostReim;
        this._has_ulIdCostReim = true;
    } //-- void setUlIdCostReim(int) 

    /**
     * Sets the value of field 'usNbrCostReimCsli'.
     * 
     * @param usNbrCostReimCsli the value of field
     * 'usNbrCostReimCsli'.
     */
    public void setUsNbrCostReimCsli(int usNbrCostReimCsli)
    {
        this._usNbrCostReimCsli = usNbrCostReimCsli;
        this._has_usNbrCostReimCsli = true;
    } //-- void setUsNbrCostReimCsli(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG unmarshal(java.io.Reader) 

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
