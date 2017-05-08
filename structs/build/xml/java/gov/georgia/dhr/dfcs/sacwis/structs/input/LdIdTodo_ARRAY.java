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
 * Class LdIdTodo_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LdIdTodo_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ldIdTodoList
     */
    private java.util.List<Integer> _ldIdTodoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LdIdTodo_ARRAY() 
     {
        super();
        this._ldIdTodoList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.LdIdTodo_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLdIdTodo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLdIdTodo(int vLdIdTodo)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ldIdTodoList.size() >= 100) {
            throw new IndexOutOfBoundsException("addLdIdTodo has a maximum of 100");
        }
        
        this._ldIdTodoList.add(new java.lang.Integer(vLdIdTodo));
    } //-- void addLdIdTodo(int) 

    /**
     * 
     * 
     * @param index
     * @param vLdIdTodo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLdIdTodo(int index, int vLdIdTodo)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ldIdTodoList.size() >= 100) {
            throw new IndexOutOfBoundsException("addLdIdTodo has a maximum of 100");
        }
        
        this._ldIdTodoList.add(index, new java.lang.Integer(vLdIdTodo));
    } //-- void addLdIdTodo(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateLdIdTodo
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateLdIdTodo()
    {
        return java.util.Collections.enumeration(this._ldIdTodoList);
    } //-- java.util.Enumeration<Integer> enumerateLdIdTodo() 

    /**
     * Method getLdIdTodo
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getLdIdTodo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ldIdTodoList.size()) {
            throw new IndexOutOfBoundsException("getLdIdTodo: Index value '" + index + "' not in range [0.." + (this._ldIdTodoList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ldIdTodoList.get(index)).intValue();
    } //-- int getLdIdTodo(int) 

    /**
     * Method getLdIdTodo
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getLdIdTodo()
    {
        int size = this._ldIdTodoList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ldIdTodoList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getLdIdTodo() 

    /**
     * Method getLdIdTodoAsReference
     * 
     * Returns a reference to '_ldIdTodoList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getLdIdTodoAsReference()
    {
        return this._ldIdTodoList;
    } //-- java.util.List<Integer> getLdIdTodoAsReference() 

    /**
     * Method getLdIdTodoCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getLdIdTodoCount()
    {
        return this._ldIdTodoList.size();
    } //-- int getLdIdTodoCount() 

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
     * Method iterateLdIdTodo
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateLdIdTodo()
    {
        return this._ldIdTodoList.iterator();
    } //-- java.util.Iterator<Integer> iterateLdIdTodo() 

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
    public void removeAllLdIdTodo()
    {
        this._ldIdTodoList.clear();
    } //-- void removeAllLdIdTodo() 

    /**
     * Method removeLdIdTodo
     * 
     * 
     * 
     * @param vLdIdTodo
     * @return true if the object was removed from the collection.
     */
    public boolean removeLdIdTodo(int vLdIdTodo)
    {
        boolean removed = _ldIdTodoList.remove(new java.lang.Integer(vLdIdTodo));
        return removed;
    } //-- boolean removeLdIdTodo(int) 

    /**
     * Method removeLdIdTodoAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeLdIdTodoAt(int index)
    {
        Object obj = this._ldIdTodoList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeLdIdTodoAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vLdIdTodo
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLdIdTodo(int index, int vLdIdTodo)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ldIdTodoList.size()) {
            throw new IndexOutOfBoundsException("setLdIdTodo: Index value '" + index + "' not in range [0.." + (this._ldIdTodoList.size() - 1) + "]");
        }
        
        this._ldIdTodoList.set(index, new java.lang.Integer(vLdIdTodo));
    } //-- void setLdIdTodo(int, int) 

    /**
     * 
     * 
     * @param vLdIdTodoArray
     */
    public void setLdIdTodo(int[] vLdIdTodoArray)
    {
        //-- copy array
        _ldIdTodoList.clear();
        
        for (int i = 0; i < vLdIdTodoArray.length; i++) {
                this._ldIdTodoList.add(new java.lang.Integer(vLdIdTodoArray[i]));
        }
    } //-- void setLdIdTodo(int) 

    /**
     * Sets the value of '_ldIdTodoList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vLdIdTodoList the Vector to copy.
     */
    public void setLdIdTodo(java.util.List<Integer> vLdIdTodoList)
    {
        // copy vector
        this._ldIdTodoList.clear();
        
        this._ldIdTodoList.addAll(vLdIdTodoList);
    } //-- void setLdIdTodo(java.util.List) 

    /**
     * Sets the value of '_ldIdTodoList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param LdIdTodoVector the Vector to set.
     */
    public void setLdIdTodoAsReference(java.util.Vector<Integer> LdIdTodoVector)
    {
        this._ldIdTodoList = LdIdTodoVector;
    } //-- void setLdIdTodoAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.LdIdTodo_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.LdIdTodo_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.LdIdTodo_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.LdIdTodo_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.LdIdTodo_ARRAY unmarshal(java.io.Reader) 

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
