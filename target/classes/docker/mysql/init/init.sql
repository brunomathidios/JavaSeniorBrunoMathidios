create database if not exists colaboradores;

CREATE TABLE setor (
    id_setor INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nm_setor VARCHAR(150) NOT NULL,
    PRIMARY KEY (id_setor)
);

CREATE TABLE colaborador (
    id_colab INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nm_colab VARCHAR(150) NOT NULL,
    cpf_colab VARCHAR(150) NOT NULL,
    tel_colab VARCHAR(150) NOT NULL,
    email_colab VARCHAR(150) NOT NULL,
    id_setor INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_colab),
    FOREIGN KEY (id_setor) REFERENCES setor (id_setor)
);

INSERT INTO setor (id_setor, nm_setor) VALUES(1, 'Setor A');
INSERT INTO setor (id_setor, nm_setor) VALUES(2, 'Setor B');
INSERT INTO setor (id_setor, nm_setor) VALUES(3, 'Setor C');
INSERT INTO setor (id_setor, nm_setor) VALUES(4, 'Setor D');

INSERT INTO colaborador (id_colab, nm_colab, cpf_colab, tel_colab, email_colab, id_setor) 
VALUES(1, 'Colab A', '23015671251', '999999999', 'colab_a@enterprise.com', 2);
INSERT INTO colaborador (id_colab, nm_colab, cpf_colab, tel_colab, email_colab, id_setor) 
VALUES(2, 'Colab B', '68665274146', '999999999', 'colab_b@enterprise.com', 2);

INSERT INTO colaborador (id_colab, nm_colab, cpf_colab, tel_colab, email_colab, id_setor) 
VALUES(3, 'Colab C', '14898897525', '999999999', 'colab_c@enterprise.com', 3);
INSERT INTO colaborador (id_colab, nm_colab, cpf_colab, tel_colab, email_colab, id_setor) 
VALUES(4, 'Colab D', '24104337234', '999999999', 'colab_d@enterprise.com', 3);
