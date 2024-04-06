import requests
import random
import time

url = 'http://localhost:8080/earthquake'
req_time = 2

while True:
    data = {
        'lat': random.randint(-360,360),
        'lng': random.randint(-180,180),
        'pow': random.randint(0,8),
        }

    response = requests.post(url, json=data)

    if response.status_code == 200:
        print("İstek başarılı!")
        print("Sunucudan gelen yanıt:")
        print(response.text)
    else:
        print("İstek başarısız! Hata kodu:", response.status_code)

    time.sleep(req_time)