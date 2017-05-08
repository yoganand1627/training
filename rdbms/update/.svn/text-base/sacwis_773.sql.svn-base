--STGAP00015834 - Release(3.5) CAPTA: CPS Invest Message Update

UPDATE  CAPS.MESSAGE SET TXT_MESSAGE = 'One or more children in the stage have an allegation with a severity of Child Death, Near Fatality as Certified by a Physician, or Serious Injury but do not have a Child Death/Near Fatality/Serious Injury Report entered.  Please produce and approve the Child Death/Near Fatality/Serious Injury report for each affected child.' 
WHERE 
TXT_MESSAGE_NAME = 'MSG_INV_CDNFSI_REQ';

-- INSERTING into error_list
Insert into caps.error_list (DT_LAST_UPDATE,NBR_MESSAGE,TXT_PRGM_CD,TXT_STAGE_CD,ID_TAB,CD_TASK) 
values (sysdate,60667,'CPS','INV',980,'2160');

Insert into caps.error_list (DT_LAST_UPDATE,NBR_MESSAGE,TXT_PRGM_CD,TXT_STAGE_CD,ID_TAB,CD_TASK) 
values (sysdate,60668,'CPS','INV',980,'2160');

Insert into  caps.error_list (DT_LAST_UPDATE,NBR_MESSAGE,TXT_PRGM_CD,TXT_STAGE_CD,ID_TAB,CD_TASK) 
values (sysdate,60669,'CPS','INV',980,'2160');

Insert into caps.error_list (DT_LAST_UPDATE,NBR_MESSAGE,TXT_PRGM_CD,TXT_STAGE_CD,ID_TAB,CD_TASK) 
values (sysdate,60670,'CPS','INV',980,'2160');

Insert into caps.error_list (DT_LAST_UPDATE,NBR_MESSAGE,TXT_PRGM_CD,TXT_STAGE_CD,ID_TAB,CD_TASK) 
values (sysdate,60680,'CPS','INV',980,'2160');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (774, 'SacwisRev3', 'Release 3.5 - DBCR 15834');

commit;

