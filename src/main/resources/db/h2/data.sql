INSERT INTO author (seq, name)
VALUES (1, '푸루');
INSERT INTO author (seq, name)
VALUES (2, '배코');

INSERT INTO post (seq, id, title, text, category, author_id, created_date)
VALUES (1, '931F48084C0E4D519CA4A8D04F3255E7', '즐거운 자바', '자바 너무 즐거워~! 빵긋~! ^0^', null, 1, now());
INSERT INTO post (seq, id, title, text, category, author_id, created_date)
VALUES (2,  'A588A4C71D4148A3B1BFE3AA8D1FF6C5', '즐거운 그래프 큐엘!', '내 동년배들 모두 그래프 큐엘만 한다.', 'graphQL~!', 2, now());
