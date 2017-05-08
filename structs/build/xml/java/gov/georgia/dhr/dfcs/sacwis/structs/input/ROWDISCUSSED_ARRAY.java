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
 * Class ROWDISCUSSED_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWDISCUSSED_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWDISCUSSEDList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> _ROWDISCUSSEDList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWDISCUSSED_ARRAY() 
     {
        super();
        this._ROWDISCUSSEDList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWDISCUSSED
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED vROWDISCUSSED)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDISCUSSEDList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDISCUSSED has a maximum of 50");
        }
        
        this._ROWDISCUSSEDList.add(vROWDISCUSSED);
    } //-- void addROWDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) 

    /**
     * 
     * 
     * @param index
     * @param vROWDISCUSSED
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDISCUSSED(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED vROWDISCUSSED)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDISCUSSEDList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDISCUSSED has a maximum of 50");
        }
        
        this._ROWDISCUSSEDList.add(index, vROWDISCUSSED);
    } //-- void addROWDISCUSSED(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWDISCUSSED
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> enumerateROWDISCUSSED()
    {
        return java.util.Collections.enumeration(this._ROWDISCUSSEDList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> enumerateROWDISCUSSED() 

    /**
     * Method getROWDISCUSSED
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED getROWDISCUSSED(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDISCUSSEDList.size()) {
            throw new IndexOutOfBoundsException("getROWDISCUSSED: Index value '" + index + "' not in range [0.." + (this._ROWDISCUSSEDList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) _ROWDISCUSSEDList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED getROWDISCUSSED(int) 

    /**
     * Method getROWDISCUSSED
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED[] getROWDISCUSSED()
    {
        int size = this._ROWDISCUSSEDList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) _ROWDISCUSSEDList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED[] getROWDISCUSSED() 

    /**
     * Method getROWDISCUSSEDAsReference
     * 
     * Returns a reference to '_ROWDISCUSSEDList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> getROWDISCUSSEDAsReference()
    {
        return this._ROWDISCUSSEDList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> getROWDISCUSSEDAsReference() 

    /**
     * Method getROWDISCUSSEDCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWDISCUSSEDCount()
    {
        return this._ROWDISCUSSEDList.size();
    } //-- int getROWDISCUSSEDCount() 

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
     * Method iterateROWDISCUSSED
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> iterateROWDISCUSSED()
    {
        return this._ROWDISCUSSEDList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> iterateROWDISCUSSED() 

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
    public void removeAllROWDISCUSSED()
    {
        this._ROWDISCUSSEDList.clear();
    } //-- void removeAllROWDISCUSSED() 

    /**
     * Method removeROWDISCUSSED
     * 
     * 
     * 
     * @param vROWDISCUSSED
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED vROWDISCUSSED)
    {
        boolean removed = _ROWDISCUSSEDList.remove(vROWDISCUSSED);
        return removed;
    } //-- boolean removeROWDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) 

    /**
     * Method removeROWDISCUSSEDAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED removeROWDISCUSSEDAt(int index)
    {
        Object obj = this._ROWDISCUSSEDList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED removeROWDISCUSSEDAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWDISCUSSED
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWDISCUSSED(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED vROWDISCUSSED)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDISCUSSEDList.size()) {
            throw new IndexOutOfBoundsException("setROWDISCUSSED: Index value '" + index + "' not in range [0.." + (this._ROWDISCUSSEDList.size() - 1) + "]");
        }
        
        this._ROWDISCUSSEDList.set(index, vROWDISCUSSED);
    } //-- void setROWDISCUSSED(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) 

    /**
     * 
     * 
     * @param vROWDISCUSSEDArray
     */
    public void setROWDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED[] vROWDISCUSSEDArray)
    {
        //-- copy array
        _ROWDISCUSSEDList.clear();
        
        for (int i = 0; i < vROWDISCUSSEDArray.length; i++) {
                this._ROWDISCUSSEDList.add(vROWDISCUSSEDArray[i]);
        }
    } //-- void setROWDISCUSSED(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED) 

    /**
     * Sets the value of '_ROWDISCUSSEDList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWDISCUSSEDList the Vector to copy.
     */
    public void setROWDISCUSSED(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> vROWDISCUSSEDList)
    {
        // copy vector
        this._ROWDISCUSSEDList.clear();
        
        this._ROWDISCUSSEDList.addAll(vROWDISCUSSEDList);
    } //-- void setROWDISCUSSED(java.util.List) 

    /**
     * Sets the value of '_ROWDISCUSSEDList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWDISCUSSEDVector the Vector to set.
     */
    public void setROWDISCUSSEDAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED> ROWDISCUSSEDVector)
    {
        this._ROWDISCUSSEDList = ROWDISCUSSEDVector;
    } //-- void setROWDISCUSSEDAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY unmarshal(java.io.Reader) 

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
