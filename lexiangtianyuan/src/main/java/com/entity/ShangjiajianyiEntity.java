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
 * 农民建议
 *
 * @author 
 * @email
 */
@TableName("shangjiajianyi")
public class ShangjiajianyiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangjiajianyiEntity() {

	}

	public ShangjiajianyiEntity(T t) {
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
     * 农民
     */
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


    /**
     * 建议标题
     */
    @TableField(value = "shangjiajianyi_name")

    private String shangjiajianyiName;


    /**
     * 建议详情
     */
    @TableField(value = "shangjiajianyi_content")

    private String shangjiajianyiContent;


    /**
     * 建议时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：农民
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：农民
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：建议标题
	 */
    public String getShangjiajianyiName() {
        return shangjiajianyiName;
    }


    /**
	 * 获取：建议标题
	 */

    public void setShangjiajianyiName(String shangjiajianyiName) {
        this.shangjiajianyiName = shangjiajianyiName;
    }
    /**
	 * 设置：建议详情
	 */
    public String getShangjiajianyiContent() {
        return shangjiajianyiContent;
    }


    /**
	 * 获取：建议详情
	 */

    public void setShangjiajianyiContent(String shangjiajianyiContent) {
        this.shangjiajianyiContent = shangjiajianyiContent;
    }
    /**
	 * 设置：建议时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：建议时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Shangjiajianyi{" +
            "id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", shangjiajianyiName=" + shangjiajianyiName +
            ", shangjiajianyiContent=" + shangjiajianyiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
