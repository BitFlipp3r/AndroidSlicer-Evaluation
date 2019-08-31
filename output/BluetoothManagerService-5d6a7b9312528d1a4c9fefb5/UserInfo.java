package android.content.pm;

            = new Parcelable.Creator<UserInfo>() {
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

    };

