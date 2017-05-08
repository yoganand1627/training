--STGAP00012369 - Update the Investigation Allegations View OBIEE

-- This update corrects a mapping problem with the some of the fields and will be
-- used for the OBIEE pilot in February.  Please apply script to release 2.6 and later.

--INVESTIGATION ALLEGATIONS - This is a population of alleged and substantiated victims of allegations on 
--investigation (INV) stages active at some point during the reporting period.  Details related to the overall investigation are 
--also provided for each victim record.


CREATE OR REPLACE VIEW CAPS.INVESTIGATION_ALLEGATIONS_MV1 (
STAGE_REGION,
STAGE_COUNTY,
LAST_ASSIGNED_CM_ID,
CASE_ID,
STAGE_ID,
STAGE_NAME,
PRORGRESSED_FROM_DIV_STAGE,
INTAKE_DATE,
SPECIAL_INVESTIGATION_TYPE,
SPECIAL_CIRCUMSTANCES_TYPE,  
INV_START_DATE,
INV_CLOSED_DATE,
PK_PERSON_ID,
PK_ZIP_CODE,
PK_MARITAL_STATUS,
HAS_SIX_MONTH_RECURRENCE,
INV_OPEN_TEN_DAY_DIV_ALL,
INV_OPEN_TEN_DAY_DIV_TWELVE,
MALTREATMENT_FINDING,
OVERALL_RISK_FINDING,
ALLEGATION_ID,
ALLEGATION_FINDING,
VIC_ID,
VIC_NAME,
MALTREATOR_RELATIONSIHP,
MALTREATMENT_LOCATION, 
MALTREATMENT_DATE,
MALTREATMENT_TYPE,
MALTREATMENT_CODE,
MALTREATMENT_DECODE,
VIC_GENDER,
VIC_DOB,
VIC_RAC
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
inner_main.SPECIAL_CIRCUMSTANCES_TYPE, 
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
inner_main.ALLEGATION_FINDING,
inner_main.VIC_ID,
inner_main.VIC_NAME,
inner_main.MALTREATOR_RELATIONSIHP,
inner_main.MALTREATMENT_LOCATION, 
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
--start of inner main from clause
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
CSPECCIR.DECODE as SPECIAL_CIRCUMSTANCES_TYPE, 
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
      and (cps_invst_detail.DT_CPS_INVST_DTL_INTAKE - div_stage.DT_STAGE_CLOSE) >= 10 -- the investigation must have begun after 10 days after the diversion closure.
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
      and (cps_invst_detail.DT_CPS_INVST_DTL_INTAKE - div_stage.DT_STAGE_CLOSE) >= 10 -- the investigation must have begun after 10 days after the diversion closure.
      and primary_caretaker.ID_PERSON = div_stage_person_link.ID_PERSON  --this is a join to the primary caretaker diversion in the master query
      and add_months(div_stage.DT_STAGE_START, 12) >= sysdate -- the diversion stage was opened within the past 12 months.
      and div_stage.id_case <> stage.id_case --this avoids counting the same incident if the case manager progressed the diversion to investigation after 10 days.    
      ), 0, 'No', 'Yes')) as INV_OPEN_TEN_DAY_DIV_TWELVE,     
CDISPSTN.DECODE as MALTREATMENT_FINDING, 
CCRSKFND.DECODE as OVERALL_RISK_FINDING,
allegation.ID_ALLEGATION as ALLEGATION_ID,
CDISPSTN2.DECODE as ALLEGATION_FINDING, 
alleged_victim.ID_PERSON as VIC_ID,
alleged_victim.NM_PERSON_FULL as VIC_NAME,
CRPTRINT.DECODE as MALTREATOR_RELATIONSIHP,
CLOCMAL.DECODE as MALTREATMENT_LOCATION, 
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
--codes tables for decodes
CSPECREQ,
CSPECCIR, 
CMARSTAT,
CDISPSTN,
CDISPSTN CDISPSTN2, --this second codes table view is used to decode the allegation dispostion
CCRSKFND,
CRPTRINT,
CLOCMAL,  
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
--joins for codes tables
and intake_details.cd_spcl_invstgtn = CSPECREQ.CODE (+) 
and intake_details.cd_spcl_circumstances = CSPECCIR.CODE (+) 
and primary_caretaker.CD_PERSON_MARITAL_STATUS = CMARSTAT.CODE(+)
and cps_invst_detail.CD_CPS_INVST_DTL_OVRLL_DISPTN = CDISPSTN.CODE(+) 
and cps_invst_detail.CD_CNCLSN_RISK_FND = CCRSKFND.CODE(+)
and allegation.CD_ALLEG_DISPOSITION = CDISPSTN2.CODE(+) 
and allegation.CD_MALTREATOR_REL = CRPTRINT.CODE (+)
and allegation.CD_ALLEGED_MAL_LOCATION = CLOCMAL.CODE(+)  
and allegation.CD_ALLEG_TYPE = CMALCODE.CODE(+)
and alleged_victim.CD_PERSON_SEX = CSEX.CODE(+)
and alleged_victim.CD_PERSON_ETHNIC_GROUP = CETHNIC.CODE(+)
)inner_main;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (431, 'SacwisRev2', 'Release 2.6 - DBCR 12369');

commit;


