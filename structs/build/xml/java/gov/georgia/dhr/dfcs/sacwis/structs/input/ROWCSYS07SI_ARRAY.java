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
 * Class ROWCSYS07SI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSYS07SI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSYS07SIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> _ROWCSYS07SIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSYS07SI_ARRAY() 
     {
        super();
        this._ROWCSYS07SIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSYS07SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS07SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI vROWCSYS07SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS07SIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS07SI has a maximum of 50");
        }
        
        this._ROWCSYS07SIList.add(vROWCSYS07SI);
    } //-- void addROWCSYS07SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS07SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS07SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI vROWCSYS07SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS07SIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS07SI has a maximum of 50");
        }
        
        this._ROWCSYS07SIList.add(index, vROWCSYS07SI);
    } //-- void addROWCSYS07SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSYS07SI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> enumerateROWCSYS07SI()
    {
        return java.util.Collections.enumeration(this._ROWCSYS07SIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> enumerateROWCSYS07SI() 

    /**
     * Method getROWCSYS07SI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI getROWCSYS07SI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS07SIList.size()) {
            throw new IndexOutOfBoundsException("getROWCSYS07SI: Index value '" + index + "' not in range [0.." + (this._ROWCSYS07SIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) _ROWCSYS07SIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI getROWCSYS07SI(int) 

    /**
     * Method getROWCSYS07SI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI[] getROWCSYS07SI()
    {
        int size = this._ROWCSYS07SIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) _ROWCSYS07SIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI[] getROWCSYS07SI() 

    /**
     * Method getROWCSYS07SIAsReference
     * 
     * Returns a reference to '_ROWCSYS07SIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> getROWCSYS07SIAsReference()
    {
        return this._ROWCSYS07SIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> getROWCSYS07SIAsReference() 

    /**
     * Method getROWCSYS07SICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSYS07SICount()
    {
        return this._ROWCSYS07SIList.size();
    } //-- int getROWCSYS07SICount() 

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
     * Method iterateROWCSYS07SI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> iterateROWCSYS07SI()
    {
        return this._ROWCSYS07SIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> iterateROWCSYS07SI() 

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
    public void removeAllROWCSYS07SI()
    {
        this._ROWCSYS07SIList.clear();
    } //-- void removeAllROWCSYS07SI() 

    /**
     * Method removeROWCSYS07SI
     * 
     * 
     * 
     * @param vROWCSYS07SI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSYS07SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI vROWCSYS07SI)
    {
        boolean removed = _ROWCSYS07SIList.remove(vROWCSYS07SI);
        return removed;
    } //-- boolean removeROWCSYS07SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) 

    /**
     * Method removeROWCSYS07SIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI removeROWCSYS07SIAt(int index)
    {
        Object obj = this._ROWCSYS07SIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI removeROWCSYS07SIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS07SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSYS07SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI vROWCSYS07SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS07SIList.size()) {
            throw new IndexOutOfBoundsException("setROWCSYS07SI: Index value '" + index + "' not in range [0.." + (this._ROWCSYS07SIList.size() - 1) + "]");
        }
        
        this._ROWCSYS07SIList.set(index, vROWCSYS07SI);
    } //-- void setROWCSYS07SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) 

    /**
     * 
     * 
     * @param vROWCSYS07SIArray
     */
    public void setROWCSYS07SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI[] vROWCSYS07SIArray)
    {
        //-- copy array
        _ROWCSYS07SIList.clear();
        
        for (int i = 0; i < vROWCSYS07SIArray.length; i++) {
                this._ROWCSYS07SIList.add(vROWCSYS07SIArray[i]);
        }
    } //-- void setROWCSYS07SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI) 

    /**
     * Sets the value of '_ROWCSYS07SIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSYS07SIList the Vector to copy.
     */
    public void setROWCSYS07SI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> vROWCSYS07SIList)
    {
        // copy vector
        this._ROWCSYS07SIList.clear();
        
        this._ROWCSYS07SIList.addAll(vROWCSYS07SIList);
    } //-- void setROWCSYS07SI(java.util.List) 

    /**
     * Sets the value of '_ROWCSYS07SIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSYS07SIVector the Vector to set.
     */
    public void setROWCSYS07SIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI> ROWCSYS07SIVector)
    {
        this._ROWCSYS07SIList = ROWCSYS07SIVector;
    } //-- void setROWCSYS07SIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS07SI_ARRAY unmarshal(java.io.Reader) 

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
