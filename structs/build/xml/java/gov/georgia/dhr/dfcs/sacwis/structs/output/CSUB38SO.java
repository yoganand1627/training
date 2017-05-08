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
 * Class CSUB38SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB38SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSUB38SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG00 _ROWCSUB38SOG00;

    /**
     * Field _ROWCSUB38SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01 _ROWCSUB38SOG01;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szScrTxtNarrStatus
     */
    private java.lang.String _szScrTxtNarrStatus;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _dtSysDtGenericSysdate
     */
    private org.exolab.castor.types.Date _dtSysDtGenericSysdate;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _attendeePerson_Array
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array _attendeePerson_Array;

    /**
     * Field _szCdOutcome_Array
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array _szCdOutcome_Array;

    /**
     * Field _szCdCrtLang_Array
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array _szCdCrtLang_Array;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB38SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'attendeePerson_Array'.
     * 
     * @return the value of field 'AttendeePerson_Array'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array getAttendeePerson_Array()
    {
        return this._attendeePerson_Array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array getAttendeePerson_Array() 

    /**
     * Returns the value of field 'dtSysDtGenericSysdate'.
     * 
     * @return the value of field 'DtSysDtGenericSysdate'.
     */
    public org.exolab.castor.types.Date getDtSysDtGenericSysdate()
    {
        return this._dtSysDtGenericSysdate;
    } //-- org.exolab.castor.types.Date getDtSysDtGenericSysdate() 

    /**
     * Returns the value of field 'ROWCSUB38SOG00'.
     * 
     * @return the value of field 'ROWCSUB38SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG00 getROWCSUB38SOG00()
    {
        return this._ROWCSUB38SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG00 getROWCSUB38SOG00() 

    /**
     * Returns the value of field 'ROWCSUB38SOG01'.
     * 
     * @return the value of field 'ROWCSUB38SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01 getROWCSUB38SOG01()
    {
        return this._ROWCSUB38SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01 getROWCSUB38SOG01() 

    /**
     * Returns the value of field 'szCdCrtLang_Array'.
     * 
     * @return the value of field 'SzCdCrtLang_Array'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array getSzCdCrtLang_Array()
    {
        return this._szCdCrtLang_Array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array getSzCdCrtLang_Array() 

    /**
     * Returns the value of field 'szCdOutcome_Array'.
     * 
     * @return the value of field 'SzCdOutcome_Array'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array getSzCdOutcome_Array()
    {
        return this._szCdOutcome_Array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array getSzCdOutcome_Array() 

    /**
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

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
     * Returns the value of field 'szScrTxtNarrStatus'.
     * 
     * @return the value of field 'SzScrTxtNarrStatus'.
     */
    public java.lang.String getSzScrTxtNarrStatus()
    {
        return this._szScrTxtNarrStatus;
    } //-- java.lang.String getSzScrTxtNarrStatus() 

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
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

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
     * Sets the value of field 'attendeePerson_Array'.
     * 
     * @param attendeePerson_Array the value of field
     * 'attendeePerson_Array'.
     */
    public void setAttendeePerson_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array attendeePerson_Array)
    {
        this._attendeePerson_Array = attendeePerson_Array;
    } //-- void setAttendeePerson_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array) 

    /**
     * Sets the value of field 'dtSysDtGenericSysdate'.
     * 
     * @param dtSysDtGenericSysdate the value of field
     * 'dtSysDtGenericSysdate'.
     */
    public void setDtSysDtGenericSysdate(org.exolab.castor.types.Date dtSysDtGenericSysdate)
    {
        this._dtSysDtGenericSysdate = dtSysDtGenericSysdate;
    } //-- void setDtSysDtGenericSysdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ROWCSUB38SOG00'.
     * 
     * @param ROWCSUB38SOG00 the value of field 'ROWCSUB38SOG00'.
     */
    public void setROWCSUB38SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG00 ROWCSUB38SOG00)
    {
        this._ROWCSUB38SOG00 = ROWCSUB38SOG00;
    } //-- void setROWCSUB38SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG00) 

    /**
     * Sets the value of field 'ROWCSUB38SOG01'.
     * 
     * @param ROWCSUB38SOG01 the value of field 'ROWCSUB38SOG01'.
     */
    public void setROWCSUB38SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01 ROWCSUB38SOG01)
    {
        this._ROWCSUB38SOG01 = ROWCSUB38SOG01;
    } //-- void setROWCSUB38SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01) 

    /**
     * Sets the value of field 'szCdCrtLang_Array'.
     * 
     * @param szCdCrtLang_Array the value of field
     * 'szCdCrtLang_Array'.
     */
    public void setSzCdCrtLang_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array szCdCrtLang_Array)
    {
        this._szCdCrtLang_Array = szCdCrtLang_Array;
    } //-- void setSzCdCrtLang_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array) 

    /**
     * Sets the value of field 'szCdOutcome_Array'.
     * 
     * @param szCdOutcome_Array the value of field
     * 'szCdOutcome_Array'.
     */
    public void setSzCdOutcome_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array szCdOutcome_Array)
    {
        this._szCdOutcome_Array = szCdOutcome_Array;
    } //-- void setSzCdOutcome_Array(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array) 

    /**
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

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
     * Sets the value of field 'szScrTxtNarrStatus'.
     * 
     * @param szScrTxtNarrStatus the value of field
     * 'szScrTxtNarrStatus'.
     */
    public void setSzScrTxtNarrStatus(java.lang.String szScrTxtNarrStatus)
    {
        this._szScrTxtNarrStatus = szScrTxtNarrStatus;
    } //-- void setSzScrTxtNarrStatus(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO unmarshal(java.io.Reader) 

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
