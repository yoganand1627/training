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
 * Class ROWCSVC09DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSVC09DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cCdApsClientFactor
     */
    private java.lang.String _cCdApsClientFactor;

    /**
     * Field _szCdApsClientFactor
     */
    private java.lang.String _szCdApsClientFactor;

    /**
     * Field _szTxtApsCltFactorCmnts
     */
    private java.lang.String _szTxtApsCltFactorCmnts;

    /**
     * Field _dtDtApsOutcomeProblem
     */
    private org.exolab.castor.types.Date _dtDtApsOutcomeProblem;

    /**
     * Field _ulIdApsOutcomeMatrix
     */
    private int _ulIdApsOutcomeMatrix;

    /**
     * keeps track of state for field: _ulIdApsOutcomeMatrix
     */
    private boolean _has_ulIdApsOutcomeMatrix;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ulIdApsCltFactor
     */
    private int _ulIdApsCltFactor;

    /**
     * keeps track of state for field: _ulIdApsCltFactor
     */
    private boolean _has_ulIdApsCltFactor;

    /**
     * Field _cIndApsOutcomeOrigFctr
     */
    private java.lang.String _cIndApsOutcomeOrigFctr;

    /**
     * Field _szCdApsOutcomeActnCateg
     */
    private java.lang.String _szCdApsOutcomeActnCateg;

    /**
     * Field _szCdApsOutcomeAction
     */
    private java.lang.String _szCdApsOutcomeAction;

    /**
     * Field _dtDtApsOutcomeAction
     */
    private org.exolab.castor.types.Date _dtDtApsOutcomeAction;

    /**
     * Field _szTxtApsOutcomeAction
     */
    private java.lang.String _szTxtApsOutcomeAction;

    /**
     * Field _szCdApsOutcomeResult
     */
    private java.lang.String _szCdApsOutcomeResult;

    /**
     * Field _dtDtApsOutcomeRecord
     */
    private org.exolab.castor.types.Date _dtDtApsOutcomeRecord;

    /**
     * Field _szTxtApsOutcomeResult
     */
    private java.lang.String _szTxtApsOutcomeResult;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdDomain
     */
    private java.lang.String _szCdDomain;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSVC09DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdApsCltFactor()
    {
        this._has_ulIdApsCltFactor= false;
    } //-- void deleteUlIdApsCltFactor() 

    /**
     */
    public void deleteUlIdApsOutcomeMatrix()
    {
        this._has_ulIdApsOutcomeMatrix= false;
    } //-- void deleteUlIdApsOutcomeMatrix() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     * Returns the value of field 'cCdApsClientFactor'.
     * 
     * @return the value of field 'CCdApsClientFactor'.
     */
    public java.lang.String getCCdApsClientFactor()
    {
        return this._cCdApsClientFactor;
    } //-- java.lang.String getCCdApsClientFactor() 

    /**
     * Returns the value of field 'cIndApsOutcomeOrigFctr'.
     * 
     * @return the value of field 'CIndApsOutcomeOrigFctr'.
     */
    public java.lang.String getCIndApsOutcomeOrigFctr()
    {
        return this._cIndApsOutcomeOrigFctr;
    } //-- java.lang.String getCIndApsOutcomeOrigFctr() 

    /**
     * Returns the value of field 'dtDtApsOutcomeAction'.
     * 
     * @return the value of field 'DtDtApsOutcomeAction'.
     */
    public org.exolab.castor.types.Date getDtDtApsOutcomeAction()
    {
        return this._dtDtApsOutcomeAction;
    } //-- org.exolab.castor.types.Date getDtDtApsOutcomeAction() 

    /**
     * Returns the value of field 'dtDtApsOutcomeProblem'.
     * 
     * @return the value of field 'DtDtApsOutcomeProblem'.
     */
    public org.exolab.castor.types.Date getDtDtApsOutcomeProblem()
    {
        return this._dtDtApsOutcomeProblem;
    } //-- org.exolab.castor.types.Date getDtDtApsOutcomeProblem() 

    /**
     * Returns the value of field 'dtDtApsOutcomeRecord'.
     * 
     * @return the value of field 'DtDtApsOutcomeRecord'.
     */
    public org.exolab.castor.types.Date getDtDtApsOutcomeRecord()
    {
        return this._dtDtApsOutcomeRecord;
    } //-- org.exolab.castor.types.Date getDtDtApsOutcomeRecord() 

    /**
     * Returns the value of field 'szCdApsClientFactor'.
     * 
     * @return the value of field 'SzCdApsClientFactor'.
     */
    public java.lang.String getSzCdApsClientFactor()
    {
        return this._szCdApsClientFactor;
    } //-- java.lang.String getSzCdApsClientFactor() 

    /**
     * Returns the value of field 'szCdApsOutcomeAction'.
     * 
     * @return the value of field 'SzCdApsOutcomeAction'.
     */
    public java.lang.String getSzCdApsOutcomeAction()
    {
        return this._szCdApsOutcomeAction;
    } //-- java.lang.String getSzCdApsOutcomeAction() 

    /**
     * Returns the value of field 'szCdApsOutcomeActnCateg'.
     * 
     * @return the value of field 'SzCdApsOutcomeActnCateg'.
     */
    public java.lang.String getSzCdApsOutcomeActnCateg()
    {
        return this._szCdApsOutcomeActnCateg;
    } //-- java.lang.String getSzCdApsOutcomeActnCateg() 

    /**
     * Returns the value of field 'szCdApsOutcomeResult'.
     * 
     * @return the value of field 'SzCdApsOutcomeResult'.
     */
    public java.lang.String getSzCdApsOutcomeResult()
    {
        return this._szCdApsOutcomeResult;
    } //-- java.lang.String getSzCdApsOutcomeResult() 

    /**
     * Returns the value of field 'szCdDomain'.
     * 
     * @return the value of field 'SzCdDomain'.
     */
    public java.lang.String getSzCdDomain()
    {
        return this._szCdDomain;
    } //-- java.lang.String getSzCdDomain() 

    /**
     * Returns the value of field 'szTxtApsCltFactorCmnts'.
     * 
     * @return the value of field 'SzTxtApsCltFactorCmnts'.
     */
    public java.lang.String getSzTxtApsCltFactorCmnts()
    {
        return this._szTxtApsCltFactorCmnts;
    } //-- java.lang.String getSzTxtApsCltFactorCmnts() 

    /**
     * Returns the value of field 'szTxtApsOutcomeAction'.
     * 
     * @return the value of field 'SzTxtApsOutcomeAction'.
     */
    public java.lang.String getSzTxtApsOutcomeAction()
    {
        return this._szTxtApsOutcomeAction;
    } //-- java.lang.String getSzTxtApsOutcomeAction() 

    /**
     * Returns the value of field 'szTxtApsOutcomeResult'.
     * 
     * @return the value of field 'SzTxtApsOutcomeResult'.
     */
    public java.lang.String getSzTxtApsOutcomeResult()
    {
        return this._szTxtApsOutcomeResult;
    } //-- java.lang.String getSzTxtApsOutcomeResult() 

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
     * Returns the value of field 'ulIdApsCltFactor'.
     * 
     * @return the value of field 'UlIdApsCltFactor'.
     */
    public int getUlIdApsCltFactor()
    {
        return this._ulIdApsCltFactor;
    } //-- int getUlIdApsCltFactor() 

    /**
     * Returns the value of field 'ulIdApsOutcomeMatrix'.
     * 
     * @return the value of field 'UlIdApsOutcomeMatrix'.
     */
    public int getUlIdApsOutcomeMatrix()
    {
        return this._ulIdApsOutcomeMatrix;
    } //-- int getUlIdApsOutcomeMatrix() 

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
     * Method hasUlIdApsCltFactor
     * 
     * 
     * 
     * @return true if at least one UlIdApsCltFactor has been added
     */
    public boolean hasUlIdApsCltFactor()
    {
        return this._has_ulIdApsCltFactor;
    } //-- boolean hasUlIdApsCltFactor() 

    /**
     * Method hasUlIdApsOutcomeMatrix
     * 
     * 
     * 
     * @return true if at least one UlIdApsOutcomeMatrix has been
     * added
     */
    public boolean hasUlIdApsOutcomeMatrix()
    {
        return this._has_ulIdApsOutcomeMatrix;
    } //-- boolean hasUlIdApsOutcomeMatrix() 

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
     * Sets the value of field 'cCdApsClientFactor'.
     * 
     * @param cCdApsClientFactor the value of field
     * 'cCdApsClientFactor'.
     */
    public void setCCdApsClientFactor(java.lang.String cCdApsClientFactor)
    {
        this._cCdApsClientFactor = cCdApsClientFactor;
    } //-- void setCCdApsClientFactor(java.lang.String) 

    /**
     * Sets the value of field 'cIndApsOutcomeOrigFctr'.
     * 
     * @param cIndApsOutcomeOrigFctr the value of field
     * 'cIndApsOutcomeOrigFctr'.
     */
    public void setCIndApsOutcomeOrigFctr(java.lang.String cIndApsOutcomeOrigFctr)
    {
        this._cIndApsOutcomeOrigFctr = cIndApsOutcomeOrigFctr;
    } //-- void setCIndApsOutcomeOrigFctr(java.lang.String) 

    /**
     * Sets the value of field 'dtDtApsOutcomeAction'.
     * 
     * @param dtDtApsOutcomeAction the value of field
     * 'dtDtApsOutcomeAction'.
     */
    public void setDtDtApsOutcomeAction(org.exolab.castor.types.Date dtDtApsOutcomeAction)
    {
        this._dtDtApsOutcomeAction = dtDtApsOutcomeAction;
    } //-- void setDtDtApsOutcomeAction(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtApsOutcomeProblem'.
     * 
     * @param dtDtApsOutcomeProblem the value of field
     * 'dtDtApsOutcomeProblem'.
     */
    public void setDtDtApsOutcomeProblem(org.exolab.castor.types.Date dtDtApsOutcomeProblem)
    {
        this._dtDtApsOutcomeProblem = dtDtApsOutcomeProblem;
    } //-- void setDtDtApsOutcomeProblem(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtApsOutcomeRecord'.
     * 
     * @param dtDtApsOutcomeRecord the value of field
     * 'dtDtApsOutcomeRecord'.
     */
    public void setDtDtApsOutcomeRecord(org.exolab.castor.types.Date dtDtApsOutcomeRecord)
    {
        this._dtDtApsOutcomeRecord = dtDtApsOutcomeRecord;
    } //-- void setDtDtApsOutcomeRecord(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdApsClientFactor'.
     * 
     * @param szCdApsClientFactor the value of field
     * 'szCdApsClientFactor'.
     */
    public void setSzCdApsClientFactor(java.lang.String szCdApsClientFactor)
    {
        this._szCdApsClientFactor = szCdApsClientFactor;
    } //-- void setSzCdApsClientFactor(java.lang.String) 

    /**
     * Sets the value of field 'szCdApsOutcomeAction'.
     * 
     * @param szCdApsOutcomeAction the value of field
     * 'szCdApsOutcomeAction'.
     */
    public void setSzCdApsOutcomeAction(java.lang.String szCdApsOutcomeAction)
    {
        this._szCdApsOutcomeAction = szCdApsOutcomeAction;
    } //-- void setSzCdApsOutcomeAction(java.lang.String) 

    /**
     * Sets the value of field 'szCdApsOutcomeActnCateg'.
     * 
     * @param szCdApsOutcomeActnCateg the value of field
     * 'szCdApsOutcomeActnCateg'.
     */
    public void setSzCdApsOutcomeActnCateg(java.lang.String szCdApsOutcomeActnCateg)
    {
        this._szCdApsOutcomeActnCateg = szCdApsOutcomeActnCateg;
    } //-- void setSzCdApsOutcomeActnCateg(java.lang.String) 

    /**
     * Sets the value of field 'szCdApsOutcomeResult'.
     * 
     * @param szCdApsOutcomeResult the value of field
     * 'szCdApsOutcomeResult'.
     */
    public void setSzCdApsOutcomeResult(java.lang.String szCdApsOutcomeResult)
    {
        this._szCdApsOutcomeResult = szCdApsOutcomeResult;
    } //-- void setSzCdApsOutcomeResult(java.lang.String) 

    /**
     * Sets the value of field 'szCdDomain'.
     * 
     * @param szCdDomain the value of field 'szCdDomain'.
     */
    public void setSzCdDomain(java.lang.String szCdDomain)
    {
        this._szCdDomain = szCdDomain;
    } //-- void setSzCdDomain(java.lang.String) 

    /**
     * Sets the value of field 'szTxtApsCltFactorCmnts'.
     * 
     * @param szTxtApsCltFactorCmnts the value of field
     * 'szTxtApsCltFactorCmnts'.
     */
    public void setSzTxtApsCltFactorCmnts(java.lang.String szTxtApsCltFactorCmnts)
    {
        this._szTxtApsCltFactorCmnts = szTxtApsCltFactorCmnts;
    } //-- void setSzTxtApsCltFactorCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtApsOutcomeAction'.
     * 
     * @param szTxtApsOutcomeAction the value of field
     * 'szTxtApsOutcomeAction'.
     */
    public void setSzTxtApsOutcomeAction(java.lang.String szTxtApsOutcomeAction)
    {
        this._szTxtApsOutcomeAction = szTxtApsOutcomeAction;
    } //-- void setSzTxtApsOutcomeAction(java.lang.String) 

    /**
     * Sets the value of field 'szTxtApsOutcomeResult'.
     * 
     * @param szTxtApsOutcomeResult the value of field
     * 'szTxtApsOutcomeResult'.
     */
    public void setSzTxtApsOutcomeResult(java.lang.String szTxtApsOutcomeResult)
    {
        this._szTxtApsOutcomeResult = szTxtApsOutcomeResult;
    } //-- void setSzTxtApsOutcomeResult(java.lang.String) 

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
     * Sets the value of field 'ulIdApsCltFactor'.
     * 
     * @param ulIdApsCltFactor the value of field 'ulIdApsCltFactor'
     */
    public void setUlIdApsCltFactor(int ulIdApsCltFactor)
    {
        this._ulIdApsCltFactor = ulIdApsCltFactor;
        this._has_ulIdApsCltFactor = true;
    } //-- void setUlIdApsCltFactor(int) 

    /**
     * Sets the value of field 'ulIdApsOutcomeMatrix'.
     * 
     * @param ulIdApsOutcomeMatrix the value of field
     * 'ulIdApsOutcomeMatrix'.
     */
    public void setUlIdApsOutcomeMatrix(int ulIdApsOutcomeMatrix)
    {
        this._ulIdApsOutcomeMatrix = ulIdApsOutcomeMatrix;
        this._has_ulIdApsOutcomeMatrix = true;
    } //-- void setUlIdApsOutcomeMatrix(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO unmarshal(java.io.Reader) 

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
