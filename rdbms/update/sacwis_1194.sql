--STGAP00017861 - Release(5.1) MR-085:Add ICPC Validation Messages

--MR-085 ICPC Validation Messages

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60947, SYSDATE, 'MSG_ICPC_PARENT_CARE',
'Relative or Foster Family Home Care cannot be selected for a parent.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60948, SYSDATE, 'MSG_ICPC_PARENT_STUDY',
'Relative, Adoptive or Foster Home Study cannot be requested for a parent.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60949, SYSDATE, 'MSG_ICPC_SPOUSE_NOT_PRIMARY',
'The Spouse can not be the same as the Primary Person. Please select a different person for Spouse.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60950, SYSDATE, 'MSG_ICPC_IVE_ADO_FUND_REQ',
'Approved AA Funding Determination is required prior to requesting an Adoptive Home Study.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60951, SYSDATE, 'MSG_ICPC_100A_DOCS_REQ',
'All required documents for 100A packet must be selected here. Please remember to upload them in External Documents.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60952, SYSDATE, 'MSG_ICPC_IVE_REQD',
'IV-E Eligibility Documentation must be selected when the Title IV-E Determination is not Pending.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60953, SYSDATE, 'MSG_ICPC_DT_PLACED_REQ',
'Date Child Placed in Receiving State is required when the Placement Status is Initial Placement of Child in Receiving State.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60954, SYSDATE, 'MSG_ICPC_DT_CHANGE_REQ',
'Effective Date of Change is required when the Placement Status is Placement of Change.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60955, SYSDATE, 'MSG_ICPC_SEND_RECV_STATE_REQ',
'The ''In Sending State'' and ''In Receiving State'' radio buttons are required if Adoption Finalized is selected.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60956, SYSDATE, 'MSG_ICPC_OTHER_NOT_SPECIFY',
'If Other (Specify) is selected as Compact Placement Termination, enter an explanation.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60957, SYSDATE, 'MSG_ICPC_DT_TERM_REQD',
'Enter a Date of Termination when reason for Compact Placement Termination is selected.', 500, 700, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1195, 'SacwisRev5', 'Release 5.1 - DBCR 17861');

commit;
