package com.zbooks.model.entity;

import com.zbooks.model.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 全局返回结果统一封装
 * Version: 1.0
 * Create Time: 2022/7/16 14:56
 *
 * @author TBH
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * 返回的状态码
     */
    private Integer code;
    /**
     * 返回的编号
     */
    private Object data;

    /**
     * 返回的信息
     */
    private String message;


    /**
     * @Description 成功返回
     * @Param [data 返回数据，message 附加消息 ]
     **/
    public static Result success(Object data, String message) {
        Result r = new Result();
        r.setCode(ResponseEnum.SUCCESS_EXEC.getKey());
        r.setData(data);
        r.setMessage(message == null ? ResponseEnum.SUCCESS_EXEC.getValue() : message);
        return r;
    }

    /**
     * @Description 成功返回
     * @Param [data 返回数据]
     **/
    public static Result success(Object data) {
        return success(data, null);
    }

    /**
     * @Description 成功返回
     **/
    public static Result success() {
        return success("业务成功");
    }


    /**
     * @Param [code 失败的状态, message 失败的原因]
     **/
    public static Result fail(Integer code, String message) {
        Result r = new Result();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    /**
     * @Param [code 失败的状态, message 失败的原因]
     **/
    public static Result fail(ResponseEnum responseEnum) {
        Result r = new Result();
        r.setCode(responseEnum.getKey());
        r.setMessage(responseEnum.getValue());
        return r;
    }

    public static Result fail() {
        Result r = new Result();
        r.setCode(-1);
        r.setMessage("业务失败");
        return r;
    }
}