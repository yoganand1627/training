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
 * Class CSUB28SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB28SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdTask
     */
    private java.lang.String _szCdTask;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulSysIdTodoCfPersCrea
     */
    private int _ulSysIdTodoCfPersCrea;

    /**
     * keeps track of state for field: _ulSysIdTodoCfPersCrea
     */
    private boolean _has_ulSysIdTodoCfPersCrea;

    /**
     * Field _dtDtPptDate
     */
    private org.exolab.castor.types.Date _dtDtPptDate;

    /**
     * Field _tmScrTmPptTime
     */
    private java.lang.String _tmScrTmPptTime;

    /**
     * Field _sWCDNbrListRowsQty
     */
    private short _sWCDNbrListRowsQty;

    /**
     * keeps track of state for field: _sWCDNbrListRowsQty
     */
    private boolean _has_sWCDNbrListRowsQty;

    /**
     * Field _ROWCSUB28SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00_ARRAY _ROWCSUB28SIG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB28SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSWCDNbrListRowsQty()
    {
        this._has_sWCDNbrListRowsQty= false;
    } //-- void deleteSWCDNbrListRowsQty() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlSysIdTodoCfPersCrea()
    {
        this._has_ulSysIdTodoCfPersCrea= false;
    } //-- void deleteUlSysIdTodoCfPersCrea() 

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
     * Returns the value of field 'dtDtPptDate'.
     * 
     * @return the value of field 'DtDtPptDate'.
     */
    public org.exolab.castor.types.Date getDtDtPptDate()
    {
        return this._dtDtPptDate;
    } //-- org.exolab.castor.types.Date getDtDtPptDate() 

    /**
     * Returns the value of field 'ROWCSUB28SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB28SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00_ARRAY getROWCSUB28SIG00_ARRAY()
    {
        return this._ROWCSUB28SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00_ARRAY getROWCSUB28SIG00_ARRAY() 

    /**
     * Returns the value of field 'sWCDNbrListRowsQty'.
     * 
     * @return the value of field 'SWCDNbrListRowsQty'.
     */
    public short getSWCDNbrListRowsQty()
    {
        return this._sWCDNbrListRowsQty;
    } //-- short getSWCDNbrListRowsQty() 

    /**
     * Returns the value of field 'szCdTask'.
     * 
     * @return the value of field 'SzCdTask'.
     */
    public java.lang.String getSzCdTask()
    {
        return this._szCdTask;
    } //-- java.lang.String getSzCdTask() 

    /**
     * Returns the value of field 'tmScrTmPptTime'.
     * 
     * @return the value of field 'TmScrTmPptTime'.
     */
    public java.lang.String getTmScrTmPptTime()
    {
        return this._tmScrTmPptTime;
    } //-- java.lang.String getTmScrTmPptTime() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

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
     * Method hasSWCDNbrListRowsQty
     * 
     * 
     * 
     * @return true if at least one SWCDNbrListRowsQty has been adde
     */
    public boolean hasSWCDNbrListRowsQty()
    {
        return this._has_sWCDNbrListRowsQty;
    } //-- boolean hasSWCDNbrListRowsQty() 

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
     * Sets the value of field 'dtDtPptDate'.
     * 
     * @param dtDtPptDate the value of field 'dtDtPptDate'.
     */
    public void setDtDtPptDate(org.exolab.castor.types.Date dtDtPptDate)
    {
        this._dtDtPptDate = dtDtPptDate;
    } //-- void setDtDtPptDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCSUB28SIG00_ARRAY'.
     * 
     * @param ROWCSUB28SIG00_ARRAY the value of field
     * 'ROWCSUB28SIG00_ARRAY'.
     */
    public void setROWCSUB28SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00_ARRAY ROWCSUB28SIG00_ARRAY)
    {
        this._ROWCSUB28SIG00_ARRAY = ROWCSUB28SIG00_ARRAY;
    } //-- void setROWCSUB28SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00_ARRAY) 

    /**
     * Sets the value of field 'sWCDNbrListRowsQty'.
     * 
     * @param sWCDNbrListRowsQty the value of field
     * 'sWCDNbrListRowsQty'.
     */
    public void setSWCDNbrListRowsQty(short sWCDNbrListRowsQty)
    {
        this._sWCDNbrListRowsQty = sWCDNbrListRowsQty;
        this._has_sWCDNbrListRowsQty = true;
    } //-- void setSWCDNbrListRowsQty(short) 

    /**
     * Sets the value of field 'szCdTask'.
     * 
     * @param szCdTask the value of field 'szCdTask'.
     */
    public void setSzCdTask(java.lang.String szCdTask)
    {
        this._szCdTask = szCdTask;
    } //-- void setSzCdTask(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmPptTime'.
     * 
     * @param tmScrTmPptTime the value of field 'tmScrTmPptTime'.
     */
    public void setTmScrTmPptTime(java.lang.String tmScrTmPptTime)
    {
        this._tmScrTmPptTime = tmScrTmPptTime;
    } //-- void setTmScrTmPptTime(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI unmarshal(java.io.Reader) 

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
