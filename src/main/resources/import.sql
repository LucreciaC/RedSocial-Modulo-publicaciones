-- Insertar perfiles
INSERT INTO Perfil (Biografia, Avatar) VALUES ('Developer and tech enthusiast.', 'avatar1.png');
INSERT INTO Perfil (Biografia, Avatar) VALUES ('Designer and artist.', 'avatar2.png');
INSERT INTO Perfil (Biografia, Avatar) VALUES ('Photographer and traveler.', 'avatar3.png');
INSERT INTO Perfil (Biografia, Avatar) VALUES ('Musician and writer.', 'avatar4.png');

-- Insertar usuarios
INSERT INTO Usuario (Nombre, Email, perfil_id) VALUES ('John Doe', 'john.doe@example.com', 1);
INSERT INTO Usuario (Nombre, Email, perfil_id) VALUES ('Jane Smith', 'jane.smith@example.com', 2);
INSERT INTO Usuario (Nombre, Email, perfil_id) VALUES ('Alice Johnson', 'alice.johnson@example.com', 3);
INSERT INTO Usuario (Nombre, Email, perfil_id) VALUES ('Bob Brown', 'bob.brown@example.com', 4);

-- Insertar publicaciones
INSERT INTO Publicacion (contenido, fecha_Creacion, usuario_id) VALUES ('Hello, this is my first post!', '2024-06-28 10:00:00', 1);
INSERT INTO Publicacion (contenido, fecha_Creacion, usuario_id) VALUES ('Loving this new platform!', '2024-06-28 11:00:00', 2);
INSERT INTO Publicacion (contenido, fecha_Creacion, usuario_id) VALUES ('Just sharing some thoughts.', '2024-06-28 12:00:00', 1);
INSERT INTO Publicacion (contenido, fecha_Creacion, usuario_id) VALUES ('What a beautiful day!', '2024-06-28 13:00:00', 3);
INSERT INTO Publicacion (contenido, fecha_Creacion, usuario_id) VALUES ('Excited about my new project.', '2024-06-28 14:00:00', 4);

-- Insertar seguidores (Many-to-Many relationship)
INSERT INTO usuario_seguidores (usuario_id, seguidor_id) VALUES (1, 2); -- John Doe sigue a Jane Smith
INSERT INTO usuario_seguidores (usuario_id, seguidor_id) VALUES (2, 1); -- Jane Smith sigue a John Doe
INSERT INTO usuario_seguidores (usuario_id, seguidor_id) VALUES (3, 1); -- Alice Johnson sigue a John Doe
INSERT INTO usuario_seguidores (usuario_id, seguidor_id) VALUES (4, 2); -- Bob Brown sigue a Jane Smith
INSERT INTO usuario_seguidores (usuario_id, seguidor_id) VALUES (1, 3); -- John Doe sigue a Alice Johnson