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
 * Class ROWCCMNB8DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMNB8DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMNB8DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> _ROWCCMNB8DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMNB8DO_ARRAY() 
     {
        super();
        this._ROWCCMNB8DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMNB8DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMNB8DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO vROWCCMNB8DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMNB8DOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCCMNB8DO has a maximum of 10");
        }
        
        this._ROWCCMNB8DOList.add(vROWCCMNB8DO);
    } //-- void addROWCCMNB8DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMNB8DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMNB8DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO vROWCCMNB8DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMNB8DOList.size() >= 10) {
            throw new IndexOutOfBoundsException("addROWCCMNB8DO has a maximum of 10");
        }
        
        this._ROWCCMNB8DOList.add(index, vROWCCMNB8DO);
    } //-- void addROWCCMNB8DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMNB8DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> enumerateROWCCMNB8DO()
    {
        return java.util.Collections.enumeration(this._ROWCCMNB8DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> enumerateROWCCMNB8DO() 

    /**
     * Method getROWCCMNB8DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO getROWCCMNB8DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMNB8DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMNB8DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMNB8DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) _ROWCCMNB8DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO getROWCCMNB8DO(int) 

    /**
     * Method getROWCCMNB8DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO[] getROWCCMNB8DO()
    {
        int size = this._ROWCCMNB8DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) _ROWCCMNB8DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO[] getROWCCMNB8DO() 

    /**
     * Method getROWCCMNB8DOAsReference
     * 
     * Returns a reference to '_ROWCCMNB8DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> getROWCCMNB8DOAsReference()
    {
        return this._ROWCCMNB8DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> getROWCCMNB8DOAsReference() 

    /**
     * Method getROWCCMNB8DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMNB8DOCount()
    {
        return this._ROWCCMNB8DOList.size();
    } //-- int getROWCCMNB8DOCount() 

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
     * Method iterateROWCCMNB8DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> iterateROWCCMNB8DO()
    {
        return this._ROWCCMNB8DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> iterateROWCCMNB8DO() 

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
    public void removeAllROWCCMNB8DO()
    {
        this._ROWCCMNB8DOList.clear();
    } //-- void removeAllROWCCMNB8DO() 

    /**
     * Method removeROWCCMNB8DO
     * 
     * 
     * 
     * @param vROWCCMNB8DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMNB8DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO vROWCCMNB8DO)
    {
        boolean removed = _ROWCCMNB8DOList.remove(vROWCCMNB8DO);
        return removed;
    } //-- boolean removeROWCCMNB8DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) 

    /**
     * Method removeROWCCMNB8DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO removeROWCCMNB8DOAt(int index)
    {
        Object obj = this._ROWCCMNB8DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO removeROWCCMNB8DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMNB8DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMNB8DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO vROWCCMNB8DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMNB8DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMNB8DO: Index value '" + index + "' not in range [0.." + (this._ROWCCMNB8DOList.size() - 1) + "]");
        }
        
        this._ROWCCMNB8DOList.set(index, vROWCCMNB8DO);
    } //-- void setROWCCMNB8DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) 

    /**
     * 
     * 
     * @param vROWCCMNB8DOArray
     */
    public void setROWCCMNB8DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO[] vROWCCMNB8DOArray)
    {
        //-- copy array
        _ROWCCMNB8DOList.clear();
        
        for (int i = 0; i < vROWCCMNB8DOArray.length; i++) {
                this._ROWCCMNB8DOList.add(vROWCCMNB8DOArray[i]);
        }
    } //-- void setROWCCMNB8DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO) 

    /**
     * Sets the value of '_ROWCCMNB8DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMNB8DOList the Vector to copy.
     */
    public void setROWCCMNB8DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> vROWCCMNB8DOList)
    {
        // copy vector
        this._ROWCCMNB8DOList.clear();
        
        this._ROWCCMNB8DOList.addAll(vROWCCMNB8DOList);
    } //-- void setROWCCMNB8DO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMNB8DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMNB8DOVector the Vector to set.
     */
    public void setROWCCMNB8DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO> ROWCCMNB8DOVector)
    {
        this._ROWCCMNB8DOList = ROWCCMNB8DOVector;
    } //-- void setROWCCMNB8DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO_ARRAY unmarshal(java.io.Reader) 

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
