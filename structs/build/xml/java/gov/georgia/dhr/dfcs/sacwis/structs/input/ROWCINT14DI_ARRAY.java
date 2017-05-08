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
 * Class ROWCINT14DI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINT14DI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINT14DIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> _ROWCINT14DIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINT14DI_ARRAY() 
     {
        super();
        this._ROWCINT14DIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINT14DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT14DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI vROWCINT14DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT14DIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCINT14DI has a maximum of 50");
        }
        
        this._ROWCINT14DIList.add(vROWCINT14DI);
    } //-- void addROWCINT14DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT14DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINT14DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI vROWCINT14DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINT14DIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCINT14DI has a maximum of 50");
        }
        
        this._ROWCINT14DIList.add(index, vROWCINT14DI);
    } //-- void addROWCINT14DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINT14DI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> enumerateROWCINT14DI()
    {
        return java.util.Collections.enumeration(this._ROWCINT14DIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> enumerateROWCINT14DI() 

    /**
     * Method getROWCINT14DI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI getROWCINT14DI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT14DIList.size()) {
            throw new IndexOutOfBoundsException("getROWCINT14DI: Index value '" + index + "' not in range [0.." + (this._ROWCINT14DIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) _ROWCINT14DIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI getROWCINT14DI(int) 

    /**
     * Method getROWCINT14DI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI[] getROWCINT14DI()
    {
        int size = this._ROWCINT14DIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) _ROWCINT14DIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI[] getROWCINT14DI() 

    /**
     * Method getROWCINT14DIAsReference
     * 
     * Returns a reference to '_ROWCINT14DIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> getROWCINT14DIAsReference()
    {
        return this._ROWCINT14DIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> getROWCINT14DIAsReference() 

    /**
     * Method getROWCINT14DICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINT14DICount()
    {
        return this._ROWCINT14DIList.size();
    } //-- int getROWCINT14DICount() 

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
     * Method iterateROWCINT14DI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> iterateROWCINT14DI()
    {
        return this._ROWCINT14DIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> iterateROWCINT14DI() 

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
    public void removeAllROWCINT14DI()
    {
        this._ROWCINT14DIList.clear();
    } //-- void removeAllROWCINT14DI() 

    /**
     * Method removeROWCINT14DI
     * 
     * 
     * 
     * @param vROWCINT14DI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINT14DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI vROWCINT14DI)
    {
        boolean removed = _ROWCINT14DIList.remove(vROWCINT14DI);
        return removed;
    } //-- boolean removeROWCINT14DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) 

    /**
     * Method removeROWCINT14DIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI removeROWCINT14DIAt(int index)
    {
        Object obj = this._ROWCINT14DIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI removeROWCINT14DIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINT14DI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINT14DI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI vROWCINT14DI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINT14DIList.size()) {
            throw new IndexOutOfBoundsException("setROWCINT14DI: Index value '" + index + "' not in range [0.." + (this._ROWCINT14DIList.size() - 1) + "]");
        }
        
        this._ROWCINT14DIList.set(index, vROWCINT14DI);
    } //-- void setROWCINT14DI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) 

    /**
     * 
     * 
     * @param vROWCINT14DIArray
     */
    public void setROWCINT14DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI[] vROWCINT14DIArray)
    {
        //-- copy array
        _ROWCINT14DIList.clear();
        
        for (int i = 0; i < vROWCINT14DIArray.length; i++) {
                this._ROWCINT14DIList.add(vROWCINT14DIArray[i]);
        }
    } //-- void setROWCINT14DI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI) 

    /**
     * Sets the value of '_ROWCINT14DIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINT14DIList the Vector to copy.
     */
    public void setROWCINT14DI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> vROWCINT14DIList)
    {
        // copy vector
        this._ROWCINT14DIList.clear();
        
        this._ROWCINT14DIList.addAll(vROWCINT14DIList);
    } //-- void setROWCINT14DI(java.util.List) 

    /**
     * Sets the value of '_ROWCINT14DIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINT14DIVector the Vector to set.
     */
    public void setROWCINT14DIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI> ROWCINT14DIVector)
    {
        this._ROWCINT14DIList = ROWCINT14DIVector;
    } //-- void setROWCINT14DIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY unmarshal(java.io.Reader) 

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
