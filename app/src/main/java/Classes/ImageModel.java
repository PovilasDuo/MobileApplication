package Classes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ImageModel implements Parcelable {

    public ImageModel(Uri imageUri, float points, String message, String gender, int age) {
        ImageUri = imageUri;
        Points = points;
        Message = message;
        Gender = gender;
        Age = age;
    }

    public Uri ImageUri;
    public float Points;
    public String Gender;
    public int Age;
    public String Message;

    protected ImageModel(Parcel in) {
        ImageUri = in.readParcelable(Uri.class.getClassLoader());
        Points = in.readFloat();
        Message = in.readString();
        Gender = in.readString();
        Age = in.readInt();
    }

    public static final Creator<ImageModel> CREATOR = new Creator<ImageModel>() {
        @Override
        public ImageModel createFromParcel(Parcel in) {
            return new ImageModel(in);
        }

        @Override
        public ImageModel[] newArray(int size) {
            return new ImageModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(ImageUri, flags);
        dest.writeFloat(Points);
        dest.writeString(Message);
        dest.writeString(Gender);
        dest.writeInt(Age);
    }
}
