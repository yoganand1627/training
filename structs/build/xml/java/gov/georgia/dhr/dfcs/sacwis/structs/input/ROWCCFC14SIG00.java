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
 * Class ROWCCFC14SIG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC14SIG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdPersMergeClosed
     */
    private int _ulIdPersMergeClosed;

    /**
     * keeps track of state for field: _ulIdPersMergeClosed
     */
    private boolean _has_ulIdPersMergeClosed;

    /**
     * Field _ulIdPersMergeSplitWrkr
     */
    private int _ulIdPersMergeSplitWrkr;

    /**
     * keeps track of state for field: _ulIdPersMergeSplitWrkr
     */
    private boolean _has_ulIdPersMergeSplitWrkr;

    /**
     * Field _ulIdPersMergeForward
     */
    private int _ulIdPersMergeForward;

    /**
     * keeps track of state for field: _ulIdPersMergeForward
     */
    private boolean _has_ulIdPersMergeForward;

    /**
     * Field _ulIdPersMergeWrkr
     */
    private int _ulIdPersMergeWrkr;

    /**
     * keeps track of state for field: _ulIdPersMergeWrkr
     */
    private boolean _has_ulIdPersMergeWrkr;

    /**
     * Field _ulIdPersonMerge
     */
    private int _ulIdPersonMerge;

    /**
     * keeps track of state for field: _ulIdPersonMerge
     */
    private boolean _has_ulIdPersonMerge;

    /**
     * Field _dtDtPersMerge
     */
    private org.exolab.castor.types.Date _dtDtPersMerge;

    /**
     * Field _dtDtPersMergeSplit
     */
    private org.exolab.castor.types.Date _dtDtPersMergeSplit;

    /**
     * Field _cIndPersMergeInvalid
     */
    private java.lang.String _cIndPersMergeInvalid;

    /**
     * Field _szCdSysDataActionOutcome
     */
    private java.lang.String _szCdSysDataActionOutcome;

    /**
     * Field _szScrNmPersMergeClosed
     */
    private java.lang.String _szScrNmPersMergeClosed;

    /**
     * Field _szScrNmPersMergeForward
     */
    private java.lang.String _szScrNmPersMergeForward;

    /**
     * Field _szScrNmPersMergeWrkr
     */
    private java.lang.String _szScrNmPersMergeWrkr;

    /**
     * Field _szScrNmPersMrgSpltWrkr
     */
    private java.lang.String _szScrNmPersMrgSpltWrkr;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC14SIG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPersMergeClosed()
    {
        this._has_ulIdPersMergeClosed= false;
    } //-- void deleteUlIdPersMergeClosed() 

    /**
     */
    public void deleteUlIdPersMergeForward()
    {
        this._has_ulIdPersMergeForward= false;
    } //-- void deleteUlIdPersMergeForward() 

    /**
     */
    public void deleteUlIdPersMergeSplitWrkr()
    {
        this._has_ulIdPersMergeSplitWrkr= false;
    } //-- void deleteUlIdPersMergeSplitWrkr() 

    /**
     */
    public void deleteUlIdPersMergeWrkr()
    {
        this._has_ulIdPersMergeWrkr= false;
    } //-- void deleteUlIdPersMergeWrkr() 

    /**
     */
    public void deleteUlIdPersonMerge()
    {
        this._has_ulIdPersonMerge= false;
    } //-- void deleteUlIdPersonMerge() 

    /**
     * Returns the value of field 'cIndPersMergeInvalid'.
     * 
     * @return the value of field 'CIndPersMergeInvalid'.
     */
    public java.lang.String getCIndPersMergeInvalid()
    {
        return this._cIndPersMergeInvalid;
    } //-- java.lang.String getCIndPersMergeInvalid() 

    /**
     * Returns the value of field 'dtDtPersMerge'.
     * 
     * @return the value of field 'DtDtPersMerge'.
     */
    public org.exolab.castor.types.Date getDtDtPersMerge()
    {
        return this._dtDtPersMerge;
    } //-- org.exolab.castor.types.Date getDtDtPersMerge() 

    /**
     * Returns the value of field 'dtDtPersMergeSplit'.
     * 
     * @return the value of field 'DtDtPersMergeSplit'.
     */
    public org.exolab.castor.types.Date getDtDtPersMergeSplit()
    {
        return this._dtDtPersMergeSplit;
    } //-- org.exolab.castor.types.Date getDtDtPersMergeSplit() 

    /**
     * Returns the value of field 'szCdSysDataActionOutcome'.
     * 
     * @return the value of field 'SzCdSysDataActionOutcome'.
     */
    public java.lang.String getSzCdSysDataActionOutcome()
    {
        return this._szCdSysDataActionOutcome;
    } //-- java.lang.String getSzCdSysDataActionOutcome() 

    /**
     * Returns the value of field 'szScrNmPersMergeClosed'.
     * 
     * @return the value of field 'SzScrNmPersMergeClosed'.
     */
    public java.lang.String getSzScrNmPersMergeClosed()
    {
        return this._szScrNmPersMergeClosed;
    } //-- java.lang.String getSzScrNmPersMergeClosed() 

    /**
     * Returns the value of field 'szScrNmPersMergeForward'.
     * 
     * @return the value of field 'SzScrNmPersMergeForward'.
     */
    public java.lang.String getSzScrNmPersMergeForward()
    {
        return this._szScrNmPersMergeForward;
    } //-- java.lang.String getSzScrNmPersMergeForward() 

    /**
     * Returns the value of field 'szScrNmPersMergeWrkr'.
     * 
     * @return the value of field 'SzScrNmPersMergeWrkr'.
     */
    public java.lang.String getSzScrNmPersMergeWrkr()
    {
        return this._szScrNmPersMergeWrkr;
    } //-- java.lang.String getSzScrNmPersMergeWrkr() 

    /**
     * Returns the value of field 'szScrNmPersMrgSpltWrkr'.
     * 
     * @return the value of field 'SzScrNmPersMrgSpltWrkr'.
     */
    public java.lang.String getSzScrNmPersMrgSpltWrkr()
    {
        return this._szScrNmPersMrgSpltWrkr;
    } //-- java.lang.String getSzScrNmPersMrgSpltWrkr() 

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
     * Returns the value of field 'ulIdPersMergeClosed'.
     * 
     * @return the value of field 'UlIdPersMergeClosed'.
     */
    public int getUlIdPersMergeClosed()
    {
        return this._ulIdPersMergeClosed;
    } //-- int getUlIdPersMergeClosed() 

    /**
     * Returns the value of field 'ulIdPersMergeForward'.
     * 
     * @return the value of field 'UlIdPersMergeForward'.
     */
    public int getUlIdPersMergeForward()
    {
        return this._ulIdPersMergeForward;
    } //-- int getUlIdPersMergeForward() 

    /**
     * Returns the value of field 'ulIdPersMergeSplitWrkr'.
     * 
     * @return the value of field 'UlIdPersMergeSplitWrkr'.
     */
    public int getUlIdPersMergeSplitWrkr()
    {
        return this._ulIdPersMergeSplitWrkr;
    } //-- int getUlIdPersMergeSplitWrkr() 

    /**
     * Returns the value of field 'ulIdPersMergeWrkr'.
     * 
     * @return the value of field 'UlIdPersMergeWrkr'.
     */
    public int getUlIdPersMergeWrkr()
    {
        return this._ulIdPersMergeWrkr;
    } //-- int getUlIdPersMergeWrkr() 

    /**
     * Returns the value of field 'ulIdPersonMerge'.
     * 
     * @return the value of field 'UlIdPersonMerge'.
     */
    public int getUlIdPersonMerge()
    {
        return this._ulIdPersonMerge;
    } //-- int getUlIdPersonMerge() 

    /**
     * Method hasUlIdPersMergeClosed
     * 
     * 
     * 
     * @return true if at least one UlIdPersMergeClosed has been
     * added
     */
    public boolean hasUlIdPersMergeClosed()
    {
        return this._has_ulIdPersMergeClosed;
    } //-- boolean hasUlIdPersMergeClosed() 

    /**
     * Method hasUlIdPersMergeForward
     * 
     * 
     * 
     * @return true if at least one UlIdPersMergeForward has been
     * added
     */
    public boolean hasUlIdPersMergeForward()
    {
        return this._has_ulIdPersMergeForward;
    } //-- boolean hasUlIdPersMergeForward() 

    /**
     * Method hasUlIdPersMergeSplitWrkr
     * 
     * 
     * 
     * @return true if at least one UlIdPersMergeSplitWrkr has been
     * added
     */
    public boolean hasUlIdPersMergeSplitWrkr()
    {
        return this._has_ulIdPersMergeSplitWrkr;
    } //-- boolean hasUlIdPersMergeSplitWrkr() 

    /**
     * Method hasUlIdPersMergeWrkr
     * 
     * 
     * 
     * @return true if at least one UlIdPersMergeWrkr has been added
     */
    public boolean hasUlIdPersMergeWrkr()
    {
        return this._has_ulIdPersMergeWrkr;
    } //-- boolean hasUlIdPersMergeWrkr() 

    /**
     * Method hasUlIdPersonMerge
     * 
     * 
     * 
     * @return true if at least one UlIdPersonMerge has been added
     */
    public boolean hasUlIdPersonMerge()
    {
        return this._has_ulIdPersonMerge;
    } //-- boolean hasUlIdPersonMerge() 

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
     * Sets the value of field 'cIndPersMergeInvalid'.
     * 
     * @param cIndPersMergeInvalid the value of field
     * 'cIndPersMergeInvalid'.
     */
    public void setCIndPersMergeInvalid(java.lang.String cIndPersMergeInvalid)
    {
        this._cIndPersMergeInvalid = cIndPersMergeInvalid;
    } //-- void setCIndPersMergeInvalid(java.lang.String) 

    /**
     * Sets the value of field 'dtDtPersMerge'.
     * 
     * @param dtDtPersMerge the value of field 'dtDtPersMerge'.
     */
    public void setDtDtPersMerge(org.exolab.castor.types.Date dtDtPersMerge)
    {
        this._dtDtPersMerge = dtDtPersMerge;
    } //-- void setDtDtPersMerge(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPersMergeSplit'.
     * 
     * @param dtDtPersMergeSplit the value of field
     * 'dtDtPersMergeSplit'.
     */
    public void setDtDtPersMergeSplit(org.exolab.castor.types.Date dtDtPersMergeSplit)
    {
        this._dtDtPersMergeSplit = dtDtPersMergeSplit;
    } //-- void setDtDtPersMergeSplit(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdSysDataActionOutcome'.
     * 
     * @param szCdSysDataActionOutcome the value of field
     * 'szCdSysDataActionOutcome'.
     */
    public void setSzCdSysDataActionOutcome(java.lang.String szCdSysDataActionOutcome)
    {
        this._szCdSysDataActionOutcome = szCdSysDataActionOutcome;
    } //-- void setSzCdSysDataActionOutcome(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmPersMergeClosed'.
     * 
     * @param szScrNmPersMergeClosed the value of field
     * 'szScrNmPersMergeClosed'.
     */
    public void setSzScrNmPersMergeClosed(java.lang.String szScrNmPersMergeClosed)
    {
        this._szScrNmPersMergeClosed = szScrNmPersMergeClosed;
    } //-- void setSzScrNmPersMergeClosed(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmPersMergeForward'.
     * 
     * @param szScrNmPersMergeForward the value of field
     * 'szScrNmPersMergeForward'.
     */
    public void setSzScrNmPersMergeForward(java.lang.String szScrNmPersMergeForward)
    {
        this._szScrNmPersMergeForward = szScrNmPersMergeForward;
    } //-- void setSzScrNmPersMergeForward(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmPersMergeWrkr'.
     * 
     * @param szScrNmPersMergeWrkr the value of field
     * 'szScrNmPersMergeWrkr'.
     */
    public void setSzScrNmPersMergeWrkr(java.lang.String szScrNmPersMergeWrkr)
    {
        this._szScrNmPersMergeWrkr = szScrNmPersMergeWrkr;
    } //-- void setSzScrNmPersMergeWrkr(java.lang.String) 

    /**
     * Sets the value of field 'szScrNmPersMrgSpltWrkr'.
     * 
     * @param szScrNmPersMrgSpltWrkr the value of field
     * 'szScrNmPersMrgSpltWrkr'.
     */
    public void setSzScrNmPersMrgSpltWrkr(java.lang.String szScrNmPersMrgSpltWrkr)
    {
        this._szScrNmPersMrgSpltWrkr = szScrNmPersMrgSpltWrkr;
    } //-- void setSzScrNmPersMrgSpltWrkr(java.lang.String) 

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
     * Sets the value of field 'ulIdPersMergeClosed'.
     * 
     * @param ulIdPersMergeClosed the value of field
     * 'ulIdPersMergeClosed'.
     */
    public void setUlIdPersMergeClosed(int ulIdPersMergeClosed)
    {
        this._ulIdPersMergeClosed = ulIdPersMergeClosed;
        this._has_ulIdPersMergeClosed = true;
    } //-- void setUlIdPersMergeClosed(int) 

    /**
     * Sets the value of field 'ulIdPersMergeForward'.
     * 
     * @param ulIdPersMergeForward the value of field
     * 'ulIdPersMergeForward'.
     */
    public void setUlIdPersMergeForward(int ulIdPersMergeForward)
    {
        this._ulIdPersMergeForward = ulIdPersMergeForward;
        this._has_ulIdPersMergeForward = true;
    } //-- void setUlIdPersMergeForward(int) 

    /**
     * Sets the value of field 'ulIdPersMergeSplitWrkr'.
     * 
     * @param ulIdPersMergeSplitWrkr the value of field
     * 'ulIdPersMergeSplitWrkr'.
     */
    public void setUlIdPersMergeSplitWrkr(int ulIdPersMergeSplitWrkr)
    {
        this._ulIdPersMergeSplitWrkr = ulIdPersMergeSplitWrkr;
        this._has_ulIdPersMergeSplitWrkr = true;
    } //-- void setUlIdPersMergeSplitWrkr(int) 

    /**
     * Sets the value of field 'ulIdPersMergeWrkr'.
     * 
     * @param ulIdPersMergeWrkr the value of field
     * 'ulIdPersMergeWrkr'.
     */
    public void setUlIdPersMergeWrkr(int ulIdPersMergeWrkr)
    {
        this._ulIdPersMergeWrkr = ulIdPersMergeWrkr;
        this._has_ulIdPersMergeWrkr = true;
    } //-- void setUlIdPersMergeWrkr(int) 

    /**
     * Sets the value of field 'ulIdPersonMerge'.
     * 
     * @param ulIdPersonMerge the value of field 'ulIdPersonMerge'.
     */
    public void setUlIdPersonMerge(int ulIdPersonMerge)
    {
        this._ulIdPersonMerge = ulIdPersonMerge;
        this._has_ulIdPersonMerge = true;
    } //-- void setUlIdPersonMerge(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC14SIG00 unmarshal(java.io.Reader) 

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
