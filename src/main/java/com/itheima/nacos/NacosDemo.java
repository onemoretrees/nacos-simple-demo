package com.itheima.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.itheima.constants.Nacosconstant;
import org.junit.Test;

import java.util.Properties;

/**
 * @author: liuyuhang
 * @date: 2020/11/07
 */
public class NacosDemo {


    /**
     * 获取指定命名空间、默认组、指定地址、指定dataId 的的配置
     *
     * @throws NacosException
     */
    @Test
    public void getDvNameSpaceDefaultGroupData() throws NacosException {
        String serverAddrAndPort = Nacosconstant.NACOSADDR;
        String nameSpaceId = "0a0eae78-1aa3-484e-bdf2-8bb66e6cab87";
        String group = Nacosconstant.NACOSDEFAULTGROUP;
        String dataId = Nacosconstant.NACOSDATAID;


        Properties properties = new Properties();
        properties.put(Nacosconstant.SERVCEADDR, serverAddrAndPort);
        properties.put(Nacosconstant.NACOSNAMESPACEKEY, nameSpaceId);

        ConfigService configService = NacosFactory.createConfigService(properties);

        String content = configService.getConfig(dataId, group, 1000);
        System.err.println(content);
    }
}
