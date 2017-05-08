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
 * Class CFAD36SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD36SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN01UIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY _ROWCCMN01UIG00_ARRAY;

    /**
     * Field _bIndRsrcNonPrs
     */
    private java.lang.String _bIndRsrcNonPrs;

    /**
     * Field _szCdRsrcRegion
     */
    private java.lang.String _szCdRsrcRegion;

    /**
     * Field _szCdCntrctRegion
     */
    private java.lang.String _szCdCntrctRegion;

    /**
     * Field _szCdRsrcClosureRsn
     */
    private java.lang.String _szCdRsrcClosureRsn;

    /**
     * Field _szCdRsrcFaHomeStatus_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY _szCdRsrcFaHomeStatus_ARRAY;

    /**
     * Field _szCdRsrcInvolClosure
     */
    private java.lang.String _szCdRsrcInvolClosure;

    /**
     * Field _szCdRsrcRecmndReopen
     */
    private java.lang.String _szCdRsrcRecmndReopen;

    /**
     * Field _szCdRsrcStatus
     */
    private java.lang.String _szCdRsrcStatus;

    /**
     * Field _szCdRsrcFacilType
     */
    private java.lang.String _szCdRsrcFacilType;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _tsLastUpdate_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY _tsLastUpdate_ARRAY;

    /**
     * Field _ulIdCntrctWkr
     */
    private int _ulIdCntrctWkr;

    /**
     * keeps track of state for field: _ulIdCntrctWkr
     */
    private boolean _has_ulIdCntrctWkr;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _szCdRsrcCnty
     */
    private java.lang.String _szCdRsrcCnty;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

    /**
     * Field _szTxtStatusRsnComments
     */
    private java.lang.String _szTxtStatusRsnComments;

    /**
     * Field _txtLastUpdatedBy
     */
    private java.lang.String _txtLastUpdatedBy;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD36SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdCntrctWkr()
    {
        this._has_ulIdCntrctWkr= false;
    } //-- void deleteUlIdCntrctWkr() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

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
     * Returns the value of field 'bIndRsrcNonPrs'.
     * 
     * @return the value of field 'BIndRsrcNonPrs'.
     */
    public java.lang.String getBIndRsrcNonPrs()
    {
        return this._bIndRsrcNonPrs;
    } //-- java.lang.String getBIndRsrcNonPrs() 

    /**
     * Returns the value of field 'ROWCCMN01UIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCCMN01UIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY getROWCCMN01UIG00_ARRAY()
    {
        return this._ROWCCMN01UIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY getROWCCMN01UIG00_ARRAY() 

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
     * Returns the value of field 'szCdRsrcClosureRsn'.
     * 
     * @return the value of field 'SzCdRsrcClosureRsn'.
     */
    public java.lang.String getSzCdRsrcClosureRsn()
    {
        return this._szCdRsrcClosureRsn;
    } //-- java.lang.String getSzCdRsrcClosureRsn() 

    /**
     * Returns the value of field 'szCdRsrcCnty'.
     * 
     * @return the value of field 'SzCdRsrcCnty'.
     */
    public java.lang.String getSzCdRsrcCnty()
    {
        return this._szCdRsrcCnty;
    } //-- java.lang.String getSzCdRsrcCnty() 

    /**
     * Returns the value of field 'szCdRsrcFaHomeStatus_ARRAY'.
     * 
     * @return the value of field 'SzCdRsrcFaHomeStatus_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY getSzCdRsrcFaHomeStatus_ARRAY()
    {
        return this._szCdRsrcFaHomeStatus_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY getSzCdRsrcFaHomeStatus_ARRAY() 

    /**
     * Returns the value of field 'szCdRsrcFacilType'.
     * 
     * @return the value of field 'SzCdRsrcFacilType'.
     */
    public java.lang.String getSzCdRsrcFacilType()
    {
        return this._szCdRsrcFacilType;
    } //-- java.lang.String getSzCdRsrcFacilType() 

    /**
     * Returns the value of field 'szCdRsrcInvolClosure'.
     * 
     * @return the value of field 'SzCdRsrcInvolClosure'.
     */
    public java.lang.String getSzCdRsrcInvolClosure()
    {
        return this._szCdRsrcInvolClosure;
    } //-- java.lang.String getSzCdRsrcInvolClosure() 

    /**
     * Returns the value of field 'szCdRsrcRecmndReopen'.
     * 
     * @return the value of field 'SzCdRsrcRecmndReopen'.
     */
    public java.lang.String getSzCdRsrcRecmndReopen()
    {
        return this._szCdRsrcRecmndReopen;
    } //-- java.lang.String getSzCdRsrcRecmndReopen() 

    /**
     * Returns the value of field 'szCdRsrcRegion'.
     * 
     * @return the value of field 'SzCdRsrcRegion'.
     */
    public java.lang.String getSzCdRsrcRegion()
    {
        return this._szCdRsrcRegion;
    } //-- java.lang.String getSzCdRsrcRegion() 

    /**
     * Returns the value of field 'szCdRsrcStatus'.
     * 
     * @return the value of field 'SzCdRsrcStatus'.
     */
    public java.lang.String getSzCdRsrcStatus()
    {
        return this._szCdRsrcStatus;
    } //-- java.lang.String getSzCdRsrcStatus() 

    /**
     * Returns the value of field 'szTxtStatusRsnComments'.
     * 
     * @return the value of field 'SzTxtStatusRsnComments'.
     */
    public java.lang.String getSzTxtStatusRsnComments()
    {
        return this._szTxtStatusRsnComments;
    } //-- java.lang.String getSzTxtStatusRsnComments() 

    /**
     * Returns the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @return the value of field 'TsLastUpdate_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY()
    {
        return this._tsLastUpdate_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY getTsLastUpdate_ARRAY() 

    /**
     * Returns the value of field 'txtLastUpdatedBy'.
     * 
     * @return the value of field 'TxtLastUpdatedBy'.
     */
    public java.lang.String getTxtLastUpdatedBy()
    {
        return this._txtLastUpdatedBy;
    } //-- java.lang.String getTxtLastUpdatedBy() 

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
     * Returns the value of field 'ulIdCntrctWkr'.
     * 
     * @return the value of field 'UlIdCntrctWkr'.
     */
    public int getUlIdCntrctWkr()
    {
        return this._ulIdCntrctWkr;
    } //-- int getUlIdCntrctWkr() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdSituation'.
     * 
     * @return the value of field 'UlIdSituation'.
     */
    public int getUlIdSituation()
    {
        return this._ulIdSituation;
    } //-- int getUlIdSituation() 

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
     * Method hasUlIdCntrctWkr
     * 
     * 
     * 
     * @return true if at least one UlIdCntrctWkr has been added
     */
    public boolean hasUlIdCntrctWkr()
    {
        return this._has_ulIdCntrctWkr;
    } //-- boolean hasUlIdCntrctWkr() 

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
     * Method hasUlIdSituation
     * 
     * 
     * 
     * @return true if at least one UlIdSituation has been added
     */
    public boolean hasUlIdSituation()
    {
        return this._has_ulIdSituation;
    } //-- boolean hasUlIdSituation() 

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
     * Sets the value of field 'bIndRsrcNonPrs'.
     * 
     * @param bIndRsrcNonPrs the value of field 'bIndRsrcNonPrs'.
     */
    public void setBIndRsrcNonPrs(java.lang.String bIndRsrcNonPrs)
    {
        this._bIndRsrcNonPrs = bIndRsrcNonPrs;
    } //-- void setBIndRsrcNonPrs(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCMN01UIG00_ARRAY'.
     * 
     * @param ROWCCMN01UIG00_ARRAY the value of field
     * 'ROWCCMN01UIG00_ARRAY'.
     */
    public void setROWCCMN01UIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY ROWCCMN01UIG00_ARRAY)
    {
        this._ROWCCMN01UIG00_ARRAY = ROWCCMN01UIG00_ARRAY;
    } //-- void setROWCCMN01UIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY) 

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
     * Sets the value of field 'szCdRsrcClosureRsn'.
     * 
     * @param szCdRsrcClosureRsn the value of field
     * 'szCdRsrcClosureRsn'.
     */
    public void setSzCdRsrcClosureRsn(java.lang.String szCdRsrcClosureRsn)
    {
        this._szCdRsrcClosureRsn = szCdRsrcClosureRsn;
    } //-- void setSzCdRsrcClosureRsn(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcCnty'.
     * 
     * @param szCdRsrcCnty the value of field 'szCdRsrcCnty'.
     */
    public void setSzCdRsrcCnty(java.lang.String szCdRsrcCnty)
    {
        this._szCdRsrcCnty = szCdRsrcCnty;
    } //-- void setSzCdRsrcCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcFaHomeStatus_ARRAY'.
     * 
     * @param szCdRsrcFaHomeStatus_ARRAY the value of field
     * 'szCdRsrcFaHomeStatus_ARRAY'.
     */
    public void setSzCdRsrcFaHomeStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY szCdRsrcFaHomeStatus_ARRAY)
    {
        this._szCdRsrcFaHomeStatus_ARRAY = szCdRsrcFaHomeStatus_ARRAY;
    } //-- void setSzCdRsrcFaHomeStatus_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY) 

    /**
     * Sets the value of field 'szCdRsrcFacilType'.
     * 
     * @param szCdRsrcFacilType the value of field
     * 'szCdRsrcFacilType'.
     */
    public void setSzCdRsrcFacilType(java.lang.String szCdRsrcFacilType)
    {
        this._szCdRsrcFacilType = szCdRsrcFacilType;
    } //-- void setSzCdRsrcFacilType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcInvolClosure'.
     * 
     * @param szCdRsrcInvolClosure the value of field
     * 'szCdRsrcInvolClosure'.
     */
    public void setSzCdRsrcInvolClosure(java.lang.String szCdRsrcInvolClosure)
    {
        this._szCdRsrcInvolClosure = szCdRsrcInvolClosure;
    } //-- void setSzCdRsrcInvolClosure(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcRecmndReopen'.
     * 
     * @param szCdRsrcRecmndReopen the value of field
     * 'szCdRsrcRecmndReopen'.
     */
    public void setSzCdRsrcRecmndReopen(java.lang.String szCdRsrcRecmndReopen)
    {
        this._szCdRsrcRecmndReopen = szCdRsrcRecmndReopen;
    } //-- void setSzCdRsrcRecmndReopen(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcRegion'.
     * 
     * @param szCdRsrcRegion the value of field 'szCdRsrcRegion'.
     */
    public void setSzCdRsrcRegion(java.lang.String szCdRsrcRegion)
    {
        this._szCdRsrcRegion = szCdRsrcRegion;
    } //-- void setSzCdRsrcRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcStatus'.
     * 
     * @param szCdRsrcStatus the value of field 'szCdRsrcStatus'.
     */
    public void setSzCdRsrcStatus(java.lang.String szCdRsrcStatus)
    {
        this._szCdRsrcStatus = szCdRsrcStatus;
    } //-- void setSzCdRsrcStatus(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStatusRsnComments'.
     * 
     * @param szTxtStatusRsnComments the value of field
     * 'szTxtStatusRsnComments'.
     */
    public void setSzTxtStatusRsnComments(java.lang.String szTxtStatusRsnComments)
    {
        this._szTxtStatusRsnComments = szTxtStatusRsnComments;
    } //-- void setSzTxtStatusRsnComments(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate_ARRAY'.
     * 
     * @param tsLastUpdate_ARRAY the value of field
     * 'tsLastUpdate_ARRAY'.
     */
    public void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY tsLastUpdate_ARRAY)
    {
        this._tsLastUpdate_ARRAY = tsLastUpdate_ARRAY;
    } //-- void setTsLastUpdate_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.TsLastUpdate_ARRAY) 

    /**
     * Sets the value of field 'txtLastUpdatedBy'.
     * 
     * @param txtLastUpdatedBy the value of field 'txtLastUpdatedBy'
     */
    public void setTxtLastUpdatedBy(java.lang.String txtLastUpdatedBy)
    {
        this._txtLastUpdatedBy = txtLastUpdatedBy;
    } //-- void setTxtLastUpdatedBy(java.lang.String) 

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
     * Sets the value of field 'ulIdCntrctWkr'.
     * 
     * @param ulIdCntrctWkr the value of field 'ulIdCntrctWkr'.
     */
    public void setUlIdCntrctWkr(int ulIdCntrctWkr)
    {
        this._ulIdCntrctWkr = ulIdCntrctWkr;
        this._has_ulIdCntrctWkr = true;
    } //-- void setUlIdCntrctWkr(int) 

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
     * Sets the value of field 'ulIdSituation'.
     * 
     * @param ulIdSituation the value of field 'ulIdSituation'.
     */
    public void setUlIdSituation(int ulIdSituation)
    {
        this._ulIdSituation = ulIdSituation;
        this._has_ulIdSituation = true;
    } //-- void setUlIdSituation(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI unmarshal(java.io.Reader) 

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
