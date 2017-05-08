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
 * Class ROWCINV29DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV29DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCINV29DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> _ROWCINV29DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV29DO_ARRAY() 
     {
        super();
        this._ROWCINV29DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCINV29DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV29DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO vROWCINV29DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV29DOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCINV29DO has a maximum of 10");
        }
        
        this._ROWCINV29DOList.add(vROWCINV29DO);
    } //-- void addROWCINV29DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV29DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCINV29DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO vROWCINV29DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCINV29DOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCINV29DO has a maximum of 10");
        }
        
        this._ROWCINV29DOList.add(index, vROWCINV29DO);
    } //-- void addROWCINV29DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCINV29DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> enumerateROWCINV29DO()
    {
        return java.util.Collections.enumeration(this._ROWCINV29DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> enumerateROWCINV29DO() 

    /**
     * Method getROWCINV29DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO getROWCINV29DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV29DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCINV29DO: Index value '" + index + "' not in range [0.." + (this._ROWCINV29DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) _ROWCINV29DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO getROWCINV29DO(int) 

    /**
     * Method getROWCINV29DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO[] getROWCINV29DO()
    {
        int size = this._ROWCINV29DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) _ROWCINV29DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO[] getROWCINV29DO() 

    /**
     * Method getROWCINV29DOAsReference
     * 
     * Returns a reference to '_ROWCINV29DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> getROWCINV29DOAsReference()
    {
        return this._ROWCINV29DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> getROWCINV29DOAsReference() 

    /**
     * Method getROWCINV29DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCINV29DOCount()
    {
        return this._ROWCINV29DOList.size();
    } //-- int getROWCINV29DOCount() 

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
     * Method iterateROWCINV29DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> iterateROWCINV29DO()
    {
        return this._ROWCINV29DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> iterateROWCINV29DO() 

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
    public void removeAllROWCINV29DO()
    {
        this._ROWCINV29DOList.clear();
    } //-- void removeAllROWCINV29DO() 

    /**
     * Method removeROWCINV29DO
     * 
     * 
     * 
     * @param vROWCINV29DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCINV29DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO vROWCINV29DO)
    {
        boolean removed = _ROWCINV29DOList.remove(vROWCINV29DO);
        return removed;
    } //-- boolean removeROWCINV29DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) 

    /**
     * Method removeROWCINV29DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO removeROWCINV29DOAt(int index)
    {
        Object obj = this._ROWCINV29DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO removeROWCINV29DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCINV29DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCINV29DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO vROWCINV29DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCINV29DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCINV29DO: Index value '" + index + "' not in range [0.." + (this._ROWCINV29DOList.size() - 1) + "]");
        }
        
        this._ROWCINV29DOList.set(index, vROWCINV29DO);
    } //-- void setROWCINV29DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) 

    /**
     * 
     * 
     * @param vROWCINV29DOArray
     */
    public void setROWCINV29DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO[] vROWCINV29DOArray)
    {
        //-- copy array
        _ROWCINV29DOList.clear();
        
        for (int i = 0; i < vROWCINV29DOArray.length; i++) {
                this._ROWCINV29DOList.add(vROWCINV29DOArray[i]);
        }
    } //-- void setROWCINV29DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO) 

    /**
     * Sets the value of '_ROWCINV29DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCINV29DOList the Vector to copy.
     */
    public void setROWCINV29DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> vROWCINV29DOList)
    {
        // copy vector
        this._ROWCINV29DOList.clear();
        
        this._ROWCINV29DOList.addAll(vROWCINV29DOList);
    } //-- void setROWCINV29DO(java.util.List) 

    /**
     * Sets the value of '_ROWCINV29DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCINV29DOVector the Vector to set.
     */
    public void setROWCINV29DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO> ROWCINV29DOVector)
    {
        this._ROWCINV29DOList = ROWCINV29DOVector;
    } //-- void setROWCINV29DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29DO_ARRAY unmarshal(java.io.Reader) 

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
