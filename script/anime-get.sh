echo ""
echo "localhost:8080/anime"
curl -b "sessionId=$1" "localhost:8080/anime" -i
echo ""