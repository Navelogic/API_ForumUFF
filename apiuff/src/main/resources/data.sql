-- Inserir usuários
INSERT INTO TB_USER(name, email, password) VALUES('Aluno', 'aluno@email.com', '123456');

-- Inserir cursos
INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Programação');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Front-end');

-- Inserir tópicos e respostas
INSERT INTO TOPICUFF(title, message, author_id, course_id)
VALUES('Dúvida', 'Erro ao criar projeto', 1, 1);