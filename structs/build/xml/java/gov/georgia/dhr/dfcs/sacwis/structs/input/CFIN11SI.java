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
 * Class CFIN11SI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFIN11SI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdInvoInvoice
     */
    private int _ulIdInvoInvoice;

    /**
     * keeps track of state for field: _ulIdInvoInvoice
     */
    private boolean _has_ulIdInvoInvoice;

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
     * Field _szCdInvoPhase
     */
    private java.lang.String _szCdInvoPhase;

    /**
     * Field _ROWCFIN11SIG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00_ARRAY _ROWCFIN11SIG00_ARRAY;

    /**
     * Field _cIndCopiedInv
     */
    private java.lang.String _cIndCopiedInv;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFIN11SI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI()


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
     */
    public void deleteUlIdInvoInvoice()
    {
        this._has_ulIdInvoInvoice= false;
    } //-- void deleteUlIdInvoInvoice() 

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
     * Returns the value of field 'ROWCFIN11SIG00_ARRAY'.
     * 
     * @return the value of field 'ROWCFIN11SIG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00_ARRAY getROWCFIN11SIG00_ARRAY()
    {
        return this._ROWCFIN11SIG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00_ARRAY getROWCFIN11SIG00_ARRAY() 

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
     * Returns the value of field 'ulIdInvoInvoice'.
     * 
     * @return the value of field 'UlIdInvoInvoice'.
     */
    public int getUlIdInvoInvoice()
    {
        return this._ulIdInvoInvoice;
    } //-- int getUlIdInvoInvoice() 

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
     * Method hasUlIdInvoInvoice
     * 
     * 
     * 
     * @return true if at least one UlIdInvoInvoice has been added
     */
    public boolean hasUlIdInvoInvoice()
    {
        return this._has_ulIdInvoInvoice;
    } //-- boolean hasUlIdInvoInvoice() 

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
     * Sets the value of field 'ROWCFIN11SIG00_ARRAY'.
     * 
     * @param ROWCFIN11SIG00_ARRAY the value of field
     * 'ROWCFIN11SIG00_ARRAY'.
     */
    public void setROWCFIN11SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00_ARRAY ROWCFIN11SIG00_ARRAY)
    {
        this._ROWCFIN11SIG00_ARRAY = ROWCFIN11SIG00_ARRAY;
    } //-- void setROWCFIN11SIG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00_ARRAY) 

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
     * Sets the value of field 'ulIdInvoInvoice'.
     * 
     * @param ulIdInvoInvoice the value of field 'ulIdInvoInvoice'.
     */
    public void setUlIdInvoInvoice(int ulIdInvoInvoice)
    {
        this._ulIdInvoInvoice = ulIdInvoInvoice;
        this._has_ulIdInvoInvoice = true;
    } //-- void setUlIdInvoInvoice(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI unmarshal(java.io.Reader) 

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
