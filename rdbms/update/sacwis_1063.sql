

--STGAP00016977 - Release(5.0) ECEM 5.0: Metaphor for new Program Code Mtnt page

-- New metaphor tab for new page for ECEM 5.0: Program Code Maintenance page
Insert into CAPS.METAPHOR (ID_TAB,TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB)
values (1545,'/financials/ProgramCodeMaintenance/displayProgramCodeMaintenance','PROG_CODE_PROGCODEMTNT','Program Code <br> Maintenance');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1064, 'SacwisRev5', 'Release 5.0 - DBCR 16977');

commit;
