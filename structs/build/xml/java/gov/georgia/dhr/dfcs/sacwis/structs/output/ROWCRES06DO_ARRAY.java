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
 * Class ROWCRES06DO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCRES06DO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCRES06DOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> _ROWCRES06DOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCRES06DO_ARRAY() 
     {
        super();
        this._ROWCRES06DOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCRES06DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES06DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO vROWCRES06DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES06DOList.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCRES06DO has a maximum of 20");
        }
        
        this._ROWCRES06DOList.add(vROWCRES06DO);
    } //-- void addROWCRES06DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES06DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCRES06DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO vROWCRES06DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCRES06DOList.size() >= 20) {
            throw new IndexOutOfBoundsException("addROWCRES06DO has a maximum of 20");
        }
        
        this._ROWCRES06DOList.add(index, vROWCRES06DO);
    } //-- void addROWCRES06DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCRES06DO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> enumerateROWCRES06DO()
    {
        return java.util.Collections.enumeration(this._ROWCRES06DOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> enumerateROWCRES06DO() 

    /**
     * Method getROWCRES06DO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO getROWCRES06DO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES06DOList.size()) {
            throw new IndexOutOfBoundsException("getROWCRES06DO: Index value '" + index + "' not in range [0.." + (this._ROWCRES06DOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) _ROWCRES06DOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO getROWCRES06DO(int) 

    /**
     * Method getROWCRES06DO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO[] getROWCRES06DO()
    {
        int size = this._ROWCRES06DOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) _ROWCRES06DOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO[] getROWCRES06DO() 

    /**
     * Method getROWCRES06DOAsReference
     * 
     * Returns a reference to '_ROWCRES06DOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> getROWCRES06DOAsReference()
    {
        return this._ROWCRES06DOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> getROWCRES06DOAsReference() 

    /**
     * Method getROWCRES06DOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCRES06DOCount()
    {
        return this._ROWCRES06DOList.size();
    } //-- int getROWCRES06DOCount() 

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
     * Method iterateROWCRES06DO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> iterateROWCRES06DO()
    {
        return this._ROWCRES06DOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> iterateROWCRES06DO() 

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
    public void removeAllROWCRES06DO()
    {
        this._ROWCRES06DOList.clear();
    } //-- void removeAllROWCRES06DO() 

    /**
     * Method removeROWCRES06DO
     * 
     * 
     * 
     * @param vROWCRES06DO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCRES06DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO vROWCRES06DO)
    {
        boolean removed = _ROWCRES06DOList.remove(vROWCRES06DO);
        return removed;
    } //-- boolean removeROWCRES06DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) 

    /**
     * Method removeROWCRES06DOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO removeROWCRES06DOAt(int index)
    {
        Object obj = this._ROWCRES06DOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO removeROWCRES06DOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCRES06DO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCRES06DO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO vROWCRES06DO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCRES06DOList.size()) {
            throw new IndexOutOfBoundsException("setROWCRES06DO: Index value '" + index + "' not in range [0.." + (this._ROWCRES06DOList.size() - 1) + "]");
        }
        
        this._ROWCRES06DOList.set(index, vROWCRES06DO);
    } //-- void setROWCRES06DO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) 

    /**
     * 
     * 
     * @param vROWCRES06DOArray
     */
    public void setROWCRES06DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO[] vROWCRES06DOArray)
    {
        //-- copy array
        _ROWCRES06DOList.clear();
        
        for (int i = 0; i < vROWCRES06DOArray.length; i++) {
                this._ROWCRES06DOList.add(vROWCRES06DOArray[i]);
        }
    } //-- void setROWCRES06DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO) 

    /**
     * Sets the value of '_ROWCRES06DOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCRES06DOList the Vector to copy.
     */
    public void setROWCRES06DO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> vROWCRES06DOList)
    {
        // copy vector
        this._ROWCRES06DOList.clear();
        
        this._ROWCRES06DOList.addAll(vROWCRES06DOList);
    } //-- void setROWCRES06DO(java.util.List) 

    /**
     * Sets the value of '_ROWCRES06DOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCRES06DOVector the Vector to set.
     */
    public void setROWCRES06DOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO> ROWCRES06DOVector)
    {
        this._ROWCRES06DOList = ROWCRES06DOVector;
    } //-- void setROWCRES06DOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06DO_ARRAY unmarshal(java.io.Reader) 

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
