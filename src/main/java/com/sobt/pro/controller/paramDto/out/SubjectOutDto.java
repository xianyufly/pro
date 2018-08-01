package com.sobt.pro.controller.paramDto.out;

import com.sobt.pro.dao.bean.TSubject;

import java.util.List;

public class SubjectOutDto {

    /**
     * 菜单列表结果
     */
    public static class GetSubjectListOutDto{

        private List<TSubject> subjects;

        public List<TSubject> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<TSubject> subjects) {
            this.subjects = subjects;
        }
    }
}
