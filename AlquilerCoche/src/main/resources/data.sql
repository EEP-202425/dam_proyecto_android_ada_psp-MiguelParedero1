INSERT INTO usuario (nombre, usuario, password, telefono, email, rol) VALUES
('Juan Pérez', 'juanp', 'password123', '600123456', 'juanp@example.com', 'USUARIO');

INSERT INTO coche (marca, modelo, matricula, disponible, precio) VALUES
('Toyota', 'Corolla', '1234ABC', true, 20),
('Ford', 'Focus', '5678DEF', true, 20),
('Tesla', 'Model 3', '9999TES', false, 20),
('Ebro', 'Corolla', '1234ABC', true, 20),
('Silk', 'Focus', '5678DEF', true, 20),
('Tesla', 'Model 2', '9999TES', false, 20),
('Toyota', 'Silk2', '1234ABC', true, 20),
('Ford', 'Fiesta', '5678DEF', true, 20),
('Tesla', 'Model 1', '9999TES', false, 20),
('Toyota', 'Divider', '1234ABC', true, 20),
('Ford', 'SE', '5678DEF', true, 20),
('Tesla', 'Model 6', '9999TES', false, 20);

INSERT INTO alquiler (fecha_inicio, fecha_fin, precio, devuelto, coche_id, usuario_id) VALUES
('2025-05-10', '2025-05-12', 100, false, 1, 1),
('2025-05-13', '2025-05-14', 120, false, 2, 1),
('2025-05-15', '2025-05-16', 150, false, 3, 1);

INSERT INTO pago (fecha_pago, metodo_pago, importe, alquiler_id) VALUES
('2025-05-15', 'tarjeta', 200, 1),
('2025-05-16', 'efectivo', 150, 1),
('2025-05-17', 'bizum', 180, 2);
