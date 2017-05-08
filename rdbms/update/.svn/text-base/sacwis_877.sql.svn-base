--STGAP00015972 - Release(4.0) Add 'Ind_Red_Flag' column to Stage Table

--Add a new column, IND_RED_FLAG, for use on the Case Summary page. See SMS #66752 for further details.

alter table caps.stage add ind_red_flag varchar2(1);
comment on column caps.stage.ind_red_flag is 'Is Red Flag case?';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (878, 'SacwisRev4', 'Release 4.0 - DBCR 15972');

commit;



