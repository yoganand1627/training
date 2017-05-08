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
 * Class StagePersonLinkDetail_ARRAY.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StagePersonLinkDetail_ARRAY extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _stagePersonLinkDetailList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> _stagePersonLinkDetailList;


      //----------------/
     //- Constructors -/
    //----------------/

    public StagePersonLinkDetail_ARRAY() 
     {
        super();
        this._stagePersonLinkDetailList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vStagePersonLinkDetail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStagePersonLinkDetail(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail vStagePersonLinkDetail)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._stagePersonLinkDetailList.size() >= 200) {
            throw new IndexOutOfBoundsException("addStagePersonLinkDetail has a maximum of 200");
        }
        
        this._stagePersonLinkDetailList.add(vStagePersonLinkDetail);
    } //-- void addStagePersonLinkDetail(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) 

    /**
     * 
     * 
     * @param index
     * @param vStagePersonLinkDetail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStagePersonLinkDetail(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail vStagePersonLinkDetail)
        throws java.lang.IndexOutOfBoundsException
    {
        // check for the maximum size
        if (this._stagePersonLinkDetailList.size() >= 200) {
            throw new IndexOutOfBoundsException("addStagePersonLinkDetail has a maximum of 200");
        }
        
        this._stagePersonLinkDetailList.add(index, vStagePersonLinkDetail);
    } //-- void addStagePersonLinkDetail(int, gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) 

    /**
     */
    public void deleteUlRowQty()
    {
        this._has_ulRowQty= false;
    } //-- void deleteUlRowQty() 

    /**
     * Method enumerateStagePersonLinkDetail
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> enumerateStagePersonLinkDetail()
    {
        return java.util.Collections.enumeration(this._stagePersonLinkDetailList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> enumerateStagePersonLinkDetail() 

    /**
     * Method getStagePersonLinkDetail
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail
     * at the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail getStagePersonLinkDetail(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._stagePersonLinkDetailList.size()) {
            throw new IndexOutOfBoundsException("getStagePersonLinkDetail: Index value '" + index + "' not in range [0.." + (this._stagePersonLinkDetailList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) _stagePersonLinkDetailList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail getStagePersonLinkDetail(int) 

    /**
     * Method getStagePersonLinkDetail
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail[] getStagePersonLinkDetail()
    {
        int size = this._stagePersonLinkDetailList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail[] array = new gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) _stagePersonLinkDetailList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail[] getStagePersonLinkDetail() 

    /**
     * Method getStagePersonLinkDetailAsReference
     * 
     * Returns a reference to '_stagePersonLinkDetailList'. No type
     * checking is performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> getStagePersonLinkDetailAsReference()
    {
        return this._stagePersonLinkDetailList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> getStagePersonLinkDetailAsReference() 

    /**
     * Method getStagePersonLinkDetailCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getStagePersonLinkDetailCount()
    {
        return this._stagePersonLinkDetailList.size();
    } //-- int getStagePersonLinkDetailCount() 

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
     * Method iterateStagePersonLinkDetail
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> iterateStagePersonLinkDetail()
    {
        return this._stagePersonLinkDetailList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> iterateStagePersonLinkDetail() 

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
    public void removeAllStagePersonLinkDetail()
    {
        this._stagePersonLinkDetailList.clear();
    } //-- void removeAllStagePersonLinkDetail() 

    /**
     * Method removeStagePersonLinkDetail
     * 
     * 
     * 
     * @param vStagePersonLinkDetail
     * @return true if the object was removed from the collection.
     */
    public boolean removeStagePersonLinkDetail(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail vStagePersonLinkDetail)
    {
        boolean removed = _stagePersonLinkDetailList.remove(vStagePersonLinkDetail);
        return removed;
    } //-- boolean removeStagePersonLinkDetail(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) 

    /**
     * Method removeStagePersonLinkDetailAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail removeStagePersonLinkDetailAt(int index)
    {
        Object obj = this._stagePersonLinkDetailList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail removeStagePersonLinkDetailAt(int) 

    /**
     * 
     * 
     * @param index
     * @param vStagePersonLinkDetail
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setStagePersonLinkDetail(int index, gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail vStagePersonLinkDetail)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._stagePersonLinkDetailList.size()) {
            throw new IndexOutOfBoundsException("setStagePersonLinkDetail: Index value '" + index + "' not in range [0.." + (this._stagePersonLinkDetailList.size() - 1) + "]");
        }
        
        this._stagePersonLinkDetailList.set(index, vStagePersonLinkDetail);
    } //-- void setStagePersonLinkDetail(int, gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) 

    /**
     * 
     * 
     * @param vStagePersonLinkDetailArray
     */
    public void setStagePersonLinkDetail(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail[] vStagePersonLinkDetailArray)
    {
        //-- copy array
        _stagePersonLinkDetailList.clear();
        
        for (int i = 0; i < vStagePersonLinkDetailArray.length; i++) {
                this._stagePersonLinkDetailList.add(vStagePersonLinkDetailArray[i]);
        }
    } //-- void setStagePersonLinkDetail(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail) 

    /**
     * Sets the value of '_stagePersonLinkDetailList' by copying
     * the given Vector. All elements will be checked for type
     * safety.
     * 
     * @param vStagePersonLinkDetailList the Vector to copy.
     */
    public void setStagePersonLinkDetail(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> vStagePersonLinkDetailList)
    {
        // copy vector
        this._stagePersonLinkDetailList.clear();
        
        this._stagePersonLinkDetailList.addAll(vStagePersonLinkDetailList);
    } //-- void setStagePersonLinkDetail(java.util.List) 

    /**
     * Sets the value of '_stagePersonLinkDetailList' by setting it
     * to the given Vector. No type checking is performed.
     * 
     * @param StagePersonLinkDetailVector the Vector to set.
     */
    public void setStagePersonLinkDetailAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail> StagePersonLinkDetailVector)
    {
        this._stagePersonLinkDetailList = StagePersonLinkDetailVector;
    } //-- void setStagePersonLinkDetailAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.StagePersonLinkDetail_ARRAY unmarshal(java.io.Reader) 

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
