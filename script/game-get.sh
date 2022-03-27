echo ""
echo "localhost:8080/game"
curl -b "sessionId=$1" "localhost:8080/game" -i
echo ""