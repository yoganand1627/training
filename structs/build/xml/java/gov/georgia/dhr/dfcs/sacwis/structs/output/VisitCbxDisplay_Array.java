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
 * Class VisitCbxDisplay_Array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class VisitCbxDisplay_Array extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _visitCbxDisplayList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> _visitCbxDisplayList;


      //----------------/
     //- Constructors -/
    //----------------/

    public VisitCbxDisplay_Array() 
     {
        super();
        this._visitCbxDisplayList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vVisitCbxDisplay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addVisitCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay vVisitCbxDisplay)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._visitCbxDisplayList.size() >= 10) {
            throw new IndexOutOfBoundsException("addVisitCbxDisplay has a maximum of 10");
        }
        
        this._visitCbxDisplayList.add(vVisitCbxDisplay);
    } //-- void addVisitCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) 

    /**
     * 
     * 
     * @param index
     * @param vVisitCbxDisplay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addVisitCbxDisplay(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay vVisitCbxDisplay)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._visitCbxDisplayList.size() >= 10) {
            throw new IndexOutOfBoundsException("addVisitCbxDisplay has a maximum of 10");
        }
        
        this._visitCbxDisplayList.add(index, vVisitCbxDisplay);
    } //-- void addVisitCbxDisplay(int, gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateVisitCbxDisplay
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> enumerateVisitCbxDisplay()
    {
        return java.util.Collections.enumeration(this._visitCbxDisplayList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> enumerateVisitCbxDisplay() 

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
     * Method getVisitCbxDisplay
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay getVisitCbxDisplay(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._visitCbxDisplayList.size()) {
            throw new IndexOutOfBoundsException("getVisitCbxDisplay: Index value '" + index + "' not in range [0.." + (this._visitCbxDisplayList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) _visitCbxDisplayList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay getVisitCbxDisplay(int) 

    /**
     * Method getVisitCbxDisplay
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay[] getVisitCbxDisplay()
    {
        int size = this._visitCbxDisplayList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) _visitCbxDisplayList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay[] getVisitCbxDisplay() 

    /**
     * Method getVisitCbxDisplayAsReference
     * 
     * Returns a reference to '_visitCbxDisplayList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> getVisitCbxDisplayAsReference()
    {
        return this._visitCbxDisplayList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> getVisitCbxDisplayAsReference() 

    /**
     * Method getVisitCbxDisplayCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getVisitCbxDisplayCount()
    {
        return this._visitCbxDisplayList.size();
    } //-- int getVisitCbxDisplayCount() 

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
     * Method iterateVisitCbxDisplay
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> iterateVisitCbxDisplay()
    {
        return this._visitCbxDisplayList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> iterateVisitCbxDisplay() 

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
    public void removeAllVisitCbxDisplay()
    {
        this._visitCbxDisplayList.clear();
    } //-- void removeAllVisitCbxDisplay() 

    /**
     * Method removeVisitCbxDisplay
     * 
     * 
     * 
     * @param vVisitCbxDisplay
     * @return true if the object was removed from the collection.
     */
    public boolean removeVisitCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay vVisitCbxDisplay)
    {
        boolean removed = _visitCbxDisplayList.remove(vVisitCbxDisplay);
        return removed;
    } //-- boolean removeVisitCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) 

    /**
     * Method removeVisitCbxDisplayAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay removeVisitCbxDisplayAt(int index)
    {
        Object obj = this._visitCbxDisplayList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay removeVisitCbxDisplayAt(int) 

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
     * 
     * 
     * @param index
     * @param vVisitCbxDisplay
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setVisitCbxDisplay(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay vVisitCbxDisplay)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._visitCbxDisplayList.size()) {
            throw new IndexOutOfBoundsException("setVisitCbxDisplay: Index value '" + index + "' not in range [0.." + (this._visitCbxDisplayList.size() - 1) + "]");
        }
        
        this._visitCbxDisplayList.set(index, vVisitCbxDisplay);
    } //-- void setVisitCbxDisplay(int, gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) 

    /**
     * 
     * 
     * @param vVisitCbxDisplayArray
     */
    public void setVisitCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay[] vVisitCbxDisplayArray)
    {
        //-- copy array
        _visitCbxDisplayList.clear();
        
        for (int i = 0; i < vVisitCbxDisplayArray.length; i++) {
                this._visitCbxDisplayList.add(vVisitCbxDisplayArray[i]);
        }
    } //-- void setVisitCbxDisplay(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay) 

    /**
     * Sets the value of '_visitCbxDisplayList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vVisitCbxDisplayList the Vector to copy.
     */
    public void setVisitCbxDisplay(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> vVisitCbxDisplayList)
    {
        // copy vector
        this._visitCbxDisplayList.clear();
        
        this._visitCbxDisplayList.addAll(vVisitCbxDisplayList);
    } //-- void setVisitCbxDisplay(java.util.List) 

    /**
     * Sets the value of '_visitCbxDisplayList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param VisitCbxDisplayVector the Vector to set.
     */
    public void setVisitCbxDisplayAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay> VisitCbxDisplayVector)
    {
        this._visitCbxDisplayList = VisitCbxDisplayVector;
    } //-- void setVisitCbxDisplayAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array unmarshal(java.io.Reader) 

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
