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
 * Class Csli_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Csli_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _csliList
     */
    private java.util.List<Integer> _csliList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Csli_ARRAY() 
     {
        super();
        this._csliList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCsli
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCsli(int vCsli)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._csliList.size() >= 10) {
            throw new IndexOutOfBoundsException("addCsli has a maximum of 10");
        }
        
        this._csliList.add(new java.lang.Integer(vCsli));
    } //-- void addCsli(int) 

    /**
     * 
     * 
     * @param index
     * @param vCsli
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCsli(int index, int vCsli)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._csliList.size() >= 10) {
            throw new IndexOutOfBoundsException("addCsli has a maximum of 10");
        }
        
        this._csliList.add(index, new java.lang.Integer(vCsli));
    } //-- void addCsli(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCsli
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateCsli()
    {
        return java.util.Collections.enumeration(this._csliList);
    } //-- java.util.Enumeration<Integer> enumerateCsli() 

    /**
     * Method getCsli
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getCsli(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._csliList.size()) {
            throw new IndexOutOfBoundsException("getCsli: Index value '" + index + "' not in range [0.." + (this._csliList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_csliList.get(index)).intValue();
    } //-- int getCsli(int) 

    /**
     * Method getCsli
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getCsli()
    {
        int size = this._csliList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_csliList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getCsli() 

    /**
     * Method getCsliAsReference
     * 
     * Returns a reference to '_csliList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getCsliAsReference()
    {
        return this._csliList;
    } //-- java.util.List<Integer> getCsliAsReference() 

    /**
     * Method getCsliCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCsliCount()
    {
        return this._csliList.size();
    } //-- int getCsliCount() 

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
     * Method iterateCsli
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateCsli()
    {
        return this._csliList.iterator();
    } //-- java.util.Iterator<Integer> iterateCsli() 

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
    public void removeAllCsli()
    {
        this._csliList.clear();
    } //-- void removeAllCsli() 

    /**
     * Method removeCsli
     * 
     * 
     * 
     * @param vCsli
     * @return true if the object was removed from the collection.
     */
    public boolean removeCsli(int vCsli)
    {
        boolean removed = _csliList.remove(new java.lang.Integer(vCsli));
        return removed;
    } //-- boolean removeCsli(int) 

    /**
     * Method removeCsliAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeCsliAt(int index)
    {
        Object obj = this._csliList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeCsliAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCsli
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCsli(int index, int vCsli)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._csliList.size()) {
            throw new IndexOutOfBoundsException("setCsli: Index value '" + index + "' not in range [0.." + (this._csliList.size() - 1) + "]");
        }
        
        this._csliList.set(index, new java.lang.Integer(vCsli));
    } //-- void setCsli(int, int) 

    /**
     * 
     * 
     * @param vCsliArray
     */
    public void setCsli(int[] vCsliArray)
    {
        //-- copy array
        _csliList.clear();
        
        for (int i = 0; i < vCsliArray.length; i++) {
                this._csliList.add(new java.lang.Integer(vCsliArray[i]));
        }
    } //-- void setCsli(int) 

    /**
     * Sets the value of '_csliList' by copying the given Vector.
     * All elements will be checked for type safety.
     * 
     * @param vCsliList the Vector to copy.
     */
    public void setCsli(java.util.List<Integer> vCsliList)
    {
        // copy vector
        this._csliList.clear();
        
        this._csliList.addAll(vCsliList);
    } //-- void setCsli(java.util.List) 

    /**
     * Sets the value of '_csliList' by setting it to the given
     * Vector. No type checking is performed.
     * 
     * @param CsliVector the Vector to set.
     */
    public void setCsliAsReference(java.util.Vector<Integer> CsliVector)
    {
        this._csliList = CsliVector;
    } //-- void setCsliAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.Csli_ARRAY unmarshal(java.io.Reader) 

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
