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
 * Class ROWCSYS08SO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSYS08SO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSYS08SOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> _ROWCSYS08SOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSYS08SO_ARRAY() 
     {
        super();
        this._ROWCSYS08SOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSYS08SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS08SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO vROWCSYS08SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS08SOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS08SO has a maximum of 50");
        }
        
        this._ROWCSYS08SOList.add(vROWCSYS08SO);
    } //-- void addROWCSYS08SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS08SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS08SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO vROWCSYS08SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS08SOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS08SO has a maximum of 50");
        }
        
        this._ROWCSYS08SOList.add(index, vROWCSYS08SO);
    } //-- void addROWCSYS08SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSYS08SO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> enumerateROWCSYS08SO()
    {
        return java.util.Collections.enumeration(this._ROWCSYS08SOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> enumerateROWCSYS08SO() 

    /**
     * Method getROWCSYS08SO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO getROWCSYS08SO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS08SOList.size()) {
            throw new IndexOutOfBoundsException("getROWCSYS08SO: Index value '" + index + "' not in range [0.." + (this._ROWCSYS08SOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) _ROWCSYS08SOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO getROWCSYS08SO(int) 

    /**
     * Method getROWCSYS08SO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO[] getROWCSYS08SO()
    {
        int size = this._ROWCSYS08SOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) _ROWCSYS08SOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO[] getROWCSYS08SO() 

    /**
     * Method getROWCSYS08SOAsReference
     * 
     * Returns a reference to '_ROWCSYS08SOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> getROWCSYS08SOAsReference()
    {
        return this._ROWCSYS08SOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> getROWCSYS08SOAsReference() 

    /**
     * Method getROWCSYS08SOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSYS08SOCount()
    {
        return this._ROWCSYS08SOList.size();
    } //-- int getROWCSYS08SOCount() 

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
     * Method iterateROWCSYS08SO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> iterateROWCSYS08SO()
    {
        return this._ROWCSYS08SOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> iterateROWCSYS08SO() 

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
    public void removeAllROWCSYS08SO()
    {
        this._ROWCSYS08SOList.clear();
    } //-- void removeAllROWCSYS08SO() 

    /**
     * Method removeROWCSYS08SO
     * 
     * 
     * 
     * @param vROWCSYS08SO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSYS08SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO vROWCSYS08SO)
    {
        boolean removed = _ROWCSYS08SOList.remove(vROWCSYS08SO);
        return removed;
    } //-- boolean removeROWCSYS08SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) 

    /**
     * Method removeROWCSYS08SOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO removeROWCSYS08SOAt(int index)
    {
        Object obj = this._ROWCSYS08SOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO removeROWCSYS08SOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS08SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSYS08SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO vROWCSYS08SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS08SOList.size()) {
            throw new IndexOutOfBoundsException("setROWCSYS08SO: Index value '" + index + "' not in range [0.." + (this._ROWCSYS08SOList.size() - 1) + "]");
        }
        
        this._ROWCSYS08SOList.set(index, vROWCSYS08SO);
    } //-- void setROWCSYS08SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) 

    /**
     * 
     * 
     * @param vROWCSYS08SOArray
     */
    public void setROWCSYS08SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO[] vROWCSYS08SOArray)
    {
        //-- copy array
        _ROWCSYS08SOList.clear();
        
        for (int i = 0; i < vROWCSYS08SOArray.length; i++) {
                this._ROWCSYS08SOList.add(vROWCSYS08SOArray[i]);
        }
    } //-- void setROWCSYS08SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO) 

    /**
     * Sets the value of '_ROWCSYS08SOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSYS08SOList the Vector to copy.
     */
    public void setROWCSYS08SO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> vROWCSYS08SOList)
    {
        // copy vector
        this._ROWCSYS08SOList.clear();
        
        this._ROWCSYS08SOList.addAll(vROWCSYS08SOList);
    } //-- void setROWCSYS08SO(java.util.List) 

    /**
     * Sets the value of '_ROWCSYS08SOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSYS08SOVector the Vector to set.
     */
    public void setROWCSYS08SOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO> ROWCSYS08SOVector)
    {
        this._ROWCSYS08SOList = ROWCSYS08SOVector;
    } //-- void setROWCSYS08SOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY unmarshal(java.io.Reader) 

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
