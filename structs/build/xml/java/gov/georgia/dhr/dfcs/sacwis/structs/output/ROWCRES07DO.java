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
 * Class ROWCRES07DO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES07DO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdFloc
     */
    private int _ulIdFloc;

    /**
     * keeps track of state for field: _ulIdFloc
     */
    private boolean _has_ulIdFloc;

    /**
     * Field _dtDtFlocEffect
     */
    private org.exolab.castor.types.Date _dtDtFlocEffect;

    /**
     * Field _dtDtFlocEnd
     */
    private org.exolab.castor.types.Date _dtDtFlocEnd;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _sNbrFlocLevelsOfCare
     */
    private int _sNbrFlocLevelsOfCare;

    /**
     * keeps track of state for field: _sNbrFlocLevelsOfCare
     */
    private boolean _has_sNbrFlocLevelsOfCare;

    /**
     * Field _cCdFlocStatus1
     */
    private java.lang.String _cCdFlocStatus1;

    /**
     * Field _cCdFlocStatus2
     */
    private java.lang.String _cCdFlocStatus2;

    /**
     * Field _cCdFlocStatus3
     */
    private java.lang.String _cCdFlocStatus3;

    /**
     * Field _cCdFlocStatus4
     */
    private java.lang.String _cCdFlocStatus4;

    /**
     * Field _cCdFlocStatus5
     */
    private java.lang.String _cCdFlocStatus5;

    /**
     * Field _cCdFlocStatus6
     */
    private java.lang.String _cCdFlocStatus6;

    /**
     * Field _cCdFlocStatus7
     */
    private java.lang.String _cCdFlocStatus7;

    /**
     * Field _cCdFlocStatus8
     */
    private java.lang.String _cCdFlocStatus8;

    /**
     * Field _cCdFlocStatus9
     */
    private java.lang.String _cCdFlocStatus9;

    /**
     * Field _cCdFlocStatus10
     */
    private java.lang.String _cCdFlocStatus10;

    /**
     * Field _cCdFlocStatus11
     */
    private java.lang.String _cCdFlocStatus11;

    /**
     * Field _cCdFlocStatus12
     */
    private java.lang.String _cCdFlocStatus12;

    /**
     * Field _cCdFlocStatus13
     */
    private java.lang.String _cCdFlocStatus13;

    /**
     * Field _cCdFlocStatus14
     */
    private java.lang.String _cCdFlocStatus14;

    /**
     * Field _cCdFlocStatus15
     */
    private java.lang.String _cCdFlocStatus15;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES07DO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSNbrFlocLevelsOfCare()
    {
        this._has_sNbrFlocLevelsOfCare= false;
    } //-- void deleteSNbrFlocLevelsOfCare() 

    /**
     */
    public void deleteUlIdFloc()
    {
        this._has_ulIdFloc= false;
    } //-- void deleteUlIdFloc() 

    /**
     * Returns the value of field 'cCdFlocStatus1'.
     * 
     * @return the value of field 'CCdFlocStatus1'.
     */
    public java.lang.String getCCdFlocStatus1()
    {
        return this._cCdFlocStatus1;
    } //-- java.lang.String getCCdFlocStatus1() 

    /**
     * Returns the value of field 'cCdFlocStatus10'.
     * 
     * @return the value of field 'CCdFlocStatus10'.
     */
    public java.lang.String getCCdFlocStatus10()
    {
        return this._cCdFlocStatus10;
    } //-- java.lang.String getCCdFlocStatus10() 

    /**
     * Returns the value of field 'cCdFlocStatus11'.
     * 
     * @return the value of field 'CCdFlocStatus11'.
     */
    public java.lang.String getCCdFlocStatus11()
    {
        return this._cCdFlocStatus11;
    } //-- java.lang.String getCCdFlocStatus11() 

    /**
     * Returns the value of field 'cCdFlocStatus12'.
     * 
     * @return the value of field 'CCdFlocStatus12'.
     */
    public java.lang.String getCCdFlocStatus12()
    {
        return this._cCdFlocStatus12;
    } //-- java.lang.String getCCdFlocStatus12() 

    /**
     * Returns the value of field 'cCdFlocStatus13'.
     * 
     * @return the value of field 'CCdFlocStatus13'.
     */
    public java.lang.String getCCdFlocStatus13()
    {
        return this._cCdFlocStatus13;
    } //-- java.lang.String getCCdFlocStatus13() 

    /**
     * Returns the value of field 'cCdFlocStatus14'.
     * 
     * @return the value of field 'CCdFlocStatus14'.
     */
    public java.lang.String getCCdFlocStatus14()
    {
        return this._cCdFlocStatus14;
    } //-- java.lang.String getCCdFlocStatus14() 

    /**
     * Returns the value of field 'cCdFlocStatus15'.
     * 
     * @return the value of field 'CCdFlocStatus15'.
     */
    public java.lang.String getCCdFlocStatus15()
    {
        return this._cCdFlocStatus15;
    } //-- java.lang.String getCCdFlocStatus15() 

    /**
     * Returns the value of field 'cCdFlocStatus2'.
     * 
     * @return the value of field 'CCdFlocStatus2'.
     */
    public java.lang.String getCCdFlocStatus2()
    {
        return this._cCdFlocStatus2;
    } //-- java.lang.String getCCdFlocStatus2() 

    /**
     * Returns the value of field 'cCdFlocStatus3'.
     * 
     * @return the value of field 'CCdFlocStatus3'.
     */
    public java.lang.String getCCdFlocStatus3()
    {
        return this._cCdFlocStatus3;
    } //-- java.lang.String getCCdFlocStatus3() 

    /**
     * Returns the value of field 'cCdFlocStatus4'.
     * 
     * @return the value of field 'CCdFlocStatus4'.
     */
    public java.lang.String getCCdFlocStatus4()
    {
        return this._cCdFlocStatus4;
    } //-- java.lang.String getCCdFlocStatus4() 

    /**
     * Returns the value of field 'cCdFlocStatus5'.
     * 
     * @return the value of field 'CCdFlocStatus5'.
     */
    public java.lang.String getCCdFlocStatus5()
    {
        return this._cCdFlocStatus5;
    } //-- java.lang.String getCCdFlocStatus5() 

    /**
     * Returns the value of field 'cCdFlocStatus6'.
     * 
     * @return the value of field 'CCdFlocStatus6'.
     */
    public java.lang.String getCCdFlocStatus6()
    {
        return this._cCdFlocStatus6;
    } //-- java.lang.String getCCdFlocStatus6() 

    /**
     * Returns the value of field 'cCdFlocStatus7'.
     * 
     * @return the value of field 'CCdFlocStatus7'.
     */
    public java.lang.String getCCdFlocStatus7()
    {
        return this._cCdFlocStatus7;
    } //-- java.lang.String getCCdFlocStatus7() 

    /**
     * Returns the value of field 'cCdFlocStatus8'.
     * 
     * @return the value of field 'CCdFlocStatus8'.
     */
    public java.lang.String getCCdFlocStatus8()
    {
        return this._cCdFlocStatus8;
    } //-- java.lang.String getCCdFlocStatus8() 

    /**
     * Returns the value of field 'cCdFlocStatus9'.
     * 
     * @return the value of field 'CCdFlocStatus9'.
     */
    public java.lang.String getCCdFlocStatus9()
    {
        return this._cCdFlocStatus9;
    } //-- java.lang.String getCCdFlocStatus9() 

    /**
     * Returns the value of field 'dtDtFlocEffect'.
     * 
     * @return the value of field 'DtDtFlocEffect'.
     */
    public org.exolab.castor.types.Date getDtDtFlocEffect()
    {
        return this._dtDtFlocEffect;
    } //-- org.exolab.castor.types.Date getDtDtFlocEffect() 

    /**
     * Returns the value of field 'dtDtFlocEnd'.
     * 
     * @return the value of field 'DtDtFlocEnd'.
     */
    public org.exolab.castor.types.Date getDtDtFlocEnd()
    {
        return this._dtDtFlocEnd;
    } //-- org.exolab.castor.types.Date getDtDtFlocEnd() 

    /**
     * Returns the value of field 'sNbrFlocLevelsOfCare'.
     * 
     * @return the value of field 'SNbrFlocLevelsOfCare'.
     */
    public int getSNbrFlocLevelsOfCare()
    {
        return this._sNbrFlocLevelsOfCare;
    } //-- int getSNbrFlocLevelsOfCare() 

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
     * Returns the value of field 'ulIdFloc'.
     * 
     * @return the value of field 'UlIdFloc'.
     */
    public int getUlIdFloc()
    {
        return this._ulIdFloc;
    } //-- int getUlIdFloc() 

    /**
     * Method hasSNbrFlocLevelsOfCare
     * 
     * 
     * 
     * @return true if at least one SNbrFlocLevelsOfCare has been
     * added
     */
    public boolean hasSNbrFlocLevelsOfCare()
    {
        return this._has_sNbrFlocLevelsOfCare;
    } //-- boolean hasSNbrFlocLevelsOfCare() 

    /**
     * Method hasUlIdFloc
     * 
     * 
     * 
     * @return true if at least one UlIdFloc has been added
     */
    public boolean hasUlIdFloc()
    {
        return this._has_ulIdFloc;
    } //-- boolean hasUlIdFloc() 

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
     * Sets the value of field 'cCdFlocStatus1'.
     * 
     * @param cCdFlocStatus1 the value of field 'cCdFlocStatus1'.
     */
    public void setCCdFlocStatus1(java.lang.String cCdFlocStatus1)
    {
        this._cCdFlocStatus1 = cCdFlocStatus1;
    } //-- void setCCdFlocStatus1(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus10'.
     * 
     * @param cCdFlocStatus10 the value of field 'cCdFlocStatus10'.
     */
    public void setCCdFlocStatus10(java.lang.String cCdFlocStatus10)
    {
        this._cCdFlocStatus10 = cCdFlocStatus10;
    } //-- void setCCdFlocStatus10(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus11'.
     * 
     * @param cCdFlocStatus11 the value of field 'cCdFlocStatus11'.
     */
    public void setCCdFlocStatus11(java.lang.String cCdFlocStatus11)
    {
        this._cCdFlocStatus11 = cCdFlocStatus11;
    } //-- void setCCdFlocStatus11(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus12'.
     * 
     * @param cCdFlocStatus12 the value of field 'cCdFlocStatus12'.
     */
    public void setCCdFlocStatus12(java.lang.String cCdFlocStatus12)
    {
        this._cCdFlocStatus12 = cCdFlocStatus12;
    } //-- void setCCdFlocStatus12(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus13'.
     * 
     * @param cCdFlocStatus13 the value of field 'cCdFlocStatus13'.
     */
    public void setCCdFlocStatus13(java.lang.String cCdFlocStatus13)
    {
        this._cCdFlocStatus13 = cCdFlocStatus13;
    } //-- void setCCdFlocStatus13(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus14'.
     * 
     * @param cCdFlocStatus14 the value of field 'cCdFlocStatus14'.
     */
    public void setCCdFlocStatus14(java.lang.String cCdFlocStatus14)
    {
        this._cCdFlocStatus14 = cCdFlocStatus14;
    } //-- void setCCdFlocStatus14(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus15'.
     * 
     * @param cCdFlocStatus15 the value of field 'cCdFlocStatus15'.
     */
    public void setCCdFlocStatus15(java.lang.String cCdFlocStatus15)
    {
        this._cCdFlocStatus15 = cCdFlocStatus15;
    } //-- void setCCdFlocStatus15(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus2'.
     * 
     * @param cCdFlocStatus2 the value of field 'cCdFlocStatus2'.
     */
    public void setCCdFlocStatus2(java.lang.String cCdFlocStatus2)
    {
        this._cCdFlocStatus2 = cCdFlocStatus2;
    } //-- void setCCdFlocStatus2(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus3'.
     * 
     * @param cCdFlocStatus3 the value of field 'cCdFlocStatus3'.
     */
    public void setCCdFlocStatus3(java.lang.String cCdFlocStatus3)
    {
        this._cCdFlocStatus3 = cCdFlocStatus3;
    } //-- void setCCdFlocStatus3(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus4'.
     * 
     * @param cCdFlocStatus4 the value of field 'cCdFlocStatus4'.
     */
    public void setCCdFlocStatus4(java.lang.String cCdFlocStatus4)
    {
        this._cCdFlocStatus4 = cCdFlocStatus4;
    } //-- void setCCdFlocStatus4(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus5'.
     * 
     * @param cCdFlocStatus5 the value of field 'cCdFlocStatus5'.
     */
    public void setCCdFlocStatus5(java.lang.String cCdFlocStatus5)
    {
        this._cCdFlocStatus5 = cCdFlocStatus5;
    } //-- void setCCdFlocStatus5(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus6'.
     * 
     * @param cCdFlocStatus6 the value of field 'cCdFlocStatus6'.
     */
    public void setCCdFlocStatus6(java.lang.String cCdFlocStatus6)
    {
        this._cCdFlocStatus6 = cCdFlocStatus6;
    } //-- void setCCdFlocStatus6(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus7'.
     * 
     * @param cCdFlocStatus7 the value of field 'cCdFlocStatus7'.
     */
    public void setCCdFlocStatus7(java.lang.String cCdFlocStatus7)
    {
        this._cCdFlocStatus7 = cCdFlocStatus7;
    } //-- void setCCdFlocStatus7(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus8'.
     * 
     * @param cCdFlocStatus8 the value of field 'cCdFlocStatus8'.
     */
    public void setCCdFlocStatus8(java.lang.String cCdFlocStatus8)
    {
        this._cCdFlocStatus8 = cCdFlocStatus8;
    } //-- void setCCdFlocStatus8(java.lang.String) 

    /**
     * Sets the value of field 'cCdFlocStatus9'.
     * 
     * @param cCdFlocStatus9 the value of field 'cCdFlocStatus9'.
     */
    public void setCCdFlocStatus9(java.lang.String cCdFlocStatus9)
    {
        this._cCdFlocStatus9 = cCdFlocStatus9;
    } //-- void setCCdFlocStatus9(java.lang.String) 

    /**
     * Sets the value of field 'dtDtFlocEffect'.
     * 
     * @param dtDtFlocEffect the value of field 'dtDtFlocEffect'.
     */
    public void setDtDtFlocEffect(org.exolab.castor.types.Date dtDtFlocEffect)
    {
        this._dtDtFlocEffect = dtDtFlocEffect;
    } //-- void setDtDtFlocEffect(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'dtDtFlocEnd'.
     * 
     * @param dtDtFlocEnd the value of field 'dtDtFlocEnd'.
     */
    public void setDtDtFlocEnd(org.exolab.castor.types.Date dtDtFlocEnd)
    {
        this._dtDtFlocEnd = dtDtFlocEnd;
    } //-- void setDtDtFlocEnd(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'sNbrFlocLevelsOfCare'.
     * 
     * @param sNbrFlocLevelsOfCare the value of field
     * 'sNbrFlocLevelsOfCare'.
     */
    public void setSNbrFlocLevelsOfCare(int sNbrFlocLevelsOfCare)
    {
        this._sNbrFlocLevelsOfCare = sNbrFlocLevelsOfCare;
        this._has_sNbrFlocLevelsOfCare = true;
    } //-- void setSNbrFlocLevelsOfCare(int) 

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
     * Sets the value of field 'ulIdFloc'.
     * 
     * @param ulIdFloc the value of field 'ulIdFloc'.
     */
    public void setUlIdFloc(int ulIdFloc)
    {
        this._ulIdFloc = ulIdFloc;
        this._has_ulIdFloc = true;
    } //-- void setUlIdFloc(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO unmarshal(java.io.Reader) 

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
