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
 * Class PrsnSrchListpInit_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PrsnSrchListpInit_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _prsnSrchListpInitList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> _prsnSrchListpInitList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PrsnSrchListpInit_ARRAY() 
     {
        super();
        this._prsnSrchListpInitList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPrsnSrchListpInit
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPrsnSrchListpInit(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit vPrsnSrchListpInit)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._prsnSrchListpInitList.size() >= 65) {
            throw new IndexOutOfBoundsException("addPrsnSrchListpInit has a maximum of 65");
        }
        
        this._prsnSrchListpInitList.add(vPrsnSrchListpInit);
    } //-- void addPrsnSrchListpInit(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) 

    /**
     * 
     * 
     * @param index
     * @param vPrsnSrchListpInit
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPrsnSrchListpInit(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit vPrsnSrchListpInit)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._prsnSrchListpInitList.size() >= 65) {
            throw new IndexOutOfBoundsException("addPrsnSrchListpInit has a maximum of 65");
        }
        
        this._prsnSrchListpInitList.add(index, vPrsnSrchListpInit);
    } //-- void addPrsnSrchListpInit(int, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumeratePrsnSrchListpInit
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> enumeratePrsnSrchListpInit()
    {
        return java.util.Collections.enumeration(this._prsnSrchListpInitList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> enumeratePrsnSrchListpInit() 

    /**
     * Method getPrsnSrchListpInit
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit getPrsnSrchListpInit(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._prsnSrchListpInitList.size()) {
            throw new IndexOutOfBoundsException("getPrsnSrchListpInit: Index value '" + index + "' not in range [0.." + (this._prsnSrchListpInitList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) _prsnSrchListpInitList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit getPrsnSrchListpInit(int) 

    /**
     * Method getPrsnSrchListpInit
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit[] getPrsnSrchListpInit()
    {
        int size = this._prsnSrchListpInitList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) _prsnSrchListpInitList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit[] getPrsnSrchListpInit() 

    /**
     * Method getPrsnSrchListpInitAsReference
     * 
     * Returns a reference to '_prsnSrchListpInitList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> getPrsnSrchListpInitAsReference()
    {
        return this._prsnSrchListpInitList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> getPrsnSrchListpInitAsReference() 

    /**
     * Method getPrsnSrchListpInitCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getPrsnSrchListpInitCount()
    {
        return this._prsnSrchListpInitList.size();
    } //-- int getPrsnSrchListpInitCount() 

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
     * Method iteratePrsnSrchListpInit
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> iteratePrsnSrchListpInit()
    {
        return this._prsnSrchListpInitList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> iteratePrsnSrchListpInit() 

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
    public void removeAllPrsnSrchListpInit()
    {
        this._prsnSrchListpInitList.clear();
    } //-- void removeAllPrsnSrchListpInit() 

    /**
     * Method removePrsnSrchListpInit
     * 
     * 
     * 
     * @param vPrsnSrchListpInit
     * @return true if the object was removed from the collection.
     */
    public boolean removePrsnSrchListpInit(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit vPrsnSrchListpInit)
    {
        boolean removed = _prsnSrchListpInitList.remove(vPrsnSrchListpInit);
        return removed;
    } //-- boolean removePrsnSrchListpInit(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) 

    /**
     * Method removePrsnSrchListpInitAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit removePrsnSrchListpInitAt(int index)
    {
        Object obj = this._prsnSrchListpInitList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit removePrsnSrchListpInitAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vPrsnSrchListpInit
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPrsnSrchListpInit(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit vPrsnSrchListpInit)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._prsnSrchListpInitList.size()) {
            throw new IndexOutOfBoundsException("setPrsnSrchListpInit: Index value '" + index + "' not in range [0.." + (this._prsnSrchListpInitList.size() - 1) + "]");
        }
        
        this._prsnSrchListpInitList.set(index, vPrsnSrchListpInit);
    } //-- void setPrsnSrchListpInit(int, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) 

    /**
     * 
     * 
     * @param vPrsnSrchListpInitArray
     */
    public void setPrsnSrchListpInit(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit[] vPrsnSrchListpInitArray)
    {
        //-- copy array
        _prsnSrchListpInitList.clear();
        
        for (int i = 0; i < vPrsnSrchListpInitArray.length; i++) {
                this._prsnSrchListpInitList.add(vPrsnSrchListpInitArray[i]);
        }
    } //-- void setPrsnSrchListpInit(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit) 

    /**
     * Sets the value of '_prsnSrchListpInitList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vPrsnSrchListpInitList the Vector to copy.
     */
    public void setPrsnSrchListpInit(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> vPrsnSrchListpInitList)
    {
        // copy vector
        this._prsnSrchListpInitList.clear();
        
        this._prsnSrchListpInitList.addAll(vPrsnSrchListpInitList);
    } //-- void setPrsnSrchListpInit(java.util.List) 

    /**
     * Sets the value of '_prsnSrchListpInitList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param PrsnSrchListpInitVector the Vector to set.
     */
    public void setPrsnSrchListpInitAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit> PrsnSrchListpInitVector)
    {
        this._prsnSrchListpInitList = PrsnSrchListpInitVector;
    } //-- void setPrsnSrchListpInitAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY unmarshal(java.io.Reader) 

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
