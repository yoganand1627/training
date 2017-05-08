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
 * Class ROWPRIVCONVERSO_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWPRIVCONVERSO_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWPRIVCONVERSOList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> _ROWPRIVCONVERSOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWPRIVCONVERSO_ARRAY() 
     {
        super();
        this._ROWPRIVCONVERSOList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWPRIVCONVERSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWPRIVCONVERSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO vROWPRIVCONVERSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWPRIVCONVERSOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWPRIVCONVERSO has a maximum of 50");
        }
        
        this._ROWPRIVCONVERSOList.add(vROWPRIVCONVERSO);
    } //-- void addROWPRIVCONVERSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) 

    /**
     * 
     * 
     * @param index
     * @param vROWPRIVCONVERSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWPRIVCONVERSO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO vROWPRIVCONVERSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWPRIVCONVERSOList.size() >= 50) {
            throw new IndexOutOfBoundsException("addROWPRIVCONVERSO has a maximum of 50");
        }
        
        this._ROWPRIVCONVERSOList.add(index, vROWPRIVCONVERSO);
    } //-- void addROWPRIVCONVERSO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWPRIVCONVERSO
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> enumerateROWPRIVCONVERSO()
    {
        return java.util.Collections.enumeration(this._ROWPRIVCONVERSOList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> enumerateROWPRIVCONVERSO() 

    /**
     * Method getROWPRIVCONVERSO
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO getROWPRIVCONVERSO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWPRIVCONVERSOList.size()) {
            throw new IndexOutOfBoundsException("getROWPRIVCONVERSO: Index value '" + index + "' not in range [0.." + (this._ROWPRIVCONVERSOList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) _ROWPRIVCONVERSOList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO getROWPRIVCONVERSO(int) 

    /**
     * Method getROWPRIVCONVERSO
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO[] getROWPRIVCONVERSO()
    {
        int size = this._ROWPRIVCONVERSOList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) _ROWPRIVCONVERSOList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO[] getROWPRIVCONVERSO() 

    /**
     * Method getROWPRIVCONVERSOAsReference
     * 
     * Returns a reference to '_ROWPRIVCONVERSOList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> getROWPRIVCONVERSOAsReference()
    {
        return this._ROWPRIVCONVERSOList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> getROWPRIVCONVERSOAsReference() 

    /**
     * Method getROWPRIVCONVERSOCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWPRIVCONVERSOCount()
    {
        return this._ROWPRIVCONVERSOList.size();
    } //-- int getROWPRIVCONVERSOCount() 

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
     * Method iterateROWPRIVCONVERSO
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> iterateROWPRIVCONVERSO()
    {
        return this._ROWPRIVCONVERSOList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> iterateROWPRIVCONVERSO() 

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
    public void removeAllROWPRIVCONVERSO()
    {
        this._ROWPRIVCONVERSOList.clear();
    } //-- void removeAllROWPRIVCONVERSO() 

    /**
     * Method removeROWPRIVCONVERSO
     * 
     * 
     * 
     * @param vROWPRIVCONVERSO
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWPRIVCONVERSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO vROWPRIVCONVERSO)
    {
        boolean removed = _ROWPRIVCONVERSOList.remove(vROWPRIVCONVERSO);
        return removed;
    } //-- boolean removeROWPRIVCONVERSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) 

    /**
     * Method removeROWPRIVCONVERSOAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO removeROWPRIVCONVERSOAt(int index)
    {
        Object obj = this._ROWPRIVCONVERSOList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO removeROWPRIVCONVERSOAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWPRIVCONVERSO
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWPRIVCONVERSO(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO vROWPRIVCONVERSO)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWPRIVCONVERSOList.size()) {
            throw new IndexOutOfBoundsException("setROWPRIVCONVERSO: Index value '" + index + "' not in range [0.." + (this._ROWPRIVCONVERSOList.size() - 1) + "]");
        }
        
        this._ROWPRIVCONVERSOList.set(index, vROWPRIVCONVERSO);
    } //-- void setROWPRIVCONVERSO(int, gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) 

    /**
     * 
     * 
     * @param vROWPRIVCONVERSOArray
     */
    public void setROWPRIVCONVERSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO[] vROWPRIVCONVERSOArray)
    {
        //-- copy array
        _ROWPRIVCONVERSOList.clear();
        
        for (int i = 0; i < vROWPRIVCONVERSOArray.length; i++) {
                this._ROWPRIVCONVERSOList.add(vROWPRIVCONVERSOArray[i]);
        }
    } //-- void setROWPRIVCONVERSO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO) 

    /**
     * Sets the value of '_ROWPRIVCONVERSOList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vROWPRIVCONVERSOList the Vector to copy.
     */
    public void setROWPRIVCONVERSO(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> vROWPRIVCONVERSOList)
    {
        // copy vector
        this._ROWPRIVCONVERSOList.clear();
        
        this._ROWPRIVCONVERSOList.addAll(vROWPRIVCONVERSOList);
    } //-- void setROWPRIVCONVERSO(java.util.List) 

    /**
     * Sets the value of '_ROWPRIVCONVERSOList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param ROWPRIVCONVERSOVector the Vector to set.
     */
    public void setROWPRIVCONVERSOAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO> ROWPRIVCONVERSOVector)
    {
        this._ROWPRIVCONVERSOList = ROWPRIVCONVERSOVector;
    } //-- void setROWPRIVCONVERSOAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY unmarshal(java.io.Reader) 

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
