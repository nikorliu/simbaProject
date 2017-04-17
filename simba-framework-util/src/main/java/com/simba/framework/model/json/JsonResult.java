package com.simba.framework.model.json;import com.simba.framework.util.json.FastJsonUtil;/** * 返回给页面的json格式数据 *  * @author caozj *  */public class JsonResult {  /**   * 成功码   */  public static final int successCode = 200;  /**   * 错误码   */  public static final int failCode = 400;  /**   * 状态码(200代表成功，其他可自行定义)   */  private int code;  /**   * 提示消息   */  private String msg;  /**   * 数据对象   */  private Object data;  public int getCode() {    return code;  }  public void setCode(int code) {    this.code = code;  }  public String getMsg() {    return msg;  }  public void setMsg(String msg) {    this.msg = msg;  }  public Object getData() {    return data;  }  public void setData(Object data) {    this.data = data;  }  public JsonResult() {    code = successCode;  }  public JsonResult(Object data) {    this.data = data;    code = successCode;  }  public JsonResult(Object data, String msg) {    this.data = data;    this.code = successCode;    this.msg = msg;  }  public JsonResult(Object data, String msg, int code) {    this.data = data;    this.code = code;    this.msg = msg;  }  public JsonResult(String msg, int code) {    this.code = code;    this.msg = msg;  }  public JsonResult(int code) {    this.code = code;  }  public String toJson() {    return FastJsonUtil.toJson(this);  }}