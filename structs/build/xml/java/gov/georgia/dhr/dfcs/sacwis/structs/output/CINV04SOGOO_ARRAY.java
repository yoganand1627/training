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
 * Class CINV04SOGOO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV04SOGOO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV04SOGOOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> _CINV04SOGOOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV04SOGOO_ARRAY() 
     {
        super();
        this._CINV04SOGOOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV04SOGOO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SOGOO(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO vCINV04SOGOO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SOGOOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addCINV04SOGOO has a maximum of 10");
        }
        
        this._CINV04SOGOOList.add(vCINV04SOGOO);
    } //-- void addCINV04SOGOO(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SOGOO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SOGOO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO vCINV04SOGOO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SOGOOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addCINV04SOGOO has a maximum of 10");
        }
        
        this._CINV04SOGOOList.add(index, vCINV04SOGOO);
    } //-- void addCINV04SOGOO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV04SOGOO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> enumerateCINV04SOGOO()
    {
        return java.util.Collections.enumeration(this._CINV04SOGOOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> enumerateCINV04SOGOO() 

    /**
     * Method getCINV04SOGOO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO getCINV04SOGOO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SOGOOList.size()) {
            throw new IndexOutOfBoundsException("getCINV04SOGOO: Index value '" + index + "' not in range [0.." + (this._CINV04SOGOOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) _CINV04SOGOOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO getCINV04SOGOO(int) 

    /**
     * Method getCINV04SOGOO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO[] getCINV04SOGOO()
    {
        int size = this._CINV04SOGOOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) _CINV04SOGOOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO[] getCINV04SOGOO() 

    /**
     * Method getCINV04SOGOOAsReference
     * 
     * Returns a reference to '_CINV04SOGOOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> getCINV04SOGOOAsReference()
    {
        return this._CINV04SOGOOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> getCINV04SOGOOAsReference() 

    /**
     * Method getCINV04SOGOOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV04SOGOOCount()
    {
        return this._CINV04SOGOOList.size();
    } //-- int getCINV04SOGOOCount() 

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
     * Method iterateCINV04SOGOO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> iterateCINV04SOGOO()
    {
        return this._CINV04SOGOOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> iterateCINV04SOGOO() 

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
    public void removeAllCINV04SOGOO()
    {
        this._CINV04SOGOOList.clear();
    } //-- void removeAllCINV04SOGOO() 

    /**
     * Method removeCINV04SOGOO
     * 
     * 
     * 
     * @param vCINV04SOGOO
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV04SOGOO(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO vCINV04SOGOO)
    {
        boolean removed = _CINV04SOGOOList.remove(vCINV04SOGOO);
        return removed;
    } //-- boolean removeCINV04SOGOO(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) 

    /**
     * Method removeCINV04SOGOOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO removeCINV04SOGOOAt(int index)
    {
        Object obj = this._CINV04SOGOOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO removeCINV04SOGOOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SOGOO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV04SOGOO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO vCINV04SOGOO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SOGOOList.size()) {
            throw new IndexOutOfBoundsException("setCINV04SOGOO: Index value '" + index + "' not in range [0.." + (this._CINV04SOGOOList.size() - 1) + "]");
        }
        
        this._CINV04SOGOOList.set(index, vCINV04SOGOO);
    } //-- void setCINV04SOGOO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) 

    /**
     * 
     * 
     * @param vCINV04SOGOOArray
     */
    public void setCINV04SOGOO(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO[] vCINV04SOGOOArray)
    {
        //-- copy array
        _CINV04SOGOOList.clear();
        
        for (int i = 0; i < vCINV04SOGOOArray.length; i++) {
                this._CINV04SOGOOList.add(vCINV04SOGOOArray[i]);
        }
    } //-- void setCINV04SOGOO(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO) 

    /**
     * Sets the value of '_CINV04SOGOOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vCINV04SOGOOList the Vector to copy.
     */
    public void setCINV04SOGOO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> vCINV04SOGOOList)
    {
        // copy vector
        this._CINV04SOGOOList.clear();
        
        this._CINV04SOGOOList.addAll(vCINV04SOGOOList);
    } //-- void setCINV04SOGOO(java.util.List) 

    /**
     * Sets the value of '_CINV04SOGOOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param CINV04SOGOOVector the Vector to set.
     */
    public void setCINV04SOGOOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO> CINV04SOGOOVector)
    {
        this._CINV04SOGOOList = CINV04SOGOOVector;
    } //-- void setCINV04SOGOOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOGOO_ARRAY unmarshal(java.io.Reader) 

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
