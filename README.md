# redis-pubsub example

Example explores the capability of redis as pubsub

package redis.impl has the publisher and message listner and  
message is constrantly sent ever 100ms . 

use it to test redis as pubsub for your use case
check throughput /capacity of your redis cluster 

uses redis/jedis driver see beans.xml for config 

for docker run using
docker run -p 6379:6379 redis


Compile as maven project 

mvn clean install 

Execute from

Application.java

