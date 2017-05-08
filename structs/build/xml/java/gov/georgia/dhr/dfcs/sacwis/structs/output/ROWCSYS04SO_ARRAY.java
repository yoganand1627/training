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
 * Class ROWCSYS04SO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSYS04SO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSYS04SOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> _ROWCSYS04SOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSYS04SO_ARRAY() 
     {
        super();
        this._ROWCSYS04SOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSYS04SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS04SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO vROWCSYS04SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS04SOList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCSYS04SO has a maximum of 500");
        }
        
        this._ROWCSYS04SOList.add(vROWCSYS04SO);
    } //-- void addROWCSYS04SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS04SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS04SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO vROWCSYS04SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS04SOList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCSYS04SO has a maximum of 500");
        }
        
        this._ROWCSYS04SOList.add(index, vROWCSYS04SO);
    } //-- void addROWCSYS04SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSYS04SO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> enumerateROWCSYS04SO()
    {
        return java.util.Collections.enumeration(this._ROWCSYS04SOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> enumerateROWCSYS04SO() 

    /**
     * Method getROWCSYS04SO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO getROWCSYS04SO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS04SOList.size()) {
            throw new IndexOutOfBoundsException("getROWCSYS04SO: Index value '" + index + "' not in range [0.." + (this._ROWCSYS04SOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) _ROWCSYS04SOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO getROWCSYS04SO(int) 

    /**
     * Method getROWCSYS04SO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO[] getROWCSYS04SO()
    {
        int size = this._ROWCSYS04SOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) _ROWCSYS04SOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO[] getROWCSYS04SO() 

    /**
     * Method getROWCSYS04SOAsReference
     * 
     * Returns a reference to '_ROWCSYS04SOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> getROWCSYS04SOAsReference()
    {
        return this._ROWCSYS04SOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> getROWCSYS04SOAsReference() 

    /**
     * Method getROWCSYS04SOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSYS04SOCount()
    {
        return this._ROWCSYS04SOList.size();
    } //-- int getROWCSYS04SOCount() 

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
     * Method iterateROWCSYS04SO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> iterateROWCSYS04SO()
    {
        return this._ROWCSYS04SOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> iterateROWCSYS04SO() 

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
    public void removeAllROWCSYS04SO()
    {
        this._ROWCSYS04SOList.clear();
    } //-- void removeAllROWCSYS04SO() 

    /**
     * Method removeROWCSYS04SO
     * 
     * 
     * 
     * @param vROWCSYS04SO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSYS04SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO vROWCSYS04SO)
    {
        boolean removed = _ROWCSYS04SOList.remove(vROWCSYS04SO);
        return removed;
    } //-- boolean removeROWCSYS04SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) 

    /**
     * Method removeROWCSYS04SOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO removeROWCSYS04SOAt(int index)
    {
        Object obj = this._ROWCSYS04SOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO removeROWCSYS04SOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS04SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSYS04SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO vROWCSYS04SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS04SOList.size()) {
            throw new IndexOutOfBoundsException("setROWCSYS04SO: Index value '" + index + "' not in range [0.." + (this._ROWCSYS04SOList.size() - 1) + "]");
        }
        
        this._ROWCSYS04SOList.set(index, vROWCSYS04SO);
    } //-- void setROWCSYS04SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) 

    /**
     * 
     * 
     * @param vROWCSYS04SOArray
     */
    public void setROWCSYS04SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO[] vROWCSYS04SOArray)
    {
        //-- copy array
        _ROWCSYS04SOList.clear();
        
        for (int i = 0; i < vROWCSYS04SOArray.length; i++) {
                this._ROWCSYS04SOList.add(vROWCSYS04SOArray[i]);
        }
    } //-- void setROWCSYS04SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO) 

    /**
     * Sets the value of '_ROWCSYS04SOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSYS04SOList the Vector to copy.
     */
    public void setROWCSYS04SO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> vROWCSYS04SOList)
    {
        // copy vector
        this._ROWCSYS04SOList.clear();
        
        this._ROWCSYS04SOList.addAll(vROWCSYS04SOList);
    } //-- void setROWCSYS04SO(java.util.List) 

    /**
     * Sets the value of '_ROWCSYS04SOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSYS04SOVector the Vector to set.
     */
    public void setROWCSYS04SOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO> ROWCSYS04SOVector)
    {
        this._ROWCSYS04SOList = ROWCSYS04SOVector;
    } //-- void setROWCSYS04SOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY unmarshal(java.io.Reader) 

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
