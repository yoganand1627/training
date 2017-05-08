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
 * Class ROWCCMN32SO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN32SO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN32SOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> _ROWCCMN32SOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN32SO_ARRAY() 
     {
        super();
        this._ROWCCMN32SOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN32SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN32SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO vROWCCMN32SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN32SOList.size() >= 40) {
            throw new IndexOutOfBoundsException("addROWCCMN32SO has a maximum of 40");
        }
        
        this._ROWCCMN32SOList.add(vROWCCMN32SO);
    } //-- void addROWCCMN32SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN32SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN32SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO vROWCCMN32SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN32SOList.size() >= 40) {
            throw new IndexOutOfBoundsException("addROWCCMN32SO has a maximum of 40");
        }
        
        this._ROWCCMN32SOList.add(index, vROWCCMN32SO);
    } //-- void addROWCCMN32SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN32SO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> enumerateROWCCMN32SO()
    {
        return java.util.Collections.enumeration(this._ROWCCMN32SOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> enumerateROWCCMN32SO() 

    /**
     * Method getROWCCMN32SO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO getROWCCMN32SO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN32SOList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN32SO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN32SOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) _ROWCCMN32SOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO getROWCCMN32SO(int) 

    /**
     * Method getROWCCMN32SO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO[] getROWCCMN32SO()
    {
        int size = this._ROWCCMN32SOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) _ROWCCMN32SOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO[] getROWCCMN32SO() 

    /**
     * Method getROWCCMN32SOAsReference
     * 
     * Returns a reference to '_ROWCCMN32SOList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> getROWCCMN32SOAsReference()
    {
        return this._ROWCCMN32SOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> getROWCCMN32SOAsReference() 

    /**
     * Method getROWCCMN32SOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN32SOCount()
    {
        return this._ROWCCMN32SOList.size();
    } //-- int getROWCCMN32SOCount() 

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
     * Method iterateROWCCMN32SO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> iterateROWCCMN32SO()
    {
        return this._ROWCCMN32SOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> iterateROWCCMN32SO() 

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
    public void removeAllROWCCMN32SO()
    {
        this._ROWCCMN32SOList.clear();
    } //-- void removeAllROWCCMN32SO() 

    /**
     * Method removeROWCCMN32SO
     * 
     * 
     * 
     * @param vROWCCMN32SO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN32SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO vROWCCMN32SO)
    {
        boolean removed = _ROWCCMN32SOList.remove(vROWCCMN32SO);
        return removed;
    } //-- boolean removeROWCCMN32SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) 

    /**
     * Method removeROWCCMN32SOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO removeROWCCMN32SOAt(int index)
    {
        Object obj = this._ROWCCMN32SOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO removeROWCCMN32SOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN32SO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN32SO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO vROWCCMN32SO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN32SOList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN32SO: Index value '" + index + "' not in range [0.." + (this._ROWCCMN32SOList.size() - 1) + "]");
        }
        
        this._ROWCCMN32SOList.set(index, vROWCCMN32SO);
    } //-- void setROWCCMN32SO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) 

    /**
     * 
     * 
     * @param vROWCCMN32SOArray
     */
    public void setROWCCMN32SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO[] vROWCCMN32SOArray)
    {
        //-- copy array
        _ROWCCMN32SOList.clear();
        
        for (int i = 0; i < vROWCCMN32SOArray.length; i++) {
                this._ROWCCMN32SOList.add(vROWCCMN32SOArray[i]);
        }
    } //-- void setROWCCMN32SO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO) 

    /**
     * Sets the value of '_ROWCCMN32SOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN32SOList the Vector to copy.
     */
    public void setROWCCMN32SO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> vROWCCMN32SOList)
    {
        // copy vector
        this._ROWCCMN32SOList.clear();
        
        this._ROWCCMN32SOList.addAll(vROWCCMN32SOList);
    } //-- void setROWCCMN32SO(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN32SOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN32SOVector the Vector to set.
     */
    public void setROWCCMN32SOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO> ROWCCMN32SOVector)
    {
        this._ROWCCMN32SOList = ROWCCMN32SOVector;
    } //-- void setROWCCMN32SOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN32SO_ARRAY unmarshal(java.io.Reader) 

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
