--STGAP00016036 - Release(4.1) MR-53 Add Alloc Mutual Single-Multiple messages

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, 
CD_PRESENTATION, IND_BATCH) 
Values (60810, SYSDATE, 'MSG_ALLOC_MMULT_RESP_INDIV_REQ', 
'You must select all AU Members Responsible for Allocation if ''Mutual Multiple'' is selected as the Allocation Type.', 
500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, 
CD_PRESENTATION, IND_BATCH) 
Values (60811, SYSDATE, 'MSG_ALLOC_MMULT_SPOUSE_CHILD_REQ', '''Number of Ineligible Spouse'' or ''Number of Ineligible Child(ren)'' must be greater than zero for each Responsible Individuals if ''Mutual Multiple'' is selected as the Allocation Type.', 
500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, 
CD_PRESENTATION, IND_BATCH) 
Values (60812, SYSDATE, 'MSG_ALLOC_MSNGL_SAME_RESP_INDIV', 'You must select two different Responsible AU members for the mutual allocation if ''Mutual Single'' is selected as the Allocation Type.',
500, 700, 'N');
Update caps.message set TXT_MESSAGE_NAME = 'MSG_ALLOC_MSNGL_RESP_INDIV_REQ' where TXT_MESSAGE_NAME = 'MSG_ALLOC_MANY_RESP_INDIV_REQ';
Update caps.message set TXT_MESSAGE_NAME = 'MSG_ALLOC_MSNGL_SPOUSE_CHILD_REQ' where TXT_MESSAGE_NAME = 'MSG_ALLOC_MANY_SPOUSE_CHILD_REQ';
Update caps.message set TXT_MESSAGE_NAME = 'MSG_ALLOC_MMULM_SAME_RESP_INDIV' where TXT_MESSAGE_NAME = 'MSG_ALLOC_MANY_SAME_RESP_INDIV';
Update caps.message set TXT_MESSAGE = 'You must select all AU Members Responsible for Allocation if ''Mutual Single'' is selected as the Allocation Type.' where TXT_MESSAGE_NAME = 'MSG_ALLOC_MSNGL_RESP_INDIV_REQ';
Update caps.message set TXT_MESSAGE = '''Number of Ineligible Spouse'' or ''Number of Ineligible Child(ren)'' must be greater than zero for each Responsible Individuals if ''Mutual Single'' is selected as the Allocation Type.' where TXT_MESSAGE_NAME = 'MSG_ALLOC_MSNGL_SPOUSE_CHILD_REQ';
Update caps.message set TXT_MESSAGE = 'You must select two different Responsible AU members for the mutual allocation if ''Mutual Multiple'' is selected as the Allocation Type.' where TXT_MESSAGE_NAME = 'MSG_ALLOC_MMULT_SAME_RESP_INDIV';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (929, 'SacwisRev4', 'Release 4.1 - DBCR 16036');

commit;



