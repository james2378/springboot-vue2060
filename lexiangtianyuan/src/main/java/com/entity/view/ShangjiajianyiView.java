package com.entity.view;

import com.entity.ShangjiajianyiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 农民建议
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shangjiajianyi")
public class ShangjiajianyiView extends ShangjiajianyiEntity implements Serializable {
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

	public ShangjiajianyiView() {

	}

	public ShangjiajianyiView(ShangjiajianyiEntity shangjiajianyiEntity) {
		try {
			BeanUtils.copyProperties(this, shangjiajianyiEntity);
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


















}
