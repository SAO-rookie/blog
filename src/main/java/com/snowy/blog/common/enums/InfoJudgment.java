package com.snowy.blog.common.enums;

/**
 * @author snowy
 * @date 2021/12/2 23:02
 */
public enum InfoJudgment {
    // 以 存在的标准进行检查
    EXIST,
    // 以 不存在的标准进行检查
    NOT_EXIST;

    public static void handlerInfoJudgment(int count, InfoJudgment infoJudgment,String info){
        if (infoJudgment == InfoJudgment.EXIST){
            if (count > 0){
                throw new RuntimeException(info+"表存在数据");
            }
        }
        if (infoJudgment == InfoJudgment.NOT_EXIST){
            if (count == 0){
                throw new RuntimeException(info+"表不存在改数据");
            }
        }
    }
}
