## Счётчик уникальных слов на сайте
#### **Системные требования**:
- Виртуальная машина java (не ниже 11 версии)
- PostgreSQL (не ниже 13.3)
#### **Инициализация базы данных**:
 Приложению требуется доступ к базе данных. Поэтому перед началом работы нужно инициализировать базу данных и пользователя:  
- Пользователь``counter`` пароль ``123``;
- База данных ``counterdb``
#### **Порядок работы**:  
- Скачать [актуальный релиз](https://github.com/xdx505/html-word-counter/releases)
- (Опционально) Конфигурировать файл ``run.bat`` или ``run.sh``
- Запустить приложение
#### **Swagger документация**:  
В приложении работает swagger документация для просмотра эндпоинтов. Если у вас стандартный конфиг, то Swagger UI здесь, - [localhost:3222/swagger-ui/](http://localhost:3222/swagger-ui/)
#### **Варианты конфигурирования параметров запуска**:
Вы можете самостоятельно настроить параметры запуска приложения в файлах ``run.bat`` и ``run.sh``

Расшифровка конфигурации:
```properties
#Профиль запуска (prod/dev). Отличается только уровнями логирования
spring.profiles.active=dev
#Порт сервера
server.port=3222
```
Отдельные настройки для headless web клиента HtmlUnit:
```properties
#Нужно ли генерировать JavaScript на странице
webclient.isJavaScriptEnabled=true
#Нужно ли генерировать Css на странице
webclient.isCssEnabled=true
#Таймаут перед действиями (мс)
webclient.timeout=5000
#Максимальное число байт в памяти
webclient.maxBytesInMemory=2048
# Высота headless экрана
webclient.screenHeight=1080
# Ширина headless экрана
webclient.screenWidth=1920
```
#### **Используемые библиотеки**:
- Spring Boot/JPA/Web/Test
- PostgreSQL
- Flyway
- HTMLUnit
- Lombok
- ModelMapper
- Springfox
- Apache commons
- JUnit 5
