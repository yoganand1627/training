--STGAP00014200 - Update Ongoing view - Correction to Months Open

--Note:  no impact to ado model


--This DBCR resolves the problem identified by defect STGAP00014066.  An update has been made to the
--logic of the ONGOING view such that the Months Open column calculates the difference between the start 
--date and the system date when the stage has not been closed.  

--ONGOING - This is a population of ongoing (ONG) stages active at some point during the reporting period.  
--Results return one record per ongoing stage.	It's intended purpose is to support the ongoing User Defined Report functionality.

CREATE OR REPLACE VIEW CAPS.ONGOING_MV1 (
"STAGE_ID",
"CASE_ID",
"STAGE_NAME",
"STAGE_START",
"STAGE_CLOSE",
"CD_STAGE_REGION",
"CD_STAGE_CNTY",
"MONTHS_OPEN",
"MALTREATMENT_FINDING", 
"INITIAL_RISK_LEVEL",
"MALTREATMENT_CODE"
) AS
select 
inner_main.STAGE_ID,
inner_main.CASE_ID,
inner_main.STAGE_NAME,
inner_main.STAGE_START,
inner_main.STAGE_CLOSE,
inner_main.CD_STAGE_REGION,
inner_main.CD_STAGE_CNTY,
inner_main.MONTHS_OPEN,
inner_main.MALTREATMENT_FINDING, 
inner_main.INITIAL_RISK_LEVEL,
--inner_main.MALTREATMENT_CODE
to_string(cast (collect (inner_main.MALTREATMENT_CODE) as collection_char1)) "MALTREATMENT_CODE"
FROM(
select distinct
stage.ID_STAGE as STAGE_ID,
stage.ID_CASE as CASE_ID,
stage.NM_STAGE as STAGE_NAME,
trunc(stage.DT_STAGE_START) as STAGE_START,
trunc(stage.DT_STAGE_CLOSE) as STAGE_CLOSE,
stage.CD_STAGE_REGION,
stage.CD_STAGE_CNTY,
trunc(months_between( NVL(stage.DT_STAGE_CLOSE, sysdate), stage.DT_STAGE_START)) as MONTHS_OPEN,
CDISPSTN.DECODE as MALTREATMENT_FINDING, 
CLVLRSK.DECODE as INITIAL_RISK_LEVEL,
sub_allegations.COMBINED as MALTREATMENT_CODE --use this one once the length of the collect statement is extended.
from stage, 
stage_link,
cps_invst_detail,
CDISPSTN,
 ( select allegation.ID_ALLEGATION_STAGE, allegation.CD_ALLEG_TYPE, CMALCODE.COMBINED
   from allegation, 
     (select codes_tables.CODE, codes_tables.DECODE, (codes_tables.CODE ||'/'|| codes_tables.DECODE) as COMBINED 
      from codes_tables
      where codes_tables.CODE_TYPE = 'CMALCODE'
     ) CMALCODE
   where allegation.CD_ALLEG_DISPOSITION = 'SUB' --only substantiated investigations retrieved.
   and allegation.CD_ALLEG_TYPE = CMALCODE.CODE
   ) sub_allegations,
  (select codes_tables.code, codes_tables.decode
  from codes_tables
  where codes_tables.CODE_TYPE = 'CLVLRSK'
  ) CLVLRSK
where stage.CD_STAGE = 'FPR'
and stage_link.ID_STAGE = stage.ID_STAGE --this is the ongoing stage
and stage_link.ID_PRIOR_STAGE = cps_invst_detail.ID_CPS_INVST_STAGE -- this is the investigation stage
and sub_allegations.ID_ALLEGATION_STAGE(+) = cps_invst_detail.ID_CPS_INVST_STAGE -- substantiated allegations on the investigation if present
and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null) --excluding stages closed to merge
and cps_invst_detail.CD_CPS_INVST_DTL_OVRLL_DISPTN = CDISPSTN.CODE(+) 
and cps_invst_detail.CD_CNCLSN_RISK_LVL = CLVLRSK.CODE(+)
) inner_main
group by
inner_main.STAGE_ID,
inner_main.CASE_ID,
inner_main.STAGE_NAME,
inner_main.STAGE_START,
inner_main.STAGE_CLOSE,
inner_main.CD_STAGE_REGION,
inner_main.CD_STAGE_CNTY,
inner_main.MONTHS_OPEN,
inner_main.MALTREATMENT_FINDING, 
inner_main.INITIAL_RISK_LEVEL;


--STGAP00014223 - Update and Insert messages for Agreement

--Note: no impact to ado model


update caps.message set txt_message = 'Please Specify a Payment Method.' where txt_message_name = 'MSG_AGMT_PAYMENT_MTHD_REQD';

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,99330,'MSG_AGMT_SPCL_SERV_EXISTS','Special Service Agreement exists for the Attached Application.',700,500,'N');




insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (478, 'SacwisRev3', 'Release 3.1 - DBCRs 14200,14223');

commit;


