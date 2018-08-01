package com.sobt.pro.controller.paramDto.out;

import java.util.List;

public class WYOutDto {

    public static class DiskFileBatchDownloadOutDto{

        private List<String> url;

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }
    }


}
