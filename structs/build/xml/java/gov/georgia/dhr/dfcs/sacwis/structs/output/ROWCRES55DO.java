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
 * Class ROWCRES55DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES55DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _idCaretaker
     */
    private int _idCaretaker;

    /**
     * keeps track of state for field: _idCaretaker
     */
    private boolean _has_idCaretaker;

    /**
     * Field _nbrCaretkr
     */
    private java.lang.String _nbrCaretkr;

    /**
     * Field _szNmCaretkrFname
     */
    private java.lang.String _szNmCaretkrFname;

    /**
     * Field _szNmCaretkrLname
     */
    private java.lang.String _szNmCaretkrLname;

    /**
     * Field _szNmCaretkrMname
     */
    private java.lang.String _szNmCaretkrMname;

    /**
     * Field _cdCaretkrEthnic
     */
    private java.lang.String _cdCaretkrEthnic;

    /**
     * Field _cdCaretkrRace
     */
    private java.lang.String _cdCaretkrRace;

    /**
     * Field _cdCaretkrSex
     */
    private java.lang.String _cdCaretkrSex;

    /**
     * Field _dtCaretkrBirth
     */
    private org.exolab.castor.types.Date _dtCaretkrBirth;

    /**
     * Field _cd_Home_Marital_Status
     */
    private java.lang.String _cd_Home_Marital_Status;

    /**
     * Field _dtEnd
     */
    private org.exolab.castor.types.Date _dtEnd;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES55DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIdCaretaker()
    {
        this._has_idCaretaker= false;
    } //-- void deleteIdCaretaker() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     * Returns the value of field 'cdCaretkrEthnic'.
     * 
     * @return the value of field 'CdCaretkrEthnic'.
     */
    public java.lang.String getCdCaretkrEthnic()
    {
        return this._cdCaretkrEthnic;
    } //-- java.lang.String getCdCaretkrEthnic() 

    /**
     * Returns the value of field 'cdCaretkrRace'.
     * 
     * @return the value of field 'CdCaretkrRace'.
     */
    public java.lang.String getCdCaretkrRace()
    {
        return this._cdCaretkrRace;
    } //-- java.lang.String getCdCaretkrRace() 

    /**
     * Returns the value of field 'cdCaretkrSex'.
     * 
     * @return the value of field 'CdCaretkrSex'.
     */
    public java.lang.String getCdCaretkrSex()
    {
        return this._cdCaretkrSex;
    } //-- java.lang.String getCdCaretkrSex() 

    /**
     * Returns the value of field 'cd_Home_Marital_Status'.
     * 
     * @return the value of field 'Cd_Home_Marital_Status'.
     */
    public java.lang.String getCd_Home_Marital_Status()
    {
        return this._cd_Home_Marital_Status;
    } //-- java.lang.String getCd_Home_Marital_Status() 

    /**
     * Returns the value of field 'dtCaretkrBirth'.
     * 
     * @return the value of field 'DtCaretkrBirth'.
     */
    public org.exolab.castor.types.Date getDtCaretkrBirth()
    {
        return this._dtCaretkrBirth;
    } //-- org.exolab.castor.types.Date getDtCaretkrBirth() 

    /**
     * Returns the value of field 'dtEnd'.
     * 
     * @return the value of field 'DtEnd'.
     */
    public org.exolab.castor.types.Date getDtEnd()
    {
        return this._dtEnd;
    } //-- org.exolab.castor.types.Date getDtEnd() 

    /**
     * Returns the value of field 'idCaretaker'.
     * 
     * @return the value of field 'IdCaretaker'.
     */
    public int getIdCaretaker()
    {
        return this._idCaretaker;
    } //-- int getIdCaretaker() 

    /**
     * Returns the value of field 'nbrCaretkr'.
     * 
     * @return the value of field 'NbrCaretkr'.
     */
    public java.lang.String getNbrCaretkr()
    {
        return this._nbrCaretkr;
    } //-- java.lang.String getNbrCaretkr() 

    /**
     * Returns the value of field 'szNmCaretkrFname'.
     * 
     * @return the value of field 'SzNmCaretkrFname'.
     */
    public java.lang.String getSzNmCaretkrFname()
    {
        return this._szNmCaretkrFname;
    } //-- java.lang.String getSzNmCaretkrFname() 

    /**
     * Returns the value of field 'szNmCaretkrLname'.
     * 
     * @return the value of field 'SzNmCaretkrLname'.
     */
    public java.lang.String getSzNmCaretkrLname()
    {
        return this._szNmCaretkrLname;
    } //-- java.lang.String getSzNmCaretkrLname() 

    /**
     * Returns the value of field 'szNmCaretkrMname'.
     * 
     * @return the value of field 'SzNmCaretkrMname'.
     */
    public java.lang.String getSzNmCaretkrMname()
    {
        return this._szNmCaretkrMname;
    } //-- java.lang.String getSzNmCaretkrMname() 

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
     * Method hasIdCaretaker
     * 
     * 
     * 
     * @return true if at least one IdCaretaker has been added
     */
    public boolean hasIdCaretaker()
    {
        return this._has_idCaretaker;
    } //-- boolean hasIdCaretaker() 

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
     * Sets the value of field 'cdCaretkrEthnic'.
     * 
     * @param cdCaretkrEthnic the value of field 'cdCaretkrEthnic'.
     */
    public void setCdCaretkrEthnic(java.lang.String cdCaretkrEthnic)
    {
        this._cdCaretkrEthnic = cdCaretkrEthnic;
    } //-- void setCdCaretkrEthnic(java.lang.String) 

    /**
     * Sets the value of field 'cdCaretkrRace'.
     * 
     * @param cdCaretkrRace the value of field 'cdCaretkrRace'.
     */
    public void setCdCaretkrRace(java.lang.String cdCaretkrRace)
    {
        this._cdCaretkrRace = cdCaretkrRace;
    } //-- void setCdCaretkrRace(java.lang.String) 

    /**
     * Sets the value of field 'cdCaretkrSex'.
     * 
     * @param cdCaretkrSex the value of field 'cdCaretkrSex'.
     */
    public void setCdCaretkrSex(java.lang.String cdCaretkrSex)
    {
        this._cdCaretkrSex = cdCaretkrSex;
    } //-- void setCdCaretkrSex(java.lang.String) 

    /**
     * Sets the value of field 'cd_Home_Marital_Status'.
     * 
     * @param cd_Home_Marital_Status the value of field
     * 'cd_Home_Marital_Status'.
     */
    public void setCd_Home_Marital_Status(java.lang.String cd_Home_Marital_Status)
    {
        this._cd_Home_Marital_Status = cd_Home_Marital_Status;
    } //-- void setCd_Home_Marital_Status(java.lang.String) 

    /**
     * Sets the value of field 'dtCaretkrBirth'.
     * 
     * @param dtCaretkrBirth the value of field 'dtCaretkrBirth'.
     */
    public void setDtCaretkrBirth(org.exolab.castor.types.Date dtCaretkrBirth)
    {
        this._dtCaretkrBirth = dtCaretkrBirth;
    } //-- void setDtCaretkrBirth(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtEnd'.
     * 
     * @param dtEnd the value of field 'dtEnd'.
     */
    public void setDtEnd(org.exolab.castor.types.Date dtEnd)
    {
        this._dtEnd = dtEnd;
    } //-- void setDtEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'idCaretaker'.
     * 
     * @param idCaretaker the value of field 'idCaretaker'.
     */
    public void setIdCaretaker(int idCaretaker)
    {
        this._idCaretaker = idCaretaker;
        this._has_idCaretaker = true;
    } //-- void setIdCaretaker(int) 

    /**
     * Sets the value of field 'nbrCaretkr'.
     * 
     * @param nbrCaretkr the value of field 'nbrCaretkr'.
     */
    public void setNbrCaretkr(java.lang.String nbrCaretkr)
    {
        this._nbrCaretkr = nbrCaretkr;
    } //-- void setNbrCaretkr(java.lang.String) 

    /**
     * Sets the value of field 'szNmCaretkrFname'.
     * 
     * @param szNmCaretkrFname the value of field 'szNmCaretkrFname'
     */
    public void setSzNmCaretkrFname(java.lang.String szNmCaretkrFname)
    {
        this._szNmCaretkrFname = szNmCaretkrFname;
    } //-- void setSzNmCaretkrFname(java.lang.String) 

    /**
     * Sets the value of field 'szNmCaretkrLname'.
     * 
     * @param szNmCaretkrLname the value of field 'szNmCaretkrLname'
     */
    public void setSzNmCaretkrLname(java.lang.String szNmCaretkrLname)
    {
        this._szNmCaretkrLname = szNmCaretkrLname;
    } //-- void setSzNmCaretkrLname(java.lang.String) 

    /**
     * Sets the value of field 'szNmCaretkrMname'.
     * 
     * @param szNmCaretkrMname the value of field 'szNmCaretkrMname'
     */
    public void setSzNmCaretkrMname(java.lang.String szNmCaretkrMname)
    {
        this._szNmCaretkrMname = szNmCaretkrMname;
    } //-- void setSzNmCaretkrMname(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO unmarshal(java.io.Reader) 

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
