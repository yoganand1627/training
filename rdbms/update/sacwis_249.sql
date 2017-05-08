-- change STGAP00006056
-- DBCR for fixing Defect STGAP00005937: Visitation Plan - Change text to to do to remove 'English'

UPDATE CAPS.TASK SET TXT_TASK_DECODE='Approve Visitation Plan' WHERE CD_TASK ='3380';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (250, 'SacwisRev21', 'correct TASK text');                                    
commit;
