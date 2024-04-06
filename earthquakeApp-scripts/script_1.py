import requests

url = 'http://localhost:8080/earthquake'
data = {
    'lat': input("Lat değerini giriniz : "),
    'lng': input("Lng değerini giriniz : "),
    'pow': input("Pow değerini giriniz : "),
    }

response = requests.post(url, json=data)

if response.status_code == 200:
    print("İstek başarılı!")
    print("Sunucudan gelen yanıt:")
    print(response.text)
else:
    print("İstek başarısız! Hata kodu:", response.status_code)