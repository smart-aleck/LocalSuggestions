INSERT INTO `local_suggestions`.`audit` (`id`,`userId`,`ip`,`device`,`timestamp`,`location`,`activity`,`description`) VALUES (1,1,'127.0.0.1','MacBook',CURRENT_TIMESTAMP(),POINT(-0.1620210, 51.4346600),'LOGIN','Testing Login Audit');
INSERT INTO `local_suggestions`.`audit` (`id`,`userId`,`ip`,`device`,`timestamp`,`location`,`activity`,`description`) VALUES (2,2,'192.168.0.1','Sony Vaio',CURRENT_TIMESTAMP(),POINT(67.0099390, 24.8614620),'STAR','Star [suggestion-id 1]');
INSERT INTO `local_suggestions`.`audit` (`id`,`userId`,`ip`,`device`,`timestamp`,`location`,`activity`,`description`) VALUES (3,4,'202.3.54.9','Samsung Andriod',CURRENT_TIMESTAMP(),POINT(70.8021600, 22.3038950),'LOCAL_GEM','Adding to local gems [suggestion-id 1]');
INSERT INTO `local_suggestions`.`audit` (`id`,`userId`,`ip`,`device`,`timestamp`,`location`,`activity`,`description`) VALUES (4,1,'127.0.0.1','MacBook',CURRENT_TIMESTAMP(),POINT(-0.1620210, 51.4346600),'LOGOFF','Logging off from computer');
INSERT INTO `local_suggestions`.`audit` (`id`,`userId`,`ip`,`device`,`timestamp`,`location`,`activity`,`description`) VALUES (5,3,'10.4.5.126','iPad',CURRENT_TIMESTAMP(),POINT(-74.0059410, 40.7127840),'LOCATION_UPDATE','Location updated to POINT(51.4346600, -0.1620210)');
INSERT INTO `local_suggestions`.`audit` (`id`,`userId`,`ip`,`device`,`timestamp`,`location`,`activity`,`description`) VALUES (6,2,'192.168.0.1','iPhone',CURRENT_TIMESTAMP(),POINT(67.0099390, 24.8614620),'LOGIN','Testing Login Audit');
INSERT INTO `local_suggestions`.`audit` (`id`,`userId`,`ip`,`device`,`timestamp`,`location`,`activity`,`description`) VALUES (7,2,'192.168.0.1','iPhone',CURRENT_TIMESTAMP(),POINT(67.0099390, 24.8614620),'LOGOFF','Logging off from computer');

INSERT INTO `local_suggestions`.`action`(`id`,`actionText`,`version`) VALUES (1,'STAR',1);
INSERT INTO `local_suggestions`.`action`(`id`,`actionText`,`version`) VALUES (2,'UPVOTE',1);
INSERT INTO `local_suggestions`.`action`(`id`,`actionText`,`version`) VALUES (3,'BOOKMARK',1);

INSERT INTO `local_suggestions`.`user_decoration_override` (`id`,`userId`,`decorationId`,`decorationName`,`defaultValue`,`version`) VALUES (1,2,1,'LocationUpdate','true',1);
INSERT INTO `local_suggestions`.`user_decoration_override` (`id`,`userId`,`decorationId`,`decorationName`,`defaultValue`,`version`) VALUES (2,3,8,'PromotedSuggestions','50/month',1);

INSERT INTO `local_suggestions`.`suggestion`(`id`,`userId`,`createTime`,`subject`,`content`,`expirationTime`,`suggestionType`,`category`,`location`,`displayLocation`,`version`) VALUES (1,1,CURRENT_TIMESTAMP(),'Best Ice-Cream ever','The Ice-Cream parlour ever. The serve the best Gelato! What a wonderful hidden gem',DATE_ADD(NOW(), INTERVAL 7 DAY),'POST','FOOD',POINT(-0.1620210, 51.4346600),POINT(-0.1620210, 51.4346600),1);
INSERT INTO `local_suggestions`.`suggestion`(`id`,`userId`,`createTime`,`subject`,`content`,`expirationTime`,`suggestionType`,`category`,`location`,`displayLocation`,`version`) VALUES (2,3,CURRENT_TIMESTAMP(),'Any good Italian place around here?','Hey guys, I just moved here a few weeks ago and am really longing for some good Pizza! Yummy! Any suggestions??',DATE_ADD(NOW(), INTERVAL 7 DAY),'QUESTION','FOOD',POINT(-0.1620210, 51.4346600),POINT(-0.1276250, 51.5033640),1);
INSERT INTO `local_suggestions`.`suggestion`(`id`,`userId`,`createTime`,`subject`,`content`,`expirationTime`,`suggestionType`,`category`,`location`,`displayLocation`,`version`) VALUES (3,1,CURRENT_TIMESTAMP(),'Where can I get a good haircut?','Any suggestions folkd living around here? Who do you recommend?',DATE_ADD(NOW(), INTERVAL 7 DAY),'QUESTION','SERVICES',POINT(-0.1620210, 51.4346600),POINT(-0.1620210, 51.4346600),1);

INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(1,1,'#food',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(2,1,'#gelato',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(3,1,'#icecream',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(4,1,'#yumy',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(5,1,'#london',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(6,1,'#tooting',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(7,2,'#food',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(8,2,'#pizza',1);
INSERT INTO `local_suggestions`.`suggestion_tag`(`id`,`suggestionId`,`tag`,`version`)VALUES(9,2,'#italian',1);

INSERT INTO `local_suggestions`.`comment`(`id`,`userId`,`suggestionId`,`createTime`,`content`,`location`,`version`) VALUES (1,2,1,CURRENT_TIMESTAMP(),'Thanks for the recommendation! :)',POINT(67.0099390, 24.8614620),1);
INSERT INTO `local_suggestions`.`comment`(`id`,`userId`,`suggestionId`,`createTime`,`content`,`location`,`version`) VALUES (2,3,1,CURRENT_TIMESTAMP(),'This place is awesome',POINT(67.0077390, 24.8414720),1);
INSERT INTO `local_suggestions`.`comment`(`id`,`userId`,`suggestionId`,`createTime`,`content`,`location`,`version`) VALUES (3,4,2,CURRENT_TIMESTAMP(),'Try papa johns!',POINT(67.0077390, 24.8414720),1);

INSERT INTO `local_suggestions`.`comment_location` (`id`,`commentId`,`location`,`version`) VALUES (1,2,POINT(-0.1620210, 51.4346600),1);
INSERT INTO `local_suggestions`.`comment_location` (`id`,`commentId`,`location`,`version`) VALUES (2,2,POINT(-0.1620210, 51.4347600),1);

INSERT INTO `local_suggestions`.`suggestion_action`(`id`,`suggestionId`,`userId`,`actionId`,`location`,`version`)VALUES(1,1,2,1,POINT(-0.1620210, 51.4346600),1);
INSERT INTO `local_suggestions`.`suggestion_action`(`id`,`suggestionId`,`userId`,`actionId`,`location`,`version`)VALUES(2,1,3,1,POINT(-0.1620210, 51.4346600),1);
INSERT INTO `local_suggestions`.`suggestion_action`(`id`,`suggestionId`,`userId`,`actionId`,`location`,`version`)VALUES(3,1,4,1,POINT(-0.1620210, 51.4346600),1);
INSERT INTO `local_suggestions`.`suggestion_action`(`id`,`suggestionId`,`userId`,`actionId`,`location`,`version`)VALUES(4,2,2,2,POINT(-0.1620210, 51.4346600),1);
