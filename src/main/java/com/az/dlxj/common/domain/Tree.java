package com.az.dlxj.common.domain;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * tree TODO <br>
 * 
 * @author kangxu2 2017-1-7
 * 
 */
public class Tree<T> {
	/**
	 * 节点ID
	 */
	private String id;
	/**
	 * 显示节点文本
	 */
	private String title;
	/**
	 * 节点状态，open closed
	 */
	private Boolean spread = Boolean.FALSE;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 链接
	 */
	private String href;
	/**
	 * 节点是否被选中 true false
	 */
	private boolean checked = false;
	/**
	 * 节点的子节点
	 */
	private List<Tree<T>> children = new ArrayList<Tree<T>>();
	/**
	 * 父ID
	 */
	private String parentId;
	/**
	 * 是否有父节点
	 */
	private boolean hasParent = false;
	/**
	 * 是否有子节点
	 */
	private boolean hasChildren = false;


	public Tree() {
		super();
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<Tree<T>> getChildren() {
		return children;
	}

	public void setChildren(List<Tree<T>> children) {
		this.children = children;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public boolean isHasParent() {
		return hasParent;
	}

	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
}