package com.haphap.recycleview.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {
    private int photo;
    private String
            name,
            detail;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.detail);
    }

    public Hero() {
    }

    protected Hero(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.detail = in.readString();
    }

    public static final Parcelable.Creator<Hero> CREATOR = new Parcelable.Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel source) {
            return new Hero(source);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };
}
