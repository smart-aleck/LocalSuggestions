INSERT INTO `access` (`id`,`accessText`,`version`) VALUES (1, 'BASIC', 1);
INSERT INTO `access` (`id`,`accessText`,`version`) VALUES (2, 'PRO', 1);
INSERT INTO `access` (`id`,`accessText`,`version`) VALUES (3, 'ADMIN', 1);

INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (1,1,'LocationUpdate','false',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (2,1,'SendSuggestions','3/week',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (3,1,'DefaultSuggestionExpiration','1 week',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (4,1,'PromotedSuggestions','0/month',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (5,2,'LocationUpdate','true',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (6,2,'SendSuggestions','10/week',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (7,2,'DefaultSuggestionExpiration','2 weeks',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (8,2,'PromotedSuggestions','10/month',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (9,3,'LocationUpdate','true',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (10,3,'SendSuggestions','9999/week',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (11,3,'DefaultSuggestionExpiration','1 month',1);
INSERT INTO `decoration` (`id`,`accessId`,`decorationName`,`defaultValue`,`version`) VALUES (12,3,'PromotedSuggestions','999/month',1);

INSERT INTO `user` (`id`,`displayName`,`firstName`,`lastName`,`email`,`passwordHash`,`dateJoined`,`userAccessId`,`version`) VALUES (1,'Ali Asghar','Ali','Agshar','ali.asghar@gmail.com','sha1:64000:32:tN+Ze7tufnoIfFAOCFTxcGxcRCMQ5uXibGTH5QyffTU=:UqHB7YOORnj2i+pz+M55zVCrdnvHsx5fFfCDiNscy1s=','2017-05-05',3,1);
INSERT INTO `user` (`id`,`displayName`,`firstName`,`lastName`,`email`,`passwordHash`,`dateJoined`,`userAccessId`,`version`) VALUES (2,'John Doe','John','Doe','john.doe@gmail.com','sha1:64000:32:tN+Ze7tufnoIfFAOCFTxcGxcRCMQ5uXibGTH5QyffTU=:UqHB7YOORnj2i+pz+M55zVCrdnvHsx5fFfCDiNscy1s=','2017-05-05',1,1);
INSERT INTO `user` (`id`,`displayName`,`firstName`,`lastName`,`email`,`passwordHash`,`dateJoined`,`userAccessId`,`version`) VALUES (3,'Jane Doe','Jane','Doe','jane.doe@gmail.com','sha1:64000:32:tN+Ze7tufnoIfFAOCFTxcGxcRCMQ5uXibGTH5QyffTU=:UqHB7YOORnj2i+pz+M55zVCrdnvHsx5fFfCDiNscy1s=','2017-05-05',2,1);
INSERT INTO `user` (`id`,`displayName`,`firstName`,`lastName`,`email`,`passwordHash`,`dateJoined`,`userAccessId`,`version`) VALUES (4,'Smart Aleck','Robert','Dias','r.dias@gmail.com','sha1:64000:32:tN+Ze7tufnoIfFAOCFTxcGxcRCMQ5uXibGTH5QyffTU=:UqHB7YOORnj2i+pz+M55zVCrdnvHsx5fFfCDiNscy1s=','2017-05-05',1,1);

INSERT INTO `profile` (`id`,`userId`,`profileType`,`profilePicture`,`version`) VALUES (1,1,'LocalSuggestions',null,1);
INSERT INTO `profile` (`id`,`userId`,`profileType`,`profilePicture`,`version`) VALUES (2,1,'Facebook',null,1);
INSERT INTO `profile` (`id`,`userId`,`profileType`,`profilePicture`,`version`) VALUES (3,1,'LocalSuggestions',null,1);
INSERT INTO `profile` (`id`,`userId`,`profileType`,`profilePicture`,`version`) VALUES (4,1,'LocalSuggestions',null,1);
INSERT INTO `profile` (`id`,`userId`,`profileType`,`profilePicture`,`version`) VALUES (5,1,'LinkedIn',null,1);
INSERT INTO `profile` (`id`,`userId`,`profileType`,`profilePicture`,`version`) VALUES (6,1,'LocalSuggestions',null,1);

INSERT INTO `phone`(`id`,`userId`,`phoneType`,`phoneNumber`,`phoneCountry`,`version`) VALUES (1,1,'Mobile','7590842513','0044',1);
INSERT INTO `phone`(`id`,`userId`,`phoneType`,`phoneNumber`,`phoneCountry`,`version`) VALUES (2,1,'Home','2034569801','0044',1);
INSERT INTO `phone`(`id`,`userId`,`phoneType`,`phoneNumber`,`phoneCountry`,`version`) VALUES (3,1,'Travel','300277197','0092',1);
INSERT INTO `phone`(`id`,`userId`,`phoneType`,`phoneNumber`,`phoneCountry`,`version`) VALUES (4,2,'Mobile','7590842513','0044',1);
INSERT INTO `phone`(`id`,`userId`,`phoneType`,`phoneNumber`,`phoneCountry`,`version`) VALUES (5,2,'Home','2039123098','0044',1);

INSERT INTO `address` (`id`,`userId`,`addressType`,`houseNumber`,`addressLine1`,`addressLine2`,`addressLine3`,`addressLine4`,`zipOrPostCode`,`city`,`countyOrProvince`,`country`,`version`) VALUES (1,1,'Billing Address','54','Flat 2','Upper Tooting Road',null,null,'SW177PD','London','London','United Kingdom',1);
INSERT INTO `address` (`id`,`userId`,`addressType`,`houseNumber`,`addressLine1`,`addressLine2`,`addressLine3`,`addressLine4`,`zipOrPostCode`,`city`,`countyOrProvince`,`country`,`version`) VALUES (2,4,'Home Address','10','Downtown Abbey','Middle Road','Downtown',null,'UB56HU','London','London','United Kingdom',1);
