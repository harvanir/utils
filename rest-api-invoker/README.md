# Rest API Invoker
Utility to invoke rest API.

## How to use
**1. Run the application**

```bash
java -jar -Dserver.port={port} rest-api-invoker.jar
```

**2. Shutdown the application**

```bash
Request [POST]:
http://{yourdomain}:{port}/actuator/shutdown
```

**3. Example-1**

```bash
Requset[POST]:
http://{yourdomain}:{port}/rest-api-invoker/invoke

Headers (This header will be replace if payload contains headers):
Content-Type: application/x-www-form-urlencoded

Payload[x-www-form-urlencoded]:
url: http://localhost:8080/rest-api-invoker/test
method: POST
headers: {"Content-Type":["application/x-www-form-urlencoded"]}
payload: code=T646&pkContract=${pkContract}&contractNo=${contractNo}&lookupPK=1326&reasonDescr=Double
payloadBinding: [{"pkContract":414361, "contractNo": "SG00414361"}, {"pkContract":414362, "contractNo":"SG00414362"}]

----
Response:
[
    {
        "code": "T646",
        "pkContract": 414361,
        "contractNo": "SG00414361",
        "lookupPK": 1326,
        "reasonDescr": "Double"
    },
    {
        "code": "T646",
        "pkContract": 414362,
        "contractNo": "SG00414362",
        "lookupPK": 1326,
        "reasonDescr": "Double"
    }
]
```
