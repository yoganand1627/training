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
 * Class UlIdStage_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UlIdStage_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ulIdStageList
     */
    private java.util.List<Integer> _ulIdStageList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UlIdStage_ARRAY() 
     {
        super();
        this._ulIdStageList = new java.util.ArrayList<Integer>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUlIdStage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdStage(int vUlIdStage)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdStageList.size() >= 2500) {
            throw new IndexOutOfBoundsException("addUlIdStage has a maximum of 2500");
        }
        
        this._ulIdStageList.add(new java.lang.Integer(vUlIdStage));
    } //-- void addUlIdStage(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdStage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUlIdStage(int index, int vUlIdStage)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ulIdStageList.size() >= 2500) {
            throw new IndexOutOfBoundsException("addUlIdStage has a maximum of 2500");
        }
        
        this._ulIdStageList.add(index, new java.lang.Integer(vUlIdStage));
    } //-- void addUlIdStage(int, int) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateUlIdStage
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<Integer> enumerateUlIdStage()
    {
        return java.util.Collections.enumeration(this._ulIdStageList);
    } //-- java.util.Enumeration<Integer> enumerateUlIdStage() 

    /**
     * Method getUlIdStage
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the int at the given index
     */
    public int getUlIdStage(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdStageList.size()) {
            throw new IndexOutOfBoundsException("getUlIdStage: Index value '" + index + "' not in range [0.." + (this._ulIdStageList.size() - 1) + "]");
        }
        
        return ((java.lang.Integer)_ulIdStageList.get(index)).intValue();
    } //-- int getUlIdStage(int) 

    /**
     * Method getUlIdStage
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public int[] getUlIdStage()
    {
        int size = this._ulIdStageList.size();
        int[] array = new int[size];
        for (int index = 0; index < size; index++){
            array[index] = ((java.lang.Integer)_ulIdStageList.get(index)).intValue();
        }
        
        return array;
    } //-- int[] getUlIdStage() 

    /**
     * Method getUlIdStageAsReference
     * 
     * Returns a reference to '_ulIdStageList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<Integer> getUlIdStageAsReference()
    {
        return this._ulIdStageList;
    } //-- java.util.List<Integer> getUlIdStageAsReference() 

    /**
     * Method getUlIdStageCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getUlIdStageCount()
    {
        return this._ulIdStageList.size();
    } //-- int getUlIdStageCount() 

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
     * Method iterateUlIdStage
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<Integer> iterateUlIdStage()
    {
        return this._ulIdStageList.iterator();
    } //-- java.util.Iterator<Integer> iterateUlIdStage() 

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
    public void removeAllUlIdStage()
    {
        this._ulIdStageList.clear();
    } //-- void removeAllUlIdStage() 

    /**
     * Method removeUlIdStage
     * 
     * 
     * 
     * @param vUlIdStage
     * @return true if the object was removed from the collection.
     */
    public boolean removeUlIdStage(int vUlIdStage)
    {
        boolean removed = _ulIdStageList.remove(new java.lang.Integer(vUlIdStage));
        return removed;
    } //-- boolean removeUlIdStage(int) 

    /**
     * Method removeUlIdStageAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public int removeUlIdStageAt(int index)
    {
        Object obj = this._ulIdStageList.remove(index);
        return ((java.lang.Integer)obj).intValue();
    } //-- int removeUlIdStageAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vUlIdStage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUlIdStage(int index, int vUlIdStage)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ulIdStageList.size()) {
            throw new IndexOutOfBoundsException("setUlIdStage: Index value '" + index + "' not in range [0.." + (this._ulIdStageList.size() - 1) + "]");
        }
        
        this._ulIdStageList.set(index, new java.lang.Integer(vUlIdStage));
    } //-- void setUlIdStage(int, int) 

    /**
     * 
     * 
     * @param vUlIdStageArray
     */
    public void setUlIdStage(int[] vUlIdStageArray)
    {
        //-- copy array
        _ulIdStageList.clear();
        
        for (int i = 0; i < vUlIdStageArray.length; i++) {
                this._ulIdStageList.add(new java.lang.Integer(vUlIdStageArray[i]));
        }
    } //-- void setUlIdStage(int) 

    /**
     * Sets the value of '_ulIdStageList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vUlIdStageList the Vector to copy.
     */
    public void setUlIdStage(java.util.List<Integer> vUlIdStageList)
    {
        // copy vector
        this._ulIdStageList.clear();
        
        this._ulIdStageList.addAll(vUlIdStageList);
    } //-- void setUlIdStage(java.util.List) 

    /**
     * Sets the value of '_ulIdStageList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param UlIdStageVector the Vector to set.
     */
    public void setUlIdStageAsReference(java.util.Vector<Integer> UlIdStageVector)
    {
        this._ulIdStageList = UlIdStageVector;
    } //-- void setUlIdStageAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdStage_ARRAY unmarshal(java.io.Reader) 

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
