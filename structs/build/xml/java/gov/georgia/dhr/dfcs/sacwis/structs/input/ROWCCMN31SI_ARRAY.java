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
 * Class ROWCCMN31SI_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMN31SI_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _ROWCCMN31SIList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> _ROWCCMN31SIList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMN31SI_ARRAY() 
     {
        super();
        this._ROWCCMN31SIList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vROWCCMN31SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN31SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI vROWCCMN31SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN31SIList.size() >= 15) {
            throw new IndexOutOfBoundsException("addROWCCMN31SI has a maximum of 15");
        }
        
        this._ROWCCMN31SIList.add(vROWCCMN31SI);
    } //-- void addROWCCMN31SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN31SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addROWCCMN31SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI vROWCCMN31SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._ROWCCMN31SIList.size() >= 15) {
            throw new IndexOutOfBoundsException("addROWCCMN31SI has a maximum of 15");
        }
        
        this._ROWCCMN31SIList.add(index, vROWCCMN31SI);
    } //-- void addROWCCMN31SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateROWCCMN31SI
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> enumerateROWCCMN31SI()
    {
        return java.util.Collections.enumeration(this._ROWCCMN31SIList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> enumerateROWCCMN31SI() 

    /**
     * Method getROWCCMN31SI
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI at the
     * given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI getROWCCMN31SI(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN31SIList.size()) {
            throw new IndexOutOfBoundsException("getROWCCMN31SI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN31SIList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) _ROWCCMN31SIList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI getROWCCMN31SI(int) 

    /**
     * Method getROWCCMN31SI
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI[] getROWCCMN31SI()
    {
        int size = this._ROWCCMN31SIList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI[] array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) _ROWCCMN31SIList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI[] getROWCCMN31SI() 

    /**
     * Method getROWCCMN31SIAsReference
     * 
     * Returns a reference to '_ROWCCMN31SIList'. No type checking
     * is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> getROWCCMN31SIAsReference()
    {
        return this._ROWCCMN31SIList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> getROWCCMN31SIAsReference() 

    /**
     * Method getROWCCMN31SICount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getROWCCMN31SICount()
    {
        return this._ROWCCMN31SIList.size();
    } //-- int getROWCCMN31SICount() 

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
     * Method iterateROWCCMN31SI
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> iterateROWCCMN31SI()
    {
        return this._ROWCCMN31SIList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> iterateROWCCMN31SI() 

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
    public void removeAllROWCCMN31SI()
    {
        this._ROWCCMN31SIList.clear();
    } //-- void removeAllROWCCMN31SI() 

    /**
     * Method removeROWCCMN31SI
     * 
     * 
     * 
     * @param vROWCCMN31SI
     * @return true if the object was removed from the collection.
     */
    public boolean removeROWCCMN31SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI vROWCCMN31SI)
    {
        boolean removed = _ROWCCMN31SIList.remove(vROWCCMN31SI);
        return removed;
    } //-- boolean removeROWCCMN31SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) 

    /**
     * Method removeROWCCMN31SIAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI removeROWCCMN31SIAt(int index)
    {
        Object obj = this._ROWCCMN31SIList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI removeROWCCMN31SIAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vROWCCMN31SI
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setROWCCMN31SI(int index, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI vROWCCMN31SI)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._ROWCCMN31SIList.size()) {
            throw new IndexOutOfBoundsException("setROWCCMN31SI: Index value '" + index + "' not in range [0.." + (this._ROWCCMN31SIList.size() - 1) + "]");
        }
        
        this._ROWCCMN31SIList.set(index, vROWCCMN31SI);
    } //-- void setROWCCMN31SI(int, gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) 

    /**
     * 
     * 
     * @param vROWCCMN31SIArray
     */
    public void setROWCCMN31SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI[] vROWCCMN31SIArray)
    {
        //-- copy array
        _ROWCCMN31SIList.clear();
        
        for (int i = 0; i < vROWCCMN31SIArray.length; i++) {
                this._ROWCCMN31SIList.add(vROWCCMN31SIArray[i]);
        }
    } //-- void setROWCCMN31SI(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI) 

    /**
     * Sets the value of '_ROWCCMN31SIList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vROWCCMN31SIList the Vector to copy.
     */
    public void setROWCCMN31SI(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> vROWCCMN31SIList)
    {
        // copy vector
        this._ROWCCMN31SIList.clear();
        
        this._ROWCCMN31SIList.addAll(vROWCCMN31SIList);
    } //-- void setROWCCMN31SI(java.util.List) 

    /**
     * Sets the value of '_ROWCCMN31SIList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ROWCCMN31SIVector the Vector to set.
     */
    public void setROWCCMN31SIAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI> ROWCCMN31SIVector)
    {
        this._ROWCCMN31SIList = ROWCCMN31SIVector;
    } //-- void setROWCCMN31SIAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY unmarshal(java.io.Reader) 

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
