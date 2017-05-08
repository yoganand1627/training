-- STGAP00010349 - Exchange Child: Need new column

alter table caps.EXC_CHILD_ADO_INFO_CBX add (DT_PERFORMED date);
update caps.EXC_CHILD_ADO_INFO_CBX set DT_PERFORMED='12/31/4712';
commit;
alter table caps.EXC_CHILD_ADO_INFO_CBX modify (DT_PERFORMED date not null);
comment on column caps.EXC_CHILD_ADO_INFO_CBX.DT_PERFORMED is 'Date of the recruitment activity';


-- STGAP00010361 - Exchange Child: New Codes Table value

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '55', '55/Study Not Returned', null, sysdate);

update caps.codes_tables
set dt_end = sysdate
where code_type = 'CANONAV'
and code = '50';


-- STGAP00010368 - Exchange Child - New message needed

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60479, 'MSG_NO_REC_DATE', 'One or more Recruitment Activities have been selected without specifying a Date.', 700, 500, 'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (389, 'SacwisRev3', 'Release 3.0 - DBCRs 10349,10361,10368');

commit;


