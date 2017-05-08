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
 * Class ROWCCMN33SO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN33SO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN33SOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> _ROWCCMN33SOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN33SO_ARRAY() 
     {
        super();
        this._ROWCCMN33SOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN33SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN33SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO vROWCCMN33SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN33SOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN33SO has a maximum of 50");
        }
        
        this._ROWCCMN33SOList.add(vROWCCMN33SO);
    } //-- void addROWCCMN33SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN33SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN33SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO vROWCCMN33SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN33SOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWCCMN33SO has a maximum of 50");
        }
        
        this._ROWCCMN33SOList.add(index, vROWCCMN33SO);
    } //-- void addROWCCMN33SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN33SO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> enumerateROWCCMN33SO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN33SOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> enumerateROWCCMN33SO() 

    /**
     * Method getROWCCMN33SO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO getROWCCMN33SO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN33SOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN33SO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN33SOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) _ROWCCMN33SOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO getROWCCMN33SO(int) 

    /**
     * Method getROWCCMN33SO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO[] getROWCCMN33SO()
    {
        int size = this._ROWCCMN33SOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) _ROWCCMN33SOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO[] getROWCCMN33SO() 

    /**
     * Method getROWCCMN33SOAsReference
     * 
     * Returns a reference to '_ROWCCMN33SOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> getROWCCMN33SOAsReference()
    {
        return this._ROWCCMN33SOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> getROWCCMN33SOAsReference() 

    /**
     * Method getROWCCMN33SOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN33SOCount()
    {
        return this._ROWCCMN33SOList.size();
    } //-- int getROWCCMN33SOCount() 

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
     * Method iterateROWCCMN33SO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> iterateROWCCMN33SO()
    {
        return this._ROWCCMN33SOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> iterateROWCCMN33SO() 

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
    public void removeAllROWCCMN33SO()
    {
        this._ROWCCMN33SOList.clear();
    } //-- void removeAllROWCCMN33SO() 

    /**
     * Method removeROWCCMN33SO
     * 
     * 
     * 
     * @param vROWCCMN33SO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN33SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO vROWCCMN33SO)
    {
        boolean removed = _ROWCCMN33SOList.remove(vROWCCMN33SO);
        return removed;
    } //-- boolean removeROWCCMN33SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) 

    /**
     * Method removeROWCCMN33SOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO removeROWCCMN33SOAt(int index)
    {
        Object obj = this._ROWCCMN33SOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO removeROWCCMN33SOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN33SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN33SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO vROWCCMN33SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN33SOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN33SO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN33SOList.size() - 1) + "]");
        }
        
        this._ROWCCMN33SOList.set(index, vROWCCMN33SO);
    } //-- void setROWCCMN33SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) 

    /**
     * 
     * 
     * @param vROWCCMN33SOArray
     */
    public void setROWCCMN33SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO[] vROWCCMN33SOArray)
    {
        //-- copy array
        _ROWCCMN33SOList.clear();
        
        for (int i = 0; i < vROWCCMN33SOArray.length; i++) {
                this._ROWCCMN33SOList.add(vROWCCMN33SOArray[i]);
        }
    } //-- void setROWCCMN33SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO) 

    /**
     * Sets the value of '_ROWCCMN33SOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN33SOList the Vector to copy.
     */
    public void setROWCCMN33SO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> vROWCCMN33SOList)
    {
        // copy vector
        this._ROWCCMN33SOList.clear();
        
        this._ROWCCMN33SOList.addAll(vROWCCMN33SOList);
    } //-- void setROWCCMN33SO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN33SOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN33SOVector the Vector to set.
     */
    public void setROWCCMN33SOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO> ROWCCMN33SOVector)
    {
        this._ROWCCMN33SOList = ROWCCMN33SOVector;
    } //-- void setROWCCMN33SOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN33SO_ARRAY unmarshal(java.io.Reader) 

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
