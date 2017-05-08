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
 * Class ROWCCMN04SOG02.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN04SOG02 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szBjnJob
     */
    private java.lang.String _szBjnJob;

    /**
     * Field _szCdJobClass
     */
    private java.lang.String _szCdJobClass;

    /**
     * Field _szCdJobTitle
     */
    private java.lang.String _szCdJobTitle;

    /**
     * Field _szCdJobFunction
     */
    private java.lang.String _szCdJobFunction;

    /**
     * Field _szTextErsNumber
     */
    private java.lang.String _szTextErsNumber;

    /**
     * Field _dtDtJobEnd
     */
    private org.exolab.castor.types.Date _dtDtJobEnd;

    /**
     * Field _dtDtJobStart
     */
    private org.exolab.castor.types.Date _dtDtJobStart;

    /**
     * Field _ulIdEmpJobHistory
     */
    private int _ulIdEmpJobHistory;

    /**
     * keeps track of state for field: _ulIdEmpJobHistory
     */
    private boolean _has_ulIdEmpJobHistory;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdJobPersSupv
     */
    private int _ulIdJobPersSupv;

    /**
     * keeps track of state for field: _ulIdJobPersSupv
     */
    private boolean _has_ulIdJobPersSupv;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _bIndJobAssignable
     */
    private java.lang.String _bIndJobAssignable;

    /**
     * Field _bIndCaseAssignable
     */
    private java.lang.String _bIndCaseAssignable;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN04SOG02() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEmpJobHistory()
    {
        this._has_ulIdEmpJobHistory= false;
    } //-- void deleteUlIdEmpJobHistory() 

    /**
     */
    public void deleteUlIdJobPersSupv()
    {
        this._has_ulIdJobPersSupv= false;
    } //-- void deleteUlIdJobPersSupv() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'bIndCaseAssignable'.
     * 
     * @return the value of field 'BIndCaseAssignable'.
     */
    public java.lang.String getBIndCaseAssignable()
    {
        return this._bIndCaseAssignable;
    } //-- java.lang.String getBIndCaseAssignable() 

    /**
     * Returns the value of field 'bIndJobAssignable'.
     * 
     * @return the value of field 'BIndJobAssignable'.
     */
    public java.lang.String getBIndJobAssignable()
    {
        return this._bIndJobAssignable;
    } //-- java.lang.String getBIndJobAssignable() 

    /**
     * Returns the value of field 'dtDtJobEnd'.
     * 
     * @return the value of field 'DtDtJobEnd'.
     */
    public org.exolab.castor.types.Date getDtDtJobEnd()
    {
        return this._dtDtJobEnd;
    } //-- org.exolab.castor.types.Date getDtDtJobEnd() 

    /**
     * Returns the value of field 'dtDtJobStart'.
     * 
     * @return the value of field 'DtDtJobStart'.
     */
    public org.exolab.castor.types.Date getDtDtJobStart()
    {
        return this._dtDtJobStart;
    } //-- org.exolab.castor.types.Date getDtDtJobStart() 

    /**
     * Returns the value of field 'szBjnJob'.
     * 
     * @return the value of field 'SzBjnJob'.
     */
    public java.lang.String getSzBjnJob()
    {
        return this._szBjnJob;
    } //-- java.lang.String getSzBjnJob() 

    /**
     * Returns the value of field 'szCdJobClass'.
     * 
     * @return the value of field 'SzCdJobClass'.
     */
    public java.lang.String getSzCdJobClass()
    {
        return this._szCdJobClass;
    } //-- java.lang.String getSzCdJobClass() 

    /**
     * Returns the value of field 'szCdJobFunction'.
     * 
     * @return the value of field 'SzCdJobFunction'.
     */
    public java.lang.String getSzCdJobFunction()
    {
        return this._szCdJobFunction;
    } //-- java.lang.String getSzCdJobFunction() 

    /**
     * Returns the value of field 'szCdJobTitle'.
     * 
     * @return the value of field 'SzCdJobTitle'.
     */
    public java.lang.String getSzCdJobTitle()
    {
        return this._szCdJobTitle;
    } //-- java.lang.String getSzCdJobTitle() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szTextErsNumber'.
     * 
     * @return the value of field 'SzTextErsNumber'.
     */
    public java.lang.String getSzTextErsNumber()
    {
        return this._szTextErsNumber;
    } //-- java.lang.String getSzTextErsNumber() 

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
     * Returns the value of field 'ulIdEmpJobHistory'.
     * 
     * @return the value of field 'UlIdEmpJobHistory'.
     */
    public int getUlIdEmpJobHistory()
    {
        return this._ulIdEmpJobHistory;
    } //-- int getUlIdEmpJobHistory() 

    /**
     * Returns the value of field 'ulIdJobPersSupv'.
     * 
     * @return the value of field 'UlIdJobPersSupv'.
     */
    public int getUlIdJobPersSupv()
    {
        return this._ulIdJobPersSupv;
    } //-- int getUlIdJobPersSupv() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Method hasUlIdEmpJobHistory
     * 
     * 
     * 
     * @return true if at least one UlIdEmpJobHistory has been added
     */
    public boolean hasUlIdEmpJobHistory()
    {
        return this._has_ulIdEmpJobHistory;
    } //-- boolean hasUlIdEmpJobHistory() 

    /**
     * Method hasUlIdJobPersSupv
     * 
     * 
     * 
     * @return true if at least one UlIdJobPersSupv has been added
     */
    public boolean hasUlIdJobPersSupv()
    {
        return this._has_ulIdJobPersSupv;
    } //-- boolean hasUlIdJobPersSupv() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

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
     * Sets the value of field 'bIndCaseAssignable'.
     * 
     * @param bIndCaseAssignable the value of field
     * 'bIndCaseAssignable'.
     */
    public void setBIndCaseAssignable(java.lang.String bIndCaseAssignable)
    {
        this._bIndCaseAssignable = bIndCaseAssignable;
    } //-- void setBIndCaseAssignable(java.lang.String) 

    /**
     * Sets the value of field 'bIndJobAssignable'.
     * 
     * @param bIndJobAssignable the value of field
     * 'bIndJobAssignable'.
     */
    public void setBIndJobAssignable(java.lang.String bIndJobAssignable)
    {
        this._bIndJobAssignable = bIndJobAssignable;
    } //-- void setBIndJobAssignable(java.lang.String) 

    /**
     * Sets the value of field 'dtDtJobEnd'.
     * 
     * @param dtDtJobEnd the value of field 'dtDtJobEnd'.
     */
    public void setDtDtJobEnd(org.exolab.castor.types.Date dtDtJobEnd)
    {
        this._dtDtJobEnd = dtDtJobEnd;
    } //-- void setDtDtJobEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtJobStart'.
     * 
     * @param dtDtJobStart the value of field 'dtDtJobStart'.
     */
    public void setDtDtJobStart(org.exolab.castor.types.Date dtDtJobStart)
    {
        this._dtDtJobStart = dtDtJobStart;
    } //-- void setDtDtJobStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szBjnJob'.
     * 
     * @param szBjnJob the value of field 'szBjnJob'.
     */
    public void setSzBjnJob(java.lang.String szBjnJob)
    {
        this._szBjnJob = szBjnJob;
    } //-- void setSzBjnJob(java.lang.String) 

    /**
     * Sets the value of field 'szCdJobClass'.
     * 
     * @param szCdJobClass the value of field 'szCdJobClass'.
     */
    public void setSzCdJobClass(java.lang.String szCdJobClass)
    {
        this._szCdJobClass = szCdJobClass;
    } //-- void setSzCdJobClass(java.lang.String) 

    /**
     * Sets the value of field 'szCdJobFunction'.
     * 
     * @param szCdJobFunction the value of field 'szCdJobFunction'.
     */
    public void setSzCdJobFunction(java.lang.String szCdJobFunction)
    {
        this._szCdJobFunction = szCdJobFunction;
    } //-- void setSzCdJobFunction(java.lang.String) 

    /**
     * Sets the value of field 'szCdJobTitle'.
     * 
     * @param szCdJobTitle the value of field 'szCdJobTitle'.
     */
    public void setSzCdJobTitle(java.lang.String szCdJobTitle)
    {
        this._szCdJobTitle = szCdJobTitle;
    } //-- void setSzCdJobTitle(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szTextErsNumber'.
     * 
     * @param szTextErsNumber the value of field 'szTextErsNumber'.
     */
    public void setSzTextErsNumber(java.lang.String szTextErsNumber)
    {
        this._szTextErsNumber = szTextErsNumber;
    } //-- void setSzTextErsNumber(java.lang.String) 

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
     * Sets the value of field 'ulIdEmpJobHistory'.
     * 
     * @param ulIdEmpJobHistory the value of field
     * 'ulIdEmpJobHistory'.
     */
    public void setUlIdEmpJobHistory(int ulIdEmpJobHistory)
    {
        this._ulIdEmpJobHistory = ulIdEmpJobHistory;
        this._has_ulIdEmpJobHistory = true;
    } //-- void setUlIdEmpJobHistory(int) 

    /**
     * Sets the value of field 'ulIdJobPersSupv'.
     * 
     * @param ulIdJobPersSupv the value of field 'ulIdJobPersSupv'.
     */
    public void setUlIdJobPersSupv(int ulIdJobPersSupv)
    {
        this._ulIdJobPersSupv = ulIdJobPersSupv;
        this._has_ulIdJobPersSupv = true;
    } //-- void setUlIdJobPersSupv(int) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02 unmarshal(java.io.Reader) 

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
