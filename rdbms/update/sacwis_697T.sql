--STGAP00015718 - Release(3.5) PerCAPTA_Children1stReferral add new table

--Per CAPTA_Children 1st Referral Page add new table CHILDREN_FIRST_REFERRAL

CREATE TABLE CAPS.CHILDREN_FIRST_REFERRAL
(ID_EVENT Number(16,0) not null,
DT_LAST_UPDATE Date not null,
ID_CHILD_REFERRED Number(16,0) not null,
ID_CASE Number(16,0) not null,
DT_REFERRAL_SENT Date,
IND_PARENTAL_RELEASE Varchar2(1),
IND_COMPLETE Varchar2(1),
DT_ACKNOWLEDGE Date,
DT_PHY_SUMMARY Date,
IND_FURTHER_ASSMT Varchar2(1),
DT_IFSP Date,
TXT_COMMENTS Varchar(500),
DT_GENERATION Date,
ID_GENERATION_EVENT Number(16,0),
CONSTRAINT PK_FIRST_REF_EVENT PRIMARY KEY(ID_EVENT) using index tablespace index01,
CONSTRAINT FK_FIRST_REF_EVENT FOREIGN KEY (ID_EVENT)
   REFERENCES CAPS.EVENT(ID_EVENT),
CONSTRAINT FK_FIRST_REF_CHILD_PERSON FOREIGN KEY (ID_CHILD_REFERRED)
   REFERENCES CAPS.PERSON(ID_PERSON),
CONSTRAINT FK_FIRST_REF_CASE FOREIGN KEY (ID_CASE)
   REFERENCES CAPS.CAPS_CASE(ID_CASE),
CONSTRAINT FK_GENERATION_EVENT FOREIGN KEY (ID_GENERATION_EVENT)
   REFERENCES CAPS.EVENT(ID_EVENT)
 ) tablespace data01;

create index caps.PK_FIRST_REF_CASE on CAPS.CHILDREN_FIRST_REFERRAL(id_case) tablespace index01;
create index caps.PK_FIRST_REF_CHILD on CAPS.CHILDREN_FIRST_REFERRAL(id_child_referred) tablespace index01;

comment on column CAPS.CHILDREN_FIRST_REFERRAL.ID_EVENT is 'Primary Key' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.DT_LAST_UPDATE is 'Used to record the last updated date.' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.ID_CHILD_REFERRED is 'Records the idPerson of the child referred.' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.ID_CASE is 'Records case id Foreign key to CASE.ID_CASE' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.DT_REFERRAL_SENT is 'Records the date on which referral was sent.' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.IND_PARENTAL_RELEASE is 'Indicates whether the parents agreed to release of information' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.IND_COMPLETE is 'Indicate if referral complete' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.DT_ACKNOWLEDGE is 'Acknowledgement of Referral Received' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.DT_PHY_SUMMARY is 'Physician.s Health Summary Recd' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.IND_FURTHER_ASSMT is 'Need for further Developmental Assmt' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.DT_IFSP is 'Date Individual Family Service/Treatment Plan Recd.' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.TXT_COMMENTS is 'Comments' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.DT_GENERATION is 'Date the form was saved.' ;
comment on column CAPS.CHILDREN_FIRST_REFERRAL.ID_GENERATION_EVENT is 'Event id of the Form generation event' ;

grant select,update,insert,delete on caps.CHILDREN_FIRST_REFERRAL to capson,capsbat,ops$datafix;
grant select on caps.CHILDREN_FIRST_REFERRAL to operator,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CHILDREN_FIRST_REFERRAL 
BEFORE UPDATE
ON CAPS.CHILDREN_FIRST_REFERRAL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CHILDREN_FIRST_REFERRAL
BEFORE INSERT
ON CAPS.CHILDREN_FIRST_REFERRAL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (698, 'SacwisRev3', 'Release 3.5 - DBCR 15718');

commit;

