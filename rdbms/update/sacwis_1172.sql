--STGAP00017713 - Release(N/A) Per 17712 - Add 2 new columns to ext_documentation

-- Per ClearQuest STGAP00017712 add 2 columns to table caps.ext_documentation for storing the information returned on uploading the file.

ALTER TABLE CAPS.EXT_DOCUMENTATION
ADD (
   UCM_DID VARCHAR2(20),
   IS_UCM_FILE VARCHAR2(1) DEFAULT 'N'
 );

 comment on column CAPS.EXT_DOCUMENTATION.UCM_DID is 'ID of the document stored on the UCM Server';

 comment on column CAPS.EXT_DOCUMENTATION.IS_UCM_FILE is 'Indicates whether file is stored on UCM Server or not';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1173, 'SacwisRev5', 'Release N/A - DBCR 17713');

