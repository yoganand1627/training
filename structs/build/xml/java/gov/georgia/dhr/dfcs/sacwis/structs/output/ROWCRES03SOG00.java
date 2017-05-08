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
 * Class ROWCRES03SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES03SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdRsrcAddress
     */
    private int _ulIdRsrcAddress;

    /**
     * keeps track of state for field: _ulIdRsrcAddress
     */
    private boolean _has_ulIdRsrcAddress;

    /**
     * Field _ulIdResource
     */
    private int _ulIdResource;

    /**
     * keeps track of state for field: _ulIdResource
     */
    private boolean _has_ulIdResource;

    /**
     * Field _cScrIndRsrcContracted
     */
    private java.lang.String _cScrIndRsrcContracted;

    /**
     * Field _szCdRsrcAddrType
     */
    private java.lang.String _szCdRsrcAddrType;

    /**
     * Field _szCdRsrcAddrSchDist
     */
    private java.lang.String _szCdRsrcAddrSchDist;

    /**
     * Field _szAddrRsrcAddrStLn1
     */
    private java.lang.String _szAddrRsrcAddrStLn1;

    /**
     * Field _szAddrRsrcAddrStLn2
     */
    private java.lang.String _szAddrRsrcAddrStLn2;

    /**
     * Field _szAddrRsrcAddrAttn
     */
    private java.lang.String _szAddrRsrcAddrAttn;

    /**
     * Field _szAddrRsrcAddrCity
     */
    private java.lang.String _szAddrRsrcAddrCity;

    /**
     * Field _szCdFacilityState
     */
    private java.lang.String _szCdFacilityState;

    /**
     * Field _szAddrRsrcAddrZip
     */
    private java.lang.String _szAddrRsrcAddrZip;

    /**
     * Field _szCdFacilityCounty
     */
    private java.lang.String _szCdFacilityCounty;

    /**
     * Field _szTxtRsrcAddrComments
     */
    private java.lang.String _szTxtRsrcAddrComments;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szNbrRsrcAddrVid
     */
    private java.lang.String _szNbrRsrcAddrVid;

    /**
     * Field _nbrRsrcAddrLong
     */
    private double _nbrRsrcAddrLong;

    /**
     * keeps track of state for field: _nbrRsrcAddrLong
     */
    private boolean _has_nbrRsrcAddrLong;

    /**
     * Field _nbrRsrcAddrLat
     */
    private double _nbrRsrcAddrLat;

    /**
     * keeps track of state for field: _nbrRsrcAddrLat
     */
    private boolean _has_nbrRsrcAddrLat;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES03SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNbrRsrcAddrLat()
    {
        this._has_nbrRsrcAddrLat= false;
    } //-- void deleteNbrRsrcAddrLat() 

    /**
     */
    public void deleteNbrRsrcAddrLong()
    {
        this._has_nbrRsrcAddrLong= false;
    } //-- void deleteNbrRsrcAddrLong() 

    /**
     */
    public void deleteUlIdResource()
    {
        this._has_ulIdResource= false;
    } //-- void deleteUlIdResource() 

    /**
     */
    public void deleteUlIdRsrcAddress()
    {
        this._has_ulIdRsrcAddress= false;
    } //-- void deleteUlIdRsrcAddress() 

    /**
     * Returns the value of field 'cScrIndRsrcContracted'.
     * 
     * @return the value of field 'CScrIndRsrcContracted'.
     */
    public java.lang.String getCScrIndRsrcContracted()
    {
        return this._cScrIndRsrcContracted;
    } //-- java.lang.String getCScrIndRsrcContracted() 

    /**
     * Returns the value of field 'nbrRsrcAddrLat'.
     * 
     * @return the value of field 'NbrRsrcAddrLat'.
     */
    public double getNbrRsrcAddrLat()
    {
        return this._nbrRsrcAddrLat;
    } //-- double getNbrRsrcAddrLat() 

    /**
     * Returns the value of field 'nbrRsrcAddrLong'.
     * 
     * @return the value of field 'NbrRsrcAddrLong'.
     */
    public double getNbrRsrcAddrLong()
    {
        return this._nbrRsrcAddrLong;
    } //-- double getNbrRsrcAddrLong() 

    /**
     * Returns the value of field 'szAddrRsrcAddrAttn'.
     * 
     * @return the value of field 'SzAddrRsrcAddrAttn'.
     */
    public java.lang.String getSzAddrRsrcAddrAttn()
    {
        return this._szAddrRsrcAddrAttn;
    } //-- java.lang.String getSzAddrRsrcAddrAttn() 

    /**
     * Returns the value of field 'szAddrRsrcAddrCity'.
     * 
     * @return the value of field 'SzAddrRsrcAddrCity'.
     */
    public java.lang.String getSzAddrRsrcAddrCity()
    {
        return this._szAddrRsrcAddrCity;
    } //-- java.lang.String getSzAddrRsrcAddrCity() 

    /**
     * Returns the value of field 'szAddrRsrcAddrStLn1'.
     * 
     * @return the value of field 'SzAddrRsrcAddrStLn1'.
     */
    public java.lang.String getSzAddrRsrcAddrStLn1()
    {
        return this._szAddrRsrcAddrStLn1;
    } //-- java.lang.String getSzAddrRsrcAddrStLn1() 

    /**
     * Returns the value of field 'szAddrRsrcAddrStLn2'.
     * 
     * @return the value of field 'SzAddrRsrcAddrStLn2'.
     */
    public java.lang.String getSzAddrRsrcAddrStLn2()
    {
        return this._szAddrRsrcAddrStLn2;
    } //-- java.lang.String getSzAddrRsrcAddrStLn2() 

    /**
     * Returns the value of field 'szAddrRsrcAddrZip'.
     * 
     * @return the value of field 'SzAddrRsrcAddrZip'.
     */
    public java.lang.String getSzAddrRsrcAddrZip()
    {
        return this._szAddrRsrcAddrZip;
    } //-- java.lang.String getSzAddrRsrcAddrZip() 

    /**
     * Returns the value of field 'szCdFacilityCounty'.
     * 
     * @return the value of field 'SzCdFacilityCounty'.
     */
    public java.lang.String getSzCdFacilityCounty()
    {
        return this._szCdFacilityCounty;
    } //-- java.lang.String getSzCdFacilityCounty() 

    /**
     * Returns the value of field 'szCdFacilityState'.
     * 
     * @return the value of field 'SzCdFacilityState'.
     */
    public java.lang.String getSzCdFacilityState()
    {
        return this._szCdFacilityState;
    } //-- java.lang.String getSzCdFacilityState() 

    /**
     * Returns the value of field 'szCdRsrcAddrSchDist'.
     * 
     * @return the value of field 'SzCdRsrcAddrSchDist'.
     */
    public java.lang.String getSzCdRsrcAddrSchDist()
    {
        return this._szCdRsrcAddrSchDist;
    } //-- java.lang.String getSzCdRsrcAddrSchDist() 

    /**
     * Returns the value of field 'szCdRsrcAddrType'.
     * 
     * @return the value of field 'SzCdRsrcAddrType'.
     */
    public java.lang.String getSzCdRsrcAddrType()
    {
        return this._szCdRsrcAddrType;
    } //-- java.lang.String getSzCdRsrcAddrType() 

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
     * Returns the value of field 'szTxtRsrcAddrComments'.
     * 
     * @return the value of field 'SzTxtRsrcAddrComments'.
     */
    public java.lang.String getSzTxtRsrcAddrComments()
    {
        return this._szTxtRsrcAddrComments;
    } //-- java.lang.String getSzTxtRsrcAddrComments() 

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
     * Returns the value of field 'ulIdRsrcAddress'.
     * 
     * @return the value of field 'UlIdRsrcAddress'.
     */
    public int getUlIdRsrcAddress()
    {
        return this._ulIdRsrcAddress;
    } //-- int getUlIdRsrcAddress() 

    /**
     * Method hasNbrRsrcAddrLat
     * 
     * 
     * 
     * @return true if at least one NbrRsrcAddrLat has been added
     */
    public boolean hasNbrRsrcAddrLat()
    {
        return this._has_nbrRsrcAddrLat;
    } //-- boolean hasNbrRsrcAddrLat() 

    /**
     * Method hasNbrRsrcAddrLong
     * 
     * 
     * 
     * @return true if at least one NbrRsrcAddrLong has been added
     */
    public boolean hasNbrRsrcAddrLong()
    {
        return this._has_nbrRsrcAddrLong;
    } //-- boolean hasNbrRsrcAddrLong() 

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
     * Method hasUlIdRsrcAddress
     * 
     * 
     * 
     * @return true if at least one UlIdRsrcAddress has been added
     */
    public boolean hasUlIdRsrcAddress()
    {
        return this._has_ulIdRsrcAddress;
    } //-- boolean hasUlIdRsrcAddress() 

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
     * Sets the value of field 'cScrIndRsrcContracted'.
     * 
     * @param cScrIndRsrcContracted the value of field
     * 'cScrIndRsrcContracted'.
     */
    public void setCScrIndRsrcContracted(java.lang.String cScrIndRsrcContracted)
    {
        this._cScrIndRsrcContracted = cScrIndRsrcContracted;
    } //-- void setCScrIndRsrcContracted(java.lang.String) 

    /**
     * Sets the value of field 'nbrRsrcAddrLat'.
     * 
     * @param nbrRsrcAddrLat the value of field 'nbrRsrcAddrLat'.
     */
    public void setNbrRsrcAddrLat(double nbrRsrcAddrLat)
    {
        this._nbrRsrcAddrLat = nbrRsrcAddrLat;
        this._has_nbrRsrcAddrLat = true;
    } //-- void setNbrRsrcAddrLat(double) 

    /**
     * Sets the value of field 'nbrRsrcAddrLong'.
     * 
     * @param nbrRsrcAddrLong the value of field 'nbrRsrcAddrLong'.
     */
    public void setNbrRsrcAddrLong(double nbrRsrcAddrLong)
    {
        this._nbrRsrcAddrLong = nbrRsrcAddrLong;
        this._has_nbrRsrcAddrLong = true;
    } //-- void setNbrRsrcAddrLong(double) 

    /**
     * Sets the value of field 'szAddrRsrcAddrAttn'.
     * 
     * @param szAddrRsrcAddrAttn the value of field
     * 'szAddrRsrcAddrAttn'.
     */
    public void setSzAddrRsrcAddrAttn(java.lang.String szAddrRsrcAddrAttn)
    {
        this._szAddrRsrcAddrAttn = szAddrRsrcAddrAttn;
    } //-- void setSzAddrRsrcAddrAttn(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRsrcAddrCity'.
     * 
     * @param szAddrRsrcAddrCity the value of field
     * 'szAddrRsrcAddrCity'.
     */
    public void setSzAddrRsrcAddrCity(java.lang.String szAddrRsrcAddrCity)
    {
        this._szAddrRsrcAddrCity = szAddrRsrcAddrCity;
    } //-- void setSzAddrRsrcAddrCity(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRsrcAddrStLn1'.
     * 
     * @param szAddrRsrcAddrStLn1 the value of field
     * 'szAddrRsrcAddrStLn1'.
     */
    public void setSzAddrRsrcAddrStLn1(java.lang.String szAddrRsrcAddrStLn1)
    {
        this._szAddrRsrcAddrStLn1 = szAddrRsrcAddrStLn1;
    } //-- void setSzAddrRsrcAddrStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRsrcAddrStLn2'.
     * 
     * @param szAddrRsrcAddrStLn2 the value of field
     * 'szAddrRsrcAddrStLn2'.
     */
    public void setSzAddrRsrcAddrStLn2(java.lang.String szAddrRsrcAddrStLn2)
    {
        this._szAddrRsrcAddrStLn2 = szAddrRsrcAddrStLn2;
    } //-- void setSzAddrRsrcAddrStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szAddrRsrcAddrZip'.
     * 
     * @param szAddrRsrcAddrZip the value of field
     * 'szAddrRsrcAddrZip'.
     */
    public void setSzAddrRsrcAddrZip(java.lang.String szAddrRsrcAddrZip)
    {
        this._szAddrRsrcAddrZip = szAddrRsrcAddrZip;
    } //-- void setSzAddrRsrcAddrZip(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilityCounty'.
     * 
     * @param szCdFacilityCounty the value of field
     * 'szCdFacilityCounty'.
     */
    public void setSzCdFacilityCounty(java.lang.String szCdFacilityCounty)
    {
        this._szCdFacilityCounty = szCdFacilityCounty;
    } //-- void setSzCdFacilityCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdFacilityState'.
     * 
     * @param szCdFacilityState the value of field
     * 'szCdFacilityState'.
     */
    public void setSzCdFacilityState(java.lang.String szCdFacilityState)
    {
        this._szCdFacilityState = szCdFacilityState;
    } //-- void setSzCdFacilityState(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcAddrSchDist'.
     * 
     * @param szCdRsrcAddrSchDist the value of field
     * 'szCdRsrcAddrSchDist'.
     */
    public void setSzCdRsrcAddrSchDist(java.lang.String szCdRsrcAddrSchDist)
    {
        this._szCdRsrcAddrSchDist = szCdRsrcAddrSchDist;
    } //-- void setSzCdRsrcAddrSchDist(java.lang.String) 

    /**
     * Sets the value of field 'szCdRsrcAddrType'.
     * 
     * @param szCdRsrcAddrType the value of field 'szCdRsrcAddrType'
     */
    public void setSzCdRsrcAddrType(java.lang.String szCdRsrcAddrType)
    {
        this._szCdRsrcAddrType = szCdRsrcAddrType;
    } //-- void setSzCdRsrcAddrType(java.lang.String) 

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
     * Sets the value of field 'szTxtRsrcAddrComments'.
     * 
     * @param szTxtRsrcAddrComments the value of field
     * 'szTxtRsrcAddrComments'.
     */
    public void setSzTxtRsrcAddrComments(java.lang.String szTxtRsrcAddrComments)
    {
        this._szTxtRsrcAddrComments = szTxtRsrcAddrComments;
    } //-- void setSzTxtRsrcAddrComments(java.lang.String) 

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
     * Sets the value of field 'ulIdRsrcAddress'.
     * 
     * @param ulIdRsrcAddress the value of field 'ulIdRsrcAddress'.
     */
    public void setUlIdRsrcAddress(int ulIdRsrcAddress)
    {
        this._ulIdRsrcAddress = ulIdRsrcAddress;
        this._has_ulIdRsrcAddress = true;
    } //-- void setUlIdRsrcAddress(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00 unmarshal(java.io.Reader) 

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
