package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 土地租赁订单
 *
 * @author 
 * @email
 */
@TableName("tudi_order")
public class TudiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TudiOrderEntity() {

	}

	public TudiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TudiOrder{" +
            "id=" + id +
            ", tudiOrderUuidNumber=" + tudiOrderUuidNumber +
            ", tudiId=" + tudiId +
            ", yonghuId=" + yonghuId +
            ", insertTime=" + insertTime +
            ", daoqiTime=" + daoqiTime +
            ", pingjiaTypes=" + pingjiaTypes +
            ", createTime=" + createTime +
        "}";
    }
}
