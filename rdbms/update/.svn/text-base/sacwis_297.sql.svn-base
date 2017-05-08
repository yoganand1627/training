-- All changes for version 2.4 of SHINES

--- STGAP00007657 Starts Here ---
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CLHECOT', 'IJR','Immediate Judicial Review', sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CLHECOT', 'IPR','Immediate Permanency Review', sysdate);
--- STGAP00007657 Ends Here ---


--- STGAP00007674 Begins Here ---
INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES
('CSECATTR', 'PD', 'Modify Approved Placement', sysdate);

INSERT INTO CAPS.CODES_TABLES
(CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES
('CSECATTR', 'PE', 'Modify End Dated Eligibility', sysdate);
--- STGAP00007674 Ends Here ---


--- STGAP00007714 Begins Here ---
/
CREATE OR REPLACE TRIGGER CAPS.TDBR_PAYMENT_OF_CARE
BEFORE DELETE
ON CAPS.PAYMENT_OF_CARE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
BEGIN
        DELETE ADJUSTMENT_REQUEST
        WHERE ID_ADJ_REQ_EVENT = :OLD.ID_POC_EVENT;
EXCEPTION
        WHEN OTHERS THEN RAISE;
END;
/
--- STGAP00007714 Ends Here ---

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (298, 'SacwisRev2', 'Static table updates and a new trigger for POC');

commit;