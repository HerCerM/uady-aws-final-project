### Build and run

SSH into the EC2 instance where the cloned repo is:

```
ssh ec2-user@CHANGE_ME_PUBLIC_IP -i CHANGE_ME_FILE_NAME.pem
```

Then, run the following commands, putting the correct values for the env variables. If running locally, use the same commands below:

```
export DB_USERNAME=
export DB_PASSWORD=
export DB_HOST=
export AWS_ACCESS_KEY_ID=
export AWS_SECRET_ACCESS_KEY=
export AWS_SESSION_TOKEN=

gradle clean bootRun --args='--spring.profiles.active=mysql' -x test
```
