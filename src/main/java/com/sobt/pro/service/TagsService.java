package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.TagsInDto;
import com.sobt.pro.controller.paramDto.out.TagsOutDto;
import com.sobt.pro.dao.bean.TBootstrapTag;
import com.sobt.pro.vo.SuccessBean;

public interface TagsService {

    public SuccessBean<TagsOutDto.ParentLevelTagsOutDto> parentLevelTags(TagsInDto.ParentLevelTagsInDto param);

    public SuccessBean<TagsOutDto.TagsDataOutDto> TagsData(TagsInDto.TagsDataInDto param);

    public SuccessBean saveTags(TBootstrapTag tag);

    public SuccessBean editTags(TBootstrapTag tag);

    public SuccessBean deleteTags(TBootstrapTag tag);
}
