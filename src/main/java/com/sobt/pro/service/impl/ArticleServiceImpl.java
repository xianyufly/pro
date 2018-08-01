package com.sobt.pro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sobt.pro.constant.MsgEnum;
import com.sobt.pro.constant.SatusEnum;
import com.sobt.pro.controller.paramDto.in.ArticleInDto;
import com.sobt.pro.controller.paramDto.out.ArticleOutDto;
import com.sobt.pro.dao.TArticleDao;
import com.sobt.pro.dao.bean.TArticle;
import com.sobt.pro.dao.bean.TArticleExample;
import com.sobt.pro.service.ArticleService;
import com.sobt.pro.vo.SuccessBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    TArticleDao articleDao;

    @Override
    public SuccessBean<ArticleOutDto.GetArticleByPageOutDto> getArticleByPage(ArticleInDto.GetArticleByPageInDto param) {
        SuccessBean<ArticleOutDto.GetArticleByPageOutDto> result=new SuccessBean<>();
        ArticleOutDto.GetArticleByPageOutDto data=new ArticleOutDto.GetArticleByPageOutDto();
        PageHelper.startPage(param.getPage(), param.getRows());
        TArticleExample example=new TArticleExample();
        TArticleExample.Criteria c=example.createCriteria();
        c.andStatusEqualTo(SatusEnum.Normal.getCode());
        if(!StringUtil.isEmpty(param.getSubject())){
            c.andArtTypeEqualTo(param.getSubject());
        }
        example.setOrderByClause("pub_date desc");
        List<TArticle> dataRows=articleDao.selectByExample(example);
        PageInfo page = new PageInfo(dataRows);
        data.setDataRows(dataRows);
        data.setTotals(page.getTotal());
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

    @Override
    public SuccessBean<ArticleOutDto.GetArticleDetailOutDto> getArticleDetail(ArticleInDto.GetArticleDetailInDto param) {

        SuccessBean<ArticleOutDto.GetArticleDetailOutDto> result=new SuccessBean<>();
        ArticleOutDto.GetArticleDetailOutDto data=new ArticleOutDto.GetArticleDetailOutDto();
        TArticleExample example=new TArticleExample();
        TArticleExample.Criteria c=example.createCriteria();
        c.andDirNameEqualTo(param.getDirName());
        List<TArticle> articleList=articleDao.selectByExampleWithBLOBs(example);
        TArticle article=articleList.get(0);
        data.setArticle(article);
        //随机2片文章
        Map<String,Object> tempParam=new HashMap<>();
        tempParam.put("tid",article.getTid());
        tempParam.put("artType",article.getArtType());
        articleList=articleDao.selectRandomArticle(tempParam);
        data.setAboutArticle(articleList);
        result.setData(data);
        result.setError(MsgEnum.Success.getCode());
        result.setDesc(MsgEnum.Success.getMsg());
        return result;
    }

//    public static void main( String[] args ) throws IOException {
//        StringReader reader = new StringReader("在媒体和众多网友曝出“李天一提前6年出狱”“李天一已被安排出国”等消息之后，网络上讨论与质疑的声音也是此起彼伏，毕竟这件性侵案的影响力非常之大，出现这样的传闻让网友们也是相当的惊讶。而北京市监狱管...");
//        IKSegmenter ik = new IKSegmenter(reader, true);// 当为true时，分词器进行最大词长切分
//        Lexeme lexeme = null;
//        try {
//            while ((lexeme = ik.next()) != null)
//                System.out.println(lexeme.getLexemeText());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            reader.close();
//        }
//
//    }
}
