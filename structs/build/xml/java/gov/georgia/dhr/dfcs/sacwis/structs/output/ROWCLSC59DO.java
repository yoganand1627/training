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
 * Class ROWCLSC59DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCLSC59DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdStageType
     */
    private java.lang.String _szCdStageType;

    /**
     * Field _ulIdUnit
     */
    private int _ulIdUnit;

    /**
     * keeps track of state for field: _ulIdUnit
     */
    private boolean _has_ulIdUnit;

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
     * Field _dtDtStageClose
     */
    private org.exolab.castor.types.Date _dtDtStageClose;

    /**
     * Field _tmScrTmGeneric1
     */
    private java.lang.String _tmScrTmGeneric1;

    /**
     * Field _szCdStageClassification
     */
    private java.lang.String _szCdStageClassification;

    /**
     * Field _szCdStageCurrPriority
     */
    private java.lang.String _szCdStageCurrPriority;

    /**
     * Field _szCdStageInitialPriority
     */
    private java.lang.String _szCdStageInitialPriority;

    /**
     * Field _szCdStageRsnPriorityChgd
     */
    private java.lang.String _szCdStageRsnPriorityChgd;

    /**
     * Field _szCdStageReasonClosed
     */
    private java.lang.String _szCdStageReasonClosed;

    /**
     * Field _bIndStageClose
     */
    private java.lang.String _bIndStageClose;

    /**
     * Field _szCdStageCnty
     */
    private java.lang.String _szCdStageCnty;

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _szCdStageRegion
     */
    private java.lang.String _szCdStageRegion;

    /**
     * Field _dtDtStageStart
     */
    private org.exolab.castor.types.Date _dtDtStageStart;

    /**
     * Field _tmScrTmGeneric2
     */
    private java.lang.String _tmScrTmGeneric2;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szTxtStagePriorityCmnts
     */
    private java.lang.String _szTxtStagePriorityCmnts;

    /**
     * Field _szTxtStageClosureCmnts
     */
    private java.lang.String _szTxtStageClosureCmnts;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCLSC59DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO()


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
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdUnit()
    {
        this._has_ulIdUnit= false;
    } //-- void deleteUlIdUnit() 

    /**
     * Returns the value of field 'bIndStageClose'.
     * 
     * @return the value of field 'BIndStageClose'.
     */
    public java.lang.String getBIndStageClose()
    {
        return this._bIndStageClose;
    } //-- java.lang.String getBIndStageClose() 

    /**
     * Returns the value of field 'dtDtStageClose'.
     * 
     * @return the value of field 'DtDtStageClose'.
     */
    public org.exolab.castor.types.Date getDtDtStageClose()
    {
        return this._dtDtStageClose;
    } //-- org.exolab.castor.types.Date getDtDtStageClose() 

    /**
     * Returns the value of field 'dtDtStageStart'.
     * 
     * @return the value of field 'DtDtStageStart'.
     */
    public org.exolab.castor.types.Date getDtDtStageStart()
    {
        return this._dtDtStageStart;
    } //-- org.exolab.castor.types.Date getDtDtStageStart() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szCdStageClassification'.
     * 
     * @return the value of field 'SzCdStageClassification'.
     */
    public java.lang.String getSzCdStageClassification()
    {
        return this._szCdStageClassification;
    } //-- java.lang.String getSzCdStageClassification() 

    /**
     * Returns the value of field 'szCdStageCnty'.
     * 
     * @return the value of field 'SzCdStageCnty'.
     */
    public java.lang.String getSzCdStageCnty()
    {
        return this._szCdStageCnty;
    } //-- java.lang.String getSzCdStageCnty() 

    /**
     * Returns the value of field 'szCdStageCurrPriority'.
     * 
     * @return the value of field 'SzCdStageCurrPriority'.
     */
    public java.lang.String getSzCdStageCurrPriority()
    {
        return this._szCdStageCurrPriority;
    } //-- java.lang.String getSzCdStageCurrPriority() 

    /**
     * Returns the value of field 'szCdStageInitialPriority'.
     * 
     * @return the value of field 'SzCdStageInitialPriority'.
     */
    public java.lang.String getSzCdStageInitialPriority()
    {
        return this._szCdStageInitialPriority;
    } //-- java.lang.String getSzCdStageInitialPriority() 

    /**
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

    /**
     * Returns the value of field 'szCdStageReasonClosed'.
     * 
     * @return the value of field 'SzCdStageReasonClosed'.
     */
    public java.lang.String getSzCdStageReasonClosed()
    {
        return this._szCdStageReasonClosed;
    } //-- java.lang.String getSzCdStageReasonClosed() 

    /**
     * Returns the value of field 'szCdStageRegion'.
     * 
     * @return the value of field 'SzCdStageRegion'.
     */
    public java.lang.String getSzCdStageRegion()
    {
        return this._szCdStageRegion;
    } //-- java.lang.String getSzCdStageRegion() 

    /**
     * Returns the value of field 'szCdStageRsnPriorityChgd'.
     * 
     * @return the value of field 'SzCdStageRsnPriorityChgd'.
     */
    public java.lang.String getSzCdStageRsnPriorityChgd()
    {
        return this._szCdStageRsnPriorityChgd;
    } //-- java.lang.String getSzCdStageRsnPriorityChgd() 

    /**
     * Returns the value of field 'szCdStageType'.
     * 
     * @return the value of field 'SzCdStageType'.
     */
    public java.lang.String getSzCdStageType()
    {
        return this._szCdStageType;
    } //-- java.lang.String getSzCdStageType() 

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
     * Returns the value of field 'szTxtStageClosureCmnts'.
     * 
     * @return the value of field 'SzTxtStageClosureCmnts'.
     */
    public java.lang.String getSzTxtStageClosureCmnts()
    {
        return this._szTxtStageClosureCmnts;
    } //-- java.lang.String getSzTxtStageClosureCmnts() 

    /**
     * Returns the value of field 'szTxtStagePriorityCmnts'.
     * 
     * @return the value of field 'SzTxtStagePriorityCmnts'.
     */
    public java.lang.String getSzTxtStagePriorityCmnts()
    {
        return this._szTxtStagePriorityCmnts;
    } //-- java.lang.String getSzTxtStagePriorityCmnts() 

    /**
     * Returns the value of field 'tmScrTmGeneric1'.
     * 
     * @return the value of field 'TmScrTmGeneric1'.
     */
    public java.lang.String getTmScrTmGeneric1()
    {
        return this._tmScrTmGeneric1;
    } //-- java.lang.String getTmScrTmGeneric1() 

    /**
     * Returns the value of field 'tmScrTmGeneric2'.
     * 
     * @return the value of field 'TmScrTmGeneric2'.
     */
    public java.lang.String getTmScrTmGeneric2()
    {
        return this._tmScrTmGeneric2;
    } //-- java.lang.String getTmScrTmGeneric2() 

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
     * Returns the value of field 'ulIdSituation'.
     * 
     * @return the value of field 'UlIdSituation'.
     */
    public int getUlIdSituation()
    {
        return this._ulIdSituation;
    } //-- int getUlIdSituation() 

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
     * Returns the value of field 'ulIdUnit'.
     * 
     * @return the value of field 'UlIdUnit'.
     */
    public int getUlIdUnit()
    {
        return this._ulIdUnit;
    } //-- int getUlIdUnit() 

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
     * Method hasUlIdUnit
     * 
     * 
     * 
     * @return true if at least one UlIdUnit has been added
     */
    public boolean hasUlIdUnit()
    {
        return this._has_ulIdUnit;
    } //-- boolean hasUlIdUnit() 

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
     * Sets the value of field 'bIndStageClose'.
     * 
     * @param bIndStageClose the value of field 'bIndStageClose'.
     */
    public void setBIndStageClose(java.lang.String bIndStageClose)
    {
        this._bIndStageClose = bIndStageClose;
    } //-- void setBIndStageClose(java.lang.String) 

    /**
     * Sets the value of field 'dtDtStageClose'.
     * 
     * @param dtDtStageClose the value of field 'dtDtStageClose'.
     */
    public void setDtDtStageClose(org.exolab.castor.types.Date dtDtStageClose)
    {
        this._dtDtStageClose = dtDtStageClose;
    } //-- void setDtDtStageClose(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtStageStart'.
     * 
     * @param dtDtStageStart the value of field 'dtDtStageStart'.
     */
    public void setDtDtStageStart(org.exolab.castor.types.Date dtDtStageStart)
    {
        this._dtDtStageStart = dtDtStageStart;
    } //-- void setDtDtStageStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageClassification'.
     * 
     * @param szCdStageClassification the value of field
     * 'szCdStageClassification'.
     */
    public void setSzCdStageClassification(java.lang.String szCdStageClassification)
    {
        this._szCdStageClassification = szCdStageClassification;
    } //-- void setSzCdStageClassification(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCnty'.
     * 
     * @param szCdStageCnty the value of field 'szCdStageCnty'.
     */
    public void setSzCdStageCnty(java.lang.String szCdStageCnty)
    {
        this._szCdStageCnty = szCdStageCnty;
    } //-- void setSzCdStageCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCurrPriority'.
     * 
     * @param szCdStageCurrPriority the value of field
     * 'szCdStageCurrPriority'.
     */
    public void setSzCdStageCurrPriority(java.lang.String szCdStageCurrPriority)
    {
        this._szCdStageCurrPriority = szCdStageCurrPriority;
    } //-- void setSzCdStageCurrPriority(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageInitialPriority'.
     * 
     * @param szCdStageInitialPriority the value of field
     * 'szCdStageInitialPriority'.
     */
    public void setSzCdStageInitialPriority(java.lang.String szCdStageInitialPriority)
    {
        this._szCdStageInitialPriority = szCdStageInitialPriority;
    } //-- void setSzCdStageInitialPriority(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageReasonClosed'.
     * 
     * @param szCdStageReasonClosed the value of field
     * 'szCdStageReasonClosed'.
     */
    public void setSzCdStageReasonClosed(java.lang.String szCdStageReasonClosed)
    {
        this._szCdStageReasonClosed = szCdStageReasonClosed;
    } //-- void setSzCdStageReasonClosed(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageRegion'.
     * 
     * @param szCdStageRegion the value of field 'szCdStageRegion'.
     */
    public void setSzCdStageRegion(java.lang.String szCdStageRegion)
    {
        this._szCdStageRegion = szCdStageRegion;
    } //-- void setSzCdStageRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageRsnPriorityChgd'.
     * 
     * @param szCdStageRsnPriorityChgd the value of field
     * 'szCdStageRsnPriorityChgd'.
     */
    public void setSzCdStageRsnPriorityChgd(java.lang.String szCdStageRsnPriorityChgd)
    {
        this._szCdStageRsnPriorityChgd = szCdStageRsnPriorityChgd;
    } //-- void setSzCdStageRsnPriorityChgd(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageType'.
     * 
     * @param szCdStageType the value of field 'szCdStageType'.
     */
    public void setSzCdStageType(java.lang.String szCdStageType)
    {
        this._szCdStageType = szCdStageType;
    } //-- void setSzCdStageType(java.lang.String) 

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
     * Sets the value of field 'szTxtStageClosureCmnts'.
     * 
     * @param szTxtStageClosureCmnts the value of field
     * 'szTxtStageClosureCmnts'.
     */
    public void setSzTxtStageClosureCmnts(java.lang.String szTxtStageClosureCmnts)
    {
        this._szTxtStageClosureCmnts = szTxtStageClosureCmnts;
    } //-- void setSzTxtStageClosureCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtStagePriorityCmnts'.
     * 
     * @param szTxtStagePriorityCmnts the value of field
     * 'szTxtStagePriorityCmnts'.
     */
    public void setSzTxtStagePriorityCmnts(java.lang.String szTxtStagePriorityCmnts)
    {
        this._szTxtStagePriorityCmnts = szTxtStagePriorityCmnts;
    } //-- void setSzTxtStagePriorityCmnts(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmGeneric1'.
     * 
     * @param tmScrTmGeneric1 the value of field 'tmScrTmGeneric1'.
     */
    public void setTmScrTmGeneric1(java.lang.String tmScrTmGeneric1)
    {
        this._tmScrTmGeneric1 = tmScrTmGeneric1;
    } //-- void setTmScrTmGeneric1(java.lang.String) 

    /**
     * Sets the value of field 'tmScrTmGeneric2'.
     * 
     * @param tmScrTmGeneric2 the value of field 'tmScrTmGeneric2'.
     */
    public void setTmScrTmGeneric2(java.lang.String tmScrTmGeneric2)
    {
        this._tmScrTmGeneric2 = tmScrTmGeneric2;
    } //-- void setTmScrTmGeneric2(java.lang.String) 

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
     * Sets the value of field 'ulIdUnit'.
     * 
     * @param ulIdUnit the value of field 'ulIdUnit'.
     */
    public void setUlIdUnit(int ulIdUnit)
    {
        this._ulIdUnit = ulIdUnit;
        this._has_ulIdUnit = true;
    } //-- void setUlIdUnit(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO unmarshal(java.io.Reader) 

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
