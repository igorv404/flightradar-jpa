USE flightradar404;

DROP PROCEDURE IF EXISTS add_country;
DROP PROCEDURE IF EXISTS add_ten_cities;
DROP PROCEDURE IF EXISTS add_new_db;
DROP FUNCTION IF EXISTS find_min_price;
DROP TRIGGER IF EXISTS check_if_id_is_unique;
DROP TRIGGER IF EXISTS check_if_update_can_be;
DROP TRIGGER IF EXISTS check_if_delete_can_be;
DROP TRIGGER IF EXISTS check_name_what_end_with_two_zero;
DROP TRIGGER IF EXISTS check_if_name_is_from_list;
DROP TRIGGER IF EXISTS log_city;

DELIMITER //

CREATE TRIGGER check_if_id_is_unique
	BEFORE INSERT
    ON country
    FOR EACH ROW
BEGIN
	DECLARE isDone BOOLEAN DEFAULT FALSE;
    DECLARE s_name VARCHAR(45);
	DECLARE cursor_country CURSOR FOR SELECT name FROM country;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET isDone = TRUE;
    OPEN cursor_country;
    curs_loop: LOOP
		FETCH cursor_country INTO s_name;
        IF isDone = TRUE THEN LEAVE curs_loop;
        END IF;
        IF new.Name = s_name THEN
			SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Name is allready exists";
		END IF;
        END LOOP;
	CLOSE cursor_country;
END//

CREATE TRIGGER check_if_update_can_be
	BEFORE UPDATE
    ON country
    FOR EACH ROW
BEGIN
	DECLARE isDone BOOLEAN DEFAULT FALSE;
    DECLARE s_name VARCHAR(45);
	DECLARE cursor_city CURSOR FOR SELECT country_name FROM city;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET isDone = TRUE;
    OPEN cursor_city;
    curs_loop: LOOP
		FETCH cursor_city INTO s_name;
        IF isDone = TRUE THEN LEAVE curs_loop;
        END IF;
        IF old.Name = s_name THEN
			SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "This country have dependecy";
		END IF;
        END LOOP;
	CLOSE cursor_city;
END//

CREATE TRIGGER check_if_delete_can_be
	BEFORE DELETE
    ON country
    FOR EACH ROW
BEGIN
	DECLARE isDone BOOLEAN DEFAULT FALSE;
    DECLARE s_name VARCHAR(45);
	DECLARE cursor_city CURSOR FOR SELECT country_name FROM city;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET isDone = TRUE;
    OPEN cursor_city;
    curs_loop: LOOP
		FETCH cursor_city INTO s_name;
        IF isDone = TRUE THEN LEAVE curs_loop;
        END IF;
        IF old.Name = s_name THEN
			SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "This country have dependecy";
		END IF;
        END LOOP;
	CLOSE cursor_city;
END//

CREATE PROCEDURE add_country (IN name VARCHAR(45))
BEGIN
	INSERT INTO country VALUES(name);
END//

CREATE PROCEDURE add_ten_cities (IN cityName VARCHAR(45))
BEGIN
	DECLARE count int;
    SET count = 1;
    addName: LOOP
		IF count > 10 THEN LEAVE addName;
        END IF;
		INSERT INTO city(name, country_name) VALUES(CONCAT(cityName, "-", count), "France");
        SET count = count + 1;
	END LOOP;
END//

CREATE FUNCTION find_min_price() RETURNS FLOAT DETERMINISTIC
BEGIN
	RETURN(SELECT MIN(price) FROM flight);
END//

SELECT find_min_price()//

CREATE PROCEDURE add_new_db()
BEGIN
	DECLARE isDone BOOLEAN DEFAULT FALSE;
    DECLARE s_name VARCHAR(45);
	DECLARE cursor_pilots CURSOR FOR SELECT name FROM pilot;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET isDone = TRUE;
    OPEN cursor_pilots;
    curs_loop: LOOP
		FETCH cursor_pilots INTO s_name;
        IF isDone = TRUE THEN LEAVE curs_loop;
        END IF;
        SET @commandDB = CONCAT("CREATE DATABASE ", s_name);
        PREPARE myquery FROM @commandDB;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;
        END LOOP;
	CLOSE cursor_pilots;
END//

CREATE TRIGGER check_name_what_end_with_two_zero
	BEFORE INSERT
    ON country
    FOR EACH ROW
BEGIN
	IF (new.Name REGEXP("00$")) THEN
		SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Name can not end with two 0";
	END IF;
END //

CREATE TRIGGER check_if_name_is_from_list
	BEFORE INSERT
    ON pilot
    FOR EACH ROW 
BEGIN
	IF(new.Name NOT REGEXP("(Igor|Oleg|Yana)")) THEN
		SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Name is not from list";
	END IF;
END //

CREATE TRIGGER log_city
	AFTER INSERT
	ON city
    FOR EACH ROW
BEGIN
	INSERT INTO city_log (city_id, city_name, country, date) VALUES (new.Id, new.Name, new.Country_name, NOW());
END//
