--STGAP00015662- DBCR - Per SMS #37374 - Insert new message

--Per SMS # 37374: Add message 'Termination Date/Payment Change Reason is required to Terminate the 
--Agreement' when attempting to terminate (Save or Complete) the Agreement and either the Termination -
--Date or Payment Change Reason has not been entered.

insert into caps.message(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (60643, 'MSG_TERM_DATE_PAY_RSN_REQ', 'Termination Date/Payment Change Reason is required to Terminate the Agreement', 500, 700, 'N');
   
insert into caps.schema_version(id_schema_version,application_version,comments)
            values (654, 'SacwisRev3', 'Release 3.5 - DBCR 15662');

commit;

