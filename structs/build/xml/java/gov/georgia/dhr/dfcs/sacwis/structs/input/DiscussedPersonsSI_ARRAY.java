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
 * Class DiscussedPersonsSI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DiscussedPersonsSI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _discussedPersonsSIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> _discussedPersonsSIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DiscussedPersonsSI_ARRAY() 
     {
        super();
        this._discussedPersonsSIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDiscussedPersonsSI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDiscussedPersonsSI(gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI vDiscussedPersonsSI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._discussedPersonsSIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addDiscussedPersonsSI has a maximum of 50");
        }
        
        this._discussedPersonsSIList.add(vDiscussedPersonsSI);
    } //-- void addDiscussedPersonsSI(gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) 

    /**
     * 
     * 
     * @param index
     * @param vDiscussedPersonsSI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDiscussedPersonsSI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI vDiscussedPersonsSI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._discussedPersonsSIList.size() >= 50) {
            throw new IndexOutOfBoundsException("addDiscussedPersonsSI has a maximum of 50");
        }
        
        this._discussedPersonsSIList.add(index, vDiscussedPersonsSI);
    } //-- void addDiscussedPersonsSI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateDiscussedPersonsSI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> enumerateDiscussedPersonsSI()
    {
        return java.util.Collections.enumeration(this._discussedPersonsSIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> enumerateDiscussedPersonsSI() 

    /**
     * Method getDiscussedPersonsSI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI getDiscussedPersonsSI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._discussedPersonsSIList.size()) {
            throw new IndexOutOfBoundsException("getDiscussedPersonsSI: Index value '" + index + "' not in range [0.." + (this._discussedPersonsSIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) _discussedPersonsSIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI getDiscussedPersonsSI(int) 

    /**
     * Method getDiscussedPersonsSI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI[] getDiscussedPersonsSI()
    {
        int size = this._discussedPersonsSIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) _discussedPersonsSIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI[] getDiscussedPersonsSI() 

    /**
     * Method getDiscussedPersonsSIAsReference
     * 
     * Returns a reference to '_discussedPersonsSIList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> getDiscussedPersonsSIAsReference()
    {
        return this._discussedPersonsSIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> getDiscussedPersonsSIAsReference() 

    /**
     * Method getDiscussedPersonsSICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getDiscussedPersonsSICount()
    {
        return this._discussedPersonsSIList.size();
    } //-- int getDiscussedPersonsSICount() 

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
     * Method iterateDiscussedPersonsSI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> iterateDiscussedPersonsSI()
    {
        return this._discussedPersonsSIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> iterateDiscussedPersonsSI() 

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
    public void removeAllDiscussedPersonsSI()
    {
        this._discussedPersonsSIList.clear();
    } //-- void removeAllDiscussedPersonsSI() 

    /**
     * Method removeDiscussedPersonsSI
     * 
     * 
     * 
     * @param vDiscussedPersonsSI
     * @return true if the object was removed from the collection.
     */
    public boolean removeDiscussedPersonsSI(gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI vDiscussedPersonsSI)
    {
        boolean removed = _discussedPersonsSIList.remove(vDiscussedPersonsSI);
        return removed;
    } //-- boolean removeDiscussedPersonsSI(gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) 

    /**
     * Method removeDiscussedPersonsSIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI removeDiscussedPersonsSIAt(int index)
    {
        Object obj = this._discussedPersonsSIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI removeDiscussedPersonsSIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vDiscussedPersonsSI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDiscussedPersonsSI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI vDiscussedPersonsSI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._discussedPersonsSIList.size()) {
            throw new IndexOutOfBoundsException("setDiscussedPersonsSI: Index value '" + index + "' not in range [0.." + (this._discussedPersonsSIList.size() - 1) + "]");
        }
        
        this._discussedPersonsSIList.set(index, vDiscussedPersonsSI);
    } //-- void setDiscussedPersonsSI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) 

    /**
     * 
     * 
     * @param vDiscussedPersonsSIArray
     */
    public void setDiscussedPersonsSI(gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI[] vDiscussedPersonsSIArray)
    {
        //-- copy array
        _discussedPersonsSIList.clear();
        
        for (int i = 0; i < vDiscussedPersonsSIArray.length; i++) {
                this._discussedPersonsSIList.add(vDiscussedPersonsSIArray[i]);
        }
    } //-- void setDiscussedPersonsSI(gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI) 

    /**
     * Sets the value of '_discussedPersonsSIList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vDiscussedPersonsSIList the Vector to copy.
     */
    public void setDiscussedPersonsSI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> vDiscussedPersonsSIList)
    {
        // copy vector
        this._discussedPersonsSIList.clear();
        
        this._discussedPersonsSIList.addAll(vDiscussedPersonsSIList);
    } //-- void setDiscussedPersonsSI(java.util.List) 

    /**
     * Sets the value of '_discussedPersonsSIList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param DiscussedPersonsSIVector the Vector to set.
     */
    public void setDiscussedPersonsSIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI> DiscussedPersonsSIVector)
    {
        this._discussedPersonsSIList = DiscussedPersonsSIVector;
    } //-- void setDiscussedPersonsSIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY unmarshal(java.io.Reader) 

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
