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
 * Class ROWCCMN33SI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN33SI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN33SIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> _ROWCCMN33SIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN33SI_ARRAY() 
     {
        super();
        this._ROWCCMN33SIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN33SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN33SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI vROWCCMN33SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN33SIList.size() >= 40) {
            throw new IndexOutOfBoundsException("addROWCCMN33SI has a maximum of 40");
        }
        
        this._ROWCCMN33SIList.add(vROWCCMN33SI);
    } //-- void addROWCCMN33SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN33SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN33SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI vROWCCMN33SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN33SIList.size() >= 40) {
            throw new IndexOutOfBoundsException("addROWCCMN33SI has a maximum of 40");
        }
        
        this._ROWCCMN33SIList.add(index, vROWCCMN33SI);
    } //-- void addROWCCMN33SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN33SI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> enumerateROWCCMN33SI()
    {
        return java.util.Collections.enumeration(this._ROWCCMN33SIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> enumerateROWCCMN33SI() 

    /**
     * Method getROWCCMN33SI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI getROWCCMN33SI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN33SIList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN33SI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN33SIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) _ROWCCMN33SIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI getROWCCMN33SI(int) 

    /**
     * Method getROWCCMN33SI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI[] getROWCCMN33SI()
    {
        int size = this._ROWCCMN33SIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) _ROWCCMN33SIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI[] getROWCCMN33SI() 

    /**
     * Method getROWCCMN33SIAsReference
     * 
     * Returns a reference to '_ROWCCMN33SIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> getROWCCMN33SIAsReference()
    {
        return this._ROWCCMN33SIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> getROWCCMN33SIAsReference() 

    /**
     * Method getROWCCMN33SICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN33SICount()
    {
        return this._ROWCCMN33SIList.size();
    } //-- int getROWCCMN33SICount() 

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
     * Method iterateROWCCMN33SI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> iterateROWCCMN33SI()
    {
        return this._ROWCCMN33SIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> iterateROWCCMN33SI() 

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
    public void removeAllROWCCMN33SI()
    {
        this._ROWCCMN33SIList.clear();
    } //-- void removeAllROWCCMN33SI() 

    /**
     * Method removeROWCCMN33SI
     * 
     * 
     * 
     * @param vROWCCMN33SI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN33SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI vROWCCMN33SI)
    {
        boolean removed = _ROWCCMN33SIList.remove(vROWCCMN33SI);
        return removed;
    } //-- boolean removeROWCCMN33SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) 

    /**
     * Method removeROWCCMN33SIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI removeROWCCMN33SIAt(int index)
    {
        Object obj = this._ROWCCMN33SIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI removeROWCCMN33SIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN33SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN33SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI vROWCCMN33SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN33SIList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN33SI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN33SIList.size() - 1) + "]");
        }
        
        this._ROWCCMN33SIList.set(index, vROWCCMN33SI);
    } //-- void setROWCCMN33SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) 

    /**
     * 
     * 
     * @param vROWCCMN33SIArray
     */
    public void setROWCCMN33SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI[] vROWCCMN33SIArray)
    {
        //-- copy array
        _ROWCCMN33SIList.clear();
        
        for (int i = 0; i < vROWCCMN33SIArray.length; i++) {
                this._ROWCCMN33SIList.add(vROWCCMN33SIArray[i]);
        }
    } //-- void setROWCCMN33SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI) 

    /**
     * Sets the value of '_ROWCCMN33SIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN33SIList the Vector to copy.
     */
    public void setROWCCMN33SI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> vROWCCMN33SIList)
    {
        // copy vector
        this._ROWCCMN33SIList.clear();
        
        this._ROWCCMN33SIList.addAll(vROWCCMN33SIList);
    } //-- void setROWCCMN33SI(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN33SIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN33SIVector the Vector to set.
     */
    public void setROWCCMN33SIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI> ROWCCMN33SIVector)
    {
        this._ROWCCMN33SIList = ROWCCMN33SIVector;
    } //-- void setROWCCMN33SIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN33SI_ARRAY unmarshal(java.io.Reader) 

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
