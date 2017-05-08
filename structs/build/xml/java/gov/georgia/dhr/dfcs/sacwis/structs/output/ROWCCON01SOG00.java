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
 * Class ROWCCON01SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCON01SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _szCdCntrctFuncType
     */
    private java.lang.String _szCdCntrctFuncType;

    /**
     * Field _szCdCntrctProgramType
     */
    private java.lang.String _szCdCntrctProgramType;

    /**
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _szCdCntrctCounty
     */
    private java.lang.String _szCdCntrctCounty;

    /**
     * Field _cIndCntrctBudgLimit
     */
    private java.lang.String _cIndCntrctBudgLimit;

    /**
     * Field _szNmResource
     */
    private java.lang.String _szNmResource;

    /**
     * Field _szNbrRsrcAddrVid
     */
    private java.lang.String _szNbrRsrcAddrVid;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCON01SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'cIndCntrctBudgLimit'.
     * 
     * @return the value of field 'CIndCntrctBudgLimit'.
     */
    public java.lang.String getCIndCntrctBudgLimit()
    {
        return this._cIndCntrctBudgLimit;
    } //-- java.lang.String getCIndCntrctBudgLimit() 

    /**
     * Returns the value of field 'szCdCntrctCounty'.
     * 
     * @return the value of field 'SzCdCntrctCounty'.
     */
    public java.lang.String getSzCdCntrctCounty()
    {
        return this._szCdCntrctCounty;
    } //-- java.lang.String getSzCdCntrctCounty() 

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
     * Returns the value of field 'szNbrRsrcAddrVid'.
     * 
     * @return the value of field 'SzNbrRsrcAddrVid'.
     */
    public java.lang.String getSzNbrRsrcAddrVid()
    {
        return this._szNbrRsrcAddrVid;
    } //-- java.lang.String getSzNbrRsrcAddrVid() 

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
     * Sets the value of field 'szCdCntrctCounty'.
     * 
     * @param szCdCntrctCounty the value of field 'szCdCntrctCounty'
     */
    public void setSzCdCntrctCounty(java.lang.String szCdCntrctCounty)
    {
        this._szCdCntrctCounty = szCdCntrctCounty;
    } //-- void setSzCdCntrctCounty(java.lang.String) 

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
     * Sets the value of field 'szNbrRsrcAddrVid'.
     * 
     * @param szNbrRsrcAddrVid the value of field 'szNbrRsrcAddrVid'
     */
    public void setSzNbrRsrcAddrVid(java.lang.String szNbrRsrcAddrVid)
    {
        this._szNbrRsrcAddrVid = szNbrRsrcAddrVid;
    } //-- void setSzNbrRsrcAddrVid(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00 unmarshal(java.io.Reader) 

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
