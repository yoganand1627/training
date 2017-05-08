-- change STGAP00006029

UPDATE caps.Professional_assmt p SET (id_case) =
      (SELECT id_case FROM caps.Event
         WHERE id_event = p.id_event) WHERE p.id_case IS NULL;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (252, 'SacwisRev22', 'datafix with 2.2 dependency for Professional_assmt');                                    
commit;

