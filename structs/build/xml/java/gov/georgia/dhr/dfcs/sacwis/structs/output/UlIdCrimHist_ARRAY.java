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
 * Class UlIdCrimHist_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdCrimHist_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdCrimHistList
     */
    private java.util.List<Integer> _ulIdCrimHistList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdCrimHist_ARRAY() 
     {
        super();
        this._ulIdCrimHistList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdCrimHist
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdCrimHist(int vUlIdCrimHist)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdCrimHistList.size() >= 1000) {
            throw new IndexOutOfBoundsException("addUlIdCrimHist has a maximum of 1000");
        }
        
        this._ulIdCrimHistList.add(new java.lang.Integer(vUlIdCrimHist));
    } //-- void addUlIdCrimHist(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdCrimHist
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdCrimHist(int index, int vUlIdCrimHist)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdCrimHistList.size() >= 1000) {
            throw new IndexOutOfBoundsException("addUlIdCrimHist has a maximum of 1000");
        }
        
        this._ulIdCrimHistList.add(index, new java.lang.Integer(vUlIdCrimHist));
    } //-- void addUlIdCrimHist(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdCrimHist
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdCrimHist()
    {
        return java.util.Collections.enumeration(this._ulIdCrimHistList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdCrimHist() 

    /**
     * Method getUlIdCrimHist
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdCrimHist(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdCrimHistList.size()) {
            throw new IndexOutOfBoundsException("getUlIdCrimHist: Index value '" + index + "' not in range [0.." + (this._ulIdCrimHistList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdCrimHistList.get(index)).intValue();
    } //-- int getUlIdCrimHist(int) 

    /**
     * Method getUlIdCrimHist
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdCrimHist()
    {
        int size = this._ulIdCrimHistList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdCrimHistList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdCrimHist() 

    /**
     * Method getUlIdCrimHistAsReference
     * 
     * Returns a reference to '_ulIdCrimHistList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdCrimHistAsReference()
    {
        return this._ulIdCrimHistList;
    } //-- java.util.List<Integer> getUlIdCrimHistAsReference() 

    /**
     * Method getUlIdCrimHistCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdCrimHistCount()
    {
        return this._ulIdCrimHistList.size();
    } //-- int getUlIdCrimHistCount() 

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
     * Method iterateUlIdCrimHist
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdCrimHist()
    {
        return this._ulIdCrimHistList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdCrimHist() 

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
    public void removeAllUlIdCrimHist()
    {
        this._ulIdCrimHistList.clear();
    } //-- void removeAllUlIdCrimHist() 

    /**
     * Method removeUlIdCrimHist
     * 
     * 
     * 
     * @param vUlIdCrimHist
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdCrimHist(int vUlIdCrimHist)
    {
        boolean removed = _ulIdCrimHistList.remove(new java.lang.Integer(vUlIdCrimHist));
        return removed;
    } //-- boolean removeUlIdCrimHist(int) 

    /**
     * Method removeUlIdCrimHistAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdCrimHistAt(int index)
    {
        Object obj = this._ulIdCrimHistList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdCrimHistAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdCrimHist
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdCrimHist(int index, int vUlIdCrimHist)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdCrimHistList.size()) {
            throw new IndexOutOfBoundsException("setUlIdCrimHist: Index value '" + index + "' not in range [0.." + (this._ulIdCrimHistList.size() - 1) + "]");
        }
        
        this._ulIdCrimHistList.set(index, new java.lang.Integer(vUlIdCrimHist));
    } //-- void setUlIdCrimHist(int, int) 

    /**
     * 
     * 
     * @param vUlIdCrimHistArray
     */
    public void setUlIdCrimHist(int[] vUlIdCrimHistArray)
    {
        //-- copy array
        _ulIdCrimHistList.clear();
        
        for (int i = 0; i < vUlIdCrimHistArray.length; i++) {
                this._ulIdCrimHistList.add(new java.lang.Integer(vUlIdCrimHistArray[i]));
        }
    } //-- void setUlIdCrimHist(int) 

    /**
     * Sets the value of '_ulIdCrimHistList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdCrimHistList the Vector to copy.
     */
    public void setUlIdCrimHist(java.util.List<Integer> vUlIdCrimHistList)
    {
        // copy vector
        this._ulIdCrimHistList.clear();
        
        this._ulIdCrimHistList.addAll(vUlIdCrimHistList);
    } //-- void setUlIdCrimHist(java.util.List) 

    /**
     * Sets the value of '_ulIdCrimHistList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdCrimHistVector the Vector to set.
     */
    public void setUlIdCrimHistAsReference(java.util.Vector<Integer> UlIdCrimHistVector)
    {
        this._ulIdCrimHistList = UlIdCrimHistVector;
    } //-- void setUlIdCrimHistAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdCrimHist_ARRAY unmarshal(java.io.Reader) 

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
