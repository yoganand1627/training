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
 * Class CityCountyStruct_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CityCountyStruct_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulRowQty
     */
    private int _ulRowQty;

    /**
     * keeps track of state for field: _ulRowQty
     */
    private boolean _has_ulRowQty;

    /**
     * Field _cityCountyStructList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> _cityCountyStructList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CityCountyStruct_ARRAY() 
     {
        super();
        this._cityCountyStructList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCityCountyStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCityCountyStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct vCityCountyStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._cityCountyStructList.size() >= 20) {
            throw new IndexOutOfBoundsException("addCityCountyStruct has a maximum of 20");
        }
        
        this._cityCountyStructList.add(vCityCountyStruct);
    } //-- void addCityCountyStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) 

    /**
     * 
     * 
     * @param index
     * @param vCityCountyStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCityCountyStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct vCityCountyStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._cityCountyStructList.size() >= 20) {
            throw new IndexOutOfBoundsException("addCityCountyStruct has a maximum of 20");
        }
        
        this._cityCountyStructList.add(index, vCityCountyStruct);
    } //-- void addCityCountyStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCityCountyStruct
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> enumerateCityCountyStruct()
    {
        return java.util.Collections.enumeration(this._cityCountyStructList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> enumerateCityCountyStruct() 

    /**
     * Method getCityCountyStruct
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct getCityCountyStruct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._cityCountyStructList.size()) {
            throw new IndexOutOfBoundsException("getCityCountyStruct: Index value '" + index + "' not in range [0.." + (this._cityCountyStructList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) _cityCountyStructList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct getCityCountyStruct(int) 

    /**
     * Method getCityCountyStruct
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct[] getCityCountyStruct()
    {
        int size = this._cityCountyStructList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) _cityCountyStructList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct[] getCityCountyStruct() 

    /**
     * Method getCityCountyStructAsReference
     * 
     * Returns a reference to '_cityCountyStructList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> getCityCountyStructAsReference()
    {
        return this._cityCountyStructList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> getCityCountyStructAsReference() 

    /**
     * Method getCityCountyStructCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCityCountyStructCount()
    {
        return this._cityCountyStructList.size();
    } //-- int getCityCountyStructCount() 

    /**
     * Returns the value of field 'ulRowQty'.
     * 
     * @return the value of field 'UlRowQty'.
     */
    public int getUlRowQty()
    {
        return this._ulRowQty;
    } //-- int getUlRowQty() 

    /**
     * Method hasUlRowQty
     * 
     * 
     * 
     * @return true if at least one UlRowQty has been added
     */
    public boolean hasUlRowQty()
    {
        return this._has_ulRowQty;
    } //-- boolean hasUlRowQty() 

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
     * Method iterateCityCountyStruct
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> iterateCityCountyStruct()
    {
        return this._cityCountyStructList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> iterateCityCountyStruct() 

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
     */
    public void removeAllCityCountyStruct()
    {
        this._cityCountyStructList.clear();
    } //-- void removeAllCityCountyStruct() 

    /**
     * Method removeCityCountyStruct
     * 
     * 
     * 
     * @param vCityCountyStruct
     * @return true if the object was removed from the collection.
     */
    public boolean removeCityCountyStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct vCityCountyStruct)
    {
        boolean removed = _cityCountyStructList.remove(vCityCountyStruct);
        return removed;
    } //-- boolean removeCityCountyStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) 

    /**
     * Method removeCityCountyStructAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct removeCityCountyStructAt(int index)
    {
        Object obj = this._cityCountyStructList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct removeCityCountyStructAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCityCountyStruct
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCityCountyStruct(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct vCityCountyStruct)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._cityCountyStructList.size()) {
            throw new IndexOutOfBoundsException("setCityCountyStruct: Index value '" + index + "' not in range [0.." + (this._cityCountyStructList.size() - 1) + "]");
        }
        
        this._cityCountyStructList.set(index, vCityCountyStruct);
    } //-- void setCityCountyStruct(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) 

    /**
     * 
     * 
     * @param vCityCountyStructArray
     */
    public void setCityCountyStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct[] vCityCountyStructArray)
    {
        //-- copy array
        _cityCountyStructList.clear();
        
        for (int i = 0; i < vCityCountyStructArray.length; i++) {
                this._cityCountyStructList.add(vCityCountyStructArray[i]);
        }
    } //-- void setCityCountyStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct) 

    /**
     * Sets the value of '_cityCountyStructList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vCityCountyStructList the Vector to copy.
     */
    public void setCityCountyStruct(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> vCityCountyStructList)
    {
        // copy vector
        this._cityCountyStructList.clear();
        
        this._cityCountyStructList.addAll(vCityCountyStructList);
    } //-- void setCityCountyStruct(java.util.List) 

    /**
     * Sets the value of '_cityCountyStructList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param CityCountyStructVector the Vector to set.
     */
    public void setCityCountyStructAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct> CityCountyStructVector)
    {
        this._cityCountyStructList = CityCountyStructVector;
    } //-- void setCityCountyStructAsReference(java.util.Vector) 

    /**
     * Sets the value of field 'ulRowQty'.
     * 
     * @param ulRowQty the value of field 'ulRowQty'.
     */
    public void setUlRowQty(int ulRowQty)
    {
        this._ulRowQty = ulRowQty;
        this._has_ulRowQty = true;
    } //-- void setUlRowQty(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct_ARRAY unmarshal(java.io.Reader) 

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
