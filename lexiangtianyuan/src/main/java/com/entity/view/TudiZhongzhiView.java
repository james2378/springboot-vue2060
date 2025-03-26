package com.entity.view;

import com.entity.TudiZhongzhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 种植详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("tudi_zhongzhi")
public class TudiZhongzhiView extends TudiZhongzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shangjia
			/**
			* 农民名称
			*/
			private String shangjiaName;
			/**
			* 联系方式
			*/
			private String shangjiaPhone;
			/**
			* 邮箱
			*/
			private String shangjiaEmail;
			/**
			* 头像
			*/
			private String shangjiaPhoto;
			/**
			* 农民信用类型
			*/
			private Integer shangjiaXingjiTypes;
				/**
				* 农民信用类型的值
				*/
				private String shangjiaXingjiValue;
			/**
			* 现有余额
			*/
			private Double newMoney;
			/**
			* 农民介绍
			*/
			private String shangjiaContent;
			/**
			* 逻辑删除
			*/
			private Integer shangjiaDelete;

		//级联表 tudi_order
			/**
			* 租赁单号
			*/
			private String tudiOrderUuidNumber;
			/**
			* 土地租赁订单 的 用户
			*/
			private Integer tudiOrderYonghuId;
			/**
			* 到期时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date daoqiTime;
			/**
			* 是否评价
			*/
			private Integer pingjiaTypes;
				/**
				* 是否评价的值
				*/
				private String pingjiaValue;

	public TudiZhongzhiView() {

	}

	public TudiZhongzhiView(TudiZhongzhiEntity tudiZhongzhiEntity) {
		try {
			BeanUtils.copyProperties(this, tudiZhongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}











				//级联表的get和set shangjia
					/**
					* 获取： 农民名称
					*/
					public String getShangjiaName() {
						return shangjiaName;
					}
					/**
					* 设置： 农民名称
					*/
					public void setShangjiaName(String shangjiaName) {
						this.shangjiaName = shangjiaName;
					}
					/**
					* 获取： 联系方式
					*/
					public String getShangjiaPhone() {
						return shangjiaPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setShangjiaPhone(String shangjiaPhone) {
						this.shangjiaPhone = shangjiaPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getShangjiaEmail() {
						return shangjiaEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setShangjiaEmail(String shangjiaEmail) {
						this.shangjiaEmail = shangjiaEmail;
					}
					/**
					* 获取： 头像
					*/
					public String getShangjiaPhoto() {
						return shangjiaPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setShangjiaPhoto(String shangjiaPhoto) {
						this.shangjiaPhoto = shangjiaPhoto;
					}
					/**
					* 获取： 农民信用类型
					*/
					public Integer getShangjiaXingjiTypes() {
						return shangjiaXingjiTypes;
					}
					/**
					* 设置： 农民信用类型
					*/
					public void setShangjiaXingjiTypes(Integer shangjiaXingjiTypes) {
						this.shangjiaXingjiTypes = shangjiaXingjiTypes;
					}


						/**
						* 获取： 农民信用类型的值
						*/
						public String getShangjiaXingjiValue() {
							return shangjiaXingjiValue;
						}
						/**
						* 设置： 农民信用类型的值
						*/
						public void setShangjiaXingjiValue(String shangjiaXingjiValue) {
							this.shangjiaXingjiValue = shangjiaXingjiValue;
						}
					/**
					* 获取： 现有余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 现有余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 农民介绍
					*/
					public String getShangjiaContent() {
						return shangjiaContent;
					}
					/**
					* 设置： 农民介绍
					*/
					public void setShangjiaContent(String shangjiaContent) {
						this.shangjiaContent = shangjiaContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShangjiaDelete() {
						return shangjiaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShangjiaDelete(Integer shangjiaDelete) {
						this.shangjiaDelete = shangjiaDelete;
					}














				//级联表的get和set tudi_order
					/**
					* 获取： 租赁单号
					*/
					public String getTudiOrderUuidNumber() {
						return tudiOrderUuidNumber;
					}
					/**
					* 设置： 租赁单号
					*/
					public void setTudiOrderUuidNumber(String tudiOrderUuidNumber) {
						this.tudiOrderUuidNumber = tudiOrderUuidNumber;
					}

					/**
					* 获取：土地租赁订单 的 用户
					*/
					public Integer getTudiOrderYonghuId() {
						return tudiOrderYonghuId;
					}
					/**
					* 设置：土地租赁订单 的 用户
					*/
					public void setTudiOrderYonghuId(Integer tudiOrderYonghuId) {
						this.tudiOrderYonghuId = tudiOrderYonghuId;
					}

					/**
					* 获取： 到期时间
					*/
					public Date getDaoqiTime() {
						return daoqiTime;
					}
					/**
					* 设置： 到期时间
					*/
					public void setDaoqiTime(Date daoqiTime) {
						this.daoqiTime = daoqiTime;
					}
					/**
					* 获取： 是否评价
					*/
					public Integer getPingjiaTypes() {
						return pingjiaTypes;
					}
					/**
					* 设置： 是否评价
					*/
					public void setPingjiaTypes(Integer pingjiaTypes) {
						this.pingjiaTypes = pingjiaTypes;
					}


						/**
						* 获取： 是否评价的值
						*/
						public String getPingjiaValue() {
							return pingjiaValue;
						}
						/**
						* 设置： 是否评价的值
						*/
						public void setPingjiaValue(String pingjiaValue) {
							this.pingjiaValue = pingjiaValue;
						}













}
