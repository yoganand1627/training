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
 * Class ROWCARC01SO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCARC01SO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCARC01SOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> _ROWCARC01SOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCARC01SO_ARRAY() 
     {
        super();
        this._ROWCARC01SOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCARC01SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC01SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO vROWCARC01SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC01SOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCARC01SO has a maximum of 10");
        }
        
        this._ROWCARC01SOList.add(vROWCARC01SO);
    } //-- void addROWCARC01SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC01SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCARC01SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO vROWCARC01SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCARC01SOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCARC01SO has a maximum of 10");
        }
        
        this._ROWCARC01SOList.add(index, vROWCARC01SO);
    } //-- void addROWCARC01SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCARC01SO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> enumerateROWCARC01SO()
    {
        return java.util.Collections.enumeration(this._ROWCARC01SOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> enumerateROWCARC01SO() 

    /**
     * Method getROWCARC01SO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO getROWCARC01SO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC01SOList.size()) {
            throw new IndexOutOfBoundsException("getROWCARC01SO: Index value '" + index + "' not in range [0.." + (this._ROWCARC01SOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) _ROWCARC01SOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO getROWCARC01SO(int) 

    /**
     * Method getROWCARC01SO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO[] getROWCARC01SO()
    {
        int size = this._ROWCARC01SOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) _ROWCARC01SOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO[] getROWCARC01SO() 

    /**
     * Method getROWCARC01SOAsReference
     * 
     * Returns a reference to '_ROWCARC01SOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> getROWCARC01SOAsReference()
    {
        return this._ROWCARC01SOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> getROWCARC01SOAsReference() 

    /**
     * Method getROWCARC01SOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCARC01SOCount()
    {
        return this._ROWCARC01SOList.size();
    } //-- int getROWCARC01SOCount() 

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
     * Method iterateROWCARC01SO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> iterateROWCARC01SO()
    {
        return this._ROWCARC01SOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> iterateROWCARC01SO() 

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
    public void removeAllROWCARC01SO()
    {
        this._ROWCARC01SOList.clear();
    } //-- void removeAllROWCARC01SO() 

    /**
     * Method removeROWCARC01SO
     * 
     * 
     * 
     * @param vROWCARC01SO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCARC01SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO vROWCARC01SO)
    {
        boolean removed = _ROWCARC01SOList.remove(vROWCARC01SO);
        return removed;
    } //-- boolean removeROWCARC01SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) 

    /**
     * Method removeROWCARC01SOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO removeROWCARC01SOAt(int index)
    {
        Object obj = this._ROWCARC01SOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO removeROWCARC01SOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCARC01SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCARC01SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO vROWCARC01SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCARC01SOList.size()) {
            throw new IndexOutOfBoundsException("setROWCARC01SO: Index value '" + index + "' not in range [0.." + (this._ROWCARC01SOList.size() - 1) + "]");
        }
        
        this._ROWCARC01SOList.set(index, vROWCARC01SO);
    } //-- void setROWCARC01SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) 

    /**
     * 
     * 
     * @param vROWCARC01SOArray
     */
    public void setROWCARC01SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO[] vROWCARC01SOArray)
    {
        //-- copy array
        _ROWCARC01SOList.clear();
        
        for (int i = 0; i < vROWCARC01SOArray.length; i++) {
                this._ROWCARC01SOList.add(vROWCARC01SOArray[i]);
        }
    } //-- void setROWCARC01SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO) 

    /**
     * Sets the value of '_ROWCARC01SOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCARC01SOList the Vector to copy.
     */
    public void setROWCARC01SO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> vROWCARC01SOList)
    {
        // copy vector
        this._ROWCARC01SOList.clear();
        
        this._ROWCARC01SOList.addAll(vROWCARC01SOList);
    } //-- void setROWCARC01SO(java.util.List) 

    /**
     * Sets the value of '_ROWCARC01SOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCARC01SOVector the Vector to set.
     */
    public void setROWCARC01SOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO> ROWCARC01SOVector)
    {
        this._ROWCARC01SOList = ROWCARC01SOVector;
    } //-- void setROWCARC01SOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY unmarshal(java.io.Reader) 

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
