# spring-boot-api-authentication-sample

- spring security実装デモ
- 認証をカスタマイズし、独自の(key1,key2,pass) の形式で認証できる
- 認証後はステートフルなトークンを吐き出す
- 認可はエンドポイントレベルで制御
- 認証後は、contextからprincipal情報を取得

まず dockerを立ち上げる
```shell
docker-compose -f ./tool/docker-compose.yaml up
```

redis, mysqlが立ち上がる。データの確認は下記
```shell
redis-cli -h localhost
mysql -uroot -ppassword -h127.0.0.1 -P3306 sample
```

script配下に動作確認用のシェルがあるのでそれを使う
```shell
cd script
# 確認用ユーザセッティング(これを始めに行う)
./user-post.sh

# (code, id) でログイン。返り値の sessionId を後の確認に使う
./code-id-login.sh

# (mail) でログイン。返り値の sessionId を後の確認に使う
./mail-login.sh

# 各エンドポイントへのリクエストは下記
# 認可ありで200
./comic-get.sh <sessionId>
# 認可なしで403
./anime-get.sh <sessionId>
# 認可ありで200
./game-get.sh <sessionId>
# 認証だけ必要で200
./movie-get.sh <sessionId>
# 認証だけ必要で200 (ログイン情報が見れる)
./users-me-get.sh <sessionId> 

# 全部まとめて見る時は下記
./check.sh <sessionId>
```
