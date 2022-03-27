echo ""
echo "localhost:8080/users/me"
curl -b "sessionId=$1" "localhost:8080/users/me" -i
echo ""