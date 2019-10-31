import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2019/7/8.
 */
public class TestJedis {
   @Test
   public void testJedis01(){
       Jedis jedis = new Jedis("10.8.157.12", 6379);
       String username = jedis.get("username");
       System.out.println(username);
       jedis.close();
   }
    @Test
    public void testJedisPool(){
        JedisPool jedisPool = new JedisPool("10.8.157.12", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("username","laoliu");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.close();
    }
}
