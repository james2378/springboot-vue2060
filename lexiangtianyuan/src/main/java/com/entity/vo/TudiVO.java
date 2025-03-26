package com.entity.vo;

import com.entity.TudiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 土地
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tudi")
public class TudiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 农民
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 土地名称
     */

    @TableField(value = "tudi_name")
    private String tudiName;


    /**
     * 土地照片
     */

    @TableField(value = "tudi_photo")
    private String tudiPhoto;


    /**
     * 合同
     */

    @TableField(value = "tudi_file")
    private String tudiFile;


    /**
     * 所在地址
     */

    @TableField(value = "tudi_address")
    private String tudiAddress;


    /**
     * 土地类型
     */

    @TableField(value = "tudi_types")
    private Integer tudiTypes;


    /**
     * 有无树
     */

    @TableField(value = "tudi_shumu_types")
    private Integer tudiShumuTypes;


    /**
     * 土地状态
     */

    @TableField(value = "tudi_haohuai_types")
    private Integer tudiHaohuaiTypes;


    /**
     * 土地原价/月
     */

    @TableField(value = "tudi_old_money")
    private Double tudiOldMoney;


    /**
     * 现价/月
     */

    @TableField(value = "tudi_new_money")
    private Double tudiNewMoney;


    /**
     * 点击次数
     */

    @TableField(value = "tudi_clicknum")
    private Integer tudiClicknum;


    /**
     * 土地介绍
     */

    @TableField(value = "tudi_content")
    private String tudiContent;


    /**
     * 是否租赁
     */

    @TableField(value = "tudi_zulin_types")
    private Integer tudiZulinTypes;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "tudi_delete")
    private Integer tudiDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：土地名称
	 */
    public String getTudiName() {
        return tudiName;
    }


    /**
	 * 获取：土地名称
	 */

    public void setTudiName(String tudiName) {
        this.tudiName = tudiName;
    }
    /**
	 * 设置：土地照片
	 */
    public String getTudiPhoto() {
        return tudiPhoto;
    }


    /**
	 * 获取：土地照片
	 */

    public void setTudiPhoto(String tudiPhoto) {
        this.tudiPhoto = tudiPhoto;
    }
    /**
	 * 设置：合同
	 */
    public String getTudiFile() {
        return tudiFile;
    }


    /**
	 * 获取：合同
	 */

    public void setTudiFile(String tudiFile) {
        this.tudiFile = tudiFile;
    }
    /**
	 * 设置：所在地址
	 */
    public String getTudiAddress() {
        return tudiAddress;
    }


    /**
	 * 获取：所在地址
	 */

    public void setTudiAddress(String tudiAddress) {
        this.tudiAddress = tudiAddress;
    }
    /**
	 * 设置：土地类型
	 */
    public Integer getTudiTypes() {
        return tudiTypes;
    }


    /**
	 * 获取：土地类型
	 */

    public void setTudiTypes(Integer tudiTypes) {
        this.tudiTypes = tudiTypes;
    }
    /**
	 * 设置：有无树
	 */
    public Integer getTudiShumuTypes() {
        return tudiShumuTypes;
    }


    /**
	 * 获取：有无树
	 */

    public void setTudiShumuTypes(Integer tudiShumuTypes) {
        this.tudiShumuTypes = tudiShumuTypes;
    }
    /**
	 * 设置：土地状态
	 */
    public Integer getTudiHaohuaiTypes() {
        return tudiHaohuaiTypes;
    }


    /**
	 * 获取：土地状态
	 */

    public void setTudiHaohuaiTypes(Integer tudiHaohuaiTypes) {
        this.tudiHaohuaiTypes = tudiHaohuaiTypes;
    }
    /**
	 * 设置：土地原价/月
	 */
    public Double getTudiOldMoney() {
        return tudiOldMoney;
    }


    /**
	 * 获取：土地原价/月
	 */

    public void setTudiOldMoney(Double tudiOldMoney) {
        this.tudiOldMoney = tudiOldMoney;
    }
    /**
	 * 设置：现价/月
	 */
    public Double getTudiNewMoney() {
        return tudiNewMoney;
    }


    /**
	 * 获取：现价/月
	 */

    public void setTudiNewMoney(Double tudiNewMoney) {
        this.tudiNewMoney = tudiNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getTudiClicknum() {
        return tudiClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setTudiClicknum(Integer tudiClicknum) {
        this.tudiClicknum = tudiClicknum;
    }
    /**
	 * 设置：土地介绍
	 */
    public String getTudiContent() {
        return tudiContent;
    }


    /**
	 * 获取：土地介绍
	 */

    public void setTudiContent(String tudiContent) {
        this.tudiContent = tudiContent;
    }
    /**
	 * 设置：是否租赁
	 */
    public Integer getTudiZulinTypes() {
        return tudiZulinTypes;
    }


    /**
	 * 获取：是否租赁
	 */

    public void setTudiZulinTypes(Integer tudiZulinTypes) {
        this.tudiZulinTypes = tudiZulinTypes;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getTudiDelete() {
        return tudiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setTudiDelete(Integer tudiDelete) {
        this.tudiDelete = tudiDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
