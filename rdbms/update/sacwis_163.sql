
-- change STGAP00002096

create or replace synonym CAPS.SEQ_CSUP_CHILDLFTCARE_OUTBOUND for SACWISIFC.SEQ_CSUP_CHILDLFTCARE_OUTBOUND;
create or replace synonym CAPS.SEQ_ADOPT_TPR_OUTBOUND for SACWISIFC.SEQ_ADOPT_TPR_OUTBOUND;
create or replace synonym CAPS.SEQ_AGENCY_CUSTODIAL_PARENTS for SACWISIFC.SEQ_AGENCY_CUSTODIAL_PARENTS;
create or replace synonym CAPS.SEQ_CHILDSUP_REF_OUTBOUND for SACWISIFC.SEQ_CHILDSUP_REF_OUTBOUND;
create or replace synonym CAPS.SEQ_CSUP_PARENT_OUTBOUND for SACWISIFC.SEQ_CSUP_PARENT_OUTBOUND;

-- change STGAP00002097
   
Insert into caps.message
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60317, 'MSG_MAX_FEMALE_ RANGE_INTEREST', 
   'You have entered Maximum Female Age Interest and have not entered a Minimum Female Age Interest.', 740, 500, 'N');   
   
Insert into caps.message
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60318, 'MSG_FAD_HOLD_SAVE_SUBMIT', 
   'Changes to the Hold Placements checkbox require Save and Submit.', 740, 500, 'N');  
       
Insert into caps.message
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60316, 'MSG_RSRC_COUNTY', 
   'County or All Counties is required.', 740, 500, 'N');
   
-- change STGAP00002099
update caps.task
set ind_task_code_prefer = '2'
where cd_task in ('2310','9020','3020','8530','4190','7100');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (164, 'SacwisRev2', 'static updates, stars synonyms');
commit;
