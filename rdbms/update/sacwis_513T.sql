--STGAP00015125 - Update SQR view for PIP18 Parent ONG status

-- Update to View 
-- to remove the condition that stage needs to be open 2 month+ to be included in the population

CREATE OR REPLACE VIEW CAPS.SQR_PIP18_PARENT_ONG_COUNTS
(CD_STAGE_REGION, CD_STAGE_COUNTY, ID_UNIT, ID_CASEMANAGER, NM_CASEMANAGER, ID_SUPERVISOR, NM_SUPERVISOR, CD_UNIT_COUNTY, NBR_UNIT, OPN_ONG_CNT, ELIG_ONG_CNT, EXCEPTION_ONG_CNT)
AS
SELECT DISTINCT
    STAGE_ONG_M.CD_STAGE_REGION,
    STAGE_ONG_M.CD_STAGE_CNTY,
    UNIT_STAGE_M.ID_UNIT,
    PERSON_CM_M.ID_PERSON,
    PERSON_CM_M.NM_PERSON_FULL,
    PERSON_SUP_M.ID_PERSON,
    PERSON_SUP_M.NM_PERSON_FULL,
    UNIT_STAGE_M.CD_COUNTY,
    UNIT_STAGE_M.NBR_UNIT
    , (SELECT  (count(  DISTINCT STAGE_ONG.ID_STAGE  ))  
      FROM  STAGE STAGE_ONG,  STAGE_PERSON_LINK STAGE_PERSON_LINK_CM 
      WHERE STAGE_ONG.ID_STAGE = STAGE_PERSON_LINK_CM.ID_STAGE AND  
      STAGE_ONG.CD_STAGE = 'FPR' AND  
      STAGE_ONG.DT_STAGE_START < last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) + 1 AND  
      (STAGE_ONG.DT_STAGE_CLOSE IS NULL  OR  STAGE_ONG.DT_STAGE_CLOSE >= to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) AND  
      STAGE_PERSON_LINK_CM.CD_STAGE_PERS_ROLE IN ('HP','PR') AND  
      STAGE_ONG.CD_STAGE_REGION = STAGE_ONG_M.CD_STAGE_REGION AND  
      STAGE_ONG.CD_STAGE_CNTY = STAGE_ONG_M.CD_STAGE_CNTY AND  
      STAGE_ONG.ID_UNIT = STAGE_ONG_M.ID_UNIT AND  
      STAGE_PERSON_LINK_CM.ID_PERSON = STAGE_PERSON_LINK_CM_M.ID_PERSON) OPN_ONG
    , (SELECT  (count( distinct STAGE_ONG.ID_STAGE ))  
      FROM  STAGE STAGE_ONG,  STAGE_PERSON_LINK STAGE_PERSON_LINK_CM,  PERSON 
      PERSON_CHILD,  PERSON PERSON_PARENT,  STAGE_PERSON_LINK 
      STAGE_PERSON_LINK_CHILD,  STAGE_PERSON_LINK STAGE_PERSON_LINK_PARENT 
      WHERE STAGE_ONG.ID_STAGE = STAGE_PERSON_LINK_PARENT.ID_STAGE  AND  
      STAGE_ONG.ID_STAGE = STAGE_PERSON_LINK_CM.ID_STAGE  AND  
      STAGE_ONG.ID_STAGE = STAGE_PERSON_LINK_CHILD.ID_STAGE  AND  
      PERSON_CHILD.ID_PERSON = STAGE_PERSON_LINK_CHILD.ID_PERSON  AND  
      PERSON_PARENT.ID_PERSON = STAGE_PERSON_LINK_PARENT.ID_PERSON AND  
      STAGE_ONG.CD_STAGE = 'FPR' AND  
      STAGE_ONG.DT_STAGE_START < last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) + 1 AND  
      (STAGE_ONG.DT_STAGE_CLOSE IS NULL  OR  STAGE_ONG.DT_STAGE_CLOSE >= to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) AND  
      months_between(least(sysdate, last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  STAGE_ONG.DT_STAGE_CLOSE  , sysdate)),   STAGE_ONG.DT_STAGE_START ) >= 2 AND  
      STAGE_PERSON_LINK_CM.CD_STAGE_PERS_ROLE IN ('HP','PR') AND  
      STAGE_PERSON_LINK_CHILD.CD_STAGE_PERS_TYPE = 'PRN' AND  
      TRUNC(PERSON_CHILD.DT_PERSON_BIRTH) < least(sysdate, last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  STAGE_ONG.DT_STAGE_CLOSE  , sysdate)) AND  
      ADD_MONTHS( PERSON_CHILD.DT_PERSON_BIRTH , 12*18)  >=  least(TRUNC(sysdate), last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  trunc(STAGE_ONG.DT_STAGE_CLOSE)  , TRUNC(sysdate))) AND  
      (PERSON_CHILD.DT_PERSON_DEATH IS NULL  OR  PERSON_CHILD.DT_PERSON_DEATH  >= least(trunc(sysdate), last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  trunc(STAGE_ONG.DT_STAGE_CLOSE)  , trunc(sysdate)))) AND  
      (SELECT DISTINCT  (1)  FROM  ALLEGATION ALLEG_CHILD,  STAGE STAGE_ALLEG_CHILD 
        WHERE ALLEG_CHILD.ID_ALLEGATION_STAGE = STAGE_ALLEG_CHILD.ID_STAGE AND  
        ALLEG_CHILD.CD_ALLEG_DISPOSITION = 'SUB' AND  ALLEG_CHILD.ID_VICTIM = 
        STAGE_PERSON_LINK_CHILD.ID_PERSON AND  STAGE_ALLEG_CHILD.ID_CASE = 
        STAGE_PERSON_LINK_CHILD.ID_CASE) IS NOT NULL  AND  
      STAGE_PERSON_LINK_PARENT.CD_STAGE_PERS_TYPE = 'PRN' AND  
      (PERSON_PARENT.DT_PERSON_DEATH IS NULL  OR  PERSON_PARENT.DT_PERSON_DEATH >= least(trunc(sysdate), last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL( trunc( STAGE_ONG.DT_STAGE_CLOSE ), trunc(sysdate)))) AND  
      (STAGE_PERSON_LINK_PARENT.CD_STAGE_PERS_REL_INT IN ('PK','SC') OR  
      (SELECT DISTINCT (1) FROM  RELATIONSHIP RELATIONSHIP_PARENT 
        WHERE RELATIONSHIP_PARENT.CD_PERSON_RELATIONSHIP IN ('SC','BF','LF','PF') AND  
        (RELATIONSHIP_PARENT.DT_RELATIONSHIP_END IS NULL  OR  
        RELATIONSHIP_PARENT.DT_RELATIONSHIP_END > sysdate) AND  
        RELATIONSHIP_PARENT.ID_PERSON = PERSON_CHILD.ID_PERSON AND 
        RELATIONSHIP_PARENT.ID_RELATED_PERSON = PERSON_PARENT.ID_PERSON) IS NOT NULL ) AND  
      STAGE_ONG.CD_STAGE_CNTY = STAGE_ONG_M.CD_STAGE_CNTY AND  
      STAGE_ONG.CD_STAGE_REGION = STAGE_ONG_M.CD_STAGE_REGION AND  
      STAGE_ONG.ID_UNIT = STAGE_ONG_M.ID_UNIT AND  
      STAGE_PERSON_LINK_CM.ID_PERSON = STAGE_PERSON_LINK_CM_M.ID_PERSON) ELIG_ONG
    , (SELECT  (count( distinct STAGE_ONG.ID_STAGE ))  
      FROM  STAGE STAGE_ONG,  STAGE_PERSON_LINK STAGE_PERSON_LINK_CM,  PERSON 
      PERSON_CHILD,  PERSON PERSON_PARENT,  STAGE_PERSON_LINK 
      STAGE_PERSON_LINK_CHILD,  STAGE_PERSON_LINK STAGE_PERSON_LINK_PARENT 
      WHERE STAGE_ONG.ID_STAGE = STAGE_PERSON_LINK_PARENT.ID_STAGE AND  
      STAGE_ONG.ID_STAGE = STAGE_PERSON_LINK_CM.ID_STAGE AND  
      STAGE_ONG.ID_STAGE = STAGE_PERSON_LINK_CHILD.ID_STAGE  AND  
      PERSON_CHILD.ID_PERSON = STAGE_PERSON_LINK_CHILD.ID_PERSON AND  
      PERSON_PARENT.ID_PERSON = STAGE_PERSON_LINK_PARENT.ID_PERSON AND  
      STAGE_ONG.CD_STAGE = 'FPR' AND  STAGE_ONG.DT_STAGE_START < last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) + 1 AND  
      (STAGE_ONG.DT_STAGE_CLOSE IS NULL  OR  STAGE_ONG.DT_STAGE_CLOSE >= to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) AND  
      months_between(least(sysdate, last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  STAGE_ONG.DT_STAGE_CLOSE  , sysdate)),   STAGE_ONG.DT_STAGE_START ) >= 2 AND  
      STAGE_PERSON_LINK_CM.CD_STAGE_PERS_ROLE IN ('HP','PR') AND  
      STAGE_PERSON_LINK_CHILD.CD_STAGE_PERS_TYPE = 'PRN' AND  
      TRUNC(PERSON_CHILD.DT_PERSON_BIRTH) < least(sysdate, last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  STAGE_ONG.DT_STAGE_CLOSE  , sysdate)) AND  
      ADD_MONTHS( PERSON_CHILD.DT_PERSON_BIRTH , 12*18)  >=  least(TRUNC(sysdate), last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  trunc(STAGE_ONG.DT_STAGE_CLOSE)  , TRUNC(sysdate))) AND  
      (PERSON_CHILD.DT_PERSON_DEATH IS NULL  OR  PERSON_CHILD.DT_PERSON_DEATH  >= least(trunc(sysdate), last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL(  trunc(STAGE_ONG.DT_STAGE_CLOSE)  , trunc(sysdate)))) AND  
      (SELECT DISTINCT  (1)  FROM  ALLEGATION ALLEG_CHILD,  STAGE STAGE_ALLEG_CHILD 
        WHERE ALLEG_CHILD.ID_ALLEGATION_STAGE = STAGE_ALLEG_CHILD.ID_STAGE AND  
        ALLEG_CHILD.CD_ALLEG_DISPOSITION = 'SUB' AND  ALLEG_CHILD.ID_VICTIM = 
        STAGE_PERSON_LINK_CHILD.ID_PERSON AND  STAGE_ALLEG_CHILD.ID_CASE = 
        STAGE_PERSON_LINK_CHILD.ID_CASE) IS NOT NULL  AND  
        STAGE_PERSON_LINK_PARENT.CD_STAGE_PERS_TYPE = 'PRN' AND  
      (PERSON_PARENT.DT_PERSON_DEATH IS NULL  OR  
      PERSON_PARENT.DT_PERSON_DEATH >= least(trunc(sysdate), last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')), NVL( trunc( STAGE_ONG.DT_STAGE_CLOSE ), trunc(sysdate)))) AND  
      (STAGE_PERSON_LINK_PARENT.CD_STAGE_PERS_REL_INT IN ('PK','SC') OR  
        (SELECT DISTINCT (1) FROM  RELATIONSHIP RELATIONSHIP_PARENT WHERE 
        RELATIONSHIP_PARENT.CD_PERSON_RELATIONSHIP IN ('SC','BF','LF','PF') AND  
        (RELATIONSHIP_PARENT.DT_RELATIONSHIP_END IS NULL  OR  
        RELATIONSHIP_PARENT.DT_RELATIONSHIP_END > sysdate) AND  
        RELATIONSHIP_PARENT.ID_PERSON = PERSON_CHILD.ID_PERSON AND 
        RELATIONSHIP_PARENT.ID_RELATED_PERSON = PERSON_PARENT.ID_PERSON) IS NOT NULL ) AND  
      STAGE_PERSON_LINK_PARENT.ID_PERSON NOT IN (SELECT  PPT_PARTICIPANT_PARENT.ID_PERSON  FROM  PPT_PARTICIPANT PPT_PARTICIPANT_PARENT,  EVENT EVENT_PPT,  PPT PPT_PARENT,  STAGE STAGE_PPT WHERE PPT_PARTICIPANT_PARENT.ID_EVENT = EVENT_PPT.ID_EVENT
          AND  EVENT_PPT.ID_EVENT = PPT_PARENT.ID_PPT_EVENT
          AND  EVENT_PPT.ID_EVENT_STAGE = STAGE_PPT.ID_STAGE
          AND  PPT_PARTICIPANT_PARENT.DT_PPT_PART IS NOT NULL  AND  PPT_PARENT.DT_PPT_DATE < last_day(to_date((select textparm from  report_work where key='dt_report'), 'mm/yyyy'))+1 AND  PPT_PARTICIPANT_PARENT.DT_PPT_PART < trunc(sysdate) + 1 AND  PPT_PARENT.DT_PPT_DATE < trunc(sysdate) + 1 AND  add_months( PPT_PARENT.DT_PPT_DATE , 6 ) >= least( trunc(sysdate) , last_day(to_date((select textparm from  report_work where key='dt_report'), 'mm/yyyy')) , NVL( STAGE_PPT.DT_STAGE_CLOSE, trunc(sysdate) ) ) AND  EVENT_PPT.ID_EVENT_STAGE = STAGE_ONG.ID_STAGE AND  PPT_PARTICIPANT_PARENT.ID_PERSON = STAGE_PERSON_LINK_PARENT.ID_PERSON) AND 
      STAGE_PERSON_LINK_PARENT.ID_PERSON NOT IN (SELECT  EVENT_PERSON_LINK_CONTACT.ID_PERSON  FROM  CONTACT CONTACT_PARENT,  EVENT_PERSON_LINK EVENT_PERSON_LINK_CONTACT,  STAGE STAGE_CONTACT WHERE CONTACT_PARENT.ID_EVENT = EVENT_PERSON_LINK_CONTACT.ID_EVENT
          AND  CONTACT_PARENT.ID_CONTACT_STAGE = STAGE_CONTACT.ID_STAGE
          AND  (CONTACT_PARENT.IND_CONTACT_ATTEMPTED IS NULL  OR  CONTACT_PARENT.IND_CONTACT_ATTEMPTED <> 'Y') AND  CONTACT_PARENT.DT_CONTACT_OCCURRED < last_day(to_date((select textparm from  report_work where key='dt_report'), 'mm/yyyy'))+1 AND  add_months( CONTACT_PARENT.DT_CONTACT_OCCURRED , 6) >= least(trunc(sysdate), last_day(to_date((select textparm from  report_work where key='dt_report'), 'mm/yyyy')) , NVL( STAGE_CONTACT.DT_STAGE_CLOSE, trunc(sysdate) )  ) AND  (EXISTS (SELECT 1 FROM CONTACT_CBX CBX_PUR WHERE CBX_PUR.ID_CONTACT_EVENT=CONTACT_PARENT.ID_EVENT AND CBX_PUR.CD_CBX_CODE_TYPE = 'CCNTPURP' AND CBX_PUR.CD_CONTACT_CBX IN ('CPL','JCPL'))) AND  CONTACT_PARENT.ID_CONTACT_STAGE = STAGE_ONG.ID_STAGE) AND 
      STAGE_ONG.CD_STAGE_CNTY = STAGE_ONG_M.CD_STAGE_CNTY AND  
      STAGE_ONG.CD_STAGE_REGION = STAGE_ONG_M.CD_STAGE_REGION AND  
      STAGE_ONG.ID_UNIT = STAGE_ONG_M.ID_UNIT AND  
      STAGE_PERSON_LINK_CM.ID_PERSON = STAGE_PERSON_LINK_CM_M.ID_PERSON) EXCEPTION_ONG
 FROM
    STAGE STAGE_ONG_M,
    UNIT UNIT_STAGE_M,
    PERSON PERSON_SUP_M,
    PERSON PERSON_CM_M,
    STAGE_PERSON_LINK STAGE_PERSON_LINK_CM_M
WHERE
    STAGE_ONG_M.ID_UNIT = UNIT_STAGE_M.ID_UNIT  AND
    UNIT_STAGE_M.ID_PERSON = PERSON_SUP_M.ID_PERSON  AND
    STAGE_ONG_M.ID_STAGE = STAGE_PERSON_LINK_CM_M.ID_STAGE  AND
    STAGE_PERSON_LINK_CM_M.ID_PERSON = PERSON_CM_M.ID_PERSON  AND
    UNIT_STAGE_M.ID_PERSON = PERSON_SUP_M.ID_PERSON  AND
    STAGE_ONG_M.CD_STAGE = 'FPR' AND
    STAGE_ONG_M.cd_stage_region like (select nvl(textparm,'%') from report_work where key='cd_region') AND
   STAGE_ONG_M.cd_stage_cnty like (select nvl(textparm,'%') from report_work where key='cd_county') AND
    UNIT_STAGE_M.NBR_unit like (select nvl(textparm,'%') from report_work where key='nbr_unit') AND
    STAGE_ONG_M.DT_STAGE_START < last_day(to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) + 1 AND
    (STAGE_ONG_M.DT_STAGE_CLOSE IS NULL  OR  STAGE_ONG_M.DT_STAGE_CLOSE  >= to_date((select textparm from report_work where key='dt_report'), 'mm/yyyy')) AND
    STAGE_PERSON_LINK_CM_M.CD_STAGE_PERS_ROLE IN ('PR','HP') 
ORDER BY
    STAGE_ONG_M.CD_STAGE_REGION DESC,
    STAGE_ONG_M.CD_STAGE_CNTY DESC,
    UNIT_STAGE_M.id_UNIT DESC,
    PERSON_CM_M.NM_PERSON_FULL DESC;

grant select on CAPS.SQR_PIP18_PARENT_ONG_COUNTS to operator,capson,capsbat,ops$datafix;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (514, 'SacwisRev3', 'Release 3.2 - DBCR 15125');

commit;



