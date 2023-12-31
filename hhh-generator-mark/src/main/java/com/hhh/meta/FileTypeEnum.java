package com.hhh.meta;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: HHNGDCZ
 * @since: 2023/12/28/13:19
 * @description:
 */
public enum FileTypeEnum {
    DIR("目录", "dir"),
    FILE("文件", "file");

    private final String text;

    private final String value;

    FileTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
