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
 * Class ROWCRES16SOG_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES16SOG_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES16SOGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> _ROWCRES16SOGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES16SOG_ARRAY() 
     {
        super();
        this._ROWCRES16SOGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCRES16SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES16SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG vROWCRES16SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES16SOGList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCRES16SOG has a maximum of 100");
        }
        
        this._ROWCRES16SOGList.add(vROWCRES16SOG);
    } //-- void addROWCRES16SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES16SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES16SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG vROWCRES16SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES16SOGList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCRES16SOG has a maximum of 100");
        }
        
        this._ROWCRES16SOGList.add(index, vROWCRES16SOG);
    } //-- void addROWCRES16SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCRES16SOG
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> enumerateROWCRES16SOG()
    {
        return java.util.Collections.enumeration(this._ROWCRES16SOGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> enumerateROWCRES16SOG() 

    /**
     * Method getROWCRES16SOG
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG getROWCRES16SOG(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES16SOGList.size()) {
            throw new IndexOutOfBoundsException("getROWCRES16SOG: Index value '" + index + "' not in range [0.." + (this._ROWCRES16SOGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) _ROWCRES16SOGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG getROWCRES16SOG(int) 

    /**
     * Method getROWCRES16SOG
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG[] getROWCRES16SOG()
    {
        int size = this._ROWCRES16SOGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) _ROWCRES16SOGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG[] getROWCRES16SOG() 

    /**
     * Method getROWCRES16SOGAsReference
     * 
     * Returns a reference to '_ROWCRES16SOGList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> getROWCRES16SOGAsReference()
    {
        return this._ROWCRES16SOGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> getROWCRES16SOGAsReference() 

    /**
     * Method getROWCRES16SOGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCRES16SOGCount()
    {
        return this._ROWCRES16SOGList.size();
    } //-- int getROWCRES16SOGCount() 

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
     * Method iterateROWCRES16SOG
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> iterateROWCRES16SOG()
    {
        return this._ROWCRES16SOGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> iterateROWCRES16SOG() 

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
    public void removeAllROWCRES16SOG()
    {
        this._ROWCRES16SOGList.clear();
    } //-- void removeAllROWCRES16SOG() 

    /**
     * Method removeROWCRES16SOG
     * 
     * 
     * 
     * @param vROWCRES16SOG
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCRES16SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG vROWCRES16SOG)
    {
        boolean removed = _ROWCRES16SOGList.remove(vROWCRES16SOG);
        return removed;
    } //-- boolean removeROWCRES16SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) 

    /**
     * Method removeROWCRES16SOGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG removeROWCRES16SOGAt(int index)
    {
        Object obj = this._ROWCRES16SOGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG removeROWCRES16SOGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES16SOG
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCRES16SOG(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG vROWCRES16SOG)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES16SOGList.size()) {
            throw new IndexOutOfBoundsException("setROWCRES16SOG: Index value '" + index + "' not in range [0.." + (this._ROWCRES16SOGList.size() - 1) + "]");
        }
        
        this._ROWCRES16SOGList.set(index, vROWCRES16SOG);
    } //-- void setROWCRES16SOG(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) 

    /**
     * 
     * 
     * @param vROWCRES16SOGArray
     */
    public void setROWCRES16SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG[] vROWCRES16SOGArray)
    {
        //-- copy array
        _ROWCRES16SOGList.clear();
        
        for (int i = 0; i < vROWCRES16SOGArray.length; i++) {
                this._ROWCRES16SOGList.add(vROWCRES16SOGArray[i]);
        }
    } //-- void setROWCRES16SOG(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG) 

    /**
     * Sets the value of '_ROWCRES16SOGList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCRES16SOGList the Vector to copy.
     */
    public void setROWCRES16SOG(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> vROWCRES16SOGList)
    {
        // copy vector
        this._ROWCRES16SOGList.clear();
        
        this._ROWCRES16SOGList.addAll(vROWCRES16SOGList);
    } //-- void setROWCRES16SOG(java.util.List) 

    /**
     * Sets the value of '_ROWCRES16SOGList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCRES16SOGVector the Vector to set.
     */
    public void setROWCRES16SOGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG> ROWCRES16SOGVector)
    {
        this._ROWCRES16SOGList = ROWCRES16SOGVector;
    } //-- void setROWCRES16SOGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY unmarshal(java.io.Reader) 

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
