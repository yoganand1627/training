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
 * Class CINV04SO_ADD_PERSON_TO_STAGES_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CINV04SO_ADD_PERSON_TO_STAGES_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _CINV04SO_ADD_PERSON_TO_STAGESList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> _CINV04SO_ADD_PERSON_TO_STAGESList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CINV04SO_ADD_PERSON_TO_STAGES_ARRAY() 
     {
        super();
        this._CINV04SO_ADD_PERSON_TO_STAGESList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGES
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SO_ADD_PERSON_TO_STAGES(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES vCINV04SO_ADD_PERSON_TO_STAGES)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SO_ADD_PERSON_TO_STAGESList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV04SO_ADD_PERSON_TO_STAGES has a maximum of 50");
        }
        
        this._CINV04SO_ADD_PERSON_TO_STAGESList.add(vCINV04SO_ADD_PERSON_TO_STAGES);
    } //-- void addCINV04SO_ADD_PERSON_TO_STAGES(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SO_ADD_PERSON_TO_STAGES
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCINV04SO_ADD_PERSON_TO_STAGES(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES vCINV04SO_ADD_PERSON_TO_STAGES)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._CINV04SO_ADD_PERSON_TO_STAGESList.size() >= 50) {
            throw new IndexOutOfBoundsException("addCINV04SO_ADD_PERSON_TO_STAGES has a maximum of 50");
        }
        
        this._CINV04SO_ADD_PERSON_TO_STAGESList.add(index, vCINV04SO_ADD_PERSON_TO_STAGES);
    } //-- void addCINV04SO_ADD_PERSON_TO_STAGES(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateCINV04SO_ADD_PERSON_TO_STAGES
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> enumerateCINV04SO_ADD_PERSON_TO_STAGES()
    {
        return java.util.Collections.enumeration(this._CINV04SO_ADD_PERSON_TO_STAGESList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> enumerateCINV04SO_ADD_PERSON_TO_STAGES() 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGES
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES getCINV04SO_ADD_PERSON_TO_STAGES(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SO_ADD_PERSON_TO_STAGESList.size()) {
            throw new IndexOutOfBoundsException("getCINV04SO_ADD_PERSON_TO_STAGES: Index value '" + index + "' not in range [0.." + (this._CINV04SO_ADD_PERSON_TO_STAGESList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) _CINV04SO_ADD_PERSON_TO_STAGESList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES getCINV04SO_ADD_PERSON_TO_STAGES(int) 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGES
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES[] getCINV04SO_ADD_PERSON_TO_STAGES()
    {
        int size = this._CINV04SO_ADD_PERSON_TO_STAGESList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) _CINV04SO_ADD_PERSON_TO_STAGESList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES[] getCINV04SO_ADD_PERSON_TO_STAGES() 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGESAsReference
     * 
     * Returns a reference to '_CINV04SO_ADD_PERSON_TO_STAGESList'.
     * No type checking is performed on any modifications to the
     * Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> getCINV04SO_ADD_PERSON_TO_STAGESAsReference()
    {
        return this._CINV04SO_ADD_PERSON_TO_STAGESList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> getCINV04SO_ADD_PERSON_TO_STAGESAsReference() 

    /**
     * Method getCINV04SO_ADD_PERSON_TO_STAGESCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getCINV04SO_ADD_PERSON_TO_STAGESCount()
    {
        return this._CINV04SO_ADD_PERSON_TO_STAGESList.size();
    } //-- int getCINV04SO_ADD_PERSON_TO_STAGESCount() 

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
     * Method iterateCINV04SO_ADD_PERSON_TO_STAGES
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> iterateCINV04SO_ADD_PERSON_TO_STAGES()
    {
        return this._CINV04SO_ADD_PERSON_TO_STAGESList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> iterateCINV04SO_ADD_PERSON_TO_STAGES() 

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
    public void removeAllCINV04SO_ADD_PERSON_TO_STAGES()
    {
        this._CINV04SO_ADD_PERSON_TO_STAGESList.clear();
    } //-- void removeAllCINV04SO_ADD_PERSON_TO_STAGES() 

    /**
     * Method removeCINV04SO_ADD_PERSON_TO_STAGES
     * 
     * 
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGES
     * @return true if the object was removed from the collection.
     */
    public boolean removeCINV04SO_ADD_PERSON_TO_STAGES(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES vCINV04SO_ADD_PERSON_TO_STAGES)
    {
        boolean removed = _CINV04SO_ADD_PERSON_TO_STAGESList.remove(vCINV04SO_ADD_PERSON_TO_STAGES);
        return removed;
    } //-- boolean removeCINV04SO_ADD_PERSON_TO_STAGES(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) 

    /**
     * Method removeCINV04SO_ADD_PERSON_TO_STAGESAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES removeCINV04SO_ADD_PERSON_TO_STAGESAt(int index)
    {
        Object obj = this._CINV04SO_ADD_PERSON_TO_STAGESList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES removeCINV04SO_ADD_PERSON_TO_STAGESAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vCINV04SO_ADD_PERSON_TO_STAGES
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGES(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES vCINV04SO_ADD_PERSON_TO_STAGES)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._CINV04SO_ADD_PERSON_TO_STAGESList.size()) {
            throw new IndexOutOfBoundsException("setCINV04SO_ADD_PERSON_TO_STAGES: Index value '" + index + "' not in range [0.." + (this._CINV04SO_ADD_PERSON_TO_STAGESList.size() - 1) + "]");
        }
        
        this._CINV04SO_ADD_PERSON_TO_STAGESList.set(index, vCINV04SO_ADD_PERSON_TO_STAGES);
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGES(int, gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) 

    /**
     * 
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGESArray
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGES(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES[] vCINV04SO_ADD_PERSON_TO_STAGESArray)
    {
        //-- copy array
        _CINV04SO_ADD_PERSON_TO_STAGESList.clear();
        
        for (int i = 0; i < vCINV04SO_ADD_PERSON_TO_STAGESArray.length; i++) {
                this._CINV04SO_ADD_PERSON_TO_STAGESList.add(vCINV04SO_ADD_PERSON_TO_STAGESArray[i]);
        }
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGES(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES) 

    /**
     * Sets the value of '_CINV04SO_ADD_PERSON_TO_STAGESList' by
     * copying the given Vector. All elements will be checked for
     * type safety.
     * 
     * @param vCINV04SO_ADD_PERSON_TO_STAGESList the Vector to copy.
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGES(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> vCINV04SO_ADD_PERSON_TO_STAGESList)
    {
        // copy vector
        this._CINV04SO_ADD_PERSON_TO_STAGESList.clear();
        
        this._CINV04SO_ADD_PERSON_TO_STAGESList.addAll(vCINV04SO_ADD_PERSON_TO_STAGESList);
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGES(java.util.List) 

    /**
     * Sets the value of '_CINV04SO_ADD_PERSON_TO_STAGESList' by
     * setting it to the given Vector. No type checking is
     * performed.
     * 
     * @param CINV04SO_ADD_PERSON_TO_STAGESVector the Vector to set.
     */
    public void setCINV04SO_ADD_PERSON_TO_STAGESAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES> CINV04SO_ADD_PERSON_TO_STAGESVector)
    {
        this._CINV04SO_ADD_PERSON_TO_STAGESList = CINV04SO_ADD_PERSON_TO_STAGESVector;
    } //-- void setCINV04SO_ADD_PERSON_TO_STAGESAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY unmarshal(java.io.Reader) 

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
