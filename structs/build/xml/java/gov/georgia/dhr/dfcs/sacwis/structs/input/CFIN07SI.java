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
 * Class CFIN07SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN07SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archInputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct _archInputStruct;

    /**
     * Field _szCdInvoPhase
     */
    private java.lang.String _szCdInvoPhase;

    /**
     * Field _ulIdContract
     */
    private int _ulIdContract;

    /**
     * keeps track of state for field: _ulIdContract
     */
    private boolean _has_ulIdContract;

    /**
     * Field _tsSysTsLastUpdate2
     */
    private java.util.Date _tsSysTsLastUpdate2;

    /**
     * Field _szCdCnsvcPaymentType
     */
    private java.lang.String _szCdCnsvcPaymentType;

    /**
     * Field _ROWCFIN07SIG_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY _ROWCFIN07SIG_ARRAY;

    /**
     * Field _szCdInvoType
     */
    private java.lang.String _szCdInvoType;

    /**
     * Field _cIndCopiedInv
     */
    private java.lang.String _cIndCopiedInv;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN07SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdContract()
    {
        this._has_ulIdContract= false;
    } //-- void deleteUlIdContract() 

    /**
     * Returns the value of field 'archInputStruct'.
     * 
     * @return the value of field 'ArchInputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct()
    {
        return this._archInputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct getArchInputStruct() 

    /**
     * Returns the value of field 'cIndCopiedInv'.
     * 
     * @return the value of field 'CIndCopiedInv'.
     */
    public java.lang.String getCIndCopiedInv()
    {
        return this._cIndCopiedInv;
    } //-- java.lang.String getCIndCopiedInv() 

    /**
     * Returns the value of field 'ROWCFIN07SIG_ARRAY'.
     * 
     * @return the value of field 'ROWCFIN07SIG_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY getROWCFIN07SIG_ARRAY()
    {
        return this._ROWCFIN07SIG_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY getROWCFIN07SIG_ARRAY() 

    /**
     * Returns the value of field 'szCdCnsvcPaymentType'.
     * 
     * @return the value of field 'SzCdCnsvcPaymentType'.
     */
    public java.lang.String getSzCdCnsvcPaymentType()
    {
        return this._szCdCnsvcPaymentType;
    } //-- java.lang.String getSzCdCnsvcPaymentType() 

    /**
     * Returns the value of field 'szCdInvoPhase'.
     * 
     * @return the value of field 'SzCdInvoPhase'.
     */
    public java.lang.String getSzCdInvoPhase()
    {
        return this._szCdInvoPhase;
    } //-- java.lang.String getSzCdInvoPhase() 

    /**
     * Returns the value of field 'szCdInvoType'.
     * 
     * @return the value of field 'SzCdInvoType'.
     */
    public java.lang.String getSzCdInvoType()
    {
        return this._szCdInvoType;
    } //-- java.lang.String getSzCdInvoType() 

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
     * Returns the value of field 'ulIdContract'.
     * 
     * @return the value of field 'UlIdContract'.
     */
    public int getUlIdContract()
    {
        return this._ulIdContract;
    } //-- int getUlIdContract() 

    /**
     * Method hasUlIdContract
     * 
     * 
     * 
     * @return true if at least one UlIdContract has been added
     */
    public boolean hasUlIdContract()
    {
        return this._has_ulIdContract;
    } //-- boolean hasUlIdContract() 

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
     * Sets the value of field 'archInputStruct'.
     * 
     * @param archInputStruct the value of field 'archInputStruct'.
     */
    public void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct archInputStruct)
    {
        this._archInputStruct = archInputStruct;
    } //-- void setArchInputStruct(gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct) 

    /**
     * Sets the value of field 'cIndCopiedInv'.
     * 
     * @param cIndCopiedInv the value of field 'cIndCopiedInv'.
     */
    public void setCIndCopiedInv(java.lang.String cIndCopiedInv)
    {
        this._cIndCopiedInv = cIndCopiedInv;
    } //-- void setCIndCopiedInv(java.lang.String) 

    /**
     * Sets the value of field 'ROWCFIN07SIG_ARRAY'.
     * 
     * @param ROWCFIN07SIG_ARRAY the value of field
     * 'ROWCFIN07SIG_ARRAY'.
     */
    public void setROWCFIN07SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY ROWCFIN07SIG_ARRAY)
    {
        this._ROWCFIN07SIG_ARRAY = ROWCFIN07SIG_ARRAY;
    } //-- void setROWCFIN07SIG_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY) 

    /**
     * Sets the value of field 'szCdCnsvcPaymentType'.
     * 
     * @param szCdCnsvcPaymentType the value of field
     * 'szCdCnsvcPaymentType'.
     */
    public void setSzCdCnsvcPaymentType(java.lang.String szCdCnsvcPaymentType)
    {
        this._szCdCnsvcPaymentType = szCdCnsvcPaymentType;
    } //-- void setSzCdCnsvcPaymentType(java.lang.String) 

    /**
     * Sets the value of field 'szCdInvoPhase'.
     * 
     * @param szCdInvoPhase the value of field 'szCdInvoPhase'.
     */
    public void setSzCdInvoPhase(java.lang.String szCdInvoPhase)
    {
        this._szCdInvoPhase = szCdInvoPhase;
    } //-- void setSzCdInvoPhase(java.lang.String) 

    /**
     * Sets the value of field 'szCdInvoType'.
     * 
     * @param szCdInvoType the value of field 'szCdInvoType'.
     */
    public void setSzCdInvoType(java.lang.String szCdInvoType)
    {
        this._szCdInvoType = szCdInvoType;
    } //-- void setSzCdInvoType(java.lang.String) 

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
     * Sets the value of field 'ulIdContract'.
     * 
     * @param ulIdContract the value of field 'ulIdContract'.
     */
    public void setUlIdContract(int ulIdContract)
    {
        this._ulIdContract = ulIdContract;
        this._has_ulIdContract = true;
    } //-- void setUlIdContract(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI unmarshal(java.io.Reader) 

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
