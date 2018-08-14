package com.sobt.pro.controller.paramDto.in;

public class WYInDto {

    /**
     * 下载文件地址
     */
    public static class DiskFileBatchDownloadInDto {

        private String account_str;

        private String file_list;

        public String getAccount_str() {
            return account_str;
        }

        public void setAccount_str(String account_str) {
            this.account_str = account_str;
        }

        public String getFile_list() {
            return file_list;
        }

        public void setFile_list(String file_list) {
            this.file_list = file_list;
        }
    }

    /**
     * 下载文件地址--通过dirName
     */
    public static class DiskFileBatchDownloadByDirName {

        private String dirName;

        public String getDirName() {
            return dirName;
        }

        public void setDirName(String dirName) {
            this.dirName = dirName;
        }
    }

}