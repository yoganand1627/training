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
 * Class CCFC33SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CCFC33SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _cIndRiskAssmtIntranet
     */
    private java.lang.String _cIndRiskAssmtIntranet;

    /**
     * Field _ulIdSituation
     */
    private int _ulIdSituation;

    /**
     * keeps track of state for field: _ulIdSituation
     */
    private boolean _has_ulIdSituation;

    /**
     * Field _ulSysNbrUlongKey
     */
    private int _ulSysNbrUlongKey;

    /**
     * keeps track of state for field: _ulSysNbrUlongKey
     */
    private boolean _has_ulSysNbrUlongKey;

    /**
     * Field _ROWCCFC33SOG01
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01 _ROWCCFC33SOG01;

    /**
     * Field _ROWCCFC33SOG02
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02 _ROWCCFC33SOG02;

    /**
     * Field _ROWCCFC33SOG03
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03 _ROWCCFC33SOG03;

    /**
     * Field _ulNbrReviewContact
     */
    private int _ulNbrReviewContact;

    /**
     * keeps track of state for field: _ulNbrReviewContact
     */
    private boolean _has_ulNbrReviewContact;

    /**
     * Field _ROWCCFC33SOG04
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04 _ROWCCFC33SOG04;


      //----------------/
     //- Constructors -/
    //----------------/

    public CCFC33SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdSituation()
    {
        this._has_ulIdSituation= false;
    } //-- void deleteUlIdSituation() 

    /**
     */
    public void deleteUlNbrReviewContact()
    {
        this._has_ulNbrReviewContact= false;
    } //-- void deleteUlNbrReviewContact() 

    /**
     */
    public void deleteUlSysNbrUlongKey()
    {
        this._has_ulSysNbrUlongKey= false;
    } //-- void deleteUlSysNbrUlongKey() 

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'cIndRiskAssmtIntranet'.
     * 
     * @return the value of field 'CIndRiskAssmtIntranet'.
     */
    public java.lang.String getCIndRiskAssmtIntranet()
    {
        return this._cIndRiskAssmtIntranet;
    } //-- java.lang.String getCIndRiskAssmtIntranet() 

    /**
     * Returns the value of field 'ROWCCFC33SOG01'.
     * 
     * @return the value of field 'ROWCCFC33SOG01'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01 getROWCCFC33SOG01()
    {
        return this._ROWCCFC33SOG01;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01 getROWCCFC33SOG01() 

    /**
     * Returns the value of field 'ROWCCFC33SOG02'.
     * 
     * @return the value of field 'ROWCCFC33SOG02'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02 getROWCCFC33SOG02()
    {
        return this._ROWCCFC33SOG02;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02 getROWCCFC33SOG02() 

    /**
     * Returns the value of field 'ROWCCFC33SOG03'.
     * 
     * @return the value of field 'ROWCCFC33SOG03'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03 getROWCCFC33SOG03()
    {
        return this._ROWCCFC33SOG03;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03 getROWCCFC33SOG03() 

    /**
     * Returns the value of field 'ROWCCFC33SOG04'.
     * 
     * @return the value of field 'ROWCCFC33SOG04'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04 getROWCCFC33SOG04()
    {
        return this._ROWCCFC33SOG04;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04 getROWCCFC33SOG04() 

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
     * Returns the value of field 'ulNbrReviewContact'.
     * 
     * @return the value of field 'UlNbrReviewContact'.
     */
    public int getUlNbrReviewContact()
    {
        return this._ulNbrReviewContact;
    } //-- int getUlNbrReviewContact() 

    /**
     * Returns the value of field 'ulSysNbrUlongKey'.
     * 
     * @return the value of field 'UlSysNbrUlongKey'.
     */
    public int getUlSysNbrUlongKey()
    {
        return this._ulSysNbrUlongKey;
    } //-- int getUlSysNbrUlongKey() 

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
     * Method hasUlNbrReviewContact
     * 
     * 
     * 
     * @return true if at least one UlNbrReviewContact has been adde
     */
    public boolean hasUlNbrReviewContact()
    {
        return this._has_ulNbrReviewContact;
    } //-- boolean hasUlNbrReviewContact() 

    /**
     * Method hasUlSysNbrUlongKey
     * 
     * 
     * 
     * @return true if at least one UlSysNbrUlongKey has been added
     */
    public boolean hasUlSysNbrUlongKey()
    {
        return this._has_ulSysNbrUlongKey;
    } //-- boolean hasUlSysNbrUlongKey() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'cIndRiskAssmtIntranet'.
     * 
     * @param cIndRiskAssmtIntranet the value of field
     * 'cIndRiskAssmtIntranet'.
     */
    public void setCIndRiskAssmtIntranet(java.lang.String cIndRiskAssmtIntranet)
    {
        this._cIndRiskAssmtIntranet = cIndRiskAssmtIntranet;
    } //-- void setCIndRiskAssmtIntranet(java.lang.String) 

    /**
     * Sets the value of field 'ROWCCFC33SOG01'.
     * 
     * @param ROWCCFC33SOG01 the value of field 'ROWCCFC33SOG01'.
     */
    public void setROWCCFC33SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01 ROWCCFC33SOG01)
    {
        this._ROWCCFC33SOG01 = ROWCCFC33SOG01;
    } //-- void setROWCCFC33SOG01(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG01) 

    /**
     * Sets the value of field 'ROWCCFC33SOG02'.
     * 
     * @param ROWCCFC33SOG02 the value of field 'ROWCCFC33SOG02'.
     */
    public void setROWCCFC33SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02 ROWCCFC33SOG02)
    {
        this._ROWCCFC33SOG02 = ROWCCFC33SOG02;
    } //-- void setROWCCFC33SOG02(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG02) 

    /**
     * Sets the value of field 'ROWCCFC33SOG03'.
     * 
     * @param ROWCCFC33SOG03 the value of field 'ROWCCFC33SOG03'.
     */
    public void setROWCCFC33SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03 ROWCCFC33SOG03)
    {
        this._ROWCCFC33SOG03 = ROWCCFC33SOG03;
    } //-- void setROWCCFC33SOG03(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG03) 

    /**
     * Sets the value of field 'ROWCCFC33SOG04'.
     * 
     * @param ROWCCFC33SOG04 the value of field 'ROWCCFC33SOG04'.
     */
    public void setROWCCFC33SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04 ROWCCFC33SOG04)
    {
        this._ROWCCFC33SOG04 = ROWCCFC33SOG04;
    } //-- void setROWCCFC33SOG04(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC33SOG04) 

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
     * Sets the value of field 'ulNbrReviewContact'.
     * 
     * @param ulNbrReviewContact the value of field
     * 'ulNbrReviewContact'.
     */
    public void setUlNbrReviewContact(int ulNbrReviewContact)
    {
        this._ulNbrReviewContact = ulNbrReviewContact;
        this._has_ulNbrReviewContact = true;
    } //-- void setUlNbrReviewContact(int) 

    /**
     * Sets the value of field 'ulSysNbrUlongKey'.
     * 
     * @param ulSysNbrUlongKey the value of field 'ulSysNbrUlongKey'
     */
    public void setUlSysNbrUlongKey(int ulSysNbrUlongKey)
    {
        this._ulSysNbrUlongKey = ulSysNbrUlongKey;
        this._has_ulSysNbrUlongKey = true;
    } //-- void setUlSysNbrUlongKey(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO unmarshal(java.io.Reader) 

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
