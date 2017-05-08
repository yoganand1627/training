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
 * Class CCON03SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCON03SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdCntrctFuncType
     */
    private java.lang.String _szCdCntrctFuncType;

    /**
     * Field _szCdCntrctProcureType
     */
    private java.lang.String _szCdCntrctProcureType;

    /**
     * Field _szCdCntrctProgramType
     */
    private java.lang.String _szCdCntrctProgramType;

    /**
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _cIndCntrctBudgLimit
     */
    private java.lang.String _cIndCntrctBudgLimit;

    /**
     * Field _cIndCntrctedResource
     */
    private java.lang.String _cIndCntrctedResource;

    /**
     * Field _ulIdCntrctManager
     */
    private int _ulIdCntrctManager;

    /**
     * keeps track of state for field: _ulIdCntrctManager
     */
    private boolean _has_ulIdCntrctManager;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _ulIdRsrcAddress
     */
    private int _ulIdRsrcAddress;

    /**
     * keeps track of state for field: _ulIdRsrcAddress
     */
    private boolean _has_ulIdRsrcAddress;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _ROWCCON02SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY _ROWCCON02SOG00_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCON03SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCntrctManager()
    {
        this._has_ulIdCntrctManager= false;
    } //-- void deleteUlIdCntrctManager() 

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdRsrcAddress()
    {
        this._has_ulIdRsrcAddress= false;
    } //-- void deleteUlIdRsrcAddress() 

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
     * Returns the value of field 'cIndCntrctBudgLimit'.
     * 
     * @return the value of field 'CIndCntrctBudgLimit'.
     */
    public java.lang.String getCIndCntrctBudgLimit()
    {
        return this._cIndCntrctBudgLimit;
    } //-- java.lang.String getCIndCntrctBudgLimit() 

    /**
     * Returns the value of field 'cIndCntrctedResource'.
     * 
     * @return the value of field 'CIndCntrctedResource'.
     */
    public java.lang.String getCIndCntrctedResource()
    {
        return this._cIndCntrctedResource;
    } //-- java.lang.String getCIndCntrctedResource() 

    /**
     * Returns the value of field 'ROWCCON02SOG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCON02SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY getROWCCON02SOG00_ARRAY()
    {
        return this._ROWCCON02SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY getROWCCON02SOG00_ARRAY() 

    /**
     * Returns the value of field 'szCdCntrctFuncType'.
     * 
     * @return the value of field 'SzCdCntrctFuncType'.
     */
    public java.lang.String getSzCdCntrctFuncType()
    {
        return this._szCdCntrctFuncType;
    } //-- java.lang.String getSzCdCntrctFuncType() 

    /**
     * Returns the value of field 'szCdCntrctProcureType'.
     * 
     * @return the value of field 'SzCdCntrctProcureType'.
     */
    public java.lang.String getSzCdCntrctProcureType()
    {
        return this._szCdCntrctProcureType;
    } //-- java.lang.String getSzCdCntrctProcureType() 

    /**
     * Returns the value of field 'szCdCntrctProgramType'.
     * 
     * @return the value of field 'SzCdCntrctProgramType'.
     */
    public java.lang.String getSzCdCntrctProgramType()
    {
        return this._szCdCntrctProgramType;
    } //-- java.lang.String getSzCdCntrctProgramType() 

    /**
     * Returns the value of field 'szCdCntrctRegion'.
     * 
     * @return the value of field 'SzCdCntrctRegion'.
     */
    public java.lang.String getSzCdCntrctRegion()
    {
        return this._szCdCntrctRegion;
    } //-- java.lang.String getSzCdCntrctRegion() 

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
     * Returns the value of field 'szNmResource'.
     * 
     * @return the value of field 'SzNmResource'.
     */
    public java.lang.String getSzNmResource()
    {
        return this._szNmResource;
    } //-- java.lang.String getSzNmResource() 

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
     * Returns the value of field 'ulIdCntrctManager'.
     * 
     * @return the value of field 'UlIdCntrctManager'.
     */
    public int getUlIdCntrctManager()
    {
        return this._ulIdCntrctManager;
    } //-- int getUlIdCntrctManager() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdRsrcAddress'.
     * 
     * @return the value of field 'UlIdRsrcAddress'.
     */
    public int getUlIdRsrcAddress()
    {
        return this._ulIdRsrcAddress;
    } //-- int getUlIdRsrcAddress() 

    /**
     * Method hasUlIdCntrctManager
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctManager has been added
     */
    public boolean hasUlIdCntrctManager()
    {
        return this._has_ulIdCntrctManager;
    } //-- boolean hasUlIdCntrctManager() 

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
     * Method hasUlIdRsrcAddress
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcAddress has been added
     */
    public boolean hasUlIdRsrcAddress()
    {
        return this._has_ulIdRsrcAddress;
    } //-- boolean hasUlIdRsrcAddress() 

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
     * Sets the value of field 'cIndCntrctBudgLimit'.
     * 
     * @param cIndCntrctBudgLimit the value of field
     * 'cIndCntrctBudgLimit'.
     */
    public void setCIndCntrctBudgLimit(java.lang.String cIndCntrctBudgLimit)
    {
        this._cIndCntrctBudgLimit = cIndCntrctBudgLimit;
    } //-- void setCIndCntrctBudgLimit(java.lang.String) 

    /**
     * Sets the value of field 'cIndCntrctedResource'.
     * 
     * @param cIndCntrctedResource the value of field
     * 'cIndCntrctedResource'.
     */
    public void setCIndCntrctedResource(java.lang.String cIndCntrctedResource)
    {
        this._cIndCntrctedResource = cIndCntrctedResource;
    } //-- void setCIndCntrctedResource(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCON02SOG00_ARRAY'.
     * 
     * @param ROWCCON02SOG00_ARRAY the value of field
     * 'ROWCCON02SOG00_ARRAY'.
     */
    public void setROWCCON02SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY ROWCCON02SOG00_ARRAY)
    {
        this._ROWCCON02SOG00_ARRAY = ROWCCON02SOG00_ARRAY;
    } //-- void setROWCCON02SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY) 

    /**
     * Sets the value of field 'szCdCntrctFuncType'.
     * 
     * @param szCdCntrctFuncType the value of field
     * 'szCdCntrctFuncType'.
     */
    public void setSzCdCntrctFuncType(java.lang.String szCdCntrctFuncType)
    {
        this._szCdCntrctFuncType = szCdCntrctFuncType;
    } //-- void setSzCdCntrctFuncType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCntrctProcureType'.
     * 
     * @param szCdCntrctProcureType the value of field
     * 'szCdCntrctProcureType'.
     */
    public void setSzCdCntrctProcureType(java.lang.String szCdCntrctProcureType)
    {
        this._szCdCntrctProcureType = szCdCntrctProcureType;
    } //-- void setSzCdCntrctProcureType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCntrctProgramType'.
     * 
     * @param szCdCntrctProgramType the value of field
     * 'szCdCntrctProgramType'.
     */
    public void setSzCdCntrctProgramType(java.lang.String szCdCntrctProgramType)
    {
        this._szCdCntrctProgramType = szCdCntrctProgramType;
    } //-- void setSzCdCntrctProgramType(java.lang.String) 

    /**
     * Sets the value of field 'szCdCntrctRegion'.
     * 
     * @param szCdCntrctRegion the value of field 'szCdCntrctRegion'
     */
    public void setSzCdCntrctRegion(java.lang.String szCdCntrctRegion)
    {
        this._szCdCntrctRegion = szCdCntrctRegion;
    } //-- void setSzCdCntrctRegion(java.lang.String) 

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
     * Sets the value of field 'szNmResource'.
     * 
     * @param szNmResource the value of field 'szNmResource'.
     */
    public void setSzNmResource(java.lang.String szNmResource)
    {
        this._szNmResource = szNmResource;
    } //-- void setSzNmResource(java.lang.String) 

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
     * Sets the value of field 'ulIdCntrctManager'.
     * 
     * @param ulIdCntrctManager the value of field
     * 'ulIdCntrctManager'.
     */
    public void setUlIdCntrctManager(int ulIdCntrctManager)
    {
        this._ulIdCntrctManager = ulIdCntrctManager;
        this._has_ulIdCntrctManager = true;
    } //-- void setUlIdCntrctManager(int) 

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
     * Sets the value of field 'ulIdRsrcAddress'.
     * 
     * @param ulIdRsrcAddress the value of field 'ulIdRsrcAddress'.
     */
    public void setUlIdRsrcAddress(int ulIdRsrcAddress)
    {
        this._ulIdRsrcAddress = ulIdRsrcAddress;
        this._has_ulIdRsrcAddress = true;
    } //-- void setUlIdRsrcAddress(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO unmarshal(java.io.Reader) 

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
