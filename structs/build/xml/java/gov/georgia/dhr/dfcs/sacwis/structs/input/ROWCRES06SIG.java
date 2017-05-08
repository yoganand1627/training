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
 * Class ROWCRES06SIG.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES06SIG extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdResourceService
     */
    private int _ulIdResourceService;

    /**
     * keeps track of state for field: _ulIdResourceService
     */
    private boolean _has_ulIdResourceService;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szCdScrDataAction
     */
    private java.lang.String _szCdScrDataAction;

    /**
     * Field _cIndRsrcSvcShowRow
     */
    private java.lang.String _cIndRsrcSvcShowRow;

    /**
     * Field _ulNbrCntrctNumber
     */
    private int _ulNbrCntrctNumber;

    /**
     * keeps track of state for field: _ulNbrCntrctNumber
     */
    private boolean _has_ulNbrCntrctNumber;

    /**
     * Field _szScrRsrcSvcCntyCode
     */
    private java.lang.String _szScrRsrcSvcCntyCode;

    /**
     * Field _szCdRsrcSvcProgram
     */
    private java.lang.String _szCdRsrcSvcProgram;

    /**
     * Field _szCdRsrcSvcRegion
     */
    private java.lang.String _szCdRsrcSvcRegion;

    /**
     * Field _szCdRsrcSvcCategRsrc
     */
    private java.lang.String _szCdRsrcSvcCategRsrc;

    /**
     * Field _szCdRsrcSvcService
     */
    private java.lang.String _szCdRsrcSvcService;

    /**
     * Field _szCdRsrcSvcState
     */
    private java.lang.String _szCdRsrcSvcState;

    /**
     * Field _cIndRsrcSvcIncomeBsed
     */
    private java.lang.String _cIndRsrcSvcIncomeBsed;

    /**
     * Field _bIndRsrcSvcCntyPartial
     */
    private java.lang.String _bIndRsrcSvcCntyPartial;

    /**
     * Field _szCdRsrcSvcServiceType
     */
    private java.lang.String _szCdRsrcSvcServiceType;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES06SIG() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdResourceService()
    {
        this._has_ulIdResourceService= false;
    } //-- void deleteUlIdResourceService() 

    /**
     */
    public void deleteUlNbrCntrctNumber()
    {
        this._has_ulNbrCntrctNumber= false;
    } //-- void deleteUlNbrCntrctNumber() 

    /**
     * Returns the value of field 'bIndRsrcSvcCntyPartial'.
     * 
     * @return the value of field 'BIndRsrcSvcCntyPartial'.
     */
    public java.lang.String getBIndRsrcSvcCntyPartial()
    {
        return this._bIndRsrcSvcCntyPartial;
    } //-- java.lang.String getBIndRsrcSvcCntyPartial() 

    /**
     * Returns the value of field 'cIndRsrcSvcIncomeBsed'.
     * 
     * @return the value of field 'CIndRsrcSvcIncomeBsed'.
     */
    public java.lang.String getCIndRsrcSvcIncomeBsed()
    {
        return this._cIndRsrcSvcIncomeBsed;
    } //-- java.lang.String getCIndRsrcSvcIncomeBsed() 

    /**
     * Returns the value of field 'cIndRsrcSvcShowRow'.
     * 
     * @return the value of field 'CIndRsrcSvcShowRow'.
     */
    public java.lang.String getCIndRsrcSvcShowRow()
    {
        return this._cIndRsrcSvcShowRow;
    } //-- java.lang.String getCIndRsrcSvcShowRow() 

    /**
     * Returns the value of field 'szCdRsrcSvcCategRsrc'.
     * 
     * @return the value of field 'SzCdRsrcSvcCategRsrc'.
     */
    public java.lang.String getSzCdRsrcSvcCategRsrc()
    {
        return this._szCdRsrcSvcCategRsrc;
    } //-- java.lang.String getSzCdRsrcSvcCategRsrc() 

    /**
     * Returns the value of field 'szCdRsrcSvcProgram'.
     * 
     * @return the value of field 'SzCdRsrcSvcProgram'.
     */
    public java.lang.String getSzCdRsrcSvcProgram()
    {
        return this._szCdRsrcSvcProgram;
    } //-- java.lang.String getSzCdRsrcSvcProgram() 

    /**
     * Returns the value of field 'szCdRsrcSvcRegion'.
     * 
     * @return the value of field 'SzCdRsrcSvcRegion'.
     */
    public java.lang.String getSzCdRsrcSvcRegion()
    {
        return this._szCdRsrcSvcRegion;
    } //-- java.lang.String getSzCdRsrcSvcRegion() 

    /**
     * Returns the value of field 'szCdRsrcSvcService'.
     * 
     * @return the value of field 'SzCdRsrcSvcService'.
     */
    public java.lang.String getSzCdRsrcSvcService()
    {
        return this._szCdRsrcSvcService;
    } //-- java.lang.String getSzCdRsrcSvcService() 

    /**
     * Returns the value of field 'szCdRsrcSvcServiceType'.
     * 
     * @return the value of field 'SzCdRsrcSvcServiceType'.
     */
    public java.lang.String getSzCdRsrcSvcServiceType()
    {
        return this._szCdRsrcSvcServiceType;
    } //-- java.lang.String getSzCdRsrcSvcServiceType() 

    /**
     * Returns the value of field 'szCdRsrcSvcState'.
     * 
     * @return the value of field 'SzCdRsrcSvcState'.
     */
    public java.lang.String getSzCdRsrcSvcState()
    {
        return this._szCdRsrcSvcState;
    } //-- java.lang.String getSzCdRsrcSvcState() 

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
     * Returns the value of field 'szScrRsrcSvcCntyCode'.
     * 
     * @return the value of field 'SzScrRsrcSvcCntyCode'.
     */
    public java.lang.String getSzScrRsrcSvcCntyCode()
    {
        return this._szScrRsrcSvcCntyCode;
    } //-- java.lang.String getSzScrRsrcSvcCntyCode() 

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
     * Returns the value of field 'ulIdResource'.
     * 
     * @return the value of field 'UlIdResource'.
     */
    public int getUlIdResource()
    {
        return this._ulIdResource;
    } //-- int getUlIdResource() 

    /**
     * Returns the value of field 'ulIdResourceService'.
     * 
     * @return the value of field 'UlIdResourceService'.
     */
    public int getUlIdResourceService()
    {
        return this._ulIdResourceService;
    } //-- int getUlIdResourceService() 

    /**
     * Returns the value of field 'ulNbrCntrctNumber'.
     * 
     * @return the value of field 'UlNbrCntrctNumber'.
     */
    public int getUlNbrCntrctNumber()
    {
        return this._ulNbrCntrctNumber;
    } //-- int getUlNbrCntrctNumber() 

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
     * Method hasUlIdResourceService
     * 
     * 
     * 
     * @return true if at least one UlIdResourceService has been
     * added
     */
    public boolean hasUlIdResourceService()
    {
        return this._has_ulIdResourceService;
    } //-- boolean hasUlIdResourceService() 

    /**
     * Method hasUlNbrCntrctNumber
     * 
     * 
     * 
     * @return true if at least one UlNbrCntrctNumber has been added
     */
    public boolean hasUlNbrCntrctNumber()
    {
        return this._has_ulNbrCntrctNumber;
    } //-- boolean hasUlNbrCntrctNumber() 

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
     * Sets the value of field 'bIndRsrcSvcCntyPartial'.
     * 
     * @param bIndRsrcSvcCntyPartial the value of field
     * 'bIndRsrcSvcCntyPartial'.
     */
    public void setBIndRsrcSvcCntyPartial(java.lang.String bIndRsrcSvcCntyPartial)
    {
        this._bIndRsrcSvcCntyPartial = bIndRsrcSvcCntyPartial;
    } //-- void setBIndRsrcSvcCntyPartial(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcSvcIncomeBsed'.
     * 
     * @param cIndRsrcSvcIncomeBsed the value of field
     * 'cIndRsrcSvcIncomeBsed'.
     */
    public void setCIndRsrcSvcIncomeBsed(java.lang.String cIndRsrcSvcIncomeBsed)
    {
        this._cIndRsrcSvcIncomeBsed = cIndRsrcSvcIncomeBsed;
    } //-- void setCIndRsrcSvcIncomeBsed(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcSvcShowRow'.
     * 
     * @param cIndRsrcSvcShowRow the value of field
     * 'cIndRsrcSvcShowRow'.
     */
    public void setCIndRsrcSvcShowRow(java.lang.String cIndRsrcSvcShowRow)
    {
        this._cIndRsrcSvcShowRow = cIndRsrcSvcShowRow;
    } //-- void setCIndRsrcSvcShowRow(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSvcCategRsrc'.
     * 
     * @param szCdRsrcSvcCategRsrc the value of field
     * 'szCdRsrcSvcCategRsrc'.
     */
    public void setSzCdRsrcSvcCategRsrc(java.lang.String szCdRsrcSvcCategRsrc)
    {
        this._szCdRsrcSvcCategRsrc = szCdRsrcSvcCategRsrc;
    } //-- void setSzCdRsrcSvcCategRsrc(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSvcProgram'.
     * 
     * @param szCdRsrcSvcProgram the value of field
     * 'szCdRsrcSvcProgram'.
     */
    public void setSzCdRsrcSvcProgram(java.lang.String szCdRsrcSvcProgram)
    {
        this._szCdRsrcSvcProgram = szCdRsrcSvcProgram;
    } //-- void setSzCdRsrcSvcProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSvcRegion'.
     * 
     * @param szCdRsrcSvcRegion the value of field
     * 'szCdRsrcSvcRegion'.
     */
    public void setSzCdRsrcSvcRegion(java.lang.String szCdRsrcSvcRegion)
    {
        this._szCdRsrcSvcRegion = szCdRsrcSvcRegion;
    } //-- void setSzCdRsrcSvcRegion(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSvcService'.
     * 
     * @param szCdRsrcSvcService the value of field
     * 'szCdRsrcSvcService'.
     */
    public void setSzCdRsrcSvcService(java.lang.String szCdRsrcSvcService)
    {
        this._szCdRsrcSvcService = szCdRsrcSvcService;
    } //-- void setSzCdRsrcSvcService(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSvcServiceType'.
     * 
     * @param szCdRsrcSvcServiceType the value of field
     * 'szCdRsrcSvcServiceType'.
     */
    public void setSzCdRsrcSvcServiceType(java.lang.String szCdRsrcSvcServiceType)
    {
        this._szCdRsrcSvcServiceType = szCdRsrcSvcServiceType;
    } //-- void setSzCdRsrcSvcServiceType(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcSvcState'.
     * 
     * @param szCdRsrcSvcState the value of field 'szCdRsrcSvcState'
     */
    public void setSzCdRsrcSvcState(java.lang.String szCdRsrcSvcState)
    {
        this._szCdRsrcSvcState = szCdRsrcSvcState;
    } //-- void setSzCdRsrcSvcState(java.lang.String) 

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
     * Sets the value of field 'szScrRsrcSvcCntyCode'.
     * 
     * @param szScrRsrcSvcCntyCode the value of field
     * 'szScrRsrcSvcCntyCode'.
     */
    public void setSzScrRsrcSvcCntyCode(java.lang.String szScrRsrcSvcCntyCode)
    {
        this._szScrRsrcSvcCntyCode = szScrRsrcSvcCntyCode;
    } //-- void setSzScrRsrcSvcCntyCode(java.lang.String) 

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
     * Sets the value of field 'ulIdResourceService'.
     * 
     * @param ulIdResourceService the value of field
     * 'ulIdResourceService'.
     */
    public void setUlIdResourceService(int ulIdResourceService)
    {
        this._ulIdResourceService = ulIdResourceService;
        this._has_ulIdResourceService = true;
    } //-- void setUlIdResourceService(int) 

    /**
     * Sets the value of field 'ulNbrCntrctNumber'.
     * 
     * @param ulNbrCntrctNumber the value of field
     * 'ulNbrCntrctNumber'.
     */
    public void setUlNbrCntrctNumber(int ulNbrCntrctNumber)
    {
        this._ulNbrCntrctNumber = ulNbrCntrctNumber;
        this._has_ulNbrCntrctNumber = true;
    } //-- void setUlNbrCntrctNumber(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG unmarshal(java.io.Reader) 

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
