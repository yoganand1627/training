--STGAP00017845 - Release(5.1) Per STGAP00017827(MR-085) Add new tables

-- Add new table to hold ICPC Detail Page values
create table CAPS.ICPC_DETAIL
(id_icpc_detail number(16) not null,
dt_last_update date not null,
dt_completed date,
id_event number(16) not null,
id_child number(16) not null,
id_primary_person number(16),
id_spouse number(16),
id_worker number(16),
ive_determ varchar2(3),
aa_funding_determ varchar2(3),
cd_icpc_form_type varchar2(3),
ind_icwa_elig varchar2(1),
ind_crt_order_af varchar2(1),
ind_crt_order_lcrp varchar2(1),
ind_crt_order_lcgr varchar2(1),
txt_other_specify varchar2(300),
cd_type_care varchar2(3),
cd_init_report_req varchar2(3),
ind_finalized_in varchar2(1),
ind_plcmt_status varchar2(1),
dt_child_placed date,
cd_plcmt_term_rsn varchar2(3),
dt_termination date,
constraint pk_ICPC primary key(id_icpc_detail) using index tablespace index01,
constraint fk_ID_EVENT foreign key(id_event) references caps.event(id_event),
constraint fk_ID_CHILD foreign key(id_child) references caps.person_enc(id_person),
constraint fk_ID_PRIMARY_PERSON foreign key(id_primary_person) references caps.person_enc(id_person),
constraint fk_ID_SPOUSE foreign key(id_spouse) references caps.person_enc(id_person),
constraint fk_ID_WORKER foreign key(id_worker) references caps.employee(id_person)) tablespace data01;

comment on table caps.ICPC_DETAIL is 'This table is used to record the data entered on ICPC Detail Page.';
comment on column caps.ICPC_DETAIL.id_icpc_detail is 'Primary Key';
comment on column caps.ICPC_DETAIL.dt_last_update is 'Used to record the last updated date';
comment on column caps.ICPC_DETAIL.dt_completed is 'Used to record the date when the ICPC page was completed';
comment on column caps.ICPC_DETAIL.id_event is 'A unique identifier to the EVENT table.';
comment on column caps.ICPC_DETAIL.id_child is 'Id of the child for whom the event was created. References PERSON table';
comment on column caps.ICPC_DETAIL.id_primary_person is 'Id of the Primary Person selected on the page, references PERSON table';
comment on column caps.ICPC_DETAIL.id_spouse is 'Id of the Spouse selected, references PERSON table';
comment on column caps.ICPC_DETAIL.id_worker is 'Id of the Case Manager who completes the page, references EMPLOYEE table';
comment on column caps.ICPC_DETAIL.ive_determ is 'IVE determination for the child';
comment on column caps.ICPC_DETAIL.aa_funding_determ is 'AA funding determination for the child';
comment on column caps.ICPC_DETAIL.cd_icpc_form_type is 'Used to store the ICPC form type';
comment on column caps.ICPC_DETAIL.ind_icwa_elig is 'Indicates if IWCA eligible is yes or no possible values Y or N';
comment on column caps.ICPC_DETAIL.ind_crt_order_af is 'Stores checkbox value for court order attached for adoption finalized values Y or N';
comment on column caps.ICPC_DETAIL.ind_crt_order_lcrp is 'Stores checkbox value for court order attached for legal custody return to parents values Y or N';
comment on column caps.ICPC_DETAIL.ind_crt_order_lcgr is 'Stores checkbox value for court order attached for legal custody given to relative values Y or N';
comment on column caps.ICPC_DETAIL.txt_other_specify is 'Used to enter reason if the compact termination reason is other';
comment on column caps.ICPC_DETAIL.cd_type_care is 'Stores codes for Type of Care';
comment on column caps.ICPC_DETAIL.cd_init_report_req is 'Initial Report Requested on 100A';
comment on column caps.ICPC_DETAIL.ind_finalized_in is 'Indicates if adoption finalized in sending or receiving values S or R';
comment on column caps.ICPC_DETAIL.ind_plcmt_status is 'Indicates intial placement or change values I or C';
comment on column caps.ICPC_DETAIL.dt_child_placed is 'Date Child Placed in Receiving State if ind_plcmt_status is I or Effective Date of Change if ind_plcmt_status id C';
comment on column caps.ICPC_DETAIL.cd_plcmt_term_rsn is 'Compact Placement Termination Reason';
comment on column caps.ICPC_DETAIL.dt_termination is 'Date of Termination';

create index caps.fk_ID_EVENT on caps.ICPC_DETAIL(id_event) tablespace index01;
create index caps.fk_ID_CHILD on caps.ICPC_DETAIL(id_child) tablespace index01;
create index caps.fk_ID_PRIMARY_PERSON on caps.ICPC_DETAIL(id_primary_person) tablespace index01;
create index caps.fk_ID_SPOUSE on caps.ICPC_DETAIL(ID_SPOUSE) tablespace index01;
create index caps.fk_ID_WORKER on caps.ICPC_DETAIL(id_worker) tablespace index01;

grant select,update,insert,delete on caps.ICPC_DETAIL to capson,capsbat,ops$datafix;
grant select on caps.ICPC_DETAIL to operator;

CREATE SEQUENCE  CAPS.SEQ_icpc_detail  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_icpc_detail  to capsbat,capson,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_icpc_detail
BEFORE UPDATE
ON CAPS.icpc_detail
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_icpc_detail
BEFORE INSERT
ON CAPS.icpc_detail
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.id_icpc_detail=0 then
    SELECT SEQ_icpc_detail.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.id_icpc_detail := dummy;
  end if;
END;
/


-- Add table ICPC_ENCLOSED_DOC_CBX
create table CAPS.ICPC_ENCLOSED_DOC_CBX
(id_icpc_enclosed_doc_cbx number(16) not null,
dt_last_update date not null,
id_icpc_detail number(16) not null,
cd_cbx_code_type varchar2(8),
cd_encl_doc varchar2(3),
constraint pk_id_icpc_enclosed_doc_cbx primary key(id_icpc_enclosed_doc_cbx) using index tablespace index01,
constraint id_icpc_detail foreign key(id_icpc_detail) references caps.icpc_detail(id_icpc_detail)) tablespace data01;

comment on table caps.ICPC_ENCLOSED_DOC_CBX is 'This table is used to record Enclosed Document checkbox values for the ICPC Page.';
comment on column caps.ICPC_ENCLOSED_DOC_CBX.id_icpc_enclosed_doc_cbx is 'Primary Key';
comment on column caps.ICPC_ENCLOSED_DOC_CBX.dt_last_update is 'Used to record the last updated date';
comment on column caps.ICPC_ENCLOSED_DOC_CBX.id_icpc_detail is 'Used to record the id of icpcdetail to which the cbx values belong';
comment on column caps.ICPC_ENCLOSED_DOC_CBX.cd_cbx_code_type is 'Used to record the cbx box codetype either required or if applicable';
comment on column caps.ICPC_ENCLOSED_DOC_CBX.cd_encl_doc is 'Used to record the actual code of the document enclosed';

create index caps.fk_ID_ICPC_DETAIL on caps.ICPC_ENCLOSED_DOC_CBX(id_icpc_detail) tablespace index01;


grant select,update,insert,delete on caps.ICPC_ENCLOSED_DOC_CBX to capson,capsbat,ops$datafix;
grant select on caps.ICPC_ENCLOSED_DOC_CBX to operator;

CREATE SEQUENCE  CAPS.SEQ_icpc_enclosed_doc_cbx  NOMINVALUE NOMAXVALUE INCREMENT
BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

grant select on CAPS.SEQ_icpc_enclosed_doc_cbx  to capsbat,capson,ops$datafix;
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_icpc_enclosed_doc_cbx
BEFORE UPDATE
ON CAPS.icpc_enclosed_doc_cbx
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_icpc_enclosed_doc_cbx
BEFORE INSERT
ON CAPS.icpc_enclosed_doc_cbx
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.id_icpc_enclosed_doc_cbx=0 then
    SELECT SEQ_icpc_enclosed_doc_cbx.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.id_icpc_enclosed_doc_cbx := dummy;
  end if;
END;
/
insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1184, 'SacwisRev5', 'Release 5.1 - DBCR 17845');

commit;
