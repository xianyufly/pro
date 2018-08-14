package com.sobt.pro.service;

import com.sobt.pro.controller.paramDto.in.WYInDto;
import com.sobt.pro.controller.paramDto.out.WYOutDto;
import com.sobt.pro.vo.SuccessBean;

public interface WYService {

    public SuccessBean<WYOutDto.DiskFileBatchDownloadOutDto> diskFileBatchDownload(WYInDto.DiskFileBatchDownloadInDto param);

}
