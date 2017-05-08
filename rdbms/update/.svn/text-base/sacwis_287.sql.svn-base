-- All changes for version 2.3 of SHINES

-- change STGAP00007384
update caps.message
set txt_message = 'A system error has occurred in Georgia SHINES.  Please contact the SHINES Help Desk at 1 (800) 764-1017 and provide them with the following information:'
where txt_message_name = ' MSG_HELP_DESK_NO';

-- change STGAP00007389
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60382, 'MSG_SVC_PROV_NM_TYP_REQ', 'Service Provider Name and Type of Service must be chosen when selecting a disposition of ''Screen Out'' or ''Screen Out & Referred''.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60383, 'MSG_SCRN_OUt_RSN_REQ', 'Screen Out Reason is required when selecting a disposition of ''Screen Out'', ''Screen Out & Referred'' or ''Diversion''.', 700, 500, 'N');

-- change STGAP00007398
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE, DT_LAST_UPDATE = SYSDATE WHERE 
CODE = '52151' AND CODE_TYPE = 'CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE, DT_LAST_UPDATE = SYSDATE WHERE 
CODE = '52151' AND CODE_TYPE = 'CFLSVLNK';

UPDATE CAPS.EQUIVALENCY SET DT_EQUIV_END_DATE = TO_DATE('08/30/2007','MM/DD/YYYY')
WHERE CD_EQUIV_SVC_DTL_SERVICE = '52151';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (288, 'SacwisRev2', 'static table updates');                        
commit;
