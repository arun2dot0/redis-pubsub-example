package redis.impl;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.scheduling.annotation.Scheduled;

import model.Person;
import redis.IRedisPublisher;

public class RedisPublisherImpl implements IRedisPublisher {
    private final RedisTemplate< String, Object > template;
    private final ChannelTopic topic; 
    private final AtomicLong counter = new AtomicLong( 0 );

    public RedisPublisherImpl( final RedisTemplate< String, Object > template, 
            final ChannelTopic topic ) {
        this.template = template;
        this.topic = topic;
    }

    @Scheduled( fixedDelay = 100 )
    public void publish() {
    	String count = String.valueOf( counter.incrementAndGet());
    	Person p = new Person("Jason "+count,"Bourne" +count,"001","jason@bourne.com");
        template.convertAndSend( topic.getTopic(), p.toString() );
    } 
}