postman doc : https://documenter.getpostman.com/view/28224207/2s9XxvUb14 
 
Uygulamayı kullanmak için bu şekilde oluşturulan iki table ve userdb isminde bir database lazım.
Mysql username root ve password Pass_2023 olarak ayarlandı.
Docker imageları dockerhubdan bulabilirsiniz kullanıcı ismim pelinerdogan.
Containerları network ile bağlamak gerekiyor. 



USE userdb;

CREATE TABLE campaign_status_changes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    campaign_id VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    change_timestamp TIMESTAMP
);


CREATE TABLE allianz (
    id VARCHAR(50) PRIMARY KEY,
    Category VARCHAR(255) NOT NULL,
    details VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    mukerrer BOOLEAN
);

Program 5 milisaniyeden uzun süren işlemleri logluyor. 

