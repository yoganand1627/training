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
 * Class TsLastUpdate_ARRAY_CSUB19SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TsLastUpdate_ARRAY_CSUB19SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _tsLastUpdateList
     */
    private java.util.List<java.util.Date> _tsLastUpdateList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TsLastUpdate_ARRAY_CSUB19SO() 
     {
        super();
        this._tsLastUpdateList = new java.util.ArrayList<java.util.Date>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTsLastUpdate
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTsLastUpdate(java.util.Date vTsLastUpdate)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._tsLastUpdateList.size() >= 2) {
            throw new IndexOutOfBoundsException("addTsLastUpdate has a maximum of 2");
        }
        
        this._tsLastUpdateList.add(vTsLastUpdate);
    } //-- void addTsLastUpdate(java.util.Date) 

    /**
     * 
     * 
     * @param index
     * @param vTsLastUpdate
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTsLastUpdate(int index, java.util.Date vTsLastUpdate)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._tsLastUpdateList.size() >= 2) {
            throw new IndexOutOfBoundsException("addTsLastUpdate has a maximum of 2");
        }
        
        this._tsLastUpdateList.add(index, vTsLastUpdate);
    } //-- void addTsLastUpdate(int, java.util.Date) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateTsLastUpdate
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<java.util.Date> enumerateTsLastUpdate()
    {
        return java.util.Collections.enumeration(this._tsLastUpdateList);
    } //-- java.util.Enumeration<java.util.Date> enumerateTsLastUpdate() 

    /**
     * Method getTsLastUpdate
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.util.Date at the given index
     */
    public java.util.Date getTsLastUpdate(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._tsLastUpdateList.size()) {
            throw new IndexOutOfBoundsException("getTsLastUpdate: Index value '" + index + "' not in range [0.." + (this._tsLastUpdateList.size() - 1) + "]");
        }
        
        return (java.util.Date)_tsLastUpdateList.get(index);
    } //-- java.util.Date getTsLastUpdate(int) 

    /**
     * Method getTsLastUpdate
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public java.util.Date[] getTsLastUpdate()
    {
        int size = this._tsLastUpdateList.size();
        java.util.Date[] array = new java.util.Date[size];
        for (int index = 0; index < size; index++){
            array[index] = (java.util.Date)_tsLastUpdateList.get(index);
        }
        
        return array;
    } //-- java.util.Date[] getTsLastUpdate() 

    /**
     * Method getTsLastUpdateAsReference
     * 
     * Returns a reference to '_tsLastUpdateList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<java.util.Date> getTsLastUpdateAsReference()
    {
        return this._tsLastUpdateList;
    } //-- java.util.List<java.util.Date> getTsLastUpdateAsReference() 

    /**
     * Method getTsLastUpdateCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getTsLastUpdateCount()
    {
        return this._tsLastUpdateList.size();
    } //-- int getTsLastUpdateCount() 

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
     * Method iterateTsLastUpdate
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<java.util.Date> iterateTsLastUpdate()
    {
        return this._tsLastUpdateList.iterator();
    } //-- java.util.Iterator<java.util.Date> iterateTsLastUpdate() 

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
    public void removeAllTsLastUpdate()
    {
        this._tsLastUpdateList.clear();
    } //-- void removeAllTsLastUpdate() 

    /**
     * Method removeTsLastUpdate
     * 
     * 
     * 
     * @param vTsLastUpdate
     * @return true if the object was removed from the collection.
     */
    public boolean removeTsLastUpdate(java.util.Date vTsLastUpdate)
    {
        boolean removed = _tsLastUpdateList.remove(vTsLastUpdate);
        return removed;
    } //-- boolean removeTsLastUpdate(java.util.Date) 

    /**
     * Method removeTsLastUpdateAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.util.Date removeTsLastUpdateAt(int index)
    {
        Object obj = this._tsLastUpdateList.remove(index);
        return (java.util.Date)obj;
    } //-- java.util.Date removeTsLastUpdateAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vTsLastUpdate
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTsLastUpdate(int index, java.util.Date vTsLastUpdate)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._tsLastUpdateList.size()) {
            throw new IndexOutOfBoundsException("setTsLastUpdate: Index value '" + index + "' not in range [0.." + (this._tsLastUpdateList.size() - 1) + "]");
        }
        
        this._tsLastUpdateList.set(index, vTsLastUpdate);
    } //-- void setTsLastUpdate(int, java.util.Date) 

    /**
     * 
     * 
     * @param vTsLastUpdateArray
     */
    public void setTsLastUpdate(java.util.Date[] vTsLastUpdateArray)
    {
        //-- copy array
        _tsLastUpdateList.clear();
        
        for (int i = 0; i < vTsLastUpdateArray.length; i++) {
                this._tsLastUpdateList.add(vTsLastUpdateArray[i]);
        }
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of '_tsLastUpdateList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vTsLastUpdateList the Vector to copy.
     */
    public void setTsLastUpdate(java.util.List<java.util.Date> vTsLastUpdateList)
    {
        // copy vector
        this._tsLastUpdateList.clear();
        
        this._tsLastUpdateList.addAll(vTsLastUpdateList);
    } //-- void setTsLastUpdate(java.util.List) 

    /**
     * Sets the value of '_tsLastUpdateList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param TsLastUpdateVector the Vector to set.
     */
    public void setTsLastUpdateAsReference(java.util.Vector<java.util.Date> TsLastUpdateVector)
    {
        this._tsLastUpdateList = TsLastUpdateVector;
    } //-- void setTsLastUpdateAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO unmarshal(java.io.Reader) 

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
