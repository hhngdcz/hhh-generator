package com.hhh.model;

import cn.hutool.bloomfilter.filter.SDBMFilter;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: HHNGDCZ
 * @since: 2023/12/27/15:54
 * @description:
 */
@Data
public class DataModel {
    /**
     * 是否循环
     */
    private boolean loop;
    /**
     * 作者注释
     */
    private String author="HHH";
    /**
     * 输出信息
     */
    private String outputText="sum=";
}
