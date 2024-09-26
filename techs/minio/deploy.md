## passos de executar localmente
https://min.io/docs/minio/container/index.html

## execução via docker

docker run \
   -p 9000:9000 \
   -p 9001:9001 \
   --name minio-s3 \
   -v data:/data \
   -e "MINIO_ROOT_USER=minio" \
   -e "MINIO_ROOT_PASSWORD=minio123" \
   quay.io/minio/minio server /data --console-address ":9001"