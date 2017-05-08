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
 * Class CallEntryRtrvOut.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CallEntryRtrvOut extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;

    /**
     * Field _CINTS025G01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CINTS025G01 _CINTS025G01;

    /**
     * Field _specHD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD _specHD;

    /**
     * Field _callDcsnAUD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD _callDcsnAUD;

    /**
     * Field _determListAUD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD _determListAUD;

    /**
     * Field _callEntrySvcStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct _callEntrySvcStruct;

    /**
     * Field _determCmntsAUD
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD _determCmntsAUD;

    /**
     * Field _cIndTrialHomeVisit
     */
    private java.lang.String _cIndTrialHomeVisit;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallEntryRtrvOut() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'CINTS025G01'.
     * 
     * @return the value of field 'CINTS025G01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINTS025G01 getCINTS025G01()
    {
        return this._CINTS025G01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINTS025G01 getCINTS025G01() 

    /**
     * Returns the value of field 'cIndTrialHomeVisit'.
     * 
     * @return the value of field 'CIndTrialHomeVisit'.
     */
    public java.lang.String getCIndTrialHomeVisit()
    {
        return this._cIndTrialHomeVisit;
    } //-- java.lang.String getCIndTrialHomeVisit() 

    /**
     * Returns the value of field 'callDcsnAUD'.
     * 
     * @return the value of field 'CallDcsnAUD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD getCallDcsnAUD()
    {
        return this._callDcsnAUD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD getCallDcsnAUD() 

    /**
     * Returns the value of field 'callEntrySvcStruct'.
     * 
     * @return the value of field 'CallEntrySvcStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct getCallEntrySvcStruct()
    {
        return this._callEntrySvcStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct getCallEntrySvcStruct() 

    /**
     * Returns the value of field 'determCmntsAUD'.
     * 
     * @return the value of field 'DetermCmntsAUD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD getDetermCmntsAUD()
    {
        return this._determCmntsAUD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD getDetermCmntsAUD() 

    /**
     * Returns the value of field 'determListAUD'.
     * 
     * @return the value of field 'DetermListAUD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD getDetermListAUD()
    {
        return this._determListAUD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD getDetermListAUD() 

    /**
     * Returns the value of field 'specHD'.
     * 
     * @return the value of field 'SpecHD'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD getSpecHD()
    {
        return this._specHD;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD getSpecHD() 

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
     * Sets the value of field 'CINTS025G01'.
     * 
     * @param CINTS025G01 the value of field 'CINTS025G01'.
     */
    public void setCINTS025G01(gov.georgia.dhr.dfcs.sacwis.structs.output.CINTS025G01 CINTS025G01)
    {
        this._CINTS025G01 = CINTS025G01;
    } //-- void setCINTS025G01(gov.georgia.dhr.dfcs.sacwis.structs.output.CINTS025G01) 

    /**
     * Sets the value of field 'cIndTrialHomeVisit'.
     * 
     * @param cIndTrialHomeVisit the value of field
     * 'cIndTrialHomeVisit'.
     */
    public void setCIndTrialHomeVisit(java.lang.String cIndTrialHomeVisit)
    {
        this._cIndTrialHomeVisit = cIndTrialHomeVisit;
    } //-- void setCIndTrialHomeVisit(java.lang.String) 

    /**
     * Sets the value of field 'callDcsnAUD'.
     * 
     * @param callDcsnAUD the value of field 'callDcsnAUD'.
     */
    public void setCallDcsnAUD(gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD callDcsnAUD)
    {
        this._callDcsnAUD = callDcsnAUD;
    } //-- void setCallDcsnAUD(gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD) 

    /**
     * Sets the value of field 'callEntrySvcStruct'.
     * 
     * @param callEntrySvcStruct the value of field
     * 'callEntrySvcStruct'.
     */
    public void setCallEntrySvcStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct callEntrySvcStruct)
    {
        this._callEntrySvcStruct = callEntrySvcStruct;
    } //-- void setCallEntrySvcStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct) 

    /**
     * Sets the value of field 'determCmntsAUD'.
     * 
     * @param determCmntsAUD the value of field 'determCmntsAUD'.
     */
    public void setDetermCmntsAUD(gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD determCmntsAUD)
    {
        this._determCmntsAUD = determCmntsAUD;
    } //-- void setDetermCmntsAUD(gov.georgia.dhr.dfcs.sacwis.structs.output.DetermCmntsAUD) 

    /**
     * Sets the value of field 'determListAUD'.
     * 
     * @param determListAUD the value of field 'determListAUD'.
     */
    public void setDetermListAUD(gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD determListAUD)
    {
        this._determListAUD = determListAUD;
    } //-- void setDetermListAUD(gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD) 

    /**
     * Sets the value of field 'specHD'.
     * 
     * @param specHD the value of field 'specHD'.
     */
    public void setSpecHD(gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD specHD)
    {
        this._specHD = specHD;
    } //-- void setSpecHD(gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut unmarshal(java.io.Reader) 

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
