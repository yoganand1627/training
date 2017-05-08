

-- Standard Alter Table SQL

ALTER TABLE CAPS.RISK_FACTORS_LOOKUP ADD AREA_CONCERN_TXT VARCHAR2(2000)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 194 R2/R1
INSERT INTO CAPS.MESSAGE (TXT_MESSAGE_NAME , TXT_MESSAGE ,NBR_MESSAGE ,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
  VALUES ('MSG_RESPONSE_TIME_IND_REQ' , 'Was Response Time Met? -  Field is required . Please select a Value.',60062,700,500,'N' );

-- change 196 R2 ONLY
-- !! R2 DB UPDATE ONLY !! -- 

-- Shift R1 Security Attributes ----------- 
UPDATE CAPS.CODES_TABLES 
SET code='BN' 
WHERE code_type='CSECATTR' 
AND code='CA'; 

UPDATE CAPS.CODES_TABLES 
SET code='BO' 
WHERE code_type='CSECATTR' 
AND code='CB'; 

UPDATE CAPS.CODES_TABLES 
SET code='BP' 
WHERE code_type='CSECATTR' 
AND code='CC'; 

UPDATE CAPS.CODES_TABLES 
SET code='BQ' 
WHERE code_type='CSECATTR' 
AND code='CD'; 

UPDATE CAPS.CODES_TABLES 
SET code='BR' 
WHERE code_type='CSECATTR' 
AND code='EM'; 

-- Shift R2 Security Attributes ----------- 
UPDATE CAPS.CODES_TABLES 
SET code='CA' 
WHERE code_type='CSECATTR' 
AND code='CE'; 

UPDATE CAPS.CODES_TABLES 
SET code='CB' 
WHERE code_type='CSECATTR' 
AND code='CF'; 

UPDATE CAPS.CODES_TABLES 
SET code='CC' 
WHERE code_type='CSECATTR' 
AND code='CG'; 

UPDATE CAPS.CODES_TABLES 
SET code='CD' 
WHERE code_type='CSECATTR' 
AND code='CH'; 

UPDATE CAPS.CODES_TABLES 
SET code='CE' 
WHERE code_type='CSECATTR' 
AND code='CI'; 

UPDATE CAPS.CODES_TABLES 
SET code='CF' 
WHERE code_type='CSECATTR' 
AND code='CJ'; 

UPDATE CAPS.CODES_TABLES 
SET code='CG' 
WHERE code_type='CSECATTR' 
AND code='CK'; 

UPDATE CAPS.CODES_TABLES 
SET code='CH' 
WHERE code_type='CSECATTR' 
AND code='CL'; 

UPDATE CAPS.CODES_TABLES 
SET code='CI' 
WHERE code_type='CSECATTR' 
AND code='CM';

-- change 197 R2/R1
INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60063,'MSG_INTK_ALLG_INTK_DT_GT_TODAY','Date of Alleged Incident must be less than or equal to Current Date', 
700,500,'N');

-- change 198 R2/R1
-- update newly added column to RISK_FACTORS_LOOKUP to hold Area of Concern Description
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Caregivers act without thinking, respond impulsively to emotions, and/or are unable to see logical consequences for spontaneous behaviors, etc.' where cd_factor='R10';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Overly severe discipline or giving punishment that does not relate to the act or punishment that the child can''t possibly understand.  Some examples include spanking for little or no reason, excessive physical discipline, forcing the child to perform extraneous activities for extended periods, or force feeding a child for spilling food.' where cd_factor='R11';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question is intended to measure how well the caregivers cope with stress, not the amount of stress they are experiencing.  Some indications of not dealing well with stress include sleeplessness, indecisiveness, abuse of drugs/alcohol, inability to concentrate, depression, confusion, isolation, or lashing out physically/verbally toward others, etc.' where cd_factor='R12';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question asks for either behavioral indicators that a caregiver is suffering from a mental illness or a history of diagnosed mental illness.' where cd_factor='R13';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question asks for either behavioral indicators that a caregiver is suffering from an impairment in mental capacity or a diagnosis of mental impairment.' where cd_factor='R14';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Any history of drug/alcohol abuse is significant. This history can be based on behavioral indicators as well as client admitted history or that confirmed by others.' where cd_factor='R15';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question relates to the caregiver''s perception that he/she was abused or neglected as a child. Prior CPS records or other reliable sources may confirm the abuse or neglect.' where cd_factor='R16';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Caregivers who do not have the knowledge to recognize when a child''s behavior is age appropriate or understand the major milestones in a child''s development.  They see changes/developments as a challenge to their authority rather than a normal process.  For instance, believing a child is crying to deliberately aggravate the caregiver or to challenge their authority instead of understanding that a baby cries because it wants something and has no other way to communicate. Another indication would be a caregiver assuming that a child has an understanding of language beyond the child''s age.' where cd_factor='R07';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Caregivers either fail to acknowledge any child''s basic needs for food, clothing, or shelter or make assumptions that are not in accord with what the child is developmentally capable of doing/feeling. Examples include, but are not limited to, leaving children alone or assigning child-care to children who aren''t capable, assigning motivations to children''s behaviors that aren''t developmentally appropriate, expecting a young child to prepare own meals, or expecting a child with mental retardation to comply with multi-step instruction, etc' where cd_factor='R08';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='There are indications that caregivers have a poor ability to manage children''s behavior and/or meet children''s needs, may not recognize dangers, may demonstrate poor judgment, or may lack nurturing. May have good intentions but simply don''t know how to apply these intentions in a practical manner.' where cd_factor='R09';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='The child''s behavior is hostile, aggressive, disturbed, fussy or irritable given ordinary circumstances. Examples include, but are not limited to, children who lash out at peers, cruelty to animals, fire setting, bed wetting beyond what is developmentally appropriate and excessively angry/ill-tempered or fussy (e.g., inconsolable) responses to routine situations.' where cd_factor='R05';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Consider how the child''s behavior is perceived by the caregivers and how that perception contributes to the caregiver''s treatment of the child. Examples include, but are not limited to, a caregiver who is provoked by even normal child’s behavior such as an infant''s crying or who makes inappropriate sexual advances while blaming the child.' where cd_factor='R06';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Given the child''s age, mental and physical conditions, consider the likelihood that any child will be able to avoid an abusive/neglectful situation.  Examples include, but are not limited to, indications that a child would be unable to recognize and flee a dangerous situation or seek outside protective resources such as telling a relative, teacher, etc' where cd_factor='R01';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Child requires more than normal age-appropriate care for any reason, such as physical disability, developmental delay or mental retardation. Examples include, but are not limited to, special medical needs (e.g., chronic asthma, diabetes, etc.), physical/emotional difficulties, attention deficit/hyperactivity, learning disability, combative or self-destructive behaviors, etc.' where cd_factor='R02';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Evaluate all caregivers regarding their ability and willingness to protect. Consider indications of any physical, mental, or emotional condition that might hinder the caregiver''s ability to protect even if the caregiver is willing to do so.  Also consider a caregiver’s ability to protect even if the caregiver is willing to do so.  Also consider a caregiver''s unwillingness to protect by virtue of lack of caring for the child or being afraid of the perpetrator. Indications of an inability or unwillingness to protect might be repeated missed medical appointments, repeated failure to provide a protective environment, or continuing to allow access to the child those who pose a threat to the child''s safety.' where cd_factor='R03';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Consider the likelihood that any alleged perpetrator will come into contact with the child in a caregiver capacity. Consider whether absences such as incarceration, hospitalizations, or other separations will deny the alleged perpetrator access to the child in the foreseeable future.' where cd_factor='R04';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='There are indications that crowded home conditions contribute to confusion or chaos with regard to who might be responsible for young children at any given point in time. For example, the number of persons in the household make it easy to assume that someone is watching young children when, in fact, no one is.' where cd_factor='R41';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Conditions in or around the home are unsanitary or hazardous to the point that health considerations apply.  Examples would include, but are not limited to, major infestations of roaches, lice, and fleas, maggot-ridden garbage, rotten food accessible to children, or feces in the home. Hazardous living conditions include but are not limited to, broken glass, open furnaces, exposed electrical wires, buckets of water, unsupervised access to bodies of water, easy access to household chemicals, living in a drug house, or living in a condemned home.' where cd_factor='R42';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Any behaviors which cause or could cause a threat to the safety of a child. Includes, but is not limited to, drug dealing, excessive drinking or intoxication, access to firearms, extreme rage, fights with others, domestic violence, etc.' where cd_factor='R43';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Consider whether normal developmental milestones, stressful to any caregiver, are perceived as inordinately stressful to any caregiver or taken as personal affronts to their ability to parent rather than attempts by the child to work through a stage.  Examples of childhood behaviors reflecting these developmental milestones include, but are not limited to, colicky babies, saying No, temper-tantrums, separation/individuation, importance of peer relationships/alliances, and teenage acting-out behaviors.' where cd_factor='R39';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Has this family been burdened with life circumstances that strain their ability to cope or put the child at risk of abuse or neglect? Examples of stressful events include but are not limited to care giving of a sick/elderly family member, birth or death of a family member, unemployment, loss of support network, moving/eviction, loss of transportation and legal problems. Be alert to the issues that may be worrying the family. Take into account the cultural context of the stressor and whether the cultural context makes it harder to deal with the stress. For instance, a family that has to deal with a situation they never imagined could happen to them.' where cd_factor='R40';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This includes both civil and criminal reports of sexual abuse in Georgia and/or other localities regardless of the disposition or the role of the principles in those past reports.' where cd_factor='R30';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question applies to any indication of abuse or neglect within the last 6 months and is not restricted to official agency reports.  It may include statements from the child, family, community, professionals or others.' where cd_factor='R31';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This includes any CPS involvement in Georgia or in other localities regardless of the disposition.' where cd_factor='R32';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question applies to the court ordered removal of any child in Georgia or in other localities. This also includes serious incidents in licensed foster/adoptive homes.' where cd_factor='R33';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Indications of severe outcomes are those which require prompt medical attention; may require medical or psychiatric hospitalization; may endanger the child’s life; may cause permanent functional impairment, death, or disfigurement; and sexual intercourse or sexual acts performed with a child.' where cd_factor='R34';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='In assessing the current severity, evaluate whether the actual physical harm or threat of harm resulted in or could have resulted in a significant physical injury. Indications of severe harm include, but are not limited to bruises, broken bones, burns, failure to thrive, and abandonment. Indications of risk of harm include, but are not limited to throwing/shaking a child resulting in no injury, threatening a child with a gun without shooting, leaving children under 4 years of age without adequate supervision, without incident, etc.' where cd_factor='R25';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This includes babies who were born either addicted or exposed to drugs or alcohol. May be indicated by clinical tests, self report by mother/others, or observable condition of the child.' where cd_factor='R26';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='In the current investigation, are there any indications that any child suffered a physical injury or sexual abuse of any kind?' where cd_factor='R27';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This includes situations in which medical attention was obtained as well as those in which a reasonable person would have expected that medical attention was required.' where cd_factor='R28';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='In assessing this item consider indications that the maltreatment was planned or that the perpetrator derived pleasure from the maltreatment. Some examples include ritualistic abuse, abuse involving animals, cigarette burns, poisoning, Munchausen''s Syndrome by Proxy, bondage, placing a child in a tub of scalding water, or holding a child''s hand over a flame.' where cd_factor='R29';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='There are indications that the outcomes of each incident are increasing in seriousness, may be more out of control, and/or are known to more people.' where cd_factor='R35';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='There are indications that the persons involved in subsequent incidents differ or increase in number either as perpetrators or victims.' where cd_factor='R36';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='There are indications that the amount of time lapsed between incidents is decreasing whether or not officially reported.' where cd_factor='R37';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='There are indications that different types of abuse or neglect (physical abuse, neglectful supervision, etc.) are occurring in the family.' where cd_factor='R38';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='One form of lack of empathy is when the caregiver is unable to understand or participate in the child’s feelings or ideas. Another is lacking compassion for the child''s point of view. Lack of attachment is when the caregiver is emotionally distant from the child, and/or lacks affection and loyalty. Some indicators are how the caregiver describes their feelings about the child or how the caregiver responds/provides attention to the child or whether the caregiver even notices the child (e.g., appears disinterested and/or disconnected).' where cd_factor='R17';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='There are indications that the caregiver thinks only of him/herself and puts own needs above the child''s needs. Some examples include leaving children alone to be with friends, spending money for him/herself while children go without, or the need to please others is greater than the need to protect children.' where cd_factor='R18';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question asks about indications that any child is unwanted or disliked by any caregiver. This may apply to any and all children (as in not wanting to be in a parenting position at all) or may be centered around one specific child (as in a child that reminds the caregiver of a former relationship or incident).' where cd_factor='R19';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question refers to indications of deliberate and intentional mistreatment of one or more children. This may be in the form of emotional insensitivity or physical disparity but serves the purpose of singling out the child in such a way that could result in significant harm. Examples include, but are not limited to, forcing a child to do activities separate from others, humiliating acts in front of others, or verbally berating the child in the presence of others. This may or may not rise to the level of meeting the statutory definition of emotional abuse.' where cd_factor='R20';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question relates to whether any child has been sent to live with others or been unable to live with their own family for any reason. Consider the child''s age, duration of out-of-home stay, and number of out-of-home caregivers in assessing the importance of this separation in the development of the child. Examples include but are not limited to, a newborn hospitalized for an extended period, children living elsewhere during caregiver incarceration/treatment, and the caregiver chronically living elsewhere.' where cd_factor='R21';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Indications of inadequate supervision may be seen when placing a child in a situation that requires judgments or actions beyond the child''s level of maturity, physical condition, or mental abilities. An inappropriate caregiver is any person who lacks the judgment or physical ability necessary to keep the child safe from harm. This may or may not rise to the level of meeting the statutory definition of neglectful supervision.' where cd_factor='R22';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Failure to seek medical treatment or provide essential medication (e.g., for diabetes or epilepsy) could result in death, disfigurement, bodily injury, or observable impairment to the growth, development and functioning of a child. May or may not rise to the level of meeting the statutory definition of medical neglect.' where cd_factor='R23';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question addresses indications of a general disregard for the needs of the child that do not necessarily rise to the level of meeting the statutory definition of physical neglect. Some examples include, but are not limited to, non-essential medications/treatment not given, wearing clothes inappropriate for weather, neglecting basic hygiene, etc.' where cd_factor='R24';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Consider the caregiver''s ability to acknowledge a problem when being presented with factual indications that the abuse and neglect has resulted in substantial harm or risk of harm to any child in the in the home.' where cd_factor='R51';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Consider the caregiver''s ability and desire to make changes necessary to avoid further maltreatment to any child. Also consider indications that the plans for change are realistic and achievable in view of the caregive''’s circumstances.' where cd_factor='R52';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Consider the caregiver''s reaction to the CPS intervention following the initial contact. Consider their ability to participate in the investigative process when it is in the best interest of the child. Some indicators of a family''s failure to cooperate are refusing to meet with the worker or making real and genuine threats as a means to intimidate staff.' where cd_factor='R53';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Consider the caregiver''s reaction to CPS intervention following the initial contact. Consider whether the explanation is inconsistent with the injuries/incident or contrary to known facts about the case, as well as whether the family is providing evasive responses.' where cd_factor='R54';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question relates to indications that the family lacks tangible support from either the community at large or the extended biological family. For instance, isolated, unsupported families may lack avenues for learning positive parenting skills, reducing stress, and managing crises.' where cd_factor='R44';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Negative social relationships may tend to enable behaviors that negatively impact any individual within the family; for example, associations with persons who engage in criminal, anti-social, or other violent/abusive lifestyles. Negative relationships can also mean isolation from personal or social contacts as a means to control family secrets.' where cd_factor='R45';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question asks whether any person has experienced verbal, emotional, or physical intimidation or abuse at the hands of a significant other, whether or not it was reported to law enforcement.' where cd_factor='R46';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question asks whether any person has been the source of verbal, emotional, or physical intimidation or abuse of a significant other, whether or not it was reported to law enforcement.' where cd_factor='R47';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='Promotion of violence is indicated when any person in the home advocates, either through verbal or physical means, violent solutions to situations.' where cd_factor='R48';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question asks whether any caregiver has ever been either accused or convicted of any criminal act that may impact the child. These could include violent criminal acts such as assault, armed robbery, family violence, rape, sexual assault, and stalking, malicious destruction of property, arson, drug dealing, and child pornography. Other criminal acts which may impact the child include, but are not limited to, public intoxication/DWI, writing bad checks, collection of unpaid traffic violations, etc.' where cd_factor='R49';
UPDATE CAPS.RISK_FACTORS_LOOKUP set area_concern_txt='This question asks whether there are indications that one adult in the home is intimidated by another adult to the extent that any well-intentioned desire to protect a child may be ineffective if protection requires standing up to the intimidator.' where cd_factor='R50';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (111, 'SacwisRev2', 'static updates, new field for RISK_FACTORS_LOOKUP');
                         


