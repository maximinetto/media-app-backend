# media-app-backend

Agregar estos roles

--
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (1, 'search', 'Buscar', '/buscar');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (2, 'insert_drive_file', 'Registrar', '/consulta');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (3, 'insert_drive_file', 'Registrar E.', '/consulta-especial');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (4, 'star_rate', 'Especialiades', '/especialidad');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (5, 'healing', 'Médicos', '/medico');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (6, 'assignment', 'Examenes', '/examen');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (7, 'accessibility', 'Pacientes', '/paciente');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (8, 'assessment', 'Reportes', '/reporte');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (9, 'account_box', 'Mi Perfil', '/perfil');
INSERT INTO public.menu (id_menu, icono, nombre, url) VALUES (10, 'favorite', 'Signos vitales', '/signo-vitales');


--
-- Data for Name: menu_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (1, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (2, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (3, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (4, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (5, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (6, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (7, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (8, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (4, 2);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (5, 2);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (6, 2);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (7, 2);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (9, 1);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (9, 2);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (9, 3);
INSERT INTO public.menu_rol (id_menu, id_rol) VALUES (10, 1);
