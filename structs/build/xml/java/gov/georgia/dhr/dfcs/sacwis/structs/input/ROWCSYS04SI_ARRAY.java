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
 * Class ROWCSYS04SI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCSYS04SI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCSYS04SIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> _ROWCSYS04SIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCSYS04SI_ARRAY() 
     {
        super();
        this._ROWCSYS04SIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCSYS04SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS04SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI vROWCSYS04SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS04SIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS04SI has a maximum of 50");
        }
        
        this._ROWCSYS04SIList.add(vROWCSYS04SI);
    } //-- void addROWCSYS04SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS04SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCSYS04SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI vROWCSYS04SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCSYS04SIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCSYS04SI has a maximum of 50");
        }
        
        this._ROWCSYS04SIList.add(index, vROWCSYS04SI);
    } //-- void addROWCSYS04SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCSYS04SI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> enumerateROWCSYS04SI()
    {
        return java.util.Collections.enumeration(this._ROWCSYS04SIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> enumerateROWCSYS04SI() 

    /**
     * Method getROWCSYS04SI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI getROWCSYS04SI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS04SIList.size()) {
            throw new IndexOutOfBoundsException("getROWCSYS04SI: Index value '" + index + "' not in range [0.." + (this._ROWCSYS04SIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) _ROWCSYS04SIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI getROWCSYS04SI(int) 

    /**
     * Method getROWCSYS04SI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI[] getROWCSYS04SI()
    {
        int size = this._ROWCSYS04SIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) _ROWCSYS04SIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI[] getROWCSYS04SI() 

    /**
     * Method getROWCSYS04SIAsReference
     * 
     * Returns a reference to '_ROWCSYS04SIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> getROWCSYS04SIAsReference()
    {
        return this._ROWCSYS04SIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> getROWCSYS04SIAsReference() 

    /**
     * Method getROWCSYS04SICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCSYS04SICount()
    {
        return this._ROWCSYS04SIList.size();
    } //-- int getROWCSYS04SICount() 

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
     * Method iterateROWCSYS04SI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> iterateROWCSYS04SI()
    {
        return this._ROWCSYS04SIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> iterateROWCSYS04SI() 

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
    public void removeAllROWCSYS04SI()
    {
        this._ROWCSYS04SIList.clear();
    } //-- void removeAllROWCSYS04SI() 

    /**
     * Method removeROWCSYS04SI
     * 
     * 
     * 
     * @param vROWCSYS04SI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCSYS04SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI vROWCSYS04SI)
    {
        boolean removed = _ROWCSYS04SIList.remove(vROWCSYS04SI);
        return removed;
    } //-- boolean removeROWCSYS04SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) 

    /**
     * Method removeROWCSYS04SIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI removeROWCSYS04SIAt(int index)
    {
        Object obj = this._ROWCSYS04SIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI removeROWCSYS04SIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCSYS04SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCSYS04SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI vROWCSYS04SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCSYS04SIList.size()) {
            throw new IndexOutOfBoundsException("setROWCSYS04SI: Index value '" + index + "' not in range [0.." + (this._ROWCSYS04SIList.size() - 1) + "]");
        }
        
        this._ROWCSYS04SIList.set(index, vROWCSYS04SI);
    } //-- void setROWCSYS04SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) 

    /**
     * 
     * 
     * @param vROWCSYS04SIArray
     */
    public void setROWCSYS04SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI[] vROWCSYS04SIArray)
    {
        //-- copy array
        _ROWCSYS04SIList.clear();
        
        for (int i = 0; i < vROWCSYS04SIArray.length; i++) {
                this._ROWCSYS04SIList.add(vROWCSYS04SIArray[i]);
        }
    } //-- void setROWCSYS04SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI) 

    /**
     * Sets the value of '_ROWCSYS04SIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCSYS04SIList the Vector to copy.
     */
    public void setROWCSYS04SI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> vROWCSYS04SIList)
    {
        // copy vector
        this._ROWCSYS04SIList.clear();
        
        this._ROWCSYS04SIList.addAll(vROWCSYS04SIList);
    } //-- void setROWCSYS04SI(java.util.List) 

    /**
     * Sets the value of '_ROWCSYS04SIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCSYS04SIVector the Vector to set.
     */
    public void setROWCSYS04SIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI> ROWCSYS04SIVector)
    {
        this._ROWCSYS04SIList = ROWCSYS04SIVector;
    } //-- void setROWCSYS04SIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY unmarshal(java.io.Reader) 

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
