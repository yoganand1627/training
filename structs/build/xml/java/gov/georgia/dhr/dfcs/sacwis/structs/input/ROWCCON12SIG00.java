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
 * Class ROWCCON12SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON12SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulAmtCnsvcEquip
     */
    private double _ulAmtCnsvcEquip;

    /**
     * keeps track of state for field: _ulAmtCnsvcEquip
     */
    private boolean _has_ulAmtCnsvcEquip;

    /**
     * Field _ulAmtCnsvcFrgBenft
     */
    private double _ulAmtCnsvcFrgBenft;

    /**
     * keeps track of state for field: _ulAmtCnsvcFrgBenft
     */
    private boolean _has_ulAmtCnsvcFrgBenft;

    /**
     * Field _ulAmtCnsvcOther
     */
    private double _ulAmtCnsvcOther;

    /**
     * keeps track of state for field: _ulAmtCnsvcOther
     */
    private boolean _has_ulAmtCnsvcOther;

    /**
     * Field _ulAmtCnsvcSalary
     */
    private double _ulAmtCnsvcSalary;

    /**
     * keeps track of state for field: _ulAmtCnsvcSalary
     */
    private boolean _has_ulAmtCnsvcSalary;

    /**
     * Field _ulAmtCnsvcSupply
     */
    private double _ulAmtCnsvcSupply;

    /**
     * keeps track of state for field: _ulAmtCnsvcSupply
     */
    private boolean _has_ulAmtCnsvcSupply;

    /**
     * Field _ulAmtCnsvcTravel
     */
    private double _ulAmtCnsvcTravel;

    /**
     * keeps track of state for field: _ulAmtCnsvcTravel
     */
    private boolean _has_ulAmtCnsvcTravel;

    /**
     * Field _ulAmtCnsvcUnitRate
     */
    private double _ulAmtCnsvcUnitRate;

    /**
     * keeps track of state for field: _ulAmtCnsvcUnitRate
     */
    private boolean _has_ulAmtCnsvcUnitRate;

    /**
     * Field _szCdCnsvcPaymentType
     */
    private java.lang.String _szCdCnsvcPaymentType;

    /**
     * Field _szCdCnsvcService
     */
    private java.lang.String _szCdCnsvcService;

    /**
     * Field _szNbrCnsvcUnitType
     */
    private java.lang.String _szNbrCnsvcUnitType;

    /**
     * Field _cIndCnsvcNewRow
     */
    private java.lang.String _cIndCnsvcNewRow;

    /**
     * Field _ulIdCnsvc
     */
    private int _ulIdCnsvc;

    /**
     * keeps track of state for field: _ulIdCnsvc
     */
    private boolean _has_ulIdCnsvc;

    /**
     * Field _ulNbrCnsvcFedMatch
     */
    private int _ulNbrCnsvcFedMatch;

    /**
     * keeps track of state for field: _ulNbrCnsvcFedMatch
     */
    private boolean _has_ulNbrCnsvcFedMatch;

    /**
     * Field _ulNbrCnsvcLineItem
     */
    private int _ulNbrCnsvcLineItem;

    /**
     * keeps track of state for field: _ulNbrCnsvcLineItem
     */
    private boolean _has_ulNbrCnsvcLineItem;

    /**
     * Field _ulNbrCnsvcLocalMatch
     */
    private int _ulNbrCnsvcLocalMatch;

    /**
     * keeps track of state for field: _ulNbrCnsvcLocalMatch
     */
    private boolean _has_ulNbrCnsvcLocalMatch;

    /**
     * Field _ulNbrCnsvcUnitRate
     */
    private double _ulNbrCnsvcUnitRate;

    /**
     * keeps track of state for field: _ulNbrCnsvcUnitRate
     */
    private boolean _has_ulNbrCnsvcUnitRate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON12SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlAmtCnsvcEquip()
    {
        this._has_ulAmtCnsvcEquip= false;
    } //-- void deleteUlAmtCnsvcEquip() 

    /**
     */
    public void deleteUlAmtCnsvcFrgBenft()
    {
        this._has_ulAmtCnsvcFrgBenft= false;
    } //-- void deleteUlAmtCnsvcFrgBenft() 

    /**
     */
    public void deleteUlAmtCnsvcOther()
    {
        this._has_ulAmtCnsvcOther= false;
    } //-- void deleteUlAmtCnsvcOther() 

    /**
     */
    public void deleteUlAmtCnsvcSalary()
    {
        this._has_ulAmtCnsvcSalary= false;
    } //-- void deleteUlAmtCnsvcSalary() 

    /**
     */
    public void deleteUlAmtCnsvcSupply()
    {
        this._has_ulAmtCnsvcSupply= false;
    } //-- void deleteUlAmtCnsvcSupply() 

    /**
     */
    public void deleteUlAmtCnsvcTravel()
    {
        this._has_ulAmtCnsvcTravel= false;
    } //-- void deleteUlAmtCnsvcTravel() 

    /**
     */
    public void deleteUlAmtCnsvcUnitRate()
    {
        this._has_ulAmtCnsvcUnitRate= false;
    } //-- void deleteUlAmtCnsvcUnitRate() 

    /**
     */
    public void deleteUlIdCnsvc()
    {
        this._has_ulIdCnsvc= false;
    } //-- void deleteUlIdCnsvc() 

    /**
     */
    public void deleteUlNbrCnsvcFedMatch()
    {
        this._has_ulNbrCnsvcFedMatch= false;
    } //-- void deleteUlNbrCnsvcFedMatch() 

    /**
     */
    public void deleteUlNbrCnsvcLineItem()
    {
        this._has_ulNbrCnsvcLineItem= false;
    } //-- void deleteUlNbrCnsvcLineItem() 

    /**
     */
    public void deleteUlNbrCnsvcLocalMatch()
    {
        this._has_ulNbrCnsvcLocalMatch= false;
    } //-- void deleteUlNbrCnsvcLocalMatch() 

    /**
     */
    public void deleteUlNbrCnsvcUnitRate()
    {
        this._has_ulNbrCnsvcUnitRate= false;
    } //-- void deleteUlNbrCnsvcUnitRate() 

    /**
     * Returns the value of field 'cIndCnsvcNewRow'.
     * 
     * @return the value of field 'CIndCnsvcNewRow'.
     */
    public java.lang.String getCIndCnsvcNewRow()
    {
        return this._cIndCnsvcNewRow;
    } //-- java.lang.String getCIndCnsvcNewRow() 

    /**
     * Returns the value of field 'szCdCnsvcPaymentType'.
     * 
     * @return the value of field 'SzCdCnsvcPaymentType'.
     */
    public java.lang.String getSzCdCnsvcPaymentType()
    {
        return this._szCdCnsvcPaymentType;
    } //-- java.lang.String getSzCdCnsvcPaymentType() 

    /**
     * Returns the value of field 'szCdCnsvcService'.
     * 
     * @return the value of field 'SzCdCnsvcService'.
     */
    public java.lang.String getSzCdCnsvcService()
    {
        return this._szCdCnsvcService;
    } //-- java.lang.String getSzCdCnsvcService() 

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
     * Returns the value of field 'szNbrCnsvcUnitType'.
     * 
     * @return the value of field 'SzNbrCnsvcUnitType'.
     */
    public java.lang.String getSzNbrCnsvcUnitType()
    {
        return this._szNbrCnsvcUnitType;
    } //-- java.lang.String getSzNbrCnsvcUnitType() 

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
     * Returns the value of field 'ulAmtCnsvcEquip'.
     * 
     * @return the value of field 'UlAmtCnsvcEquip'.
     */
    public double getUlAmtCnsvcEquip()
    {
        return this._ulAmtCnsvcEquip;
    } //-- double getUlAmtCnsvcEquip() 

    /**
     * Returns the value of field 'ulAmtCnsvcFrgBenft'.
     * 
     * @return the value of field 'UlAmtCnsvcFrgBenft'.
     */
    public double getUlAmtCnsvcFrgBenft()
    {
        return this._ulAmtCnsvcFrgBenft;
    } //-- double getUlAmtCnsvcFrgBenft() 

    /**
     * Returns the value of field 'ulAmtCnsvcOther'.
     * 
     * @return the value of field 'UlAmtCnsvcOther'.
     */
    public double getUlAmtCnsvcOther()
    {
        return this._ulAmtCnsvcOther;
    } //-- double getUlAmtCnsvcOther() 

    /**
     * Returns the value of field 'ulAmtCnsvcSalary'.
     * 
     * @return the value of field 'UlAmtCnsvcSalary'.
     */
    public double getUlAmtCnsvcSalary()
    {
        return this._ulAmtCnsvcSalary;
    } //-- double getUlAmtCnsvcSalary() 

    /**
     * Returns the value of field 'ulAmtCnsvcSupply'.
     * 
     * @return the value of field 'UlAmtCnsvcSupply'.
     */
    public double getUlAmtCnsvcSupply()
    {
        return this._ulAmtCnsvcSupply;
    } //-- double getUlAmtCnsvcSupply() 

    /**
     * Returns the value of field 'ulAmtCnsvcTravel'.
     * 
     * @return the value of field 'UlAmtCnsvcTravel'.
     */
    public double getUlAmtCnsvcTravel()
    {
        return this._ulAmtCnsvcTravel;
    } //-- double getUlAmtCnsvcTravel() 

    /**
     * Returns the value of field 'ulAmtCnsvcUnitRate'.
     * 
     * @return the value of field 'UlAmtCnsvcUnitRate'.
     */
    public double getUlAmtCnsvcUnitRate()
    {
        return this._ulAmtCnsvcUnitRate;
    } //-- double getUlAmtCnsvcUnitRate() 

    /**
     * Returns the value of field 'ulIdCnsvc'.
     * 
     * @return the value of field 'UlIdCnsvc'.
     */
    public int getUlIdCnsvc()
    {
        return this._ulIdCnsvc;
    } //-- int getUlIdCnsvc() 

    /**
     * Returns the value of field 'ulNbrCnsvcFedMatch'.
     * 
     * @return the value of field 'UlNbrCnsvcFedMatch'.
     */
    public int getUlNbrCnsvcFedMatch()
    {
        return this._ulNbrCnsvcFedMatch;
    } //-- int getUlNbrCnsvcFedMatch() 

    /**
     * Returns the value of field 'ulNbrCnsvcLineItem'.
     * 
     * @return the value of field 'UlNbrCnsvcLineItem'.
     */
    public int getUlNbrCnsvcLineItem()
    {
        return this._ulNbrCnsvcLineItem;
    } //-- int getUlNbrCnsvcLineItem() 

    /**
     * Returns the value of field 'ulNbrCnsvcLocalMatch'.
     * 
     * @return the value of field 'UlNbrCnsvcLocalMatch'.
     */
    public int getUlNbrCnsvcLocalMatch()
    {
        return this._ulNbrCnsvcLocalMatch;
    } //-- int getUlNbrCnsvcLocalMatch() 

    /**
     * Returns the value of field 'ulNbrCnsvcUnitRate'.
     * 
     * @return the value of field 'UlNbrCnsvcUnitRate'.
     */
    public double getUlNbrCnsvcUnitRate()
    {
        return this._ulNbrCnsvcUnitRate;
    } //-- double getUlNbrCnsvcUnitRate() 

    /**
     * Method hasUlAmtCnsvcEquip
     * 
     * 
     * 
     * @return true if at least one UlAmtCnsvcEquip has been added
     */
    public boolean hasUlAmtCnsvcEquip()
    {
        return this._has_ulAmtCnsvcEquip;
    } //-- boolean hasUlAmtCnsvcEquip() 

    /**
     * Method hasUlAmtCnsvcFrgBenft
     * 
     * 
     * 
     * @return true if at least one UlAmtCnsvcFrgBenft has been adde
     */
    public boolean hasUlAmtCnsvcFrgBenft()
    {
        return this._has_ulAmtCnsvcFrgBenft;
    } //-- boolean hasUlAmtCnsvcFrgBenft() 

    /**
     * Method hasUlAmtCnsvcOther
     * 
     * 
     * 
     * @return true if at least one UlAmtCnsvcOther has been added
     */
    public boolean hasUlAmtCnsvcOther()
    {
        return this._has_ulAmtCnsvcOther;
    } //-- boolean hasUlAmtCnsvcOther() 

    /**
     * Method hasUlAmtCnsvcSalary
     * 
     * 
     * 
     * @return true if at least one UlAmtCnsvcSalary has been added
     */
    public boolean hasUlAmtCnsvcSalary()
    {
        return this._has_ulAmtCnsvcSalary;
    } //-- boolean hasUlAmtCnsvcSalary() 

    /**
     * Method hasUlAmtCnsvcSupply
     * 
     * 
     * 
     * @return true if at least one UlAmtCnsvcSupply has been added
     */
    public boolean hasUlAmtCnsvcSupply()
    {
        return this._has_ulAmtCnsvcSupply;
    } //-- boolean hasUlAmtCnsvcSupply() 

    /**
     * Method hasUlAmtCnsvcTravel
     * 
     * 
     * 
     * @return true if at least one UlAmtCnsvcTravel has been added
     */
    public boolean hasUlAmtCnsvcTravel()
    {
        return this._has_ulAmtCnsvcTravel;
    } //-- boolean hasUlAmtCnsvcTravel() 

    /**
     * Method hasUlAmtCnsvcUnitRate
     * 
     * 
     * 
     * @return true if at least one UlAmtCnsvcUnitRate has been adde
     */
    public boolean hasUlAmtCnsvcUnitRate()
    {
        return this._has_ulAmtCnsvcUnitRate;
    } //-- boolean hasUlAmtCnsvcUnitRate() 

    /**
     * Method hasUlIdCnsvc
     * 
     * 
     * 
     * @return true if at least one UlIdCnsvc has been added
     */
    public boolean hasUlIdCnsvc()
    {
        return this._has_ulIdCnsvc;
    } //-- boolean hasUlIdCnsvc() 

    /**
     * Method hasUlNbrCnsvcFedMatch
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcFedMatch has been adde
     */
    public boolean hasUlNbrCnsvcFedMatch()
    {
        return this._has_ulNbrCnsvcFedMatch;
    } //-- boolean hasUlNbrCnsvcFedMatch() 

    /**
     * Method hasUlNbrCnsvcLineItem
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcLineItem has been adde
     */
    public boolean hasUlNbrCnsvcLineItem()
    {
        return this._has_ulNbrCnsvcLineItem;
    } //-- boolean hasUlNbrCnsvcLineItem() 

    /**
     * Method hasUlNbrCnsvcLocalMatch
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcLocalMatch has been
     * added
     */
    public boolean hasUlNbrCnsvcLocalMatch()
    {
        return this._has_ulNbrCnsvcLocalMatch;
    } //-- boolean hasUlNbrCnsvcLocalMatch() 

    /**
     * Method hasUlNbrCnsvcUnitRate
     * 
     * 
     * 
     * @return true if at least one UlNbrCnsvcUnitRate has been adde
     */
    public boolean hasUlNbrCnsvcUnitRate()
    {
        return this._has_ulNbrCnsvcUnitRate;
    } //-- boolean hasUlNbrCnsvcUnitRate() 

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
     * Sets the value of field 'cIndCnsvcNewRow'.
     * 
     * @param cIndCnsvcNewRow the value of field 'cIndCnsvcNewRow'.
     */
    public void setCIndCnsvcNewRow(java.lang.String cIndCnsvcNewRow)
    {
        this._cIndCnsvcNewRow = cIndCnsvcNewRow;
    } //-- void setCIndCnsvcNewRow(java.lang.String) 

    /**
     * Sets the value of field 'szCdCnsvcPaymentType'.
     * 
     * @param szCdCnsvcPaymentType the value of field
     * 'szCdCnsvcPaymentType'.
     */
    public void setSzCdCnsvcPaymentType(java.lang.String szCdCnsvcPaymentType)
    {
        this._szCdCnsvcPaymentType = szCdCnsvcPaymentType;
    } //-- void setSzCdCnsvcPaymentType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCnsvcService'.
     * 
     * @param szCdCnsvcService the value of field 'szCdCnsvcService'
     */
    public void setSzCdCnsvcService(java.lang.String szCdCnsvcService)
    {
        this._szCdCnsvcService = szCdCnsvcService;
    } //-- void setSzCdCnsvcService(java.lang.String) 

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
     * Sets the value of field 'szNbrCnsvcUnitType'.
     * 
     * @param szNbrCnsvcUnitType the value of field
     * 'szNbrCnsvcUnitType'.
     */
    public void setSzNbrCnsvcUnitType(java.lang.String szNbrCnsvcUnitType)
    {
        this._szNbrCnsvcUnitType = szNbrCnsvcUnitType;
    } //-- void setSzNbrCnsvcUnitType(java.lang.String) 

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
     * Sets the value of field 'ulAmtCnsvcEquip'.
     * 
     * @param ulAmtCnsvcEquip the value of field 'ulAmtCnsvcEquip'.
     */
    public void setUlAmtCnsvcEquip(double ulAmtCnsvcEquip)
    {
        this._ulAmtCnsvcEquip = ulAmtCnsvcEquip;
        this._has_ulAmtCnsvcEquip = true;
    } //-- void setUlAmtCnsvcEquip(double) 

    /**
     * Sets the value of field 'ulAmtCnsvcFrgBenft'.
     * 
     * @param ulAmtCnsvcFrgBenft the value of field
     * 'ulAmtCnsvcFrgBenft'.
     */
    public void setUlAmtCnsvcFrgBenft(double ulAmtCnsvcFrgBenft)
    {
        this._ulAmtCnsvcFrgBenft = ulAmtCnsvcFrgBenft;
        this._has_ulAmtCnsvcFrgBenft = true;
    } //-- void setUlAmtCnsvcFrgBenft(double) 

    /**
     * Sets the value of field 'ulAmtCnsvcOther'.
     * 
     * @param ulAmtCnsvcOther the value of field 'ulAmtCnsvcOther'.
     */
    public void setUlAmtCnsvcOther(double ulAmtCnsvcOther)
    {
        this._ulAmtCnsvcOther = ulAmtCnsvcOther;
        this._has_ulAmtCnsvcOther = true;
    } //-- void setUlAmtCnsvcOther(double) 

    /**
     * Sets the value of field 'ulAmtCnsvcSalary'.
     * 
     * @param ulAmtCnsvcSalary the value of field 'ulAmtCnsvcSalary'
     */
    public void setUlAmtCnsvcSalary(double ulAmtCnsvcSalary)
    {
        this._ulAmtCnsvcSalary = ulAmtCnsvcSalary;
        this._has_ulAmtCnsvcSalary = true;
    } //-- void setUlAmtCnsvcSalary(double) 

    /**
     * Sets the value of field 'ulAmtCnsvcSupply'.
     * 
     * @param ulAmtCnsvcSupply the value of field 'ulAmtCnsvcSupply'
     */
    public void setUlAmtCnsvcSupply(double ulAmtCnsvcSupply)
    {
        this._ulAmtCnsvcSupply = ulAmtCnsvcSupply;
        this._has_ulAmtCnsvcSupply = true;
    } //-- void setUlAmtCnsvcSupply(double) 

    /**
     * Sets the value of field 'ulAmtCnsvcTravel'.
     * 
     * @param ulAmtCnsvcTravel the value of field 'ulAmtCnsvcTravel'
     */
    public void setUlAmtCnsvcTravel(double ulAmtCnsvcTravel)
    {
        this._ulAmtCnsvcTravel = ulAmtCnsvcTravel;
        this._has_ulAmtCnsvcTravel = true;
    } //-- void setUlAmtCnsvcTravel(double) 

    /**
     * Sets the value of field 'ulAmtCnsvcUnitRate'.
     * 
     * @param ulAmtCnsvcUnitRate the value of field
     * 'ulAmtCnsvcUnitRate'.
     */
    public void setUlAmtCnsvcUnitRate(double ulAmtCnsvcUnitRate)
    {
        this._ulAmtCnsvcUnitRate = ulAmtCnsvcUnitRate;
        this._has_ulAmtCnsvcUnitRate = true;
    } //-- void setUlAmtCnsvcUnitRate(double) 

    /**
     * Sets the value of field 'ulIdCnsvc'.
     * 
     * @param ulIdCnsvc the value of field 'ulIdCnsvc'.
     */
    public void setUlIdCnsvc(int ulIdCnsvc)
    {
        this._ulIdCnsvc = ulIdCnsvc;
        this._has_ulIdCnsvc = true;
    } //-- void setUlIdCnsvc(int) 

    /**
     * Sets the value of field 'ulNbrCnsvcFedMatch'.
     * 
     * @param ulNbrCnsvcFedMatch the value of field
     * 'ulNbrCnsvcFedMatch'.
     */
    public void setUlNbrCnsvcFedMatch(int ulNbrCnsvcFedMatch)
    {
        this._ulNbrCnsvcFedMatch = ulNbrCnsvcFedMatch;
        this._has_ulNbrCnsvcFedMatch = true;
    } //-- void setUlNbrCnsvcFedMatch(int) 

    /**
     * Sets the value of field 'ulNbrCnsvcLineItem'.
     * 
     * @param ulNbrCnsvcLineItem the value of field
     * 'ulNbrCnsvcLineItem'.
     */
    public void setUlNbrCnsvcLineItem(int ulNbrCnsvcLineItem)
    {
        this._ulNbrCnsvcLineItem = ulNbrCnsvcLineItem;
        this._has_ulNbrCnsvcLineItem = true;
    } //-- void setUlNbrCnsvcLineItem(int) 

    /**
     * Sets the value of field 'ulNbrCnsvcLocalMatch'.
     * 
     * @param ulNbrCnsvcLocalMatch the value of field
     * 'ulNbrCnsvcLocalMatch'.
     */
    public void setUlNbrCnsvcLocalMatch(int ulNbrCnsvcLocalMatch)
    {
        this._ulNbrCnsvcLocalMatch = ulNbrCnsvcLocalMatch;
        this._has_ulNbrCnsvcLocalMatch = true;
    } //-- void setUlNbrCnsvcLocalMatch(int) 

    /**
     * Sets the value of field 'ulNbrCnsvcUnitRate'.
     * 
     * @param ulNbrCnsvcUnitRate the value of field
     * 'ulNbrCnsvcUnitRate'.
     */
    public void setUlNbrCnsvcUnitRate(double ulNbrCnsvcUnitRate)
    {
        this._ulNbrCnsvcUnitRate = ulNbrCnsvcUnitRate;
        this._has_ulNbrCnsvcUnitRate = true;
    } //-- void setUlNbrCnsvcUnitRate(double) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00 unmarshal(java.io.Reader) 

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
