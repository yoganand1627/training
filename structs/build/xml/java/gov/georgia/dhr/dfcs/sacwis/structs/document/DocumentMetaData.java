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
 * Class DocumentMetaData.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DocumentMetaData implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _documentType
     */
    private java.lang.String _documentType;

    /**
     * Field _documentDisplayName
     */
    private java.lang.String _documentDisplayName;

    /**
     * Field _documentCategory
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType _documentCategory;

    /**
     * Field _templateType
     */
    private java.lang.String _templateType;

    /**
     * Field _newTemplateVersion
     */
    private int _newTemplateVersion;

    /**
     * keeps track of state for field: _newTemplateVersion
     */
    private boolean _has_newTemplateVersion;

    /**
     * Field _actualTemplateVersion
     */
    private int _actualTemplateVersion;

    /**
     * keeps track of state for field: _actualTemplateVersion
     */
    private boolean _has_actualTemplateVersion;

    /**
     * Field _legacy
     */
    private boolean _legacy;

    /**
     * keeps track of state for field: _legacy
     */
    private boolean _has_legacy;

    /**
     * Field _renderFormat
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType _renderFormat;

    /**
     * Field _hasFooter
     */
    private boolean _hasFooter;

    /**
     * keeps track of state for field: _hasFooter
     */
    private boolean _has_hasFooter;

    /**
     * Field _displayOnly
     */
    private boolean _displayOnly;

    /**
     * keeps track of state for field: _displayOnly
     */
    private boolean _has_displayOnly;

    /**
     * Field _documentExists
     */
    private boolean _documentExists;

    /**
     * keeps track of state for field: _documentExists
     */
    private boolean _has_documentExists;

    /**
     * Field _checkStage
     */
    private int _checkStage;

    /**
     * keeps track of state for field: _checkStage
     */
    private boolean _has_checkStage;

    /**
     * Field _validationClass
     */
    private java.lang.String _validationClass;

    /**
     * Field _validationParameters
     */
    private java.lang.String _validationParameters;

    /**
     * Field _saveActionClass
     */
    private java.lang.String _saveActionClass;

    /**
     * Field _successActionClass
     */
    private java.lang.String _successActionClass;

    /**
     * Field _isInApproverMode
     */
    private boolean _isInApproverMode;

    /**
     * keeps track of state for field: _isInApproverMode
     */
    private boolean _has_isInApproverMode;

    /**
     * Field _userName
     */
    private java.lang.String _userName;

    /**
     * Field _userId
     */
    private int _userId;

    /**
     * keeps track of state for field: _userId
     */
    private boolean _has_userId;

    /**
     * Field _stageId
     */
    private int _stageId;

    /**
     * keeps track of state for field: _stageId
     */
    private boolean _has_stageId;

    /**
     * Field _caseId
     */
    private int _caseId;

    /**
     * keeps track of state for field: _caseId
     */
    private boolean _has_caseId;

    /**
     * Field _preFillMetaData
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData _preFillMetaData;

    /**
     * Field _tableMetaData
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData _tableMetaData;

    /**
     * Field _validEventStatus
     */
    private gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus _validEventStatus;


      //----------------/
     //- Constructors -/
    //----------------/

    public DocumentMetaData() 
     {
        super();
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteActualTemplateVersion()
    {
        this._has_actualTemplateVersion= false;
    } //-- void deleteActualTemplateVersion() 

    /**
     */
    public void deleteCaseId()
    {
        this._has_caseId= false;
    } //-- void deleteCaseId() 

    /**
     */
    public void deleteCheckStage()
    {
        this._has_checkStage= false;
    } //-- void deleteCheckStage() 

    /**
     */
    public void deleteDisplayOnly()
    {
        this._has_displayOnly= false;
    } //-- void deleteDisplayOnly() 

    /**
     */
    public void deleteDocumentExists()
    {
        this._has_documentExists= false;
    } //-- void deleteDocumentExists() 

    /**
     */
    public void deleteHasFooter()
    {
        this._has_hasFooter= false;
    } //-- void deleteHasFooter() 

    /**
     */
    public void deleteIsInApproverMode()
    {
        this._has_isInApproverMode= false;
    } //-- void deleteIsInApproverMode() 

    /**
     */
    public void deleteLegacy()
    {
        this._has_legacy= false;
    } //-- void deleteLegacy() 

    /**
     */
    public void deleteNewTemplateVersion()
    {
        this._has_newTemplateVersion= false;
    } //-- void deleteNewTemplateVersion() 

    /**
     */
    public void deleteStageId()
    {
        this._has_stageId= false;
    } //-- void deleteStageId() 

    /**
     */
    public void deleteUserId()
    {
        this._has_userId= false;
    } //-- void deleteUserId() 

    /**
     * Returns the value of field 'actualTemplateVersion'.
     * 
     * @return the value of field 'ActualTemplateVersion'.
     */
    public int getActualTemplateVersion()
    {
        return this._actualTemplateVersion;
    } //-- int getActualTemplateVersion() 

    /**
     * Returns the value of field 'caseId'.
     * 
     * @return the value of field 'CaseId'.
     */
    public int getCaseId()
    {
        return this._caseId;
    } //-- int getCaseId() 

    /**
     * Returns the value of field 'checkStage'.
     * 
     * @return the value of field 'CheckStage'.
     */
    public int getCheckStage()
    {
        return this._checkStage;
    } //-- int getCheckStage() 

    /**
     * Returns the value of field 'displayOnly'.
     * 
     * @return the value of field 'DisplayOnly'.
     */
    public boolean getDisplayOnly()
    {
        return this._displayOnly;
    } //-- boolean getDisplayOnly() 

    /**
     * Returns the value of field 'documentCategory'.
     * 
     * @return the value of field 'DocumentCategory'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType getDocumentCategory()
    {
        return this._documentCategory;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType getDocumentCategory() 

    /**
     * Returns the value of field 'documentDisplayName'.
     * 
     * @return the value of field 'DocumentDisplayName'.
     */
    public java.lang.String getDocumentDisplayName()
    {
        return this._documentDisplayName;
    } //-- java.lang.String getDocumentDisplayName() 

    /**
     * Returns the value of field 'documentExists'.
     * 
     * @return the value of field 'DocumentExists'.
     */
    public boolean getDocumentExists()
    {
        return this._documentExists;
    } //-- boolean getDocumentExists() 

    /**
     * Returns the value of field 'documentType'.
     * 
     * @return the value of field 'DocumentType'.
     */
    public java.lang.String getDocumentType()
    {
        return this._documentType;
    } //-- java.lang.String getDocumentType() 

    /**
     * Returns the value of field 'hasFooter'.
     * 
     * @return the value of field 'HasFooter'.
     */
    public boolean getHasFooter()
    {
        return this._hasFooter;
    } //-- boolean getHasFooter() 

    /**
     * Returns the value of field 'isInApproverMode'.
     * 
     * @return the value of field 'IsInApproverMode'.
     */
    public boolean getIsInApproverMode()
    {
        return this._isInApproverMode;
    } //-- boolean getIsInApproverMode() 

    /**
     * Returns the value of field 'legacy'.
     * 
     * @return the value of field 'Legacy'.
     */
    public boolean getLegacy()
    {
        return this._legacy;
    } //-- boolean getLegacy() 

    /**
     * Returns the value of field 'newTemplateVersion'.
     * 
     * @return the value of field 'NewTemplateVersion'.
     */
    public int getNewTemplateVersion()
    {
        return this._newTemplateVersion;
    } //-- int getNewTemplateVersion() 

    /**
     * Returns the value of field 'preFillMetaData'.
     * 
     * @return the value of field 'PreFillMetaData'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData getPreFillMetaData()
    {
        return this._preFillMetaData;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData getPreFillMetaData() 

    /**
     * Returns the value of field 'renderFormat'.
     * 
     * @return the value of field 'RenderFormat'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType getRenderFormat()
    {
        return this._renderFormat;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType getRenderFormat() 

    /**
     * Returns the value of field 'saveActionClass'.
     * 
     * @return the value of field 'SaveActionClass'.
     */
    public java.lang.String getSaveActionClass()
    {
        return this._saveActionClass;
    } //-- java.lang.String getSaveActionClass() 

    /**
     * Returns the value of field 'stageId'.
     * 
     * @return the value of field 'StageId'.
     */
    public int getStageId()
    {
        return this._stageId;
    } //-- int getStageId() 

    /**
     * Returns the value of field 'successActionClass'.
     * 
     * @return the value of field 'SuccessActionClass'.
     */
    public java.lang.String getSuccessActionClass()
    {
        return this._successActionClass;
    } //-- java.lang.String getSuccessActionClass() 

    /**
     * Returns the value of field 'tableMetaData'.
     * 
     * @return the value of field 'TableMetaData'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData getTableMetaData()
    {
        return this._tableMetaData;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData getTableMetaData() 

    /**
     * Returns the value of field 'templateType'.
     * 
     * @return the value of field 'TemplateType'.
     */
    public java.lang.String getTemplateType()
    {
        return this._templateType;
    } //-- java.lang.String getTemplateType() 

    /**
     * Returns the value of field 'userId'.
     * 
     * @return the value of field 'UserId'.
     */
    public int getUserId()
    {
        return this._userId;
    } //-- int getUserId() 

    /**
     * Returns the value of field 'userName'.
     * 
     * @return the value of field 'UserName'.
     */
    public java.lang.String getUserName()
    {
        return this._userName;
    } //-- java.lang.String getUserName() 

    /**
     * Returns the value of field 'validEventStatus'.
     * 
     * @return the value of field 'ValidEventStatus'.
     */
    public gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus getValidEventStatus()
    {
        return this._validEventStatus;
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus getValidEventStatus() 

    /**
     * Returns the value of field 'validationClass'.
     * 
     * @return the value of field 'ValidationClass'.
     */
    public java.lang.String getValidationClass()
    {
        return this._validationClass;
    } //-- java.lang.String getValidationClass() 

    /**
     * Returns the value of field 'validationParameters'.
     * 
     * @return the value of field 'ValidationParameters'.
     */
    public java.lang.String getValidationParameters()
    {
        return this._validationParameters;
    } //-- java.lang.String getValidationParameters() 

    /**
     * Method hasActualTemplateVersion
     * 
     * 
     * 
     * @return true if at least one ActualTemplateVersion has been
     * added
     */
    public boolean hasActualTemplateVersion()
    {
        return this._has_actualTemplateVersion;
    } //-- boolean hasActualTemplateVersion() 

    /**
     * Method hasCaseId
     * 
     * 
     * 
     * @return true if at least one CaseId has been added
     */
    public boolean hasCaseId()
    {
        return this._has_caseId;
    } //-- boolean hasCaseId() 

    /**
     * Method hasCheckStage
     * 
     * 
     * 
     * @return true if at least one CheckStage has been added
     */
    public boolean hasCheckStage()
    {
        return this._has_checkStage;
    } //-- boolean hasCheckStage() 

    /**
     * Method hasDisplayOnly
     * 
     * 
     * 
     * @return true if at least one DisplayOnly has been added
     */
    public boolean hasDisplayOnly()
    {
        return this._has_displayOnly;
    } //-- boolean hasDisplayOnly() 

    /**
     * Method hasDocumentExists
     * 
     * 
     * 
     * @return true if at least one DocumentExists has been added
     */
    public boolean hasDocumentExists()
    {
        return this._has_documentExists;
    } //-- boolean hasDocumentExists() 

    /**
     * Method hasHasFooter
     * 
     * 
     * 
     * @return true if at least one HasFooter has been added
     */
    public boolean hasHasFooter()
    {
        return this._has_hasFooter;
    } //-- boolean hasHasFooter() 

    /**
     * Method hasIsInApproverMode
     * 
     * 
     * 
     * @return true if at least one IsInApproverMode has been added
     */
    public boolean hasIsInApproverMode()
    {
        return this._has_isInApproverMode;
    } //-- boolean hasIsInApproverMode() 

    /**
     * Method hasLegacy
     * 
     * 
     * 
     * @return true if at least one Legacy has been added
     */
    public boolean hasLegacy()
    {
        return this._has_legacy;
    } //-- boolean hasLegacy() 

    /**
     * Method hasNewTemplateVersion
     * 
     * 
     * 
     * @return true if at least one NewTemplateVersion has been adde
     */
    public boolean hasNewTemplateVersion()
    {
        return this._has_newTemplateVersion;
    } //-- boolean hasNewTemplateVersion() 

    /**
     * Method hasStageId
     * 
     * 
     * 
     * @return true if at least one StageId has been added
     */
    public boolean hasStageId()
    {
        return this._has_stageId;
    } //-- boolean hasStageId() 

    /**
     * Method hasUserId
     * 
     * 
     * 
     * @return true if at least one UserId has been added
     */
    public boolean hasUserId()
    {
        return this._has_userId;
    } //-- boolean hasUserId() 

    /**
     * Returns the value of field 'displayOnly'.
     * 
     * @return the value of field 'DisplayOnly'.
     */
    public boolean isDisplayOnly()
    {
        return this._displayOnly;
    } //-- boolean isDisplayOnly() 

    /**
     * Returns the value of field 'documentExists'.
     * 
     * @return the value of field 'DocumentExists'.
     */
    public boolean isDocumentExists()
    {
        return this._documentExists;
    } //-- boolean isDocumentExists() 

    /**
     * Returns the value of field 'hasFooter'.
     * 
     * @return the value of field 'HasFooter'.
     */
    public boolean isHasFooter()
    {
        return this._hasFooter;
    } //-- boolean isHasFooter() 

    /**
     * Returns the value of field 'isInApproverMode'.
     * 
     * @return the value of field 'IsInApproverMode'.
     */
    public boolean isIsInApproverMode()
    {
        return this._isInApproverMode;
    } //-- boolean isIsInApproverMode() 

    /**
     * Returns the value of field 'legacy'.
     * 
     * @return the value of field 'Legacy'.
     */
    public boolean isLegacy()
    {
        return this._legacy;
    } //-- boolean isLegacy() 

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
     * Sets the value of field 'actualTemplateVersion'.
     * 
     * @param actualTemplateVersion the value of field
     * 'actualTemplateVersion'.
     */
    public void setActualTemplateVersion(int actualTemplateVersion)
    {
        this._actualTemplateVersion = actualTemplateVersion;
        this._has_actualTemplateVersion = true;
    } //-- void setActualTemplateVersion(int) 

    /**
     * Sets the value of field 'caseId'.
     * 
     * @param caseId the value of field 'caseId'.
     */
    public void setCaseId(int caseId)
    {
        this._caseId = caseId;
        this._has_caseId = true;
    } //-- void setCaseId(int) 

    /**
     * Sets the value of field 'checkStage'.
     * 
     * @param checkStage the value of field 'checkStage'.
     */
    public void setCheckStage(int checkStage)
    {
        this._checkStage = checkStage;
        this._has_checkStage = true;
    } //-- void setCheckStage(int) 

    /**
     * Sets the value of field 'displayOnly'.
     * 
     * @param displayOnly the value of field 'displayOnly'.
     */
    public void setDisplayOnly(boolean displayOnly)
    {
        this._displayOnly = displayOnly;
        this._has_displayOnly = true;
    } //-- void setDisplayOnly(boolean) 

    /**
     * Sets the value of field 'documentCategory'.
     * 
     * @param documentCategory the value of field 'documentCategory'
     */
    public void setDocumentCategory(gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType documentCategory)
    {
        this._documentCategory = documentCategory;
    } //-- void setDocumentCategory(gov.georgia.dhr.dfcs.sacwis.structs.document.types.CategoryType) 

    /**
     * Sets the value of field 'documentDisplayName'.
     * 
     * @param documentDisplayName the value of field
     * 'documentDisplayName'.
     */
    public void setDocumentDisplayName(java.lang.String documentDisplayName)
    {
        this._documentDisplayName = documentDisplayName;
    } //-- void setDocumentDisplayName(java.lang.String) 

    /**
     * Sets the value of field 'documentExists'.
     * 
     * @param documentExists the value of field 'documentExists'.
     */
    public void setDocumentExists(boolean documentExists)
    {
        this._documentExists = documentExists;
        this._has_documentExists = true;
    } //-- void setDocumentExists(boolean) 

    /**
     * Sets the value of field 'documentType'.
     * 
     * @param documentType the value of field 'documentType'.
     */
    public void setDocumentType(java.lang.String documentType)
    {
        this._documentType = documentType;
    } //-- void setDocumentType(java.lang.String) 

    /**
     * Sets the value of field 'hasFooter'.
     * 
     * @param hasFooter the value of field 'hasFooter'.
     */
    public void setHasFooter(boolean hasFooter)
    {
        this._hasFooter = hasFooter;
        this._has_hasFooter = true;
    } //-- void setHasFooter(boolean) 

    /**
     * Sets the value of field 'isInApproverMode'.
     * 
     * @param isInApproverMode the value of field 'isInApproverMode'
     */
    public void setIsInApproverMode(boolean isInApproverMode)
    {
        this._isInApproverMode = isInApproverMode;
        this._has_isInApproverMode = true;
    } //-- void setIsInApproverMode(boolean) 

    /**
     * Sets the value of field 'legacy'.
     * 
     * @param legacy the value of field 'legacy'.
     */
    public void setLegacy(boolean legacy)
    {
        this._legacy = legacy;
        this._has_legacy = true;
    } //-- void setLegacy(boolean) 

    /**
     * Sets the value of field 'newTemplateVersion'.
     * 
     * @param newTemplateVersion the value of field
     * 'newTemplateVersion'.
     */
    public void setNewTemplateVersion(int newTemplateVersion)
    {
        this._newTemplateVersion = newTemplateVersion;
        this._has_newTemplateVersion = true;
    } //-- void setNewTemplateVersion(int) 

    /**
     * Sets the value of field 'preFillMetaData'.
     * 
     * @param preFillMetaData the value of field 'preFillMetaData'.
     */
    public void setPreFillMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData preFillMetaData)
    {
        this._preFillMetaData = preFillMetaData;
    } //-- void setPreFillMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.PreFillMetaData) 

    /**
     * Sets the value of field 'renderFormat'.
     * 
     * @param renderFormat the value of field 'renderFormat'.
     */
    public void setRenderFormat(gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType renderFormat)
    {
        this._renderFormat = renderFormat;
    } //-- void setRenderFormat(gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType) 

    /**
     * Sets the value of field 'saveActionClass'.
     * 
     * @param saveActionClass the value of field 'saveActionClass'.
     */
    public void setSaveActionClass(java.lang.String saveActionClass)
    {
        this._saveActionClass = saveActionClass;
    } //-- void setSaveActionClass(java.lang.String) 

    /**
     * Sets the value of field 'stageId'.
     * 
     * @param stageId the value of field 'stageId'.
     */
    public void setStageId(int stageId)
    {
        this._stageId = stageId;
        this._has_stageId = true;
    } //-- void setStageId(int) 

    /**
     * Sets the value of field 'successActionClass'.
     * 
     * @param successActionClass the value of field
     * 'successActionClass'.
     */
    public void setSuccessActionClass(java.lang.String successActionClass)
    {
        this._successActionClass = successActionClass;
    } //-- void setSuccessActionClass(java.lang.String) 

    /**
     * Sets the value of field 'tableMetaData'.
     * 
     * @param tableMetaData the value of field 'tableMetaData'.
     */
    public void setTableMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData tableMetaData)
    {
        this._tableMetaData = tableMetaData;
    } //-- void setTableMetaData(gov.georgia.dhr.dfcs.sacwis.structs.document.TableMetaData) 

    /**
     * Sets the value of field 'templateType'.
     * 
     * @param templateType the value of field 'templateType'.
     */
    public void setTemplateType(java.lang.String templateType)
    {
        this._templateType = templateType;
    } //-- void setTemplateType(java.lang.String) 

    /**
     * Sets the value of field 'userId'.
     * 
     * @param userId the value of field 'userId'.
     */
    public void setUserId(int userId)
    {
        this._userId = userId;
        this._has_userId = true;
    } //-- void setUserId(int) 

    /**
     * Sets the value of field 'userName'.
     * 
     * @param userName the value of field 'userName'.
     */
    public void setUserName(java.lang.String userName)
    {
        this._userName = userName;
    } //-- void setUserName(java.lang.String) 

    /**
     * Sets the value of field 'validEventStatus'.
     * 
     * @param validEventStatus the value of field 'validEventStatus'
     */
    public void setValidEventStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus validEventStatus)
    {
        this._validEventStatus = validEventStatus;
    } //-- void setValidEventStatus(gov.georgia.dhr.dfcs.sacwis.structs.document.ValidEventStatus) 

    /**
     * Sets the value of field 'validationClass'.
     * 
     * @param validationClass the value of field 'validationClass'.
     */
    public void setValidationClass(java.lang.String validationClass)
    {
        this._validationClass = validationClass;
    } //-- void setValidationClass(java.lang.String) 

    /**
     * Sets the value of field 'validationParameters'.
     * 
     * @param validationParameters the value of field
     * 'validationParameters'.
     */
    public void setValidationParameters(java.lang.String validationParameters)
    {
        this._validationParameters = validationParameters;
    } //-- void setValidationParameters(java.lang.String) 

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
     * gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData
     */
    public static gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData) Unmarshaller.unmarshal(gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData.class, reader);
    } //-- gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData unmarshal(java.io.Reader) 

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
