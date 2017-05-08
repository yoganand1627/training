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
 * Class AssignmentGroup.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AssignmentGroup extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _szNmStage
     */
    private java.lang.String _szNmStage;

    /**
     * Field _szNmPersonFull
     */
    private java.lang.String _szNmPersonFull;

    /**
     * Field _szCdStagePersRole
     */
    private java.lang.String _szCdStagePersRole;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdPerson
     */
    private int _ulIdPerson;

    /**
     * keeps track of state for field: _ulIdPerson
     */
    private boolean _has_ulIdPerson;

    /**
     * Field _ulIdStagePerson
     */
    private int _ulIdStagePerson;

    /**
     * keeps track of state for field: _ulIdStagePerson
     */
    private boolean _has_ulIdStagePerson;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _szCdStage
     */
    private java.lang.String _szCdStage;

    /**
     * Field _szCdStageProgram
     */
    private java.lang.String _szCdStageProgram;

    /**
     * Field _szCdStageType
     */
    private java.lang.String _szCdStageType;

    /**
     * Field _szCdStageCnty
     */
    private java.lang.String _szCdStageCnty;

    /**
     * Field _tsLastUpdate
     */
    private java.util.Date _tsLastUpdate;

    /**
     * Field _bIndOverPolicyLimit
     */
    private boolean _bIndOverPolicyLimit;

    /**
     * keeps track of state for field: _bIndOverPolicyLimit
     */
    private boolean _has_bIndOverPolicyLimit;


      //----------------/
     //- Constructors -/
    //----------------/

    public AssignmentGroup() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBIndOverPolicyLimit()
    {
        this._has_bIndOverPolicyLimit= false;
    } //-- void deleteBIndOverPolicyLimit() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdPerson()
    {
        this._has_ulIdPerson= false;
    } //-- void deleteUlIdPerson() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     */
    public void deleteUlIdStagePerson()
    {
        this._has_ulIdStagePerson= false;
    } //-- void deleteUlIdStagePerson() 

    /**
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean getBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean getBIndOverPolicyLimit() 

    /**
     * Returns the value of field 'szCdStage'.
     * 
     * @return the value of field 'SzCdStage'.
     */
    public java.lang.String getSzCdStage()
    {
        return this._szCdStage;
    } //-- java.lang.String getSzCdStage() 

    /**
     * Returns the value of field 'szCdStageCnty'.
     * 
     * @return the value of field 'SzCdStageCnty'.
     */
    public java.lang.String getSzCdStageCnty()
    {
        return this._szCdStageCnty;
    } //-- java.lang.String getSzCdStageCnty() 

    /**
     * Returns the value of field 'szCdStagePersRole'.
     * 
     * @return the value of field 'SzCdStagePersRole'.
     */
    public java.lang.String getSzCdStagePersRole()
    {
        return this._szCdStagePersRole;
    } //-- java.lang.String getSzCdStagePersRole() 

    /**
     * Returns the value of field 'szCdStageProgram'.
     * 
     * @return the value of field 'SzCdStageProgram'.
     */
    public java.lang.String getSzCdStageProgram()
    {
        return this._szCdStageProgram;
    } //-- java.lang.String getSzCdStageProgram() 

    /**
     * Returns the value of field 'szCdStageType'.
     * 
     * @return the value of field 'SzCdStageType'.
     */
    public java.lang.String getSzCdStageType()
    {
        return this._szCdStageType;
    } //-- java.lang.String getSzCdStageType() 

    /**
     * Returns the value of field 'szNmPersonFull'.
     * 
     * @return the value of field 'SzNmPersonFull'.
     */
    public java.lang.String getSzNmPersonFull()
    {
        return this._szNmPersonFull;
    } //-- java.lang.String getSzNmPersonFull() 

    /**
     * Returns the value of field 'szNmStage'.
     * 
     * @return the value of field 'SzNmStage'.
     */
    public java.lang.String getSzNmStage()
    {
        return this._szNmStage;
    } //-- java.lang.String getSzNmStage() 

    /**
     * Returns the value of field 'tsLastUpdate'.
     * 
     * @return the value of field 'TsLastUpdate'.
     */
    public java.util.Date getTsLastUpdate()
    {
        return this._tsLastUpdate;
    } //-- java.util.Date getTsLastUpdate() 

    /**
     * Returns the value of field 'ulIdCase'.
     * 
     * @return the value of field 'UlIdCase'.
     */
    public int getUlIdCase()
    {
        return this._ulIdCase;
    } //-- int getUlIdCase() 

    /**
     * Returns the value of field 'ulIdPerson'.
     * 
     * @return the value of field 'UlIdPerson'.
     */
    public int getUlIdPerson()
    {
        return this._ulIdPerson;
    } //-- int getUlIdPerson() 

    /**
     * Returns the value of field 'ulIdStage'.
     * 
     * @return the value of field 'UlIdStage'.
     */
    public int getUlIdStage()
    {
        return this._ulIdStage;
    } //-- int getUlIdStage() 

    /**
     * Returns the value of field 'ulIdStagePerson'.
     * 
     * @return the value of field 'UlIdStagePerson'.
     */
    public int getUlIdStagePerson()
    {
        return this._ulIdStagePerson;
    } //-- int getUlIdStagePerson() 

    /**
     * Method hasBIndOverPolicyLimit
     * 
     * 
     * 
     * @return true if at least one BIndOverPolicyLimit has been
     * added
     */
    public boolean hasBIndOverPolicyLimit()
    {
        return this._has_bIndOverPolicyLimit;
    } //-- boolean hasBIndOverPolicyLimit() 

    /**
     * Method hasUlIdCase
     * 
     * 
     * 
     * @return true if at least one UlIdCase has been added
     */
    public boolean hasUlIdCase()
    {
        return this._has_ulIdCase;
    } //-- boolean hasUlIdCase() 

    /**
     * Method hasUlIdPerson
     * 
     * 
     * 
     * @return true if at least one UlIdPerson has been added
     */
    public boolean hasUlIdPerson()
    {
        return this._has_ulIdPerson;
    } //-- boolean hasUlIdPerson() 

    /**
     * Method hasUlIdStage
     * 
     * 
     * 
     * @return true if at least one UlIdStage has been added
     */
    public boolean hasUlIdStage()
    {
        return this._has_ulIdStage;
    } //-- boolean hasUlIdStage() 

    /**
     * Method hasUlIdStagePerson
     * 
     * 
     * 
     * @return true if at least one UlIdStagePerson has been added
     */
    public boolean hasUlIdStagePerson()
    {
        return this._has_ulIdStagePerson;
    } //-- boolean hasUlIdStagePerson() 

    /**
     * Returns the value of field 'bIndOverPolicyLimit'.
     * 
     * @return the value of field 'BIndOverPolicyLimit'.
     */
    public boolean isBIndOverPolicyLimit()
    {
        return this._bIndOverPolicyLimit;
    } //-- boolean isBIndOverPolicyLimit() 

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
     * Sets the value of field 'bIndOverPolicyLimit'.
     * 
     * @param bIndOverPolicyLimit the value of field
     * 'bIndOverPolicyLimit'.
     */
    public void setBIndOverPolicyLimit(boolean bIndOverPolicyLimit)
    {
        this._bIndOverPolicyLimit = bIndOverPolicyLimit;
        this._has_bIndOverPolicyLimit = true;
    } //-- void setBIndOverPolicyLimit(boolean) 

    /**
     * Sets the value of field 'szCdStage'.
     * 
     * @param szCdStage the value of field 'szCdStage'.
     */
    public void setSzCdStage(java.lang.String szCdStage)
    {
        this._szCdStage = szCdStage;
    } //-- void setSzCdStage(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageCnty'.
     * 
     * @param szCdStageCnty the value of field 'szCdStageCnty'.
     */
    public void setSzCdStageCnty(java.lang.String szCdStageCnty)
    {
        this._szCdStageCnty = szCdStageCnty;
    } //-- void setSzCdStageCnty(java.lang.String) 

    /**
     * Sets the value of field 'szCdStagePersRole'.
     * 
     * @param szCdStagePersRole the value of field
     * 'szCdStagePersRole'.
     */
    public void setSzCdStagePersRole(java.lang.String szCdStagePersRole)
    {
        this._szCdStagePersRole = szCdStagePersRole;
    } //-- void setSzCdStagePersRole(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageProgram'.
     * 
     * @param szCdStageProgram the value of field 'szCdStageProgram'
     */
    public void setSzCdStageProgram(java.lang.String szCdStageProgram)
    {
        this._szCdStageProgram = szCdStageProgram;
    } //-- void setSzCdStageProgram(java.lang.String) 

    /**
     * Sets the value of field 'szCdStageType'.
     * 
     * @param szCdStageType the value of field 'szCdStageType'.
     */
    public void setSzCdStageType(java.lang.String szCdStageType)
    {
        this._szCdStageType = szCdStageType;
    } //-- void setSzCdStageType(java.lang.String) 

    /**
     * Sets the value of field 'szNmPersonFull'.
     * 
     * @param szNmPersonFull the value of field 'szNmPersonFull'.
     */
    public void setSzNmPersonFull(java.lang.String szNmPersonFull)
    {
        this._szNmPersonFull = szNmPersonFull;
    } //-- void setSzNmPersonFull(java.lang.String) 

    /**
     * Sets the value of field 'szNmStage'.
     * 
     * @param szNmStage the value of field 'szNmStage'.
     */
    public void setSzNmStage(java.lang.String szNmStage)
    {
        this._szNmStage = szNmStage;
    } //-- void setSzNmStage(java.lang.String) 

    /**
     * Sets the value of field 'tsLastUpdate'.
     * 
     * @param tsLastUpdate the value of field 'tsLastUpdate'.
     */
    public void setTsLastUpdate(java.util.Date tsLastUpdate)
    {
        this._tsLastUpdate = tsLastUpdate;
    } //-- void setTsLastUpdate(java.util.Date) 

    /**
     * Sets the value of field 'ulIdCase'.
     * 
     * @param ulIdCase the value of field 'ulIdCase'.
     */
    public void setUlIdCase(int ulIdCase)
    {
        this._ulIdCase = ulIdCase;
        this._has_ulIdCase = true;
    } //-- void setUlIdCase(int) 

    /**
     * Sets the value of field 'ulIdPerson'.
     * 
     * @param ulIdPerson the value of field 'ulIdPerson'.
     */
    public void setUlIdPerson(int ulIdPerson)
    {
        this._ulIdPerson = ulIdPerson;
        this._has_ulIdPerson = true;
    } //-- void setUlIdPerson(int) 

    /**
     * Sets the value of field 'ulIdStage'.
     * 
     * @param ulIdStage the value of field 'ulIdStage'.
     */
    public void setUlIdStage(int ulIdStage)
    {
        this._ulIdStage = ulIdStage;
        this._has_ulIdStage = true;
    } //-- void setUlIdStage(int) 

    /**
     * Sets the value of field 'ulIdStagePerson'.
     * 
     * @param ulIdStagePerson the value of field 'ulIdStagePerson'.
     */
    public void setUlIdStagePerson(int ulIdStagePerson)
    {
        this._ulIdStagePerson = ulIdStagePerson;
        this._has_ulIdStagePerson = true;
    } //-- void setUlIdStagePerson(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup unmarshal(java.io.Reader) 

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
