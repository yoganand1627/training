--STGAP00015932 - Release(3.6) Create Indexes for all Foreign Keys

--Some tables have foreign keys which are referencing fields that are not indexed.  To improve performance (and minimize the time a table is locked during an update), this dbcr is creating indexes for the foriegn keys.

CREATE INDEX CAPS.ADMN_RVW_DECISION_NARR_FK1 ON CAPS.ADMN_RVW_DECISION_NARR(ID_CASE) tablespace index01;
CREATE INDEX CAPS.ADO_INFO_FK1 ON CAPS.ADO_INFO(ID_EVENT_CHILD_REGISTRATION) tablespace index01;
CREATE INDEX CAPS.ADOPTION_SUBSIDY_FK1 ON CAPS.ADOPTION_SUBSIDY(ID_SPC_NEEDS_DET) tablespace index01;
CREATE INDEX CAPS.ADO_SIBLING_HISTORY_FK1 ON CAPS.ADO_SIBLING_HISTORY(ID_ADO_INFO_EVENT) tablespace index01;
CREATE INDEX CAPS.ADO_SIBLING_HISTORY_FK2 ON CAPS.ADO_SIBLING_HISTORY(ID_EVENT_CHILD_REGISTRATION) tablespace index01;
CREATE INDEX CAPS.CHILDREN_FIRST_REFERRAL_FK1 ON CAPS.CHILDREN_FIRST_REFERRAL(ID_GENERATION_EVENT) tablespace index01;
CREATE INDEX CAPS.CONTACT_FK1 ON CAPS.CONTACT(ID_CONTACT_TCM_CLIENT) tablespace index01;
CREATE INDEX CAPS.CONTACT_FK2 ON CAPS.CONTACT(ID_PORTAL_USER_ENTERED) tablespace index01;
CREATE INDEX CAPS.CONTACT_FOR_FK1 ON CAPS.CONTACT_FOR(ID_CONTACT_RULE) tablespace index01;
CREATE INDEX CAPS.CW_CASE_ERRORS_FK1 ON CAPS.CW_CASE_ERRORS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_CASE_WARNINGS_FK1 ON CAPS.CW_CASE_WARNINGS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_CASA_GAL_FK1 ON CAPS.CW_FC_CASA_GAL(ID_PERSON) tablespace index01;
CREATE INDEX CAPS.CW_FC_CASA_GAL_FK2 ON CAPS.CW_FC_CASA_GAL(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_CI_CONTACT_ADDL_FACT_FK1 ON CAPS.CW_FC_CI_CONTACT_ADDL_FACTORS(ID_ILP_COORDINATOR_ASSIGNED) tablespace index01;
CREATE INDEX CAPS.CW_FC_CI_CONTACT_ADDL_FACT_FK2 ON CAPS.CW_FC_CI_CONTACT_ADDL_FACTORS(ID_ILP_COORDINATOR_WTLP) tablespace index01;
CREATE INDEX CAPS.CW_FC_CI_CONTACT_ADDL_FACT_FK3 ON CAPS.CW_FC_CI_CONTACT_ADDL_FACTORS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_CP_REVIEW_FACTORS_FK1 ON CAPS.CW_FC_CP_REVIEW_FACTORS(ID_CURRENT_PLAN_EVENT) tablespace index01;
CREATE INDEX CAPS.CW_FC_CP_REVIEW_FACTORS_FK2 ON CAPS.CW_FC_CP_REVIEW_FACTORS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_HEALTH_SCREENS_FK1 ON CAPS.CW_FC_HEALTH_SCREENS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_HIDDEN_SECTION_ERRORSFK1 ON CAPS.CW_FC_HIDDEN_SECTION_ERRORS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_PARENTAL_CONTACTS_FK1 ON CAPS.CW_FC_PARENTAL_CONTACTS(ID_PARENT) tablespace index01;
CREATE INDEX CAPS.CW_FC_PARENTAL_CONTACTS_FK2 ON CAPS.CW_FC_PARENTAL_CONTACTS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_TPR_BY_ROLE_FK1 ON CAPS.CW_FC_TPR_BY_ROLE(ID_PARENT) tablespace index01;
CREATE INDEX CAPS.CW_FC_TPR_BY_ROLE_FK2 ON CAPS.CW_FC_TPR_BY_ROLE(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_FC_TPR_FACTORS_FK3 ON CAPS.CW_FC_TPR_FACTORS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_INV_ADDL_FACTORS_FK1 ON CAPS.CW_INV_ADDL_FACTORS(ID_SPEC_INV_RESOURCE) tablespace index01;
CREATE INDEX CAPS.CW_INV_ADDL_FACTORS_FK2 ON CAPS.CW_INV_ADDL_FACTORS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_INV_RESP_PER_VICTIM_FK1 ON CAPS.CW_INV_RESP_PER_VICTIM(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_INV_RESP_PER_VICTIM_FK2 ON CAPS.CW_INV_RESP_PER_VICTIM(ID_VICTIM) tablespace index01;
CREATE INDEX CAPS.CW_LAST_VIEWED_FK1 ON CAPS.CW_LAST_VIEWED(ID_EMPLOYEE) tablespace index01;
CREATE INDEX CAPS.CW_LAST_VIEWED_FK2 ON CAPS.CW_LAST_VIEWED(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_ONG_ADDL_FACTORS_FK1 ON CAPS.CW_ONG_ADDL_FACTORS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_ONG_CONTACT_STANDARDS_FK1 ON CAPS.CW_ONG_CONTACT_STANDARDS(ID_PERSON) tablespace index01;
CREATE INDEX CAPS.CW_ONG_CONTACT_STANDARDS_FK2 ON CAPS.CW_ONG_CONTACT_STANDARDS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_ONG_SAFETY_RESOURCE_FK1 ON CAPS.CW_ONG_SAFETY_RESOURCE(ID_CHILD) tablespace index01;
CREATE INDEX CAPS.CW_ONG_SAFETY_RESOURCE_FK2 ON CAPS.CW_ONG_SAFETY_RESOURCE(ID_SAFETY_RESOURCE) tablespace index01;
CREATE INDEX CAPS.CW_ONG_SAFETY_RESOURCE_FK3 ON CAPS.CW_ONG_SAFETY_RESOURCE(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.CW_UPCOMING_EVENTS_FK1 ON CAPS.CW_UPCOMING_EVENTS(ID_EVENT) tablespace index01;
CREATE INDEX CAPS.CW_UPCOMING_EVENTS_FK2 ON CAPS.CW_UPCOMING_EVENTS(ID_STAGE) tablespace index01;
CREATE INDEX CAPS.DILIGENT_SEARCH_FK1 ON CAPS.DILIGENT_SEARCH(ID_PERSON_DETAIL) tablespace index01;
CREATE INDEX CAPS.FCCP_DTL_FORM_NARR_FK1 ON CAPS.FCCP_DTL_FORM_NARR(ID_EVENT) tablespace index01;
CREATE INDEX CAPS.FOSTER_HOME_CONV_FK1 ON CAPS.FOSTER_HOME_CONV(ID_ADO_AGENCY) tablespace index01;
CREATE INDEX CAPS.INITIAL_MED_PARENT_FK1 ON CAPS.INITIAL_MED_PARENT(ID_EVENT) tablespace index01;
CREATE INDEX CAPS.INITIAL_MED_PARENT_FK2 ON CAPS.INITIAL_MED_PARENT(ID_PERSON) tablespace index01;
CREATE INDEX CAPS.MEDICATION_ENC_FK1 ON CAPS.MEDICATION_ENC(ID_PERSON) tablespace index01;
CREATE INDEX CAPS.PERF_TALLY_FK1 ON CAPS.PERF_TALLY(ID_OFFICE) tablespace index01;
CREATE INDEX CAPS.PLACEMENT_FK1 ON CAPS.PLACEMENT(ID_PERSON_CONNECTED_ADULT) tablespace index01;
CREATE INDEX CAPS.PORTAL_USER_FK1 ON CAPS.PORTAL_USER(ID_PORTAL_PERSON_MODIFIED_BY) tablespace index01;
CREATE INDEX CAPS.PORTAL_USER_FK2 ON CAPS.PORTAL_USER(ID_SHINES_PERSON_MODIFIED_BY) tablespace index01;
CREATE INDEX CAPS.PPT_FK1 ON CAPS.PPT(ID_CONTACT_STDS_EVENT) tablespace index01;
CREATE INDEX CAPS.SAFETY_RESOURCE_CHILD_FK1 ON CAPS.SAFETY_RESOURCE_CHILD(ID_SR_EVENT) tablespace index01;
CREATE INDEX CAPS.SAFETY_RESOURCE_FK1 ON CAPS.SAFETY_RESOURCE(ID_PRIMARY) tablespace index01;
CREATE INDEX CAPS.SAFETY_RESOURCE_FK2 ON CAPS.SAFETY_RESOURCE(ID_SECONDARY) tablespace index01;
CREATE INDEX CAPS.SR_HOUSEHOLD_MEMBERS_FK1 ON CAPS.SR_HOUSEHOLD_MEMBERS(ID_PERSON) tablespace index01;
CREATE INDEX CAPS.SR_HOUSEHOLD_MEMBERS_FK2 ON CAPS.SR_HOUSEHOLD_MEMBERS(ID_SR_EVENT) tablespace index01;
CREATE INDEX CAPS.SVC_AUTH_DETAIL_FK1 ON CAPS.SVC_AUTH_DETAIL(ID_SPC_NEEDS_DET) tablespace index01;
CREATE INDEX CAPS.TCM_CLAIM_FK1 ON CAPS.TCM_CLAIM(ID_EVENT) tablespace index01;
DROP INDEX CAPS.IND_CONTRACT_COUNTY_99;
CREATE INDEX CAPS.CONTRACT_COUNTY_FK1 ON CAPS.CONTRACT_COUNTY(ID_CONTRACT,NBR_CNCNTY_PERIOD,NBR_CNCNTY_VERSION,NBR_CNCNTY_LINE_ITEM,CD_CNCNTY_SERVICE) tablespace index01;
insert into caps.schema_version(id_schema_version,application_version,comments)
            values (850, 'SacwisRev3', 'Release 3.6 - DBCR 15932');

commit;

