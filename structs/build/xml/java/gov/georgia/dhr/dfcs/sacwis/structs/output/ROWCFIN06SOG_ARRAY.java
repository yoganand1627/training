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
 * Class ROWCFIN06SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN06SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN06SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> _ROWCFIN06SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN06SOG_ARRAY() 
     {
        super();
        this._ROWCFIN06SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN06SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG vROWCFIN06SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN06SOGList.size() >= 300) {
            throw new IndexOutOfBoundsException("addROWCFIN06SOG has a maximum of 300");
        }
        
        this._ROWCFIN06SOGList.add(vROWCFIN06SOG);
    } //-- void addROWCFIN06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN06SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN06SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG vROWCFIN06SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN06SOGList.size() >= 300) {
            throw new IndexOutOfBoundsException("addROWCFIN06SOG has a maximum of 300");
        }
        
        this._ROWCFIN06SOGList.add(index, vROWCFIN06SOG);
    } //-- void addROWCFIN06SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN06SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> enumerateROWCFIN06SOG()
    {
        return java.util.Collections.enumeration(this._ROWCFIN06SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> enumerateROWCFIN06SOG() 

    /**
     * Method getROWCFIN06SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG getROWCFIN06SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN06SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN06SOG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN06SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) _ROWCFIN06SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG getROWCFIN06SOG(int) 

    /**
     * Method getROWCFIN06SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG[] getROWCFIN06SOG()
    {
        int size = this._ROWCFIN06SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) _ROWCFIN06SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG[] getROWCFIN06SOG() 

    /**
     * Method getROWCFIN06SOGAsReference
     * 
     * Returns a reference to '_ROWCFIN06SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> getROWCFIN06SOGAsReference()
    {
        return this._ROWCFIN06SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> getROWCFIN06SOGAsReference() 

    /**
     * Method getROWCFIN06SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN06SOGCount()
    {
        return this._ROWCFIN06SOGList.size();
    } //-- int getROWCFIN06SOGCount() 

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
     * Method iterateROWCFIN06SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> iterateROWCFIN06SOG()
    {
        return this._ROWCFIN06SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> iterateROWCFIN06SOG() 

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
    public void removeAllROWCFIN06SOG()
    {
        this._ROWCFIN06SOGList.clear();
    } //-- void removeAllROWCFIN06SOG() 

    /**
     * Method removeROWCFIN06SOG
     * 
     * 
     * 
     * @param vROWCFIN06SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG vROWCFIN06SOG)
    {
        boolean removed = _ROWCFIN06SOGList.remove(vROWCFIN06SOG);
        return removed;
    } //-- boolean removeROWCFIN06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) 

    /**
     * Method removeROWCFIN06SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG removeROWCFIN06SOGAt(int index)
    {
        Object obj = this._ROWCFIN06SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG removeROWCFIN06SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN06SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN06SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG vROWCFIN06SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN06SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN06SOG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN06SOGList.size() - 1) + "]");
        }
        
        this._ROWCFIN06SOGList.set(index, vROWCFIN06SOG);
    } //-- void setROWCFIN06SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) 

    /**
     * 
     * 
     * @param vROWCFIN06SOGArray
     */
    public void setROWCFIN06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG[] vROWCFIN06SOGArray)
    {
        //-- copy array
        _ROWCFIN06SOGList.clear();
        
        for (int i = 0; i < vROWCFIN06SOGArray.length; i++) {
                this._ROWCFIN06SOGList.add(vROWCFIN06SOGArray[i]);
        }
    } //-- void setROWCFIN06SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG) 

    /**
     * Sets the value of '_ROWCFIN06SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN06SOGList the Vector to copy.
     */
    public void setROWCFIN06SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> vROWCFIN06SOGList)
    {
        // copy vector
        this._ROWCFIN06SOGList.clear();
        
        this._ROWCFIN06SOGList.addAll(vROWCFIN06SOGList);
    } //-- void setROWCFIN06SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN06SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN06SOGVector the Vector to set.
     */
    public void setROWCFIN06SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG> ROWCFIN06SOGVector)
    {
        this._ROWCFIN06SOGList = ROWCFIN06SOGVector;
    } //-- void setROWCFIN06SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY unmarshal(java.io.Reader) 

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
