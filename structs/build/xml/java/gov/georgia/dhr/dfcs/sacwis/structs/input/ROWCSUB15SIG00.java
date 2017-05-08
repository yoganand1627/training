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
 * Class ROWCSUB15SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSUB15SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dtDtRemoval
     */
    private org.exolab.castor.types.Date _dtDtRemoval;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdVictim
     */
    private int _ulIdVictim;

    /**
     * keeps track of state for field: _ulIdVictim
     */
    private boolean _has_ulIdVictim;

    /**
     * Field _cIndRemovalNACare
     */
    private java.lang.String _cIndRemovalNACare;

    /**
     * Field _cIndRemovalNaChild
     */
    private java.lang.String _cIndRemovalNaChild;

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
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _rbRemovalType
     */
    private java.lang.String _rbRemovalType;

    /**
     * Field _cbParentNotified
     */
    private java.lang.String _cbParentNotified;

    /**
     * Field _txtFactualDesc
     */
    private java.lang.String _txtFactualDesc;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSUB15SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00()


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
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdVictim()
    {
        this._has_ulIdVictim= false;
    } //-- void deleteUlIdVictim() 

    /**
     * Returns the value of field 'cIndRemovalNACare'.
     * 
     * @return the value of field 'CIndRemovalNACare'.
     */
    public java.lang.String getCIndRemovalNACare()
    {
        return this._cIndRemovalNACare;
    } //-- java.lang.String getCIndRemovalNACare() 

    /**
     * Returns the value of field 'cIndRemovalNaChild'.
     * 
     * @return the value of field 'CIndRemovalNaChild'.
     */
    public java.lang.String getCIndRemovalNaChild()
    {
        return this._cIndRemovalNaChild;
    } //-- java.lang.String getCIndRemovalNaChild() 

    /**
     * Returns the value of field 'cbParentNotified'.
     * 
     * @return the value of field 'CbParentNotified'.
     */
    public java.lang.String getCbParentNotified()
    {
        return this._cbParentNotified;
    } //-- java.lang.String getCbParentNotified() 

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
     * Returns the value of field 'rbRemovalType'.
     * 
     * @return the value of field 'RbRemovalType'.
     */
    public java.lang.String getRbRemovalType()
    {
        return this._rbRemovalType;
    } //-- java.lang.String getRbRemovalType() 

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
     * Returns the value of field 'txtFactualDesc'.
     * 
     * @return the value of field 'TxtFactualDesc'.
     */
    public java.lang.String getTxtFactualDesc()
    {
        return this._txtFactualDesc;
    } //-- java.lang.String getTxtFactualDesc() 

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
     * Returns the value of field 'ulIdEvent'.
     * 
     * @return the value of field 'UlIdEvent'.
     */
    public int getUlIdEvent()
    {
        return this._ulIdEvent;
    } //-- int getUlIdEvent() 

    /**
     * Returns the value of field 'ulIdVictim'.
     * 
     * @return the value of field 'UlIdVictim'.
     */
    public int getUlIdVictim()
    {
        return this._ulIdVictim;
    } //-- int getUlIdVictim() 

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
     * Method hasUlIdEvent
     * 
     * 
     * 
     * @return true if at least one UlIdEvent has been added
     */
    public boolean hasUlIdEvent()
    {
        return this._has_ulIdEvent;
    } //-- boolean hasUlIdEvent() 

    /**
     * Method hasUlIdVictim
     * 
     * 
     * 
     * @return true if at least one UlIdVictim has been added
     */
    public boolean hasUlIdVictim()
    {
        return this._has_ulIdVictim;
    } //-- boolean hasUlIdVictim() 

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
     * Sets the value of field 'cIndRemovalNACare'.
     * 
     * @param cIndRemovalNACare the value of field
     * 'cIndRemovalNACare'.
     */
    public void setCIndRemovalNACare(java.lang.String cIndRemovalNACare)
    {
        this._cIndRemovalNACare = cIndRemovalNACare;
    } //-- void setCIndRemovalNACare(java.lang.String) 

    /**
     * Sets the value of field 'cIndRemovalNaChild'.
     * 
     * @param cIndRemovalNaChild the value of field
     * 'cIndRemovalNaChild'.
     */
    public void setCIndRemovalNaChild(java.lang.String cIndRemovalNaChild)
    {
        this._cIndRemovalNaChild = cIndRemovalNaChild;
    } //-- void setCIndRemovalNaChild(java.lang.String) 

    /**
     * Sets the value of field 'cbParentNotified'.
     * 
     * @param cbParentNotified the value of field 'cbParentNotified'
     */
    public void setCbParentNotified(java.lang.String cbParentNotified)
    {
        this._cbParentNotified = cbParentNotified;
    } //-- void setCbParentNotified(java.lang.String) 

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
     * Sets the value of field 'rbRemovalType'.
     * 
     * @param rbRemovalType the value of field 'rbRemovalType'.
     */
    public void setRbRemovalType(java.lang.String rbRemovalType)
    {
        this._rbRemovalType = rbRemovalType;
    } //-- void setRbRemovalType(java.lang.String) 

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
     * Sets the value of field 'txtFactualDesc'.
     * 
     * @param txtFactualDesc the value of field 'txtFactualDesc'.
     */
    public void setTxtFactualDesc(java.lang.String txtFactualDesc)
    {
        this._txtFactualDesc = txtFactualDesc;
    } //-- void setTxtFactualDesc(java.lang.String) 

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
     * Sets the value of field 'ulIdEvent'.
     * 
     * @param ulIdEvent the value of field 'ulIdEvent'.
     */
    public void setUlIdEvent(int ulIdEvent)
    {
        this._ulIdEvent = ulIdEvent;
        this._has_ulIdEvent = true;
    } //-- void setUlIdEvent(int) 

    /**
     * Sets the value of field 'ulIdVictim'.
     * 
     * @param ulIdVictim the value of field 'ulIdVictim'.
     */
    public void setUlIdVictim(int ulIdVictim)
    {
        this._ulIdVictim = ulIdVictim;
        this._has_ulIdVictim = true;
    } //-- void setUlIdVictim(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00 unmarshal(java.io.Reader) 

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
