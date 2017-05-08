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
 * Class ROWDELETEDISCUSSED_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWDELETEDISCUSSED_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWDELETEDISCUSSEDList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> _ROWDELETEDISCUSSEDList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWDELETEDISCUSSED_ARRAY() 
     {
        super();
        this._ROWDELETEDISCUSSEDList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWDELETEDISCUSSED
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDELETEDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED vROWDELETEDISCUSSED)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDELETEDISCUSSEDList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDELETEDISCUSSED has a maximum of 50");
        }
        
        this._ROWDELETEDISCUSSEDList.add(vROWDELETEDISCUSSED);
    } //-- void addROWDELETEDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) 

    /**
     * 
     * 
     * @param index
     * @param vROWDELETEDISCUSSED
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDELETEDISCUSSED(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED vROWDELETEDISCUSSED)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDELETEDISCUSSEDList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDELETEDISCUSSED has a maximum of 50");
        }
        
        this._ROWDELETEDISCUSSEDList.add(index, vROWDELETEDISCUSSED);
    } //-- void addROWDELETEDISCUSSED(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWDELETEDISCUSSED
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> enumerateROWDELETEDISCUSSED()
    {
        return java.util.Collections.enumeration(this._ROWDELETEDISCUSSEDList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> enumerateROWDELETEDISCUSSED() 

    /**
     * Method getROWDELETEDISCUSSED
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED getROWDELETEDISCUSSED(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDELETEDISCUSSEDList.size()) {
            throw new IndexOutOfBoundsException("getROWDELETEDISCUSSED: Index value '" + index + "' not in range [0.." + (this._ROWDELETEDISCUSSEDList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) _ROWDELETEDISCUSSEDList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED getROWDELETEDISCUSSED(int) 

    /**
     * Method getROWDELETEDISCUSSED
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED[] getROWDELETEDISCUSSED()
    {
        int size = this._ROWDELETEDISCUSSEDList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) _ROWDELETEDISCUSSEDList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED[] getROWDELETEDISCUSSED() 

    /**
     * Method getROWDELETEDISCUSSEDAsReference
     * 
     * Returns a reference to '_ROWDELETEDISCUSSEDList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> getROWDELETEDISCUSSEDAsReference()
    {
        return this._ROWDELETEDISCUSSEDList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> getROWDELETEDISCUSSEDAsReference() 

    /**
     * Method getROWDELETEDISCUSSEDCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWDELETEDISCUSSEDCount()
    {
        return this._ROWDELETEDISCUSSEDList.size();
    } //-- int getROWDELETEDISCUSSEDCount() 

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
     * Method iterateROWDELETEDISCUSSED
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> iterateROWDELETEDISCUSSED()
    {
        return this._ROWDELETEDISCUSSEDList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> iterateROWDELETEDISCUSSED() 

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
    public void removeAllROWDELETEDISCUSSED()
    {
        this._ROWDELETEDISCUSSEDList.clear();
    } //-- void removeAllROWDELETEDISCUSSED() 

    /**
     * Method removeROWDELETEDISCUSSED
     * 
     * 
     * 
     * @param vROWDELETEDISCUSSED
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWDELETEDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED vROWDELETEDISCUSSED)
    {
        boolean removed = _ROWDELETEDISCUSSEDList.remove(vROWDELETEDISCUSSED);
        return removed;
    } //-- boolean removeROWDELETEDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) 

    /**
     * Method removeROWDELETEDISCUSSEDAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED removeROWDELETEDISCUSSEDAt(int index)
    {
        Object obj = this._ROWDELETEDISCUSSEDList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED removeROWDELETEDISCUSSEDAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWDELETEDISCUSSED
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWDELETEDISCUSSED(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED vROWDELETEDISCUSSED)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDELETEDISCUSSEDList.size()) {
            throw new IndexOutOfBoundsException("setROWDELETEDISCUSSED: Index value '" + index + "' not in range [0.." + (this._ROWDELETEDISCUSSEDList.size() - 1) + "]");
        }
        
        this._ROWDELETEDISCUSSEDList.set(index, vROWDELETEDISCUSSED);
    } //-- void setROWDELETEDISCUSSED(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) 

    /**
     * 
     * 
     * @param vROWDELETEDISCUSSEDArray
     */
    public void setROWDELETEDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED[] vROWDELETEDISCUSSEDArray)
    {
        //-- copy array
        _ROWDELETEDISCUSSEDList.clear();
        
        for (int i = 0; i < vROWDELETEDISCUSSEDArray.length; i++) {
                this._ROWDELETEDISCUSSEDList.add(vROWDELETEDISCUSSEDArray[i]);
        }
    } //-- void setROWDELETEDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED) 

    /**
     * Sets the value of '_ROWDELETEDISCUSSEDList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vROWDELETEDISCUSSEDList the Vector to copy.
     */
    public void setROWDELETEDISCUSSED(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> vROWDELETEDISCUSSEDList)
    {
        // copy vector
        this._ROWDELETEDISCUSSEDList.clear();
        
        this._ROWDELETEDISCUSSEDList.addAll(vROWDELETEDISCUSSEDList);
    } //-- void setROWDELETEDISCUSSED(java.util.List) 

    /**
     * Sets the value of '_ROWDELETEDISCUSSEDList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param ROWDELETEDISCUSSEDVector the Vector to set.
     */
    public void setROWDELETEDISCUSSEDAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED> ROWDELETEDISCUSSEDVector)
    {
        this._ROWDELETEDISCUSSEDList = ROWDELETEDISCUSSEDVector;
    } //-- void setROWDELETEDISCUSSEDAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY unmarshal(java.io.Reader) 

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
