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
 * Class AllegRtrvRecOut.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AllegRtrvRecOut extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _archOutputStruct
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct _archOutputStruct;

    /**
     * Field _ROWCINT76DO_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY _ROWCINT76DO_ARRAY;

    /**
     * Field _cIndTrialHomeVisit
     */
    private java.lang.String _cIndTrialHomeVisit;


      //----------------/
     //- Constructors -/
    //----------------/

    public AllegRtrvRecOut() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'archOutputStruct'.
     * 
     * @return the value of field 'ArchOutputStruct'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct()
    {
        return this._archOutputStruct;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct getArchOutputStruct() 

    /**
     * Returns the value of field 'cIndTrialHomeVisit'.
     * 
     * @return the value of field 'CIndTrialHomeVisit'.
     */
    public java.lang.String getCIndTrialHomeVisit()
    {
        return this._cIndTrialHomeVisit;
    } //-- java.lang.String getCIndTrialHomeVisit() 

    /**
     * Returns the value of field 'ROWCINT76DO_ARRAY'.
     * 
     * @return the value of field 'ROWCINT76DO_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY getROWCINT76DO_ARRAY()
    {
        return this._ROWCINT76DO_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY getROWCINT76DO_ARRAY() 

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
     * Sets the value of field 'archOutputStruct'.
     * 
     * @param archOutputStruct the value of field 'archOutputStruct'
     */
    public void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct archOutputStruct)
    {
        this._archOutputStruct = archOutputStruct;
    } //-- void setArchOutputStruct(gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct) 

    /**
     * Sets the value of field 'cIndTrialHomeVisit'.
     * 
     * @param cIndTrialHomeVisit the value of field
     * 'cIndTrialHomeVisit'.
     */
    public void setCIndTrialHomeVisit(java.lang.String cIndTrialHomeVisit)
    {
        this._cIndTrialHomeVisit = cIndTrialHomeVisit;
    } //-- void setCIndTrialHomeVisit(java.lang.String) 

    /**
     * Sets the value of field 'ROWCINT76DO_ARRAY'.
     * 
     * @param ROWCINT76DO_ARRAY the value of field
     * 'ROWCINT76DO_ARRAY'.
     */
    public void setROWCINT76DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY ROWCINT76DO_ARRAY)
    {
        this._ROWCINT76DO_ARRAY = ROWCINT76DO_ARRAY;
    } //-- void setROWCINT76DO_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut unmarshal(java.io.Reader) 

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
