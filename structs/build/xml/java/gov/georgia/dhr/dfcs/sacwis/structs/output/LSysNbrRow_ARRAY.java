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
 * Class LSysNbrRow_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LSysNbrRow_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _lSysNbrRowList
     */
    private java.util.List<Integer> _lSysNbrRowList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LSysNbrRow_ARRAY() 
     {
        super();
        this._lSysNbrRowList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vLSysNbrRow
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLSysNbrRow(int vLSysNbrRow)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._lSysNbrRowList.size() >= 5) {
            throw new IndexOutOfBoundsException("addLSysNbrRow has a maximum of 5");
        }
        
        this._lSysNbrRowList.add(new java.lang.Integer(vLSysNbrRow));
    } //-- void addLSysNbrRow(int) 

    /**
     * 
     * 
     * @param index
     * @param vLSysNbrRow
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addLSysNbrRow(int index, int vLSysNbrRow)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._lSysNbrRowList.size() >= 5) {
            throw new IndexOutOfBoundsException("addLSysNbrRow has a maximum of 5");
        }
        
        this._lSysNbrRowList.add(index, new java.lang.Integer(vLSysNbrRow));
    } //-- void addLSysNbrRow(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateLSysNbrRow
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateLSysNbrRow()
    {
        return java.util.Collections.enumeration(this._lSysNbrRowList);
    } //-- java.util.Enumeration<Integer> enumerateLSysNbrRow() 

    /**
     * Method getLSysNbrRow
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getLSysNbrRow(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._lSysNbrRowList.size()) {
            throw new IndexOutOfBoundsException("getLSysNbrRow: Index value '" + index + "' not in range [0.." + (this._lSysNbrRowList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_lSysNbrRowList.get(index)).intValue();
    } //-- int getLSysNbrRow(int) 

    /**
     * Method getLSysNbrRow
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getLSysNbrRow()
    {
        int size = this._lSysNbrRowList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_lSysNbrRowList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getLSysNbrRow() 

    /**
     * Method getLSysNbrRowAsReference
     * 
     * Returns a reference to '_lSysNbrRowList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getLSysNbrRowAsReference()
    {
        return this._lSysNbrRowList;
    } //-- java.util.List<Integer> getLSysNbrRowAsReference() 

    /**
     * Method getLSysNbrRowCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getLSysNbrRowCount()
    {
        return this._lSysNbrRowList.size();
    } //-- int getLSysNbrRowCount() 

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
     * Method iterateLSysNbrRow
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateLSysNbrRow()
    {
        return this._lSysNbrRowList.iterator();
    } //-- java.util.Iterator<Integer> iterateLSysNbrRow() 

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
    public void removeAllLSysNbrRow()
    {
        this._lSysNbrRowList.clear();
    } //-- void removeAllLSysNbrRow() 

    /**
     * Method removeLSysNbrRow
     * 
     * 
     * 
     * @param vLSysNbrRow
     * @return true if the object was removed from the collection.
     */
    public boolean removeLSysNbrRow(int vLSysNbrRow)
    {
        boolean removed = _lSysNbrRowList.remove(new java.lang.Integer(vLSysNbrRow));
        return removed;
    } //-- boolean removeLSysNbrRow(int) 

    /**
     * Method removeLSysNbrRowAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeLSysNbrRowAt(int index)
    {
        Object obj = this._lSysNbrRowList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeLSysNbrRowAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vLSysNbrRow
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setLSysNbrRow(int index, int vLSysNbrRow)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._lSysNbrRowList.size()) {
            throw new IndexOutOfBoundsException("setLSysNbrRow: Index value '" + index + "' not in range [0.." + (this._lSysNbrRowList.size() - 1) + "]");
        }
        
        this._lSysNbrRowList.set(index, new java.lang.Integer(vLSysNbrRow));
    } //-- void setLSysNbrRow(int, int) 

    /**
     * 
     * 
     * @param vLSysNbrRowArray
     */
    public void setLSysNbrRow(int[] vLSysNbrRowArray)
    {
        //-- copy array
        _lSysNbrRowList.clear();
        
        for (int i = 0; i < vLSysNbrRowArray.length; i++) {
                this._lSysNbrRowList.add(new java.lang.Integer(vLSysNbrRowArray[i]));
        }
    } //-- void setLSysNbrRow(int) 

    /**
     * Sets the value of '_lSysNbrRowList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vLSysNbrRowList the Vector to copy.
     */
    public void setLSysNbrRow(java.util.List<Integer> vLSysNbrRowList)
    {
        // copy vector
        this._lSysNbrRowList.clear();
        
        this._lSysNbrRowList.addAll(vLSysNbrRowList);
    } //-- void setLSysNbrRow(java.util.List) 

    /**
     * Sets the value of '_lSysNbrRowList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param LSysNbrRowVector the Vector to set.
     */
    public void setLSysNbrRowAsReference(java.util.Vector<Integer> LSysNbrRowVector)
    {
        this._lSysNbrRowList = LSysNbrRowVector;
    } //-- void setLSysNbrRowAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.LSysNbrRow_ARRAY unmarshal(java.io.Reader) 

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
