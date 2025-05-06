INSERT INTO coche (marca, modelo, matricula, disponible, precio)
VALUES 
  ('Toyota', 'Corolla', '1234ABC', true, 20),
  ('Ford', 'Focus', '5678DEF', true, 20),
  ('Tesla', 'Model 3', '9999TES', false, 20);
 INSERT INTO usuario (nombre, usuario, password, telefono, email, rol)
VALUES ('Juan Pérez', 'juanp', 'password123', '600123456', 'juanp@example.com', 'USUARIO');

INSERT INTO usuario (nombre, usuario, password, telefono, email, rol)
VALUES ('Ana García', 'anag', 'pass456', '611234567', 'ana.garcia@example.com', 'USUARIO');

INSERT INTO usuario (nombre, usuario, password, telefono, email, rol)
VALUES ('Carlos López', 'carlosl', 'admin789', '622345678', 'carlos.lopez@example.com', 'ADMIN');

INSERT INTO usuario (nombre, usuario, password, telefono, email, rol)
VALUES ('Laura Ruiz', 'laurar', 'secure321', '633456789', 'laura.ruiz@example.com', 'USUARIO');

INSERT INTO usuario (nombre, usuario, password, telefono, email, rol)
VALUES ('Pedro Sánchez', 'pedros', 'mypassword', '644567890', 'pedro.sanchez@example.com', 'USUARIO');

INSERT INTO alquiler (fecha_inicio, fecha_fin, precio, devuelto, coche_id, usuario_id)
VALUES ('2025-05-10', '2025-05-15', 200, false, 1, 1);

INSERT INTO pago (fecha_pago, metodo_pago, importe, alquiler_id) VALUES 
('2025-05-15', 'tarjeta', 200, 1),
('2025-05-16', 'efectivo', 150, 2),
('2025-05-17', 'bizum', 180, 3);
