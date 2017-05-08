--STGAP00015845 - Release(3.5) CAPTA: CDNFSI New Messages

-- New Help messages for CDNFSI Page.
INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60717,'MSG_SIDS_HELP',
       'Sudden Infant Death Syndrome; a definition of exclusion, after a thorough death scene investigation, complete review of the medical history, and a complete autopsy, the cause of death still cannot be determined.  SIDS does not apply to a child over the age of 12 months.', 700, 500, 'N');


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60718,'MSG_SUID_HELP',
       'Sudden Unexplained Infant Death; similar to SIDS, but there is one or more contributing factors that may have been related to the death (example: bed-sharing, inappropriate sleep environment for the infant, or drug exposure in the air or environment).  SUID does not apply to any child over t
he age of 12 months.', 700, 500, 'N');


INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60719,'MSG_MEDI_HELP',
       'Condition diagnosed prior to death refers to the identification of disease or symptoms of a condition(s) that lead up to the death.  A diagnosed condition is not necessarily the immediate cause of death.  List both diagnosed condition and cause on the review form.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE ( NBR_MESSAGE, TXT_MESSAGE_NAME,TXT_MESSAGE,
                           CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES (60720,'MSG_COMMENT_REQD',
       'Comments are required.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (782, 'SacwisRev3', 'Release 3.5 - DBCR 15845');

commit;

