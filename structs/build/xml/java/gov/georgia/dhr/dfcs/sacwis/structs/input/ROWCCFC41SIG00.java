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
 * Class ROWCCFC41SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC41SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _ulIdCaseMerge
     */
    private int _ulIdCaseMerge;

    /**
     * keeps track of state for field: _ulIdCaseMerge
     */
    private boolean _has_ulIdCaseMerge;

    /**
     * Field _ulIdCaseMergeFrom
     */
    private int _ulIdCaseMergeFrom;

    /**
     * keeps track of state for field: _ulIdCaseMergeFrom
     */
    private boolean _has_ulIdCaseMergeFrom;

    /**
     * Field _ulIdCaseMergePersMrg
     */
    private int _ulIdCaseMergePersMrg;

    /**
     * keeps track of state for field: _ulIdCaseMergePersMrg
     */
    private boolean _has_ulIdCaseMergePersMrg;

    /**
     * Field _ulIdCaseMergePersSplit
     */
    private int _ulIdCaseMergePersSplit;

    /**
     * keeps track of state for field: _ulIdCaseMergePersSplit
     */
    private boolean _has_ulIdCaseMergePersSplit;

    /**
     * Field _ulIdCaseMergeTo
     */
    private int _ulIdCaseMergeTo;

    /**
     * keeps track of state for field: _ulIdCaseMergeTo
     */
    private boolean _has_ulIdCaseMergeTo;

    /**
     * Field _dtDtCaseMerge
     */
    private org.exolab.castor.types.Date _dtDtCaseMerge;

    /**
     * Field _dtCaseMergeSplit
     */
    private org.exolab.castor.types.Date _dtCaseMergeSplit;

    /**
     * Field _cIndCaseMergeInv
     */
    private java.lang.String _cIndCaseMergeInv;

    /**
     * Field _cIndCaseMergePending
     */
    private java.lang.String _cIndCaseMergePending;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC41SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCaseMerge()
    {
        this._has_ulIdCaseMerge= false;
    } //-- void deleteUlIdCaseMerge() 

    /**
     */
    public void deleteUlIdCaseMergeFrom()
    {
        this._has_ulIdCaseMergeFrom= false;
    } //-- void deleteUlIdCaseMergeFrom() 

    /**
     */
    public void deleteUlIdCaseMergePersMrg()
    {
        this._has_ulIdCaseMergePersMrg= false;
    } //-- void deleteUlIdCaseMergePersMrg() 

    /**
     */
    public void deleteUlIdCaseMergePersSplit()
    {
        this._has_ulIdCaseMergePersSplit= false;
    } //-- void deleteUlIdCaseMergePersSplit() 

    /**
     */
    public void deleteUlIdCaseMergeTo()
    {
        this._has_ulIdCaseMergeTo= false;
    } //-- void deleteUlIdCaseMergeTo() 

    /**
     * Returns the value of field 'cIndCaseMergeInv'.
     * 
     * @return the value of field 'CIndCaseMergeInv'.
     */
    public java.lang.String getCIndCaseMergeInv()
    {
        return this._cIndCaseMergeInv;
    } //-- java.lang.String getCIndCaseMergeInv() 

    /**
     * Returns the value of field 'cIndCaseMergePending'.
     * 
     * @return the value of field 'CIndCaseMergePending'.
     */
    public java.lang.String getCIndCaseMergePending()
    {
        return this._cIndCaseMergePending;
    } //-- java.lang.String getCIndCaseMergePending() 

    /**
     * Returns the value of field 'dtCaseMergeSplit'.
     * 
     * @return the value of field 'DtCaseMergeSplit'.
     */
    public org.exolab.castor.types.Date getDtCaseMergeSplit()
    {
        return this._dtCaseMergeSplit;
    } //-- org.exolab.castor.types.Date getDtCaseMergeSplit() 

    /**
     * Returns the value of field 'dtDtCaseMerge'.
     * 
     * @return the value of field 'DtDtCaseMerge'.
     */
    public org.exolab.castor.types.Date getDtDtCaseMerge()
    {
        return this._dtDtCaseMerge;
    } //-- org.exolab.castor.types.Date getDtDtCaseMerge() 

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
     * Returns the value of field 'ulIdCaseMerge'.
     * 
     * @return the value of field 'UlIdCaseMerge'.
     */
    public int getUlIdCaseMerge()
    {
        return this._ulIdCaseMerge;
    } //-- int getUlIdCaseMerge() 

    /**
     * Returns the value of field 'ulIdCaseMergeFrom'.
     * 
     * @return the value of field 'UlIdCaseMergeFrom'.
     */
    public int getUlIdCaseMergeFrom()
    {
        return this._ulIdCaseMergeFrom;
    } //-- int getUlIdCaseMergeFrom() 

    /**
     * Returns the value of field 'ulIdCaseMergePersMrg'.
     * 
     * @return the value of field 'UlIdCaseMergePersMrg'.
     */
    public int getUlIdCaseMergePersMrg()
    {
        return this._ulIdCaseMergePersMrg;
    } //-- int getUlIdCaseMergePersMrg() 

    /**
     * Returns the value of field 'ulIdCaseMergePersSplit'.
     * 
     * @return the value of field 'UlIdCaseMergePersSplit'.
     */
    public int getUlIdCaseMergePersSplit()
    {
        return this._ulIdCaseMergePersSplit;
    } //-- int getUlIdCaseMergePersSplit() 

    /**
     * Returns the value of field 'ulIdCaseMergeTo'.
     * 
     * @return the value of field 'UlIdCaseMergeTo'.
     */
    public int getUlIdCaseMergeTo()
    {
        return this._ulIdCaseMergeTo;
    } //-- int getUlIdCaseMergeTo() 

    /**
     * Method hasUlIdCaseMerge
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMerge has been added
     */
    public boolean hasUlIdCaseMerge()
    {
        return this._has_ulIdCaseMerge;
    } //-- boolean hasUlIdCaseMerge() 

    /**
     * Method hasUlIdCaseMergeFrom
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMergeFrom has been added
     */
    public boolean hasUlIdCaseMergeFrom()
    {
        return this._has_ulIdCaseMergeFrom;
    } //-- boolean hasUlIdCaseMergeFrom() 

    /**
     * Method hasUlIdCaseMergePersMrg
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMergePersMrg has been
     * added
     */
    public boolean hasUlIdCaseMergePersMrg()
    {
        return this._has_ulIdCaseMergePersMrg;
    } //-- boolean hasUlIdCaseMergePersMrg() 

    /**
     * Method hasUlIdCaseMergePersSplit
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMergePersSplit has been
     * added
     */
    public boolean hasUlIdCaseMergePersSplit()
    {
        return this._has_ulIdCaseMergePersSplit;
    } //-- boolean hasUlIdCaseMergePersSplit() 

    /**
     * Method hasUlIdCaseMergeTo
     * 
     * 
     * 
     * @return true if at least one UlIdCaseMergeTo has been added
     */
    public boolean hasUlIdCaseMergeTo()
    {
        return this._has_ulIdCaseMergeTo;
    } //-- boolean hasUlIdCaseMergeTo() 

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
     * Sets the value of field 'cIndCaseMergeInv'.
     * 
     * @param cIndCaseMergeInv the value of field 'cIndCaseMergeInv'
     */
    public void setCIndCaseMergeInv(java.lang.String cIndCaseMergeInv)
    {
        this._cIndCaseMergeInv = cIndCaseMergeInv;
    } //-- void setCIndCaseMergeInv(java.lang.String) 

    /**
     * Sets the value of field 'cIndCaseMergePending'.
     * 
     * @param cIndCaseMergePending the value of field
     * 'cIndCaseMergePending'.
     */
    public void setCIndCaseMergePending(java.lang.String cIndCaseMergePending)
    {
        this._cIndCaseMergePending = cIndCaseMergePending;
    } //-- void setCIndCaseMergePending(java.lang.String) 

    /**
     * Sets the value of field 'dtCaseMergeSplit'.
     * 
     * @param dtCaseMergeSplit the value of field 'dtCaseMergeSplit'
     */
    public void setDtCaseMergeSplit(org.exolab.castor.types.Date dtCaseMergeSplit)
    {
        this._dtCaseMergeSplit = dtCaseMergeSplit;
    } //-- void setDtCaseMergeSplit(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtCaseMerge'.
     * 
     * @param dtDtCaseMerge the value of field 'dtDtCaseMerge'.
     */
    public void setDtDtCaseMerge(org.exolab.castor.types.Date dtDtCaseMerge)
    {
        this._dtDtCaseMerge = dtDtCaseMerge;
    } //-- void setDtDtCaseMerge(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ulIdCaseMerge'.
     * 
     * @param ulIdCaseMerge the value of field 'ulIdCaseMerge'.
     */
    public void setUlIdCaseMerge(int ulIdCaseMerge)
    {
        this._ulIdCaseMerge = ulIdCaseMerge;
        this._has_ulIdCaseMerge = true;
    } //-- void setUlIdCaseMerge(int) 

    /**
     * Sets the value of field 'ulIdCaseMergeFrom'.
     * 
     * @param ulIdCaseMergeFrom the value of field
     * 'ulIdCaseMergeFrom'.
     */
    public void setUlIdCaseMergeFrom(int ulIdCaseMergeFrom)
    {
        this._ulIdCaseMergeFrom = ulIdCaseMergeFrom;
        this._has_ulIdCaseMergeFrom = true;
    } //-- void setUlIdCaseMergeFrom(int) 

    /**
     * Sets the value of field 'ulIdCaseMergePersMrg'.
     * 
     * @param ulIdCaseMergePersMrg the value of field
     * 'ulIdCaseMergePersMrg'.
     */
    public void setUlIdCaseMergePersMrg(int ulIdCaseMergePersMrg)
    {
        this._ulIdCaseMergePersMrg = ulIdCaseMergePersMrg;
        this._has_ulIdCaseMergePersMrg = true;
    } //-- void setUlIdCaseMergePersMrg(int) 

    /**
     * Sets the value of field 'ulIdCaseMergePersSplit'.
     * 
     * @param ulIdCaseMergePersSplit the value of field
     * 'ulIdCaseMergePersSplit'.
     */
    public void setUlIdCaseMergePersSplit(int ulIdCaseMergePersSplit)
    {
        this._ulIdCaseMergePersSplit = ulIdCaseMergePersSplit;
        this._has_ulIdCaseMergePersSplit = true;
    } //-- void setUlIdCaseMergePersSplit(int) 

    /**
     * Sets the value of field 'ulIdCaseMergeTo'.
     * 
     * @param ulIdCaseMergeTo the value of field 'ulIdCaseMergeTo'.
     */
    public void setUlIdCaseMergeTo(int ulIdCaseMergeTo)
    {
        this._ulIdCaseMergeTo = ulIdCaseMergeTo;
        this._has_ulIdCaseMergeTo = true;
    } //-- void setUlIdCaseMergeTo(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00 unmarshal(java.io.Reader) 

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
