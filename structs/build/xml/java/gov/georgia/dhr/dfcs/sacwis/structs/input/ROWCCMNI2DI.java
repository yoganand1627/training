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
 * Class ROWCCMNI2DI.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ROWCCMNI2DI extends gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ulIdApprovalRejection
     */
    private int _ulIdApprovalRejection;

    /**
     * keeps track of state for field: _ulIdApprovalRejection
     */
    private boolean _has_ulIdApprovalRejection;

    /**
     * Field _ulIdCase
     */
    private int _ulIdCase;

    /**
     * keeps track of state for field: _ulIdCase
     */
    private boolean _has_ulIdCase;

    /**
     * Field _ulIdStage
     */
    private int _ulIdStage;

    /**
     * keeps track of state for field: _ulIdStage
     */
    private boolean _has_ulIdStage;

    /**
     * Field _ulIdRejector
     */
    private int _ulIdRejector;

    /**
     * keeps track of state for field: _ulIdRejector
     */
    private boolean _has_ulIdRejector;

    /**
     * Field _dtDtRejection
     */
    private org.exolab.castor.types.Date _dtDtRejection;

    /**
     * Field _bIndApsEffort
     */
    private java.lang.String _bIndApsEffort;

    /**
     * Field _bIndCareEntered
     */
    private java.lang.String _bIndCareEntered;

    /**
     * Field _bIndEvidence
     */
    private java.lang.String _bIndEvidence;

    /**
     * Field _bIndMissingEvidRptr
     */
    private java.lang.String _bIndMissingEvidRptr;

    /**
     * Field _bIndMissingEvidAp
     */
    private java.lang.String _bIndMissingEvidAp;

    /**
     * Field _bIndMissingEvidMp
     */
    private java.lang.String _bIndMissingEvidMp;

    /**
     * Field _bIndMissingEvidCl
     */
    private java.lang.String _bIndMissingEvidCl;

    /**
     * Field _bIndMissingEvidPhoto
     */
    private java.lang.String _bIndMissingEvidPhoto;

    /**
     * Field _bIndMissingEvidDe
     */
    private java.lang.String _bIndMissingEvidDe;

    /**
     * Field _bIndMissingEvidOther
     */
    private java.lang.String _bIndMissingEvidOther;

    /**
     * Field _bIndDiscretionaryReason
     */
    private java.lang.String _bIndDiscretionaryReason;

    /**
     * Field _szTxtApproversComments
     */
    private java.lang.String _szTxtApproversComments;

    /**
     * Field _szNMRejector
     */
    private java.lang.String _szNMRejector;


      //----------------/
     //- Constructors -/
    //----------------/

    public ROWCCMNI2DI() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteUlIdApprovalRejection()
    {
        this._has_ulIdApprovalRejection= false;
    } //-- void deleteUlIdApprovalRejection() 

    /**
     */
    public void deleteUlIdCase()
    {
        this._has_ulIdCase= false;
    } //-- void deleteUlIdCase() 

    /**
     */
    public void deleteUlIdRejector()
    {
        this._has_ulIdRejector= false;
    } //-- void deleteUlIdRejector() 

    /**
     */
    public void deleteUlIdStage()
    {
        this._has_ulIdStage= false;
    } //-- void deleteUlIdStage() 

    /**
     * Returns the value of field 'bIndApsEffort'.
     * 
     * @return the value of field 'BIndApsEffort'.
     */
    public java.lang.String getBIndApsEffort()
    {
        return this._bIndApsEffort;
    } //-- java.lang.String getBIndApsEffort() 

    /**
     * Returns the value of field 'bIndCareEntered'.
     * 
     * @return the value of field 'BIndCareEntered'.
     */
    public java.lang.String getBIndCareEntered()
    {
        return this._bIndCareEntered;
    } //-- java.lang.String getBIndCareEntered() 

    /**
     * Returns the value of field 'bIndDiscretionaryReason'.
     * 
     * @return the value of field 'BIndDiscretionaryReason'.
     */
    public java.lang.String getBIndDiscretionaryReason()
    {
        return this._bIndDiscretionaryReason;
    } //-- java.lang.String getBIndDiscretionaryReason() 

    /**
     * Returns the value of field 'bIndEvidence'.
     * 
     * @return the value of field 'BIndEvidence'.
     */
    public java.lang.String getBIndEvidence()
    {
        return this._bIndEvidence;
    } //-- java.lang.String getBIndEvidence() 

    /**
     * Returns the value of field 'bIndMissingEvidAp'.
     * 
     * @return the value of field 'BIndMissingEvidAp'.
     */
    public java.lang.String getBIndMissingEvidAp()
    {
        return this._bIndMissingEvidAp;
    } //-- java.lang.String getBIndMissingEvidAp() 

    /**
     * Returns the value of field 'bIndMissingEvidCl'.
     * 
     * @return the value of field 'BIndMissingEvidCl'.
     */
    public java.lang.String getBIndMissingEvidCl()
    {
        return this._bIndMissingEvidCl;
    } //-- java.lang.String getBIndMissingEvidCl() 

    /**
     * Returns the value of field 'bIndMissingEvidDe'.
     * 
     * @return the value of field 'BIndMissingEvidDe'.
     */
    public java.lang.String getBIndMissingEvidDe()
    {
        return this._bIndMissingEvidDe;
    } //-- java.lang.String getBIndMissingEvidDe() 

    /**
     * Returns the value of field 'bIndMissingEvidMp'.
     * 
     * @return the value of field 'BIndMissingEvidMp'.
     */
    public java.lang.String getBIndMissingEvidMp()
    {
        return this._bIndMissingEvidMp;
    } //-- java.lang.String getBIndMissingEvidMp() 

    /**
     * Returns the value of field 'bIndMissingEvidOther'.
     * 
     * @return the value of field 'BIndMissingEvidOther'.
     */
    public java.lang.String getBIndMissingEvidOther()
    {
        return this._bIndMissingEvidOther;
    } //-- java.lang.String getBIndMissingEvidOther() 

    /**
     * Returns the value of field 'bIndMissingEvidPhoto'.
     * 
     * @return the value of field 'BIndMissingEvidPhoto'.
     */
    public java.lang.String getBIndMissingEvidPhoto()
    {
        return this._bIndMissingEvidPhoto;
    } //-- java.lang.String getBIndMissingEvidPhoto() 

    /**
     * Returns the value of field 'bIndMissingEvidRptr'.
     * 
     * @return the value of field 'BIndMissingEvidRptr'.
     */
    public java.lang.String getBIndMissingEvidRptr()
    {
        return this._bIndMissingEvidRptr;
    } //-- java.lang.String getBIndMissingEvidRptr() 

    /**
     * Returns the value of field 'dtDtRejection'.
     * 
     * @return the value of field 'DtDtRejection'.
     */
    public org.exolab.castor.types.Date getDtDtRejection()
    {
        return this._dtDtRejection;
    } //-- org.exolab.castor.types.Date getDtDtRejection() 

    /**
     * Returns the value of field 'szNMRejector'.
     * 
     * @return the value of field 'SzNMRejector'.
     */
    public java.lang.String getSzNMRejector()
    {
        return this._szNMRejector;
    } //-- java.lang.String getSzNMRejector() 

    /**
     * Returns the value of field 'szTxtApproversComments'.
     * 
     * @return the value of field 'SzTxtApproversComments'.
     */
    public java.lang.String getSzTxtApproversComments()
    {
        return this._szTxtApproversComments;
    } //-- java.lang.String getSzTxtApproversComments() 

    /**
     * Returns the value of field 'ulIdApprovalRejection'.
     * 
     * @return the value of field 'UlIdApprovalRejection'.
     */
    public int getUlIdApprovalRejection()
    {
        return this._ulIdApprovalRejection;
    } //-- int getUlIdApprovalRejection() 

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
     * Returns the value of field 'ulIdRejector'.
     * 
     * @return the value of field 'UlIdRejector'.
     */
    public int getUlIdRejector()
    {
        return this._ulIdRejector;
    } //-- int getUlIdRejector() 

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
     * Method hasUlIdApprovalRejection
     * 
     * 
     * 
     * @return true if at least one UlIdApprovalRejection has been
     * added
     */
    public boolean hasUlIdApprovalRejection()
    {
        return this._has_ulIdApprovalRejection;
    } //-- boolean hasUlIdApprovalRejection() 

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
     * Method hasUlIdRejector
     * 
     * 
     * 
     * @return true if at least one UlIdRejector has been added
     */
    public boolean hasUlIdRejector()
    {
        return this._has_ulIdRejector;
    } //-- boolean hasUlIdRejector() 

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
     * Sets the value of field 'bIndApsEffort'.
     * 
     * @param bIndApsEffort the value of field 'bIndApsEffort'.
     */
    public void setBIndApsEffort(java.lang.String bIndApsEffort)
    {
        this._bIndApsEffort = bIndApsEffort;
    } //-- void setBIndApsEffort(java.lang.String) 

    /**
     * Sets the value of field 'bIndCareEntered'.
     * 
     * @param bIndCareEntered the value of field 'bIndCareEntered'.
     */
    public void setBIndCareEntered(java.lang.String bIndCareEntered)
    {
        this._bIndCareEntered = bIndCareEntered;
    } //-- void setBIndCareEntered(java.lang.String) 

    /**
     * Sets the value of field 'bIndDiscretionaryReason'.
     * 
     * @param bIndDiscretionaryReason the value of field
     * 'bIndDiscretionaryReason'.
     */
    public void setBIndDiscretionaryReason(java.lang.String bIndDiscretionaryReason)
    {
        this._bIndDiscretionaryReason = bIndDiscretionaryReason;
    } //-- void setBIndDiscretionaryReason(java.lang.String) 

    /**
     * Sets the value of field 'bIndEvidence'.
     * 
     * @param bIndEvidence the value of field 'bIndEvidence'.
     */
    public void setBIndEvidence(java.lang.String bIndEvidence)
    {
        this._bIndEvidence = bIndEvidence;
    } //-- void setBIndEvidence(java.lang.String) 

    /**
     * Sets the value of field 'bIndMissingEvidAp'.
     * 
     * @param bIndMissingEvidAp the value of field
     * 'bIndMissingEvidAp'.
     */
    public void setBIndMissingEvidAp(java.lang.String bIndMissingEvidAp)
    {
        this._bIndMissingEvidAp = bIndMissingEvidAp;
    } //-- void setBIndMissingEvidAp(java.lang.String) 

    /**
     * Sets the value of field 'bIndMissingEvidCl'.
     * 
     * @param bIndMissingEvidCl the value of field
     * 'bIndMissingEvidCl'.
     */
    public void setBIndMissingEvidCl(java.lang.String bIndMissingEvidCl)
    {
        this._bIndMissingEvidCl = bIndMissingEvidCl;
    } //-- void setBIndMissingEvidCl(java.lang.String) 

    /**
     * Sets the value of field 'bIndMissingEvidDe'.
     * 
     * @param bIndMissingEvidDe the value of field
     * 'bIndMissingEvidDe'.
     */
    public void setBIndMissingEvidDe(java.lang.String bIndMissingEvidDe)
    {
        this._bIndMissingEvidDe = bIndMissingEvidDe;
    } //-- void setBIndMissingEvidDe(java.lang.String) 

    /**
     * Sets the value of field 'bIndMissingEvidMp'.
     * 
     * @param bIndMissingEvidMp the value of field
     * 'bIndMissingEvidMp'.
     */
    public void setBIndMissingEvidMp(java.lang.String bIndMissingEvidMp)
    {
        this._bIndMissingEvidMp = bIndMissingEvidMp;
    } //-- void setBIndMissingEvidMp(java.lang.String) 

    /**
     * Sets the value of field 'bIndMissingEvidOther'.
     * 
     * @param bIndMissingEvidOther the value of field
     * 'bIndMissingEvidOther'.
     */
    public void setBIndMissingEvidOther(java.lang.String bIndMissingEvidOther)
    {
        this._bIndMissingEvidOther = bIndMissingEvidOther;
    } //-- void setBIndMissingEvidOther(java.lang.String) 

    /**
     * Sets the value of field 'bIndMissingEvidPhoto'.
     * 
     * @param bIndMissingEvidPhoto the value of field
     * 'bIndMissingEvidPhoto'.
     */
    public void setBIndMissingEvidPhoto(java.lang.String bIndMissingEvidPhoto)
    {
        this._bIndMissingEvidPhoto = bIndMissingEvidPhoto;
    } //-- void setBIndMissingEvidPhoto(java.lang.String) 

    /**
     * Sets the value of field 'bIndMissingEvidRptr'.
     * 
     * @param bIndMissingEvidRptr the value of field
     * 'bIndMissingEvidRptr'.
     */
    public void setBIndMissingEvidRptr(java.lang.String bIndMissingEvidRptr)
    {
        this._bIndMissingEvidRptr = bIndMissingEvidRptr;
    } //-- void setBIndMissingEvidRptr(java.lang.String) 

    /**
     * Sets the value of field 'dtDtRejection'.
     * 
     * @param dtDtRejection the value of field 'dtDtRejection'.
     */
    public void setDtDtRejection(org.exolab.castor.types.Date dtDtRejection)
    {
        this._dtDtRejection = dtDtRejection;
    } //-- void setDtDtRejection(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'szNMRejector'.
     * 
     * @param szNMRejector the value of field 'szNMRejector'.
     */
    public void setSzNMRejector(java.lang.String szNMRejector)
    {
        this._szNMRejector = szNMRejector;
    } //-- void setSzNMRejector(java.lang.String) 

    /**
     * Sets the value of field 'szTxtApproversComments'.
     * 
     * @param szTxtApproversComments the value of field
     * 'szTxtApproversComments'.
     */
    public void setSzTxtApproversComments(java.lang.String szTxtApproversComments)
    {
        this._szTxtApproversComments = szTxtApproversComments;
    } //-- void setSzTxtApproversComments(java.lang.String) 

    /**
     * Sets the value of field 'ulIdApprovalRejection'.
     * 
     * @param ulIdApprovalRejection the value of field
     * 'ulIdApprovalRejection'.
     */
    public void setUlIdApprovalRejection(int ulIdApprovalRejection)
    {
        this._ulIdApprovalRejection = ulIdApprovalRejection;
        this._has_ulIdApprovalRejection = true;
    } //-- void setUlIdApprovalRejection(int) 

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
     * Sets the value of field 'ulIdRejector'.
     * 
     * @param ulIdRejector the value of field 'ulIdRejector'.
     */
    public void setUlIdRejector(int ulIdRejector)
    {
        this._ulIdRejector = ulIdRejector;
        this._has_ulIdRejector = true;
    } //-- void setUlIdRejector(int) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMNI2DI unmarshal(java.io.Reader) 

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
