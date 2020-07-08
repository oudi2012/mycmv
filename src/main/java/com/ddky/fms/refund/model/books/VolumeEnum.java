package com.ddky.fms.refund.model.books;


/**
 * 卷册
 * @author a
 */
public enum VolumeEnum {

    /** 上册 */
    UP(1, "上册"),
    DOWN(2, "下册");

    /**状态编码**/
    private int code;

    /**状态标题**/
    private String title;

    /**
     * 构造函数
     * @param code 状态编码
     * @param title 状态标题
     */
    VolumeEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static int getCodeByTitle(String title) {
        for (VolumeEnum item : VolumeEnum.values()) {
            if (item.title.equals(title)) {
                return item.code;
            }
        }
        return 1;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
