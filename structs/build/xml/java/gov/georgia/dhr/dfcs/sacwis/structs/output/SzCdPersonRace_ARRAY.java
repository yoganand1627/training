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
 * Class SzCdPersonRace_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdPersonRace_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdPersonRaceList
     */
    private java.util.List<java.lang.String> _szCdPersonRaceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdPersonRace_ARRAY() 
     {
        super();
        this._szCdPersonRaceList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonRace_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdPersonRace
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdPersonRace(java.lang.String vSzCdPersonRace)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdPersonRaceList.size() >= 10) {
            throw new IndexOutOfBoundsException("addSzCdPersonRace has a maximum of 10");
        }
        
        this._szCdPersonRaceList.add(vSzCdPersonRace);
    } //-- void addSzCdPersonRace(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdPersonRace
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdPersonRace(int index, java.lang.String vSzCdPersonRace)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdPersonRaceList.size() >= 10) {
            throw new IndexOutOfBoundsException("addSzCdPersonRace has a maximum of 10");
        }
        
        this._szCdPersonRaceList.add(index, vSzCdPersonRace);
    } //-- void addSzCdPersonRace(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdPersonRace
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdPersonRace()
    {
        return java.util.Collections.enumeration(this._szCdPersonRaceList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdPersonRace() 

    /**
     * Method getSzCdPersonRace
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdPersonRace(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdPersonRaceList.size()) {
            throw new IndexOutOfBoundsException("getSzCdPersonRace: Index value '" + index + "' not in range [0.." + (this._szCdPersonRaceList.size() - 1) + "]");
        }
        
        return (String)_szCdPersonRaceList.get(index);
    } //-- java.lang.String getSzCdPersonRace(int) 

    /**
     * Method getSzCdPersonRace
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdPersonRace()
    {
        int size = this._szCdPersonRaceList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdPersonRaceList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdPersonRace() 

    /**
     * Method getSzCdPersonRaceAsReference
     * 
     * Returns a reference to '_szCdPersonRaceList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdPersonRaceAsReference()
    {
        return this._szCdPersonRaceList;
    } //-- java.util.List<java.lang.String> getSzCdPersonRaceAsReference() 

    /**
     * Method getSzCdPersonRaceCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdPersonRaceCount()
    {
        return this._szCdPersonRaceList.size();
    } //-- int getSzCdPersonRaceCount() 

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
     * Method iterateSzCdPersonRace
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdPersonRace()
    {
        return this._szCdPersonRaceList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdPersonRace() 

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
    public void removeAllSzCdPersonRace()
    {
        this._szCdPersonRaceList.clear();
    } //-- void removeAllSzCdPersonRace() 

    /**
     * Method removeSzCdPersonRace
     * 
     * 
     * 
     * @param vSzCdPersonRace
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdPersonRace(java.lang.String vSzCdPersonRace)
    {
        boolean removed = _szCdPersonRaceList.remove(vSzCdPersonRace);
        return removed;
    } //-- boolean removeSzCdPersonRace(java.lang.String) 

    /**
     * Method removeSzCdPersonRaceAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdPersonRaceAt(int index)
    {
        Object obj = this._szCdPersonRaceList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdPersonRaceAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdPersonRace
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdPersonRace(int index, java.lang.String vSzCdPersonRace)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdPersonRaceList.size()) {
            throw new IndexOutOfBoundsException("setSzCdPersonRace: Index value '" + index + "' not in range [0.." + (this._szCdPersonRaceList.size() - 1) + "]");
        }
        
        this._szCdPersonRaceList.set(index, vSzCdPersonRace);
    } //-- void setSzCdPersonRace(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdPersonRaceArray
     */
    public void setSzCdPersonRace(java.lang.String[] vSzCdPersonRaceArray)
    {
        //-- copy array
        _szCdPersonRaceList.clear();
        
        for (int i = 0; i < vSzCdPersonRaceArray.length; i++) {
                this._szCdPersonRaceList.add(vSzCdPersonRaceArray[i]);
        }
    } //-- void setSzCdPersonRace(java.lang.String) 

    /**
     * Sets the value of '_szCdPersonRaceList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdPersonRaceList the Vector to copy.
     */
    public void setSzCdPersonRace(java.util.List<java.lang.String> vSzCdPersonRaceList)
    {
        // copy vector
        this._szCdPersonRaceList.clear();
        
        this._szCdPersonRaceList.addAll(vSzCdPersonRaceList);
    } //-- void setSzCdPersonRace(java.util.List) 

    /**
     * Sets the value of '_szCdPersonRaceList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param SzCdPersonRaceVector the Vector to set.
     */
    public void setSzCdPersonRaceAsReference(java.util.Vector<java.lang.String> SzCdPersonRaceVector)
    {
        this._szCdPersonRaceList = SzCdPersonRaceVector;
    } //-- void setSzCdPersonRaceAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonRace_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonRace_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonRace_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonRace_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPersonRace_ARRAY unmarshal(java.io.Reader) 

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
