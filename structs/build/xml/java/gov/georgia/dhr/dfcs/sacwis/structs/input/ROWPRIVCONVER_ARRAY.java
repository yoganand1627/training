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
 * Class ROWPRIVCONVER_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWPRIVCONVER_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWPRIVCONVERList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> _ROWPRIVCONVERList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWPRIVCONVER_ARRAY() 
     {
        super();
        this._ROWPRIVCONVERList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWPRIVCONVER
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER vROWPRIVCONVER)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWPRIVCONVERList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWPRIVCONVER has a maximum of 50");
        }
        
        this._ROWPRIVCONVERList.add(vROWPRIVCONVER);
    } //-- void addROWPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) 

    /**
     * 
     * 
     * @param index
     * @param vROWPRIVCONVER
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWPRIVCONVER(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER vROWPRIVCONVER)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWPRIVCONVERList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWPRIVCONVER has a maximum of 50");
        }
        
        this._ROWPRIVCONVERList.add(index, vROWPRIVCONVER);
    } //-- void addROWPRIVCONVER(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWPRIVCONVER
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> enumerateROWPRIVCONVER()
    {
        return java.util.Collections.enumeration(this._ROWPRIVCONVERList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> enumerateROWPRIVCONVER() 

    /**
     * Method getROWPRIVCONVER
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER getROWPRIVCONVER(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWPRIVCONVERList.size()) {
            throw new IndexOutOfBoundsException("getROWPRIVCONVER: Index value '" + index + "' not in range [0.." + (this._ROWPRIVCONVERList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) _ROWPRIVCONVERList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER getROWPRIVCONVER(int) 

    /**
     * Method getROWPRIVCONVER
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER[] getROWPRIVCONVER()
    {
        int size = this._ROWPRIVCONVERList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) _ROWPRIVCONVERList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER[] getROWPRIVCONVER() 

    /**
     * Method getROWPRIVCONVERAsReference
     * 
     * Returns a reference to '_ROWPRIVCONVERList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> getROWPRIVCONVERAsReference()
    {
        return this._ROWPRIVCONVERList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> getROWPRIVCONVERAsReference() 

    /**
     * Method getROWPRIVCONVERCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWPRIVCONVERCount()
    {
        return this._ROWPRIVCONVERList.size();
    } //-- int getROWPRIVCONVERCount() 

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
     * Method iterateROWPRIVCONVER
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> iterateROWPRIVCONVER()
    {
        return this._ROWPRIVCONVERList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> iterateROWPRIVCONVER() 

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
    public void removeAllROWPRIVCONVER()
    {
        this._ROWPRIVCONVERList.clear();
    } //-- void removeAllROWPRIVCONVER() 

    /**
     * Method removeROWPRIVCONVER
     * 
     * 
     * 
     * @param vROWPRIVCONVER
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER vROWPRIVCONVER)
    {
        boolean removed = _ROWPRIVCONVERList.remove(vROWPRIVCONVER);
        return removed;
    } //-- boolean removeROWPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) 

    /**
     * Method removeROWPRIVCONVERAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER removeROWPRIVCONVERAt(int index)
    {
        Object obj = this._ROWPRIVCONVERList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER removeROWPRIVCONVERAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWPRIVCONVER
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWPRIVCONVER(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER vROWPRIVCONVER)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWPRIVCONVERList.size()) {
            throw new IndexOutOfBoundsException("setROWPRIVCONVER: Index value '" + index + "' not in range [0.." + (this._ROWPRIVCONVERList.size() - 1) + "]");
        }
        
        this._ROWPRIVCONVERList.set(index, vROWPRIVCONVER);
    } //-- void setROWPRIVCONVER(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) 

    /**
     * 
     * 
     * @param vROWPRIVCONVERArray
     */
    public void setROWPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER[] vROWPRIVCONVERArray)
    {
        //-- copy array
        _ROWPRIVCONVERList.clear();
        
        for (int i = 0; i < vROWPRIVCONVERArray.length; i++) {
                this._ROWPRIVCONVERList.add(vROWPRIVCONVERArray[i]);
        }
    } //-- void setROWPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER) 

    /**
     * Sets the value of '_ROWPRIVCONVERList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWPRIVCONVERList the Vector to copy.
     */
    public void setROWPRIVCONVER(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> vROWPRIVCONVERList)
    {
        // copy vector
        this._ROWPRIVCONVERList.clear();
        
        this._ROWPRIVCONVERList.addAll(vROWPRIVCONVERList);
    } //-- void setROWPRIVCONVER(java.util.List) 

    /**
     * Sets the value of '_ROWPRIVCONVERList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWPRIVCONVERVector the Vector to set.
     */
    public void setROWPRIVCONVERAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER> ROWPRIVCONVERVector)
    {
        this._ROWPRIVCONVERList = ROWPRIVCONVERVector;
    } //-- void setROWPRIVCONVERAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY unmarshal(java.io.Reader) 

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
