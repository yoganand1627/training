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
 * Class ROWCFIN20SIG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN20SIG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN20SIGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> _ROWCFIN20SIGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN20SIG_ARRAY() 
     {
        super();
        this._ROWCFIN20SIGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN20SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN20SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG vROWCFIN20SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN20SIGList.size() >= 70) {
            throw new IndexOutOfBoundsException("addROWCFIN20SIG has a maximum of 70");
        }
        
        this._ROWCFIN20SIGList.add(vROWCFIN20SIG);
    } //-- void addROWCFIN20SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN20SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN20SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG vROWCFIN20SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN20SIGList.size() >= 70) {
            throw new IndexOutOfBoundsException("addROWCFIN20SIG has a maximum of 70");
        }
        
        this._ROWCFIN20SIGList.add(index, vROWCFIN20SIG);
    } //-- void addROWCFIN20SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN20SIG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> enumerateROWCFIN20SIG()
    {
        return java.util.Collections.enumeration(this._ROWCFIN20SIGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> enumerateROWCFIN20SIG() 

    /**
     * Method getROWCFIN20SIG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG getROWCFIN20SIG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN20SIGList.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN20SIG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN20SIGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) _ROWCFIN20SIGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG getROWCFIN20SIG(int) 

    /**
     * Method getROWCFIN20SIG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG[] getROWCFIN20SIG()
    {
        int size = this._ROWCFIN20SIGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) _ROWCFIN20SIGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG[] getROWCFIN20SIG() 

    /**
     * Method getROWCFIN20SIGAsReference
     * 
     * Returns a reference to '_ROWCFIN20SIGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> getROWCFIN20SIGAsReference()
    {
        return this._ROWCFIN20SIGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> getROWCFIN20SIGAsReference() 

    /**
     * Method getROWCFIN20SIGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN20SIGCount()
    {
        return this._ROWCFIN20SIGList.size();
    } //-- int getROWCFIN20SIGCount() 

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
     * Method iterateROWCFIN20SIG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> iterateROWCFIN20SIG()
    {
        return this._ROWCFIN20SIGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> iterateROWCFIN20SIG() 

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
    public void removeAllROWCFIN20SIG()
    {
        this._ROWCFIN20SIGList.clear();
    } //-- void removeAllROWCFIN20SIG() 

    /**
     * Method removeROWCFIN20SIG
     * 
     * 
     * 
     * @param vROWCFIN20SIG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN20SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG vROWCFIN20SIG)
    {
        boolean removed = _ROWCFIN20SIGList.remove(vROWCFIN20SIG);
        return removed;
    } //-- boolean removeROWCFIN20SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) 

    /**
     * Method removeROWCFIN20SIGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG removeROWCFIN20SIGAt(int index)
    {
        Object obj = this._ROWCFIN20SIGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG removeROWCFIN20SIGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN20SIG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN20SIG(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG vROWCFIN20SIG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN20SIGList.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN20SIG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN20SIGList.size() - 1) + "]");
        }
        
        this._ROWCFIN20SIGList.set(index, vROWCFIN20SIG);
    } //-- void setROWCFIN20SIG(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) 

    /**
     * 
     * 
     * @param vROWCFIN20SIGArray
     */
    public void setROWCFIN20SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG[] vROWCFIN20SIGArray)
    {
        //-- copy array
        _ROWCFIN20SIGList.clear();
        
        for (int i = 0; i < vROWCFIN20SIGArray.length; i++) {
                this._ROWCFIN20SIGList.add(vROWCFIN20SIGArray[i]);
        }
    } //-- void setROWCFIN20SIG(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG) 

    /**
     * Sets the value of '_ROWCFIN20SIGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN20SIGList the Vector to copy.
     */
    public void setROWCFIN20SIG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> vROWCFIN20SIGList)
    {
        // copy vector
        this._ROWCFIN20SIGList.clear();
        
        this._ROWCFIN20SIGList.addAll(vROWCFIN20SIGList);
    } //-- void setROWCFIN20SIG(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN20SIGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN20SIGVector the Vector to set.
     */
    public void setROWCFIN20SIGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG> ROWCFIN20SIGVector)
    {
        this._ROWCFIN20SIGList = ROWCFIN20SIGVector;
    } //-- void setROWCFIN20SIGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY unmarshal(java.io.Reader) 

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
