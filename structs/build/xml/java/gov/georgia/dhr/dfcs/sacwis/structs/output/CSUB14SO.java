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
 * Class CSUB14SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CSUB14SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtDtPersonBirth
     */
    private org.exolab.castor.types.Date _dtDtPersonBirth;

    /**
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _szCdPersonEthnicGroup
     */
    private java.lang.String _szCdPersonEthnicGroup;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _ROWCSUB14SOG04
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG04 _ROWCSUB14SOG04;

    /**
     * Field _ROWCSUB14SOG00
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00 _ROWCSUB14SOG00;

    /**
     * Field _ROWCSUB14SOG01_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01_ARRAY _ROWCSUB14SOG01_ARRAY;

    /**
     * Field _ROWCSUB14SOG02_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02_ARRAY _ROWCSUB14SOG02_ARRAY;

    /**
     * Field _ROWCSUB14SOG03_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY _ROWCSUB14SOG03_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CSUB14SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

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
     * Returns the value of field 'dtDtPersonBirth'.
     * 
     * @return the value of field 'DtDtPersonBirth'.
     */
    public org.exolab.castor.types.Date getDtDtPersonBirth()
    {
        return this._dtDtPersonBirth;
    } //-- org.exolab.castor.types.Date getDtDtPersonBirth() 

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
     * Returns the value of field 'ROWCSUB14SOG00'.
     * 
     * @return the value of field 'ROWCSUB14SOG00'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00 getROWCSUB14SOG00()
    {
        return this._ROWCSUB14SOG00;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00 getROWCSUB14SOG00() 

    /**
     * Returns the value of field 'ROWCSUB14SOG01_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB14SOG01_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01_ARRAY getROWCSUB14SOG01_ARRAY()
    {
        return this._ROWCSUB14SOG01_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01_ARRAY getROWCSUB14SOG01_ARRAY() 

    /**
     * Returns the value of field 'ROWCSUB14SOG02_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB14SOG02_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02_ARRAY getROWCSUB14SOG02_ARRAY()
    {
        return this._ROWCSUB14SOG02_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02_ARRAY getROWCSUB14SOG02_ARRAY() 

    /**
     * Returns the value of field 'ROWCSUB14SOG03_ARRAY'.
     * 
     * @return the value of field 'ROWCSUB14SOG03_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY getROWCSUB14SOG03_ARRAY()
    {
        return this._ROWCSUB14SOG03_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY getROWCSUB14SOG03_ARRAY() 

    /**
     * Returns the value of field 'ROWCSUB14SOG04'.
     * 
     * @return the value of field 'ROWCSUB14SOG04'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG04 getROWCSUB14SOG04()
    {
        return this._ROWCSUB14SOG04;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG04 getROWCSUB14SOG04() 

    /**
     * Returns the value of field 'szCdPersonEthnicGroup'.
     * 
     * @return the value of field 'SzCdPersonEthnicGroup'.
     */
    public java.lang.String getSzCdPersonEthnicGroup()
    {
        return this._szCdPersonEthnicGroup;
    } //-- java.lang.String getSzCdPersonEthnicGroup() 

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
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'dtDtPersonBirth'.
     * 
     * @param dtDtPersonBirth the value of field 'dtDtPersonBirth'.
     */
    public void setDtDtPersonBirth(org.exolab.castor.types.Date dtDtPersonBirth)
    {
        this._dtDtPersonBirth = dtDtPersonBirth;
    } //-- void setDtDtPersonBirth(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'ROWCSUB14SOG00'.
     * 
     * @param ROWCSUB14SOG00 the value of field 'ROWCSUB14SOG00'.
     */
    public void setROWCSUB14SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00 ROWCSUB14SOG00)
    {
        this._ROWCSUB14SOG00 = ROWCSUB14SOG00;
    } //-- void setROWCSUB14SOG00(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00) 

    /**
     * Sets the value of field 'ROWCSUB14SOG01_ARRAY'.
     * 
     * @param ROWCSUB14SOG01_ARRAY the value of field
     * 'ROWCSUB14SOG01_ARRAY'.
     */
    public void setROWCSUB14SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01_ARRAY ROWCSUB14SOG01_ARRAY)
    {
        this._ROWCSUB14SOG01_ARRAY = ROWCSUB14SOG01_ARRAY;
    } //-- void setROWCSUB14SOG01_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01_ARRAY) 

    /**
     * Sets the value of field 'ROWCSUB14SOG02_ARRAY'.
     * 
     * @param ROWCSUB14SOG02_ARRAY the value of field
     * 'ROWCSUB14SOG02_ARRAY'.
     */
    public void setROWCSUB14SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02_ARRAY ROWCSUB14SOG02_ARRAY)
    {
        this._ROWCSUB14SOG02_ARRAY = ROWCSUB14SOG02_ARRAY;
    } //-- void setROWCSUB14SOG02_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02_ARRAY) 

    /**
     * Sets the value of field 'ROWCSUB14SOG03_ARRAY'.
     * 
     * @param ROWCSUB14SOG03_ARRAY the value of field
     * 'ROWCSUB14SOG03_ARRAY'.
     */
    public void setROWCSUB14SOG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY ROWCSUB14SOG03_ARRAY)
    {
        this._ROWCSUB14SOG03_ARRAY = ROWCSUB14SOG03_ARRAY;
    } //-- void setROWCSUB14SOG03_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY) 

    /**
     * Sets the value of field 'ROWCSUB14SOG04'.
     * 
     * @param ROWCSUB14SOG04 the value of field 'ROWCSUB14SOG04'.
     */
    public void setROWCSUB14SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG04 ROWCSUB14SOG04)
    {
        this._ROWCSUB14SOG04 = ROWCSUB14SOG04;
    } //-- void setROWCSUB14SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG04) 

    /**
     * Sets the value of field 'szCdPersonEthnicGroup'.
     * 
     * @param szCdPersonEthnicGroup the value of field
     * 'szCdPersonEthnicGroup'.
     */
    public void setSzCdPersonEthnicGroup(java.lang.String szCdPersonEthnicGroup)
    {
        this._szCdPersonEthnicGroup = szCdPersonEthnicGroup;
    } //-- void setSzCdPersonEthnicGroup(java.lang.String) 

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
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO unmarshal(java.io.Reader) 

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
