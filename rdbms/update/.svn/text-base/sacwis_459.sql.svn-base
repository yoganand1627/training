--STGAP00013444 - New columns to Payment_Of_Care and new rows to foster care rate

--Note:  no impact to ado conversion


--Per MR - 033
--Add new columns to Payment_Of_Care Table and Add new rows to Foster_Care_Rate as 
--per the table in CFIN04B Relative Care Invoicing Batch Design.

-- Adding columns to payment_of_care table

    ALTER TABLE caps.payment_of_care
    add (ind_80_Per_Diem varchar2(1),
     ind_100_Per_Diem varchar2(1),
     ind_custom_waiver varchar2(1),
     amt_waiver number(7,2),
     txt_waiver_reason varchar2(300));

-- Inserting rows to foster_care_rate table.

     insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('55099', '005', 88.82, '06/30/2009', '07/01/2008');

     insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('55099', '612', 100.38, '06/30/2009', '07/01/2008');

     insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('55099', '13P', 114.37, '06/30/2009', '07/01/2008');

     insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('55299', '005', 88.82, '06/30/2009', '07/01/2008');

       insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('55299', '612', 100.38, '06/30/2009', '07/01/2008');

     insert into caps.foster_care_rate fcr
     (cd_fcare_rate_service, cd_age_range, amt_fcare_rt_unit_rate,
      dt_fcare_rt_end, dt_fcare_rt_start)
     values
     ('55299', '13P', 114.37, '06/30/2009', '07/01/2008');


--STGAP00013427 - DBCR - Per STGAP00013411 Insert a new value

--Note:  no impact to ado model


--Per STGAP00013411:

--Permanent Custody to a Third Party should display in the reason drop down as per design document.

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CCLOSFCC', 'PCT', 'Permanent Custody to a Third Party');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (460, 'SacwisRev3', 'Release 3.1 - DBCRs 13427,13444');

commit;


