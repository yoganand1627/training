-- Sequence Alter SQL
DROP SEQUENCE CAPS.SEQ_DOCUMENT_TEMPLATE_TYPE;

CREATE SEQUENCE CAPS.SEQ_DOCUMENT_TEMPLATE_TYPE
    START WITH 1000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCACHE
    NOORDER
;

DROP SEQUENCE CAPS.SEQ_DOCUMENT_TEMPLATE;

CREATE SEQUENCE CAPS.SEQ_DOCUMENT_TEMPLATE
    START WITH 1000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    NOCACHE
    NOORDER
;

--Rename 24hour to contact24hour because of XML limitation
UPDATE CAPS.DOCUMENT_TEMPLATE_TYPE
   SET NM_DOCUMENT='contact24hour'
 WHERE NM_DOCUMENT='24hour';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (117, 'SacwisRev2', 'Document updates.');

commit;
