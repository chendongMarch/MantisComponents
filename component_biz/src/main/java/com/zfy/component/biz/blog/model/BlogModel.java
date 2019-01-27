package com.zfy.component.biz.blog.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * CreateAt : 2019/1/24
 * Describe :
 *
 * @author chendong
 */
public class BlogModel implements Parcelable {

    private String content;


    public BlogModel(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
    }

    public BlogModel() {
    }

    protected BlogModel(Parcel in) {
        this.content = in.readString();
    }

    public static final Parcelable.Creator<BlogModel> CREATOR = new Parcelable.Creator<BlogModel>() {
        @Override
        public BlogModel createFromParcel(Parcel source) {
            return new BlogModel(source);
        }

        @Override
        public BlogModel[] newArray(int size) {
            return new BlogModel[size];
        }
    };
}
