/*
 * Created on Sep 22, 2005
 */
package com.candidate.hr;


/**
 * @author HSONI 
 *
 * TODO Discribe the class / interface here
 */
public class Skills {
	private String skill;
	private String rating;
	private String remark;
	private String skill_id;
	
	public Skills(){}
	
	/**
	 * @return Returns the rating.
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating The rating to set.
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * @return Returns the remark.
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark The remark to set.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return Returns the skill.
	 */
	public String getSkill() {
		return skill;
	}
	/**
	 * @param skill The skill to set.
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public void setSkill_id(String skill_id){
		this.skill_id = skill_id;
	}
	
	public String getSkill_id(){
		return skill_id;
	}
}
