-- STGAP00014746 - Add missing comments to database tables

COMMENT ON TABLE CAPS.ADDRESS_PERSON_LINK IS 'A table that links persons and addresses, since a person can have multiple addresses and many persons can live at an address.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.ID_ADDR_PERSON_LINK IS 'A unique integer which defines an Address Person Link.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.ID_PERSON_ADDR IS 'A unique integer which identifies a Person''s Address.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.CD_PERS_ADDR_LINK_TYPE IS 'Identifies the type of address listed for an individual known to IMPACT (i.e. school, day care, work, etc.)'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.IND_PERS_ADDR_LINK_INVALID IS 'A flag that identifies one of the addresses provided for an individual as an invalid address.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.IND_PERS_ADDR_LINK_PRIMARY IS 'Indicates if an  address listed is the primary address of the individual.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.TXT_PERS_ADDR_CMNTS IS 'Narrative directions or special instructions on the location of each individuals'' address.  For example, people who live in trailer parks or apartment buildings.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.DT_PERS_ADDR_LINK_START IS 'Date that the individual''s address became valid. This is often the date that the address was added.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.DT_PERS_ADDR_LINK_END IS 'Date that the individual''s address is no longer effective. This date is used to end-date an address.'
;
COMMENT ON COLUMN CAPS.ADDRESS_PERSON_LINK.IND_REMOVAL_HOME IS 'Indicator if this is the removal home if the person is a child in a foster care stage'
;
COMMENT ON TABLE CAPS.ADJUSTMENT_DETAIL IS 'Detail information for Adjustment Invoices.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.ID_ADJUSTMENT_DETAIL IS 'A unique identifier to the Adjustment detail table.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.AMT_ADJUST_DTL_AMT IS 'Contains the amount of a non-invoice specific adjustment.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.CD_ADJUST_DTL_INVO_DISPTN IS 'Used to hold a code indicating the status of a particular line item.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.CD_ADJUST_DTL_LI_TYPE IS 'Contains a system generated code indicating the type of line item entry (original, adjustment, or reversal).'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.DT_ADJUST_DTL_ADJUST_DATE IS 'This is the user specified date of adjustment.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.MO_ADJUST_DTL_SVC_MONTH IS 'This is the user specified service month for the adjustment.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.TXT_ADJUST_DTL_DESC IS 'This is the user specified description for the adjustment.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_DETAIL.YR_ADJUST_DTL_SVC_YEAR IS 'This is the user specified service year for the adjustment.'
;
COMMENT ON TABLE CAPS.ADJUSTMENT_REQUEST IS 'References changes in Placement, Level of Care, or Eligibility records. Used by the Prior Period Adjustments batch process.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.ID_ADJ_REQ IS 'This element is the primary key for the ADJUSTMENT_REQUEST table.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.ID_ADJ_REQ_EVENT IS 'This element is an identifier for the event that has been changed which is a candidate for a prior period adjustment. It could uniquely identify a change in the PLACEMENT, ELIGIBILITY, or PERSON LOC tables.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.ID_ADJ_REQ_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.DT_ADJ_REQ_START IS 'Contains the start date for the range of time affected by a change in PLACEMENT, ELIGIBILITY, or PERSON LOC.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.DT_ADJ_REQ_END IS 'Contains the end date for the range of time affected by a change in PLACEMENT, ELIGIBILITY, or PERSON LOC.'
;
COMMENT ON COLUMN CAPS.ADJUSTMENT_REQUEST.CD_ADJ_REQ_TYPE IS 'Code that indicates the type of adjustment request. This field is populated by triggers. These codes are located in the triggers of the corresponding decode''s table. For example, ''PLA'' is decoded as PLACEMENT. The PLACEMENT table has a trigger that inserts ''PLA'' into this field.'
;
COMMENT ON TABLE CAPS.ADMIN_ALLEGATION IS 'Stores a copy of the allegations related to the person being reviewed from the allegation table when the admin review stage is opened.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.ID_ADMIN_ALLEG_ALLEGATION IS 'A unique identifier for a row on the ADMIN ALLEGATION table.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.ID_ADMIN_ALLEG_STAGE IS 'A unique identifier for the stage table residing on the ADMIN ALLEGATION table.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.ID_ADMIN_ALLEG_AR_STAGE IS 'This is the Admin Review Stage ID.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.ID_ADMIN_ALLEG_VICTIM IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.IND_ADMIN_ALLEG_PRIOR IS 'Indicates whether or not an allegation is prior or current.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.ID_ADMIN_ALLEG_PERPETRATR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.CD_ADMIN_ALLEG_DISPOSTIION IS 'A code that identifies the validity of the allegation disposition determined at the end of the investigation.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.CD_ADMIN_ALLEG_INCDNT_STG IS 'A code that identifies the stage of service in which the allegation was identified. Could be any valid stage of service.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.CD_ADMIN_ALLEG_SEVERITY IS 'Identifies the severity of the allegation. Examples of this are founded, invalid, moderate, or unable to determine. This is on the history table for Allegation.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.CD_ADMIN_ALLEG_TYPE IS 'A code that identifies each type of abuse/neglect alleged.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.TXT_ADMIN_ALLEG_DURATION IS 'Short text to describe how long each allegation (triad) has been occurring.'
;
COMMENT ON COLUMN CAPS.ADMIN_ALLEGATION.CD_ADMIN_ALLEG_CLSS IS 'Contains a code indicating the classification of the allegation.'
;
COMMENT ON TABLE CAPS.ADMIN_DTL IS 'Stores detail information for payment line items for admin invoices.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.ID_ADMIN_DTL IS 'A unique identifier for a row on the ADMIN DTL table.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.ID_ADMIN_DTL_REVRSAL_ORIG IS 'Contains the ID of the original line item reversed by the current line item.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_ADMIN_ALLOC IS 'An amount paid to a provider based on the total expenditures reimbursed, allocated to administrative costs.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_EQUIPMENT IS 'The amount paid to a provider for equipment expenditures.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_FRG_BENFT IS 'The amount reimbursed to a provider for fringe benefit expenditures.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_OFFSET_ITEM IS 'The total amount paid by or for a client which offsets the total amount billed by a provider.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_OTHER IS 'The amount reimbursed to a provider for expenditures not covered in the other five categories.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_SALARIES IS 'The amount reimbursed to a provider for salary expenditures.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_SUPPLIES IS 'The amount reimbursed to a provider for supplies expenditures.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_TRAVEL IS 'The amount reimbursed to a provider for travel expenditures.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_ADMIN_DTL_SERVICE IS 'Contains the service code for the administrative detail line item.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_ADMIN_DTL_INVO_DISPTN IS 'Used to hold a code indicating the status of a particular line item.  A value of ''RV'' indicates the line has been reversed by another line.  A value of null indicates the line stands as is.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_ADMIN_DTL_LI_TYPE IS 'Contains a system generated code indicating the type of line item entry (original, adjustment, or reversal).'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_ADMIN_DTL_PAC IS 'Contains the PAC code for a particular service code.  Please reference the department''s Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_ADMIN_DTL_OBJ_CODE IS 'Contains the Object Code for the line item. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.IND_ADMIN_DTL_REJ_ITM IS 'This element indicates whether or not a line item is rejected.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.MO_ADMIN_DTL_SVC_MONTH IS 'This field indicates the month that a particular service was delivered.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.NBR_ADMIN_DTL_CSLI IS 'Contains the contract services line item number for the administrative detail record.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.YR_ADMIN_DTL_SVC_YEAR IS 'Contains the service year for a particular invoice/line item.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.NBR_CNTRCT_PRD IS 'Contains a number identifying the period for a specific contract.  Each period covers a specific time frame.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_OBJCT_CERTIFIED IS 'Contains the certified funds object code for the Line Item. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_OBJCT_PURE IS 'Contains the pure state dollars object code for the Line Item. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.NBR_OBJCT_ALLOWABLE IS 'A percentage (or factor) that indicates the share of the expense that can be matched with federal funds, or, in the case of JPC and TYC, the federal share.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.NBR_OBJCT_CERTIFIED IS 'A percentage (or factor) applied against the line amount to determine the state share of the expense.  The public agency to whom payment is made "certifies" that funds are available in their budget. Used for TYC and JPC invoices only.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.NBR_OBJCT_PURE IS 'A percentage (or factor) associated with pure state dollars.  When the percentage is applied against the line amount, the result represents the amount of state dollars that cannot be matched with federal dollars.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.CD_ON_CALL_COUNTY IS 'County to which administrative detail belongs'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.TXT_COMMENTS IS 'Comments'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_ADMIN_DTL_PROMOTIONAL IS 'Promotional Amount'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.AMT_SMILE_PAID IS 'Amount paid via the SMILE accounting system for this line item.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.NBR_CHECK IS 'Check number issued by SMILE to pay this line item.'
;
COMMENT ON COLUMN CAPS.ADMIN_DTL.DT_PAID IS 'Date that payment for this line item was made - comes from the SMILE interface.'
;
COMMENT ON TABLE CAPS.ADMIN_REVIEW IS 'Stores the admin review information related to the stage and case. Contains the history of the allegation prior to any changes made in the admin review stage.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.ID_STAGE_RELATED IS 'A unique integer which identifies a Stage of Service related to an Admin Review stage.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.ID_PERSON_REQUESTOR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.CD_ADMIN_RV_APPEAL_RESULT IS 'The decision from the appeal of a F/A home.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.CD_ADMIN_RV_APPEAL_TYPE IS 'The type of appeal that is being recorded.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.CD_ADMIN_RV_AUTH IS 'Contains the authority that conducts the review and makes a determination.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.CD_ADMIN_RV_STATUS IS 'The status of the admin review.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_ADMIN_RV_APPEAL_NOTIF IS 'The date DFCS notified the F/A parent of the appeal hearing'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_ADMIN_RV_APPEAL_REVIEW IS 'The date of the review to appeal the decision to close a F/A home'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_ADMIN_RV_DUE IS 'The date the review is due'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_ADMIN_RV_EMGCY_REL IS 'The date of emergency release of data in an Administrative Review case.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_ADMIN_RV_HEARING IS 'The date the Release Hearing was held or is going to be held.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_ADMIN_RV_REQ_APPEAL IS 'The date that the request for a review or appeal was received.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.IND_ADMIN_RV_EMGCY_REL IS 'This is an indicator that when checked, indicates that findings have been released in an emergency.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.CD_ADMIN_RV_REQ_BY IS 'Code used to describe the type of person requested the Administrative Review. (i.e. RPT-Reporter, DPP-Designated Perp, etc)'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.NM_ADMIN_RV_REQ_BY IS 'The name of the requester of the Administrative Review.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.DT_DETERMINATION_LTR IS 'Date of the Letter of Determination.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.IND_SAAG_NOTIFICATION IS 'Indicator if the SAAG (Special Assistant Attorney General) was notified.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.IND_LGL_REPRESENTATION IS 'Indicator if there was legal representation.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.TXT_APPEAL_RESULT IS 'Text for describing the result of the appeal.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW.TXT_RSN_APPRV_DENY IS 'Text for reason for approval or denial.'
;
COMMENT ON TABLE CAPS.ADMIN_REVIEW_NARR IS 'A narrative of the Administrative Review.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing an Administrative Review.'
;
COMMENT ON COLUMN CAPS.ADMIN_REVIEW_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.ADO_ASST_AGREEMENT_NARR.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.ADO_ASST_MEM_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.ADO_INFO IS 'Holds data from the Adoption Information Page'
;
COMMENT ON COLUMN CAPS.ADO_INFO.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.ADO_INFO.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table that identifies the actual adoptive resource.'
;
COMMENT ON COLUMN CAPS.ADO_INFO.CD_CHLD_AVAIL IS 'Reason For Child''s Non-Availability'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_INT_TPR IS 'Foster Parents Notified of Agency Intent to TPR'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_PERM_STAFF IS 'Permanency Staffing with Foster Parents'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_DEC_ADOPT IS 'Foster Parents Notified Agency of Decision to Adopt'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_LIFE_HIS_PRES IS 'Child Life History Presentation'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_ADO_STAFF IS 'Staffing wit h Adoptive Family'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_ADO_AGREE IS 'Adoptive Placement Agreement Signed'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_REL_ADO IS 'Child Released for Adoption from DFCS'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_PERM_FILE IS 'Permission to file letter completed'
;
COMMENT ON COLUMN CAPS.ADO_INFO.DT_DOC_SENT IS 'Documents Sent to Attorney'
;
COMMENT ON COLUMN CAPS.ADO_INFO.IND_OTH_SIB IS 'Other Siblings Adopted'
;
COMMENT ON COLUMN CAPS.ADO_INFO.NBR_FAM_CONS IS 'Number of Families Considered'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_NOT_SEL IS 'Reasons Families were not selected for adoption'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_TYP_ADO IS 'Type of Adoptive Resource Needed'
;
COMMENT ON COLUMN CAPS.ADO_INFO.IND_IDEN_ADO IS 'Child has identified adoptive resource'
;
COMMENT ON COLUMN CAPS.ADO_INFO.CD_RSRC_CNTY IS 'County Code'
;
COMMENT ON COLUMN CAPS.ADO_INFO.NM_PRIV_AGENCY IS 'Private Agency Name'
;
COMMENT ON COLUMN CAPS.ADO_INFO.CD_STATE IS 'ICPC State'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_RECR_BARR IS 'Barriers to Recruitment'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_PLCMNT_BARR IS 'Barriers to Placement'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_TPR_BARR IS 'Barriers to Termination of Parental Rights'
;
COMMENT ON COLUMN CAPS.ADO_INFO.IND_INQRY IS 'Out of town inquery'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_PREP_CMNTS IS 'Captures comments on preparation activities'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_STATE_ACT IS 'Captures comments on state recruitment activities.'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_CNTY_ACT IS 'Captures comments on county recruitment activities.'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_CONS_COMMENTS IS 'Field will be used to specify families that may have been considered by county for adopting child.'
;
COMMENT ON COLUMN CAPS.ADO_INFO.IND_FP_ADO IS 'Yes or No Value to indicate if the foster parents intend to adopt the child.'
;
COMMENT ON COLUMN CAPS.ADO_INFO.TXT_COUNTY_CONS_COMMENT IS 'Field will be used by county to specified families that have been considered for adoption.'
;
COMMENT ON COLUMN CAPS.ADO_INFO.ID_EVENT_CHILD_REGISTRATION IS 'A unique identifier to the EVENT table.'
;
COMMENT ON TABLE CAPS.ADO_INFO_CBX IS 'Holds Checkbox information for Adoption Information Page'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX.ID_INFO_CHAR IS 'Adoption Information Checkboxes ID'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX.CD_ADO_INFO_CBX IS 'Adoption Information Checkbox Code'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX.CD_CBX_CODE_TYPE IS 'Holds the code type for corresponding check box code.'
;
COMMENT ON TABLE CAPS.ADO_INFO_CBX_SENT IS 'Keeps track of each time adoption info is sent'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX_SENT.ID_ADO_INFO_CBX_SENT IS 'Artificial primary key for this table'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX_SENT.ID_INFO_CHAR IS 'Adoption Information Checkboxes ID Foreign Key to ADO_INFO_CBX'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX_SENT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.ADO_INFO_CBX_SENT.DT_ADO_INFO_CBX_SENT IS 'Date that information for this ADO INFO Checkbox was sent'
;
COMMENT ON TABLE CAPS.ADO_INFO_FAMILY IS 'Holds the adoptive family study resources'
;
COMMENT ON COLUMN CAPS.ADO_INFO_FAMILY.ID_INFO_FAMILY IS 'Adoption Information Family ID'
;
COMMENT ON COLUMN CAPS.ADO_INFO_FAMILY.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.ADO_INFO_FAMILY.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ADO_INFO_FAMILY.ID_RESOURCE IS 'Resource ID of potential adoptive resource'
;
COMMENT ON COLUMN CAPS.ADO_NEW_NAME.ID_ADO_STAGE IS 'The stage Id of the adoption stage that is being closed with the reason Adoption finalized'
;
COMMENT ON COLUMN CAPS.ADO_NEW_NAME.NM_PERSON_LAST IS 'The new last name for the child entered on the stage closure page'
;
COMMENT ON COLUMN CAPS.ADO_NEW_NAME.NM_PERSON_FIRST IS 'The new first name for the child entered on the stage closure page'
;
COMMENT ON COLUMN CAPS.ADO_NEW_NAME.NM_PERSON_MIDDLE IS 'The new middle name for the child entered on the stage closure page'
;
COMMENT ON COLUMN CAPS.ADO_SIBLING_HISTORY.ID_ADO_INFO_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ADO_SIBLING_HISTORY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ADO_SUBSIDY_RATE.ID_ADO_SUBSIDY_RATE IS 'Primary key of table'
;
COMMENT ON COLUMN CAPS.ADO_SUBSIDY_RATE.CD_RATE_TYPE IS 'The type of rate'
;
COMMENT ON COLUMN CAPS.ADO_SUBSIDY_RATE.NUM_MIN_AGE IS 'minum age'
;
COMMENT ON COLUMN CAPS.ADO_SUBSIDY_RATE.NUM_MAX_AGE IS 'maximum age'
;
COMMENT ON COLUMN CAPS.ADO_SUBSIDY_RATE.AMT_ADPT_SUB IS 'Amount of Subsidy'
;
COMMENT ON TABLE CAPS.ADOPTION_SUBSIDY IS 'Assessment of child''s entitlement to receive Medicaid and cash assistance after adoption.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.ID_ADPT_SUB IS 'Unique identifier of a row on the ADOPTION SUBSIDY table.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.ID_ADPT_SUB_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.ID_ADPT_SUB_PAYEE IS 'Unique identifier to the CAPS RESOURCE table for the family receiving the subsidy.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.ID_PLCMT_EVENT IS 'A unique identifier to the event table used on Placement.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.AMT_ADPT_SUB IS 'The amount approved for the adoption subsidy.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.CD_ADPT_SUB_CLOSE_RSN IS 'The reason the adoption subsidy was closed or denied.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.CD_ADPT_SUB_DETERM IS 'The determination of the type of adoption subsidy eligibility the home may receive.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_AGREE_RETN IS 'The date the adoption subsidy agreement was returned by the home signed'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_AGREE_SENT IS 'The date the adoption subsidy agreement was sent to the family.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_APP_RETURNED IS 'The date the adoption subsidy was returned by the home.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_APP_SENT IS 'The date the adoption subsidy application is sent to the home.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_APPRVD IS 'Date the adoption subsidy was approved.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_EFFECTIVE IS 'The effective date of the adoption subsidy.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_END IS 'The end date of the adoption subsidy.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_LAST_INVC IS 'The date of the last invoice for the adoption subsidy.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.IND_ADPT_SUB_THIRD_PARTY IS 'Indicates whether the home has third party insurance.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.IND_ADPT_SUB_PROCESS IS 'This is an indicator of whether the Adoption Subsidy has been previously processed for closure in case the end date is backdated.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.TXT_ADPT_SUB_RSN IS 'The reason the home needs the adoption subsidy.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.IND_SAU_CONF IS 'Indicator for if SAU memo confirms eligibility for adoption assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.IND_SPCL_ASST_APPRVL IS 'Indicator if the special service assistance was approved or denied'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.AMT_SPCL_ASST_REQ IS 'Requested amount of money for special service assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.CD_SPCL_ASST_TYPE IS 'Special service assistance type'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.TXT_SPCL_ASST_SPECIFY IS 'Specifc information about special service assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.TXT_SPCL_ASST_CMNTS IS 'Comments about special service assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_RENWL_EFF_BEGIN IS 'Effective begin date of the renewal'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_RENWL_EFF_END IS 'Effective end date of the renewal'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.DT_ADPT_SUB_TERMINATED IS 'Actual end date could differ from the DT_ADPT_SUB_END.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.CD_PAYMENT_MTHD IS 'Indicates if payments are to be made directly to the Service Provider or to the adoptive parent.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.IND_DOC_SSI IS 'Indicator if SSI documentation exists.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.TXT_ICAMA_COMMENTS IS 'Inter-state comments'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY.IND_SCHOOL_VER IS 'Checkbox to hold if school enrollment was verified.'
;
COMMENT ON TABLE CAPS.ADOPTION_SUBSIDY_AUDIT IS 'This table contains audit records of the ADOPTION SUBSIDY table and duplicates all elements in that table.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.ID_ADPT_SUB_AUD IS 'Primary Key for the adoption_subusidy_audit table.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.ID_ADPT_AUD_PERSON IS 'Unique identifier to the PERSON table for the person for whom the adoption subsidy is made.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.ID_ADPT_AUD_PAYEE IS 'Unique identifier to the CAPS RESOURCE table for the family receiving the subsidy.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.ID_PLCMT_EVENT IS 'A unique identifier to the event table used on Placement.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.AMT_ADPT_AUD IS 'The amount of the adoption subsidy (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.CD_ADPT_AUD_CLOSE_RSN IS 'The reason the adoption subsidy was closed or denied (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.CD_ADPT_AUD_DETERM IS 'The determination of the type of adoption subsidy eligibility the home may receive (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_AGREE_RETN IS 'The date the adoption subsidy agreement was returned by the home signed (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_AGREE_SENT IS 'The date the adoption subsidy agreement was sent to the family (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_APP_RETURNED IS 'The date the adoption subsidy was returned by the home (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_APP_SENT IS 'The date the adoption subsidy application is sent to the home (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_APPRVD IS 'The date the adoption subsidy was approved (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_EFFECTIVE IS 'The effective date of the adoption subsidy (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_END IS 'The end date of the adoption subsidy (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_ADPT_AUD_LAST_INVC IS 'The date of the last invoice for the adoption subsidy (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.IND_ADPT_AUD_THIRD_PARTY IS 'Indicates whether the home has third party insurance (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.IND_ADPT_AUD_PROCESS IS 'This is an indicator of whether the Adoption Subsidy has been previously processed for closure in case the end date is backdated.'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.TXT_ADPT_AUD_RSN IS 'The reason the home needs the adoption subsidy (on Audit table).'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.IND_SAU_CONF IS 'Indicator for if SAU memo confirms eligibility for adoption assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.IND_SPCL_ASST_APPRVL IS 'Indicator if the special service assistance was approved or denied'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.AMT_SPCL_ASST_REQ IS 'Requested amount of money for special service assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.CD_SPCL_ASST_TYPE IS 'Special service assistance type'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.TXT_SPCL_ASST_SPECIFY IS 'Specifc information about special service assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.TXT_SPCL_ASST_CMNTS IS 'Comments about special service assistance'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_RENWL_EFF_BEGIN IS 'Effective begin date of the renewal'
;
COMMENT ON COLUMN CAPS.ADOPTION_SUBSIDY_AUDIT.DT_RENWL_EFF_END IS 'Effective end date of the renewal'
;
COMMENT ON TABLE CAPS.ADPT_SUB_EVENT_LINK IS 'This table links the Adoption Subsidy table to the Event table.  (FK ADPT SUB CASE is not a true foreign key constraint.)'
;
COMMENT ON COLUMN CAPS.ADPT_SUB_EVENT_LINK.ID_ADPT_SUB_EVENT_LINK IS 'Unique key to the Adoption Subsidy table. Is generated by the system.'
;
COMMENT ON COLUMN CAPS.ADPT_SUB_EVENT_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ADPT_SUB_EVENT_LINK.ID_ADPT_SUB IS 'Unique identifier of a row on the ADOPTION SUBSIDY table.'
;
COMMENT ON COLUMN CAPS.ADPT_SUB_EVENT_LINK.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ADPT_SUB_EVENT_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.AFCARS IS 'To support state reporting, this request creates the AFCARS table.  Each month, data will be reloaded in this table following a new run of the AFCARS Batch Extract to store the information from the flat file produced.  Together with the AFCARS_VIEW, the AFCARS table will satisfy multiple state office reporting requirements'
;
COMMENT ON COLUMN CAPS.AFCARS.DT_LAST_UPDATE IS 'Indicates the date when the record was last updated'
;
COMMENT ON TABLE CAPS.AFCARS_HISTORY IS 'Table used to house additional data used by AFCARS reporting.'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.ID_PERSON IS 'Person ID from SHINES'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.ID_AFCARS IS 'AFCARS person ID that this history is associated to'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_IDS_UPDATE IS 'Date the case was last updated in IDS'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_CONVERSION IS 'Date of Conversion release - Black out date from IDS'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.CD_AGE_PREV_ADOPT IS 'code of age range of child when they were adopted'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_FIRST_REMOVAL IS 'first removal date'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.NBR_REMOVALS IS 'number of removals of this child'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_DISCHARGE IS 'last foster care discharge date'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_RECENT_REMOVAL_TRANS IS 'date of transaction of most recent removal (when it was entered)'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.NBR_PLACEMENTS_THIS_EPISODE IS 'number of placements child has had in this episode'
;
COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_RECENT_DISCHARGE_TRANS IS 'Transaction date of the most recent foster care discharge'
;
COMMENT ON TABLE CAPS.ALLEG_EVIDENCE IS 'Contains a list of evidence that supports or is otherwise associated with an allegation.'
;
COMMENT ON COLUMN CAPS.ALLEG_EVIDENCE.ID_ALLEG_EVIDENCE IS 'Unqiue identifier for an evidence record for an allegation.'
;
COMMENT ON COLUMN CAPS.ALLEG_EVIDENCE.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  It identifies the allegation that this record contains evidence for.'
;
COMMENT ON COLUMN CAPS.ALLEG_EVIDENCE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.ALLEG_EVIDENCE.CD_EVIDENCE_CODE IS 'Code for the type of evidence for the allegation.'
;
COMMENT ON TABLE CAPS.ALLEGATION IS 'The link of a victim to a perpetrator for an occurrence of Abuse, Neglect, or Exploitation. Allegations are recorded at intake on the INTAKE_ALLEGATION table and are referenced on the ALLEGATION table using Cd_Alleg_Incident_Stage. Additional allegations can be discovered during the investigation and would be stored on the ALLEGATION table. The dispositions of all allegations are assigned in investigation.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  On the FACIL_ALLEG_PRIOR_REVIEW table, it is the ID_ALLEGATION before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.ID_ALLEGATION_STAGE IS 'A unique identifier for the stage table residing on the Allegation table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.ID_VICTIM IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.ID_ALLEGED_PERPETRATOR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.CD_ALLEG_INCIDENT_STAGE IS 'A code that identifies the stage of service in which the allegation was identified. Could be any valid stage of service.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.TXT_ALLEG_DURATION IS 'Short text to describe how long each allegation (triad) has been occurring.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.CD_ALLEG_TYPE IS 'A code that identifies each type of abuse/neglect alleged.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.CD_ALLEG_DISPOSITION IS 'A code that identifies the validity of the allegation disposition that was determined at the end of the investigation.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.CD_ALLEG_SEVERITY IS 'Identifies the severity of the allegation.  Examples of this are founded, invalid, moderate, or unable to determine.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.IND_ALLEG_CANCEL_HIST IS 'An indicator that determines whether an automatic update to the allegation history table is overridden.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.TXT_EVIDENCE_SUMMARY IS 'Text Summary of the evidence for this allegation.'
;
COMMENT ON COLUMN CAPS.ALLEGATION.IND_CRIM_CHRGS_FILED IS 'Indicator if criminal charges were filed'
;
COMMENT ON COLUMN CAPS.ALLEGATION.CD_ALLEGED_MAL_LOCATION IS 'Location of maltreatment'
;
COMMENT ON COLUMN CAPS.ALLEGATION.DT_ALLEGED_INCIDENT IS 'Date of alleged incident'
;
COMMENT ON COLUMN CAPS.ALLEGATION.CD_MALTREATOR_REL IS 'Relationship of the maltreater to the victim.'
;
COMMENT ON TABLE CAPS.ALLEGATION_HISTORY IS 'Historical record of Allegations. See ALLEGATION entity.  FK ID ALLEGATION STAGE is not a true foreign key constraint.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.ID_ALLEG_HISTORY IS 'A unique identifier for a row on the Allegation History table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  On the FACIL_ALLEG_PRIOR_REVIEW table, it is the ID_ALLEGATION before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.ID_ALLEGATION_STAGE IS 'A unique identifier for the stage table residing on the Allegation table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.ID_VICTIM IS 'A unique integer that defines a specific person, in this case a victim. This was added to allow multiple person ids on the same table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.ID_ALLEGED_PERPETRATOR IS 'A unique integer that defines a specific person, in this case an alleged perpetrator. This was needed to be able to handle the storage of multiple person ids on the same table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.CD_ALLEG_HIST_INCDNT_STG IS 'A code that identifies the stage of service in which the allegation was identified. Could be any valid stage of service.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.TXT_ALLEG_HIST_DURATION IS 'Short text to describe how long each allegation (triad) has been occurring. This field is on the Allegation History table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.CD_ALLEG_HIST_TYPE IS 'A code that identifies each type of abuse/neglect alleged. This field is on the Allegation History table.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.CD_ALLEG_HIST_DISPOSITION IS 'A code that identifies the validity of the allegation disposition that was determined at the end of the investigation. This is the history table for Allegation.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.CD_ALLEG_HIST_SEVERITY IS 'Identifies the severity of the allegation.  Examples of this are founded, invalid, moderate, or unable to determine. This is on the history table for Allegation.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.DT_ALLEG_HIST_EFFECTIVE IS 'Date the Allegation History record is effective.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.DT_ALLEG_HIST_END IS 'Date the Allegation History record ends.'
;
COMMENT ON COLUMN CAPS.ALLEGATION_HISTORY.CD_MALTREATOR_REL IS 'Relationship of maltreater to the victim.'
;
COMMENT ON TABLE CAPS.ALOC IS 'ALOC is a holding table used to track the status of expiring Authorized Level of Care for the ALOC interface.  It is meant to keep track of all Utilization Review records that are scheduled by DFCS and procesed by The Third Party Reviewer.  Currently each record is updated with a status of 98 once it is processed.'
;
COMMENT ON COLUMN CAPS.ALOC.ID_ALOC IS 'Contains a unique identifier for a row on the ALOC table.'
;
COMMENT ON COLUMN CAPS.ALOC.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ALOC.ID_ALOC_RESOURCE IS 'Unique ID RESOURCE of the resource with which the child is placed.'
;
COMMENT ON COLUMN CAPS.ALOC.ID_ALOC_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ALOC.ID_ALOC_EVENT IS 'Id_ploc_event from the person_loc table.'
;
COMMENT ON COLUMN CAPS.ALOC.NBR_ALOC_TDHS_CLNT IS 'Contains the valid TDHS Client # from person_id table.'
;
COMMENT ON COLUMN CAPS.ALOC.NM_ALOC_PERSON_FIRST IS 'Contains the first name of the ALOC person.'
;
COMMENT ON COLUMN CAPS.ALOC.NM_ALOC_PERSON_MIDDLE IS 'Contains the middle name of the ALOC person.'
;
COMMENT ON COLUMN CAPS.ALOC.NM_ALOC_PERSON_LAST IS 'Contains the last name of the ALOC person.'
;
COMMENT ON COLUMN CAPS.ALOC.DT_ALOC_PERSON_BIRTH IS 'Contains a date indicating the date of birth of the ALOC person.'
;
COMMENT ON COLUMN CAPS.ALOC.CD_ALOC_PERSON_SEX IS 'Code representing the ALOC person''s sex. (cd_person_sex)'
;
COMMENT ON COLUMN CAPS.ALOC.CD_ALOC_CURR_ALOC IS 'Code representing the Authorized level of care for the ALOC person from the person_loc table. (cd_ploc_child)'
;
COMMENT ON COLUMN CAPS.ALOC.DT_ALOC_CURR_START IS 'Contains a date representing the start date of the Authorized Level of Care for the ALOC person from the person_loc table.'
;
COMMENT ON COLUMN CAPS.ALOC.DT_ALOC_CURR_END IS 'Contains a date representing the end date of the Authorized Level of Care for the ALOC person from the person_loc table.'
;
COMMENT ON COLUMN CAPS.ALOC.CD_ALOC_CURR_BLOC IS 'Code representing the Billing Level of Care for the ALOC person from the person_loc table.  (cd_ploc_child)'
;
COMMENT ON COLUMN CAPS.ALOC.CD_ALOC_LEGAL_COUNTY IS 'Contains the code of the county of legal action for the ALOC person from the legal_status table. (cd_legal_stat_cnty)'
;
COMMENT ON COLUMN CAPS.ALOC.CD_ALOC_STATUS IS 'Contains a code for the ALOC status of a person.
01=non-cpa scheduled
02=cpa scheduled
03=non-cpa not scheduled
04=cpa not scheduled
05=not processed, resend
06=fahome
98=processed
99=hold for processing'
;
COMMENT ON COLUMN CAPS.ALOC.IND_ALOC_RESEND IS 'Contains the Resend indicator.  The initial value = N.  It is set to Y if a record is re-sent in the interface.'
;
COMMENT ON TABLE CAPS.ALOC_ERROR IS 'Errors or exceptions occuring during the processing of the Third Party Reviews.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.ID_ALOC_ERROR IS 'Unique identifier and primary key for a row in the ALOC_ERROR table.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.NM_PERSON_FIRST IS 'First name of individual.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.NM_PERSON_LAST IS 'Last name of an individual.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.CD_ALOC IS 'Last authorized level of care which does not have same start/end dates.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.DT_ALOC_START IS 'This is the date the last authorized level of care (which does not have same start/end dates) started.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.DT_ALOC_END IS 'This is the date the last authorized level (which does not have same start/end dates) of care ended.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.DT_ALOC_PROC IS 'Date the authorized level of care was processed.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.CD_COUNTY IS 'Three digit, numeric county code for each individual involved in the case.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.NBR_MESSAGE IS 'The reference number of the message generated by the services; this matches the IMPACT message number.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.TXT_ERROR IS 'The text of the error.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.IND_MARKED_DELETION IS 'Indicates that the row should be deleted at the end of the month.'
;
COMMENT ON COLUMN CAPS.ALOC_ERROR.CD_REV_TYPE IS 'Type of revision of authorized level of care.'
;
COMMENT ON TABLE CAPS.ALOC_SCHEDULE IS 'ALOC_SCHEDULE is used by the ALOC interface to determine whether or not a person with an expiring ALOC is placed in a resource that is scheduled for review.  The data is refreshed from 3rd party provider data once a month via the ALOC interface.'
;
COMMENT ON COLUMN CAPS.ALOC_SCHEDULE.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.  This is the unique ID RESOURCE of the resource scheduled for review.'
;
COMMENT ON COLUMN CAPS.ALOC_SCHEDULE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ALOC_SCHEDULE.DT_ALOC_SCHEDULED IS 'Contains the date the resource is scheduled for review.'
;
COMMENT ON TABLE CAPS.APPROVAL IS 'Tracks Supervisor Approvals for DFCS Tasks. Each task in a stage of service may be approved more than once, by more than one person.'
;
COMMENT ON COLUMN CAPS.APPROVAL.ID_APPROVAL IS 'Unique identifier of the Approval table. To get the approval information for a particular event, link its id_event to the Approval_Event_Link.id_approval_event. Then, use the Id_Approval to link back to the Event table to get the date and status of the approval.'
;
COMMENT ON COLUMN CAPS.APPROVAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.APPROVAL.ID_APPROVAL_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.APPROVAL.TXT_APPROVAL_TOPIC IS 'Name of the approval task off of the process task list. The approval task covers the review of one or multiple tasks.'
;
COMMENT ON COLUMN CAPS.APPROVAL.DT_APPROVAL_DATE IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON TABLE CAPS.APPROVAL_EVENT_LINK IS 'Links multiple approvals to multiple events. Allows the approval of multiple events at one time.'
;
COMMENT ON COLUMN CAPS.APPROVAL_EVENT_LINK.ID_APPROVAL_EVENT IS 'A unique identifier to the Approval Event Link entity.'
;
COMMENT ON COLUMN CAPS.APPROVAL_EVENT_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.APPROVAL_EVENT_LINK.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.APPROVAL_EVENT_LINK.ID_APPROVAL IS 'Unique identifier of the Approval table. To get the approval information for a particular event, link its id_event to the Approval_Event_Link.id_approval_event. Then, use the Id_Approval to link back to the Event table to get the date and status of the approval.'
;
COMMENT ON COLUMN CAPS.APPROVAL_EVENT_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.APPROVAL_REJECTION IS 'Rejection log for approvals throughout the system.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.ID_APPROVAL_REJECTION IS 'Unique ID for the Approval/Rejection record.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.ID_CASE IS 'ID of the Case associated with this approval/rejection'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.DT_LAST_UPDATE IS 'Date of insert or last update to this record.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.ID_STAGE IS 'Identifier of the stage associated with this approval/rejection'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.ID_REJECTOR IS 'person Id of who rejected it.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.DT_REJECTION IS 'Date of rejection.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_APS_EFFORT IS 'Indicator for if APS made efforts.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_PROBLEMS IS 'indicator if there are still problems.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_EVIDENCE IS 'indicator if there is evidence.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_MISSING_EVID_RPTR IS 'indicator if the reporter evidence is missing.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_MISSING_EVID_AP IS 'indicator if the alleged perp evidence is missing.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_MISSING_EVID_MP IS 'indicator if the medical evidence is missing.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_MISSING_EVID_COL IS 'indicator if the collateral evidence is missing.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_MISSING_EVID_PHOTOS IS 'indicator if photo evidence is missing.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_MISSING_EVID_DE IS 'indicator if documentary evidence is missing.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_MISSING_EVID_OTH IS 'indicator if other information is missing.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.IND_DISCRETIONARY IS 'indicator if rejection was discretionary.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.TXT_APPROVERS_CMNTS IS 'Comments about rejection.'
;
COMMENT ON COLUMN CAPS.APPROVAL_REJECTION.ID_APPROVAL IS 'Unique identifier of the Approval table. To get the approval information for a particular event, link its id_event to the Approval_Event_Link.id_approval_event. Then, use the Id_Approval to link back to the Event table to get the date and status of the approval.'
;
COMMENT ON TABLE CAPS.APPROVERS IS 'Contains the dates associated with a requested approval including the date of the request, date of the determination, status of the approval, and Id_person of the individual who made the approval.'
;
COMMENT ON COLUMN CAPS.APPROVERS.ID_APPROVERS IS 'A unique identifier for a row on the APPROVER table.'
;
COMMENT ON COLUMN CAPS.APPROVERS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.APPROVERS.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.APPROVERS.ID_APPROVAL IS 'Unique identifier of the Approval table. To get the approval information for a particular event, link its id_event to the Approval_Event_Link.id_approval_event. Then, use the Id_Approval to link back to the Event table to get the date and status of the approval.'
;
COMMENT ON COLUMN CAPS.APPROVERS.ID_TODO IS 'A unique identifier for a row on the To Do table.'
;
COMMENT ON COLUMN CAPS.APPROVERS.CD_APPROVERS_STATUS IS 'Indicates status of an approval request for a completed task. The status would be Approved or Rejected. It may also be Pending or Invalid which indicates the approver has not taken any approval action.'
;
COMMENT ON COLUMN CAPS.APPROVERS.DT_APPROVERS_DETERMINATION IS 'Date of approvers'' determinations.'
;
COMMENT ON COLUMN CAPS.APPROVERS.DT_APPROVERS_REQUESTED IS 'Date approver''s approval was requested.'
;
COMMENT ON COLUMN CAPS.APPROVERS.IND_APPROVERS_HISTORICAL IS 'Indicator marking an assigned approval request as historical where no action may be associated.  Information related to a historical approval request is for information only.'
;
COMMENT ON COLUMN CAPS.APPROVERS.TXT_APPROVERS_CMNTS IS 'Comments on the approval window as to why approval was or was not given for the unit of work submitted.'
;
COMMENT ON TABLE CAPS.ATTENDEES IS 'Attendess at a legal event, typically a court hearing or meeting in Judges chambers.'
;
COMMENT ON COLUMN CAPS.ATTENDEES.ID_LEGAL_ACT_EVENT IS 'A unique identifier to the EVENT table - what event this this was an attendee for.'
;
COMMENT ON COLUMN CAPS.ATTENDEES.ID_ATTD_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ATTENDEES.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.ATTENDEES.CD_ATTD_TYPE IS 'The type of attendee.'
;
COMMENT ON COLUMN CAPS.ATTENDEES.CD_ATTD_ROLE IS 'The role the attendee played at the hearing/event.'
;
COMMENT ON COLUMN CAPS.ATTENDEES.CD_ATTD_RELATION IS 'Relationship of the attendee to the person for whom the event/hearing was held.'
;
COMMENT ON TABLE CAPS.BATCH_CODES_TABLES IS 'Contains a one to one definition of the code and its translation, similar to the CODES_TABLES table.  However, this set of codes and decodes is only used for batch processing; not on-line pages.'
;
COMMENT ON COLUMN CAPS.BATCH_CODES_TABLES.BATCH_CODE_TYPE IS 'A series of eight letters used to describe a group of related codes.'
;
COMMENT ON COLUMN CAPS.BATCH_CODES_TABLES.BATCH_CODE IS 'A series of one or more numbers and/or letters that is used to represent a word or group of words. This value may be stored in the system in a specific CD data element, but may also be used only in batch processing as a translation mechanism.'
;
COMMENT ON COLUMN CAPS.BATCH_CODES_TABLES.BATCH_DECODE IS 'The word or groups of words that is represented by a code.'
;
COMMENT ON COLUMN CAPS.BATCH_CODES_TABLES.DT_CD_DCD_EFFECTIVE IS 'The date a row becomes effective.  Depending on the code type, code and decode, the effective date may be related to the current date, or it may be related to a service date.'
;
COMMENT ON COLUMN CAPS.BATCH_CODES_TABLES.DT_CD_DCD_END IS 'The last date a row is used.  Depending on the code type, code and decode, the date may be related to the current date, or it may be related to a service date.'
;
COMMENT ON TABLE CAPS.BATCH_PARAMETERS IS 'Table that stores dynamic parameters for batch processes.'
;
COMMENT ON COLUMN CAPS.BATCH_PARAMETERS.NM_BATCH_PROGRAM IS 'Contains the name of the batch program.'
;
COMMENT ON COLUMN CAPS.BATCH_PARAMETERS.NM_BATCH_PARAMETER IS 'Used by the batch programs to store the batch parameters for the batch runs.'
;
COMMENT ON COLUMN CAPS.BATCH_PARAMETERS.DT_PARAM_EFFECTIVE IS 'The date at which a particular batch program parameter is valid.'
;
COMMENT ON COLUMN CAPS.BATCH_PARAMETERS.DT_PARAM_EXPIRED IS 'The date at which a particular batch program parameter is expired or no longer valid.'
;
COMMENT ON COLUMN CAPS.BATCH_PARAMETERS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.BATCH_PARAMETERS.TXT_PARAMETER_VALUE IS 'Used by the batch programs to store the text of the parameter for a batch program.'
;
COMMENT ON TABLE CAPS.BATCH_SERVICE_LOCKS IS 'Contains information about what services are currently locked by batch processes.  This information is used by impact to determine whether or not services can be accessed.'
;
COMMENT ON COLUMN CAPS.BATCH_SERVICE_LOCKS.NM_BATCH_SCRIPT IS 'Name of the batch script that is locking the service.'
;
COMMENT ON COLUMN CAPS.BATCH_SERVICE_LOCKS.NM_SERVICE_NAME IS 'Name of the service that is locked.'
;
COMMENT ON COLUMN CAPS.BATCH_SERVICE_LOCKS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.BATCH_SERVICE_LOCKS.IND_SERVICE_LOCKED IS 'Indicates whether or not this lock is currently active.'
;
COMMENT ON TABLE CAPS.BATCH_TABLE_LOCK IS 'Contains the information regarding batch scripts and the tables which they lock while in progress.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.NM_BATCH_SCRIPT IS 'Name of the batch script that is locking the service.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.NM_TABLE_NAME IS 'Used by the batch processes, this element stores the name of the TABLE which is locked while the batch program is in progress.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.IND_TABLE_DELETE IS 'Indicator used to determine if the DELETE rights should be revoked when tables are locked by the batch processes.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.IND_TABLE_INSERT IS 'Indicator used to determine if the INSERT rights should be revoked when tables are locked by the batch processes.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.IND_TABLE_LOCKED IS 'Indicator used by the Batch programs to indicate that a particular TABLE should be locked during a certain batch run.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.IND_TABLE_SELECT IS 'Indicator used to determine if the SELECT rights should be revoked when tables are locked by the batch processes.'
;
COMMENT ON COLUMN CAPS.BATCH_TABLE_LOCK.IND_TABLE_UPDATE IS 'Indicator used to determine if the UPDATE rights should be revoked when the tables are locked by the batch processes.'
;
COMMENT ON TABLE CAPS.BATCH_TCM_CASE IS 'This is a temporary table used for batch processing.  It is loaded with case information that is used in the TCM (Targeted Case Management) Valid Claims report.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.ID_TCM_CASE IS 'A unique integer which identifies a Case.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.ID_TCM_CASE_STAGE IS 'A unique integer which identifies a Stage of Service.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.ID_TCM_CASE_PERSON IS 'A unique integer that identifies a Person.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_PROGRAM IS 'This is the DFCS Program which controls the Case. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_SEX IS 'A code that identifies an individual''s sex.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_STAGE_TYPE IS 'Code value of a logical group of tasks that as been started or completed.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_WRKR_REGN IS 'A geographic area, larger than a county or unit, which the state is broken down into. Specific to the stage of the case it is associated with.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_SUFFIX IS 'This data element is used within the ALIAS LIST/DETAIL Window to house the appended suffix of the person in question.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_BJN IS 'Stores the BJN number for the case worker. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_CNTCT_TYPE IS 'Used to identify the type of contact being recorded.  This includes: contacts, notifications, staffing, and summaries.  Required field that enables and disables fields in the Contact Info group box depending on the selection made.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_CNTCT_METHOD IS 'A code that indicates the method used (such as phone call or letter) used to make contact with the client/collateral. The user may indicate whether the contact took place in a face to face meeting, by a telephone call, letter, etc., If type is Notification, defaults to Letter Sent.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.CD_TCM_CASE_CNTCT_LOCATN IS 'A code that indicates the location of the client/collaterals who were contacted.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.DT_TCM_CASE_DOB IS 'A date indicating the date of birth of each individual in the IMPACT system.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.ID_TCM_CASE_PERSON_DHS IS 'A unique integer which identifies a DHS.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.ID_TCM_CASE_SSN IS 'A unique integer which identifies a person''s SSN.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.ID_TCM_CASE_CNTCT_WRKR IS 'A unique identifier to the person table.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.ID_TCM_CASE_EVENT IS 'A unique identifier to the event table.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.IND_TCM_CASE_MHMR_MATCH IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.NBR_TCM_CASE_WRKR_UNIT IS 'Number which identifies a group of workers with common supervisor and goals.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.NM_TCM_CASE_NAME IS 'The full name of each person known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.NM_TCM_CASE_WRKR_FULL IS 'The full name of each person known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.NM_TCM_CASE_FIRST IS 'First name of each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.NM_TCM_CASE_LAST IS 'Last name of each individual known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CASE.NM_TCM_CASE_MIDDLE IS 'Middle name of each individual known to the IMPACT system.'
;
COMMENT ON TABLE CAPS.BATCH_TCM_CLAIM IS 'Contains historical TCM (Targeted Case Management) Valid Claims Report data.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.ID_BATCH_TCM_CLAIM IS 'Contains a unique identifier for a row on the BATCH TCM CLAIM table.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.YR_TCM_CLAIM IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.MO_TCM_CLAIM IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.CD_CONTACT_LOCATION IS 'A code that indicates the location of the client/collaterals who were contacted.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.NBR_TDHS_CLIENT IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON TABLE CAPS.BATCH_TCM_CLAIM_AMOUNT IS 'Contains data maintained and used by Budget to balance Valid Claims Report data for TCM (Targeted Case Management) against data reported to MSIS (Medicaid Statistical Information System).'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.ID_BATCH_TCM_CLAIM_AMOUNT IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.YR_TCM_CLAIM IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.MO_TCM_CLAIM IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.DT_PYMNT_ADJUDICATION IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.AMT_UNIT IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.AMT_TOTAL_MONTH IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.AMT_TOTAL_FFQ IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.NBR_TOTAL_MONTH IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.NBR_TOTAL_FFQ IS 'No description available.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_CLAIM_AMOUNT.NBR_FFP_PRCNT IS 'No description available.'
;
COMMENT ON TABLE CAPS.BATCH_TCM_JOB_CLASS IS 'batch runs to update job classes from HR.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_JOB_CLASS.DT_END IS 'Specifies the last date for which this code and decode are recognized by the IMPACT application.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_JOB_CLASS.DT_START IS 'start date of batch.'
;
COMMENT ON COLUMN CAPS.BATCH_TCM_JOB_CLASS.CODE IS 'A series of one or more numbers and/or letters that is used to represent a word or group of words. This value is stored in the system in a specific CD data element.'
;
COMMENT ON TABLE CAPS.BATCH_TST IS 'This is a table purely for testing the batch mechanism. It is not a core application table.'
;
COMMENT ON COLUMN CAPS.BATCH_TST.KEY_ID IS 'Batch test table identifier -- duplicates are allowed so no primary key'
;
COMMENT ON COLUMN CAPS.BATCH_TST.COMMENTS_TX IS 'Comments field'
;
COMMENT ON COLUMN CAPS.BATCH_TST.EDIT_DT IS 'Edit Date'
;
COMMENT ON COLUMN CAPS.BATCH_TST.LOAD_IND IS 'Load indicator (Y/N)'
;
COMMENT ON TABLE CAPS.BATCH_WINDOW_LOCKS IS 'This table is used by the batch process to indicate which windows should be locked by the various batch programs during their execution.'
;
COMMENT ON COLUMN CAPS.BATCH_WINDOW_LOCKS.NM_BATCH_SCRIPT IS 'Name of the batch script that is locking the service.'
;
COMMENT ON COLUMN CAPS.BATCH_WINDOW_LOCKS.NM_WINDOW_NAME IS 'Used by the batch processes, this element stores the name of the window which is locked while the batch program is in progress.'
;
COMMENT ON COLUMN CAPS.BATCH_WINDOW_LOCKS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.BATCH_WINDOW_LOCKS.IND_WINDOW_LOCKED IS 'Indicator used by Batch programs to indicate that a particular window should be locked during a certain batch run.'
;
COMMENT ON TABLE CAPS.BUDGET_VALID IS 'Temporary table used by the Invoice Validation batch process to store Contract budget amounts.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.NBR_BUDG_ITEM IS 'This element is on the BUDGET_VALID table and is used to uniquely identify a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.NBR_BUDG_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CNCNTY table.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_EQUIP IS 'Contains the amount budgeted for equipment expenses on a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_EQUIP_USED IS 'Contains the amount of the equipment budget that has been used for a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_FRG_BENFT IS 'Contains the amount of fringe benefits budget allowed on a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_FRG_BENFT_USED IS 'Contains the amount of fringe benefit budget used on a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_OTHER IS 'Contains the amount of ''other'' budget allowed for a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_OTHER_USED IS 'Contains the amount of ''other'' budget used on a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_SALARY IS 'Contains the amount of salary budget for a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_SALARY_USED IS 'Contains the amount of salary budget used on a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_SUPPLY IS 'Contains the amount of supply budget for a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_SUPPLY_USED IS 'Contains the amount of supply budget used on a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_TRAVEL IS 'Contains the amount of travel budget for a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_TRAVEL_USED IS 'Contains the amount of travel budget used on a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_UNIT_RATE IS 'Contains the amount of unit rate budget allowed for a contract service line item.'
;
COMMENT ON COLUMN CAPS.BUDGET_VALID.AMT_BUDG_UNIT_RATE_USED IS 'Contains the amount of unit rate budget used on a contract service line item.'
;
COMMENT ON TABLE CAPS.CAPS_CARETAKER IS 'Contains caretaker information for private agency foster homes.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.ID_CARETAKER IS 'Unique ID for the Caps_Caretaker record.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.NBR_CARETKR IS 'Number which identifies to which caretaker the record refers. For example, 1 for Caretaker 1.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.NM_CARETKR_FNAME IS 'First name of the caretaker for the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.NM_CARETKR_MNAME IS 'Middle name of the caretaker for the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.NM_CARETKR_LNAME IS 'Last name of the caretaker for the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.CD_CARETKR_SEX IS 'Code identifying the caretaker''s sex.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.DT_CARETKR_BIRTH IS 'Date indicating the date of birth of the caretaker.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.CD_CARETKR_ETHNIC IS 'Code indicating the ethnicity of the caretaker.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.CD_CARETKR_RACE IS 'Code indicating the race of the caretaker.'
;
COMMENT ON COLUMN CAPS.CAPS_CARETAKER.DT_END IS 'End date of the caretaker relationship'
;
COMMENT ON TABLE CAPS.CAPS_CASE IS 'A CASE is a grouping of IMPACT situations. An APS CASE is always associated with a single victim. CPS cases may have multiple victims. a CASE is either CPS or APS, not both. An APS case may be Community, Facility or Both.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.CD_CASE_PROGRAM IS 'This is the DFCS Program which controls the Case. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.CD_CASE_COUNTY IS 'Three digit, numeric county code for each case.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.CD_CASE_SPECIAL_HANDLING IS 'A code which indicates that the case may require special handling (military base, Indian reservation, etc.)'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.IND_CASE_WORKER_SAFETY IS 'CheckBox that allows the intake worker to identify a possible threat of violence to the worker on the Intake Call Decision window.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.TXT_CASE_WORKER_SAFETY IS 'Contains specifics about warnings if Worker Safety Issues box is checked. (e.g. Case worker was physically threatened by intoxicated father when arrived at the house.)'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.TXT_CASE_SENSITIVE_CMNTS IS 'Comments as to why a case is marked sensitive.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.IND_CASE_SENSITIVE IS 'Indicates whether the case associated to the stage or the case itself has been marked as sensitive (DFCS Staff, VIP, etc).'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.IND_CASE_ARCHIVED IS 'Indicator to show if a case is archived.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.DT_CASE_CLOSED IS 'This is the date the case was last closed. A case may be closed and re-opened if a new situation is identified.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.CD_CASE_REGION IS 'A geographic area which the state is broken down into.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.DT_CASE_OPENED IS 'This is the date DFCS received the first intake for the first situation in the case.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.NM_CASE IS 'This is the Name of the Case. Usually is the Name of one of the Principals (Mother or Father).'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.NM_CASE_LAST IS 'Last name of the case. Usually the last name of the mother or father in the case.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.IND_CASE_SUSP_METH IS 'indicator if the case is related to the suspicion of meth manufacturing.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.TXT_CASE_SUSP_METH IS 'text about the suspicion of meth manufacturing.'
;
COMMENT ON COLUMN CAPS.CAPS_CASE.IND_CASE_SEALED IS 'Indicator whether the case is sealed or not'
;
COMMENT ON TABLE CAPS.CAPS_RESOURCE IS 'A person or organization which may provide services or other aid to people. This could include, day care, transportation, food services etc. Resources include Providers, Facilities, and Foster Adoptive Homes.  (CAPS RESOURCE NBR is not a true foreign key constraint.)'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ADDR_RSRC_ST_LN_1 IS 'Address of the facility.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ADDR_RSRC_ST_LN_2 IS 'Second line of Street address for the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ADDR_RSRC_CITY IS 'City of the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_STATE IS 'The abbreviated state code for the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ADDR_RSRC_ZIP IS 'Numeric zip code for the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ADDR_RSRC_ATTN IS 'Contains the attention field for the primary resource address.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_CNTY IS 'The abbreviated county code for the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_INVOL_CLOSURE IS 'To determine if the closure of the home was involuntary. Used to capture the history of the home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_CLOSURE_RSN IS 'The reason for closing or other status change on the F/A home/application. Recorded on the Resource Table.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_SOURCE_INQUIRY IS 'Contains how the inquiree found out about the F/A Home program.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_TYPE IS 'Type of resource. e.g. Provider'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_CAMPUS_TYPE IS 'When a resource is of type school, this field indicates the type of campus of the school.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_MAINTAINER IS 'The name of the region that is responsible for updating the resource record. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_SCH_DIST IS 'The school district in which a resource is located.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_OWNERSHIP IS 'The legal type of business that the resource represents.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FACIL_TYPE IS 'The type of facility as defined by who licensed the facility, the number of clients it can accommodate, and the type of service it provides.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_HUB IS 'Code which indicates the type of HUB vendor/resource this is.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_CERT_BY IS 'Stores the code value of the types of certifying bodies for resources.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_OPER_BY IS 'An umbrella agency that operates a child resource that is listed separately in the resource directory.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_SETTING IS 'The physical setting in which the facility is located.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_PAYMENT IS 'The type of payment that the resource accepts for rendered services.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_CATEGORY IS 'The category of F/A home (Foster, Adoptive, Foster/Adoptive...).'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_ETHNICITY IS 'The ethnicity of the F/A Home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_LANGUAGE IS 'The language spoken by the F/A Home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_MARITAL_STATUS IS 'The home''s marital status or family structure.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_RECMND_REOPEN IS 'Indicates whether the worker would allow the F/A Home to be reinstated after closure, if applied again.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_REGION IS 'The region the F/A Home is located .'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_RELIGION IS 'The religion practiced in the F/A Home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_RESPITE IS 'Indicates the type of respite placements a home accepts.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_STATUS IS 'The status of service of a F/A home (i.e. inquiry, recruit, applicant, participant).'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_TYPE_1 IS 'This element indicates the home is a Type 1 FA Home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_TYPE_2 IS 'This element indicates the home is a FA home type 2.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_TYPE_3 IS 'This element indicates the home is a FA home type 3.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_TYPE_4 IS 'This element indicates the home is a FA home type 4.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_TYPE_5 IS 'This element indicates the home is a FA home type 5.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_TYPE_6 IS 'This element indicates the home is a FA home type 6.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_FA_HOME_TYPE_7 IS 'This element indicates the home is a FA home type 7.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_STATUS IS 'The operation or license status of the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_RSRC_MARRIAGE IS 'The date of the marriage of the couple in the F/A Home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_RSRC_CLOSE IS 'The date that a facility was closed (license cancelled).'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_RSRC_CERT IS 'The date that a facility was certified (licensed).'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ID_RSRC_FA_HOME_STAGE IS 'A unique integer which identifies FA Home as the stage.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ID_RSRC_FA_HOME_EVENT IS 'A unique identifier for the Event table.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_RSRC_WRITE_HIST IS 'Indicates that information needs to reflect in the history table.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_RSRC_CARE_PROV IS 'Indicates that the home provides care in the home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_RSRC_EMERG_PLACE IS 'This field indicates that the home is willing to accept children for emergency placement. Disabled for adoptive homes.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_RSRC_INACTIVE IS 'Indicates that a home is inactive.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_RSRC_TRANSPORT IS 'Identifies resources that offer transportation to their services.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NM_RSRC_LAST_UPDATE IS 'The person who last updated the resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NM_RESOURCE IS 'The name of an entity that provides assistance or services to APS and/or CPS clients.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NM_RSRC_NAME_INDEX IS 'This element is solely for the purpose of being indexed to improve performance in the resource search. This element contains the first two letters of the resource name.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NM_RSRC_CONTACT IS 'The name of the individual that a DFCS employee calls to inquire about services.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_PHN IS 'The phone number of the resource which is offering services.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_PHONE_EXT IS 'The extension of the phone number listed.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_FACIL_CAPACITY IS 'The maximum client capacity of a facility.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_FACIL_ACCLAIM IS 'The unique ACCLAIM identifier from the ACCLAIM interface that is stored on the resource record.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_VID IS 'The Vendor ID number for the F/A Home used for payment.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_CAMPUS_NBR IS 'TEA system identifier for a given school.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_INT_CHILDREN IS 'The max number of children an adoptive home wishes to adopt. Not on window, only for database.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_INT_FE_AGE_MAX IS 'The max age of a female child that an adoptive home wishes to adopt. Not on window, only for database.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_INT_FE_AGE_MIN IS 'The min age of a female child that an adoptive home wishes to adopt. Not on window, only for database.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_INT_MA_AGE_MAX IS 'The max age of a male child the adoptive home wishes to adopt. Not on window, only for database.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_INT_MA_AGE_MIN IS 'The min age of a male child the adoptive home wishes to adopt. Not on window, only for database.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_ANNUAL_INCOME IS 'The annual income of a F/A Family.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_FM_AGE_MAX IS 'The maximum age of a female child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_FM_AGE_MIN IS 'The minimum age of a female child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_MA_AGE_MAX IS 'The maximum age of a male child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_MA_AGE_MIN IS 'The minimum age of a male child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_OPEN_SLOTS IS 'The number of open slots in a F/A Home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.TXT_RSRC_ADDR_CMNTS IS 'Comment field for Resource address records on the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.TXT_RSRC_COMMENTS IS 'Comment field for a resource record.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_MHMR_COMP_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_CCL_UPDATE IS 'Date that child care licensing agency updated record.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_RSRC_MHMR_SITE IS 'Contains an MHMR code that distinguishes among sites within an MHMR facility provider.  This code is not associated with a codes table.  It is populated with data received from MHMR through a batch interface that runs weekly.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_RSRC_CONTRACTED IS 'Indicates if the resource has been contracted.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NM_LEGAL IS 'Legal Name of the Resource.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NM_RSRC_CONTACT_TITLE IS 'Contact person title'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_NTNL_PROVIDER IS 'National Provider number'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ADDR_RSRC_EMAIL IS 'Email Address'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.ADDR_RSRC_WEBSITE IS 'Website URL'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_SCHOOL_TYPE IS 'Type of school (if this resource is a school)'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_PAYMENT_DELIVERY IS 'Type of payment'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.TXT_SPEC_CERT IS 'Other Specialty/Certification'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_EXCHANGE_STAT IS 'AD Exchg. Status'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_WAIVER IS 'Waiver Exists'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_SCH_DIST IS 'School District'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_ELEM IS 'Elementary School - Code indicates what Elementary school services the F/A Home in this record'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_MIDDLE IS 'Middle School'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.CD_HIGH IS 'High School'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_FOST_MANUAL IS 'Foster Parent Manual Date'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_FOST_BILL IS 'Foster Parents Bill of Rights'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_SPECIFIC_CHILD IS 'Specific Children Identified'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_LIC_BEGIN IS 'Approval Begin Date'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.DT_LIC_END IS 'Approval End Date'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.TXT_CLOSURE_COMM IS 'Closure Comments (or other status change comments)'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NDFCS_CERT_ENTITY IS 'Name of the Non-DFCS Entity that certified this resource'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_RSRC_NONDFCS IS 'Indicates whether the F/A Home is a Non-DFCS home.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_CURR_HM_STDY_EXSTS IS 'Indicator if a current home study exists'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_PREV_FAM_STDY_RQSTD IS 'Represents the previous family study requested checkbox on home info page.'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.RSRC_OTH_SPC_CERTF IS 'Other or Specialty Certification'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.IND_AFTER_HOURS IS 'New field representing the available after hours field on the PLACEMENT PROVIDER page'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.TXT_HM_PRG_INTEREST IS 'Text field for HM Program Interest'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_CONTACT_PHN IS 'Phone number for private agency case worker'
;
COMMENT ON COLUMN CAPS.CAPS_RESOURCE.NBR_RSRC_CONTACT_PHONE_EXT IS 'Extension for private agency case worker'
;
COMMENT ON TABLE CAPS.CASE_BUDGET_LIMIT IS 'Holds Data for the Case Budget Limit page'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.CD_SVC_CODE IS 'Holds the Entitlement/Service Codes'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.AMT_BUDGT IS 'Amount Budgeted'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.AMT_SPENT IS 'Amount Spent'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.AMT_REMAIN IS 'Remaining Amount'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.AMT_WAIVER IS 'Waiver Amount'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.AMT_BALANCE IS 'Remaining Balance'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.CD_SVC_AUTH_STATUS IS 'It indicates the event status of the service auth'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT.AMT_PEND_AUTH IS 'Holds the amount that is requested for the service'
;
COMMENT ON TABLE CAPS.CASE_BUDGET_LIMIT_WAIVER IS 'Contains Budget limits for Waivers by case.'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT_WAIVER.ID_WAIVER IS 'A unique identifier to the EVENT table. Identifies the Event that is policy waiver applies to.'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT_WAIVER.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT_WAIVER.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.CASE_BUDGET_LIMIT_WAIVER.CD_SVC_CODE IS 'Service Code'
;
COMMENT ON TABLE CAPS.CASE_FILE_LOC IS 'NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_LOC.ID_CASE_FILE_LOC IS 'A unique integer which defines a Case File Location.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_LOC.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_LOC.DT_CASE_FILE_LOC IS 'The date the case file changed locations.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_LOC.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_LOC.ID_CASE_FILE_LOC_OFFICE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_LOC.NM_CASE_FILE_LOC_PERS_RESP IS 'No description available.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_LOC.TXT_CASE_FILE_LOC_CMNTS IS 'This contains any other information needed in the transfer of a case file such as the reason why the case has physically transferred to a new location and the exact location.'
;
COMMENT ON TABLE CAPS.CASE_FILE_MANAGEMENT IS 'Contains information regarding the physical location of the case file.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.ID_CASE_FILE_CASE IS 'Primary key on the CASE FILE MANAGEMENT table. References the unique key of Id Case on the CASE table.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.ID_CASE_FILE_OFFICE IS 'Foreign Key on the CASE_FILE_MANAGEMENT table that references ID_OFFICE on the OFFICE table.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.ID_UNIT IS 'A unique identifer for the UNIT table.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.ADDR_CASE_FILE_CITY IS 'The case file location city.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.ADDR_CASE_FILE_ST_LN_1 IS 'The first line of the street address of the Case File Location.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.ADDR_CASE_FILE_ST_LN_2 IS 'The second line of the street address of the Case File Location.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.CD_CASE_FILE_OFFICE_TYPE IS 'This is a radio button used to denote whether a case file location is a DFCS office or not.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.DT_CASE_FILE_ARCH_COMPL IS 'The date the physical case file was archived.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.DT_CASE_FILE_ARCH_ELIG IS 'The date the physical case file is eligible for archiving.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.NM_CASE_FILE_OFFICE IS 'Name of DFCS Office where the case file is located.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.TXT_CASE_FILE_LOCATE_INFO IS 'Locating descriptions which aid in tracking the location of the archived/microfilmed physical case file.'
;
COMMENT ON COLUMN CAPS.CASE_FILE_MANAGEMENT.TXT_PRIOR_CMNTS IS 'Holds Comments Prior Data'
;
COMMENT ON TABLE CAPS.CASE_LINK IS 'Table used to store linked and un-linked case Ids.'
;
COMMENT ON COLUMN CAPS.CASE_LINK.ID_CASE_LINK IS 'Unique identifier and primary key for the CASE_LINK table.'
;
COMMENT ON COLUMN CAPS.CASE_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CASE_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CASE_LINK.IND_CASE_LINK IS 'Case link indicator which indicates whether it is a linked case or unlinked case by ''Y'' or ''N''.'
;
COMMENT ON COLUMN CAPS.CASE_LINK.ID_LINKED_CASE IS 'For each case id relevant case information will be linked with this linked case id.'
;
COMMENT ON COLUMN CAPS.CASE_LINK.DT_CASE_LINKED IS 'Date of case linked.'
;
COMMENT ON COLUMN CAPS.CASE_LINK.ID_PERSON_UPDATE IS 'ID PERSON of the child for whom the referral was sent.'
;
COMMENT ON TABLE CAPS.CASE_MERGE IS 'This table contains the information on cases which have been merged with another case.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.ID_CASE_MERGE IS 'Primary key for Case Merge table.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.ID_CASE_MERGE_TO IS 'ID of Case being merged TO.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.ID_CASE_MERGE_FROM IS 'ID of case merged from.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.ID_CASE_MERGE_SIT_FROM IS 'ID of Situation being merged into new case'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.ID_CASE_MERGE_STAGE_FROM IS 'ID Stage of case being merged from'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.ID_CASE_MERGE_PERS_MRG IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.ID_CASE_MERGE_PERS_SPLIT IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.IND_CASE_MERGE_INVALID IS 'Used to indicate is a case merge has been split or invalidated with another merge.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.IND_CASE_MERGE_PENDING IS 'Flag for batch process to process case merges and splits.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.IND_CASE_MERGE_STAGE_SWAP IS 'Indicator to show that stage was moved to a different situation as part of the merge.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.DT_CASE_MERGE IS 'Date merge took place.'
;
COMMENT ON COLUMN CAPS.CASE_MERGE.DT_CASE_MERGE_SPLIT IS 'Date of split.'
;
COMMENT ON TABLE CAPS.CASE_PURGE_REPORT IS 'Holds Case and Person data for purged cases from the latest execution of Case Purge.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.ID_CASE_PURGE_REPORT IS 'Unique identifier for the CASE PURGE REPORT table.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.ID_DELETE_CASE IS 'Contains a unique identifier for a row on the DELETE CASE table.  It is the same value as ID CASE from the CAPS CASE table.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.NM_CASE IS 'This is the Name of the Case. Usually is the Name of one of the Principals (Mother or Father).'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.CD_CASE_PROGRAM IS 'This is the DFCS Program which controls the Case. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.CD_CASE_REGION IS 'A geographic area which the state is broken down into.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.CD_CASE_COUNTY IS 'Three digit, numeric county code for each case.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.CD_CASE_FILE_OFF_TYPE IS 'Denotes whether or not a case file location is a DFCS office.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.ID_CASE_FILE_OFFICE IS 'Foreign Key on the CASE_FILE_MANAGEMENT table that references ID_OFFICE on the OFFICE table.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.ID_UNIT IS 'A unique identifer for the UNIT table.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.DT_CASE_OPENED IS 'This is the date DFCS received the first intake for the first situation in the case.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.DT_CASE_CLOSED IS 'This is the date the case was last closed. A case may be closed and re-opened if a new situation is identified.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.CD_REC_RTN_RETEN_TYPE IS 'The retention code associated with the closed case. Based upon stages/services associated with the case.  This element is used as a key into the REC RETEN TYPE table and is used by the Records Retention Common Function.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.DT_PURGE IS 'date of purge.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.CD_PURGE_TYPE IS 'type of purge.'
;
COMMENT ON COLUMN CAPS.CASE_PURGE_REPORT.CD_PURGE_ACTION IS 'action to continue with purge.'
;
COMMENT ON TABLE CAPS.CBT_ACTION_LOG IS 'Stores messages sent to CBT Administrator.'
;
COMMENT ON COLUMN CAPS.CBT_ACTION_LOG.NM_ACTION_SCRIPT_NAME IS 'Script Name of the batch process.'
;
COMMENT ON COLUMN CAPS.CBT_ACTION_LOG.NBR_ACTION_SCRIPT_PID IS 'UNIX Process Id of the process running.'
;
COMMENT ON COLUMN CAPS.CBT_ACTION_LOG.TXT_RESTART_SAVE_AREA IS 'Working Storage of a running Batch Process. Maximum size is 1,500 bytes.'
;
COMMENT ON COLUMN CAPS.CBT_ACTION_LOG.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.CBT_RSAM_CHECKPOINT IS 'Stores the checkpoint of where the batch program is for RSAM architecture.'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_CHECKPOINT.NM_CHECKPOINT_SCRIPT_NAME IS 'No description available.'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_CHECKPOINT.DT_CHECKPOINT_DATE IS 'The date of the checkpoint (Not Used).'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_CHECKPOINT.NBR_CHECKPOINT_INTERVAL IS 'Commit internal of a batch process. (Not used).'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_CHECKPOINT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.CBT_RSAM_RESTART IS 'Stores a snapshot of memory that will be used to restart a failed batch process.'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_RESTART.NM_RESTART_SCRIPT_NAME IS 'No description available.'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_RESTART.ID_RESTART_ROW_SEQ IS 'No description available.'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_RESTART.TXT_RESTART_SAVE_AREA IS 'Working Storage of a running Batch Process. Maximum size is 1,500 bytes.'
;
COMMENT ON COLUMN CAPS.CBT_RSAM_RESTART.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.CBT_STEP_RESTART IS 'Used by the batch architecture to restart a batch process after it abends. It stores the program name and which step was last executed successfully.'
;
COMMENT ON COLUMN CAPS.CBT_STEP_RESTART.NM_STEP_SCRIPT_NAME IS 'Stores the name of the script that is currently running.'
;
COMMENT ON COLUMN CAPS.CBT_STEP_RESTART.NBR_STEP_NUM IS 'The last successful step executed in the batch script.'
;
COMMENT ON COLUMN CAPS.CBT_STEP_RESTART.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.CFP_DOCUMENT IS 'This table contians the information needed to generate a document for a CFP.  This table will tell the system what nethod to use, what data that method needs, what document it is, and in what order to print them out.'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.ID_CFP_DOCUMENT IS 'Primary key of the CFP_DOCUMENT table.'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.TXT_NAME IS 'The name of the document as it appears on the CFP page'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.TXT_GENERATE_METHOD IS 'The name of the method the system should use to generate this document.'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.TXT_FOR_EACH IS 'What to process each document for.'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.NM_DOCUMENT IS 'The smart name fo the document'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.CD_OUTPUT IS 'Output code'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.CD_STAGE_PROGRAM IS 'This is the DFCS Program which controls the Stage. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT.NBR_SORT_ORDER IS 'The order they will print out in the CFP'
;
COMMENT ON TABLE CAPS.CFP_DOCUMENT_STAGE IS 'This table will tell the CFP page what document can be generated for a given stage and stage type'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT_STAGE.ID_CFP_DOCUMENT IS 'Primary key of the CFP_DOCUMENT table.'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT_STAGE.CD_STAGE IS 'Code that represents the stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.)'
;
COMMENT ON COLUMN CAPS.CFP_DOCUMENT_STAGE.CD_STAGE_TYPE IS 'Code representing a further breakdown of the stage.  It defines the type of client or type of services being provided to the client.'
;
COMMENT ON TABLE CAPS.CFP_STATUS IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.ID_CFP_STATUS IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.DT_LAST_UPDATE IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.ID_CASE IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.ID_STAGE IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.ID_PERSON IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.DT_SUBMIT_TIME IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.DT_COMPLETION_TIME IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.CD_STAGE IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.CD_STATUS IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.TXT_PROGRESS IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.TXT_PATH IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON COLUMN CAPS.CFP_STATUS.TXT_ERROR_DESCRIPTION IS 'The table hold the status of cfp documents that have been created in the past day.'
;
COMMENT ON TABLE CAPS.CHARACTERISTICS IS 'Distinguishing features of a principal. i.e. Blind, Substance Abuser, Physically Handicapped.'
;
COMMENT ON COLUMN CAPS.CHARACTERISTICS.ID_CHARACTERISTICS IS 'A unique integer which defines a Characteristic.'
;
COMMENT ON COLUMN CAPS.CHARACTERISTICS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHARACTERISTICS.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CHARACTERISTICS.CD_CHARACTERISTIC IS 'Stores the person characteristics for both programs.'
;
COMMENT ON COLUMN CAPS.CHARACTERISTICS.DT_CHAR_START IS 'Effective date that defines when a Characteristic was selected for a Person.'
;
COMMENT ON COLUMN CAPS.CHARACTERISTICS.DT_CHAR_END IS 'Effective date that defines when a Characteristic was deselected for a Person.'
;
COMMENT ON COLUMN CAPS.CHARACTERISTICS.CD_CHAR_CATEGORY IS 'Lists Person Characteristic categories.'
;
COMMENT ON TABLE CAPS.CHILD_PLAN IS 'Details about a service plan for a child in substitute care or adoption. References set objectives oriented towards the child''s special needs.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.ID_CHILD_PLAN_EVENT IS 'A unique identifier to the event table used on Child Plan.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.CD_CSP_PLAN_PERM_GOAL IS 'A code which identifies the child''s permanency goal.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.CD_CSP_PLAN_TYPE IS 'The type of service plan the child is receiving.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.DT_CSP_PERM_GOAL_TARGET IS 'Specified date when the child is expected to enter the permanent living situation identified in the long-range goal for permanency.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.DT_CSP_NEXT_REVIEW IS 'The next review date for the child service plan.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.TXT_CSP_LENGTH_OF_STAY IS 'Text indicating how long the child is expected to remain in temporary substitute care before entering the permanent living situation planned.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.TXT_CSP_LOS_DISCREPANCY IS 'Text explaining a possible discrepancy between the projected date for achieving the permanent living situation planned for a child and the estimated length of time a child is expected to stay in temporary substitute care.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.TXT_CSP_PARTICIP_COMMENT IS 'Child Service Plan participation comments.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN.DT_CSP_PLAN_COMPLETED IS 'date the child plan was completed.'
;
COMMENT ON TABLE CAPS.CHILD_PLAN_ITEM IS 'Needs, Tasks and Services recorded for a child during a Child Plan.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.ID_CHILD_PLAN_ITEM IS 'A unique identifier for the Child Plan Item.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.ID_CHILD_PLAN_EVENT IS 'A unique identifier to the event table used on Child Plan.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.CD_CSP_ITEM_NEED IS 'The need column in the summary list box is populated by the needs previously entered on a particular case. The user can delete, or modify these needs. The needs summary is also used to view all past needs of the youth.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.CD_CSP_ITEM_SERVICE IS 'The service column in the summary list box is populated by the services previously entered on a particular case. The user can delete, or modify these services. The service summary is also used to view all past services used by the youth.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.CD_CSP_ITEM_TASK IS 'The task summary list box is populated by the tasks that have been started or completed by the youth. The user can delete or modify these tasks. The task is also used as a summary of previous tasks.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.TXT_CSP_ITEM_METHOD_EVAL IS 'Text specifying how the staff assess the completion of a task (Only enabled if the current selection is task).'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.TXT_CSP_ITEM_SVC_FREQ IS 'The service frequency field indicates how often or for what period the service is used by the youth. This field is required for the service information to be completed and saved.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.TXT_CSP_ITEM_TASK_FREQ IS 'Short description of the begin date, end date or frequency of a task or service (Only enabled if the current selection is task or service).'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.TXT_CSP_SERVICE IS 'Multi-line entry field which defaults to the long description of the type (needs, tasks, or services). The user may modify the tasks or services descriptions to suit the particular situation being described. This field allows users to create client-friendly statements that appear on the printed child''s service plan. (The title and the contents of the field change according to what is chosen in the current selection.)'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_ITEM.TXT_CSP_TASK IS 'Multi-line entry field which defaults to the long description of the type (needs, tasks, or services). The user may modify the tasks or services descriptions to suit the particular situation being described. This field allows users to create client-friendly statements that appears on the printed child''s service plan. (The title and the contents of the field change according to what is chosen in the current selection.)'
;
COMMENT ON TABLE CAPS.CHILD_PLAN_NARR IS 'Child Plan topics narrative blob table. Several narratives are recorded during a Child Plan.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_NARR.CD_CP_TOPIC IS 'This is the topic code that references the child plan type topic codes table to obtain the detail topics to be addressed for a child plan type.  The 3 character code can be used to find the narrative table in which that topic is stored in the database.  For example, the code ''DVL'', data is stored in the child plan topic narrative table called ''CP_DVL_NARR''.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing the Child Plan done in SubCare or Adoption.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.CHILD_PLAN_PARTICIP IS 'Stores the participant and notification type for the child plan.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.ID_CHILD_PLAN_PART IS 'A primary key on the Child Plan Particip table.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.ID_CHILD_PLAN_EVENT IS 'A unique identifier to the event table used on Child Plan.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.CD_CSP_PART_NOTIF_TYPE IS 'This data element is where the user chooses the type of notification given, whether verbal or written.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.CD_CSP_PART_TYPE IS 'This box enables the name and relationship entry fields.  It allows for classification of persons participation in the child plan process. Participate can be a person in case, staff or others.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.DT_CSP_DATE_NOTIFIED IS 'Displays the date that the participant was notified that the meeting would take place. The information is taken from the data inputted/chosen in the Date Notified field when the user invokes the Add pushbutton.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.DT_CSP_PART_COPY_GIVEN IS 'Allows the user to input/select the date the user delivered or mailed a copy of the plan to the participant. This information is passed to the Copy Given column of the Participants List Box when the Add pushbutton is invoked.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.DT_CSP_PART_PARTICIPATE IS 'Allows the user to input/select the date the client(s) participated in the development/review of the plan. This information is passed to the Participation column of the Participants List Box when the Add pushbutton is invoked.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.NM_CSP_PART_FULL IS 'This is the full name of the child plan participant. Could be a person in case, staff or others.'
;
COMMENT ON COLUMN CAPS.CHILD_PLAN_PARTICIP.SDS_CSP_PART_RELATIONSHIP IS 'The relationship of the other person to the case is entered here.'
;
COMMENT ON TABLE CAPS.CHILD_SUPPORT IS 'Contains child support receipt data (related to DFCS clients) from the Office of the Attorney General''s (OAG) child support enforcement system.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.ID_CHLD_SPPRT IS 'Contains a unique identifier for a row on the CHILD SUPPORT table.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.NBR_PRSN_SSN IS 'Contains the social security number (as recorded by the OAG) of the child for whom a child support payment was made.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.DT_CHLD_SPPRT_RCVD IS 'Contains the date the child support payment was received by the Office of the Attorney General (OAG).'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.AMT_CHLD_SPPRT_AMNT IS 'Contains the amount of a child support payment allocated to the current child.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.NBR_COUNTY_CRS_ID IS 'This is the Client Identifier obtained from CRS (Client Repository System) which is used in state of Georgia applications. This particular field is the CRS ID of the Virtual "County DFCS" client that will represent the entity being paid child support, which in this instance is the county itself because the child is in Foster Care.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.NBR_NCP_CRS_ID IS 'This is the Client Identifier obtained from CRS (Client Repository System) which is used in state of Georgia applications. This field contains the client id for the non custodial parent that is paying the child support.'
;
COMMENT ON COLUMN CAPS.CHILD_SUPPORT.NBR_CHECK IS 'The number of the check associated with a payment, in this case a child support payment made by the non custodial parent on behalf of one or more children that will go to DFCS.'
;
COMMENT ON TABLE CAPS.CHILDBKGRND_SUMM_NARR IS 'Stores the narrative of the child''s background.'
;
COMMENT ON COLUMN CAPS.CHILDBKGRND_SUMM_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CHILDBKGRND_SUMM_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHILDBKGRND_SUMM_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CHILDBKGRND_SUMM_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing a Child''s Background.'
;
COMMENT ON COLUMN CAPS.CHILDBKGRND_SUMM_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.CHLD_DTH_COMM_NARR IS 'Stores the child death committee narrative.'
;
COMMENT ON COLUMN CAPS.CHLD_DTH_COMM_NARR.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CHLD_DTH_COMM_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CHLD_DTH_COMM_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Child Death Comm.'
;
COMMENT ON COLUMN CAPS.CHLD_DTH_COMM_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.CITY IS 'Stores all of the cities, including their corresponding counties within (state and federal) in Texas, including the Texas and federal county numbers.'
;
COMMENT ON COLUMN CAPS.CITY.ID_CITY IS 'A unique identifier for the City table.'
;
COMMENT ON COLUMN CAPS.CITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CITY.CD_CITY_TEX_CNTY IS 'Texas codes for the counties in Texas.'
;
COMMENT ON COLUMN CAPS.CITY.CD_CITY_FED_CNTY IS 'Federal codes for the counties in Texas.'
;
COMMENT ON COLUMN CAPS.CITY.NM_CITY_CNTY IS 'Name of county.'
;
COMMENT ON COLUMN CAPS.CITY.NM_CITY IS 'City field or address.'
;
COMMENT ON TABLE CAPS.CLAIM_FACTOR IS 'Contains assistance and non-assistance factors used in claiming program funds.  Used for reporting purposes.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.ID_CLAIM_FCTR IS 'A unique identifier for a row on the CLAIM FACTOR table.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.NM_PRGRM IS 'Contains the name or acronym of the Program to which the current row applied.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.DT_FCTR_EFFECTIVE IS 'Contains the beginning date for which the current row is effective.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.DT_FCTR_END IS 'Contains the last date for which the current row is effective.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.CD_PAC IS 'Contains the PAC (Program Activity Code) for the particular service code. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.CD_OBJCT IS 'The Object for which the fund allocation is being made. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.NBR_ASSSTNC_FCTR IS 'A factor that indicates the share of the expense that is applied to Assistance for the particular Program, PAC and Object.'
;
COMMENT ON COLUMN CAPS.CLAIM_FACTOR.NBR_NON_ASSSTNC_FCTR IS 'A factor that indicates the share of the expense that is applied to Non-Assistance for the particular Program, PAC and Object.'
;
COMMENT ON TABLE CAPS.CNSRVTRSHP_REMOVAL IS 'Stores data pertaining to the removal of the child from the home.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.ID_REMOVAL_EVENT IS 'A unique identifier to the EVENT table. Stores the Id Event from the EVENT table for the event of removal.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.ID_VICTIM IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.DT_REMOVAL IS 'The date the child was removed from his/her own home.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.IND_REMOVAL_NA_CARE IS 'If the characteristic list is not applicable for the caretaker, the box is checked.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.IND_REMOVAL_NA_CHILD IS 'If the characteristic list is not applicable for the client, the box is checked.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.NBR_REMOVAL_AGE_MO IS 'The child''s age (month) when the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.NBR_REMOVAL_AGE_YR IS 'The child''s age (year) when the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.CD_REMOVAL_MOTHR_MARRD IS 'A code indicating whether the mother was married at the time when the child was born. This field is editable for 45 days following removal and can be updated if additional information regarding mothers marital status is obtained.'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.CD_REMOVAL_TYPE IS 'Type of removal'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.IND_PARENT_NOTIFIED IS 'Indicator if Parent Notified of 72 Hour Hearing at Removal'
;
COMMENT ON COLUMN CAPS.CNSRVTRSHP_REMOVAL.TXT_DESCRIPTION_OF_INCIDENT IS 'Factual Description of incident precipitating removal'
;
COMMENT ON TABLE CAPS.CODES_TABLES IS 'Static Table that contains a one-to-one definition of the code and its translation.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES.CODE_TYPE IS 'A series of eight letters used to describe a group of related codes.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES.CODE IS 'A series of one or more numbers and/or letters that is used to represent a word or group of words. This value is stored in the system in a specific CD data element.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES.DECODE IS 'The word or groups of words that is represented by a code.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES.DT_END IS 'Specifies the last date for which this code and decode are recognized by the IMPACT application.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES.DT_LAST_UPDATE IS 'Date this record was inserted or last updated.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES_HISTORY.id_codes_table_history IS 'Uniquely identifies each row in the table.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES_HISTORY.code_type IS 'Code type in CODES_TABLES'
;
COMMENT ON COLUMN CAPS.CODES_TABLES_HISTORY.trans_type IS 'Type of edit ability allowed for the code type - full edit or limited edit.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES_HISTORY.id_employee IS 'Id of the employee who made the update.'
;
COMMENT ON TABLE CAPS.CODES_TABLES_INFO IS 'CODES_TABLES_INFO contains one row for each code type in CODES_TABLES that is editable.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES_INFO.code_type IS 'Code type in CODES_TABLES'
;
COMMENT ON COLUMN CAPS.CODES_TABLES_INFO.trans_type IS 'Type of edit ability allowed for the code type - full edit or limited edit.'
;
COMMENT ON COLUMN CAPS.CODES_TABLES_INFO.code_type_desc IS 'Brief description of the code type - what it is used for.'
;
COMMENT ON TABLE CAPS.COLLEGE_EXAM IS 'Holds College Entrance Exam Information.'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.ID_COLLEGE_EXAM IS 'College Exam ID'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.CD_EXAM_TYP IS 'Exam Type'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.NBR_ENGLISH IS 'English Score'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.NBR_MATH IS 'Math Score'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.NBR_READING IS 'Reading Score'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.NBR_SCIENCE IS 'Science Score'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.NBR_WRITING IS 'Writing Score'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.NBR_TOTAL IS 'Total Score'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.NBR_VERBAL IS 'Verbal Score'
;
COMMENT ON COLUMN CAPS.COLLEGE_EXAM.DT_EXAM IS 'Captures date examination taken.'
;
COMMENT ON TABLE CAPS.COMMON_APPL_NARR IS 'Stores the narrative of application for placement of children in residential care from subcare stage.'
;
COMMENT ON COLUMN CAPS.COMMON_APPL_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.COMMON_APPL_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.COMMON_APPL_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.COMMON_APPL_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative of the Common Application Document for a child in Sub-Care.'
;
COMMENT ON COLUMN CAPS.COMMON_APPL_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.CONTACT IS 'A contact between an employee and a person (i.e. a collateral, principal, provider) to gather information about a situation, a principal, or a service plan, or to provide direct delivery services.'
;
COMMENT ON COLUMN CAPS.CONTACT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CONTACT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTACT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CONTACT.ID_CONTACT_WORKER IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTACT.ID_CONTACT_STAGE IS 'Unique identifier to the stage table.'
;
COMMENT ON COLUMN CAPS.CONTACT.DT_CONTACT_OCCURRED IS 'The date the contact was made. If the contact is a summary, it is the latest date the narrative was modified.'
;
COMMENT ON COLUMN CAPS.CONTACT.DT_CNTCT_NEXT_SUMM_DUE IS 'Date that the Next Summary is due.'
;
COMMENT ON COLUMN CAPS.CONTACT.IND_CONTACT_ATTEMPTED IS 'Checked if the contact was attempted but not made successfully.'
;
COMMENT ON COLUMN CAPS.CONTACT.CD_CONTACT_TYPE IS 'Used to identify the type of contact being recorded. This includes: contacts, notifications, staffing, and summaries.  Required field that enables and disables fields in the Contact Info group box depending on the selection made.  The four character code contains a prefix indicating the following: 
   A = CPS INV, CCL INV or RCL INV
   B = FPR, FRE or FSU
   C = APS INV, APS SVC or APS AOC
   D = INT (APS or CPS)
   E = AFC INV
   F = Closed Stages
   G = SUB
   H = ADO or PAD
   I = FAD
   J = PAL
   K = ARI or ARF'
;
COMMENT ON COLUMN CAPS.CONTACT.CD_CONTACT_PURPOSE IS 'The purpose of the contact.  Used for targeted case management. The codes that appear in the Purpose drop-down list vary depending on the type of contact chosen and whether the worker is CPS or APS.  The four character code contains a prefix indicating the following: 
   A = APS INV, AFC INV, SVC, AOC or FPR
   B = CCL INV, RCL INV or CPS INV
   D = INT (APS or CPS)
   G = SUB, FRE or FSU
   H = ADO or PAD
   I = PAL or FAD
   K = ARI or ARF'
;
COMMENT ON COLUMN CAPS.CONTACT.CD_CONTACT_LOCATION IS 'A code that indicates the location of the client/collaterals who were contacted.'
;
COMMENT ON COLUMN CAPS.CONTACT.CD_CONTACT_METHOD IS 'A code that indicates the method used (such as phone call or letter) used to make contact with the client/collateral. The user may indicate whether the contact took place in a face to face meeting, by a telephone call, letter, etc., If type is Notification, defaults to Letter Sent.'
;
COMMENT ON COLUMN CAPS.CONTACT.CD_CONTACT_OTHERS IS 'If the contact or notification involved persons other than principals or collaterals, the user may select from the Others Contacted drop-down list box. (Others contacted may be Law Enforcement, Juvenile Detention Facility, Medical, Attorney Ad Litem, etc.  The four character code contains a prefix indicating the following:   
   A = APS INV, APS SVC or APS AOC
   B = CPS INV, CPS FPR, RCL INV, RCL FPR, CCL INV or CCL FPR
   C = INV or AFC
   D = INT (APS or CPS)
   G = ADO, SUB, FAD, PAD, FRE or FSU
   H = PAL
   K = ARI or ARF'
;
COMMENT ON COLUMN CAPS.CONTACT.DT_CNTCT_MNTHLY_SUMM_BEG IS 'Date of the first contact to which the monthly summary applies.'
;
COMMENT ON COLUMN CAPS.CONTACT.DT_CNTCT_MNTHLY_SUMM_END IS 'Date of the last contact to which the monthly summary applies.'
;
COMMENT ON COLUMN CAPS.CONTACT.DT_CONTACT_APPRV IS 'Date that the contact narrative was approved by the supervisor.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.CONTACT.NM_AGENCY_NAME IS 'Name of the Agency'
;
COMMENT ON COLUMN CAPS.CONTACT.IND_PERM_CROSS_CNTY_LN IS ' permission to cross county lines'
;
COMMENT ON COLUMN CAPS.CONTACT.ID_CONTACT_TCM_CLIENT IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTACT.CD_CONTACT_TCM_ELIGIBLE IS 'A code value representing the eligibility of the client for TCM services'
;
COMMENT ON COLUMN CAPS.CONTACT.CD_CONTACT_TCM_MED_SVCS IS 'A code value representing if medical services were provided to the client via TCM'
;
COMMENT ON TABLE CAPS.CONTACT_CBX IS 'Non-static table linking multiple checkbox code values to a single contact record'
;
COMMENT ON COLUMN CAPS.CONTACT_CBX.ID_CONTACT_CBX IS 'Primary key, unique ID'
;
COMMENT ON COLUMN CAPS.CONTACT_CBX.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.CONTACT_CBX.ID_CONTACT_EVENT IS 'Foreign key to contact table.'
;
COMMENT ON COLUMN CAPS.CONTACT_CBX.CD_CBX_CODE_TYPE IS 'Specifies the code type of the code value stored in the last column'
;
COMMENT ON COLUMN CAPS.CONTACT_CBX.CD_CONTACT_CBX IS 'Code value associated to the CONTACT record; represents a particular checkbox on the Contact Detail page'
;
COMMENT ON TABLE CAPS.CONTACT_NARRATIVE IS 'A blob of narrative (Formatted in MS Word) describing a contact.'
;
COMMENT ON COLUMN CAPS.CONTACT_NARRATIVE.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CONTACT_NARRATIVE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTACT_NARRATIVE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CONTACT_NARRATIVE.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the contact the worker made with each individual involved in the case.'
;
COMMENT ON COLUMN CAPS.CONTACT_NARRATIVE.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.CONTACT_VISITATION_NARRATIVE IS 'Table used to save data on the Contact Visitation Narrative'
;
COMMENT ON COLUMN CAPS.CONTACT_VISITATION_NARRATIVE.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CONTACT_VISITATION_NARRATIVE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.CONTACT_VISITATION_NARRATIVE.ID_CASE IS 'Case id'
;
COMMENT ON COLUMN CAPS.CONTACT_VISITATION_NARRATIVE.NARRATIVE IS 'The content of the narrative'
;
COMMENT ON COLUMN CAPS.CONTACT_VISITATION_NARRATIVE.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.CONTRACT IS 'A legal agreement between a provider of services and DFCS.'
;
COMMENT ON COLUMN CAPS.CONTRACT.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.CONTRACT.ID_CNTRCT_WKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTRACT.ID_CNTRCT_MANAGER IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTRACT.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.CONTRACT.ID_RSRC_ADDRESS IS 'A unique identifier for a row on the RESOURCE ADDRESS table.'
;
COMMENT ON COLUMN CAPS.CONTRACT.CD_CNTRCT_FUNC_TYPE IS 'The functional type of contract specified in the contract detail.il.'
;
COMMENT ON COLUMN CAPS.CONTRACT.CD_CNTRCT_PROGRAM_TYPE IS 'The client population that the contract was put in place to serve; that is, CPS or APS.'
;
COMMENT ON COLUMN CAPS.CONTRACT.CD_CNTRCT_PROCURE_TYPE IS 'The type of procurement used to secure the contract.'
;
COMMENT ON COLUMN CAPS.CONTRACT.CD_CNTRCT_REGION IS 'The region for which the contract has been created.'
;
COMMENT ON COLUMN CAPS.CONTRACT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT.IND_CNTRCT_BUDG_LIMIT IS 'Indicates whether a contract must have a budget limit.  If there is no budget limit, expenditures are not updated in the CONTRACT SERVICE table.'
;
COMMENT ON COLUMN CAPS.CONTRACT.IND_CNTRCTD_RSRC IS 'Contracted Resource'
;
COMMENT ON TABLE CAPS.CONTRACT_AUDIT IS 'This table audits the CONTRACT table. All elements in CONTRACT are duplicated here.  (Contains no true primary or foreign key constraints.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.ID_AUD_CONTRACT IS 'Unique identifier for a row on the CONTRACT table.  (Corresponds to ID CONTRACT.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.ID_CNTRCT_AUD_WKR IS 'A unique integer which identifies a Contract Worker. Relates to ID PERSON in the Employee Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.ID_CNTRCT_AUD_MANAGER IS 'The contract manager to whom the contract has been assigned. Relates to the ID PERSON on the Employee Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.ID_AUD_RESOURCE IS 'Foreign Key that references the CAPS_RESOURCE table (ID_RESOURCE).'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.ID_RSRC_AUD_ADDRESS IS 'A unique integer which identifies a Resources'' Address. Foreign Key to the Resource Address table. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.CD_CNTRCT_AUD_FUNC_TYPE IS 'The functional type of contract specified in the contract detail. (Audit Table).'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.CD_CNTRCT_AUD_PROGRAM_TYPE IS 'The client group that the contract was put in place to serve - e.g. CPS, APS, Residential Care, Post Adoption, STAR, and Family Casework. (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.CD_CNTRCT_AUD_PROCURE_TYPE IS 'The type of procurement used to secure the contract. (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.CD_CNTRCT_AUD_REGION IS 'The region for which the contract has been created. (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.IND_CNTRCT_AUD_BUDG_LIMIT IS 'Indicates whether a contract must have a budget limit. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_AUDIT.IND_CNTRCTD_RSRC IS 'Contracted Resource'
;
COMMENT ON TABLE CAPS.CONTRACT_COUNTY IS 'Stores the counties set up for a given contract, period, version and service.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.ID_CNCNTY IS 'Primary key for the CNCNTY table. Describes a contract county record.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.NBR_CNCNTY_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CNSVC table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.NBR_CNCNTY_VERSION IS 'The contract version number for a specific contract - part of the key combination for CNCNTY table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.NBR_CNCNTY_LINE_ITEM IS 'The contract service line item number for a specific contract - part of the key combination on CNCNTY table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.CD_CNCNTY_COUNTY IS 'Code for a county in which services can be provided for a specific resource, for a specific contract.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.ID_CNTRCT_WKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.CD_CNCNTY_SERVICE IS 'Code for a service in being provided from a contract.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.DT_CNCNTY_EFFECTIVE IS 'Date that a specific version of a contract and contracted period is effective.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY.DT_CNCNTY_END IS 'The date that a specific contract and contract period becomes ineffective, i.e., not valid.'
;
COMMENT ON TABLE CAPS.CONTRACT_COUNTY_AUDIT IS 'This table audits the CONTRACT COUNTY table and duplicates all elements in that table.  (Contains no true primary or foreign key constraints.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.ID_CNCNTY_AUD IS 'Primary Key for the CONTRACT_COUNTY table. (Corresponds to ID CNCNTY.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.ID_AUD_CONTRACT IS 'Unique identifier for a row on the CONTRACT table.  (Corresponds to ID CONTRACT.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.NBR_CNCNTY_AUD_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CONTRACT COUNTY table. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.NBR_CNCNTY_AUD_VERSION IS 'The contract version number for a specific contract - part of the key combination for CONTRACT COUNTY table. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.NBR_CNCNTY_AUD_LINE_ITEM IS 'The contract service line item number for a specific contract - part of the key combination on CONTRACT COUNTY  table. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.CD_CNCNTY_AUD_COUNTY IS 'Code for a county in which services can be provided for a specific resource, for a specific contract. (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.ID_CNTRCT_AUD_WKR IS 'A unique integer which identifies a Contract Worker. Relates to ID PERSON in the Employee Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.ID_AUD_RESOURCE IS 'Foreign Key that references the CAPS_RESOURCE table (ID_RESOURCE).'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.CD_CNCNTY_AUD_SERVICE IS 'Code for a service in being provided from a contract. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.DT_CNCNTY_AUD_EFFECTIVE IS 'Date that a specific version of a contract and contracted period is effective. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_COUNTY_AUDIT.DT_CNCNTY_AUD_END IS 'The date that a specific contract and contract period becomes ineffective, i.e., not valid. Audit Table.'
;
COMMENT ON TABLE CAPS.CONTRACT_PERIOD IS 'Stores periods set up for a particular contract. Each period covers a unique period of time. Time periods are sequential and continuous.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.ID_CNTRCT_WKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.NBR_CNPER_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CNCNTY table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.CD_CNPER_STATUS IS 'Contains the status of the contract (service hold, payment hold, both, terminated, active).'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.DT_CNPER_START IS 'Contains the start date of a specific contract period.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.DT_CNPER_TERM IS 'Contains the normal termination date of a specific contract period.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.DT_CNPER_CLOSURE IS 'Contains the end date for the contract period.  It contains the earliest of either an early termination date or the normal termination date.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.IND_CNPER_RENEWAL IS 'Indicates whether the contract period has been selected for renewal.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.IND_CNPER_SIGNED IS 'Indicates whether the contract document has been signed and whether services can be authorized.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.NBR_LEGAL_IDENTIFIER IS 'contract id for the resource.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD.TXT_TERM_COMM IS 'Early termination comments'
;
COMMENT ON TABLE CAPS.CONTRACT_PERIOD_AUDIT IS 'This table audits the CONTRACT PERIOD table and contains duplicate elements of that table.  (Contains no true primary or foreign key constraints.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.ID_AUD_CONTRACT IS 'Unique identifier for a row on the CONTRACT table.  (Corresponds to ID CONTRACT.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.ID_AUD_CNTRCT_WKR IS 'Unique identifier for a row on the PERSON and EMPLOYEE tables.  It identifies a Contract Worker.  (Relates to ID PERSON.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.NBR_CNPER_AUD_PERIOD IS 'The contract period number for a specific contract - part of the key combination on the CONTRACT PERIOD table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.CD_CNPER_AUD_STATUS IS 'Contains the status of the contract (service hold, payment hold, both, terminated, active).  (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.DT_CNPER_AUD_START IS 'Contains the start date of a specific contract period.  (Audit Table.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.DT_CNPER_AUD_TERM IS 'Contains the normal termination date of a specific contract period.  (Audit Table.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.DT_CNPER_AUD_CLOSURE IS 'Contains the end date for the contract period.  It contains the earliest of either an early termination date or the normal termination date.  (Audit Table.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.IND_CNPER_AUD_RENEWAL IS 'Indicates whether the contract period has been selected for renewal.  (Audit Table.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.IND_CNPER_AUD_SIGNED IS 'Indicates whether the contract document has been signed and whether services can be authorized.  (Audit Table.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_PERIOD_AUDIT.TXT_TERM_COMM IS 'Early Termination Comments'
;
COMMENT ON TABLE CAPS.CONTRACT_SERVICE IS 'Stores all services set up for a given contract period and version.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.ID_CNSVC IS 'The unique identifier for a row in the CONTRACT SERVICE table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.ID_CNTRCT_WKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.NBR_CNSVC_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CNSVC table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.NBR_CNSVC_VERSION IS 'The contract version number for a specific contract - part of the key combination on CNSVC table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.NBR_CNSVC_LINE_ITEM IS 'The contract service line item for a specific contract and contract version.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.CD_CNSVC_SERVICE IS 'Contains a code identifying the type of service authorized by the contract_service row.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.CD_CNSVC_PAYMENT_TYPE IS 'Contains a code identifying the contracted payment type for a specific contracted service.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.IND_CNSVC_NEW_ROW IS 'Indicates that the row has been added while the contract period was unsigned. Signing the contract period updates this row to No.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.CD_CNSVC_UNIT_TYPE IS 'Contains a code identifying the unit type specified for the CONTRACT SERVICE row.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.NBR_CNSVC_FED_MATCH IS 'The federal match amount for a specific service within a contract.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.NBR_CNSVC_LOCAL_MATCH IS 'The local match amount for a specific service within a contract.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.NBR_CNSVC_UNIT_RATE IS 'The unit rate for a specific service contracted under the unit rate payment method.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_ADMIN_ALL_USED IS 'Contains invoiced amounts debited against a specific contract for administrative allocation expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_EQUIP IS 'The budgeted contract amount for cost reimbursement equipment expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_EQUIP_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement equipment expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_FRG_BENFT IS 'The budgeted contract amount for cost reimbursement fringe benefit expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_FRG_BENFT_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement fringe benefit expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_OFF_ITEM_USED IS 'Contains invoiced amounts debited against a specific contract for offset item expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_OTHER IS 'The budgeted contract amount for cost reimbursement other expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_OTHER_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement other expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_SALARY IS 'The budgeted contract amount for cost reimbursement salary expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_SALARY_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement salary expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_SUPPLY IS 'The budgeted contract amount for cost reimbursement supply expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_SUPPLY_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement supply expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_TRAVEL IS 'The budgeted contract amount for cost reimbursement travel expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_TRAVEL_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement travel expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_UNIT_RATE IS 'The budgeted contract amount for unit rate expenditures.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE.AMT_CNSVC_UNIT_RATE_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement unit rate expenditures.'
;
COMMENT ON TABLE CAPS.CONTRACT_SERVICE_AUDIT IS 'This is the audit table for contract service. See the contract service table for functional description.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.ID_CNSVC_AUD IS 'Primary Key for the CONTACT_SERVICE table.  (Corresponds to ID CNSVC.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.ID_AUD_CONTRACT IS 'Unique identifier for a row on the CONTRACT table.  (Corresponds to ID CONTRACT.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.ID_AUD_CNTRCT_WKR IS 'Unique identifier for a row on the PERSON and EMPLOYEE tables.  It identifies a Contract Worker.  (Relates to ID PERSON.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.NBR_CNSVC_AUD_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CONTRACT SERVICE table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.NBR_CNSVC_AUD_VERSION IS 'The contract version number for a specific contract - part of the key combination on CONTRACT SERVICE table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.NBR_CNSVC_AUD_LINE_ITEM IS 'The contract service line item for a specific contract, period, version and service code.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.CD_CNSVC_AUD_SERVICE IS 'The contract service of service type for a cost reimbursement contract type. (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.CD_CNSVC_AUD_PAYMENT_TYPE IS 'The contracted payment type for a specific contracted service. (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.IND_CNSVC_AUD_NEW_ROW IS 'Indicates that the row has been added while the contract period was unsigned. Signing the contract period updates this row to No. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.CD_CNSVC_AUD_UNIT_TYPE IS 'Unit type for cost reimbursement client-specific contracts. (Audit Table)'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.NBR_CNSVC_AUD_FED_MATCH IS 'The federal match amount for a specific service within a contract. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.NBR_CNSVC_AUD_LOCAL_MATCH IS 'The local match amount for a specific service within a contract. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.NBR_CNSVC_AUD_UNIT_RATE IS 'The unit rate for a specific service contracted under the unit rate payment method. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_ADMIN_ALL_USED IS 'Contains invoiced amounts debited against a specific contract for administrative allocation expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_EQUIP IS 'The budgeted contract amount for cost reimbursement equipment expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_EQUIP_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement equipment expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_FRG_BENFT IS 'The budgeted contract amount for cost reimbursement fringe benefit expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_FRG_BENFT_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement fringe benefit expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_OFF_ITEM_USED IS 'Contains invoiced amounts debited against a specific contract for offset item expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_OTHER IS 'The budgeted contract amount for cost reimbursement other expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_OTHER_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement other expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_SALARY IS 'The budgeted contract amount for cost reimbursement salary expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_SALARY_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement salary expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_SUPPLY IS 'The budgeted contract amount for cost reimbursement supply expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_SUPPLY_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement supply expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_TRAVEL IS 'The budgeted contract amount for cost reimbursement travel expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_TRAVEL_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement travel expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_UNIT_RATE IS 'The budgeted contract amount for unit rate expenditures. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_SERVICE_AUDIT.AMT_CNSVC_AUD_UNIT_RATE_USED IS 'Contains invoiced amounts debited against a specific contract for cost reimbursement unit rate expenditures. Audit Table.'
;
COMMENT ON TABLE CAPS.CONTRACT_VERSION IS 'Stores the version for a particular contract period. Versions are sequential and continuous.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.ID_CNVER IS 'The unique identifier for the contract version.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.ID_CNTRCT_WKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.NBR_CNVER_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CNVER table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.NBR_CNVER_VERSION IS 'The contract version number for a specific contract - part of the key combination on CNVER table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.NBR_CNVER_NO_SHOW_PCT IS 'The percentage of the invoiced amount that is debited to the contract if the client does not show for an appointment.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.IND_CNVER_VER_LOCK IS 'Indicates that the version has been created and altered once before being locked for modifications on the same record.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.TXT_CNVER_COMMENT IS 'A version specific comment that describes the changes made to the contract.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.DT_CNVER_CREATE IS 'The date that the version record was created.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.DT_CNVER_EFFECTIVE IS 'The date that the version is effective.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.DT_CNVER_END IS 'The date that the version''s effectiveness ends.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.CONTRACT_VERSION_AUDIT IS 'This is the audit table for contract version. See the contract version table for functional description.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.ID_CNVER_AUD IS 'Primary Key on the CONTRACT_VERSION table.  (Corresponds to ID_CNVER.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.ID_CONTRACT_AUD IS 'Primary key on the CONTRACT table.  (Corresponds to ID CONTRACT.)'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.ID_CNTRCT_WKR_AUD IS 'A unique integer which identifies a Contract Worker. Foreign Key to the Employee Table Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.NBR_CNVER_AUD_PERIOD IS 'The contract period number for a specific contract - part of the key combination on CONTRACT VERSION table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.NBR_CNVER_AUD_VERSION IS 'The contract version number for a specific contract - part of the key combination on CONTRACT VERSION table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.NBR_CNVER_AUD_NO_SH0W_PCT IS 'No description available.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.IND_CNVER_AUD_VER_LOCK IS 'Indicates that the version has been created and altered once before being locked for modifications on the same record. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.TXT_CNVER_AUD_COMMENT IS 'A version specific comment that describes the changes made to the contract. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.DT_CNVER_AUD_CREATE IS 'The date that the version record was created. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.DT_CNVER_AUD_EFFECTIVE IS 'The date that the version is effective. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.DT_CNVER_AUD_END IS 'The date that the version''s effectiveness ends. Audit Table.'
;
COMMENT ON COLUMN CAPS.CONTRACT_VERSION_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.CORR_ACT_NARR IS 'The Narrative Table for the Corrective Action Plan.'
;
COMMENT ON COLUMN CAPS.CORR_ACT_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CORR_ACT_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CORR_ACT_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CORR_ACT_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Corrective action.'
;
COMMENT ON COLUMN CAPS.CORR_ACT_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.COST_REIM_DTL IS 'Stores detail information regarding the cost reimbursement payment line items for an invoice.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.ID_COST_REIM IS 'A unique identifier on the Cost Reim Dtl table.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.ID_COST_REIM_REVRSAL_ORIG IS 'This is the foreign key to the original line item reversed by the current line item.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_ADMIN_ALL IS 'An amount paid to a provider based on the total expenditures reimbursed, allocated to administrative costs.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_EQUIP IS 'The amount reimbursed to a provider for equipment expenditures.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_FRG_BENFT IS 'The amount reimbursed to a provider for fringe benefits expenditures.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_OFF_ITEM IS 'The total amount paid by or for a client which offsets the total amount billed by a provider.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_OTHER IS 'The amount reimbursed to a provider for expenditures that do not fall into the other categories.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_SALARY IS 'The amount reimbursed to a provider for salary expenditures.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_SUPPLY IS 'The amount reimbursed to a provider for supplies expenditures.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.AMT_COST_REIM_TRAVEL IS 'The amount reimbursed to a provider for travel expenditures.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.CD_COST_REIM_INVO_DISPTN IS 'Used to hold a code indicating the status of a particular line item.  A value of ''RV'' indicates the line has been reversed by another line.  A value of null indicates the line stands as is.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.CD_COST_REIM_SERVICE IS 'Contains the service code for the cost reimbursement record.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.CD_COST_REIM_LI_TYPE IS 'Contains a system generated code indicating the type of line item entry (original, adjustment, or reversal).'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.IND_COST_REIM_REJ_ITM IS 'Indicates whether or not the Cost Reim dtl budget item has been rejected.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.CD_COST_REIM_PAC IS 'Not used by the system.  The PAC codes are stored in related DELVRD SVC DTL rows.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.CD_COST_REIM_OBJ_CODE IS 'Not used by the system.  The object codes are stored in related DELVRD SVC DTL rows.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.NBR_COST_REIM_CSLI IS 'Contains the contract services line item number.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.NBR_COST_REIM_UNIT_QTY IS 'Indicates the number of units of service delivered for a particular line item.  It is the sum the units of service from related DELVRD SVC DTL rows.'
;
COMMENT ON COLUMN CAPS.COST_REIM_DTL.NBR_CNTRCT_PRD IS 'Contains a number identifying the period for a specific contract.  Each period covers a specific time frame.'
;
COMMENT ON TABLE CAPS.COUNTY_BUDGET_LIMIT IS 'Holds County Budget Limit Data'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.ID_COUNTY_BUDGET_LIMIT IS 'County Budget Limt ID - primary key.'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.CD_COUNTY IS 'County Code'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.CD_PROGRAM IS 'Program Code'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.NBR_FISCAL_YEAR IS 'Fiscal Year'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.AMT_BUDGET_LIMIT IS 'Budget Limit'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.AMT_SPENT IS 'Amount Spent'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.AMT_OBG IS 'Amount Obligated'
;
COMMENT ON COLUMN CAPS.COUNTY_BUDGET_LIMIT.AMT_BALANCE IS 'Remaining Balance'
;
COMMENT ON TABLE CAPS.CP_AOP_NARR IS 'The "Additional Objectives of Placement" Child Plan Topic Narr Table'
;
COMMENT ON COLUMN CAPS.CP_AOP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_AOP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_AOP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_AOP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Additional Objectives of Placement Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_AOP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_AOP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_APA_NARR IS 'The "Appropriateness and Safety of Placement" Adoption Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_APA_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_APA_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_APA_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_APA_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_APA_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_APA_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_APP_NARR IS 'The "Appropriateness and Safety of Placement" Child Plan Topic Narr Table'
;
COMMENT ON COLUMN CAPS.CP_APP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_APP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_APP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_APP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Appropriateness of Placement Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_APP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_APP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_APR_NARR IS 'The "Appropriateness of Services" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_APR_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_APR_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_APR_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_APR_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Appropriateness of Services Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_APR_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_APR_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_ASF_NARR IS 'The "ASFA situation requiring documentation" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_ASF_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_ASF_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_ASF_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_ASF_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "ASFA situation requiring documentation" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_ASF_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_ASF_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_CHG_NARR IS 'The "Child''s Cultural Heritage" Child Plan Topic Narr table.'
;
COMMENT ON COLUMN CAPS.CP_CHG_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_CHG_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_CHG_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_CHG_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_CHG_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_CHG_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_CNP_NARR IS 'The "Continued Need for Placement" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_CNP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_CNP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_CNP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_CNP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Continued Need for Placement Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_CNP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_CNP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_CPL_NARR IS 'The "Concurrent Plan" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_CPL_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_CPL_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_CPL_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_CPL_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Concurrent Plan" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_CPL_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_CPL_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_CTP_NARR IS 'The "Compliance with Tasks on Previous Plan" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_CTP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_CTP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_CTP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_CTP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Compliance with Tasks on Previous Plan" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_CTP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_CTP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_DAP_NARR IS 'The "Developmental/Educational Needs Planning (ADO)" Child Plan Topic Narr table.'
;
COMMENT ON COLUMN CAPS.CP_DAP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_DAP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_DAP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_DAP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_DAP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_DAP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_DSC_NARR IS 'The "Behavior Management" Child Plan Topic Narr.'
;
COMMENT ON COLUMN CAPS.CP_DSC_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_DSC_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_DSC_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_DSC_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Discipline Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_DSC_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_DSC_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_DVL_NARR IS 'The "Developmental/Educational Needs (ADO)" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_DVL_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_DVL_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_DVL_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_DVL_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Developmental/Educational Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_DVL_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_DVL_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_DVN_NARR IS 'The "Developmental Needs" Child Plan Topic Narr.'
;
COMMENT ON COLUMN CAPS.CP_DVN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_DVN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_DVN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_DVN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Developmental Needs Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_DVN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_DVN_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_DVP_NARR IS 'The "Developmental Needs Planning" Child Plan Topics Narr table.'
;
COMMENT ON COLUMN CAPS.CP_DVP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_DVP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_DVP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_DVP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_DVP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_DVP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_EDN_NARR IS 'The "Educational Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_EDN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_EDN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_EDN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_EDN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Educational Needs Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_EDN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_EDN_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_EDP_NARR IS 'The "Educational Needs Planning" Child Plan Topics Narr table.'
;
COMMENT ON COLUMN CAPS.CP_EDP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_EDP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_EDP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_EDP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_EDP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_EDP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_EOC_NARR IS 'The "Extent of Compliance" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_EOC_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_EOC_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_EOC_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_EOC_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Extent of Compliance Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_EOC_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_EOC_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_FAM_NARR IS 'The "Family Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_FAM_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_FAM_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_FAM_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_FAM_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Family Needs Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_FAM_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_FAM_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_FAN_NARR IS 'The "Family Needs (ADO)" Adoption Child Plan Topic Narr table.'
;
COMMENT ON COLUMN CAPS.CP_FAN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_FAN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_FAN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_FAN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Family Needs (Adoption) Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_FAN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_FAN_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_FMP_NARR IS 'The "Family Needs Planning" Child Plan Topics Narr table.'
;
COMMENT ON COLUMN CAPS.CP_FMP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_FMP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_FMP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_FMP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_FMP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_FMP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_FNP_NARR IS 'The "Family Needs Planning (ADO)" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_FNP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_FNP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_FNP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_FNP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_FNP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_FNP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_IBP_NARR IS 'The "Interests, Behavior, and Personality" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_IBP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_IBP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_IBP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_IBP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Interests, Behavior, and Personality Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_IBP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_IBP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_ICH_NARR IS 'The "Initial Child History" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_ICH_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_ICH_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_ICH_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_ICH_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Initial Child History" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_ICH_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_ICH_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_IGH_NARR IS 'The "Initial Genetic History" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_IGH_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_IGH_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_IGH_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_IGH_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Initial Genetic History Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_IGH_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_IGH_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_ISH_NARR IS 'The "Initial Family/Genetic History" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_ISH_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_ISH_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_ISH_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_ISH_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Initial Social History" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_ISH_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_ISH_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_MDN_NARR IS 'The "Medical and Dental Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_MDN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_MDN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_MDN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_MDN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Medical ad Dental Needs child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_MDN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_MDN_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_MDP_NARR IS 'The "Medical and Dental Needs Planning" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_MDP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_MDP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_MDP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_MDP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_MDP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_MDP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_OOP_NARR IS 'The "Objectives of Placement" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_OOP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_OOP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_OOP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_OOP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Objectives of Placement Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_OOP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_OOP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PAL_NARR IS 'The "PAL Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PAL_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PAL_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PAL_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PAL_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the PAL Needs Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_PAL_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PAL_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PAP_NARR IS 'The "PAL Needs Planning" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_PAP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PAP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PAP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PAP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_PAP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PAP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PCH_NARR IS 'The "Plans for Preserving Child''s Cultural Heritage" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_PCH_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PCH_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PCH_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PCH_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_PCH_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PCH_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PDO_NARR IS 'The "Post Discharge Objectives" Child plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PDO_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PDO_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PDO_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PDO_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Post Discharge Objectives" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_PDO_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PDO_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PER_NARR IS 'The "Progress/Efforts Made Toward Permanency" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PER_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PER_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PER_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PER_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Achieving Permanency Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_PER_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PER_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PFC_NARR IS 'The "Plans for Future Visitation" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_PFC_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PFC_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PFC_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PFC_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_PFC_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PFC_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PHP_NARR IS 'The "Special Physical Needs Planning" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_PHP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PHP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PHP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PHP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_PHP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PHP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PHY_NARR IS 'The "Special Physical Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PHY_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PHY_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PHY_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PHY_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Special Physical needs Child Plan Topic'
;
COMMENT ON COLUMN CAPS.CP_PHY_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PHY_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PLP_NARR IS 'The "Plans to Address Permanency" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PLP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PLP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PLP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PLP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Plans to Address Permanency" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_PLP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PLP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PLS_NARR IS 'The "Plans to Address Safe and Proper Care" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PLS_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PLS_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PLS_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PLS_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Plans to Address Safe and Proper Care" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_PLS_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PLS_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PRA_NARR IS 'The "Progress/Efforts Made Toward Permanency" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PRA_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PRA_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PRA_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PRA_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Progress/Efforts Made Toward Permanency" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_PRA_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PRA_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PSP_NARR IS 'The "Psychological Needs Planning" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_PSP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PSP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PSP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PSP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_PSP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PSP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PSY_NARR IS 'The "Psychological Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_PSY_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PSY_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PSY_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PSY_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Psychological Needs Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_PSY_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PSY_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_PVP_NARR IS 'The "Previous Placements Not Involving DFCS" Child Plan Topic Narr table.'
;
COMMENT ON COLUMN CAPS.CP_PVP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_PVP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_PVP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_PVP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Previous Placement Not Involving PRS Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_PVP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_PVP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_REC_NARR IS 'The "Recreational Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_REC_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_REC_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_REC_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_REC_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Recreational Needs" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_REC_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_REC_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_REP_NARR IS 'The "Recreational Needs Planning" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_REP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_REP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_REP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_REP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_REP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_REP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_SAE_NARR IS 'The "Social and Emotional" (Adoption) Child Plan Topic narrative table.'
;
COMMENT ON COLUMN CAPS.CP_SAE_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_SAE_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_SAE_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_SAE_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Social and Emotional Needs" (Adoption) Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_SAE_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_SAE_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_SAP_NARR IS 'The "Social and Emotional Needs Planning (ADO)" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_SAP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_SAP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_SAP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_SAP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_SAP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_SAP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_SEN_NARR IS 'The "Social and Emotional Needs" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_SEN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_SEN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_SEN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_SEN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Social and Emotional Needs" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_SEN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_SEN_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_SEP_NARR IS 'The "Social and Emotional Needs Planning" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_SEP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_SEP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_SEP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_SEP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_SEP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_SEP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_SSC_NARR IS 'The "Support Services to Caregiver" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_SSC_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_SSC_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_SSC_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_SSC_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Support Services to Caregiver" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_SSC_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_SSC_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_SSF_NARR IS 'The "Support Services for Family" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_SSF_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_SSF_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_SSF_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_SSF_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Support Services for Family" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_SSF_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_SSF_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_SUP_NARR IS 'The "Supervision" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_SUP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_SUP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_SUP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_SUP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Supervision" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_SUP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_SUP_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_TOPIC_INSTRUCTION IS 'Instructions on what the user should put into the narrative for each Child Plan topic..'
;
COMMENT ON COLUMN CAPS.CP_TOPIC_INSTRUCTION.CD_CP_TOPIC IS 'This is the topic code that references the child plan type topic codes table to obtain the detail topics to be addressed for a child plan type.  The 3 character code can be used to find the narrative table in which that topic is stored in the database.  For example, the code ''DVL'', data is stored in the child plan topic narrative table called ''CP_DVL_NARR''.'
;
COMMENT ON COLUMN CAPS.CP_TOPIC_INSTRUCTION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_TOPIC_INSTRUCTION.TXT_CP_TOPIC_INST IS 'Instructions to the worker informing them of what type of information to enter regarding the current guide topic.'
;
COMMENT ON TABLE CAPS.CP_TPL_NARR IS 'The "Type of Placement" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_TPL_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_TPL_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_TPL_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_TPL_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Type of Placement" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_TPL_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_TPL_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_TRM_NARR IS 'The "Treatment Objectives" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_TRM_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_TRM_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_TRM_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_TRM_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Treatment Objectives" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_TRM_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_TRM_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_TRV_NARR IS 'The "Travel" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_TRV_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_TRV_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_TRV_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_TRV_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Travel" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_TRV_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_TRV_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_VIS_NARR IS 'The "Visitation Summary" Child Plan Topics narr table.'
;
COMMENT ON COLUMN CAPS.CP_VIS_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_VIS_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_VIS_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_VIS_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.CP_VIS_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_VIS_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CP_WOR_NARR IS 'The "Worker''s Role" Child Plan Topic Narr Table.'
;
COMMENT ON COLUMN CAPS.CP_WOR_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CP_WOR_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CP_WOR_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CP_WOR_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the "Worker Role" Child Plan Topic.'
;
COMMENT ON COLUMN CAPS.CP_WOR_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.CP_WOR_NARR.DT_NEW_USED IS 'Date modified of previous copy.'
;
COMMENT ON TABLE CAPS.CPS_CHECKLIST IS 'Contains the services and referrals information, along with the CPS_CHECKLIST_ITEM table,  that were provided to the family during the Investigation  and is used to document the family''s response of acceptance or non-acceptance of the services and referrals.  If services and referrals were not provided, it is used to document the reason they were not.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.ID_CPS_CHECKLIST IS 'Unique identifier for a record in the CPS_CHECKLIST table.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.DT_FIRST_REFERRAL IS 'The date that services were first offered to the family.  This date is not prior to the date of initial attempted contact or contact in the investigation.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.IND_REFERRAL IS 'Indicates whether or not services or referrals were provided to the family during the investigation.  Y= Services were provided, N=No services/referrals'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.CD_FAMILY_RESP IS 'Family''s response to the services and referrals.  1=At least one family member agreed to seek/accept one or more services/resource, 2= No family member agreed to seek or accept any of the services/resources offered, 3=Other (explain in comments)'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST.TXT_COMMENTS IS 'Comments describing the income, resource, or special conditions  On the CPS_CHECKLIST table, this information explains why the "No Services/Referrals" check box was use or why the "Other-explain in Comment" was selected from the Services/Referrals list or from the family''s response.'
;
COMMENT ON TABLE CAPS.CPS_CHECKLIST_ITEM IS 'Services and referrals provided to the family during the investigation.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST_ITEM.ID_CPS_CHECKLIST_ITEM IS 'Unique identifier of a record in the CPS_CHECKLIST_ITEM table.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST_ITEM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST_ITEM.ID_CPS_CHECKLIST IS 'Unique identifier for a record in the CPS_CHECKLIST table.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST_ITEM.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST_ITEM.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST_ITEM.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.CPS_CHECKLIST_ITEM.CD_SRVC_REFERRED IS 'Services/Referrals Checklist.'
;
COMMENT ON TABLE CAPS.CPS_CONCLUSION_NARR IS 'Contains the narrative blob for the CPS Conclusion Narrative.'
;
COMMENT ON COLUMN CAPS.CPS_CONCLUSION_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CPS_CONCLUSION_NARR.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.CPS_CONCLUSION_NARR.ID_CASE IS 'The Case this narrative is associated with'
;
COMMENT ON COLUMN CAPS.CPS_CONCLUSION_NARR.NARRATIVE IS 'Blob containing the actual narrative'
;
COMMENT ON COLUMN CAPS.CPS_CONCLUSION_NARR.ID_DOCUMENT_TEMPLATE IS 'The ID of the Document Template used by the narrative blob'
;
COMMENT ON TABLE CAPS.CPS_INVST_DETAIL IS 'Details surrounding a CPS Investigation.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.ID_CPS_INVST_STAGE IS 'Foreign key that stores the Id_Stage from the stage table for the investigation stage.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_CPS_INVST_DTL_COMPLT IS 'Date the CPS Investigation completed.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_CPS_INVST_DTL_BEGUN IS 'This is the date the Investigation was begun; this date is actually the date the first contact was recorded.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_CPS_INVST_SAFETY_PLN IS 'This field is used to indicate when a Safety Plan has been completed for the CPS investigation. This field is used on the CPS Investigation Conclusion window. If the user wishes to view the details of the Safety Plan, (s)he needs to access the Safety Plan window.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_CPS_INVST_DTL_RA_NA IS 'This field is used to indicate when a Risk Assessment is not available for the CPS investigation. This field is used on the CPS Investigation Conclusion window.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_CPS_INVST_DTL_ASSIGNED IS 'The date that the investigation/stage was assigned to an investigation worker. Filled by Date Emp Sit Link for the first assignment of an investigation.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_CPS_INVST_DTL_INTAKE IS 'Date that the information was received by Intake. Filled by Date Incoming Call for the first intake for the investigation.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_CPS_INVST_DTL_FAM_INCM IS 'Contains families annual income.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_CPS_INVST_DTL_EA_CONCL IS 'Indicates whether a family is eligible for Emergency Assistance or not.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_CPS_INVST_DTL_OVRLL_DISPTN IS 'The overall disposition determined for an investigation.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_CPS_INVST_DTL_ABBRV IS 'Indicator if the investigation was an abbreviated investigation.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_CPS_LE_JNT_CNTCT IS 'A three-value element that indicates if a case was investigated or initally contacted jointly by CPS and Law Enforcement (LE).'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_REASON_NO_JNT_CNTCT IS 'Reason why CPS and Law Enforcement (LE) did not jointly investigate the case or did not make the initial contact together.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.TXT_REASON_NO_JNT_CNTCT IS 'Comments regarding joint investigation or initial joint contact of the case by CPS and Law Enforcement (LE).'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_VICTIM_TAPED IS 'Indicates where or not the victim was audiotaped/videotaped as part of the investigation.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_VICTIM_TAPED IS 'Agency-approved "good-cause" exceptions to  taping the victim.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.TXT_VICTIM_TAPED IS 'Comments about why the victim was or was not audio or videotaped.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_CNCLSN_RISK_FND IS 'Overall risk finding.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_CNCLSN_RISK_LVL IS 'Overall level of risk.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.TXT_OVRLL_CASE_DISPTN IS 'Overall disposition and description of the investigation.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_OVERRIDE IS 'Date the supervisor overrode the investigation decision.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_OVERRIDE_OVERLL_FIND IS 'Override risk finding.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.CD_OVERRIDE_RISK_LVL IS 'override level of risk.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.TXT_OVERRIDE_COMMENTS IS 'Comments about why the supervisor overrode the decision.'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_SPE_INVST_PLACE_PROV IS 'Is this a special investigation on a placement provider or facility'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_FOST_PRNT_NOTIFIED IS 'Was the foster parent notified of the right to have an advocate present?'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_FOST_PRNT_NOTIFIED IS 'Date the foster parent was notified of the right to have an advocate present'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.IND_ST_OFF_NOTIFY_RMV_CHILD IS 'Has notification been given to the state office of the removal of child(ren) following initial investigative contact?'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_ST_OFF_NOTIFY_RMV_CHILD IS 'Date the state office was notified of removal of child(ren)'
;
COMMENT ON COLUMN CAPS.CPS_INVST_DETAIL.DT_ST_OFF_ADVICE_RMV_CHILD IS 'Date state office advised  all invovled counties, providers, and agencies to remove children from the provider''s care'
;
COMMENT ON TABLE CAPS.CRIMINAL_HIST_NARR IS 'Stores the narrative off of the criminal history table.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HIST_NARR.ID_CRIM_HIST IS 'A unique identifier to the criminal history.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HIST_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HIST_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Criminal History records from DPS.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HIST_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.CRIMINAL_HISTORY IS 'Stores criminal history information from search, based on results from DPS/Criminal History Receive Interface.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HISTORY.ID_CRIM_HIST IS 'A unique identifier to the criminal history.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HISTORY.ID_REC_CHECK IS 'A unique identifier to the Records Check table.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HISTORY.CD_CRIM_HIST_ACTION IS 'This code is used to indicate if a criminal history row is accepted (ACP), rejected (REJ), or no action taken (NON).  (Needs a codes table.  Currently being researched.)'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HISTORY.NM_CRIM_HIST_RETURNED IS 'The name returned from DPS when a hit was returned from a Criminal History Check.'
;
COMMENT ON COLUMN CAPS.CRIMINAL_HISTORY.TXT_CRIM_HIST_CMNTS IS 'Any comments the user wishes to enter about the specifics of the Criminal History Check results.'
;
COMMENT ON TABLE CAPS.CSUP_PAST_REFERRAL IS 'past supervisor referrals.'
;
COMMENT ON COLUMN CAPS.CSUP_PAST_REFERRAL.ID_CSUP_PAST_REFERRAL IS 'Unique identifier for Past Referral.'
;
COMMENT ON COLUMN CAPS.CSUP_PAST_REFERRAL.ID_PERSON IS 'Id of child for whom the referral was sent.'
;
COMMENT ON COLUMN CAPS.CSUP_PAST_REFERRAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CSUP_PAST_REFERRAL.DT_PAST_REFERRAL IS 'Date of the past referral.'
;
COMMENT ON TABLE CAPS.CSUP_REFERRAL IS 'Supervisor referrals.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_CSUP_REFERRAL IS 'Unique row id for successful referrals.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.DT_REFERRAL IS 'Date this referral sent.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_PERSON IS 'Id of child for whom the referral was sent.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_ELIG_EVENT IS 'A unique identifier to the event table located on the eligibility table.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_PLOC_EVENT IS 'The unique identifier for an event on the Person level of care table.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_LEGAL_STATUS_EVENT IS 'id_event from the cursor view for the  LEGAL_STATUS cursor.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.AMT_RATE IS 'Rate, if found- default 0.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.CD_INITIAL_SEND IS 'Code for the initial send of the referral.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.CD_LEGAL_STAT_CNTY IS 'The county of legal status is displayed here.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.CD_PERSON_SEX IS 'Code representing an individual''s sex.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.CD_PLOC_CHILD IS 'Code representing the level of care for a child.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.CD_SVC_CODE IS 'Service code, if found.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.DT_PERSON_BIRTH IS 'A date indicating the date of birth of an individual.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.ID_ELIG_WORKER IS 'Id of the eligibility worker.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.IND_COURT_ORDERED IS 'Indicates whether or not this task or service was ordered by the court.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.NM_ELIG_WORKER IS 'Worker who sent the referral.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.NM_PERSON_FULL IS 'Full name of an individual.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.TXT_LEGAL_STAT_CAUSE_NBR IS 'The cause number is recorded here.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.TXT_LEGAL_STAT_COURT_NBR IS 'The court number on the Legal Status window.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.TXT_PERSON_SSN IS 'Child''s SSN.'
;
COMMENT ON COLUMN CAPS.CSUP_REFERRAL.TXT_PROGRAM_TYPE IS 'Text describing the type of program for the referral.'
;
COMMENT ON TABLE CAPS.DATAFIX_AUDIT_TABLE IS 'Audit table used by the DataFix process to keep track of what data fixes have been applied to the database and when.'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ID_DATAFIX IS 'Primary key of table - generated from sequence'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.SCRIPT_NAME IS 'Name of the script containing the datafix.'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.LOGFILE_NAME IS 'Name of the log file containing output from the datafix run'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ID_DEFECT_CQ IS 'Id of the defect in ClearQuest associated with this datafix (datafix addresses)'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ERROR_CATEGORY IS 'General category or type of error or issue the datafix is addressing.'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.DATAFIX_DESC IS 'Description of the data fix.'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.DT_START IS 'Date/time the script execution started'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.DT_COMPLETED IS 'Date execution of the script completed.'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ID_CASE IS 'Optional case ID that datafix corrects.'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ID_PERSON IS 'Optional ID of the person this datafix is associated with'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ID_EVENT IS 'Optional event id associated with this data fix'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ID_RESOURCE IS 'Optional Resource ID associated with this datafix'
;
COMMENT ON COLUMN CAPS.DATAFIX_AUDIT_TABLE.ID_STAGE IS 'Optional Stage ID associated with this data fix.'
;
COMMENT ON TABLE CAPS.DELETE_CALL IS 'Temporary table used in the PURGE process for purging calls (stage ids)  that have been disposed over 180 days and contains the status of the purge.  All records are copied to the DELETE_CALL_HSTRY table for a complete history of purges.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DELETE_CALL_HSTRY IS 'Used in the PURGE process for purging calls (stage ids)  that have been disposed over 180 days and contains the status of the purge.  Contains a history of what was purged using the DELETE_CALL table.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_HSTRY.ID_DELETE_CALL_HSTRY IS 'Unique identifier of a record in the DELETE_CALL_HSTRY table.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_HSTRY.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_HSTRY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DELETE_CALL_PERSON IS 'Used in the PURGE process for purging person related to the calls that have been disposed over 180 days and contains the status of the purge. All records are copied to the DELETE_CALL_PERSON_HSTRY table for a complete history of purges.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_PERSON.ID_PERSON IS 'Id of child for whom the referral was sent.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_PERSON.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_PERSON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DELETE_CALL_PERSON_HSTRY IS 'Used in the PURGE process for purging persons related to the calls (stage ids)  that have been disposed over 180 days and contains the status of the purge.  Contains a history of all records that were  purged using the DELETE_CALL_PERSON  table.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_PERSON_HSTRY.ID_PERSON IS 'Id of child for whom the referral was sent.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_PERSON_HSTRY.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.DELETE_CALL_PERSON_HSTRY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DELETE_CASE IS 'Temporary table used in the PURGE process for purging cases that meet the criteria established by CPS for purging.  All records are copied to the DELETE_CASE_HSTRY table for a complete history of purges.  Associated with RECORDS_RETENTION.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE.ID_DELETE_CASE IS 'Contains a unique identifier for a row on the DELETE CASE table.  It is the same value as ID CASE from the CAPS CASE table.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE.IND_DELETE_STATUS IS '0=scheduled to purge,
1=processed sucessfully,
2=NOT processed successfully,
3=person not deleted; involved in other,
7=merged to/from case, for manual bypass,
9=manual control to bypass selection of row'
;
COMMENT ON TABLE CAPS.DELETE_CASE_HIST IS 'Used in the PURGE process for purging cases that meet the criteria established by CPS for purging.  Contains a history of all records purged using the DELETE_CASE table.  Associated with RECORDS_RETENTION.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_HIST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_HIST.ID_CASE IS 'Identifier for the case being purged.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_HIST.ID_PERSON IS 'Unqiue identifier for Person associated with case being purged,'
;
COMMENT ON TABLE CAPS.DELETE_CASE_HSTRY IS 'Used in the PURGE process for purging cases that meet the criteria established by CPS for purging.  Contains a history of all records purged using the DELETE_CASE table.  Associated with RECORDS_RETENTION.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_HSTRY.ID_DELETE_CASE IS 'Contains a unique identifier for a row on the DELETE CASE table.  It is the same value as ID CASE from the CAPS CASE table.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_HSTRY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DELETE_CASE_PERSON IS 'Temporary table used in the PURGE process for purging persons associated with cases that meet the criteria established by CPS for purging.  All records are copied to the DELETE_CASE_PERSON_HSTRY table for a complete history of purges.  Associated with RECORDS_RETENTION.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON.ID_CASE_PERSON IS 'Unique sequence identifier for the DELETE CASE PERSON  table, which is system generated.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON.ID_MERGED_PERSON IS 'The ID for the PERSON merged, used in the DELETE CASE PERSON table.'
;
COMMENT ON TABLE CAPS.DELETE_CASE_PERSON_HSTRY IS 'Used in the PURGE process for purging persons associated with cases that meet the criteria established by CPS for purging.  Contains a complete history of all records purged using the DELETE_CASE_PERSON table.  Associated with RECORDS_RETENTION.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON_HSTRY.ID_DELETE_CASE_PERSON_HSTRY IS 'Contains a unique identifier for a record in the DELETE_CASE_PERSON_HSTRY table.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON_HSTRY.ID_CASE_PERSON IS 'Unique sequence identifier for the DELETE CASE PERSON  table, which is system generated.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON_HSTRY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON_HSTRY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON_HSTRY.ID_PERSON IS 'Id of child for whom the referral was sent.'
;
COMMENT ON COLUMN CAPS.DELETE_CASE_PERSON_HSTRY.ID_MERGED_PERSON IS 'The ID for the PERSON merged, used in the DELETE CASE PERSON table.'
;
COMMENT ON TABLE CAPS.DELETE_EPL_HIST IS 'Used in the PURGE process for purging cases that meet the criteria established by CPS for purging.  Contains a history of all records purged from EVENT_PERSON_LINK table.  Associated with RECORDS_RETENTION.'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.ID_EVENT_PERS_LINK IS 'Unique identifier of the event person link being purged,'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.DT_LAST_UPDATE IS 'Date of insert or last update of this record'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.ID_PERSON IS 'Unqiue Identifier for person in Person table.'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.ID_EVENT IS 'Unqiue identifier for Event in Event table.'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.ID_CASE IS 'Unique identifier of Case in Case table.'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.CD_FAM_PLAN_PERM_GOAL IS 'A code which identifies the child''s permanency goal.  Linked to the CCPPRMGL codes table.'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.DT_FAM_PLAN_PERM_GOAL_TARGET IS 'Target date for reaching the child''s permanency goal.'
;
COMMENT ON COLUMN CAPS.DELETE_EPL_HIST.IND_CAREGIVER IS 'Caregiver Checkbox'
;
COMMENT ON COLUMN CAPS.DELETE_RESOURCES_HIST.ID_DELETE_RESOURCES_HIST IS 'Unqiue identifier for Deleted Resource Hist record.'
;
COMMENT ON COLUMN CAPS.DELETE_RESOURCES_HIST.DT_LAST_UPDATE IS 'Date record was inserted or last updated.'
;
COMMENT ON COLUMN CAPS.DELETE_RESOURCES_HIST.ID_RESOURCE IS 'Unqiue identifier of resource in the CAPS_RESOURCE table.'
;
COMMENT ON TABLE CAPS.DELVRD_SVC_DTL IS 'Detail information for Delivered Service Invoices.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.ID_SVC_DTL IS 'A unique identifier for a row on the DELVRD SVC DTL table.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.ID_SVC_DTL_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_COUNTY IS 'Contains the county code that corresponds to the service code for a particular line item.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.ID_SVC_DTL_REVRSAL_ORIG IS 'Contains the ID of the original line item reversed by the current line item.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.  This is the ID of the foster care or adoption subsidy resource with which a child is placed.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.ID_SVC_AUTH_DTL IS 'A unique identifier for a row on the SVC AUTH DTL table.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.AMT_SVC_DTL_FEE_PAID IS 'The amount paid to a provider by a client or on behalf of a client by a third party resource, such as Medicaid or private insurance.  Currently, these fees are related only to delivered service, non-foster care invoices.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.AMT_SVC_DTL_INCOME IS 'The amount of a child''s income used to offset the cost of care.  Currently used only for foster care services.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.AMT_SVC_DTL_UNIT_RATE IS 'The unit rate applied to a particular line item.  Depending on the type of payment, the rate may come from the contract_service table, the foster_care_rate table, or the adoption_subsidy table.  It may also be calculated, based on data in the svc_auth_detail table, or may be calculated based on data in the cost_reim_dtl table.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_INVO_DISPTN IS 'Contains a code indicating the status of a particular line item.  A value of ''RV'' indicates the line has been reversed by another line.  A value of null indicates the line stands as is.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_LI_TYPE IS 'Contains a system generated code indicating the type of line item entry (original, adjustment, or reversal).'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_OBJ_CODE IS 'Contains the Object Code for the Line Item. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_OBJ_CERT IS 'Contains the certified funds object code for the Line Item. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_OBJ_PURE IS 'Contains the pure state dollars object code for the Line Item. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_PAC IS 'Contains the PAC (Program Activity Code) for the particular service code. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_SERVICE IS 'Contains a code that indicates the service that was delivered.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_UNIT_TYPE IS 'Contains a code that indicates the unit type of a particular service - hour, day, session, etc.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.IND_SVC_DTL_REJ_ITEM IS 'Indicates whether or not a line item is rejected after being subjected to a validation procedure.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.MO_SVC_DTL_SVC_MONTH IS 'Contains the month that a particular service was delivered.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_SVC_DTL_CSLI IS 'Contains the Contract Services Line Item number.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_SVC_DTL_FROM_DAY IS 'Contains the start day of service for the row.  (Only used for foster care services.)'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_SVC_DTL_OBJ_CERT IS 'A percentage (or factor) applied against the line amount to determine the state share of the expense.  The public agency to whom payment is made "certifies" that funds are available in their budget. Used for TYC and JPC invoices only.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_SVC_DTL_OBJ_CODE IS 'A percentage (or factor) that indicates the share of the expense that can be matched with federal funds, or, in the case of JPC and TYC, the federal share.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_SVC_DTL_OBJ_PURE IS 'A percentage (or factor) associated with pure state dollars.  When the percentage is applied against the line amount, the result represents the amount of state dollars that cannot be matched with federal dollars.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_SVC_DTL_TO_DAY IS 'Contains the last day of service for the row.  (Only used for foster care services.)'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_SVC_DTL_UNIT_QTY IS 'Contains the number of units of service delivered.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.YR_SVC_DTL_SVC_YEAR IS 'Contains the service year for a particular line item.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_SVC_DTL_FUND_STREAM IS 'funding stream type.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_CNTRCT_PRD IS 'Contract period number.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_STG_FND IS 'funding type.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_STG_TYP_FND IS 'funding stage type.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_STG_USD IS 'us dollar per stage.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.CD_STG_TYP_USD IS 'us dollar per stage type.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.AMT_SMILE_PAID IS 'Amount paid via the SMILE accounting system for this line item.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.NBR_CHECK IS 'Check number issued by SMILE to pay this line item.'
;
COMMENT ON COLUMN CAPS.DELVRD_SVC_DTL.DT_PAID IS 'Date that payment for this line item was made - comes from the SMILE interface.'
;
COMMENT ON TABLE CAPS.DEVELOPMENT_HISTORY IS 'A history of a child''s developmental characteristics (birth and development, feeding history, habits) i.e. age the child first talked, age the child sat up, feeding problems, sleeping habits.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.ID_DEVTL_HIST IS 'A unique integer which defines a Developmental History. * NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.CD_DEVTL_HIST IS 'No description available.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.DT_DEVTL_HIST_ENTERED IS 'Date Person''s Developmental History was entered into the System.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.NBR_DEVTL_HIST_MONTH IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.NBR_DEVTL_HIST_YEAR IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.DEVELOPMENT_HISTORY.TXT_DEVTL_HIST_DESC IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON TABLE CAPS.DHS_ELIGIBILITY IS 'This is a static lookup table that contains DHS eligibility codes and descriptions.'
;
COMMENT ON COLUMN CAPS.DHS_ELIGIBILITY.ID_DHS_ELIGIBILITY IS 'Contains a unique identifier for a row on the DHS ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.DHS_ELIGIBILITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DHS_ELIGIBILITY.CD_DHS_ELIG_CODE IS 'Contains a combination of the DHS Case Code, Med Coverage, SIG (Status in Group), Case Status, Program Type and Case Category.  This code is not linked to a code type.  The decode an be read either in the form of another code (CD DHS ELIG DECODE in same table) or in the form of the programs/federal titles involved (TXT DHS ELIG DESC in same table).'
;
COMMENT ON COLUMN CAPS.DHS_ELIGIBILITY.CD_DHS_ELIG_DECODE IS 'Contains an eligibility code that represents the combination found in CD DHS ELIG CODE.'
;
COMMENT ON COLUMN CAPS.DHS_ELIGIBILITY.TXT_DHS_ELIG_DESC IS 'A description (or decode) of the DHS eligibility code.'
;
COMMENT ON TABLE CAPS.DHS_RESULT_CODE IS 'This is a static lookup table that contains a list of DHS eligibility code combinations, and a resulting code that is then inserted into the PERSON ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.DHS_RESULT_CODE.ID_DHS_RESULT_CODE IS 'Contains a unique identifier for a row on the DHS RESULT CODE table.'
;
COMMENT ON COLUMN CAPS.DHS_RESULT_CODE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DHS_RESULT_CODE.CD_DHS_RESULT_COMBO_CODE IS 'Contains a list, in each row, of DHS eligibility codes that may be received from DHS for one individual.'
;
COMMENT ON COLUMN CAPS.DHS_RESULT_CODE.CD_DHS_ELIG_RESULT_CODE IS 'Contains a resulting eligibility code that is inserted into the PERSON ELIGIBILITY table for an individual.'
;
COMMENT ON TABLE CAPS.DILIGENT_SEARCH IS 'Holds Diligent Search Information - required by GA State law to ensure all possible relatives have been contacted.'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.ID_DILIGENT_SEARCH IS 'Diligent Search ID'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.IND_INC_DLGNT IS 'Include in diligent search'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.IND_CRTKR_PRIOR IS 'Caretaker prior to removal'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.TXT_DESC_REM IS 'Describe why removed'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.CD_REF_TYPE IS 'Referral Type'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.TXT_OTHER_DESC IS 'If other, describe.'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.TXT_REF_NAME IS 'Referrer''s Name'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.IND_SUCC_CONT IS 'Was the person successfully contacted?'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.TXT_WHY_CONT IS 'If not Contacted, why?'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.CD_CURR_OUTCOME IS 'Current Outcome of Contact'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.IND_VISIT_RSRC IS 'Is person willing to be a visitation resource'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.IND_PLCMT_RSRC IS 'Is person willing to be a placement resource'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.TXT_RSRC IS 'If not a resource, why?'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.DT_SUBSY_DISCSD IS 'Date relative care subsidies discussed'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.TXT_COMMENTS IS 'Comments'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.ID_PERSON_SEARCH IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.DILIGENT_SEARCH.ID_PERSON_DETAIL IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON TABLE CAPS.DIRECT_DELIVERY_PAC IS 'This is a specialized codes table used for a batch process.  It contains a Program Activity Code (PAC) as the code, and a description of the PAC as the decode.  The list of PACs is used to determine direct-delivery workers for Targeted Case Management (TCM) reporting.'
;
COMMENT ON COLUMN CAPS.DIRECT_DELIVERY_PAC.CD_DIR_DELIV_PAC_CODE IS 'Program Activity Code (PAC) associated with direct-delivery workers.  Used in determining workers involved in direct-delivery.'
;
COMMENT ON COLUMN CAPS.DIRECT_DELIVERY_PAC.CD_DIR_DELIV_PAC_DECODE IS 'Description of PAC associated with direct-delivery workers.'
;
COMMENT ON TABLE CAPS.DIVERSION_CONCLUSION IS 'The DIVERSION_CONCLUSION table captures concluding information regarding the Diversion stage.'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION.ID_EVENT IS 'Event identifier associated with the diversion stage'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION.ID_STAGE IS 'Stage identifier associated with the diversion stage.'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION.ID_CASE IS 'Case identifier associated with the diversion stage.'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION.DT_TASKS_COMP IS 'The date the diversion tasks were completed'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION.CD_DIV_DSPSN IS 'The disposition for the diversion stage.'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION.DT_RESPONSE IS 'Date case manager first responded.'
;
COMMENT ON TABLE CAPS.DIVERSION_CONCLUSION_NARR IS 'Contains the narrative blob for the Diversion Conclusion Narrative.'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION_NARR.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION_NARR.ID_CASE IS 'The Case this narrative is associated with'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION_NARR.NARRATIVE IS 'Blob containing the actual narrative'
;
COMMENT ON COLUMN CAPS.DIVERSION_CONCLUSION_NARR.ID_DOCUMENT_TEMPLATE IS 'The ID of the Document Template used by the narrative blob'
;
COMMENT ON TABLE CAPS.DLN_BATCH_NBR IS 'This table serves as the source of batch numbers assigned to NBR_INVO_DLN in the INVOICE table during nightly payment processing.  The DLN is assigned prior to submission to the accounting system.'
;
COMMENT ON COLUMN CAPS.DLN_BATCH_NBR.ID_DLN_BATCH IS 'This is the key/unique identifier to the DLN_BATCH_NBR table.'
;
COMMENT ON COLUMN CAPS.DLN_BATCH_NBR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DLN_BATCH_NBR.NBR_DLN_BATCH_END IS 'This is the last valid batch number that may be used before a new series of numbers is assigned.'
;
COMMENT ON COLUMN CAPS.DLN_BATCH_NBR.NBR_DLN_BATCH_NEXT_AVAIL IS 'This is the next available batch number to be used during nightly processing.  The number is incremented as numbers are used.'
;
COMMENT ON COLUMN CAPS.DLN_BATCH_NBR.NBR_DLN_BATCH_INFO IS 'This number serves as an information threshold.  When the batch number used reaches this threshold, an information message is included in the exception report to warn that the end of the batch number series is approaching.'
;
COMMENT ON COLUMN CAPS.DLN_BATCH_NBR.NBR_DLN_BATCH_WARN IS 'This number serves as a warning threshold.  When the batch number used reaches this threshold, a warning message is included in the exception report to warn that the end of the batch number series is nearing.  Plans should be made to acquire a new series.'
;
COMMENT ON COLUMN CAPS.DLN_BATCH_NBR.NBR_DLN_BATCH_SEVERE IS 'This number serves as a severe warning threshold.  When the batch number used reaches this threshold, a severe warning message is included in the exception report to warn that the end of the batch number series is close.  A new series must be established to avoid delaying payments.'
;
COMMENT ON TABLE CAPS.DOCUMENT_TEMPLATE IS 'This table contains the document templates and all the version info associated with the template.'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.ID_DOCUMENT_TEMPLATE IS 'The id for the document'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.ID_DOCUMENT_TEMPLATE_TYPE IS 'Unique identifier for a row in the DOCUMENT TEMPLATE TYPE table.'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.NBR_MINOR_VERSION IS 'The minor version of this template'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.NBR_MAJOR_VERSION IS 'The major version of this template'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.NBR_REVISION IS 'The revision number for this template'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.TXT_VERSION_STRING IS 'A strng describing the name and version of this template'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.TXT_SHORT_DESCRIPTION IS 'A short description of the template'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.TXT_LONG_DESCRIPTION IS 'A long description of the template'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.TXT_HTML IS 'The template itself in html format'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE.IND_ACTIVE IS 'Indicator if the template is active or not'
;
COMMENT ON TABLE CAPS.DOCUMENT_TEMPLATE_TYPE IS 'Parent table to the DOCUMENT TEMPLATE table.'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE_TYPE.ID_DOCUMENT_TEMPLATE_TYPE IS 'Unique identifier for a row in the DOCUMENT TEMPLATE TYPE table.'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE_TYPE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE_TYPE.TXT_NAME IS 'The name of the document as it appears on the CFP page'
;
COMMENT ON COLUMN CAPS.DOCUMENT_TEMPLATE_TYPE.NM_DOCUMENT IS 'The smart name fo the document'
;
COMMENT ON TABLE CAPS.DVLP_PLN_NARR IS 'The developmental Plan Narr Table.  (FK DVLP PLN NARR CASE is not a true foreign key constraint.)'
;
COMMENT ON COLUMN CAPS.DVLP_PLN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.DVLP_PLN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DVLP_PLN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.DVLP_PLN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Development Plan.'
;
COMMENT ON COLUMN CAPS.DVLP_PLN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.DW_DELETE_CALL IS 'Used in the PURGE process to mark records as purged in the Data Warehouse.  Populated by a trigger from the DELETE_CALL table.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CALL.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CALL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DW_DELETE_CALL_PERSON IS 'Used in the PURGE process to mark records as purged in the Data Warehouse.  Populated by a trigger from the DELETE_CALL_PERSON table.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CALL_PERSON.ID_PERSON IS 'Id of child for whom the referral was sent.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CALL_PERSON.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CALL_PERSON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DW_DELETE_CASE IS 'Used in the PURGE process to mark records as purged in the Data Warehouse.  Populated by a trigger from the DELETE_CASE table.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CASE.ID_DELETE_CASE IS 'Contains a unique identifier for a row on the DELETE CASE table.  It is the same value as ID CASE from the CAPS CASE table.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CASE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.DW_DELETE_CASE_PERSON IS 'Used in the PURGE process to mark records as purged in the Data Warehouse.  Populated by a trigger from the DELETE_CASE_PERSON table.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CASE_PERSON.ID_CASE_PERSON IS 'Unique sequence identifier for the DELETE CASE PERSON  table, which is system generated.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CASE_PERSON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CASE_PERSON.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CASE_PERSON.ID_PERSON IS 'Id of child for whom the referral was sent.'
;
COMMENT ON COLUMN CAPS.DW_DELETE_CASE_PERSON.ID_MERGED_PERSON IS 'The ID for the PERSON merged, used in the DELETE CASE PERSON table.'
;
COMMENT ON TABLE CAPS.EDUCATIONAL_HISTORY IS 'Stores a list of schools attended by the child in subcare, including school information, dates of attendance, and programs in which the child participated.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ID_EDHIST IS 'A unique integer that identifies an EDUCATION HISTORY record.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ADDR_EDHIST_CITY IS 'The city in which the school is located.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ADDR_EDHIST_CNTY IS 'The county in which the school is located is displayed here.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ADDR_EDHIST_STATE IS 'Contains the state in which the school is located.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ADDR_EDHIST_STREET_LN_1 IS 'Contains the first line of the address of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ADDR_EDHIST_STREET_LN_2 IS 'Contains the second line address of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.ADDR_EDHIST_ZIP IS 'Contains the zip code of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_ENROLL_GRADE IS 'This field enables the user to choose the grade of the child at time of enrollment in a school from a list.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_1 IS 'Stores the first needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_2 IS 'Stores the second needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_3 IS 'Stores the third needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_4 IS 'Stores the fourth needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_5 IS 'Stores the fifth needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_6 IS 'Stores the sixth needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_7 IS 'Stores the seventh needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_8 IS 'Stores the eighth needs of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_WITHDRAWN_GRADE IS 'Code representing the grade that the student was in at time withdrawn from school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.DT_EDHIST_ENROLL_DATE IS 'Date of enrollment associated with this event.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.DT_EDHIST_WITHDRAWN_DATE IS 'Date that the child was withdrawn from this school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_EDHIST_TEA_SCHOOL IS 'Indicates if a school is In State and TEA Certified.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.NBR_EDHIST_PHONE IS 'Phone Number of a School.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.NBR_EDHIST_PHONE_EXT IS 'The phone number extension of the school is listed here, if applicable.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.NM_EDHIST_SCHOOL IS 'Name of the school.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.NM_EDHIST_SCH_DIST IS 'The name of the School District to which the school belongs.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_EDHIST_ADDR_CMNT IS 'Narrative directions or special instructions on the location of school address.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_EDHIST_LICENSE IS 'Indicator if the education resource has a license.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_TYPE IS 'Type of educational resource.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_EDHIST_CMNTS IS 'Comments on education history.'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_CURR_GRADE IS 'Current Grade Level'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_CURR_GRADE_LEVEL IS 'Indicates if child is at or below level for grade'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_ATTENDANCE IS 'Captures person''s current attendance record  (truant, etc.)'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_9 IS 'Captures if the person has psycho-educational needs'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.CD_EDHIST_NEEDS_10 IS 'Captures if the person attends school part time'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_SCH_REC IS 'Indicates if school records are in the child''s file'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_REC_BOARD IS 'Indicates if records have been provided to boarding county'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_SCH_CHG IS 'Indicates if school changed due to removal'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_DSCPL_COMM IS 'Captures comments on disciplinary records'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_SPC_EDU_NEED IS 'Indicates if child has special educational needs'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_PREV_EDU_NEED IS 'Indicates if child has previously had special education services'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_SPC_EDU IS 'Captures additional comments on special education needs'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.DT_SST_REF IS 'Date of Student Support Team referral'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.DT_EDU_PLAN IS 'Date of Individualized Education Plan'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.NM_SURR_PRNT IS 'Name of surrogate parent for Individualized Education Plan'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_FSTR_PRNT IS 'Type of surrogate parent for IEP'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_LEGAL_PRNT IS 'Indicates of legal parent involved in IEP'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_SST IS 'Additional comments on IEP or Student Support Team'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_EIS IS 'Indicates if Early Intervention services are being provided'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.IND_PREV_EIS IS 'Indicates if Early Intervention Services have previously been provided'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_EIS IS 'Additional comments on Early Intervention Services'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_SCH_CNG_CMNT IS 'Text for  School changed due to removal? If yes, explain'
;
COMMENT ON COLUMN CAPS.EDUCATIONAL_HISTORY.TXT_SCH_REC_ON_FILE_CMNT IS 'Comments field to hold the text for  Are school records in file?
If yes, explain'
;
COMMENT ON TABLE CAPS.ELIG_NARR IS 'Stores the narrative off of the eligibility window.'
;
COMMENT ON COLUMN CAPS.ELIG_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.ELIG_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ELIG_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ELIG_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Quarterly FAD.'
;
COMMENT ON COLUMN CAPS.ELIG_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.ELIGIBILITY IS 'Table which contains foster care assistance eligibility determination for children in DFCS conservatorship and for Title IV-E eligible children in the custody of the Georgia Youth Commission and the County Juvenile Probation Departments. Children in own-home, relative and non-paid placements do not require eligibility determination.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.ID_ELIG_EVENT IS 'A unique identifier to the event table located on the eligibility table.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.ID_PERSON_UPDATE IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.DT_ELIG_END IS 'The date this eligibility status was denied.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_ACTUAL IS 'Eligibility as determined by the worker.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_CSUP_QUEST1 IS 'This is a yes or no question used in eligibility child support referral. The question found in the codes table states Assignment of support rights exists.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_CSUP_QUEST2 IS 'This is a yes or no question used in eligibility child support referral. The question found in the codes table states Good cause not to collect child support.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_CSUP_QUEST3 IS 'This is a yes or no question used in eligibility child support referral. The question found in the codes table states Child Support is Court Ordered.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_CSUP_QUEST4 IS 'This is a yes or no question used in eligibility child support referral. The question found in the codes table states Third party insurance exists.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_CSUP_QUEST5 IS 'Not currently being used.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_CSUP_QUEST6 IS 'Not currently being used.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_CSUP_QUEST7 IS 'Not currently being used.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_MED_ELIG_GROUP IS 'Code representing the type of Medicaid eligibility for which the child is eligible.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_ELIG_SELECTED IS 'Eligibility selected for billing as having the most advantageous funding for the department.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.DT_ELIG_CSUP_REFERRAL IS 'The most recent date on which child information has been submitted to the Attorney General via the AG Child Support Referral Interface process.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.DT_ELIG_REVIEW IS 'The date by which the next eligibility review must be completed. This date is generated by the system to be one year after the eligibility start date and cannot be modified.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.DT_ELIG_START IS 'The date this eligibility began.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.IND_ELIG_CSUP_SEND IS 'To indicate which records to be processed by CSUP Referral Interface batch program.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.IND_ELIG_WRITE_HISTORY IS 'Generic indicator used by the Database trigger which indicates the need for creation of a history record.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.TXT_ELIG_COMMENT IS 'This multi-line entry field is a pop-up window for the Eligibility determination window. This field is used to record comments.'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.CD_FCE_ELIG_REASON IS 'The Reason  the Eligibility has Changed/Ended'
;
COMMENT ON COLUMN CAPS.ELIGIBILITY.TXT_CHILD_SUPP_REF_COMMENT IS 'Comments regarding the Child Support Referral'
;
COMMENT ON TABLE CAPS.EMERGENCY_ASSIST IS 'Set of questions asked during CPS investigation to determine if the family is qualified for Emergency Assistance Eligibility.'
;
COMMENT ON COLUMN CAPS.EMERGENCY_ASSIST.ID_EMERGENCY_ASSIST IS 'Primary key on Emergency Assistance Table.'
;
COMMENT ON COLUMN CAPS.EMERGENCY_ASSIST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMERGENCY_ASSIST.ID_EA_EVENT IS 'Foreign Key to the Event table for emergency assistance.'
;
COMMENT ON COLUMN CAPS.EMERGENCY_ASSIST.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.EMERGENCY_ASSIST.IND_EA_RESPONSE IS 'Indicates response to Emergency Assistance Questions.'
;
COMMENT ON COLUMN CAPS.EMERGENCY_ASSIST.CD_EA_QUESTION IS 'The three Emergency Assistance Questions that determine if Emergency Assistance is needed.'
;
COMMENT ON TABLE CAPS.EMP_JOB_HISTORY IS 'A history of an employees job functions with DFCS.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.ID_EMP_JOB_HISTORY IS 'A unique integer which identifies an Employee''s Job History.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.ID_JOB_PERS_SUPV IS 'A unique integer which identifies a Person.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.CD_JOB_CLASS IS 'The job class of an employee.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.IND_JOB_ASSIGNABLE IS 'A flag which identifies if the employee may be assigned cases.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.CD_JOB_FUNCTION IS 'The functional title of the employee.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.CD_JOB_BJN IS 'Identifier representing a budgeted position within DFCS, one or at most two people hold this position at one time.Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.DT_JOB_END IS 'The end date for an employee''s budgeted job number (BJN.)'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.DT_JOB_START IS 'The start date for an employee''s budgeted job number (BJN.)'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.NBR_JOB_PAC IS 'The PAC for the employee''s job - the agency funding stream.'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.CD_JOB_TITLE IS 'Code for Employee Job Title'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.IND_CASE_ASSIGNABLE IS 'Indicator if assignable to a case'
;
COMMENT ON COLUMN CAPS.EMP_JOB_HISTORY.TEXT_ERS_NUMBER IS 'ERS number.'
;
COMMENT ON TABLE CAPS.EMP_ON_CALL_LINK IS 'Staff that are on a certain on-call schedule.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.ID_EMP_ON_CALL_LINK IS 'Unique identifier for the Employee On Call Link table.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.ID_ON_CALL IS 'A unique integer which identifies a particular shift or block for the on-call schedule.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.CD_EMP_ON_CALL_DESIG IS 'The role the employee fills within an on-call block or shift (primary, backup, supervisor.)'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.NBR_EMP_ON_CALL_PHONE1 IS 'First phone number that is used to contact the on-call staff in case of a call out after hours. May be a beeper. Defaults to the staff''s home phone number.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.NBR_EMP_ON_CALL_PHONE2 IS 'The second phone number intake would call to reach the on-call staff during business hours. Defaults to the staff''s work phone number.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.NBR_EMP_ON_CALL_EXT1 IS 'Extension field is used to list the extension number (if needed) associated with on call phone1.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.NBR_EMP_ON_CALL_EXT2 IS 'Extension field is used to list the extension number (if needed) associated with on call phone2.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.NBR_EMP_ON_CALL_CNTCT_ORD IS 'The order in which the on-call staff should be contacted at call-out time from intake.'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.CD_PRGM_CVRG IS 'Program Coverage Code'
;
COMMENT ON COLUMN CAPS.EMP_ON_CALL_LINK.CD_TITLE IS 'Job Title'
;
COMMENT ON TABLE CAPS.EMP_SEC_CLASS_LINK IS 'Provides a link between the EMPLOYEE table and the SECURITY CLASS table.  It defines the IMPACT Security available to each employee.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK.ID_EMP_SEC_LINK IS 'Provides a link between the EMPLOYEE table and the SECURITY CLASS table.  It defines the IMPACT Security available to each employee.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK.CD_SECURITY_CLASS_NAME IS 'Stores the name of the security class. Also is used to uniquely identify each row. Mislabeled as a code. There is no associated codes table with this data element.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  Contains the ID PERSON of an employee with IMPACT Security.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK.ID_PERSON_MODIFIED_BY IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.  Contains the id_person of a department employee.'
;
COMMENT ON TABLE CAPS.EMP_SEC_CLASS_LINK_AUDIT IS 'Audit table to track all modifications to the EMP_SEC_CLASS_LINK table.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK_AUDIT.ID_EMP_SEC_LINK_AUDIT IS 'Unique key for EMP_SEC_CLASS_LINK_AUDIT table'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK_AUDIT.ID_EMP_SEC_LINK IS 'Provides a link between the EMPLOYEE table and the SECURITY CLASS table.  It defines the IMPACT Security available to each employee.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK_AUDIT.CD_SECURITY_CLASS_NAME IS 'Stores the name of the security class. Also is used to uniquely identify each row. Mislabeled as a code. There is no associated codes table with this data element.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK_AUDIT.ID_PERSON IS 'Id of child for whom the referral was sent  Contains the ID PERSON of an employee with IMPACT Security.'
;
COMMENT ON COLUMN CAPS.EMP_SEC_CLASS_LINK_AUDIT.ID_PERSON_MODIFIED_BY IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.  Contains the id_person of a department employee.'
;
COMMENT ON TABLE CAPS.EMP_TEMP_ASSIGN IS 'This table manages designee assignments. It has no affiliation with case assignments.'
;
COMMENT ON COLUMN CAPS.EMP_TEMP_ASSIGN.ID_EMP_TEMP_ASSIGN IS 'The Primary Key on the EMP_TEMP_ASSIGN table.'
;
COMMENT ON COLUMN CAPS.EMP_TEMP_ASSIGN.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMP_TEMP_ASSIGN.ID_PERSON_EMP IS 'Foreign Key to the EMPLOYEE table.'
;
COMMENT ON COLUMN CAPS.EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE IS 'ID of person designated temporarily as the Unit Approver.'
;
COMMENT ON COLUMN CAPS.EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION IS 'The date the temporary assignment expires.'
;
COMMENT ON TABLE CAPS.EMPLOYEE IS 'Details about a PRS employee.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.  Contains the id_person of a department employee.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.CD_EMPLOYEE_CLASS IS 'The employee''s classification code (i.e. worker, case aid.)'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.DT_EMP_HIRE IS 'Date the employee was hired.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.ID_EMP_JOB_HISTORY IS 'A unique integer which identifies an Employee''s Job History.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.NBR_EMP_ACTIVE_PCT IS 'The percentage of the employee''s part-time employment.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.ID_EMP_OFFICE IS 'A unique identifier for the Office table on the Employee table.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.ID_EMPLOYEE_LOGON IS 'Employee''s Novell logon ID.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.CD_EMP_SECURITY_CLASS_NM IS 'The unique description of the security profile for PRS employees, determined by the creator of the security profile.  This column is now obsolete.  It is replaced by the EMP SEC CLASS LINK table that provides for multiple security classes for each employee.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.CD_EMP_PROGRAM IS 'The program area for which the employee works, or if the employee is non-program related(admin,support.)'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.DT_EMP_LAST_ASSIGNED IS 'Date the employee was last assigned.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.DT_EMP_TERMINATION IS 'Date the employee was terminated.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.IND_EMP_ACTIVE_STATUS IS 'Represents the working status of the staff person, either full-time or part-time.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.IND_EMP_CONFIRMED_HRMIS IS 'This is an indicator to confirm that the Employee Record has been officially updated by HRMIS. It gets automatically checked if the HRMIS interface is successful. This is a hidden field on the window. The authorized maintainer can delete an employee record if this field is NOT checked.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.IND_EMP_PENDING_HRMIS IS 'The employee record is pending validation from HRMIS interface.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.NM_EMPLOYEE_FIRST IS 'Current, valid first name of each individual employee known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.NM_EMPLOYEE_MIDDLE IS 'Current, valid middle name of each individual employee known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.NM_EMPLOYEE_LAST IS 'Current, valid last name of each individual employee known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.CD_EMP_BJN_EMP IS 'Identifier representing a budgeted position within PRS, indicates the identifier the employee currently has in effect. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.IND_EMP_JOB_ASSIGN_CURR IS 'Indicates whether the employee is currently job assignable.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.NM_EMP_OFFICE_NAME IS 'Name of the PRS Office which the employee is currently associated with.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.CD_EMP_OFFICE_MAIL IS 'Mail Code for the PRS office with which the employee is currently associated.  Mislabeled as a code.  There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.NBR_EMP_UNIT_EMP_IN IS 'The Unit Number that the employee is currently an IN member of.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.ID_EMP_UNIT IS 'The unique integer which defines the Unit that the employee is currently an IN member of.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.CD_EMP_UNIT_REGION IS 'A geographic area or organizational group of the PRS agency that the employee''s current IN assigned unit is associated with.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.CD_EMPLOYEE_SUFFIX IS 'The appended suffix of the person in question. (populated by a trigger on the NAME table)'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.DT_LAST_LOGIN IS 'Contains the last date on which a user logged in to IMPACT.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.ID_PERSON_MODIFIED_BY IS 'The ID of the Employee who last modified this employee table.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE.ID_RACF IS 'This is an 8-character version of the employee logon used in mainframe transactions for this user. The id stored here DOES NOT need to be a real mainframe RACF id, but it does need to be unique for the employee, and is used for logging the employees transactions against mainframe interfaces such as CRS, $TARS, and SUCCESS.'
;
COMMENT ON TABLE CAPS.EMPLOYEE_AUDIT IS 'Audit table of activity on the Employee Table'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_EMPLOYEE_AUDIT IS 'Primary, Artificial key for the Employee Audit Table'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.  Contains the id_person of a department employee.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.CD_EMPLOYEE_CLASS IS 'The employee''s classification code (i.e. worker, case aid.)'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.DT_EMP_HIRE IS 'Date the employee was hired.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_EMP_JOB_HISTORY IS 'A unique integer which identifies an Employee''s Job History.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.NBR_EMP_ACTIVE_PCT IS 'The percentage of the employee''s part-time employment.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_EMP_OFFICE IS 'A unique identifier for the Office table on the Employee table.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_EMPLOYEE_LOGON IS 'Employee''s Novell logon ID.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.CD_EMP_SECURITY_CLASS_NM IS 'The unique description of the security profile for PRS employees, determined by the creator of the security profile.  This column is now obsolete.  It is replaced by the EMP SEC CLASS LINK table that provides for multiple security classes for each employee.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.CD_EMP_PROGRAM IS 'The program area for which the employee works, or if the employee is non-program related(admin,support.)'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.DT_EMP_LAST_ASSIGNED IS 'Date the employee was last assigned.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.DT_EMP_TERMINATION IS 'Date the employee was terminated.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.IND_EMP_ACTIVE_STATUS IS 'Represents the working status of the staff person, either full-time or part-time.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.IND_EMP_CONFIRMED_HRMIS IS 'This is an indicator to confirm that the Employee Record has been officially updated by HRMIS. It gets automatically checked if the HRMIS interface is successful. This is a hidden field on the window. The authorized maintainer can delete an employee record if this field is NOT checked.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.IND_EMP_PENDING_HRMIS IS 'The employee record is pending validation from HRMIS interface.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.NM_EMPLOYEE_FIRST IS 'Current, valid first name of each individual employee known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.NM_EMPLOYEE_MIDDLE IS 'Current, valid middle name of each individual employee known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.NM_EMPLOYEE_LAST IS 'Current, valid last name of each individual employee known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.CD_EMP_BJN_EMP IS 'Identifier representing a budgeted position within PRS, indicates the identifier the employee currently has in effect. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.IND_EMP_JOB_ASSIGN_CURR IS 'Indicates whether the employee is currently job assignable.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.NM_EMP_OFFICE_NAME IS 'Name of the PRS Office which the employee is currently associated with.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.CD_EMP_OFFICE_MAIL IS 'Mail Code for the PRS office with which the employee is currently associated.  Mislabeled as a code.  There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.NBR_EMP_UNIT_EMP_IN IS 'The Unit Number that the employee is currently an IN member of.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_EMP_UNIT IS 'The unique integer which defines the Unit that the employee is currently an IN member of.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.CD_EMP_UNIT_REGION IS 'A geographic area or organizational group of the PRS agency that the employee''s current IN assigned unit is associated with.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.CD_EMPLOYEE_SUFFIX IS 'The appended suffix of the person in question. (populated by a trigger on the NAME table)'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.DT_LAST_LOGIN IS 'Contains the last date on which a user logged in to IMPACT.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_PERSON_MODIFIED_BY IS 'The ID of the Employee who last modified this employee table.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_AUDIT.ID_RACF IS 'This is an 8-character version of the employee logon used in mainframe transactions for this user. The id stored here DOES NOT need to be a real mainframe RACF id, but it does need to be unique for the employee, and is used for logging the employees transactions against mainframe interfaces such as CRS, $TARS, and SUCCESS.'
;
COMMENT ON TABLE CAPS.EMPLOYEE_SKILL IS 'A list of any special skills or special certificates an employee had or has earned.  THIS TABLE IS NO LONGER USED WITH THE IMPLEMENTATION OF IMPACT.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_SKILL.ID_EMPLOYEE_SKILL IS 'A unique integer which defines an Employee Skill.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_SKILL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_SKILL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.  Contains the id_person of a department employee.'
;
COMMENT ON COLUMN CAPS.EMPLOYEE_SKILL.CD_EMP_SKILL IS 'Special skills the employee may have (e.g.: experience with homeless, foreign languages, law enforcement/military experience, etc.).'
;
COMMENT ON TABLE CAPS.EQUIVALENCY IS 'Static table that is used by the Invoice Validation batch process to assign PAC and Object codes to the payment line items.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.ID_EQUIV IS 'This is the unique identifier/key for the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_FUNDING_STREAM IS 'This element is used by the ISAS Roll up process as a part of a table look up to determine the proper PAC and Object codes for an invoice line item. It is pulled from the FUNDING_STREAM table. Please reference the Financial System for additional information. There is no associated codes table for this data element, but TXT FNDSTR DESCRIP in the FUNDING STREAM table contains a brief description/decode.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_OBJ_ALW IS 'This element is used in the ISAS Roll up process to hold the code for an object of expenditure. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_OBJ_CERT IS 'This element is used by the ISAS Roll up process to hold the code for an object of expenditure. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_OBJ_PURE IS 'This element is used by the ISAS Roll up process to hold the code for an object of expenditure. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_PAC IS 'This element is used by the ISAS Roll up process to hold the program activity code for an invoice line item. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_STAGE IS 'This element is used by the ISAS Roll up process to hold the stage code (attained from a hierarchy of stages that a person may actually be in), that is used in an EQUIVALENCY table lookup.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_STAGE_TYPE IS 'This element is used by the ISAS Roll up to hold the type for the CD EQUIV STAGE, and is used in the look up of the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.CD_EQUIV_SVC_DTL_SERVICE IS 'This element is used by the ISAS Roll up process to hold the service code referenced on an invoice line item and is used in a look up of the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.DT_EQUIV_START_DATE IS 'This is the first day that an EQUIVALENCY table line item is valid.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.DT_EQUIV_END_DATE IS 'This is the last day that the EQUIVALENCY table line item is valid.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.NBR_EQUIV_OBJ_ALW IS 'This element is used by the ISAS Roll up process to hold the percentage (e.g. fraction, never be over 1.000000) that an object of expenditure pays for a particular line item.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.NBR_EQUIV_OBJ_CERT IS 'This element is used by the ISAS Roll up process to hold the percentage of an invoice line item amount that is paid by a particular object of expenditure.'
;
COMMENT ON COLUMN CAPS.EQUIVALENCY.NBR_EQUIV_OBJ_PURE IS 'This element is used by the ISAS Roll up process to hold the percentage of an invoice line item amount that is paid by an object of expenditure.'
;
COMMENT ON TABLE CAPS.ERROR_LIST IS 'Static table that works with error messaging architecture.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST.ID_ERROR_LIST IS 'Primary key - id of the error list record.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST.NBR_MESSAGE IS 'The reference number of the message generated by the services; this matches the IMPACT message number.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST.TXT_PRGM_CD IS 'Program type.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST.TXT_STAGE_CD IS 'Stage type.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST.ID_TAB IS 'A unique ID identifying each tab.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST.CD_TASK IS 'The primary key to the TASK table.  The code value may be stored in various other tables.  The value may then be used to acquire other information about the task, such as a description, from the TASK table.'
;
COMMENT ON TABLE CAPS.ERROR_LIST_DEST IS 'Destination pages for errors.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST_DEST.ID_ERROR_LIST_DEST IS 'Primary key of the ERROR_LIST_DEST table.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST_DEST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST_DEST.TXT_ERROR_PAGE_NAME IS 'The Title/page name of the destination page.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST_DEST.TXT_SERVLET IS 'The IMPACT Servlet of the destination page'
;
COMMENT ON COLUMN CAPS.ERROR_LIST_DEST.TXT_CONVERSATION IS 'The IMPACT conversation of the destination page.'
;
COMMENT ON COLUMN CAPS.ERROR_LIST_DEST.TXT_COMMAND IS 'The IMPACT command of the destination page; the servlet, the conversation, and the command together will be used, to create the request URI to load the destination page, in the following pattern: ''/servlet/conversation/command'''
;
COMMENT ON TABLE CAPS.EVENT IS 'Records each event which happens in the IMPACT system. An event is an action or happening within a case which we want to track, for example, closing an investigation, or recording an intake during service delivery.'
;
COMMENT ON COLUMN CAPS.EVENT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.EVENT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EVENT.ID_EVENT_STAGE IS 'Foreign Key to the STAGE table.'
;
COMMENT ON COLUMN CAPS.EVENT.CD_EVENT_TYPE IS 'A type of event recorded by IMPACT, (i.e. investigation closure, service plan approval, etc.)'
;
COMMENT ON COLUMN CAPS.EVENT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.EVENT.ID_EVENT_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.EVENT.CD_TASK IS 'The primary key to the TASK table.  The code value may be stored in various other tables.  The value may then be used to acquire other information about the task, such as a description, from the TASK table.'
;
COMMENT ON COLUMN CAPS.EVENT.TXT_EVENT_DESCR IS 'Details about an event that are unique to a specific occurrence of a particular event type.'
;
COMMENT ON COLUMN CAPS.EVENT.DT_EVENT_OCCURRED IS 'The date on which the event was recorded by the system.'
;
COMMENT ON COLUMN CAPS.EVENT.CD_EVENT_STATUS IS 'Status of event. (e.g. started, in process, complete) Only one status per event is maintained in the system, so the status is updated if it changes. (e.g. from started to in process)'
;
COMMENT ON TABLE CAPS.EVENT_PERSON_LINK IS 'This table links people (other than the creator) to a particular event.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.ID_EVENT_PERS_LINK IS 'A unique identifier to the Event Pers Link table.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.CD_FAM_PLAN_PERM_GOAL IS 'A code which identifies the child''s permanency goal.  Linked to the CCPPRMGL codes table.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.DT_FAM_PLAN_PERM_GOAL_TARGET IS 'Target date for reaching the child''s permanency goal.'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.TXT_GOAL_CMMT IS 'Goal Comment'
;
COMMENT ON COLUMN CAPS.EVENT_PERSON_LINK.IND_CAREGIVER IS 'Caregiver Checkbox'
;
COMMENT ON TABLE CAPS.EVENT_PLAN_LINK IS 'Indicates whether or not a family plan was created using IMPACT. Data for plans created using IMPACT will be stored in the FAMILY_PLAN tables. Data for legacy plans will be stored in the SERVICE_PLAN tables.'
;
COMMENT ON COLUMN CAPS.EVENT_PLAN_LINK.ID_EVENT_FAMILY_PLAN_LINK IS 'Primary key of the EVENT_PLAN_LINK table.'
;
COMMENT ON COLUMN CAPS.EVENT_PLAN_LINK.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.EVENT_PLAN_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EVENT_PLAN_LINK.IND_IMPACT_CREATED IS 'Indicates whether or not a plan was created using IMPACT.'
;
COMMENT ON TABLE CAPS.EVENT_TYPE IS 'A code/decode table for all the different events that can happen in an IMPACT Case. This table does not contain the case/stage/person specific events, only a description of each event type, like ''Investigation Complete'' or ''Case Closed''.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EVENT_TYPE.CD_EVENT_TYPE IS 'A type of event recorded by IMPACT, (i.e. investigation closure, service plan approval, etc.)'
;
COMMENT ON COLUMN CAPS.EVENT_TYPE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EVENT_TYPE.DESC_EVENT_TYPE IS 'The long description of an event type.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EVENT_TYPE.SDS_EVENT_TYPE IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON TABLE CAPS.EXAM_DETAIL IS 'This table is used to store information from the  examination detail page'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.ID_EXAM_DETAIL IS 'Unique identifier (artificial key) for the EXAM_DETAIL table'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.CD_EXAM_TYP IS 'Stores exam type'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.DT_EXAM IS 'Date the exam was taken'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.NBR_SCORE IS 'The exam score.'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.IND_FIRST_ATMPT IS 'Indicates if this was the first attempt to take this exam.'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.IND_PASSED IS 'Indicates if the person passed this exam on this dt_exam.'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.IND_GED IS 'Sets indicator to Store whether it''s GED exam info or Graduation exam info.'
;
COMMENT ON TABLE CAPS.EXC_CHILD_ADO_INFO_CBX IS 'Records the state recruitment activities that are saved on the Exchange Child Detail page'
;
COMMENT ON COLUMN CAPS.EXC_CHILD_ADO_INFO_CBX.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.EXC_CHILD_ADO_INFO_CBX.CD_ADO_INFO_CBX IS 'The type of the recruitment activity'
;
COMMENT ON COLUMN CAPS.EXC_CHILD_ADO_INFO_CBX.CD_CBX_CODE_TYPE IS 'The code type of the activity'
;
COMMENT ON COLUMN CAPS.EXC_CHILD_ADO_INFO_CBX.DT_PERFORMED IS 'Date of the recruitment activity'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_OUT IS 'date materials sent for consideration'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_NON_AVAIL_STATUS IS 'Child''s availability code'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_LEGAL_RISK IS 'Indicator if the child has legal risk'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_NOTIFIED IS 'Date SAU was notified of the child being free'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_REGISTERED IS 'Date child registered for exchange'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_APPROVED IS 'Date child approved for exchange'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_RE_REGISTERED IS 'Date child re-registered for exchange'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.TXT_RECRUIT_COMMENT IS 'Comment about child recruiting activities'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_MENTAL_RETARDATION IS 'Indicator if the child has the characteristic Mental Retardation'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_SEV_MENTAL_RETARDATION IS 'Severity level of the characteristic Mental Retardation'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_VISUAL_HEARING_IMP IS 'Indicator if the child has the characteristic Visual or Hearing Impaired'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_SEV_VISUAL_HEARING_IMP IS 'Severity level of the characteristic Visual or Hearing Impaired'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_PHYSICALLY_DISABLED IS 'Indicator if the child has the characteristic Physically Disabled'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_SEV_PHYSICALLY_DISABLED IS 'Severity level of the characteristic Physically Disabled'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_EMOTIONALLY_DIST IS 'Indicator if the child has the characteristic Emotionally Disturbed'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_SEV_EMOTIONALLY_DIST IS 'Severity level of the characteristic Emotionally Disturbed'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_OTHER_MED IS 'Indicator if the child has the characteristic Other Medical Diagnosis'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_SEV_OTHER_MED IS 'Severity level of the characteristic Other Medical Diagnosis'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_FAM_HX_DRUGS_ALCOHOL IS 'Indicator if the child has the characteristic Family History of Drug/Alcohol Abuse'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_FAM_HX_MENTAL_ILL IS 'Indicator if the child has the characteristic Family History of Mental Illness'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_FAM_HX_MR IS 'Indicator if the child has the characteristic Family History of Mental Retardation'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_CH_HX_SEXUAL_ABUSE IS 'Indicator if the child has the characteristic Family History of Sexual Abuse'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.IND_BIO_IS_LEG_FATHER IS 'Indicator if the child''s biological father is the same as the legal father'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_CLOSE IS 'Date the child was closed without placement'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.CD_REASON_CLOSED IS 'Reason child was closed without placement'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_FINAL IS 'Date the finalization occurred'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.DT_FINAL_ENTERED IS 'Date the finalization was documented'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.TXT_AVAIL_COMMENTS IS 'Comments regarding the child''s availablility'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.TXT_EXPLANATION_NO_PLCMT IS 'Comments about why the child was closed no placement.'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.NBR_AFILE IS 'Afile number for child'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.TXT_BIRTH_NAME IS 'Birth name of the child if there was a dissolution'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.TXT_CHILD_IS_LINKED IS 'Comments for Child is Linked'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD.TXT_CHILD_PLACED_WITH IS 'Comments for Child is Placed With'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD_FAM_LINK.ID_EXCHANGE_CHILD_FAM_LINK IS 'Primary Key of table'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD_FAM_LINK.ID_EVENT_HOME_REGISTRATION IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD_FAM_LINK.ID_EVENT_CHILD_REGISTRATION IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD_FAM_LINK.DT_OUT IS 'Date the family were linked'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD_FAM_LINK.IND_LINK_CURRENT IS 'Indicator if they are currently linked'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD_FAM_LINK.CD_NON_SELECTION_RSN IS 'Code that stores non-selection reason'
;
COMMENT ON COLUMN CAPS.EXCHANGE_CHILD_FAM_LINK.CD_NON_AVAIL_CODE IS 'Availability code change for that specific link'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.ID_EVENT IS 'Event id of the home registration event'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.DT_APPROVED IS 'Date home was approved for the exchange'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.DT_REGISTERED IS 'Date home was registered for the exchange'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.DT_RE_REGISTERED IS 'Date home was re-registered for the exchange'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_MENTAL_RETARDATION IS 'Indicator if the home will accept the characteristic Mental Retardation'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.CD_SEV_MENTAL_RETARDATION IS 'Severity level of the characteristic Mental Retardation'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_VISUAL_HEARING_IMP IS 'Indicator if the home will accept the characteristic Visual or Hearing Impaired'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.CD_SEV_VISUAL_HEARING_IMP IS 'Severity level of the characteristic Visual or Hearing Impaired'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_PHYSICALLY_DISABLED IS 'Indicator if the home will accept the characteristic Physically Disabled'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.CD_SEV_PHYSICALLY_DISABLED IS 'Severity level of the characteristic Physically Disabled'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_EMOTIONALLY_DIST IS 'Indicator if the home will accept the characteristic Emotionally Disturbed'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.CD_SEV_EMOTIONALLY_DIST IS 'Severity level of the characteristic Emotionally Disturbed'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_OTHER_MED IS 'Indicator if the home will accept the characteristic Other Medical Diagnosis'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.CD_SEV_OTHER_MED IS 'Severity level of the characteristic Other Medical Diagnosis'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_FAM_HX_DRUGS_ALCOHOL IS 'Indicator if the home will accept the characteristic Family History of Drug/Alcohol Abuse'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_FAM_HX_MENTAL_ILL IS 'Indicator if the home will accept the characteristic Family History of Mental Illness'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_FAM_HX_MR IS 'Indicator if the home will accept the characteristic Family History of Mental Retardation'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.IND_CH_HX_SEXUAL_ABUSE IS 'Indicator if the home will accept the characteristic Child History of Sexual Abuse'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.CD_NON_AVAIL_STATUS IS 'Non-Availability Status code'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.DT_OUT IS 'Date the home study was sent out to the county'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.TXT_COMMENTS IS 'Comments regarding the home study being sent'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.DT_CLOSE IS 'Date the home was closed without placement'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.CD_REASON_CLOSED IS 'Reason home was closed without placement'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.TXT_EXPLANATION IS 'Explanation why the home was closed'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.DT_FINAL IS 'Date the finalization occurred'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.DT_FINAL_ENTERED IS 'Date the finalization was documented'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.NBR_CHILD_INTEREST IS 'Number of children home is interested in'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.TXT_COMMENTS_INTEREST IS 'Comments regarding the home preferences'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.NM_AGNCY_CASEWORKER IS 'Name of the private agency case worker'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.NBR_AGNCY_CONTACT_PHN IS 'Phone number for private agency case worker'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.NBR_AGNCY_CONTACT_PHONE_EXT IS 'Extension for private agencycase worker'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.TXT_FAMILY_IS_LINKED IS 'Textbox to keep family is linked information'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.NBR_AFILE IS 'Afile number for the family'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.TXT_CHILD_PLACED_WITH IS 'Textbox to keep child placed with information'
;
COMMENT ON COLUMN CAPS.EXCHANGE_HOME.NBR_AGENCY_CONTRACT_CODE IS 'Number of the agency''''s contract code with the SAU'
;
COMMENT ON TABLE CAPS.EXT_DOCUMENTATION IS 'Documents that are kept relating to a case that are external to the automated case. Examples include Medical Assessments, Legal Documents.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.ID_EXT_DOCUMENTATION IS 'A unique integer which identifies an External Situation Information.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.DT_EXT_DOC_OBTAINED IS 'The date the worker obtained the document.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.TXT_EXT_DOC_DETAILS IS 'Any other details the user wishes to enter about the specifics of the document, the document''s location, and the time of day the document was obtained, if applicable.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.CD_EXT_DOC_TYPE IS 'A drop-down combo box containing codes for the type of external documentation obtained.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.TXT_EXT_DOC_LOCATION IS 'General comments field allowing for indication of the location of the document such as case, police department.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.CD_EXT_DOC_SORT IS 'A drop-down combo box containing codes for the type of external documentation obtained. This number is used to sort the information on the Facility Abuse Neglect Form in the Facility Investigation Conclusion window.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.IND_EXT_DOC_SIGNED IS 'Indicates if document has been signed.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.DT_EXT_DOC_UPLOADED IS 'Date when document was uploaded.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.BL_EXT_DOC IS 'Contains the document'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.TXT_FILE_NAME IS 'Name of the file that was uploaded.'
;
COMMENT ON COLUMN CAPS.EXT_DOCUMENTATION.TXT_FORMAT_TYPE IS 'Extension of the file uploaded.'
;
COMMENT ON TABLE CAPS.EXTERNAL_REC_SEARCH IS 'Details about records searches against external systems such as MHMR and DHS.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.ID_EXT_REC_SEARCH IS 'A unique integer which defines an External Records Search.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.DT_EXT_SEARCH_CONDUCTED IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.CD_EXT_SEARCH_CHECK_TYPE IS '* NOT CURRENTLY USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.CD_EXT_SEARCH_STATUS IS 'A code that identifies the status of each external search that was done on each client.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.NM_EXT_SEARCH_CONDUCTED IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.ID_LICENSE_NUMBER IS 'A unique identifier for a Car License Plate.'
;
COMMENT ON COLUMN CAPS.EXTERNAL_REC_SEARCH.TXT_EXT_SEARCH_COMMENTS IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON TABLE CAPS.FA_HOME_INT_ETHNIC IS 'Stores the ethnic preferences for the F/A Home.'
;
COMMENT ON COLUMN CAPS.FA_HOME_INT_ETHNIC.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.FA_HOME_INT_ETHNIC.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FA_HOME_INT_ETHNIC.CD_FA_HOME_INT_ETHNICITY IS 'The ethnicity of the F/A Home to be stored on the FA Home Interests Ethnicity table.'
;
COMMENT ON TABLE CAPS.FA_INDIV_TRAINING IS 'This table contains the information regarding the training of an individual person for the purpose of providing quality foster/adoptive care.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.ID_INDIV_TRAINING IS 'A unique identifier to the Individual Training table.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.TXT_INDIV_TRN_TITLE IS 'The description (name) of the individual training session'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.CD_INDIV_TRN_TYPE IS 'The type of individual training the F/A Home member may take.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.DT_INDIV_TRN IS 'The date of the individual training session.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.IND_INDIV_TRN_EC IS 'Indicates whether the individual training session has evaluation component hours.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.NBR_INDIV_TRN_HRS IS 'The number of training session hrs associated with a training session.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.NBR_INDIV_TRN_SESSION IS 'The session number of the training session the individual attends.'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.NM_AGENCY IS 'Agency Name'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.IND_CO_TRAIN IS 'Co-Trained with DFCS'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.NM_TRAIN1 IS 'Trainer 1'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.CD_TRAIN1_ROLE IS 'Role'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.NM_TRAIN2 IS 'Trainer 2'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.CD_TRAIN2_ROLE IS 'Role'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.NM_TRAIN3 IS 'Trainer 3'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.CD_TRAIN3_ROLE IS 'Role'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.NM_TRAIN4 IS 'Trainer 4'
;
COMMENT ON COLUMN CAPS.FA_INDIV_TRAINING.CD_TRAIN4_ROLE IS 'Role'
;
COMMENT ON TABLE CAPS.FAC_CONCL_REV_NARR IS 'No description available.'
;
COMMENT ON COLUMN CAPS.FAC_CONCL_REV_NARR.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.FAC_CONCL_REV_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAC_CONCL_REV_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the information for the APS Facility Investigation Conclusion document generated during the Request for Review process. This document is not modified.'
;
COMMENT ON COLUMN CAPS.FAC_CONCL_REV_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.FACIL_ALLEG IS 'For an APS Facility case, the link of a victim to a perpetrator for an occurrence of abuse, neglect or exploitation. Allegations are recorded at intake. Additional allegations can be discovered during the investigation.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  On the FACIL_ALLEG_PRIOR_REVIEW table, it is the ID_ALLEGATION before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.IND_FACIL_ALLEG_CANCEL_HIST IS 'Indicator column used to specify whether or not to copy the currently inserted or updated row to the FACIL_ALLEG_HIST table.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_EVENT_LOC IS 'Contains the specific location of the incident.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_CLSS IS 'Contains the overall severity of the allegation.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_CLSS_SUPR IS 'Contains the overall severity determined by the superintendent.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_DISP_SUPR IS 'Contains the superintendent''s determination of the allegation.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_SRC IS 'Contains source of the injury of the allegation. Filled with codes from the Table of Source of Injury.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_SRC_SUPR IS 'Contains the superintendent''s statement about the victim''s Source of the Injury as it relates to the allegation.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.DT_FACIL_ALLEG_SUPR_REPLY IS 'Contains the date the superintendent''s findings are recorded.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.DT_FACIL_ALLEG_INVSTGTR IS 'Contains the date the investigator''s findings are recorded.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_INJ_SER IS 'Contains the seriousness of the injury. Filled with codes from the Table of Seriousness of Injuries.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.CD_FACIL_ALLEG_NEGL_TYPE IS 'This element is used on the Facility Allegation Detail window to indicate neglect type when the victim in question is a child (under 18).'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.DT_FACIL_ALLEG_INCIDENT IS '1. Date of each alleged incident.  or2. Date of last known incident of abuse. or3. Date the alleged facility incident occurred.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.IND_FACIL_ALLEG_AB_OFF_GR IS 'This field is used to indicate whether or not the allegation occurred on the grounds of the facility.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.IND_FACIL_ALLEG_SUPVD IS 'This field is used to indicate whether or not the facility where the allegation occurred is a supervised facility.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.TXT_FACIL_ALLEG_CMNTS IS 'Narrative that can be added when a caseworker is completing the triad(s) during an investigation.This field will probably not be available to intake workers.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG.NBR_FACIL_ALLEG_MHMR IS 'Contains the MHMR Incident # which identifies the incident for tracking purposes.'
;
COMMENT ON TABLE CAPS.FACIL_ALLEG_HIST IS 'Historical record of allegations recorded during an APS Facility case.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.ID_FACIL_ALLEG_HISTORY IS 'A unique integer which defines a Facility Allegation History.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  On the FACIL_ALLEG_PRIOR_REVIEW table, it is the ID_ALLEGATION before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.DT_FACIL_HIST_EFFECTIVE IS 'Date the Facility Allegation History record was effective.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.DT_FACIL_HIST_END IS 'Date the Facility Allegation Records in no longer effective.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_EVENT_LOC IS 'Contains the specific location of the incident.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_CLSS IS 'Contains the overall severity of the allegation.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_CLSS_SUPR IS 'Contains the overall severity determined by the superintendent.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_DISP_SUPR IS 'Contains the superintendent''s determination of the allegation.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_SRC IS 'Contains source of the injury of the allegation. Filled with codes from the Table of Source of Injury.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_SRC_SUPR IS 'Contains the superintendent''s statement about the victim''s Source of the Injury as it relates to the allegation.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.DT_FACIL_HIST_SUPR_REPLY IS 'Contains the date the superintendent''s findings are recorded.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.DT_FACIL_HIST_INVSTGTR IS 'Contains the date the investigator''s findings are recorded.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_INJ_SER IS 'Contains the seriousness of the injury. Filled with codes from the Table of Seriousness of Injuries.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.CD_FACIL_HIST_NEGL_TYPE IS 'This element is used on the Facility Allegation Detail window to indicate neglect type when the victim in question is a child (under 18).'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.DT_FACIL_HIST_INCIDENT IS '1. Date of each alleged incident.  or2. Date of last known incident of abuse. or3. Date the alleged facility incident occurred.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.IND_FACIL_HIST_AB_OFF_GR IS 'This field is used to indicate whether or not the allegation occurred on the grounds of the facility.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.IND_FACIL_HIST_SUPVD IS 'This field is used to indicate whether or not the facility where the allegation occurred is a supervised facility.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.TXT_FACIL_HIST_CMNTS IS 'Narrative that can be added when a caseworker is completing the triad(s) during an investigation.This field will probably not be available to intake workers.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_HIST.NBR_FACIL_HIST_MHMR IS 'Contains the MHMR Incident # which identifies the incident for tracking purposes.'
;
COMMENT ON TABLE CAPS.FACIL_ALLEG_PRIOR_REVIEW IS 'All original allegation information for an AFC Investigation. This table serves to store original AFC investigation information entered prior to a Request for Review contact is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  On the FACIL_ALLEG_PRIOR_REVIEW table, it is the ID_ALLEGATION before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.ID_REVIEW_VICTIM IS 'ID_PERSON of the victim before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.ID_REVIEW_ALLEGED_PERP IS 'ID_PERSON of the alleged perpetrator before a Request for Review has been submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.ID_REVIEW_STAGE IS 'ID_STAGE of the stage before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.CD_REVIEW_ALLEG_TYPE IS 'A code that describes each type of abuse/neglect alleged before a Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.CD_REVIEW_ALLEG_DISP IS 'A code which identifies the validity of the allegation disposition that was determined at the end of the investigation before a Request for Review was submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.CD_REVIEW_ALLEG_DISP_SUPR IS 'A code which identifies the superintendent''s validity of the allegation disposition that was determined at the end of the investigation before a Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.CD_REVIEW_ALLEG_CLSS IS 'A code which identifies the classification of APS Facility cases before a Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACIL_ALLEG_PRIOR_REVIEW.CD_REVIEW_ALLEG_CLSS_SUPR IS 'A code which identifies the superintendent''s classification of APS Facility cases before a Request for Review is submitted.'
;
COMMENT ON TABLE CAPS.FACIL_CONCL_NARR IS 'Information for the original AFC Investigation Conclusion document. This information will not be modified.'
;
COMMENT ON COLUMN CAPS.FACIL_CONCL_NARR.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.FACIL_CONCL_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACIL_CONCL_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the information for the original APS Facility Investigation Conclusion document generated during the Request for Review process. This document is not modified.'
;
COMMENT ON COLUMN CAPS.FACIL_CONCL_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.FACILITY_INJURY IS 'Details of an injury sustained by a client during an APS Facility case.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.ID_FACILITY_INJURY IS 'A unique identifier for the Facility Injury table.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  On the FACIL_ALLEG_PRIOR_REVIEW table, it is the ID_ALLEGATION before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.CD_FACIL_INJURY_TYPE IS 'Contains the type of injury that occurred. Filled with codes from the Table of Types of Injury.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.CD_FACIL_INJURY_BODY IS 'Contains the part of the body to which the injury occurred.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.CD_FACIL_INJURY_SIDE IS 'Contains the side of the body to which the injury occurred.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.TXT_FACIL_INJURY_CMNTS IS 'Comments pertaining to injuries incurred for a particular allegation facilities investigation.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.CD_FACIL_INJURY_CAUSE IS 'Contains the cause of injury.'
;
COMMENT ON COLUMN CAPS.FACILITY_INJURY.DT_FACIL_INJURY_DTRMNTN IS 'Date that the client was medically assessed for injury by MHMR medical personnel. This date cannot be greater than the system date and can only be back dated to 09-01-1992 when responsibility was transferred to DFCS.'
;
COMMENT ON TABLE CAPS.FACILITY_INVST_DTL IS 'Details surrounding an investigation at a Facility.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ID_FACIL_INVST_STAGE IS 'Primary key for the FACILITY_INVST_DTL table. References the STAGE table.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ID_FACIL_RESOURCE IS 'Foreign key to the Resource table. (ID RESOURCE).'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ID_AFFIL_RESOURCE IS 'Foreign key to the Resource table (ID RESOURCE). Resource Id affiliated with the facility.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.CD_FACIL_INVST_OVRALL_DIS IS 'This element is not viewed on the window but assists in the determining of which closure codes to display.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.NM_FACIL_INVST_FACILITY IS 'Database only element that records the facility name at intake and is updatable in investigation from the Facility Investigation Conclusion Window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.NM_FACIL_INVST_AFF IS 'Database only element that records the facility affiliation name at intake and is updatable in investigation from the Facility Investigation Conclusion Window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.NBR_FACIL_INVST_AFFIL_PHN IS 'This logs the phone number of the affiliated facility if it has not been entered via the Resource Directory. The Address/Phone Detail window is the window to enter this data. If the affiliated facility has been entered into the Resource Directory, the phone information may be viewed via the Facility Investigation Detail-Address/Phone Detail link.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.NBR_FACIL_INVST_PHONE IS 'This logs the phone number of the facility if it has not been entered via the Resource Directory. The Address/Phone Detail window is the window to enter this data. If the facility has been entered into the Resource Directory, the phone information may be viewed via the Facility Investigation Detail-Address/Phone Detail link.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.NBR_FACIL_INVST_AFFIL_EXT IS 'This logs the extension of the affiliated facility if it has not been entered via the Resource Directory. The Address/Phone Detail window is the window to enter this data. If the affiliated facility has been entered into the Resource Directory, the extension information may be viewed via the Facility Investigation Detail-Address/Phone Detail link.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.NBR_FACIL_INVST_EXTENSION IS 'This logs the extension of the facility if it has not been entered via the Resource Directory. The Address/Phone Detail window is the window to enter this data. If the facility has been entered into the Resource Directory, the extension information may be viewed via the Facility Investigation Detail-Address/Phone Detail link.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.TXT_FACIL_INVST_AFFIL_CMNT IS 'Narrative directions or special instructions on the location of an affiliate facility. Example are affiliated facilities that are located in hard to find places, especially in more rural areas.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.TXT_FACIL_INVST_COMMENTS IS 'Narrative directions or special instructions on the location of an facility. Example are facilities that are located in hard to find places, especially in more rural areas.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_AFF_ATTN IS 'Contains the attention field for the affiliated facility address.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_AFF_CITY IS 'Contains the city portion of a facility''s address and is updatable in investigation from the Facility Investigation Conclusion Window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_AFF_CNTY IS 'Contains the county associated with a particular person.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_AFF_ST IS 'Contains the state decode for a facility.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_AFF_STR1 IS 'Contains the street address of a particular facility. It is the first of two address entry fields.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_AFF_STR2 IS 'Contains the street address of a particular facility. It is the first of two address entry fields.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_AFF_ZIP IS 'Contains the facility''s zip at intake and is updatable in investigation from the Facility Investigation Conclusion Window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_ATTN IS 'Contains the attention field for the facility address as accessed from the Facility Investigation Detail window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_CITY IS 'Contains the city portion of a facility''s address and is updatable in investigation from the Facility Investigation Conclusion Window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_CNTY IS 'Contains the county associated with a facility as accessed from the Facility Investigation Conclusion window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_STATE IS 'Contains the state decode for a person.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_STR1 IS 'Contains the street address of a resource as accessed from the Facility Investigation Conclusion window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_STR2 IS 'Contains the street address of a resource as accessed from the Facility Investigation Conclusion window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.ADDR_FACIL_INVST_ZIP IS 'Contains the facility''s zip at intake and is updatable in investigation from the Facility Investigation Conclusion Window.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.DT_FACIL_INVST_INTAKE IS 'Date the incoming information is received (by phone, walk-in, fax, letter, etc.)'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.DT_FACIL_INVST_INCIDENT IS 'This is the date the first incident took place in regard to the facility investigation.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.DT_FACIL_INVST_BEGUN IS 'This is the date the Investigation was begun; this date is actually the date the first contact was recorded.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.DT_FACIL_INVST_COMPLT IS 'Date the last investigation action was made. The Administrative Review process can modify this date. DT FACIL INVST ORIG COMPL should be used to get the original investigation completion date.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.IND_FACIL_SUPERINT_NOTIF IS 'Indicates that the worker has completed his or her investigation and is awaiting Superintendent disposition. This can also indicate that a Request for Review of Findings has been initiated.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.CD_FACIL_INVST_MHMR_CODE IS 'MHMR Facility Identifier number found during the Resource or Affiliated search. Required field if Normal Closure is selected as the reason for closure. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.CD_FACIL_INVST_ORIG_DISP IS 'The original disposition of the AFC investigation.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.CD_FACIL_INVST_ORIG_CLS_RSN IS 'The original reason for closure of the AFC investigation.'
;
COMMENT ON COLUMN CAPS.FACILITY_INVST_DTL.DT_FACIL_INVST_ORIG_COMPL IS 'Date that the original AFC investigation was completed.'
;
COMMENT ON TABLE CAPS.FACILITY_LICENSE_TYPE IS 'Holds Data about Program Licences'
;
COMMENT ON COLUMN CAPS.FACILITY_LICENSE_TYPE.ID_FAC_LIC IS 'Facility License ID'
;
COMMENT ON COLUMN CAPS.FACILITY_LICENSE_TYPE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FACILITY_LICENSE_TYPE.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.FACILITY_LICENSE_TYPE.CD_LIC IS 'Program Licensure Checkboxes'
;
COMMENT ON TABLE CAPS.FACILITY_LOC IS 'The Level of Care that a CPS facility is authorized to provide. Children are designated with a certain level of care; facilities are authorized to provide for children with that level of care, or lower.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.ID_FLOC IS 'The unique identifier for the Facility LOC table.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_1 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_2 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_3 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_4 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_5 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_6 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_7 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_8 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_9 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_10 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_11 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_12 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_13 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_14 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.CD_FLOC_STATUS_15 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.NBR_FLOC_LEVELS_OF_CARE IS 'The number of levels of care that were available at the time this row in the FACILITY_LOC table was created.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.DT_FLOC_EFFECT IS 'The date that the LOC settings for the facility were effective.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.DT_FLOC_END IS 'The end date of a facility level of care.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC.IND_FLOC_CANCEL_HIST IS 'Indicator column used to specify whether or not to copy the currently inserted or updated row to the FACILITY_LOC_AUDIT table.'
;
COMMENT ON TABLE CAPS.FACILITY_LOC_AUDIT IS 'This table audits the FACILITY LOC table and duplicates all the elements in that table.  (Contains no true primary or foreign key constraints.)'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.ID_AUD_FLOC IS 'Primary Key for the FACILITY_LOC_AUDIT table.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.ID_AUD_RESOURCE IS 'Foreign Key that references the CAPS_RESOURCE table (ID_RESOURCE).'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_1 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_2 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_3 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_4 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_5 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_6 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_7 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_8 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_9 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_10 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_11 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_12 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_13 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_14 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.CD_FLOC_AUD_STATUS_15 IS 'A Facility LOC value for placements.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.NBR_FLOC_AUD_LEVELS_OF_CARE IS 'The number of levels of care that were available at the time this row in the FACILITY_LOC table was created.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.DT_FLOC_AUD_EFFECT IS 'The date the facility level of care audit record was effective.'
;
COMMENT ON COLUMN CAPS.FACILITY_LOC_AUDIT.DT_FLOC_AUD_END IS 'The date the facility level of care audit record ended.'
;
COMMENT ON TABLE CAPS.FAD_CLOS_SUM_NARR IS 'This table stores the narrative used for the closing summary window when closing a FAD stage.'
;
COMMENT ON COLUMN CAPS.FAD_CLOS_SUM_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAD_CLOS_SUM_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAD_CLOS_SUM_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAD_CLOS_SUM_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description the FAD home closing summary'
;
COMMENT ON COLUMN CAPS.FAD_CLOS_SUM_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.FAMILY_ASSMT IS 'An assessment of a Family''s strengths and problems related to an incident of abuse or neglect (situation).'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT.ID_FAM_ASSMT_STAGE IS 'Foreign Key that references the STAGE table (ID_STAGE)'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT.DT_FAM_ASSMT_COMPLT IS 'Date that the Family Assessment was completed. Not a field on a window but used to insure worker compliance with policy.'
;
COMMENT ON TABLE CAPS.FAMILY_ASSMT_FACTORS IS 'Factors associated with a CPS Family Assessment. Factors include Behaviors and conditions in a family that characterize abuse and neglect risk.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.ID_FAM_ASSMT_FACTR IS 'A unique integer which identifies a Family Assessment Factor.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.ID_FAM_ASSMT_EVENT IS 'A unique identifier to the family Assessment table.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.ID_FAM_ASSMT_PRINCIPAL IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.IND_FAM_ASSMT_RESPONSE IS 'Used as a Y/N indicator beside each Category and Factor combination in the Family Assessment. Each Factor needs to be addressed with either Y or N in order for the Family Assessment to be complete for the chosen subject of Assessment.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.CD_FAM_ASSMT_FACTR IS 'Filled from the Family Assessment Factors codes table. Code that identifies factors related to certain categories and subjects selected by the caseworker.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.CD_FAM_ASSMT_SUBJECT IS 'Drives the family assessment. Allows the worker to specify a general grouping of factors with which to work. Examples include child or adult factors.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.CD_FAM_ASSMT_CATEGORY IS 'Filled from the Family Assessment Category Codes Tables. Code that identifies a category of factors. Assists the worker in indicating the factors.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_FACTORS.CD_FAM_ASSMT_FACTR_TYPE IS 'Code identifying the specific strength or problem area causing risk in the situation.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON TABLE CAPS.FAMILY_ASSMT_NARR IS 'A blob of narrative (Formatted in MS Word) allowing the worker to add supporting comments to the assessment.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing a Family Assessment.'
;
COMMENT ON COLUMN CAPS.FAMILY_ASSMT_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.FAMILY_PLAN IS 'A plan used to help a family provide their child with a safe environment within a reasonable period of time. This table captures the header information for the plan.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.ID_FAMILY_PLAN IS 'Primary key of the FAMILY_PLAN table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.DT_COMPLETED IS 'The completion date of the item represented by this rows.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.CD_PLAN_TYPE IS 'Identifies the type of service plan to be developed.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.DT_NEXT_REVIEW IS 'The date the first review/evaluation should be performed.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.TXT_RSN_CPS_INVLVMNT IS 'The reason CPS has become involved in the case. The description is printed on the hard copy of the service plan.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.IND_CLIENT_COMMENTS IS 'Checked if the client recorded any comments on the service plan form (paper copy).'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.TXT_STRNGTHS_RSRCS IS 'The ongoing worker''s description of the family''s strengths and/or resources. This description is printed on the hard copy of the service plan.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.TXT_NOT_PARTICIPATE IS 'Explanation of why the parents did not participate in the development of the service plan.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.TXT_PERM_GOAL_COMMENTS IS 'Permanency Goal comments.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.IND_CRT_ORDRD IS 'Indicates if plan is Court Ordered'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.DT_INIT_DUE IS 'Initial Due Date'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.DT_PLAN_PREP IS 'Date Plan Prepared'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.DT_REV_FAM IS 'Date Reviewed with Family '
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.IND_UPDATE_PLAN IS 'Indicator for what type of Family Plan it is'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.ID_EVENT_RISK_ASSMT IS 'A unique identifier to the EVENT table. ID of the Risk Assessment event, if present.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.CD_OUTCOME IS 'Outcome for the Family Plan'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN.IND_COPIED_PLAN IS 'An indicator which tells if the Family plan is copied from an existing plan for page mode purposes.'
;
COMMENT ON TABLE CAPS.FAMILY_PLAN_EVAL IS 'Header information for a given review/evaluation of the family. The evaluation is performed by the ongoing worker to assess the family''s current level of concern/risk for each area of risk and to indentify any new tasks or services aimed at helping the family to reduce the concern/risk to an acceptible level.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL.ID_FAMILY_PLAN_EVALUATION IS 'Primary key of the FAMILY_PLAN_EVAL table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL.ID_FAMILY_PLAN_EVENT IS 'Foreign key to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL.DT_COMPLETED IS 'The completion date of the item represented by this rows.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL.DT_NEXT_DUE IS 'Date the next review/evaluation should be performed.'
;
COMMENT ON TABLE CAPS.FAMILY_PLAN_EVAL_ITEM IS 'The ongoing worker''s review/evaluation of the family regarding a particular area of risk. The evaluation will determine the family''s compliance with the specified tasks/services and the effectiveness of those tasks/services in helping the family to reduce the level of concern/risk.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL_ITEM.ID_FAMILY_PLAN_EVAL_ITEM IS 'Primary key of the FAMILY_PLAN_EVAL_ITEM table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL_ITEM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL_ITEM.ID_FAM_PLAN_EVAL_EVENT IS 'The date this row was inserted or last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL_ITEM.ID_FAMILY_PLAN_ITEM IS 'Primary key of the FAMILY_PLAN_ITEM table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL_ITEM.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL_ITEM.TXT_ITEM_EVALUATION IS 'The ongoing worker''s review/evaluation of the family.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_EVAL_ITEM.DT_APPROVED IS 'This column will never be used.'
;
COMMENT ON TABLE CAPS.FAMILY_PLAN_ITEM IS 'Header information for how the family will reduce risk/concern to an acceptible level for a particular area of concern.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.ID_FAMILY_PLAN_ITEM IS 'Primary key of the FAMILY_PLAN_ITEM table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.CD_AREA_CONCERN IS 'Code indicating the area of risk that is being addressed.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.CD_INITIAL_LEVEL_CONCERN IS 'Code indicating the initial level (or scale) of concern regarding the area of risk. The assessment will be performed either by the worker during the Investigation stage or by the ongoing worker during the Family stage.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.CD_CURRENT_LEVEL_CONCERN IS 'Code indicating the current level (or scale) of concern regarding the area of risk. The assessment will be performed by the ongoing worker during the Family stage.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.TXT_ITEM_GOALS IS 'One or more goals identified for the family aimed at helping them to reduce risk/concern to an acceptible level.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.DT_INITIALLY_ADDRESSED IS 'The date this area of risk was intially addressed.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.IND_IDENTIFIED_IN_RISK_ASSMNT IS 'Indicates whether or not this area of risk was initially addressed in the Risk Assessment that was performed during the Investigation stage that led to the creation of this Family stage.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_ITEM.DT_GOAL_COMP IS 'Date Goals Complete'
;
COMMENT ON TABLE CAPS.FAMILY_PLAN_TASK IS 'A specific task or service identified for the family aimed at helping them to reduce concern/risk to an acceptible level for a particular area of concern.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.ID_FAMILY_PLAN_TASK IS 'Primary key of the FAMILY_PLAN_TASK table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.ID_FAMILY_PLAN_ITEM IS 'Primary key of the FAMILY_PLAN_ITEM table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.IND_COURT_ORDERED IS 'Indicates whether or not this task or service was ordered by the court.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.TXT_TASK IS 'A description of the task or service identified for the family.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.DT_CREATED IS 'The date the row was created.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.DT_COMPLETED IS 'The completion date of the item represented by this rows.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.DT_APPROVED IS 'This column will never be used.'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.DT_TASK_COMP IS 'Date Task Completed'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.DT_COURT_ACT IS 'Date Court Action'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.IND_COURT_CLOSE IS 'Court Mandated Closure'
;
COMMENT ON COLUMN CAPS.FAMILY_PLAN_TASK.TXT_PROGRESS IS 'Comments text box'
;
COMMENT ON TABLE CAPS.FAMILY_SERVICE_REFERRAL IS 'Holds data from the Family service referral page'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.DT_DUE IS 'Date Due'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.DT_COMPLETE IS 'Completed Date'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.ID_PERSON_ASSIGNED IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.TXT_DESC IS 'Short Description'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.TXT_REF_NOTE IS 'Referral Notes'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.ID_PERSON_CREATE IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FAMILY_SERVICE_REFERRAL.DT_REFERRAL IS 'Referral Date'
;
COMMENT ON TABLE CAPS.FCCP_CHILD IS 'Holds Foster Care Case Plan Child Data'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.ID_EVENT IS 'A unique identifier to the EVENT table and primary key for the FFCP_CHILD table'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_EFFRTS_REM IS 'Efforts to prevent removal'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_DILGNT_SRCH IS 'Diligent Search Completed'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.DT_DILGNT_COMP IS 'Diligent Search Complete Date'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_CHILD_ADJ_CARE IS 'Is child adjusting to care'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_CHILD_ADJ_COMM IS 'Reason child is not adjusting to care'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_AFSA IS 'AFSA Comments'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_TPR IS 'Will DFCS petition to terminate parental rights'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.DT_TPR IS 'Date petition filed to TPR'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_TPR IS 'Comments for TPR'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_STEPS IS 'Steps taken to finalize placement'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_ADDTL_INFO IS 'Additional Information'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_IMM_UTD IS 'Immunization Up to Date'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_IMM_UTD IS 'Comments on Immunizations being up to date'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_IMM_ONFILE IS 'Immunization Up On file'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_IMM_ONFILE IS 'Comments on Immunizations On File'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_ONGOING_PROB IS 'Ongoing Medical or Psychological Problems'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_ONGOING_PROB IS 'Comments on Ongoing Medical or Psychological Problems'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_MEDREC_ONFILE IS 'Medical Records on File'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_MEDREC_ONFILE IS 'Comments on Medical Records On file'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_PSYCH_ONFILE IS 'Psych Records On file'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_PSYCH_ONFILE IS 'Comments on Psych Records On file'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_PSYCH_TREAT IS 'Ongoing Medical or Psych treatment'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_PSYCH_DOC IS 'Medical or Psych treatment documented in record'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_EVAL_DATES IS 'Evaluation dates are not in the health record'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.TXT_RELEVANT_MED IS 'Other relevant Medical or Psychological info'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD.IND_PERM_PLAN IS 'Indicator if there is a permancey plan.'
;
COMMENT ON TABLE CAPS.FCCP_CHILD_CBX IS 'Holds the Foster Care Case Plan Checkboxes'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD_CBX.ID_FCCP_CHILD_CBX IS 'Primary Key for FFCP CHILD Checkbox table'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD_CBX.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD_CBX.ID_EVENT IS 'A unique identifier to the EVENT table and primary key for the FFCP_CHILD table'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD_CBX.CD_CBX IS 'Foster Care Case Plan Child checkbox'
;
COMMENT ON COLUMN CAPS.FCCP_CHILD_CBX.CD_CBX_CODE_TYPE IS 'Holds the code type for corresponding check box code.'
;
COMMENT ON TABLE CAPS.FCCP_DTL_FORM_NARR IS 'Narrative to contain the Home Study Comments and description.'
;
COMMENT ON COLUMN CAPS.FCCP_DTL_FORM_NARR.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.FCCP_DTL_FORM_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCCP_DTL_FORM_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FCCP_DTL_FORM_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the FAD Home study.'
;
COMMENT ON COLUMN CAPS.FCCP_DTL_FORM_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON COLUMN CAPS.FCCP_DTL_FORM_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON TABLE CAPS.FCCP_FAMILY IS 'Foster Care Case Plan Family Detail information'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.CD_PLAN_TYPE IS 'Type of Plan'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.NM_ASSGN_JUDGE IS 'Name of assigned judge'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.IND_INIT_REVIEW IS 'Initial or Review Plan'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_INIT_DUE IS 'Initial Due Date'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_ORIG_SUB IS 'Date Original Plan Submitted'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_PREV_REV IS 'Previous Review Date'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_CURR_REV IS 'Current Review Date'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_NEXT_REV IS 'Next Review Date'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.CD_PRIM_PERM_PLAN IS 'Primary Permanency Plan'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_PRIM_COMP_RSNS IS 'Primary Compelling Reasons Perm'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.CD_SECND_PERM_PLAN IS 'Secondary Permanency Plan'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_SECND_COMP_RSNS IS 'Secondary Compelling Reasons Primary Perm'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.CD_REV_TYP IS 'Review Type'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_RSNS_PROT IS 'Reasons children cannot be adequately and safely '
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_HARM IS 'Harm which may occur if children remain in home'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_PERM_ACHVD IS 'Projected Date of achieving Permanency'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.IND_PRNT_PRTCPT IS 'Has the Parent Participated'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_PRNT_PRTCPT IS 'Comments on why Parent has not participated'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.IND_CHILD_PRTCPT IS 'Has the Child Participated'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_CHILD_PRTCPT IS 'Comments on why Child has not participated'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.IND_PRNT_PRESENT IS 'Parent Present but does not sign'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.IND_HEARING_SUB IS 'Hearing Request Submitted'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_HEARING_REQSTD IS 'Date Hearing Requested'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.IND_ASSTNC IS 'Case Manager Assistance Needed'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_BEGIN_AFTERCARE IS 'Aftercare begin date'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.DT_END_AFTERCARE IS 'Aftercare end date'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_RSN_DSCHRG_AFTERCARE IS 'Reason for discharge from aftercare'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.IND_UPDATE_PLAN IS 'Indicator if this is an update version of the plan'
;
COMMENT ON COLUMN CAPS.FCCP_FAMILY.TXT_HEARING_REQUEST_COMMENT IS 'From DBCR 9648
Problems with the MR0013 changes for the FCCP form:
1. If there are 2 caregivers, the form is correctly displaying the 1st caregiver''s information correctly in the caregiver fields, but is displaying the information for the 2nd caregiver underneath the fields.
2. The Participation and Disclosure was mistakenly re-labeled Hearing Request Comments.  Instead, a comment text field was to be added to the FCCP Family Detail page and that field was to be labeled Hearing Request Comments.  Those comments should pull to a corresponding field on the FCCP form.
3. The Additional Comments comments on the Person Detail of a relative who displays on the FCCP form are not pulling over to the form.
'
;
COMMENT ON TABLE CAPS.FCE_AFDC_INCOME_LIMIT IS 'Used to determine income limits for the families of children for whom Federal Title IV-E assistance is being applied.'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.ID_FCE_AFDC_INCOME_LIMIT IS 'Primary key of the FCE_AFDC_INCOME_LIMIT table.'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.NBR_CRTFD_GRP IS 'Number of family members in the certified group.'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.AMT_NO_PARENT_CRTFD_GRP IS 'Total allowable gross income for the no parents certified group.'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.AMT_ONE_PARENT_CRTFD_GRP IS 'Total allowable gross income for the one parent certified group.'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.AMT_TWO_PARENT_CRTFD_GRP IS 'Total allowable gross income for the two parent certified group.'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.AMT_GROSS_INCOME_CEILING IS 'Gross AFDC Income Limit for assistance unit'
;
COMMENT ON COLUMN CAPS.FCE_AFDC_INCOME_LIMIT.AMT_STANDARD_OF_NEED IS 'Standard of Need Income Limit for assistance unit'
;
COMMENT ON TABLE CAPS.FCE_APPLICATION IS 'Information used to determine a child''s initial eligibility for Federal Title IV-E foster care assistance.
'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_FCE_APPLICATION IS 'Primary key of the FCE_APPLICATION table.
'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_PERSON IS 'Id of child for whom the referral was sent  ID_PERSON of the child whose information is described in this row.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_LAST_UPDATE_PERSON IS 'ID_PERSON of person to last update the current row in this table.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_MNGNG_CVS_PERSON IS 'Foreign key for the ID_PERSON of the relative with managing conservatorship during the 6 months prior to the court proceedings being initiated in the PERSON table.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_OTHER_RELATIVE_PERSON IS 'Foreign key for the ID_PERSON of the relative with whom the child was living during the month the court proceedings were initiated in the PERSON table.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ID_FCE_ELIGIBILITY IS 'Primary key of the FCE_ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_HEALTH_ADDR_CITY IS 'Health Insurance Address City.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_HEALTH_ADDR_ST_LN_1 IS 'Health Insurance Street Address 1.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_HEALTH_ADDR_ST_LN_2 IS 'Health Insurance Street Address 2.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_HEALTH_ADDR_ZIP IS 'Health Insurance Address Zip.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_REMOVAL_ADDR_ZIP IS 'Zip of the child''s address in the Home of Removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_REMOVAL_CITY IS 'City of the child''s address of the Home of Removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_REMOVAL_ST_LN_1 IS 'Street address line 1 of the Home of Removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.ADDR_REMOVAL_ST_LN_2 IS 'Street address line 2 of the child Home of Removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_APPLICATION IS 'Code indicating that this is either the first application or a reapplication for a case.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_COUNTY_HOSPITAL IS 'County in which the hospital is located.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_HEALTH_ADDR_STATE IS 'Health Insurance Address State.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_LIVING_MONTH_REMOVAL IS 'The living situation of the child during month court proceedings were initiated.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_NOTA_MOST_RECENT IS 'Most recent living situation for the child before removal if he or she was living with a parent or other relative at any time during the 6 months before removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_REMOVAL_ADDR_COUNTY IS 'County of the child''s address in the Home of Removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_REMOVAL_ADDR_STATE IS 'State of the child''s address in the Home of Removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.CD_STATE IS 'State code for the state in which the hospital is located.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_APPLICATION_COMPLETE IS 'Date the application or reapplication was completed.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_HEALTH_BEGIN_DATE IS 'Health Insurance Begin Date.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_HEALTH_END_DATE IS 'Health Insurance End Date.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_HOSPITAL_ADMISSION IS 'Date the child was admitted to the hospital.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_HOSPITAL_DISCHARGE IS 'Date the child was discharged from the hospital.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_NOTIFIED_WORKER IS 'Date that the worker was notified that the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_PROOF_AGE_SENT_ES IS 'Date on which proof of age was sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_PROOF_CITIZENSHIP_SENT_ES IS 'Date on which proof of citizenship was sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_BAPTISM_CERT IS 'Indicates that the child''s age was verified by a baptismal age certificate.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_FOREIGN_CERT IS 'Indicates that the child''s age was verified by a foreign birth certificate.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_US_BIRTH_CERT IS 'Indicates that the child''s age was verified by a US birth certificate.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_JUSTIFIED_EVAL IS 'Indicates that the child''s age was approximated and justified using an Evaluative Conclusion.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_HOSPITAL_CERT IS 'Indicates that the child''s age was verified by a hospital certificate.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_NTRLZTN_CERT IS 'Indicates that the child''s age was verified by a naturalization certificate.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_PASSPORT IS 'Indicates that the child''s age was verified by a US passport.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_RESIDENT_CARD IS 'Indicates that the child''s age was verified by a US resident card.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_CHILD_SUPPORT_ORDER IS 'Indicates that child support was court ordered to be paid to DFCS.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_EVALUATION_CONCLUSION IS 'An evaluative conclusion has been completed regarding the child''s age and/or citizenship.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_HOSPITAL IS 'Indicates that the child was in the hospital when DFCS was appointed managing conservator.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_INCOME_ASSISTANCE IS 'Indicates that the child received income assistance in the form of TANF, Food Stamps, or Medicaid.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_LEGAL_DOCS_SENT_ES IS 'Indicates that all legal documentation has been sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_LIVING_RELATIVE_SIX_MONTH IS 'Indicates that the child was living with a parent or relative who had managing conservatorship at some time during the 6 months prior the court proceedings being initiated.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_MANAGING_CVS IS 'Indicates that another person had managing conservatorship besides the parent at time of removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_MINOR_PARENT IS 'Indicates that the child''s parent is a minor in DFCS''s managing conservatorship.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_NOTIFIED_DHS_WORKER IS 'Indicates that the DHS worker was notified that the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_OTHER_HEALTH_INSURANCE IS 'Indicates that the child is covered by insurance other than Medicaid.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_PROOF_AGE_SENT_ES IS 'Indicates that proof of age was sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_PROOF_CITIZENSHIP_SENT_ES IS 'Indicates that proof of citizenship was sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NBR_COURT_MONTH IS 'Month in which court procedings were initiated for domicile and deprivation determination.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NBR_COURT_YEAR IS 'Year in which court procedings where initiated for domicile and deprivation determination.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NBR_HEALTH_GROUP IS 'Health Insurance Group Number.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NBR_LIVING_AT_HOME IS 'Number of people living in the home of removal.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NBR_NOTIFIED_DHS_WRKR_PHN IS 'Work phone number of the worker who was notified that the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_HEALTH_COMPANY IS 'Health Insurance Company Name.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_HEALTH_EMPLOYEE_NM IS 'Health Insurance Employee Name.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_HEALTH_EMPLOYER_NM IS 'Health Insurance Employer''s Name.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_HEALTH_POLICY_HLDR_NM IS 'Health Insurance Policy Holder.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_HOSPITAL IS 'The hospital name used to find documentation about the mother of the child.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_HOSPITAL_CITY IS 'City in which the hospital is located.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_MOTHER_MAIDEN IS 'Maiden name of the child''s mother.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_NOTIFIED_DHS_WRKR_FIRST IS 'First name of the worker who was notified that the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_NOTIFIED_DHS_WRKR_LAST IS 'Last name of the worker who was notified that the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NM_NOTIFIED_DHS_WRKR_MIDDLE IS 'Middle name of the worker who was notified that the child was removed from the home.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_INCOME_DTRMNTN_COMMENTS IS 'Summary of how the family''s and child''s income were determined.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_LEGAL_DOCS_SENT_ES IS 'Comments describing the status of legal documents sent or not sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_MEETS_DD_OR_NOT_COMMENTS IS 'Stores comments regarding the child''s Title IV-E deprivation status from the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_NO_INCOME_EXPLANATION IS 'Explanation of how the child and family''s monthly living expenses are met if no monthly income.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_PROOF_AGE_SENT_ES IS 'Comments describing why proof of age was not sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_PROOF_CITIZENSHIP_SENT_ES IS 'Comments describing why proof of citizenship was not sent to the Eligibility Specialist.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_SUCCESS_SYSTEM IS 'Indicator if the age was verified through SUCCESS'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_AGE_VRFD_SAVE_SYSTEM IS 'Indicator if the age was verified through SAVE'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_EVAL_REVIEW_EC_ES IS 'Indicator if the Eligibility Specialist reviewed the Evaluative Conclusion'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_MEDICAL_ASSISTANCE IS 'Indicator if child needed medical assistance for the prior 3 months'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_MONTH_MEDICAL_ASSISTANCE IS 'Months that medical assistance was needed'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_PRF_PREGNANCY_SENT_ES IS 'Indicator if proof of pregnancy was sent to the eligibility specialist'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_PRF_PREGNANCY_SENT_ES IS 'Comments about the proof of pregnancy'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_PRIOR_REMOVAL_MONTHS IS 'months that medical assistance was needed within the 3 months prior to removal'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_PROOF_CHILD_ID_SENT_ES IS 'Boolean Indicator for the question "Are copies of all documents used to verify the child''s Identity being provided to the Eligibility Specialist?"  '
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_PROOF_CHILD_ID_SENT_ES IS 'Date field for when the documents were provided to the Eligibility Specialist'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_PROOF_CHILD_ID_SENT_ES IS 'Comments field to enter comments what documents are provided and if the documents are not provided then why not?'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_PROOF_PREGNANCY_SENT_ES IS 'Date field for when the documents were provided to the Eligibility Specialist'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.TXT_EMPLOYEE_COMMENTS IS 'Comments field allows Case Managers to document additional notes which are submitted to the Eligibility Specialist'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_LEGAL_DOCS_SENT_ES IS 'Date when legal documents were provided to the Eligibility Specialist, including the Affidavit, Petition, and Court Orders'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION.NBR_HEALTH_POLICY IS 'Health Insurance Policy Number.'
;
COMMENT ON TABLE CAPS.FCE_APPLICATION_TEMP_EVENT IS 'Temporarily stores the Event ID for FCE Application.'
;
COMMENT ON COLUMN CAPS.FCE_APPLICATION_TEMP_EVENT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON TABLE CAPS.FCE_ELIGIBILITY IS 'Information used to describe the eligibility of a child for a Title IV-E application.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_FCE_ELIGIBILITY IS 'Primary key of the FCE_ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_FCE_APPLICATION IS 'Primary key of the FCE_APPLICATION table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_FCE_REVIEW IS 'Primary key of the FCE_REVIEW table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_FCE_PERSON IS 'Primary key of the FCE_PERSON table'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_ELIGIBILITY_EVENT IS 'Eligibility Event Id.  The value matches the ID_ELIG_EVENT of the ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_LAST_UPDATE_PERSON IS 'ID_PERSON of person to last update the current row in this table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_COUNTABLE_INCOME IS 'Countable income for the application; amount compared to the AFDC Income Limit table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_GROSS_EARNED_CRTFD_GRP IS 'Monthly countable, earned income of the certified group.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_GROSS_UNEARNED_CRTFD_GRP IS 'Monthly countable, unearned income of the certified group.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_INCOME_LIMIT IS 'Indicates the maximum income allowable for the child''s family based on AFDC Income Limit table..'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_PWE_INCOME IS 'Indicates the gross income of the PWE if he or she works more than 100 hours per month.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_ALIMONY IS 'Amount of court-ordered alimony or child support paid by a stepparent to dependents outside the home.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_ALLOWANCE IS 'Allowance amount for the stepparent and non-certified dependents from Stepparent Allowance Deduction table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_APPLIED_INCOME IS 'Applied income of stepparent; total countable income minus the Allowance amount.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_CNTBL_UNEARNED IS 'Monthly countable, unearned income for the stepparent.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_GROSS_EARNED IS 'Monthly countable, earned income from the stepparent.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_OUTSIDE_PMNT IS 'Payments made by the stepparent to dependents outside the home.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_TOTAL_CNTBL IS 'Total countable monthly income for the stepparent.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STEPPARENT_WORK_DEDUCT IS 'Work related expenses standard deduction for the stepparent.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_SSI IS 'SSI (Income).'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_MOTHER IS 'Indicates absentee mother.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_FATHER IS 'Indicates absentee father.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_ELIGIBILITY_ACTUAL IS 'COLUMN NOT POPULATED.  This data may be acquired from CD_ELIG_ACTUAL in the ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_ELIGIBILITY_SELECTED IS 'COLUMN NOT POPULATED.  This data may be acquired from CD_ELIG_SELECTED in the ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_MEDICAID_ELIGIBILITY_TYPE IS 'COLUMN NOT POPULATED.  This data may be acquired from CD_ELIG_MED_ELIG GROUP in the ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_PERSON_CITIZENSHIP IS 'Code representing the citizenship status of an individual.  This is the citizenship status at the time of application.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_BLOC_CHILD IS 'Billing level of Care for Child (Codes table: CBILPLOC).  This is not necessarily the current BLOC for a child, but is the one in effect at the time of the Title IV-E application.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_MOTHER_PWE IS 'Indicates mother is the primary wage earner.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_FATHER_PWE IS 'Indicates father is the primary wage earner.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.DT_ELIGIBILITY_END IS 'COLUMN NOT POPULATED.  This data may be acquired from DT_ELIG_END in the ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.DT_REMOVAL_CHILD_ORDERED IS 'Date of the first court order ordering the child''s removal from the home.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.DT_REVIEW_DATE IS 'COLUMN NOT POPULATED.  This data may be acquired from DT_ELIG_REVIEW in the ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.DT_RSNBL_EFFORT_PREVENT_REM IS 'Date of the judicial determination of "Reasonable Efforts were made to Prevent Removal"'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.DT_ELIG_DTRMNTN_START IS 'COLUMN NOT POPULATED.  This data may be acquired from DT_ELIG_START in the ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_ALTRNT_CUSTODY IS 'Indicates that the parents have alternating custody of the child.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_DEPORTED IS 'Indicates that the parent has been deported.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_DESERTED IS 'Indicates that the parent has deserted the child.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_DIED IS 'Indicates that the parent is deceased.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_DIVORCED IS 'Indicates that the parent is divorced.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_HOSPITALIZED IS 'Inidcates that the parent is hospitalized.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_INCARCERATED IS 'Indicates that the parent is incarcerated.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_MILITARY_WORK IS 'Indicates that the parent''s absence is due to military or other work related reasons.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_SEPARATED IS 'Indicates that the parents are seperated.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_WORK_RELATED IS 'Indicates that the parent is absent due to work related reason.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CHILD_LIVING_PRNT_6_MNTHS IS 'Indicates that the child was living with a parent or other relative at some time during the 6 months prior the court proceedings being initiated.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_MEETS_DP_OR_NOT_ES IS 'Inticates that the Eligibility Specialist has determined that the child meets the Title IV-E requirements for deprivation.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_MEETS_DP_OR_NOT_SYSTEM IS 'Indicates that the system has determined that the child meets the Title IV-E requirements for deprivation based on the information entered.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CHILD_QUALIFIED_CITIZEN IS 'Indicates that the child is a qualified citizen.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CHILD_SUPPORT_ORDERED IS 'Indicates that child support was court ordered for the child.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CHILD_UNDER_18 IS 'Indicates that the child is under 18 years old.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_ATTORNEY_REVIEW IS 'Indicates that the US child''s citizenship was verified by an attorney who reviewed available documentation.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_BAPTISMAL_CRTFCT IS 'Indicates that the US child''s citizenship was verified by a US baptismal certificate.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_BIRTH_CRTFCT_FOR IS 'Indicates that the child''s citizenship status was determined by a foreign birth certificate or record.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_BIRTH_CRTFCT_US IS 'Indicates that the child''s US citizenship was verified by a US birth certificate.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CHLD_FOUND IS 'Indicates that the US child''s citizenship was determined by the fact that he or she was found in the US under the age of 5.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CITIZEN_CRTFCT IS 'Indicates that the US child''s citizenship was verified by a US citizen certificate.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_EVALUATION IS 'Indicates that the US child''s citizenship was verified by an evaluative conclusion.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_FOR_DOCUMENTATION IS 'Indicates that the child''s citizenship status was determined by other foreign documentation and that the child''s status is undetermined.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_HOSPITAL_CRTFCT IS 'Indicates that the child''s US citizenship was verified by a hospitial certificate.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_NO_DOCUMENTATION IS 'No documents have been located regarding the child''s citizenship.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_NTRLZTN_CRTFCT IS 'Indicates that the US child''s citizenship was verified by a US naturalization certificate.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_PASSPORT IS 'Indicates that the US child''s citizenship was verified by a US passport.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_RESIDENT_CARD IS 'Indicates that the US child''s permanent resident status was verified by an Alien Registration Receipt Card/I-551 (Green Card).'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ELIGIBILITY_COURT_MONTH IS 'Indicates that the child would have been eligible for Title IV-E assistance according to AFDC rules in effect for July 1996.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ELIGIBLE IS 'Indicated that the child is/is not eligible for Federal Title IV-E assistance.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_EQUITY IS 'Indicates that the child has at least $10,000 in property and resources.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_HOME_INCOME_AFDC_ELGBLTY IS 'Indicates that the income in the home is less than or equal to the AFDC Income Limit; meeting the Title IV-E eligibility requirement.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_OTHER_VERIFICATION IS 'Indicates that the disabled status of the child''s parent(s) was verified by other means.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_PARENTAL_DEPRIVATION IS 'Indicates that parental deprivation existed in the home of removal.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_PARENT_DISABLED IS 'Indicates that at least one of the child''s parents is disabled.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_PRS_MANAGING_CVS IS 'Indicates that DFCS was given responsibility for the child''s placement and care, or managing conservatorship, of the child.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_NARRATIVE_APPROVED IS 'Indicates that the Eligibility Specialist has approved the narritive concerning the child''s age and/or citizenship.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_PWE_IRREGULAR_UNDER_100 IS 'Indicates that the Primary Wage Earner (PWE) works irregulary but less than 100 hours per month.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_REMOVAL_CHILD_ORDERED IS 'Indicates that the first order ordering the child''s removal from the home was "In the Child''s Best Interest" or "Remaining in the Home was Contrary to the Welfare of the Child."'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_RSNBL_EFFORT_PRVT_REMOVAL IS 'Indicates that there was a judicial determination that "Reasonable Efforts were made to Prevent Removal" within 60 days of the child''s court-ordered removal from the home.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_PWE_STEADY_UNDER_100 IS 'Indicates that the Primary Wage Earner (PWE) works steady but less than 100 hours per month.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_RSDI_VERIFICATION IS 'Indicates that the disabled status of the child''s parent(s) was verified by RDSI.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_SSI_VERIFICATION IS 'Indicates that the disabled status of the child''s parent(s) was verified by SSI.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.NBR_CERTIFIED_GROUP IS 'Number of people in the certified group.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.NBR_PARENTS_HOME IS 'Indicates the number of parents in the home of removal.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.TXT_DETERMINATION_COMMENTS IS 'Comments for Eligibility Determination Summary.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.NBR_STEPPARENT_CHILDREN IS 'Number of children the stepparent has.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_NEVER_COHABITATED IS 'Indicator if the absent parent has ever cohabited with the child.'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_FCE_ELIG_REASON IS 'Reason for eligibility'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_US_ID_CARD IS 'Indicator if citizenship was verified by US Citizen ID Card (I-97)'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_BIRTH_ABROAD IS 'Indicator if citizenship was verified by Report of Birth Abroad/U.S Citizen (FS-240)'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CONFIRM_BIRTH IS 'Indicator if citizenship was verified by confirmation of birth'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_REFUGEE IS 'Indicator if citizenship was verified by Refugee (I-94)  '
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_STUDENT_VISA IS 'Indicator if citizenship was verified by Student Visa'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_SAVE_SYSTEM IS 'Indicator if citizenship was verified by the Save System'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_COST_CARE_EXCEED_AMT IS 'Indicator if the child''s cost of care exceeds $853'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_COST_CARE_OUT_OF_HOME IS 'Indicator if the child is expected to be in out of home care for a short period of time'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_COST_CARE_EMANCIPATION IS 'Indicator if the child is approaching emancipation'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_COST_CARE_ADOPTED IS 'Indicator if the child is in the process of being adopted'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_OTHER_EXPENDITURES IS 'Indicator if anyone in the removal home has child care or disabled adult care expenses'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CRT_ORDR_BEST_INTRST IS 'Indicator if there was judicial determination containing the words "contrary to the welfare" or "best interests"'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CRT_ORDR_REUNIFY IS 'Indicator if there was judicial determination containing the words "reunify the child and family"'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.DT_DEPRIVATION_CHANGED IS 'The date the deprivation changed'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.TXT_MONTHS_DEPRIVATION IS 'Text field to hold the months of deprivation '
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.TXT_MONTHS_DEP_DISABLED IS 'The months in which deprivation occurred due to disability or incapacitation'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.TXT_MONTHS_DEP_UNDER_EMPL IS 'The months in which deprivation occurred due to underemployment'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.TXT_MONTHS_DEP_UNEMP IS 'The months in which deprivation occurred due to unemployment'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_ABSENT_TPR_VOL_RELINQ IS 'A reason for one of the Legal or Biological parent''s '
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_SUCCESS_SYSTEM IS 'SUCCESS System method of verification of citizenship status '
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_AMER_INDIAN_CRD IS 'American Indian Card method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CIVIL_SERVICE_EMP IS 'Evidence of civil service employment by US Gov''t. before 1976 method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_NORTH_MARIANA_ID IS 'Northern Mariana ID Card method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_FINAL_ADOPT_DECREE IS 'Final Adoption decree method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_VITAL_BIRTH_RCRD IS 'Bureau of Vital Statistics record of Birth/Parentage method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_MILTRY_BIRTH_RCRD IS 'Official military record of service showing a US place of birth method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_US_HSPTL_BRTH_RCRD IS 'Confirmation of Birth method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_LIFE_INS_BRTH_RCRD IS 'Life, Health, or other insurance record showing US place of birth method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CENSUS_BIRTH_RCRD IS 'Census Bureau records of Birth/Parentage method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_MED_BIRTH_RCRD IS 'Medical records of Birth/Parentage method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_RELIG_BIRTH_RCRD IS 'Religious record of Birth method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD IS 'Local Gov''t. record of Birth/Parentage method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_LEGL_IMMI_STAT_EXP IS 'Legal Immigration Status Expired method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_UNACC_MINOR_CHILD IS 'Unaccompanied Minor Child method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_UNDOC_IMMIGRANT IS 'Undocumented Immigrant method of verification of citizenship status'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.TXT_MONTHS_LIVING_REL_CUST IS 'The months in which the child was living with a parent or relative who had legal custody of the child'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STANDARD_OF_NEED IS 'Standard of Need Income Limit'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_CEILING IS 'Gross AFDC'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_DEPENDENT_CARE_DEDUCT IS 'Dependent Care Deduction'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_ALLOC_ALLOWANCE IS 'Allocation Allowance'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_CNT_INCOME_STD_NEED IS 'Total Countable Income (Standard of Need Test)'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_CNT_INCOME_30_ONE_THIRD IS 'Total Countable Income ($30 & 1/3)'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STD_EARNED_INCOME_DEDUCT IS 'Standard Earned Income Deduction'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_CNTBL_RESOURCE_CHILD IS 'Total Countable Resource for the child only'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_GROSS_EARNED_CHILD IS 'Gross Earned income for child only'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_GROSS_UNEARNED_CHILD IS 'Gross Unearned income for child only'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_TOTAL_GROSS_INCOME_CHILD IS 'Total gross income of child only'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_CNTBL_INC_STD_NEED_CHILD IS 'Total Countable Income (Standard of Need Test) for child'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_CNTBL_INC_30_ONE_CHILD IS 'Total Countable Income ($30 & 1/3) for child'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_GROSS_INCOME_CEILING_CHILD IS 'Gross AFDC Income Limit for child'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_STD_OF_NEED_CHILD IS 'Standard of Need Income Limit'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_DEP_CARE_DEDUC_CHILD IS 'Dependent Care Deduction only for the child'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_DRIVER_LIC_OR_ID IS 'Current Driver''s Licence or state ID bearing picture'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_SCHOOL_REC IS 'School Record Showing date and place of birth of the parent(s)'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_MILITARY_DEPDNT_ID IS 'Military dependent ID card with photograph'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CHILD_RECEIVING_SSI IS 'Indicator to check if child is receiving SSI Income'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CERT_IND_BLOOD IS 'A Certificate of Indian Blood as a Method of Citizenship Verification'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_DOC_IMMIG_NAT_ACT IS 'Any Identity document described in section 247A of the Immigration and Naturalization Act as a Method of Citizenship Verification'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_SCHOOL_ID_PHOTO IS 'A School ID with photograph as a Method of Citizenship Verification'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CLINIC_DOC_HOS_DOC IS 'A Clinic, doctor, or hospital record showing date of birth as a Method of Citizenship Verification'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_DAYCARE_NURSE_RCRD IS 'A Daycare or nursery school record showing date and place of birth as a Method of Citizenship Verification'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_AFFIDAVIT_SIGNED IS 'An Affidavit signed under penalty of perjury by a parent or guardian attesting to the child''s identity as a Method of Citizenship Verification'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTZNSHP_CERT_REPORT_BIRTH IS 'A Certification of Report of Birth (DS1350) as a Method of Citizenship Verification'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_OTHER_RELATIVE_PERSON IS 'Id of the Relative (Who Has Custody) with whom child is living'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_30_ONE_THIRD_TEST_ELGBLTY IS 'Indicator for 30 1/3 test'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_30_1_3_CHILD_TEST_ELGBLTY IS 'Indicator for 30 1/3 test for child'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CTNBL_RES_CHILD_ELGBLTY IS 'Indicator for countable resource for child test'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_GROSS_INC_CEILING_ELGBLTY IS 'Indicator for gross income ceiling test'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_GROSS_INC_CHILD_ELGBLTY IS 'Indicator for gross income ceiling for child test'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_SON_CHILD_TEST_ELGBLTY IS 'Indicator for standard of need for child test'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_STD_OF_NEED_TEST_ELGBLTY IS 'Indicator for  standard of need test'
;
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_CHILD_EQUITY IS 'Indicates whether Child has more than $10,000 in property or accessible resources'
;
COMMENT ON TABLE CAPS.FCE_EXPENDITURES IS 'Foster Care Eligibility Expenditures'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.ID_FCE_EXPENDITURES IS 'Primary key - unique id of FCE Expenditures record'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.ID_FCE_ELIGIBILITY IS 'Primary key of the FCE_ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.ID_PERSON_CARE_RECEIVE IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.ID_FCE_PERSON IS 'Primary key of the FCE_PERSON table.'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.NM_SERVICE_PROVIDER IS 'Name of the service provider'
;
COMMENT ON COLUMN CAPS.FCE_EXPENDITURES.AMT_PD_MONTHLY IS 'Monthly amount paid'
;
COMMENT ON TABLE CAPS.FCE_INCOME IS 'Information used to describe the income and resources of persons related to a Title IV-E application.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.ID_FCE_INCOME IS 'Primary key of the FCE_INCOME table.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.ID_FCE_ELIGIBILITY IS 'Primary key of the FCE_ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.ID_INC_RSRC IS 'Primary Key on the INCOME_AND_RESOURCES table..'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.ID_FCE_PERSON IS 'Primary key of the FCE_PERSON table.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.AMT_INCOME IS 'Amount of the income or resource being described.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.CD_TYPE IS 'Specifies the type of income or resource being described.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_INCOME_SOURCE IS 'Indicates the source is an income.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_RESOURCE_SOURCE IS 'Indicates the source is a resource.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_COUNTABLE IS 'Indicates that the income is countable.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_EARNED IS 'Indicates that the income is earned.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_NOT_ACCESSIBLE IS 'Indicates that the income or resource cannot be accessed.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_CHILD IS 'Indicates that this income is the child''s income.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_FAMILY IS 'Indictes that this income is the family''s income.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.IND_NONE IS 'Indicates that the person has no income.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.TXT_VERIFICATION_METHOD IS 'Specifies the method of verification used to verify the income or resource.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.TXT_COMMENTS IS 'Comments describing the income, resource, or special conditions.'
;
COMMENT ON COLUMN CAPS.FCE_INCOME.TXT_SOURCE IS 'Description of the income if the "Other" code is specified for the income''s type.'
;
COMMENT ON TABLE CAPS.FCE_IVE_INCOME_LIMIT IS 'This table has the unique IV-E GIC and SON limit values.'
;
COMMENT ON COLUMN CAPS.FCE_IVE_INCOME_LIMIT.ID_FCE_IVE_INCOME_LIMIT IS 'Unique identifier (artifical key) for FCE_IVE_INCOME_LIMIT table'
;
COMMENT ON COLUMN CAPS.FCE_IVE_INCOME_LIMIT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FCE_IVE_INCOME_LIMIT.NBR_AGE IS 'Age of the child'
;
COMMENT ON COLUMN CAPS.FCE_IVE_INCOME_LIMIT.AMT_GROSS_INCOME_CEILING IS 'Gross Income Ceiling (Dollars)'
;
COMMENT ON COLUMN CAPS.FCE_IVE_INCOME_LIMIT.AMT_STANDARD_OF_NEED IS 'Standard of Need (Dollars)'
;
COMMENT ON TABLE CAPS.FCE_NARRATIVE IS 'Stores the FCE (Foster Care Eligibility) Narratives.'
;
COMMENT ON COLUMN CAPS.FCE_NARRATIVE.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FCE_NARRATIVE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCE_NARRATIVE.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.FCE_NARRATIVE.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.FCE_NARRATIVE.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.FCE_PERSON IS 'Information used to describe a person related to a Title IV-E application.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.ID_FCE_PERSON IS 'Primary key of the FCE_PERSON table.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.ID_FCE_ELIGIBILITY IS 'Primary key of the FCE_ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.CD_REL_INT IS 'Relationship to the child that was removed from the home.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.IND_CERTIFIED_GROUP IS 'Indicates that the person is in the certified group for the application.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.IND_PERSON_HM_REMOVAL IS 'Indicates that the person was living in the home of removal.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.IND_DOB_APPROX IS 'Indicates that the recorded DOB was approximate at the time that the application was filed.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.DT_BIRTH IS 'Date of Birth.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.NBR_AGE IS 'Age at the time that the application or review was marked as completed.'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.IND_LEGAL_CUSTODIAN IS 'Indicator is person was a legal custodian'
;
COMMENT ON COLUMN CAPS.FCE_PERSON.IND_THIRD_PARTY_INSURANCE IS 'Indicator if this person is covered by the third party insurance'
;
COMMENT ON TABLE CAPS.FCE_PWE_UNDEREMPLOYED IS 'Used to describe income limits for the families of children for whom Federal Title IV-E assistance is being applied.'
;
COMMENT ON COLUMN CAPS.FCE_PWE_UNDEREMPLOYED.ID_FCE_UNDEREMPLOYED IS 'Primary key of the FCE_PWE_UNDEREMPLOYED table.'
;
COMMENT ON COLUMN CAPS.FCE_PWE_UNDEREMPLOYED.NBR_FAMILY_CERTIFIED_GRP IS 'Number of people in the certified group.'
;
COMMENT ON COLUMN CAPS.FCE_PWE_UNDEREMPLOYED.AMT_INCOME_LIMIT IS 'Amount indicating the maximum income for a PWE who is considered underemployed given the size of the certified group.'
;
COMMENT ON COLUMN CAPS.FCE_PWE_UNDEREMPLOYED.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.FCE_REASON_NOT_ELIGIBLE IS 'Used to store reasons that a child is not eligible for Federal Title IV-E assistance for a particular application.'
;
COMMENT ON COLUMN CAPS.FCE_REASON_NOT_ELIGIBLE.ID_FCE_REASON_NOT_ELIGIBLE IS 'Primary key for the FCE_REASON_NOT_ELIGIBLE table.'
;
COMMENT ON COLUMN CAPS.FCE_REASON_NOT_ELIGIBLE.ID_FCE_ELIGIBILITY IS 'Primary key of the FCE_ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_REASON_NOT_ELIGIBLE.CD_REASON_NOT_ELIGIBLE IS 'Describes a reason that a child is not eligibile for Federal Title IV-E assistance.'
;
COMMENT ON COLUMN CAPS.FCE_REASON_NOT_ELIGIBLE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.FCE_REVIEW IS 'Information used to determine a child''s continuing eligibility for Title IV-E application.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_FCE_REVIEW IS 'Primary key of the FCE_REVIEW table.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_FCE_APPLICATION IS 'Primary key of the FCE_APPLICATION table.
'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_LAST_UPDATE_PERSON IS 'ID_PERSON of person to last update the current row in this table.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_FCE_ELIGIBILITY IS 'Primary key of the FCE_ELIGIBILITY table.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.AMT_SAVINGS IS 'Current balance of the savings account set up by DFCS.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.CD_CHANGE_CTZN_STATUS IS 'Indicates that there was a change in the child''s citizenship status.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.CD_LIVING_CONDITION_CURRENT IS 'Code indicating the living conditions of the home of removal at the time of the review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.CD_PERSON_CITIZENSHIP IS 'Code representing the citizenship status of an individual.  This is the citizenship status at the time of review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_CHILD_ENTER_HIGHER IS 'Date that the child plans to enter higher education.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_CHILD_CMPLT_HIGH_SCHOOL IS 'Date that the child plans to finish high school.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_REVIEW_COMPLETE IS 'Date that the review was completed.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_RIGHTS_TERMINATED IS 'Date that parental rights were terminated.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_CHILD_ACCPTD_HIGHER IS 'Indicates that the child was accepted into a higher education program.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_CHILD_ENROLLED IS 'Indicates that the child is currently enrolled in school.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_CHILD_CMPLT_19 IS 'Indicates that the child plans to complete high school before turning 19.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_CMPLT_SCHL_MAX_AGE IS 'Indicator if the child has completed school.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_CURRENT_PARENT_SIT IS 'Indicates that the child''s parents are living together in the home of removal.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_PERMANENCY_HEARINGS IS 'Indicates that a permanency or placement review hearing since the last review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_PRMNCY_HEARINGS_DUE IS 'Indicates the child Permanency Plan is due for child.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_PRMNCY_HRNGS_12_MONTH IS 'Indicates the judicial finding regarding the child''s Permanency Plan was made during the past 12 months.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_RIGHTS_TERMINATED IS 'Indicates that parental rights were terminated.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_SAVINGS_ACCT IS 'Indicates that the child has a savings account set up by DFCS.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_CHILD_INCOME_GT_FC_PAY IS 'Indicates the child''s income is greater than the pay received by the foster home.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_TDPRS_RESPONSIBILITY IS 'Indicates the child is under DFCS responsibility.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_NO_ACTIVE_PLACEMENT IS 'The child has/had no active placements at the time of review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_NON_PRS_PAID_PLACEMENT IS 'The child''s active placement was not DFCS PAID at the time of review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_NO_ACTIVE_BLOC IS 'The child has no active BLOCs at the time of the review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_NO_OPEN_PAID_ELIGIBILITY IS 'The child has/had no DFCS-paid eligibility at the time of the review (Title IV-E, State-Paid, MAO).'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_REVIEW_INAPPROPRIATE IS 'User override to cancel review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.TXT_INAPPROPRIATE_COMMENTS IS 'Comments why a review is no longer appropriate for the child.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_CURRENT_PLACEMENT_EVENT IS 'Current placement id for the child at the time of the review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.ID_PLACEMENT_RATE_EVENT IS 'Placement id for the child used to calculate the foster care rate.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.CD_RATE IS 'Placement code (plcmntsv) used to find the foster care rate.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.AMT_FOSTER_CARE_RATE IS 'Foster care rate used to determine Title IV-E eligibility.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_SHOW_CHECKLIST IS 'Indicates a "Non-Title IV-E Checklist" is associated with this review.'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_CHILD_CARE_COURT_ORDER IS 'Indicator for the question Did the child enters care prior to 3/27/2000 via a court order?'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_BEST_INTEREST_LANG IS 'Indicator for the question "Was there a judicial determination containing the "contrary to the welfare" or "best interest" language?"'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_RESNABL_EFRT_REUNIFY IS 'Indicator for the question "Was there a judicial determination containing the "Reasonable efforts were made to Reunify the Child and Family" language?"'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_RESNABL_EFRT_PRVNT_RMVAL IS 'Indicator for the question "Was there a judicial determination containing the "Reasonable efforts were made to Prevent Removal" language?"'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.NBR_MHN_NUMBER IS 'MHN Number'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_PRMNCY_HRNGS_12_MONTH IS 'Date of Judicial Determination regarding "Reasonable Efforts to Finalize the child''s Permanency Plan" made during the past 12 months'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_COURT_ORDER IS 'Date of court order when child enter ed care prior to 3/27/2000 via a court order'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_BEST_INTEREST_LANG IS 'Date of Judicial Determination for a judicial determination containing the "contrary to the welfare" or "best interest" language'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_RESNABL_EFRT_REUNIFY IS 'Date of Judicial Determination for a judicial determination containing the "Reasonable efforts were made to Reunify the Child and Family" language'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.DT_RESNABL_EFRT_PRVNT_RMVAL IS 'Date of Judicial Determination for a judicial determination containing the "Reasonable efforts were made to Prevent Removal" language'
;
COMMENT ON COLUMN CAPS.FCE_REVIEW.IND_EXTNSION_PROVIDED_12_MNTHS IS 'Indicator if a 12 month extension was provided'
;
COMMENT ON TABLE CAPS.FCE_STEPPARENT_ALLOWANCE IS 'Used to income limits for the families of children for whom Federal Title IV-E assistance is being applied.'
;
COMMENT ON COLUMN CAPS.FCE_STEPPARENT_ALLOWANCE.ID_FCE_STEPPARENT_ALLOWANCE IS 'Primary key of the FCE_STEPPARENT_ALLOWANCE table.'
;
COMMENT ON COLUMN CAPS.FCE_STEPPARENT_ALLOWANCE.NBR_FAMILY_NOT_CERTIFIED IS 'Number of people in the group of family members including the stepparent and all of the stepparent''s dependents not in the certified group'
;
COMMENT ON COLUMN CAPS.FCE_STEPPARENT_ALLOWANCE.AMT_ALLOWANCE_DEDUCTION IS 'Amount of the allowed deduction given the number of non-certified dependents.'
;
COMMENT ON COLUMN CAPS.FCE_STEPPARENT_ALLOWANCE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.FCE_THIRD_PARTY_INSURANCE IS 'Foster Care table documenting if the child had other insurance'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.ID_FCE_APPLICATION IS 'Primary key of the FCE_APPLICATION table.
'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.IND_CHILD_COVERAGE IS 'Indicator if the child is covered by any 3rd party health insurance'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.CD_TYPE IS 'Type of insurance'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.NM_COMPANY IS 'Company Name'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.NBR_GROUP IS 'Group Number'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.ADDR_STREET_LN1 IS 'Address Line 1'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.ADDR_STREET_LN2 IS 'Address Line 2'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.ADDR_CITY IS 'City'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.ADDR_STATE IS 'State'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.ADDR_ZIP IS 'Zip Code'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.NBR_PHONE IS 'Phone Number'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.DT_BEGIN IS 'Begin date of coverage'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.DT_END IS 'End Date of Coverage'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.NM_EMPLOYER IS 'Name of the Employer'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.NM_EMPLOYEE_NAME IS 'Name of the Employee'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.IND_AUTH_RELEASE IS 'Indicator if the person authorized the release of information to DCH'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.IND_AUTH_ASSIGN IS 'Indicator if the person authorized and assigned payments to DCH'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.DT_AUTH_RELEASE IS 'Date of the authorization of release of information'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.DT_AUTH_ASSIGN IS 'Date of the authorization of assignment of payments'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.IND_CHANGE_CANCEL IS 'Indicator if the insurance changed or was cancelled'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.DT_CHANGE_CANCEL IS 'Date of the change or cancellation'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.NM_POLICY_HOLDER IS 'Name of the Policy Holder'
;
COMMENT ON COLUMN CAPS.FCE_THIRD_PARTY_INSURANCE.NBR_POLICY IS 'Policy Number'
;
COMMENT ON TABLE CAPS.FIN_ACCT_TRAN_AUDIT IS 'This table audits the FIN_ACCT_TRANSACTION table and duplicates all the elements in that table.  This table will be populated by a trigger on  the FIN_ACCT_TRANSACTION table.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.ID_FIN_ACCT_TRAN_AUD IS 'Primary Key of the FIN_ACCT_TRAN_AUDIT table.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.ID_FIN_ACCT_TRAN IS 'A unique identifier for the financial account Transaction table.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.ID_FIN_ACCT IS 'A unique identifier for the financial account table.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.AMT_ACCT_TRAN_AUD_AMOUNT IS 'The amount of this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.AMT_ACCT_TRAN_AUD_BALANCE IS 'The balance left by this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.CD_ACCT_TRAN_AUD_CATEGORY IS 'The category code for this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.CD_ACCT_TRAN_AUD_TYPE IS 'The type code for this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.DT_ACCT_TRAN_AUD_DATE IS 'The transaction date.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.NBR_ACCT_TRAN_AUD_COUNT IS 'The count for this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.NBR_ACCT_TRAN_AUD_WARRANT_NBR IS 'The warrant number for this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.TXT_ACCT_TRAN_AUD_DESCR IS 'The description of this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.CD_ACCT_TRAN_AUD_SUBCATEGORY IS 'The sub-category for this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.NM_ACCT_TRAN_AUD_PAYEE_NAME IS 'The name of the payee for this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.IND_ACCT_TRAN_AUD_RECONCILED IS 'The indicator whether the transaction has been reconciled.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.ID_EMPLOYEE_LOGON_AUD IS 'The logon ID of the user that performed this transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRAN_AUDIT.CD_ACCT_TRAN_AUD_DML_TYPE IS 'The DML code related to this transaction: .I.-Insert, .U.-Update, .D.-Delete.'
;
COMMENT ON TABLE CAPS.FIN_ACCT_TRANSACTION IS 'Stores different transactions for a particular client''s financial account.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.ID_FIN_ACCT_TRAN IS 'A unique identifier for the financial account Transaction table.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.ID_FIN_ACCT IS 'A unique identifier for the financial account table.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.AMT_ACCT_TRAN_AMOUNT IS 'Contains the amount for each individual transaction. The sign (positive/negative) is determined by the transaction type selected.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.AMT_ACCT_TRAN_BALANCE IS 'Contains the balance for the individual account.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.CD_ACCT_TRAN_CATEGORY IS 'Contains the code for the category of debit/credit for each transaction record.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.CD_ACCT_TRAN_TYPE IS 'Contains the code for the type of transaction (debit/credit).'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.DT_ACCT_TRAN_DATE IS 'Contains the user specified date of the transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.NBR_ACCT_TRAN_COUNT IS 'Contains the number of transactions for the individual account. It is incremented every time a new transaction record is added.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.NBR_ACCT_TRAN_WARRANT_NBR IS 'Contains the user specified check/warrant number for the transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.TXT_ACCT_TRAN_DESCR IS 'Contains user specified information that further clarifies the category of debit/credit for the transaction.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.CD_ACCT_TRAN_SUBCATEGORY IS 'Contains the sub-category  code for  the debit/credit associated with a transaction record.  Link to the CACTSUB code_type.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.NM_ACCT_TRAN_PAYEE_NAME IS 'Contains the payee name for this transaction record.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.IND_ACCT_TRAN_RECONCILED IS 'Indicates whether the financial account transaction has been reconciled.'
;
COMMENT ON COLUMN CAPS.FIN_ACCT_TRANSACTION.ID_EMPLOYEE_LOGON IS 'Employee''s Novell logon ID.'
;
COMMENT ON TABLE CAPS.FINANCIAL_ACCOUNT IS 'Stores financial account transactions and balances for a given person.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.ID_FIN_ACCT IS 'A unique identifier for the financial account table.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.ADDR_FIN_ACCT_ADDR1 IS 'Contains the first line of the address for a financial institution.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.ADDR_FIN_ACCT_ADDR2 IS 'Contains the second line of an address for a financial institution.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.ADDR_FIN_ACCT_CITY IS 'Contains the city for a financial institution.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.ADDR_FIN_ACCT_ZIP IS 'Contains the zip code for a financial institution.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.AMT_FIN_ACCT_BALANCE IS 'Contains the balance for the account as of the last save by the user.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.CD_FIN_ACCT_STATE IS 'The state in which the financial institution that a ward of the state''s account belongs to.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.CD_FIN_ACCT_STATUS IS 'Contains the status of the client account (active/closed).'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.CD_FIN_ACCT_CNTY IS 'Code for county of Financial Institution. Created because CINV24W allows user to change the value of the county passed into the window, so it must be stored on the Financial Account table.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.CD_FIN_ACCT_TYPE IS 'Contains the code for the type of account (checking, savings or trust fund).'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.DT_FIN_ACCT_BALANCE_DATE IS 'Contains the date for the latest ending balance.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.DT_FIN_ACCT_END_DATE IS 'Contains the date that the account is closed.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.DT_FIN_ACCT_START_DATE IS 'Contains the date that the account is activated.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.NBR_FIN_ACCT_ACCOUNT IS 'Contains the user specified account number (the number is from an external financial institution) for the client account.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.NBR_FIN_ACCT_PHONE IS 'Contains the phone number for a financial institution.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.NBR_FIN_ACCT_EXT IS 'Contains the phone extension for a particular financial institution record.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.NBR_FIN_ACCT_TRANS_COUNT IS 'Contains the transaction count for the individual account.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.NM_FIN_ACCT_INST_NAME IS 'Contains the name of a financial institution.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.TXT_FIN_ACCT_COMMENTS IS 'Contains the comments for a particular financial institution record.'
;
COMMENT ON COLUMN CAPS.FINANCIAL_ACCOUNT.CD_PROGRAM IS 'Code that identifies the program.'
;
COMMENT ON TABLE CAPS.FMIS_BATCH_NBR IS '(Effective 9/1/1998, use of this table was discontinued.  It is replaced by the DLN_BATCH_NBR table.)  Used by the FMIS DLN application process to keep track of the available batch number range and where we are in that range.'
;
COMMENT ON COLUMN CAPS.FMIS_BATCH_NBR.ID_FMIS_BATCH IS 'The unique sequence identifier for the FMIS BATCH NBR table.'
;
COMMENT ON COLUMN CAPS.FMIS_BATCH_NBR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FMIS_BATCH_NBR.MO_FMIS_BATCH_MONTH IS 'The month in which the Batch process is run.'
;
COMMENT ON COLUMN CAPS.FMIS_BATCH_NBR.NBR_FMIS_BATCH_END IS 'End of the possible batch number range.'
;
COMMENT ON COLUMN CAPS.FMIS_BATCH_NBR.NBR_FMIS_BATCH_NEXT_AVAIL IS 'Next batch number available for assignment.'
;
COMMENT ON COLUMN CAPS.FMIS_BATCH_NBR.NBR_FMIS_BATCH_START IS 'Start of the possible batch number range.'
;
COMMENT ON COLUMN CAPS.FMIS_BATCH_NBR.YR_FMIS_BATCH_YEAR IS 'Contains the billing year for the batch.'
;
COMMENT ON TABLE CAPS.FMIS_BREAKOUT IS 'Used by the ISAS roll-up process to hold line items that have a unique combination of PAC and Object code, month and year of service, id_contract and vendor ID.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.ID_BREAKOUT IS 'A unique identifier for the FMIS BREAKOUT table.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.ID_SVC_AUTH_DTL IS 'A unique identifier for a row on the SVC AUTH DTL table.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.AMT_BREAKOUT_FEE_INCOME IS 'Allows the process to track the totals and update the contract service correctly.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.AMT_BREAKOUT_LINE_AMOUNT IS 'The amount for a specific line item that is to be pulled from a specific PAC and Object code.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.AMT_BREAKOUT_OTHER_AMOUNT IS 'The amount for a specific line item that is to be pulled from a specific PAC and Object code.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.AMT_BREAKOUT_SVC_DTL_QTY IS 'Number of units on the delivered service line item.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.CD_BREAKOUT_INVO_TYPE IS 'Type of invoice that is being rolled up.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.CD_BREAKOUT_OBJ_CODE IS 'Object code for the invoice line item. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.CD_BREAKOUT_PAC IS 'PAC for the invoice line item. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.CD_BREAKOUT_REGION IS 'Region of the contract.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.IND_BREAKOUT_TYC_JPC IS 'Flag indicating if the line item is for TYC/JPC.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.MO_BREAKOUT_SVC_MONTH IS 'Month of service for the invoice line item. Not the same as the billing month.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.NBR_BREAKOUT_CLSI IS 'Contract service line that the invoice line item references.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.NBR_BREAKOUT_DLN IS 'Document Locator Number that the invoice line item references.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.NBR_BREAKOUT_LINE_XREF IS 'Cross reference number that the DLN application process uses to know what line items belong to the same DLN.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.NBR_BREAKOUT_TO_DAY IS 'To day on the Foster Care line item.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.NBR_BREAKOUT_VID IS 'Vendor ID for the payee of the invoice.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.YR_BREAKOUT_SVC_YEAR IS 'Year of service for the invoice line item. Not the same as the billing year.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.DT_BRKOUT_PYMNT_DUE IS 'No description available'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.IND_BRKOUT_BLNC_DELAY IS 'No description available.'
;
COMMENT ON COLUMN CAPS.FMIS_BREAKOUT.NBR_CNTRCT_PRD IS 'Contains a number identifying the period for a specific contract.  Each period covers a specific time frame.'
;
COMMENT ON TABLE CAPS.FOSTER_CARE_RATE IS 'This defines a relationship between a derived Foster Care service code and a unit rate and the effective dates.'
;
COMMENT ON COLUMN CAPS.FOSTER_CARE_RATE.ID_FCARE_RATE IS 'The unique sequence primary key for the FOSTER CARE RATE table.'
;
COMMENT ON COLUMN CAPS.FOSTER_CARE_RATE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FOSTER_CARE_RATE.AMT_FCARE_RT_UNIT_RATE IS 'The amount for unit rate expenditures for Foster Care.'
;
COMMENT ON COLUMN CAPS.FOSTER_CARE_RATE.CD_FCARE_RATE_SERVICE IS 'The rate at which the service is delivered to the client.'
;
COMMENT ON COLUMN CAPS.FOSTER_CARE_RATE.DT_FCARE_RT_END IS 'Contains the end date of a rate for Foster Care.'
;
COMMENT ON COLUMN CAPS.FOSTER_CARE_RATE.DT_FCARE_RT_START IS 'Contains the start date of a rate for Foster Care.'
;
COMMENT ON COLUMN CAPS.FOSTER_CARE_RATE.CD_AGE_RANGE IS 'Age range code associated with this foster care rate'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.ID_EVENT IS 'Event id of the Foster Home Conversion event'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.ID_ADO_AGENCY IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.DT_INQUIRY IS 'Inquiry date for the foster home conversion'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.DT_APPLIED IS 'Applied date for the foster home conversion'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.DT_APPROVAL IS 'Date home was approved'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.DT_CLOSURE IS 'Closure date of the foster home conversion'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.CD_CLOSURE_REASON IS 'Reason for ending foster home conversion'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV.CD_CONV_APP_STATUS IS 'Approval status of the home'
;
COMMENT ON TABLE CAPS.FOSTER_HOME_CONV_PER_LINK IS 'Table to link a child to a foster home conversion'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV_PER_LINK.ID_FOSTER_HOME_CONV_EVENT IS 'Event id of the Foster Home Conversion event'
;
COMMENT ON COLUMN CAPS.FOSTER_HOME_CONV_PER_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON TABLE CAPS.FSTR_CARE_AST_APP_NARR IS 'Table to store the narrative of the foster care assistance application.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_APP_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_APP_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_APP_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_APP_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing a Foster Care Assistance application.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_APP_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.FSTR_CARE_AST_RVW_NARR IS 'Table to store the narrative of the foster care assistance review.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_RVW_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_RVW_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_RVW_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_RVW_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing a Foster Care Assistance review.'
;
COMMENT ON COLUMN CAPS.FSTR_CARE_AST_RVW_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.FUNDING_STREAM IS 'Stores information used by the invoice validation batch process to determine the proper source (PAC/Object) of funding for a payment line item.  A combination of data gathered from client information is matched to this table to result in the appropriate Funding Stream row.  This is a static table referenced exclusively by invoice validation to get data needed to retrieve coding from the Equivalency table.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.ID_FNDSTR IS 'This element is the primary key for the FUNDING_STREAM table.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.CD_FNDSTR_AUTH_LOC IS 'Code lookup value that is matched agains a child''s Adoption Subsidy determination.  The code indicates the types of Adoption Subsidy determination for which a child can be eligible.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.CD_FNDSTR_ELIG_MED_GROUP IS 'Code lookup value that is matched against the medicaid eligibility group for a child.  It is used in a look up of the FUNDING_STREAM table, which feeds a look up of the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.CD_FNDSTR_ELIG_SELECTED IS 'Code lookup value that is matched against a person''s selected eligibility and is used in a table lookup of the FUNDING_STREAM table which feeds a look up of the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.CD_FNDSTR_FUND_STREAM IS 'This element is the output of a lookup of the FUNDING_STREAM table and is used in a lookup of the EQUIVALENCY table. It identifies the funding stream from which a particular line item is paid. Please reference the department''s Financial System for additional information.  There is no associated codes table for this data element as the TXT FNDSTR DESCRIP is essentially the decode for each code.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.CD_FNDSTR_PLOC_BLOC IS 'Code lookup value that is matched against a person''s billing level of care (BLOC) and is used in a look up of the FUNDING_STREAM table, which feeds a look up of the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.DT_FNDSTR_START_DATE IS 'This record is used to hold the start date of a FUNDING_STREAM record''s validity.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.DT_FNDSTR_END_DATE IS 'Contains the end date of a FUNDING_STREAM record''s validity.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.IND_FNDSTR_EMER_ASSIST IS 'Contains an indicator which tells whether or not emergency assistance was rendered. This is part of the FUNDING_STREAM look up, which feeds the look up from the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.IND_FNDSTR_TITLE_XIX IS 'This element is an indicator for Title 19 eligibility. It is used in a look up from the FUNDING_STREAM table, which feeds a look up of the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.TXT_FNDSTR_DESCRIP IS 'Contains a brief description of a FUNDING_STREAM record.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.CD_FNDSTR_ELIG_CODE IS 'Code lookup value that is matched against the client''s DHS eligibility.'
;
COMMENT ON COLUMN CAPS.FUNDING_STREAM.CD_FNDSTR_ADS_DETERM IS 'Code lookup value that is matched agains a child''s Adoption Subsidy determination.  The code indicates the types of Adoption Subsidy determination for which a child can be eligible.'
;
COMMENT ON TABLE CAPS.HOME_APPLICANT_CBX IS 'Holds Inquiry and Pre-Service checkboxes from the Home Information page'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_CBX.ID_HOME_APPLICANT_CBX IS 'Home Applicant Checkbox ID'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_CBX.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_CBX.ID_HOME_APPLICANT IS 'Home Applicant ID'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_CBX.CD_HOME_APPLICANT_CBX IS 'Sources of Inquiry, Information Covered, Programs of Interest Checkboxes'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_CBX.CD_HOME_APLCNT_CBX_TYPE IS 'Represents the home applicant type'
;
COMMENT ON TABLE CAPS.HOME_APPLICANT_INFO IS 'Holds Inquiry and Pre-Service information from the Home Information page'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.ID_HOME_APPLICANT IS 'Home Applicant ID'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_INQUIRY IS 'Inquiry Date'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_INQUIRY_RCVD IS 'Inquiry Received By'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_INFO_PACKET IS 'Information Packet Requested'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_INFO_SENT IS 'Information Packet Sent'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.TXT_CHILD_INT IS 'Child Specific Interest'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.TXT_INQRY_COMM IS 'Inquiry Comments'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_ORIENT1 IS 'Orientation 1'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_ORIENT1_STAT IS 'Status'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_ORIENT2 IS 'Orientation 2'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_ORIENT2_STAT IS 'Status'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_ORIENT3 IS 'Orientation 3'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_ORIENT3_STAT IS 'Status'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_INVITE1 IS 'Invite 1'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_INVITE1_STAT IS 'Status'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.TXT_INVITE1_LOC IS 'Location'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_INVITE2 IS 'Invite'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_INVITE2_STAT IS 'Status'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.TXT_INVITE2_LOC IS 'Location'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.DT_INVITE3 IS 'Invite 3'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.CD_INVITE3_STAT IS 'Status'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.TXT_INVITE3_LOC IS 'Location'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.TXT_TRN_COMM IS 'Training Comments'
;
COMMENT ON COLUMN CAPS.HOME_APPLICANT_INFO.INQ_REQ_NBR_CHLDRN IS 'Represents requested number of children inquiry information subsection'
;
COMMENT ON COLUMN CAPS.HOME_ETHNICITY.DT_LAST_UPDATE IS 'date last updated'
;
COMMENT ON COLUMN CAPS.HOME_ETHNICITY.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.HOME_ETHNICITY.CD_ETHNICITY IS 'ethnicity code'
;
COMMENT ON COLUMN CAPS.HOME_RACE.DT_LAST_UPDATE IS 'date last updated'
;
COMMENT ON COLUMN CAPS.HOME_RACE.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.HOME_RACE.CD_RACE IS 'Race code'
;
COMMENT ON TABLE CAPS.HOME_STUD_NARR IS 'Narrative to contain the Home Study Comments and description.'
;
COMMENT ON COLUMN CAPS.HOME_STUD_NARR.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.HOME_STUD_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.HOME_STUD_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.HOME_STUD_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the FAD Home study.'
;
COMMENT ON COLUMN CAPS.HOME_STUD_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.HSEGH_NARR IS 'Table to store the narrative for the HESGH report.'
;
COMMENT ON COLUMN CAPS.HSEGH_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.HSEGH_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.HSEGH_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.HSEGH_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative of the HSEGH documents of a child in Sub-Care.'
;
COMMENT ON COLUMN CAPS.HSEGH_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.IMPACT_ERRORS IS 'Used for on demand  application tracing only.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.ID_ERROR IS 'Primary key - id of the impact error.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.ID_PERSON IS 'Id of person associated with the error, if any.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.TS_ERROR_OCCURRED IS 'timestamp of error.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.ID_EXCEPTION IS 'exception id.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.ID_CSC_PROBLEM IS 'csc problem id.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.SZ_IMPACT_VERSION IS 'impact version number.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.SZ_ERROR_REPORT_TYPE IS 'error type.'
;
COMMENT ON COLUMN CAPS.IMPACT_ERRORS.BL_ERROR IS 'Batch lock error.'
;
COMMENT ON TABLE CAPS.IMPACT_PERFORMANCE IS 'Used for on demand  application tracing only.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.ID_IMPACT_PERFORMANCE IS 'Primary key - id of the impact performance record.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.ID_COMMAND IS 'Id of the Impact Command - Command Name.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.SZ_TRANSACTION_GUID IS 'Transaction id.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.SZ_TRANSACTION_PARENT_GUID IS 'Transaction Parent id.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_TRANSACTION_START IS 'Number of the transaction.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_TOTAL_SERVER_TIME IS 'Total time on the server.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_TOTAL_USER_TIME IS 'Total time on the client.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_VALIDATION_TIME IS 'Total time for validation.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_XA_TIME IS 'Total time for transation.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_SERVICE_TIME IS 'Total time for service.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_EJB_TIME IS 'Total time for EJB.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_CASE_UTILITY_TIME IS 'Total time for Case Utility.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_MARSHALL_TIME IS 'Total time for marshalling.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_JSP_TIME IS 'Total time in JSP.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_REQUEST_SIZE IS 'Total size of request.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_STATE_SIZE IS 'Total size of state.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.NBR_ACTIVE_TRANSACTIONS IS 'Number of active transactions.'
;
COMMENT ON COLUMN CAPS.IMPACT_PERFORMANCE.ID_PERSON IS 'Id of person associated with the transaction'
;
COMMENT ON TABLE CAPS.INCMG_DETERM_FACTORS IS 'Behaviors or conditions that characterize an abuse, neglect, or exploitation, incident at intake.'
;
COMMENT ON COLUMN CAPS.INCMG_DETERM_FACTORS.ID_DETERMINATION IS 'A unique integer which identifies an Incoming Determination.'
;
COMMENT ON COLUMN CAPS.INCMG_DETERM_FACTORS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCMG_DETERM_FACTORS.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.INCMG_DETERM_FACTORS.ID_INCMG_DETERM_STAGE IS 'Foreign Key to the stage table. Stores the id_stage for the Intake.'
;
COMMENT ON COLUMN CAPS.INCMG_DETERM_FACTORS.CD_INCMG_DETERM IS 'A code that determines the level of severity when the case was in intake.'
;
COMMENT ON COLUMN CAPS.INCMG_DETERM_FACTORS.CD_INCMG_DETERM_TYPE IS 'Identifies an entry in the Incoming Determination table as an allegation descriptor or a determination factor.'
;
COMMENT ON COLUMN CAPS.INCMG_DETERM_FACTORS.TXT_DET_FAC_CMNTS IS 'This column is used to enter the answers to the determination factor question on the Physical Abuse section.'
;
COMMENT ON TABLE CAPS.INCOME_AND_RESOURCES IS 'Income and Resources belonging to a principal.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.ID_INC_RSRC IS 'Primary Key on the INCOME_AND_RESOURCES table.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.ID_INC_RSRC_WORKER IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.AMT_INC_RSRC IS 'Contains the amount or value of the income/resources.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.CD_INC_RSRC_TYPE IS 'The user chooses the type of income or resources being recorded. The list is changed depending on whether an income or resource is being entered.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.CD_INC_RSRC_INCOME IS 'This element distinguishes between incomes and resources.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.DT_INC_RSRC_FROM IS 'The date that the income and/or resource is effective from is entered here. The system defaults the system date, but the user can modify if desired.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.DT_INC_RSRC_TO IS 'The date that the income or resource is effective is recorded her. The information is not mandatory to save the record. However, the user cannot have two overlapping records of the same resource type.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.IND_INC_RSRC_NOT_ACCESS IS 'Indicates whether income and resource information is accessible or not.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.SDS_INC_RSRC_SOURCE IS 'The source of the income and/or resource is entered here. This information is optional.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.SDS_INC_RSRC_VERF_METHOD IS 'The verification method is entered here. This is optional information.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_DESC IS 'The user can enter additional information in this window.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.CD_INC_RSRC_FREQ_TYPE IS 'frequency of income or resource.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_PHONE_NUM IS 'Phone number for the Income Source, particularly for source type of employer.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_PHONE_EXT IS 'Phone extension for income source.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_ADDR_ST_LN1 IS 'Line 1 of the address for the income source'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_ADDR_ST_LN2 IS 'Line 2 of the street address for the income resource.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_ADDR_CITY IS 'City for the income resource source.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_ADDR_STATE IS 'State for the Income Resource Source'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_ADDR_ZIP IS 'Zip Code for the income resource source.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.CD_INC_RSRC_SRC_ADDR_COUNTY IS 'County for the Income Resource Source.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.TXT_INC_RSRC_SRC_ADDR_CMNTS IS 'Comments on the address of the Income Resource Source'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.DT_INC_RSRC_MODIFIED IS 'Date the income resource was modified. This is a user entered date, as opposed to the automatically assigned system date in DT_LAST_UPDATE'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.AU_NUMBER IS 'Field returned by SUCCESS interface that indicates the group/family number that can be associated with income types coming from the state. The AU Number typically identifies the family receiving benefits as a whole, as opposed to a particular person.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.AU_STATUS IS 'Returned by the SUCCESS interface - status of the family unit case associated with benefits/income from the state itself.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.CASE_LOAD_NUMBER IS 'Returned by the SUCCESS interface. This can be used by the SUCCESS team to determine who the current SUCCESS Case Worker is.'
;
COMMENT ON COLUMN CAPS.INCOME_AND_RESOURCES.CD_PROGRAM_TYPE IS 'Returned by the SUCCESS interface. This is a SUCCESS program type. AF-TANF, FS-Food Stamps, MA-Medicaid, RF-Refugee, RP-Repatriated Citizen.'
;
COMMENT ON TABLE CAPS.INCOMING_ADDRESS IS 'Table to store address at the Intake level.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.ID_INCOMING_ADDRESS IS 'A unique integer which identifies and Incoming Address.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.ID_INCMG_PERSON IS 'A unique integer that identifies an Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.ADDR_INCMG_ADDR_ATTN IS 'Contains the attention field for person addresses.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.ADDR_INCMG_ADDR_CITY IS 'The city of the incoming person.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.ADDR_INCMG_ADDR_ST_LN_1 IS 'The first line of the street address of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.ADDR_INCMG_ADDR_ST_LN_2 IS 'The second line of the street address for the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.ADDR_INCMG_ADDR_ZIP IS 'The zip code of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.CD_INCMG_ADDR_COUNTY IS 'The abbreviated county code in which an individual known to IMPACT lives.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.CD_INCMG_ADDR_STATE IS 'The abbreviated state code for each individual known to IMPACT.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.CD_INCMG_ADDR_TYPE IS 'Type of address for an individual that is recorded at intake. e.g. business, residence'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.DT_INCMG_ADDR_START IS 'The date the incoming address started.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.DT_INCMG_ADDR_END IS 'Date the incoming address ended.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.IND_INCMG_ADDR_INVALID IS 'Indicator showing that the incoming Intake address was invalid.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.IND_INCMG_ADDR_PRIMARY IS 'A flag to indicate if the address of the Incoming Person is their primary address.'
;
COMMENT ON COLUMN CAPS.INCOMING_ADDRESS.TXT_INCMG_ADDR_COMMENTS IS 'Comments on the Incoming Person''s Address.'
;
COMMENT ON TABLE CAPS.INCOMING_DETAIL IS 'Details about an incoming contact with DFCS. Incoming details can be about an incident of abuse, neglect, or exploitation (situation), a request for information and referral, or a special request.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ID_INCOMING_WORKER IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NBR_INCMG_UNIT IS 'Number which identifies a group of workers with common supervisor and goals. (value at intake)'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_REGION IS 'A geographic area which the state is broken down into.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCOMING_CALLER_LAST IS 'Last name of the person calling in.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_CALLER_INT IS 'A code that identifies the reporter interest or relationship to the individual in the intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ADDR_INCMG_WORKER_CITY IS 'This field in the Created By section of the Call Summary window captures the office of the worker where the intake was created.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NBR_INCMG_WORKER_PHONE IS 'This field in the Created By section of the Call Summary window captures the office phone of the worker who created the intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NBR_INCMG_WORKER_EXT IS 'This field in the Created By section of the Call Summary window captures the phone extension of the worker who took the intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCMG_WORKER_NAME IS 'This name field in the Created By section of the Call Summary window captures the concatenated name of the worker who took the call.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_ALLEG_TYPE IS 'A code that identifies each type of abuse/neglect alleged.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_CALLER_ADDR_TYPE IS 'Type of address for the caller that is recorded at intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_CALLER_PHON_TYPE IS 'Contains the phone type of the incoming caller.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NBR_INCMG_CALLER_PHON_EXT IS 'The phone extension of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_CALLER_SUFFIX IS 'A code which identifies the caller as Jr., Sr., I, II, etc.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_SPEC_HANDLING IS 'A code which indicates that the case may require special handling (military base, Indian reservation, DFCS staff, VIP, etc.)'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_INCMG_SENSITIVE IS 'Marks whether the case associated to the stage or the case itself has been marked as sensitive.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_INCMG_WORKER_SAFETY IS 'CheckBox that allows the intake worker to identify a possible threat of violence to the worker on the Intake Call Decision window.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.TXT_INCMG_WORKER_SAFETY IS 'Text describing if there are safety issues the worker should be concerned about before making a home visit.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.TXT_INCMG_SENSITIVE IS 'Text describing whether an Incoming Detail is sensitive.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_CALL_TYPE IS 'Code indicating the type of call that is being received (if not an intake) such as I&R type or special request type. Same purpose as CD Incoming Disposition.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_SEX IS 'Gender of an individual determined at intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ADDR_INCMG_STREET_LN_1 IS 'Street address for each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ADDR_INCMG_STREET_LN_2 IS 'Street address for each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_INCMG_NO_FACTOR IS 'Indicates no determination factors in the list box are valid for this call.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ADDR_INCMG_ZIP IS 'Contains the zip code of the incoming caller.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCMG_REGARDING_LAST IS 'The last name of the person the reporter is calling in reference to.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCMG_JURISDICTION IS 'Fills in with the appropriate law enforcement agency from the Resource List window.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ADDR_INCOMING_CALLER_CITY IS 'City from which the caller is calling.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.DT_INCOMING_CALL_DISPOSED IS 'Date the incoming call was ended.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_DISPOSITION IS 'A code that identifies how the call was resolved.  If an I&R, then it is an I&R type, if Special Request, it is a Special Request type.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_STATUS IS 'Contains the status of the incoming call: Open, Pending (awaiting approval), Closed (assigned) or marked for Deletion.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCOMING_CALLER_FIRST IS 'The first name of the person calling in.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_CALLER_STATE IS 'Code that indicates the state in which the caller is calling from.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.DT_INCOMING_CALL IS 'Date the incoming information is received (by phone, walk-in, fax, letter, etc.)'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCMG_REGARDING_FIRST IS 'First name of the person the reporter is calling in reference to.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_CALLER_COUNTY IS 'A code that indicates the county in which the caller is calling from.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_PROGRAM_TYPE IS 'A code that indicates what program area is affected, i.e., Child Protective, Adult Protective etc.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NBR_INCOMING_CALLER_PHONE IS 'The phone number of the person calling in.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCOMING_CALLER_MIDDLE IS 'Middle name or initial of person calling in.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_INCMG_INT_INV_CLS_RECLASS IS 'This element is used to indicate if a stage was closed and reclassified. This element is only used for intake and investigation stages. This element corresponds to an indicator column on the INCOMING_DETAIL table.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_INCMG_SUSP_METH IS 'Indicator if meth manufacturing is suspected.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.TXT_INCMG_SUSP_METH IS 'Comments about why meth manufacturing is suspected.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_NON_RSDNT_REQ_TYPE IS 'Non resident request type.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_SPCL_INVSTGTN IS 'Type of special investigation.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_CNFIDNTLTY_EXPLND IS 'Indicator if confidentialty was explained at intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.DT_CNFIDNTLTY_EXPLNTN IS 'Date the confidentitality was explained.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_INCMG_LAW_ENF_INVOL IS 'Indicator if law enforcement is involved.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCMG_WORKER_REGION IS 'Region of incoming worker.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NM_INCMG_SUP_NAME IS 'Supervisor name.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NBR_INCMG_SUP_PHONE IS 'Supervisor phone.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.NBR_INCMG_SUP_EXT IS 'Supervisor phone extension.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_INCOMING_WORKER_COUNTY IS 'County Code'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ID_INCOMING_SUP IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.CD_SPCL_CIRCUMSTANCES IS 'Special Circumstances'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.ID_REFERRED_RESOURCE IS 'Resource Id of referred and Screen out'
;
COMMENT ON COLUMN CAPS.INCOMING_DETAIL.IND_MR_LETTER IS 'Checkbox on intake actions page to indicate if the mandated reporter letter has been sent'
;
COMMENT ON TABLE CAPS.INCOMING_ETHNICITY IS 'Contains data identifying a person''s ethnicity as recorded during Intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_ETHNICITY.ID_INCOMING_ETHNICITY IS 'A unique identifier for a row on the INCOMING ETHNICITY table.'
;
COMMENT ON COLUMN CAPS.INCOMING_ETHNICITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_ETHNICITY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique integer that identifies an Incoming Person.  In this table, the value derives from ID INCMG PERSON in the INCOMING_PERSON table; NOT from ID PERSON in the PERSON table.'
;
COMMENT ON COLUMN CAPS.INCOMING_ETHNICITY.CD_ETHNICITY IS 'Contains a code identifying the ethnic background of a person.'
;
COMMENT ON TABLE CAPS.INCOMING_FACILITY IS 'Incoming details about an incident of abuse, neglect, or exploitation that occurred in a licensed facility. The facility may or may not be known to DFCS.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.ADDR_INCMG_FACIL_CITY IS 'Contains the city portion of a facility''s address for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.ADDR_INCMG_FACIL_ST_LN_1 IS 'Contains line 1 of the street portion of a facility''s address for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.ADDR_INCMG_FACIL_ST_LN_2 IS 'Contains line 2 of the street portion of the facility address for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.ADDR_INCMG_FACIL_ZIP IS 'The zip code of the facility''s address for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.CD_INCMG_FACIL_OPER_BY IS 'This field displays the agency that operates the facility being reported.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.CD_INCMG_FACIL_CNTY IS 'Contains the county portion of a facility''s address for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.CD_INCMG_FACIL_TYPE IS 'Contains the facility type for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.CD_INCMG_FACIL_STATE IS 'Contains the state portion of the facility''s address for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.IND_INCMG_FACIL_OFF_GRNDS IS 'Indicates whether abuse occurred at facility or off grounds.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.IND_INCMG_FACIL_SEARCH IS 'Indicator showing that a resource search was performed on a facility at Intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.IND_INCMG_FACIL_AB_SUPVD IS 'This check box indicates whether the abuse occurred in a supervised environment.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.NBR_INCMG_FACIL_PHONE IS 'Contains the phone number of a facility for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.NBR_INCMG_FACIL_PHONE_EXT IS 'The phone extension of the facility recorded at intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.NM_INCMG_FACIL_AFFILIATED IS 'Contains the name of the affiliated facility for the incoming record.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.NM_INCMG_FACIL_NAME IS 'Contains the name of a facility for the incoming record. It is also used as the criterion when searching the resource directory for facilities.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.NM_INCMG_FACIL_SUPRTDANT IS 'Contains the facility superintendent''s name.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.NM_INCMG_FACIL_UNIT_WARD IS 'Contains unit/ward of APS facility.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.TXT_INCOMING_FACIL_CMNTS IS 'Optional comments regarding the facility entered at intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_FACILITY.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON TABLE CAPS.INCOMING_NAME IS 'Individual''s name as recorded during an intake. Includes phonetic keys.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.ID_INCOMING_NAME IS 'A unique integer which identifies an Incoming Name.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.ID_INCMG_PERSON IS 'A unique integer that identifies an Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.NM_INCMG_NAME_FIRST IS 'The first name of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.NM_INCMG_NAME_PHK_FIRST IS 'Phonetic key for SSA-Name3 for first name.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.NM_INCMG_NAME_PHK_FULL IS 'Phonetic key for SSA-NAME3 for full name (last, first middle).'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.NM_INCMG_NAME_MIDDLE IS 'The middle name of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.NM_INCMG_NAME_LAST IS 'The last name of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.IND_INCMG_NAME_INVALID IS 'Indicates whether the Incoming Name is invalid.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.IND_INCMG_NAME_PRIMARY IS 'Indicates whether the Incoming name is primary.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.CD_INCMG_NAME_SUFFIX IS 'A code which identifies the caller as Jr., Sr., I, II, etc.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.DT_INCMG_NAME_START IS 'Date the incoming name became effective.'
;
COMMENT ON COLUMN CAPS.INCOMING_NAME.DT_INCMG_NAME_END IS 'Date the incoming name ended.'
;
COMMENT ON TABLE CAPS.INCOMING_NARRATIVE IS 'Narrative (i.e. MS word document) about a situation.'
;
COMMENT ON COLUMN CAPS.INCOMING_NARRATIVE.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.INCOMING_NARRATIVE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_NARRATIVE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.INCOMING_NARRATIVE.NARR_INCOMING IS 'Contains a narrative description of the details about the incoming call.'
;
COMMENT ON COLUMN CAPS.INCOMING_NARRATIVE.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.INCOMING_PERSON IS 'Table to store person information if a person has been related.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.ID_INCMG_PERSON IS 'A unique integer that identifies an Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.NBR_INCMG_PERS_AGE IS 'The age of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.DT_INCMG_PERS_DEATH IS 'The date the Incoming Person died.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.DT_INCMG_PERS_BIRTH IS 'The date the Incoming Person was born.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.IND_INCMG_PERS_DOB_APPROX IS 'An indicator that shows approximation of date of birth.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_DEATH IS 'Code indicating how a person died. (i.e. was it related to abuse/neglect.)'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_MARITL_STAT IS 'The marital status of a person. This is not recorded for the reporter or collaterals.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_LANGUAGE IS 'A code that indicates the language spoken by the individual.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_SEX IS 'A code that identifies an individual''s sex.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.NM_INCMG_PERS_FULL IS 'Full name of each individual known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_ETHNIC IS 'A code indicating the ethnicity of each person involved in the case.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.IND_INFO_SWAP IS 'Indicator if information was swapped.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_TITLE IS 'Title of incoming person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_RSN_DEATH IS 'Reason for death.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.IND_INCMG_PERS_AGE_APPROX IS 'Indicator that the Incoming person''s age is approximate.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_MATCH_TYPE IS 'Background check match type.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_PRF_CITIZENSHIP IS 'Defines how citizenship was proven/established for the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.IND_INCMG_PERS_US_CITIZEN IS 'Indicator if the Incoming Person is a U.S. Citizen'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_IMMGRTN_STATUS IS 'Immigration Status of the Incoming Person
'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON.CD_INCMG_PERS_CNTRY_ORIGIN IS 'Incoming Person''s official country of origin.'
;
COMMENT ON TABLE CAPS.INCOMING_PERSON_ID IS 'Stores the social security number of a person in the Intake stage.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.ID_INCOMING_PERSON_ID IS 'A unique integer which identifies an Incoming Person ID. The primary key for the INCOMING_PERSON_ID table.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.ID_INCMG_PERSON IS 'A unique integer that identifies an Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.CD_INCMG_PERS_ID_TYPE IS 'The type of identifier for the Incoming Person (i.e. SSN, DHS.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.DESC_INCMG_PERSON_ID IS 'The long description of an event type.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.DT_INCMG_PERS_ID_START IS 'The date the incoming person id started.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.DT_INCMG_PERSON_ID_END IS 'Date the completed child plan was signed by the child (optional) (No default).'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.IND_INCMG_PERSON_ID_INV IS 'This field is used to indicate whether or not the allegation occurred on the grounds of the facility.'
;
COMMENT ON COLUMN CAPS.INCOMING_PERSON_ID.NBR_INCMG_PERS_ID_NUMBER IS 'The number for the identifier for the Incoming Person.'
;
COMMENT ON TABLE CAPS.INCOMING_PHONE IS 'Phone details as recorded during an intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.ID_INCOMING_PHONE IS 'A unique integer which identifies and Incoming Phone.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.ID_INCMG_PERSON IS 'A unique integer that identifies an Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.TXT_INCMG_PHONE_COMMENTS IS 'Comments on the Incoming Person''s phone.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.NBR_INCMG_PHONE_EXTENSION IS 'The phone extension of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.NBR_INCMG_PHONE IS 'The phone number of the Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.DT_INCMG_PHONE_START IS 'Date that the incoming phone started.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.DT_INCMG_PHONE_END IS 'Date that the incoming phone ended.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.IND_INCMG_PHONE_INVALID IS 'Indicator showing that the phone number taken at Intake was invalid.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.IND_INCMG_PHONE_PRIMARY IS 'A flag indicating whether the Incoming Person''s phone is their primary phone number.'
;
COMMENT ON COLUMN CAPS.INCOMING_PHONE.CD_INCMG_PHONE_TYPE IS 'Contains the phone type of the incoming caller.'
;
COMMENT ON TABLE CAPS.INCOMING_RACE IS 'Contains data identifying a person''s race as recorded during Intake.'
;
COMMENT ON COLUMN CAPS.INCOMING_RACE.ID_INCOMING_RACE IS 'A unique identifier for a row on the INCOMING RACE table.'
;
COMMENT ON COLUMN CAPS.INCOMING_RACE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INCOMING_RACE.ID_PERSON IS 'A unique integer that identifies an Incoming Person.'
;
COMMENT ON COLUMN CAPS.INCOMING_RACE.CD_RACE IS 'Contains a code identifying the race of a person.'
;
COMMENT ON TABLE CAPS.INIT_CHLD_DTH_NARR IS 'Stores the initial child death narrative.'
;
COMMENT ON COLUMN CAPS.INIT_CHLD_DTH_NARR.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INIT_CHLD_DTH_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INIT_CHLD_DTH_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Initial Child Death Document.'
;
COMMENT ON COLUMN CAPS.INIT_CHLD_DTH_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.INITIAL_MED_PARENT IS 'This table contains data for the initial medicaid application that is specific to a particular parent.'
;
COMMENT ON COLUMN CAPS.INITIAL_MED_PARENT.ID_INITIAL_MED_PARENT IS 'Artificial generated primary key for the INITIAL_MED_PARENT table'
;
COMMENT ON COLUMN CAPS.INITIAL_MED_PARENT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.INITIAL_MED_PARENT.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INITIAL_MED_PARENT.ID_EVENT IS 'This event id is the link back to the Initial Medicaid Application (INITIAL_MEDICAID_APP)'
;
COMMENT ON COLUMN CAPS.INITIAL_MED_PARENT.IND_PARENT IS 'Indicator for the parent.'
;
COMMENT ON TABLE CAPS.INITIAL_MEDICAID_APP IS 'Initial Medicaid Eligibility Application'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_CHILD_PREGNANCY IS 'Is the child''s pregnancy verified and documented? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_CHILD_SUPPORT_ORDER IS 'Has Child Support been ordered in the juvenile court? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_MEDICAL_ASST_CHILD IS 'Was medical assistance needed for the child prior to removal? (If requesting prior months, please provide proof of medical services.) (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.TXT_MONTHS IS 'Months'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_EST_DELIVERY_DATE IS 'Estimated Delivery Date'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_CASE_MANAGER_APPLY IS 'I choose to apply for Medicaid benefits for the applicant (Foster Child). I choose to apply using the system application and authorize processing of this system application with my electronic signature.'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_PROCESSED IS 'Date Processed'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.TXT_COMMENTS IS 'Comments'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_HEALTH_INSURANCE_CARD IS 'Is a copy of the health insurance card available? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.CD_SUCCESS_CLASS_ASSISTANCE IS 'The SUCCESS Class of Assistance [from Initial Medicaid Application table]. This field value is returned by the interface with the state IV-E system, which in Georgia is SUCCESS.'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_SUCC_CLASS_ASSISTANCE IS 'The SUCCESS Class of Assistance Date [from Initial Medicaid Application table].'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.CD_TYPE IS 'Type of insurance'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NM_COMPANY IS 'Company Name'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NBR_POLICY IS 'Policy Number'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NBR_GROUP IS 'Group Number'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.ADDR_STREET_LN1 IS 'Address Line 1'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.ADDR_STREET_LN2 IS 'Address Line 2'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.ADDR_CITY IS 'City'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.ADDR_STATE IS 'State'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.ADDR_ZIP IS 'Zip Code'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NBR_PHONE IS 'Phone Number'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NBR_PHONE_EXT IS 'Phone Extension'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NM_EMPLOYER IS 'Name of the Employer'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_BEGIN IS 'Begin date of coverage'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_END IS 'End Date of Coverage'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_CHILD_COVERAGE IS 'Indicator if the child is covered by any 3rd party health insurance'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_PARENT IS 'Parent?'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NM_POLICY_HOLDER IS 'Name of the policy holder'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.NM_EMPLOYEE_NAME IS 'Name of the employee'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.ID_CM_SIGNED IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_CM_SIGNED IS 'Signed date by case manager'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.IND_ICAMA_ICPC IS 'Indicator if child receives out of state assistance'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.CD_ICAMA_ASSISTANCE_TYPE IS 'Inter-state assistance type'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.CD_ADOPTION_TYPE IS 'Inter-state adoption type'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.CD_ICAMA_STATE IS 'Inter-state state'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.TXT_ICAMA_COMMENTS IS 'Inter-state comments'
;
COMMENT ON TABLE CAPS.INTAKE_ALLEGATION IS 'Allegation details as recorded during intake. Records the victim, perpetrator, and allegation type. During investigation, the allegation details, as recorded during intake, are written to the ALLEGATION table with a Cd_Alleg_Incident_Stage of ''INT''. Additional allegations can be recorded during investigation, but would be stored on the ALLEGATION table.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.ID_ALLEGATION IS 'A unique identifier for a row on the Allegation table.  On the FACIL_ALLEG_PRIOR_REVIEW table, it is the ID_ALLEGATION before the Request for Review is submitted.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.ID_VICTIM IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.ID_ALLEGED_PERPETRATOR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.ID_ALLEGATION_STAGE IS 'A unique identifier for the stage table residing on the Allegation table.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.CD_INTAKE_ALLEG_TYPE IS 'A code that identifies each type of abuse/neglect alleged.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.TXT_INTAKE_ALLEG_DURATION IS 'Short text to describe how long each allegation (triad) has been occurring.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.NM_VICTIM IS 'Name of the victim in this allegation.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.NM_PERPETRATOR IS 'Name of the perpetrator in this allegation.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.DT_ALLEGED_INCIDENT IS 'Date of the alleged incident.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.CD_ALLEGED_MAL_CODE IS 'Alleged Maltreatment Code associated with this allegation.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.CD_ALLEGED_MAL_LOCATION IS 'Code for the alleged maltreatment location for this allegation.'
;
COMMENT ON COLUMN CAPS.INTAKE_ALLEGATION.CD_MALTREATOR_REL IS 'Relationship of maltreator to the victim.'
;
COMMENT ON TABLE CAPS.INTAKE_REPORT_NARRATIVE IS 'Table Contains Narrative Text associated with Intake Reports.'
;
COMMENT ON COLUMN CAPS.INTAKE_REPORT_NARRATIVE.ID_CASE IS 'Unqiue identifier for the CAPS_CASE that this Intake Narrative is associated with. This field is the primary key.'
;
COMMENT ON COLUMN CAPS.INTAKE_REPORT_NARRATIVE.DT_LAST_UPDATE IS 'Date record was inserted or last updated.'
;
COMMENT ON COLUMN CAPS.INTAKE_REPORT_NARRATIVE.NARRATIVE IS 'Long Raw field containing a blob that represents the narrative document.'
;
COMMENT ON COLUMN CAPS.INTAKE_REPORT_NARRATIVE.ID_DOCUMENT_TEMPLATE IS 'Identifies the HTML template that is associated with this Intake Report Narrative.'
;
COMMENT ON TABLE CAPS.INVOICE IS 'Contains header data related to a request for payment of services provided under approved programs.'
;
COMMENT ON COLUMN CAPS.INVOICE.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INVOICE.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.INVOICE.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_ADJUSTMENT_RB IS 'Contains a code indicating whether or not the invoice is a normal invoice or an adjusment.  If it is an adjustment invoice, the code indicates whether it is client- or contract-specific.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_APPROVED IS 'Contains the approval code for the invoice.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_FC_DIST_CODE IS 'Contains either the County or Region of distribution.  The element, IND INVO FC DIST TYPE, indicates whether it is a County or a Region. Both elements are populated in the Foster Care Prebill process and used by the SQR Prebill report process.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_GENERATION IS 'Contains a system-generated code indicating whether the invoice was created by the system or by a user.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_PHASE IS 'Contains a code that indicates the phase that the invoice is currently in - Pre-Bill, Validation Pending, Submitted, Paid, etc.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_REGION IS 'A geographic area which the state is broken down into.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_TYPE IS 'A code that indicates the type of invoice - Delivered Service (Unit Rate), Delivered Service (Cost Reimbursement), Adoption Subsidy, Foster Care, Administrative.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_APPROVAL_DATE IS 'Contains the date that the user marks an invoice as approved.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_CREATE_DATE IS 'Contains the date on which a Pre-Bill/Invoice was generated/created.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_ENTRY_COMPLETED IS 'Contains the date on which data entry is completed. It is recorded when the Data Entry Complete checkbox is checked.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_ENTRY_STARTED IS 'Contains the date stamp for the date that a user begins data entry on a record.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_RECEIVED_DATE IS 'Contains the date that an invoice is received from the provider.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_SUBMIT_DATE IS 'Contains the date on which an invoice is submitted to the accounting system for payment.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_WARRANT_DATE IS 'Contains the date on which a warrant or direct deposit is issued by the comptroller.'
;
COMMENT ON COLUMN CAPS.INVOICE.AMT_INVO_CLAIMED_AMOUNT IS 'The total dollar amount of all line items on a particular invoice.  The amount is entered by the user and is not used in any calculations, nor is it edited for accuracy.'
;
COMMENT ON COLUMN CAPS.INVOICE.AMT_INVO_VALID_AMOUNT IS 'Contains the valid amount of the invoice after invoice validation batch is run.  It includes only line items not rejected during validation.'
;
COMMENT ON COLUMN CAPS.INVOICE.AMT_INVO_WARRANT IS 'The amount of a warrant (check) issued by the comptroller in payment of an invoice.  If multiple invoices are rolled together and paid as a unit, the warrant amount reflects the total payment; not just the amount related to the current invoice.'
;
COMMENT ON COLUMN CAPS.INVOICE.IND_INVO_READY_FOR_VALID IS 'Indicates whether or not data entry is complete. If it is "Y", the invoice is processed by the validation batch.'
;
COMMENT ON COLUMN CAPS.INVOICE.IND_INVO_REJ_ITEMS IS 'Indicates whether or not the invoice includes one or more rejected line items.'
;
COMMENT ON COLUMN CAPS.INVOICE.IND_INVO_FC_DIST_TYPE IS 'Indicates whether the invoice Prebill goes to a Regional or County level distribution file. It contains an ''R'' (region), ''C'' (county), ''J'' (JPC; distributed at the region level) or ''T'' (TYC; also distributed at the region level), and is populated by the Foster Care Prebill process.'
;
COMMENT ON COLUMN CAPS.INVOICE.MO_INVO_MONTH IS 'Contains the billing month for the invoice.'
;
COMMENT ON COLUMN CAPS.INVOICE.NBR_INVO_DLN IS 'The DLN (Document Locator Number) is used to relate invoices having the same id_contract and vendor ID that are rolled together and paid as a single unit.
The DLN is currently a sequential number.  Prior to 09/1998 (and still in the database) the DLN was built by stringing Yr(99) + Mnth(99) + FMIS Batch # (9999) + 0 + a sequential number.'
;
COMMENT ON COLUMN CAPS.INVOICE.NBR_INVO_VID IS 'Contains the VID (vendor ID) for a contract/resource.'
;
COMMENT ON COLUMN CAPS.INVOICE.NBR_INVO_WARRANT IS 'Contains the warrant or direct deposit number of a particular payment issued by the comptroller.'
;
COMMENT ON COLUMN CAPS.INVOICE.YR_INVO_YEAR IS 'Contains the billing year for the invoice.'
;
COMMENT ON COLUMN CAPS.INVOICE.AMT_INVO_INTEREST_PAID IS 'Not used at this time.  May be removed from the system in the future.'
;
COMMENT ON COLUMN CAPS.INVOICE.DT_INVO_PYMNT_DUE IS 'Contains the date calculated as 30 days after the receipt date.  The date may be adjusted to reflect time the invoice is held because of invoices for the same id_contract and vendor ID that cause the overall payment amount to be less than or equal to zero.'
;
COMMENT ON COLUMN CAPS.INVOICE.IND_INVO_BLNC_DELAY IS 'An indicator that shows whether or not an invoice was held because the overall balance (when combined with other invoices for the same id_contract and vendor id) was less than or equal to zero.'
;
COMMENT ON COLUMN CAPS.INVOICE.CD_INVO_COUNTY IS 'Invoice County'
;
COMMENT ON COLUMN CAPS.INVOICE.TXT_INVO_CONTACT IS 'Invoice Contact'
;
COMMENT ON TABLE CAPS.INVOICE_TRANSACTION IS 'This table is used by the Financial batch process to drive the Invoice Validation Process. The records are created by a trigger on the INVOICE table for each insert or update.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.ID_INVO_TRANS IS 'A unique identifier for a row on the INVOICE TRANSACTION table.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.CD_INVO_TRAN_TYPE IS 'A code that indicates the type of invoice - Delivered Service (Unit Rate), Delivered Service (Cost Reimbursement), Adoption Subsidy, Foster Care, Administrative in INVOICE TRANSACTION table.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.CD_INVO_TRAN_APPROVED IS 'Contains the approval code for the invoice in the INVOICE TRANSACTION table.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.CD_INVO_TRAN_ADJUST_RB IS 'Contains the code for the adjustment specificity in the INVOICE TRANSACTION table.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.CD_INVO_TRAN_PHASE IS 'Contains the phase that the invoice is currently in (Pre-Bill,  Submitted, Paid, etc.) in the INVOICE TRANSACTION table.'
;
COMMENT ON COLUMN CAPS.INVOICE_TRANSACTION.IND_INVO_TRAN_READY_VALID IS 'This checkbox indicates whether or not data entry is complete. If it is checked, the invoice is picked up on the validation batch.'
;
COMMENT ON TABLE CAPS.INVST_ACTION_QUESTION IS 'Questions documented for each CPS Investigation. Requires that the worker indicate whether certain actions were performed.'
;
COMMENT ON COLUMN CAPS.INVST_ACTION_QUESTION.ID_INVST_ACTION_QUEST IS 'A unique integer which defines an Investigation Action Question.'
;
COMMENT ON COLUMN CAPS.INVST_ACTION_QUESTION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.INVST_ACTION_QUESTION.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.INVST_ACTION_QUESTION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.INVST_ACTION_QUESTION.CD_INVST_ACTION_ANS IS 'Answers to investigation action questions.'
;
COMMENT ON COLUMN CAPS.INVST_ACTION_QUESTION.CD_INVST_ACTION_QUEST IS 'Lists the seven questions currently answered at the beginning of the recording contacts using Structured Recording.'
;
COMMENT ON COLUMN CAPS.INVST_ACTION_QUESTION.TXT_INVST_ACTION_CMNTS IS 'Contains worker''s comments about the response to the questions. The worker uses this field to justify his response.'
;
COMMENT ON TABLE CAPS.LAW_ENFORC_ZIP IS 'Zip code for a Law Enforcement resource.'
;
COMMENT ON COLUMN CAPS.LAW_ENFORC_ZIP.ID_LAW_ENFORC_RSRC IS 'The unique identifier for the Law Enforcement Zip table.'
;
COMMENT ON COLUMN CAPS.LAW_ENFORC_ZIP.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.LAW_ENFORC_ZIP.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.LAW_ENFORC_ZIP.NBR_LAW_ENFORC_ZIP IS 'The zip code in which a law enforcement agency provides specific services.'
;
COMMENT ON TABLE CAPS.LEGAL_ACTION IS 'Contains information about the Legal Actions recorded for a particular person during a case. Used by both APS and CPS.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.ID_LEGAL_ACT_EVENT IS 'A unique identifier to the event table located on the legal action table.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_LEGAL_ACT_ACTION IS 'Contains a code for the legal action that occurred.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_LEGAL_ACT_ACTN_SUBTYPE IS 'Depending on with action is chosen, a list of subtypes are displayed in order to the user to choose. The codes table used for the subtype is dependent on the type of legal action.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_LEGAL_ACT_OUTCOME IS 'The outcome of the legal action is recorded here. Depending on whether the case is CPS or APS, the outcomes are located in different code tables.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_LEGAL_ACT_DATE_FILED IS 'The date the legal action was filed with the court is entered here.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_LEGAL_ACT_OUTCOME_DT IS 'The date the outcome was dispensed is entered here.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.IND_LEGAL_ACT_DOCS_N_CASE IS 'Checked if the legal document is stored in the paper case file.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.TXT_LEGAL_ACT_COMMENT IS 'Any comments regarding the legal outcomes is entered here.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.NBR_CRT_FILE IS 'Court file number.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_CRT_TYPE IS 'Court type.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_NXT_HEAR_DATE IS 'Next hearing date.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_CONTIN_DATE IS 'Next continuing date.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_CRT_ORD_DATE IS 'Court ordered date.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_PUB_DATE IS 'Publication date'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_COUNTY IS 'County Code'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_CRT_ACT_DATE IS 'Court Activity Date'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_HR_TYP_CRT_ORD IS 'Code for the Hearing Type Court Order'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CRT_CASE_NBR IS 'Court Case Number - may be alphanumeric'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.IND_UP_PREV_ACT IS 'Indicates whether the legal action is an update to a previous legal action'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.IND_COMPLETE IS 'Indicates whether the legal action is complete'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_STATE IS 'The code value (CSTATE) referencing the geographic location of the legal action event'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.DT_SHELTER_CARE_AUTH IS 'The date and time shelter care was authorized for legal actions of type "Request for Shelter Care" (code RSC)'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.NM_CRT_ORD_PREP_BY IS 'Name of the person the Court Order was prepared by'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.IND_CRT_ORD_SIGNED IS 'Indicates if the Court Order was signed'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.IND_AMMENDMENT IS 'Indicates if the legal action is an ammendment to the Court Order'
;
COMMENT ON TABLE CAPS.LEGAL_ACTION_CRT_LANG IS 'This table contains every Court Order Language Code value(CCRTLANG) associated to a particular LEGAL_ACTION record.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_CRT_LANG.ID_LA_CRT_LANG IS 'Primary Key for Legal Action CRT LANG table'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_CRT_LANG.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_CRT_LANG.ID_LEGAL_ACT_EVENT IS 'A unique identifier to the event table located on the legal action table.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_CRT_LANG.CD_CRT_LANG IS 'One of possibly many CCRTLANG code values associated to the legal action'
;
COMMENT ON TABLE CAPS.LEGAL_ACTION_OUTCOME IS 'This table contains every Outcome code value (CLEGLOUT) associated to each particular LEGAL_ACTION record.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_OUTCOME.ID_LA_OUTCOME IS 'Primary, Artifical key for Legal Action Outcome record'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_OUTCOME.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_OUTCOME.ID_LEGAL_ACT_EVENT IS 'A unique identifier to the event table located on the legal action table.'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION_OUTCOME.CD_OUTCOME IS 'One of possibly many CLEGLOUT code values associated to the legal action'
;
COMMENT ON TABLE CAPS.LEGAL_ACTIONS_NARRATIVE IS 'Holds Narrative associated with Legal Action event'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTIONS_NARRATIVE.ID_EVENT IS 'Event ID associated with Legal Action'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTIONS_NARRATIVE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTIONS_NARRATIVE.ID_CASE IS 'Case ID associated with Legal Action'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTIONS_NARRATIVE.NARRATIVE IS 'BLOB value representing form presentation'
;
COMMENT ON COLUMN CAPS.LEGAL_ACTIONS_NARRATIVE.ID_DOCUMENT_TEMPLATE IS 'Template revision number for narrative'
;
COMMENT ON TABLE CAPS.LEGAL_STATUS IS 'Stores the legal status information for the child.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.ID_LEGAL_STAT_EVENT IS 'A unique identifier to the event table located on the legal status table.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.CD_LEGAL_STAT_CNTY IS 'The county of legal status is displayed here.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.CD_LEGAL_STAT_STATUS IS 'Contains a code for the legal status of a child.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.DT_LEGAL_STAT_STATUS_DT IS 'Date of legal status.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.IND_CSUP_SEND IS 'No description available.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.CD_COURT_NBR IS 'Contains a county/court code that provides a link to the county (using code type CRTCNYLK) and to the court number (using code type CRTNUMB).'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.DT_LEGAL_STAT_CRT_ODR_EXP_DT IS 'Court order expriation date.'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.DT_LEGAL_STAT_CUS_EXP_DT IS 'Date of Legal Status Custody Expiration'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.DT_LEGAL_STAT_P_M_DUE_DT IS 'Petition/Motion Due Date'
;
COMMENT ON COLUMN CAPS.LEGAL_STATUS.IND_LEGAL_STAT_RISK IS 'Indicates if this is a legal risk'
;
COMMENT ON TABLE CAPS.LICENSING_INVST_DTL IS 'Details surrounding an investigation of a Licensed Child Care Facility.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ID_LICNG_INVST_STAGE IS 'Foreign Key to the stage table. Stores the id_stage of the Licensing Investigation stage.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.CD_LICNG_INVST_OVRALL_DISP IS 'The overall disposition determined during a Licensing Investigation.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.DT_LICNG_INVST_INTAKE IS 'Date that the information was received by Intake. Filled by Date Incoming Call for the first intake for the investigation.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.DT_LICNG_INVST_ASSIGNED IS 'The date that the investigation/stage was assigned to an investigation worker. Filled by Date Emp Sit Link for the first assignment of an investigation.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.DT_LICNG_INVST_BEGUN IS 'This is the date the Investigation was begun; this date is actually the date the first contact was recorded.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.DT_LICNG_INVST_COMPLT IS 'Contains the date the Licensing Investigation is marked complete. This field is disabled until the Overall Disposition field has been entered.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.TXT_LICNG_INVST_NONCOMP IS 'Comments describing the noncompliance found during a Licensing Investigation.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.CD_LICNG_INVST_CORACTN IS 'Contains the appropriate corrective action from the drop list the worker recommends. Enabled only when Recommended Action is Corrective Action.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NM_RESOURCE IS 'The name of an entity that provides assistance or services to APS and/or CPS clients.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_ACCLAIM IS 'Facility number'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.CD_RSRC_FACIL_TYPE IS 'The type of facility as defined by who licensed the facility, the number of clients it can accommodate, and the type of service it provides.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.TXT_COMMENTS IS 'Comments describing the income, resource, or special conditions'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_PHONE IS 'Phone number of the facility being investigated.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_PHONE_EXT IS 'Phone number extension of facility being investigated.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_ATTN IS 'On an address label, this field contains who or what to bring this document to the attention of.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_ST_LN1 IS 'First line of the address for this facility.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_ST_LN2 IS 'Second line of the address of the facility, if needed.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_CITY IS 'City of the facility being investigated.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_COUNTY IS 'County of the facility being investigated.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_STATE IS 'State of the facility being investigated.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_ZIP IS 'Zip code of the facility being investigated.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ID_AFFIL_RESOURCE IS 'Foreign key to the Resource table (ID RESOURCE). Resource Id affiliated with the facility.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NM_AFFIL_RESOURCE IS 'Name of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.TXT_AFFIL_COMMENTS IS 'Comments for the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_AFFIL_PHONE IS 'Phone number of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_AFFIL_PHONE_EXT IS 'Phone number extension of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_AFFIL_ATTN IS 'Attention line of the address for the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_AFFIL_ST_LN1 IS 'First line of the address of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_AFFIL_ST_LN2 IS 'Second line of the address of the affiliated resource, if needed.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_AFFIL_CITY IS 'City of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_AFFIL_COUNTY IS 'County of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_AFFIL_STATE IS 'State of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ADDR_AFFIL_ZIP IS 'Zip code of the affiliated resource.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ID_CLASS_FCLTY IS 'facilty Id'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.ID_CLASS_AFFIL_FCLTY IS 'Affiliated facility ID'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_AFFIL_ACCLAIM IS 'Affliated facility number.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_AGENCY IS 'Agency number'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_BRANCH IS 'branch number.'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_AFFIL_AGENCY IS 'Affliated agency number'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.NBR_AFFIL_BRANCH IS 'affliated branch number'
;
COMMENT ON COLUMN CAPS.LICENSING_INVST_DTL.CD_AFFIL_FACIL_TYPE IS 'affilated facility type'
;
COMMENT ON TABLE CAPS.MAIL_CODE IS 'This entity is for the HRMIS interface.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.CD_MAIL_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.NBR_MAIL_CODE_PHONE IS 'The phone number of the Mail Code. Used in HRMIS interface.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.NBR_MAIL_CODE_PHONE_EXT IS 'The phone extension of the Mail Code. Used for the HRMIS interface.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.ADDR_MAIL_CODE_ST_LN_1 IS 'The first line of the street address of the Mail Code. Used for the HRMIS interface.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.ADDR_MAIL_CODE_ST_LN_2 IS 'The second line of the street address of the Mail Code. Used for the HRMIS interface.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.ADDR_MAIL_CODE_CITY IS 'The mail code city. Used for the HRMIS interface.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.ADDR_MAIL_CODE_ZIP IS 'The zip code of the Mail Code.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.ADDR_MAIL_CODE_COUNTY IS 'The Mail Code counties. Used for the HRMIS interface.'
;
COMMENT ON COLUMN CAPS.MAIL_CODE.IND_MAIL_CODE_INVALID IS 'Indicates whether a mail code has been deleted on the HRMIS system.'
;
COMMENT ON TABLE CAPS.MED_DVL_HIST_NARR IS 'Blob table for the Medical and Developmental History Form.'
;
COMMENT ON COLUMN CAPS.MED_DVL_HIST_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.MED_DVL_HIST_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.MED_DVL_HIST_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.MED_DVL_HIST_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing a medical development history.'
;
COMMENT ON COLUMN CAPS.MED_DVL_HIST_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.MEDICAID_UPDATE IS 'Table used to process SAVERR Med-Upd Batch program. Various services in the system will write a record to this table.'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.ID_MED_UPD IS 'This is the unique sequence id for the MEDICID UPDATE record.'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.ID_MED_UPD_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.ID_MED_UPD_STAGE IS 'The ID of the stage from which the Medicaid Update trigger record was written from. (Used in SAVERR Medicaid Update Batch Process).'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.ID_MED_UPD_RECORD IS 'This is the unique record id the Medicaid Update trigger record. (Used in SAVERR Medicaid Update Batch Process).'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.CD_MED_UPD_TYPE IS 'The type of the Medicaid Update trigger record. This code indicates the source of the record (i.e., PLA if written from Placement Detail window, ADS if written from Adoption Subsidy window, etc.) (Used in SAVERR Medicaid Update Batch Process).'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.CD_MED_UPD_TRANS_TYPE IS 'The type of transaction of the Medicaid Update Trigger record (i.e., ADD, SUStain, DENy, TRAnsfer, OPen/Close) (Used in SAVERR Medicaid Update Batch Process).'
;
COMMENT ON COLUMN CAPS.MEDICAID_UPDATE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.MEDICAL_HISTORY IS 'A history of a principal''s medical visits.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.MEDICAL_HISTORY.ID_MED_HISTORY IS 'A unique integer which defines a Medical History.'
;
COMMENT ON COLUMN CAPS.MEDICAL_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.MEDICAL_HISTORY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.MEDICAL_HISTORY.NARR_MED_HISTORY IS 'Contains a narrative detailing a Person''s Medical History.'
;
COMMENT ON TABLE CAPS.MEDICATION IS 'A list of medications that a person in a case is taking.'
;
COMMENT ON COLUMN CAPS.MEDICATION.ID_MEDICATION IS 'Unique identifier for the medication record for a person in the case.'
;
COMMENT ON COLUMN CAPS.MEDICATION.ID_PERSON IS 'A unique identifier for a row on the Person table that is taking the medication in this record.'
;
COMMENT ON COLUMN CAPS.MEDICATION.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.MEDICATION.CD_MEDCTN_DOSE IS 'The code for the dosage of the medication being taken.'
;
COMMENT ON COLUMN CAPS.MEDICATION.TXT_MEDCTN_ADMIN_PERSON IS 'Contains the person who is administering the medication to the person.'
;
COMMENT ON COLUMN CAPS.MEDICATION.DT_MEDCTN_PRESC IS 'The date this medication was prescribed.'
;
COMMENT ON COLUMN CAPS.MEDICATION.DT_MEDCTN_END_DATE IS 'The end date, if known, for the person to be taking this medication.'
;
COMMENT ON COLUMN CAPS.MEDICATION.IND_MEDCTN_ALLERGIES IS 'Indicator if person is known to have any allergies to this medication.'
;
COMMENT ON COLUMN CAPS.MEDICATION.TXT_MEDCTN_DESCRIP IS 'A description of this medication.'
;
COMMENT ON COLUMN CAPS.MEDICATION.TXT_MEDCTN_CMNTS IS 'Comments associated with this medication.'
;
COMMENT ON COLUMN CAPS.MEDICATION.TXT_MEDCTN_PRESC_PERSON IS 'Name of the person who prescribed the medication.'
;
COMMENT ON COLUMN CAPS.MEDICATION.NM_PHARMACY IS 'Pharmacy Name'
;
COMMENT ON COLUMN CAPS.MEDICATION.ADDR_PHARM_ST_LN_1 IS 'Pharmacy Address Details '
;
COMMENT ON COLUMN CAPS.MEDICATION.ADDR_PHARM_ST_LN_2 IS 'Pharmacy Address Details '
;
COMMENT ON COLUMN CAPS.MEDICATION.ADDR_PHARM_CITY IS 'Pharmacy Address City'
;
COMMENT ON COLUMN CAPS.MEDICATION.CD_ADDR_PHARM_STATE IS 'Pharmacy Address State'
;
COMMENT ON COLUMN CAPS.MEDICATION.ADDR_PHARM_ZIP IS 'Pharmacy Address Zip Code'
;
COMMENT ON COLUMN CAPS.MEDICATION.NBR_PHARM_PHONE IS 'Pharmacy Phone Number'
;
COMMENT ON COLUMN CAPS.MEDICATION.NM_MEDCTN IS 'Name of the medication.'
;
COMMENT ON COLUMN CAPS.MEDICATION.TXT_MEDCTN_REASON IS 'The reason why the medication was prescribed for the person.'
;
COMMENT ON TABLE CAPS.MESSAGE IS 'A static table that replaces part of the codes tables files in IMPACT. It is used to display the error messages.'
;
COMMENT ON COLUMN CAPS.MESSAGE.ID_MESSAGE IS 'Primary key of the MESSAGE table.'
;
COMMENT ON COLUMN CAPS.MESSAGE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.MESSAGE.NBR_MESSAGE IS 'The reference number of the message generated by the services; this matches the IMPACT message number.'
;
COMMENT ON COLUMN CAPS.MESSAGE.TXT_MESSAGE_NAME IS 'The message name, as it is called in IMPACT; this corresponds to the C macro name of the error number.'
;
COMMENT ON COLUMN CAPS.MESSAGE.TXT_MESSAGE IS 'The text of the message'
;
COMMENT ON COLUMN CAPS.MESSAGE.CD_SOURCE IS 'The source of the message: NOT USED'
;
COMMENT ON COLUMN CAPS.MESSAGE.CD_PRESENTATION IS 'How the message will be displayed: NOT USED.'
;
COMMENT ON COLUMN CAPS.MESSAGE.IND_BATCH IS 'Indicates if the message is used by batch'
;
COMMENT ON TABLE CAPS.MESSAGE_DEST_LINK IS 'Links message numbers from the MESSAGE table with pages from the ERROR_LIST_DEST'
;
COMMENT ON COLUMN CAPS.MESSAGE_DEST_LINK.ID_MESSAGE_DEST_LINK IS 'Primary key of the MESSAGE_DEST_LINK table.'
;
COMMENT ON COLUMN CAPS.MESSAGE_DEST_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.MESSAGE_DEST_LINK.TXT_MESSAGE_NAME IS 'The message name, as it is called in IMPACT; this corresponds to the C macro name of the error number.'
;
COMMENT ON COLUMN CAPS.MESSAGE_DEST_LINK.NBR_MESSAGE IS 'The reference number of the message generated by the services; this matches the IMPACT message number.'
;
COMMENT ON COLUMN CAPS.MESSAGE_DEST_LINK.TXT_ERROR_PAGE_NAME IS 'The Title/page name of the destination page.'
;
COMMENT ON COLUMN CAPS.MESSAGE_DEST_LINK.ID_ERROR_LIST_DEST IS 'Primary key of the ERROR_LIST_DEST table.'
;
COMMENT ON TABLE CAPS.METAPHOR IS 'Table used exclusively by the IMPACT application Metaphor.  Data is loaded into hashmaps on startup by NavInit.java.'
;
COMMENT ON COLUMN CAPS.METAPHOR.ID_TAB IS 'A unique ID identifying each tab.'
;
COMMENT ON COLUMN CAPS.METAPHOR.TXT_TAB_URL IS 'The URL to which the tab links.'
;
COMMENT ON COLUMN CAPS.METAPHOR.TXT_TAB_CONSTANT IS 'A unique constant which maps to the tab ID.'
;
COMMENT ON COLUMN CAPS.METAPHOR.TXT_TAB IS 'The text that appears on the tab.'
;
COMMENT ON COLUMN CAPS.METAPHOR.TXT_L1_IMG_INACTIVE IS 'The location of the 1st level inactive tab image.'
;
COMMENT ON COLUMN CAPS.METAPHOR.TXT_L1_IMG_ACTIVE IS 'The location of the 1st level active tab image.'
;
COMMENT ON COLUMN CAPS.METAPHOR.TXT_FILTER_PATH IS 'The location of the filter class that governs whether the tab displays (if applicable).'
;
COMMENT ON COLUMN CAPS.METAPHOR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.MONTH_NARR IS 'The Narrative Table for the Monthly Assessment'
;
COMMENT ON COLUMN CAPS.MONTH_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.MONTH_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.MONTH_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.MONTH_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the monthly Assessment for Adoption'
;
COMMENT ON COLUMN CAPS.MONTH_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.NAME IS 'Other names a person may assume. i.e. Babe Ruth is an alias for George Ruth.'
;
COMMENT ON COLUMN CAPS.NAME.ID_NAME IS 'A unique integer which identifies an Alias.'
;
COMMENT ON COLUMN CAPS.NAME.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.NAME.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.NAME.IND_NAME_INVALID IS 'A flag that identifies a name previously entered for an individual as invalid.'
;
COMMENT ON COLUMN CAPS.NAME.NM_NAME_FIRST IS 'First name of each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.NAME.NM_NAME_MIDDLE IS 'Middle name of each individual known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.NAME.NM_NAME_LAST IS 'Last name of each individual known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.NAME.IND_NAME_EMP IS 'A flag that identifies if this name is an employee name in the system.'
;
COMMENT ON COLUMN CAPS.NAME.IND_NAME_PRIMARY IS 'A flag that indicates that the name is the primary name for the Person.  Multiple rows may have this indicator set for one ID PERSON.  The actual primary name has IND_NAME_PRIMARY = "Y", an open-ended DT NAME END DATE (12/31/4712) and IND_NAME_INVALID = "N".'
;
COMMENT ON COLUMN CAPS.NAME.CD_NAME_SUFFIX IS 'This data element is used within the ALIAS LIST/DETAIL Window to house the appended suffix of the person in question.'
;
COMMENT ON COLUMN CAPS.NAME.DT_NAME_START_DATE IS 'Date that the individual''s name became valid. This is often the date that the name was added.'
;
COMMENT ON COLUMN CAPS.NAME.DT_NAME_END_DATE IS 'Date that the individual''s name is no longer effective.'
;
COMMENT ON COLUMN CAPS.NAME.TXT_NAME_COMMENTS IS 'Comments about the Name'
;
COMMENT ON TABLE CAPS.NEEDS_OUTCOMES IS 'Holds the Needs and Outcomes Data'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.NM_AGENCY IS 'Agency Name'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.NM_ASSESSOR IS 'Assessor Name'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.TXT_ASSESSOR_TITLE IS 'Assessor Title'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.DT_REFERRAL IS 'Referral Date'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.DT_ASST_CMPLT IS 'Date Assessment Complete'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.TXT_GEN_REC IS 'General Recommendations'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.TXT_PLCMT_REC IS 'Placement Recommendations'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.TXT_CCFA_REC IS 'CCFA Recommendations that were not used as a step to accomplish this case plan'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.IND_CCFA_AGENCY IS 'Indicator for CCFA Agency'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.IND_CCFA_EDU_ASSMT IS 'Indicator for CCFA Educational Assessment'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.TXT_CCFA_EDU_ASSMT IS 'The text of the CCFA educational assessment findings'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.DT_CCFA_EDU_ASSMT IS 'Date of CCFA Educational Assessment'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.TXT_UNDER4_NO_DEV_SRC_CMNT IS ' text for if the child is under 4 years old, and there has not been a Developmental Screening, explain'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.TXT_UND_SCHOOLAGE_NO_DEV_ASS IS ' text for If the child is below school age and there has not been a Developmental Assessment, explain'
;
COMMENT ON TABLE CAPS.NEEDS_OUTCOMES_DETAIL IS 'Holds Data from the Needs and Outcomes Detail page'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.ID_NEEDS_OUTCOMES_DETAIL IS 'Needs Outcomes Detail ID'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.TXT_IDEN_NEED IS 'Identified Need'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.TXT_COMMENTS IS 'Comments'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.IND_CCFA_NEED IS 'CCFA Need'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.TXT_SVC_REC IS 'Service Recommended'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.IND_SVC_PROV IS 'Service Provided'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.IND_NEED_MET IS 'Need Met'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.TXT_SVC_PROV IS 'Why service was not provided for need'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES_DETAIL.TXT_NEED_MET IS 'Why need was not met'
;
COMMENT ON TABLE CAPS.NON_COMPLIANCE IS 'This table holds both corrective action plans and policy violations by employees'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.ID_NON_COMPLIANCE IS 'Primary Key of Non Compliance table'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.CD_NON_COMPLIANCE IS 'Ind that holds either VLT or CRA to specify Policy Violation or Corrective Action'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.IND_DOC_COMPLETED IS 'Ind Document completed'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.DT_TRACKING IS 'Stores either Date of Achievement / Staffing date based on CRA / VLT'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.TXT_COMMENTS IS 'Stores either Results Desc / Staffing Outcome based on CRA / VLT'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.CD_COUNTY IS 'County Code'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.DT_OF_VIOLATION IS 'Date of Violation'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.DT_EFFECT_FROM IS 'Date of Plan Effect from'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.DT_EFFECT_TO IS 'Date of Plan Effect to'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.IND_ST_OFF_CONCURRENCE IS 'Indicator for SO concurrence'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.DT_ST_OFF_CONCURRENCE IS 'Date entered of SO concurrence'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.IND_CPA_CONCURRENCE IS 'Indicator for CPA Concurrence'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE.DT_CPA_CONCURRENCE IS 'Date entered for CPA Concurrence'
;
COMMENT ON TABLE CAPS.NON_COMPLIANCE_CBX IS 'Holds selected checkboxes for the Non Compliance pages (Policy Violation and Corrective Action Plan)'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CBX.ID_NON_COMPLIANCE_CBX IS 'Primary Key'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CBX.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CBX.ID_NON_COMPLIANCE IS 'Primary Key of Non Compliance table'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CBX.CD_NON_COMPLIANCE_CBX IS 'Holds Policy Violation checkboxes from the Both Policy violation and corrective action plan page'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CBX.CD_NON_COMPLIANCE_CBX_TYPE IS 'Cd non compliance checkbox type'
;
COMMENT ON TABLE CAPS.NON_COMPLIANCE_CHILD IS 'Hold children involved in policy violation or correction action plan and their attributes'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CHILD.ID_NON_COMPLIANCE IS 'Primary Key of Non Compliance table'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CHILD.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CHILD.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CHILD.IND_HOME_VIOLATION IS 'Ind whether violation involved in Home'
;
COMMENT ON COLUMN CAPS.NON_COMPLIANCE_CHILD.IND_ADOPTIVE_PROCESS IS 'Ind whether violation involved in Adoptive process'
;
COMMENT ON TABLE CAPS.NON_EQUIVALENCY IS 'Static table that stores service code entries that are exempt from edits against the EQUIVALENCY table during the save of new service authorizations.'
;
COMMENT ON COLUMN CAPS.NON_EQUIVALENCY.ID_NON_EQUIV IS 'This is the unique identifier/key for the NON EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.NON_EQUIVALENCY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.NON_EQUIVALENCY.CD_NON_EQUIV_SVC_DTL_SVC IS 'A code that indicates a service that can be authorized, but is not paid for by the agency, and is not in the EQUIVALENCY table.'
;
COMMENT ON COLUMN CAPS.NON_EQUIVALENCY.DT_NON_EQUIV_START_DATE IS 'This is the first day that a NON EQUIVALENCY table line item is valid.'
;
COMMENT ON COLUMN CAPS.NON_EQUIVALENCY.DT_NON_EQUIV_END_DATE IS 'This is the last day that the NON EQUIVALENCY table line item is valid.'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.ID_PERSON IS 'child''s person id'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.DT_APP_SENT IS 'date application sent to family.'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.DT_BM_RIGHT_TERMINATED IS 'date birth mother''s rights were terminated.'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.DT_BM_DOB IS 'birth mother''s date of birth'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_BM_TERMINATION_TYPE IS 'Type of termination of birth mother''s rights.'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BM_RACE_AA IS 'birth mother''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BM_RACE_AN IS 'birth mother''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BM_RACE_BK IS 'birth mother''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BM_RACE_HP IS 'birth mother''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BM_RACE_UD IS 'birth mother''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BM_RACE_WT IS 'birth mother''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_BM_ETHNICITY IS 'birth mother''s ethnicity indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.DT_BF_DOB IS 'birth father''s date of birth'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.DT_BF_RIGHT_TERMINATED IS 'date birth father''s rights were terminated.'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_BF_TERMINATION_TYPE IS 'Type of termination of birth father''s rights.'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BF_RACE_AA IS 'Birth Father''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BF_RACE_AN IS 'Birth Father''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BF_RACE_BK IS 'Birth Father''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BF_RACE_HP IS 'Birth Father''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BF_RACE_UD IS 'Birth Father''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_BF_RACE_WT IS 'Birth Father''s race indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_BF_ETHNICITY IS 'Birth Father''s ethnicity indicator'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.NM_BN_FIRST IS 'birth first name'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.NM_BN_MIDDLE IS 'birth last name'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.NM_BN_LAST IS 'birth middle name'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_MENTAL_RETARDATION IS 'Indicator if the child has the characteristic Mental Retardation'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_SEV_MENTAL_RETARDATION IS 'Severity level of the characteristic Mental Retardation'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_VISUAL_HEARING_IMP IS 'Indicator if the child has the characteristic Visual or Hearing Impaired'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_SEV_VISUAL_HEARING_IMP IS 'Severity level of the characteristic Visual or Hearing Impaired'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_PHYSICALLY_DISABLED IS 'Indicator if the child has the characteristic Physically Disabled'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_SEV_PHYSICALLY_DISABLED IS 'Severity level of the characteristic Physically Disabled'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_EMOTIONALLY_DIST IS 'Indicator if the child has the characteristic Emotionally Disturbed'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_SEV_EMOTIONALLY_DIST IS 'Severity level of the characteristic Emotionally Disturbed'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.IND_OTHER_MED IS 'Indicator if the child has the characteristic Other Medical Diagnosis'
;
COMMENT ON COLUMN CAPS.NON_INCIDENT_AFCARS_INFO.CD_SEV_OTHER_MED IS 'Severity level of the characteristic Other Medical Diagnosis'
;
COMMENT ON TABLE CAPS.OFFICE IS 'Information about the DFCS office in which an employee is housed.'
;
COMMENT ON COLUMN CAPS.OFFICE.ID_OFFICE IS 'A unique integer which identifies a DFCS Office.'
;
COMMENT ON COLUMN CAPS.OFFICE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.OFFICE.CD_OFFICE_MAIL IS 'Mail Code for office.Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.OFFICE.CD_OFFICE_PROGRAM IS 'Identifies the program for each office/mail code. (i.e. APS or CPS)'
;
COMMENT ON COLUMN CAPS.OFFICE.CD_OFFICE_REGION IS 'The DFCS region in which the office is located.'
;
COMMENT ON COLUMN CAPS.OFFICE.CD_OFFICE_PRINTER IS 'This is the 8 byte alphanumeric printer id for each office. This id allows the HP to directly print to one printer in each office as the result of an SQR report process.  While this element is actually an id of a printer, it is defined as a code. It is NOT attached to any codes table; there is no decode.  NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.OFFICE.NM_OFFICE_NAME IS 'Name of DFCS Office.'
;
COMMENT ON TABLE CAPS.OFFICE_COUNTY_LINK IS 'A table that links DFCS offices to the counties they service/have jurisdiction over.'
;
COMMENT ON COLUMN CAPS.OFFICE_COUNTY_LINK.ID_OFFICE_COUNTY_LINK IS 'A unique integer which defines an Office County Link.'
;
COMMENT ON COLUMN CAPS.OFFICE_COUNTY_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.OFFICE_COUNTY_LINK.ID_OFFICE IS 'A unique integer which identifies a DFCS Office.'
;
COMMENT ON COLUMN CAPS.OFFICE_COUNTY_LINK.CD_COUNTY IS 'Three digit, numeric county code for each individual involved in the case.'
;
COMMENT ON TABLE CAPS.OFFICE_PHONE IS 'Information about the DFCS office phones.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.ID_OFFICE_PHONE IS 'A unique integer which identifies a DFCS Office''s Phone.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.ID_OFFICE IS 'A unique integer which identifies a DFCS Office.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.NBR_OFFICE_PHONE IS 'The office phone number.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.TXT_OFFICE_PHONE_COMMENT IS 'Comments about the office phone.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.NBR_OFFICE_PHONE_EXT IS 'The office phone extension.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.IND_OFFICE_PHONE_INVALID IS 'A flag that identifies one of the phone numbers provided for an individual as an invalid phone number.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.DT_OFFICE_PHONE_START IS 'This is the date that the Office started using the phone number.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.DT_OFFICE_PHONE_END IS 'This is the date that the Office stopped using the phone number.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.IND_OFFICE_PHONE_PRIMARY IS 'A flag that identifies if the phone number is the primary phone.'
;
COMMENT ON COLUMN CAPS.OFFICE_PHONE.CD_OFFICE_PHONE_TYPE IS 'A code which identifies the type of phone i.e. pager, mobile phone.'
;
COMMENT ON TABLE CAPS.ON_CALL IS 'Tracks information about blocks of time where employees are to be available on call for a given county and program.'
;
COMMENT ON COLUMN CAPS.ON_CALL.ID_ON_CALL IS 'A unique integer which identifies a particular shift or block for the on-call schedule.'
;
COMMENT ON COLUMN CAPS.ON_CALL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ON_CALL.DT_ON_CALL_START IS 'Date the on call worker starts their on-call shift or block.'
;
COMMENT ON COLUMN CAPS.ON_CALL.DT_ON_CALL_END IS 'Date the on call worker ends their on-call shift or block.'
;
COMMENT ON COLUMN CAPS.ON_CALL.CD_ON_CALL_TYPE IS 'A code which identifies whether the on call worker is working a shift or block. A shift is a period of a day covered over multiple days. A block is a continuous period of time between the start date/time and the end date/time.'
;
COMMENT ON COLUMN CAPS.ON_CALL.CD_ON_CALL_PROGRAM IS 'Whether the worker works for and covers Child Protective Services call outs, or Adult Protective Services call outs.  May include other program designations found on the Program codes table.'
;
COMMENT ON COLUMN CAPS.ON_CALL.CD_ON_CALL_COUNTY IS 'County for which the on-call worker is responsible.'
;
COMMENT ON COLUMN CAPS.ON_CALL.IND_ON_CALL_FILLED IS 'Indicates that for a shift or block the minimum staffing requirements have been met.'
;
COMMENT ON COLUMN CAPS.ON_CALL.ON_CALL_REGION IS 'Region within the state.'
;
COMMENT ON TABLE CAPS.ON_CALL_COUNTY IS 'No description available.'
;
COMMENT ON COLUMN CAPS.ON_CALL_COUNTY.ID_ON_CALL_COUNTY IS 'No description available.'
;
COMMENT ON COLUMN CAPS.ON_CALL_COUNTY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.ON_CALL_COUNTY.ID_ON_CALL IS 'A unique integer which identifies a particular shift or block for the on-call schedule.'
;
COMMENT ON COLUMN CAPS.ON_CALL_COUNTY.CD_ON_CALL_COUNTY IS 'County for which the on-call worker is responsible.'
;
COMMENT ON COLUMN CAPS.ON_CALL_COUNTY.CD_ON_CALL_REGION IS 'No description available.'
;
COMMENT ON TABLE CAPS.OUTPUT_LAUNCH_EVENT_LINK IS 'Used to capture additional details about an event / narrative in Output Launch'
;
COMMENT ON COLUMN CAPS.OUTPUT_LAUNCH_EVENT_LINK.ID_EVENT IS 'A unique identifier to the EVENT table and primary key of this table.'
;
COMMENT ON COLUMN CAPS.OUTPUT_LAUNCH_EVENT_LINK.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.OUTPUT_LAUNCH_EVENT_LINK.DT_ACHIEVED IS 'Date the plan was achieved'
;
COMMENT ON COLUMN CAPS.OUTPUT_LAUNCH_EVENT_LINK.TXT_RESULTS IS 'Description of results'
;
COMMENT ON COLUMN CAPS.OUTPUT_LAUNCH_EVENT_LINK.IND_CURRENT IS 'Indicates if Current or Not.'
;
COMMENT ON TABLE CAPS.PAC_LIMIT IS 'Stores the budgetary limit for each PAC (Program Allocation Code).* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.PAC_LIMIT.ID_PAC IS 'A unique identifier for the PAC limit table.'
;
COMMENT ON COLUMN CAPS.PAC_LIMIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PAC_LIMIT.TXT_PAC_COMMENT IS 'Comments field to allow contract manager to record reasons for PAC changes.'
;
COMMENT ON COLUMN CAPS.PAC_LIMIT.CD_PAC_REGION IS 'The region for which the PAC allocation is being made.'
;
COMMENT ON COLUMN CAPS.PAC_LIMIT.CD_PAC IS 'Contains the PAC (Program Activity Code) for the particular service code. Please reference the department''s Financial System for additional information. No codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.PAC_LIMIT.NBR_PAC_AMOUNT IS 'The regional allocation for a PAC in a designated region.'
;
COMMENT ON TABLE CAPS.PAL IS 'Stores assessment information for preparation for adult living stage.'
;
COMMENT ON COLUMN CAPS.PAL.ID_PAL_STAGE IS 'Foreign Key to the stage table. Stores the id_stage for the PAL stage.'
;
COMMENT ON COLUMN CAPS.PAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PAL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PAL.CD_PAL_CLOSE_LIV_ARR IS 'This field records the client''s living arrangement at time of closure via the user''s choice from a table.'
;
COMMENT ON COLUMN CAPS.PAL.DT_PAL_POSTASMT_DATE IS 'This field displays the date the post-test was taken. The information is entered in the PAL Detail window and is transferred to the PAL History window when the Save pushbutton is invoked.'
;
COMMENT ON COLUMN CAPS.PAL.DT_PAL_PREASMT_DATE IS 'This field displays the date the pretest for an Independent Living Skills Assessment or training topic was taken.'
;
COMMENT ON COLUMN CAPS.PAL.IND_PAL_IL_NO_ILS_ASSMT IS 'This element is records if no Independent Living Assessment (ILS) was done for the youth.'
;
COMMENT ON COLUMN CAPS.PAL.IND_PAL_IL_NO_POASMT_SCRE IS 'This element is used to record if a youth took an Independent Living Skills assessment but did not receive a score.'
;
COMMENT ON COLUMN CAPS.PAL.IND_PAL_IL_NO_PRASMT_SCRE IS 'This element is used to record if a youth took an Independent Living Skills assessment but received no score.'
;
COMMENT ON COLUMN CAPS.PAL.NBR_PAL_POSTASMT_SCORE IS 'This filed displays the score from a required post-test. The information is entered in the PAL Detail window and transferred to the PAL History window when the Save pushbutton is engaged.'
;
COMMENT ON COLUMN CAPS.PAL.NBR_PAL_PREASMT_SCORE IS 'This field displays the pre-test score from any required test. The information is entered in the PAL Detail window and is transferred to the PAL History window when the Add pushbutton is engaged.'
;
COMMENT ON COLUMN CAPS.PAL.TXT_PAL_IL_NO_ILS_RSN IS 'Used to record the reason why a youth did not take a Independent Living Skills assessment.'
;
COMMENT ON COLUMN CAPS.PAL.CD_NO_ILS_REASON IS 'Reason for now ILS assessment'
;
COMMENT ON COLUMN CAPS.PAL.DT_TRAINING_CMPLTD IS 'date the training was completed.'
;
COMMENT ON TABLE CAPS.PAL_FOLLOW_UP IS 'Stores follow-up information for persons within PAL stage.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.ID_PAL_FOLLUP_STAGE IS 'Foreign Key to the stage table. Stores the id_stage for the PAL FOLLOW UP stage.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.DT_PAL_FOLLUP_DATE IS 'Contains the system date which is non-modifiable. The date is to reflect the date the follow-up took place.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_PAL_FOLLUP_EDUC_STAT IS 'This is used to record the current educational status for the youth. This is not the highest education level the youth has obtained.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_PAL_FOLLUP_EMPLOYED IS 'Records whether the youth is employed, not employed or unknown.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_PAL_FOLLUP_HIGHEST_EDU IS 'Enables the user to choose the highest level of education the PAL client achieved at time of follow-up.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_PAL_FOLLUP_LIV_ARR IS 'This field records the client''s living arrangement at time of follow-up via the user''s choice from a table.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_PAL_FOLLUP_MARITAL IS 'This field enables the user to record the client''s follow up marital status from a table.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_PAL_FOLLUP_REUNIFIED IS 'This element is used to record if the youth was reunified with the family for a follow up from subcare discharge.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.IND_PAL_FOLLUP_NO_PUB_AST IS 'Indicates whether their is public assistance in the PAL follow up stage or not.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.IND_PAL_FOLLUP_NOT_LOCATE IS 'This field is chosen when the PAl coordinator is not able to find the client during the follow up stage.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.NBR_PAL_FOLLUP_NUM_CHLDRN IS 'Enables the user to the number of children the client has.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.ID_PAL_FOLLOW_UP IS 'Primary key - id of the PAL Follow Up Record'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.IND_CARING_ADULT IS 'Indicator if there is a caring adult.'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_NON_REPORT IS 'Reason for non report'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_INTERNSHIP IS 'If person has done an internship'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_HOMELESS IS 'If person has been homeless'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_REFERRAL_ABUSE IS 'If there was a referral for substance abuse'
;
COMMENT ON COLUMN CAPS.PAL_FOLLOW_UP.CD_INCARCERATED IS 'If there was incarceration'
;
COMMENT ON TABLE CAPS.PAL_PUBLIC_ASSIST IS 'Stores type of public assistance available for a particular stage.'
;
COMMENT ON COLUMN CAPS.PAL_PUBLIC_ASSIST.ID_PAL_PUBLIC_ASSIST_STGE IS 'Foreign Key to the STAGE table. Stores the id_stage for the PAL stage.'
;
COMMENT ON COLUMN CAPS.PAL_PUBLIC_ASSIST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PAL_PUBLIC_ASSIST.CD_PAL_PUBLIC_ASSIST IS 'The public assistance received at the time of PAL closure.'
;
COMMENT ON COLUMN CAPS.PAL_PUBLIC_ASSIST.ID_PAL_FOLLOW_UP IS 'Primary key - id of the PAL Follow Up Record'
;
COMMENT ON TABLE CAPS.PAL_SERVICE IS 'Assessment of the adult living skills of a child in DFCS conservatorship.  (FK PAL SERVICE CASE is not a true foreign key constraint.)'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.ID_PAL_SERVICE IS 'A unique identifier on the Pal Service table.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.ID_PAL_SERVICE_STAGE IS 'Foreign Key to the STAGE table. Stores the id_stage for the PAL stage.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.CD_PAL_SERVICE_CATGORY IS 'Enables the user to choose the PAL service type from a pull-down list box. This information is transferred to the Service column in the summary list box on the PAL History window when the Save pushbutton is engaged.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.CD_PAL_SERVICE_TYPE IS 'This list box on the PAL Detail window enables the user to choose the appropriate service subcategory for a chosen service. The information is transferred to the PAL History window when the Save push-button is engaged.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.DT_PAL_SERVICE_DATE IS 'Contains the date that the service was chosen. The information is transferred to the PAL History window when the Save pushbutton is engaged.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.NBR_PAL_SERVICE_UNITS IS 'Enables the user to input the hours associated with a test or service. Disengaged if the service is DMA. Transferred to the summary list box when the Save push-button is invoked.'
;
COMMENT ON COLUMN CAPS.PAL_SERVICE.SDS_PAL_SERVICE_OTHER IS 'This field enables the user to enter the Other PAL service provided to the client. This field is enabled only when the Other Support Service subcategory is chosen.'
;
COMMENT ON TABLE CAPS.PAYMENT_OF_CARE IS 'Records details of a client''s payment of care details for paid placements'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.ID_POC_EVENT IS 'Payment of Care Event ID'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.CD_POC_TYPE IS 'Payment of Care Type'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_START IS 'Start date of the payment of care'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_END IS 'End Date of the Payment of Care'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_TERMINATE IS 'Termination Date of the Payment of Care'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.NBR_SPEC_PER_DIEM IS 'Specialized add on per diem rate'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_CONCURRENT IS 'Indicates if the Payment of Care is a concurrent per diem'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.TXT_CONCUR_P_DIEM IS 'Additional comments on concurrent per diem'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.TXT_SPEC_PER_DIEM IS 'Additional comments on special per diems'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_RBWO_TYPE IS 'Indicates if RBWO is initial or review'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_PACKET_COMP IS 'Date RBWO Packet Complete'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.ID_CM_PACKET_COMP IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_PACKET_APRV IS 'Date RBWO packet approved'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.ID_SPV_PACKET_APRV IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_PACKET_SENT IS 'Date RBWO packet sent to state office'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_STAFF_COMPL IS 'Date RBWO staffing completed'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_SO_RESP IS 'Date of state office response'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.ID_SO_APRV IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_RBWO_APRV IS 'Date RBWO approved'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.ID_RBWO_REV_APRV IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.ID_RESOURCE IS 'Relative resource ID'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_RCS_TYPE IS 'Relative Care subsidy type (initial or renewal)'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_AGREEMENT IS 'Date of RCS agreement'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_ANN_REVIEW IS 'Date of RCS annual review'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.DT_COURT IS 'Date of RCS court review'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_INCOME IS 'Indicates if income certified less than $150,000'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_TERMINATE IS 'Indicate if RCS terminated'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_SUSPEND IS 'Indicates if RCS suspended'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.TXT_TERMINATE IS 'Additional comments on RCS termination'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.AMT_SPEC_FC_RBWO_WAIVER IS 'Amount of Special FC/RBWO Waiver'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.TXT_REASON_SPEC_WAIVER IS 'Reason for Specialized FC/RBWO Waiver'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.IND_CCI IS 'Indicates if the program relates to a CCI or CPA for RBWO programs. IND_CCI = Y for CCI, = N for CPA, and blank when non applicable.'
;
COMMENT ON COLUMN CAPS.PAYMENT_OF_CARE.CD_RBWO_PROGRAM IS 'For RBWO programs, this contains a one-character addition to SHINES other service codes. a = basic,b maximum, etc.'
;
COMMENT ON TABLE CAPS.PERF_DATA_ACCESS IS 'Stores statistical information about dam calls.'
;
COMMENT ON COLUMN CAPS.PERF_DATA_ACCESS.ID_SERVER IS 'Stores the numeric identifier for the server for which the DAM time was just captured.'
;
COMMENT ON COLUMN CAPS.PERF_DATA_ACCESS.ID_SERVICE IS 'Stores the numeric identifier for the service for which the DAM time was just captured.'
;
COMMENT ON COLUMN CAPS.PERF_DATA_ACCESS.TXT_SERVICE_START_TM IS 'The time of day when the DAM call was initiated.'
;
COMMENT ON COLUMN CAPS.PERF_DATA_ACCESS.NM_USER_ID IS 'Contains the login name of the user that initiated the DAM.'
;
COMMENT ON COLUMN CAPS.PERF_DATA_ACCESS.NM_DAM_ID IS 'A 7 letter identifier for the DAM.'
;
COMMENT ON COLUMN CAPS.PERF_DATA_ACCESS.NBR_DATA_ACCESS_TIME IS 'The time it took to execute the DAM.'
;
COMMENT ON TABLE CAPS.PERF_TALLY IS 'Stores previous month''s performance results to track against the performance SLA.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.DT_MONTH IS 'The month for which statistics are being captured.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.ID_OFFICE IS 'A unique integer which identifies a DFCS Office.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_1 IS 'The number of times a network call and service time was less than or equal to 1.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_2 IS 'The number of times a network call and service time was less than or equal to 2.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_3 IS 'The number of times a network call and service time was less than or equal to 3.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_4 IS 'The number of times a network call and service time was less than or equal to 4.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_5 IS 'The number of times a network call and service time was less than or equal to 5.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_6 IS 'The number of times a network call and service time was less than or equal to 6.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_7 IS 'The number of times a network call and service time was less than or equal to 7.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_10 IS 'The number of times a network call and service time was less than or equal to 10.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_12 IS 'The number of times a network call and service time was less than or equal to 12.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_20 IS 'The number of times a network call and service time was less than or equal to 20.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_24 IS 'The number of times a network call and service time was less than or equal to 24.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_LEQ_30 IS 'The number of times a network call and service time was less than or equal to 30.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_GTR_30 IS 'The number of times a network call and service time was greater than 30.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_1 IS 'The number of times service time (excluding the network time) was less than or equal to 1.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_2 IS 'The number of times service time (excluding the network time) was less than or equal to 2.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_3 IS 'The number of times service time (excluding the network time) was less than or equal to 3.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_4 IS 'The number of times service time (excluding the network time) was less than or equal to 4.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_5 IS 'The number of times service time (excluding the network time) was less than or equal to 5.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_6 IS 'The number of times service time (excluding the network time) was less than or equal to 6.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_7 IS 'The number of times service time (excluding the network time) was less than or equal to 7.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_10 IS 'The number of times service time (excluding the network time) was less than or equal to 10.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_12 IS 'The number of times service time (excluding the network time) was less than or equal to 12.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_20 IS 'The number of times service time (excluding the network time) was less than or equal to 20.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_24 IS 'The number of times service time (excluding the network time) was less than or equal to 24.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_LEQ_30 IS 'The number of times service time (excluding the network time) was less than or equal to 30.'
;
COMMENT ON COLUMN CAPS.PERF_TALLY.NBR_PRF_NONET_GTR_30 IS 'The number of times service time (excluding the network time) was greater than 30.'
;
COMMENT ON TABLE CAPS.PERSON_ADDRESS IS 'Addresses of all persons known to DFCS. Includes Collaterals, Principals, Professionals, Employees, and Foster/Adoptive Family Members.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.ID_PERSON_ADDR IS 'A unique integer which identifies a Person''s Address.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.ADDR_PERSON_ADDR_ZIP IS 'Numeric zip code for each individual known to IMPACT.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.CD_PERSON_ADDR_STATE IS 'Code representing the state in which an individual lives.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.NBR_PERSON_ADDR_HASH IS 'This field is used to increase performance during non-key searches for a particular row. For more information on the associated hashing algorithm, see the Service Definition for the Person Address AUD service (CCMN44S).'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.ADDR_PERSON_ADDR_CITY IS 'City of each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.ADDR_PERSON_ADDR_ATTN IS 'Contains the attention field for person addresses.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.ADDR_PERS_ADDR_ST_LN_1 IS 'Street address for each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.ADDR_PERS_ADDR_ST_LN_2 IS 'Second line of Street address for each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.CD_PERSON_ADDR_COUNTY IS 'Code representing the county in which an individual lives.'
;
COMMENT ON COLUMN CAPS.PERSON_ADDRESS.TXT_PERSON_EMAIL IS 'Email Address for the person'
;
COMMENT ON TABLE CAPS.PERSON_CATEGORY IS 'Specifies under what context an individual is recorded in the IMPACT system. e.g. They could be involved in a Case, be a staff person, be involved in an FA Home. It is displayed as a check mark on the Person Detail window.'
;
COMMENT ON COLUMN CAPS.PERSON_CATEGORY.ID_PERSON_CATEGORY IS 'Unique identifier to the Person Category table.'
;
COMMENT ON COLUMN CAPS.PERSON_CATEGORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_CATEGORY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_CATEGORY.CD_PERSON_CATEGORY IS 'Used within the Category list box to display various categories.'
;
COMMENT ON TABLE CAPS.PERSON_CITIZENSHIP IS 'Citizenship and Identity Information for a Person'
;
COMMENT ON COLUMN CAPS.PERSON_CITIZENSHIP.ID_PERSON_CITIZENSHIP IS 'Unique (artificial key) identifier for Person Citizenship'
;
COMMENT ON COLUMN CAPS.PERSON_CITIZENSHIP.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PERSON_CITIZENSHIP.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_CITIZENSHIP.CD_CBX IS 'Active Code for person'
;
COMMENT ON COLUMN CAPS.PERSON_CITIZENSHIP.CD_CBX_CODE_TYPE IS 'Code Type'
;
COMMENT ON TABLE CAPS.PERSON_DTL IS 'Further details about an individual in the system than are recorded on the Person Detail window. Recorded on the Person Detail FA/CVS window.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.AMT_PERSON_ANNUAL_INCOME IS 'The annual income of the FAD home.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_BIRTH_CITY IS 'City in which an individual is born.  Mislabeled as a code.  There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_BIRTH_COUNTRY IS 'The country in which an individual is born. Mislabeled as a code. There is no associated codes table associated with this data element.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_BIRTH_COUNTY IS 'Code representing the county in which an individual was born. It person was born out of state, this contains the full text name of the county.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_BIRTH_STATE IS 'Code representing the state in which an individual was born.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_CITIZENSHIP IS 'Code representing the citizenship status of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_EYE_COLOR IS 'Code representing the color of an individual''s eyes.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_FA_HOME_ROLE IS 'Code representing  the role of the foster adoptive home member.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_HAIR_COLOR IS 'Code representing the hair color of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_HIGHEST_EDUC IS 'The highest level of education achieved by this person.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.IND_PERSON_NO_US_BRN IS 'This field records the fact that an individual was not born in the US. The information is needed for AG information and to enable the country field.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.NM_PERSON_LAST_EMPLOYER IS 'The last known employer of the person.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.NM_PERSON_MAIDEN_NAME IS 'The person''s maiden name, if applicable.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.QTY_PERSON_HEIGHT_FEET IS 'The foot component of a person''s height (i.e. 6'' in 6''2).'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.QTY_PERSON_HEIGHT_INCHES IS 'The inch component of a person''s height (i.e. 2 of 6''2).'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.QTY_PERSON_WEIGHT IS 'This contains the person''s weight, in pounds.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_REMOVAL_MOTHR_MARRD IS 'A code indicating whether the mother was married at the time when the child was born. This field is editable for 45 days following removal and can be updated if additional information regarding mothers marital status is obtained.'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.IND_ANNUAL_MED IS 'Annual Medical Examination Form'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_MED_DUE IS 'Next Medical Due Date'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_CRIM_REC IS 'Criminal Records Check Due Date'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.IND_PERSON_VERIFIED IS 'Verified'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.IND_PERSON_RSRC_HSHD_MEMBER IS 'Resource Household Member'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.IND_PERSON_PATERNITY_EST IS 'Paternity Established'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_SIDE_OF_FAMILY IS 'Side of Family'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_ENTRY_US IS 'Date Entered US'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.CD_PERSON_MARRIED_AT_BIRTH IS 'Mother married at child''s birth'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.IND_LEGAL_CUSTODY IS 'Legal Custody Indicator'
;
COMMENT ON COLUMN CAPS.PERSON_DTL.DT_LAST_MED IS 'Record the last medical check up date. Page: F/A Person Detail.'
;
COMMENT ON TABLE CAPS.PERSON_ELIGIBILITY IS 'This table is used to store special types of Eligibility for a person (a person can have Medicaid Eligibility, Emergency Assist Elig, etc.). This table is used by the SAVERR Med-Upd Batch Process.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.ID_PERS_ELIG IS 'Unique identifier for a PERSON ELIGIBILITY record.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.ID_PERS_ELIG_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.CD_PERS_ELIG_ELIG_TYPE IS 'Code indicating eligibility. Based on a combination of DHS Case Code, Med Coverage, SIG, Case Status, Program Type, and Case category.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.DT_PERS_ELIG_START IS 'The Start Date of a type of Eligibility for a person. (A person can have periods of Medicaid Eligibility, Emergency Assist Eligibility, etc.)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.DT_PERS_ELIG_END IS 'The End Date of a type of Eligibility for a person. (A person can have periods of Medicaid Eligibility, Emergency Assist Eligibility, etc.)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.DT_PERS_ELIG_EA_DENY IS 'The Denial Date of Emergency Assistance Eligibility for a person. (Different from DT PERS ELIG END.)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.CD_PERS_ELIG_PRG_START IS 'Code indicating which program (CPS or STARS) started EA eligibility.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.CD_PERS_ELIG_PRG_OPEN IS 'Code indicating which program (CPS or STARS) still has EA eligibility open.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.CD_PERS_ELIG_PRG_CLOSED IS 'Code indicating which program (CPS or STARS) closed EA eligibility for this client.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY.IND_PERS_ELIG_MHMR IS 'Indicates whether or not MHMR claims Title XIX eligibility for this client.'
;
COMMENT ON TABLE CAPS.PERSON_ELIGIBILITY_DETAIL IS 'Stores detailed information about eligibility received from DHS.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.ID_PERS_ELIG_DETAIL IS 'Unique identifier of a PERSON ELIGIBILITY DETAIL record.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.ID_PERS_ELIG IS 'Unique identifier for a PERSON ELIGIBILITY record.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.ID_PERS_ELIG_DTL_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.MO_PERS_ELIG_DTL_MONTH IS 'Month during which eligibility applies.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.YR_PERS_ELIG_DTL_YEAR IS 'Year during which eligibility applies.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.CD_PERS_ELIG_DTL_ELIG_CODE IS 'Eligibility code based on the combination of DHS Case Code, Med Coverage, SIG, Case Status, Program Type and Case category.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.CD_PERS_ELIG_DTL_TYPE_CASE IS 'DHS Case Code (see DHS SAVERR data dictionary)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.CD_PERS_ELIG_DTL_MED_COV IS 'DHS Medical coverage (see DHS SAVERR data dictionary)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.CD_PERS_ELIG_DTL_STAT_IN_GRP IS 'DHS Status in Group (see DHS SAVERR data dictionary)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.CD_PERS_ELIG_DTL_CASE_STATUS IS 'DHS Case Status (see DHS SAVERR data dictionary)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.CD_PERS_ELIG_DTL_PROG_TYPE IS 'DHS Program Type (see DHS SAVERR data dictionary)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.CD_PERS_ELIG_DTL_CASE_CATEG IS 'DHS Case category (see DHS SAVERR data dictionary)'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.DT_PERS_ELIG_DTL_CASE_CERT IS 'DHS certification date.'
;
COMMENT ON COLUMN CAPS.PERSON_ELIGIBILITY_DETAIL.NBR_PERS_ELIG_DTL_CASE_NBR IS 'DHS Case Number.'
;
COMMENT ON TABLE CAPS.PERSON IS 'An individual known to DFCS. Persons include Principals, Collaterals, Employees, Professionals, and Foster/Adoptive Family Members. This table includes all the details that could be captured regardless of whether they are an employee, principal, collateral. Note: not all information will be captured for an employee.
'
;
COMMENT ON COLUMN CAPS.PERSON.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_SEX IS 'Code representing an individual''s sex.'
;
COMMENT ON COLUMN CAPS.PERSON.ADDR_PERSON_ST_LN_1 IS 'Street address for an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.ADDR_PERSON_CITY IS 'City of an  individual.'
;
COMMENT ON COLUMN CAPS.PERSON.ADDR_PERSON_ZIP IS 'Numeric zip code for an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.DT_PERSON_DEATH IS 'A date indicating the death of a child/adult involved in an open case.'
;
COMMENT ON COLUMN CAPS.PERSON.DT_PERSON_BIRTH IS 'A date indicating the date of birth of an iindividual.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_RELIGION IS 'Code representing a religion for an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_CHAR IS 'Code indicating whether a person characteristic record exists for an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_LIV_ARR IS 'Code indicating the living arrangement of the person.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERS_GUARD_CNSRV IS 'Code indicating whether guardianship has been assigned.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_STATUS IS 'Code indicating whether an individual is involved in an active case.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_DEATH IS 'Code representing the reason an individual died. (i.e. whether or not it was related to abuse/neglect.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_MARITAL_STATUS IS 'Code representing the marital status of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_LANGUAGE IS 'Code representing the language spoken by an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_ETHNIC_GROUP IS 'Code representing the ethnicity of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_STATE IS 'Abbreviated state code for an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_COUNTY IS 'Code representing the county in which an individual lives.'
;
COMMENT ON COLUMN CAPS.PERSON.IND_PERSON_DOB_APPROX IS 'Indicates that the persons Date of Birth is approximate.'
;
COMMENT ON COLUMN CAPS.PERSON.IND_PERS_CANCEL_HIST IS 'Indicates whether a row should be written to the person history table or not for an insert or update to the person table. Not stored on the person table.'
;
COMMENT ON COLUMN CAPS.PERSON.NBR_PERSON_AGE IS 'The numeric age, actual or estimated, of each principal (not reporter or collateral) involved in the case. Integer describing a person''s age.'
;
COMMENT ON COLUMN CAPS.PERSON.NBR_PERSON_PHONE IS 'Phone number of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.NM_PERSON_FIRST IS 'First name of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.NM_PERSON_MIDDLE IS 'Middle name of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.NM_PERSON_LAST IS 'Last name of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.NM_PERSON_FULL IS 'Full name of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON.TXT_PERSON_OCCUPATION IS 'Contains the individual''s occupation (not employment status).'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_SUFFIX IS 'Code representing the suffix appended to a name for distinction (e.g. ,Jr., Sr.)'
;
COMMENT ON COLUMN CAPS.PERSON.IND_AUTO_PERS_MERGE IS 'The indicator is used by the automated person merge program to identify which person records have been processed (looked at as a possible mergee) by the automated person merge program.  It isn''t used by any other program including the on-line person merge.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_DISASTER_RLF IS 'If this person was related to a disaster'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_TITLE IS 'Person''s Title, e.g. Mr., Mrs.'
;
COMMENT ON COLUMN CAPS.PERSON.IND_PERSON_US_CITIZEN IS 'Indicator if the Person is a U.S. Citizen'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_IMMIGRATION_STATUS IS 'Immigration Status of the Person'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_COUNTRY_ORIGIN IS 'Person''s official country of origin '
;
COMMENT ON COLUMN CAPS.PERSON.TXT_CHAR_CMNTS IS 'Characteristic comments for a Person'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERS_NOT_YET_DIAG IS 'Indicates if Person has been diagnosed'
;
COMMENT ON COLUMN CAPS.PERSON.CD_PERSON_PROOF_CITIZENSHIP IS 'Defines how citizenship was proven/established.'
;
COMMENT ON COLUMN CAPS.PERSON.TXT_PERSON_OTHER_RELATIONSHIPS IS 'Text describing other relationships this person has not documented in RELATIONSHIPS table.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_MATCH_TYPE IS 'Background check match type.'
;
COMMENT ON COLUMN CAPS.PERSON.CD_SMILE_CLIENT IS 'Cd to signify if the person is registered SMILE client'
;
COMMENT ON COLUMN CAPS.PERSON.TXT_IDS_NUMBER IS 'Child''s IDS case number'
;
COMMENT ON COLUMN CAPS.PERSON.IND_PREV_ADOPTED IS 'Indicator  that stores previously adopted data.'
;
COMMENT ON COLUMN CAPS.PERSON.IND_PRIVATE IS 'Data that stores whether the child is Private Adoption'
;
COMMENT ON COLUMN CAPS.PERSON.IND_PUBLIC IS 'Data that stores whether the child is Public Adoption'
;
COMMENT ON COLUMN CAPS.PERSON.IND_INTRNTL IS 'Data that stores whether the child is  International Adoption'
;
COMMENT ON COLUMN CAPS.PERSON.CD_ADOPT_STATE IS 'Stores adoption state'
;
COMMENT ON COLUMN CAPS.PERSON.CD_ADOPT_COUNTY IS 'Stores adoption county'
;
COMMENT ON COLUMN CAPS.PERSON.CD_ADOPT_CNTRY IS 'Stores adoption country'
;
COMMENT ON COLUMN CAPS.PERSON.IND_ADOPT_DISLUTON IS 'Indicator  that stores adoption dissolution data.'
;
COMMENT ON COLUMN CAPS.PERSON.TXT_PERSON_ADDL_CMNTS IS 'Additional comments for this person.'
;
COMMENT ON COLUMN CAPS.PERSON.IND_ADOPT_FINALIZED IS 'Indicator if child had a finalized adoption.  This will be used to exclude this child from search results.'
;
COMMENT ON COLUMN CAPS.PERSON.IND_ADOPT_AFCARS_SENT IS 'Indicator if the child has been reported in the adoption afcars file.'
;
COMMENT ON COLUMN CAPS.PERSON.NBR_PERSON_ID_NUMBER IS 'Contains the various id''s entered for a specific person.  On the PERSON table, this data element contains the Social Security Number.
'
;
COMMENT ON TABLE CAPS.PERSON_ETHNICITY IS 'Contains data identifying a person''s ethnicity.'
;
COMMENT ON COLUMN CAPS.PERSON_ETHNICITY.ID_PERSON_ETHNICITY IS 'A unique identifier for a row on the PERSON ETHNICITY table.'
;
COMMENT ON COLUMN CAPS.PERSON_ETHNICITY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_ETHNICITY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_ETHNICITY.CD_ETHNICITY IS 'Contains a code identifying the ethnic background of a person.'
;
COMMENT ON TABLE CAPS.PERSON_HISTORY IS 'Person History contains the data about a single person at a specific point in time. Updates to the person table trigger an insert to this table, containing the OLD person information, date stamped. The Person table will continue to have the most current information.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.ID_PERSON_HISTORY IS 'Unique identifier for the PERSON_HISTORY table.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.ID_PERS_HIST_PERSON IS 'Foreign Key to the PERSON table.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_ETHNIC IS 'A history of a person''s ethnicity.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_LANGUAGE IS 'A history of a person''s language.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_MARITAL_STAT IS 'A history of a person''s marital status.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_DEATH IS 'History of the code indicating how a person died (whether it was related to abuse/neglect).'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_RELIGION IS 'History of a person''s religion.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_SEX IS 'A history of a person''s sex.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_STATUS IS 'History of a code indicating whether a person is involved in a case.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.DT_PERS_HIST_BIRTH IS 'A history of the date indicating the birth of each individual in the IMPACT system.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.DT_PERS_HIST_DEATH IS 'A history of the date indicating the death of a child/adult involved in an open case.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.DT_PERS_HIST_EFFECT IS 'A date indicating when a person'' history record is effective.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.DT_PERS_HIST_END IS 'The date that the particular person history row ended.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.NBR_PERS_HIST_AGE IS 'A history of the numeric age, actual or estimated, of each principal (not reporter or collateral) involved in a case.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.NM_PERS_HIST_FULL IS 'This history of the full name of a person.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_CHAR IS 'Code indicating whether a person characteristic record exists for an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.IND_PERS_HIST_DOB_APPROX IS 'Byte that is sent to the BFCD to indicate the row has been selected in the parent window.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_LIV_ARR IS 'A code indicating the living arrangement of the person.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_GUARD_CNSRV IS 'A code indicating whether guardianship has been assigned on person detail window.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.TXT_PERS_HIST_OCCUPATION IS 'A history of a person''s occupation.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_DISASTER_RLF IS 'If this person was related to a disaster'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.TXT_CHAR_CMNTS IS 'Comments about characteristics'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_NOT_YET_DIAG IS 'If person has not yet been diagnosed'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.IND_PERS_HIST_US_CITIZEN IS 'Indicates if a person is a US Citizen'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_IMMG_STATUS IS 'History of person''s immigration status'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_COUNTRY_ORIGIN IS 'History of person''s county of origin'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_PROOF_CITIZEN IS 'History of person''s proof of citizenship'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_SUFFIX IS 'Person''s Suffix to their name'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_TITLE IS 'Person''s Title'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_PERS_HIST_MATCH_TYPE IS 'Person''s Match Type'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.TXT_PERS_HIST_OTHER_RELATIONS IS 'Text description of person''s other relationships.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_SMILE_CLIENT IS 'Cd to signify if the person is registered SMILE client'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.TXT_IDS_NUMBER IS 'Child''s IDS case number'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.IND_PREV_ADOPTED IS 'Indicator  that stores previously adopted data.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.IND_PRIVATE IS 'Data that stores whether the child is Private Adoption'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.IND_PUBLIC IS 'Data that stores whether the child is Public Adoption'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.IND_INTRNTL IS 'Data that stores whether the child is  International Adoption'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_ADOPT_STATE IS 'Stores adoption state'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_ADOPT_COUNTY IS 'Stores adoption county'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.CD_ADOPT_CNTRY IS 'Stores adoption country'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.IND_ADOPT_DISLUTON IS 'Indicator  that stores adoption dissolution data.'
;
COMMENT ON COLUMN CAPS.PERSON_HISTORY.TXT_PERSON_ADDL_CMNTS IS 'Additional comments for this person.'
;
COMMENT ON TABLE CAPS.PERSON_HOME_REMOVAL IS 'Individuals that were in the home at the time of a CPS Conservatorship Removal. Recorded on the Person Home Removal window.'
;
COMMENT ON COLUMN CAPS.PERSON_HOME_REMOVAL.ID_PERS_HM_REMOVAL IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_HOME_REMOVAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_HOME_REMOVAL.ID_REMOVAL_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PERSON_HOME_REMOVAL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.PERSON_ID IS 'Identifiers for Persons known to DFCS (i.e. DHS, SSN, MHMR).
'
;
COMMENT ON COLUMN CAPS.PERSON_ID.ID_PERSON_ID IS 'A unique identifier for the Person Id table.'
;
COMMENT ON COLUMN CAPS.PERSON_ID.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_ID.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_ID.CD_PERSON_ID_TYPE IS 'Contains the type of id entered on the Person Identifiers window.'
;
COMMENT ON COLUMN CAPS.PERSON_ID.DESC_PERSON_ID IS 'Contains free-form text entered in screen element labeled "Comments" on Person Identifier window (cint14w).'
;
COMMENT ON COLUMN CAPS.PERSON_ID.IND_PERSON_ID_INVALID IS 'This field is used to indicate whether or not the value in NBR PERSON ID NUMBER is valid or invalid.  A value of Y indicates the number is invalid.'
;
COMMENT ON COLUMN CAPS.PERSON_ID.DT_PERSON_ID_START IS 'Date the completed child plan was signed by the child (optional) (No default).'
;
COMMENT ON COLUMN CAPS.PERSON_ID.DT_PERSON_ID_END IS 'Date the completed child plan was signed by the child (optional) (No default).'
;
COMMENT ON COLUMN CAPS.PERSON_ID.IND_VALIDATE_BY_INTERFACE IS 'If ID was validated by an interface'
;
COMMENT ON COLUMN CAPS.PERSON_ID.NBR_PERSON_ID_NUMBER IS 'Contains the various id''s entered for a specific person.  On the PERSON table, this data element contains the Social Security Number.'
;
COMMENT ON TABLE CAPS.PERSON_LOC IS 'Assessment of the type of care required by a child in DFCS conservatorship.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.ID_PLOC_EVENT IS 'The unique identifier for an event on the Person level of care table.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.DT_PLOC_END IS 'The date the level of care ends.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.CD_PLOC_CHILD IS 'Code representing the level of care for a child.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.CD_PLOC_TYPE IS 'Code representing the type of level of care (Requested, Authorized, or Billing).'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.DT_PLOC_START IS 'The date the level of care begins.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.IND_PLOC_CSUP_SEND IS 'To indicate which records to be processed by CSUP Referral Interface batch program.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.IND_PLOC_WRITE_HISTORY IS 'Generic indicator used by the Database trigger which indicates the need for creation of a history record.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.ID_PLOC_PERSON_UPDATE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.TXT_COMMENTS IS 'Comments describing the income, resource, or special conditions.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.DT_SUB_TPR IS 'Date submitted to third party reviewer'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.DT_REV_CMPLT IS 'Date review is complete'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.NM_TPR_CONS IS 'Name of third party reviewer'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.DT_REV_CONDCT IS 'Date review was conducted'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.CD_LVL_CHG IS 'Level of Care'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.CD_PLCMT_SETTING IS 'Placement of child'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.CD_REV_TYPE IS 'Review type'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.TXT_PLCMT_REC_1 IS 'Recommended Placement #1'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.TXT_PLCMT_REC_2 IS 'Recommended Placement #2'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.TXT_PLCMT_REC_3 IS 'Recommended Placement #3'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.TXT_PLCMT_REC_4 IS 'Recommended Placement #4'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.TXT_PLCMT_REC_5 IS 'Recommended Placement #5'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.TXT_PLCMT_REC_6 IS 'Recommended Placement #6'
;
COMMENT ON COLUMN CAPS.PERSON_LOC.CD_ASSCTD_RLOC IS 'Requsted level of care'
;
COMMENT ON TABLE CAPS.PERSON_LOC_AUDIT IS 'Audit table for PERSON_LOC.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.ID_PLOC_AUD_EVENT IS 'The unique identifier for an event on the Person level of care table.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.ID_PLOC_AUD_PERSON IS 'A unique identifier for a row on the Person and Employee tables.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.DT_PLOC_AUD_END IS 'The date the level of care ends.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.ID_PLOC_AUD_CASE IS 'A unique identifier for the CAPS CASE table.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.CD_PLOC_AUD_CHILD IS 'Code representing the level of care for a child.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.CD_PLOC_AUD_TYPE IS 'Code representing the type of level of care (Requested, Authorized, or Billing).'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.DT_PLOC_AUD_START IS 'The date the level of care begins.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.IND_PLOC_AUD_CSUP_SEND IS 'To indicate which records to be processed by CSUP Referral Interface batch program.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.IND_PLOC_AUD_WRITE_HISTORY IS 'Generic indicator used by the Database trigger which indicates the need for creation of a history record.'
;
COMMENT ON COLUMN CAPS.PERSON_LOC_AUDIT.ID_PLOC_AUD_PERSON_UPDATE IS 'No description available.'
;
COMMENT ON TABLE CAPS.PERSON_MATCH_REQUEST IS 'Temporary table used by batch programs to store person match requests and results of searches.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.ID_PERSON_MATCH_REQUEST IS 'Unique identifier of a PERSON MATCH REQUEST record.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.ID_REQUEST IS 'This is a match to the primary key of the STARS EA REQUEST table.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.CD_PERS_MATCH_REQ_ENTITY IS 'Code indicating the entity making a request for a person match.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.CD_PERS_MATCH_REQ_SEX IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.CD_PERS_MATCH_REQ_CODE IS 'Code indicating whether the person match request is for an inquiry or add.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.ID_PERS_MATCH_REQ_PERSON IS 'ID PERSON of the person for whom the match is requested.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.CD_PERS_MATCH_REQ_RSLT_CODE IS 'Code indicating the results of a person match.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.NM_PERS_MATCH_REQ_FIRST IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.NM_PERS_MATCH_REQ_MIDDLE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.NM_PERS_MATCH_REQ_LAST IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.NM_PERS_MATCH_REQ_SUFFIX IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.DT_PERS_MATCH_REQ_BIRTH IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.NBR_PERS_MATCH_REQ_TDHS IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.NBR_PERS_MATCH_REQ_SSN IS 'No description available.'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.NBR_EMPLOYEE_SSN IS 'employee SSN'
;
COMMENT ON COLUMN CAPS.PERSON_MATCH_REQUEST.ID_BCKGRND_CHCK IS 'Foreign key to background check'
;
COMMENT ON TABLE CAPS.PERSON_MERGE IS 'Merge/split details about an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.ID_PERSON_MERGE IS 'The unique ID for the PERSON MERGE record.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.ID_PERS_MERGE_FORWARD IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.DT_PERS_MERGE IS 'The date the person was merged with the person selected'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.ID_PERS_MERGE_CLOSED IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.ID_PERS_MERGE_WRKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.ID_PERS_MERGE_SPLIT_WRKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.IND_PERS_MERGE_INVALID IS 'Indicates whether row on the Person Merge Split table is invalid.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE.DT_PERS_MERGE_SPLIT IS 'The date the person was split with the person selected'
;
COMMENT ON TABLE CAPS.PERSON_MERGE_PENDING IS 'Table which holds all potental persons ids to be merged.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.ID_PRSN_MRG IS 'Unique identifier of a row in the PERSON_MERGE_PENDING table.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.ID_GROUP IS 'Unique identifier of a repeating group within a registered IMPACT Form. 0 if not a group field.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.DT_PERSON_BIRTH IS 'A date indicating the date of birth of an iindividual.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_MERGE_TYPE IS 'Describes the type of record to be merged.  A = Automatic merge of records, F = identified as the person forward, R = Data review of records, P = indicates record has already been reported to worker, N = records identified NOT to be used as person forward id, C = Worker has modified information and is ready for re-processing.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_EDIT_TYPE IS 'Describes the merge edits that pervented the automatic person merge.  O =  Merge edits that did not allow the merge to complete successfully due to both person ids being associated with the same event in an open stage, P = Edit which does not allow the merge if person forward has not been a Primary Child (PC) in the same type of stage as the person closed, E = Edit which does not allow the merge if open eligibility records exist for persons and they do not match, N = unable to merge, S = trigger updated by worker.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_SEX IS 'Sex code of the person.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_PERSON_STATUS IS 'Code indicating whether an individual is involved in an active case.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_SPL_ROLE IS 'A code that indicates the role of each person involved in the case. Example: Victim, Alleged Perpetrator, Concerned relative, etc.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.NM_LAST IS 'Last name of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.NM_MIDDLE IS 'Middle name of each individual known to the IMPACT system. (used for the Person table)'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.NM_FIRST IS 'First name of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.NBR_SSN IS 'Social Security Number.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.NBR_DHS_CLNT_NBR IS 'Person''s TDHS Client Number.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.IND_INPUT_TYPE IS '1 indicates that the records came from the multiref table.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.NBR_MEDICAID IS 'TDHS Medicaid Number'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_STAGE IS 'Code that represents the stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.)'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_STAGE_PROGRAM IS 'This is the DFCS Program which controls the Stage. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.IND_STAGE_CLOSE IS 'This indicator is used to indicate if a stage is open (N) or closed (Y).'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_WKLD_STAGE_REGION IS 'A geographic area which the state is broken down into. Specific to the stage of the case it is associated with.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_WKLD_STAGE_CNTY IS 'County that the stage is or was handled within.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_WKLD_STAGE_PROGRAM IS 'This is the DFCS Program that controls the Stage. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.ADDR_PERSON_ST_LN_1 IS 'Street address for an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.CD_PERSON_COUNTY IS 'Code representing the county in which an individual lives.'
;
COMMENT ON COLUMN CAPS.PERSON_MERGE_PENDING.NBR_WKLD_UNIT IS 'Number that identifies a group of workers with common supervisor and goals.'
;
COMMENT ON TABLE CAPS.PERSON_PHONE IS 'Phone numbers of all persons known to DFCS. Includes, Principals, Collaterals, Employees, and Foster/Adoptive Family Members.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.ID_PERSON_PHONE IS 'A unique identifier for a row on the PERSON PHONE table.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.TXT_PERSON_PHONE_COMMENTS IS 'Narrative of phone comments that need to be noted. i.e. how many times worker tried to call, phone is disconnected etc.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.NBR_PERSON_PHONE_EXTENSION IS 'Extension field is used to list the extension number (if needed) for any phone numbers listed for each individual.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.NBR_PERSON_PHONE IS 'Phone number of an individual.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.DT_PERSON_PHONE_START IS 'This is the date that the Person started using the phone number.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.DT_PERSON_PHONE_END IS 'This is the date that the Person stopped using the phone number.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.IND_PERSON_PHONE_INVALID IS 'A flag that identifies one of the phone numbers provided for an individual as an invalid phone number.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.IND_PERSON_PHONE_PRIMARY IS 'A flag that identifies if the phone number is the primary phone.'
;
COMMENT ON COLUMN CAPS.PERSON_PHONE.CD_PERSON_PHONE_TYPE IS 'A code which identifies the type of phone number (i.e. home, work, school, beeper, etc.)'
;
COMMENT ON TABLE CAPS.PERSON_RACE IS 'Contains data identifying a person''s race.'
;
COMMENT ON COLUMN CAPS.PERSON_RACE.ID_PERSON_RACE IS 'A unique identifier for a row on the PERSON RACE table.'
;
COMMENT ON COLUMN CAPS.PERSON_RACE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PERSON_RACE.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PERSON_RACE.CD_RACE IS 'Contains a code identifying the race of a person.'
;
COMMENT ON TABLE CAPS.PGM_LCNSRE_TYPS IS 'Stores Program licensure Types for Facility Detail.'
;
COMMENT ON COLUMN CAPS.PGM_LCNSRE_TYPS.ID_LCNSRE_TYPS IS 'Type Id'
;
COMMENT ON COLUMN CAPS.PGM_LCNSRE_TYPS.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PGM_LCNSRE_TYPS.CD_PGM_TYPE IS 'Program licensure types for facility detail.'
;
COMMENT ON COLUMN CAPS.PGM_LCNSRE_TYPS.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON TABLE CAPS.PHONETIC_NAME IS 'Table used to store the binary translations of names so they can be searched phonetically.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.ID_PHK_NAME IS 'A unique identifier to the phonetic name table. It determines if the key is a primary key for the NAME table, the INCOMING DETAIL table or the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.ID_PHK_NAME_KEY IS 'A unique identifier to the phonetic name table that is used for the index table.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.CD_PHK_NAME_TYPE IS 'The type of phonetic name.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.NM_PHK_NAME IS 'The phonetic name.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.NM_NAME_FIRST IS 'First name of each individual known to IMPACT system.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.NM_NAME_MIDDLE IS 'Middle name of each individual known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.NM_NAME_LAST IS 'Last name of each individual known to the IMPACT system.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.IND_NAME_INVALID IS 'A flag that identifies a name previously entered for an individual as invalid.'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.IND_NAME_PRIMARY IS 'A flag that indicates that the name is the primary name for the Person.  Multiple rows may have this indicator set for one ID PERSON.  The actual primary name has IND_NAME_PRIMARY = "Y", an open-ended DT NAME END DATE (12/31/4712) and IND_NAME_INVALID = "N".'
;
COMMENT ON COLUMN CAPS.PHONETIC_NAME.DT_NAME_END_DATE IS 'Date that the individual''s name is no longer effective.'
;
COMMENT ON TABLE CAPS.PLACEMENT IS 'The placement of a child outside the parent''s home. This includes the placement of the child with relatives when he/she is in Protective Services conservatorship.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_PLCMT_EVENT IS 'A unique identifier to the event table used on Placement.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_PLCMT_CHILD IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_END IS 'The date placement ended.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_PLCMT_ADULT IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_PLCMT_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_RSRC_AGENCY IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_RSRC_FACIL IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ADDR_PLCMT_CITY IS 'Contains the address city information.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ADDR_PLCMT_CNTY IS 'Contains the county code of the county in which the address is located.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ADDR_PLCMT_LN1 IS 'Contains the first line of the street address.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ADDR_PLCMT_LN2 IS 'Contains the second line of the street address.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ADDR_PLCMT_ST IS 'Contains the address state information.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ADDR_PLCMT_ZIP IS 'Contains the address zip code information.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_1 IS 'Placement information code indicating that Medicaid and Placement Addresses are different.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_2 IS 'Placement information code indicating placement is Intended to be Permanent.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_3 IS 'Placement information code indicating Supervision Contracted.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_4 IS 'Placement information code indicating that placement is a Relative placement.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_5 IS 'Stores additional information about the placement, e.g., if the placement is with a relative.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_6 IS 'Stores additional information about the placement, e.g., if the placement is with a relative.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_7 IS 'Stores additional information about the placement, e.g., if the placement is with a relative.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_LIV_ARR IS 'The living arrangement of a child.  The values stored in this column depend on the CD_PLCMT_TYPE chosen and the corresponding codes_table for that placement type.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_REMOVAL_RSN IS 'The reason the child was removed from the placement.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_ACT_PLANNED IS 'If the placement was actual or planned'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_TYPE IS 'The type of placement.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_SERVICE IS 'A code which indicates the service for the placement.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_CAREGVR_DISCUSS IS 'The date that the placement is discussed with the caregiver.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_CHILD_DISCUSS IS 'The date the placement was discussed with the child.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_CHILD_PLAN IS 'The date that the Child Service Plan was given to the caregiver.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_EDUC_LOG IS 'The date that the education log was provided to the caregiver.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_MEDDEV_HISTORY IS 'The date the Medical/Developmental History log was given to the caregiver.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_PARENTS_NOTIF IS 'The date the parents were notified of the placement meeting.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_LAST_PREBILL IS 'The date of the last prebill. Used by the batch prebill process.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_PREPLACE_VISIT IS 'The date of a preplacement visit.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_SCHOOL_RECORDS IS 'The date that school records of the client were provided to the caregiver.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_START IS 'The date the child was placed.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_CONT_CNTCT IS 'If continued contact between the child and the placement people is recommended, this box is to be checked.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_EDUC_LOG IS 'If Education Log is not applicable for this client, the box is checked.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_EMERG IS 'Whether or not the placement is an emergency placement.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_NOT_APPLIC IS 'This element depicts whether or not placement information is applicable or not.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_SCHOOL_DOC IS 'If school documents are not applicable to the client, the check box is checked.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_WRITE_HISTORY IS 'Generic indicator used by the Database trigger which indicates the need for creation of a history record.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NBR_PLCMT_PHONE_EXT IS 'The phone extension for the placement address is listed here.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NBR_PLCMT_TELEPHONE IS 'This field is the phone number of the placement contact. The field is pre populated but is available for overwrite capability. However, the overwrite is not saved to the resource directory.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NM_PLCMT_AGENCY IS 'The name of the Child Placing Agency (if any) associated with the child''s placement resource.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NM_PLCMT_CONTACT IS 'This field enables the user to enter the name of the contact at a facility.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NM_PLCMT_FACIL IS 'Contains the name of the facility in which the child was placed. If the Placement type was PRS Foster Home, the name is prefilled. If the Placement type was Other, this field is enabled for data entry.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NM_PLCMT_PERSON_FULL IS 'The name of a noncertified person with whom the child resides.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_ADDR_COMMENT IS 'The user enters any comments regarding the placement address in this field.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_DISCUSSION IS 'Any discussion with the child about reason for placement and response to placement is recorded in this field.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_DOCUMENTS IS 'Any explanation as to why a caregiver has not been given documents regarding the client is documented here.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_REMOVAL_RSN IS 'Removal from placement reason description.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_8 IS 'Stores additional information about the placement, e.g., if the placement is with a relative.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_9 IS 'Stores additional information about the placement, e.g., if the placement is with a relative.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PLCMT_PERM_EFF IS 'The date the child was selected as ''Intended to be permanent'' on the Placement Information list box. The start date for the placement to be permanent may be after the start date of the placement.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_10 IS 'Placement information code indicating a placement from within State - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_11 IS 'Placement information code indicating a placement from Out of State - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_12 IS 'Placement information code indicating a placement from Another Country - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_13 IS 'Placement information code indicating placement by Public Agency - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_14 IS 'Placement information code indicating placement by Private Agency - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_15 IS 'Placement information code indicating placement by Tribal Council - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_16 IS 'Placement information code indicating placement by Individual Person - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_INFO_17 IS 'Placement information code indicating placement by Birth Parent - ADO only.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_CONTACT_WRKR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_CONTACT_METHOD IS 'Records method of contact with the facility/home regarding the placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_TEMP_TYPE IS 'Records type of temporary placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_TEMP_CMNTS IS 'Records additional comments on temporary placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_WAIVER_REQD IS 'Indicates if policy waiver is required to complete placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_WAIVER_TYPE IS 'CD_WAIVER_TYPE'
;
COMMENT ON COLUMN CAPS.PLACEMENT.ID_WAIVER IS 'Records unique ID of waiver to complete placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_MATCH IS 'Records matching percentage of child with home'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_BOARDING_CNTY IS 'Records the boarding county'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_TRIAL_HOME IS 'Indicates if the placement is a trial home visit'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_TRIAL_CO_START IS 'Records start date of court order for trial home visit'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_TRIAL_CO_END IS 'Records end date of court order for trial home visit'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_ADO_TYPE IS 'Records the type of adoption for adoptive placements'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_SAFE IS 'Indicates if placement is in safe setting'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_RESTR IS 'Indicates if placement is least restrictive available'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_FAM IS 'Indicates if placement is most family like available'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_APPR IS 'Indicates if placement is appropriate'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_PROX IS 'Indicates if placement is in close proximity to home of removal'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_SCH_DIST IS 'Indicates if placement required school district change'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_CASE_PLAN IS 'Indicates if placement is consistent with case plan'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_CHECKLIST IS 'Records additional comments on placement checklist responses'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_TRAUMA IS 'Indicates if child experienced trauma during the placement move'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_TRAUMA IS 'Additional comments on trauma experienced due to placement move'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_SIBLING IS 'Indicates if child able to stay with siblings'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NBR_PLCMT_SIB_CARE IS 'Number of siblings in care'
;
COMMENT ON COLUMN CAPS.PLACEMENT.NBR_PLCMT_SIB_CHILD IS 'Number of siblings placed with child'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_SIBLING IS 'Reason child could not be placed with siblings'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_SIBLING IS 'Additional comments on why child could not be placed with siblings'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_PLCMT_CCFA IS 'Indicates if placement matches CCFA recommendations'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_CCFA IS 'Reason why placement does not match CCFA recommendations'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PLCMT_CCFA IS 'Additional comments on why placement does not match CCFA recommendations'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_SPVSN IS 'Indicates if supplemental supervision provided'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_SPVSN IS 'Additional comments on supplemental supervision'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PSY_INFO IS 'Date psychological information shared with placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PSY_INFO_CONTACT IS 'Person contacted regarding psychological info'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_PSY_CP IS 'Date psychological portions of case plan shared with placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_PSY_CP_CONTACT IS 'Person contacted regarding psychological portions of case plan'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_MED_INFO_CONTACT IS 'Person contacted regarding medical information'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_MED_CP IS 'Date medical portions of case plan shared with placement'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_MED_CP_CONTACT IS 'Person contacted regarding medical portions of case plan'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_EDU_INFO_CONTACT IS 'Person contacted regarding educational info'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_EDU_CP_CONTACT IS 'Person contacted regarding educational portions of case plan'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_DOC_CMNTS IS 'Additional comments regarding documents provided to placement resource'
;
COMMENT ON COLUMN CAPS.PLACEMENT.IND_AFCARS_DISCHARGE IS 'Indicates if placement removal is an AFCARS discharge'
;
COMMENT ON COLUMN CAPS.PLACEMENT.DT_AFCARS_DISCHARGE IS 'Date of AFCARS discharge'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_AFCARS_DISCHARGE IS 'Type of AFCARS discharge'
;
COMMENT ON COLUMN CAPS.PLACEMENT.CD_PLCMT_ADPT_BY IS 'Code for Adoption By'
;
COMMENT ON COLUMN CAPS.PLACEMENT.TXT_ADO_CMNTS IS 'Adoption Comments'
;
COMMENT ON TABLE CAPS.PLACEMENT_REFERRAL IS 'Capture the referrals for placements of children into a certain resource.'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.ID_PLACEMENT_REFERRAL IS 'Primary key identifying the referral'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.ID_EMPLOYEE IS 'ID of the employee that requested the referral'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.ID_RESOURCE IS 'ID of the resource for putting child on the waiting list for.'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.DT_BEGIN IS 'Begin date of the referral'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.DT_EXPIRATION IS 'Expiration date of the referral'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.CD_STATUS IS 'Status of the referral'
;
COMMENT ON COLUMN CAPS.PLACEMENT_REFERRAL.CD_PLACEMENT_TYPE IS 'Placement type that has been referred'
;
COMMENT ON TABLE CAPS.PLAN_GOAL IS 'Holds Goals for the Family Plan, Foster Care Case Plan Child, and Foster Care Case Plan Family'
;
COMMENT ON COLUMN CAPS.PLAN_GOAL.ID_PLAN_GOAL IS 'Plan Goal ID'
;
COMMENT ON COLUMN CAPS.PLAN_GOAL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PLAN_GOAL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PLAN_GOAL.CD_GOAL_TYP IS 'Goal Type'
;
COMMENT ON COLUMN CAPS.PLAN_GOAL.CD_GOAL_RSN IS 'Goal Reason'
;
COMMENT ON COLUMN CAPS.PLAN_GOAL.TXT_OTH IS 'If other, please explain'
;
COMMENT ON COLUMN CAPS.PLAN_GOAL.TXT_GOAL IS 'Change/Goal'
;
COMMENT ON TABLE CAPS.PLAN_PARTICIPANT IS 'Holds Participants for the Family Plan, Foster Care Case Plan Child, and Foster Care Case Plan Family'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.ID_PLAN_PARTICIPANT IS 'Plan Participant ID'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.CD_PART_TYP IS 'Participant Type'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.NM_PART IS 'Name of Participant'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.CD_REL IS 'Relationship of Participant'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.DT_SIGN IS 'Signed Receipt of Copy'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.DT_PART IS 'Participation Date'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.IND_APPV IS 'Person Approves'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.DT_APPV IS 'Date of Approval'
;
COMMENT ON COLUMN CAPS.PLAN_PARTICIPANT.TXT_NO_APPV IS 'Why person did not approve'
;
COMMENT ON TABLE CAPS.PLAN_SEC_GOAL IS 'Holds Secondary Goals for the Family Plan, Foster Care Case Plan Child, and Foster Care Case Plan Family'
;
COMMENT ON COLUMN CAPS.PLAN_SEC_GOAL.ID_PLAN_SEC_GOAL IS 'Plan Secondary Goal ID'
;
COMMENT ON COLUMN CAPS.PLAN_SEC_GOAL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PLAN_SEC_GOAL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PLAN_SEC_GOAL.TXT_DESC IS 'Description'
;
COMMENT ON COLUMN CAPS.PLAN_SEC_GOAL.CD_STAT IS 'Status'
;
COMMENT ON COLUMN CAPS.PLAN_SEC_GOAL.IND_PRNT_APPV IS 'Parent Approval'
;
COMMENT ON TABLE CAPS.PLAN_STEP IS 'Holds Steps for the Family Plan, Foster Care Case Plan Child, and Foster Care Case Plan Family'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.ID_PLAN_STEP IS 'Primary Key of Plan Step table'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.ID_PLAN_GOAL IS 'Plan Goal ID'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.TXT_PRIORITY IS 'Priority'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.TXT_RSPNS IS 'Responsibility'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.TXT_STEP IS 'Step'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.TXT_STEP_COMM IS 'Comment'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.CD_STATUS IS 'Status'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.DT_ANT_COMP IS 'Anticipated Completion Date'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.DT_ACT_COMP IS 'Actual Completion'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.CD_STEP_CODE IS 'Code used for the step in the codes table.'
;
COMMENT ON COLUMN CAPS.PLAN_STEP.IND_SELECTED IS 'Indicates if the step is selected or not.'
;
COMMENT ON TABLE CAPS.PLCMT_DISCHG_NARR IS 'Table used to store the narrative for placement discharges.'
;
COMMENT ON COLUMN CAPS.PLCMT_DISCHG_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PLCMT_DISCHG_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PLCMT_DISCHG_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PLCMT_DISCHG_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Placement Discharge for a Child.'
;
COMMENT ON COLUMN CAPS.PLCMT_DISCHG_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.PLCMT_ISSUES_NARR IS 'Table used to store the narrative for placement issues.'
;
COMMENT ON COLUMN CAPS.PLCMT_ISSUES_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PLCMT_ISSUES_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PLCMT_ISSUES_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PLCMT_ISSUES_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description for the Placement Issues for a Child placement.'
;
COMMENT ON COLUMN CAPS.PLCMT_ISSUES_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.POLICY_LINK IS 'Static table used by the application to display the PolicyLink page depending on the task code of the page that is being accessed when the handbook image is clicked. Also used to populate the values of policylink URL in the text fields of the policy link management page.'
;
COMMENT ON COLUMN CAPS.POLICY_LINK.ID_POLICY_LINK IS 'Unique identifier and primary key for the POLICY_LINK table.'
;
COMMENT ON COLUMN CAPS.POLICY_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.POLICY_LINK.CD_TASK IS 'The primary key to the TASK table.  The code value may be stored in various other tables.  The value may then be used to acquire other information about the task, such as a description, from the TASK table.'
;
COMMENT ON COLUMN CAPS.POLICY_LINK.TXT_POLICY_LINK IS 'Text name assigned to Policy Link URL'
;
COMMENT ON TABLE CAPS.POLICY_WAIVER IS 'Contains a list of policy waivers associated with an event. A waiver is required to document a variance from official policy.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.ID_WVR_EVENT IS 'A unique identifier to the EVENT table. Identifies the Event that is policy waiver applies to.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.ID_WVR_CASE_MGR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.DT_WVR_REQUEST IS 'The date the waiver was requested.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_TYPE IS 'The type (code) of the waiver.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_REASON IS 'Reason for the waiver.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.DT_WVR_EXPRTN IS 'Date of expiration for the waiver.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.TXT_WVR_COMMENTS IS 'Comments associated with this policy waiver.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.MNTH_WVR_CTCT IS 'Contact Month'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.YR_WVR_CTCT IS 'Contact Year'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.TXT_WVR_OTHER IS 'Other Waiver Text'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.ID_WVR_PRN_UNABLE_CNCT IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_AUTH_COUNTY IS 'County Code'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_PMT_COUNTY IS 'Waiver Payment County'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_UAS_CD IS 'UAS CODE'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_ENT_CD IS 'Entitlement Code'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.DT_WVR_BEGIN IS 'Begin Date of Waiver'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.DT_WVR_END IS 'End Date for Waiver'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.ID_WVR_PRY_CUST IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.ID_WVR_RSRC IS 'Resource'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_SVC_DESC IS 'Service Description'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.AMT_WVR IS 'Waiver Amount'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.NBR_WVR_UNIT IS 'Number of Units'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.CD_WVR_JUSTIFICATION IS 'Justification'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.TXT_WVR_CAPACITY IS 'Waiver Capacity'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.TXT_SLP_ARNGMTS IS 'Sleeping Arrangements'
;
COMMENT ON COLUMN CAPS.POLICY_WAIVER.AMT_APP_PRDM IS 'Approved Per Diem'
;
COMMENT ON TABLE CAPS.POPULATION_SEGMENT IS 'This is a demographic group of people, typically used in reference to those who may be served by a resource.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.POPULATION_SEGMENT.CD_POPULATION_SEGMENT IS 'No description available.'
;
COMMENT ON COLUMN CAPS.POPULATION_SEGMENT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.PPA_DELVRD_SVC IS 'Temporary table used by PPA batch process to store history of foster care payments. Loaded by program to create reversal and adjustment line items.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.ID_PPA_SVC IS 'Corresponds to the element ID_SVC_DTL in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.ID_PPA_SVC_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.AMT_PPA_SVC_FEE_PAID IS 'Corresponds to the element AMT_SVC_DTL_FEE_PAID in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.AMT_PPA_SVC_INCOME IS 'Corresponds to the element AMT_SVC_DTL_INCOME in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.AMT_PPA_SVC_UNIT_RATE IS 'Corresponds to the element AMT_SVC_DTL_UNIT_RATE in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_COUNTY IS 'Corresponds to the element CD_SVC_DTL_COUNTY in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_OBJ_CODE IS 'Corresponds to the element CD_SVC_DTL_OBJ_CODE in the DELVRD_SVC_DTL Table.  Please reference the Financial System for additional information.  There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_OBJ_CERT IS 'Corresponds to the element CD_SVC_DTL_OBJ_CERT in the DELVRD_SVC_DTL Table. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_OBJ_PURE IS 'Corresponds to the element CD_SVC_DTL_OBJ_PURE in the DELVRD_SVC_DTL Table. Please reference the Financial System for additional information. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_PAC IS 'Corresponds to the element CD_SVC_DTL_PAC in the DELVRD_SVC_DTL Table.  Please reference the Financial System for additional information.  There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_SERVICE IS 'Corresponds to the element CD_SVC_DTL_SERVICE in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_UNIT_TYPE IS 'Corresponds to the element CD_SVC_DTL_UNIT_TYPE in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.MO_PPA_SVC_SVC_MONTH IS 'The month for the PPA Service.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_CSLI IS 'Corresponds to the element NBR_SVC_DTL_CSLI in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_FROM_DAY IS 'Corresponds to the element NBR_SVC_DTL_FROM_DAY in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_OBJ_CERT IS 'Corresponds to the element NBR_SVC_DTL_OBJ_CERT in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_OBJ_CODE IS 'Corresponds to the element NBR_SVC_DTL_OBJ_CODE in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_OBJ_PURE IS 'Corresponds to the element NBR_SVC_DTL_OBJ_PURE in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_TO_DAY IS 'Corresponds to the element NBR_SVC_DTL_TO_DAY in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_UNIT_QTY IS 'Corresponds to the element NBR_SVC_DTL_UNIT_QTY in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_PPA_SVC_VID IS 'Corresponds to the element NBR_INVO_VID in the INVOICE Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.YR_PPA_SVC_SVC_YEAR IS 'Corresponds to the element YR_SVC_DTL_SVC_YEAR in the DELVRD_SVC_DTL Table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_INVO_TYPE IS 'Code that indicates the type of invoice related to the prior period adjustment.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_ADJUSTMENT_RB IS 'Contains a code indicating whether or not the invoice is a normal invoice or an adjusment.  If it is an adjustment invoice, the code indicates whether it is client- or contract-specific.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.DT_PPA_SVC_APPROVAL_DATE IS 'Contains the date the invoice was marked as approved.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.DT_PPA_SVC_ENTRY_COMPLETED IS 'Contains the date on which data entry was completed for this invoice.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.AMT_PPA_SVC_CLAIMED_AMOUNT IS 'Contains the total dollar amount entered for all line items on a particular invoice.  (This value is not edited for accuracy.)'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.AMT_PPA_SVC_VALID_AMOUNT IS 'Contains the total dollar amount validated for all line items on a particular invoice'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_PPA_SVC_FUND_STREAM IS 'Indicates the funding stream used for payment of the current row.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.ID_PPA_SVC_AUTH_DTL IS 'This is a match to the primary key of the SVC AUTH DETAIL table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.NBR_CNTRCT_PRD IS 'Contains a number identifying the period for a specific contract.  Each period covers a specific time frame.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_STG_FND IS 'Contains the stage found during invoice validation that covers the service period.  If multiple stages were open, the one recorded is the first found in the stage/stage type hierarchy table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_STG_TYP_FND IS 'Contains the stage type found during invoice validation that covers the service period.  If multiple stage types were open, the one recorded is the first found in the stage/stage type hierarchy table.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_STG_USD IS 'Contains the stage used for the accounting code lookup during invoice validation.  It may be different from the stage found for the client if "ALL" is substituted for the stage.'
;
COMMENT ON COLUMN CAPS.PPA_DELVRD_SVC.CD_STG_TYP_USD IS 'Contains the stage type used for the accounting code lookup during invoice validation.  It may be different from the stage type found for the client if "ALL" is substituted for the stage type.'
;
COMMENT ON TABLE CAPS.PPA_REPORT IS 'Temporary table populated by the Prior Period Adjustment (PPA) batch process used by the PPA SQR formatter for the PPA report.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.ID_PPA IS 'Unique identifier and primary key for a PPA_REPORT record.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.ID_PPA_FACIL IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.ID_PPA_ORIG_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.ID_PPA_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.ID_PPA_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.CD_PPA_ELIG_SELECTED IS 'This element contains the selected eligibility of a child as it exists for particular time frame.  It is used on the PPA_REPORT table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.CD_PPA_MED_ELIG_GROUP IS 'This element contains the Medicare group for a child as it exists for the particular time frame.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.CD_PPA_PLOC_CHILD IS 'This element contains the billing level of care for a child, for a particular time frame. It is referenced on the PPA_REPORT table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.DT_PPA_START IS 'Contains the start date of a period where the Placement, Eligibility, and Billing Level of Care for a child are constant. It is referenced on the PPA_REPORT table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.DT_PPA_END IS 'This element contains the end date for a particular period of time in which the Placement, Eligibility, and Billing Level of Care for a child remain constant. This element resides on the PPA_REPORT table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.MO_PPA_SVC_MONTH IS 'The month for the PPA Service.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.NBR_PPA_FROM_DAY IS 'This element contains the From day as referenced on the Foster Care detail window. It is the beginning day of an invoice line item that was previously paid and needs to be backed out. It resides on the PPA_REPORT table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.NBR_PPA_TO_DAY IS 'Contains the To day from an invoice line item as referenced on the Foster Care Detail window.  It represents the last day a child was in a resource in a billing month, for an invoice line item that is being reversed. It resides on the PPA_REPORT table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.YR_PPA_SVC_YEAR IS 'Contains the service year for a line item written to the PPA_REPORT table.'
;
COMMENT ON COLUMN CAPS.PPA_REPORT.IND_PPA_EA IS 'Indicates whether or not the person was EA eligible during the From/To period.'
;
COMMENT ON TABLE CAPS.PPT IS 'Details about a Permanency Planning Team meeting. The PPT meeting is held regularly during a CPS Conservatorship case.'
;
COMMENT ON COLUMN CAPS.PPT.ID_PPT_EVENT IS 'A unique identifier to the event table.'
;
COMMENT ON COLUMN CAPS.PPT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PPT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PPT.ADDR_PPT_CITY IS 'Stores the city of the location of PPT meeting.'
;
COMMENT ON COLUMN CAPS.PPT.ADDR_PPT_CNTY IS 'Stores the county of the location of PPT meeting.'
;
COMMENT ON COLUMN CAPS.PPT.ADDR_PPT_ST_LN_1 IS 'The first line of the street address of the PPT meeting.'
;
COMMENT ON COLUMN CAPS.PPT.ADDR_PPT_ST_LN_2 IS 'Stores the street ln 2 of location of PPT Meeting.'
;
COMMENT ON COLUMN CAPS.PPT.ADDR_PPT_STATE IS 'The state for the address of the PPT meeting.'
;
COMMENT ON COLUMN CAPS.PPT.ADDR_PPT_ZIP IS 'Stores the zip code of location of PPT Meeting.'
;
COMMENT ON COLUMN CAPS.PPT.DT_PPT_DATE IS 'Date that the PPT meeting was scheduled and eventually held.'
;
COMMENT ON COLUMN CAPS.PPT.DT_PPT_DOC_COMP IS 'This field stores the completion date of ppt review documentation.'
;
COMMENT ON COLUMN CAPS.PPT.NBR_PPT_PHONE IS 'Phone Number of PPT meeting location.'
;
COMMENT ON COLUMN CAPS.PPT.NBR_PPT_PHONE_EXT IS 'The phone number extension of the PPT meeting location.'
;
COMMENT ON COLUMN CAPS.PPT.TXT_PPT_ADDR_CMNT IS 'Narrative directions or special instructions on the location of ppt meeting.'
;
COMMENT ON COLUMN CAPS.PPT.CD_PPT_TYPE IS 'Meeting or Review type'
;
COMMENT ON COLUMN CAPS.PPT.IND_MDT_PERM IS 'MDT Meeting regarding Permanency'
;
COMMENT ON COLUMN CAPS.PPT.IND_MDT_SFTY IS 'MDT Meeting regarding Safety'
;
COMMENT ON COLUMN CAPS.PPT.IND_MDT_WLBNG IS 'MDT Meeting regarding wellbeing'
;
COMMENT ON COLUMN CAPS.PPT.IND_FTM_REQ_MET IS 'FTM Meeting requirements met'
;
COMMENT ON COLUMN CAPS.PPT.DT_UR_BEGIN IS 'Begin date of the utilization review'
;
COMMENT ON COLUMN CAPS.PPT.DT_UR_END IS 'End date of the utilization review'
;
COMMENT ON COLUMN CAPS.PPT.IND_AH_ASST_NEEDED IS 'Administrative Hearing Assistance needed'
;
COMMENT ON COLUMN CAPS.PPT.DT_AH_REQUESTED IS 'Date Administrative Hearing was requested'
;
COMMENT ON COLUMN CAPS.PPT.DT_AH_OUTCOME IS 'Date Administrative Hearing outcome discussed'
;
COMMENT ON COLUMN CAPS.PPT.DT_PERM_REP_COMP IS 'Date that the permanency report was completed'
;
COMMENT ON COLUMN CAPS.PPT.DT_PREP_INTVW IS 'Date of the preparation interview'
;
COMMENT ON COLUMN CAPS.PPT.IND_TRAN_PLAN_COMP IS 'indicator if the transition plan is complete.'
;
COMMENT ON TABLE CAPS.PPT_NARR IS 'Table used to store the narrative for the child participant window.'
;
COMMENT ON COLUMN CAPS.PPT_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PPT_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PPT_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PPT_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Quarterly FAD.'
;
COMMENT ON COLUMN CAPS.PPT_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.PPT_PARTICIPANT IS 'Stores meeting information for planning the goal of the child.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.ID_PPT_PART IS 'A unique identifier to the PPT Part table.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.CD_PPT_NOTIF_TYPE IS 'The type of notification (i.e. verbal, written, etc.) is entered here.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.CD_PPT_PART_TYPE IS 'This box enables the name and relationship entry fields.  It allows for classification of persons participation in the plan process. Participate can be a person in case, staff or others.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.DT_PPT_PART IS 'This data element is where the user inputs/selects the date the participant participated in the PPT meeting.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.DT_PPT_PART_DATE_NOTIF IS 'This data element is where the user inputs/selects the date the participant was notified when the meeting would take place. The information is passed to the Notified column of the Participants List Box when the Add pushbutton is invoked.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.NM_PPT_PART_FULL IS 'This is the full name of the ppt participant. Could be a person in case, staff or others.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.SDS_PPT_PART_RELATIONSHIP IS 'The relationship of the other person to the case is entered here.'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.CD_PPT_PART_TITLE IS 'Title of person'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.NM_PPT_PART_AGENCY IS 'Agency of person '
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.IND_ACCPTD_CHANGES IS 'Indicator if the person accepted the changes to the case plan'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.IND_SIGNED_WVR_AH IS 'Indicator if the person signed the waiver of administrative hearing'
;
COMMENT ON COLUMN CAPS.PPT_PARTICIPANT.IND_REQ_AH IS 'Indicator if the person requested the administrative hearing'
;
COMMENT ON TABLE CAPS.PROB_GOAL_TASK_SVC IS 'Table used to store associated Problem, Goal, Task, Service tetrad for the service plan.'
;
COMMENT ON COLUMN CAPS.PROB_GOAL_TASK_SVC.CD_SVC_PLAN_PROBLEM IS 'The code identifying a problem in the Service Plan. It is displayed in a list box.'
;
COMMENT ON COLUMN CAPS.PROB_GOAL_TASK_SVC.CD_SVC_PLAN_GOAL IS 'Displays either the task or goal from the highlighted row, depending on which radio button has been selected.'
;
COMMENT ON COLUMN CAPS.PROB_GOAL_TASK_SVC.CD_SVC_PLAN_TASK IS 'Contains a code identifying a task in the service plan. It is populated from the Options list box when task is chosen as the Current Selection. The Tasks are dependent upon the Goal chosen.'
;
COMMENT ON COLUMN CAPS.PROB_GOAL_TASK_SVC.CD_SVC_PLAN_SVC IS 'Contains a code identifying a service that is populated from a list box when Service is chosen as the Current Selection. Services are dependent upon the Task chosen.'
;
COMMENT ON COLUMN CAPS.PROB_GOAL_TASK_SVC.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.PROF_ASSMT_NARR IS 'A blob of narrative (Formatted in MS Word) detailing additional findings of a medical/mental assessment.'
;
COMMENT ON COLUMN CAPS.PROF_ASSMT_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PROF_ASSMT_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PROF_ASSMT_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PROF_ASSMT_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.PROF_ASSMT_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.PROFESSIONAL_ASSMT IS 'Evaluation of a principal made by a medical or mental health professional.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ID_PERSON_PRINCIPAL IS 'A unique integer which identifies a Person.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ID_PERSON_PROFESSIONAL IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.DT_PROF_ASSMT_APPT IS 'The date of the profession assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.CD_PROF_ASSMT_APPT_RSN IS 'Stores APS/CPS reasons for obtaining a medical or psychological professional assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.TXT_PROF_ASSMT_OTHER IS 'Text that defines what was meant by Other when selected as Reason for a Medical/Mental Assessment. Required whenever Other is selected.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.TXT_PROF_ASSMT_FINDINGS IS 'Text that details the Findings of the Professional in relation to a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.NM_PROF_ASSMT_NAME IS 'Name of the Professional who performed the Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.NM_PROF_ASSMT_PRINCIPAL IS 'The name of the APS client receiving the professional assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.TXT_PROF_ASSMT_CMNTS IS 'Professional assessment comments.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.NBR_PROF_ASSMT_PHONE IS 'The phone number recorded on the Address/Phone Detail window for the Professional involved in a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.NBR_PROF_ASSMT_PHONE_EXT IS 'The extension of the phone number recorded on the Address/Phone Detail window for the Professional for a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ADDR_PROF_ASSMT_ST_LN_1 IS 'Street address recorded on the Address/Phone Detail window for the Professional for a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ADDR_PROF_ASSMT_ST_LN_2 IS 'Street address recorded on the Address/Phone Detail window for the Professional for a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ADDR_PROF_ASSMT_CITY IS 'City recorded on the Address/Phone Detail window for the Professional for a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.ADDR_PROF_ASSMT_ZIP IS 'ZIP code recorded on the Address/Phone Detail window for the Professional for a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.CD_PROF_ASSMT_COUNTY IS 'County recorded on the Address/Phone Detail window for the Professional for a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.CD_PROF_ASSMT_STATE IS 'State recorded on the Address/Phone Detail window for the Professional for a Medical/Mental Assessment.'
;
COMMENT ON COLUMN CAPS.PROFESSIONAL_ASSMT.IND_OUT_NETWORK_AUTH IS 'Indicator that the visit with the out of network health care provider was authorized'
;
COMMENT ON TABLE CAPS.PROTECTIVE_SERVICE_ALERT IS 'Captures statewide alerts on missing people'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.ID_PROTECTIVE_SERVICE_ALERT IS 'Primary key - ID of Protective Service Alert Record'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.ID_PSA_CASE_MANAGER IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.CD_PSA_STAGE IS 'stage the protective service alert is associated to'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.DT_PSA_DATE IS 'Date of the protective service alert'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.DT_PSA_ABSCONDED IS 'Date the person absconded'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.CD_PSA_REASONALERT IS 'Reason for protective service alert'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.CH_PSA_ALLPESRLOCATED IS 'Checkbox to indicate if all people have been located'
;
COMMENT ON COLUMN CAPS.PROTECTIVE_SERVICE_ALERT.TXT_PSA_COMMENT IS 'Comments related to protective service alert'
;
COMMENT ON TABLE CAPS.PROVIDER IS 'Provider of services. Details are recorded through the resource dialog.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.PROVIDER.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.PROVIDER.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.PSA_PERSON_LINK.ID_PSA_PERSON_LINK IS 'Primary Key (Artificial) of PSA_PERSON_LINK table'
;
COMMENT ON COLUMN CAPS.PSA_PERSON_LINK.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.PSA_PERSON_LINK.ID_PROTECTIVE_SERVICE_ALERT IS 'Foreign key to the Protective Service Alert Record'
;
COMMENT ON COLUMN CAPS.PSA_PERSON_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.PSA_PERSON_LINK.DT_ACTIVATED IS 'The date the protective service alert was issued for this person'
;
COMMENT ON COLUMN CAPS.PSA_PERSON_LINK.DT_DEACTIVATED IS 'The date the protective service alert was deactivated for this person.'
;
COMMENT ON TABLE CAPS.QUART_NARR IS 'The Narrative Table for the Quarterly Assessment'
;
COMMENT ON COLUMN CAPS.QUART_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.QUART_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.QUART_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.QUART_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Quarterly Assessment'
;
COMMENT ON COLUMN CAPS.QUART_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.REC_RETEN_TYPE IS 'Table which contains the information regarding a record retention types.'
;
COMMENT ON COLUMN CAPS.REC_RETEN_TYPE.CD_REC_RTN_TYPE IS 'This element is used as a key into the REC RETEN TYPE table and is used by the Records Retention Common Function.'
;
COMMENT ON COLUMN CAPS.REC_RETEN_TYPE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REC_RETEN_TYPE.IND_REC_RTN_TYPE_PERM IS 'Indicates whether the case record should be retained permanently.'
;
COMMENT ON COLUMN CAPS.REC_RETEN_TYPE.NBR_REC_RTN_TYPE_MNTH IS 'The number of Months used to calculate the Retention Date for a Case.'
;
COMMENT ON COLUMN CAPS.REC_RETEN_TYPE.NBR_REC_RTN_TYPE_YEAR IS 'Year used to calculate the Retention Date for a Case.'
;
COMMENT ON COLUMN CAPS.REC_RETEN_TYPE.TXT_REC_RTN_TYPE_DESC IS 'This is the description for the Records Retention Codes (ACH, ACP, etc).'
;
COMMENT ON TABLE CAPS.RECORDS_CHECK IS 'Stores the record check requests for DPS in the system.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.ID_REC_CHECK IS 'A unique identifier to the Records Check table.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.ID_REC_CHECK_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.ID_REC_CHECK_REQUESTOR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.CD_REC_CHECK_CHECK_TYPE IS 'A code that identifies the type of search that was done for each individual in the case.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.CD_REC_CHECK_EMP_TYPE IS 'A code that identifies the type of person (employee) that a Criminal History Check is done for.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.CD_REC_CHECK_STATUS IS 'Displays the current status of that particular record (and blob) pertaining to a Criminal History Check.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.DT_REC_CHECK_COMPLETED IS 'Records the date the search was done on the system for that individual client.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.DT_REC_CHECK_REQUEST IS 'The date the external records check was requested is entered here.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.TXT_REC_CHECK_COMMENTS IS 'Text field that allows the user to enter comments about the records check.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK.IND_RECCHECK_HISTORY IS 'Indicator if there is previous history'
;
COMMENT ON TABLE CAPS.RECORDS_CHECK_NARR IS 'Records Check Narrative table'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK_NARR.ID_REC_CHECK IS 'A unique identifier to the Records Check table.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.RECORDS_CHECK_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.RECORDS_RETENTION IS 'Table to track the retention and destruction of the physical file for a case.'
;
COMMENT ON COLUMN CAPS.RECORDS_RETENTION.ID_REC_RTN_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RECORDS_RETENTION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RECORDS_RETENTION.CD_REC_RTN_RETEN_TYPE IS 'The retention code associated with the closed case. Based upon stages/services associated with the case.'
;
COMMENT ON COLUMN CAPS.RECORDS_RETENTION.DT_REC_RTN_DSTRY_ACTUAL IS 'The date the case is eligible to be destroyed when the PURGE process actually runs.  When a case is closed, DT_REC_RTN_DSTRY_ACTUAL and DT_REC_RTN_DSTRY_ELIG are set to the same calculated destruction date, but from then on, this field, ACTUAL, is the  one that is updated, and is used to pull cases to be purged.'
;
COMMENT ON COLUMN CAPS.RECORDS_RETENTION.DT_REC_RTN_DSTRY_ELIG IS 'The date the case was originally eligible to be destroyed. When a case is closed, DT_REC_RTN_DSTRY_ELIG and DT_REC_RTN_DSTRY_ACTUAL are set to the same calculated destruction date, but from then on, this field is no longer valid and the ACTUAL date is the one used to select cases to be purged..'
;
COMMENT ON COLUMN CAPS.RECORDS_RETENTION.TXT_REC_RTN_DSTRY_DT_RSN IS 'This stores the reason why a change was made to the DT_REC_RTN_DSTRY_ELIG field or destruction date for the electronic case file.'
;
COMMENT ON TABLE CAPS.REFERRAL IS 'This table contains the information regarding __.'
;
COMMENT ON COLUMN CAPS.REFERRAL.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REFERRAL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REFERRAL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.REFERRAL.ADDR_REFER_CITY IS 'The city in which a home must be located in order for it to match to a child.'
;
COMMENT ON COLUMN CAPS.REFERRAL.CD_REFER_ADDR_SCH_DIST IS 'The school district that is selected to search for possible homes to place a child.'
;
COMMENT ON COLUMN CAPS.REFERRAL.CD_REFER_CATEGORY IS 'The home category that is needed to match the children to.'
;
COMMENT ON COLUMN CAPS.REFERRAL.CD_REFER_CNTY IS 'The abbreviated county code for the referral of a child for placement.'
;
COMMENT ON COLUMN CAPS.REFERRAL.CD_REFER_ETHNICITY IS 'The ethnicity of the home needed to match to the children.'
;
COMMENT ON COLUMN CAPS.REFERRAL.CD_REFER_FOSTER_TYPE IS 'The type of F/A Home. Only on table, not on window.'
;
COMMENT ON COLUMN CAPS.REFERRAL.CD_REFER_LANGUAGE IS 'The language the home must speak to match with the child.'
;
COMMENT ON COLUMN CAPS.REFERRAL.CD_REFER_REGION IS 'In order to match a child to the home, the home needs to be in this region.'
;
COMMENT ON COLUMN CAPS.REFERRAL.DT_REFER_EXPIRE IS 'The expiration date of the placement match referral.'
;
COMMENT ON COLUMN CAPS.REFERRAL.DT_REFER_HOME_NEEDED IS 'The date a home is needed for the child.'
;
COMMENT ON COLUMN CAPS.REFERRAL.DT_REFER_SEARCH_COMPLETE IS 'The date the search for homes to place the child(ren) in was completed.'
;
COMMENT ON COLUMN CAPS.REFERRAL.DT_REFER_SENT IS 'The date the referral was sent to the child worker.'
;
COMMENT ON COLUMN CAPS.REFERRAL.IND_REFER_CARE_PROV IS 'Indicates that the search for homes in which to place children includes homes that provide care in the home.'
;
COMMENT ON COLUMN CAPS.REFERRAL.IND_REFER_F_EMERG_PLACE IS 'This field is used to search for homes to place children that indicate that the home is willing to accept children for emergency placement.'
;
COMMENT ON COLUMN CAPS.REFERRAL.IND_REFER_SEARCH_DONE IS 'This indicator shows that a search for potential homes by a one-person office has been done.'
;
COMMENT ON COLUMN CAPS.REFERRAL.IND_REFER_F_TRANSPORT IS 'Indicates that when searching for homes in which to place children, the search includes F/A Homes that provide transportation for the F/A Child.'
;
COMMENT ON COLUMN CAPS.REFERRAL.NBR_REFER_FE_AGE_MAX IS 'The max age of a female child that is used in searching for a home to place children.'
;
COMMENT ON COLUMN CAPS.REFERRAL.NBR_REFER_FE_AGE_MIN IS 'The min age of a female foster child used in searching for a home to place children.'
;
COMMENT ON COLUMN CAPS.REFERRAL.NBR_REFER_MA_AGE_MAX IS 'The max age of a male child that is used to search for homes to place children.'
;
COMMENT ON COLUMN CAPS.REFERRAL.NBR_REFER_MA_AGE_MIN IS 'The min age of a male child that is used to search for a home to place children.'
;
COMMENT ON COLUMN CAPS.REFERRAL.NBR_REFER_OPEN_SLOTS IS 'The number of open slots in a F/A Home that is searched for when locating homes to place children.'
;
COMMENT ON TABLE CAPS.REFERRAL_CHRCTR IS 'Stores the referral characteristics.'
;
COMMENT ON COLUMN CAPS.REFERRAL_CHRCTR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REFERRAL_CHRCTR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REFERRAL_CHRCTR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.REFERRAL_CHRCTR.CD_REFER_CHAR_CHRCTR IS 'Contains a client characteristic that is used to locate a home for placing children.'
;
COMMENT ON TABLE CAPS.REFERRAL_HOME_LINK IS 'Stores possible resources/homes available for referral.'
;
COMMENT ON COLUMN CAPS.REFERRAL_HOME_LINK.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REFERRAL_HOME_LINK.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.REFERRAL_HOME_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REFERRAL_HOME_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.REFERRAL_NARR IS 'No description available.'
;
COMMENT ON COLUMN CAPS.REFERRAL_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REFERRAL_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.REFERRAL_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REFERRAL_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.REFERRAL_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.REFERRAL_PERSON_LINK IS 'Stores person information about children able to be associated with referral.'
;
COMMENT ON COLUMN CAPS.REFERRAL_PERSON_LINK.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REFERRAL_PERSON_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.REFERRAL_PERSON_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REFERRAL_PERSON_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.REFERRAL_PERSON_LINK.IND_REFER_PERS_REFERRED IS 'An indicator to indicate whether a person originally referred still exists on the Referral List for a Placement Match Referral'
;
COMMENT ON TABLE CAPS.REFRL_DOC_NARR IS 'Stores the narrative regarding the referral.'
;
COMMENT ON COLUMN CAPS.REFRL_DOC_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REFRL_DOC_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REFRL_DOC_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.REFRL_DOC_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the FAD Home study.'
;
COMMENT ON COLUMN CAPS.REFRL_DOC_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.REGION_COUNTY IS 'Table used to link regions with certain counties.'
;
COMMENT ON COLUMN CAPS.REGION_COUNTY.CD_REG_CNTY_REGION IS 'The regions in Georgia.'
;
COMMENT ON COLUMN CAPS.REGION_COUNTY.CD_REG_CNTY_COUNTY IS 'The counties in Georgia.'
;
COMMENT ON TABLE CAPS.REJECTION_REASON IS 'Table used to store all rejection reasons for a given payment line item.'
;
COMMENT ON COLUMN CAPS.REJECTION_REASON.ID_REJECTION_REASON IS 'A unique identifier for the Rejection Reason table.'
;
COMMENT ON COLUMN CAPS.REJECTION_REASON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REJECTION_REASON.ID_INVOICE IS 'A unique identifier for a row on the INVOICE table.'
;
COMMENT ON COLUMN CAPS.REJECTION_REASON.ID_REJECTED_ITEM_ID IS 'This element serves as a foreign key to four entities (Cost Reim, Service Dtl, Admin Dtl, Adjustment Dtl) depending on the code chosen.'
;
COMMENT ON COLUMN CAPS.REJECTION_REASON.CD_REJ_RSN IS 'Contains a code that indicates the reason a line item is rejected.'
;
COMMENT ON COLUMN CAPS.REJECTION_REASON.CD_REJ_RSN_REJ_ITEM_ID IS 'This is the Code for the type of Foreign Key (Rejected Items ID) for the Reject Reason table.'
;
COMMENT ON TABLE CAPS.RELATIONSHIP IS 'A table that depicts the relationship between two persons. i.e. John Doe is the father of Mary Doe.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RELATIONSHIP.ID_RELATIONSHIP IS 'A unique integer which defines a Relationship.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RELATIONSHIP.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RELATIONSHIP.ID_RELATED_PERSON IS 'A unique integer which identifies a Person related to another Person.'
;
COMMENT ON COLUMN CAPS.RELATIONSHIP.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.RELATIONSHIP.CD_PERSON_RELATIONSHIP IS 'For CPS a code indicating the relationship to the oldest victim involved in the case. For APS a code indicating the relationship of the AP to the client.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RELATIONSHIP.DT_RELATIONSHIP_START IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RELATIONSHIP.DT_RELATIONSHIP_END IS '* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON TABLE CAPS.RELATIVE_CARE_ASSMT IS 'Stores information related to a relative care assessment on a family for potential or ongoing relative placement of child.'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.ID_RCA_EVENT IS 'Event ID for the Relative Care Assessment'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.CD_ASSESSOR_TYPE IS 'Assessor type for RCA'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.CD_ASSMT_TYPE IS 'Assessment type for RCA (initial or review)'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.CD_STATE IS 'State of ICPC assessment'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.CD_COUNTY IS 'County of DFCS staff assessment'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.ID_RESOURCE IS 'CCFA resource performing assessment'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_REFERRAL IS 'Date of assessment referral'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_DUE IS 'Date assessment due'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_SCHED IS 'Date assessment due'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_ACTUAL IS 'Date of actual home visit'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_COMPLETE IS 'Date assessment completed'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_RECEIVED IS 'Date assessment received'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.CD_ASSMT_RESULTS IS 'Assessment Results'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_DECISION IS 'Date of assessment decision'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.IND_DISCUSSION IS 'Indicator of discussion of relative support options'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_DISCUSSION IS 'Date of discussion of relative support options'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.IND_ACCEPT IS 'Indicator that relative will support child'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.CD_SUPPORT IS 'Choice of support type'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_RD_REFRRAL IS 'Date of referral to resource development'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.DT_AGREE_SIGNED IS 'Date relative placement agreement signed'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.TXT_COMMENTS IS 'Comments on relative care assessment'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.CD_CAREGIVER_TYPE IS 'Caregiver type'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT.TXT_NON_RELATIVES IS 'For non-relatives record degree of relationship'
;
COMMENT ON TABLE CAPS.RELATIVE_CARE_ASSMT_PERSON IS 'Records persons in a home where a Relative Care Assessment takes place'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT_PERSON.ID_RCA_PERSON IS 'Unique identifier for RELATIVE_CARE_ASSMT_PERSON table
'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT_PERSON.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT_PERSON.ID_RCA_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT_PERSON.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.RELATIVE_CARE_ASSMT_PERSON.CD_PERSON_TYPE IS 'Person type for the RCA'
;
COMMENT ON TABLE CAPS.REMOVAL_CHAR_ADULT IS 'Stores characteristics assigned to the adult at the time of conservatorship removal.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_ADULT.ID_REMOVAL_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_ADULT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_ADULT.CD_REMOV_ADULT_CHAR IS 'The Caretaker''s characteristics which contributed to the removal of the child are listed here.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_ADULT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.REMOVAL_CHAR_CHILD IS 'Stores characteristics assigned to the child at the time of conservatorship removal.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_CHILD.ID_REMOVAL_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_CHILD.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_CHILD.CD_REMOV_CHILD_CHAR IS 'The characteristics of removal are listed here.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_CHILD.IND_CHAR_CHILD_CURRENT IS 'This indicates whether the characteristic is current or not.'
;
COMMENT ON COLUMN CAPS.REMOVAL_CHAR_CHILD.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.REMOVAL_REASON IS 'Stores the removal reasons of conservatorship removal.'
;
COMMENT ON COLUMN CAPS.REMOVAL_REASON.ID_REMOVAL_EVENT IS 'A unique identifier to the EVENT table. Stores the Id Event from the EVENT table for the event of removal.'
;
COMMENT ON COLUMN CAPS.REMOVAL_REASON.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REMOVAL_REASON.CD_REMOVAL_REASON IS 'The list of reasons for removal from the home are displayed in the list box.'
;
COMMENT ON COLUMN CAPS.REMOVAL_REASON.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.REPORT_LIST IS 'Reports and generated from windows and batch processes in IMPACT, they are displayed in the Report List window. This entity stores details about the report.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.ID_RPT_LIST IS 'A unique identifier for the Report List table.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.NM_RPT_SQR_NAME IS 'The name of the report''s SQR module. This and the Report SQR Version ID uniquely identify a report on the report list table and report parameter table.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.NM_RPT_SQR_VER IS 'SQR Report version.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.DT_RPT_LST_GENERATION IS 'Date of last report generation.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.DT_RPT_LST_RETAINAGE IS 'Report retainage date.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.NBR_RPT_LST_CFP_STAMP IS 'Stamp to associate a report with a case file during case file print.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.TXT_RPT_GEN_NAME IS 'The generated name of the report used on the Novell drive.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.TXT_RPT_LST_PARMLIST IS 'Parameter list sent by initial report request, saved for resubmit functionality.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.TXT_RPT_LST_RUNTIME_NAME IS 'Holds the runtime full description of the report.'
;
COMMENT ON COLUMN CAPS.REPORT_LIST.TXT_RPT_LST_STATUS IS 'Status field to track progress of a report, e.g.: run, done, err.'
;
COMMENT ON TABLE CAPS.REPORT_PARAMETER IS 'Used in the reporting architecture to store the input parameters for certain reports.'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.ID_RPT_PARAMETER IS 'A unique identifier for the Report Parameter table.'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.NM_RPT_SQR_NAME IS 'The name of the report''s SQR module. This and the Report SQR Version ID uniquely identify a report on the report list table and report parameter table.'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.NM_RPT_SQR_VER IS 'SQR Report version.'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.NBR_RPT_PARM_SEQ IS 'Parameter sequence.'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.NBR_RPT_PARM_LENGTH IS 'Parameter length'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.NM_RPT_PARM_NAME IS 'The name of a parameter within a report. The user is able to see by the name what functionality the parameter performs within the report. Examples: Date ; Worker; Unit; Region'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.TXT_RPT_PARM_TYPE IS 'Parameter type (CHAR, DATE, INTEGER, or NUMBER).'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.IND_REQUIRED IS 'Specifies whether or not this parameter is a required field.'
;
COMMENT ON COLUMN CAPS.REPORT_PARAMETER.NM_RPT_PARM_LABEL IS 'Report Label to display on screen'
;
COMMENT ON TABLE CAPS.REPORTS IS 'Stores a list of reports generated by the IMPACT application.'
;
COMMENT ON COLUMN CAPS.REPORTS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REPORTS.NM_RPT_SQR_NAME IS 'The name of the report''s SQR module. This and the Report SQR Version ID uniquely identify a report on the report list table and report parameter table.'
;
COMMENT ON COLUMN CAPS.REPORTS.NM_RPT_SQR_VER IS 'SQR Report version.'
;
COMMENT ON COLUMN CAPS.REPORTS.NBR_RPT_RETAINAGE IS 'Stores the number of days the report is displayed on the report list window.'
;
COMMENT ON COLUMN CAPS.REPORTS.NM_RPT_TYPE IS 'Type of report.  Types are: B-Batch Control; E-Batch Exception; M-Misc Batch Report; and O-On Demand Report.'
;
COMMENT ON COLUMN CAPS.REPORTS.TXT_RPT_FULL_NAME IS 'Full descriptive name of SQR report'
;
COMMENT ON COLUMN CAPS.REPORTS.NM_RPT_TEMPLATE_NAME IS 'Name of the template to be used to generate and display the report.'
;
COMMENT ON COLUMN CAPS.REPORTS.NM_RPT_ORIENTATION IS 'Stores whether the report should be displayed in landscape (L) or portrait (P) layout.'
;
COMMENT ON COLUMN CAPS.REPORTS.TXT_RPT_EMAIL_OPTIONS IS 'Stores the e-mail attach option: A-Attach; E-Embed. The default option is A-Attach.'
;
COMMENT ON COLUMN CAPS.REPORTS.NM_RPT_DESC IS 'Description of the report'
;
COMMENT ON COLUMN CAPS.REPORTS.NM_RPT_AREA_TYPE IS 'Area type for the report'
;
COMMENT ON COLUMN CAPS.REPORTS.IND_RPT_PAGE IS 'Indicator for Report Page'
;
COMMENT ON TABLE CAPS.RESOURCE_ADDRESS IS 'Addresses of all resources known to DFCS. Resources include Providers, Facilities, and Foster/Adoptive Homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.ID_RSRC_ADDRESS IS 'A unique identifier for a row on the RESOURCE ADDRESS table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.ADDR_RSRC_ADDR_ZIP IS 'Number zip code for the facility.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.CD_RSRC_ADDR_COUNTY IS 'A three digit numeric code that indicates the county in which the facility is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.ADDR_RSRC_ADDR_ATTN IS 'Contains the attention field for person addresses.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.CD_RSRC_ADDR_STATE IS 'A code that identifies the state in which the resource is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.ADDR_RSRC_ADDR_ST_LN_1 IS 'Address of the facility.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.ADDR_RSRC_ADDR_ST_LN_2 IS 'Address of the facility.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.CD_RSRC_ADDR_SCH_DIST IS 'The school district in which a resource is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.CD_RSRC_ADDR_TYPE IS 'This is the type of address for a resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.TXT_RSRC_ADDR_COMMENTS IS 'Comment field for Resource address records'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.NBR_RSRC_ADDR_VID IS 'The vendor identification number used by the state comptroller''s office to track payments from state agencies to vendors.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.ADDR_RSRC_ADDR_CITY IS 'The city of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.NBR_RSRC_ADDR_LAT IS 'Represents the latitude coordinate saved when an address is validated'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.NBR_RSRC_ADDR_LONG IS 'Represents the longitude coordinate saved when an address is validated'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.CD_RSRC_ADDR_SMILEUPD_ST IS 'Response received from SMILE Resource Update WS.'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.RESULT IS 'Result string from MapMarker MapInfo software used to geocode these addresses'
;
COMMENT ON COLUMN CAPS.RESOURCE_ADDRESS.CONFCODE IS 'Confirm code (Y/N) from MapMarker MapInfo software used to geocode these addresses'
;
COMMENT ON TABLE CAPS.RESOURCE_CHRCTR IS 'Conditions or restrictions which a resource may impose on the services it provides, i.e. no smokers, no sessions on monday etc.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.ID_RSRC_CHRCTR IS 'A unique identifier of the RESOURCE_CHRCTR table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.ID_RESOURCE_SERVICE IS 'The primary key on the Resource Service table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_CHRCTR IS 'A client characteristic that a resource specializes in accommodating.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_CATEG_RSRC IS 'A category or grouping of services that a resource can provide.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_CNTY IS 'A resource can provide services within this county.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_PROGRAM IS 'The DFCS program for which a resource provides a service.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_REGION IS 'The region for which a resource provides a service.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_SERVICE IS 'The service code of a service the resource provides.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_STATE IS 'The state for which a resource provides a service.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.DT_RSRC_CHAR_DT_ADDED IS 'The date that the characteristic was added to those that are selected'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.NBR_RSRC_CHAR_MIN_M_AGE IS 'The min age of a male child on the resource characteristics table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.NBR_RSRC_CHAR_MAX_M_AGE IS 'The max age of a male child on the Resource Characteristics table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.NBR_RSRC_CHAR_MIN_F_AGE IS 'The min age of a female child on the resource characteristics table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.NBR_RSRC_CHAR_MAX_F_AGE IS 'The max age of a female child on the Resource Characteristics table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_SEX IS 'The gender of the client that can receive the service.'
;
COMMENT ON COLUMN CAPS.RESOURCE_CHRCTR.CD_RSRC_CHAR_SERVICE_TYPE IS 'Stores the service type - G or F'
;
COMMENT ON TABLE CAPS.RESOURCE_HISTORY IS 'This table is the History of the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ID_RESOURCE_HISTORY IS 'Primary Key on the RESOURCE_HISTORY table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_RSHS_EFFECTIVE IS 'The start date for that resource history record. Only used for F/A homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_RSHS_CLOSE IS 'The date that a facility was closed (license cancelled).'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_RSHS_CERT IS 'The date that a facility was certified.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_RSHS_MARRIAGE IS 'The date of the marriage of the couple in the F/A Home'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_RSHS_END IS 'The end date for that resource history record. Only used for F/A homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ADDR_RSHS_ST_LN_1 IS 'Address of the facility.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ADDR_RSHS_ST_LN_2 IS 'Second line of Street address for the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ADDR_RSHS_CITY IS 'City of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_STATE IS 'City of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ADDR_RSHS_ZIP IS 'Numeric zip code for the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ADDR_RSHS_ATTN IS 'Contains the attention field for the primary resource address.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_CNTY IS 'The abbreviated county code for the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_INVOL_CLOSURE IS 'To determine if the closure of the home was involuntary. Used to capture the history of the home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_CLOSURE_RSN IS 'The reason for closing the F/A home/application. Recorded on the Resource History Table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_TYPE IS 'Type of resource. e.g. Provider'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_HUB IS 'Code which indicates the type of HUB vendor/resource this is'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_CAMPUS_TYPE IS 'When a resource is of type school, this field indicates the type of campus of the school.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_SOURCE_INQUIRY IS 'Contains how the inquirer found out about the F/A Home program.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_MAINTAINER IS 'The name of the region that is responsible for updating the resource record.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_SCH_DIST IS 'The school district in which a resource is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_OWNERSHIP IS 'The legal type of business that the resource represents.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_STATUS IS 'The operation or license status of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FACIL_TYPE IS 'The type of facility as defined by who licensed the facility, the number of clients it can accommodate, and the type of service it provides.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_CERT_BY IS 'Stores the code value of the types of certifying bodies for resources.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_OPER_BY IS 'An umbrella agency that operates a child resource that is listed separately in the resource directory.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_SETTING IS 'The physical setting in which the facility is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_PAYMENT IS 'The type of payment that the resource accepts for rendered services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_CATEGORY IS 'The category of F/A home (Foster, Adoptive, Foster/Adoptive, Legal Risk).'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_ETHNICITY IS 'The ethnicity of the F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_LANGUAGE IS 'The language spoken by the F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_MARITAL_STATUS IS 'The home''s marital status.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_RECMND_REOPEN IS 'Indicates whether the worker would allow the F/A Home should be reinstated after closure if applied again. Held on the Resource History Table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_REGION IS 'The region the F/A Home is located .'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_RELIGION IS 'The religion practiced in the F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_RESPITE IS 'Indicates whether a home accepts respite placements.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_STATUS IS 'The status of service of a F/A home (i.e. inquiry, recruit, applicant, participant)'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_TYPE1 IS 'This element indicates the home is a FA home, Type1.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_TYPE2 IS 'This element indicates the home is a FA home, Type2.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_TYPE3 IS 'This element indicates the home is a FA home, Type3.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_TYPE4 IS 'This element indicates the home is a FA home, Type4.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_TYPE5 IS 'This element indicates the home is a FA home, Type5.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_TYPE6 IS 'This element indicates the home is a FA home, Type6.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_FA_HOME_TYPE7 IS 'This element indicates the home is a FA home, Type7.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ID_RSHS_FA_HOME_STAGE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ID_RSHS_FA_HOME_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_RSHS_CARE_PROV IS 'Indicates that the home provides care in the home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_RSHS_INACTIVE IS 'Indicates that a home is inactive.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_RSHS_TRANSPORT IS 'Identifies resources that offer transportation to their services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_RSHS_EMERG_PLACE IS 'This field indicates that the home is willing to accept children for emergency placement. Disabled for adoptive homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NM_RSHS_RESOURCE IS 'The name of an entity which provides assistance or services to APS and/or CPS clients (e.g., Daycare Facility, Sheriff''s Department, Assessment Center, etc.).'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NM_RSHS_CONTACT IS 'The name of the individual that a DFCS employee calls to inquire about services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NM_RSHS_LAST_UPDATE IS 'The person who last updated the resource history record.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_VID IS 'The Vendor ID number for the F/A Home used for payment.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_PHN IS 'The phone number of the resource which is offering services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_FACIL_CAPACITY IS 'The maximum client capacity of a facility.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_FACIL_ACCLAIM IS 'The unique ACCLAIM identifier from the ACCLAIM interface that is stored on the resource record.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_PHONE_EXT IS 'The extension of the phone number listed.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_CAMPUS_NBR IS 'TEA system identifier for a given school.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_ANNUAL_INCOME IS 'The annual income of a F/A Family'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_FM_AGE_MAX IS 'The maximum age of a female child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_FM_AGE_MIN IS 'The minimum age of a female child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_MA_AGE_MAX IS 'The maximum age of a male child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_MA_AGE_MIN IS 'The minimum age of a male child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_INT_CHILDREN IS 'The max number of children an adoptive home wishes to adopt. Not on window, only for database history table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_INT_FE_AGE_MAX IS 'The max age of a female child that an adoptive home wishes to adopt. Not on window, only for database History table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_INT_FE_AGE_MIN IS 'The min age of a female child that an adoptive home wishes to adopt. Not on window, only for database History table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_INT_MA_AGE_MAX IS 'The max age of a male child the adoptive home wishes to adopt. Not on window, only for database history table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_INT_MA_AGE_MIN IS 'The min age of a male child the adoptive home wishes to adopt. Not on window, only for database History table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.TXT_RSHS_ADDR_CMNTS IS 'Comment field for Resource address records on the RESOURCE HISTORY table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.TXT_RSHS_COMMENTS IS 'Comment field for Resource address records on the RESOURCE HISTORY table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSHS_OPEN_SLOTS IS 'The number of open slots in a F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_RSHS_WRITE_AUDIT IS 'An indicator to signal if a row should be written to the RESOURCE_HISTORY_AUDIT table for an update or insert into the RESOURCE_HISTORY table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSHS_MHMR_COMP_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_CCL_UPDATE IS 'Date of child care licensing update'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_RSRC_MHMR_SITE IS 'Contains an MHMR code that distinguishes among sites within an MHMR facility provider.  This code is not associated with a codes table.  It is populated with data received from MHMR through a batch interface that runs weekly.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_RSRC_CONTRACTED IS 'Indicator if the resource has been contracted.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NM_LEGAL IS 'Legal name of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NM_RSRC_CONTACT_TITLE IS 'Contact person title'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NBR_RSRC_NTNL_PROVIDER IS 'National Provider Number'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ADDR_RSRC_EMAIL IS 'Email Address'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.ADDR_RSRC_WEBSITE IS 'Website URL'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_SCHOOL_TYPE IS 'Type of school'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_PAYMENT_DELIVERY IS 'Type of payment'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.TXT_SPEC_CERT IS 'Other Specialty/Certification'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_EXCHANGE_STAT IS 'AD Exchg. Status'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_WAIVER IS 'Waiver Exists'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_SCH_DIST IS 'School District'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_ELEM IS 'Elementary School'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_MIDDLE IS 'Middle School'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.CD_HIGH IS 'High School'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_FOST_MANUAL IS 'Foster Parent Manual Date'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_FOST_BILL IS 'Foster Parent Bill of Rights'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_SPECIFIC_CHILD IS 'Specific Child Indicated'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_LIC_BEGIN IS 'Approval Begin Date'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.DT_LIC_END IS 'Approval End Date'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.TXT_CLOSURE_COMM IS 'Closure Comments'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.NDFCS_CERT_ENTITY IS 'Name of the DFCS Entity that certified this resource'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_RSRC_NONDFCS IS 'Indicates whether the F/A Home is a Non-DFCS home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_CURR_HM_STDY_EXSTS IS 'Indicator if a current home study exists'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_PREV_FAM_STDY_RQSTD IS 'Represents the previous family study requested checkbox on home info page.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.RSRC_OTH_SPC_CERTF IS 'Other or Specialty Certification'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.IND_AFTER_HOURS IS 'New field representing the available after hours field on the PLACEMENT PROVIDER page'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY.TXT_HM_PRG_INTEREST IS 'Text field for HM Program Interest'
;
COMMENT ON TABLE CAPS.RESOURCE_HISTORY_AUDIT IS 'Audit table for the RESOURCE_HISTORY table. All elements are duplicated in this table.  (Contains no true primary or foreign key constraints.)'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ID_RESOURCE_HISTORY_AUD IS 'Primary Key for the RESOURCE_HISTORY_AUDIT table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ID_AUD_RESOURCE IS 'Foreign Key that references the CAPS_RESOURCE table (ID_RESOURCE).'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_RSHS_AUD_EFFECTIVE IS 'The start date for that resource history record. Only used for F/A homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_RSHS_AUD_CLOSE IS 'The date that a facility was closed (license canceled).'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_RSHS_AUD_CERT IS 'The date that a facility was certified.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_RSHS_AUD_MARRIAGE IS 'The date of the marriage of the couple in the F/A home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_RSHS_AUD_END IS 'The end date for that resource history record. Only used for F/A homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ADDR_RSHS_AUD_ST_LN_1 IS 'Address of the facility.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ADDR_RSHS_AUD_ST_LN_2 IS 'Second line of Street address for the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ADDR_RSHS_AUD_CITY IS 'City of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_STATE IS 'The abbreviated state code for the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ADDR_RSHS_AUD_ZIP IS 'Numeric zip code for the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ADDR_RSHS_AUD_ATTN IS 'Contains the attention field for the primary resource address.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_CNTY IS 'The abbreviated county code for the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_REC_REASON IS 'NEEDS A DESCRIPTION.  NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_INVOL_CLOSURE IS 'To determine if the closure of the home was involuntary. Used to capture the history of the home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_CLOSURE_RSN IS 'The reason for closing the F/A home/application. Recorded on the Resource History Table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_TYPE IS 'Type of resource. e.g. Provider'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_HUB IS 'Code which indicates the type of HUB vendor/resource.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_CAMPUS_TYPE IS 'When a resource is of type school, this field indicates the type of campus of the school.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_SOURCE_INQUIRY IS 'Contains how the inquire found out about the F/A Home program.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_MAINTAINER IS 'The name of the region that is responsible for updating the resource record. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_SCH_DIST IS 'The school district in which a resource is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_OWNERSHIP IS 'The legal type of business that the resource represents.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_STATUS IS 'The operation or license status of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FACIL_TYPE IS 'The type of facility as defined by who licensed the facility, the number of clients it can accommodate, and the type of service it provides.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_CERT_BY IS 'Stores the code value of the types of certifying bodies for resources.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_OPER_BY IS 'An umbrella agency that operates a child resource that is listed separately in the resource directory.NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_SETTING IS 'The physical setting in which the facility is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_PAYMENT IS 'The type of payment that the resource accepts for rendered services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_CATEGORY IS 'The category of F/A home (Foster, Adoptive, Foster/Adoptive, Legal Risk).'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_ETHNICITY IS 'The ethnicity of the F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_LANGUAGE IS 'The language spoken by the F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_MARITAL_STATUS IS 'The home''s marital status.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_RECMND_REOPEN IS 'Indicates whether the worker would allow the F/A Home should be reinstated after closure if applied again. Held on the Resource History Table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_REGION IS 'The region the F/A Home is located.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_RELIGION IS 'The religion practiced in the F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_RESPITE IS 'Indicates whether a home accepts respite placements.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_STATUS IS 'The status of service of a F/A home (i.e. inquiry, recruit, applicant, participant)'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_TYPE1 IS 'This element indicates the home is a FA home, Type1.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_TYPE2 IS 'This element indicates the home is a FA home, Type2.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_TYPE3 IS 'This element indicates the home is a FA home, Type3.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_TYPE4 IS 'This element indicates the home is a FA home, Type4.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_TYPE5 IS 'This element indicates the home is a FA home, Type5.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_TYPE6 IS 'This element indicates the home is a FA home, Type6.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_FA_HOME_TYPE7 IS 'This element indicates the home is a FA home, Type7.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ID_RSHS_AUD_FA_HOME_STAGE IS 'Foreign Key to the STAGE table. References the Id_Stage for the FA Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ID_RSHS_AUD_FA_HOME_EVENT IS 'Foreign Key to the EVENT table. References the Id_Event for the FA Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_RSHS_AUD_CARE_PROV IS 'Indicates that the home provides care in the home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_RSHS_AUD_INACTIVE IS 'Indicates that a home is inactive.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_RSHS_AUD_TRANSPORT IS 'Identifies resources that offer transportation to their services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_RSHS_AUD_EMERG_PLACE IS 'This field indicates that the home is willing to accept children for emergency placement. Disabled for adoptive homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NM_RSHS_AUD_RESOURCE IS 'The name of an entity which provides assistance or services to APS and/or CPS clients (e.g., Daycare Facility, Sheriff''s Department, Assessment Center, etc.).'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NM_RSHS_AUD_CONTACT IS 'The name of the individual that a DFCS employee calls to inquire about services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NM_RSHS_AUD_LAST_UPDATE IS 'The person who last updated the resource history record.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_VID IS 'The Vendor ID number for the F/A Home used for payment.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_PHN IS 'The phone number of the resource which is offering services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_FACIL_CAPACITY IS 'The maximum client capacity of a facility.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_FACIL_ACCLAIM IS 'The unique ACCLAIM identifier from the ACCLAIM interface that is stored on the resource record.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_PHONE_EXT IS 'The extension of the phone number listed.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_CAMPUS_NBR IS 'TEA system identifier for a given school.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_ANNUAL_INCOME IS 'The annual income of a F/A Family.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_FM_AGE_MAX IS 'The maximum age of a female child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_FM_AGE_MIN IS 'The minimum age of a female child the FA Home is licensed for.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_MA_AGE_MAX IS 'The max age of a male child the adoptive home wishes to adopt. Not on window, only for database history table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_MA_AGE_MIN IS 'The min age of a male child the adoptive home wishes to adopt. Not on window, only for database History table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_INT_CHILDREN IS 'The max number of children an adoptive home wishes to adopt. Not on window, only for database history table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_INT_FE_AGE_MAX IS 'The max age of a female child that an adoptive home wishes to adopt. Not on window, only for database History table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_INT_FE_AGE_MIN IS 'The min age of a female child that an adoptive home wishes to adopt. Not on window, only for database History table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_INT_MA_AGE_MAX IS 'The max age of a male child the adoptive home wishes to adopt. Not on window, only for database history table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_INT_MA_AGE_MIN IS 'The min age of a male child the adoptive home wishes to adopt. Not on window, only for database History table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSHS_AUD_OPEN_SLOTS IS 'The number of open slots in a F/A Home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.TXT_RSHS_AUD_ADDR_CMNTS IS 'Comment field for Resource address records on the RESOURCE_HISTORY table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.TXT_RSHS_AUD_COMMENTS IS 'Comment field for a resource record.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_RSHS_AUD_WRITE_AUDIT IS 'Not Used.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSHS_AUD_MHMR_COMP_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_CCL_UPDATE IS 'Date of child care licensing update'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_RSRC_MHMR_SITE IS 'Contains an MHMR code that distinguishes among sites within an MHMR facility provider.  This code is not associated with a codes table.  It is populated with data received from MHMR through a batch interface that runs weekly.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_RSRC_CONTRACTED IS 'Indicator if the resource has been contracted.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NM_LEGAL IS 'Legal Name of the resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NM_RSRC_CONTACT_TITLE IS 'Contact person title'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NBR_RSRC_NTNL_PROVIDER IS 'National Provider number'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ADDR_RSRC_EMAIL IS 'Email Address'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ADDR_RSRC_WEBSITE IS 'Website URL'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_SCHOOL_TYPE IS 'Type of school'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_PAYMENT_DELIVERY IS 'Type of payment'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.TXT_SPEC_CERT IS 'Other Specialty/Certification'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_EXCHANGE_STAT IS 'AD Exchg. Status'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_WAIVER IS 'Waiver Exists'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_SCH_DIST IS 'School District'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_ELEM IS 'Elementary School'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_MIDDLE IS 'Middle School'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.CD_HIGH IS 'High School'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_FOST_MANUAL IS 'Foster Parent Manual Date'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_FOST_BILL IS 'Foster Parent Bill of Rights'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_SPECIFIC_CHILD IS 'Specific Children Identified'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_LIC_BEGIN IS 'Approval Begin Date'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.DT_LIC_END IS 'Approval End Date'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.TXT_CLOSURE_COMM IS 'Closure Comments'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.NDFCS_CERT_ENTITY IS 'Name of the DFCS Entity that certified this resource'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_RSRC_NONDFCS IS 'Indicates whether the F/A Home is a Non-DFCS home.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_CURR_HM_STDY_EXSTS IS 'Indicator if a current home study exists'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_PREV_FAM_STDY_RQSTD IS 'Represents the previous family study requested checkbox on home info page.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.RSRC_OTH_SPC_CERTF IS 'Other or Specialty Certification'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.ID_RESOURCE_HISTORY_AUDIT IS 'Single, artificial unique key for the RESOURCE_HISTORY AUDIT table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.IND_AFTER_HOURS IS 'New field representing the available after hours field on the PLACEMENT PROVIDER page'
;
COMMENT ON COLUMN CAPS.RESOURCE_HISTORY_AUDIT.TXT_HM_PRG_INTEREST IS 'Text field for HM Program Interest'
;
COMMENT ON TABLE CAPS.RESOURCE_PHONE IS 'Phone numbers of all resources known to DFCS. Resources include Providers, Facilities, and Foster/Adoptive Homes.'
;
COMMENT ON COLUMN CAPS.RESOURCE_PHONE.ID_RSRC_PHONE IS 'A unique identifier to the Resource phone table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_PHONE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RESOURCE_PHONE.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_PHONE.NBR_RSRC_PHONE IS 'The phone number of the resource which is offering services.'
;
COMMENT ON COLUMN CAPS.RESOURCE_PHONE.NBR_RSRC_PHONE_EXT IS 'The extension of the phone number listed.'
;
COMMENT ON COLUMN CAPS.RESOURCE_PHONE.TXT_RSRC_PHONE_COMMENTS IS 'Comments made for a resource''s phone number.'
;
COMMENT ON COLUMN CAPS.RESOURCE_PHONE.CD_RSRC_PHONE_TYPE IS 'A code which identifies the type of phone number provided (home, work, beeper)'
;
COMMENT ON TABLE CAPS.RESOURCE_SERVICE IS 'Stores service by area information for a given resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.ID_RESOURCE_SERVICE IS 'Stores service by area information for a given resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.DT_LAST_UPDATE IS 'Stores service by area information for a given resource.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.IND_RSRC_SVC_SHOW_ROW IS 'Indicates that a row needs to be displayed on the Area Served window list box.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.IND_RSRC_SVC_INCOME_BSED IS 'Describes whether a service is income based.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.CD_RSRC_SVC_CATEG_RSRC IS 'A category or grouping of services that a resource can provide.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.CD_RSRC_SVC_CNTY IS 'A resource can provide services within this county.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.CD_RSRC_SVC_PROGRAM IS 'The DFCS program for which a resource provides a service.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.CD_RSRC_SVC_REGION IS 'The region for which a resource provides a service.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.CD_RSRC_SVC_SERVICE IS 'The service code of a service the resource provides.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.CD_RSRC_SVC_STATE IS 'The state for which a resource provides a service.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.IND_RSRC_SVC_CNTY_PARTIAL IS 'Indicates that a service provided by a resource does not serve an entire county.'
;
COMMENT ON COLUMN CAPS.RESOURCE_SERVICE.CD_RSRC_SVC_SERVICE_TYPE IS 'Stores the service type - G or F'
;
COMMENT ON TABLE CAPS.RESTRICTED_FUNDS IS 'Holds Data from the Restricted Funds Data'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.AMT_CHECK_BAL IS 'Checking Balance'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.AMT_SAV_BAL IS 'Savings Balance'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.AMT_RES IS 'Amount Reserved'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.TXT_RES IS 'Reserved Person'
;
COMMENT ON COLUMN CAPS.RESTRICTED_FUNDS.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON TABLE CAPS.REVERIF_NARR IS 'The Narrative Table for the Re-verification of F/A Homes.'
;
COMMENT ON COLUMN CAPS.REVERIF_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.REVERIF_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.REVERIF_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.REVERIF_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the re-verification.'
;
COMMENT ON COLUMN CAPS.REVERIF_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.REVOLVING_DATE IS 'Changes the sysdate of a particular program.'
;
COMMENT ON COLUMN CAPS.REVOLVING_DATE.DT_FIXED IS 'The date to be read in by the batch program.'
;
COMMENT ON COLUMN CAPS.REVOLVING_DATE.DT_CREATED IS 'The date the row was created.'
;
COMMENT ON TABLE CAPS.RISK_AREA IS 'Contains data related to the area of risk found during a risk assessment.  Areas are used to group categories of abuse and neglect.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.ID_RISK_AREA IS 'Contains a unique identifier for a row on the RISK AREA table.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.CD_RISK_AREA IS 'Contains a code indicating the area of risk assessed during investigation.  Areas are used to group categories of abuse and neglect.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.CD_RISK_AREA_CONCERN_SCALE IS 'Contains a code indicating the workers assessment of the level (or scale) of concern regarding the area.'
;
COMMENT ON COLUMN CAPS.RISK_AREA.TXT_RISK_AREA_JUSTIFICATION IS 'Risk Area Justification text'
;
COMMENT ON TABLE CAPS.RISK_AREA_LOOKUP IS 'Same as RISK_AREA, except it contains a column for sort-order.'
;
COMMENT ON COLUMN CAPS.RISK_AREA_LOOKUP.CD_AREA IS 'Contains a code indicating the area of risk assessed during investigation.  Areas are used to group categories of abuse and neglect.'
;
COMMENT ON COLUMN CAPS.RISK_AREA_LOOKUP.TXT_AREA IS 'Text for the area of risk found during a risk assessment.  Areas are used to group categories of abuse and neglect.'
;
COMMENT ON COLUMN CAPS.RISK_AREA_LOOKUP.NBR_AREA_ORDER IS 'Index indicating the order in which the area of concern should appear on the page.'
;
COMMENT ON COLUMN CAPS.RISK_AREA_LOOKUP.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.RISK_ASSESSMENT IS 'An assessment performed during a CPS Investigation to determine whether a child(ren) is at risk of abuse or neglect.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.CD_RISK_ASSMT_PURPOSE IS 'The reason that a risk assessment is being recorded. e.g. Removal, investigation.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.CD_RISK_ASSMT_RISK_FIND IS 'Contains type of Risk Finding. Enables the appropriate Recommended Actions checkboxes.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.IND_RISK_ASSMT_AP_ACCESS IS 'Code (misnamed as an indicator) filled when recording Risk Assessment. Indicates whether the Alleged Perpetrator has access to the victim.  The values are 0 (Yes), 1 (No) and 2 (Unknown).'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.NBR_RISK_ASSMT_CALC IS 'Contains the numeric result of mathematical formulas that use intake factors, intake descriptors and risk assessment factors to indicate risk.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.NBR_RISK_ASSMT_SEVERITY IS 'Contains the severity index computed from weighted intake factors and descriptors to indicate risk.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.IND_RISK_ASSMT_INTRANET IS 'Indicates whether or not the Risk Assessment was done prior to IRA, with IRA, or post IRA in IMPACT. The column will contain ''N'' for risk assessments created prior to IRA, ''Y'' for risk assessments created with IRA, and ''M'' for risk assessments created in IMPACT.'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.DT_RESPONSE IS 'Date and Time of Response'
;
COMMENT ON COLUMN CAPS.RISK_ASSESSMENT.IND_RISK_ASSMT_RESPONSE IS 'Indicator for Risk Assessment Response'
;
COMMENT ON TABLE CAPS.RISK_ASSMT_FMLY_STR IS 'Risk Assessment Family Strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.IND_RISK_AFS_CHILDVUL IS 'Indicator if Child Vulnerability is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_CHILDPROCTN IS 'indicator if child protection is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_CHILDBHVR IS 'indicator if child behavior is a family strength
'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.IND_RISK_AFS_CAREGIVCAP IS 'indicator if caregiver capability is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_KNOWLEDGE IS 'indicator if knowledge  is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_CONTROL IS 'indicator if control is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_FUNCTNG IS 'indicator if functioning is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.IND_RISK_AFS_QUALOFCARE IS 'indicator if quality of care is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_EMOCARE IS 'indicator if emotional care is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_PHYCARE IS 'indicator if physical care is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.IND_RISK_AFS_MALPATRN IS 'indicator if maltreatment pattern is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_CURSEVRTY IS 'indicator if current severity is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_CHRONCTY IS 'indicator if chonicity is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_TREND IS 'indicator if trend is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.IND_RISK_AFS_HOMENV IS 'indicator if home environment is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_STRESS IS 'indicator if stress is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_DANEXP IS 'indicator if dangerous exposure is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.IND_RISK_AFS_SOCENV IS 'indicator if social environment is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_SOCCLI IS 'indicator if social climate is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_SOCVIOL IS 'indicator if social violence is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.IND_RISK_AFS_RESPINT IS 'indicator if response to intervention is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_ATTITUDE IS 'indicator if attitude is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.CB_RISK_AFS_DECEPTION IS 'indicator if deception is a family strength'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_FMLY_STR.TXT_RISK_AFS_SUMMARY IS 'Summary of family strengths'
;
COMMENT ON TABLE CAPS.RISK_ASSMT_IRA_NARR IS 'Stores the Risk Assessment Narratives.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_IRA_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_IRA_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_IRA_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_IRA_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_IRA_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.RISK_ASSMT_NARR IS 'Blob table used to store the Risk Assessment Analysis document recorded when the Risk Assessment window is filled out.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative detailing the Risk Assessment analysis.'
;
COMMENT ON COLUMN CAPS.RISK_ASSMT_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.RISK_CATEGORY IS 'Contains data related to the categories of risk found during a risk assessment.  Categories are used to group factors of abuse and neglect.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.ID_RISK_CATEGORY IS 'Contains a unique identifier for a row on the RISK CATEGORY table.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.ID_RISK_CATEG_AREA IS 'Contains a unique identifier for a row on the RISK AREA table.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.CD_RISK_CATEG IS 'Contains a code indicating the Risk Assessment Category.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.CD_RISK_CATEG_CONCERN_SCALE IS 'Contains a code indicating the workers assessment of the level (or scale) of concern regarding the category.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY.TXT_RISK_CATEG_JUSTIFICATION IS 'Risk Category Justification Text'
;
COMMENT ON TABLE CAPS.RISK_CATEGORY_LOOKUP IS 'Same as RISK_CATEGORY, except it contains a column for sort-order. Links to RISK AREA LOOKUP.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY_LOOKUP.CD_CATEGORY IS 'The code for the Area of Concern category.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY_LOOKUP.TXT_CATEGORY IS 'The text name/description of the category.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY_LOOKUP.NBR_CATEGORY_ORDER IS 'Index indicating the order in which the category should appear on the page.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY_LOOKUP.CD_AREA IS 'Contains a code indicating the area of risk assessed during investigation.  Areas are used to group categories of abuse and neglect.'
;
COMMENT ON COLUMN CAPS.RISK_CATEGORY_LOOKUP.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.RISK_FACTORS IS 'Factors associated with a CPS Risk Assessment that characterize risk of abuse and neglect risk.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.ID_RISK_FACTOR IS 'A unique integer which defines a Risk Factor.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.CD_RISK_FACTOR IS 'A code that indicates the risk factor is for each principal involved in the investigation.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.CD_RISK_FACTOR_RESPONSE IS 'Response to Risk Assessment factors. Valid responses are: Yes, No, and Unknown.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.CD_RISK_FACTOR_CATEG IS 'Contains factors as they relate to principals. This drop-down list box is only valid when principal is selected as the principal type.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.TXT_RISK_FACTOR_COMMENT IS 'Comments about risk factors.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.ID_RISK_FACTOR_AREA IS 'Contains a unique identifier for a row on the RISK AREA table.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS.ID_RISK_FACTOR_CATEG IS 'Contains a unique identifier for a row on the RISK CATEGORY table.'
;
COMMENT ON TABLE CAPS.RISK_FACTORS_LOOKUP IS 'Same as RISK_FACTORS, except it contains a column for sort-order.  Links to RISK CATEGORY LOOKUP.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS_LOOKUP.CD_FACTOR IS 'The code for the area of concern factor.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS_LOOKUP.TXT_FACTOR IS 'The text name/description of the factor.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS_LOOKUP.NBR_FACTOR_ORDER IS 'Index indicating the order in which the factor should appear on the page.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS_LOOKUP.CD_CATEGORY IS 'The code for the Area of Concern category.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS_LOOKUP.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS_LOOKUP.TXT_FACTOR_DETAIL IS 'The long description of this area of concern factor.'
;
COMMENT ON COLUMN CAPS.RISK_FACTORS_LOOKUP.AREA_CONCERN_TXT IS 'Area of Concern Description for the Risk Factor'
;
COMMENT ON TABLE CAPS.RISK_HISTORY_REPORT IS 'Contains history of risk assessment reports'
;
COMMENT ON COLUMN CAPS.RISK_HISTORY_REPORT.ID_RISK_HISTORY_REPORT IS 'ID for Risk History Report Table'
;
COMMENT ON COLUMN CAPS.RISK_HISTORY_REPORT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_HISTORY_REPORT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.RISK_HISTORY_REPORT.DT_REPORT IS 'Date of Report'
;
COMMENT ON COLUMN CAPS.RISK_HISTORY_REPORT.DT_CLOSURE IS 'Date of Closure'
;
COMMENT ON TABLE CAPS.RISK_INV_ACTIONS IS 'Risk Investigation Actions'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.IND_RISK_IA_PARENTSGUIDE IS 'Indicator if parent''s guide was given'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.DT_PARENTSGUIDE IS 'Date parent''s guide was given'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.IND_RISK_IA_PARENTSINTERV IS 'Indicator if parents were notified of interview
'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.DT_PARENTSINTERV IS 'Date parents were notified of interview'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.IND_RISK_IA_HIPPAINFO IS 'indicator if HIPPA information was given'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.IND_RISK_IA_HIPPASIGN IS 'Indicator if HIPPA agreement was signed'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.DT_HIPPASIGN IS 'Date HIPPA agreement was signed'
;
COMMENT ON COLUMN CAPS.RISK_INV_ACTIONS.TXT_RISK_IA_COMMENTS IS 'Comments on investigative actions'
;
COMMENT ON TABLE CAPS.ROLLOUT_DATE IS 'Static table that lists the code release dates'
;
COMMENT ON COLUMN CAPS.ROLLOUT_DATE.RELEASE_DATE IS 'Date of code release'
;
COMMENT ON TABLE CAPS.RSRC_LINK IS 'Stores the links between parent facilities and available foster adoptive homes.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK.ID_RSRC_LINK IS 'Uniquely identifies a row on the RSRC LNK table.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK.ID_RSRC_LINK_PARENT IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK.ID_RSRC_LINK_CHILD IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK.CD_RSRC_LINK_SERVICE IS 'The service that a subcontracted resource provides for a prime resource.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK.CD_RSRC_LINK_TYPE IS 'This data element, stored on the RSRC LNK table, indicated what type of RSRC LNK exists relative to the resource.'
;
COMMENT ON TABLE CAPS.RSRC_LINK_HISTORY IS 'audit table for rsrc_link'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.ID_RSRC_LINK_HISTORY IS 'Audit of id_rsrc_link'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.ID_RSRC_LINK IS 'Uniquely identifies a row on the RSRC LNK table.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.ID_RSRC_LINK_PARENT IS 'This element identifies the parent resource involved in the parent/child resource relationship.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.ID_RSRC_LINK_CHILD IS 'This element identifies the child resource in the parent/child resource relationship.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.CD_RSRC_LINK_SERVICE IS 'The service that a subcontracted resource provides for a prime resource.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.CD_RSRC_LINK_TYPE IS 'This data element, stored on the RSRC LNK table, indicated what type of RSRC LNK exists relative to the resource.'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.DT_RSRC_LINK_EFFECTIVE IS 'audit of dt_rsrc_link_effective'
;
COMMENT ON COLUMN CAPS.RSRC_LINK_HISTORY.DML_TYPE IS 'audit of dml_type'
;
COMMENT ON TABLE CAPS.SA_DRUG_EXPOSED_NEWBORNS IS 'Captures drug exposed newborn information for the safety assessement'
;
COMMENT ON COLUMN CAPS.SA_DRUG_EXPOSED_NEWBORNS.ID_SA_DRUG_EXPOSED_NEWBORNS IS 'Primary key - ID for SA Drug Exposed Newborn record'
;
COMMENT ON COLUMN CAPS.SA_DRUG_EXPOSED_NEWBORNS.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SA_DRUG_EXPOSED_NEWBORNS.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SA_DRUG_EXPOSED_NEWBORNS.CD_DRUG_EXP_NB IS 'Drug exposed newborn question'
;
COMMENT ON COLUMN CAPS.SA_DRUG_EXPOSED_NEWBORNS.CD_DRUG_EXP_NB_RPS IS 'Drug exposed newborn reponse'
;
COMMENT ON TABLE CAPS.SA_REASONABLE_EFFORTS IS 'Captures reasonable efforts checklist for the safety assessment'
;
COMMENT ON COLUMN CAPS.SA_REASONABLE_EFFORTS.ID_SA_REASONABLE_EFFORTS IS 'Primary key - ID of SA Reasonable Efforts Record'
;
COMMENT ON COLUMN CAPS.SA_REASONABLE_EFFORTS.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SA_REASONABLE_EFFORTS.ID_PERSON_CHILD IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SA_REASONABLE_EFFORTS.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SA_REASONABLE_EFFORTS.CD_RSB_EFFORTS IS 'Reasonable effort'
;
COMMENT ON COLUMN CAPS.SA_REASONABLE_EFFORTS.CD_RSB_EFFORTS_RPS IS 'reasonsable effort response'
;
COMMENT ON COLUMN CAPS.SA_REASONABLE_EFFORTS.TXT_COMMENTS IS 'Comments about reasonable efforts'
;
COMMENT ON TABLE CAPS.SA_SAFETY_ASSESSMENT IS 'Safety Assessment data'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_ASSESSMENT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_ASSESSMENT.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_ASSESSMENT.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_ASSESSMENT.CD_OV_SF_DECISION IS 'Overall safety decision'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_ASSESSMENT.TXT_WY_RPS IS 'Comments on safety assessment'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_ASSESSMENT.OTHER_SAFETY_FACTOR IS 'Holds the description for the Other type of safety factor'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_ASSESSMENT.TXT_ADDTNL_COMMENTS IS 'Additional comments about the safety factors'
;
COMMENT ON TABLE CAPS.SA_SAFETY_FACTOR IS 'Captures safety factor and caretaker child relationship'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_FACTOR.ID_SA_SAFETY_FACTOR IS 'Primary key - ID of SA Safety Factor Record'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_FACTOR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_FACTOR.ID_PERSON_CARETAKER IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_FACTOR.ID_PERSON_CHILD IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_FACTOR.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_FACTOR.CD_SF_FACTOR IS 'Safety factor'
;
COMMENT ON COLUMN CAPS.SA_SAFETY_FACTOR.CD_SF_FACTOR_RPS IS 'safety factor response'
;
COMMENT ON TABLE CAPS.SACWIS_AUDIT IS 'SACWIS Audit table tracks the execution of certain commands'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.ID_SACWIS_AUDIT IS 'Primary key for SACWIS AUDIT table'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.DT_USER_ACTION IS 'Date of user action'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.ID_PERSON IS 'ID of the person involved in this transaction.'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.TXT_IP_ADDRESS IS 'Source IP Address of the user in the transaction'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.ID_COMMAND IS 'Identifier from SACWIS Command table'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.NBR_MESSAGE IS 'Message id association with this audit record'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.ID_CASE IS 'Case ID asssociated with this command.'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.ID_STAGE IS 'ID of the Stage associated with this audit record'
;
COMMENT ON COLUMN CAPS.SACWIS_AUDIT.ID_EVENT IS 'ID of the Stage associated with this event'
;
COMMENT ON TABLE CAPS.SACWIS_COMMAND IS 'Used for on demand  application tracing only'
;
COMMENT ON COLUMN CAPS.SACWIS_COMMAND.ID_COMMAND IS 'Primary key - id of the impact command record.'
;
COMMENT ON COLUMN CAPS.SACWIS_COMMAND.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SACWIS_COMMAND.NM_SERVLET IS 'Servlet name.'
;
COMMENT ON COLUMN CAPS.SACWIS_COMMAND.NM_CONVERSATION IS 'Conversation name.'
;
COMMENT ON COLUMN CAPS.SACWIS_COMMAND.NM_COMMAND IS 'command name.'
;
COMMENT ON COLUMN CAPS.SACWIS_COMMAND.NM_BRANCH IS 'branch name.'
;
COMMENT ON TABLE CAPS.SAFETY_RESOURCE IS 'Table tracks safety resources before DFCS takes custody'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE.ID_PRIMARY IS 'Primary Safety Resource. This is a required Person.'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE.ID_SECONDARY IS 'Secondary Person Safety Resource. Optional.'
;
COMMENT ON TABLE CAPS.SAFETY_RESOURCE_CHILD IS 'Table tracks children under in safety resource care before DFCS takes custody'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_CHILD.ID_SR_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_CHILD.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_CHILD.ID_CHILD IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_CHILD.DT_START IS 'Start Date'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_CHILD.DT_END IS 'End Date'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_CHILD.CD_REL_PRIMARY IS 'Code for Primary Relation'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_CHILD.CD_REL_SECONDARY IS 'Optional code for Secondary Relation'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_NARR.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_NARR.NARRATIVE IS 'Narrative BLOB field for Safety Resource'
;
COMMENT ON COLUMN CAPS.SAFETY_RESOURCE_NARR.ID_DOCUMENT_TEMPLATE IS 'ID of the Document Template that contains the format information for this form.'
;
COMMENT ON TABLE CAPS.SAFETY_RSRC_ASMNT_NARR IS 'This table will store the Safety Resource Assessment form. '
;
COMMENT ON COLUMN CAPS.SAFETY_RSRC_ASMNT_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SAFETY_RSRC_ASMNT_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SAFETY_RSRC_ASMNT_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SAFETY_RSRC_ASMNT_NARR.NARRATIVE IS 'Holds all data entered onto the form as a blob.'
;
COMMENT ON COLUMN CAPS.SAFETY_RSRC_ASMNT_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.SCH_DIST IS 'School District by county static table.'
;
COMMENT ON COLUMN CAPS.SCH_DIST.CD_SCH_DIST IS 'School district code for the District - County codes table.'
;
COMMENT ON COLUMN CAPS.SCH_DIST.TXT_SCH_DIST_NAME IS 'School district name decode for the school district codes table.'
;
COMMENT ON COLUMN CAPS.SCH_DIST.CD_SCH_DIST_TX_COUNTY IS 'County corresponding to a school district.'
;
COMMENT ON TABLE CAPS.SCHEMA_VERSION IS 'This table tracks schema updates. All database scripts that change the schema or modify static contact will insert a record into this table.'
;
COMMENT ON COLUMN CAPS.SCHEMA_VERSION.ID_SCHEMA_VERSION IS 'Unique ID for the schema version. This id is not automatically generated - the script that contains the database changes will supply this value.'
;
COMMENT ON COLUMN CAPS.SCHEMA_VERSION.APPLICATION_VERSION IS 'Version of the application at the time of this schema change.'
;
COMMENT ON COLUMN CAPS.SCHEMA_VERSION.COMMENTS IS 'Comments about the schema change.'
;
COMMENT ON COLUMN CAPS.SCHEMA_VERSION.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON TABLE CAPS.SECURITY_CLASS IS 'Security classes established for IMPACT. Each security class has security attributes that enable the user to perform certain functions in the application.'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS.CD_SECURITY_CLASS_NAME IS 'Stores the name of the security class. Also is used to uniquely identify each row. Mislabeled as a code. There is no associated codes table with this data element.'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS.TXT_SECURITY_CLASS_PROFIL IS 'Field containing an employee''s security profile. Each position in TxtSecurityAttribute corresponds to a specific permission.'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS.IND_RESTRICT IS 'If that class is restricted'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS.ID_PERSON_MODIFIED_BY IS 'Id of Employee who last modified this record'
;
COMMENT ON TABLE CAPS.SECURITY_CLASS_AUDIT IS 'Audit table for Security Class table'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS_AUDIT.ID_SECURITY_CLASS_AUDIT IS 'Unique key for the SECURITY_CLASS_AUDIT table'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS_AUDIT.CD_SECURITY_CLASS_NAME IS 'Stores the name of the security class. Also is used to uniquely identify each row. Mislabeled as a code. There is no associated codes table with this data element.'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS_AUDIT.TXT_SECURITY_CLASS_PROFIL IS 'Field containing an employee''s security profile. Each position in TxtSecurityAttribute corresponds to a specific permission.'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS_AUDIT.IND_RESTRICT IS 'If that class is restricted'
;
COMMENT ON COLUMN CAPS.SECURITY_CLASS_AUDIT.ID_PERSON_MODIFIED_BY IS 'Id of Employee who last modified this record'
;
COMMENT ON TABLE CAPS.SER_INC_NARR IS 'Stores narrative regarding the serious incident.'
;
COMMENT ON COLUMN CAPS.SER_INC_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SER_INC_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SER_INC_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SER_INC_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Serious Incident.'
;
COMMENT ON COLUMN CAPS.SER_INC_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.SERVICE_AUTH_AUDIT IS 'This table audits the SERVICE AUTHORIZATION table and duplicates all the elements in that table.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.ID_SVC_AUTH_AUD IS 'Primary Key for the SERVICE_AUTH_AUDIT table.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.CD_SVC_AUTH_AUD_COUNTY IS 'The county in which the authorized service is provided.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.ID_AUD_RESOURCE IS 'Foreign Key that references the CAPS_RESOURCE table (ID_RESOURCE).'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.ID_AUD_CONTRACT IS 'Unique identifier for a row on the CONTRACT table.  (Corresponds to ID CONTRACT.)'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.ID_AUD_PRIMARY_CLIENT IS 'Foreign Key to the PERSON table. Stores the id_person for the primary client.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.ID_AUD_PERSON IS 'A unique identifier for a row on the Person table.  When entered, this appears to be an MD associated with the APS Case.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.CD_SVC_AUT_AUD_ABIL_TO_RESPOND IS 'Used to indicate whether the client is unable to respond, speaks English, Spanish or Other. Defaults to English.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.CD_SVC_AUTH_AUD_CATEGORY IS 'Contains the category used during a service authorization search.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.CD_SVC_AUTH_AUD_REGION IS 'Contains the region used during a service authorization search.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.CD_SVC_AUTH_AUD_SERVICE IS 'Contains the service used during a service authorization search.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.DT_SVC_AUTH_AUD_VERBAL_REFERL IS 'The date that the worker verbally referred the case for services.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.DT_SVC_AUTH_AUD_EFF IS 'The Effective Date of the Service Authorization used to identify the proper contracted resource and contract version.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.IND_SVC_AUTH_AUD_COMPLETE IS 'Indicates whether the service authorization is complete and can be submitted for approval, create and event, and initiate alert generation.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.TXT_SVC_AUTH_AUD_COMMENTS IS 'Comments recorded at the time of a client''s service authorization.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.TXT_SVC_AUTH_AUD_DIR_TO_HOME IS 'The worker is able to specify the directions to the home of the client.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.TXT_SVC_AUTH_AUD_HOME_ENVIRON IS 'Enables the worker to comment on additional factors that impact Service Delivery. The worker uses the field to describe pertinent client factors to the service provider such as condition of the home.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.TXT_SVC_AUTH_AUD_MED_COND IS 'This allows the worker to enter information dealing with physical, mental and/or medical conditions which cause functional limitations.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTH_AUDIT.TXT_SVC_AUTH_AUD_SEC_PROVDR IS 'Subcontracted or other service providers. Informational field only with no validation.'
;
COMMENT ON TABLE CAPS.SERVICE_AUTHORIZATION IS 'An authorization to a Provider to deliver a specific service to a DFCS principal. A person must be a principal to be authorized to receive services.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.ID_SVC_AUTH IS 'The unique key for a Service Authorization Header record.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_SVC_AUTH_COUNTY IS 'The county in which the authorized service is provided.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.ID_RESOURCE IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.ID_CONTRACT IS 'Unique identifier and primary key for the CONTRACT table.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.ID_PRIMARY_CLIENT IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_SVC_AUTH_ABIL_TO_RESPOND IS 'Used to indicate whether the client is unable to respond, speaks English, Spanish or Other. Defaults to English.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_SVC_AUTH_CATEGORY IS 'Contains the category used during a service authorization search.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_SVC_AUTH_REGION IS 'Contains the region used during a service authorization search.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_SVC_AUTH_SERVICE IS 'Contains the service used during a service authorization search.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.DT_SVC_AUTH_VERBAL_REFERL IS 'The date that the worker verbally referred the case for services.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.DT_SVC_AUTH_EFF IS 'The Effective Date of the Service Authorization used to identify the proper contracted resource and contract version.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.IND_SVC_AUTH_COMPLETE IS 'Indicates whether the service authorization is complete and can be submitted for approval, create an event, and initiate alert generation.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.TXT_SVC_AUTH_COMMENTS IS 'Comments recorded at the time of a client''s service authorization.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.TXT_SVC_AUTH_DIR_TO_HOME IS 'The worker is able to specify the directions to the home of the client.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.TXT_SVC_AUTH_HOME_ENVIRON IS 'Enables the worker to comment on additional factors that impact Service Delivery. The worker uses the field to describe pertinent client factors to the service provider such as condition of the home.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.TXT_SVC_AUTH_MED_COND IS 'This allows the worker to enter information dealing with physical, mental and/or medical conditions which cause functional limitations.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.TXT_SVC_AUTH_SEC_PROVDR IS 'Subcontracted or other service providers. Informational field only with no validation.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.IND_DONTD_COMNTY_SVC IS 'This is an indicator to check whether service is donated community service by Y or N.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.AMT_EST_VALUE IS 'Contains the estimated value amount, when donated community service is selected by APS case.'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_PAY_CNTY IS 'Payment County Code'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.IND_WAIVER_REQD IS 'Indicates if Waiver is Required'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.ID_WAIVER IS 'Waiver ID'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.DT_REF_SENT IS 'Date Referral Sent'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_ERLY_CASE_TYP IS 'Early Intervention Case Type'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_PUP_TYP IS 'PUP Outcome Type'
;
COMMENT ON COLUMN CAPS.SERVICE_AUTHORIZATION.CD_PUP_OTCME IS 'PUP Outcome'
;
COMMENT ON TABLE CAPS.SERVICE_PLAN IS 'A plan used to help a family provide their child with a safe environment within a reasonable period of time. Plans include problems/strengths, goals, and objectives.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.ID_SVC_PLAN_EVENT IS 'A unique identifier for the event table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.ID_FAM_ASSMT_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_COMPLT IS 'The date which the worker completed the service plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_PARTCP IS 'The date the client/s (parents) participated in the development of the plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.CD_SVC_PLAN_TYPE IS 'Identifies the type of CPS service plan to be developed. Examples include safety plan or family plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_NEXT_REVW IS 'The system automatically determines the next date of review of the family service plan depending on stage of service and type of case: every six months for substitute care cases, 6 months for therapeutic foster care cases, 3 months for family preservation. Note: I some children are in the home and at least one is in substitute care, the case is considered a substitute care case.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.TXT_SVC_PLAN_RSN_INVLVMNT IS 'The reason CPS has become involved in the case. The description is printed on the hard copy of the Service Plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.IND_SVC_PLAN_CLIENT_CMNT IS 'Checked if the client recorded any comments on the service plan form (paper copy).'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.TXT_SVC_PLN_STRNTHS_RSRCS IS 'The user describes the strengths and/or resources. This description is printed on the hard copy of the Service Plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.TXT_SVC_PLAN_PARTCP IS 'If the parents did not participate in the development of the service plan, the user enters an explanation in the comment box.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_SGND_PARENT1 IS 'Date one of the parents signed.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_GIVEN_CLIENTS IS 'The date the worker hand delivered or mailed a paper copy of the plan to the client/s.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_SGND_PARENT2 IS 'Date one of the parents signed.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_SGND_SUPV IS 'Date the supervisor signed.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN.DT_SVC_PLAN_SGND_WORKER IS 'Date one of the workers signed. (No default)'
;
COMMENT ON TABLE CAPS.SERVICE_PLAN_EVAL_DTL IS 'Detail information about the Family Plan Evaluation that is performed during Service Delivery stages of a CPS case. A Family Plan Evaluation is done on an approved Family Plan every three or six months.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_DTL.ID_SVC_PLAN_EVAL_EVENT IS 'A unique identifier to the event table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_DTL.ID_SVC_PLAN_EVENT IS 'A unique identifier for the event table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_DTL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_DTL.CD_SVC_PLAN_EVAL_DTL_TYPE IS 'Type of evaluation of the service plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_DTL.DT_SVC_PLAN_EVAL_DTL_CMPL IS 'Date the evaluation for a particular goal on a Service Plan was completed by an evaluator.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_DTL.DT_SVC_PLAN_EVAL_DTL_NREV IS 'Defaults to three months from completion date for service delivery cases and six months from completion date for substitute care (based on what is entered in Evaluation Type field) can be modified.'
;
COMMENT ON TABLE CAPS.SERVICE_PLAN_EVAL_ITEM IS 'Information about each Task/Goal combinations for a Family Plan. Part of the Family Plan Evaluation event. There are multiple items per evaluation.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_ITEM.ID_SVC_PLAN_EVAL_ITEM IS 'The unique identifier to the Service Plan Eval Item table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_ITEM.ID_SVC_PLAN_EVAL_EVENT IS 'A unique identifier to the event table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_ITEM.ID_SVC_PLN_ITEM IS 'Primary key for the SERVICE_PLAN_ITEM table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_ITEM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_ITEM.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_ITEM.TXT_SVC_PLAN_EVAL_GOAL IS 'The worker enters free-form evaluative comments in this comment box. Comments are required for each task and goal evaluated.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_EVAL_ITEM.TXT_SVC_PLAN_EVAL_TASK IS 'Worker''s evaluation of the family''s assigned task.'
;
COMMENT ON TABLE CAPS.SERVICE_PLAN_ITEM IS 'Information about the goals, problems, tasks and services identified on a service plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.ID_SVC_PLN_ITEM IS 'Primary key for the SERVICE_PLAN_ITEM table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.ID_SVC_PLAN_EVENT IS 'A unique identifier for the event table.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.CD_SVC_PLAN_TASK IS 'Contains a code identifying a task in the service plan. It is populated from the Options list box when task is chosen as the Current Selection. The Tasks are dependent upon the Goal chosen.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.CD_SVC_PLAN_PROBLEM IS 'The code identifying a problem in the Service Plan. It is displayed in a list box.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.CD_SVC_PLAN_SVC IS 'Contains a code identifying a service that is populated from a list box when Service is chosen as the Current Selection. Services are dependent upon the Task chosen.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.IND_SVC_PLN_SVC_CRT_ORDR IS 'Indicates whether the task or service is court-ordered.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.IND_SVC_PLN_TASK_CRT_ORDR IS 'Checked by the worker if the task specified is Court ordered'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.TXT_SVC_PLAN_METHOD_EVAL IS 'The method of evaluation for the task or service. (Only enabled if the current selection is task or service. For services, it is disabled.)Comment field that allows the caseworker to identify the steps that are taken to determine if the client has achieved the selected goal or task.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.CD_SVC_PLAN_GOAL IS 'Displays either the task or goal from the highlighted row, depending on which radio button has been selected.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.TXT_SVC_PLAN_TASK_FREQ IS 'The begin date, end date or frequency of the task. (Only enabled if the current selection is task or service).'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.TXT_SVC_PLAN_PROBLEM IS 'Defaults to the long description of the Problem. The worker may modify the description to suit his/her needs. This field allows workers to create client-friendly statements that appear on the printed service plan. (The title of the comment box changes according to what is chosen as the Current Selection.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.TXT_SVC_PLAN_TASK IS 'Defaults to the long description of the Task. The worker may modify the description to suit his/her needs. This field allows workers to create client-friendly statements that appears on the printed service plan. (The title of the comment box changes to Description of Task when task is chosen as the Current Selection).'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.TXT_SVC_PLAN_GOAL IS 'Defaults to the long description of the type (of problems, goals, tasks, or services). The worker may modify the description to suit his/her needs. This field allows workers to create client friendly statements that appear on the printed service plan.'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.TXT_SVC_PLAN_SVC IS 'Defaults to the long description of the Service. The worker may modify the description to suit his/her needs. This field allows workers to create client-friendly statements that appear on the printed service plan. (The title of the comments box changes to Description of Service: when Service is chosen as the Current Selection).'
;
COMMENT ON COLUMN CAPS.SERVICE_PLAN_ITEM.TXT_SVC_PLAN_SVC_FREQ IS 'The begin date, end date or frequency of the task or service.The worker specifies how often or long the task or service is performed.'
;
COMMENT ON COLUMN CAPS.SIBLING.ID_SIBLING_GROUP IS 'Primary key of table'
;
COMMENT ON COLUMN CAPS.SIBLING.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SIBLING_GROUP.ID_SIBLING_GROUP IS 'Primary key of table'
;
COMMENT ON COLUMN CAPS.SIBLING_GROUP.NBR_IN_GROUP IS 'Number of children in group'
;
COMMENT ON COLUMN CAPS.SIBLING_GROUP.NBR_AVAIL IS 'Number available for adoption.'
;
COMMENT ON COLUMN CAPS.SIBLING_GROUP.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.SITUATION IS 'A situation is an incident involving abuse/neglect/exploitation or some request that requires casework by DFCS. A case may be composed of several situations. Each situation may have one or more stages of service, including multiple intakes, investigations and service deliveries. For a case, only one situation is active at a time. Once all stages in a situation are closed, the situation and case are closed.'
;
COMMENT ON COLUMN CAPS.SITUATION.ID_SITUATION IS 'A unique identifier for the SITUATION table.'
;
COMMENT ON COLUMN CAPS.SITUATION.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SITUATION.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SITUATION.DT_SITUATION_CLOSED IS 'Date situation is closed.'
;
COMMENT ON COLUMN CAPS.SITUATION.NBR_SIT_OCCURRENCE IS 'Stores the number of times a situation has been investigated for a given case.'
;
COMMENT ON COLUMN CAPS.SITUATION.CD_SIT_FUNCTIONAL_AREA IS 'Stores the functional area for a situation (i.e. APS)'
;
COMMENT ON COLUMN CAPS.SITUATION.CD_SIT_CURR_STATUS IS 'NEEDS A DEFINITION.* NOT CURRENTLY BEING USED BY THE SYSTEM.'
;
COMMENT ON COLUMN CAPS.SITUATION.DT_SITUATION_OPENED IS 'Date situation is opened.'
;
COMMENT ON TABLE CAPS.SP_PERSONS_RESPNSBL IS 'The SP_PERSONS_RESPNSBL table retains information regarding the persons responsible for the actions associated with the safety factors.'
;
COMMENT ON COLUMN CAPS.SP_PERSONS_RESPNSBL.ID_SP_PERS_RESPNSBL IS 'Unique person responsible on the safety factor record identifier'
;
COMMENT ON COLUMN CAPS.SP_PERSONS_RESPNSBL.ID_SFTY_FCTR IS 'Unique safety factor record identifier'
;
COMMENT ON COLUMN CAPS.SP_PERSONS_RESPNSBL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SP_PERSONS_RESPNSBL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON TABLE CAPS.SP_SAFETY_FACTORS IS 'The SP_SAFETY_FACTORS table retains information regarding the safety factors associated with a safety plan documented during the investigation stage.'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.ID_SFTY_FCTR IS 'Unique safety factor record identifier'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.ID_EVENT IS 'Event identifier associated with the safety plan'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.TXT_SFTY_FCTR_DESC IS 'Description of the safety factor'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.TXT_SFTY_FCTR_MITIGATE IS 'Description documented the changes required to mitigate the safety factor'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.DT_COMPLTD_BY IS 'Date the safety factor actions must be completed by.'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.TXT_DESC_ACTIONS IS 'Description of the actions required to mitigate the safety factor'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.TXT_SFTY_FCTR_COMMENTS IS 'Any comments associated with the safety factor'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.NM_FIRST_OTHR_RESP IS 'First Name of the ''Other'' person responsible/associated with the safety factor'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.NM_MIDDLE_OTHR_RESP IS 'Middle Name of the ''Other'' person responsible/associated with the safety factor'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.NM_LAST_OTHR_RESP IS 'Last Name of the ''Other'' person responsible/associated with the safety factor'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_FACTORS.IND_ADDL_PERS_RESP_EXIST IS 'Yes/No value indicating that the SP_PERSONS_RESPNSBL table has other identifiers of persons responsible/associated with this safety factor.'
;
COMMENT ON TABLE CAPS.SP_SAFETY_PLAN IS 'The SP_SAFETY_PLAN table retains basic information regarding the safety plan documented during the investigation stage.'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_PLAN.ID_EVENT IS 'Event identifier associated with the safety plan'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_PLAN.ID_CASE IS 'Unique identifier for CAPS Case associated with the safety plan'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_PLAN.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_PLAN.DT_DISC_WITH_CRTKR IS 'Date the safety plan was discussed with the caretaker'
;
COMMENT ON COLUMN CAPS.SP_SAFETY_PLAN.IND_CRTKR_AGREES_SP IS 'Yes/no value indicating whether the caretaker agrees with the safety plan'
;
COMMENT ON COLUMN CAPS.SPCL_SVC_AAA_NARR.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON TABLE CAPS.SPEC_SVCS IS 'Stores the facility''s available special services.'
;
COMMENT ON COLUMN CAPS.SPEC_SVCS.ID_SPEC_SVC IS 'Primary Key on the SPEC_SVCS table.'
;
COMMENT ON COLUMN CAPS.SPEC_SVCS.ID_SPEC_SVC_RSRC IS 'A unique identifier and primary key for the CAPS RESOURCE table.'
;
COMMENT ON COLUMN CAPS.SPEC_SVCS.CD_SPEC_SVCS IS 'This element indicates the special services offered by the resource.'
;
COMMENT ON COLUMN CAPS.SPEC_SVCS.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON TABLE CAPS.SPECIAL_NEEDS_DETERMINATION IS 'Table used for Special Needs Determination'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_REASON_SPECIAL_REQUEST IS 'Reason for Special Needs Request'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_CMNTS_SPECIAL_REQUEST IS 'Comments'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_CHILD_MNT_RETARDED IS 'Is the child diagnosed Mentally Retarded? (Options: Yes or No'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_CMNTS_MNT_RETARDED IS 'Comment( If yes, state diagnoses) .'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_CHILD_VIS_HEARING_IMPAIRED IS 'Is the child diagnosed Visually or Hearing Impaired? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_CMNTS_VIS_HEARING_IMPAIRED IS 'Comment( If yes, state diagnoses) '
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_CHILD_PHYSICALLY_DISABLED IS 'Is the child Physically Disabled? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_CMNTS_PHYSICALLY_DISABLED IS 'Comment( If yes, state diagnoses)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_CHILD_EMOTIONALLY_DISABLED IS 'Is the child diagnosed Emotionally Disturbed? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_CMNTS_EMOTIONALLY_DISABLED IS 'Comment( If yes, state diagnoses)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_CHILD_OTHER_MEDICAL IS 'Is the child diagnosed with other Medical condition(s)? 
 (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_CMNTS_OTHER_MEDICAL IS 'Comment( If yes, state diagnoses)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_DOC_PSYCHOLOGICAL IS 'Check PSYCHOLOGICAL documentation being attached'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_DOC_DEVELOPMENTAL_ASSMT IS 'Check DEVELOPMENTAL documentation being attached'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_DOC_TRTMNT_PRVDR IS 'Check DOCUMENTATION from Treatment Provider documentation being attached'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_DOC_MENTAL_ASSMT IS 'Check MENTAL documentation being attached'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_SPCL_SERVICE_REQ IS 'Is a Special Service being requested for this child? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_ALL_SPECIAL_DOC_ATTACHED IS 'Has all required documentation been attached? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.NBR_REQ_AMT IS 'Requested Amount'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.CD_SPCL_SER_TYPE IS 'Special Services Type'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_PLEASE_SPECIFY IS 'Please Specify'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_SPC_NEEDS_APPROVED IS 'Indicator if special needs determination request approved'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.CD_FUNDING_TYPE IS 'Funding Type'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_APR_TYPE IS 'Approval Type  '
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_APPRV_MNT_RETARDED IS 'Mentally Retarded'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_APPRV_HEARING_IMPAIRED IS 'Visually or Hearing Impaired'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_APPRV_PHYSICALLY_DISABLED IS 'Physically Disabled'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_APPRV_EMOTIONAL_DIST IS 'Emotionally Disturbed'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_APPRV_OTHER IS 'Other Medical Conditions'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_APPRV_OTHER_CMT IS 'Comments on Other Approval'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_SPCL_REQ_APPROVED IS 'Is the Special Service Request approved? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.CD_APPRV_SPCL_TYPE_FUNDING IS 'Special Services Type and Funding'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.NBR_APPRV_AMT IS 'Total (IV-E/IV-B) Approved Amount'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.DT_APPRV_DATE IS 'Approval Date'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.DT_EXPIRATION_DATE IS 'Expiration Date'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.TXT_COMMENTS IS 'Comments on Special Needs Determination'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_SPCL_RATE_ADO_APPR IS 'Is the Specialized Rate for Adoption Assistance approved? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_SPCL_RATE_REQ_CHILD IS 'Is a Specialized Rate being requested for this child? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_SPCL_SER_REQ_CHILD IS 'Is a Special Service being requested for this child? (Options: Yes or No)'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.NBR_TOTAL_IVE_IVB_AMT IS 'Holds the total amount that is approved'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.NBR_IVE_AMT IS 'IV-E Amount'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.NBR_IVB_AMT IS 'IV-B Amount'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.CD_PAYMENT_MTHD IS 'Indicates if payments are to be made directly to the Service Provider or to the adoptive parent.'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_BASIC_RATE_REQ_CHILD IS 'Indicates if a basic rate is being requested'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.IND_SFC_RBWO_RCVD IS 'Indicates if child is receiving a special foster care per-diem'
;
COMMENT ON TABLE CAPS.SR_HOUSEHOLD_MEMBERS IS 'Table tracks household members before DFCS takes custody of child'
;
COMMENT ON COLUMN CAPS.SR_HOUSEHOLD_MEMBERS.ID_SR_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.SR_HOUSEHOLD_MEMBERS.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.SR_HOUSEHOLD_MEMBERS.ID_PERSON IS 'Id of Person who is a Household Member'
;
COMMENT ON TABLE CAPS.STAGE IS 'This table links a specific situation to a particular stage of service. The same stage of service can occur multiple times in any given situation'
;
COMMENT ON COLUMN CAPS.STAGE.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.STAGE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_TYPE IS 'Code representing a further breakdown of the stage.  It defines the type of client or type of services being provided to the client. CODE_TYPE=CSTGTYPE'
;
COMMENT ON COLUMN CAPS.STAGE.ID_UNIT IS 'A unique identifer for the UNIT table.'
;
COMMENT ON COLUMN CAPS.STAGE.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.STAGE.ID_SITUATION IS 'A unique identifier for the SITUATION table.'
;
COMMENT ON COLUMN CAPS.STAGE.DT_STAGE_CLOSE IS 'The date the stage was closed.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_CLASSIFICATION IS 'Code that identifies the program or other agency responsible for any further action on the reported situation.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_CURR_PRIORITY IS 'Code which indicates the current priority assigned to an intake report.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_INITIAL_PRIORITY IS 'Code which indicates the new priority being assigned to an intake report.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_RSN_PRIORITY_CHGD IS 'A codified reason for a priority change.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_REASON_CLOSED IS 'Code representing the reason the stage closed.'
;
COMMENT ON COLUMN CAPS.STAGE.IND_STAGE_CLOSE IS 'This indicator is used to indicate if a stage is open (N) or closed (Y).'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_CNTY IS 'Code representing the county of the victim.'
;
COMMENT ON COLUMN CAPS.STAGE.NM_STAGE IS 'Text identifier for the name assigned to the stage.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_REGION IS 'The region of the worker assigned to a particular stage. A region is a geographic area which the state is broken down into.'
;
COMMENT ON COLUMN CAPS.STAGE.DT_STAGE_START IS 'The date the stage was opened.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_PROGRAM IS 'This is the PRS Program which controls the Stage. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE IS 'Code that represents the stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.). CODE_TYPE=CSTAGES'
;
COMMENT ON COLUMN CAPS.STAGE.TXT_STAGE_PRIORITY_CMNTS IS 'Text area for comments regarding the assigned priority or reasons for a priority change.'
;
COMMENT ON COLUMN CAPS.STAGE.TXT_STAGE_CLOSURE_CMNTS IS 'Comments describing reason for closing a case of a stage. This is a STAGE table element.'
;
COMMENT ON COLUMN CAPS.STAGE.CD_CLIENT_ADVISED IS 'If client was advised of case closure'
;
COMMENT ON COLUMN CAPS.STAGE.IND_ECS IS 'If ECS funds were used'
;
COMMENT ON COLUMN CAPS.STAGE.IND_ECS_VER IS 'If ECS funds were verified'
;
COMMENT ON COLUMN CAPS.STAGE.CD_STAGE_SCROUT_REASON IS 'Code for Screen Out Reason'
;
COMMENT ON COLUMN CAPS.STAGE.TXT_STAGE_SPL_INSTRT_CMNT IS 'Special Instructions Comment'
;
COMMENT ON TABLE CAPS.STAGE_ASSIGN_HISTORY IS 'Contains a history of when persons are assigned to and unassigned from a stage in a case.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.ID_STG_ASSGN_HSTRY IS 'Contains a unique identifier for a row on the STAGE ASSIGN HISTORY table.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.ID_STAGE_PERSON_LINK IS 'Contains a unique identifier for a row on the STAGE PERSON LINK table.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.DT_LST_UPDT IS 'Date the last update is on all tables and shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.CD_ROLE IS 'A code that indicates the role of each person involved in the case. Example: Victim, Alleged Perpetrator, Concerned relative, etc.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.DT_ASSGND IS 'The date a person is assigned to a stage in a case.'
;
COMMENT ON COLUMN CAPS.STAGE_ASSIGN_HISTORY.DT_UNASSGND IS 'The date a person is unassigned from a stage in a case.'
;
COMMENT ON TABLE CAPS.STAGE_LINK IS 'Links stages to each other to form one situation.'
;
COMMENT ON COLUMN CAPS.STAGE_LINK.ID_STAGE_LINK IS 'Unique identifier to the STAGE LINK table.'
;
COMMENT ON COLUMN CAPS.STAGE_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAGE_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.STAGE_LINK.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.STAGE_LINK.ID_PRIOR_STAGE IS 'ID of the stage prior to the current stage.'
;
COMMENT ON TABLE CAPS.STAGE_NAME_INFO IS 'General stage information'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.ID_STAGE_NAME_INFO IS 'Unique identifier of the stage name info records. Primary key.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.CD_STAGE IS 'Code that represents the stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.)'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.CD_STAGE_PROGRAM IS 'This is the DFCS Program which controls the Stage. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.CD_STAGE_TYPE IS 'Code representing a further breakdown of the stage.  It defines the type of client or type of services being provided to the client.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.DT_STAGE_START IS 'The date the stage was opened.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.DT_STAGE_CLOSE IS 'The date the stage was closed.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.CD_ADDRESS_TYPE IS 'Type of address for this stage.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.ADDR_ST_LN_1 IS 'First line of the street address.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.ADDR_ST_LN_2 IS 'Second line of the street address, if needed.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.ADDR_CITY IS 'City of the address.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.ADDR_STATE IS 'State of the address for the stage.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.ADDR_ZIP IS 'Zip code of the address.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.CD_COUNTY IS 'County code for the stage name.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.CD_REGION IS 'The region for which the contract has been created.'
;
COMMENT ON COLUMN CAPS.STAGE_NAME_INFO.IND_NM_STAGE_INDICATOR IS 'if name of stage is used'
;
COMMENT ON TABLE CAPS.STAGE_PERSON_LINK IS 'Information which links the situation with an individual on the case. This includes the individual''s role in the situation (Victim, AP etc.) and their function (Principal, Collateral, Employee). A person can be involved in many situations and have different roles and a different function in each.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.ID_STAGE_PERSON_LINK IS 'Contains a unique identifier for a row on the STAGE PERSON LINK table.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IS 'Code that indicates the type of function each person has in a particular report (i.e. principal, reporter, collateral.)'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.IND_STAGE_PERS_IN_LAW IS 'Indicates whether person relationship is in-law on the Person Detail window.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.CD_STAGE_PERS_TYPE IS 'Code that indicates the type of function each person has in a particular report (i.e. principal, reporter, collateral.)'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.CD_STAGE_PERS_SEARCH_IND IS 'Code Indicating  that the worker would like to perform a contact search including the name checked.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.TXT_STAGE_PERS_NOTES IS 'Comments or notes that can be person specific.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.DT_STAGE_PERS_LINK IS 'The date the assignment of the employee to the situation/stage was made.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.CD_STAGE_PERS_REL_INT IS 'Code representing the relationship/interest of an individual to a case.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.IND_STAGE_PERS_REPORTER IS 'A "Y" indicates that the relationship of the Reporter is described by the value stored in CD_STAGE_PERS_REL_INT.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.IND_STAGE_PERS_PR_SEC_ASGN IS 'Indicates whether person is Primary/Secondary assigned employee for the stage. In the STAGE PERSON LINK table.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.IND_STAGE_PERS_EMP_NEW IS 'Indicator that determines whether the assigned employee has done any action on the assigned situation/stage.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.CD_STAGE_PERS_LST_SORT IS 'Contains a code used to identify and sort a person in the Person List window listbox.  A person may be a "CALLER_SORT" (01), "REPORTER_SORT" (02), or an "OTHER_SORT" (03).  Each intake has only one caller, but may have multiple persons categorized as reporters or others.  The caller always appears shaded in the first row of the listbox.  All "reporters" appear below the "caller" row and above the "other" rows.'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.IND_NM_STAGE IS 'If that person is the name of the stage'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.IND_STAGE_PERS_SFTY_RESOURCE IS 'If that person could be a safety resource'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.ID_PERS_SCNDARY_CARETAKER IS 'ID of the secondary caretaker'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.TXT_STAGE_PERS_OTH_RELATIONS IS 'Comments on other person relationships in the stage'
;
COMMENT ON COLUMN CAPS.STAGE_PERSON_LINK.CD_PERSON_SIDE_OF_FAMILY IS 'Code indicating what side of the family the person being linked is on.'
;
COMMENT ON TABLE CAPS.STAGE_PROG IS 'Static table that provides stage progression information to the application. The table specifies which stages can be created from previous stages. Also provides the information necessary to generate alerts when a new stage is begun.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.ID_STAGE_PROG IS 'A unique identifier to the Stage Progression table.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_STAGE IS 'A stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.)'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_RSN_CLOSE IS 'Reason stage closed on static stage progression table.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_PROGRAM IS 'Contains the DFCS Program that controls the Stage. i.e., CPS, APS Facility, APS Community care, etc.  It is used by the Stage Progression table.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.IND_STAGE_PROG_CLOSE IS 'This indicator is used to indicate the progression of a case (i.e., close stage, close case OR close stage, open stage).'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_OPEN IS 'Contains the value of the stage to be opened for a case. (i.e., a stage of service that has certain tasks associated with it (i.e., intake, investigation, service delivery, etc.)).'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_EVENT_TYPE IS 'A type of event recorded by IMPACT, (i.e. investigation closure, service plan approval, etc.)'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_STAGE_TYPE IS 'Contains the Stage Type.  It is used by the Stage Progression table.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_STATUS IS 'Contains the status of an event. (e.g., started, in process, complete) Only one status per event is maintained in the system, so the status is updated if it changes. (e.g., from started to in process)'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_TASK IS 'The various tasks used to close and re-open stages through stage progression.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.CD_STAGE_PROG_TODO_INFO IS 'Contains a 4-digit code that tells Stage Progression which CD TODO INFO TASK is applicable .  Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.TXT_STAGE_PROG_EVNT_DESC IS 'Details about an event which are unique to a specific occurrence of a particular event type.'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.TXT_STAGE_PROG_TODO_DESC IS 'The To Do description for the To Dos created through stage progression'
;
COMMENT ON COLUMN CAPS.STAGE_PROG.NBR_STAGE_PROG_DAYS_DUE IS 'If a due date is required for a task this field indicates in how many days (starting today) is the task due.'
;
COMMENT ON TABLE CAPS.STAR_PERS_MTCH_REQUEST IS 'Contains IMPACT person match requests from the STAR system.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.ID_STAR_PM_REQ IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.ID_REQUEST IS 'This is a match to the primary key of the STARS EA REQUEST table.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.CD_STAR_PM_REQ_ENTITY IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.CD_STAR_PM_REQ_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.CD_STAR_PM_REQ_SEX IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.ID_STAR_PM_REQ_PERSON IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.CD_STAR_PM_REQ_RSLT_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.NM_STAR_PM_REQ_FIRST IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.NM_STAR_PM_REQ_MIDDLE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.NM_STAR_PM_REQ_LAST IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.NM_STAR_PM_REQ_SUFFIX IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.DT_STAR_PM_REQ_BIRTH IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.NBR_STAR_PM_REQ_TDHS IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_REQUEST.NBR_STAR_PM_REQ_SSN IS 'No description available.'
;
COMMENT ON TABLE CAPS.STAR_PERS_MTCH_RESPONSE IS 'Contains the results of IMPACT person match searches in response to requests from the STAR system.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.ID_STAR_PM_RESP IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.ID_REQUEST IS 'This is a match to the primary key of the STARS EA REQUEST table.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.CD_STAR_PM_RESP_ENTITY IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.CD_STAR_PM_RESP_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.CD_STAR_PM_RESP_SEX IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.ID_STAR_PM_RESP_PERSON IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.CD_STAR_PM_RESP_RSLT_CODE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.NM_STAR_PM_RESP_FIRST IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.NM_STAR_PM_RESP_MIDDLE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.NM_STAR_PM_RESP_LAST IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.NM_STAR_PM_RESP_SUFFIX IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.DT_STAR_PM_RESP_BIRTH IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.NBR_STAR_PM_RESP_TDHS IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STAR_PERS_MTCH_RESPONSE.NBR_STAR_PM_RESP_SSN IS 'No description available.'
;
COMMENT ON TABLE CAPS.STARS_EA_REQUEST IS 'This table is used as part of the interface with STARS (Services To At-Risk Youth).  It stores the client EA eligibility request to IMPACT from STARS.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.ID_STARS_EA_REQUEST IS 'Unique identifier of a STARS EA REQUEST record.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.ID_STARS_EA_REQ_PERSON IS 'ID PERSON for the person for which the requested action is being taken.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.IND_STARS_EA_REQ_ROW_PROC IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.CD_STARS_EA_REQ_ACTION_CODE IS 'Code indicating that STARS has requested action to be taken during batch processing.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.CD_STARS_EA_REQ_RSLT_CODE IS 'Code indicating the result of action taken by the batch process requested by STARS.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.DT_STARS_EA_REQ_OPEN IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.DT_STARS_EA_REQ_CLOSE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.DT_STARS_EA_REQ_EA_OPEN IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.DT_STARS_EA_REQ_EA_CLOSE IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.DT_STARS_EA_REQ_EA_DENY IS 'No description available.'
;
COMMENT ON COLUMN CAPS.STARS_EA_REQUEST.NBR_STARS_EA_REQ_STARS_PROV IS 'No description available.'
;
COMMENT ON TABLE CAPS.STFF_ASGNMT_HISTORY IS 'Represents staff assignment history of a case. Updated by 2 tables STAGE_PERSON_LINK and TO_DO.'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.ID_STFF_ASGNMT_HSTRY IS 'Primary Key of Staff Assignment History Table'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.ID_FROM_PERSON IS 'Person the case is being transferred from.'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.ID_TO_PERSON IS 'Person the case is being assigned to.'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.ID_ENTERED_BY_PERSON IS 'Person who entered this case transfer/assignment.'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.ID_STAGE IS 'Stage of the case being transferred.'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.ID_CASE IS 'ID of the  case being transferred/assigned.'
;
COMMENT ON TABLE CAPS.SUB_ELIG_NARR IS 'Stores the subsidy eligibility narrative for a particular child.'
;
COMMENT ON COLUMN CAPS.SUB_ELIG_NARR.ID_ADPT_SUB IS 'Unique identifier of a row on the ADOPTION SUBSIDY table.'
;
COMMENT ON COLUMN CAPS.SUB_ELIG_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SUB_ELIG_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SUB_ELIG_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Substitute care eligibility.'
;
COMMENT ON COLUMN CAPS.SUB_ELIG_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.SUBMITTED_DTL IS 'This table is used during nightly financial batch processing.  It contains detail information about invoices submitted to the accounting system for payment.  It is used to keep track of how delvrd_svc_dtl rows were rolled up so that rejections can be properly noted in the system.'
;
COMMENT ON COLUMN CAPS.SUBMITTED_DTL.ID_SUBMITTED_DTL IS 'A unique identifier for a row on the SUBMITTED DTL table.'
;
COMMENT ON COLUMN CAPS.SUBMITTED_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SUBMITTED_DTL.NBR_SUBMITTED_DLN IS 'Contains the DLN used when submitting the current row for payment.  (The DLN (Document Locator Number) is used to relate invoices having the same id_contract and vendor ID that are rolled together and paid as a single unit.)'
;
COMMENT ON COLUMN CAPS.SUBMITTED_DTL.NBR_SUBMITTED_LINE_XREF IS 'Contains the line number, within the DLN, into which the current row was rolled up for payment.'
;
COMMENT ON COLUMN CAPS.SUBMITTED_DTL.ID_SUBMITTED_LINE_DTL IS 'Contains the ID of the row submitted for payment.  The table the row belongs to is identified by the value in CD SUBMITTED LINE DTL.'
;
COMMENT ON COLUMN CAPS.SUBMITTED_DTL.CD_SUBMITTED_LINE_DTL IS 'Contains a code indicating the IMPACT table related to the ID stored in the ID SUBMITTED LINE DTL element of the SUBMITTED DTL table.'
;
COMMENT ON COLUMN CAPS.SUBMITTED_DTL.ID_SUBMITTED_BREAKOUT IS 'Contains an ID that links to the FMIS BREAKOUT table.  (However, the FMIS BREAKOUT rows are deleted before the item is actually submitted for payment.  FMIS BREAKOUT is a temporary table used during nightly financial processing.)'
;
COMMENT ON TABLE CAPS.SVC_AUTH_DETAIL IS 'This table links a service authorization within a situation to a person receiving a service, and the service rendered.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.ID_SVC_AUTH_DTL IS 'A unique identifier for a row on the SVC AUTH DTL table.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.ID_SVC_AUTH IS 'The unique key for a Service Authorization Header record.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.CD_SVC_AUTH_DTL_AUTH_TYPE IS 'Specifies to the provider whether the service request is an initial, update, or termination to a previous request, or whether it is a one-time only request. This needs to be filled before the user can submit for approval.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.CD_SVC_AUTH_DTL_PERIOD IS 'The period of time in which a certain frequency of units of service are provided.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.CD_SVC_AUTH_DTL_SVC IS 'The service that has been authorized for a DFCS client.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.CD_SVC_AUTH_DTL_UNIT_TYPE IS 'The unit type under which the service being authorized was contracted.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.DT_SVC_AUTH_DTL IS 'The date the service authorization was made.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.DT_SVC_AUTH_DTL_BEGIN IS 'Start date for services for the principal.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.DT_SVC_AUTH_DTL_END IS 'End date for services for the principal.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.DT_SVC_AUTH_DTL_TERM IS 'The date that a service authorization ends or is terminated early (if no early termination, then term date equals end date).'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.DT_SVC_AUTH_DTL_SHOW IS 'Show date for the ToDo created in Service Auth Detail window.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.AMT_SVC_AUTH_DTL_AMT_REQ IS 'Amount Requested for the Service Recipient in dollars. Field disables or enables dependent on the contract. If the contract specifies a need for the amount in dollars then the field is enabled.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.AMT_SVC_AUTH_DTL_AMT_USED IS 'The amount of the authorization that has been used.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.NBR_SVC_AUTH_DTL_FREQ IS 'Used in conjunction with the unit type, the frequency is used to calculate a number of units for a specified period of time.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.NBR_SVC_AUTH_DTL_LINE_ITM IS 'The line item number of the contract that the service authorization record references.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.NBR_SVC_AUTH_DTL_SUG_UNIT IS 'The number of units calculated and suggested by the application based on the unit type, frequency, begin date, and term date. This must remain a length of 7 (unsigned long) to enable the proper calculations.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.NBR_SVC_AUTH_DTL_UNITS_REQ IS 'Number of units of a service requested by a worker on the service authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.NBR_SVC_AUTH_DTL_UNIT_RATE IS 'The rate for which the authorized service can be invoiced and paid.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.NBR_SVC_AUTH_DTL_UNIT_USED IS 'The number of units used out of the total units authorized.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.IND_SERV_ACPT IS 'Service Provider Accepted'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.IND_CASE_PLN_SVC IS 'Service Required in Case Plan'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.CD_SVC_QLTY IS 'Quality of Service'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DETAIL.TXT_CMMTS IS 'Comments'
;
COMMENT ON TABLE CAPS.SVC_AUTH_DTL_AUDIT IS 'This table contains the elements to audit the SVC AUTH DTL table. There should always be a matching element in this table for each element in SVC AUTH DTL.  (Contains no true primary or foreign key constraints.)'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.ID_SVC_AUTH_AUD_DTL IS 'Primary key on the SVC_AUTH_DTL_AUDIT table.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.ID_SVC_AUTH_AUD IS 'Primary Key for the SERVICE_AUTH_AUDIT table.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.ID_AUD_PERSON IS 'A unique identifier for a row on the Person table.  When entered, this appears to be an MD associated with the APS Case.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.CD_SVC_AUTH_DTL_AUD_AUTH_TYPE IS 'The unit type under which the service being authorized was contracted.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.CD_SVC_AUTH_DTL_AUD_PERIOD IS 'The period of time in which a certain frequency of units of service are provided.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.CD_SVC_AUTH_DTL_AUD_SVC IS 'The service that has been authorized for a DFCS client.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.CD_SVC_AUTH_DTL_AUD_UNIT_TYPE IS 'The unit type under which the service being authorized was contracted.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.DT_SVC_AUTH_DTL_AUD IS 'The date the service authorization was made.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.DT_SVC_AUTH_DTL_AUD_BEGIN IS 'Start date for services for the principal.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.DT_SVC_AUTH_DTL_AUD_END IS 'End date for services for the principal.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.DT_SVC_AUTH_DTL_AUD_TERM IS 'The date that a service authorization ends or is terminated early (if no early termination, then term date equals end date).'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.DT_SVC_AUTH_DTL_AUD_SHOW IS 'Show date for the ToDo created in Service Auth Detail window.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.AMT_SVC_AUTH_DTL_AUD_AMT_REQ IS 'Amount Requested for the Service Recipient in dollars. Field disables or enables dependent on the contract. If the contract specifies a need for the amount in dollars then the field is enabled.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.AMT_SVC_AUTH_DTL_AUD_AMT_USED IS 'The amount of the authorization that has been used.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.NBR_SVC_AUTH_DTL_AUD_FREQ IS 'Used in conjunction with the unit type, the frequency is used to calculate a number of units for a specified period of time.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.NBR_SVC_AUTH_DTL_AUD_LINE_ITM IS 'The line item number of the contract that the service authorization record references.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.NBR_SVC_AUTH_DTL_AUD_SUG_UNIT IS 'The number of units calculated and suggested by the application based on the unit type, frequency, begin date, and term date. This must remain a length of 7 (unsigned long) to enable the proper calculations.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.NBR_SVC_AUTH_DTL_AUD_UNITS_REQ IS 'Number of units of a service requested by a worker on the service authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.NBR_SVC_AUTH_DTL_AUD_UNIT_RATE IS 'The rate for which the authorized service can be invoiced and paid.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_DTL_AUDIT.NBR_SVC_AUTH_DTL_AUD_UNIT_USED IS 'The number of units used out of the total units authorized.'
;
COMMENT ON TABLE CAPS.SVC_AUTH_EVENT_LINK IS 'Links multiple Service Authorization rows to one Service Authorization header event.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_EVENT_LINK.ID_SVC_AUTH_EVENT IS 'A unique identifier to the EVENT and SVC AUTH EVENT LINK tables.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_EVENT_LINK.ID_SVC_AUTH IS 'The unique key for a Service Authorization Header record.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_EVENT_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_EVENT_LINK.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON TABLE CAPS.SVC_AUTH_VALID IS 'This table holds the valid service authorization details for a contract, and is used in the budget validation process along with the contract service records.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.ID_AUTH_VALID IS 'A unique identifier for a row on the SVC AUTH DTL table.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.ID_SVC_AUTH IS 'The unique key for a Service Authorization Header record.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.AMT_AUTH_VALID_AMT_REQ IS 'Amount requested on a service authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.AMT_AUTH_VALID_AMT_USED IS 'Amount used on a service authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.CD_AUTH_VALID_PERIOD IS 'Period of the authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.DT_AUTH_VALID_BEGIN IS 'Begin date of the authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.DT_AUTH_VALID_TERM IS 'Termination date of the authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.NBR_AUTH_VALID_UNIT_RATE IS 'Unit rate of the authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.NBR_AUTH_VALID_UNIT_USED IS 'Number of units used on the authorization.'
;
COMMENT ON COLUMN CAPS.SVC_AUTH_VALID.NBR_AUTH_VALID_UNITS_REQ IS 'Number of units requested on the authorization.'
;
COMMENT ON TABLE CAPS.SVC_DELV_DTL IS 'Stores the decision date for service delivery.'
;
COMMENT ON COLUMN CAPS.SVC_DELV_DTL.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.SVC_DELV_DTL.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.SVC_DELV_DTL.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.SVC_DELV_DTL.DT_SVC_DELV_DECISION IS 'The date the closure window was technically completed.'
;
COMMENT ON TABLE CAPS.TASK IS 'Static table used by the application to populate the Task List dependent on the stage that is being accessed. Also provides information on which push buttons to enable under certain circumstances.'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK IS 'The primary key to the TASK table.  The code value may be stored in various other tables.  The value may then be used to acquire other information about the task, such as a description, from the TASK table.'
;
COMMENT ON COLUMN CAPS.TASK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK_EVENT_STATUS IS 'Status of event. (e.g., started, in process, complete) Only one status per event is maintained in the system, so the status is updated if it changes. (e.g., from started to in process)'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK_EVENT_TYPE IS 'A type of event recorded by IMPACT, (i.e. investigation closure, service plan approval, etc.)'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK_LIST_WINDOW IS 'Indicates the smart name of the list window that needs to be called in order to display all the events linked to a particular task. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK_PRIOR IS 'CD TASK of the Prior Stage is needed for Task List. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK_STAGE IS 'A stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.)'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK_STAGE_PROGRAM IS 'This is the DFCS Program which controls the Stage. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.TASK.CD_TASK_TOP_WINDOW IS 'Indicates which window to open to create the task.Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_DETAIL_ENABLE IS 'Indicates whether Task List should always enable the Detail PB (Override).'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_EVENT_CREATE IS 'Indicates if an event is created (Event ID created) when a To Do for a task is created from the Task List.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_EVENT_NAVIG IS 'Indicates if an event is navigational or not.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_LIST_ENABLE IS 'Indicates whether Task List should always enable the List PB (Override).'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_MULTIPLE_INSTANCE IS 'Indicates if multiple instances of a task are allowed.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_NEW_ENABLE IS 'Indicates whether Task List should always enable the New PB (Override).'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_NEW_USING IS 'Indicates whether the new using file option is available.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_NU_ACROSS_CASE IS 'Indicates whether the new using file option is to be used across the case.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_RTRV_PRIOR_STAGE IS 'Indicates whether Task uses Prior Stage to retrieve information instead of Current Stage.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_SHOW_IN_LIST IS 'Indicates whether Task should display in Task List window.'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_TODO_ENABLE IS 'Indicates whether Task List should always enable the To Do PB (Override).'
;
COMMENT ON COLUMN CAPS.TASK.TXT_TASK_DECODE IS 'Text name assigned to a task.'
;
COMMENT ON COLUMN CAPS.TASK.TXT_1ST_TAB IS 'path to first level tab'
;
COMMENT ON COLUMN CAPS.TASK.TXT_2ND_TAB IS 'path to second level tab'
;
COMMENT ON COLUMN CAPS.TASK.TXT_3RD_TAB IS 'path to third level tab'
;
COMMENT ON COLUMN CAPS.TASK.TXT_EVENT_DETAIL_URL IS 'url of event type'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_CODE_PREFER IS 'indicator if task code should override'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_NEW_CASE_TODO_ENABLE IS 'indicator if task can be created by creating a new to do'
;
COMMENT ON COLUMN CAPS.TASK.IND_TASK_FORCE_EVENT_LINK IS 'indicator if task needs to be linked to event'
;
COMMENT ON COLUMN CAPS.TASK.IND_STAGE_CLOSURE IS 'indicator if the task is a stage closure task'
;
COMMENT ON TABLE CAPS.TCM_CLAIM IS 'Holds TCM Claim Data'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.ID_TCM_CLAIM IS 'TCM Claim ID'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.ID_STAFF IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.ID_STAGE IS 'Stage ID'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.NM_CLIENT IS 'Client Name'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.NBR_MEDICAID IS 'Medicaid Number'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.CD_STATUS IS 'Status'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.CD_DENIAL IS 'Denial Reason - EOB Codes (multiple comma delimited values possible)'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.DT_STATUS IS 'Status Date'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.DT_SERVICE IS 'Service Date'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.NBR_TCN IS 'TCN Number'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.DT_PAY IS 'Pay date for the claim'
;
COMMENT ON COLUMN CAPS.TCM_CLAIM.NBR_RA IS 'Remitall Advice Number (identifies a batch of Medicaid claims that were processed together)'
;
COMMENT ON TABLE CAPS.TEAM_MEET_REVIEW_NARRATIVE IS 'Stores the team meeting narrative content'
;
COMMENT ON COLUMN CAPS.TEAM_MEET_REVIEW_NARRATIVE.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.TEAM_MEET_REVIEW_NARRATIVE.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.TEAM_MEET_REVIEW_NARRATIVE.ID_CASE IS 'Case id'
;
COMMENT ON COLUMN CAPS.TEAM_MEET_REVIEW_NARRATIVE.NARRATIVE IS 'The content of the narrative'
;
COMMENT ON COLUMN CAPS.TEAM_MEET_REVIEW_NARRATIVE.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.TEMP_ELIG_SEND_MHMR IS 'Contains the clients who are claimed as Title XIX eligible by MHMR.  The table is refreshed (deleted and reloaded) monthly though the DHS Receive batch interface process.'
;
COMMENT ON COLUMN CAPS.TEMP_ELIG_SEND_MHMR.TEMP_ELIG_CLIENT_NBR IS 'Contains the DHS client number.'
;
COMMENT ON COLUMN CAPS.TEMP_ELIG_SEND_MHMR.TEMP_ELIG_NAME_LAST IS 'Contains the last name of the client.'
;
COMMENT ON COLUMN CAPS.TEMP_ELIG_SEND_MHMR.TEMP_ELIG_NAME_FIRST IS 'Contains the first name of the client.'
;
COMMENT ON TABLE CAPS.TEMP_LOGIN IS 'login id'
;
COMMENT ON COLUMN CAPS.TEMP_LOGIN.ID_PERSON IS 'person id  '
;
COMMENT ON TABLE CAPS.TEMP_SECURITY_CLASS IS 'Static table holding security class information for users'
;
COMMENT ON TABLE CAPS.TEMP_SSMS_INTRFC_EVENT IS 'Temp table used for the SSMS conversion process. The table will be needed for as long as the SSMS outbound interface is active.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_EVENT.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_EVENT.CD_EVENT_TYPE IS 'A type of event recorded by IMPACT, (i.e. investigation closure, service plan approval, etc.)'
;
COMMENT ON TABLE CAPS.TEMP_SSMS_INTRFC_LIST IS 'Temporary table to be used in the SSMS conversion process. The table will be needed for as long as the SSMS outbound interface is active.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_LIST.CD_TRANSACTION IS 'No description available.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_LIST.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_LIST.ID_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_LIST.CD_STAGE IS 'Code that represents the stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.)'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_LIST.CD_ACTION IS 'No description available.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_LIST.SSMS_1 IS 'No description available.'
;
COMMENT ON COLUMN CAPS.TEMP_SSMS_INTRFC_LIST.SSMS_2 IS 'No description available.'
;
COMMENT ON TABLE CAPS.TEMP_STAGE_PERS_LINK IS 'Used by Intake dialog box to store assignments for people that have not been fully saved.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE_PERS_LINK IS 'A unique integer which defines a Stage Person Link on the Temporary Stage Person Link table.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE IS 'A unique integer which identifies a Stage of Service on the Temporary Stage Person Link table.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE_PERSON IS 'ID of person assigned to stage or temp stage person link table. Used for Intake before it is complete.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.CD_TEMP_STAGE IS 'A stage of service which has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.). This temporary stage of service is used by the Temporary Stage Person Link table and can only contain the value of ''INT''.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.CD_TEMP_STAGE_PERS_ROLE IS 'A code that indicates the role of each person involved in the case. Example: Victim, Alleged Perpetrator, Concerned relative, etc. This temporary role is used by the Temporary Stage Person Link table and only contains the value of ''PR''.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.CD_TEMP_STAGE_PERS_TYPE IS 'A code that indicates the type of function each person has in a particular report (i.e. principal, reporter, collateral.). This temporary type is used by the Temporary Stage Person Link table and only contains the value ''STF''.'
;
COMMENT ON COLUMN CAPS.TEMP_STAGE_PERS_LINK.DT_TEMP_STAGE_PERS_LINK IS 'The date the assignment of the employee to the Intake stage occurred. This temporary date is used by the Temporary Stage Person Link table.'
;
COMMENT ON TABLE CAPS.TODO IS 'A list of to-do functions for the worker to complete.'
;
COMMENT ON COLUMN CAPS.TODO.ID_TODO IS 'A unique identifier for a row on the To Do table.'
;
COMMENT ON COLUMN CAPS.TODO.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.TODO.ID_TODO_PERS_ASSIGNED IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.TODO.ID_TODO_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.TODO.ID_TODO_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.TODO.ID_TODO_PERS_CREATOR IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.TODO.ID_TODO_STAGE IS 'A unique identifier for a row on the STAGE table.'
;
COMMENT ON COLUMN CAPS.TODO.ID_TODO_PERS_WORKER IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.TODO.DT_TODO_DUE IS 'A date created by the employee indicating when the To Do must be completed.'
;
COMMENT ON COLUMN CAPS.TODO.CD_TODO_TASK IS 'Task ID linked to To Do record.'
;
COMMENT ON COLUMN CAPS.TODO.TXT_TODO_DESC IS 'The short description of a To Do.'
;
COMMENT ON COLUMN CAPS.TODO.CD_TODO_TYPE IS 'Type of to do. (i.e. Reminder, Alert, or Task)'
;
COMMENT ON COLUMN CAPS.TODO.TXT_TODO_LONG_DESC IS 'The long description of a To Do.'
;
COMMENT ON COLUMN CAPS.TODO.DT_TODO_CREATED IS 'The date the to-do is scheduled (created if system generated.)'
;
COMMENT ON COLUMN CAPS.TODO.DT_TODO_TASK_DUE IS 'A date created by the system indicating when a To Do must be completed. These To Dos are related to an item on the Task List.'
;
COMMENT ON COLUMN CAPS.TODO.DT_TODO_COMPLETED IS 'The date that a scheduled task is completed.'
;
COMMENT ON COLUMN CAPS.TODO.NM_TODO_CREATOR_INIT IS 'The initials of the person who created the ToDo.'
;
COMMENT ON TABLE CAPS.TODO_INFO IS 'This entity contains all TO DOs that can be generated by the system.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.ID_TODO_INFO IS 'A unique identifier for the TODO INFO table.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.CD_TODO_INFO IS 'Unique code for the To Do. Mislabeled as a code. There is no associated codes table for this data element.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.CD_TODO_INFO_PERS_ASSIGND IS 'Role of a person who should receive this To Do. Use codes in Unit Member Role codes table.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.CD_TODO_INFO_TASK IS 'Contains a 4-digit code that allows the user to navigate to a certain task.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.CD_TODO_INFO_TYPE IS 'To Do Type - (a)lert, (r)eminder, (t)odo.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.NBR_TODO_INFO_DUE_DD IS 'The number of days to be added to the given date to produce the real due date.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.NBR_TODO_INFO_DUE_MM IS 'The number of months to be added to the given date to produce the real due date.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.NBR_TODO_INFO_DUE_YY IS 'The number of years to be added to the given date to produce the real due date.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.NBR_TODO_INFO_TASK_DUE_DD IS 'The number of days to be added to the given date to produce the show date.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.NBR_TODO_INFO_TASK_DUE_MM IS 'The number of months to be added to the given date to produce the show date.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.NBR_TODO_INFO_TASK_DUE_YY IS 'The number of years to be added to the given date to produce the show date.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.TXT_TODO_INFO_DESC IS 'Short description of the To Do.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.TXT_TODO_INFO_LONG_DESC IS 'Long description of the To Do.'
;
COMMENT ON COLUMN CAPS.TODO_INFO.IND_TODO_INFO_ENABLED IS 'if the to do info is used '
;
COMMENT ON TABLE CAPS.TRAIN_MASTER IS 'The TRAIN_MASTER table contains master configuration information used only by Training versions of the application. This table is not referenced in production. This table should have ONE and ONLY ONE ROW in it.'
;
COMMENT ON COLUMN CAPS.TRAIN_MASTER.TRAIN_GLOBAL IS 'Contains the global password for training users. Only used for training databases.'
;
COMMENT ON COLUMN CAPS.TRAIN_MASTER.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON TABLE CAPS.TRIBAL IS 'Tracks a person''s affiliation with an Native American Tribe.'
;
COMMENT ON COLUMN CAPS.TRIBAL.ID_TRIBAL IS 'Unqiue identifier for the Tribal record.'
;
COMMENT ON COLUMN CAPS.TRIBAL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.TRIBAL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.TRIBAL.NBR_TRBL_PERCENT_HERITAGE IS 'Numeric percentage of person''s heritage associated with this tribe. 100 percent is the maximum and indicates the person is  full-blooded Native American of this tribe.'
;
COMMENT ON COLUMN CAPS.TRIBAL.TXT_TRIBAL_NAME IS 'Name of the Native American tribe.'
;
COMMENT ON COLUMN CAPS.TRIBAL.NBR_TRIBAL_REGISTRY IS 'Tribal Registry Number associated with this Tribe.'
;
COMMENT ON COLUMN CAPS.TRIBAL.IND_TRBL_MEMBER IS 'Indicator is the person is a member of this Native American tribe.'
;
COMMENT ON COLUMN CAPS.TRIBAL.IND_TRBL_REGISTERED IS 'Indicator if the person is registered with the Native American tribe.'
;
COMMENT ON TABLE CAPS.UNIT IS 'Information about a unit, which is a grouping of employees within a region and program which performs a specific function or specialization.'
;
COMMENT ON COLUMN CAPS.UNIT.ID_UNIT IS 'A unique identifer for the UNIT table.'
;
COMMENT ON COLUMN CAPS.UNIT.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.UNIT.NBR_UNIT IS 'Number which identifies a group of workers with common supervisor and goals.'
;
COMMENT ON COLUMN CAPS.UNIT.CD_UNIT_REGION IS 'A geographic area which the state is broken down into.'
;
COMMENT ON COLUMN CAPS.UNIT.CD_UNIT_PROGRAM IS 'The program the unit is associated with: APS, CPS...'
;
COMMENT ON COLUMN CAPS.UNIT.ID_PERSON IS 'The person ID of the unit approver (supervisor)  of that unit.'
;
COMMENT ON COLUMN CAPS.UNIT.ID_UNIT_PARENT IS 'ID of the parent unit of the current unit.'
;
COMMENT ON COLUMN CAPS.UNIT.CD_UNIT_SPECIALIZATION IS 'APS or CPS specific unit that has been tasked to handle a specific type of case based on skill needs.'
;
COMMENT ON COLUMN CAPS.UNIT.CD_COUNTY IS 'County Code'
;
COMMENT ON TABLE CAPS.UNIT_EMP_LINK IS 'A link which identifies an employee with a unit.'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.ID_UNIT_EMP_LINK IS 'A unique integer which defines a Unit Employee Link.'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.DT_LAST_UPDATE IS 'A unique integer which defines a Unit Employee Link.'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person and Employee tables.'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.ID_UNIT IS 'A unique identifer for the UNIT table.'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IS 'The role an employee plays within a unit: Support, Worker, Designee, Supervisor. Not Classification.'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.CD_UNIT_MEMBER_IN_OUT IS 'Designates whether the staff added to a unit is formally within the unit based upon their bjn or not.'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_INT IS 'Intake Stage Number'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_INV IS 'Investigation Stage Number'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_DIV IS 'Diversion Stage Number'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_ONG IS 'Ongoing stage number'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_FC IS 'Foster Care Stage Number'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_ADO IS 'Adoption Stage Number'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_PAD IS 'number of post adoption stages'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_FAD IS 'number of foster adoptive stages'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_TOTAL IS 'Total'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_STAFF_ID IS 'Staff ID Number'
;
COMMENT ON COLUMN CAPS.UNIT_EMP_LINK.NBR_PFC IS 'Number of Post Foster Care stages'
;
COMMENT ON TABLE CAPS.VARNCE_NARR IS 'Not Used. Stores the Variance Narrative.'
;
COMMENT ON COLUMN CAPS.VARNCE_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.VARNCE_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.VARNCE_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.VARNCE_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Variance.'
;
COMMENT ON COLUMN CAPS.VARNCE_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.VIOLTN_NARR IS 'Not Used. Stores the Violation Narrative.'
;
COMMENT ON COLUMN CAPS.VIOLTN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.VIOLTN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.VIOLTN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.VIOLTN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the FA Home Violation.'
;
COMMENT ON COLUMN CAPS.VIOLTN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.VISIT_PLAN_NARR IS 'Blob table for the Visitation Plan that is used during CPS Conservatorship cases.'
;
COMMENT ON COLUMN CAPS.VISIT_PLAN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.VISIT_PLAN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.VISIT_PLAN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.VISIT_PLAN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description of the Visitation Plan.'
;
COMMENT ON COLUMN CAPS.VISIT_PLAN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.VISIT_PLN_SPAN_NARR IS 'Blob table for the Visitation Plan - Spanish that is used during CPS Conservatorship cases.'
;
COMMENT ON COLUMN CAPS.VISIT_PLN_SPAN_NARR.ID_EVENT IS 'A unique identifier to the EVENT table.'
;
COMMENT ON COLUMN CAPS.VISIT_PLN_SPAN_NARR.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.VISIT_PLN_SPAN_NARR.ID_CASE IS 'Unique identifier for CAPS Case.'
;
COMMENT ON COLUMN CAPS.VISIT_PLN_SPAN_NARR.NARRATIVE IS 'Data element to represent a blob in ORACLE. This data element serves as a pointer in memory to a formatted MS WORD document.  Contains a narrative description the visitation plan in Spanish.'
;
COMMENT ON COLUMN CAPS.VISIT_PLN_SPAN_NARR.ID_DOCUMENT_TEMPLATE IS 'The id for the document.'
;
COMMENT ON TABLE CAPS.WORKLOAD IS 'Used for the assigned workload window and is build off of the stage person link table.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.ID_WKLD_PERSON IS 'A unique integer that identifies a Person (worker).'
;
COMMENT ON COLUMN CAPS.WORKLOAD.ID_WKLD_STAGE IS 'A unique integer that identifies a Stage of Service.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.DT_LAST_UPDATE IS 'Date of last update shows when the record was last modified.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.ID_WKLD_CASE IS 'A unique integer that identifies a Case.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_WKLD_STAGE_PERS_ROLE IS 'A code that indicates the role of each person involved in the case. Example: Victim, Alleged Perpetrator, Concerned relative, etc.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.DT_WKLD_STAGE_PERS_LINK IS 'The date the assignment of the employee to the situation/stage was made.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.IND_WKLD_STAGE_PERS_NEW IS 'Generic indicator used by the Database trigger that indicates the need for creation of a history record.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.NM_WKLD_STAGE IS 'The name of the stage to which the worker is currently assigned.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_WKLD_STAGE IS 'A stage of service that has certain tasks associated with it (i.e. intake, investigation, service delivery, etc.)'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_WKLD_STAGE_CNTY IS 'County that the stage is or was handled within.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_WKLD_STAGE_TYPE IS 'Code value of a logical group of tasks that as been started or completed.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_WKLD_STAGE_REGION IS 'A geographic area which the state is broken down into. Specific to the stage of the case it is associated with.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_WKLD_STAGE_RSN_CLS IS 'Reason stage closed (code) on stage table.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_WKLD_STAGE_PROGRAM IS 'This is the DFCS Program that controls the Stage. i.e., CPS, APS Facility, APS Community care etc.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.ID_WKLD_UNIT IS 'Unique identifier of the unit to which the worker is assigned.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.NBR_WKLD_UNIT IS 'Number that identifies a group of workers with common supervisor and goals.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.NM_WKLD_CASE IS 'This is the Name of the Case. Usually is the Name of one of the Principals (Mother or Father).'
;
COMMENT ON COLUMN CAPS.WORKLOAD.IND_WKLD_CASE_SENSITIVE IS 'Generic indicator used by the Database trigger that indicates the need for creation of a history record.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.IND_WKLD_SUPERINT_NOTIF IS 'No description available.'
;
COMMENT ON COLUMN CAPS.WORKLOAD.DT_CHECKOUT IS 'Date of workload checkout'
;
COMMENT ON COLUMN CAPS.WORKLOAD.DT_CHECKIN IS 'date of workload checkin'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_MOBILE_STATUS IS 'status of mobile checkout'
;
COMMENT ON COLUMN CAPS.WORKLOAD.CD_RECIDIVISM IS 'Indicator if recidivism exists'
;
COMMENT ON TABLE CAPS.WTLP_PLAN IS 'Holds WTLP page information'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.ID_EVENT IS 'A unique identifier to the EVENT table.- primary key of the WTLP_PLAN table'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.CD_PLAN_TYPE IS 'Plan Type'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.DT_WTLP IS 'WTLP Date'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.DT_FROM IS 'WTLP From Date'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.DT_TO IS 'WTLP Date to'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.CD_PLCMT_AUTH IS 'Placement Authority'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.TXT_VOLUNTARY IS 'If Voluntary Describe'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.CD_EDU IS 'Education'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.CD_VOC IS 'Vocational Code'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.CD_BASIC IS 'Basic Daily Living'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.CD_HEALTH IS 'Health/Education Maintenance'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.CD_PERS IS 'Personal Development/Counseling'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.TXT_STRENGTHS IS 'Strengths'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.TXT_NEEDS IS 'Needs'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.YDP_COORD_INFO IS 'Additional info about the YDP coordinator'
;
COMMENT ON COLUMN CAPS.WTLP_PLAN.ID_YDP_COORD IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON TABLE CAPS.YOUTH_DETAIL IS 'This table hold Youth Develpment information for children 14 and older (formerly known as WTLP Detail).
'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.ADDR_GED_ADDR_1 IS 'Address Line 1'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.ADDR_GED_ADDR_2 IS 'Address Line 2'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.ADDR_GED_ADDR_CITY IS 'City'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.ADDR_GED_ADDR_STATE IS 'State'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.ADDR_GED_ADDR_ZIP IS 'Zip Code'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.CD_ACAD_TRACK IS 'Academic Track'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.CD_CLASSIF IS 'Classification'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.CD_EDU_GOAL IS 'Education Goal'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.CD_PAR_STAT IS 'Captures the parental status of the person'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_EMNC_DISC IS 'Emancipation Discussion Date'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_GED_EXP_PROG_COMP IS 'Expected GED Program Completion Date'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_GED_PROG_COMP IS 'Actual GED Program Completion'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_SCH_GRAD IS 'Expected highschool graduation date'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_POST_EXP_GRAD IS 'Post Secondary Expected Graduation Date'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_POST_GRAD IS 'Post Secondary Actual Graduation Date'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.IND_EMP_SVC IS 'Captures if employment services have been provided'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.IND_GED_PROG IS 'In GED Program'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.IND_HEALTH_SVC IS 'Captures if health services have been provided'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.IND_LIFE_SKILLS IS 'Captures if life skills training has been provided.'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.IND_SCH_GRAD IS 'High School Graduate'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_GED_FAX IS 'Fax Number'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_GED_PHONE IS 'Phone Number'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_POST_CUMM_GPA IS 'Post Secondary Education Cumulative GPA'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_POST_CURR_GPA IS 'Post Secondary Education Current GPA'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_POST_REQ_CRED IS 'Post Secondary Education Credits Required'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_POST_REQ_EAR IS 'Post Secondary Education Credits Earned'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_SCH_CREDIT_EARNED IS 'Credits earned.'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_SCH_CREDIT_REQD IS 'Credits Required'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_SCH_CURR_GPA IS 'School Current GPA'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NBR_SCH_CUM_GPA IS 'School Cumulative GPA'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NM_GED_PROG IS 'GED Program Name'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NM_INST IS 'Institution Name'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.NM_SCH IS 'Highschool name'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.TXT_AREA_STUDY IS 'Area of Study'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.TXT_EMNC_DISC IS 'Comments on Emancipation discussion'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.TXT_EMP_SVC IS 'Employment Services Received'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.TXT_HLTH_SVC IS 'Health Services Received'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.TXT_LIFE_SKILLS IS 'Life Skills Training Received'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.TXT_SCH_CMMTS IS 'School Comments'
;
COMMENT ON TABLE CAPS.YOUTH_REPORT_DTL IS 'Each record represents outcome reporting information for a child per reporting period (once a year).'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.ID_YOUTH_REPORT_DTL IS 'Unique identifier for Youth Report Detail'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.DT_LAST_UPDATE IS 'Date of insert or last update'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.ID_PERSON IS 'Id of child for whom the referral was sent  A unique identifier for a row on the Person table.'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.DT_RPT_PERIOD_END IS 'The end date of the reporting period for this record'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.DT_DOB IS 'Date of birth of child at time of report'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_AGE_CLASS IS 'The age class of child at time of report, as determined by case manager'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_SEX IS 'Sex of child'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_RACE_AA IS 'Indicates if child is American Indian/Alaskan Native'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_RACE_AN IS 'Indicates if child is Asian'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_RACE_BK IS 'Indicates if child is Black/African-American'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_RACE_HP IS 'Indicates if child is Native Hawaiian/Pacific Islander'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_RACE_UD IS 'Indicates if child''s race is undeterminable'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_RACE_WT IS 'Indicates if child is White/Caucasian'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_RACE_DECLINED IS 'Indicates if the informant declined to specify race'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_ETHINICITY IS 'Ethnicity of child'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_ETH_DECLINED IS 'Indicates if the informant declined to specify ethnicity'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_TRIBAL_MBR IS 'Indicates if child is a tribal member'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_ADJ_DELINQUENT IS 'Indicates if child has faced legal charges of delinquency'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_LAST_GRADE_COMP IS 'Last grade of education completed by the child at time of report'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_SPC_EDU_STAT IS 'Indicates if child requires special education	
'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_IL_NEEDS_ASM IS 'Indicates if child''s capacity to live independently needs assessment'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_ACAD_SUPPORT IS 'Indicates if academic support was given during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_PS_EDU_SUPPORT IS 'Indicates if post-secondary education support was given during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CAREER_PREP IS 'Indicates if career preparation training was given during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_EMP_PROG_VOC IS 'Indicates if employment programs or vocational training were provided during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_BDGT_FIN_MGT IS 'Indicates if budget or finance management training was given during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_HOUSING_EDU IS 'Indicates if housing education was provided during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_HEALTH_EDU IS 'Indicates if health education was provided during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_FAM_MARR_EDU IS 'Indicates if family or marriage education was provided during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_MENTORING IS 'Indicates if mentoring was provided during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_SUPER_IL IS 'Indicates if supervised independent living services were provided during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_ROOM_BRD_FIN IS 'Indicates if room and board financial assistance was given during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_EDU_FINANCE IS 'Indicates if education financial assistance was given during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_OTH_FINANCE IS 'Indicates if other financial assistance was given during the reporting period'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_OUTCOME_RPT_STAT IS 'The status of outcomes reporting'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.DT_OUTCOME_DATE IS 'The date of outcomes reporting'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_FC_STATUS IS 'Indicates if the child is in the foster care program at time of report'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CURR_FT_EMP IS 'Indicates if child currently maintains full-time employment'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CFTE_DECLINED IS 'Indicates if the informant declined to specify current full-time employment status'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CURR_PT_EMP IS 'Indicates if child currently maintains part-time employment'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CPTE_DECLINED IS 'Indicates if the informant declined to specify current part-time employment status'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_EMP_SKILLS IS 'Indicates if child has developed employment-related skills'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_ERS_DECLINED IS 'Indicates if the informant declined to specify employment-related skills'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_SOCIAL_SEC IS 'Indicates if the child receives Social Security income/resources'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_SS_DECLINED IS 'Indicates if the informant declined to specify Social Security income'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_EDUC_AID IS 'Indicates if the child receives educational aid'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_EA_DECLINED IS 'Indicates if the informant declined to specify educational aid'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_TANF IS 'Indicates if child receives public financial assistance (TANF)'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_TANF_DECLINED IS 'Indicates if the informant declined to specify public financial assistance'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_FOOD_STAMPS IS 'Indicates if child receives food assistance'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_FS_DECLINED IS 'Indicates if the informant declined to specify food assistance'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_HOUSING_AST IS 'Indicates if child receives housing assistance'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_HA_DECLINED IS 'Indicates if the informant declined to specify housing assistance'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_OTH_SUPPORT IS 'Indicates if child receives other support'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_OS_DECLINED IS 'Indicates if the informant declined to specify other support'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_HIGH_EDU IS 'Highest educational certification received'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_HEDU_DECLINED IS 'Indicates if the informant declined to specify highest educational certification received'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CURR_ATD_ENR IS 'Indicates if child is enrolled in and regularly attends an educational program'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CAE_DECLINED IS 'Indicates if the informant declined to specify current attendance and enrollment'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CONN_ADULT IS 'Indicates if child has a connection to an adult'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CA_DECLINED IS 'Indicates if the informant declined to specify connection to adult'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_MEDICAID IS 'Indicates if child is a member of Medicaid'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_MED_DECLINED IS 'Indicates if the informant declined to specify Medicaid member status'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_OTH_HLTH_INS_TYP IS 'What, if any, other health insurance covers the child at time of report'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_OHIT_DECLINED IS 'Indicates if the informant declined to specify other health insurance type'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_HOMELESS IS 'Indicates if child has experienced periods of homelessness'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_HOM_DECLINED IS 'Indicates if the informant declined to specify homelessness experience'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_SUB_ABUSE_REF IS 'Indicates if child has been a substance abuse referral'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_SAR_DECLINED IS 'Indicates if the informant declined to specify substance abuse referral status'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_INCARCERATION IS 'Indicates if child has experienced incarceration'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_INC_DECLINED IS 'Indicates if the informant declined to specify incarceration experience'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CHILDREN IS 'Indicates if child is a parent'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_CHL_DECLINED IS 'Indicates if the informant declined to specify parental status'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.CD_MARR_AT_BIRTH IS 'Indicates if child was married when becoming a parent'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_MAB_DECLINED IS 'Indicates if the informant declined to specify marital status at time of birthing children'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.IND_FOLLOW_UP IS 'A system indicator representing follow-up reporting capability'
;
COMMENT ON TABLE CAPS.ZIP_CODE IS 'Stores all possible zip codes and associates them with counties and regions.'
;
COMMENT ON COLUMN CAPS.ZIP_CODE.NBR_ZIP_NUMBER IS 'Zip Codes for the state of Georgia.'
;
COMMENT ON COLUMN CAPS.ZIP_CODE.CD_ZIP_REGION IS 'Contains a code that indicates the region in which the zip code is located.'
;
COMMENT ON COLUMN CAPS.ZIP_CODE.CD_ZIP_COUNTY IS 'Contains a code that indicates the Georgia county in which the zip code is located.'
;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (497, 'SacwisRev3', 'Release 3.2 - DBCR 14746');

commit;



