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
 * Class ROWCINV34SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV34SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV34SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> _ROWCINV34SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV34SIG_ARRAY() 
     {
        super();
        this._ROWCINV34SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV34SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV34SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG vROWCINV34SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV34SIGList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCINV34SIG has a maximum of 100");
        }
        
        this._ROWCINV34SIGList.add(vROWCINV34SIG);
    } //-- void addROWCINV34SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV34SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV34SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG vROWCINV34SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV34SIGList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCINV34SIG has a maximum of 100");
        }
        
        this._ROWCINV34SIGList.add(index, vROWCINV34SIG);
    } //-- void addROWCINV34SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV34SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> enumerateROWCINV34SIG()
    {
        return java.util.Collections.enumeration(this._ROWCINV34SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> enumerateROWCINV34SIG() 

    /**
     * Method getROWCINV34SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG getROWCINV34SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV34SIGList.size()) {
            throw new IndexOutOfBoundsException("getROWCINV34SIG: Index value '" + index + "' not in range [0.." + (this._ROWCINV34SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) _ROWCINV34SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG getROWCINV34SIG(int) 

    /**
     * Method getROWCINV34SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG[] getROWCINV34SIG()
    {
        int size = this._ROWCINV34SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) _ROWCINV34SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG[] getROWCINV34SIG() 

    /**
     * Method getROWCINV34SIGAsReference
     * 
     * Returns a reference to '_ROWCINV34SIGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> getROWCINV34SIGAsReference()
    {
        return this._ROWCINV34SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> getROWCINV34SIGAsReference() 

    /**
     * Method getROWCINV34SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV34SIGCount()
    {
        return this._ROWCINV34SIGList.size();
    } //-- int getROWCINV34SIGCount() 

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
     * Method iterateROWCINV34SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> iterateROWCINV34SIG()
    {
        return this._ROWCINV34SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> iterateROWCINV34SIG() 

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
    public void removeAllROWCINV34SIG()
    {
        this._ROWCINV34SIGList.clear();
    } //-- void removeAllROWCINV34SIG() 

    /**
     * Method removeROWCINV34SIG
     * 
     * 
     * 
     * @param vROWCINV34SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV34SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG vROWCINV34SIG)
    {
        boolean removed = _ROWCINV34SIGList.remove(vROWCINV34SIG);
        return removed;
    } //-- boolean removeROWCINV34SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) 

    /**
     * Method removeROWCINV34SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG removeROWCINV34SIGAt(int index)
    {
        Object obj = this._ROWCINV34SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG removeROWCINV34SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV34SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV34SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG vROWCINV34SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV34SIGList.size()) {
            throw new IndexOutOfBoundsException("setROWCINV34SIG: Index value '" + index + "' not in range [0.." + (this._ROWCINV34SIGList.size() - 1) + "]");
        }
        
        this._ROWCINV34SIGList.set(index, vROWCINV34SIG);
    } //-- void setROWCINV34SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) 

    /**
     * 
     * 
     * @param vROWCINV34SIGArray
     */
    public void setROWCINV34SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG[] vROWCINV34SIGArray)
    {
        //-- copy array
        _ROWCINV34SIGList.clear();
        
        for (int i = 0; i < vROWCINV34SIGArray.length; i++) {
                this._ROWCINV34SIGList.add(vROWCINV34SIGArray[i]);
        }
    } //-- void setROWCINV34SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG) 

    /**
     * Sets the value of '_ROWCINV34SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV34SIGList the Vector to copy.
     */
    public void setROWCINV34SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> vROWCINV34SIGList)
    {
        // copy vector
        this._ROWCINV34SIGList.clear();
        
        this._ROWCINV34SIGList.addAll(vROWCINV34SIGList);
    } //-- void setROWCINV34SIG(java.util.List) 

    /**
     * Sets the value of '_ROWCINV34SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV34SIGVector the Vector to set.
     */
    public void setROWCINV34SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG> ROWCINV34SIGVector)
    {
        this._ROWCINV34SIGList = ROWCINV34SIGVector;
    } //-- void setROWCINV34SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV34SIG_ARRAY unmarshal(java.io.Reader) 

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
