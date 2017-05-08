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
 * Class ROWCFIN19SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCFIN19SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCFIN19SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> _ROWCFIN19SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCFIN19SOG_ARRAY() 
     {
        super();
        this._ROWCFIN19SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCFIN19SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN19SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG vROWCFIN19SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN19SOGList.size() >= 70) {
            throw new IndexOutOfBoundsException("addROWCFIN19SOG has a maximum of 70");
        }
        
        this._ROWCFIN19SOGList.add(vROWCFIN19SOG);
    } //-- void addROWCFIN19SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN19SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCFIN19SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG vROWCFIN19SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCFIN19SOGList.size() >= 70) {
            throw new IndexOutOfBoundsException("addROWCFIN19SOG has a maximum of 70");
        }
        
        this._ROWCFIN19SOGList.add(index, vROWCFIN19SOG);
    } //-- void addROWCFIN19SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCFIN19SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> enumerateROWCFIN19SOG()
    {
        return java.util.Collections.enumeration(this._ROWCFIN19SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> enumerateROWCFIN19SOG() 

    /**
     * Method getROWCFIN19SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG getROWCFIN19SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN19SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCFIN19SOG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN19SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) _ROWCFIN19SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG getROWCFIN19SOG(int) 

    /**
     * Method getROWCFIN19SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG[] getROWCFIN19SOG()
    {
        int size = this._ROWCFIN19SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) _ROWCFIN19SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG[] getROWCFIN19SOG() 

    /**
     * Method getROWCFIN19SOGAsReference
     * 
     * Returns a reference to '_ROWCFIN19SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> getROWCFIN19SOGAsReference()
    {
        return this._ROWCFIN19SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> getROWCFIN19SOGAsReference() 

    /**
     * Method getROWCFIN19SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCFIN19SOGCount()
    {
        return this._ROWCFIN19SOGList.size();
    } //-- int getROWCFIN19SOGCount() 

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
     * Method iterateROWCFIN19SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> iterateROWCFIN19SOG()
    {
        return this._ROWCFIN19SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> iterateROWCFIN19SOG() 

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
    public void removeAllROWCFIN19SOG()
    {
        this._ROWCFIN19SOGList.clear();
    } //-- void removeAllROWCFIN19SOG() 

    /**
     * Method removeROWCFIN19SOG
     * 
     * 
     * 
     * @param vROWCFIN19SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCFIN19SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG vROWCFIN19SOG)
    {
        boolean removed = _ROWCFIN19SOGList.remove(vROWCFIN19SOG);
        return removed;
    } //-- boolean removeROWCFIN19SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) 

    /**
     * Method removeROWCFIN19SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG removeROWCFIN19SOGAt(int index)
    {
        Object obj = this._ROWCFIN19SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG removeROWCFIN19SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCFIN19SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCFIN19SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG vROWCFIN19SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCFIN19SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCFIN19SOG: Index value '" + index + "' not in range [0.." + (this._ROWCFIN19SOGList.size() - 1) + "]");
        }
        
        this._ROWCFIN19SOGList.set(index, vROWCFIN19SOG);
    } //-- void setROWCFIN19SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) 

    /**
     * 
     * 
     * @param vROWCFIN19SOGArray
     */
    public void setROWCFIN19SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG[] vROWCFIN19SOGArray)
    {
        //-- copy array
        _ROWCFIN19SOGList.clear();
        
        for (int i = 0; i < vROWCFIN19SOGArray.length; i++) {
                this._ROWCFIN19SOGList.add(vROWCFIN19SOGArray[i]);
        }
    } //-- void setROWCFIN19SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG) 

    /**
     * Sets the value of '_ROWCFIN19SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCFIN19SOGList the Vector to copy.
     */
    public void setROWCFIN19SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> vROWCFIN19SOGList)
    {
        // copy vector
        this._ROWCFIN19SOGList.clear();
        
        this._ROWCFIN19SOGList.addAll(vROWCFIN19SOGList);
    } //-- void setROWCFIN19SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCFIN19SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCFIN19SOGVector the Vector to set.
     */
    public void setROWCFIN19SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG> ROWCFIN19SOGVector)
    {
        this._ROWCFIN19SOGList = ROWCFIN19SOGVector;
    } //-- void setROWCFIN19SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY unmarshal(java.io.Reader) 

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
