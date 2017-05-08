--STGAP00016086 - Release(4.2) MR-075  Update TUBR_CAPS_RESOURCE trigger

-- MR-075 FA Home Reimbursability Enhancement DBCR
-- Update TIBR_RESOURCE_HISTORY trigger


grant select on caps.caps_case to operator;

/
  CREATE OR REPLACE TRIGGER CAPS.TUBR_CAPS_RESOURCE 
BEFORE UPDATE
ON CAPS.CAPS_RESOURCE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
  dummy2    NUMBER;

-- Similar to those triggers of table PERSON
-- Mike Bui 12-JUL-95

BEGIN

-- 05/26/2001 MITSCHCG Added for CLASS project SIR #15684
-- For resource type 70 check whether any of the following columns changed
-- and if changed set the dt_ccl_update to sysdate.

IF :NEW.CD_RSRC_FACIL_TYPE ='70' THEN

IF ((:OLD.CD_RSRC_FACIL_TYPE IS NULL AND :NEW.CD_RSRC_FACIL_TYPE IS NOT NULL)   OR
   (:OLD.CD_RSRC_FACIL_TYPE IS NOT NULL AND :NEW.CD_RSRC_FACIL_TYPE IS NULL)   OR
   (:OLD.CD_RSRC_FACIL_TYPE != :NEW.CD_RSRC_FACIL_TYPE))        OR
   ((:OLD.CD_RSRC_FA_HOME_STATUS IS NULL AND :NEW.CD_RSRC_FA_HOME_STATUS IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_STATUS IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_STATUS IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_STATUS != :NEW.CD_RSRC_FA_HOME_STATUS))        OR
   ((:OLD.CD_RSRC_CATEGORY IS NULL AND :NEW.CD_RSRC_CATEGORY IS NOT NULL)   OR
   (:OLD.CD_RSRC_CATEGORY IS NOT NULL AND :NEW.CD_RSRC_CATEGORY IS NULL)   OR
   (:OLD.CD_RSRC_CATEGORY != :NEW.CD_RSRC_CATEGORY))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_1 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_1 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_1 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_1 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_1 != :NEW.CD_RSRC_FA_HOME_TYPE_1))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_2 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_2 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_2 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_2 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_2 != :NEW.CD_RSRC_FA_HOME_TYPE_2))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_3 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_3 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_3 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_3 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_3 != :NEW.CD_RSRC_FA_HOME_TYPE_3))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_4 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_4 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_4 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_4 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_4 != :NEW.CD_RSRC_FA_HOME_TYPE_4))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_5 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_5 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_5 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_5 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_5 != :NEW.CD_RSRC_FA_HOME_TYPE_5))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_6 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_6 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_6 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_6 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_6 != :NEW.CD_RSRC_FA_HOME_TYPE_6))        OR
   ((:OLD.CD_RSRC_FA_HOME_TYPE_7 IS NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_7 IS NOT NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_7 IS NOT NULL AND :NEW.CD_RSRC_FA_HOME_TYPE_7 IS NULL)   OR
   (:OLD.CD_RSRC_FA_HOME_TYPE_7 != :NEW.CD_RSRC_FA_HOME_TYPE_7))        OR
   ((:OLD.CD_RSRC_REGION IS NULL AND :NEW.CD_RSRC_REGION IS NOT NULL)   OR
   (:OLD.CD_RSRC_REGION IS NOT NULL AND :NEW.CD_RSRC_REGION IS NULL)   OR
   (:OLD.CD_RSRC_REGION != :NEW.CD_RSRC_REGION))        OR
   ((:OLD.NM_RESOURCE IS NULL AND :NEW.NM_RESOURCE IS NOT NULL)   OR
   (:OLD.NM_RESOURCE IS NOT NULL AND :NEW.NM_RESOURCE IS NULL)   OR
   (:OLD.NM_RESOURCE != :NEW.NM_RESOURCE))        OR
   ((:OLD.NBR_RSRC_FACIL_CAPACITY IS NULL AND :NEW.NBR_RSRC_FACIL_CAPACITY IS NOT NULL)   OR
   (:OLD.NBR_RSRC_FACIL_CAPACITY IS NOT NULL AND :NEW.NBR_RSRC_FACIL_CAPACITY IS NULL)   OR
   (:OLD.NBR_RSRC_FACIL_CAPACITY != :NEW.NBR_RSRC_FACIL_CAPACITY))        OR
   ((:OLD.DT_RSRC_CLOSE IS NULL AND :NEW.DT_RSRC_CLOSE IS NOT NULL)   OR
   (:OLD.DT_RSRC_CLOSE IS NOT NULL AND :NEW.DT_RSRC_CLOSE IS NULL)   OR
   (:OLD.DT_RSRC_CLOSE != :NEW.DT_RSRC_CLOSE))        OR
   ((:OLD.DT_RSRC_CERT IS NULL AND :NEW.DT_RSRC_CERT IS NOT NULL)   OR
   (:OLD.DT_RSRC_CERT IS NOT NULL AND :NEW.DT_RSRC_CERT IS NULL)   OR
   (:OLD.DT_RSRC_CERT != :NEW.DT_RSRC_CERT))        OR
   ((:OLD.ADDR_RSRC_ST_LN_1 IS NULL AND :NEW.ADDR_RSRC_ST_LN_1 IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_1 IS NOT NULL AND :NEW.ADDR_RSRC_ST_LN_1 IS NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_1 != :NEW.ADDR_RSRC_ST_LN_1))        OR
   ((:OLD.ADDR_RSRC_ST_LN_2 IS NULL AND :NEW.ADDR_RSRC_ST_LN_2 IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_2 IS NOT NULL AND :NEW.ADDR_RSRC_ST_LN_2 IS NULL)   OR
   (:OLD.ADDR_RSRC_ST_LN_2 != :NEW.ADDR_RSRC_ST_LN_2))        OR
   ((:OLD.ADDR_RSRC_CITY IS NULL AND :NEW.ADDR_RSRC_CITY IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_CITY IS NOT NULL AND :NEW.ADDR_RSRC_CITY IS NULL)   OR
   (:OLD.ADDR_RSRC_CITY != :NEW.ADDR_RSRC_CITY))        OR
   ((:OLD.CD_RSRC_STATE IS NULL AND :NEW.CD_RSRC_STATE IS NOT NULL)   OR
   (:OLD.CD_RSRC_STATE IS NOT NULL AND :NEW.CD_RSRC_STATE IS NULL)   OR
   (:OLD.CD_RSRC_STATE != :NEW.CD_RSRC_STATE))        OR
   ((:OLD.ADDR_RSRC_ZIP IS NULL AND :NEW.ADDR_RSRC_ZIP IS NOT NULL)   OR
   (:OLD.ADDR_RSRC_ZIP IS NOT NULL AND :NEW.ADDR_RSRC_ZIP IS NULL)   OR
   (:OLD.ADDR_RSRC_ZIP != :NEW.ADDR_RSRC_ZIP))        OR
   ((:OLD.CD_RSRC_CNTY IS NULL AND :NEW.CD_RSRC_CNTY IS NOT NULL)   OR
   (:OLD.CD_RSRC_CNTY IS NOT NULL AND :NEW.CD_RSRC_CNTY IS NULL)   OR
   (:OLD.CD_RSRC_CNTY != :NEW.CD_RSRC_CNTY))        OR
   ((:OLD.NBR_RSRC_PHN IS NULL AND :NEW.NBR_RSRC_PHN IS NOT NULL)     OR
   (:OLD.NBR_RSRC_PHN IS NOT NULL AND :NEW.NBR_RSRC_PHN IS NULL)     OR
   (:OLD.NBR_RSRC_PHN != :NEW.NBR_RSRC_PHN))            OR
   ((:OLD.NBR_RSRC_PHONE_EXT IS NULL AND :NEW.NBR_RSRC_PHONE_EXT IS NOT NULL)   OR
   (:OLD.NBR_RSRC_PHONE_EXT IS NOT NULL AND :NEW.NBR_RSRC_PHONE_EXT IS NULL)   OR
   (:OLD.NBR_RSRC_PHONE_EXT != :NEW.NBR_RSRC_PHONE_EXT))        OR
   ((:OLD.NBR_RSRC_FM_AGE_MAX IS NULL AND :NEW.NBR_RSRC_FM_AGE_MAX IS NOT NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MAX IS NOT NULL AND :NEW.NBR_RSRC_FM_AGE_MAX IS NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MAX != :NEW.NBR_RSRC_FM_AGE_MAX))        OR
   ((:OLD.NBR_RSRC_FM_AGE_MIN IS NULL AND :NEW.NBR_RSRC_FM_AGE_MIN IS NOT NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MIN IS NOT NULL AND :NEW.NBR_RSRC_FM_AGE_MIN IS NULL)   OR
   (:OLD.NBR_RSRC_FM_AGE_MIN != :NEW.NBR_RSRC_FM_AGE_MIN))        OR
   ((:OLD.NBR_RSRC_MA_AGE_MAX IS NULL AND :NEW.NBR_RSRC_MA_AGE_MAX IS NOT NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MAX IS NOT NULL AND :NEW.NBR_RSRC_MA_AGE_MAX IS NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MAX != :NEW.NBR_RSRC_MA_AGE_MAX))        OR
   ((:OLD.NBR_RSRC_MA_AGE_MIN IS NULL AND :NEW.NBR_RSRC_MA_AGE_MIN IS NOT NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MIN IS NOT NULL AND :NEW.NBR_RSRC_MA_AGE_MIN IS NULL)   OR
   (:OLD.NBR_RSRC_MA_AGE_MIN != :NEW.NBR_RSRC_MA_AGE_MIN))
                    THEN
  :NEW.DT_CCL_UPDATE := SYSDATE;
END IF;

END IF;


  :NEW.DT_LAST_UPDATE := SYSDATE;
  :NEW.NM_RSRC_NAME_INDEX := SUBSTR(:NEW.NM_RESOURCE,0,2);
  --insert into table RESOURCE_HISTORY if field :new.IND_RSRC_WRITE_HIST is 'Y':
  IF NVL(:NEW.IND_RSRC_WRITE_HIST,'N') = 'Y' THEN

    -- SMS#97850: MR-075 Update home reimbursability status based on home license status.
    -- Changed to IV-E Reimbursable for the following status
    --AFA	Approved (Full) - Active
    --ASA	Approved (Special) - Active
    --FLG	Full Approval 30 Day Grace Period
    --FSG	Full (Special) Approval 30 Day Grace Period
    IF (:NEW.CD_RSRC_FA_HOME_STATUS IN ('AFA','ASA','FLG','FSG')) THEN
      -- If IV-E one day of the month then IVE the entire month
      -- Set reimbursable effective date to first of current month
      :NEW.IND_IVE_REIMBURSABLE := 'Y';
      :NEW.DT_REIMBURSABLE_EFFECTIVE := TRUNC(SYSDATE, 'MM');
      -- Set reimbursable end date to max date
      :NEW.DT_REIMBURSABLE_END := TO_DATE('12/31/4712', 'MM/DD/YYYY');
    ELSIF (:NEW.CD_RSRC_FA_HOME_STATUS IN ('APP','AUN','CSD','INQ','PCL','PUN','WTL')) THEN
      -- Changed to IV-B Reimbursable for the following status
      --APP	Applicant (Pre-Service Training)
      --AUN	Unapproved
      --CSD	Closed
      --INQ	Inquiry
      --PCL	Pending Closure
      --PUN	Pending Unapprove
      --WTL	Waitlist
      :NEW.IND_IVE_REIMBURSABLE := 'N';

      IF TRUNC(SYSDATE) = TRUNC(SYSDATE, 'MM') THEN
        -- IV-B on the first of the month
        -- Set reimbursable effective date to first of current month
        :NEW.DT_REIMBURSABLE_EFFECTIVE := TRUNC(SYSDATE, 'MM');
      ELSE
        -- IV-B after the first of the month
        -- Set reimbursable effective date to first of next month
        :NEW.DT_REIMBURSABLE_EFFECTIVE := ADD_MONTHS(TRUNC(SYSDATE, 'MM'), 1);
      END IF;

      -- Set reimbursable end date to max date
      :NEW.DT_REIMBURSABLE_END := TO_DATE('12/31/4712', 'MM/DD/YYYY');
      
    ELSIF (:NEW.CD_RSRC_FA_HOME_STATUS IN ('PFA', 'PFG', 'PSA', 'PSG')) THEN
      -- Keep previous reimbursability status and dates ,if any, if new fa home status is the following
      --PFA	Pending Full Approval
      --PFG	Pending Full Approval 30 Day Grace Period
      --PSA	Pending Special Approval
      --PSG	Pending Full (Special) Approval 30 Day Grace Period
      :NEW.IND_IVE_REIMBURSABLE := :OLD.IND_IVE_REIMBURSABLE;
      :NEW.DT_REIMBURSABLE_EFFECTIVE := :OLD.DT_REIMBURSABLE_EFFECTIVE;
      :NEW.DT_REIMBURSABLE_END := :OLD.DT_REIMBURSABLE_END; 
    --ELSE
     -- no fa home status therefore resource is not a placement home, do not set reimbursability since it is not applicable
    END IF;

  --dbms_output.put_line('0');
  -- 1st: set END DATE of previous record:
  -- 2nd: SMS#97850: MR-075 Set RH.DT_REIMBURSABLE_END of previous record to :NEW.DT_REIMBURSABLE_EFFECTIVE,
  --           if previous record RH.DT_REIMBURSABLE_EFFECTIVE is not null. However, if previous record 
  --           RH.DT_REIMBURSABLE_EFFECTIVE is a future date, 
  --           set RH.DT_REIMBURSABLE_END to same RH.DT_REIMBURSABLE_EFFECTIVE date.
  --      If previous record RH.DT_REIMBURSABLE_EFFECTIVE is null, leave RH.DT_REIMBURSABLE_END as null.
  UPDATE RESOURCE_HISTORY  RH
  SET    RH.DT_RSHS_END            = :NEW.DT_LAST_UPDATE,
         RH.DT_REIMBURSABLE_END    = NVL2(RH.DT_REIMBURSABLE_EFFECTIVE, 
                                          DECODE(GREATEST(RH.DT_REIMBURSABLE_EFFECTIVE, TRUNC(SYSDATE)), 
                                                RH.DT_REIMBURSABLE_EFFECTIVE, RH.DT_REIMBURSABLE_EFFECTIVE,
                                                :NEW.DT_REIMBURSABLE_EFFECTIVE),  
                                          NULL)
  WHERE  RH.ID_RESOURCE            = :NEW.ID_RESOURCE
  AND    RH.ID_RESOURCE_HISTORY  =
    (SELECT MAX(RH2.ID_RESOURCE_HISTORY)
    FROM   RESOURCE_HISTORY RH2
    WHERE  RH2.ID_RESOURCE = :NEW.ID_RESOURCE
    AND    RH2.DT_RSHS_END = to_date('12/31/4712', 'mm/dd/yyyy'));

  -- now insert a new record into RESOURCE_HISTORY using data from the OLD record
  -- (not from the NEW record) of CAPS_RESOURCE.  This is different with that
  -- update trigger of table PERSON

  -- Get next sequence value:
  SELECT SEQ_RESOURCE_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;

  --dbms_output.put_line('1 '||TO_CHAR(dummy2) ||' ' ||
  --to_char(:new.dt_last_update) || ' ' ||
  --to_char(:new.id_resource) );
  INSERT INTO RESOURCE_HISTORY (
    ID_RESOURCE_HISTORY,
    DT_RSHS_EFFECTIVE,
    DT_RSHS_END,
    ID_RESOURCE,
    DT_LAST_UPDATE,
    ID_CASE,
    ADDR_RSHS_ST_LN_1,
    ADDR_RSHS_ST_LN_2,
    ADDR_RSHS_CITY,
    ADDR_RSHS_ATTN,
    CD_RSHS_STATE,
    ADDR_RSHS_ZIP,
    CD_RSHS_CNTY,
    NM_RSHS_RESOURCE,
    NM_RSHS_CONTACT,
    CD_RSHS_TYPE,
    CD_RSHS_HUB,
    CD_RSHS_CAMPUS_TYPE,
    NBR_RSHS_PHN,
    NBR_RSHS_CAMPUS_NBR,
    CD_RSHS_MAINTAINER,
    CD_RSHS_SCH_DIST,
    CD_RSHS_OWNERSHIP,
    CD_RSHS_STATUS,
    NM_RSHS_LAST_UPDATE,
    IND_RSHS_TRANSPORT,
    CD_RSHS_FACIL_TYPE,
    NBR_RSHS_FACIL_ACCLAIM,
    CD_RSHS_CERT_BY,
    CD_RSHS_OPER_BY,
    CD_RSHS_SETTING,
    DT_RSHS_CERT,
    DT_RSHS_CLOSE,
    CD_RSHS_PAYMENT,
    NBR_RSHS_FACIL_CAPACITY,
    ID_RSHS_FA_HOME_STAGE,
    ID_RSHS_FA_HOME_EVENT,
    CD_RSHS_CATEGORY,
    CD_RSHS_ETHNICITY,
    CD_RSHS_LANGUAGE,
    CD_RSHS_MARITAL_STATUS,
    CD_RSHS_REGION,
    CD_RSHS_RELIGION,
    CD_RSHS_RESPITE,
    CD_RSHS_RECMND_REOPEN,
    CD_RSHS_FA_HOME_TYPE1,
    CD_RSHS_FA_HOME_TYPE2,
    CD_RSHS_FA_HOME_TYPE3,
    CD_RSHS_FA_HOME_TYPE4,
    CD_RSHS_FA_HOME_TYPE5,
    CD_RSHS_FA_HOME_TYPE6,
    CD_RSHS_FA_HOME_TYPE7,
    CD_RSHS_MHMR_COMP_CODE,
    CD_RSHS_INVOL_CLOSURE,
    CD_RSHS_CLOSURE_RSN,
    CD_RSHS_FA_HOME_STATUS,
    DT_RSHS_MARRIAGE,
    IND_RSHS_CARE_PROV,
    IND_RSHS_EMERG_PLACE,
    IND_RSHS_INACTIVE,
    NBR_RSHS_INT_CHILDREN,
    NBR_RSHS_INT_FE_AGE_MAX,
    NBR_RSHS_INT_FE_AGE_MIN,
    NBR_RSHS_INT_MA_AGE_MAX,
    NBR_RSHS_INT_MA_AGE_MIN,
    NBR_RSHS_ANNUAL_INCOME,
    NBR_RSHS_FM_AGE_MAX,
    NBR_RSHS_FM_AGE_MIN,
    NBR_RSHS_MA_AGE_MAX,
    NBR_RSHS_MA_AGE_MIN,
    NBR_RSHS_PHONE_EXT,
    NBR_RSHS_VID,
    NBR_RSHS_OPEN_SLOTS,
    CD_RSHS_SOURCE_INQUIRY,
    TXT_RSHS_ADDR_CMNTS,
    TXT_RSHS_COMMENTS,
    DT_CCL_UPDATE,
    CD_RSRC_MHMR_SITE,
    IND_RSRC_CONTRACTED,
    NM_LEGAL,
    NM_RSRC_CONTACT_TITLE,
    NBR_RSRC_NTNL_PROVIDER,
    ADDR_RSRC_EMAIL,
    ADDR_RSRC_WEBSITE,
    CD_SCHOOL_TYPE,
    CD_PAYMENT_DELIVERY,
    TXT_SPEC_CERT,
    CD_EXCHANGE_STAT,
    IND_WAIVER,
    CD_SCH_DIST,
    CD_ELEM,
    CD_MIDDLE,
    CD_HIGH,
    DT_FOST_MANUAL,
    DT_FOST_BILL,
    IND_SPECIFIC_CHILD,
    DT_LIC_BEGIN,
    DT_LIC_END,
    TXT_CLOSURE_COMM,
    NDFCS_CERT_ENTITY,
    IND_RSRC_NONDFCS,
    IND_CURR_HM_STDY_EXSTS,
    IND_PREV_FAM_STDY_RQSTD,
    RSRC_OTH_SPC_CERTF,
    IND_AFTER_HOURS,
    TXT_HM_PRG_INTEREST,
    NBR_RSRC_CONTACT_PHN,
    NBR_RSRC_CONTACT_PHONE_EXT,
    IND_IVE_REIMBURSABLE,
    DT_REIMBURSABLE_EFFECTIVE,
    DT_REIMBURSABLE_END
  ) VALUES (
    dummy2,
    :NEW.DT_LAST_UPDATE,
    NULL,
    :NEW.ID_RESOURCE,
    SYSDATE,
    :NEW.ID_CASE,
    :NEW.ADDR_RSRC_ST_LN_1,
    :NEW.ADDR_RSRC_ST_LN_2,
    :NEW.ADDR_RSRC_CITY,
    :NEW.ADDR_RSRC_ATTN,
    :NEW.CD_RSRC_STATE,
    :NEW.ADDR_RSRC_ZIP,
    :NEW.CD_RSRC_CNTY,
    :NEW.NM_RESOURCE,
    :NEW.NM_RSRC_CONTACT,
    :NEW.CD_RSRC_TYPE,
    :NEW.CD_RSRC_HUB,
    :NEW.CD_RSRC_CAMPUS_TYPE,
    :NEW.NBR_RSRC_PHN,
    :NEW.NBR_RSRC_CAMPUS_NBR,
    :NEW.CD_RSRC_MAINTAINER,
    :NEW.CD_RSRC_SCH_DIST,
    :NEW.CD_RSRC_OWNERSHIP,
    :NEW.CD_RSRC_STATUS,
    :NEW.NM_RSRC_LAST_UPDATE,
    :NEW.IND_RSRC_TRANSPORT,
    :NEW.CD_RSRC_FACIL_TYPE,
    :NEW.NBR_RSRC_FACIL_ACCLAIM,
    :NEW.CD_RSRC_CERT_BY,
    :NEW.CD_RSRC_OPER_BY,
    :NEW.CD_RSRC_SETTING,
    :NEW.DT_RSRC_CERT,
    :NEW.DT_RSRC_CLOSE,
    :NEW.CD_RSRC_PAYMENT,
    :NEW.NBR_RSRC_FACIL_CAPACITY,
    :NEW.ID_RSRC_FA_HOME_STAGE,
    :NEW.ID_RSRC_FA_HOME_EVENT,
    :NEW.CD_RSRC_CATEGORY,
    :NEW.CD_RSRC_ETHNICITY,
    :NEW.CD_RSRC_LANGUAGE,
    :NEW.CD_RSRC_MARITAL_STATUS,
    :NEW.CD_RSRC_REGION,
    :NEW.CD_RSRC_RELIGION,
    :NEW.CD_RSRC_RESPITE,
    :NEW.CD_RSRC_RECMND_REOPEN,
    :NEW.CD_RSRC_FA_HOME_TYPE_1,
    :NEW.CD_RSRC_FA_HOME_TYPE_2,
    :NEW.CD_RSRC_FA_HOME_TYPE_3,
    :NEW.CD_RSRC_FA_HOME_TYPE_4,
    :NEW.CD_RSRC_FA_HOME_TYPE_5,
    :NEW.CD_RSRC_FA_HOME_TYPE_6,
    :NEW.CD_RSRC_FA_HOME_TYPE_7,
    :NEW.CD_RSRC_MHMR_COMP_CODE,
    :NEW.CD_RSRC_INVOL_CLOSURE,
    :NEW.CD_RSRC_CLOSURE_RSN,
    :NEW.CD_RSRC_FA_HOME_STATUS,
    :NEW.DT_RSRC_MARRIAGE,
    :NEW.IND_RSRC_CARE_PROV,
    :NEW.IND_RSRC_EMERG_PLACE,
    :NEW.IND_RSRC_INACTIVE,
    :NEW.NBR_RSRC_INT_CHILDREN,
    :NEW.NBR_RSRC_INT_FE_AGE_MAX,
    :NEW.NBR_RSRC_INT_FE_AGE_MIN,
    :NEW.NBR_RSRC_INT_MA_AGE_MAX,
    :NEW.NBR_RSRC_INT_MA_AGE_MIN,
    :NEW.NBR_RSRC_ANNUAL_INCOME,
    :NEW.NBR_RSRC_FM_AGE_MAX,
    :NEW.NBR_RSRC_FM_AGE_MIN,
    :NEW.NBR_RSRC_MA_AGE_MAX,
    :NEW.NBR_RSRC_MA_AGE_MIN,
    :NEW.NBR_RSRC_PHONE_EXT,
    :NEW.NBR_RSRC_VID,
    :NEW.NBR_RSRC_OPEN_SLOTS,
    :NEW.CD_RSRC_SOURCE_INQUIRY,
    :NEW.TXT_RSRC_ADDR_CMNTS,
    :NEW.TXT_RSRC_COMMENTS,
    :NEW.DT_CCL_UPDATE,
    :NEW.CD_RSRC_MHMR_SITE,
    :NEW.IND_RSRC_CONTRACTED,
    :NEW.NM_LEGAL,
    :NEW.NM_RSRC_CONTACT_TITLE,
    :NEW.NBR_RSRC_NTNL_PROVIDER,
    :NEW.ADDR_RSRC_EMAIL,
    :NEW.ADDR_RSRC_WEBSITE,
    :NEW.CD_SCHOOL_TYPE,
    :NEW.CD_PAYMENT_DELIVERY,
    :NEW.TXT_SPEC_CERT,
    :NEW.CD_EXCHANGE_STAT,
    :NEW.IND_WAIVER,
    :NEW.CD_SCH_DIST,
    :NEW.CD_ELEM,
    :NEW.CD_MIDDLE,
    :NEW.CD_HIGH,
    :NEW.DT_FOST_MANUAL,
    :NEW.DT_FOST_BILL,
    :NEW.IND_SPECIFIC_CHILD,
    :NEW.DT_LIC_BEGIN,
    :NEW.DT_LIC_END,
    :NEW.TXT_CLOSURE_COMM,
    :New.NDFCS_CERT_ENTITY,
    :New.IND_RSRC_NONDFCS,
    :New.IND_CURR_HM_STDY_EXSTS,
    :New.IND_PREV_FAM_STDY_RQSTD,
    :New.RSRC_OTH_SPC_CERTF,
    :New.IND_AFTER_HOURS,
    :New.TXT_HM_PRG_INTEREST,
    :New.NBR_RSRC_CONTACT_PHN,
    :New.NBR_RSRC_CONTACT_PHONE_EXT,
    :NEW.IND_IVE_REIMBURSABLE,
    :NEW.DT_REIMBURSABLE_EFFECTIVE,
    :NEW.DT_REIMBURSABLE_END
  );
  END IF;

END;
/




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (975, 'SacwisRev4', 'Release 4.2 - DBCR 16086');

commit;


