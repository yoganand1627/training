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
 * Class SzCdUerrorMsgNbr_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdUerrorMsgNbr_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _szCdUerrorMsgNbrList
     */
    private java.util.List<Integer> _szCdUerrorMsgNbrList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdUerrorMsgNbr_ARRAY() 
     {
        super();
        this._szCdUerrorMsgNbrList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSzCdUerrorMsgNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdUerrorMsgNbr(int vSzCdUerrorMsgNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdUerrorMsgNbrList.size() >= 20) {
            throw new IndexOutOfBoundsException("addSzCdUerrorMsgNbr has a maximum of 20");
        }
        
        this._szCdUerrorMsgNbrList.add(new java.lang.Integer(vSzCdUerrorMsgNbr));
    } //-- void addSzCdUerrorMsgNbr(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdUerrorMsgNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSzCdUerrorMsgNbr(int index, int vSzCdUerrorMsgNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._szCdUerrorMsgNbrList.size() >= 20) {
            throw new IndexOutOfBoundsException("addSzCdUerrorMsgNbr has a maximum of 20");
        }
        
        this._szCdUerrorMsgNbrList.add(index, new java.lang.Integer(vSzCdUerrorMsgNbr));
    } //-- void addSzCdUerrorMsgNbr(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateSzCdUerrorMsgNbr
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateSzCdUerrorMsgNbr()
    {
        return java.util.Collections.enumeration(this._szCdUerrorMsgNbrList);
    } //-- java.util.Enumeration<Integer> enumerateSzCdUerrorMsgNbr() 

    /**
     * Method getSzCdUerrorMsgNbr
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getSzCdUerrorMsgNbr(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdUerrorMsgNbrList.size()) {
            throw new IndexOutOfBoundsException("getSzCdUerrorMsgNbr: Index value '" + index + "' not in range [0.." + (this._szCdUerrorMsgNbrList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_szCdUerrorMsgNbrList.get(index)).intValue();
    } //-- int getSzCdUerrorMsgNbr(int) 

    /**
     * Method getSzCdUerrorMsgNbr
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getSzCdUerrorMsgNbr()
    {
        int size = this._szCdUerrorMsgNbrList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_szCdUerrorMsgNbrList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getSzCdUerrorMsgNbr() 

    /**
     * Method getSzCdUerrorMsgNbrAsReference
     * 
     * Returns a reference to '_szCdUerrorMsgNbrList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getSzCdUerrorMsgNbrAsReference()
    {
        return this._szCdUerrorMsgNbrList;
    } //-- java.util.List<Integer> getSzCdUerrorMsgNbrAsReference() 

    /**
     * Method getSzCdUerrorMsgNbrCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getSzCdUerrorMsgNbrCount()
    {
        return this._szCdUerrorMsgNbrList.size();
    } //-- int getSzCdUerrorMsgNbrCount() 

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
     * Method iterateSzCdUerrorMsgNbr
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateSzCdUerrorMsgNbr()
    {
        return this._szCdUerrorMsgNbrList.iterator();
    } //-- java.util.Iterator<Integer> iterateSzCdUerrorMsgNbr() 

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
    public void removeAllSzCdUerrorMsgNbr()
    {
        this._szCdUerrorMsgNbrList.clear();
    } //-- void removeAllSzCdUerrorMsgNbr() 

    /**
     * Method removeSzCdUerrorMsgNbr
     * 
     * 
     * 
     * @param vSzCdUerrorMsgNbr
     * @return true if the object was removed from the collection.
     */
    public boolean removeSzCdUerrorMsgNbr(int vSzCdUerrorMsgNbr)
    {
        boolean removed = _szCdUerrorMsgNbrList.remove(new java.lang.Integer(vSzCdUerrorMsgNbr));
        return removed;
    } //-- boolean removeSzCdUerrorMsgNbr(int) 

    /**
     * Method removeSzCdUerrorMsgNbrAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeSzCdUerrorMsgNbrAt(int index)
    {
        Object obj = this._szCdUerrorMsgNbrList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeSzCdUerrorMsgNbrAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vSzCdUerrorMsgNbr
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSzCdUerrorMsgNbr(int index, int vSzCdUerrorMsgNbr)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._szCdUerrorMsgNbrList.size()) {
            throw new IndexOutOfBoundsException("setSzCdUerrorMsgNbr: Index value '" + index + "' not in range [0.." + (this._szCdUerrorMsgNbrList.size() - 1) + "]");
        }
        
        this._szCdUerrorMsgNbrList.set(index, new java.lang.Integer(vSzCdUerrorMsgNbr));
    } //-- void setSzCdUerrorMsgNbr(int, int) 

    /**
     * 
     * 
     * @param vSzCdUerrorMsgNbrArray
     */
    public void setSzCdUerrorMsgNbr(int[] vSzCdUerrorMsgNbrArray)
    {
        //-- copy array
        _szCdUerrorMsgNbrList.clear();
        
        for (int i = 0; i < vSzCdUerrorMsgNbrArray.length; i++) {
                this._szCdUerrorMsgNbrList.add(new java.lang.Integer(vSzCdUerrorMsgNbrArray[i]));
        }
    } //-- void setSzCdUerrorMsgNbr(int) 

    /**
     * Sets the value of '_szCdUerrorMsgNbrList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vSzCdUerrorMsgNbrList the Vector to copy.
     */
    public void setSzCdUerrorMsgNbr(java.util.List<Integer> vSzCdUerrorMsgNbrList)
    {
        // copy vector
        this._szCdUerrorMsgNbrList.clear();
        
        this._szCdUerrorMsgNbrList.addAll(vSzCdUerrorMsgNbrList);
    } //-- void setSzCdUerrorMsgNbr(java.util.List) 

    /**
     * Sets the value of '_szCdUerrorMsgNbrList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param SzCdUerrorMsgNbrVector the Vector to set.
     */
    public void setSzCdUerrorMsgNbrAsReference(java.util.Vector<Integer> SzCdUerrorMsgNbrVector)
    {
        this._szCdUerrorMsgNbrList = SzCdUerrorMsgNbrVector;
    } //-- void setSzCdUerrorMsgNbrAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr_ARRAY unmarshal(java.io.Reader) 

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
