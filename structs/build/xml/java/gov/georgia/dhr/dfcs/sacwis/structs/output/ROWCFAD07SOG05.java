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
 * Class ROWCFAD07SOG05.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFAD07SOG05 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _uNbrRsrcIntChildren
     */
    private int _uNbrRsrcIntChildren;

    /**
     * keeps track of state for field: _uNbrRsrcIntChildren
     */
    private boolean _has_uNbrRsrcIntChildren;

    /**
     * Field _uNbrRsrcIntFeAgeMax
     */
    private int _uNbrRsrcIntFeAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcIntFeAgeMax
     */
    private boolean _has_uNbrRsrcIntFeAgeMax;

    /**
     * Field _uNbrRsrcIntFeAgeMin
     */
    private int _uNbrRsrcIntFeAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcIntFeAgeMin
     */
    private boolean _has_uNbrRsrcIntFeAgeMin;

    /**
     * Field _uNbrRsrcIntMaAgeMax
     */
    private int _uNbrRsrcIntMaAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcIntMaAgeMax
     */
    private boolean _has_uNbrRsrcIntMaAgeMax;

    /**
     * Field _uNbrRsrcIntMaAgeMin
     */
    private int _uNbrRsrcIntMaAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcIntMaAgeMin
     */
    private boolean _has_uNbrRsrcIntMaAgeMin;

    /**
     * Field _cIndRsrcEmergPlace
     */
    private java.lang.String _cIndRsrcEmergPlace;

    /**
     * Field _cIndRsrcTransport
     */
    private java.lang.String _cIndRsrcTransport;

    /**
     * Field _cIndSpecificChild
     */
    private java.lang.String _cIndSpecificChild;

    /**
     * Field _szTxtRsrcComments
     */
    private java.lang.String _szTxtRsrcComments;

    /**
     * Field _uNbrRsrcFMAgeMax
     */
    private int _uNbrRsrcFMAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMax
     */
    private boolean _has_uNbrRsrcFMAgeMax;

    /**
     * Field _uNbrRsrcFMAgeMin
     */
    private int _uNbrRsrcFMAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcFMAgeMin
     */
    private boolean _has_uNbrRsrcFMAgeMin;

    /**
     * Field _uNbrRsrcMlAgeMax
     */
    private int _uNbrRsrcMlAgeMax;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMax
     */
    private boolean _has_uNbrRsrcMlAgeMax;

    /**
     * Field _uNbrRsrcMlAgeMin
     */
    private int _uNbrRsrcMlAgeMin;

    /**
     * keeps track of state for field: _uNbrRsrcMlAgeMin
     */
    private boolean _has_uNbrRsrcMlAgeMin;

    /**
     * Field _txtHmPrgInterest
     */
    private java.lang.String _txtHmPrgInterest;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFAD07SOG05() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUNbrRsrcFMAgeMax()
    {
        this._has_uNbrRsrcFMAgeMax= false;
    } //-- void deleteUNbrRsrcFMAgeMax() 

    /**
     */
    public void deleteUNbrRsrcFMAgeMin()
    {
        this._has_uNbrRsrcFMAgeMin= false;
    } //-- void deleteUNbrRsrcFMAgeMin() 

    /**
     */
    public void deleteUNbrRsrcIntChildren()
    {
        this._has_uNbrRsrcIntChildren= false;
    } //-- void deleteUNbrRsrcIntChildren() 

    /**
     */
    public void deleteUNbrRsrcIntFeAgeMax()
    {
        this._has_uNbrRsrcIntFeAgeMax= false;
    } //-- void deleteUNbrRsrcIntFeAgeMax() 

    /**
     */
    public void deleteUNbrRsrcIntFeAgeMin()
    {
        this._has_uNbrRsrcIntFeAgeMin= false;
    } //-- void deleteUNbrRsrcIntFeAgeMin() 

    /**
     */
    public void deleteUNbrRsrcIntMaAgeMax()
    {
        this._has_uNbrRsrcIntMaAgeMax= false;
    } //-- void deleteUNbrRsrcIntMaAgeMax() 

    /**
     */
    public void deleteUNbrRsrcIntMaAgeMin()
    {
        this._has_uNbrRsrcIntMaAgeMin= false;
    } //-- void deleteUNbrRsrcIntMaAgeMin() 

    /**
     */
    public void deleteUNbrRsrcMlAgeMax()
    {
        this._has_uNbrRsrcMlAgeMax= false;
    } //-- void deleteUNbrRsrcMlAgeMax() 

    /**
     */
    public void deleteUNbrRsrcMlAgeMin()
    {
        this._has_uNbrRsrcMlAgeMin= false;
    } //-- void deleteUNbrRsrcMlAgeMin() 

    /**
     * Returns the value of field 'cIndRsrcEmergPlace'.
     * 
     * @return the value of field 'CIndRsrcEmergPlace'.
     */
    public java.lang.String getCIndRsrcEmergPlace()
    {
        return this._cIndRsrcEmergPlace;
    } //-- java.lang.String getCIndRsrcEmergPlace() 

    /**
     * Returns the value of field 'cIndRsrcTransport'.
     * 
     * @return the value of field 'CIndRsrcTransport'.
     */
    public java.lang.String getCIndRsrcTransport()
    {
        return this._cIndRsrcTransport;
    } //-- java.lang.String getCIndRsrcTransport() 

    /**
     * Returns the value of field 'cIndSpecificChild'.
     * 
     * @return the value of field 'CIndSpecificChild'.
     */
    public java.lang.String getCIndSpecificChild()
    {
        return this._cIndSpecificChild;
    } //-- java.lang.String getCIndSpecificChild() 

    /**
     * Returns the value of field 'szTxtRsrcComments'.
     * 
     * @return the value of field 'SzTxtRsrcComments'.
     */
    public java.lang.String getSzTxtRsrcComments()
    {
        return this._szTxtRsrcComments;
    } //-- java.lang.String getSzTxtRsrcComments() 

    /**
     * Returns the value of field 'txtHmPrgInterest'.
     * 
     * @return the value of field 'TxtHmPrgInterest'.
     */
    public java.lang.String getTxtHmPrgInterest()
    {
        return this._txtHmPrgInterest;
    } //-- java.lang.String getTxtHmPrgInterest() 

    /**
     * Returns the value of field 'uNbrRsrcFMAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcFMAgeMax'.
     */
    public int getUNbrRsrcFMAgeMax()
    {
        return this._uNbrRsrcFMAgeMax;
    } //-- int getUNbrRsrcFMAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcFMAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcFMAgeMin'.
     */
    public int getUNbrRsrcFMAgeMin()
    {
        return this._uNbrRsrcFMAgeMin;
    } //-- int getUNbrRsrcFMAgeMin() 

    /**
     * Returns the value of field 'uNbrRsrcIntChildren'.
     * 
     * @return the value of field 'UNbrRsrcIntChildren'.
     */
    public int getUNbrRsrcIntChildren()
    {
        return this._uNbrRsrcIntChildren;
    } //-- int getUNbrRsrcIntChildren() 

    /**
     * Returns the value of field 'uNbrRsrcIntFeAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcIntFeAgeMax'.
     */
    public int getUNbrRsrcIntFeAgeMax()
    {
        return this._uNbrRsrcIntFeAgeMax;
    } //-- int getUNbrRsrcIntFeAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcIntFeAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcIntFeAgeMin'.
     */
    public int getUNbrRsrcIntFeAgeMin()
    {
        return this._uNbrRsrcIntFeAgeMin;
    } //-- int getUNbrRsrcIntFeAgeMin() 

    /**
     * Returns the value of field 'uNbrRsrcIntMaAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcIntMaAgeMax'.
     */
    public int getUNbrRsrcIntMaAgeMax()
    {
        return this._uNbrRsrcIntMaAgeMax;
    } //-- int getUNbrRsrcIntMaAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcIntMaAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcIntMaAgeMin'.
     */
    public int getUNbrRsrcIntMaAgeMin()
    {
        return this._uNbrRsrcIntMaAgeMin;
    } //-- int getUNbrRsrcIntMaAgeMin() 

    /**
     * Returns the value of field 'uNbrRsrcMlAgeMax'.
     * 
     * @return the value of field 'UNbrRsrcMlAgeMax'.
     */
    public int getUNbrRsrcMlAgeMax()
    {
        return this._uNbrRsrcMlAgeMax;
    } //-- int getUNbrRsrcMlAgeMax() 

    /**
     * Returns the value of field 'uNbrRsrcMlAgeMin'.
     * 
     * @return the value of field 'UNbrRsrcMlAgeMin'.
     */
    public int getUNbrRsrcMlAgeMin()
    {
        return this._uNbrRsrcMlAgeMin;
    } //-- int getUNbrRsrcMlAgeMin() 

    /**
     * Method hasUNbrRsrcFMAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFMAgeMax has been added
     */
    public boolean hasUNbrRsrcFMAgeMax()
    {
        return this._has_uNbrRsrcFMAgeMax;
    } //-- boolean hasUNbrRsrcFMAgeMax() 

    /**
     * Method hasUNbrRsrcFMAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcFMAgeMin has been added
     */
    public boolean hasUNbrRsrcFMAgeMin()
    {
        return this._has_uNbrRsrcFMAgeMin;
    } //-- boolean hasUNbrRsrcFMAgeMin() 

    /**
     * Method hasUNbrRsrcIntChildren
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntChildren has been
     * added
     */
    public boolean hasUNbrRsrcIntChildren()
    {
        return this._has_uNbrRsrcIntChildren;
    } //-- boolean hasUNbrRsrcIntChildren() 

    /**
     * Method hasUNbrRsrcIntFeAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntFeAgeMax has been
     * added
     */
    public boolean hasUNbrRsrcIntFeAgeMax()
    {
        return this._has_uNbrRsrcIntFeAgeMax;
    } //-- boolean hasUNbrRsrcIntFeAgeMax() 

    /**
     * Method hasUNbrRsrcIntFeAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntFeAgeMin has been
     * added
     */
    public boolean hasUNbrRsrcIntFeAgeMin()
    {
        return this._has_uNbrRsrcIntFeAgeMin;
    } //-- boolean hasUNbrRsrcIntFeAgeMin() 

    /**
     * Method hasUNbrRsrcIntMaAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntMaAgeMax has been
     * added
     */
    public boolean hasUNbrRsrcIntMaAgeMax()
    {
        return this._has_uNbrRsrcIntMaAgeMax;
    } //-- boolean hasUNbrRsrcIntMaAgeMax() 

    /**
     * Method hasUNbrRsrcIntMaAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcIntMaAgeMin has been
     * added
     */
    public boolean hasUNbrRsrcIntMaAgeMin()
    {
        return this._has_uNbrRsrcIntMaAgeMin;
    } //-- boolean hasUNbrRsrcIntMaAgeMin() 

    /**
     * Method hasUNbrRsrcMlAgeMax
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcMlAgeMax has been added
     */
    public boolean hasUNbrRsrcMlAgeMax()
    {
        return this._has_uNbrRsrcMlAgeMax;
    } //-- boolean hasUNbrRsrcMlAgeMax() 

    /**
     * Method hasUNbrRsrcMlAgeMin
     * 
     * 
     * 
     * @return true if at least one UNbrRsrcMlAgeMin has been added
     */
    public boolean hasUNbrRsrcMlAgeMin()
    {
        return this._has_uNbrRsrcMlAgeMin;
    } //-- boolean hasUNbrRsrcMlAgeMin() 

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
     * Sets the value of field 'cIndRsrcEmergPlace'.
     * 
     * @param cIndRsrcEmergPlace the value of field
     * 'cIndRsrcEmergPlace'.
     */
    public void setCIndRsrcEmergPlace(java.lang.String cIndRsrcEmergPlace)
    {
        this._cIndRsrcEmergPlace = cIndRsrcEmergPlace;
    } //-- void setCIndRsrcEmergPlace(java.lang.String) 

    /**
     * Sets the value of field 'cIndRsrcTransport'.
     * 
     * @param cIndRsrcTransport the value of field
     * 'cIndRsrcTransport'.
     */
    public void setCIndRsrcTransport(java.lang.String cIndRsrcTransport)
    {
        this._cIndRsrcTransport = cIndRsrcTransport;
    } //-- void setCIndRsrcTransport(java.lang.String) 

    /**
     * Sets the value of field 'cIndSpecificChild'.
     * 
     * @param cIndSpecificChild the value of field
     * 'cIndSpecificChild'.
     */
    public void setCIndSpecificChild(java.lang.String cIndSpecificChild)
    {
        this._cIndSpecificChild = cIndSpecificChild;
    } //-- void setCIndSpecificChild(java.lang.String) 

    /**
     * Sets the value of field 'szTxtRsrcComments'.
     * 
     * @param szTxtRsrcComments the value of field
     * 'szTxtRsrcComments'.
     */
    public void setSzTxtRsrcComments(java.lang.String szTxtRsrcComments)
    {
        this._szTxtRsrcComments = szTxtRsrcComments;
    } //-- void setSzTxtRsrcComments(java.lang.String) 

    /**
     * Sets the value of field 'txtHmPrgInterest'.
     * 
     * @param txtHmPrgInterest the value of field 'txtHmPrgInterest'
     */
    public void setTxtHmPrgInterest(java.lang.String txtHmPrgInterest)
    {
        this._txtHmPrgInterest = txtHmPrgInterest;
    } //-- void setTxtHmPrgInterest(java.lang.String) 

    /**
     * Sets the value of field 'uNbrRsrcFMAgeMax'.
     * 
     * @param uNbrRsrcFMAgeMax the value of field 'uNbrRsrcFMAgeMax'
     */
    public void setUNbrRsrcFMAgeMax(int uNbrRsrcFMAgeMax)
    {
        this._uNbrRsrcFMAgeMax = uNbrRsrcFMAgeMax;
        this._has_uNbrRsrcFMAgeMax = true;
    } //-- void setUNbrRsrcFMAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcFMAgeMin'.
     * 
     * @param uNbrRsrcFMAgeMin the value of field 'uNbrRsrcFMAgeMin'
     */
    public void setUNbrRsrcFMAgeMin(int uNbrRsrcFMAgeMin)
    {
        this._uNbrRsrcFMAgeMin = uNbrRsrcFMAgeMin;
        this._has_uNbrRsrcFMAgeMin = true;
    } //-- void setUNbrRsrcFMAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntChildren'.
     * 
     * @param uNbrRsrcIntChildren the value of field
     * 'uNbrRsrcIntChildren'.
     */
    public void setUNbrRsrcIntChildren(int uNbrRsrcIntChildren)
    {
        this._uNbrRsrcIntChildren = uNbrRsrcIntChildren;
        this._has_uNbrRsrcIntChildren = true;
    } //-- void setUNbrRsrcIntChildren(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntFeAgeMax'.
     * 
     * @param uNbrRsrcIntFeAgeMax the value of field
     * 'uNbrRsrcIntFeAgeMax'.
     */
    public void setUNbrRsrcIntFeAgeMax(int uNbrRsrcIntFeAgeMax)
    {
        this._uNbrRsrcIntFeAgeMax = uNbrRsrcIntFeAgeMax;
        this._has_uNbrRsrcIntFeAgeMax = true;
    } //-- void setUNbrRsrcIntFeAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntFeAgeMin'.
     * 
     * @param uNbrRsrcIntFeAgeMin the value of field
     * 'uNbrRsrcIntFeAgeMin'.
     */
    public void setUNbrRsrcIntFeAgeMin(int uNbrRsrcIntFeAgeMin)
    {
        this._uNbrRsrcIntFeAgeMin = uNbrRsrcIntFeAgeMin;
        this._has_uNbrRsrcIntFeAgeMin = true;
    } //-- void setUNbrRsrcIntFeAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntMaAgeMax'.
     * 
     * @param uNbrRsrcIntMaAgeMax the value of field
     * 'uNbrRsrcIntMaAgeMax'.
     */
    public void setUNbrRsrcIntMaAgeMax(int uNbrRsrcIntMaAgeMax)
    {
        this._uNbrRsrcIntMaAgeMax = uNbrRsrcIntMaAgeMax;
        this._has_uNbrRsrcIntMaAgeMax = true;
    } //-- void setUNbrRsrcIntMaAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcIntMaAgeMin'.
     * 
     * @param uNbrRsrcIntMaAgeMin the value of field
     * 'uNbrRsrcIntMaAgeMin'.
     */
    public void setUNbrRsrcIntMaAgeMin(int uNbrRsrcIntMaAgeMin)
    {
        this._uNbrRsrcIntMaAgeMin = uNbrRsrcIntMaAgeMin;
        this._has_uNbrRsrcIntMaAgeMin = true;
    } //-- void setUNbrRsrcIntMaAgeMin(int) 

    /**
     * Sets the value of field 'uNbrRsrcMlAgeMax'.
     * 
     * @param uNbrRsrcMlAgeMax the value of field 'uNbrRsrcMlAgeMax'
     */
    public void setUNbrRsrcMlAgeMax(int uNbrRsrcMlAgeMax)
    {
        this._uNbrRsrcMlAgeMax = uNbrRsrcMlAgeMax;
        this._has_uNbrRsrcMlAgeMax = true;
    } //-- void setUNbrRsrcMlAgeMax(int) 

    /**
     * Sets the value of field 'uNbrRsrcMlAgeMin'.
     * 
     * @param uNbrRsrcMlAgeMin the value of field 'uNbrRsrcMlAgeMin'
     */
    public void setUNbrRsrcMlAgeMin(int uNbrRsrcMlAgeMin)
    {
        this._uNbrRsrcMlAgeMin = uNbrRsrcMlAgeMin;
        this._has_uNbrRsrcMlAgeMin = true;
    } //-- void setUNbrRsrcMlAgeMin(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG05 unmarshal(java.io.Reader) 

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
