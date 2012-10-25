package catstd.passbook.activities.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class UserParcelable implements Parcelable {
    
    public static final Parcelable.Creator<UserParcelable> CREATOR = new Parcelable.Creator<UserParcelable>() {

        public UserParcelable createFromParcel(Parcel source) {
            return new UserParcelable(source);
        }

        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };
    
    private long id;
    private String username;
    private String fullname;
    private String password;
    
    public UserParcelable() {}
    
    private UserParcelable(Parcel source) {
        id = source.readLong();
        username = source.readString();
        fullname = source.readString();
        password = source.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(username);
        dest.writeString(fullname);
        dest.writeString(password);
    }

}
