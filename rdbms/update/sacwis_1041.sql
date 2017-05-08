--STGAP00016181 - Release(4.3) Modify all legacy records' history indicator

update caps.records_check
set ind_reccheck_history = 'Y'
where cd_rec_check_check_type in ('GS', 'PS', 'IM', 'IC', 'SC');

update caps.records_check
set txt_rec_check_comments = 'default comments added by dbcr STGAP00016181'
where ind_reccheck_history = 'Y' and txt_rec_check_comments is null;

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, 
CD_PRESENTATION, IND_BATCH) Values (60872, SYSDATE, 'MSG_REC_COMMENT_REQ_HISTORY',
 'For %s, Since History checkbox is checked, a Comment Entry is required.', 500, 700, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1042, 'SacwisRev4', 'Release 4.3 - DBCR 16181');

commit;

