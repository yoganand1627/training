--STGAP00011833 - Create STAGE VIEW to support OBIEE development

--Note: no imapct to ado model


--The attached SQL creates the STAGE VIEW, a short list of columns for all stages
--that will be used to support multiple charts for the OBIEE reporting tool.  This
-- view should be added to the SAC30SYS schema to support the development effort.


--A data fix will be submitted later to push this view to production.

CREATE OR REPLACE FORCE VIEW CAPS.STAGE_VIEW ("STAGE_TYPE", "ID_STAGE", "ID_CASE", "DT_STAGE_START", "DT_STAGE_CLOSE", "CD_STAGE_REGION", "CD_STAGE_CNTY", 
"NBR_UNIT", "CMID", "SUPID", "INTAKE_DISPOSITION", "INTAKE_REPORT_DATE") AS 
select *
from(
select 
'Intake' as stage_type,
stage.ID_STAGE,
stage.ID_CASE,
trunc(stage.DT_STAGE_START) as DT_STAGE_START,
trunc(case
when incoming_detail.CD_INCMG_STATUS = 'CLD' 
and stage.DT_STAGE_CLOSE is null then stage.DT_STAGE_START
else stage.DT_STAGE_CLOSE
end) as DT_STAGE_CLOSE,
NVL(stage.CD_STAGE_REGION,incoming_detail.CD_INCMG_REGION) as CD_STAGE_REGION,
NVL(stage.CD_STAGE_CNTY, incoming_detail.CD_INCOMING_WORKER_COUNTY) as CD_STAGE_CNTY,
unit.NBR_UNIT,
stage_person_link.ID_PERSON as CMID, --ID PERSON of last primary casemanager assigned.
unit.ID_PERSON as SUPID, --ID Person of supervisor assigned to unit.
(case 
when incoming_detail.CD_INCOMING_DISPOSITION IN ('SCO','SCR') then 'Screened Out'
when incoming_detail.CD_INCOMING_DISPOSITION IN ('ACA') then 'Investigation'
when incoming_detail.CD_INCOMING_DISPOSITION IN ('DIV') then 'Diversion'
when incoming_detail.CD_INCOMING_DISPOSITION IN ('OIE') then 'Opened In Error'
when incoming_detail.CD_INCOMING_DISPOSITION IN ('IC') then 'ICPC Reguest'
when incoming_detail.CD_INCOMING_DISPOSITION IN ('PA') then 'PAD Payments'
when incoming_detail.CD_INCOMING_DISPOSITION IN ('PF') then 'PFC Payments'
when (incoming_detail.CD_INCOMING_DISPOSITION IN ('NI') 
or (incoming_detail.CD_INCOMING_DISPOSITION is null and incoming_detail.CD_NON_RSDNT_REQ_TYPE is not null)) then 'Non-Incident' 
else 'Undetermined'
end) as intake_disposition, 
trunc(incoming_detail.DT_INCOMING_CALL) as intake_report_date
from stage, 
stage_person_link, 
unit, 
incoming_detail
where stage.CD_STAGE = 'INT'
and stage_person_link.ID_STAGE = stage.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN ('PR','HP')
and stage.ID_UNIT = unit.ID_UNIT
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
and stage.ID_STAGE = incoming_detail.ID_STAGE
UNION
select 
'Investigation' as stage_type,
stage.ID_STAGE,
stage.ID_CASE,
trunc(stage.DT_STAGE_START) as DT_STAGE_START,
trunc(stage.DT_STAGE_CLOSE) as DT_STAGE_CLOSE,
stage.CD_STAGE_REGION,
stage.CD_STAGE_CNTY,
unit.NBR_UNIT,
stage_person_link.ID_PERSON as CMID, --ID PERSON of last primary casemanager assigned.
unit.ID_PERSON as SUPID, --ID Person of supervisor assigned to unit.
'' as intake_disposition,
trunc(cps_invst_detail.DT_CPS_INVST_DTL_INTAKE) as intake_report_date
from stage, 
stage_person_link, 
unit, 
cps_invst_detail
where stage.CD_STAGE = 'INV'
and stage_person_link.ID_STAGE = stage.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN ('PR','HP')
and stage.ID_UNIT = unit.ID_UNIT
and cps_invst_detail.ID_CPS_INVST_STAGE = stage.ID_STAGE
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
UNION
select 
'Ongoing' as stage_type,
stage.ID_STAGE,
stage.ID_CASE,
trunc(stage.DT_STAGE_START) as DT_STAGE_START,
trunc(stage.DT_STAGE_CLOSE) as DT_STAGE_CLOSE,
stage.CD_STAGE_REGION,
stage.CD_STAGE_CNTY,
unit.NBR_UNIT,
stage_person_link.ID_PERSON as CMID, --ID PERSON of last primary casemanager assigned.
unit.ID_PERSON as SUPID, --ID Person of supervisor assigned to unit.
'' as intake_disposition,
null as intake_report_date
from stage, 
stage_person_link, 
unit
where stage.CD_STAGE = 'FPR'
and stage_person_link.ID_STAGE = stage.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN ('PR','HP')
and stage.ID_UNIT = unit.ID_UNIT
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
UNION
select 
'Diversion' as stage_type,
stage.ID_STAGE,
stage.ID_CASE,
trunc(stage.DT_STAGE_START) as DT_STAGE_START,
trunc(stage.DT_STAGE_CLOSE) as DT_STAGE_CLOSE,
stage.CD_STAGE_REGION,
stage.CD_STAGE_CNTY,
unit.NBR_UNIT,
stage_person_link.ID_PERSON as CMID, --ID PERSON of last primary casemanager assigned.
unit.ID_PERSON as SUPID, --ID Person of supervisor assigned to unit.
'' as intake_disposition,
null as intake_report_date
from stage, 
stage_person_link, 
unit
where stage.CD_STAGE = 'DIV'
and stage_person_link.ID_STAGE = stage.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN ('PR','HP')
and stage.ID_UNIT = unit.ID_UNIT
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
UNION
select 
'Post Adoption' as stage_type,
stage.ID_STAGE,
stage.ID_CASE,
trunc(stage.DT_STAGE_START) as DT_STAGE_START,
trunc(stage.DT_STAGE_CLOSE) as DT_STAGE_CLOSE,
stage.CD_STAGE_REGION,
stage.CD_STAGE_CNTY,
unit.NBR_UNIT,
stage_person_link.ID_PERSON as CMID, --ID PERSON of last primary casemanager assigned.
unit.ID_PERSON as SUPID, --ID Person of supervisor assigned to unit.
'' as intake_disposition,
null as intake_report_date
from stage, 
stage_person_link, 
unit
where stage.CD_STAGE = 'PAD'
and stage_person_link.ID_STAGE = stage.ID_STAGE
and stage_person_link.CD_STAGE_PERS_ROLE IN ('PR','HP')
and stage.ID_UNIT = unit.ID_UNIT
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
UNION
select 
'Foster Care' as stage_type,
stage.ID_STAGE, 
stage.ID_CASE, 
trunc ((select min (stage.DT_STAGE_START)
    from stage_person_link, 
    stage
    where stage_person_link.CD_STAGE_PERS_ROLE = 'PC' --primary child
    and stage_person_link.id_stage = stage.id_stage
    and stage.CD_STAGE IN ('SUB','ADO')
    and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
    and exists (select *
                from legal_status_view
                where legal_status_view.IN_DFCS_CUSTODY = 'Y'
                and legal_status_view.ID_CASE = stage_person_link.ID_CASE  
                and legal_status_view.id_person = stage_person_link.id_person)
    and spl_primary_child.id_case = stage_person_link.ID_CASE 
    and spl_primary_child.id_person = stage_person_link.id_person
)) DT_STAGE_START, --the earliest stage start date of the child's multiple foster care stages on the case.
trunc(stage.DT_STAGE_CLOSE) as DT_STAGE_CLOSE,  
stage.CD_STAGE_REGION, 
stage.CD_STAGE_CNTY, 
unit.NBR_UNIT, 
spl_casemanager.ID_PERSON as CMID, --ID PERSON of last primary casemanager assigned.
unit.ID_PERSON as SUPID, --ID Person of supervisor assigned to unit.
'' as intake_disposition,
null as intake_report_date
from stage, 
stage_person_link spl_casemanager, 
stage_person_link spl_primary_child,
unit,
    (select max (stage_person_link.ID_STAGE) as id_stage, stage_person_link.id_case, stage_person_link.id_person
    from stage_person_link, 
    stage
    where stage_person_link.CD_STAGE_PERS_ROLE = 'PC' --primary child
    and stage_person_link.id_stage = stage.id_stage
    and stage.CD_STAGE IN ('SUB','ADO')
    and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
    and exists (select *
                from legal_status_view
                where legal_status_view.IN_DFCS_CUSTODY = 'Y'
                and legal_status_view.ID_CASE = stage_person_link.ID_CASE  
                and legal_status_view.id_person = stage_person_link.id_person)
    group by stage_person_link.id_case, stage_person_link.id_person
    ) last_foster_care_stage
where spl_casemanager.ID_STAGE = stage.ID_STAGE
and spl_casemanager.CD_STAGE_PERS_ROLE IN ('PR','HP')
and spl_primary_child.id_stage = stage.ID_stage
and spl_primary_child.CD_STAGE_PERS_ROLE = 'PC' -- primary child
and stage.ID_UNIT = unit.ID_UNIT
and stage.ID_STAGE = last_foster_care_stage.id_stage --this join limits the stage information to the most recent FCC or ADO stage for the child on the case.
and spl_primary_child.id_person = last_foster_care_stage.id_person --this join limits the stage information to the most recent FCC or ADO stage for the child on the case.
and spl_primary_child.id_case = last_foster_care_stage.id_case --this join limits the stage information to the most recent FCC or ADO stage for the child on the case.
) master_union;

grant insert,update,delete,select on caps.stage_view to capson,capsbat,ops$datafix;
grant select on caps.stage_view to operator;


--STGAP00011893 - Create view for codes table code_type = CSPECCIR

--Note:   no impact to ado model

--The code_type of CSPECCIR is used to decode the CD_SPCL_CIRCUMSTANCES on the INC
--OMING_DETAIL table.  This view will be used for the Investigations Allegations U
--DR to display the decoded value in the result set.

--A data fix will also be necessary for the 2.6 environment.

CREATE OR REPLACE VIEW CAPS.CSPECCIR (CODE,DECODE, DT_END) AS
SELECT CODE, DECODE, DT_END FROM CODES_TABLES WHERE CODE_TYPE='CSPECCIR';

grant insert,update,delete,select on caps.CSPECCIR to capson,capsbat,ops$datafix;
grant select on caps.CSPECCIR to operator;


--STGAP00011899 - Create codes_tables view for CLOCMAL code_type

--Note:  no impact to ado model

--Please create a new view of the CLOCMAL code_type for use with creating the investigation allegations UDR.

--A data fix for the 2.6 environment will be submitted as well to make this change in production.

CREATE OR REPLACE VIEW CAPS.CLOCMAL (CODE,DECODE, DT_END) AS
SELECT CODE, DECODE, DT_END FROM CODES_TABLES WHERE CODE_TYPE='CLOCMAL';

grant insert,update,delete,select on caps.CLOCMAL to capson,capsbat,ops$datafix;
grant select on caps.CLOCMAL to operator;


--STGAP00011916 - Create INVESTIGATION_ALLEGATIONS VIEW

--Note:  no impact to ado model

--The INVESTIGATION_ALLEGATIONS view attached should be created as a materialized
--view with an hourly run frequency.  The attached script creates this as a standard
-- view, so this will need to be updated slightly.

--In addition, this DBCR will need to be applied to 2.6 to support the OBIEE pilot
-- that occurs before release 3.0 goes live.

--Note, DBCRS STGAP00011899 and STGAP00011893 will affect this view.  This view should 
--not be run until after these other DBCRS have been executed.  Otherwise, th
--is view will throw errors.

--INVESTIGATION ALLEGATIONS - This is a population of alleged and substantiated victims of allegations on 
--investigation (INV) stages active at some point during the reporting period.  Details related to the overall investigation are 
--also provided for each victim record.

CREATE OR REPLACE FORCE VIEW CAPS.INVESTIGATION_ALLEGATIONS_MV1 (
"STAGE_REGION",
"STAGE_COUNTY",
"LAST_ASSIGNED_CM_ID",
--"LAST_ASSIGNED_CM_NAME",
"CASE_ID",
"STAGE_ID",
"STAGE_NAME",
"PRORGRESSED_FROM_DIV_STAGE",
"INTAKE_DATE",
"SPECIAL_INVESTIGATION_TYPE",
"SPECIAL_CIRCUMSTANCES_TYPE",  --uncomment when DBCR STGAP00011893 is completed
"INV_START_DATE",
"INV_CLOSED_DATE",
"PK_PERSON_ID",
"PK_ZIP_CODE",
"PK_MARITAL_STATUS",
"HAS_SIX_MONTH_RECURRENCE",
"INV_OPEN_TEN_DAY_DIV_ALL",
"INV_OPEN_TEN_DAY_DIV_TWELVE",
"MALTREATMENT_FINDING",
"OVERALL_RISK_FINDING",
"ALLEGATION_ID",
"VIC_ID",
"VIC_NAME",
"MALTREATOR_RELATIONSIHP",
"MALTREATMENT_LOCATION", --uncomment after DBCR STGAP00011899 is complete
"MALTREATMENT_DATE",
"MALTREATMENT_TYPE",
"MALTREATMENT_CODE",
"MALTREATMENT_DECODE",
"VIC_GENDER",
"VIC_DOB",
"VIC_RACE"
) AS 
select 
inner_main.STAGE_REGION,
inner_main.STAGE_COUNTY,
inner_main.LAST_ASSIGNED_CM_ID,
inner_main.CASE_ID,
inner_main.STAGE_ID,
inner_main.STAGE_NAME,
inner_main.PRORGRESSED_FROM_DIV_STAGE,
inner_main.INTAKE_DATE,
inner_main.SPECIAL_INVESTIGATION_TYPE,
inner_main.SPECIAL_CIRCUMSTANCES_TYPE, --uncomment when DBCR STGAP00011893 is completed
inner_main.INV_START_DATE,
inner_main.INV_CLOSED_DATE,
inner_main.PK_PERSON_ID,
inner_main.PK_ZIP_CODE,
inner_main.PK_MARITAL_STATUS,
inner_main.HAS_SIX_MONTH_RECURRENCE,
inner_main.INV_OPEN_TEN_DAY_DIV_ALL,
inner_main.INV_OPEN_TEN_DAY_DIV_TWELVE,
inner_main.MALTREATMENT_FINDING,
inner_main.OVERALL_RISK_FINDING,
inner_main.ALLEGATION_ID,
inner_main.VIC_ID,
inner_main.VIC_NAME,
inner_main.MALTREATOR_RELATIONSIHP,
inner_main.MALTREATMENT_LOCATION, --uncomment after DBCR STGAP00011899 is complete
inner_main.MALTREATMENT_DATE,
( case 
  when inner_main.MALTREATMENT_TYPE = 'O' then 'Other'
  when inner_main.MALTREATMENT_TYPE = 'E' then 'Emotional'
  when inner_main.MALTREATMENT_TYPE = 'P' then 'Physical'
  when inner_main.MALTREATMENT_TYPE = 'S' then 'Sexual'
  when inner_main.MALTREATMENT_TYPE = 'N' then 'Neglect'
  end
) as MALTREATMENT_TYPE,
inner_main.MALTREATMENT_CODE,
inner_main.MALTREATMENT_DECODE,
inner_main.VIC_GENDER,
inner_main.VIC_DOB,
inner_main.VIC_RACE
from(
select distinct
stage.cd_stage_region as STAGE_REGION,
stage.cd_stage_cnty as STAGE_COUNTY,
stage_person_link_cm.ID_PERSON as LAST_ASSIGNED_CM_ID,
stage.ID_CASE as CASE_ID,
stage.ID_STAGE as STAGE_ID,
stage.NM_STAGE as STAGE_NAME,
intake_details.PRORGRESSED_FROM_DIV_STAGE as PRORGRESSED_FROM_DIV_STAGE,
cps_invst_detail.DT_CPS_INVST_DTL_INTAKE as INTAKE_DATE,
CSPECREQ.DECODE as SPECIAL_INVESTIGATION_TYPE,
CSPECCIR.DECODE as SPECIAL_CIRCUMSTANCES_TYPE, --uncomment when DBCR STGAP00011893 is completed
stage.DT_STAGE_START as INV_START_DATE,
stage.DT_STAGE_CLOSE as INV_CLOSED_DATE,
primary_caretaker.ID_PERSON as PK_PERSON_ID,
(select person_address.ADDR_PERSON_ADDR_ZIP     
      from person_address, address_person_link
      where person_address.ID_PERSON_ADDR = address_person_link.ID_PERSON_ADDR
      and address_person_link.IND_PERS_ADDR_LINK_INVALID = 'N' -- must be a valid address
      and address_person_link.IND_PERS_ADDR_LINK_PRIMARY = 'Y' --must be the primary address
      and address_person_link.ID_PERSON = primary_caretaker.ID_PERSON --join to outer main query
      and address_person_link.ID_ADDR_PERSON_LINK = (select max(address_person_link2.ID_ADDR_PERSON_LINK)
                                                    from address_person_link address_person_link2 --most recent returns
                                                    where address_person_link2.IND_PERS_ADDR_LINK_INVALID = 'N' -- must be a valid address
                                                    and address_person_link2.IND_PERS_ADDR_LINK_PRIMARY = 'Y' --must be the primary address
                                                    and address_person_link.ID_PERSON = address_person_link2.id_person
                                                    and (address_person_link2.DT_PERS_ADDR_LINK_START <= stage.DT_STAGE_CLOSE or stage.DT_STAGE_CLOSE is null)
                                                    ) --returns most recent primary address  
) as PK_ZIP_CODE,
CMARSTAT.DECODE as PK_MARITAL_STATUS,
 (decode( ( select count(*) 
      from caps.cps_invst_detail cps_invst_detail2,
      caps.stage_person_link stage_person_link2, 
      caps.stage stage2
      where cps_invst_detail2.ID_CPS_INVST_STAGE = stage_person_link2.ID_STAGE
      and stage_person_link2.ID_stage = stage2.id_stage
       --These lines below are to be used to identify the alleged or substantiated victims on the investigation.
      and exists (select * 
            from allegation
            where allegation.ID_ALLEGATION_STAGE = stage_person_link2.ID_STAGE --joins to the outer query to identify only principals that were victims (alleged or substantiated)
            and allegation.ID_VICTIM = stage_person_link2.ID_PERSON --joins to the outer query to identify only principals that were victims (alleged or substantiated)
            and allegation.CD_ALLEG_DISPOSITION IN ('SUB') 
            )    
      AND cps_invst_detail2.cd_cps_invst_dtl_ovrll_disptn='SUB'
      and cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE <= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE --the previous intake must be before the current intake date.
      and add_months(cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE, 6) >= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE
      --the above line compares the two intake dates and returns results of incidents that occurred within the past 6 months
      and alleged_victim.ID_PERSON = stage_person_link2.ID_PERSON  --this joins the victim person ids
      and stage2.DT_STAGE_CLOSE is not null --this verifies that the previous investigation has also been closed.
      and stage.id_case <> stage2.id_case --this avoids double counting the investigation from the main query if the investigations were merged to the same case.
      ), 0, 'No', 'Yes')) as HAS_SIX_MONTH_RECURRENCE,
      (decode( ( select count(*) 
      from 
      stage_person_link div_stage_person_link, 
      stage div_stage
      where div_stage.id_stage = div_stage_person_link.ID_STAGE 
      and div_stage_person_link.cd_stage_pers_rel_int = 'PK'
      and div_stage.cd_stage = 'DIV'         
      and (cps_invst_detail.DT_CPS_INVST_DTL_INTAKE - div_stage.DT_STAGE_CLOSE) <= 10 -- the investigation must have begun within 10 days after the diversion closure.
      and primary_caretaker.ID_PERSON = div_stage_person_link.ID_PERSON  --this is a join to the primary caretaker diversion in the master query
      and div_stage.id_case <> stage.id_case --this avoids counting the same incident if the case manager progressed the diversion to investigation after 10 days.    
      ), 0, 'No', 'Yes')) as INV_OPEN_TEN_DAY_DIV_ALL, 
      (decode( ( select count(*) 
      from 
      stage_person_link div_stage_person_link, 
      stage div_stage
      where div_stage.id_stage = div_stage_person_link.ID_STAGE 
      and div_stage_person_link.cd_stage_pers_rel_int = 'PK'
      and div_stage.cd_stage = 'DIV'         
      and (cps_invst_detail.DT_CPS_INVST_DTL_INTAKE - div_stage.DT_STAGE_CLOSE) <= 10 -- the investigation must have begun within 10 days after the diversion closure.
      and primary_caretaker.ID_PERSON = div_stage_person_link.ID_PERSON  --this is a join to the primary caretaker diversion in the master query
      and add_months(div_stage.DT_STAGE_START, 12) >= sysdate -- the diversion stage was opened within the past 12 months.
      and div_stage.id_case <> stage.id_case --this avoids counting the same incident if the case manager progressed the diversion to investigation after 10 days.    
      ), 0, 'No', 'Yes')) as INV_OPEN_TEN_DAY_DIV_TWELVE,
CDISPSTN.DECODE as MALTREATMENT_FINDING, 
CCRSKFND.DECODE as OVERALL_RISK_FINDING,
allegation.ID_ALLEGATION as ALLEGATION_ID,
alleged_victim.ID_PERSON as VIC_ID,
alleged_victim.NM_PERSON_FULL as VIC_NAME,
CRPTRINT.DECODE as MALTREATOR_RELATIONSIHP,
CLOCMAL.DECODE as MALTREATMENT_LOCATION, --uncomment after DBCR STGAP00011899 is complete
allegation.DT_ALLEGED_INCIDENT as MALTREATMENT_DATE,
substr(CMALCODE.CODE,1,1) as MALTREATMENT_TYPE,
allegation.CD_ALLEG_TYPE as MALTREATMENT_CODE,
CMALCODE.COMBINED as MALTREATMENT_DECODE,  
CSEX.DECODE as VIC_GENDER,
alleged_victim.DT_PERSON_BIRTH as VIC_DOB,
CETHNIC.DECODE as VIC_RACE
from stage, 
stage_person_link, 
stage_person_link stage_person_link_cm,
person primary_caretaker, 
person alleged_victim,
cps_invst_detail, 
allegation, 
stage_link,
CSPECREQ,
CSPECCIR, --uncomment when DBCR STGAP00011893 is completed
CMARSTAT,
CDISPSTN,
CCRSKFND,
CRPTRINT,
CLOCMAL,  --uncomment after DBCR STGAP00011899 is complete
CSEX,
CETHNIC,
  (select codes_tables.CODE, codes_tables.DECODE, (codes_tables.CODE ||'/'|| codes_tables.DECODE) as COMBINED 
  from codes_tables
  where codes_tables.CODE_TYPE = 'CMALCODE'
   ) CMALCODE,
  (select 
  intake_stage.ID_STAGE as id_int_stage,
    ( select div_stage.id_stage
      from stage_link, stage div_stage
      where div_stage.cd_stage IN ('DIV')
      and stage_link.ID_STAGE = div_stage.id_stage
      and intake_stage.id_stage = stage_link.ID_PRIOR_STAGE
    ) as id_div_stage,
  incoming_detail.CD_SPCL_CIRCUMSTANCES, 
  incoming_detail.CD_SPCL_INVSTGTN, 
  intake_stage.CD_STAGE_CURR_PRIORITY, 
  ( case 
  when (select div_stage.id_stage
        from stage div_stage, stage_link
        where div_stage.cd_stage IN ('DIV')
        and stage_link.ID_STAGE = div_stage.id_stage
        and intake_stage.id_stage = stage_link.ID_PRIOR_STAGE
      ) is null then 'No'
  else 'Yes'
  end) as PRORGRESSED_FROM_DIV_STAGE  
  from incoming_detail, 
  stage intake_stage 
  where incoming_detail.ID_STAGE = intake_stage.ID_STAGE
  ) intake_details 
where stage.CD_STAGE = 'INV'
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
and stage.ID_STAGE = stage_person_link.ID_STAGE
and stage_person_link.CD_STAGE_PERS_REL_INT IN ('PK') --identifies the primary caretaker
and stage_person_link.ID_PERSON = primary_caretaker.ID_PERSON --identifies the primary caretaker
and cps_invst_detail.ID_CPS_INVST_STAGE = stage.ID_STAGE
and allegation.ID_ALLEGATION_STAGE = stage.ID_STAGE
and alleged_victim.ID_PERSON = allegation.ID_VICTIM
and stage_person_link_cm.CD_STAGE_PERS_ROLE IN ('PR','HP') --identifies the current primary case manager
and stage_person_link_cm.ID_STAGE = stage.ID_STAGE
and stage_link.ID_STAGE = stage.ID_STAGE --this is the investigation stage
and (stage_link.ID_PRIOR_STAGE = intake_details.id_int_stage or stage_link.ID_PRIOR_STAGE = intake_details.id_div_stage)
and stage.DT_STAGE_START > to_date('01/01/2008', 'MM/DD/YYYY') -- only retrieves details on investigations that began after 1/1/2008 to restrict the volume of records.
and intake_details.cd_spcl_invstgtn = CSPECREQ.CODE (+) 
and intake_details.cd_spcl_circumstances = CSPECCIR.CODE (+) --uncomment when DBCR STGAP00011893 is completed
and primary_caretaker.CD_PERSON_MARITAL_STATUS = CMARSTAT.CODE(+)
and cps_invst_detail.CD_OVERRIDE_OVERLL_FIND = CDISPSTN.CODE(+) 
and cps_invst_detail.CD_CNCLSN_RISK_LVL = CCRSKFND.CODE(+)
and allegation.CD_MALTREATOR_REL = CRPTRINT.CODE (+)
and allegation.CD_ALLEGED_MAL_LOCATION = CLOCMAL.CODE(+)  --uncomment after DBCR STGAP00011899 is complete
and allegation.CD_ALLEG_TYPE = CMALCODE.CODE(+)
and alleged_victim.CD_PERSON_SEX = CSEX.CODE(+)
and alleged_victim.CD_PERSON_ETHNIC_GROUP = CETHNIC.CODE(+)
)inner_main;

grant select on CAPS.INVESTIGATION_ALLEGATIONS_MV1 to capson,capsbat,ops$datafix,operator;


--STGAP00012057 - Create Response Time View

--Note:  no impact to ado model


--The attached file creates the Response Time view for use when determining whether 
--investigator met the response time guidelines.  This view is needed to support OBIEE development.

CREATE OR REPLACE FORCE VIEW CAPS.RESPONSE_TIMES_MV1 (
"ID_STAGE",
"CD_STAGE_REGION",
"CD_STAGE_CNTY",
"INTAKE_DATE",
"RESPONSE_TIME_TYPE",
"RESPONSE_TIME",
"IND_RESPONSE_TIME_MET"
) AS 
select 
inner_main.ID_STAGE,
inner_main.CD_STAGE_REGION,
inner_main.CD_STAGE_CNTY,
inner_main.INTAKE_DATE,
inner_main.RESPONSE_TIME_TYPE,
inner_main.RESPONSE_TIME,
( case when (inner_main.RESPONSE_TIME_TYPE IN ('5D') 
                and BUSINESS_DAYS_DIFF (inner_main.INTAKE_DATE, inner_main.RESPONSE_TIME) <= 5) then 'Met' 
       when (inner_main.RESPONSE_TIME_TYPE IN ('5D') 
                and BUSINESS_DAYS_DIFF (inner_main.INTAKE_DATE, inner_main.RESPONSE_TIME) > 5 
                and BUSINESS_DAYS_DIFF (inner_main.INTAKE_DATE, sysdate) > 5) then 'Not Met' 
       when (inner_main.RESPONSE_TIME_TYPE IN ('5D') 
                and BUSINESS_DAYS_DIFF (inner_main.INTAKE_DATE, inner_main.RESPONSE_TIME) > 5 
                and BUSINESS_DAYS_DIFF (inner_main.INTAKE_DATE, sysdate) <= 5) then 'In Progress' 
       when (inner_main.RESPONSE_TIME_TYPE IN ('24','IM') 
                and inner_main.RESPONSE_TIME - inner_main.INTAKE_DATE <= 1) then 'Met' 
       when (inner_main.RESPONSE_TIME_TYPE IN ('24','IM')
               and inner_main.RESPONSE_TIME - inner_main.INTAKE_DATE > 1
               and sysdate - inner_main.INTAKE_DATE > 1) then 'Not Met' 
       when (inner_main.RESPONSE_TIME_TYPE IN ('24','IM') 
               and inner_main.RESPONSE_TIME - inner_main.INTAKE_DATE > 1
               and sysdate - inner_main.INTAKE_DATE <= 1) then 'In Progress'              
       else 'Undetermined'         
 end 
    )  as IND_RESPONSE_TIME_MET
-- start of inner main
from (
select 
stage.ID_STAGE,
stage.CD_STAGE_REGION,
stage.CD_STAGE_CNTY,
cps_invst_detail.DT_CPS_INVST_DTL_INTAKE as INTAKE_DATE,
intake_details.cd_stage_curr_priority as RESPONSE_TIME_TYPE,
  (select max (victim_contacts.vic_contact_date)
      from (
          select allegation2.ID_ALLEGATION_STAGE, 
          allegation2.ID_VICTIM, 
              NVL((select min(contact.DT_CONTACT_OCCURRED)
              from  event_person_link, contact
              where event_person_link.ID_EVENT = contact.ID_EVENT
              and (contact.IND_CONTACT_ATTEMPTED is null or contact.IND_CONTACT_ATTEMPTED <> 'Y')
              and contact.CD_CONTACT_METHOD IN ('ATF','UTF')
              and event_person_link.ID_PERSON = allegation2.ID_VICTIM --contact made with alleged victim.
              and contact.ID_CASE = stage2.ID_CASE --contact made with alleged victim documented in any stage of the case.                                
            ), TO_DATE('12/31/4712 00:00:00', 'MM/DD/YYYY HH24:MI:SS')) vic_contact_date 
          from allegation allegation2, stage stage2
          where allegation2.ID_ALLEGATION_STAGE = stage2.ID_STAGE --this is a necessary join because ALLEGATION does not store the CASE_ID. 
         ) victim_contacts
        where victim_contacts.ID_ALLEGATION_STAGE = stage.id_stage --join to outer main investigation query
       -- where victim_contacts.ID_ALLEGATION_STAGE = '11398109' --remove this line after testing
    ) as RESPONSE_TIME
from stage, 
cps_invst_detail,
stage_link,
  (select intake_stage.ID_STAGE as id_int_stage,
    ( select div_stage.id_stage
      from stage_link, stage div_stage
      where div_stage.cd_stage IN ('DIV')
      and stage_link.ID_STAGE = div_stage.id_stage
      and intake_stage.id_stage = stage_link.ID_PRIOR_STAGE
    ) as id_div_stage,
  incoming_detail.CD_SPCL_CIRCUMSTANCES, 
  incoming_detail.CD_SPCL_INVSTGTN, 
  intake_stage.CD_STAGE_CURR_PRIORITY, 
  ( case 
  when (select div_stage.id_stage
        from stage div_stage, stage_link
        where div_stage.cd_stage IN ('DIV')
        and stage_link.ID_STAGE = div_stage.id_stage
        and intake_stage.id_stage = stage_link.ID_PRIOR_STAGE
      ) is null then 'No'
  else 'Yes'
  end) as PRORGRESSED_FROM_DIV_STAGE  
  from incoming_detail, 
  stage intake_stage 
  where incoming_detail.ID_STAGE = intake_stage.ID_STAGE
  ) intake_details 
where stage.CD_STAGE = 'INV'
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
and stage.DT_STAGE_START > to_date('01/01/2008', 'MM/DD/YYYY') -- only retrieves details on investigations that began after 1/1/2008 to restrict the volume of records.
and stage_link.ID_STAGE = stage.ID_STAGE --this is the investigation stage
and (stage_link.ID_PRIOR_STAGE = intake_details.id_int_stage or stage_link.ID_PRIOR_STAGE = intake_details.id_div_stage)
and stage.ID_STAGE = cps_invst_detail.ID_CPS_INVST_STAGE 
) inner_main; 

grant select on CAPS.RESPONSE_TIMES_MV1 to capson,capsbat,ops$datafix,operator;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (426, 'SacwisRev2', 'Release 2.6 - DBCR 11833,11899,11893,11916,12057');

commit;


