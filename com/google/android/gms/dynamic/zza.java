package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T zzaNG;
    private Bundle zzaNH;
    private LinkedList<zza> zzaNI;
    private final zzf<T> zzaNJ = new C04681(this);

    class C04681 implements zzf<T> {
        final /* synthetic */ zza zzaNK;

        C04681(zza com_google_android_gms_dynamic_zza) {
            this.zzaNK = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.zzaNK.zzaNG = t;
            Iterator it = this.zzaNK.zzaNI.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.zzaNK.zzaNG);
            }
            this.zzaNK.zzaNI.clear();
            this.zzaNK.zzaNH = null;
        }
    }

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    class C04736 implements zza {
        final /* synthetic */ zza zzaNK;

        C04736(zza com_google_android_gms_dynamic_zza) {
            this.zzaNK = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzaNK.zzaNG.onStart();
        }
    }

    class C04747 implements zza {
        final /* synthetic */ zza zzaNK;

        C04747(zza com_google_android_gms_dynamic_zza) {
            this.zzaNK = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzaNK.zzaNG.onResume();
        }
    }

    private void zza(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.zzaNG != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.zzaNG);
            return;
        }
        if (this.zzaNI == null) {
            this.zzaNI = new LinkedList();
        }
        this.zzaNI.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.zzaNH == null) {
                this.zzaNH = (Bundle) bundle.clone();
            } else {
                this.zzaNH.putAll(bundle);
            }
        }
        zza(this.zzaNJ);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zzb = zzg.zzb(context, isGooglePlayServicesAvailable, GooglePlayServicesUtilLight.zzap(context));
        CharSequence zzg = zzg.zzg(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzb);
        linearLayout.addView(textView);
        if (zzg != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzg);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.getGooglePlayServicesAvailabilityRecoveryIntent(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzgD(int i) {
        while (!this.zzaNI.isEmpty() && ((zza) this.zzaNI.getLast()).getState() >= i) {
            this.zzaNI.removeLast();
        }
    }

    public void onCreate(final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzaNK;

            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzaNK.zzaNG.onCreate(savedInstanceState);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzaNK;

            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.zzaNK.zzaNG.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.zzaNG == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzaNG != null) {
            this.zzaNG.onDestroy();
        } else {
            zzgD(1);
        }
    }

    public void onDestroyView() {
        if (this.zzaNG != null) {
            this.zzaNG.onDestroyView();
        } else {
            zzgD(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzaNK;

            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzaNK.zzaNG.onInflate(activity, attrs, savedInstanceState);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzaNG != null) {
            this.zzaNG.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzaNG != null) {
            this.zzaNG.onPause();
        } else {
            zzgD(5);
        }
    }

    public void onResume() {
        zza(null, new C04747(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.zzaNG != null) {
            this.zzaNG.onSaveInstanceState(outState);
        } else if (this.zzaNH != null) {
            outState.putAll(this.zzaNH);
        }
    }

    public void onStart() {
        zza(null, new C04736(this));
    }

    public void onStop() {
        if (this.zzaNG != null) {
            this.zzaNG.onStop();
        } else {
            zzgD(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public T zzwG() {
        return this.zzaNG;
    }
}
