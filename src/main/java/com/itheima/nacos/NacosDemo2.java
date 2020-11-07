package com.itheima.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.itheima.constants.Nacosconstant;
import org.junit.Test;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author: liuyuhang
 * @date: 2020/11/07
 */
public class NacosDemo2 {

     @Test
     public void t1() throws NacosException {
         /**
          * 使用nacos client远程获取nacos服务上的配置信息
          */

         String serverAddr = Nacosconstant.NACOSADDR;
         String dataId = Nacosconstant.NACOSDATAID;
         String group = Nacosconstant.NACOSDEFAULTGROUP;

         //namespace
         //String namespace = "c67e4a97-a698-4d6d-9bb1-cfac5f5b51c4";

         Properties properties =new Properties();
         properties.put(Nacosconstant.SERVCEADDR,serverAddr);
         //properties.put(Nacosconstant.NACOSNAMESPACEKEY,namespace);


         //获取配置
         ConfigService configService = NacosFactory.createConfigService(properties);
         String config = configService.getConfig(dataId, group, 5000);


         System.out.println(config);
         /**
          * String dataId, String group, Listener listener
          */

         configService.addListener(dataId, group, new Listener() {
             public Executor getExecutor() {
                 return null;
             }
             //当配置有变化 时候获取通知
             public void receiveConfigInfo(String s) {
                 System.out.println(s);
             }
         });

         while (true){
             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
}
