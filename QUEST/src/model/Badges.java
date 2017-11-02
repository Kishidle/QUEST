package model;

import javax.swing.JButton;

public class Badges {
	
	private int badgeNum;
	private String badgeTitle = "";
	private String badgeDisc = "";
	private int badgeType;
	private String badgeIcon = "";
	private JButton badgeBtn;
	public int getBadgeNum() {
		return badgeNum;
	}
	public void setBadgeNum(int badgeNum) {
		this.badgeNum = badgeNum;
	}
	public String getBadgeTitle() {
		return badgeTitle;
	}
	public void setBadgeTitle(String badgeTitle) {
		this.badgeTitle = badgeTitle;
	}
	public String getBadgeDisc() {
		return badgeDisc;
	}
	public void setBadgeDisc(String badgeDisc) {
		this.badgeDisc = badgeDisc;
	}
	public int getBadgeType() {
		return badgeType;
	}
	public void setBadgeType(int badgeType) {
		this.badgeType = badgeType;
	}
	public String getBadgeIcon() {
		return badgeIcon;
	}
	public void setBadgeIcon(String badgeIcon) {
		this.badgeIcon = badgeIcon;
	}
	public JButton getBadgeBtn() {
		return badgeBtn;
	}
	public void setBadgeBtn(JButton badgeBtn) {
		this.badgeBtn = badgeBtn;
	}

}
