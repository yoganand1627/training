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
 * Class AllegEvidence_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AllegEvidence_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _allegationEvidenceList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> _allegationEvidenceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AllegEvidence_ARRAY() 
     {
        super();
        this._allegationEvidenceList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAllegationEvidence
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAllegationEvidence(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence vAllegationEvidence)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._allegationEvidenceList.size() >= 50) {
            throw new IndexOutOfBoundsException("addAllegationEvidence has a maximum of 50");
        }
        
        this._allegationEvidenceList.add(vAllegationEvidence);
    } //-- void addAllegationEvidence(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) 

    /**
     * 
     * 
     * @param index
     * @param vAllegationEvidence
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAllegationEvidence(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence vAllegationEvidence)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._allegationEvidenceList.size() >= 50) {
            throw new IndexOutOfBoundsException("addAllegationEvidence has a maximum of 50");
        }
        
        this._allegationEvidenceList.add(index, vAllegationEvidence);
    } //-- void addAllegationEvidence(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateAllegationEvidence
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> enumerateAllegationEvidence()
    {
        return java.util.Collections.enumeration(this._allegationEvidenceList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> enumerateAllegationEvidence() 

    /**
     * Method getAllegationEvidence
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence getAllegationEvidence(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._allegationEvidenceList.size()) {
            throw new IndexOutOfBoundsException("getAllegationEvidence: Index value '" + index + "' not in range [0.." + (this._allegationEvidenceList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) _allegationEvidenceList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence getAllegationEvidence(int) 

    /**
     * Method getAllegationEvidence
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence[] getAllegationEvidence()
    {
        int size = this._allegationEvidenceList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) _allegationEvidenceList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence[] getAllegationEvidence() 

    /**
     * Method getAllegationEvidenceAsReference
     * 
     * Returns a reference to '_allegationEvidenceList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> getAllegationEvidenceAsReference()
    {
        return this._allegationEvidenceList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> getAllegationEvidenceAsReference() 

    /**
     * Method getAllegationEvidenceCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getAllegationEvidenceCount()
    {
        return this._allegationEvidenceList.size();
    } //-- int getAllegationEvidenceCount() 

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
     * Method iterateAllegationEvidence
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> iterateAllegationEvidence()
    {
        return this._allegationEvidenceList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> iterateAllegationEvidence() 

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
    public void removeAllAllegationEvidence()
    {
        this._allegationEvidenceList.clear();
    } //-- void removeAllAllegationEvidence() 

    /**
     * Method removeAllegationEvidence
     * 
     * 
     * 
     * @param vAllegationEvidence
     * @return true if the object was removed from the collection.
     */
    public boolean removeAllegationEvidence(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence vAllegationEvidence)
    {
        boolean removed = _allegationEvidenceList.remove(vAllegationEvidence);
        return removed;
    } //-- boolean removeAllegationEvidence(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) 

    /**
     * Method removeAllegationEvidenceAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence removeAllegationEvidenceAt(int index)
    {
        Object obj = this._allegationEvidenceList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence removeAllegationEvidenceAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vAllegationEvidence
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAllegationEvidence(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence vAllegationEvidence)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._allegationEvidenceList.size()) {
            throw new IndexOutOfBoundsException("setAllegationEvidence: Index value '" + index + "' not in range [0.." + (this._allegationEvidenceList.size() - 1) + "]");
        }
        
        this._allegationEvidenceList.set(index, vAllegationEvidence);
    } //-- void setAllegationEvidence(int, gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) 

    /**
     * 
     * 
     * @param vAllegationEvidenceArray
     */
    public void setAllegationEvidence(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence[] vAllegationEvidenceArray)
    {
        //-- copy array
        _allegationEvidenceList.clear();
        
        for (int i = 0; i < vAllegationEvidenceArray.length; i++) {
                this._allegationEvidenceList.add(vAllegationEvidenceArray[i]);
        }
    } //-- void setAllegationEvidence(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence) 

    /**
     * Sets the value of '_allegationEvidenceList' by copying the
     * given Vector. All elements will be checked for type safety.
     * 
     * @param vAllegationEvidenceList the Vector to copy.
     */
    public void setAllegationEvidence(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> vAllegationEvidenceList)
    {
        // copy vector
        this._allegationEvidenceList.clear();
        
        this._allegationEvidenceList.addAll(vAllegationEvidenceList);
    } //-- void setAllegationEvidence(java.util.List) 

    /**
     * Sets the value of '_allegationEvidenceList' by setting it to
     * the given Vector. No type checking is performed.
     * 
     * @param AllegationEvidenceVector the Vector to set.
     */
    public void setAllegationEvidenceAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence> AllegationEvidenceVector)
    {
        this._allegationEvidenceList = AllegationEvidenceVector;
    } //-- void setAllegationEvidenceAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRA
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY unmarshal(java.io.Reader) 

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
