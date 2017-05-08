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
 * Class ROWCINV44SOG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV44SOG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szScrPersVictim
     */
    private java.lang.String _szScrPersVictim;

    /**
     * Field _ulIdVictim
     */
    private int _ulIdVictim;

    /**
     * keeps track of state for field: _ulIdVictim
     */
    private boolean _has_ulIdVictim;

    /**
     * Field _szCdAllegType
     */
    private java.lang.String _szCdAllegType;

    /**
     * Field _szScrAllegPerp
     */
    private java.lang.String _szScrAllegPerp;

    /**
     * Field _ulIdAllegedPerpetrator
     */
    private int _ulIdAllegedPerpetrator;

    /**
     * keeps track of state for field: _ulIdAllegedPerpetrator
     */
    private boolean _has_ulIdAllegedPerpetrator;

    /**
     * Field _szCdMaltreatorRel
     */
    private java.lang.String _szCdMaltreatorRel;

    /**
     * Field _cdAllegDisposition
     */
    private java.lang.String _cdAllegDisposition;

    /**
     * Field _szCdAllegIncidentStage
     */
    private java.lang.String _szCdAllegIncidentStage;

    /**
     * Field _ulIdAllegation
     */
    private int _ulIdAllegation;

    /**
     * keeps track of state for field: _ulIdAllegation
     */
    private boolean _has_ulIdAllegation;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _szTxtEvidenceSummary
     */
    private java.lang.String _szTxtEvidenceSummary;

    /**
     * Field _szCdAllegSeverity
     */
    private java.lang.String _szCdAllegSeverity;

    /**
     * Field _indChildDeathSeverity
     */
    private java.lang.String _indChildDeathSeverity;

    /**
     * Field _allegEvidence_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY _allegEvidence_ARRAY;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV44SOG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG()


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
    public void deleteUlIdVictim()
    {
        this._has_ulIdVictim= false;
    } //-- void deleteUlIdVictim() 

    /**
     * Returns the value of field 'allegEvidence_ARRAY'.
     * 
     * @return the value of field 'AllegEvidence_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY getAllegEvidence_ARRAY()
    {
        return this._allegEvidence_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY getAllegEvidence_ARRAY() 

    /**
     * Returns the value of field 'cdAllegDisposition'.
     * 
     * @return the value of field 'CdAllegDisposition'.
     */
    public java.lang.String getCdAllegDisposition()
    {
        return this._cdAllegDisposition;
    } //-- java.lang.String getCdAllegDisposition() 

    /**
     * Returns the value of field 'indChildDeathSeverity'.
     * 
     * @return the value of field 'IndChildDeathSeverity'.
     */
    public java.lang.String getIndChildDeathSeverity()
    {
        return this._indChildDeathSeverity;
    } //-- java.lang.String getIndChildDeathSeverity() 

    /**
     * Returns the value of field 'szCdAllegIncidentStage'.
     * 
     * @return the value of field 'SzCdAllegIncidentStage'.
     */
    public java.lang.String getSzCdAllegIncidentStage()
    {
        return this._szCdAllegIncidentStage;
    } //-- java.lang.String getSzCdAllegIncidentStage() 

    /**
     * Returns the value of field 'szCdAllegSeverity'.
     * 
     * @return the value of field 'SzCdAllegSeverity'.
     */
    public java.lang.String getSzCdAllegSeverity()
    {
        return this._szCdAllegSeverity;
    } //-- java.lang.String getSzCdAllegSeverity() 

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
     * Returns the value of field 'szCdMaltreatorRel'.
     * 
     * @return the value of field 'SzCdMaltreatorRel'.
     */
    public java.lang.String getSzCdMaltreatorRel()
    {
        return this._szCdMaltreatorRel;
    } //-- java.lang.String getSzCdMaltreatorRel() 

    /**
     * Returns the value of field 'szScrAllegPerp'.
     * 
     * @return the value of field 'SzScrAllegPerp'.
     */
    public java.lang.String getSzScrAllegPerp()
    {
        return this._szScrAllegPerp;
    } //-- java.lang.String getSzScrAllegPerp() 

    /**
     * Returns the value of field 'szScrPersVictim'.
     * 
     * @return the value of field 'SzScrPersVictim'.
     */
    public java.lang.String getSzScrPersVictim()
    {
        return this._szScrPersVictim;
    } //-- java.lang.String getSzScrPersVictim() 

    /**
     * Returns the value of field 'szTxtEvidenceSummary'.
     * 
     * @return the value of field 'SzTxtEvidenceSummary'.
     */
    public java.lang.String getSzTxtEvidenceSummary()
    {
        return this._szTxtEvidenceSummary;
    } //-- java.lang.String getSzTxtEvidenceSummary() 

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
     * Returns the value of field 'tsSysTsLastUpdate2'.
     * 
     * @return the value of field 'TsSysTsLastUpdate2'.
     */
    public java.util.Date getTsSysTsLastUpdate2()
    {
        return this._tsSysTsLastUpdate2;
    } //-- java.util.Date getTsSysTsLastUpdate2() 

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
     * Sets the value of field 'allegEvidence_ARRAY'.
     * 
     * @param allegEvidence_ARRAY the value of field
     * 'allegEvidence_ARRAY'.
     */
    public void setAllegEvidence_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY allegEvidence_ARRAY)
    {
        this._allegEvidence_ARRAY = allegEvidence_ARRAY;
    } //-- void setAllegEvidence_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY) 

    /**
     * Sets the value of field 'cdAllegDisposition'.
     * 
     * @param cdAllegDisposition the value of field
     * 'cdAllegDisposition'.
     */
    public void setCdAllegDisposition(java.lang.String cdAllegDisposition)
    {
        this._cdAllegDisposition = cdAllegDisposition;
    } //-- void setCdAllegDisposition(java.lang.String) 

    /**
     * Sets the value of field 'indChildDeathSeverity'.
     * 
     * @param indChildDeathSeverity the value of field
     * 'indChildDeathSeverity'.
     */
    public void setIndChildDeathSeverity(java.lang.String indChildDeathSeverity)
    {
        this._indChildDeathSeverity = indChildDeathSeverity;
    } //-- void setIndChildDeathSeverity(java.lang.String) 

    /**
     * Sets the value of field 'szCdAllegIncidentStage'.
     * 
     * @param szCdAllegIncidentStage the value of field
     * 'szCdAllegIncidentStage'.
     */
    public void setSzCdAllegIncidentStage(java.lang.String szCdAllegIncidentStage)
    {
        this._szCdAllegIncidentStage = szCdAllegIncidentStage;
    } //-- void setSzCdAllegIncidentStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdAllegSeverity'.
     * 
     * @param szCdAllegSeverity the value of field
     * 'szCdAllegSeverity'.
     */
    public void setSzCdAllegSeverity(java.lang.String szCdAllegSeverity)
    {
        this._szCdAllegSeverity = szCdAllegSeverity;
    } //-- void setSzCdAllegSeverity(java.lang.String) 

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
     * Sets the value of field 'szScrAllegPerp'.
     * 
     * @param szScrAllegPerp the value of field 'szScrAllegPerp'.
     */
    public void setSzScrAllegPerp(java.lang.String szScrAllegPerp)
    {
        this._szScrAllegPerp = szScrAllegPerp;
    } //-- void setSzScrAllegPerp(java.lang.String) 

    /**
     * Sets the value of field 'szScrPersVictim'.
     * 
     * @param szScrPersVictim the value of field 'szScrPersVictim'.
     */
    public void setSzScrPersVictim(java.lang.String szScrPersVictim)
    {
        this._szScrPersVictim = szScrPersVictim;
    } //-- void setSzScrPersVictim(java.lang.String) 

    /**
     * Sets the value of field 'szTxtEvidenceSummary'.
     * 
     * @param szTxtEvidenceSummary the value of field
     * 'szTxtEvidenceSummary'.
     */
    public void setSzTxtEvidenceSummary(java.lang.String szTxtEvidenceSummary)
    {
        this._szTxtEvidenceSummary = szTxtEvidenceSummary;
    } //-- void setSzTxtEvidenceSummary(java.lang.String) 

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
     * Sets the value of field 'tsSysTsLastUpdate2'.
     * 
     * @param tsSysTsLastUpdate2 the value of field
     * 'tsSysTsLastUpdate2'.
     */
    public void setTsSysTsLastUpdate2(java.util.Date tsSysTsLastUpdate2)
    {
        this._tsSysTsLastUpdate2 = tsSysTsLastUpdate2;
    } //-- void setTsSysTsLastUpdate2(java.util.Date) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG unmarshal(java.io.Reader) 

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
