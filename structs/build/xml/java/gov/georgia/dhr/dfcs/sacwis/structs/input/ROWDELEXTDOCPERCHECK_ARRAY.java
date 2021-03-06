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
 * Class ROWDELEXTDOCPERCHECK_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWDELEXTDOCPERCHECK_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWDELETEEXTDOCPERSONCHECKList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> _ROWDELETEEXTDOCPERSONCHECKList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWDELEXTDOCPERCHECK_ARRAY() 
     {
        super();
        this._ROWDELETEEXTDOCPERSONCHECKList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWDELETEEXTDOCPERSONCHECK
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK vROWDELETEEXTDOCPERSONCHECK)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDELETEEXTDOCPERSONCHECKList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDELETEEXTDOCPERSONCHECK has a maximum of 50");
        }
        
        this._ROWDELETEEXTDOCPERSONCHECKList.add(vROWDELETEEXTDOCPERSONCHECK);
    } //-- void addROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) 

    /**
     * 
     * 
     * @param index
     * @param vROWDELETEEXTDOCPERSONCHECK
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDELETEEXTDOCPERSONCHECK(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK vROWDELETEEXTDOCPERSONCHECK)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDELETEEXTDOCPERSONCHECKList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDELETEEXTDOCPERSONCHECK has a maximum of 50");
        }
        
        this._ROWDELETEEXTDOCPERSONCHECKList.add(index, vROWDELETEEXTDOCPERSONCHECK);
    } //-- void addROWDELETEEXTDOCPERSONCHECK(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWDELETEEXTDOCPERSONCHECK
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> enumerateROWDELETEEXTDOCPERSONCHECK()
    {
        return java.util.Collections.enumeration(this._ROWDELETEEXTDOCPERSONCHECKList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> enumerateROWDELETEEXTDOCPERSONCHECK() 

    /**
     * Method getROWDELETEEXTDOCPERSONCHECK
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK getROWDELETEEXTDOCPERSONCHECK(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDELETEEXTDOCPERSONCHECKList.size()) {
            throw new IndexOutOfBoundsException("getROWDELETEEXTDOCPERSONCHECK: Index value '" + index + "' not in range [0.." + (this._ROWDELETEEXTDOCPERSONCHECKList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) _ROWDELETEEXTDOCPERSONCHECKList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK getROWDELETEEXTDOCPERSONCHECK(int) 

    /**
     * Method getROWDELETEEXTDOCPERSONCHECK
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK[] getROWDELETEEXTDOCPERSONCHECK()
    {
        int size = this._ROWDELETEEXTDOCPERSONCHECKList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) _ROWDELETEEXTDOCPERSONCHECKList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK[] getROWDELETEEXTDOCPERSONCHECK() 

    /**
     * Method getROWDELETEEXTDOCPERSONCHECKAsReference
     * 
     * Returns a reference to '_ROWDELETEEXTDOCPERSONCHECKList'. No
     * type checking is performed on any modifications to the
     * Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> getROWDELETEEXTDOCPERSONCHECKAsReference()
    {
        return this._ROWDELETEEXTDOCPERSONCHECKList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> getROWDELETEEXTDOCPERSONCHECKAsReference() 

    /**
     * Method getROWDELETEEXTDOCPERSONCHECKCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWDELETEEXTDOCPERSONCHECKCount()
    {
        return this._ROWDELETEEXTDOCPERSONCHECKList.size();
    } //-- int getROWDELETEEXTDOCPERSONCHECKCount() 

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
     * Method iterateROWDELETEEXTDOCPERSONCHECK
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> iterateROWDELETEEXTDOCPERSONCHECK()
    {
        return this._ROWDELETEEXTDOCPERSONCHECKList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> iterateROWDELETEEXTDOCPERSONCHECK() 

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
    public void removeAllROWDELETEEXTDOCPERSONCHECK()
    {
        this._ROWDELETEEXTDOCPERSONCHECKList.clear();
    } //-- void removeAllROWDELETEEXTDOCPERSONCHECK() 

    /**
     * Method removeROWDELETEEXTDOCPERSONCHECK
     * 
     * 
     * 
     * @param vROWDELETEEXTDOCPERSONCHECK
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK vROWDELETEEXTDOCPERSONCHECK)
    {
        boolean removed = _ROWDELETEEXTDOCPERSONCHECKList.remove(vROWDELETEEXTDOCPERSONCHECK);
        return removed;
    } //-- boolean removeROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) 

    /**
     * Method removeROWDELETEEXTDOCPERSONCHECKAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK removeROWDELETEEXTDOCPERSONCHECKAt(int index)
    {
        Object obj = this._ROWDELETEEXTDOCPERSONCHECKList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK removeROWDELETEEXTDOCPERSONCHECKAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWDELETEEXTDOCPERSONCHECK
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWDELETEEXTDOCPERSONCHECK(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK vROWDELETEEXTDOCPERSONCHECK)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDELETEEXTDOCPERSONCHECKList.size()) {
            throw new IndexOutOfBoundsException("setROWDELETEEXTDOCPERSONCHECK: Index value '" + index + "' not in range [0.." + (this._ROWDELETEEXTDOCPERSONCHECKList.size() - 1) + "]");
        }
        
        this._ROWDELETEEXTDOCPERSONCHECKList.set(index, vROWDELETEEXTDOCPERSONCHECK);
    } //-- void setROWDELETEEXTDOCPERSONCHECK(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) 

    /**
     * 
     * 
     * @param vROWDELETEEXTDOCPERSONCHECKArray
     */
    public void setROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK[] vROWDELETEEXTDOCPERSONCHECKArray)
    {
        //-- copy array
        _ROWDELETEEXTDOCPERSONCHECKList.clear();
        
        for (int i = 0; i < vROWDELETEEXTDOCPERSONCHECKArray.length; i++) {
                this._ROWDELETEEXTDOCPERSONCHECKList.add(vROWDELETEEXTDOCPERSONCHECKArray[i]);
        }
    } //-- void setROWDELETEEXTDOCPERSONCHECK(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK) 

    /**
     * Sets the value of '_ROWDELETEEXTDOCPERSONCHECKList' by
     * copying the given Vector. All elements will be checked for
     * type safety.
     * 
     * @param vROWDELETEEXTDOCPERSONCHECKList the Vector to copy.
     */
    public void setROWDELETEEXTDOCPERSONCHECK(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> vROWDELETEEXTDOCPERSONCHECKList)
    {
        // copy vector
        this._ROWDELETEEXTDOCPERSONCHECKList.clear();
        
        this._ROWDELETEEXTDOCPERSONCHECKList.addAll(vROWDELETEEXTDOCPERSONCHECKList);
    } //-- void setROWDELETEEXTDOCPERSONCHECK(java.util.List) 

    /**
     * Sets the value of '_ROWDELETEEXTDOCPERSONCHECKList' by
     * setting it to the given Vector. No type checking is
     * performed.
     * 
     * @param ROWDELETEEXTDOCPERSONCHECKVector the Vector to set.
     */
    public void setROWDELETEEXTDOCPERSONCHECKAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEEXTDOCPERSONCHECK> ROWDELETEEXTDOCPERSONCHECKVector)
    {
        this._ROWDELETEEXTDOCPERSONCHECKList = ROWDELETEEXTDOCPERSONCHECKVector;
    } //-- void setROWDELETEEXTDOCPERSONCHECKAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELEXTDOCPERCHECK_ARRAY unmarshal(java.io.Reader) 

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
