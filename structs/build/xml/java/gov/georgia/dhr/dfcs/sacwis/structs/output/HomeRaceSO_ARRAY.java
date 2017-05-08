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
 * Class HomeRaceSO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HomeRaceSO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _homeRaceSOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> _homeRaceSOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public HomeRaceSO_ARRAY() 
     {
        super();
        this._homeRaceSOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vHomeRaceSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHomeRaceSO(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO vHomeRaceSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._homeRaceSOList.size() >= 25) {
            throw new IndexOutOfBoundsException("addHomeRaceSO has a maximum of 25");
        }
        
        this._homeRaceSOList.add(vHomeRaceSO);
    } //-- void addHomeRaceSO(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) 

    /**
     * 
     * 
     * @param index
     * @param vHomeRaceSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHomeRaceSO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO vHomeRaceSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._homeRaceSOList.size() >= 25) {
            throw new IndexOutOfBoundsException("addHomeRaceSO has a maximum of 25");
        }
        
        this._homeRaceSOList.add(index, vHomeRaceSO);
    } //-- void addHomeRaceSO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateHomeRaceSO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> enumerateHomeRaceSO()
    {
        return java.util.Collections.enumeration(this._homeRaceSOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> enumerateHomeRaceSO() 

    /**
     * Method getHomeRaceSO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO getHomeRaceSO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._homeRaceSOList.size()) {
            throw new IndexOutOfBoundsException("getHomeRaceSO: Index value '" + index + "' not in range [0.." + (this._homeRaceSOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) _homeRaceSOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO getHomeRaceSO(int) 

    /**
     * Method getHomeRaceSO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO[] getHomeRaceSO()
    {
        int size = this._homeRaceSOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) _homeRaceSOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO[] getHomeRaceSO() 

    /**
     * Method getHomeRaceSOAsReference
     * 
     * Returns a reference to '_homeRaceSOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> getHomeRaceSOAsReference()
    {
        return this._homeRaceSOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> getHomeRaceSOAsReference() 

    /**
     * Method getHomeRaceSOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getHomeRaceSOCount()
    {
        return this._homeRaceSOList.size();
    } //-- int getHomeRaceSOCount() 

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
     * Method iterateHomeRaceSO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> iterateHomeRaceSO()
    {
        return this._homeRaceSOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> iterateHomeRaceSO() 

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
    public void removeAllHomeRaceSO()
    {
        this._homeRaceSOList.clear();
    } //-- void removeAllHomeRaceSO() 

    /**
     * Method removeHomeRaceSO
     * 
     * 
     * 
     * @param vHomeRaceSO
     * @return true if the object was removed from the collection.
     */
    public boolean removeHomeRaceSO(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO vHomeRaceSO)
    {
        boolean removed = _homeRaceSOList.remove(vHomeRaceSO);
        return removed;
    } //-- boolean removeHomeRaceSO(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) 

    /**
     * Method removeHomeRaceSOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO removeHomeRaceSOAt(int index)
    {
        Object obj = this._homeRaceSOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO removeHomeRaceSOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vHomeRaceSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHomeRaceSO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO vHomeRaceSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._homeRaceSOList.size()) {
            throw new IndexOutOfBoundsException("setHomeRaceSO: Index value '" + index + "' not in range [0.." + (this._homeRaceSOList.size() - 1) + "]");
        }
        
        this._homeRaceSOList.set(index, vHomeRaceSO);
    } //-- void setHomeRaceSO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) 

    /**
     * 
     * 
     * @param vHomeRaceSOArray
     */
    public void setHomeRaceSO(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO[] vHomeRaceSOArray)
    {
        //-- copy array
        _homeRaceSOList.clear();
        
        for (int i = 0; i < vHomeRaceSOArray.length; i++) {
                this._homeRaceSOList.add(vHomeRaceSOArray[i]);
        }
    } //-- void setHomeRaceSO(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO) 

    /**
     * Sets the value of '_homeRaceSOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vHomeRaceSOList the Vector to copy.
     */
    public void setHomeRaceSO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> vHomeRaceSOList)
    {
        // copy vector
        this._homeRaceSOList.clear();
        
        this._homeRaceSOList.addAll(vHomeRaceSOList);
    } //-- void setHomeRaceSO(java.util.List) 

    /**
     * Sets the value of '_homeRaceSOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param HomeRaceSOVector the Vector to set.
     */
    public void setHomeRaceSOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO> HomeRaceSOVector)
    {
        this._homeRaceSOList = HomeRaceSOVector;
    } //-- void setHomeRaceSOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.HomeRaceSO_ARRAY unmarshal(java.io.Reader) 

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
