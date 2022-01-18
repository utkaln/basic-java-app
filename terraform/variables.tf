variable "vpc_cidr_block" {
  default = "10.0.0.0/16"
}
variable "subnet_cidr_block" {
  default = "10.0.10.0/24"
}
variable "region" {
  default = "us-east-1"
}
variable "def_az" {
  default = "us-east-1a"
}
variable "env_prefix" {
  default = "dev"
}

variable "ssh_ip" {
  default = "151.196.124.95/32"
}

variable "instance_type" {
  default = "t2.micro"
}

variable "http_ip" {
  default = "0.0.0.0/0"
}

variable "image_name" {
  default = ["amzn2-ami-hvm-*-x86_64-gp2"]
}


