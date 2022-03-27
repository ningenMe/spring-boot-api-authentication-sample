echo ""
echo "localhost:8080/comic"
curl -b "sessionId=$1" "localhost:8080/comic" -i
echo ""