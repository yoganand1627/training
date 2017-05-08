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
 * Class ROWCFIN14SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN14SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN14SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> _ROWCFIN14SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN14SIG_ARRAY() 
     {
        super();
        this._ROWCFIN14SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN14SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG vROWCFIN14SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN14SIGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN14SIG has a maximum of 200");
        }
        
        this._ROWCFIN14SIGList.add(vROWCFIN14SIG);
    } //-- void addROWCFIN14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN14SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN14SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG vROWCFIN14SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN14SIGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN14SIG has a maximum of 200");
        }
        
        this._ROWCFIN14SIGList.add(index, vROWCFIN14SIG);
    } //-- void addROWCFIN14SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN14SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> enumerateROWCFIN14SIG()
    {
        return java.util.Collections.enumeration(this._ROWCFIN14SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> enumerateROWCFIN14SIG() 

    /**
     * Method getROWCFIN14SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG getROWCFIN14SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN14SIGList.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN14SIG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN14SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) _ROWCFIN14SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG getROWCFIN14SIG(int) 

    /**
     * Method getROWCFIN14SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG[] getROWCFIN14SIG()
    {
        int size = this._ROWCFIN14SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) _ROWCFIN14SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG[] getROWCFIN14SIG() 

    /**
     * Method getROWCFIN14SIGAsReference
     * 
     * Returns a reference to '_ROWCFIN14SIGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> getROWCFIN14SIGAsReference()
    {
        return this._ROWCFIN14SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> getROWCFIN14SIGAsReference() 

    /**
     * Method getROWCFIN14SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN14SIGCount()
    {
        return this._ROWCFIN14SIGList.size();
    } //-- int getROWCFIN14SIGCount() 

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
     * Method iterateROWCFIN14SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> iterateROWCFIN14SIG()
    {
        return this._ROWCFIN14SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> iterateROWCFIN14SIG() 

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
    public void removeAllROWCFIN14SIG()
    {
        this._ROWCFIN14SIGList.clear();
    } //-- void removeAllROWCFIN14SIG() 

    /**
     * Method removeROWCFIN14SIG
     * 
     * 
     * 
     * @param vROWCFIN14SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG vROWCFIN14SIG)
    {
        boolean removed = _ROWCFIN14SIGList.remove(vROWCFIN14SIG);
        return removed;
    } //-- boolean removeROWCFIN14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) 

    /**
     * Method removeROWCFIN14SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG removeROWCFIN14SIGAt(int index)
    {
        Object obj = this._ROWCFIN14SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG removeROWCFIN14SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN14SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN14SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG vROWCFIN14SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN14SIGList.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN14SIG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN14SIGList.size() - 1) + "]");
        }
        
        this._ROWCFIN14SIGList.set(index, vROWCFIN14SIG);
    } //-- void setROWCFIN14SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) 

    /**
     * 
     * 
     * @param vROWCFIN14SIGArray
     */
    public void setROWCFIN14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG[] vROWCFIN14SIGArray)
    {
        //-- copy array
        _ROWCFIN14SIGList.clear();
        
        for (int i = 0; i < vROWCFIN14SIGArray.length; i++) {
                this._ROWCFIN14SIGList.add(vROWCFIN14SIGArray[i]);
        }
    } //-- void setROWCFIN14SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG) 

    /**
     * Sets the value of '_ROWCFIN14SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN14SIGList the Vector to copy.
     */
    public void setROWCFIN14SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> vROWCFIN14SIGList)
    {
        // copy vector
        this._ROWCFIN14SIGList.clear();
        
        this._ROWCFIN14SIGList.addAll(vROWCFIN14SIGList);
    } //-- void setROWCFIN14SIG(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN14SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN14SIGVector the Vector to set.
     */
    public void setROWCFIN14SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG> ROWCFIN14SIGVector)
    {
        this._ROWCFIN14SIGList = ROWCFIN14SIGVector;
    } //-- void setROWCFIN14SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG_ARRAY unmarshal(java.io.Reader) 

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
