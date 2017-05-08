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
 * Class ROWCINV86DOG00.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCINV86DOG00 extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dtDtStageStart
     */
    private org.exolab.castor.types.Date _dtDtStageStart;

    /**
     * Field _ulIdPriorStage
     */
    private int _ulIdPriorStage;

    /**
     * keeps track of state for field: _ulIdPriorStage
     */
    private boolean _has_ulIdPriorStage;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCINV86DOG00() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdPriorStage()
    {
        this._has_ulIdPriorStage= false;
    } //-- void deleteUlIdPriorStage() 

    /**
     * Returns the value of field 'dtDtStageStart'.
     * 
     * @return the value of field 'DtDtStageStart'.
     */
    public org.exolab.castor.types.Date getDtDtStageStart()
    {
        return this._dtDtStageStart;
    } //-- org.exolab.castor.types.Date getDtDtStageStart() 

    /**
     * Returns the value of field 'ulIdPriorStage'.
     * 
     * @return the value of field 'UlIdPriorStage'.
     */
    public int getUlIdPriorStage()
    {
        return this._ulIdPriorStage;
    } //-- int getUlIdPriorStage() 

    /**
     * Method hasUlIdPriorStage
     * 
     * 
     * 
     * @return true if at least one UlIdPriorStage has been added
     */
    public boolean hasUlIdPriorStage()
    {
        return this._has_ulIdPriorStage;
    } //-- boolean hasUlIdPriorStage() 

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
     * Sets the value of field 'dtDtStageStart'.
     * 
     * @param dtDtStageStart the value of field 'dtDtStageStart'.
     */
    public void setDtDtStageStart(org.exolab.castor.types.Date dtDtStageStart)
    {
        this._dtDtStageStart = dtDtStageStart;
    } //-- void setDtDtStageStart(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'ulIdPriorStage'.
     * 
     * @param ulIdPriorStage the value of field 'ulIdPriorStage'.
     */
    public void setUlIdPriorStage(int ulIdPriorStage)
    {
        this._ulIdPriorStage = ulIdPriorStage;
        this._has_ulIdPriorStage = true;
    } //-- void setUlIdPriorStage(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00 unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV86DOG00 unmarshal(java.io.Reader) 

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
