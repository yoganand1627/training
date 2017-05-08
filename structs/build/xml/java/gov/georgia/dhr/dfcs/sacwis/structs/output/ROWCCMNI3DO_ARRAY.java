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
 * Class ROWCCMNI3DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMNI3DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMNI3DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> _ROWCCMNI3DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMNI3DO_ARRAY() 
     {
        super();
        this._ROWCCMNI3DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMNI3DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMNI3DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO vROWCCMNI3DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMNI3DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMNI3DO has a maximum of 100");
        }
        
        this._ROWCCMNI3DOList.add(vROWCCMNI3DO);
    } //-- void addROWCCMNI3DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMNI3DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMNI3DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO vROWCCMNI3DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMNI3DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCCMNI3DO has a maximum of 100");
        }
        
        this._ROWCCMNI3DOList.add(index, vROWCCMNI3DO);
    } //-- void addROWCCMNI3DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMNI3DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> enumerateROWCCMNI3DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMNI3DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> enumerateROWCCMNI3DO() 

    /**
     * Method getROWCCMNI3DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO getROWCCMNI3DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMNI3DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMNI3DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMNI3DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) _ROWCCMNI3DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO getROWCCMNI3DO(int) 

    /**
     * Method getROWCCMNI3DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO[] getROWCCMNI3DO()
    {
        int size = this._ROWCCMNI3DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) _ROWCCMNI3DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO[] getROWCCMNI3DO() 

    /**
     * Method getROWCCMNI3DOAsReference
     * 
     * Returns a reference to '_ROWCCMNI3DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> getROWCCMNI3DOAsReference()
    {
        return this._ROWCCMNI3DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> getROWCCMNI3DOAsReference() 

    /**
     * Method getROWCCMNI3DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMNI3DOCount()
    {
        return this._ROWCCMNI3DOList.size();
    } //-- int getROWCCMNI3DOCount() 

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
     * Method iterateROWCCMNI3DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> iterateROWCCMNI3DO()
    {
        return this._ROWCCMNI3DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> iterateROWCCMNI3DO() 

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
    public void removeAllROWCCMNI3DO()
    {
        this._ROWCCMNI3DOList.clear();
    } //-- void removeAllROWCCMNI3DO() 

    /**
     * Method removeROWCCMNI3DO
     * 
     * 
     * 
     * @param vROWCCMNI3DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMNI3DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO vROWCCMNI3DO)
    {
        boolean removed = _ROWCCMNI3DOList.remove(vROWCCMNI3DO);
        return removed;
    } //-- boolean removeROWCCMNI3DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) 

    /**
     * Method removeROWCCMNI3DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO removeROWCCMNI3DOAt(int index)
    {
        Object obj = this._ROWCCMNI3DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO removeROWCCMNI3DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMNI3DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMNI3DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO vROWCCMNI3DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMNI3DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMNI3DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMNI3DOList.size() - 1) + "]");
        }
        
        this._ROWCCMNI3DOList.set(index, vROWCCMNI3DO);
    } //-- void setROWCCMNI3DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) 

    /**
     * 
     * 
     * @param vROWCCMNI3DOArray
     */
    public void setROWCCMNI3DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO[] vROWCCMNI3DOArray)
    {
        //-- copy array
        _ROWCCMNI3DOList.clear();
        
        for (int i = 0; i < vROWCCMNI3DOArray.length; i++) {
                this._ROWCCMNI3DOList.add(vROWCCMNI3DOArray[i]);
        }
    } //-- void setROWCCMNI3DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO) 

    /**
     * Sets the value of '_ROWCCMNI3DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMNI3DOList the Vector to copy.
     */
    public void setROWCCMNI3DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> vROWCCMNI3DOList)
    {
        // copy vector
        this._ROWCCMNI3DOList.clear();
        
        this._ROWCCMNI3DOList.addAll(vROWCCMNI3DOList);
    } //-- void setROWCCMNI3DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMNI3DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMNI3DOVector the Vector to set.
     */
    public void setROWCCMNI3DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO> ROWCCMNI3DOVector)
    {
        this._ROWCCMNI3DOList = ROWCCMNI3DOVector;
    } //-- void setROWCCMNI3DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY unmarshal(java.io.Reader) 

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
