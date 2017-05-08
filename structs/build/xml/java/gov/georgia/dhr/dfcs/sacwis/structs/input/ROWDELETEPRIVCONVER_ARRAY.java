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
 * Class ROWDELETEPRIVCONVER_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWDELETEPRIVCONVER_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWDELETEPRIVCONVERList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> _ROWDELETEPRIVCONVERList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWDELETEPRIVCONVER_ARRAY() 
     {
        super();
        this._ROWDELETEPRIVCONVERList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWDELETEPRIVCONVER
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDELETEPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER vROWDELETEPRIVCONVER)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDELETEPRIVCONVERList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDELETEPRIVCONVER has a maximum of 50");
        }
        
        this._ROWDELETEPRIVCONVERList.add(vROWDELETEPRIVCONVER);
    } //-- void addROWDELETEPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) 

    /**
     * 
     * 
     * @param index
     * @param vROWDELETEPRIVCONVER
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDELETEPRIVCONVER(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER vROWDELETEPRIVCONVER)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDELETEPRIVCONVERList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDELETEPRIVCONVER has a maximum of 50");
        }
        
        this._ROWDELETEPRIVCONVERList.add(index, vROWDELETEPRIVCONVER);
    } //-- void addROWDELETEPRIVCONVER(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWDELETEPRIVCONVER
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> enumerateROWDELETEPRIVCONVER()
    {
        return java.util.Collections.enumeration(this._ROWDELETEPRIVCONVERList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> enumerateROWDELETEPRIVCONVER() 

    /**
     * Method getROWDELETEPRIVCONVER
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER getROWDELETEPRIVCONVER(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDELETEPRIVCONVERList.size()) {
            throw new IndexOutOfBoundsException("getROWDELETEPRIVCONVER: Index value '" + index + "' not in range [0.." + (this._ROWDELETEPRIVCONVERList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) _ROWDELETEPRIVCONVERList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER getROWDELETEPRIVCONVER(int) 

    /**
     * Method getROWDELETEPRIVCONVER
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER[] getROWDELETEPRIVCONVER()
    {
        int size = this._ROWDELETEPRIVCONVERList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) _ROWDELETEPRIVCONVERList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER[] getROWDELETEPRIVCONVER() 

    /**
     * Method getROWDELETEPRIVCONVERAsReference
     * 
     * Returns a reference to '_ROWDELETEPRIVCONVERList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> getROWDELETEPRIVCONVERAsReference()
    {
        return this._ROWDELETEPRIVCONVERList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> getROWDELETEPRIVCONVERAsReference() 

    /**
     * Method getROWDELETEPRIVCONVERCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWDELETEPRIVCONVERCount()
    {
        return this._ROWDELETEPRIVCONVERList.size();
    } //-- int getROWDELETEPRIVCONVERCount() 

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
     * Method iterateROWDELETEPRIVCONVER
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> iterateROWDELETEPRIVCONVER()
    {
        return this._ROWDELETEPRIVCONVERList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> iterateROWDELETEPRIVCONVER() 

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
    public void removeAllROWDELETEPRIVCONVER()
    {
        this._ROWDELETEPRIVCONVERList.clear();
    } //-- void removeAllROWDELETEPRIVCONVER() 

    /**
     * Method removeROWDELETEPRIVCONVER
     * 
     * 
     * 
     * @param vROWDELETEPRIVCONVER
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWDELETEPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER vROWDELETEPRIVCONVER)
    {
        boolean removed = _ROWDELETEPRIVCONVERList.remove(vROWDELETEPRIVCONVER);
        return removed;
    } //-- boolean removeROWDELETEPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) 

    /**
     * Method removeROWDELETEPRIVCONVERAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER removeROWDELETEPRIVCONVERAt(int index)
    {
        Object obj = this._ROWDELETEPRIVCONVERList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER removeROWDELETEPRIVCONVERAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWDELETEPRIVCONVER
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWDELETEPRIVCONVER(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER vROWDELETEPRIVCONVER)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDELETEPRIVCONVERList.size()) {
            throw new IndexOutOfBoundsException("setROWDELETEPRIVCONVER: Index value '" + index + "' not in range [0.." + (this._ROWDELETEPRIVCONVERList.size() - 1) + "]");
        }
        
        this._ROWDELETEPRIVCONVERList.set(index, vROWDELETEPRIVCONVER);
    } //-- void setROWDELETEPRIVCONVER(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) 

    /**
     * 
     * 
     * @param vROWDELETEPRIVCONVERArray
     */
    public void setROWDELETEPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER[] vROWDELETEPRIVCONVERArray)
    {
        //-- copy array
        _ROWDELETEPRIVCONVERList.clear();
        
        for (int i = 0; i < vROWDELETEPRIVCONVERArray.length; i++) {
                this._ROWDELETEPRIVCONVERList.add(vROWDELETEPRIVCONVERArray[i]);
        }
    } //-- void setROWDELETEPRIVCONVER(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER) 

    /**
     * Sets the value of '_ROWDELETEPRIVCONVERList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vROWDELETEPRIVCONVERList the Vector to copy.
     */
    public void setROWDELETEPRIVCONVER(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> vROWDELETEPRIVCONVERList)
    {
        // copy vector
        this._ROWDELETEPRIVCONVERList.clear();
        
        this._ROWDELETEPRIVCONVERList.addAll(vROWDELETEPRIVCONVERList);
    } //-- void setROWDELETEPRIVCONVER(java.util.List) 

    /**
     * Sets the value of '_ROWDELETEPRIVCONVERList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param ROWDELETEPRIVCONVERVector the Vector to set.
     */
    public void setROWDELETEPRIVCONVERAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER> ROWDELETEPRIVCONVERVector)
    {
        this._ROWDELETEPRIVCONVERList = ROWDELETEPRIVCONVERVector;
    } //-- void setROWDELETEPRIVCONVERAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY unmarshal(java.io.Reader) 

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
