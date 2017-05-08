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
 * Class PrsnSearchOutRec_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PrsnSearchOutRec_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _prsnSearchOutRecList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> _prsnSearchOutRecList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PrsnSearchOutRec_ARRAY() 
     {
        super();
        this._prsnSearchOutRecList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPrsnSearchOutRec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPrsnSearchOutRec(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec vPrsnSearchOutRec)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._prsnSearchOutRecList.size() >= 65) {
            throw new IndexOutOfBoundsException("addPrsnSearchOutRec has a maximum of 65");
        }
        
        this._prsnSearchOutRecList.add(vPrsnSearchOutRec);
    } //-- void addPrsnSearchOutRec(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) 

    /**
     * 
     * 
     * @param index
     * @param vPrsnSearchOutRec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPrsnSearchOutRec(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec vPrsnSearchOutRec)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._prsnSearchOutRecList.size() >= 65) {
            throw new IndexOutOfBoundsException("addPrsnSearchOutRec has a maximum of 65");
        }
        
        this._prsnSearchOutRecList.add(index, vPrsnSearchOutRec);
    } //-- void addPrsnSearchOutRec(int, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumeratePrsnSearchOutRec
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> enumeratePrsnSearchOutRec()
    {
        return java.util.Collections.enumeration(this._prsnSearchOutRecList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> enumeratePrsnSearchOutRec() 

    /**
     * Method getPrsnSearchOutRec
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec getPrsnSearchOutRec(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._prsnSearchOutRecList.size()) {
            throw new IndexOutOfBoundsException("getPrsnSearchOutRec: Index value '" + index + "' not in range [0.." + (this._prsnSearchOutRecList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) _prsnSearchOutRecList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec getPrsnSearchOutRec(int) 

    /**
     * Method getPrsnSearchOutRec
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec[] getPrsnSearchOutRec()
    {
        int size = this._prsnSearchOutRecList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) _prsnSearchOutRecList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec[] getPrsnSearchOutRec() 

    /**
     * Method getPrsnSearchOutRecAsReference
     * 
     * Returns a reference to '_prsnSearchOutRecList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> getPrsnSearchOutRecAsReference()
    {
        return this._prsnSearchOutRecList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> getPrsnSearchOutRecAsReference() 

    /**
     * Method getPrsnSearchOutRecCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getPrsnSearchOutRecCount()
    {
        return this._prsnSearchOutRecList.size();
    } //-- int getPrsnSearchOutRecCount() 

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
     * Method iteratePrsnSearchOutRec
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> iteratePrsnSearchOutRec()
    {
        return this._prsnSearchOutRecList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> iteratePrsnSearchOutRec() 

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
    public void removeAllPrsnSearchOutRec()
    {
        this._prsnSearchOutRecList.clear();
    } //-- void removeAllPrsnSearchOutRec() 

    /**
     * Method removePrsnSearchOutRec
     * 
     * 
     * 
     * @param vPrsnSearchOutRec
     * @return true if the object was removed from the collection.
     */
    public boolean removePrsnSearchOutRec(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec vPrsnSearchOutRec)
    {
        boolean removed = _prsnSearchOutRecList.remove(vPrsnSearchOutRec);
        return removed;
    } //-- boolean removePrsnSearchOutRec(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) 

    /**
     * Method removePrsnSearchOutRecAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec removePrsnSearchOutRecAt(int index)
    {
        Object obj = this._prsnSearchOutRecList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec removePrsnSearchOutRecAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vPrsnSearchOutRec
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPrsnSearchOutRec(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec vPrsnSearchOutRec)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._prsnSearchOutRecList.size()) {
            throw new IndexOutOfBoundsException("setPrsnSearchOutRec: Index value '" + index + "' not in range [0.." + (this._prsnSearchOutRecList.size() - 1) + "]");
        }
        
        this._prsnSearchOutRecList.set(index, vPrsnSearchOutRec);
    } //-- void setPrsnSearchOutRec(int, gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) 

    /**
     * 
     * 
     * @param vPrsnSearchOutRecArray
     */
    public void setPrsnSearchOutRec(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec[] vPrsnSearchOutRecArray)
    {
        //-- copy array
        _prsnSearchOutRecList.clear();
        
        for (int i = 0; i < vPrsnSearchOutRecArray.length; i++) {
                this._prsnSearchOutRecList.add(vPrsnSearchOutRecArray[i]);
        }
    } //-- void setPrsnSearchOutRec(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec) 

    /**
     * Sets the value of '_prsnSearchOutRecList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vPrsnSearchOutRecList the Vector to copy.
     */
    public void setPrsnSearchOutRec(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> vPrsnSearchOutRecList)
    {
        // copy vector
        this._prsnSearchOutRecList.clear();
        
        this._prsnSearchOutRecList.addAll(vPrsnSearchOutRecList);
    } //-- void setPrsnSearchOutRec(java.util.List) 

    /**
     * Sets the value of '_prsnSearchOutRecList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param PrsnSearchOutRecVector the Vector to set.
     */
    public void setPrsnSearchOutRecAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec> PrsnSearchOutRecVector)
    {
        this._prsnSearchOutRecList = PrsnSearchOutRecVector;
    } //-- void setPrsnSearchOutRecAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY unmarshal(java.io.Reader) 

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
