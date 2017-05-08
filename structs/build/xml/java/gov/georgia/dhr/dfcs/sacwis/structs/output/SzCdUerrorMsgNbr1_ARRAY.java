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
 * Class SzCdUerrorMsgNbr1_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SzCdUerrorMsgNbr1_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROW_ERROR_MAPPINGList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> _ROW_ERROR_MAPPINGList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SzCdUerrorMsgNbr1_ARRAY() 
     {
        super();
        this._ROW_ERROR_MAPPINGList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROW_ERROR_MAPPING
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROW_ERROR_MAPPING(gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING vROW_ERROR_MAPPING)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROW_ERROR_MAPPINGList.size() >= 20) {
            throw new IndexOutOfBoundsException("addROW_ERROR_MAPPING has a maximum of 20");
        }
        
        this._ROW_ERROR_MAPPINGList.add(vROW_ERROR_MAPPING);
    } //-- void addROW_ERROR_MAPPING(gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) 

    /**
     * 
     * 
     * @param index
     * @param vROW_ERROR_MAPPING
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROW_ERROR_MAPPING(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING vROW_ERROR_MAPPING)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROW_ERROR_MAPPINGList.size() >= 20) {
            throw new IndexOutOfBoundsException("addROW_ERROR_MAPPING has a maximum of 20");
        }
        
        this._ROW_ERROR_MAPPINGList.add(index, vROW_ERROR_MAPPING);
    } //-- void addROW_ERROR_MAPPING(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROW_ERROR_MAPPING
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> enumerateROW_ERROR_MAPPING()
    {
        return java.util.Collections.enumeration(this._ROW_ERROR_MAPPINGList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> enumerateROW_ERROR_MAPPING() 

    /**
     * Method getROW_ERROR_MAPPING
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING getROW_ERROR_MAPPING(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROW_ERROR_MAPPINGList.size()) {
            throw new IndexOutOfBoundsException("getROW_ERROR_MAPPING: Index value '" + index + "' not in range [0.." + (this._ROW_ERROR_MAPPINGList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) _ROW_ERROR_MAPPINGList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING getROW_ERROR_MAPPING(int) 

    /**
     * Method getROW_ERROR_MAPPING
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING[] getROW_ERROR_MAPPING()
    {
        int size = this._ROW_ERROR_MAPPINGList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) _ROW_ERROR_MAPPINGList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING[] getROW_ERROR_MAPPING() 

    /**
     * Method getROW_ERROR_MAPPINGAsReference
     * 
     * Returns a reference to '_ROW_ERROR_MAPPINGList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> getROW_ERROR_MAPPINGAsReference()
    {
        return this._ROW_ERROR_MAPPINGList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> getROW_ERROR_MAPPINGAsReference() 

    /**
     * Method getROW_ERROR_MAPPINGCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROW_ERROR_MAPPINGCount()
    {
        return this._ROW_ERROR_MAPPINGList.size();
    } //-- int getROW_ERROR_MAPPINGCount() 

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
     * Method iterateROW_ERROR_MAPPING
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> iterateROW_ERROR_MAPPING()
    {
        return this._ROW_ERROR_MAPPINGList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> iterateROW_ERROR_MAPPING() 

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
    public void removeAllROW_ERROR_MAPPING()
    {
        this._ROW_ERROR_MAPPINGList.clear();
    } //-- void removeAllROW_ERROR_MAPPING() 

    /**
     * Method removeROW_ERROR_MAPPING
     * 
     * 
     * 
     * @param vROW_ERROR_MAPPING
     * @return true if the object was removed from the collection.
     */
    public boolean removeROW_ERROR_MAPPING(gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING vROW_ERROR_MAPPING)
    {
        boolean removed = _ROW_ERROR_MAPPINGList.remove(vROW_ERROR_MAPPING);
        return removed;
    } //-- boolean removeROW_ERROR_MAPPING(gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) 

    /**
     * Method removeROW_ERROR_MAPPINGAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING removeROW_ERROR_MAPPINGAt(int index)
    {
        Object obj = this._ROW_ERROR_MAPPINGList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING removeROW_ERROR_MAPPINGAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROW_ERROR_MAPPING
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROW_ERROR_MAPPING(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING vROW_ERROR_MAPPING)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROW_ERROR_MAPPINGList.size()) {
            throw new IndexOutOfBoundsException("setROW_ERROR_MAPPING: Index value '" + index + "' not in range [0.." + (this._ROW_ERROR_MAPPINGList.size() - 1) + "]");
        }
        
        this._ROW_ERROR_MAPPINGList.set(index, vROW_ERROR_MAPPING);
    } //-- void setROW_ERROR_MAPPING(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) 

    /**
     * 
     * 
     * @param vROW_ERROR_MAPPINGArray
     */
    public void setROW_ERROR_MAPPING(gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING[] vROW_ERROR_MAPPINGArray)
    {
        //-- copy array
        _ROW_ERROR_MAPPINGList.clear();
        
        for (int i = 0; i < vROW_ERROR_MAPPINGArray.length; i++) {
                this._ROW_ERROR_MAPPINGList.add(vROW_ERROR_MAPPINGArray[i]);
        }
    } //-- void setROW_ERROR_MAPPING(gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING) 

    /**
     * Sets the value of '_ROW_ERROR_MAPPINGList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vROW_ERROR_MAPPINGList the Vector to copy.
     */
    public void setROW_ERROR_MAPPING(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> vROW_ERROR_MAPPINGList)
    {
        // copy vector
        this._ROW_ERROR_MAPPINGList.clear();
        
        this._ROW_ERROR_MAPPINGList.addAll(vROW_ERROR_MAPPINGList);
    } //-- void setROW_ERROR_MAPPING(java.util.List) 

    /**
     * Sets the value of '_ROW_ERROR_MAPPINGList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param ROW_ERROR_MAPPINGVector the Vector to set.
     */
    public void setROW_ERROR_MAPPINGAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING> ROW_ERROR_MAPPINGVector)
    {
        this._ROW_ERROR_MAPPINGList = ROW_ERROR_MAPPINGVector;
    } //-- void setROW_ERROR_MAPPINGAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdUerrorMsgNbr1_ARRAY unmarshal(java.io.Reader) 

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
