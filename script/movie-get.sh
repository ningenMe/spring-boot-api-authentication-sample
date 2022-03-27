echo ""
echo "localhost:8080/movie"
curl -b "sessionId=$1" "localhost:8080/movie" -i
echo ""