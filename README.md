# aws-lambda-terraform

This repo demonstrates how to create Lambda's in both `Java` with the help of `Terraform`. 

## Get started

Go to the `java` directory and do the following:

To get started simply create a `terraform.tfvars` file in `terraform`
directory with your AWS account/IAM User details. Your IAM User must have
[permissions](http://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)
for AWS Lambda and AWS API Gateway.

The contents should follow the template below (with you replacing the info
between `<< >>`):

```
aws_access_key = "<< your IAM user AWS access key >>"
aws_secret_key = "<< your IAM user AWS secret key >>"
region = "<< your chosen region >>"
account_id = "<<your AWS account id>>"

```

Or instead of the above, you can apply the account key and secret to your terminal session. See .`/terraform/main.tf` for more details:

```
export AWS_ACCESS_KEY_ID="<< your IAM user AWS access key >>"
export AWS_SECRET_ACCESS_KEY="<< your IAM user AWS secret key >>"
export AWS_SESSION_TOKEN="<< your session token when needed >>"
```

From the root of the project run the `build_and_deploy.sh` script.
This compiles the Java application into the `helloworld/target` directory
and runs Terraform to upload and configure the Lambda function and API Gateway.

```
$ ./build_and_deploy.sh
```

## Manually test your function

After a successful run, something similar to the output below should be visible:

```
Outputs:

curl = Run the following to test the lambda:
curl -H 'Content-Type: application/json' -X POST -d '{"name": "Emilio"}' https://XXXXXXXXXX.execute-api.us-east-1.amazonaws.com/beta/helloworld
```

To test your Lambda deployed behind the API Gateway all you need to do is
copy/paste the curl command (minus the `curl = ` part) e.g.

```
curl -H 'Content-Type: application/json' -X POST -d '{"name": "Emilio"}' https://XXXXXXXXXX.execute-api.us-east-1.amazonaws.com/beta/helloworld
```

## Rinse and repeat

You can make changes to the Java application and run the `build_and_deploy.sh`
script repeatedly to update the Lambda Function deployed into AWS.

## Tidy up when finished!

When you are finished, don't forget to shut your infrastructure down:

```
$ ./destroy.sh
```

## Disclaimer

Please note: I'm not responsible for any costs incurred within your AWS account :-)
