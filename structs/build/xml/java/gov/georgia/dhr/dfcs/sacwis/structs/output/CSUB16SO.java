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
 * Class CSUB16SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB16SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _tsLastUpdate_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY _tsLastUpdate_ARRAY;

    /**
     * Field _szCdPlocChild
     */
    private java.lang.String _szCdPlocChild;

    /**
     * Field _szCdPlocType
     */
    private java.lang.String _szCdPlocType;

    /**
     * Field _dtDtPlocEnd
     */
    private org.exolab.castor.types.Date _dtDtPlocEnd;

    /**
     * Field _dtDtPlocStart
     */
    private org.exolab.castor.types.Date _dtDtPlocStart;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _ulIdEventPerson
     */
    private int _ulIdEventPerson;

    /**
     * keeps track of state for field: _ulIdEventPerson
     */
    private boolean _has_ulIdEventPerson;

    /**
     * Field _szTxtComments
     */
    private java.lang.String _szTxtComments;

    /**
     * Field _dtDtSubTpr
     */
    private org.exolab.castor.types.Date _dtDtSubTpr;

    /**
     * Field _dtDtRevCmplt
     */
    private org.exolab.castor.types.Date _dtDtRevCmplt;

    /**
     * Field _szNmTprCons
     */
    private java.lang.String _szNmTprCons;

    /**
     * Field _dtDtRevCondct
     */
    private org.exolab.castor.types.Date _dtDtRevCondct;

    /**
     * Field _szCdLvlChg
     */
    private java.lang.String _szCdLvlChg;

    /**
     * Field _szCdPlcmtSetting
     */
    private java.lang.String _szCdPlcmtSetting;

    /**
     * Field _szCdRevType
     */
    private java.lang.String _szCdRevType;

    /**
     * Field _CSUB16SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SOG00 _CSUB16SOG00;

    /**
     * Field _szNmPersUpdt
     */
    private java.lang.String _szNmPersUpdt;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB16SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEventPerson()
    {
        this._has_ulIdEventPerson= false;
    } //-- void deleteUlIdEventPerson() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'CSUB16SOG00'.
     * 
     * @return the value of field 'CSUB16SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SOG00 getCSUB16SOG00()
    {
        return this._CSUB16SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SOG00 getCSUB16SOG00() 

    /**
     * Returns the value of field 'dtDtPlocEnd'.
     * 
     * @return the value of field 'DtDtPlocEnd'.
     */
    public org.exolab.castor.types.Date getDtDtPlocEnd()
    {
        return this._dtDtPlocEnd;
    } //-- org.exolab.castor.types.Date getDtDtPlocEnd() 

    /**
     * Returns the value of field 'dtDtPlocStart'.
     * 
     * @return the value of field 'DtDtPlocStart'.
     */
    public org.exolab.castor.types.Date getDtDtPlocStart()
    {
        return this._dtDtPlocStart;
    } //-- org.exolab.castor.types.Date getDtDtPlocStart() 

    /**
     * Returns the value of field 'dtDtRevCmplt'.
     * 
     * @return the value of field 'DtDtRevCmplt'.
     */
    public org.exolab.castor.types.Date getDtDtRevCmplt()
    {
        return this._dtDtRevCmplt;
    } //-- org.exolab.castor.types.Date getDtDtRevCmplt() 

    /**
     * Returns the value of field 'dtDtRevCondct'.
     * 
     * @return the value of field 'DtDtRevCondct'.
     */
    public org.exolab.castor.types.Date getDtDtRevCondct()
    {
        return this._dtDtRevCondct;
    } //-- org.exolab.castor.types.Date getDtDtRevCondct() 

    /**
     * Returns the value of field 'dtDtSubTpr'.
     * 
     * @return the value of field 'DtDtSubTpr'.
     */
    public org.exolab.castor.types.Date getDtDtSubTpr()
    {
        return this._dtDtSubTpr;
    } //-- org.exolab.castor.types.Date getDtDtSubTpr() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'szCdEventStatus'.
     * 
     * @return the value of field 'SzCdEventStatus'.
     */
    public java.lang.String getSzCdEventStatus()
    {
        return this._szCdEventStatus;
    } //-- java.lang.String getSzCdEventStatus() 

    /**
     * Returns the value of field 'szCdLvlChg'.
     * 
     * @return the value of field 'SzCdLvlChg'.
     */
    public java.lang.String getSzCdLvlChg()
    {
        return this._szCdLvlChg;
    } //-- java.lang.String getSzCdLvlChg() 

    /**
     * Returns the value of field 'szCdPlcmtSetting'.
     * 
     * @return the value of field 'SzCdPlcmtSetting'.
     */
    public java.lang.String getSzCdPlcmtSetting()
    {
        return this._szCdPlcmtSetting;
    } //-- java.lang.String getSzCdPlcmtSetting() 

    /**
     * Returns the value of field 'szCdPlocChild'.
     * 
     * @return the value of field 'SzCdPlocChild'.
     */
    public java.lang.String getSzCdPlocChild()
    {
        return this._szCdPlocChild;
    } //-- java.lang.String getSzCdPlocChild() 

    /**
     * Returns the value of field 'szCdPlocType'.
     * 
     * @return the value of field 'SzCdPlocType'.
     */
    public java.lang.String getSzCdPlocType()
    {
        return this._szCdPlocType;
    } //-- java.lang.String getSzCdPlocType() 

    /**
     * Returns the value of field 'szCdRevType'.
     * 
     * @return the value of field 'SzCdRevType'.
     */
    public java.lang.String getSzCdRevType()
    {
        return this._szCdRevType;
    } //-- java.lang.String getSzCdRevType() 

    /**
     * Returns the value of field 'szNmPersUpdt'.
     * 
     * @return the value of field 'SzNmPersUpdt'.
     */
    public java.lang.String getSzNmPersUpdt()
    {
        return this._szNmPersUpdt;
    } //-- java.lang.String getSzNmPersUpdt() 

    /**
     * Returns the value of field 'szNmTprCons'.
     * 
     * @return the value of field 'SzNmTprCons'.
     */
    public java.lang.String getSzNmTprCons()
    {
        return this._szNmTprCons;
    } //-- java.lang.String getSzNmTprCons() 

    /**
     * Returns the value of field 'szTxtComments'.
     * 
     * @return the value of field 'SzTxtComments'.
     */
    public java.lang.String getSzTxtComments()
    {
        return this._szTxtComments;
    } //-- java.lang.String getSzTxtComments() 

    /**
     * Returns the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY()
    {
        return this._tsLastUpdate_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY() 

    /**
     * Returns the value of field 'ulIdEventPerson'.
     * 
     * @return the value of field 'UlIdEventPerson'.
     */
    public int getUlIdEventPerson()
    {
        return this._ulIdEventPerson;
    } //-- int getUlIdEventPerson() 

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
     * Method hasUlIdEventPerson
     * 
     * 
     * 
     * @return true if at least one UlIdEventPerson has been added
     */
    public boolean hasUlIdEventPerson()
    {
        return this._has_ulIdEventPerson;
    } //-- boolean hasUlIdEventPerson() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'CSUB16SOG00'.
     * 
     * @param CSUB16SOG00 the value of field 'CSUB16SOG00'.
     */
    public void setCSUB16SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SOG00 CSUB16SOG00)
    {
        this._CSUB16SOG00 = CSUB16SOG00;
    } //-- void setCSUB16SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SOG00) 

    /**
     * Sets the value of field 'dtDtPlocEnd'.
     * 
     * @param dtDtPlocEnd the value of field 'dtDtPlocEnd'.
     */
    public void setDtDtPlocEnd(org.exolab.castor.types.Date dtDtPlocEnd)
    {
        this._dtDtPlocEnd = dtDtPlocEnd;
    } //-- void setDtDtPlocEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtPlocStart'.
     * 
     * @param dtDtPlocStart the value of field 'dtDtPlocStart'.
     */
    public void setDtDtPlocStart(org.exolab.castor.types.Date dtDtPlocStart)
    {
        this._dtDtPlocStart = dtDtPlocStart;
    } //-- void setDtDtPlocStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRevCmplt'.
     * 
     * @param dtDtRevCmplt the value of field 'dtDtRevCmplt'.
     */
    public void setDtDtRevCmplt(org.exolab.castor.types.Date dtDtRevCmplt)
    {
        this._dtDtRevCmplt = dtDtRevCmplt;
    } //-- void setDtDtRevCmplt(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtRevCondct'.
     * 
     * @param dtDtRevCondct the value of field 'dtDtRevCondct'.
     */
    public void setDtDtRevCondct(org.exolab.castor.types.Date dtDtRevCondct)
    {
        this._dtDtRevCondct = dtDtRevCondct;
    } //-- void setDtDtRevCondct(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtSubTpr'.
     * 
     * @param dtDtSubTpr the value of field 'dtDtSubTpr'.
     */
    public void setDtDtSubTpr(org.exolab.castor.types.Date dtDtSubTpr)
    {
        this._dtDtSubTpr = dtDtSubTpr;
    } //-- void setDtDtSubTpr(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdEventStatus'.
     * 
     * @param szCdEventStatus the value of field 'szCdEventStatus'.
     */
    public void setSzCdEventStatus(java.lang.String szCdEventStatus)
    {
        this._szCdEventStatus = szCdEventStatus;
    } //-- void setSzCdEventStatus(java.lang.String) 

    /**
     * Sets the value of field 'szCdLvlChg'.
     * 
     * @param szCdLvlChg the value of field 'szCdLvlChg'.
     */
    public void setSzCdLvlChg(java.lang.String szCdLvlChg)
    {
        this._szCdLvlChg = szCdLvlChg;
    } //-- void setSzCdLvlChg(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlcmtSetting'.
     * 
     * @param szCdPlcmtSetting the value of field 'szCdPlcmtSetting'
     */
    public void setSzCdPlcmtSetting(java.lang.String szCdPlcmtSetting)
    {
        this._szCdPlcmtSetting = szCdPlcmtSetting;
    } //-- void setSzCdPlcmtSetting(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlocChild'.
     * 
     * @param szCdPlocChild the value of field 'szCdPlocChild'.
     */
    public void setSzCdPlocChild(java.lang.String szCdPlocChild)
    {
        this._szCdPlocChild = szCdPlocChild;
    } //-- void setSzCdPlocChild(java.lang.String) 

    /**
     * Sets the value of field 'szCdPlocType'.
     * 
     * @param szCdPlocType the value of field 'szCdPlocType'.
     */
    public void setSzCdPlocType(java.lang.String szCdPlocType)
    {
        this._szCdPlocType = szCdPlocType;
    } //-- void setSzCdPlocType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRevType'.
     * 
     * @param szCdRevType the value of field 'szCdRevType'.
     */
    public void setSzCdRevType(java.lang.String szCdRevType)
    {
        this._szCdRevType = szCdRevType;
    } //-- void setSzCdRevType(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersUpdt'.
     * 
     * @param szNmPersUpdt the value of field 'szNmPersUpdt'.
     */
    public void setSzNmPersUpdt(java.lang.String szNmPersUpdt)
    {
        this._szNmPersUpdt = szNmPersUpdt;
    } //-- void setSzNmPersUpdt(java.lang.String) 

    /**
     * Sets the value of field 'szNmTprCons'.
     * 
     * @param szNmTprCons the value of field 'szNmTprCons'.
     */
    public void setSzNmTprCons(java.lang.String szNmTprCons)
    {
        this._szNmTprCons = szNmTprCons;
    } //-- void setSzNmTprCons(java.lang.String) 

    /**
     * Sets the value of field 'szTxtComments'.
     * 
     * @param szTxtComments the value of field 'szTxtComments'.
     */
    public void setSzTxtComments(java.lang.String szTxtComments)
    {
        this._szTxtComments = szTxtComments;
    } //-- void setSzTxtComments(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @param tsLastUpdate_ARRAY the value of field
     * 'tsLastUpdate_ARRAY'.
     */
    public void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY tsLastUpdate_ARRAY)
    {
        this._tsLastUpdate_ARRAY = tsLastUpdate_ARRAY;
    } //-- void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY) 

    /**
     * Sets the value of field 'ulIdEventPerson'.
     * 
     * @param ulIdEventPerson the value of field 'ulIdEventPerson'.
     */
    public void setUlIdEventPerson(int ulIdEventPerson)
    {
        this._ulIdEventPerson = ulIdEventPerson;
        this._has_ulIdEventPerson = true;
    } //-- void setUlIdEventPerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO unmarshal(java.io.Reader) 

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
