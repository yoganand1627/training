
--change 291
-- CSTATUS

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSTATUS','NEW','New',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSTATUS','ONG','Ongoing',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSTATUS','NOP','No Progress',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSTATUS','ACH','Achieved',SYSDATE);

-- CCGRU

INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','PHY','Child/ren must be safe from physical harm.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','SXA','Child/ren must be safe from sexual contact.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','EMO','Child/ren must be safe from emotional harm.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','NEG','Parent must demonstrate ability to care for and supervise child/ren. ',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','MED','Parent must demonstrate ability to care for child/rens medical needs.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','EDU','Parent must ensure that child/ren attend school on a daily basis.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','ABA','Parent must demonstrate interest in and ability to care for child/ren.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','SUA','Parent must become and remain alcohol/drug free.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CCGRU','MPP','Parent must demonstrate capacity and ability to care for and supervise child/ren.',SYSDATE);

-- CCGNRU

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGNRUN','FWR',' Child will have a permanent living arrangement with a fit and living relative. ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGNRUN','ADO',' Child will have a permanent family through adoption. ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGNRUN','LTF',' Child will have a permanent living arrangement through long-term foster care. ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGNRUN','EMA',' Child will obtain a permanent living arrangement through emancipation. ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGNRUN','GUA',' Child will have a permanent living arrangement through guardianship. ',SYSDATE);

-- CCGWTLP

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','MHS','Youth will graduate from middle/high school.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','LSK','Youth will continue learning life skills.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','HIS','Youth will graduate from high school.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','GED','Youth will earn his/her GED.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','LSA','Youth will continue learning life skills.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','WES','Youth will have work experience.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','WEE','Youth will continue getting work experience.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','PSP','Youth will begin preparing for college.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCGWTLP','PSA','Youth will complete his/her post-secondary education (Technical degree, with other certification).',SYSDATE);

-- CCGDFCS

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) 
VALUES('CCGDFCS','DSG','DFCS will ensure that the medical, dental, educational, and psychological needs of the child are met.',SYSDATE);

-- CRUPA

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','DSP','DFCS must schedule appointments for psychological evaluation, psychiatric evaluation, and counseling with licensed provider, if indicated.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PMA','Parent must attend and successfully complete psychological evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PSP','Parent must attend and successfully complete psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PAC','Parent must attend and successfully complete counseling sessions as indicated by psychological and/or psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PTM','Parent will take all prescribed medications as recommended by licensed treatment provider.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PFR','Parent will follow all recommendations of licensed treatment provider.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','DPR','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PSA','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PPC','Parent must attend and successfully complete all parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUPA','PNH','Parent will use non-harmful methods of discipline for child(ren).',SYSDATE);

-- CRUSA

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','PNR','Perpetrator must not reside in home or have contact with child/ren (Note - this step may interrelate with the visitation section of the Case Plan Report).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','DPE','DFCS must schedule appointments for psychological evaluation, psychiatric evaluation, psychosexual evaluation, and counseling with licensed provider, if indicated.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','PAC','Parent must attend and successfully complete psychological evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','PSP','Parent must attend and successfully complete psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','PSS','Parent must attend and successfully complete psychosexual evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','MCC','Parent must attend and successfully complete counseling sessions as indicated by psychological and/or psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','PCM','Parent will follow all recommendations of child(ren) mental and/or physical health care provider.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','DGP','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','PMS','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSA','PAM','Parent must attend and successfully complete all parenting classes.',SYSDATE);

-- CRUEA

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KML','DFCS must schedule appointments for psychological evaluation, psychiatric evaluation, and counseling with licensed provider, if indicated.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAB','Parent must attend AND successfully complete psychological evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAC','Parent must attend and successfully complete psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAD','Parent must attend and successfully complete counseling sessions as indicated by psychological and/or psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAE','Parent will follow all recommendations of licensed treatment provider.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAF','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAG','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAH','Parent must attend and successfully complete all parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEA','KAI','Parent must use non-emotionally abusive methods of interacting with child/ren during visitation.',SYSDATE);

-- CRUN

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBA','Parent must obtain and maintain a source of income/support for the child/ren.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBB','Parent must obtain and maintain stable, clean, and safe housing that is also large enough for self and child/ren.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBC','Parent must obtain childcare services or assure proper supervision of child/ren at all times.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBD','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBE','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBF','Parent must attend and successfully complete all parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBG','DFCS will give parent a referral for parent aide or family service worker.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUN','LBH','Parent will cooperate with parent aide/family service worker and follow all aides'' recommendations.',SYSDATE);

-- CRUMN

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RMA','DFCS must schedule medical appointments for child/ren.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAA','Parent must keep all scheduled medical appointments and follow all recommendations of child/rens health care provider(s).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAB','Parent must demonstrate that they can care for child/rens special medical needs (Examples - apnea monitor, diabetes, trachea tube).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAC','Parent must assure that child/rens medical, nutritional, and hygiene needs are met.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAD','Parent will ensure that child takes all prescribed medications.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAE','Parent must have telephone with local service connection (Purposes - parent can call 911, remote monitoring of apnea condition).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAF','Parent must submit proof of successful CPR training.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAG','DFCS to give parent a referral for parent aide or family service worker.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAH','Parent must cooperate with parent aide/family service worker and follow all recommendations of aide/worker.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAI','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAJ','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMN','RAK','Parent must attend and successfully complete all parenting classes.',SYSDATE);

-- CRUEDN

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEDN','JAA','Parent must ensure that child gets to school every day and on time.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEDN','JAB','Parent must provide school and DFCS with written explanation for any tardiness or absences from school.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEDN','JAC','Parent will attend all parent-teacher and/or IEP conferences and communicate with school about child/rens progress and needs.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEDN','JAD','Parent will cooperate with child/rens participation in programs deemed necessary by DFCS or school personnel (Example - mentoring services).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUEDN','JAE','Parent will follow directions of _______________.',SYSDATE);

-- CRUA

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAA','DFCS to determine underlying cause(s) of abandonment and provide appropriate services (Examples of cause could be - drugs/partying, mental impairment, poverty).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAB','DFCS must schedule appointments for psychological evaluation, psychiatric evaluation, and counseling with licensed provider, if indicated.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAC','Parent must attend and sucessfully complete psychological evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAD','Parent must attend and sucessfully complete psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAE','Parent must attend and sucessfully complete counseling sessions as indicated by psychological and/or psychiatric evaluation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAF','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAG','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUA','GAH','Parent must attend and successfully complete all parenting classes.',SYSDATE);

-- CRUSAP

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSAP','HAA','DFCS must refer parent to substance abuse/treatment center.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) 
VALUES('CRUSAP','HAB','Parent must obtain substance abuse assessment and follow all of treatment provider''s recommendations.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSAP','HAC','Parent must attend and successfully complete drug/alcohol treatment program with a licensed treatment provider.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSAP','HAD','Parent must submit to random drug screens at request, to be set up by DFCS, Court, or treatment provider, with results reported to Court.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSAP','HAE','Parent must remain drug/alcohol free for 6 consecutive months and must test negative when drug screened.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSAP','HAF','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSAP','HAG','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUSAP','HAH','Parent must attend and successfully complete all parenting classes.',SYSDATE);

-- CRUMPIP

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAA','Parent must consistently follow treatment recommendations of physical and/or mental health care provider (ie medication, therapy).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAB','Parent must take all medications prescribed by treatment provider.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAC','Parent must not drink any alcohol while taking medication.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAD','DFCS to give parent a referral for parent aide or family service worker.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAE','Parent must schedule and keep appointments with parent aide/family service worker.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAF','Parent must follow all recommendations of parent aide/family service worker.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAG','DFCS must give parent a referral for appropriate parenting classes geared to meet specialized needs of parent and/or child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAH','Parent must schedule appointments to attend parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAI','Parent must attend and successfully complete all parenting classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CRUMPIP','IAJ','Parent must successfully complete vocational training.',SYSDATE);

-- CDFCSSG

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAA','At a minimum, DFCS will visit with the child on a (indicate frequency) basis to monitor the safety, well-being, and other needs of the child.  Visits will be meaningful and in the least restrictive environment.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAB','DFCS will monitor the quality of care an ICPC placed child receives out of state by reviewing and tracking and the receipt of quarterly progress reports.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAC','DFCS will make meaningful, purposeful, and individualized contacts with the child''s family on a (indicate frequency) basis.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAD','DFCS will contact child''s school on a (indicate frequency) basis to ensure child''s educational needs are being met.  DFCS will ensure information about the child is shared between the child''s school and the placement resource.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAE','(Indicate responsible person) will schedule child''s medical, psychological, and dental appointments.  Case manager will ensure these appointments are noted in the child''s record.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAF','(Indicate responsible person) will provide transportation to medical, psychological, and dental appointments.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAG','The placement resource will ensure that the special medical, educational, or psychological needs (i.e. breathing treatments, physical therapy, speech exercises etc) of the child are met as prescribed by the provider.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CDFCSSG','BAH','The case manager will ensure that issues about the child that are raised by the placement resource are communicated to the educational, psychological, dental, or medical provider.  The case manager will likewise ensure that information from the providers is discussed with the placement resource.',SYSDATE);

-- CNRULFLR

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRULFLR','CAA','DFCS will petition for a non-reunification order from the juvenile court',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRULFLR','CAB','DFCS will complete a home evaluation of the relative who is willing to become the child''s caregiver',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRULFLR','CAC','DFCS will use FP/BP Wrap-Around funds to provide DNA testing to establish the relationship of the putative father',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRULFLR','CAD','DFCS will assist the relative in applying for TANF and other support services from the Office of Family Independence',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRULFLR','CAE','DFCS will assist the relative to obtain financial support from any appropriate sources',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRULFLR','CAF','DFCS will petition the Juvenile Court to be relieved of custody and for permanent custody to be awarded to the relative',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRULFLR','CAG','DFCS will complete the application process and authorize Relative Care Subsidy payments',SYSDATE);

-- CNRA

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAA','DFCS will notify the foster parents of the plan for termination of parental rights to allow them to decide if they wish to be considered as adoptive parents.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAB','DFCS will petition the court for termination of parental rights and request that custody be granted to {Choose DHR, specified relative, or a third party} for the purpose of adoption.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAC','Foster Parents will notify the agency of their decision as to whether or not they want to adopt the child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAD','DFCS will contract with a private provider to complete the conversion of the foster home to adoptive status.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAE','DFCS will determine the eligibility of the child for adoption assistance by completing the special needs determination, a IV-E determination, and a Level of Care determination prior to placement for adoption.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAF','DFCS will utilize all available recruitment resources to identify an adoptive resource for the child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAG','DFCS will prepare the child for recruitment activities.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAH','DFCS will contract with a private provider for the child life history.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAI','DFCS will obtain professional photographs of the child and submit along with descriptive information to My Turn Now for recruitment purposes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAJ','DFCS will evaluate studies of approved adoptive homes for possible adoptive placement.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAK','DFCS will complete pre-placement activities including presentation of the child life history to prospective parents, staffing, preparation of the child for placement, pre-placement visitaton and conducting the actual placement.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAL','DFCS will provide post-placement supervision and supportive services as needed.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAM','DFCS will complete the necessary documentation to assure the adoption is finalized in a timely manner.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRA','SAN','DFCS will complete conversion of the foster home to adoptive status.',SYSDATE);

-- CNRPPLFC

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLFC','PAA',' DFCS will petition the Juvenile Court for a non-reunification order.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLFC','PAB',' DFCS will assure the long-term foster care agreement is signed by both the foster parents and the child.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLFC','PAC','DFCS will provide services to support the child in following the provisions of the Written Transitional Living Plan (in cases where the child is 14 or older).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLFC','PAD','The child will comply with the Written Transitional Living Plan to prepare him/her for independent living as an adult.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLFC','PAE','The placement provider will assist the child in following the steps of the Written Transitional Living Plan.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLFC','PFA','All persons will complete and sign the long term foster care agreement.',SYSDATE);

-- CNRPPLE

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLE','VAA','DFCS will petition the Juvenile Court for a non-reunification order.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLE','VAB','DFCS will assure that the child has the most stable placement possible to allow him/her to work toward independence.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLE','VAC','DFCS will begin planning immediately for the child to move into a protective environment upon reaching the age of 18.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRPPLE','VAD','The child will comply with the Written Transitional Living Plan to prepare him/her for independent living as an adult.',SYSDATE);

-- CNRG

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRG','NAA','DFCS will petition for a non-reunification order from the juvenile court.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRG','NAB','DFCS will complete a home evaluation of the person who is willing to become the child''s guardian.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRG','NAC','DFCS will work with the parent to obtain consent to the guardianship ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRG','NAD','DFCS will continue to pursue a more permanent living arrangement until the guardianship is in place.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRG','NAE','The potential guardian will petition the probate court to be appointed guardian ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRG','NAF','After guardianship has been established, DFCS will petition the Juvenile Court to be relieved of custody.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRG','NAG','DFCS will provide supervision of the placement as requested by the guardian for _____ months. (Should be very short-term intervention.).',SYSDATE);

-- CWMHSFF

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWMHSFF','ZAA','Youth will attend school daily, with no unexcused absences.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWMHSFF','ZAB','Youth will complete all assignments on time ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWMHSFF','ZAC','Youth will study at least ___________ minutes/hours per day, _______ days per wee.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWMHSFF','ZAD','Youth will maintain at least _____________ (e.g., passing grades in all classes; an overall B average; a B in each class).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWMHSFF','ZAE','Youth will maintain contact with his/her school guidance counselor regarding academic track, credits needed for graduation, etc.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWMHSFF','ZAF','Youth, foster parent and SSCM will determine need for tutoring, and SSCM will contact ILP Coordinator for funding, if necessary, for the next six (6) months.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWMHSFF','ZAG','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWLSFF

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSFF','WAA','Youth will participate in an ILP orientation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSFF','WAB','Youth will continue being responsible for his/her chores at home.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSFF','WAC','Youth will attend ILP activities, when possible.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSFF','WAD','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWHSSO

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAA',' Youth will attend school daily_________________ with no unexcused absences ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAD','Youth will complete all assignments on time.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAC','Youth will study at least ___________ minutes/hours per day, _______ days per week.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAB','Youth will maintain at least _____________ (eg, passing grades in all classes; an overall B average; a B in each class).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAE','Youth will maintain contact with his/her school guidance counselor regarding academic track, credits needed for graduation, etc.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAF','Youth, foster parent and SSCM will determine need for tutoring, and SSCM will contact ILP Coordinator for funding, if necessary.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAG','Youth will take advantage of tutoring services available at the group home.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAH','Youth will register for summer/night school, by the deadline (or, by specific date).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAI','Youth will prepare for, take and pass the writing section/subject sections of the Georgia High School Graduation Test, in (fill in month/year).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAJ','Youth will send a copy of his/her high school diploma to ___________ County DFCS Case Manager and ILP Coordinator, within 10 days after receiving it.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWHSSO','MAK','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWSO

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWSO','YAA','Youth will find out all details regarding classes (cost, registration, class dates/times, etc.).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWSO','YAB','Youth will register for GED classes.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWSO','YAC','Youth will take pre-test(s) and attend GED classes as scheduled, for the next six (6) months, or until he/she is ready to take GED test(s) per agreement of instructor.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWSO','YAD','Youth will send a copy of his/her GED certificate to_________ County DFCS Case Manager and ILP Coordinator, within 10 days after receiving it.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWSO','YAE','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWLSSO

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAA','Youth will participate in an ILP orientation.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAB','Youth will attend ILP activities, when possible.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAC','Youth will open a savings account.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAD','Youth will develop a personal budget.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAE','Youth will follow his/her budget, revising as necessary.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAF','Youth will (be responsible for/assist with) planning, shopping, preparing and cleaning up at least _____meal(s) per week.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAG','Youth will be responsible for doing his/her own laundry.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWLSSO','UAH','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWWEJS

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEJS','EAA','Youth will submit applications for at least __________ (fill in a number) jobs per week, until he/she is hired.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEJS','EAB','Youth will follow-up each job application within one (1) week (unless instructed otherwise by potential employer), until he/she is hired.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEJS','EAC','Once hired, youth will demonstrate acceptable job performance.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEJS','EAD','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWWEE

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEE','TAA','Youth will maintain part-time employment.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEE','TAB','As long as grades are maintained at the level specified for a high school student, youth will maintain part-time employment.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEE','TAC','Youth will continue demonstrating acceptable job performance.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWWEE','TAD','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWPSEP

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAA','Youth will request a test fee waiver from school guidance counselor.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAB','If test fee waiver is not available from school guidance counselor, then youth will ask case manager to request test fee payment from ILP Coordinator.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAC','Youth will register for the ____ (fill in PSAT,  SAT, ACT or other) by _____ (fill in a specific date, which is an actual deadline for SAT; or, if deadline is unknown, fill in a date reflecting a reasonable amount of time to do so, such as two weeks; or, will register for the  next available SAT (or ACT, etc.) by the regular deadline, within the next six (6) months.).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAD','Youth will notify his/her case manager within ___(fill in a number)days that (s)he has registered for the __________(fill in PSAT,  SAT, ACT or other test) in order to ask that his/her case manager request ILP Coordinator to provide a study guide for the ________(fill in PSAT, SAT, ACT or other test).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAE','Youth will prepare for the ________(fill in PSAT, SAT, ACT, or other test) by ________________(using study guide provided by ILP Coordinator, attending test preparation class(es,) working on-line at test preparation web site(s,) or other means,) at least _______(fill in a number) minutes/hour(s) per day/week, until________(fill in actual test date).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAF','Youth will attend a PROBE Fair at (specify location) on (specify date) in order to talk to college representatives and obtain printed and other college material.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAG','Youth will attend T.A.G. (Targeting Academic Goals) DAY AT  (specify location) ON(specify DATE).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAH','Youth will identify at least _______ (number of colleges) to research (specify date, considering current high school needs; usually by late summer preceding senior high school year.).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAI','Youth will obtain and review information (catalog/application) from the colleges identified.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAJ','Youth will submit applications to at least _______ (number) of colleges (or name specific college(s) and others un-specified).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAK','Youth will send case manager and ILP Coordinator copy of acceptance letter, within five (5) days of receiving it.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAL','Case manager will submit Financial Assistance Request form to ILP Coordinator for any and all post-secondary needs.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAM','Youth will satisfy any and all requirements set by ILP Coordinator as condition(s) for receiving ILP financial assistance for post-secondary education expenses.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAN','Youth will submit Free Application for Federal Student Aid (FAFSA,) by (specify date, usually between January 1 and April 1 of the student''s senior year in high school).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAR','Youth will comply with all other financial aid requirements of his/her college, within deadline(s) set by the college.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAP','Youth will research and apply for scholarships and other grants for which he/she may be eligible.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEP','QAQ','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- CWPSEA

INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAA','Youth will attend classes as scheduled ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAB','Youth will complete all assignments on time ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAC','Youth will study at least ___________ minutes/hours per day, _______ days per week.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAD','Youth will maintain at least _____________ (eg, passing grades in all classes; a 3.0 grade point average;  in each class).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAE','Youth will maintain contact with his/her academic advisor regarding credit hours needed for graduation, etc.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAF','Youth will seek help, if needed, for academic classes, adjusting to college life, or other needs ',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAG','Case manager will submit Financial Assistance Request form to ILP Coordinator for any and all post-secondary needs.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAH','Youth will satisfy any and all requirements set by ILP Coordinator as condition(s) for receiving ILP financial assistance for post-secondary education expenses.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAI','Youth will send copies of his/her grades to ILP Coordinator and Case Manager within five (5) days of receiving them.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAJ','Youth will maintain current status with Free Application for Federal Student Aid (FAFSA).',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAK','Youth will comply with all other financial aid requirements of his/her college, within deadline(s) set by the college.',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CWPSEA','FAL','The Independent Living Program (ILP) will assist in completion of this goal, however possible, within policy guidelines, including financial assistance, until completed.',SYSDATE);

-- change 312
UPDATE CAPS.TASK SET TXT_EVENT_DETAIL_URL='/subcare/ChildPlan/displayFccpChild' 
WHERE CD_TASK IN (8660,3160);

-- change 313
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60122, 'MSG_NEEDS_OUTCOMES_DETAIL_REQ' 
,'A Needs And Outcomes Detail is required to save Needs And Outcomes',500,700,'N');

-- change 314
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60123, 'MSG_SVC_PROV_EXP_REQ' 
,'Explanation is required when services have not been provided.',500,700,'N'); 


INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60124, 'MSG_NEED_NOT_MET_EXP_REQ' 
,'Explanation is required when the needs have not been met.',500,700,'N');

-- change 315
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60130, 'MSG_PRGM_CNTY' 
,'Enter either Program or County to perform the search.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60131, 'MSG_BUD_CNTY' 
,'The county entered is outside of your responsibility.',500,700,'N');

-- change 316
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CCTPLNTY','AFC','Aftercare', SYSDATE);

-- change 317
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60125, 'MSG_FCE_HLTH_INS_COV_PRNPL_CHILD' 
,'You indicated the child is covered by health insurance other than Medicaid.  Please select the child in the ‘Principals Covered by Health Insurance Policy’ list.',500,700,'N'); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60126, 'MSG_FCE_HLTH_INS_COV_AUTH_REQ' 
,'You indicated the child is covered by health insurance other than Medicaid.  Please acknowledge the Authorization statements in the ‘Authorization’ section.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60127, 'MSG_FCE_HLTH_INS_AUTH_DATE_CURR' 
,'Date of Authorization must be on or before current date.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60128, 'MSG_FCE_HLTH_INS_NO_AUTH_STMT_DATE' 
,'A Date of Authorization has been entered, but the corresponding Authorization statement has not been acknowledged.',500,700,'N'); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60129, 'MSG_FCE_HLTH_INS_COV_REQ' 
,'The Health Insurance Coverage question must be answered.',500,700,'N');

-- change 318
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','PHY','Physical Abuse',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','SXA','Sexual Abuse',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','EMO','Emotional Abuse',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','NEG','Neglect',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','MED','Medical Neglect',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','EDU','Educational Neglect',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES ('CRURSN', 'ABA', 'Abandonment', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','SUA','Substance abuse by parent',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','MPP','Medical/Physical impairment of parent',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE,dt_last_update) VALUES('CRURSN','OTH','Other',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRRSN','FWR','Live with Fit anf Willing Relatives',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRRSN','ADO','Adoption',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRRSN','LTF','Another Planned Perm. Living Arr. - Long term Foster Care',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRRSN','EMA','Another Planned Perm. Living Arr. - Emancipation',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRRSN','GUA','Guardianship',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CNRRSN','XXX','Other',SYSDATE);

-- change 319
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60132, 'MSG_NO_CHILD_PART_EXPL', 'Explain why there is no child participation in this development of this case plan.', 500, 700, 'N');

-- change 322
insert into CAPS.codes_tables  (code_type,code,decode)values('CDSIREFL','FMI','Family Interview'); 
insert into CAPS.codes_tables  (code_type,code,decode)values('CDSIREFL','CFP','CCFA Provider'); 
insert into CAPS.codes_tables  (code_type,code,decode)values('CDSIREFL','SCR','Secondary Referral'); 
insert into CAPS.codes_tables  (code_type,code,decode)values('CDSIREFL','SSS','State System Search'); 
insert into CAPS.codes_tables  (code_type,code,decode)values('CDSIREFL','ITS','Internet Search'); 
insert into CAPS.codes_tables (code_type,code,decode)values('CDSIREFL','XXX','Other');

-- change 323
insert into caps.codes_tables  (code_type,code,decode)values('CDSICONT','INT','Interested'); 
insert into caps.codes_tables  (code_type,code,decode)values('CDSICONT','NIN','Not Interested'); 
insert into caps.codes_tables  (code_type,code,decode)values('CDSICONT','PFI','Possible Future Interest'); 
insert into caps.codes_tables  (code_type,code,decode)values('CDSICONT','AMB','Ambivalent'); 
insert into caps.codes_tables  (code_type,code,decode)values('CDSICONT','OTH','Other');

-- change 324
insert into caps.metaphor 
(id_tab,txt_tab_url,txt_tab_constant,txt_tab,dt_last_update)values('1500','/person/DiligentSearch/displayDiligentSearchList','DILIGENT_SEARCH_DILIGENTSEARCH','Diligent Search',sysdate);

-- change 326
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) 
VALUES('CPGLICTP','ESH','Emergency Shelters'); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) 
VALUES('CPGLICTP','IDL','Independent Living'); 

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) 
VALUES('CPGLICTP','STP','Specialty Treatment Programs');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (124, 'SacwisRev2', 'static updates');
                         
commit;
