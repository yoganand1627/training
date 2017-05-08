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
 * Class ROWCFIN13SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN13SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN13SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> _ROWCFIN13SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN13SOG_ARRAY() 
     {
        super();
        this._ROWCFIN13SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN13SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG vROWCFIN13SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN13SOGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN13SOG has a maximum of 200");
        }
        
        this._ROWCFIN13SOGList.add(vROWCFIN13SOG);
    } //-- void addROWCFIN13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN13SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN13SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG vROWCFIN13SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN13SOGList.size() >= 200) {
            throw new IndexOutOfBoundsException("addROWCFIN13SOG has a maximum of 200");
        }
        
        this._ROWCFIN13SOGList.add(index, vROWCFIN13SOG);
    } //-- void addROWCFIN13SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN13SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> enumerateROWCFIN13SOG()
    {
        return java.util.Collections.enumeration(this._ROWCFIN13SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> enumerateROWCFIN13SOG() 

    /**
     * Method getROWCFIN13SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG getROWCFIN13SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN13SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN13SOG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN13SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) _ROWCFIN13SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG getROWCFIN13SOG(int) 

    /**
     * Method getROWCFIN13SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG[] getROWCFIN13SOG()
    {
        int size = this._ROWCFIN13SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) _ROWCFIN13SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG[] getROWCFIN13SOG() 

    /**
     * Method getROWCFIN13SOGAsReference
     * 
     * Returns a reference to '_ROWCFIN13SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> getROWCFIN13SOGAsReference()
    {
        return this._ROWCFIN13SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> getROWCFIN13SOGAsReference() 

    /**
     * Method getROWCFIN13SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN13SOGCount()
    {
        return this._ROWCFIN13SOGList.size();
    } //-- int getROWCFIN13SOGCount() 

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
     * Method iterateROWCFIN13SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> iterateROWCFIN13SOG()
    {
        return this._ROWCFIN13SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> iterateROWCFIN13SOG() 

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
    public void removeAllROWCFIN13SOG()
    {
        this._ROWCFIN13SOGList.clear();
    } //-- void removeAllROWCFIN13SOG() 

    /**
     * Method removeROWCFIN13SOG
     * 
     * 
     * 
     * @param vROWCFIN13SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG vROWCFIN13SOG)
    {
        boolean removed = _ROWCFIN13SOGList.remove(vROWCFIN13SOG);
        return removed;
    } //-- boolean removeROWCFIN13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) 

    /**
     * Method removeROWCFIN13SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG removeROWCFIN13SOGAt(int index)
    {
        Object obj = this._ROWCFIN13SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG removeROWCFIN13SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN13SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN13SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG vROWCFIN13SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN13SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN13SOG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN13SOGList.size() - 1) + "]");
        }
        
        this._ROWCFIN13SOGList.set(index, vROWCFIN13SOG);
    } //-- void setROWCFIN13SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) 

    /**
     * 
     * 
     * @param vROWCFIN13SOGArray
     */
    public void setROWCFIN13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG[] vROWCFIN13SOGArray)
    {
        //-- copy array
        _ROWCFIN13SOGList.clear();
        
        for (int i = 0; i < vROWCFIN13SOGArray.length; i++) {
                this._ROWCFIN13SOGList.add(vROWCFIN13SOGArray[i]);
        }
    } //-- void setROWCFIN13SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG) 

    /**
     * Sets the value of '_ROWCFIN13SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN13SOGList the Vector to copy.
     */
    public void setROWCFIN13SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> vROWCFIN13SOGList)
    {
        // copy vector
        this._ROWCFIN13SOGList.clear();
        
        this._ROWCFIN13SOGList.addAll(vROWCFIN13SOGList);
    } //-- void setROWCFIN13SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN13SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN13SOGVector the Vector to set.
     */
    public void setROWCFIN13SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG> ROWCFIN13SOGVector)
    {
        this._ROWCFIN13SOGList = ROWCFIN13SOGVector;
    } //-- void setROWCFIN13SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY unmarshal(java.io.Reader) 

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
