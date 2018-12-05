package com.az.dlxj.common.util;

import java.util.HashMap;

/**
 * ajax返回结果：
 * 	0：ok
 * 	1: error
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 0);
		put("msg", "操作成功");
	}

	public static R error() {
		return error(1, "操作失败");
	}

	public static R error(String msg) {
		return error(1, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
