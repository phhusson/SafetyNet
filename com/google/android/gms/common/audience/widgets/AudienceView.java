package com.google.android.gms.common.audience.widgets;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.people.data.Audience;
import com.google.android.gms.common.people.data.AudienceMember;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzng;
import com.google.android.gms.internal.zznh;

public final class AudienceView extends FrameLayout {
    public static final int EDIT_MODE_CLICK_TO_EDIT = 3;
    public static final int EDIT_MODE_CLICK_TO_REMOVE = 2;
    public static final int EDIT_MODE_READ_ONLY = 1;
    protected static final String PACKAGE_IMPLEMENTATION_CLASS_NAME = "com.google.android.gms.plus.audience.widgets.AudienceViewImpl$DynamiteHost";
    private static Context zzatp;
    private final Context zzatq;
    private final zzng zzatr;
    private EditAudienceCallback zzats;
    private RemoveAudienceMemberCallback zzatt;

    class C02131 extends com.google.android.gms.internal.zznh.zza {
        final /* synthetic */ AudienceView zzatu;

        C02131(AudienceView audienceView) {
            this.zzatu = audienceView;
        }

        public void editAudience() {
            this.zzatu.zzats.editAudience();
        }

        public void removeAudienceMember(AudienceMember audienceMember) {
            this.zzatu.zzatt.removeAudienceMember(audienceMember);
        }
    }

    public interface EditAudienceCallback {
        void editAudience();
    }

    public interface RemoveAudienceMemberCallback {
        void removeAudienceMember(AudienceMember audienceMember);
    }

    private static class zza extends com.google.android.gms.internal.zzng.zza {
        private Audience zzatv;
        private TextView zzatw;

        private zza() {
        }

        public zzd getView() {
            return zze.zzJ(this.zzatw);
        }

        public void onRestoreInstanceState(Bundle state) {
            setAudience((Audience) state.getParcelable("audience"));
        }

        public Bundle onSaveInstanceState() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("audience", this.zzatv);
            return bundle;
        }

        public void setAudience(Audience audience) {
            this.zzatv = audience;
            if (this.zzatv == null) {
                this.zzatw.setText("");
                return;
            }
            CharSequence charSequence = null;
            for (AudienceMember displayName : audience.getAudienceMemberList()) {
                Object obj = (charSequence == null ? "" : charSequence + ", ") + displayName.getDisplayName();
            }
            this.zzatw.setText(charSequence);
        }

        public void setIsUnderageAccount(boolean isUnderageAccount) {
        }

        public void setShowEmptyText(boolean showEmptyText) {
        }

        public void zza(zzd com_google_android_gms_dynamic_zzd, zzd com_google_android_gms_dynamic_zzd2, zznh com_google_android_gms_internal_zznh) {
            this.zzatw = new TextView((Context) zze.zzu(com_google_android_gms_dynamic_zzd));
        }

        public void zzcV(int i) {
        }
    }

    public AudienceView(Context context) {
        this(context, null, 0);
    }

    public AudienceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AudienceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Pair zzas = zzas(context);
        this.zzatr = (zzng) zzas.first;
        this.zzatq = (Context) zzas.second;
        try {
            this.zzatr.zza(zze.zzJ(getContext()), zze.zzJ(this.zzatq), new C02131(this));
            addView((View) zze.zzu(this.zzatr.getView()));
        } catch (RemoteException e) {
        }
    }

    private void zza(int i, EditAudienceCallback editAudienceCallback, RemoveAudienceMemberCallback removeAudienceMemberCallback) {
        this.zzats = editAudienceCallback;
        this.zzatt = removeAudienceMemberCallback;
        try {
            this.zzatr.zzcV(i);
        } catch (RemoteException e) {
        }
    }

    private static Pair<zzng, Context> zzas(Context context) {
        Throwable e;
        if (zzatp == null) {
            zzatp = GooglePlayServicesUtil.getRemoteContext(context);
        }
        if (zzatp != null) {
            try {
                return new Pair(com.google.android.gms.internal.zzng.zza.zzcm((IBinder) zzatp.getClassLoader().loadClass(PACKAGE_IMPLEMENTATION_CLASS_NAME).newInstance()), zzatp);
            } catch (ClassNotFoundException e2) {
                e = e2;
                if (e != null && Log.isLoggable("AudienceView", 3)) {
                    Log.d("AudienceView", "Can't load com.google.android.gms.plus.audience.widgets.AudienceViewImpl$DynamiteHost", e);
                }
                return new Pair(new zza(), context);
            } catch (InstantiationException e3) {
                e = e3;
                Log.d("AudienceView", "Can't load com.google.android.gms.plus.audience.widgets.AudienceViewImpl$DynamiteHost", e);
                return new Pair(new zza(), context);
            } catch (IllegalAccessException e4) {
                e = e4;
                Log.d("AudienceView", "Can't load com.google.android.gms.plus.audience.widgets.AudienceViewImpl$DynamiteHost", e);
                return new Pair(new zza(), context);
            }
        }
        return new Pair(new zza(), context);
    }

    protected void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        super.onRestoreInstanceState(bundle.getParcelable("parent"));
        try {
            this.zzatr.onRestoreInstanceState(bundle.getBundle("impl"));
        } catch (RemoteException e) {
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("parent", super.onSaveInstanceState());
        try {
            bundle.putBundle("impl", this.zzatr.onSaveInstanceState());
        } catch (RemoteException e) {
        }
        return bundle;
    }

    public void setAudience(Audience audience) {
        try {
            this.zzatr.setAudience(audience);
        } catch (RemoteException e) {
        }
    }

    public void setIsUnderageAccount(boolean isUnderageAccount) {
        try {
            this.zzatr.setIsUnderageAccount(isUnderageAccount);
        } catch (RemoteException e) {
        }
    }

    public void setModeClickToEdit(EditAudienceCallback callback) {
        zza(3, (EditAudienceCallback) zzx.zzD(callback), null);
    }

    public void setModeClickToRemove(RemoveAudienceMemberCallback callback) {
        zza(2, null, (RemoveAudienceMemberCallback) zzx.zzD(callback));
    }

    public void setModeReadonly() {
        zza(1, null, null);
    }

    public void setShowEmptyText(boolean showEmptyText) {
        try {
            this.zzatr.setShowEmptyText(showEmptyText);
        } catch (RemoteException e) {
        }
    }
}
