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
 * Class HomeRaceSI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HomeRaceSI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _homeRaceSIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> _homeRaceSIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public HomeRaceSI_ARRAY() 
     {
        super();
        this._homeRaceSIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vHomeRaceSI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHomeRaceSI(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI vHomeRaceSI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._homeRaceSIList.size() >= 25) {
            throw new IndexOutOfBoundsException("addHomeRaceSI has a maximum of 25");
        }
        
        this._homeRaceSIList.add(vHomeRaceSI);
    } //-- void addHomeRaceSI(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) 

    /**
     * 
     * 
     * @param index
     * @param vHomeRaceSI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHomeRaceSI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI vHomeRaceSI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._homeRaceSIList.size() >= 25) {
            throw new IndexOutOfBoundsException("addHomeRaceSI has a maximum of 25");
        }
        
        this._homeRaceSIList.add(index, vHomeRaceSI);
    } //-- void addHomeRaceSI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateHomeRaceSI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> enumerateHomeRaceSI()
    {
        return java.util.Collections.enumeration(this._homeRaceSIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> enumerateHomeRaceSI() 

    /**
     * Method getHomeRaceSI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI getHomeRaceSI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._homeRaceSIList.size()) {
            throw new IndexOutOfBoundsException("getHomeRaceSI: Index value '" + index + "' not in range [0.." + (this._homeRaceSIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) _homeRaceSIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI getHomeRaceSI(int) 

    /**
     * Method getHomeRaceSI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI[] getHomeRaceSI()
    {
        int size = this._homeRaceSIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) _homeRaceSIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI[] getHomeRaceSI() 

    /**
     * Method getHomeRaceSIAsReference
     * 
     * Returns a reference to '_homeRaceSIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> getHomeRaceSIAsReference()
    {
        return this._homeRaceSIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> getHomeRaceSIAsReference() 

    /**
     * Method getHomeRaceSICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getHomeRaceSICount()
    {
        return this._homeRaceSIList.size();
    } //-- int getHomeRaceSICount() 

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
     * Method iterateHomeRaceSI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> iterateHomeRaceSI()
    {
        return this._homeRaceSIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> iterateHomeRaceSI() 

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
    public void removeAllHomeRaceSI()
    {
        this._homeRaceSIList.clear();
    } //-- void removeAllHomeRaceSI() 

    /**
     * Method removeHomeRaceSI
     * 
     * 
     * 
     * @param vHomeRaceSI
     * @return true if the object was removed from the collection.
     */
    public boolean removeHomeRaceSI(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI vHomeRaceSI)
    {
        boolean removed = _homeRaceSIList.remove(vHomeRaceSI);
        return removed;
    } //-- boolean removeHomeRaceSI(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) 

    /**
     * Method removeHomeRaceSIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI removeHomeRaceSIAt(int index)
    {
        Object obj = this._homeRaceSIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI removeHomeRaceSIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vHomeRaceSI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHomeRaceSI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI vHomeRaceSI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._homeRaceSIList.size()) {
            throw new IndexOutOfBoundsException("setHomeRaceSI: Index value '" + index + "' not in range [0.." + (this._homeRaceSIList.size() - 1) + "]");
        }
        
        this._homeRaceSIList.set(index, vHomeRaceSI);
    } //-- void setHomeRaceSI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) 

    /**
     * 
     * 
     * @param vHomeRaceSIArray
     */
    public void setHomeRaceSI(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI[] vHomeRaceSIArray)
    {
        //-- copy array
        _homeRaceSIList.clear();
        
        for (int i = 0; i < vHomeRaceSIArray.length; i++) {
                this._homeRaceSIList.add(vHomeRaceSIArray[i]);
        }
    } //-- void setHomeRaceSI(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI) 

    /**
     * Sets the value of '_homeRaceSIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vHomeRaceSIList the Vector to copy.
     */
    public void setHomeRaceSI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> vHomeRaceSIList)
    {
        // copy vector
        this._homeRaceSIList.clear();
        
        this._homeRaceSIList.addAll(vHomeRaceSIList);
    } //-- void setHomeRaceSI(java.util.List) 

    /**
     * Sets the value of '_homeRaceSIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param HomeRaceSIVector the Vector to set.
     */
    public void setHomeRaceSIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI> HomeRaceSIVector)
    {
        this._homeRaceSIList = HomeRaceSIVector;
    } //-- void setHomeRaceSIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.HomeRaceSI_ARRAY unmarshal(java.io.Reader) 

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
