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
insert into POST VALUES(1, 'My first post', 'Kevin Bowersox', 1, '2012-10-12');
insert into POST VALUES(2, 'My first post', 'Kevin Bowersox', 2, '2012-10-12');
insert into POST VALUES(3, 'My first post', 'Kevin Bowersox', 3, '2012-10-12');
insert into POST VALUES(4, 'My first post', 'Kevin Bowersox', 4, '2012-10-12');

insert into POST_TAG VALUES(1, 1);
insert into POST_TAG VALUES(1, 2);
insert into POST_TAG VALUES(2, 1);
insert into POST_TAG VALUES(3, 2);