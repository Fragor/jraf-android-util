/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 * 
 * Copyright (C) 2014 Benoit 'BoD' Lubek (BoD@JRAF.org)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jraf.android.util.about;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class AboutActivityParams implements Parcelable {
    public static class Link implements Parcelable {
        public String uri;
        public String text;

        public Link(String uri, String text) {
            this.uri = uri;
            this.text = text;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.uri);
            dest.writeString(this.text);
        }

        private Link(Parcel in) {
            this.uri = in.readString();
            this.text = in.readString();
        }

        public static final Parcelable.Creator<Link> CREATOR = new Parcelable.Creator<Link>() {
            @Override
            public Link createFromParcel(Parcel source) {
                return new Link(source);
            }

            @Override
            public Link[] newArray(int size) {
                return new Link[size];
            }
        };
    }

    public String appName;
    public String buildDate;
    public String gitSha1;
    public String authorCopyright;
    public String license;
    public List<Link> linkList = new ArrayList<>();
    public String shareTextSubject;
    public String shareTextBody;
    public int backgroundResId;
    public boolean isLightIcons;

    public AboutActivityParams(String appName, String buildDate, String gitSha1, String authorCopyright, String license, List<Link> linkList,
                               String shareTextSubject, String shareTextBody, int backgroundResId, boolean isLightIcons) {
        this.appName = appName;
        this.buildDate = buildDate;
        this.gitSha1 = gitSha1;
        this.authorCopyright = authorCopyright;
        this.license = license;
        this.linkList = linkList;
        this.shareTextSubject = shareTextSubject;
        this.shareTextBody = shareTextBody;
        this.backgroundResId = backgroundResId;
        this.isLightIcons = isLightIcons;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(appName);
        dest.writeString(buildDate);
        dest.writeString(gitSha1);
        dest.writeString(authorCopyright);
        dest.writeString(license);
        dest.writeTypedList(linkList);
        dest.writeString(shareTextSubject);
        dest.writeString(shareTextBody);
        dest.writeInt(backgroundResId);
        dest.writeInt(isLightIcons ? 1 : 0);
    }

    private AboutActivityParams(Parcel in) {
        appName = in.readString();
        buildDate = in.readString();
        gitSha1 = in.readString();
        authorCopyright = in.readString();
        license = in.readString();
        in.readTypedList(linkList, Link.CREATOR);
        shareTextSubject = in.readString();
        shareTextBody = in.readString();
        backgroundResId = in.readInt();
        isLightIcons = in.readInt() == 1;
    }

    public static final Creator<AboutActivityParams> CREATOR = new Creator<AboutActivityParams>() {
        @Override
        public AboutActivityParams createFromParcel(Parcel source) {
            return new AboutActivityParams(source);
        }

        @Override
        public AboutActivityParams[] newArray(int size) {
            return new AboutActivityParams[size];
        }
    };
}
