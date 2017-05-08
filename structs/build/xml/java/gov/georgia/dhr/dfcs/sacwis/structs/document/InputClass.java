/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.5</a>, using an XML
 * Schema.
 * $Id$
 */

package gov.georgia.dhr.dfcs.sacwis.structs.document;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class InputClass.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InputClass implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _parameterList
     */
    private java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> _parameterList;


      //----------------/
     //- Constructors -/
    //----------------/

    public InputClass() 
     {
        super();
        this._parameterList = new java.util.ArrayList<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter>();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameter(gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        this._parameterList.add(vParameter);
    } //-- void addParameter(gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) 

    /**
     * 
     * 
     * @param index
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameter(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        this._parameterList.add(index, vParameter);
    } //-- void addParameter(int, gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) 

    /**
     * Method enumerateParameter
     * 
     * 
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> enumerateParameter()
    {
        return java.util.Collections.enumeration(this._parameterList);
    } //-- java.util.Enumeration<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> enumerateParameter() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Method getParameter
     * 
     * 
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter at
     * the given index
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter getParameter(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._parameterList.size()) {
            throw new IndexOutOfBoundsException("getParameter: Index value '" + index + "' not in range [0.." + (this._parameterList.size() - 1) + "]");
        }
        
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) _parameterList.get(index);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter getParameter(int) 

    /**
     * Method getParameter
     * 
     * 
     * 
     * @return this collection as an Array
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter[] getParameter()
    {
        int size = this._parameterList.size();
        gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter[] array = new gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter[size];
        for (int index = 0; index < size; index++){
            array[index] = (gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) _parameterList.get(index);
        }
        
        return array;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter[] getParameter() 

    /**
     * Method getParameterAsReference
     * 
     * Returns a reference to '_parameterList'. No type checking is
     * performed on any modifications to the Vector.
     * 
     * @return a reference to the Vector backing this class
     */
    public java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> getParameterAsReference()
    {
        return this._parameterList;
    } //-- java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> getParameterAsReference() 

    /**
     * Method getParameterCount
     * 
     * 
     * 
     * @return the size of this collection
     */
    public int getParameterCount()
    {
        return this._parameterList.size();
    } //-- int getParameterCount() 

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
     * Method iterateParameter
     * 
     * 
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> iterateParameter()
    {
        return this._parameterList.iterator();
    } //-- java.util.Iterator<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> iterateParameter() 

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
    public void removeAllParameter()
    {
        this._parameterList.clear();
    } //-- void removeAllParameter() 

    /**
     * Method removeParameter
     * 
     * 
     * 
     * @param vParameter
     * @return true if the object was removed from the collection.
     */
    public boolean removeParameter(gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter vParameter)
    {
        boolean removed = _parameterList.remove(vParameter);
        return removed;
    } //-- boolean removeParameter(gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) 

    /**
     * Method removeParameterAt
     * 
     * 
     * 
     * @param index
     * @return the element removed from the collection
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter removeParameterAt(int index)
    {
        Object obj = this._parameterList.remove(index);
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) obj;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter removeParameterAt(int) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vParameter
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setParameter(int index, gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter vParameter)
        throws java.lang.IndexOutOfBoundsException
    {
        // check bounds for index
        if (index < 0 || index >= this._parameterList.size()) {
            throw new IndexOutOfBoundsException("setParameter: Index value '" + index + "' not in range [0.." + (this._parameterList.size() - 1) + "]");
        }
        
        this._parameterList.set(index, vParameter);
    } //-- void setParameter(int, gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) 

    /**
     * 
     * 
     * @param vParameterArray
     */
    public void setParameter(gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter[] vParameterArray)
    {
        //-- copy array
        _parameterList.clear();
        
        for (int i = 0; i < vParameterArray.length; i++) {
                this._parameterList.add(vParameterArray[i]);
        }
    } //-- void setParameter(gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter) 

    /**
     * Sets the value of '_parameterList' by copying the given
     * Vector. All elements will be checked for type safety.
     * 
     * @param vParameterList the Vector to copy.
     */
    public void setParameter(java.util.List<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> vParameterList)
    {
        // copy vector
        this._parameterList.clear();
        
        this._parameterList.addAll(vParameterList);
    } //-- void setParameter(java.util.List) 

    /**
     * Sets the value of '_parameterList' by setting it to the
     * given Vector. No type checking is performed.
     * 
     * @param ParameterVector the Vector to set.
     */
    public void setParameterAsReference(java.util.Vector<gov.georgia.dhr.dfcs.sacwis.structs.document.Parameter> ParameterVector)
    {
        this._parameterList = ParameterVector;
    } //-- void setParameterAsReference(java.util.Vector) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.InputClass unmarshal(java.io.Reader) 

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
