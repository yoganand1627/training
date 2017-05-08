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
 * Class ROWCINV44SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV44SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV44SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> _ROWCINV44SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV44SOG_ARRAY() 
     {
        super();
        this._ROWCINV44SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV44SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV44SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG vROWCINV44SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV44SOGList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCINV44SOG has a maximum of 500");
        }
        
        this._ROWCINV44SOGList.add(vROWCINV44SOG);
    } //-- void addROWCINV44SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV44SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV44SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG vROWCINV44SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV44SOGList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCINV44SOG has a maximum of 500");
        }
        
        this._ROWCINV44SOGList.add(index, vROWCINV44SOG);
    } //-- void addROWCINV44SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV44SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> enumerateROWCINV44SOG()
    {
        return java.util.Collections.enumeration(this._ROWCINV44SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> enumerateROWCINV44SOG() 

    /**
     * Method getROWCINV44SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG getROWCINV44SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV44SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCINV44SOG: Index value '" + index + "' not in range [0.." + (this._ROWCINV44SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) _ROWCINV44SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG getROWCINV44SOG(int) 

    /**
     * Method getROWCINV44SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG[] getROWCINV44SOG()
    {
        int size = this._ROWCINV44SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) _ROWCINV44SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG[] getROWCINV44SOG() 

    /**
     * Method getROWCINV44SOGAsReference
     * 
     * Returns a reference to '_ROWCINV44SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> getROWCINV44SOGAsReference()
    {
        return this._ROWCINV44SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> getROWCINV44SOGAsReference() 

    /**
     * Method getROWCINV44SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV44SOGCount()
    {
        return this._ROWCINV44SOGList.size();
    } //-- int getROWCINV44SOGCount() 

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
     * Method iterateROWCINV44SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> iterateROWCINV44SOG()
    {
        return this._ROWCINV44SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> iterateROWCINV44SOG() 

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
    public void removeAllROWCINV44SOG()
    {
        this._ROWCINV44SOGList.clear();
    } //-- void removeAllROWCINV44SOG() 

    /**
     * Method removeROWCINV44SOG
     * 
     * 
     * 
     * @param vROWCINV44SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV44SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG vROWCINV44SOG)
    {
        boolean removed = _ROWCINV44SOGList.remove(vROWCINV44SOG);
        return removed;
    } //-- boolean removeROWCINV44SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) 

    /**
     * Method removeROWCINV44SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG removeROWCINV44SOGAt(int index)
    {
        Object obj = this._ROWCINV44SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG removeROWCINV44SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV44SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV44SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG vROWCINV44SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV44SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCINV44SOG: Index value '" + index + "' not in range [0.." + (this._ROWCINV44SOGList.size() - 1) + "]");
        }
        
        this._ROWCINV44SOGList.set(index, vROWCINV44SOG);
    } //-- void setROWCINV44SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) 

    /**
     * 
     * 
     * @param vROWCINV44SOGArray
     */
    public void setROWCINV44SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG[] vROWCINV44SOGArray)
    {
        //-- copy array
        _ROWCINV44SOGList.clear();
        
        for (int i = 0; i < vROWCINV44SOGArray.length; i++) {
                this._ROWCINV44SOGList.add(vROWCINV44SOGArray[i]);
        }
    } //-- void setROWCINV44SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG) 

    /**
     * Sets the value of '_ROWCINV44SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV44SOGList the Vector to copy.
     */
    public void setROWCINV44SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> vROWCINV44SOGList)
    {
        // copy vector
        this._ROWCINV44SOGList.clear();
        
        this._ROWCINV44SOGList.addAll(vROWCINV44SOGList);
    } //-- void setROWCINV44SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCINV44SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV44SOGVector the Vector to set.
     */
    public void setROWCINV44SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG> ROWCINV44SOGVector)
    {
        this._ROWCINV44SOGList = ROWCINV44SOGVector;
    } //-- void setROWCINV44SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY unmarshal(java.io.Reader) 

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
