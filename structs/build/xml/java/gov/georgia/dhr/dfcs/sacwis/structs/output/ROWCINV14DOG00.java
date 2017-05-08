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
 * Class ROWCINV14DOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV14DOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdEvent
     */
    private int _ulIdEvent;

    /**
     * keeps track of state for field: _ulIdEvent
     */
    private boolean _has_ulIdEvent;

    /**
     * Field _szCdRiskFactorCateg
     */
    private java.lang.String _szCdRiskFactorCateg;

    /**
     * Field _cIndRiskAssmtIntranet
     */
    private java.lang.String _cIndRiskAssmtIntranet;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _cdRiskAssmtPurpose
     */
    private java.lang.String _cdRiskAssmtPurpose;

    /**
     * Field _szCdRiskAssmtRiskFind
     */
    private java.lang.String _szCdRiskAssmtRiskFind;

    /**
     * Field _szCdRiskAssmtApAccess
     */
    private java.lang.String _szCdRiskAssmtApAccess;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV14DOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00()


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
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'cIndRiskAssmtIntranet'.
     * 
     * @return the value of field 'CIndRiskAssmtIntranet'.
     */
    public java.lang.String getCIndRiskAssmtIntranet()
    {
        return this._cIndRiskAssmtIntranet;
    } //-- java.lang.String getCIndRiskAssmtIntranet() 

    /**
     * Returns the value of field 'cdRiskAssmtPurpose'.
     * 
     * @return the value of field 'CdRiskAssmtPurpose'.
     */
    public java.lang.String getCdRiskAssmtPurpose()
    {
        return this._cdRiskAssmtPurpose;
    } //-- java.lang.String getCdRiskAssmtPurpose() 

    /**
     * Returns the value of field 'szCdRiskAssmtApAccess'.
     * 
     * @return the value of field 'SzCdRiskAssmtApAccess'.
     */
    public java.lang.String getSzCdRiskAssmtApAccess()
    {
        return this._szCdRiskAssmtApAccess;
    } //-- java.lang.String getSzCdRiskAssmtApAccess() 

    /**
     * Returns the value of field 'szCdRiskAssmtRiskFind'.
     * 
     * @return the value of field 'SzCdRiskAssmtRiskFind'.
     */
    public java.lang.String getSzCdRiskAssmtRiskFind()
    {
        return this._szCdRiskAssmtRiskFind;
    } //-- java.lang.String getSzCdRiskAssmtRiskFind() 

    /**
     * Returns the value of field 'szCdRiskFactorCateg'.
     * 
     * @return the value of field 'SzCdRiskFactorCateg'.
     */
    public java.lang.String getSzCdRiskFactorCateg()
    {
        return this._szCdRiskFactorCateg;
    } //-- java.lang.String getSzCdRiskFactorCateg() 

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
     * Sets the value of field 'cIndRiskAssmtIntranet'.
     * 
     * @param cIndRiskAssmtIntranet the value of field
     * 'cIndRiskAssmtIntranet'.
     */
    public void setCIndRiskAssmtIntranet(java.lang.String cIndRiskAssmtIntranet)
    {
        this._cIndRiskAssmtIntranet = cIndRiskAssmtIntranet;
    } //-- void setCIndRiskAssmtIntranet(java.lang.String) 

    /**
     * Sets the value of field 'cdRiskAssmtPurpose'.
     * 
     * @param cdRiskAssmtPurpose the value of field
     * 'cdRiskAssmtPurpose'.
     */
    public void setCdRiskAssmtPurpose(java.lang.String cdRiskAssmtPurpose)
    {
        this._cdRiskAssmtPurpose = cdRiskAssmtPurpose;
    } //-- void setCdRiskAssmtPurpose(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskAssmtApAccess'.
     * 
     * @param szCdRiskAssmtApAccess the value of field
     * 'szCdRiskAssmtApAccess'.
     */
    public void setSzCdRiskAssmtApAccess(java.lang.String szCdRiskAssmtApAccess)
    {
        this._szCdRiskAssmtApAccess = szCdRiskAssmtApAccess;
    } //-- void setSzCdRiskAssmtApAccess(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskAssmtRiskFind'.
     * 
     * @param szCdRiskAssmtRiskFind the value of field
     * 'szCdRiskAssmtRiskFind'.
     */
    public void setSzCdRiskAssmtRiskFind(java.lang.String szCdRiskAssmtRiskFind)
    {
        this._szCdRiskAssmtRiskFind = szCdRiskAssmtRiskFind;
    } //-- void setSzCdRiskAssmtRiskFind(java.lang.String) 

    /**
     * Sets the value of field 'szCdRiskFactorCateg'.
     * 
     * @param szCdRiskFactorCateg the value of field
     * 'szCdRiskFactorCateg'.
     */
    public void setSzCdRiskFactorCateg(java.lang.String szCdRiskFactorCateg)
    {
        this._szCdRiskFactorCateg = szCdRiskFactorCateg;
    } //-- void setSzCdRiskFactorCateg(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 unmarshal(java.io.Reader) 

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
