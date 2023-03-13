<img width="960" alt="bearer" src="https://user-images.githubusercontent.com/39404852/224669712-ffc0b9c3-f5ce-4a5c-8843-2b5d9535924f.png">


### How To Generate Keys in the Certs directory ?
```shell
# create rsa key pair
openssl genrsa -out keypair.pem 2048

# extract public key
openssl rsa -in keypair.pem -pubout -out public.pem

# create private key in PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
```

### For further explanation 

Please visit this [blog](https://www.danvega.dev/blog/2022/09/06/spring-security-jwt)
