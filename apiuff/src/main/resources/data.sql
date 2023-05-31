-- USER
INSERT INTO USERS(name, email, password) VALUES('Aluno', 'aluno@email.com', '123456');
INSERT INTO USERS(name, email, password) VALUES('João', 'joao@email.com', 'qwerty');
INSERT INTO USERS(name, email, password) VALUES('Maria', 'maria@email.com', 'abcdef');
INSERT INTO USERS(name, email, password) VALUES('Pedro', 'pedro@email.com', '654321');
INSERT INTO USERS(name, email, password) VALUES('Ana', 'ana@email.com', 'password123');
INSERT INTO USERS(name, email, password) VALUES('Lucas', 'lucas@email.com', 'pass1234');
INSERT INTO USERS(name, email, password) VALUES('Juliana', 'juliana@email.com', '987654');
INSERT INTO USERS(name, email, password) VALUES('Gabriel', 'gabriel@email.com', 'p@ssw0rd');
INSERT INTO USERS(name, email, password) VALUES('Camila', 'camila@email.com', 'abcdefg');
INSERT INTO USERS(name, email, password) VALUES('Rafael', 'rafael@email.com', 'q1w2e3r4');
INSERT INTO USERS(name, email, password) VALUES('Isabela', 'isabela@email.com', 'abcd1234');
INSERT INTO USERS(name, email, password) VALUES('Gustavo', 'gustavo@email.com', 'password456');
INSERT INTO USERS(name, email, password) VALUES('Laura', 'laura@email.com', 'qwerty123');
INSERT INTO USERS(name, email, password) VALUES('Felipe', 'felipe@email.com', 'asdfgh');
INSERT INTO USERS(name, email, password) VALUES('Carolina', 'carolina@email.com', 'zxcvbn');
INSERT INTO USERS(name, email, password) VALUES('Thiago', 'thiago@email.com', 'passw0rd');
INSERT INTO USERS(name, email, password) VALUES('Mariana', 'mariana@email.com', '123abc');
INSERT INTO USERS(name, email, password) VALUES('Diego', 'diego@email.com', '789456');
INSERT INTO USERS(name, email, password) VALUES('Fernanda', 'fernanda@email.com', 'qazwsx');
INSERT INTO USERS(name, email, password) VALUES('Eduardo', 'eduardo@email.com', 'asdf1234');
INSERT INTO USERS(name, email, password) VALUES('Patrícia', 'patricia@email.com', 'password789');

-- COURSE
INSERT INTO COURSE(name, category) VALUES('React Native', 'Mobile Development');
INSERT INTO COURSE(name, category) VALUES('Machine Learning', 'Data Science');
INSERT INTO COURSE(name, category) VALUES('Python for Beginners', 'Programming');
INSERT INTO COURSE(name, category) VALUES('Digital Marketing', 'Marketing');
INSERT INTO COURSE(name, category) VALUES('Photoshop Essentials', 'Design');
INSERT INTO COURSE(name, category) VALUES('Introduction to Finance', 'Finance');
INSERT INTO COURSE(name, category) VALUES('Spanish for Travelers', 'Language');
INSERT INTO COURSE(name, category) VALUES('Yoga for Beginners', 'Fitness');
INSERT INTO COURSE(name, category) VALUES('Public Speaking Mastery', 'Communication');
INSERT INTO COURSE(name, category) VALUES('Introduction to Psychology', 'Psychology');
INSERT INTO COURSE(name, category) VALUES('Java Fundamentals', 'Programming');
INSERT INTO COURSE(name, category) VALUES('Graphic Design Principles', 'Design');
INSERT INTO COURSE(name, category) VALUES('Introduction to Data Analysis', 'Data Science');
INSERT INTO COURSE(name, category) VALUES('JavaScript for Web Development', 'Front-end');
INSERT INTO COURSE(name, category) VALUES('Introduction to Business Management', 'Business');
INSERT INTO COURSE(name, category) VALUES('Photography Basics', 'Photography');
INSERT INTO COURSE(name, category) VALUES('Android App Development', 'Mobile Development');
INSERT INTO COURSE(name, category) VALUES('Music Theory', 'Music');
INSERT INTO COURSE(name, category) VALUES('Introduction to Artificial Intelligence', 'Technology');
INSERT INTO COURSE(name, category) VALUES('Creative Writing Workshop', 'Writing');
INSERT INTO COURSE(name, category) VALUES('Accounting Principles', 'Finance');
INSERT INTO COURSE(name, category) VALUES('Introduction to Sociology', 'Social Sciences');
INSERT INTO COURSE(name, category) VALUES('Introduction to Nutrition', 'Health');
INSERT INTO COURSE(name, category) VALUES('Illustration Techniques', 'Art');
INSERT INTO COURSE(name, category) VALUES('Introduction to Game Development', 'Gaming');
INSERT INTO COURSE(name, category) VALUES('Fashion Styling Basics', 'Fashion');
INSERT INTO COURSE(name, category) VALUES('Spanish for Beginners', 'Language');
INSERT INTO COURSE(name, category) VALUES('Leadership Skills Development', 'Personal Development');
INSERT INTO COURSE(name, category) VALUES('Introduction to Environmental Science', 'Science');
INSERT INTO COURSE(name, category) VALUES('Film Production Fundamentals', 'Film');

-- TOPICS users
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'CLOSED', 1, 1);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre CSS', 'Como centralizar um elemento na página?', '2021-09-15 10:30:00', 'CLOSED', 2, 2);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Problema com JavaScript', 'Função não está sendo executada corretamente', '2022-07-20 14:15:00', 'NOT_SOLVED', 3, 3);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre APIs', 'Como fazer uma requisição HTTP?', '2023-01-10 09:45:00', 'NOT_SOLVED', 4, 4);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Erro no Banco de Dados', 'Tabela não está sendo criada corretamente', '2023-02-28 16:20:00', 'SOLVED', 5, 5);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre algoritmos', 'Qual a complexidade deste algoritmo?', '2023-03-10 11:10:00', 'SOLVED', 6, 6);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Problema com HTML', 'Tags não estão sendo exibidas corretamente', '2023-04-05 13:25:00', 'SOLVED', 7, 7);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre SQL', 'Como fazer uma consulta com múltiplas tabelas?', '2023-04-15 16:40:00', 'SOLVED', 8, 8);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Erro no servidor', 'Site está retornando erro 500', '2023-04-25 08:55:00', 'CLOSED', 9, 9);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre Python', 'Como ler um arquivo CSV?', '2023-05-01 10:10:00', 'CLOSED', 10, 10);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Problema com CSS', 'Estilos não estão sendo aplicados corretamente', '2023-05-10 14:30:00', 'CLOSED', 11, 11);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre Java', 'Como criar uma classe abstrata?', '2023-05-15 11:20:00', 'CLOSED', 12, 12);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Problema com APIs', 'Requisições estão retornando erro 404', '2023-05-20 15:40:00', 'CLOSED', 13, 13);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre Git', 'Como criar uma nova branch?', '2023-05-25 09:50:00', 'SOLVED', 14, 14);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Erro de sintaxe', 'Código não está sendo reconhecido pelo compilador', '2023-05-28 12:15:00', 'SOLVED', 15, 15);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre JavaScript', 'Como usar a função map()?', '2023-05-30 15:30:00', 'NOT_ANSWERED', 16, 16);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Problema com Banco de Dados', 'Dados não estão sendo atualizados corretamente', '2023-05-31 10:45:00', 'NOT_ANSWERED', 17, 17);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre HTML', 'Como criar um formulário?', '2023-06-05 14:00:00', 'NOT_ANSWERED', 18, 18);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Problema com CSS', 'Elementos estão sobrepostos', '2023-06-10 09:20:00', 'NOT_ANSWERED', 19, 19);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Dúvida sobre Python', 'Como utilizar a biblioteca Pandas?', '2023-06-15 11:40:00', 'NOT_ANSWERED', 20, 20);
INSERT INTO TOPICUFF(TITLE, MESSAGE, CREATED_AT, STATUS, author_id, COURSE_ID) VALUES('Erro no servidor', 'Site está fora do ar', '2023-06-20 13:55:00', 'NOT_ANSWERED', 21, 21);