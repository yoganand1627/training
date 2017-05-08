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
 * Class ROWCINT14DI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT14DI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdAllegation
     */
    private int _ulIdAllegation;

    /**
     * keeps track of state for field: _ulIdAllegation
     */
    private boolean _has_ulIdAllegation;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _szCdAllegType
     */
    private java.lang.String _szCdAllegType;

    /**
     * Field _szTxtAllegDuration
     */
    private java.lang.String _szTxtAllegDuration;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _ulIdVictim
     */
    private int _ulIdVictim;

    /**
     * keeps track of state for field: _ulIdVictim
     */
    private boolean _has_ulIdVictim;

    /**
     * Field _ulIdAllegedPerpetrator
     */
    private int _ulIdAllegedPerpetrator;

    /**
     * keeps track of state for field: _ulIdAllegedPerpetrator
     */
    private boolean _has_ulIdAllegedPerpetrator;

    /**
     * Field _szNmVictim
     */
    private java.lang.String _szNmVictim;

    /**
     * Field _szNmPerpetrator
     */
    private java.lang.String _szNmPerpetrator;

    /**
     * Field _szCdAllegedMalLocation
     */
    private java.lang.String _szCdAllegedMalLocation;

    /**
     * Field _szCdIntakeAllegMalCode
     */
    private java.lang.String _szCdIntakeAllegMalCode;

    /**
     * Field _dtDtAllegedIncident
     */
    private org.exolab.castor.types.Date _dtDtAllegedIncident;

    /**
     * Field _szCdMaltreatorRel
     */
    private java.lang.String _szCdMaltreatorRel;

    /**
     * Field _cIndIncmgMaltreatInCare
     */
    private java.lang.String _cIndIncmgMaltreatInCare;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT14DI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdAllegation()
    {
        this._has_ulIdAllegation= false;
    } //-- void deleteUlIdAllegation() 

    /**
     */
    public void deleteUlIdAllegedPerpetrator()
    {
        this._has_ulIdAllegedPerpetrator= false;
    } //-- void deleteUlIdAllegedPerpetrator() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdVictim()
    {
        this._has_ulIdVictim= false;
    } //-- void deleteUlIdVictim() 

    /**
     * Returns the value of field 'cIndIncmgMaltreatInCare'.
     * 
     * @return the value of field 'CIndIncmgMaltreatInCare'.
     */
    public java.lang.String getCIndIncmgMaltreatInCare()
    {
        return this._cIndIncmgMaltreatInCare;
    } //-- java.lang.String getCIndIncmgMaltreatInCare() 

    /**
     * Returns the value of field 'dtDtAllegedIncident'.
     * 
     * @return the value of field 'DtDtAllegedIncident'.
     */
    public org.exolab.castor.types.Date getDtDtAllegedIncident()
    {
        return this._dtDtAllegedIncident;
    } //-- org.exolab.castor.types.Date getDtDtAllegedIncident() 

    /**
     * Returns the value of field 'szCdAllegType'.
     * 
     * @return the value of field 'SzCdAllegType'.
     */
    public java.lang.String getSzCdAllegType()
    {
        return this._szCdAllegType;
    } //-- java.lang.String getSzCdAllegType() 

    /**
     * Returns the value of field 'szCdAllegedMalLocation'.
     * 
     * @return the value of field 'SzCdAllegedMalLocation'.
     */
    public java.lang.String getSzCdAllegedMalLocation()
    {
        return this._szCdAllegedMalLocation;
    } //-- java.lang.String getSzCdAllegedMalLocation() 

    /**
     * Returns the value of field 'szCdIntakeAllegMalCode'.
     * 
     * @return the value of field 'SzCdIntakeAllegMalCode'.
     */
    public java.lang.String getSzCdIntakeAllegMalCode()
    {
        return this._szCdIntakeAllegMalCode;
    } //-- java.lang.String getSzCdIntakeAllegMalCode() 

    /**
     * Returns the value of field 'szCdMaltreatorRel'.
     * 
     * @return the value of field 'SzCdMaltreatorRel'.
     */
    public java.lang.String getSzCdMaltreatorRel()
    {
        return this._szCdMaltreatorRel;
    } //-- java.lang.String getSzCdMaltreatorRel() 

    /**
     * Returns the value of field 'szCdScrDataAction'.
     * 
     * @return the value of field 'SzCdScrDataAction'.
     */
    public java.lang.String getSzCdScrDataAction()
    {
        return this._szCdScrDataAction;
    } //-- java.lang.String getSzCdScrDataAction() 

    /**
     * Returns the value of field 'szNmPerpetrator'.
     * 
     * @return the value of field 'SzNmPerpetrator'.
     */
    public java.lang.String getSzNmPerpetrator()
    {
        return this._szNmPerpetrator;
    } //-- java.lang.String getSzNmPerpetrator() 

    /**
     * Returns the value of field 'szNmVictim'.
     * 
     * @return the value of field 'SzNmVictim'.
     */
    public java.lang.String getSzNmVictim()
    {
        return this._szNmVictim;
    } //-- java.lang.String getSzNmVictim() 

    /**
     * Returns the value of field 'szTxtAllegDuration'.
     * 
     * @return the value of field 'SzTxtAllegDuration'.
     */
    public java.lang.String getSzTxtAllegDuration()
    {
        return this._szTxtAllegDuration;
    } //-- java.lang.String getSzTxtAllegDuration() 

    /**
     * Returns the value of field 'ulIdAllegation'.
     * 
     * @return the value of field 'UlIdAllegation'.
     */
    public int getUlIdAllegation()
    {
        return this._ulIdAllegation;
    } //-- int getUlIdAllegation() 

    /**
     * Returns the value of field 'ulIdAllegedPerpetrator'.
     * 
     * @return the value of field 'UlIdAllegedPerpetrator'.
     */
    public int getUlIdAllegedPerpetrator()
    {
        return this._ulIdAllegedPerpetrator;
    } //-- int getUlIdAllegedPerpetrator() 

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
     * Returns the value of field 'ulIdVictim'.
     * 
     * @return the value of field 'UlIdVictim'.
     */
    public int getUlIdVictim()
    {
        return this._ulIdVictim;
    } //-- int getUlIdVictim() 

    /**
     * Method hasUlIdAllegation
     * 
     * 
     * 
     * @return true if at least one UlIdAllegation has been added
     */
    public boolean hasUlIdAllegation()
    {
        return this._has_ulIdAllegation;
    } //-- boolean hasUlIdAllegation() 

    /**
     * Method hasUlIdAllegedPerpetrator
     * 
     * 
     * 
     * @return true if at least one UlIdAllegedPerpetrator has been
     * added
     */
    public boolean hasUlIdAllegedPerpetrator()
    {
        return this._has_ulIdAllegedPerpetrator;
    } //-- boolean hasUlIdAllegedPerpetrator() 

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
     * Method hasUlIdVictim
     * 
     * 
     * 
     * @return true if at least one UlIdVictim has been added
     */
    public boolean hasUlIdVictim()
    {
        return this._has_ulIdVictim;
    } //-- boolean hasUlIdVictim() 

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
     * Sets the value of field 'cIndIncmgMaltreatInCare'.
     * 
     * @param cIndIncmgMaltreatInCare the value of field
     * 'cIndIncmgMaltreatInCare'.
     */
    public void setCIndIncmgMaltreatInCare(java.lang.String cIndIncmgMaltreatInCare)
    {
        this._cIndIncmgMaltreatInCare = cIndIncmgMaltreatInCare;
    } //-- void setCIndIncmgMaltreatInCare(java.lang.String) 

    /**
     * Sets the value of field 'dtDtAllegedIncident'.
     * 
     * @param dtDtAllegedIncident the value of field
     * 'dtDtAllegedIncident'.
     */
    public void setDtDtAllegedIncident(org.exolab.castor.types.Date dtDtAllegedIncident)
    {
        this._dtDtAllegedIncident = dtDtAllegedIncident;
    } //-- void setDtDtAllegedIncident(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdAllegType'.
     * 
     * @param szCdAllegType the value of field 'szCdAllegType'.
     */
    public void setSzCdAllegType(java.lang.String szCdAllegType)
    {
        this._szCdAllegType = szCdAllegType;
    } //-- void setSzCdAllegType(java.lang.String) 

    /**
     * Sets the value of field 'szCdAllegedMalLocation'.
     * 
     * @param szCdAllegedMalLocation the value of field
     * 'szCdAllegedMalLocation'.
     */
    public void setSzCdAllegedMalLocation(java.lang.String szCdAllegedMalLocation)
    {
        this._szCdAllegedMalLocation = szCdAllegedMalLocation;
    } //-- void setSzCdAllegedMalLocation(java.lang.String) 

    /**
     * Sets the value of field 'szCdIntakeAllegMalCode'.
     * 
     * @param szCdIntakeAllegMalCode the value of field
     * 'szCdIntakeAllegMalCode'.
     */
    public void setSzCdIntakeAllegMalCode(java.lang.String szCdIntakeAllegMalCode)
    {
        this._szCdIntakeAllegMalCode = szCdIntakeAllegMalCode;
    } //-- void setSzCdIntakeAllegMalCode(java.lang.String) 

    /**
     * Sets the value of field 'szCdMaltreatorRel'.
     * 
     * @param szCdMaltreatorRel the value of field
     * 'szCdMaltreatorRel'.
     */
    public void setSzCdMaltreatorRel(java.lang.String szCdMaltreatorRel)
    {
        this._szCdMaltreatorRel = szCdMaltreatorRel;
    } //-- void setSzCdMaltreatorRel(java.lang.String) 

    /**
     * Sets the value of field 'szCdScrDataAction'.
     * 
     * @param szCdScrDataAction the value of field
     * 'szCdScrDataAction'.
     */
    public void setSzCdScrDataAction(java.lang.String szCdScrDataAction)
    {
        this._szCdScrDataAction = szCdScrDataAction;
    } //-- void setSzCdScrDataAction(java.lang.String) 

    /**
     * Sets the value of field 'szNmPerpetrator'.
     * 
     * @param szNmPerpetrator the value of field 'szNmPerpetrator'.
     */
    public void setSzNmPerpetrator(java.lang.String szNmPerpetrator)
    {
        this._szNmPerpetrator = szNmPerpetrator;
    } //-- void setSzNmPerpetrator(java.lang.String) 

    /**
     * Sets the value of field 'szNmVictim'.
     * 
     * @param szNmVictim the value of field 'szNmVictim'.
     */
    public void setSzNmVictim(java.lang.String szNmVictim)
    {
        this._szNmVictim = szNmVictim;
    } //-- void setSzNmVictim(java.lang.String) 

    /**
     * Sets the value of field 'szTxtAllegDuration'.
     * 
     * @param szTxtAllegDuration the value of field
     * 'szTxtAllegDuration'.
     */
    public void setSzTxtAllegDuration(java.lang.String szTxtAllegDuration)
    {
        this._szTxtAllegDuration = szTxtAllegDuration;
    } //-- void setSzTxtAllegDuration(java.lang.String) 

    /**
     * Sets the value of field 'ulIdAllegation'.
     * 
     * @param ulIdAllegation the value of field 'ulIdAllegation'.
     */
    public void setUlIdAllegation(int ulIdAllegation)
    {
        this._ulIdAllegation = ulIdAllegation;
        this._has_ulIdAllegation = true;
    } //-- void setUlIdAllegation(int) 

    /**
     * Sets the value of field 'ulIdAllegedPerpetrator'.
     * 
     * @param ulIdAllegedPerpetrator the value of field
     * 'ulIdAllegedPerpetrator'.
     */
    public void setUlIdAllegedPerpetrator(int ulIdAllegedPerpetrator)
    {
        this._ulIdAllegedPerpetrator = ulIdAllegedPerpetrator;
        this._has_ulIdAllegedPerpetrator = true;
    } //-- void setUlIdAllegedPerpetrator(int) 

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
     * Sets the value of field 'ulIdVictim'.
     * 
     * @param ulIdVictim the value of field 'ulIdVictim'.
     */
    public void setUlIdVictim(int ulIdVictim)
    {
        this._ulIdVictim = ulIdVictim;
        this._has_ulIdVictim = true;
    } //-- void setUlIdVictim(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI unmarshal(java.io.Reader) 

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
