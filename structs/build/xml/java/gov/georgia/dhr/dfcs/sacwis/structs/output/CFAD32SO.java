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
 * Class CFAD32SO.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CFAD32SO extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
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
     * Field _dtWCDDtSystemDate
     */
    private org.exolab.castor.types.Date _dtWCDDtSystemDate;

    /**
     * Field _CFAD32SOG00_ARRAY
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY _CFAD32SOG00_ARRAY;

    /**
     * Field _numberOfTrainingHoursRequired
     */
    private int _numberOfTrainingHoursRequired;

    /**
     * keeps track of state for field: _numberOfTrainingHoursRequire
     */
    private boolean _has_numberOfTrainingHoursRequired;

    /**
     * Field _trngHrsCompleted
     */
    private double _trngHrsCompleted;

    /**
     * keeps track of state for field: _trngHrsCompleted
     */
    private boolean _has_trngHrsCompleted;

    /**
     * Field _trngHrsRemain
     */
    private double _trngHrsRemain;

    /**
     * keeps track of state for field: _trngHrsRemain
     */
    private boolean _has_trngHrsRemain;


      //----------------/
     //- Constructors -/
    //----------------/

    public CFAD32SO() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNumberOfTrainingHoursRequired()
    {
        this._has_numberOfTrainingHoursRequired= false;
    } //-- void deleteNumberOfTrainingHoursRequired() 

    /**
     */
    public void deleteTrngHrsCompleted()
    {
        this._has_trngHrsCompleted= false;
    } //-- void deleteTrngHrsCompleted() 

    /**
     */
    public void deleteTrngHrsRemain()
    {
        this._has_trngHrsRemain= false;
    } //-- void deleteTrngHrsRemain() 

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
     * Returns the value of field 'CFAD32SOG00_ARRAY'.
     * 
     * @return the value of field 'CFAD32SOG00_ARRAY'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY getCFAD32SOG00_ARRAY()
    {
        return this._CFAD32SOG00_ARRAY;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY getCFAD32SOG00_ARRAY() 

    /**
     * Returns the value of field 'dtWCDDtSystemDate'.
     * 
     * @return the value of field 'DtWCDDtSystemDate'.
     */
    public org.exolab.castor.types.Date getDtWCDDtSystemDate()
    {
        return this._dtWCDDtSystemDate;
    } //-- org.exolab.castor.types.Date getDtWCDDtSystemDate() 

    /**
     * Returns the value of field 'numberOfTrainingHoursRequired'.
     * 
     * @return the value of field 'NumberOfTrainingHoursRequired'.
     */
    public int getNumberOfTrainingHoursRequired()
    {
        return this._numberOfTrainingHoursRequired;
    } //-- int getNumberOfTrainingHoursRequired() 

    /**
     * Returns the value of field 'trngHrsCompleted'.
     * 
     * @return the value of field 'TrngHrsCompleted'.
     */
    public double getTrngHrsCompleted()
    {
        return this._trngHrsCompleted;
    } //-- double getTrngHrsCompleted() 

    /**
     * Returns the value of field 'trngHrsRemain'.
     * 
     * @return the value of field 'TrngHrsRemain'.
     */
    public double getTrngHrsRemain()
    {
        return this._trngHrsRemain;
    } //-- double getTrngHrsRemain() 

    /**
     * Method hasNumberOfTrainingHoursRequired
     * 
     * 
     * 
     * @return true if at least one NumberOfTrainingHoursRequired
     * has been added
     */
    public boolean hasNumberOfTrainingHoursRequired()
    {
        return this._has_numberOfTrainingHoursRequired;
    } //-- boolean hasNumberOfTrainingHoursRequired() 

    /**
     * Method hasTrngHrsCompleted
     * 
     * 
     * 
     * @return true if at least one TrngHrsCompleted has been added
     */
    public boolean hasTrngHrsCompleted()
    {
        return this._has_trngHrsCompleted;
    } //-- boolean hasTrngHrsCompleted() 

    /**
     * Method hasTrngHrsRemain
     * 
     * 
     * 
     * @return true if at least one TrngHrsRemain has been added
     */
    public boolean hasTrngHrsRemain()
    {
        return this._has_trngHrsRemain;
    } //-- boolean hasTrngHrsRemain() 

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
     * Sets the value of field 'CFAD32SOG00_ARRAY'.
     * 
     * @param CFAD32SOG00_ARRAY the value of field
     * 'CFAD32SOG00_ARRAY'.
     */
    public void setCFAD32SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY CFAD32SOG00_ARRAY)
    {
        this._CFAD32SOG00_ARRAY = CFAD32SOG00_ARRAY;
    } //-- void setCFAD32SOG00_ARRAY(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00_ARRAY) 

    /**
     * Sets the value of field 'dtWCDDtSystemDate'.
     * 
     * @param dtWCDDtSystemDate the value of field
     * 'dtWCDDtSystemDate'.
     */
    public void setDtWCDDtSystemDate(org.exolab.castor.types.Date dtWCDDtSystemDate)
    {
        this._dtWCDDtSystemDate = dtWCDDtSystemDate;
    } //-- void setDtWCDDtSystemDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'numberOfTrainingHoursRequired'.
     * 
     * @param numberOfTrainingHoursRequired the value of field
     * 'numberOfTrainingHoursRequired'.
     */
    public void setNumberOfTrainingHoursRequired(int numberOfTrainingHoursRequired)
    {
        this._numberOfTrainingHoursRequired = numberOfTrainingHoursRequired;
        this._has_numberOfTrainingHoursRequired = true;
    } //-- void setNumberOfTrainingHoursRequired(int) 

    /**
     * Sets the value of field 'trngHrsCompleted'.
     * 
     * @param trngHrsCompleted the value of field 'trngHrsCompleted'
     */
    public void setTrngHrsCompleted(double trngHrsCompleted)
    {
        this._trngHrsCompleted = trngHrsCompleted;
        this._has_trngHrsCompleted = true;
    } //-- void setTrngHrsCompleted(double) 

    /**
     * Sets the value of field 'trngHrsRemain'.
     * 
     * @param trngHrsRemain the value of field 'trngHrsRemain'.
     */
    public void setTrngHrsRemain(double trngHrsRemain)
    {
        this._trngHrsRemain = trngHrsRemain;
        this._has_trngHrsRemain = true;
    } //-- void setTrngHrsRemain(double) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO unmarshal(java.io.Reader) 

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
