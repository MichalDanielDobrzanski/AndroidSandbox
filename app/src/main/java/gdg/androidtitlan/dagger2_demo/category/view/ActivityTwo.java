package gdg.androidtitlan.dagger2_demo.category.view;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.Arrays;

import javax.inject.Inject;

import gdg.androidtitlan.dagger2_demo.R;
import gdg.androidtitlan.dagger2_demo.category.view.fragment.FragmentOne;
import gdg.androidtitlan.dagger2_demo.common.BaseActivity;
import gdg.androidtitlan.dagger2_demo.di.component.AppComponent;
import gdg.androidtitlan.dagger2_demo.di.component.DaggerActivityTwoComponent;
import gdg.androidtitlan.dagger2_demo.di.module.CategoryModule;

public class ActivityTwo extends BaseActivity {

    @Inject
    SimplePresenter simplePresenter;

    @Inject
    Application app;

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerActivityTwoComponent.builder()
                .appComponent(appComponent)
                .categoryModule(new CategoryModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Log.v("ME2", String.valueOf(simplePresenter.hashCode()));
        Log.v("ME3", String.valueOf(app.hashCode()));

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, FragmentOne.create())
                .commit();

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(
//                    this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                    MY_PERMISSIONS_REQUEST_LOCATION
//            );
//        } else {
////            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
////                    Manifest.permission.ACCESS_FINE_LOCATION)) {
////
////                // Show an explanation to the user *asynchronously* -- don't block
////                // this thread waiting for the user's response! After the user
////                // sees the explanation, try again to request the permission.
////                new AlertDialog.Builder(this)
////                        .setTitle("Hey")
////                        .setMessage("WANT THIS")
////                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialogInterface, int i) {
////                                //Prompt the user once explanation has been shown
////                                ActivityCompat.requestPermissions(ActivityTwo.this,
////                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
////                                        MY_PERMISSIONS_REQUEST_LOCATION);
////                            }
////                        })
////                        .create()
////                        .show();
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.v("ME","onRequestPermissionsResult" + Arrays.toString(permissions));
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                // Permission was denied. Display an error message.
            }
        }
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 23;
}
