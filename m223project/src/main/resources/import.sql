INSERT INTO "Place" ("isbooked", "story") VALUES (true, 2.5);
INSERT INTO "Place" ("isbooked", "story") VALUES (false, 1.5);

INSERT INTO "Role" ("typ") VALUES ('admin');
INSERT INTO "Role" ("typ") VALUES ('mitglied');
INSERT INTO "Role" ("typ") VALUES ('besucher');

INSERT INTO "User" ("email", "firstname", "lastname", "password", "role_id") VALUES ('gianluca.ferrara@gmail.ch','Gianluca','Ferrara','JuveToTheTop69' , 2);
INSERT INTO "User" ("email", "firstname", "lastname", "password", "role_id") VALUES ('mattia.loiarro@gmail.com','Mattia','Loiarro','MilanIschNedGuet420',1);

INSERT INTO "Booking" ("end", "start", "status", "place_id", "user_id") VALUES(TO_TIMESTAMP('2005-5-5 10:10:10', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2005-5-5 05:05:05', 'YYYY-MM-DD HH24:MI:SS'), true, 1, 1);
INSERT INTO "Booking" ("end", "start", "status", "place_id", "user_id") VALUES(TO_TIMESTAMP('2003-5-6 03:30:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2003-5-5 07:07:07', 'YYYY-MM-DD HH24:MI:SS'), true, 1, 1);

INSERT INTO "Extra" ("name", "price", "place_id") VALUES ('Monitor',255.50, 1);
INSERT INTO "Extra" ("name", "price", "place_id") VALUES ('Maus', 179.50, 1);




