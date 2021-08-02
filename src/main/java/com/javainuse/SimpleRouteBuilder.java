package com.javainuse;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		String topicName = "topic=javainuse-topic";
		String kafkaServer = "kafka:localhost:9092";
		String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
		String serializerClass = "serializerClass=kafka.serializer.StringEncoder";

		String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&")
				.append(zooKeeperHost).append("&").append(serializerClass).toString();
		System.out.println("check:" + toKafka);

		// from("file:data/input?noop=true").split().tokenize("\n").to(toKafka);
		// from("/Users/vktyagi/Downloads/camelfile?noop=true").split().tokenize("\n");
		from("file:data/input?noop=true").split().tokenize("\n").to(toKafka);
		// .to("file:data/output");
	}
}