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
 * Class ROWCCMN57DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN57DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN57DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> _ROWCCMN57DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN57DO_ARRAY() 
     {
        super();
        this._ROWCCMN57DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN57DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN57DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO vROWCCMN57DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN57DOList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCCMN57DO has a maximum of 500");
        }
        
        this._ROWCCMN57DOList.add(vROWCCMN57DO);
    } //-- void addROWCCMN57DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN57DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN57DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO vROWCCMN57DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN57DOList.size() >= 500) {
            throw new IndexOutOfBoundsException("addROWCCMN57DO has a maximum of 500");
        }
        
        this._ROWCCMN57DOList.add(index, vROWCCMN57DO);
    } //-- void addROWCCMN57DO(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN57DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> enumerateROWCCMN57DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN57DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> enumerateROWCCMN57DO() 

    /**
     * Method getROWCCMN57DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO getROWCCMN57DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN57DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN57DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN57DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) _ROWCCMN57DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO getROWCCMN57DO(int) 

    /**
     * Method getROWCCMN57DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO[] getROWCCMN57DO()
    {
        int size = this._ROWCCMN57DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) _ROWCCMN57DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO[] getROWCCMN57DO() 

    /**
     * Method getROWCCMN57DOAsReference
     * 
     * Returns a reference to '_ROWCCMN57DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> getROWCCMN57DOAsReference()
    {
        return this._ROWCCMN57DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> getROWCCMN57DOAsReference() 

    /**
     * Method getROWCCMN57DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN57DOCount()
    {
        return this._ROWCCMN57DOList.size();
    } //-- int getROWCCMN57DOCount() 

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
     * Method iterateROWCCMN57DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> iterateROWCCMN57DO()
    {
        return this._ROWCCMN57DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> iterateROWCCMN57DO() 

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
    public void removeAllROWCCMN57DO()
    {
        this._ROWCCMN57DOList.clear();
    } //-- void removeAllROWCCMN57DO() 

    /**
     * Method removeROWCCMN57DO
     * 
     * 
     * 
     * @param vROWCCMN57DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN57DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO vROWCCMN57DO)
    {
        boolean removed = _ROWCCMN57DOList.remove(vROWCCMN57DO);
        return removed;
    } //-- boolean removeROWCCMN57DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) 

    /**
     * Method removeROWCCMN57DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO removeROWCCMN57DOAt(int index)
    {
        Object obj = this._ROWCCMN57DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO removeROWCCMN57DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN57DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN57DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO vROWCCMN57DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN57DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN57DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN57DOList.size() - 1) + "]");
        }
        
        this._ROWCCMN57DOList.set(index, vROWCCMN57DO);
    } //-- void setROWCCMN57DO(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) 

    /**
     * 
     * 
     * @param vROWCCMN57DOArray
     */
    public void setROWCCMN57DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO[] vROWCCMN57DOArray)
    {
        //-- copy array
        _ROWCCMN57DOList.clear();
        
        for (int i = 0; i < vROWCCMN57DOArray.length; i++) {
                this._ROWCCMN57DOList.add(vROWCCMN57DOArray[i]);
        }
    } //-- void setROWCCMN57DO(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO) 

    /**
     * Sets the value of '_ROWCCMN57DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN57DOList the Vector to copy.
     */
    public void setROWCCMN57DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> vROWCCMN57DOList)
    {
        // copy vector
        this._ROWCCMN57DOList.clear();
        
        this._ROWCCMN57DOList.addAll(vROWCCMN57DOList);
    } //-- void setROWCCMN57DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN57DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN57DOVector the Vector to set.
     */
    public void setROWCCMN57DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO> ROWCCMN57DOVector)
    {
        this._ROWCCMN57DOList = ROWCCMN57DOVector;
    } //-- void setROWCCMN57DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY unmarshal(java.io.Reader) 

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
