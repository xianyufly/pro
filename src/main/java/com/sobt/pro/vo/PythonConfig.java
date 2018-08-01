package com.sobt.pro.vo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "python")
public class PythonConfig {

    private String python_sql;

    private String chrome_driver_path;

    private String python_exe_path;

    public String getPython_exe_path() {
        return python_exe_path;
    }

    public void setPython_exe_path(String python_exe_path) {
        this.python_exe_path = python_exe_path;
    }

    public String getPython_sql() {
        return python_sql;
    }

    public void setPython_sql(String python_sql) {
        this.python_sql = python_sql;
    }

    public String getChrome_driver_path() {
        return chrome_driver_path;
    }

    public void setChrome_driver_path(String chrome_driver_path) {
        this.chrome_driver_path = chrome_driver_path;
    }
}
