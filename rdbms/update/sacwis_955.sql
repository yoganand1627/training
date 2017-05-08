--STGAP00016064 - Release(4.1) CONTACT_NARRATIVE Trigger Updates

--Query the online version of a template. Needed to support mobile updates to contact narratives.


grant select on caps.contact_narrative to operator;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CONTACT_NARRATIVE
BEFORE INSERT ON CAPS.CONTACT_NARRATIVE
FOR EACH ROW
DECLARE
   DocName    varchar2(255);
BEGIN  -- Lookup query to find the online version of a template. Needed to support mobile updates to contact narratives.
SELECT nm_document   into DocName
FROM   document_template_type dtt2,  document_template dt2
     WHERE  dtt2.id_document_template_type =  dt2.id_document_template_type
     AND  dt2.id_document_template = :new.id_document_template;

IF (substr(DocName,1,2) = 'mo') THEN
   BEGIN    -- Do the lookup to re-assign id_document_template
   SELECT id_document_template into :new.ID_DOCUMENT_TEMPLATE
     FROM   (SELECT dt.id_document_template
             FROM   document_template dt,document_template_type dtt
             WHERE  dt.id_document_template_type = dtt.id_document_template_type
               AND dt.ind_active = 1
               AND dtt.nm_document = (SELECT Ltrim(nm_document, 'mo')   -- Lookup the SHINES document type based on the mobile template
                                      FROM   document_template_type dtt2,
                                             document_template dt2
                                      WHERE  dtt2.id_document_template_type =
                                             dt2.id_document_template_type
                                             AND
                       dt2.id_document_template = :new.id_document_template)
               AND dt.nbr_major_version = (SELECT dt3.nbr_major_version
                                           FROM   document_template_type dtt3,
                                                  document_template dt3
                                           WHERE dtt3.id_document_template_type = dt3.id_document_template_type
                                           AND dt3.id_document_template = :new.id_document_template)
               AND dt.nbr_minor_version =  ( SELECT dt3.nbr_minor_version
                                             FROM   document_template_type dtt3,
                                                    document_template dt3
                                            WHERE dtt3.id_document_template_type = dt3.id_document_template_type
                                            AND dt3.id_document_template = :new.id_document_template)
               AND dt.nbr_revision =  ( SELECT dt3.nbr_revision
                                        FROM   document_template_type dtt3,
                                               document_template dt3
                                        WHERE dtt3.id_document_template_type = dt3.id_document_template_type
                                        AND dt3.id_document_template = :new.id_document_template)

               ORDER  BY dt.id_document_template DESC)
            WHERE  ROWNUM < 2;
    EXCEPTION
 WHEN OTHERS THEN
  IF SQL%NOTFOUND THEN
   :new.ID_DOCUMENT_TEMPLATE := :new.ID_DOCUMENT_TEMPLATE;
  END IF;
  END;
END IF;

:new.DT_LAST_UPDATE := SYSDATE;
SELECT ID_CASE
 INTO  :new.ID_CASE
 FROM  EVENT
 WHERE  ID_EVENT = :new.ID_EVENT;
EXCEPTION
 WHEN OTHERS THEN
  IF SQL%NOTFOUND THEN
   :new.ID_CASE := NULL;
  END IF;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CONTACT_NARRATIVE
BEFORE UPDATE ON CAPS.CONTACT_NARRATIVE
FOR EACH ROW
DECLARE
   DocName    varchar2(255);

BEGIN
:new.DT_LAST_UPDATE := SYSDATE;

-- Lookup query to find the online version of a template. Needed to support mobile updates to contact narratives.
SELECT nm_document   into DocName
FROM   document_template_type dtt2,  document_template dt2
     WHERE  dtt2.id_document_template_type =  dt2.id_document_template_type
     AND  dt2.id_document_template = :new.id_document_template;

IF (substr(DocName,1,2) = 'mo') THEN
   BEGIN    -- Do the lookup to re-assign id_document_template
   SELECT id_document_template into :new.ID_DOCUMENT_TEMPLATE
     FROM   (SELECT dt.id_document_template
             FROM   document_template dt,document_template_type dtt
             WHERE  dt.id_document_template_type = dtt.id_document_template_type
               AND dt.ind_active = 1
               AND dtt.nm_document = (SELECT Ltrim(nm_document, 'mo')   -- Lookup the SHINES document type based on the mobile template
                                      FROM   document_template_type dtt2,
                                             document_template dt2
                                      WHERE  dtt2.id_document_template_type =
                                             dt2.id_document_template_type
                                             AND

                       dt2.id_document_template = :new.id_document_template)
               AND dt.nbr_major_version = (SELECT dt3.nbr_major_version
                                           FROM   document_template_type dtt3,
                                                  document_template dt3
                                           WHERE dtt3.id_document_template_type = dt3.id_document_template_type
                                           AND dt3.id_document_template = :new.id_document_template)
               AND dt.nbr_minor_version =  ( SELECT dt3.nbr_minor_version
                                             FROM   document_template_type dtt3,
                                                    document_template dt3
                                            WHERE dtt3.id_document_template_type = dt3.id_document_template_type
                                            AND dt3.id_document_template = :new.id_document_template)
               AND dt.nbr_revision =  ( SELECT dt3.nbr_revision
                                        FROM   document_template_type dtt3,
                                               document_template dt3
                                        WHERE dtt3.id_document_template_type = dt3.id_document_template_type
                                        AND dt3.id_document_template = :new.id_document_template)

               ORDER  BY dt.id_document_template DESC)
            WHERE  ROWNUM < 2;
    EXCEPTION
        WHEN OTHERS THEN
                IF SQL%NOTFOUND THEN
                        :new.ID_DOCUMENT_TEMPLATE := :new.ID_DOCUMENT_TEMPLATE;
                END IF;
   END;
END IF;
END;
/



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (956, 'SacwisRev4', 'Release 4.1 - DBCR 16064');

commit;



