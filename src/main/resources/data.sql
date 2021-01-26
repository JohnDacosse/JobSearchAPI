insert into user(address, avatar, city, cp, email, firstname, lastname, password, phone)
values('Rue du machin', 'url/none', 'Mons', '7000', 'johndac@mail.com', 'John', 'Dac', 'test', '0444123456');

insert into cv(birth_date, first_name, last_name, vehicle, usr_id)
values('1989-08-24', 'John', 'Dac', 1, 1);

insert into favorite(description, job_id, language_code, license_code, location, title, usr_id)
values('Just a job', '000001', null, null, 'Somewhere', 'JobTitle', 1);

insert into license(type)
values('B');

insert into cv_licenses(cvs_cv_id, licenses_lic_id)
values(1, 1);

insert into pro_exp(title, location, start_date, end_date, cv_id)
values('Vendeur de hot-dog', 'New-York', '2010-03-01', '2012-03-01', 1);

insert into language(language, lev_id)
values('Français', 1);

insert into level(title)
values('Langue maternelle');

insert into cv_languages(cvs_cv_id, languages_lan_id)
values(1, 1);

insert into studies(title, location, degree, start_date, end_date, cv_id)
values('Aqua-poney', 'Atlantide', null, '2012-04-15', '2012-10-15', 1);

insert into skill(title, description)
values('Compétence test', 'Test de description de compétence');

insert into cv_skills(cvs_cv_id, skills_ski_id)
values(1, 1);