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
 * Class CurrPlacementStats.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CurrPlacementStats extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _nbrChldrnUnder3
     */
    private int _nbrChldrnUnder3;

    /**
     * keeps track of state for field: _nbrChldrnUnder3
     */
    private boolean _has_nbrChldrnUnder3;

    /**
     * Field _nbrChldrnOver16
     */
    private int _nbrChldrnOver16;

    /**
     * keeps track of state for field: _nbrChldrnOver16
     */
    private boolean _has_nbrChldrnOver16;

    /**
     * Field _nbrMalesInHome
     */
    private int _nbrMalesInHome;

    /**
     * keeps track of state for field: _nbrMalesInHome
     */
    private boolean _has_nbrMalesInHome;

    /**
     * Field _nbrFemalesInHome
     */
    private int _nbrFemalesInHome;

    /**
     * keeps track of state for field: _nbrFemalesInHome
     */
    private boolean _has_nbrFemalesInHome;

    /**
     * Field _nbrChldrnWithLOCFllng
     */
    private int _nbrChldrnWithLOCFllng;

    /**
     * keeps track of state for field: _nbrChldrnWithLOCFllng
     */
    private boolean _has_nbrChldrnWithLOCFllng;


      //----------------/
     //- Constructors -/
    //----------------/

    public CurrPlacementStats() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNbrChldrnOver16()
    {
        this._has_nbrChldrnOver16= false;
    } //-- void deleteNbrChldrnOver16() 

    /**
     */
    public void deleteNbrChldrnUnder3()
    {
        this._has_nbrChldrnUnder3= false;
    } //-- void deleteNbrChldrnUnder3() 

    /**
     */
    public void deleteNbrChldrnWithLOCFllng()
    {
        this._has_nbrChldrnWithLOCFllng= false;
    } //-- void deleteNbrChldrnWithLOCFllng() 

    /**
     */
    public void deleteNbrFemalesInHome()
    {
        this._has_nbrFemalesInHome= false;
    } //-- void deleteNbrFemalesInHome() 

    /**
     */
    public void deleteNbrMalesInHome()
    {
        this._has_nbrMalesInHome= false;
    } //-- void deleteNbrMalesInHome() 

    /**
     * Returns the value of field 'nbrChldrnOver16'.
     * 
     * @return the value of field 'NbrChldrnOver16'.
     */
    public int getNbrChldrnOver16()
    {
        return this._nbrChldrnOver16;
    } //-- int getNbrChldrnOver16() 

    /**
     * Returns the value of field 'nbrChldrnUnder3'.
     * 
     * @return the value of field 'NbrChldrnUnder3'.
     */
    public int getNbrChldrnUnder3()
    {
        return this._nbrChldrnUnder3;
    } //-- int getNbrChldrnUnder3() 

    /**
     * Returns the value of field 'nbrChldrnWithLOCFllng'.
     * 
     * @return the value of field 'NbrChldrnWithLOCFllng'.
     */
    public int getNbrChldrnWithLOCFllng()
    {
        return this._nbrChldrnWithLOCFllng;
    } //-- int getNbrChldrnWithLOCFllng() 

    /**
     * Returns the value of field 'nbrFemalesInHome'.
     * 
     * @return the value of field 'NbrFemalesInHome'.
     */
    public int getNbrFemalesInHome()
    {
        return this._nbrFemalesInHome;
    } //-- int getNbrFemalesInHome() 

    /**
     * Returns the value of field 'nbrMalesInHome'.
     * 
     * @return the value of field 'NbrMalesInHome'.
     */
    public int getNbrMalesInHome()
    {
        return this._nbrMalesInHome;
    } //-- int getNbrMalesInHome() 

    /**
     * Method hasNbrChldrnOver16
     * 
     * 
     * 
     * @return true if at least one NbrChldrnOver16 has been added
     */
    public boolean hasNbrChldrnOver16()
    {
        return this._has_nbrChldrnOver16;
    } //-- boolean hasNbrChldrnOver16() 

    /**
     * Method hasNbrChldrnUnder3
     * 
     * 
     * 
     * @return true if at least one NbrChldrnUnder3 has been added
     */
    public boolean hasNbrChldrnUnder3()
    {
        return this._has_nbrChldrnUnder3;
    } //-- boolean hasNbrChldrnUnder3() 

    /**
     * Method hasNbrChldrnWithLOCFllng
     * 
     * 
     * 
     * @return true if at least one NbrChldrnWithLOCFllng has been
     * added
     */
    public boolean hasNbrChldrnWithLOCFllng()
    {
        return this._has_nbrChldrnWithLOCFllng;
    } //-- boolean hasNbrChldrnWithLOCFllng() 

    /**
     * Method hasNbrFemalesInHome
     * 
     * 
     * 
     * @return true if at least one NbrFemalesInHome has been added
     */
    public boolean hasNbrFemalesInHome()
    {
        return this._has_nbrFemalesInHome;
    } //-- boolean hasNbrFemalesInHome() 

    /**
     * Method hasNbrMalesInHome
     * 
     * 
     * 
     * @return true if at least one NbrMalesInHome has been added
     */
    public boolean hasNbrMalesInHome()
    {
        return this._has_nbrMalesInHome;
    } //-- boolean hasNbrMalesInHome() 

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
     * Sets the value of field 'nbrChldrnOver16'.
     * 
     * @param nbrChldrnOver16 the value of field 'nbrChldrnOver16'.
     */
    public void setNbrChldrnOver16(int nbrChldrnOver16)
    {
        this._nbrChldrnOver16 = nbrChldrnOver16;
        this._has_nbrChldrnOver16 = true;
    } //-- void setNbrChldrnOver16(int) 

    /**
     * Sets the value of field 'nbrChldrnUnder3'.
     * 
     * @param nbrChldrnUnder3 the value of field 'nbrChldrnUnder3'.
     */
    public void setNbrChldrnUnder3(int nbrChldrnUnder3)
    {
        this._nbrChldrnUnder3 = nbrChldrnUnder3;
        this._has_nbrChldrnUnder3 = true;
    } //-- void setNbrChldrnUnder3(int) 

    /**
     * Sets the value of field 'nbrChldrnWithLOCFllng'.
     * 
     * @param nbrChldrnWithLOCFllng the value of field
     * 'nbrChldrnWithLOCFllng'.
     */
    public void setNbrChldrnWithLOCFllng(int nbrChldrnWithLOCFllng)
    {
        this._nbrChldrnWithLOCFllng = nbrChldrnWithLOCFllng;
        this._has_nbrChldrnWithLOCFllng = true;
    } //-- void setNbrChldrnWithLOCFllng(int) 

    /**
     * Sets the value of field 'nbrFemalesInHome'.
     * 
     * @param nbrFemalesInHome the value of field 'nbrFemalesInHome'
     */
    public void setNbrFemalesInHome(int nbrFemalesInHome)
    {
        this._nbrFemalesInHome = nbrFemalesInHome;
        this._has_nbrFemalesInHome = true;
    } //-- void setNbrFemalesInHome(int) 

    /**
     * Sets the value of field 'nbrMalesInHome'.
     * 
     * @param nbrMalesInHome the value of field 'nbrMalesInHome'.
     */
    public void setNbrMalesInHome(int nbrMalesInHome)
    {
        this._nbrMalesInHome = nbrMalesInHome;
        this._has_nbrMalesInHome = true;
    } //-- void setNbrMalesInHome(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CurrPlacementStats unmarshal(java.io.Reader) 

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
