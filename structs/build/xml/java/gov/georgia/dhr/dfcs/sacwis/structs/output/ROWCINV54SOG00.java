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
 * Class ROWCINV54SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV54SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdCpsChecklist
     */
    private int _ulIdCpsChecklist;

    /**
     * keeps track of state for field: _ulIdCpsChecklist
     */
    private boolean _has_ulIdCpsChecklist;

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _dtDtCPSInvstDtlBegun
     */
    private org.exolab.castor.types.Date _dtDtCPSInvstDtlBegun;

    /**
     * Field _dtDtFirstReferral
     */
    private org.exolab.castor.types.Date _dtDtFirstReferral;

    /**
     * Field _cIndSvcRefChklstNoRef
     */
    private java.lang.String _cIndSvcRefChklstNoRef;

    /**
     * Field _szCdFamilyResponse
     */
    private java.lang.String _szCdFamilyResponse;

    /**
     * Field _szTxtChklstComments
     */
    private java.lang.String _szTxtChklstComments;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV54SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00()


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
    public void deleteUlIdCpsChecklist()
    {
        this._has_ulIdCpsChecklist= false;
    } //-- void deleteUlIdCpsChecklist() 

    /**
     */
    public void deleteUlIdEvent()
    {
        this._has_ulIdEvent= false;
    } //-- void deleteUlIdEvent() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'cIndSvcRefChklstNoRef'.
     * 
     * @return the value of field 'CIndSvcRefChklstNoRef'.
     */
    public java.lang.String getCIndSvcRefChklstNoRef()
    {
        return this._cIndSvcRefChklstNoRef;
    } //-- java.lang.String getCIndSvcRefChklstNoRef() 

    /**
     * Returns the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @return the value of field 'DtDtCPSInvstDtlBegun'.
     */
    public org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun()
    {
        return this._dtDtCPSInvstDtlBegun;
    } //-- org.exolab.castor.types.Date getDtDtCPSInvstDtlBegun() 

    /**
     * Returns the value of field 'dtDtFirstReferral'.
     * 
     * @return the value of field 'DtDtFirstReferral'.
     */
    public org.exolab.castor.types.Date getDtDtFirstReferral()
    {
        return this._dtDtFirstReferral;
    } //-- org.exolab.castor.types.Date getDtDtFirstReferral() 

    /**
     * Returns the value of field 'szCdFamilyResponse'.
     * 
     * @return the value of field 'SzCdFamilyResponse'.
     */
    public java.lang.String getSzCdFamilyResponse()
    {
        return this._szCdFamilyResponse;
    } //-- java.lang.String getSzCdFamilyResponse() 

    /**
     * Returns the value of field 'szTxtChklstComments'.
     * 
     * @return the value of field 'SzTxtChklstComments'.
     */
    public java.lang.String getSzTxtChklstComments()
    {
        return this._szTxtChklstComments;
    } //-- java.lang.String getSzTxtChklstComments() 

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
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdCpsChecklist'.
     * 
     * @return the value of field 'UlIdCpsChecklist'.
     */
    public int getUlIdCpsChecklist()
    {
        return this._ulIdCpsChecklist;
    } //-- int getUlIdCpsChecklist() 

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
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

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
     * Method hasUlIdCpsChecklist
     * 
     * 
     * 
     * @return true if at least one UlIdCpsChecklist has been added
     */
    public boolean hasUlIdCpsChecklist()
    {
        return this._has_ulIdCpsChecklist;
    } //-- boolean hasUlIdCpsChecklist() 

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
     * Sets the value of field 'cIndSvcRefChklstNoRef'.
     * 
     * @param cIndSvcRefChklstNoRef the value of field
     * 'cIndSvcRefChklstNoRef'.
     */
    public void setCIndSvcRefChklstNoRef(java.lang.String cIndSvcRefChklstNoRef)
    {
        this._cIndSvcRefChklstNoRef = cIndSvcRefChklstNoRef;
    } //-- void setCIndSvcRefChklstNoRef(java.lang.String) 

    /**
     * Sets the value of field 'dtDtCPSInvstDtlBegun'.
     * 
     * @param dtDtCPSInvstDtlBegun the value of field
     * 'dtDtCPSInvstDtlBegun'.
     */
    public void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date dtDtCPSInvstDtlBegun)
    {
        this._dtDtCPSInvstDtlBegun = dtDtCPSInvstDtlBegun;
    } //-- void setDtDtCPSInvstDtlBegun(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtFirstReferral'.
     * 
     * @param dtDtFirstReferral the value of field
     * 'dtDtFirstReferral'.
     */
    public void setDtDtFirstReferral(org.exolab.castor.types.Date dtDtFirstReferral)
    {
        this._dtDtFirstReferral = dtDtFirstReferral;
    } //-- void setDtDtFirstReferral(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdFamilyResponse'.
     * 
     * @param szCdFamilyResponse the value of field
     * 'szCdFamilyResponse'.
     */
    public void setSzCdFamilyResponse(java.lang.String szCdFamilyResponse)
    {
        this._szCdFamilyResponse = szCdFamilyResponse;
    } //-- void setSzCdFamilyResponse(java.lang.String) 

    /**
     * Sets the value of field 'szTxtChklstComments'.
     * 
     * @param szTxtChklstComments the value of field
     * 'szTxtChklstComments'.
     */
    public void setSzTxtChklstComments(java.lang.String szTxtChklstComments)
    {
        this._szTxtChklstComments = szTxtChklstComments;
    } //-- void setSzTxtChklstComments(java.lang.String) 

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
     * Sets the value of field 'ulIdCpsChecklist'.
     * 
     * @param ulIdCpsChecklist the value of field 'ulIdCpsChecklist'
     */
    public void setUlIdCpsChecklist(int ulIdCpsChecklist)
    {
        this._ulIdCpsChecklist = ulIdCpsChecklist;
        this._has_ulIdCpsChecklist = true;
    } //-- void setUlIdCpsChecklist(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00 unmarshal(java.io.Reader) 

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
