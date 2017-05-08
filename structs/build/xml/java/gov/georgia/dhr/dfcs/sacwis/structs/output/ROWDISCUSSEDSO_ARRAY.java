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
 * Class ROWDISCUSSEDSO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWDISCUSSEDSO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWDISCUSSEDSOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> _ROWDISCUSSEDSOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWDISCUSSEDSO_ARRAY() 
     {
        super();
        this._ROWDISCUSSEDSOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWDISCUSSEDSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDISCUSSEDSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO vROWDISCUSSEDSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDISCUSSEDSOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDISCUSSEDSO has a maximum of 50");
        }
        
        this._ROWDISCUSSEDSOList.add(vROWDISCUSSEDSO);
    } //-- void addROWDISCUSSEDSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) 

    /**
     * 
     * 
     * @param index
     * @param vROWDISCUSSEDSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWDISCUSSEDSO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO vROWDISCUSSEDSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWDISCUSSEDSOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWDISCUSSEDSO has a maximum of 50");
        }
        
        this._ROWDISCUSSEDSOList.add(index, vROWDISCUSSEDSO);
    } //-- void addROWDISCUSSEDSO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWDISCUSSEDSO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> enumerateROWDISCUSSEDSO()
    {
        return java.util.Collections.enumeration(this._ROWDISCUSSEDSOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> enumerateROWDISCUSSEDSO() 

    /**
     * Method getROWDISCUSSEDSO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO getROWDISCUSSEDSO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDISCUSSEDSOList.size()) {
            throw new IndexOutOfBoundsException("getROWDISCUSSEDSO: Index value '" + index + "' not in range [0.." + (this._ROWDISCUSSEDSOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) _ROWDISCUSSEDSOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO getROWDISCUSSEDSO(int) 

    /**
     * Method getROWDISCUSSEDSO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO[] getROWDISCUSSEDSO()
    {
        int size = this._ROWDISCUSSEDSOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) _ROWDISCUSSEDSOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO[] getROWDISCUSSEDSO() 

    /**
     * Method getROWDISCUSSEDSOAsReference
     * 
     * Returns a reference to '_ROWDISCUSSEDSOList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> getROWDISCUSSEDSOAsReference()
    {
        return this._ROWDISCUSSEDSOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> getROWDISCUSSEDSOAsReference() 

    /**
     * Method getROWDISCUSSEDSOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWDISCUSSEDSOCount()
    {
        return this._ROWDISCUSSEDSOList.size();
    } //-- int getROWDISCUSSEDSOCount() 

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
     * Method iterateROWDISCUSSEDSO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> iterateROWDISCUSSEDSO()
    {
        return this._ROWDISCUSSEDSOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> iterateROWDISCUSSEDSO() 

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
    public void removeAllROWDISCUSSEDSO()
    {
        this._ROWDISCUSSEDSOList.clear();
    } //-- void removeAllROWDISCUSSEDSO() 

    /**
     * Method removeROWDISCUSSEDSO
     * 
     * 
     * 
     * @param vROWDISCUSSEDSO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWDISCUSSEDSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO vROWDISCUSSEDSO)
    {
        boolean removed = _ROWDISCUSSEDSOList.remove(vROWDISCUSSEDSO);
        return removed;
    } //-- boolean removeROWDISCUSSEDSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) 

    /**
     * Method removeROWDISCUSSEDSOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO removeROWDISCUSSEDSOAt(int index)
    {
        Object obj = this._ROWDISCUSSEDSOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO removeROWDISCUSSEDSOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWDISCUSSEDSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWDISCUSSEDSO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO vROWDISCUSSEDSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWDISCUSSEDSOList.size()) {
            throw new IndexOutOfBoundsException("setROWDISCUSSEDSO: Index value '" + index + "' not in range [0.." + (this._ROWDISCUSSEDSOList.size() - 1) + "]");
        }
        
        this._ROWDISCUSSEDSOList.set(index, vROWDISCUSSEDSO);
    } //-- void setROWDISCUSSEDSO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) 

    /**
     * 
     * 
     * @param vROWDISCUSSEDSOArray
     */
    public void setROWDISCUSSEDSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO[] vROWDISCUSSEDSOArray)
    {
        //-- copy array
        _ROWDISCUSSEDSOList.clear();
        
        for (int i = 0; i < vROWDISCUSSEDSOArray.length; i++) {
                this._ROWDISCUSSEDSOList.add(vROWDISCUSSEDSOArray[i]);
        }
    } //-- void setROWDISCUSSEDSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO) 

    /**
     * Sets the value of '_ROWDISCUSSEDSOList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWDISCUSSEDSOList the Vector to copy.
     */
    public void setROWDISCUSSEDSO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> vROWDISCUSSEDSOList)
    {
        // copy vector
        this._ROWDISCUSSEDSOList.clear();
        
        this._ROWDISCUSSEDSOList.addAll(vROWDISCUSSEDSOList);
    } //-- void setROWDISCUSSEDSO(java.util.List) 

    /**
     * Sets the value of '_ROWDISCUSSEDSOList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWDISCUSSEDSOVector the Vector to set.
     */
    public void setROWDISCUSSEDSOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO> ROWDISCUSSEDSOVector)
    {
        this._ROWDISCUSSEDSOList = ROWDISCUSSEDSOVector;
    } //-- void setROWDISCUSSEDSOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY unmarshal(java.io.Reader) 

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
