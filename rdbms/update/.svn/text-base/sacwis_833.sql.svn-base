--STGAP00015911 - Release(3.6) PerSMS54782 Add new Codestables, new column to chl

--Per SMS#54782  Add new column report_type  to Chld_Dth_Nr_Flty_Seri_Inj table so that the user can
-- record if the report was created for child death, Near Fatality or Serious Injury.

ALTER TABLE caps.Chld_Dth_Nr_Flty_Seri_Inj ADD (report_type varchar2(3) NULL);

COMMENT ON COLUMN caps.Chld_Dth_Nr_Flty_Seri_Inj.report_type IS 'Used to record if the report was created for child death, Near Fatality or Serious Injury';


--Per SMS#54782Add new codes for report types

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES
('CDREPTYP','DTH','Child Death',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES
('CDREPTYP','FTY','Near Fatality',SYSDATE);

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE,DT_LAST_UPDATE) VALUES
('CDREPTYP','INJ','Serious Injury',SYSDATE);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (834, 'SacwisRev3', 'Release 3.6 - DBCR 15911');

commit;

