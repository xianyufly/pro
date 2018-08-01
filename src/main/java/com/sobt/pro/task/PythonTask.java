package com.sobt.pro.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

@Component
public class PythonTask {

//    @Scheduled(initialDelay = 5000,fixedRate = 6000)
//    public void timerToReport(){
//        for (int i = 0; i < 10; i++){
//            System.out.println("<================delay :" + i + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "count===============>");
//        }
//        System.out.println("==================================大分割线========================");
//        try {
//            Thread.sleep(10000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Base64.Encoder encoder=Base64.getEncoder();
            String python_sql=URLEncoder.encode("mysql+mysqldb://root:xian0402@localhost:3306/news","utf-8");
            String message="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
            String chrome_driver_path= URLEncoder.encode(message,"utf8");
            chrome_driver_path=chrome_driver_path.replaceAll("\\+", "%20");
            String pdir_key=URLEncoder.encode("a909c646985f636b296e5d07ca7c749c","utf8");
            String file_id=URLEncoder.encode("5851dbcf-7dea-4ef5-9a45-dca73090767f","utf8");
            String file_name=URLEncoder.encode("img_1532559736.jpeg","utf8");
            String command=String.format("python F:\\ideaWorkPlace\\pro\\src\\main\\resources\\python\\weiyun.py --python_sql %s --chrome_driver_path %s --pdir_key %s --file_id %s --file_name %s", python_sql,chrome_driver_path,pdir_key,file_id,file_name);
            Process proc=Runtime.getRuntime().exec(command); //执行py文件
            InputStreamReader stdin=new InputStreamReader(proc.getInputStream());
            LineNumberReader input=new LineNumberReader(stdin);
            String line;
            while((line=input.readLine())!=null ){
                System.out.println(line);//得到输出
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
