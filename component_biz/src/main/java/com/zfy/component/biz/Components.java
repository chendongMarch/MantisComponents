package com.zfy.component.biz;

/**
 * CreateAt : 2019/1/25
 * Describe :
 *
 * @author chendong
 */
public class Components {


    public static final String MUSIC_COMPONENT_NAME     = "music";
    public static final int    MUSIC_COMPONENT_PRIORITY = 0;
    public static final String MUSIC_COMPONENT_SERVICE  = "/music/component/init";
    public static final String MUSIC_SERVICE            = "/music/service/index";
    public static final String MUSIC_INDEX_PAGE         = "/music/page/index";

    public static final String BLOG_COMPONENT_NAME     = "blog";
    public static final int    BLOG_COMPONENT_PRIORITY = 0;
    public static final String BLOG_COMPONENT_SERVICE  = "/blog/component/init";
    public static final String BLOG_SERVICE            = "/blog/service/index";
    public static final String BLOG_INDEX_PAGE         = "/blog/page/index";
    public static final int    BLOG_PAGE_EXTRA         = 0b1_1_0_1_0_1_0_1_0;


    public static final String MAIN_COMPONENT_NAME     = "main";
    public static final int    MAIN_COMPONENT_PRIORITY = 0;
    public static final String MAIN_COMPONENT_SERVICE  = "/main/component/init";
    public static final String MAIN_SERVICE            = "/main/service/index";
    public static final String MAIN_INDEX_PAGE         = "/main/page/index";


    public static String[] getComponentServiceNames() {
        return new String[]{
                MUSIC_COMPONENT_SERVICE,
                MAIN_COMPONENT_SERVICE,
                BLOG_COMPONENT_SERVICE,
        };
    }
}
