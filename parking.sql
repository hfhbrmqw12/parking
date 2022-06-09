-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Фев 11 2022 г., 20:15
-- Версия сервера: 10.3.22-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `parking`
--

-- --------------------------------------------------------

--
-- Структура таблицы `car`
--

CREATE TABLE `car` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `car_color` varchar(255) DEFAULT NULL,
  `car_model` varchar(255) DEFAULT NULL,
  `car_number` varchar(255) DEFAULT NULL,
  `parking_number` int(11) DEFAULT NULL,
  `parking_paid` bit(1) DEFAULT NULL,
  `parking_sum` double DEFAULT NULL,
  `parking_time_end` varchar(255) DEFAULT NULL,
  `parking_time_start` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `car`
--

INSERT INTO `car` (`id`, `comment`, `car_color`, `car_model`, `car_number`, `parking_number`, `parking_paid`, `parking_sum`, `parking_time_end`, `parking_time_start`) VALUES
(11, 'Возможно продлит на неделю', 'Чёрная', 'Лада Гранта', 'а244ме197', 5, NULL, 1500, '2021-08-21', '2021-08-19'),
(12, '', 'Синий', 'Мерседес', 'р566рр22', 2, b'1', 5000, '2021-09-16', '2021-09-08'),
(13, 'Залог', 'Белый', 'Тойота', 'а189мм197', 1, NULL, 3000, '', '2021-08-07'),
(14, 'Ожидает ремонта', 'Зелёный', 'Киа', 'е764тт197', 6, b'1', 4000, '2021-08-26', '2021-08-24'),
(15, '', 'Красный', 'Хёндай Солярис', 'е789аа57', 9, b'1', 20000, '2021-09-18', '2021-08-15'),
(16, 'Будет продлять', 'Чёрный', 'Митсубиси Лансер', 'о157ор99', 15, b'1', 3000, '2021-08-31', '2021-08-26'),
(17, 'Пока будет стоять', 'Синий', 'Мерседес', 'а984нм197', 21, b'1', 20000, '', '2021-08-25'),
(18, '', 'Белый', 'Тойота', 'м532оо197', 33, NULL, 5000, '2021-08-19', '2021-08-17'),
(19, '', 'Синий', 'Тойота', 'а199хм14', 36, b'1', 3000, '2021-08-28', '2021-08-13'),
(20, '', 'Белый', 'Хёндай Солярис', 'а211ку04', 50, b'1', 5000, '2021-09-12', '2021-09-10');

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(21);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
