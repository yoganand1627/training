--STGAP00017075 - Release(5.0) MR-095 Person Relationships Add New Messages

-- MR-095 Person Relationships Add New Messages
INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
values
(0,SYSDATE,60907,'MSG_COMPLT_FC_PRN_LIST_WARN',
'Please complete the Foster Care Principal List for FCC Stage section. The section will no longer display after the initial save.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
values (0,SYSDATE,60908,'MSG_CONFIRM_CP_SECTION_MISMATCH',
'Your selection does not match the Relationship selected in the Caregiver/Parental Relationship Information for Child section on Person Detail. Click OK to continue or Cancel to modify.',
700,500,'N');

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
values
(0,SYSDATE,60909,'MSG_PRN_REQ_FOR_REM_CHILD_ERR',
'Principal relationship is required when removing a child.',
700,500,'N');


INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
values
(0,SYSDATE,60910,'MSG_UNKNOWN_GENDER_WARN',
'One or more Principals in this stage has an Unknown Gender. Please select the correct Gender before proceeding.',
700,500,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1093, 'SacwisRev5', 'Release 5.0 - DBCR 17075');

commit;
