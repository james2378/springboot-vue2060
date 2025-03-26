package com.entity.vo;

import com.entity.TudiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 土地租赁订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tudi_order")
public class TudiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 租赁单号
     */

    @TableField(value = "tudi_order_uuid_number")
    private String tudiOrderUuidNumber;


    /**
     * 土地
     */

    @TableField(value = "tudi_id")
    private Integer tudiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 租赁时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 到期时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "daoqi_time")
    private Date daoqiTime;


    /**
     * 是否评价
     */

    @TableField(value = "pingjia_types")
    private Integer pingjiaTypes;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：租赁单号
	 */
    public String getTudiOrderUuidNumber() {
        return tudiOrderUuidNumber;
    }


    /**
	 * 获取：租赁单号
	 */

    public void setTudiOrderUuidNumber(String tudiOrderUuidNumber) {
        this.tudiOrderUuidNumber = tudiOrderUuidNumber;
    }
    /**
	 * 设置：土地
	 */
    public Integer getTudiId() {
        return tudiId;
    }


    /**
	 * 获取：土地
	 */

    public void setTudiId(Integer tudiId) {
        this.tudiId = tudiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：租赁时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：租赁时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：到期时间
	 */
    public Date getDaoqiTime() {
        return daoqiTime;
    }


    /**
	 * 获取：到期时间
	 */

    public void setDaoqiTime(Date daoqiTime) {
        this.daoqiTime = daoqiTime;
    }
    /**
	 * 设置：是否评价
	 */
    public Integer getPingjiaTypes() {
        return pingjiaTypes;
    }


    /**
	 * 获取：是否评价
	 */

    public void setPingjiaTypes(Integer pingjiaTypes) {
        this.pingjiaTypes = pingjiaTypes;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
