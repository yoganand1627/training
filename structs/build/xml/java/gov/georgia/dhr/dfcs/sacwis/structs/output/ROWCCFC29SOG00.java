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
 * Class ROWCCFC29SOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCFC29SOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _lAmtIncRsrc
     */
    private double _lAmtIncRsrc;

    /**
     * keeps track of state for field: _lAmtIncRsrc
     */
    private boolean _has_lAmtIncRsrc;

    /**
     * Field _szCdIncRsrcIncome
     */
    private java.lang.String _szCdIncRsrcIncome;

    /**
     * Field _szCdIncRsrcType
     */
    private java.lang.String _szCdIncRsrcType;

    /**
     * Field _dtDtIncRsrcFrom
     */
    private org.exolab.castor.types.Date _dtDtIncRsrcFrom;

    /**
     * Field _dtDtIncRsrcTo
     */
    private org.exolab.castor.types.Date _dtDtIncRsrcTo;

    /**
     * Field _ulIdIncRsrc
     */
    private int _ulIdIncRsrc;

    /**
     * keeps track of state for field: _ulIdIncRsrc
     */
    private boolean _has_ulIdIncRsrc;

    /**
     * Field _ulIdIncRsrcWorker
     */
    private int _ulIdIncRsrcWorker;

    /**
     * keeps track of state for field: _ulIdIncRsrcWorker
     */
    private boolean _has_ulIdIncRsrcWorker;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _cIndIncRsrcNotAccess
     */
    private java.lang.String _cIndIncRsrcNotAccess;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _dtScrDtLastUpdate
     */
    private org.exolab.castor.types.Date _dtScrDtLastUpdate;

    /**
     * Field _szSdsIncRrcsSource
     */
    private java.lang.String _szSdsIncRrcsSource;

    /**
     * Field _szSdsIncRsrcVerfMethod
     */
    private java.lang.String _szSdsIncRsrcVerfMethod;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _szTxtIncRsrcDesc
     */
    private java.lang.String _szTxtIncRsrcDesc;

    /**
     * Field _szCdIncRsrcFreqType
     */
    private java.lang.String _szCdIncRsrcFreqType;

    /**
     * Field _szTxtIncRsrcSrcPhoneNum
     */
    private java.lang.String _szTxtIncRsrcSrcPhoneNum;

    /**
     * Field _szTxtIncRsrcSrcPhoneExt
     */
    private java.lang.String _szTxtIncRsrcSrcPhoneExt;

    /**
     * Field _szTxtIncRsrcSrcAddrStLn1
     */
    private java.lang.String _szTxtIncRsrcSrcAddrStLn1;

    /**
     * Field _szTxtIncRsrcSrcAddrStLn2
     */
    private java.lang.String _szTxtIncRsrcSrcAddrStLn2;

    /**
     * Field _szTxtIncRsrcSrcAddrCity
     */
    private java.lang.String _szTxtIncRsrcSrcAddrCity;

    /**
     * Field _szTxtIncRsrcSrcAddrState
     */
    private java.lang.String _szTxtIncRsrcSrcAddrState;

    /**
     * Field _szTxtIncRsrcSrcAddrZip
     */
    private java.lang.String _szTxtIncRsrcSrcAddrZip;

    /**
     * Field _szCdIncRsrcSrcAddrCounty
     */
    private java.lang.String _szCdIncRsrcSrcAddrCounty;

    /**
     * Field _szTxtIncRsrcSrcAddrCmnts
     */
    private java.lang.String _szTxtIncRsrcSrcAddrCmnts;

    /**
     * Field _dtDtIncRsrcModified
     */
    private org.exolab.castor.types.Date _dtDtIncRsrcModified;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCFC29SOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLAmtIncRsrc()
    {
        this._has_lAmtIncRsrc= false;
    } //-- void deleteLAmtIncRsrc() 

    /**
     */
    public void deleteUlIdIncRsrc()
    {
        this._has_ulIdIncRsrc= false;
    } //-- void deleteUlIdIncRsrc() 

    /**
     */
    public void deleteUlIdIncRsrcWorker()
    {
        this._has_ulIdIncRsrcWorker= false;
    } //-- void deleteUlIdIncRsrcWorker() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     * Returns the value of field 'cIndIncRsrcNotAccess'.
     * 
     * @return the value of field 'CIndIncRsrcNotAccess'.
     */
    public java.lang.String getCIndIncRsrcNotAccess()
    {
        return this._cIndIncRsrcNotAccess;
    } //-- java.lang.String getCIndIncRsrcNotAccess() 

    /**
     * Returns the value of field 'dtDtIncRsrcFrom'.
     * 
     * @return the value of field 'DtDtIncRsrcFrom'.
     */
    public org.exolab.castor.types.Date getDtDtIncRsrcFrom()
    {
        return this._dtDtIncRsrcFrom;
    } //-- org.exolab.castor.types.Date getDtDtIncRsrcFrom() 

    /**
     * Returns the value of field 'dtDtIncRsrcModified'.
     * 
     * @return the value of field 'DtDtIncRsrcModified'.
     */
    public org.exolab.castor.types.Date getDtDtIncRsrcModified()
    {
        return this._dtDtIncRsrcModified;
    } //-- org.exolab.castor.types.Date getDtDtIncRsrcModified() 

    /**
     * Returns the value of field 'dtDtIncRsrcTo'.
     * 
     * @return the value of field 'DtDtIncRsrcTo'.
     */
    public org.exolab.castor.types.Date getDtDtIncRsrcTo()
    {
        return this._dtDtIncRsrcTo;
    } //-- org.exolab.castor.types.Date getDtDtIncRsrcTo() 

    /**
     * Returns the value of field 'dtScrDtLastUpdate'.
     * 
     * @return the value of field 'DtScrDtLastUpdate'.
     */
    public org.exolab.castor.types.Date getDtScrDtLastUpdate()
    {
        return this._dtScrDtLastUpdate;
    } //-- org.exolab.castor.types.Date getDtScrDtLastUpdate() 

    /**
     * Returns the value of field 'lAmtIncRsrc'.
     * 
     * @return the value of field 'LAmtIncRsrc'.
     */
    public double getLAmtIncRsrc()
    {
        return this._lAmtIncRsrc;
    } //-- double getLAmtIncRsrc() 

    /**
     * Returns the value of field 'szCdIncRsrcFreqType'.
     * 
     * @return the value of field 'SzCdIncRsrcFreqType'.
     */
    public java.lang.String getSzCdIncRsrcFreqType()
    {
        return this._szCdIncRsrcFreqType;
    } //-- java.lang.String getSzCdIncRsrcFreqType() 

    /**
     * Returns the value of field 'szCdIncRsrcIncome'.
     * 
     * @return the value of field 'SzCdIncRsrcIncome'.
     */
    public java.lang.String getSzCdIncRsrcIncome()
    {
        return this._szCdIncRsrcIncome;
    } //-- java.lang.String getSzCdIncRsrcIncome() 

    /**
     * Returns the value of field 'szCdIncRsrcSrcAddrCounty'.
     * 
     * @return the value of field 'SzCdIncRsrcSrcAddrCounty'.
     */
    public java.lang.String getSzCdIncRsrcSrcAddrCounty()
    {
        return this._szCdIncRsrcSrcAddrCounty;
    } //-- java.lang.String getSzCdIncRsrcSrcAddrCounty() 

    /**
     * Returns the value of field 'szCdIncRsrcType'.
     * 
     * @return the value of field 'SzCdIncRsrcType'.
     */
    public java.lang.String getSzCdIncRsrcType()
    {
        return this._szCdIncRsrcType;
    } //-- java.lang.String getSzCdIncRsrcType() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szSdsIncRrcsSource'.
     * 
     * @return the value of field 'SzSdsIncRrcsSource'.
     */
    public java.lang.String getSzSdsIncRrcsSource()
    {
        return this._szSdsIncRrcsSource;
    } //-- java.lang.String getSzSdsIncRrcsSource() 

    /**
     * Returns the value of field 'szSdsIncRsrcVerfMethod'.
     * 
     * @return the value of field 'SzSdsIncRsrcVerfMethod'.
     */
    public java.lang.String getSzSdsIncRsrcVerfMethod()
    {
        return this._szSdsIncRsrcVerfMethod;
    } //-- java.lang.String getSzSdsIncRsrcVerfMethod() 

    /**
     * Returns the value of field 'szTxtIncRsrcDesc'.
     * 
     * @return the value of field 'SzTxtIncRsrcDesc'.
     */
    public java.lang.String getSzTxtIncRsrcDesc()
    {
        return this._szTxtIncRsrcDesc;
    } //-- java.lang.String getSzTxtIncRsrcDesc() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcAddrCity'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcAddrCity'.
     */
    public java.lang.String getSzTxtIncRsrcSrcAddrCity()
    {
        return this._szTxtIncRsrcSrcAddrCity;
    } //-- java.lang.String getSzTxtIncRsrcSrcAddrCity() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcAddrCmnts'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcAddrCmnts'.
     */
    public java.lang.String getSzTxtIncRsrcSrcAddrCmnts()
    {
        return this._szTxtIncRsrcSrcAddrCmnts;
    } //-- java.lang.String getSzTxtIncRsrcSrcAddrCmnts() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcAddrStLn1'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcAddrStLn1'.
     */
    public java.lang.String getSzTxtIncRsrcSrcAddrStLn1()
    {
        return this._szTxtIncRsrcSrcAddrStLn1;
    } //-- java.lang.String getSzTxtIncRsrcSrcAddrStLn1() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcAddrStLn2'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcAddrStLn2'.
     */
    public java.lang.String getSzTxtIncRsrcSrcAddrStLn2()
    {
        return this._szTxtIncRsrcSrcAddrStLn2;
    } //-- java.lang.String getSzTxtIncRsrcSrcAddrStLn2() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcAddrState'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcAddrState'.
     */
    public java.lang.String getSzTxtIncRsrcSrcAddrState()
    {
        return this._szTxtIncRsrcSrcAddrState;
    } //-- java.lang.String getSzTxtIncRsrcSrcAddrState() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcAddrZip'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcAddrZip'.
     */
    public java.lang.String getSzTxtIncRsrcSrcAddrZip()
    {
        return this._szTxtIncRsrcSrcAddrZip;
    } //-- java.lang.String getSzTxtIncRsrcSrcAddrZip() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcPhoneExt'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcPhoneExt'.
     */
    public java.lang.String getSzTxtIncRsrcSrcPhoneExt()
    {
        return this._szTxtIncRsrcSrcPhoneExt;
    } //-- java.lang.String getSzTxtIncRsrcSrcPhoneExt() 

    /**
     * Returns the value of field 'szTxtIncRsrcSrcPhoneNum'.
     * 
     * @return the value of field 'SzTxtIncRsrcSrcPhoneNum'.
     */
    public java.lang.String getSzTxtIncRsrcSrcPhoneNum()
    {
        return this._szTxtIncRsrcSrcPhoneNum;
    } //-- java.lang.String getSzTxtIncRsrcSrcPhoneNum() 

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
     * Returns the value of field 'ulIdIncRsrc'.
     * 
     * @return the value of field 'UlIdIncRsrc'.
     */
    public int getUlIdIncRsrc()
    {
        return this._ulIdIncRsrc;
    } //-- int getUlIdIncRsrc() 

    /**
     * Returns the value of field 'ulIdIncRsrcWorker'.
     * 
     * @return the value of field 'UlIdIncRsrcWorker'.
     */
    public int getUlIdIncRsrcWorker()
    {
        return this._ulIdIncRsrcWorker;
    } //-- int getUlIdIncRsrcWorker() 

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
     * Method hasLAmtIncRsrc
     * 
     * 
     * 
     * @return true if at least one LAmtIncRsrc has been added
     */
    public boolean hasLAmtIncRsrc()
    {
        return this._has_lAmtIncRsrc;
    } //-- boolean hasLAmtIncRsrc() 

    /**
     * Method hasUlIdIncRsrc
     * 
     * 
     * 
     * @return true if at least one UlIdIncRsrc has been added
     */
    public boolean hasUlIdIncRsrc()
    {
        return this._has_ulIdIncRsrc;
    } //-- boolean hasUlIdIncRsrc() 

    /**
     * Method hasUlIdIncRsrcWorker
     * 
     * 
     * 
     * @return true if at least one UlIdIncRsrcWorker has been added
     */
    public boolean hasUlIdIncRsrcWorker()
    {
        return this._has_ulIdIncRsrcWorker;
    } //-- boolean hasUlIdIncRsrcWorker() 

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
     * Sets the value of field 'cIndIncRsrcNotAccess'.
     * 
     * @param cIndIncRsrcNotAccess the value of field
     * 'cIndIncRsrcNotAccess'.
     */
    public void setCIndIncRsrcNotAccess(java.lang.String cIndIncRsrcNotAccess)
    {
        this._cIndIncRsrcNotAccess = cIndIncRsrcNotAccess;
    } //-- void setCIndIncRsrcNotAccess(java.lang.String) 

    /**
     * Sets the value of field 'dtDtIncRsrcFrom'.
     * 
     * @param dtDtIncRsrcFrom the value of field 'dtDtIncRsrcFrom'.
     */
    public void setDtDtIncRsrcFrom(org.exolab.castor.types.Date dtDtIncRsrcFrom)
    {
        this._dtDtIncRsrcFrom = dtDtIncRsrcFrom;
    } //-- void setDtDtIncRsrcFrom(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtIncRsrcModified'.
     * 
     * @param dtDtIncRsrcModified the value of field
     * 'dtDtIncRsrcModified'.
     */
    public void setDtDtIncRsrcModified(org.exolab.castor.types.Date dtDtIncRsrcModified)
    {
        this._dtDtIncRsrcModified = dtDtIncRsrcModified;
    } //-- void setDtDtIncRsrcModified(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtIncRsrcTo'.
     * 
     * @param dtDtIncRsrcTo the value of field 'dtDtIncRsrcTo'.
     */
    public void setDtDtIncRsrcTo(org.exolab.castor.types.Date dtDtIncRsrcTo)
    {
        this._dtDtIncRsrcTo = dtDtIncRsrcTo;
    } //-- void setDtDtIncRsrcTo(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtScrDtLastUpdate'.
     * 
     * @param dtScrDtLastUpdate the value of field
     * 'dtScrDtLastUpdate'.
     */
    public void setDtScrDtLastUpdate(org.exolab.castor.types.Date dtScrDtLastUpdate)
    {
        this._dtScrDtLastUpdate = dtScrDtLastUpdate;
    } //-- void setDtScrDtLastUpdate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'lAmtIncRsrc'.
     * 
     * @param lAmtIncRsrc the value of field 'lAmtIncRsrc'.
     */
    public void setLAmtIncRsrc(double lAmtIncRsrc)
    {
        this._lAmtIncRsrc = lAmtIncRsrc;
        this._has_lAmtIncRsrc = true;
    } //-- void setLAmtIncRsrc(double) 

    /**
     * Sets the value of field 'szCdIncRsrcFreqType'.
     * 
     * @param szCdIncRsrcFreqType the value of field
     * 'szCdIncRsrcFreqType'.
     */
    public void setSzCdIncRsrcFreqType(java.lang.String szCdIncRsrcFreqType)
    {
        this._szCdIncRsrcFreqType = szCdIncRsrcFreqType;
    } //-- void setSzCdIncRsrcFreqType(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncRsrcIncome'.
     * 
     * @param szCdIncRsrcIncome the value of field
     * 'szCdIncRsrcIncome'.
     */
    public void setSzCdIncRsrcIncome(java.lang.String szCdIncRsrcIncome)
    {
        this._szCdIncRsrcIncome = szCdIncRsrcIncome;
    } //-- void setSzCdIncRsrcIncome(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncRsrcSrcAddrCounty'.
     * 
     * @param szCdIncRsrcSrcAddrCounty the value of field
     * 'szCdIncRsrcSrcAddrCounty'.
     */
    public void setSzCdIncRsrcSrcAddrCounty(java.lang.String szCdIncRsrcSrcAddrCounty)
    {
        this._szCdIncRsrcSrcAddrCounty = szCdIncRsrcSrcAddrCounty;
    } //-- void setSzCdIncRsrcSrcAddrCounty(java.lang.String) 

    /**
     * Sets the value of field 'szCdIncRsrcType'.
     * 
     * @param szCdIncRsrcType the value of field 'szCdIncRsrcType'.
     */
    public void setSzCdIncRsrcType(java.lang.String szCdIncRsrcType)
    {
        this._szCdIncRsrcType = szCdIncRsrcType;
    } //-- void setSzCdIncRsrcType(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szSdsIncRrcsSource'.
     * 
     * @param szSdsIncRrcsSource the value of field
     * 'szSdsIncRrcsSource'.
     */
    public void setSzSdsIncRrcsSource(java.lang.String szSdsIncRrcsSource)
    {
        this._szSdsIncRrcsSource = szSdsIncRrcsSource;
    } //-- void setSzSdsIncRrcsSource(java.lang.String) 

    /**
     * Sets the value of field 'szSdsIncRsrcVerfMethod'.
     * 
     * @param szSdsIncRsrcVerfMethod the value of field
     * 'szSdsIncRsrcVerfMethod'.
     */
    public void setSzSdsIncRsrcVerfMethod(java.lang.String szSdsIncRsrcVerfMethod)
    {
        this._szSdsIncRsrcVerfMethod = szSdsIncRsrcVerfMethod;
    } //-- void setSzSdsIncRsrcVerfMethod(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcDesc'.
     * 
     * @param szTxtIncRsrcDesc the value of field 'szTxtIncRsrcDesc'
     */
    public void setSzTxtIncRsrcDesc(java.lang.String szTxtIncRsrcDesc)
    {
        this._szTxtIncRsrcDesc = szTxtIncRsrcDesc;
    } //-- void setSzTxtIncRsrcDesc(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcAddrCity'.
     * 
     * @param szTxtIncRsrcSrcAddrCity the value of field
     * 'szTxtIncRsrcSrcAddrCity'.
     */
    public void setSzTxtIncRsrcSrcAddrCity(java.lang.String szTxtIncRsrcSrcAddrCity)
    {
        this._szTxtIncRsrcSrcAddrCity = szTxtIncRsrcSrcAddrCity;
    } //-- void setSzTxtIncRsrcSrcAddrCity(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcAddrCmnts'.
     * 
     * @param szTxtIncRsrcSrcAddrCmnts the value of field
     * 'szTxtIncRsrcSrcAddrCmnts'.
     */
    public void setSzTxtIncRsrcSrcAddrCmnts(java.lang.String szTxtIncRsrcSrcAddrCmnts)
    {
        this._szTxtIncRsrcSrcAddrCmnts = szTxtIncRsrcSrcAddrCmnts;
    } //-- void setSzTxtIncRsrcSrcAddrCmnts(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcAddrStLn1'.
     * 
     * @param szTxtIncRsrcSrcAddrStLn1 the value of field
     * 'szTxtIncRsrcSrcAddrStLn1'.
     */
    public void setSzTxtIncRsrcSrcAddrStLn1(java.lang.String szTxtIncRsrcSrcAddrStLn1)
    {
        this._szTxtIncRsrcSrcAddrStLn1 = szTxtIncRsrcSrcAddrStLn1;
    } //-- void setSzTxtIncRsrcSrcAddrStLn1(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcAddrStLn2'.
     * 
     * @param szTxtIncRsrcSrcAddrStLn2 the value of field
     * 'szTxtIncRsrcSrcAddrStLn2'.
     */
    public void setSzTxtIncRsrcSrcAddrStLn2(java.lang.String szTxtIncRsrcSrcAddrStLn2)
    {
        this._szTxtIncRsrcSrcAddrStLn2 = szTxtIncRsrcSrcAddrStLn2;
    } //-- void setSzTxtIncRsrcSrcAddrStLn2(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcAddrState'.
     * 
     * @param szTxtIncRsrcSrcAddrState the value of field
     * 'szTxtIncRsrcSrcAddrState'.
     */
    public void setSzTxtIncRsrcSrcAddrState(java.lang.String szTxtIncRsrcSrcAddrState)
    {
        this._szTxtIncRsrcSrcAddrState = szTxtIncRsrcSrcAddrState;
    } //-- void setSzTxtIncRsrcSrcAddrState(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcAddrZip'.
     * 
     * @param szTxtIncRsrcSrcAddrZip the value of field
     * 'szTxtIncRsrcSrcAddrZip'.
     */
    public void setSzTxtIncRsrcSrcAddrZip(java.lang.String szTxtIncRsrcSrcAddrZip)
    {
        this._szTxtIncRsrcSrcAddrZip = szTxtIncRsrcSrcAddrZip;
    } //-- void setSzTxtIncRsrcSrcAddrZip(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcPhoneExt'.
     * 
     * @param szTxtIncRsrcSrcPhoneExt the value of field
     * 'szTxtIncRsrcSrcPhoneExt'.
     */
    public void setSzTxtIncRsrcSrcPhoneExt(java.lang.String szTxtIncRsrcSrcPhoneExt)
    {
        this._szTxtIncRsrcSrcPhoneExt = szTxtIncRsrcSrcPhoneExt;
    } //-- void setSzTxtIncRsrcSrcPhoneExt(java.lang.String) 

    /**
     * Sets the value of field 'szTxtIncRsrcSrcPhoneNum'.
     * 
     * @param szTxtIncRsrcSrcPhoneNum the value of field
     * 'szTxtIncRsrcSrcPhoneNum'.
     */
    public void setSzTxtIncRsrcSrcPhoneNum(java.lang.String szTxtIncRsrcSrcPhoneNum)
    {
        this._szTxtIncRsrcSrcPhoneNum = szTxtIncRsrcSrcPhoneNum;
    } //-- void setSzTxtIncRsrcSrcPhoneNum(java.lang.String) 

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
     * Sets the value of field 'ulIdIncRsrc'.
     * 
     * @param ulIdIncRsrc the value of field 'ulIdIncRsrc'.
     */
    public void setUlIdIncRsrc(int ulIdIncRsrc)
    {
        this._ulIdIncRsrc = ulIdIncRsrc;
        this._has_ulIdIncRsrc = true;
    } //-- void setUlIdIncRsrc(int) 

    /**
     * Sets the value of field 'ulIdIncRsrcWorker'.
     * 
     * @param ulIdIncRsrcWorker the value of field
     * 'ulIdIncRsrcWorker'.
     */
    public void setUlIdIncRsrcWorker(int ulIdIncRsrcWorker)
    {
        this._ulIdIncRsrcWorker = ulIdIncRsrcWorker;
        this._has_ulIdIncRsrcWorker = true;
    } //-- void setUlIdIncRsrcWorker(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00 unmarshal(java.io.Reader) 

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
