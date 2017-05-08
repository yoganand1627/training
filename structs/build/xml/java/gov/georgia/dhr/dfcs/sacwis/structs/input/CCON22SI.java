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
 * Class CCON22SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON22SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdSvcAuthCounty
     */
    private java.lang.String _szCdSvcAuthCounty;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdSvcAuthDtl
     */
    private int _ulIdSvcAuthDtl;

    /**
     * keeps track of state for field: _ulIdSvcAuthDtl
     */
    private boolean _has_ulIdSvcAuthDtl;

    /**
     * Field _ulNbrCnperPeriod
     */
    private int _ulNbrCnperPeriod;

    /**
     * keeps track of state for field: _ulNbrCnperPeriod
     */
    private boolean _has_ulNbrCnperPeriod;

    /**
     * Field _ulNbrCnverVersion
     */
    private int _ulNbrCnverVersion;

    /**
     * keeps track of state for field: _ulNbrCnverVersion
     */
    private boolean _has_ulNbrCnverVersion;

    /**
     * Field _szCdStagePersType
     */
    private java.lang.String _szCdStagePersType;

    /**
     * Field _ulPageSizeNbr
     */
    private int _ulPageSizeNbr;

    /**
     * keeps track of state for field: _ulPageSizeNbr
     */
    private boolean _has_ulPageSizeNbr;

    /**
     * Field _szSysCdWinMode
     */
    private java.lang.String _szSysCdWinMode;

    /**
     * Field _ulIdAdopAssistAppl
     */
    private int _ulIdAdopAssistAppl;

    /**
     * keeps track of state for field: _ulIdAdopAssistAppl
     */
    private boolean _has_ulIdAdopAssistAppl;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON22SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAdopAssistAppl()
    {
        this._has_ulIdAdopAssistAppl= false;
    } //-- void deleteUlIdAdopAssistAppl() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdSvcAuthDtl()
    {
        this._has_ulIdSvcAuthDtl= false;
    } //-- void deleteUlIdSvcAuthDtl() 

    /**
     */
    public void deleteUlNbrCnperPeriod()
    {
        this._has_ulNbrCnperPeriod= false;
    } //-- void deleteUlNbrCnperPeriod() 

    /**
     */
    public void deleteUlNbrCnverVersion()
    {
        this._has_ulNbrCnverVersion= false;
    } //-- void deleteUlNbrCnverVersion() 

    /**
     */
    public void deleteUlPageSizeNbr()
    {
        this._has_ulPageSizeNbr= false;
    } //-- void deleteUlPageSizeNbr() 

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
     * Returns the value of field 'szCdStagePersType'.
     * 
     * @return the value of field 'SzCdStagePersType'.
     */
    public java.lang.String getSzCdStagePersType()
    {
        return this._szCdStagePersType;
    } //-- java.lang.String getSzCdStagePersType() 

    /**
     * Returns the value of field 'szCdSvcAuthCounty'.
     * 
     * @return the value of field 'SzCdSvcAuthCounty'.
     */
    public java.lang.String getSzCdSvcAuthCounty()
    {
        return this._szCdSvcAuthCounty;
    } //-- java.lang.String getSzCdSvcAuthCounty() 

    /**
     * Returns the value of field 'szSysCdWinMode'.
     * 
     * @return the value of field 'SzSysCdWinMode'.
     */
    public java.lang.String getSzSysCdWinMode()
    {
        return this._szSysCdWinMode;
    } //-- java.lang.String getSzSysCdWinMode() 

    /**
     * Returns the value of field 'ulIdAdopAssistAppl'.
     * 
     * @return the value of field 'UlIdAdopAssistAppl'.
     */
    public int getUlIdAdopAssistAppl()
    {
        return this._ulIdAdopAssistAppl;
    } //-- int getUlIdAdopAssistAppl() 

    /**
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

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
     * Returns the value of field 'ulIdSvcAuthDtl'.
     * 
     * @return the value of field 'UlIdSvcAuthDtl'.
     */
    public int getUlIdSvcAuthDtl()
    {
        return this._ulIdSvcAuthDtl;
    } //-- int getUlIdSvcAuthDtl() 

    /**
     * Returns the value of field 'ulNbrCnperPeriod'.
     * 
     * @return the value of field 'UlNbrCnperPeriod'.
     */
    public int getUlNbrCnperPeriod()
    {
        return this._ulNbrCnperPeriod;
    } //-- int getUlNbrCnperPeriod() 

    /**
     * Returns the value of field 'ulNbrCnverVersion'.
     * 
     * @return the value of field 'UlNbrCnverVersion'.
     */
    public int getUlNbrCnverVersion()
    {
        return this._ulNbrCnverVersion;
    } //-- int getUlNbrCnverVersion() 

    /**
     * Returns the value of field 'ulPageSizeNbr'.
     * 
     * @return the value of field 'UlPageSizeNbr'.
     */
    public int getUlPageSizeNbr()
    {
        return this._ulPageSizeNbr;
    } //-- int getUlPageSizeNbr() 

    /**
     * Method hasUlIdAdopAssistAppl
     * 
     * 
     * 
     * @return true if at least one UlIdAdopAssistAppl has been adde
     */
    public boolean hasUlIdAdopAssistAppl()
    {
        return this._has_ulIdAdopAssistAppl;
    } //-- boolean hasUlIdAdopAssistAppl() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

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
     * Method hasUlIdSvcAuthDtl
     * 
     * 
     * 
     * @return true if at least one UlIdSvcAuthDtl has been added
     */
    public boolean hasUlIdSvcAuthDtl()
    {
        return this._has_ulIdSvcAuthDtl;
    } //-- boolean hasUlIdSvcAuthDtl() 

    /**
     * Method hasUlNbrCnperPeriod
     * 
     * 
     * 
     * @return true if at least one UlNbrCnperPeriod has been added
     */
    public boolean hasUlNbrCnperPeriod()
    {
        return this._has_ulNbrCnperPeriod;
    } //-- boolean hasUlNbrCnperPeriod() 

    /**
     * Method hasUlNbrCnverVersion
     * 
     * 
     * 
     * @return true if at least one UlNbrCnverVersion has been added
     */
    public boolean hasUlNbrCnverVersion()
    {
        return this._has_ulNbrCnverVersion;
    } //-- boolean hasUlNbrCnverVersion() 

    /**
     * Method hasUlPageSizeNbr
     * 
     * 
     * 
     * @return true if at least one UlPageSizeNbr has been added
     */
    public boolean hasUlPageSizeNbr()
    {
        return this._has_ulPageSizeNbr;
    } //-- boolean hasUlPageSizeNbr() 

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
     * Sets the value of field 'szCdStagePersType'.
     * 
     * @param szCdStagePersType the value of field
     * 'szCdStagePersType'.
     */
    public void setSzCdStagePersType(java.lang.String szCdStagePersType)
    {
        this._szCdStagePersType = szCdStagePersType;
    } //-- void setSzCdStagePersType(java.lang.String) 

    /**
     * Sets the value of field 'szCdSvcAuthCounty'.
     * 
     * @param szCdSvcAuthCounty the value of field
     * 'szCdSvcAuthCounty'.
     */
    public void setSzCdSvcAuthCounty(java.lang.String szCdSvcAuthCounty)
    {
        this._szCdSvcAuthCounty = szCdSvcAuthCounty;
    } //-- void setSzCdSvcAuthCounty(java.lang.String) 

    /**
     * Sets the value of field 'szSysCdWinMode'.
     * 
     * @param szSysCdWinMode the value of field 'szSysCdWinMode'.
     */
    public void setSzSysCdWinMode(java.lang.String szSysCdWinMode)
    {
        this._szSysCdWinMode = szSysCdWinMode;
    } //-- void setSzSysCdWinMode(java.lang.String) 

    /**
     * Sets the value of field 'ulIdAdopAssistAppl'.
     * 
     * @param ulIdAdopAssistAppl the value of field
     * 'ulIdAdopAssistAppl'.
     */
    public void setUlIdAdopAssistAppl(int ulIdAdopAssistAppl)
    {
        this._ulIdAdopAssistAppl = ulIdAdopAssistAppl;
        this._has_ulIdAdopAssistAppl = true;
    } //-- void setUlIdAdopAssistAppl(int) 

    /**
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

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
     * Sets the value of field 'ulIdSvcAuthDtl'.
     * 
     * @param ulIdSvcAuthDtl the value of field 'ulIdSvcAuthDtl'.
     */
    public void setUlIdSvcAuthDtl(int ulIdSvcAuthDtl)
    {
        this._ulIdSvcAuthDtl = ulIdSvcAuthDtl;
        this._has_ulIdSvcAuthDtl = true;
    } //-- void setUlIdSvcAuthDtl(int) 

    /**
     * Sets the value of field 'ulNbrCnperPeriod'.
     * 
     * @param ulNbrCnperPeriod the value of field 'ulNbrCnperPeriod'
     */
    public void setUlNbrCnperPeriod(int ulNbrCnperPeriod)
    {
        this._ulNbrCnperPeriod = ulNbrCnperPeriod;
        this._has_ulNbrCnperPeriod = true;
    } //-- void setUlNbrCnperPeriod(int) 

    /**
     * Sets the value of field 'ulNbrCnverVersion'.
     * 
     * @param ulNbrCnverVersion the value of field
     * 'ulNbrCnverVersion'.
     */
    public void setUlNbrCnverVersion(int ulNbrCnverVersion)
    {
        this._ulNbrCnverVersion = ulNbrCnverVersion;
        this._has_ulNbrCnverVersion = true;
    } //-- void setUlNbrCnverVersion(int) 

    /**
     * Sets the value of field 'ulPageSizeNbr'.
     * 
     * @param ulPageSizeNbr the value of field 'ulPageSizeNbr'.
     */
    public void setUlPageSizeNbr(int ulPageSizeNbr)
    {
        this._ulPageSizeNbr = ulPageSizeNbr;
        this._has_ulPageSizeNbr = true;
    } //-- void setUlPageSizeNbr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI unmarshal(java.io.Reader) 

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
