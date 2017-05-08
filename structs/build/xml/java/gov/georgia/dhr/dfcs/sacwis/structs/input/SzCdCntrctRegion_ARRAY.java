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
 * Class SzCdCntrctRegion_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdCntrctRegion_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdCntrctRegionList
     */
    private java.util.List<java.lang.String> _szCdCntrctRegionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdCntrctRegion_ARRAY() 
     {
        super();
        this._szCdCntrctRegionList = new java.util.ArrayList<java.lang.String>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCntrctRegion_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdCntrctRegion
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCntrctRegion(java.lang.String vSzCdCntrctRegion)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCntrctRegionList.size() >= 20) {
            throw new IndexOutOfBoundsException("addSzCdCntrctRegion has a maximum of 20");
        }
        
        this._szCdCntrctRegionList.add(vSzCdCntrctRegion);
    } //-- void addSzCdCntrctRegion(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCntrctRegion
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdCntrctRegion(int index, java.lang.String vSzCdCntrctRegion)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdCntrctRegionList.size() >= 20) {
            throw new IndexOutOfBoundsException("addSzCdCntrctRegion has a maximum of 20");
        }
        
        this._szCdCntrctRegionList.add(index, vSzCdCntrctRegion);
    } //-- void addSzCdCntrctRegion(int, java.lang.String) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdCntrctRegion
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.lang.String> enumerateSzCdCntrctRegion()
    {
        return java.util.Collections.enumeration(this._szCdCntrctRegionList);
    } //-- java.util.Enumeration<java.lang.String> enumerateSzCdCntrctRegion() 

    /**
     * Method getSzCdCntrctRegion
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getSzCdCntrctRegion(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCntrctRegionList.size()) {
            throw new IndexOutOfBoundsException("getSzCdCntrctRegion: Index value '" + index + "' not in range [0.." + (this._szCdCntrctRegionList.size() - 1) + "]");
        }
        
        return (String)_szCdCntrctRegionList.get(index);
    } //-- java.lang.String getSzCdCntrctRegion(int) 

    /**
     * Method getSzCdCntrctRegion
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getSzCdCntrctRegion()
    {
        int size = this._szCdCntrctRegionList.size();
        java.lang.String[] array = new java.lang.String[size];
        for (int index = 0; index < size; index++){
            array[index] = (String)_szCdCntrctRegionList.get(index);
        }
        
        return array;
    } //-- java.lang.String[] getSzCdCntrctRegion() 

    /**
     * Method getSzCdCntrctRegionAsReference
     * 
     * Returns a reference to '_szCdCntrctRegionList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.lang.String> getSzCdCntrctRegionAsReference()
    {
        return this._szCdCntrctRegionList;
    } //-- java.util.List<java.lang.String> getSzCdCntrctRegionAsReference() 

    /**
     * Method getSzCdCntrctRegionCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdCntrctRegionCount()
    {
        return this._szCdCntrctRegionList.size();
    } //-- int getSzCdCntrctRegionCount() 

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
     * Method iterateSzCdCntrctRegion
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.lang.String> iterateSzCdCntrctRegion()
    {
        return this._szCdCntrctRegionList.iterator();
    } //-- java.util.Iterator<java.lang.String> iterateSzCdCntrctRegion() 

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
    public void removeAllSzCdCntrctRegion()
    {
        this._szCdCntrctRegionList.clear();
    } //-- void removeAllSzCdCntrctRegion() 

    /**
     * Method removeSzCdCntrctRegion
     * 
     * 
     * 
     * @param vSzCdCntrctRegion
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdCntrctRegion(java.lang.String vSzCdCntrctRegion)
    {
        boolean removed = _szCdCntrctRegionList.remove(vSzCdCntrctRegion);
        return removed;
    } //-- boolean removeSzCdCntrctRegion(java.lang.String) 

    /**
     * Method removeSzCdCntrctRegionAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeSzCdCntrctRegionAt(int index)
    {
        Object obj = this._szCdCntrctRegionList.remove(index);
        return (String)obj;
    } //-- java.lang.String removeSzCdCntrctRegionAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdCntrctRegion
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdCntrctRegion(int index, java.lang.String vSzCdCntrctRegion)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdCntrctRegionList.size()) {
            throw new IndexOutOfBoundsException("setSzCdCntrctRegion: Index value '" + index + "' not in range [0.." + (this._szCdCntrctRegionList.size() - 1) + "]");
        }
        
        this._szCdCntrctRegionList.set(index, vSzCdCntrctRegion);
    } //-- void setSzCdCntrctRegion(int, java.lang.String) 

    /**
     * 
     * 
     * @param vSzCdCntrctRegionArray
     */
    public void setSzCdCntrctRegion(java.lang.String[] vSzCdCntrctRegionArray)
    {
        //-- copy array
        _szCdCntrctRegionList.clear();
        
        for (int i = 0; i < vSzCdCntrctRegionArray.length; i++) {
                this._szCdCntrctRegionList.add(vSzCdCntrctRegionArray[i]);
        }
    } //-- void setSzCdCntrctRegion(java.lang.String) 

    /**
     * Sets the value of '_szCdCntrctRegionList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdCntrctRegionList the Vector to copy.
     */
    public void setSzCdCntrctRegion(java.util.List<java.lang.String> vSzCdCntrctRegionList)
    {
        // copy vector
        this._szCdCntrctRegionList.clear();
        
        this._szCdCntrctRegionList.addAll(vSzCdCntrctRegionList);
    } //-- void setSzCdCntrctRegion(java.util.List) 

    /**
     * Sets the value of '_szCdCntrctRegionList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdCntrctRegionVector the Vector to set.
     */
    public void setSzCdCntrctRegionAsReference(java.util.Vector<java.lang.String> SzCdCntrctRegionVector)
    {
        this._szCdCntrctRegionList = SzCdCntrctRegionVector;
    } //-- void setSzCdCntrctRegionAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCntrctRegion_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCntrctRegion_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCntrctRegion_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCntrctRegion_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCntrctRegion_ARRAY unmarshal(java.io.Reader) 

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
