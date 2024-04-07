# Deprem Uygulaması
Bu uygulamabasit bir panel içerisinde, dünya haritası üzerinde anormal depremleri gösterebilecek bir web uygulamasıdır. Meydana gelen depremler harita üzerinde işaretlenmektedir. Projenin test edilmesi için 2 farklı script dosyası yer almaktadır. Proje Spring Boot ile geliştirilmiş olup ön yüzü ise React ile geliştirilmiştir. Veritabanı olarak MongoDb kullanılmıştır.

## Proje Kurulumu
Adım 1: Projeyi öncelikle `git clone` komutu yardımıyla bilgisayarınızda yerel bir dosyanın içerisine çekiniz.

Adım 2: Projenin backend'ini kurmak için yerel dosyaların içinde yer alan `/earthquake-be` dosyasına cmd üzerinden gidiniz. Ardından `docker-compose up -d` komutunu çalıştırınız.

❗Docker üzerinden konteynırları ayağa kaldırmadan önce bilgisayarınızda yer alan `Docker Desktop` uygulamasının açık olduğundan emin olunuz.

Adım 3: Projenin frontend'ini ayağa kaldırmak için projenin yer aldığı ana dizinden `/earthquake-fe/earthquakeApp` dosyasına cmd üzerinden gidiniz. Ardından `npm start` komutu ile projeyi `localhost:3000` portu üzerinden ayağa kaldırınız.

Adım 4: Projenin docker üzerindeki backend ve veri tabanının ayağa kalktığından emin olduktan sonra projedeki scriptler ile projeyi test edebilirsiniz. Test etmek için `/earthquake-scripts` klasörüne cmd üzerinden gidiniz. Sonrasında istediğiniz scripti `python script-adi` olarak çalıştırınız.

## Proje Hakkında
Projede yer alan endpointler şunlardır;

`GET /earthquake` -> Tüm depremleri getirir.

`GET /earthquake/{id}` -> Id'si gönderilen depremi getirir.

`POST /earthquake` -> Deprem oluşturur.

`DELETE /earthquake/{id}` -> Id'si gönderilen depremi siler.

## Projeden Alıntılar
![image](https://github.com/DCanKayrak/earthquake-app/assets/94143272/66afdb11-19eb-465f-bc53-cf55b7cf0982)

![image](https://github.com/DCanKayrak/earthquake-app/assets/94143272/e6e904c7-3ce2-4e19-9dda-9904236b76d3)

