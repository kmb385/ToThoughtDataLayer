/* POST PARTS */
insert into POST_PART(POST_PART_ID, BODY) VALUES(1, 'This is the first test');
insert into POST_PART(POST_PART_ID, BODY) VALUES(2, 'This is my test');
insert into POST_PART(POST_PART_ID, BODY) VALUES(3, 'This is my test');
insert into POST_PART(POST_PART_ID, BODY) VALUES(4, 'This is my delete test');

/* TAGS */
insert into TAG VALUES(1, 'Spring');
insert into TAG VALUES(2, 'Java');
insert into TAG VALUES(3, 'Delete');
insert into TAG VALUES(4, 'Spring Data');

/* POSTS */
insert into POST VALUES(1, 'My first post', 'Kevin Bowersox', 1, null, '2012-10-12');
insert into POST VALUES(2, 'My first post', 'Kevin Bowersox', 2, null, '2012-10-12');
insert into POST VALUES(3, 'My first post', 'Kevin Bowersox', 3, null, '2012-10-12');
insert into POST VALUES(4, 'My first post', 'Kevin Bowersox', 4, null, '2012-10-12');

insert into POST_TAG VALUES(1, 1);
insert into POST_TAG VALUES(1, 2);
insert into POST_TAG VALUES(2, 1);
insert into POST_TAG VALUES(3, 2);

insert into IMAGE VALUES(1, 'Java.png', '.png',null);
insert into IMAGE VALUES(2, 'Spring.png', '.png',null);

insert into SKILL_CATEGORY VALUES(1, 'Programming Skills');
insert into SKILL_CATEGORY VALUES(2, 'People Skills');

insert into SKILL VALUES(1, 'Java', 5, 'The Java Programming Language', 'Oracle', 'http://www.java.com', 2, 1, 1);

insert into EXPERIENCE VALUES(1, '2009-7-20', '2012-11-20', 'This is my current position', 'Web Application Developer', 'NAVSUP BSC', 1);
insert into EXPERIENCE VALUES(2, '2008-1-1', '2009-7-20', 'This is was my former position', 'Cognos Developer', 'BI Solutions', 1);

insert into EXPERIENCE_DETAIL VALUES(1, 'I wrote a bunch of clean code.', 1);
insert into EXPERIENCE_DETAIL VALUES(2, 'I worked with ORMs', 1);
insert into EXPERIENCE_DETAIL VALUES(3, 'I created a bunch of apps.', 1);
insert into EXPERIENCE_DETAIL VALUES(4, 'I wrote javascript', 2);
insert into EXPERIENCE_DETAIL VALUES(5, 'I made cognos reports', 2);

insert into EXPERIENCE_TAG VALUES(1, 1, 1);
insert into EXPERIENCE_TAG VALUES(2, 1, 2);
insert into EXPERIENCE_TAG VALUES(3, 1, 4);

insert into DEGREE VALUES(1, 'The Pennsylvania State University', 'Information Sciences and Technology', 'Design and Development', 'Bachelors of Science', '3.1', '2009-7-20','2009-7-20',0);
insert into DEGREE VALUES(2, 'The Pennsylvania State University', 'Human Resource Management and Employment Relations', 'Training and Development', 'Masters', '4.0', '2009-7-20','2009-7-20',0);

insert into DEGREE_DETAIL VALUES(1, 'Dean''s List 5 Semesters', 1);
insert into DEGREE_DETAIL VALUES(2, 'Excellent IT Student 3 Semesters', 1);

insert into COMMENT VALUES (1, 'John Doe', 'joe@gmail.com', 'www.google.com', 'This is a greate post', 3, '2012-7-20', 1);
insert into COMMENT VALUES (2, 'John Doe', 'joe@gmail.com', 'www.google.com', 'This is a greate post', 3, '2012-7-20', 1);

insert into COMMIT values (1, 'Testing commit repo', 'apiUrl1', 'htmlUrl1', 'sha1', '2013-1-3', 'A Message');
insert into COMMIT values (2, 'Testing commit repo2', 'apiUrl2', 'htmlUrl2', 'sha2', '2013-1-3', 'A Message');

insert into DATA_LOAD_LOG_ENTRY values(1, 'GITHUB', 22, '2012-7-20', '2013-1-3');
insert into DATA_LOAD_LOG_ENTRY values(2, 'STACKOVERFLOW', 32, '2012-1-20', '2013-1-7');
insert into DATA_LOAD_LOG_ENTRY values(3, 'GITHUB', 55, '2012-1-20', '2013-1-3');
