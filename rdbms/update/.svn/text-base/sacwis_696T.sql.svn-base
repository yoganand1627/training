--STGAP00015720 - Release(3.5) Report: Overdue Healthchecks: new table and views

--Report: Cases with Overdue Healthchecks (Kenny A)
-- Adding table Kenny_A_Service to hold Kenny A specific health services
-- Adding function age_in_month() to calculate person's age in months at any date from DOB to simplify report's logic.
-- Adding view Kenny_A_View to hold information about the foster care case, primary child, and their last visit.
-- Adding view Kenny_A_Service_Due as the top layer of Kenny_A_View to calculate next due date for each service type based on Kenny A's rule.

  CREATE OR REPLACE VIEW CAPS.KENNY_A_VIEW (CD_REGION, CD_STAGE_CNTY, ID_CASE, ID_STAGE, ID_PERSON_CHILD, NM_CHILD, DT_ENTERED_CARE, DOB_CHILD, SERVICE, DT_LAST_APPT, ID_CM, ID_SUP, NM_CM, NM_SUP, NBR_UNIT) AS 
  SELECT DISTINCT STAGE_CHILD.CD_STAGE_REGION, STAGE_CHILD.CD_STAGE_CNTY, STAGE_CHILD.ID_CASE, STAGE_CHILD.ID_STAGE,
    PERSON_ENC_CHILD.ID_PERSON child_id, 
    PERSON_ENC_CHILD.NM_PERSON_FULL child_name, 
    (NVL((select max(max_cr.dt_removal) from cnsrvtrshp_removal max_cr where max_cr.id_case =  STAGE_PERSON_LINK_CHILD.ID_CASE  and max_cr.id_victim =  STAGE_PERSON_LINK_CHILD.ID_PERSON ),  STAGE_CHILD.DT_STAGE_START))
    date_entered_care, 
    PERSON_ENC_CHILD.DT_PERSON_BIRTH CHILD_DOB, 
    (DECODE (  CT_HEALTH_RSN.CODE , 'EPS', 'EPSDT', 'MSC', 'EPSDT',  'DSC', 'DENTAL','DAA', 'DENTAL', 'PHL', 'PSYCHOLOGICAL', 'DEA', 'DEVELOPMENTAL'))
    service, 
    (SELECT  (max( PROFESSIONAL_ASSMT00.DT_PROF_ASSMT_APPT ))  FROM  PROFESSIONAL_ASSMT PROFESSIONAL_ASSMT00 WHERE DECODE ( CT_HEALTH_RSN.CODE , 'EPS', 'EPSDT', 'MSC', 'EPSDT',  'DSC', 'DENTAL','DAA', 'DENTAL', 'PHL', 'PSYCHOLOGICAL', 'DEA', 'DEVELOPMENTAL') = DECODE (  PROFESSIONAL_ASSMT00.CD_PROF_ASSMT_APPT_RSN , 'EPS', 'EPSDT', 'MSC', 'EPSDT',  'DSC', 'DENTAL','DAA', 'DENTAL', 'PHL', 'PSYCHOLOGICAL', 'DEA', 'DEVELOPMENTAL') AND  PROFESSIONAL_ASSMT00.ID_PERSON_PRINCIPAL = STAGE_PERSON_LINK_CHILD.ID_PERSON AND  PROFESSIONAL_ASSMT00.ID_CASE = STAGE_PERSON_LINK_CHILD.ID_CASE)
    date_last_appt, 
    PERSON_ENC_CM.ID_PERSON CM_ID, 
    PERSON_ENC_SUP.ID_PERSON Supervisor_ID,
    PERSON_ENC_CM.NM_PERSON_FULL CM, 
    PERSON_ENC_SUP.NM_PERSON_FULL Supervisor,
    UNIT_CM.NBR_UNIT   unit_num
 FROM 
    PERSON PERSON_ENC_CHILD, 
    PERSON PERSON_ENC_CM, 
    PERSON PERSON_ENC_SUP, 
    STAGE STAGE_CHILD, 
    STAGE_PERSON_LINK STAGE_PERSON_LINK_CHILD, 
    STAGE_PERSON_LINK STAGE_PERSON_LINK_CM, 
    UNIT UNIT_CM, 
    CODES_TABLES CT_HEALTH_RSN
WHERE
    STAGE_PERSON_LINK_CHILD.ID_STAGE = STAGE_CHILD.ID_STAGE  AND 
    STAGE_PERSON_LINK_CM.ID_STAGE = STAGE_CHILD.ID_STAGE  AND 
    STAGE_CHILD.ID_UNIT = UNIT_CM.ID_UNIT  AND 
    STAGE_PERSON_LINK_CHILD.ID_PERSON = PERSON_ENC_CHILD.ID_PERSON  AND 
    PERSON_ENC_CM.ID_PERSON = STAGE_PERSON_LINK_CM.ID_PERSON  AND 
    PERSON_ENC_SUP.ID_PERSON = UNIT_CM.ID_PERSON  AND 
    STAGE_CHILD.CD_STAGE IN ('ADO','SUB') AND 
    STAGE_CHILD.DT_STAGE_CLOSE IS NULL  AND 
    STAGE_CHILD.ID_STAGE = 
      (SELECT MAX(S1.ID_STAGE) FROM STAGE S1, STAGE_PERSON_LINK SPL1 WHERE S1.DT_STAGE_START = 
        (SELECT  (max( S2.DT_STAGE_START ))  FROM  STAGE S2,  STAGE_PERSON_LINK SPL2 
        WHERE S2.ID_STAGE = SPL2.ID_STAGE
        AND  S2.CD_STAGE IN ('ADO','SUB') AND  S2.DT_STAGE_CLOSE IS NULL  
        AND  SPL2.CD_STAGE_PERS_ROLE = 'PC' 
        AND  SPL2.ID_CASE = SPL1.ID_CASE 
        AND  SPL2.ID_PERSON = SPL1.ID_PERSON)
      AND S1.ID_STAGE = SPL1.ID_STAGE
      AND S1.CD_STAGE IN ('ADO','SUB') AND  S1.DT_STAGE_CLOSE IS NULL 
      AND SPL1.CD_STAGE_PERS_ROLE = 'PC'
      AND S1.ID_CASE = STAGE_PERSON_LINK_CHILD.ID_CASE
      AND SPL1.ID_PERSON = STAGE_PERSON_LINK_CHILD.ID_PERSON
      ) AND 
    STAGE_PERSON_LINK_CHILD.CD_STAGE_PERS_ROLE = 'PC' AND 
    (PERSON_ENC_CHILD.CD_PERSON_STATUS IS NULL OR PERSON_ENC_CHILD.CD_PERSON_STATUS <> 'M') AND -- exclude merged person
    EXISTS (SELECT 1 FROM LEGAL_STATUS_VIEW LSV WHERE LSV.ID_CASE =  STAGE_PERSON_LINK_CHILD.ID_CASE AND LSV.ID_PERSON =  STAGE_PERSON_LINK_CHILD.ID_PERSON AND LSV.in_dfcs_custody = 'Y' and LSV.dt_legal_stat_end > sysdate) AND 
    CT_HEALTH_RSN.CODE_TYPE = 'CARSAPPT' AND 
    CT_HEALTH_RSN.CODE IN ('EPS', 'MSC',  'DSC', 'DAA',  'PHL', 'DEA') AND 
    STAGE_PERSON_LINK_CM.CD_STAGE_PERS_ROLE = 'PR'
    AND     (
    (CT_HEALTH_RSN.CODE IN ('EPS', 'MSC',  'DSC', 'DAA') AND add_months( PERSON_ENC_CHILD.DT_PERSON_BIRTH , 12*18) > sysdate) OR -- EPSDT AND DENTAL REQUIRED FOR ALL UNDER 18
    (CT_HEALTH_RSN.CODE IN ('PHL') AND add_months( PERSON_ENC_CHILD.DT_PERSON_BIRTH , 12*4) <= sysdate AND add_months( PERSON_ENC_CHILD.DT_PERSON_BIRTH , 12*18) > sysdate) OR --PSY REQUIRED FOR ALL BETWEEN 4 AND UNDER 18
    (CT_HEALTH_RSN.CODE IN ('DEA') AND add_months( PERSON_ENC_CHILD.DT_PERSON_BIRTH , 12*4) > sysdate) -- DEVELOPMENTAL REQUIRED FOR ALL UNDER 4
    ) 
;
grant select on CAPS.KENNY_A_VIEW to operator,capson,capsbat,ops$datafix,shinesdm;    
COMMENT ON TABLE CAPS.KENNY_A_VIEW IS 'Listing of all foster care children, currently in DFCS custody, with the most recent healthcheck date for EPDST, Dental, Developmental and Psycholigical services. Date displays null if the child did not have healthcheck in this foster care period.';
COMMENT ON COLUMN CAPS.KENNY_A_VIEW.ID_STAGE IS 'The most recent foster care stage for the current period. It is not necessarily the stage where the most recent healthcheck recorded in.';
COMMENT ON COLUMN CAPS.KENNY_A_VIEW.dt_entered_care IS 'The last custody removal date for this current foster care period (in the case) or stage start date of the most recently opened active foster care stage (in the case) if there is no custody removal event.';
COMMENT ON COLUMN CAPS.KENNY_A_VIEW.dt_last_appt IS 'The last healthcheck date in the case.';
COMMENT ON COLUMN CAPS.KENNY_A_VIEW.service IS 'EPSDT includes EPSDT/GA Health Check or Medical Screen, DENTAL - Dental Screen or Dental 6 Mo. Exm/Cl, PSYCHOLOGICAL - Psychological, DEVELOPMENTAL - Developmental Assessment or Developmental Screen.';

-- Static table to store Kenny A's age limit and interval months between healthchecks

create table caps.kenny_a_service
(nm_service varchar2(20) not null,
nbr_age_group number(1,0),
nbr_interval_months number(2,0),
nbr_min_age_months_initial number(6, 2) not null,
nbr_max_age_months_initial number(6, 2) not null,
nbr_min_age_months_ongoing number(6, 2) not null,
nbr_RT number(2, 0) not null,
txt_condition_desc varchar2(500)) tablespace data01;

grant select on caps.kenny_a_service to capson,capsbat,ops$datafix, operator,shinesdm;

insert into caps.kenny_a_service values ('EPSDT', 1, 2, 0.00, 6.00, 0.00, 10, '0.00mons < age <= 6mons');
insert into caps.kenny_a_service values ('EPSDT', 2, 3, 6.00, 18.00, 6.00, 10, '6mons < age <= 18mons');
insert into caps.kenny_a_service values ('EPSDT', 3, 6, 18.00, 71.99, 18.00, 10, '18mons < age < 6years. Equivalent: 18m < age <= 71.99m. Taken off .01 from max age in months to normalize the inequalities in all rows as lower < age <= upper. Dates used in Kenny A report calculation have time component removed so the smallest difference is one day or 0.03 of a month. A child is yonger than 72 months is also younger than 71.99 months for Kenny A report.
');
insert into caps.kenny_a_service values ('EPSDT', 4, 12, 71.99, 215.99, 71.99, 10, '6years <= age < 18years. Equivalent: 71.99m < age <= 215.99m');
insert into caps.kenny_a_service values ('DENTAL', NULL, 12, 0.00, 215.99, 35.99, 10, '0years <= age < 18years. Equivalent: 0.00m < age <= 215.99m. For ongoing service: 35.99m < age <= 215.99');
insert into caps.kenny_a_service values ('PSYCHOLOGICAL', NULL, 24, 47.99, 215.99, 47.99, 30, '4years <= age < 18years. Equivalent: 47.99m <age <= 215.99m');
insert into caps.kenny_a_service values ('DEVELOPMENTAL', NULL, NULL, 0.00, 47.99, 0.00, 30, '0mons < age < 4years. Equivalent: 0m < age <= 47.99m');

COMMENT ON TABLE CAPS.kenny_a_service IS 'Kenny A health service mapping, required age range and interval in months between health checks.';
COMMENT ON COLUMN CAPS.kenny_a_service.nm_service IS 'Kenny A Ongoing Services/Healthchecks - As defined: EPSDT includes EPS, MSC; DENTAL includes DSC, DAA; PSYCHOLOGICAL includes PHL.';
COMMENT ON COLUMN CAPS.kenny_a_service.nbr_age_group IS 'Child''s age groups where specific ongoing service is required for each number of months (interval).';
COMMENT ON COLUMN CAPS.kenny_a_service.nbr_interval_months IS 'The x number of months that an ongoing service is required for every x months.';
COMMENT ON COLUMN CAPS.kenny_a_service.nbr_max_age_months_initial IS 'Max age in months for initial healthcheck.';
COMMENT ON COLUMN CAPS.kenny_a_service.nbr_min_age_months_initial IS 'Min age in months for initial healthcheck.';
COMMENT ON COLUMN CAPS.kenny_a_service.nbr_min_age_months_ongoing IS 'Min age in months for ongoing healthcheck. Except for Dental, this is the same with the initial healthcheck age requirement.';
COMMENT ON COLUMN CAPS.kenny_a_service.nbr_RT IS 'The response time window in days for which case manager is allowed in providing initial healthcheck to client.';
COMMENT ON COLUMN CAPS.kenny_a_service.txt_condition_desc IS 'Age condition for each age group.';

-- Age in Months functions
/
create or replace FUNCTION CAPS.AGE_IN_MONTHS 
     (v_a_date  IN DATE,
      v_dob_date    IN DATE)
RETURN NUMBER
IS
-- Simple function to calculate age as a number months given a date (first parameter) and dob (second parameter)
-- Both parameters expected to be not null but no validation coded.
  Age_Months  NUMBER := 0;
BEGIN 
  Select months_between(v_a_date, v_dob_date) into Age_Months from Dual;
  RETURN Age_Months;
END AGE_IN_MONTHS;
/

grant execute on caps.age_in_months to capson,capsbat,shinesdm;
-- KENNY_A_SERVICE_DUE_VIEW
CREATE OR REPLACE VIEW CAPS.KENNY_A_SERVICE_DUE_VIEW 
  (CD_REGION, CD_STAGE_CNTY, ID_CASE, ID_STAGE, ID_PERSON_CHILD, NM_CHILD, DT_ENTERED_CARE, DOB_CHILD, AGE_MONS, SERVICE_DUE, 
  AGE_GROUP, INTERVAL_MONS, DT_LAST_APPT, FIXED_NEXT_DUE, MODIFIED_NEXT_DUE,
  ID_CM, ID_SUP, NM_CM, NM_SUP, NBR_UNIT) AS 
  select distinct 
  CD_REGION, CD_STAGE_CNTY, ID_CASE, ID_STAGE, ID_PERSON_CHILD, NM_CHILD, dT_entered_care, DOB_CHILD, age_in_months(sysdate, DOB_CHILD),
  (case when (k.dt_last_appt is null or dt_last_appt < dt_entered_care) then service || ' - Initial' 
        when  not(k.service = 'DENTAL' -- Dental-Ongoing applies to children age 3+
              and age_in_months(sysdate, DOB_CHILD) <= (select nbr_min_age_months_ongoing  from kenny_a_service sdental 
                                                        where nm_service = 'DENTAL' ) ) 
        then service || ' - Ongoing'
  end) service_due,                                                       
  nbr_age_group ag, nbr_interval_months interval_m,
  dT_last_appt, 
  (add_months(NVL (dT_last_appt, dT_entered_care), nbr_interval_months)) fixed_dt_next_due,
  (case when (k.dt_last_appt is null or dt_last_appt < dt_entered_care)  -- child missed the initial healthcheck, 
              then dT_entered_care + s.nbr_RT                            -- set next due to be the date entered care + response window
        when s.nm_service = 'EPSDT' and
             age_in_months(add_months(NVL (dT_last_appt, dT_entered_care), nbr_interval_months), DOB_child) > s.nbr_max_age_months_initial-- child in next age group at next due
        then                                                                                             -- add the months required for next age group in calculating actual next due
            add_months(NVL (dT_last_appt, dT_entered_care), (select snext.nbr_interval_months from kenny_a_service snext
                                                             where snext.nbr_age_group = s.nbr_age_group+1 --and s.nbr_age_group <= 3
                                                             ) ) -- 4 is the last age group
        else add_months(NVL (dT_last_appt, dT_entered_care), nbr_interval_months) -- child still in current age group at next due date.
  end) modified_dt_next_due, -- over 18 at next due and developmental - ongoing will have null value due to interval is null, these should be excluded as they are not exceptions.
  ID_CM, ID_SUP, NM_CM, NM_SUP, NBR_UNIT
  from KENNY_A_VIEW K, kenny_a_service S
  where k.service=s.nm_service and 
  (age_in_months(sysdate, DOB_CHILD) > s.nbr_min_age_months_initial and 
  age_in_months(sysdate, DOB_CHILD) <= s.nbr_max_age_months_initial)
;
grant select on CAPS.KENNY_A_SERVICE_DUE_VIEW to capson,capsbat,ops$datafix, operator,shinesdm;
COMMENT ON TABLE CAPS.KENNY_A_SERVICE_DUE_VIEW IS 'Listing of foster care children eligible whose  Kenny A services are past due or coming due in 60 days.';
COMMENT ON COLUMN CAPS.KENNY_A_SERVICE_DUE_VIEW.AGE_MONS IS 'The child''s age in months';
COMMENT ON COLUMN CAPS.KENNY_A_SERVICE_DUE_VIEW.SERVICE_DUE IS 'The Kenny A service that was past due or is coming due in the next 60 days since the most recent check.';
COMMENT ON COLUMN CAPS.KENNY_A_SERVICE_DUE_VIEW.AGE_GROUP IS 'The require age group (expressed as age range in kenny_a_service view) for each type of Kenny A service.';
COMMENT ON COLUMN CAPS.KENNY_A_SERVICE_DUE_VIEW.INTERVAL_MONS IS 'The number of months between subsequent ongoing Kenny A services defined for each service and age range.';
COMMENT ON COLUMN CAPS.KENNY_A_SERVICE_DUE_VIEW.DT_LAST_APPT IS 'The date of the most recent Kenny A service was done. It is null if a service was never done for the child.';
COMMENT ON COLUMN CAPS.KENNY_A_SERVICE_DUE_VIEW.FIXED_NEXT_DUE IS 'The date a service is due next assuming the child is still within curren age group. It is calculated by adding the current age group''s interval months to the date last appt (or the date entered care where date last appt is null).';
COMMENT ON COLUMN CAPS.KENNY_A_SERVICE_DUE_VIEW.MODIFIED_NEXT_DUE IS 'The date a service is due next. This takes into account whether the child will move to the next age group at the time of the fixed next due date.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (697, 'SacwisRev3', 'Release 3.5 - DBCR 15720');

commit;

