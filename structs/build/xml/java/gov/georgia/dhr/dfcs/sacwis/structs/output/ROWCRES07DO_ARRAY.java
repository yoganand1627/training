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
 * Class ROWCRES07DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES07DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES07DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> _ROWCRES07DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES07DO_ARRAY() 
     {
        super();
        this._ROWCRES07DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCRES07DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES07DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO vROWCRES07DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES07DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCRES07DO has a maximum of 100");
        }
        
        this._ROWCRES07DOList.add(vROWCRES07DO);
    } //-- void addROWCRES07DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES07DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES07DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO vROWCRES07DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES07DOList.size() >= 100) {
            throw new IndexOutOfBoundsException("addROWCRES07DO has a maximum of 100");
        }
        
        this._ROWCRES07DOList.add(index, vROWCRES07DO);
    } //-- void addROWCRES07DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCRES07DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> enumerateROWCRES07DO()
    {
        return java.util.Collections.enumeration(this._ROWCRES07DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> enumerateROWCRES07DO() 

    /**
     * Method getROWCRES07DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO getROWCRES07DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES07DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCRES07DO: Index value '" + index + "' not in range [0.." + (this._ROWCRES07DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) _ROWCRES07DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO getROWCRES07DO(int) 

    /**
     * Method getROWCRES07DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO[] getROWCRES07DO()
    {
        int size = this._ROWCRES07DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) _ROWCRES07DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO[] getROWCRES07DO() 

    /**
     * Method getROWCRES07DOAsReference
     * 
     * Returns a reference to '_ROWCRES07DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> getROWCRES07DOAsReference()
    {
        return this._ROWCRES07DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> getROWCRES07DOAsReference() 

    /**
     * Method getROWCRES07DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCRES07DOCount()
    {
        return this._ROWCRES07DOList.size();
    } //-- int getROWCRES07DOCount() 

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
     * Method iterateROWCRES07DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> iterateROWCRES07DO()
    {
        return this._ROWCRES07DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> iterateROWCRES07DO() 

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
    public void removeAllROWCRES07DO()
    {
        this._ROWCRES07DOList.clear();
    } //-- void removeAllROWCRES07DO() 

    /**
     * Method removeROWCRES07DO
     * 
     * 
     * 
     * @param vROWCRES07DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCRES07DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO vROWCRES07DO)
    {
        boolean removed = _ROWCRES07DOList.remove(vROWCRES07DO);
        return removed;
    } //-- boolean removeROWCRES07DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) 

    /**
     * Method removeROWCRES07DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO removeROWCRES07DOAt(int index)
    {
        Object obj = this._ROWCRES07DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO removeROWCRES07DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES07DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCRES07DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO vROWCRES07DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES07DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCRES07DO: Index value '" + index + "' not in range [0.." + (this._ROWCRES07DOList.size() - 1) + "]");
        }
        
        this._ROWCRES07DOList.set(index, vROWCRES07DO);
    } //-- void setROWCRES07DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) 

    /**
     * 
     * 
     * @param vROWCRES07DOArray
     */
    public void setROWCRES07DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO[] vROWCRES07DOArray)
    {
        //-- copy array
        _ROWCRES07DOList.clear();
        
        for (int i = 0; i < vROWCRES07DOArray.length; i++) {
                this._ROWCRES07DOList.add(vROWCRES07DOArray[i]);
        }
    } //-- void setROWCRES07DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO) 

    /**
     * Sets the value of '_ROWCRES07DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCRES07DOList the Vector to copy.
     */
    public void setROWCRES07DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> vROWCRES07DOList)
    {
        // copy vector
        this._ROWCRES07DOList.clear();
        
        this._ROWCRES07DOList.addAll(vROWCRES07DOList);
    } //-- void setROWCRES07DO(java.util.List) 

    /**
     * Sets the value of '_ROWCRES07DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCRES07DOVector the Vector to set.
     */
    public void setROWCRES07DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO> ROWCRES07DOVector)
    {
        this._ROWCRES07DOList = ROWCRES07DOVector;
    } //-- void setROWCRES07DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY unmarshal(java.io.Reader) 

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
