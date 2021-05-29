    INSERT INTO authority(authority_role, authority_id) VALUES ('ROLE_ADMIN', 1);
    INSERT INTO authority(authority_role, authority_id) VALUES ('ROLE_USER', 2);
    INSERT INTO disconnect_user (id, student_id, password) VALUES (nextval('disconnect_user_id_seq'),'user','$2a$10$9Qvd5OgmZ42IM/5xDiMeYOpMeGaDygACK1.yP605cie8s2bGH0QDO');
    INSERT INTO disconnect_user (id, student_id, password) VALUES (nextval('disconnect_user_id_seq'),'user2','$2a$10$9Qvd5OgmZ42IM/5xDiMeYOpMeGaDygACK1.yP605cie8s2bGH0QDO');
    INSERT INTO disconnect_user (id, student_id, password) VALUES (nextval('disconnect_user_id_seq'),'admin','$2a$10$9Qvd5OgmZ42IM/5xDiMeYOpMeGaDygACK1.yP605cie8s2bGH0QDO');
    INSERT INTO users_authority(authority_id, id) VALUES (1, (select id from disconnect_user where student_id ='admin'));
    INSERT INTO users_authority(authority_id, id) VALUES (2, (select id from disconnect_user where student_id ='user'));
    INSERT INTO users_authority(authority_id, id) VALUES (2, (select id from disconnect_user where student_id ='user2'));