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
 * Class ArchInputStruct.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArchInputStruct extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cReqFuncCd
     */
    private java.lang.String _cReqFuncCd;

    /**
     * Field _bPerfInd
     */
    private java.lang.String _bPerfInd;

    /**
     * Field _bDataAcsInd
     */
    private java.lang.String _bDataAcsInd;

    /**
     * Field _usPageNbr
     */
    private int _usPageNbr;

    /**
     * keeps track of state for field: _usPageNbr
     */
    private boolean _has_usPageNbr;

    /**
     * Field _ulPageSizeNbr
     */
    private int _ulPageSizeNbr;

    /**
     * keeps track of state for field: _ulPageSizeNbr
     */
    private boolean _has_ulPageSizeNbr;

    /**
     * Field _ulSysNbrReserved1
     */
    private java.lang.String _ulSysNbrReserved1;

    /**
     * Field _ulSysNbrReserved2
     */
    private int _ulSysNbrReserved2;

    /**
     * keeps track of state for field: _ulSysNbrReserved2
     */
    private boolean _has_ulSysNbrReserved2;

    /**
     * Field _ulSysServiceChksum
     */
    private int _ulSysServiceChksum;

    /**
     * keeps track of state for field: _ulSysServiceChksum
     */
    private boolean _has_ulSysServiceChksum;

    /**
     * Field _szUserId
     */
    private java.lang.String _szUserId;

    /**
     * Field _szDstribStrtTs
     */
    private java.lang.String _szDstribStrtTs;

    /**
     * Field _szOrderBy
     */
    private java.lang.String _szOrderBy;

    /**
     * Field _szOrderDirection
     */
    private java.lang.String _szOrderDirection;

    /**
     * Field _szSysTxtGenericIP
     */
    private java.lang.String _szSysTxtGenericIP;

    /**
     * Field _szSysTxtGenericSSN
     */
    private java.lang.String _szSysTxtGenericSSN;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArchInputStruct() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlPageSizeNbr()
    {
        this._has_ulPageSizeNbr= false;
    } //-- void deleteUlPageSizeNbr() 

    /**
     */
    public void deleteUlSysNbrReserved2()
    {
        this._has_ulSysNbrReserved2= false;
    } //-- void deleteUlSysNbrReserved2() 

    /**
     */
    public void deleteUlSysServiceChksum()
    {
        this._has_ulSysServiceChksum= false;
    } //-- void deleteUlSysServiceChksum() 

    /**
     */
    public void deleteUsPageNbr()
    {
        this._has_usPageNbr= false;
    } //-- void deleteUsPageNbr() 

    /**
     * Returns the value of field 'bDataAcsInd'.
     * 
     * @return the value of field 'BDataAcsInd'.
     */
    public java.lang.String getBDataAcsInd()
    {
        return this._bDataAcsInd;
    } //-- java.lang.String getBDataAcsInd() 

    /**
     * Returns the value of field 'bPerfInd'.
     * 
     * @return the value of field 'BPerfInd'.
     */
    public java.lang.String getBPerfInd()
    {
        return this._bPerfInd;
    } //-- java.lang.String getBPerfInd() 

    /**
     * Returns the value of field 'cReqFuncCd'.
     * 
     * @return the value of field 'CReqFuncCd'.
     */
    public java.lang.String getCReqFuncCd()
    {
        return this._cReqFuncCd;
    } //-- java.lang.String getCReqFuncCd() 

    /**
     * Returns the value of field 'szDstribStrtTs'.
     * 
     * @return the value of field 'SzDstribStrtTs'.
     */
    public java.lang.String getSzDstribStrtTs()
    {
        return this._szDstribStrtTs;
    } //-- java.lang.String getSzDstribStrtTs() 

    /**
     * Returns the value of field 'szOrderBy'.
     * 
     * @return the value of field 'SzOrderBy'.
     */
    public java.lang.String getSzOrderBy()
    {
        return this._szOrderBy;
    } //-- java.lang.String getSzOrderBy() 

    /**
     * Returns the value of field 'szOrderDirection'.
     * 
     * @return the value of field 'SzOrderDirection'.
     */
    public java.lang.String getSzOrderDirection()
    {
        return this._szOrderDirection;
    } //-- java.lang.String getSzOrderDirection() 

    /**
     * Returns the value of field 'szSysTxtGenericIP'.
     * 
     * @return the value of field 'SzSysTxtGenericIP'.
     */
    public java.lang.String getSzSysTxtGenericIP()
    {
        return this._szSysTxtGenericIP;
    } //-- java.lang.String getSzSysTxtGenericIP() 

    /**
     * Returns the value of field 'szSysTxtGenericSSN'.
     * 
     * @return the value of field 'SzSysTxtGenericSSN'.
     */
    public java.lang.String getSzSysTxtGenericSSN()
    {
        return this._szSysTxtGenericSSN;
    } //-- java.lang.String getSzSysTxtGenericSSN() 

    /**
     * Returns the value of field 'szUserId'.
     * 
     * @return the value of field 'SzUserId'.
     */
    public java.lang.String getSzUserId()
    {
        return this._szUserId;
    } //-- java.lang.String getSzUserId() 

    /**
     * Returns the value of field 'ulPageSizeNbr'.
     * 
     * @return the value of field 'UlPageSizeNbr'.
     */
    public int getUlPageSizeNbr()
    {
        return this._ulPageSizeNbr;
    } //-- int getUlPageSizeNbr() 

    /**
     * Returns the value of field 'ulSysNbrReserved1'.
     * 
     * @return the value of field 'UlSysNbrReserved1'.
     */
    public java.lang.String getUlSysNbrReserved1()
    {
        return this._ulSysNbrReserved1;
    } //-- java.lang.String getUlSysNbrReserved1() 

    /**
     * Returns the value of field 'ulSysNbrReserved2'.
     * 
     * @return the value of field 'UlSysNbrReserved2'.
     */
    public int getUlSysNbrReserved2()
    {
        return this._ulSysNbrReserved2;
    } //-- int getUlSysNbrReserved2() 

    /**
     * Returns the value of field 'ulSysServiceChksum'.
     * 
     * @return the value of field 'UlSysServiceChksum'.
     */
    public int getUlSysServiceChksum()
    {
        return this._ulSysServiceChksum;
    } //-- int getUlSysServiceChksum() 

    /**
     * Returns the value of field 'usPageNbr'.
     * 
     * @return the value of field 'UsPageNbr'.
     */
    public int getUsPageNbr()
    {
        return this._usPageNbr;
    } //-- int getUsPageNbr() 

    /**
     * Method hasUlPageSizeNbr
     * 
     * 
     * 
     * @return true if at least one UlPageSizeNbr has been added
     */
    public boolean hasUlPageSizeNbr()
    {
        return this._has_ulPageSizeNbr;
    } //-- boolean hasUlPageSizeNbr() 

    /**
     * Method hasUlSysNbrReserved2
     * 
     * 
     * 
     * @return true if at least one UlSysNbrReserved2 has been added
     */
    public boolean hasUlSysNbrReserved2()
    {
        return this._has_ulSysNbrReserved2;
    } //-- boolean hasUlSysNbrReserved2() 

    /**
     * Method hasUlSysServiceChksum
     * 
     * 
     * 
     * @return true if at least one UlSysServiceChksum has been adde
     */
    public boolean hasUlSysServiceChksum()
    {
        return this._has_ulSysServiceChksum;
    } //-- boolean hasUlSysServiceChksum() 

    /**
     * Method hasUsPageNbr
     * 
     * 
     * 
     * @return true if at least one UsPageNbr has been added
     */
    public boolean hasUsPageNbr()
    {
        return this._has_usPageNbr;
    } //-- boolean hasUsPageNbr() 

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
     * Sets the value of field 'bDataAcsInd'.
     * 
     * @param bDataAcsInd the value of field 'bDataAcsInd'.
     */
    public void setBDataAcsInd(java.lang.String bDataAcsInd)
    {
        this._bDataAcsInd = bDataAcsInd;
    } //-- void setBDataAcsInd(java.lang.String) 

    /**
     * Sets the value of field 'bPerfInd'.
     * 
     * @param bPerfInd the value of field 'bPerfInd'.
     */
    public void setBPerfInd(java.lang.String bPerfInd)
    {
        this._bPerfInd = bPerfInd;
    } //-- void setBPerfInd(java.lang.String) 

    /**
     * Sets the value of field 'cReqFuncCd'.
     * 
     * @param cReqFuncCd the value of field 'cReqFuncCd'.
     */
    public void setCReqFuncCd(java.lang.String cReqFuncCd)
    {
        this._cReqFuncCd = cReqFuncCd;
    } //-- void setCReqFuncCd(java.lang.String) 

    /**
     * Sets the value of field 'szDstribStrtTs'.
     * 
     * @param szDstribStrtTs the value of field 'szDstribStrtTs'.
     */
    public void setSzDstribStrtTs(java.lang.String szDstribStrtTs)
    {
        this._szDstribStrtTs = szDstribStrtTs;
    } //-- void setSzDstribStrtTs(java.lang.String) 

    /**
     * Sets the value of field 'szOrderBy'.
     * 
     * @param szOrderBy the value of field 'szOrderBy'.
     */
    public void setSzOrderBy(java.lang.String szOrderBy)
    {
        this._szOrderBy = szOrderBy;
    } //-- void setSzOrderBy(java.lang.String) 

    /**
     * Sets the value of field 'szOrderDirection'.
     * 
     * @param szOrderDirection the value of field 'szOrderDirection'
     */
    public void setSzOrderDirection(java.lang.String szOrderDirection)
    {
        this._szOrderDirection = szOrderDirection;
    } //-- void setSzOrderDirection(java.lang.String) 

    /**
     * Sets the value of field 'szSysTxtGenericIP'.
     * 
     * @param szSysTxtGenericIP the value of field
     * 'szSysTxtGenericIP'.
     */
    public void setSzSysTxtGenericIP(java.lang.String szSysTxtGenericIP)
    {
        this._szSysTxtGenericIP = szSysTxtGenericIP;
    } //-- void setSzSysTxtGenericIP(java.lang.String) 

    /**
     * Sets the value of field 'szSysTxtGenericSSN'.
     * 
     * @param szSysTxtGenericSSN the value of field
     * 'szSysTxtGenericSSN'.
     */
    public void setSzSysTxtGenericSSN(java.lang.String szSysTxtGenericSSN)
    {
        this._szSysTxtGenericSSN = szSysTxtGenericSSN;
    } //-- void setSzSysTxtGenericSSN(java.lang.String) 

    /**
     * Sets the value of field 'szUserId'.
     * 
     * @param szUserId the value of field 'szUserId'.
     */
    public void setSzUserId(java.lang.String szUserId)
    {
        this._szUserId = szUserId;
    } //-- void setSzUserId(java.lang.String) 

    /**
     * Sets the value of field 'ulPageSizeNbr'.
     * 
     * @param ulPageSizeNbr the value of field 'ulPageSizeNbr'.
     */
    public void setUlPageSizeNbr(int ulPageSizeNbr)
    {
        this._ulPageSizeNbr = ulPageSizeNbr;
        this._has_ulPageSizeNbr = true;
    } //-- void setUlPageSizeNbr(int) 

    /**
     * Sets the value of field 'ulSysNbrReserved1'.
     * 
     * @param ulSysNbrReserved1 the value of field
     * 'ulSysNbrReserved1'.
     */
    public void setUlSysNbrReserved1(java.lang.String ulSysNbrReserved1)
    {
        this._ulSysNbrReserved1 = ulSysNbrReserved1;
    } //-- void setUlSysNbrReserved1(java.lang.String) 

    /**
     * Sets the value of field 'ulSysNbrReserved2'.
     * 
     * @param ulSysNbrReserved2 the value of field
     * 'ulSysNbrReserved2'.
     */
    public void setUlSysNbrReserved2(int ulSysNbrReserved2)
    {
        this._ulSysNbrReserved2 = ulSysNbrReserved2;
        this._has_ulSysNbrReserved2 = true;
    } //-- void setUlSysNbrReserved2(int) 

    /**
     * Sets the value of field 'ulSysServiceChksum'.
     * 
     * @param ulSysServiceChksum the value of field
     * 'ulSysServiceChksum'.
     */
    public void setUlSysServiceChksum(int ulSysServiceChksum)
    {
        this._ulSysServiceChksum = ulSysServiceChksum;
        this._has_ulSysServiceChksum = true;
    } //-- void setUlSysServiceChksum(int) 

    /**
     * Sets the value of field 'usPageNbr'.
     * 
     * @param usPageNbr the value of field 'usPageNbr'.
     */
    public void setUsPageNbr(int usPageNbr)
    {
        this._usPageNbr = usPageNbr;
        this._has_usPageNbr = true;
    } //-- void setUsPageNbr(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct unmarshal(java.io.Reader) 

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
