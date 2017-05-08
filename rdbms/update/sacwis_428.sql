--STGAP00012302 - New columns for SPECIAL NEEDS DETERMINATION

alter table caps.SPECIAL_NEEDS_DETERMINATION add (IND_NON_REC_REQUESTED varchar2(1));
alter table caps.SPECIAL_NEEDS_DETERMINATION add (IND_NON_REC_APPROVED varchar2(1));
alter table caps.SPECIAL_NEEDS_DETERMINATION add (NBR_NON_REC_AMT decimal(8));
alter table caps.SPECIAL_NEEDS_DETERMINATION add (NBR_NON_REC_APRV_AMT decimal(8));

comment on column caps.SPECIAL_NEEDS_DETERMINATION.IND_NON_REC_REQUESTED is 'Is a Non-Recurring/510 Funding Type being requested for this child';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.IND_NON_REC_APPROVED is 'Is the Non-Recurring/510 Funding Type request approved  for this child';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.NBR_NON_REC_AMT is 'The Non-Recurring/510 Amount';
comment on column caps.SPECIAL_NEEDS_DETERMINATION.NBR_NON_REC_APRV_AMT is 'The approved Non-Recurring/510 Amount';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (429, 'SacwisRev3', 'Release 3.0 - DBCR 12302');

commit;


