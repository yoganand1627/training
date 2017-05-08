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
 * Class CINV07SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV07SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dtDtFacilAllegIncident
     */
    private org.exolab.castor.types.Date _dtDtFacilAllegIncident;

    /**
     * Field _tmTmIncmgCall
     */
    private java.lang.String _tmTmIncmgCall;

    /**
     * Field _szCdFacilAllegNeglType
     */
    private java.lang.String _szCdFacilAllegNeglType;

    /**
     * Field _ulIdAllegedPerpetrator
     */
    private int _ulIdAllegedPerpetrator;

    /**
     * keeps track of state for field: _ulIdAllegedPerpetrator
     */
    private boolean _has_ulIdAllegedPerpetrator;

    /**
     * Field _ulIdVictim
     */
    private int _ulIdVictim;

    /**
     * keeps track of state for field: _ulIdVictim
     */
    private boolean _has_ulIdVictim;

    /**
     * Field _dtDtTodaysDate
     */
    private org.exolab.castor.types.Date _dtDtTodaysDate;

    /**
     * Field _szCdAllegType
     */
    private java.lang.String _szCdAllegType;

    /**
     * Field _szCdAllegIncidentStage
     */
    private java.lang.String _szCdAllegIncidentStage;

    /**
     * Field _szCdFacilAllegDispSupr
     */
    private java.lang.String _szCdFacilAllegDispSupr;

    /**
     * Field _cdAllegDisposition
     */
    private java.lang.String _cdAllegDisposition;

    /**
     * Field _szCdFacilAllegEventLoc
     */
    private java.lang.String _szCdFacilAllegEventLoc;

    /**
     * Field _szCdFacilAllegInjSer
     */
    private java.lang.String _szCdFacilAllegInjSer;

    /**
     * Field _szNbrFacilAllegMHMR
     */
    private java.lang.String _szNbrFacilAllegMHMR;

    /**
     * Field _bIndFacilAllegAbOffGr
     */
    private java.lang.String _bIndFacilAllegAbOffGr;

    /**
     * Field _bIndFacilAllegSupvd
     */
    private java.lang.String _bIndFacilAllegSupvd;

    /**
     * Field _szCdFacilAllegSrc
     */
    private java.lang.String _szCdFacilAllegSrc;

    /**
     * Field _szCdFacilAllegSrcSupr
     */
    private java.lang.String _szCdFacilAllegSrcSupr;

    /**
     * Field _dtDtFacilAllegInvstgtr
     */
    private org.exolab.castor.types.Date _dtDtFacilAllegInvstgtr;

    /**
     * Field _dtDtFacilAllegSuprReply
     */
    private org.exolab.castor.types.Date _dtDtFacilAllegSuprReply;

    /**
     * Field _szFacilAllegInvClass
     */
    private java.lang.String _szFacilAllegInvClass;

    /**
     * Field _szCdFacilAllegClssSupr
     */
    private java.lang.String _szCdFacilAllegClssSupr;

    /**
     * Field _szTxtFacilAllegCmnts
     */
    private java.lang.String _szTxtFacilAllegCmnts;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _szCdEventStatus
     */
    private java.lang.String _szCdEventStatus;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV07SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'bIndFacilAllegAbOffGr'.
     * 
     * @return the value of field 'BIndFacilAllegAbOffGr'.
     */
    public java.lang.String getBIndFacilAllegAbOffGr()
    {
        return this._bIndFacilAllegAbOffGr;
    } //-- java.lang.String getBIndFacilAllegAbOffGr() 

    /**
     * Returns the value of field 'bIndFacilAllegSupvd'.
     * 
     * @return the value of field 'BIndFacilAllegSupvd'.
     */
    public java.lang.String getBIndFacilAllegSupvd()
    {
        return this._bIndFacilAllegSupvd;
    } //-- java.lang.String getBIndFacilAllegSupvd() 

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
     * Returns the value of field 'dtDtFacilAllegIncident'.
     * 
     * @return the value of field 'DtDtFacilAllegIncident'.
     */
    public org.exolab.castor.types.Date getDtDtFacilAllegIncident()
    {
        return this._dtDtFacilAllegIncident;
    } //-- org.exolab.castor.types.Date getDtDtFacilAllegIncident() 

    /**
     * Returns the value of field 'dtDtFacilAllegInvstgtr'.
     * 
     * @return the value of field 'DtDtFacilAllegInvstgtr'.
     */
    public org.exolab.castor.types.Date getDtDtFacilAllegInvstgtr()
    {
        return this._dtDtFacilAllegInvstgtr;
    } //-- org.exolab.castor.types.Date getDtDtFacilAllegInvstgtr() 

    /**
     * Returns the value of field 'dtDtFacilAllegSuprReply'.
     * 
     * @return the value of field 'DtDtFacilAllegSuprReply'.
     */
    public org.exolab.castor.types.Date getDtDtFacilAllegSuprReply()
    {
        return this._dtDtFacilAllegSuprReply;
    } //-- org.exolab.castor.types.Date getDtDtFacilAllegSuprReply() 

    /**
     * Returns the value of field 'dtDtTodaysDate'.
     * 
     * @return the value of field 'DtDtTodaysDate'.
     */
    public org.exolab.castor.types.Date getDtDtTodaysDate()
    {
        return this._dtDtTodaysDate;
    } //-- org.exolab.castor.types.Date getDtDtTodaysDate() 

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
     * Returns the value of field 'szCdAllegType'.
     * 
     * @return the value of field 'SzCdAllegType'.
     */
    public java.lang.String getSzCdAllegType()
    {
        return this._szCdAllegType;
    } //-- java.lang.String getSzCdAllegType() 

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
     * Returns the value of field 'szCdFacilAllegClssSupr'.
     * 
     * @return the value of field 'SzCdFacilAllegClssSupr'.
     */
    public java.lang.String getSzCdFacilAllegClssSupr()
    {
        return this._szCdFacilAllegClssSupr;
    } //-- java.lang.String getSzCdFacilAllegClssSupr() 

    /**
     * Returns the value of field 'szCdFacilAllegDispSupr'.
     * 
     * @return the value of field 'SzCdFacilAllegDispSupr'.
     */
    public java.lang.String getSzCdFacilAllegDispSupr()
    {
        return this._szCdFacilAllegDispSupr;
    } //-- java.lang.String getSzCdFacilAllegDispSupr() 

    /**
     * Returns the value of field 'szCdFacilAllegEventLoc'.
     * 
     * @return the value of field 'SzCdFacilAllegEventLoc'.
     */
    public java.lang.String getSzCdFacilAllegEventLoc()
    {
        return this._szCdFacilAllegEventLoc;
    } //-- java.lang.String getSzCdFacilAllegEventLoc() 

    /**
     * Returns the value of field 'szCdFacilAllegInjSer'.
     * 
     * @return the value of field 'SzCdFacilAllegInjSer'.
     */
    public java.lang.String getSzCdFacilAllegInjSer()
    {
        return this._szCdFacilAllegInjSer;
    } //-- java.lang.String getSzCdFacilAllegInjSer() 

    /**
     * Returns the value of field 'szCdFacilAllegNeglType'.
     * 
     * @return the value of field 'SzCdFacilAllegNeglType'.
     */
    public java.lang.String getSzCdFacilAllegNeglType()
    {
        return this._szCdFacilAllegNeglType;
    } //-- java.lang.String getSzCdFacilAllegNeglType() 

    /**
     * Returns the value of field 'szCdFacilAllegSrc'.
     * 
     * @return the value of field 'SzCdFacilAllegSrc'.
     */
    public java.lang.String getSzCdFacilAllegSrc()
    {
        return this._szCdFacilAllegSrc;
    } //-- java.lang.String getSzCdFacilAllegSrc() 

    /**
     * Returns the value of field 'szCdFacilAllegSrcSupr'.
     * 
     * @return the value of field 'SzCdFacilAllegSrcSupr'.
     */
    public java.lang.String getSzCdFacilAllegSrcSupr()
    {
        return this._szCdFacilAllegSrcSupr;
    } //-- java.lang.String getSzCdFacilAllegSrcSupr() 

    /**
     * Returns the value of field 'szFacilAllegInvClass'.
     * 
     * @return the value of field 'SzFacilAllegInvClass'.
     */
    public java.lang.String getSzFacilAllegInvClass()
    {
        return this._szFacilAllegInvClass;
    } //-- java.lang.String getSzFacilAllegInvClass() 

    /**
     * Returns the value of field 'szNbrFacilAllegMHMR'.
     * 
     * @return the value of field 'SzNbrFacilAllegMHMR'.
     */
    public java.lang.String getSzNbrFacilAllegMHMR()
    {
        return this._szNbrFacilAllegMHMR;
    } //-- java.lang.String getSzNbrFacilAllegMHMR() 

    /**
     * Returns the value of field 'szTxtFacilAllegCmnts'.
     * 
     * @return the value of field 'SzTxtFacilAllegCmnts'.
     */
    public java.lang.String getSzTxtFacilAllegCmnts()
    {
        return this._szTxtFacilAllegCmnts;
    } //-- java.lang.String getSzTxtFacilAllegCmnts() 

    /**
     * Returns the value of field 'tmTmIncmgCall'.
     * 
     * @return the value of field 'TmTmIncmgCall'.
     */
    public java.lang.String getTmTmIncmgCall()
    {
        return this._tmTmIncmgCall;
    } //-- java.lang.String getTmTmIncmgCall() 

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
     * Sets the value of field 'bIndFacilAllegAbOffGr'.
     * 
     * @param bIndFacilAllegAbOffGr the value of field
     * 'bIndFacilAllegAbOffGr'.
     */
    public void setBIndFacilAllegAbOffGr(java.lang.String bIndFacilAllegAbOffGr)
    {
        this._bIndFacilAllegAbOffGr = bIndFacilAllegAbOffGr;
    } //-- void setBIndFacilAllegAbOffGr(java.lang.String) 

    /**
     * Sets the value of field 'bIndFacilAllegSupvd'.
     * 
     * @param bIndFacilAllegSupvd the value of field
     * 'bIndFacilAllegSupvd'.
     */
    public void setBIndFacilAllegSupvd(java.lang.String bIndFacilAllegSupvd)
    {
        this._bIndFacilAllegSupvd = bIndFacilAllegSupvd;
    } //-- void setBIndFacilAllegSupvd(java.lang.String) 

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
     * Sets the value of field 'dtDtFacilAllegIncident'.
     * 
     * @param dtDtFacilAllegIncident the value of field
     * 'dtDtFacilAllegIncident'.
     */
    public void setDtDtFacilAllegIncident(org.exolab.castor.types.Date dtDtFacilAllegIncident)
    {
        this._dtDtFacilAllegIncident = dtDtFacilAllegIncident;
    } //-- void setDtDtFacilAllegIncident(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtFacilAllegInvstgtr'.
     * 
     * @param dtDtFacilAllegInvstgtr the value of field
     * 'dtDtFacilAllegInvstgtr'.
     */
    public void setDtDtFacilAllegInvstgtr(org.exolab.castor.types.Date dtDtFacilAllegInvstgtr)
    {
        this._dtDtFacilAllegInvstgtr = dtDtFacilAllegInvstgtr;
    } //-- void setDtDtFacilAllegInvstgtr(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtFacilAllegSuprReply'.
     * 
     * @param dtDtFacilAllegSuprReply the value of field
     * 'dtDtFacilAllegSuprReply'.
     */
    public void setDtDtFacilAllegSuprReply(org.exolab.castor.types.Date dtDtFacilAllegSuprReply)
    {
        this._dtDtFacilAllegSuprReply = dtDtFacilAllegSuprReply;
    } //-- void setDtDtFacilAllegSuprReply(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtTodaysDate'.
     * 
     * @param dtDtTodaysDate the value of field 'dtDtTodaysDate'.
     */
    public void setDtDtTodaysDate(org.exolab.castor.types.Date dtDtTodaysDate)
    {
        this._dtDtTodaysDate = dtDtTodaysDate;
    } //-- void setDtDtTodaysDate(org.exolab.castor.types.Date) 

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
     * Sets the value of field 'szCdAllegType'.
     * 
     * @param szCdAllegType the value of field 'szCdAllegType'.
     */
    public void setSzCdAllegType(java.lang.String szCdAllegType)
    {
        this._szCdAllegType = szCdAllegType;
    } //-- void setSzCdAllegType(java.lang.String) 

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
     * Sets the value of field 'szCdFacilAllegClssSupr'.
     * 
     * @param szCdFacilAllegClssSupr the value of field
     * 'szCdFacilAllegClssSupr'.
     */
    public void setSzCdFacilAllegClssSupr(java.lang.String szCdFacilAllegClssSupr)
    {
        this._szCdFacilAllegClssSupr = szCdFacilAllegClssSupr;
    } //-- void setSzCdFacilAllegClssSupr(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilAllegDispSupr'.
     * 
     * @param szCdFacilAllegDispSupr the value of field
     * 'szCdFacilAllegDispSupr'.
     */
    public void setSzCdFacilAllegDispSupr(java.lang.String szCdFacilAllegDispSupr)
    {
        this._szCdFacilAllegDispSupr = szCdFacilAllegDispSupr;
    } //-- void setSzCdFacilAllegDispSupr(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilAllegEventLoc'.
     * 
     * @param szCdFacilAllegEventLoc the value of field
     * 'szCdFacilAllegEventLoc'.
     */
    public void setSzCdFacilAllegEventLoc(java.lang.String szCdFacilAllegEventLoc)
    {
        this._szCdFacilAllegEventLoc = szCdFacilAllegEventLoc;
    } //-- void setSzCdFacilAllegEventLoc(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilAllegInjSer'.
     * 
     * @param szCdFacilAllegInjSer the value of field
     * 'szCdFacilAllegInjSer'.
     */
    public void setSzCdFacilAllegInjSer(java.lang.String szCdFacilAllegInjSer)
    {
        this._szCdFacilAllegInjSer = szCdFacilAllegInjSer;
    } //-- void setSzCdFacilAllegInjSer(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilAllegNeglType'.
     * 
     * @param szCdFacilAllegNeglType the value of field
     * 'szCdFacilAllegNeglType'.
     */
    public void setSzCdFacilAllegNeglType(java.lang.String szCdFacilAllegNeglType)
    {
        this._szCdFacilAllegNeglType = szCdFacilAllegNeglType;
    } //-- void setSzCdFacilAllegNeglType(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilAllegSrc'.
     * 
     * @param szCdFacilAllegSrc the value of field
     * 'szCdFacilAllegSrc'.
     */
    public void setSzCdFacilAllegSrc(java.lang.String szCdFacilAllegSrc)
    {
        this._szCdFacilAllegSrc = szCdFacilAllegSrc;
    } //-- void setSzCdFacilAllegSrc(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilAllegSrcSupr'.
     * 
     * @param szCdFacilAllegSrcSupr the value of field
     * 'szCdFacilAllegSrcSupr'.
     */
    public void setSzCdFacilAllegSrcSupr(java.lang.String szCdFacilAllegSrcSupr)
    {
        this._szCdFacilAllegSrcSupr = szCdFacilAllegSrcSupr;
    } //-- void setSzCdFacilAllegSrcSupr(java.lang.String) 

    /**
     * Sets the value of field 'szFacilAllegInvClass'.
     * 
     * @param szFacilAllegInvClass the value of field
     * 'szFacilAllegInvClass'.
     */
    public void setSzFacilAllegInvClass(java.lang.String szFacilAllegInvClass)
    {
        this._szFacilAllegInvClass = szFacilAllegInvClass;
    } //-- void setSzFacilAllegInvClass(java.lang.String) 

    /**
     * Sets the value of field 'szNbrFacilAllegMHMR'.
     * 
     * @param szNbrFacilAllegMHMR the value of field
     * 'szNbrFacilAllegMHMR'.
     */
    public void setSzNbrFacilAllegMHMR(java.lang.String szNbrFacilAllegMHMR)
    {
        this._szNbrFacilAllegMHMR = szNbrFacilAllegMHMR;
    } //-- void setSzNbrFacilAllegMHMR(java.lang.String) 

    /**
     * Sets the value of field 'szTxtFacilAllegCmnts'.
     * 
     * @param szTxtFacilAllegCmnts the value of field
     * 'szTxtFacilAllegCmnts'.
     */
    public void setSzTxtFacilAllegCmnts(java.lang.String szTxtFacilAllegCmnts)
    {
        this._szTxtFacilAllegCmnts = szTxtFacilAllegCmnts;
    } //-- void setSzTxtFacilAllegCmnts(java.lang.String) 

    /**
     * Sets the value of field 'tmTmIncmgCall'.
     * 
     * @param tmTmIncmgCall the value of field 'tmTmIncmgCall'.
     */
    public void setTmTmIncmgCall(java.lang.String tmTmIncmgCall)
    {
        this._tmTmIncmgCall = tmTmIncmgCall;
    } //-- void setTmTmIncmgCall(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00 unmarshal(java.io.Reader) 

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
