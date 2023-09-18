package com.bean;

import java.io.InputStream;

public class UploadBean {

	private String uid, fname, content, rk, cmk, ecmk, dek, edek, da;
	private InputStream photo, ephoto;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRk() {
		return rk;
	}
	public void setRk(String rk) {
		this.rk = rk;
	}
	public String getCmk() {
		return cmk;
	}
	public void setCmk(String cmk) {
		this.cmk = cmk;
	}
	public String getEcmk() {
		return ecmk;
	}
	public void setEcmk(String ecmk) {
		this.ecmk = ecmk;
	}
	public String getDek() {
		return dek;
	}
	public void setDek(String dek) {
		this.dek = dek;
	}
	public String getEdek() {
		return edek;
	}
	public void setEdek(String edek) {
		this.edek = edek;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	public InputStream getEphoto() {
		return ephoto;
	}
	public void setEphoto(InputStream ephoto) {
		this.ephoto = ephoto;
	}
}
