--STGAP00016032 - Release(4.1) MR-53 Add Alloc-Deem messages and codes

--11/23/2010
alter table CAPS.FCE_ELIGIBILITY rename column IND_DEEM_RESP_TYPE to CD_DEEM_RESP_TYPE;

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMTYP', 'ONE', 'One Responsible Individual');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CDEEMTYP', 'TWO', 'Two Responsible Individuals');

--Messages for Single Parent
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60791, SYSDATE, 'MSG_ALLOC_SNGL_RESP_INDIV_REQ', 'You must select the AU Member Responsible for Allocation if ''Single Parent'' is selected as the Allocation Type.', 500,
700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60792, SYSDATE, 'MSG_ALLOC_SNGL_SPOUSE_CHILD_REQ','''Number of Ineligible Spouse'' or ''Number of Ineligible Child(ren)'' must be greater than zero if ''Single Parent'' is selected as the Allocation Type.', 500, 700, 'N');

--Messages for Mutual Parents
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60793, SYSDATE, 'MSG_ALLOC_MUT_RESP_INDIV_REQ', 'You must select both AU Members Responsible for Allocation if ''Mutual Parent'' is selected as the Allocation Type.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60794, SYSDATE, 'MSG_ALLOC_MUT_SPOUSE_CHILD_REQ', '''Number of Ineligible Spouse'' or ''Number of Ineligible Child(ren)'' must be greater than zero if ''Mutual Parent'' is selected as the Allocation Type.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60795, SYSDATE, 'MSG_ALLOC_MUT_SAME_RESP_INDIV', 'You must select two different Responsible AU members for ''Mutual Parent'' Allocation Type.', 500, 700, 'N');


--Messages for Multiple Parents
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60796, SYSDATE, 'MSG_ALLOC_MULT_RESP_INDIV_REQ', 'You must select both AU Members Responsible for Allocation if ''Multiple Parents'' is selected as the Allocation Type.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60797, SYSDATE, 'MSG_ALLOC_MULT_SPOUSE_CHILD_REQ', '''Number of Ineligible Spouse'' or ''Number of Ineligible Child(ren)'' must be greater than zero for each Responsible Individuals if ''Multiple Parents'' is selected as the Allocation Type.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60798, SYSDATE, 'MSG_ALLOC_MULT_SAME_RESP_INDIV', 'You must select two different Responsible AU members for ''Multiple Parents'' Allocation Type.', 500, 700, 'N');

--Messages for Mutual Single and Mutual Multiple
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60799, SYSDATE, 'MSG_ALLOC_MANY_RESP_INDIV_REQ', 'You must select all AU Members Responsible for Allocation if %s is selected as the Allocation Type.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60800, SYSDATE, 'MSG_ALLOC_MANY_SPOUSE_CHILD_REQ', '''Number of Ineligible Spouse'' or ''Number of Ineligible Child(ren)'' must be greater than zero for each Responsible Individuals if %s is selected as the Allocation Type.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60801, SYSDATE, 'MSG_ALLOC_MMULT_SAME_RESP_INDIV', 'You must select two different Responsible AU members for the mutual allocation if %s is selected as the Allocation Type.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60802, SYSDATE, 'MSG_ALLOC_MANY_SAME_RESP_INDIV', 'You must select two different Responsible AU members for each single allocator if ''Mutual Multiple'' is selected as the Allocation Type.', 500, 700, 'N');

--Messages for Deeming section
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60803, SYSDATE, 'MSG_DEEM_SECTION_REQ', 'The ''Determination Of Standard Of Need for Deeming Budget'' section is required if  a Deeming Type is selected.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60804, SYSDATE, 'MSG_DEEM_SAME_RESP_INDIV', 'You must select two different Household Members if ''Two Responsible Individuals'' is selected as the Deeming Type.', 500, 700, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (924, 'SacwisRev4', 'Release 4.1 - DBCR 16032');

commit;


