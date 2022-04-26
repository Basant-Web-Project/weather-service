# weather-service

#### Weather API cURL 

```
curl --location --request GET 'http://localhost:8080/weather-service/next3days/Georgia'
```
#### Weather API Response

```
{
  "cityName": "Georgia",
  "forecastMap": {
    "2022-04-26": [
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 79,
        "max_temp": 25.6,
        "winds": 3.36,
        "date": "2022-04-26",
        "time": "15:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 58,
        "max_temp": 28.91,
        "winds": 4.07,
        "date": "2022-04-26",
        "time": "18:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 87,
        "max_temp": 19.54,
        "winds": 5.41,
        "date": "2022-04-26",
        "time": "21:00:00"
      }
    ],
    "2022-04-27": [
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 79,
        "max_temp": 19.04,
        "winds": 1.42,
        "date": "2022-04-27",
        "time": "00:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 67,
        "max_temp": 16.84,
        "winds": 3.12,
        "date": "2022-04-27",
        "time": "03:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 60,
        "max_temp": 14.36,
        "winds": 3.65,
        "date": "2022-04-27",
        "time": "06:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 68,
        "max_temp": 11.34,
        "winds": 2.85,
        "date": "2022-04-27",
        "time": "09:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 73,
        "max_temp": 12.84,
        "winds": 3.24,
        "date": "2022-04-27",
        "time": "12:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 57,
        "max_temp": 19.76,
        "winds": 4.07,
        "date": "2022-04-27",
        "time": "15:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 43,
        "max_temp": 23.79,
        "winds": 2.86,
        "date": "2022-04-27",
        "time": "18:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 35,
        "max_temp": 24.93,
        "winds": 2.31,
        "date": "2022-04-27",
        "time": "21:00:00"
      }
    ],
    "2022-04-28": [
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 59,
        "max_temp": 18.63,
        "winds": 2.38,
        "date": "2022-04-28",
        "time": "00:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 64,
        "max_temp": 14.94,
        "winds": 2.11,
        "date": "2022-04-28",
        "time": "03:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 66,
        "max_temp": 12.57,
        "winds": 1.67,
        "date": "2022-04-28",
        "time": "06:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 69,
        "max_temp": 11.03,
        "winds": 2.11,
        "date": "2022-04-28",
        "time": "09:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 65,
        "max_temp": 12.16,
        "winds": 2.03,
        "date": "2022-04-28",
        "time": "12:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 36,
        "max_temp": 20.33,
        "winds": 3.16,
        "date": "2022-04-28",
        "time": "15:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 29,
        "max_temp": 23.83,
        "winds": 3.13,
        "date": "2022-04-28",
        "time": "18:00:00"
      },
      {
        "warnMessages": [
          "All good ! Enjoy"
        ],
        "avg_humidity": 30,
        "max_temp": 24.23,
        "winds": 3.2,
        "date": "2022-04-28",
        "time": "21:00:00"
      }
    ]
  }
}
```

#### Build Docker image

```
docker build -t weather-service:1.0 .
```

#### Deploy App to kubernetes 
```
kubectl apply -f deployment.yaml
```

Note : Jenkinsfile & Dockerfile attached in source code
