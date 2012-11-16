CREATE TABLE TAG(
	TAG_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	NAME VARCHAR(100)
);

CREATE TABLE POST_PART(
  POST_PART_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  BODY text
);

CREATE TABLE POST(
  POST_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  TITLE VARCHAR(200) DEFAULT NULL,
  AUTHOR VARCHAR(45) DEFAULT NULL,
  POST_PART_ID INT DEFAULT NULL,
  POSTED_DT DATE DEFAULT NULL,
  FOREIGN KEY(POST_PART_ID) REFERENCES POST_PART(POST_PART_ID)
);

CREATE TABLE POST_TAG(
	POST_ID INT NOT NULL,
	TAG_ID INT NOT NULL,
	FOREIGN KEY(POST_ID) REFERENCES POST(POST_ID),
    FOREIGN KEY(TAG_ID) REFERENCES TAG(TAG_ID),
    PRIMARY KEY(POST_ID,TAG_ID)
);

CREATE VIEW V_POST AS 
select POST_ID,AUTHOR,POSTED_DT,TITLE, POST.POST_PART_ID, BODY,
substr(BODY,1,300) AS TEASER 
from POST 
join POST_PART 
on POST.POST_PART_ID = POST_PART.POST_PART_ID;

CREATE VIEW V_TAG as
select POST_TAG.TAG_ID, count(POST_TAG.TAG_ID) as COUNT, NAME
from POST_TAG
join TAG
on POST_TAG.TAG_ID = TAG.TAG_ID
group by POST_TAG.TAG_ID;

CREATE  TABLE IF NOT EXISTS IMAGE (
  IMAGE_ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(100) NULL ,
  TYPE VARCHAR(100) NULL ,
  FILE BLOB NULL ,
  PRIMARY KEY (IMAGE_ID)
);
  
CREATE TABLE skill_category (
  SKILL_CATEGORY_ID int(11) NOT NULL AUTO_INCREMENT,
  NAME varchar(100) DEFAULT NULL,
  PRIMARY KEY (SKILL_CATEGORY_ID)
);

CREATE TABLE skill (
  SKILL_ID int(11) NOT NULL AUTO_INCREMENT,
  NAME varchar(45) NOT NULL,
  RATING int(11) DEFAULT NULL,
  DESCRIPTION longtext,
  PROVIDER varchar(100) DEFAULT NULL,
  URL varchar(150) DEFAULT NULL,
  TAG_ID int(11) DEFAULT NULL,
  SKILL_CATEGORY_ID int(11) DEFAULT NULL,
  IMAGE_ID int(11) DEFAULT NULL,
  PRIMARY KEY (SKILL_ID)
);



 