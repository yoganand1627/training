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
 * Class CSUB40UIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB40UIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szSysCdTodoCf
     */
    private java.lang.String _szSysCdTodoCf;

    /**
     * Field _dtSysDtTodoCfDueFrom
     */
    private org.exolab.castor.types.Date _dtSysDtTodoCfDueFrom;

    /**
     * Field _ulSysIdTodoCfEvent
     */
    private int _ulSysIdTodoCfEvent;

    /**
     * keeps track of state for field: _ulSysIdTodoCfEvent
     */
    private boolean _has_ulSysIdTodoCfEvent;

    /**
     * Field _ulSysIdTodoCfPersAssgn
     */
    private int _ulSysIdTodoCfPersAssgn;

    /**
     * keeps track of state for field: _ulSysIdTodoCfPersAssgn
     */
    private boolean _has_ulSysIdTodoCfPersAssgn;

    /**
     * Field _ulSysIdTodoCfPersCrea
     */
    private int _ulSysIdTodoCfPersCrea;

    /**
     * keeps track of state for field: _ulSysIdTodoCfPersCrea
     */
    private boolean _has_ulSysIdTodoCfPersCrea;

    /**
     * Field _ulSysIdTodoCfPersWkr
     */
    private int _ulSysIdTodoCfPersWkr;

    /**
     * keeps track of state for field: _ulSysIdTodoCfPersWkr
     */
    private boolean _has_ulSysIdTodoCfPersWkr;

    /**
     * Field _ulSysIdTodoCfStage
     */
    private int _ulSysIdTodoCfStage;

    /**
     * keeps track of state for field: _ulSysIdTodoCfStage
     */
    private boolean _has_ulSysIdTodoCfStage;

    /**
     * Field _szSysTxtTodoCfDesc
     */
    private java.lang.String _szSysTxtTodoCfDesc;

    /**
     * Field _szSysTxtTodoCfLongDesc
     */
    private java.lang.String _szSysTxtTodoCfLongDesc;

    /**
     * Field _lNbrRemovalAgeMo
     */
    private int _lNbrRemovalAgeMo;

    /**
     * keeps track of state for field: _lNbrRemovalAgeMo
     */
    private boolean _has_lNbrRemovalAgeMo;

    /**
     * Field _lNbrRemovalAgeYr
     */
    private int _lNbrRemovalAgeYr;

    /**
     * keeps track of state for field: _lNbrRemovalAgeYr
     */
    private boolean _has_lNbrRemovalAgeYr;

    /**
     * Field _dtDtRemoval
     */
    private org.exolab.castor.types.Date _dtDtRemoval;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB40UIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLNbrRemovalAgeMo()
    {
        this._has_lNbrRemovalAgeMo= false;
    } //-- void deleteLNbrRemovalAgeMo() 

    /**
     */
    public void deleteLNbrRemovalAgeYr()
    {
        this._has_lNbrRemovalAgeYr= false;
    } //-- void deleteLNbrRemovalAgeYr() 

    /**
     */
    public void deleteUlSysIdTodoCfEvent()
    {
        this._has_ulSysIdTodoCfEvent= false;
    } //-- void deleteUlSysIdTodoCfEvent() 

    /**
     */
    public void deleteUlSysIdTodoCfPersAssgn()
    {
        this._has_ulSysIdTodoCfPersAssgn= false;
    } //-- void deleteUlSysIdTodoCfPersAssgn() 

    /**
     */
    public void deleteUlSysIdTodoCfPersCrea()
    {
        this._has_ulSysIdTodoCfPersCrea= false;
    } //-- void deleteUlSysIdTodoCfPersCrea() 

    /**
     */
    public void deleteUlSysIdTodoCfPersWkr()
    {
        this._has_ulSysIdTodoCfPersWkr= false;
    } //-- void deleteUlSysIdTodoCfPersWkr() 

    /**
     */
    public void deleteUlSysIdTodoCfStage()
    {
        this._has_ulSysIdTodoCfStage= false;
    } //-- void deleteUlSysIdTodoCfStage() 

    /**
     * Returns the value of field 'dtDtRemoval'.
     * 
     * @return the value of field 'DtDtRemoval'.
     */
    public org.exolab.castor.types.Date getDtDtRemoval()
    {
        return this._dtDtRemoval;
    } //-- org.exolab.castor.types.Date getDtDtRemoval() 

    /**
     * Returns the value of field 'dtSysDtTodoCfDueFrom'.
     * 
     * @return the value of field 'DtSysDtTodoCfDueFrom'.
     */
    public org.exolab.castor.types.Date getDtSysDtTodoCfDueFrom()
    {
        return this._dtSysDtTodoCfDueFrom;
    } //-- org.exolab.castor.types.Date getDtSysDtTodoCfDueFrom() 

    /**
     * Returns the value of field 'lNbrRemovalAgeMo'.
     * 
     * @return the value of field 'LNbrRemovalAgeMo'.
     */
    public int getLNbrRemovalAgeMo()
    {
        return this._lNbrRemovalAgeMo;
    } //-- int getLNbrRemovalAgeMo() 

    /**
     * Returns the value of field 'lNbrRemovalAgeYr'.
     * 
     * @return the value of field 'LNbrRemovalAgeYr'.
     */
    public int getLNbrRemovalAgeYr()
    {
        return this._lNbrRemovalAgeYr;
    } //-- int getLNbrRemovalAgeYr() 

    /**
     * Returns the value of field 'szSysCdTodoCf'.
     * 
     * @return the value of field 'SzSysCdTodoCf'.
     */
    public java.lang.String getSzSysCdTodoCf()
    {
        return this._szSysCdTodoCf;
    } //-- java.lang.String getSzSysCdTodoCf() 

    /**
     * Returns the value of field 'szSysTxtTodoCfDesc'.
     * 
     * @return the value of field 'SzSysTxtTodoCfDesc'.
     */
    public java.lang.String getSzSysTxtTodoCfDesc()
    {
        return this._szSysTxtTodoCfDesc;
    } //-- java.lang.String getSzSysTxtTodoCfDesc() 

    /**
     * Returns the value of field 'szSysTxtTodoCfLongDesc'.
     * 
     * @return the value of field 'SzSysTxtTodoCfLongDesc'.
     */
    public java.lang.String getSzSysTxtTodoCfLongDesc()
    {
        return this._szSysTxtTodoCfLongDesc;
    } //-- java.lang.String getSzSysTxtTodoCfLongDesc() 

    /**
     * Returns the value of field 'ulSysIdTodoCfEvent'.
     * 
     * @return the value of field 'UlSysIdTodoCfEvent'.
     */
    public int getUlSysIdTodoCfEvent()
    {
        return this._ulSysIdTodoCfEvent;
    } //-- int getUlSysIdTodoCfEvent() 

    /**
     * Returns the value of field 'ulSysIdTodoCfPersAssgn'.
     * 
     * @return the value of field 'UlSysIdTodoCfPersAssgn'.
     */
    public int getUlSysIdTodoCfPersAssgn()
    {
        return this._ulSysIdTodoCfPersAssgn;
    } //-- int getUlSysIdTodoCfPersAssgn() 

    /**
     * Returns the value of field 'ulSysIdTodoCfPersCrea'.
     * 
     * @return the value of field 'UlSysIdTodoCfPersCrea'.
     */
    public int getUlSysIdTodoCfPersCrea()
    {
        return this._ulSysIdTodoCfPersCrea;
    } //-- int getUlSysIdTodoCfPersCrea() 

    /**
     * Returns the value of field 'ulSysIdTodoCfPersWkr'.
     * 
     * @return the value of field 'UlSysIdTodoCfPersWkr'.
     */
    public int getUlSysIdTodoCfPersWkr()
    {
        return this._ulSysIdTodoCfPersWkr;
    } //-- int getUlSysIdTodoCfPersWkr() 

    /**
     * Returns the value of field 'ulSysIdTodoCfStage'.
     * 
     * @return the value of field 'UlSysIdTodoCfStage'.
     */
    public int getUlSysIdTodoCfStage()
    {
        return this._ulSysIdTodoCfStage;
    } //-- int getUlSysIdTodoCfStage() 

    /**
     * Method hasLNbrRemovalAgeMo
     * 
     * 
     * 
     * @return true if at least one LNbrRemovalAgeMo has been added
     */
    public boolean hasLNbrRemovalAgeMo()
    {
        return this._has_lNbrRemovalAgeMo;
    } //-- boolean hasLNbrRemovalAgeMo() 

    /**
     * Method hasLNbrRemovalAgeYr
     * 
     * 
     * 
     * @return true if at least one LNbrRemovalAgeYr has been added
     */
    public boolean hasLNbrRemovalAgeYr()
    {
        return this._has_lNbrRemovalAgeYr;
    } //-- boolean hasLNbrRemovalAgeYr() 

    /**
     * Method hasUlSysIdTodoCfEvent
     * 
     * 
     * 
     * @return true if at least one UlSysIdTodoCfEvent has been adde
     */
    public boolean hasUlSysIdTodoCfEvent()
    {
        return this._has_ulSysIdTodoCfEvent;
    } //-- boolean hasUlSysIdTodoCfEvent() 

    /**
     * Method hasUlSysIdTodoCfPersAssgn
     * 
     * 
     * 
     * @return true if at least one UlSysIdTodoCfPersAssgn has been
     * added
     */
    public boolean hasUlSysIdTodoCfPersAssgn()
    {
        return this._has_ulSysIdTodoCfPersAssgn;
    } //-- boolean hasUlSysIdTodoCfPersAssgn() 

    /**
     * Method hasUlSysIdTodoCfPersCrea
     * 
     * 
     * 
     * @return true if at least one UlSysIdTodoCfPersCrea has been
     * added
     */
    public boolean hasUlSysIdTodoCfPersCrea()
    {
        return this._has_ulSysIdTodoCfPersCrea;
    } //-- boolean hasUlSysIdTodoCfPersCrea() 

    /**
     * Method hasUlSysIdTodoCfPersWkr
     * 
     * 
     * 
     * @return true if at least one UlSysIdTodoCfPersWkr has been
     * added
     */
    public boolean hasUlSysIdTodoCfPersWkr()
    {
        return this._has_ulSysIdTodoCfPersWkr;
    } //-- boolean hasUlSysIdTodoCfPersWkr() 

    /**
     * Method hasUlSysIdTodoCfStage
     * 
     * 
     * 
     * @return true if at least one UlSysIdTodoCfStage has been adde
     */
    public boolean hasUlSysIdTodoCfStage()
    {
        return this._has_ulSysIdTodoCfStage;
    } //-- boolean hasUlSysIdTodoCfStage() 

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
     * Sets the value of field 'dtDtRemoval'.
     * 
     * @param dtDtRemoval the value of field 'dtDtRemoval'.
     */
    public void setDtDtRemoval(org.exolab.castor.types.Date dtDtRemoval)
    {
        this._dtDtRemoval = dtDtRemoval;
    } //-- void setDtDtRemoval(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtSysDtTodoCfDueFrom'.
     * 
     * @param dtSysDtTodoCfDueFrom the value of field
     * 'dtSysDtTodoCfDueFrom'.
     */
    public void setDtSysDtTodoCfDueFrom(org.exolab.castor.types.Date dtSysDtTodoCfDueFrom)
    {
        this._dtSysDtTodoCfDueFrom = dtSysDtTodoCfDueFrom;
    } //-- void setDtSysDtTodoCfDueFrom(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lNbrRemovalAgeMo'.
     * 
     * @param lNbrRemovalAgeMo the value of field 'lNbrRemovalAgeMo'
     */
    public void setLNbrRemovalAgeMo(int lNbrRemovalAgeMo)
    {
        this._lNbrRemovalAgeMo = lNbrRemovalAgeMo;
        this._has_lNbrRemovalAgeMo = true;
    } //-- void setLNbrRemovalAgeMo(int) 

    /**
     * Sets the value of field 'lNbrRemovalAgeYr'.
     * 
     * @param lNbrRemovalAgeYr the value of field 'lNbrRemovalAgeYr'
     */
    public void setLNbrRemovalAgeYr(int lNbrRemovalAgeYr)
    {
        this._lNbrRemovalAgeYr = lNbrRemovalAgeYr;
        this._has_lNbrRemovalAgeYr = true;
    } //-- void setLNbrRemovalAgeYr(int) 

    /**
     * Sets the value of field 'szSysCdTodoCf'.
     * 
     * @param szSysCdTodoCf the value of field 'szSysCdTodoCf'.
     */
    public void setSzSysCdTodoCf(java.lang.String szSysCdTodoCf)
    {
        this._szSysCdTodoCf = szSysCdTodoCf;
    } //-- void setSzSysCdTodoCf(java.lang.String) 

    /**
     * Sets the value of field 'szSysTxtTodoCfDesc'.
     * 
     * @param szSysTxtTodoCfDesc the value of field
     * 'szSysTxtTodoCfDesc'.
     */
    public void setSzSysTxtTodoCfDesc(java.lang.String szSysTxtTodoCfDesc)
    {
        this._szSysTxtTodoCfDesc = szSysTxtTodoCfDesc;
    } //-- void setSzSysTxtTodoCfDesc(java.lang.String) 

    /**
     * Sets the value of field 'szSysTxtTodoCfLongDesc'.
     * 
     * @param szSysTxtTodoCfLongDesc the value of field
     * 'szSysTxtTodoCfLongDesc'.
     */
    public void setSzSysTxtTodoCfLongDesc(java.lang.String szSysTxtTodoCfLongDesc)
    {
        this._szSysTxtTodoCfLongDesc = szSysTxtTodoCfLongDesc;
    } //-- void setSzSysTxtTodoCfLongDesc(java.lang.String) 

    /**
     * Sets the value of field 'ulSysIdTodoCfEvent'.
     * 
     * @param ulSysIdTodoCfEvent the value of field
     * 'ulSysIdTodoCfEvent'.
     */
    public void setUlSysIdTodoCfEvent(int ulSysIdTodoCfEvent)
    {
        this._ulSysIdTodoCfEvent = ulSysIdTodoCfEvent;
        this._has_ulSysIdTodoCfEvent = true;
    } //-- void setUlSysIdTodoCfEvent(int) 

    /**
     * Sets the value of field 'ulSysIdTodoCfPersAssgn'.
     * 
     * @param ulSysIdTodoCfPersAssgn the value of field
     * 'ulSysIdTodoCfPersAssgn'.
     */
    public void setUlSysIdTodoCfPersAssgn(int ulSysIdTodoCfPersAssgn)
    {
        this._ulSysIdTodoCfPersAssgn = ulSysIdTodoCfPersAssgn;
        this._has_ulSysIdTodoCfPersAssgn = true;
    } //-- void setUlSysIdTodoCfPersAssgn(int) 

    /**
     * Sets the value of field 'ulSysIdTodoCfPersCrea'.
     * 
     * @param ulSysIdTodoCfPersCrea the value of field
     * 'ulSysIdTodoCfPersCrea'.
     */
    public void setUlSysIdTodoCfPersCrea(int ulSysIdTodoCfPersCrea)
    {
        this._ulSysIdTodoCfPersCrea = ulSysIdTodoCfPersCrea;
        this._has_ulSysIdTodoCfPersCrea = true;
    } //-- void setUlSysIdTodoCfPersCrea(int) 

    /**
     * Sets the value of field 'ulSysIdTodoCfPersWkr'.
     * 
     * @param ulSysIdTodoCfPersWkr the value of field
     * 'ulSysIdTodoCfPersWkr'.
     */
    public void setUlSysIdTodoCfPersWkr(int ulSysIdTodoCfPersWkr)
    {
        this._ulSysIdTodoCfPersWkr = ulSysIdTodoCfPersWkr;
        this._has_ulSysIdTodoCfPersWkr = true;
    } //-- void setUlSysIdTodoCfPersWkr(int) 

    /**
     * Sets the value of field 'ulSysIdTodoCfStage'.
     * 
     * @param ulSysIdTodoCfStage the value of field
     * 'ulSysIdTodoCfStage'.
     */
    public void setUlSysIdTodoCfStage(int ulSysIdTodoCfStage)
    {
        this._ulSysIdTodoCfStage = ulSysIdTodoCfStage;
        this._has_ulSysIdTodoCfStage = true;
    } //-- void setUlSysIdTodoCfStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00 unmarshal(java.io.Reader) 

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
