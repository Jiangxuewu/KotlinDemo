package com.transsnet.note.model.structure;

import android.support.annotation.Keep;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Jiangxuewu on 2018/6/27.
 */
@Keep
@Entity
public class Task {
    @Id(autoincrement = true)
    private Long _id;

    private String done_time = "0000-00-00 00:00:00";
    private String stick_time = "0000-00-00 00:00:00";
    private int uid;
    private String list_id;
    private String client_time;
    private String content;
    private String checksum;
    private String create_time;
    private String modify_time;
    private int state;//0 todo, 1 done  2 delete
    private boolean isupload;// true 是否已经上传服务器过， false -> 需要与服务器同步； true->不需要与服务器同步
    @Generated(hash = 1409399669)
    public Task(Long _id, String done_time, String stick_time, int uid,
            String list_id, String client_time, String content, String checksum,
            String create_time, String modify_time, int state, boolean isupload) {
        this._id = _id;
        this.done_time = done_time;
        this.stick_time = stick_time;
        this.uid = uid;
        this.list_id = list_id;
        this.client_time = client_time;
        this.content = content;
        this.checksum = checksum;
        this.create_time = create_time;
        this.modify_time = modify_time;
        this.state = state;
        this.isupload = isupload;
    }
    @Generated(hash = 733837707)
    public Task() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getDone_time() {
        return this.done_time;
    }
    public void setDone_time(String done_time) {
        this.done_time = done_time;
    }
    public String getStick_time() {
        return this.stick_time;
    }
    public void setStick_time(String stick_time) {
        this.stick_time = stick_time;
    }
    public int getUid() {
        return this.uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getList_id() {
        return this.list_id;
    }
    public void setList_id(String list_id) {
        this.list_id = list_id;
    }
    public String getClient_time() {
        return this.client_time;
    }
    public void setClient_time(String client_time) {
        this.client_time = client_time;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getChecksum() {
        return this.checksum;
    }
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
    public String getCreate_time() {
        return this.create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    public String getModify_time() {
        return this.modify_time;
    }
    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }
    public int getState() {
        return this.state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public boolean getIsupload() {
        return this.isupload;
    }
    public void setIsupload(boolean isupload) {
        this.isupload = isupload;
    }

}
