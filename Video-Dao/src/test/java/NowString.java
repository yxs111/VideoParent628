import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NowString {
    public static void main(String[] args) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//
//        Date date = new Date();
//        Timestamp timestamp = new Timestamp(date.getTime()); //2013-01-14 22:45:36.484
//        System.out.println(timestamp);


        //String转换为java.util.Date

        String str = "2013-01-14";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null; //初始化date

        try {

            date = sdf.parse(str); //Mon Jan 14 00:00:00 CST 2013

        } catch (ParseException e) {

            e.printStackTrace();

        }
        System.out.println(sdf);
        System.out.println(date);


//java.util.Date转换为String

        Date date2 = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String str2 = format.format(date2); //2013-01-14
        System.out.println(str2);
    }
}
