package com.sobt.pro.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.controller.paramDto.in.WYInDto;
import com.sobt.pro.controller.paramDto.out.WYOutDto;
import com.sobt.pro.dao.TArticleDao;
import com.sobt.pro.dao.bean.TArticle;
import com.sobt.pro.dao.bean.TArticleExample;
import com.sobt.pro.service.WYService;
import com.sobt.pro.vo.PythonConfig;
import com.sobt.pro.vo.SuccessBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class WYServiceImpl implements WYService {
    Logger log= LoggerFactory.getLogger(this.getClass());

    @Resource
    PythonConfig pythonConfig;

    @Override
    public SuccessBean<WYOutDto.DiskFileBatchDownloadOutDto> diskFileBatchDownload(WYInDto.DiskFileBatchDownloadInDto param) {
        SuccessBean<WYOutDto.DiskFileBatchDownloadOutDto> successBean=new SuccessBean<>();
        WYOutDto.DiskFileBatchDownloadOutDto data=new WYOutDto.DiskFileBatchDownloadOutDto();

        // TODO Auto-generated method stub
        try {
            Base64.Encoder encoder=Base64.getEncoder();
            String python_sql= URLEncoder.encode(pythonConfig.getPython_sql(),"utf-8");
            String message=pythonConfig.getChrome_driver_path();
            String chrome_driver_path= URLEncoder.encode(message,"utf8");
            chrome_driver_path=chrome_driver_path.replaceAll("\\+", "%20");
            String file_list=URLEncoder.encode(param.getFile_list(),"utf8");
            String qq=URLEncoder.encode(param.getAccount_str(),"utf8");
//            File path=new File(ResourceUtils.getURL("classpath:").getPath());
            String pythonPath=pythonConfig.getPython_exe_path();
//            log.info("pythonPath:"+pythonPath);
            String command=String.format("python %s//weiyun.py --python_sql %s --chrome_driver_path %s --qq %s --file_list %s ", pythonPath,python_sql,chrome_driver_path,qq,file_list);
//            log.info("command:"+command);
            Process proc=Runtime.getRuntime().exec(command); //执行py文件
            InputStreamReader stdin=new InputStreamReader(proc.getInputStream());
            LineNumberReader input=new LineNumberReader(stdin);
            String line;
            List url=new ArrayList<>();
            while((line=input.readLine())!=null ){
                url= JSONArray.parseArray(line, String.class);
            }
            data.setUrl(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("地址转化错误信息:",e);
            data.setUrl(new ArrayList<>());
        }
        successBean.setData(data);
        successBean.setError(MsgEnum.Success.getCode());
        successBean.setDesc(MsgEnum.Success.getMsg());
        return successBean;
    }
}
