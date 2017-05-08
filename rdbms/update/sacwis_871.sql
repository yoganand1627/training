--STGAP00015965 - Release(4.0) MR-067 Schema change for YOUTH_REPORT_DTL

-- STGAP00015965  MR-067 Schema change for YOUTH_REPORT_DTL
alter table
   caps.youth_report_dtl
add
   (
   CD_HLTH_INS_MEDICAL VARCHAR2(1 BYTE),
   CD_HLTH_INS_MENTAL VARCHAR2(1 BYTE) ,
   CD_HLTH_INS_RX VARCHAR2(1 BYTE),
   IND_ENTERED_BY_YTH VARCHAR2(1 BYTE),
   NM_ENTERED_BY_NAME VARCHAR2(25 BYTE)
   );
COMMENT ON COLUMN caps.YOUTH_REPORT_DTL.CD_HLTH_INS_MEDICAL IS 'Indicates if child''s other health insurance has coverage of medical services';
COMMENT ON COLUMN caps.YOUTH_REPORT_DTL.CD_HLTH_INS_MENTAL IS 'Indicates if child''s other health insurance has coverage mental/psychological services';
COMMENT ON COLUMN caps.YOUTH_REPORT_DTL.CD_HLTH_INS_RX IS 'Indicates if child''s other health insurance has coverage for prescription medications';
COMMENT ON COLUMN caps.YOUTH_REPORT_DTL.IND_ENTERED_BY_YTH IS 'Indicator to determine if youth had personally taken the survey';
COMMENT ON COLUMN caps.YOUTH_REPORT_DTL.NM_ENTERED_BY_NAME IS 'Name of whom last updated the survey';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (872, 'SacwisRev4', 'Release 4.0 - DBCR 15965');

commit;

