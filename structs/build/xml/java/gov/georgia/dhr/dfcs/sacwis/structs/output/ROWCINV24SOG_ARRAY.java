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
 * Class ROWCINV24SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV24SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV24SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> _ROWCINV24SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV24SOG_ARRAY() 
     {
        super();
        this._ROWCINV24SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV24SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV24SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG vROWCINV24SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV24SOGList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCINV24SOG has a maximum of 100");
        }
        
        this._ROWCINV24SOGList.add(vROWCINV24SOG);
    } //-- void addROWCINV24SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV24SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV24SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG vROWCINV24SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV24SOGList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCINV24SOG has a maximum of 100");
        }
        
        this._ROWCINV24SOGList.add(index, vROWCINV24SOG);
    } //-- void addROWCINV24SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV24SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> enumerateROWCINV24SOG()
    {
        return java.util.Collections.enumeration(this._ROWCINV24SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> enumerateROWCINV24SOG() 

    /**
     * Method getROWCINV24SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG getROWCINV24SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV24SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCINV24SOG: Index value '" + index + "' not in range [0.." + (this._ROWCINV24SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) _ROWCINV24SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG getROWCINV24SOG(int) 

    /**
     * Method getROWCINV24SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG[] getROWCINV24SOG()
    {
        int size = this._ROWCINV24SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) _ROWCINV24SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG[] getROWCINV24SOG() 

    /**
     * Method getROWCINV24SOGAsReference
     * 
     * Returns a reference to '_ROWCINV24SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> getROWCINV24SOGAsReference()
    {
        return this._ROWCINV24SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> getROWCINV24SOGAsReference() 

    /**
     * Method getROWCINV24SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV24SOGCount()
    {
        return this._ROWCINV24SOGList.size();
    } //-- int getROWCINV24SOGCount() 

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
     * Method iterateROWCINV24SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> iterateROWCINV24SOG()
    {
        return this._ROWCINV24SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> iterateROWCINV24SOG() 

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
    public void removeAllROWCINV24SOG()
    {
        this._ROWCINV24SOGList.clear();
    } //-- void removeAllROWCINV24SOG() 

    /**
     * Method removeROWCINV24SOG
     * 
     * 
     * 
     * @param vROWCINV24SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV24SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG vROWCINV24SOG)
    {
        boolean removed = _ROWCINV24SOGList.remove(vROWCINV24SOG);
        return removed;
    } //-- boolean removeROWCINV24SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) 

    /**
     * Method removeROWCINV24SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG removeROWCINV24SOGAt(int index)
    {
        Object obj = this._ROWCINV24SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG removeROWCINV24SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV24SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV24SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG vROWCINV24SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV24SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCINV24SOG: Index value '" + index + "' not in range [0.." + (this._ROWCINV24SOGList.size() - 1) + "]");
        }
        
        this._ROWCINV24SOGList.set(index, vROWCINV24SOG);
    } //-- void setROWCINV24SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) 

    /**
     * 
     * 
     * @param vROWCINV24SOGArray
     */
    public void setROWCINV24SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG[] vROWCINV24SOGArray)
    {
        //-- copy array
        _ROWCINV24SOGList.clear();
        
        for (int i = 0; i < vROWCINV24SOGArray.length; i++) {
                this._ROWCINV24SOGList.add(vROWCINV24SOGArray[i]);
        }
    } //-- void setROWCINV24SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG) 

    /**
     * Sets the value of '_ROWCINV24SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV24SOGList the Vector to copy.
     */
    public void setROWCINV24SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> vROWCINV24SOGList)
    {
        // copy vector
        this._ROWCINV24SOGList.clear();
        
        this._ROWCINV24SOGList.addAll(vROWCINV24SOGList);
    } //-- void setROWCINV24SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCINV24SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV24SOGVector the Vector to set.
     */
    public void setROWCINV24SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG> ROWCINV24SOGVector)
    {
        this._ROWCINV24SOGList = ROWCINV24SOGVector;
    } //-- void setROWCINV24SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV24SOG_ARRAY unmarshal(java.io.Reader) 

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
